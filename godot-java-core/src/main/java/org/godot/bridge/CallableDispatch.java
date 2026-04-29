package org.godot.bridge;

import org.godot.Godot;
import org.godot.core.Variant;
import org.godot.core.VariantUtils;
import org.godot.internal.dispatch.Dispatch;
import org.godot.internal.ref.JavaObjectMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import static java.lang.foreign.ValueLayout.*;

/**
 * Handles Godot-side callable invocations back to Java.
 *
 * <p>
 * GDExtensionCallableCustomCall (same signature for both create and create2):
 * void(void* callable_userdata, const GDExtensionConstVariantPtr* p_args,
 * GDExtensionInt p_argument_count, GDExtensionVariantPtr r_return,
 * GDExtensionCallError* r_error)
 *
 * <p>
 * All reflection has been eliminated. Method dispatch is handled by the
 * APT-generated DispatchIndex via the {@link Dispatch} facade.
 */
public final class CallableDispatch {

	private static final Logger logger = LogManager.getLogger(CallableDispatch.class);

	private CallableDispatch() {
	}

	/**
	 * Entry stored in callable userdata: a long pointing to an entry in CALLABLES
	 * map.
	 */
	private static final Map<Long, CallableEntry> CALLABLES = new ConcurrentHashMap<>();
	private static long nextKey = 1;

	/**
	 * GDExtensionCallableCustomCall: void(void* callable_userdata, const
	 * GDExtensionConstVariantPtr* p_args, GDExtensionInt p_argument_count,
	 * GDExtensionVariantPtr r_return, GDExtensionCallError* r_error)
	 */
	private static final FunctionDescriptor CALLABLE_CALL_FD = FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, JAVA_LONG,
			ADDRESS, ADDRESS);

	private static volatile MemorySegment callStub;
	private static volatile boolean initialized = false;

	public static synchronized void ensureInitialized() {
		if (initialized)
			return;
		try {
			MethodHandle mh = MethodHandles.lookup().findStatic(CallableDispatch.class, "callAdapter",
					MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class, long.class,
							MemorySegment.class, MemorySegment.class));
			callStub = Bridge.linker().upcallStub(mh, CALLABLE_CALL_FD, Bridge.ARENA);
			initialized = true;
		} catch (Exception e) {
			throw new RuntimeException("CallableDispatch init failed", e);
		}
	}

	/**
	 * Register a callable and return its unique key for userdata.
	 */
	public static long registerCallable(Godot object, String methodName) {
		return registerCallable(object, methodName, null);
	}

	/**
	 * Register a callable with bound arguments and return its unique key.
	 */
	public static long registerCallable(Godot object, String methodName, Object[] boundArgs) {
		ensureInitialized();
		long key = nextKey++;
		CALLABLES.put(key, new CallableEntry(object, methodName, boundArgs));
		return key;
	}

	/**
	 * Unregister a callable (call when the NativeCallable is freed).
	 */
	public static void unregisterCallable(long key) {
		CALLABLES.remove(key);
	}

	/**
	 * Get the call upcall stub address for call_func.
	 */
	public static long getCallStubAddress() {
		ensureInitialized();
		return callStub.address();
	}

	/** Get the call stub segment (for passing to callable_custom_create). */
	public static MemorySegment getCallStub() {
		ensureInitialized();
		return callStub;
	}

	/**
	 * Panama adapter called by Godot when a custom callable is invoked. Matches
	 * GDExtensionCallableCustomCall signature.
	 */
	static void callAdapter(MemorySegment userdataSeg, MemorySegment argsSeg, long argCount, MemorySegment retSeg,
			MemorySegment errorSeg) {
		// Only discard if we're in a direct upcall without a downcall in between.
		// When IN_DOWNCALL=true, thread is in _thread_in_native, so nested
		// upcalls are safe. Must allow signal handlers during downcalls.
		if (Bridge.isInUpcall() && !Bridge.isInDowncall()) {
			writeNilVariant(retSeg);
			setError(errorSeg, 0);
			return;
		}

		try {
			long key = userdataSeg.address();
			CallableEntry entry = CALLABLES.get(key);
			if (entry == null) {
				writeNilVariant(retSeg);
				setError(errorSeg, 2);
				return;
			}

			Godot obj = JavaObjectMap.get(entry.objectPtr());
			if (obj == null) {
				writeNilVariant(retSeg);
				setError(errorSeg, 2);
				return;
			}

			String godotClassName = Dispatch.getGodotClassName(obj.getClass().getName());
			if (godotClassName == null || godotClassName.isEmpty()) {
				writeNilVariant(retSeg);
				setError(errorSeg, 2);
				return;
			}

			int argc = (int) argCount;
			Object[] javaArgs = new Object[argc];
			for (int i = 0; i < argc; i++) {
				try {
					MemorySegment argPtr = argsSeg.reinterpret(8L * Math.max(argc, 1)).get(ADDRESS, (long) i * 8L);
					if (argPtr != null && !argPtr.equals(MemorySegment.NULL)) {
						javaArgs[i] = VariantUtils.toObject(new Variant(argPtr.reinterpret(Variant.SIZE)));
					}
				} catch (Exception e) {
					javaArgs[i] = null;
				}
			}

			Object[] argsToInvoke;
			if (entry.boundArgs != null && entry.boundArgs.length > 0) {
				argsToInvoke = new Object[entry.boundArgs.length + javaArgs.length];
				System.arraycopy(entry.boundArgs, 0, argsToInvoke, 0, entry.boundArgs.length);
				System.arraycopy(javaArgs, 0, argsToInvoke, entry.boundArgs.length, javaArgs.length);
			} else {
				argsToInvoke = javaArgs;
			}

			Object result = Dispatch.dispatchVariantCall(godotClassName, entry.methodName, obj, argsToInvoke);

			if (result != null) {
				try {
					org.godot.core.VariantUtils.writeVariantFromObject(retSeg, result);
				} catch (Exception e) {
					writeNilVariant(retSeg);
				}
			} else {
				writeNilVariant(retSeg);
			}

			setError(errorSeg, 0);

		} catch (Throwable t) {
			try {
				writeNilVariant(retSeg);
				setError(errorSeg, 2);
			} catch (Exception e) {
				// Best effort
			}
		}
	}

	private static void setError(MemorySegment errorSeg, int errorCode) {
		if (errorSeg != null && !errorSeg.equals(MemorySegment.NULL)) {
			errorSeg.reinterpret(16).set(JAVA_INT, 0, errorCode);
			errorSeg.reinterpret(16).set(JAVA_INT, 4, 0);
			errorSeg.reinterpret(16).set(JAVA_INT, 8, 0);
		}
	}

	private static void writeNilVariant(MemorySegment retSeg) {
		MemorySegment seg = retSeg.reinterpret(Variant.SIZE);
		seg.set(JAVA_LONG, 0, 0L);
		seg.set(JAVA_LONG, 8, 0L);
		seg.set(JAVA_LONG, 16, 0L);
	}

	private static class CallableEntry {
		final Godot object;
		final String methodName;
		final Object[] boundArgs;

		CallableEntry(Godot object, String methodName, Object[] boundArgs) {
			this.object = object;
			this.methodName = methodName;
			this.boundArgs = boundArgs;
		}

		long objectPtr() {
			return object.getPtr();
		}
	}
}
