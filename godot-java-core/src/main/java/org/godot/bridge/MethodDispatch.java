package org.godot.bridge;

import org.godot.Godot;
import org.godot.core.GodotString;
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
 * Handles Godot-side method calls back to Java.
 *
 * <p>
 * GDExtensionClassMethodCall signature: void(void *method_userdata,
 * GDExtensionClassInstancePtr p_instance, const GDExtensionConstVariantPtr
 * *p_args, GDExtensionInt p_argument_count, GDExtensionVariantPtr r_return,
 * GDExtensionCallError *r_error)
 */
public final class MethodDispatch {

	private static final Logger logger = LogManager.getLogger(MethodDispatch.class);

	private MethodDispatch() {
	}

	private static final java.util.concurrent.atomic.AtomicLong nextMethodKey = new java.util.concurrent.atomic.AtomicLong(
			1);

	// methodKey → godotClassName (for Dispatch-based dispatch)
	private static final Map<Long, String> METHOD_KEY_TO_CLASS = new ConcurrentHashMap<>();

	// methodKey → godot method name (for Dispatch-based dispatch)
	private static final Map<Long, String> METHOD_KEY_TO_NAME = new ConcurrentHashMap<>();

	// Method flags
	private static final int ERROR_OK = 0;
	private static final int ERROR_INVALID_ARGUMENT = 2;

	/**
	 * GDExtensionClassMethodCall: void(ADDRESS userdata, ADDRESS instance, ADDRESS
	 * args, JAVA_LONG argc, ADDRESS ret, ADDRESS error)
	 */
	private static final FunctionDescriptor METHOD_CALL_FD = FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS,
			JAVA_LONG, ADDRESS, ADDRESS);

	private static volatile MemorySegment callStub;
	private static volatile boolean initialized = false;

	public static synchronized void ensureInitialized() {
		if (initialized)
			return;
		try {
			MethodHandle mh = MethodHandles.lookup().findStatic(MethodDispatch.class, "callAdapter",
					MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class, MemorySegment.class,
							long.class, MemorySegment.class, MemorySegment.class));
			callStub = Bridge.linker().upcallStub(mh, METHOD_CALL_FD, Bridge.arena());
			initialized = true;
		} catch (Exception e) {
			throw new RuntimeException("MethodDispatch init failed", e);
		}
	}

	/**
	 * Register a method by class name and Godot method name (no reflection). The
	 * dispatch path will use Dispatch.dispatchPtrcall/dispatchVariantCall.
	 */
	static long registerMethod(String godotClassName, String godotMethodName) {
		ensureInitialized();
		long key = nextMethodKey.getAndIncrement();
		METHOD_KEY_TO_CLASS.put(key, godotClassName);
		METHOD_KEY_TO_NAME.put(key, godotMethodName);
		return key;
	}

	/** Get the call upcall stub. */
	static MemorySegment getCallStub() {
		ensureInitialized();
		return callStub;
	}

	/** Panama adapter called by Godot. */
	static void callAdapter(MemorySegment userdataSeg, MemorySegment instanceSeg, MemorySegment argsSeg, long argCount,
			MemorySegment retSeg, MemorySegment errorSeg) {
		try {
			// Get method from userdata key
			long methodKey = userdataSeg.address();

			// Get Java instance from native instance pointer
			long instanceAddr = instanceSeg.address();
			Godot obj = JavaObjectMap.get(instanceAddr);
			if (obj == null) {
				logger.error("MethodDispatch: no object for instance 0x{}", Long.toHexString(instanceAddr));
				setError(errorSeg, ERROR_INVALID_ARGUMENT);
				return;
			}

			// Try Dispatch-based path first (no reflection)
			String dispatchClassName = METHOD_KEY_TO_CLASS.get(methodKey);
			String dispatchMethodName = METHOD_KEY_TO_NAME.get(methodKey);
			if (dispatchMethodName != null && dispatchClassName != null) {
				int argc = (int) argCount;
				Object[] javaArgs = new Object[argc];
				for (int i = 0; i < argc; i++) {
					MemorySegment argPtr = argsSeg.reinterpret(8L * argc).get(ADDRESS, (long) i * 8L);
					if (!argPtr.equals(MemorySegment.NULL)) {
						Object raw = VariantUtils.toObject(new Variant(argPtr.reinterpret(24)));
						javaArgs[i] = raw;
					}
				}

				Object result = org.godot.internal.dispatch.Dispatch.dispatchVariantCall(dispatchClassName,
						dispatchMethodName, obj, javaArgs);

				if (result != null) {
					Variant retVar = VariantUtils.fromObject(result);
					Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_NEW_COPY, retSeg, retVar.getSegment());
				} else {
					Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_NEW_NIL, retSeg);
				}
				setError(errorSeg, ERROR_OK);
				return;
			}

			logger.error("MethodDispatch callAdapter: no dispatch data for methodKey {}", methodKey);
			setError(errorSeg, ERROR_INVALID_ARGUMENT);
		} catch (Throwable t) {
			logger.error("MethodDispatch error", t);
			setError(errorSeg, ERROR_INVALID_ARGUMENT);
		}
	}

	// ------------------------------------------------------------------------'
	// ptrcall — zero-copy typed dispatch
	// ------------------------------------------------------------------------

	private static final FunctionDescriptor METHOD_PTRCALL_FD = FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS,
			ADDRESS);

	private static volatile MemorySegment ptrcallStub;

	/** Get the ptrcall upcall stub. */
	static synchronized MemorySegment getPtrcallStub() {
		if (ptrcallStub != null)
			return ptrcallStub;
		try {
			MethodHandle mh = MethodHandles.lookup().findStatic(MethodDispatch.class, "ptrcallAdapter",
					MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class, MemorySegment.class,
							MemorySegment.class));
			ptrcallStub = Bridge.linker().upcallStub(mh, METHOD_PTRCALL_FD, Bridge.arena());
		} catch (Exception e) {
			throw new RuntimeException("MethodDispatch ptrcall init failed", e);
		}
		return ptrcallStub;
	}

	/**
	 * ptrcall adapter: reads typed pointers directly, avoiding Variant boxing.
	 * Signature: void(ADDRESS userdata, ADDRESS instance, ADDRESS args, ADDRESS
	 * ret)
	 */
	static void ptrcallAdapter(MemorySegment userdataSeg, MemorySegment instanceSeg, MemorySegment argsSeg,
			MemorySegment retSeg) {
		try {
			long methodKey = userdataSeg.address();

			long instanceAddr = instanceSeg.address();
			Godot obj = JavaObjectMap.get(instanceAddr);
			if (obj == null)
				return;

			// Try Dispatch-based path first (no reflection)
			String dispatchClassName = METHOD_KEY_TO_CLASS.get(methodKey);
			String dispatchMethodName = METHOD_KEY_TO_NAME.get(methodKey);
			if (dispatchMethodName != null && dispatchClassName != null) {
				Object result = org.godot.internal.dispatch.Dispatch.dispatchPtrcall(dispatchClassName,
						dispatchMethodName, obj, argsSeg, 0);
				if (result != null && retSeg.address() != 0) {
					writeTypedPtr(retSeg, result, result.getClass());
				}
				return;
			}

			logger.error("MethodDispatch ptrcallAdapter: no dispatch data for methodKey {}", methodKey);
		} catch (Throwable t) {
			logger.error("MethodDispatch ptrcall error", t);
		}
	}

	/** Write a value to a typed pointer (zero-copy). */
	private static void writeTypedPtr(MemorySegment ptr, Object value, Class<?> type) {
		if (value == null)
			return;
		if (type == double.class || type == Double.class) {
			ptr.reinterpret(8).set(JAVA_DOUBLE, 0, (Double) value);
		} else if (type == float.class || type == Float.class) {
			ptr.reinterpret(4).set(JAVA_FLOAT, 0, (Float) value);
		} else if (type == int.class || type == Integer.class) {
			ptr.reinterpret(4).set(JAVA_INT, 0, (Integer) value);
		} else if (type == long.class || type == Long.class) {
			ptr.reinterpret(8).set(JAVA_LONG, 0, (Long) value);
		} else if (type == boolean.class || type == Boolean.class) {
			ptr.set(JAVA_BYTE, 0, (Boolean) value ? (byte) 1 : (byte) 0);
		} else if (type == String.class) {
			GodotString gs = GodotString.fromJavaString((String) value);
			MemorySegment.copy(gs.segment(), 0, ptr.reinterpret(8), 0, 8);
		} else if (value instanceof Godot godotObj) {
			MemorySegment objAddr = MemorySegment.ofAddress(godotObj.getPtr());
			// RefCounted return: ptrcall expects RefPtr*, use ref_set_object
			try {
				Bridge.callVoid(org.godot.internal.api.ApiIndex.REF_SET_OBJECT, ptr, objAddr);
			} catch (Exception e) {
				// Not a RefPtr, fall back to direct write (non-RefCounted Object**)
				ptr.reinterpret(ADDRESS.byteSize()).set(ADDRESS, 0, objAddr);
			}
		}
	}

	private static void setError(MemorySegment errorSeg, int errorCode) {
		if (!errorSeg.equals(MemorySegment.NULL)) {
			errorSeg.reinterpret(24).set(JAVA_INT, 0, errorCode);
			errorSeg.reinterpret(24).set(JAVA_INT, 4, 0); // argument
			errorSeg.reinterpret(24).set(JAVA_INT, 8, 0); // expected
		}
	}
}
