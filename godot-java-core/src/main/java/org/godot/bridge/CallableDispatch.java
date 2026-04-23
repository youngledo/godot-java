package org.godot.bridge;

import org.godot.Godot;
import org.godot.core.Variant;
import org.godot.core.VariantUtils;
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
 * GDExtensionCallableCustomCall signature: void(void *callable_userdata, const
 * GDExtensionConstVariantPtr *p_args, GDExtensionInt p_argument_count,
 * GDExtensionVariantPtr r_return, GDExtensionCallError *r_error)
 *
 * <p>
 * This is different from GDExtensionClassMethodCall — the callable doesn't have
 * an instance pointer, only userdata that points to (objectId, methodName).
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

	private static final int ERROR_OK = 0;
	private static final int ERROR_INVALID_ARGUMENT = 2;

	/**
	 * GDExtensionCallableCustomCall: void(ADDRESS userdata, ADDRESS args, JAVA_LONG
	 * argc, ADDRESS ret, ADDRESS error)
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
			callStub = Bridge.linker().upcallStub(mh, CALLABLE_CALL_FD, Bridge.arena());
			initialized = true;
		} catch (Exception e) {
			throw new RuntimeException("CallableDispatch init failed", e);
		}
	}

	/**
	 * Register a callable and return its unique key for userdata.
	 *
	 * @param object
	 *            The Godot object to invoke the method on
	 * @param methodName
	 *            Name of the method to invoke
	 * @return unique key that can be used as callable_userdata
	 */
	public static long registerCallable(Godot object, String methodName) {
		return registerCallable(object, methodName, null);
	}

	/**
	 * Register a callable with bound arguments and return its unique key.
	 *
	 * @param object
	 *            The Godot object to invoke the method on
	 * @param methodName
	 *            Name of the method to invoke
	 * @param boundArgs
	 *            Pre-bound arguments (may be null)
	 * @return unique key that can be used as callable_userdata
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

	/** Coerce a Variant-derived value to the expected Java parameter type. */
	private static Object coerceType(Object value, Class<?> targetType) {
		if (value == null)
			return null;
		if (targetType == int.class || targetType == Integer.class) {
			if (value instanceof Number n)
				return n.intValue();
		}
		if (targetType == long.class || targetType == Long.class) {
			if (value instanceof Number n)
				return n.longValue();
		}
		if (targetType == float.class || targetType == Float.class) {
			if (value instanceof Number n)
				return n.floatValue();
		}
		if (targetType == double.class || targetType == Double.class) {
			if (value instanceof Number n)
				return n.doubleValue();
		}
		if (targetType == boolean.class || targetType == Boolean.class) {
			if (value instanceof Boolean b)
				return b;
		}
		return value;
	}

	/**
	 * Panama adapter called by Godot when a custom callable is invoked.
	 *
	 * args is actually a pointer to an array of Variant pointers: p_args[i] =
	 * *(GDExtensionConstVariantPtr*)(args + i * sizeof(GDExtensionConstVariantPtr))
	 */
	static void callAdapter(MemorySegment userdataSeg, MemorySegment argsSeg, long argCount, MemorySegment retSeg,
			MemorySegment errorSeg) {
		// Discard re-entrant upcall during downcall — native pointers are ephemeral
		if (Bridge.isInDowncall()) {
			Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_NEW_NIL, retSeg);
			setError(errorSeg, ERROR_OK);
			return;
		}

		try {
			// Get key from userdata
			long key = userdataSeg.address();
			CallableEntry entry = CALLABLES.get(key);
			if (entry == null) {
				logger.error("CallableDispatch: no callable for key 0x{}", Long.toHexString(key));
				setError(errorSeg, ERROR_INVALID_ARGUMENT);
				return;
			}

			// Get Java object from stored object ID
			Godot obj = JavaObjectMap.get(entry.objectPtr());
			if (obj == null) {
				logger.error("CallableDispatch: no object for ptr 0x{}", Long.toHexString(entry.objectPtr()));
				setError(errorSeg, ERROR_INVALID_ARGUMENT);
				return;
			}

			// Get the method from the object
			java.lang.reflect.Method method;
			try {
				method = obj.getClass().getDeclaredMethod(entry.methodName);
			} catch (NoSuchMethodException e) {
				logger.error("CallableDispatch: method '{}' not found on {}", entry.methodName,
						obj.getClass().getName());
				setError(errorSeg, ERROR_INVALID_ARGUMENT);
				return;
			}

			// Convert variant args to Java objects
			int argc = (int) argCount;
			Object[] javaArgs = new Object[argc];
			Class<?>[] paramTypes = method.getParameterTypes();
			for (int i = 0; i < argc; i++) {
				// args is actually an array of Variant pointers: p_args[i]
				MemorySegment argPtr = argsSeg.reinterpret(8L * argc).get(ADDRESS, (long) i * 8L);
				if (!argPtr.equals(MemorySegment.NULL)) {
					Object raw = VariantUtils.toObject(new Variant(argPtr.reinterpret(24)));
					javaArgs[i] = coerceType(raw, paramTypes[i]);
				}
			}

			// Prepend bound args if any
			Object[] argsToInvoke;
			if (entry.boundArgs != null && entry.boundArgs.length > 0) {
				argsToInvoke = new Object[entry.boundArgs.length + javaArgs.length];
				System.arraycopy(entry.boundArgs, 0, argsToInvoke, 0, entry.boundArgs.length);
				System.arraycopy(javaArgs, 0, argsToInvoke, entry.boundArgs.length, javaArgs.length);
			} else {
				argsToInvoke = javaArgs;
			}

			// Invoke the Java method
			Object result = method.invoke(obj, argsToInvoke);

			// Set return value
			if (method.getReturnType() != void.class && result != null) {
				Variant retVar = VariantUtils.fromObject(result);
				Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_NEW_COPY, retSeg, retVar.getSegment());
			} else {
				Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_NEW_NIL, retSeg);
			}

			setError(errorSeg, ERROR_OK);
		} catch (Throwable t) {
			logger.error("CallableDispatch error", t);
			setError(errorSeg, ERROR_INVALID_ARGUMENT);
		}
	}

	private static void setError(MemorySegment errorSeg, int errorCode) {
		if (!errorSeg.equals(MemorySegment.NULL)) {
			errorSeg.reinterpret(16).set(JAVA_INT, 0, errorCode);
			errorSeg.reinterpret(16).set(JAVA_INT, 4, 0);
			errorSeg.reinterpret(16).set(JAVA_INT, 8, 0);
		}
	}

	private static class CallableEntry {
		final Godot object;
		final String methodName;
		final Object[] boundArgs; // may be null

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
