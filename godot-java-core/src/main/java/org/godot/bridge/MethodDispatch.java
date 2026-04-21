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
import java.lang.reflect.Method;
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

	// Registered methods: methodKey -> Method object
	private static final Map<Long, Method> REGISTERED_METHODS = new ConcurrentHashMap<>();
	private static final java.util.concurrent.atomic.AtomicLong nextMethodKey = new java.util.concurrent.atomic.AtomicLong(
			1);

	// APT-generated typed dispatch: godotClassName → TypedDispatch class
	private static final Map<String, Class<?>> APT_DISPATCH_CACHE = new ConcurrentHashMap<>();

	// methodKey → godotClassName (for looking up APT dispatch)
	private static final Map<Long, String> METHOD_KEY_TO_CLASS = new ConcurrentHashMap<>();

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

	/** Register a Java method and return its unique key for userdata. */
	static long registerMethod(Method method, String godotClassName) {
		ensureInitialized();
		long key = nextMethodKey.getAndIncrement();
		REGISTERED_METHODS.put(key, method);
		METHOD_KEY_TO_CLASS.put(key, godotClassName);
		return key;
	}

	/** Get the call upcall stub. */
	static MemorySegment getCallStub() {
		ensureInitialized();
		return callStub;
	}

	/**
	 * Load APT-generated TypedDispatch_<ClassName> for typed method dispatch.
	 * Returns null if no APT data is available.
	 */
	private static Class<?> loadAptDispatch(String godotClassName) {
		return APT_DISPATCH_CACHE.computeIfAbsent(godotClassName, name -> {
			try {
				return Class.forName("org.godot.internal.TypedDispatch_" + name);
			} catch (ClassNotFoundException e) {
				return null;
			}
		});
	}

	/** Check if APT-generated dispatch is available for a class. */
	static boolean hasAptDispatch(String godotClassName) {
		return loadAptDispatch(godotClassName) != null;
	}

	/** Get the APT dispatch class for a given godot class name. */
	static Class<?> getAptDispatch(String godotClassName) {
		return loadAptDispatch(godotClassName);
	}

	/** Panama adapter called by Godot. */
	static void callAdapter(MemorySegment userdataSeg, MemorySegment instanceSeg, MemorySegment argsSeg, long argCount,
			MemorySegment retSeg, MemorySegment errorSeg) {
		try {
			// Get method from userdata key
			long methodKey = userdataSeg.address();
			Method method = REGISTERED_METHODS.get(methodKey);
			if (method == null) {
				setError(errorSeg, ERROR_INVALID_ARGUMENT);
				return;
			}

			// Get Java instance from native instance pointer
			long instanceAddr = instanceSeg.address();
			Godot obj = JavaObjectMap.get(instanceAddr);
			if (obj == null) {
				logger.error("MethodDispatch: no object for instance 0x{}", Long.toHexString(instanceAddr));
				setError(errorSeg, ERROR_INVALID_ARGUMENT);
				return;
			}

			// Convert variant args to Java objects matching parameter types
			int argc = (int) argCount;
			Object[] javaArgs = new Object[argc];
			Class<?>[] paramTypes = method.getParameterTypes();
			for (int i = 0; i < argc; i++) {
				MemorySegment argPtr = argsSeg.reinterpret(8L * argc).get(ADDRESS, (long) i * 8L);
				if (!argPtr.equals(MemorySegment.NULL)) {
					Object raw = VariantUtils.toObject(new Variant(argPtr.reinterpret(24)));
					javaArgs[i] = coerceType(raw, paramTypes[i]);
				}
			}

			// Invoke the Java method
			Object result = method.invoke(obj, javaArgs);

			// Set return value if any
			if (method.getReturnType() != void.class && result != null) {
				Variant retVar = VariantUtils.fromObject(result);
				// Copy result variant to retSeg
				Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_NEW_COPY, retSeg, retVar.getSegment());
			} else {
				// Set NIL return
				Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_NEW_NIL, retSeg);
			}

			setError(errorSeg, ERROR_OK);
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
			Method method = REGISTERED_METHODS.get(methodKey);
			if (method == null)
				return;

			long instanceAddr = instanceSeg.address();
			Godot obj = JavaObjectMap.get(instanceAddr);
			if (obj == null)
				return;

			// Try APT-generated typed dispatch first
			String className = METHOD_KEY_TO_CLASS.get(methodKey);
			Class<?> aptDispatch = className != null ? loadAptDispatch(className) : null;
			if (aptDispatch != null) {
				String godotName = method.getName();
				var hasMethod = aptDispatch.getMethod("hasMethod", String.class);
				if ((boolean) hasMethod.invoke(null, godotName)) {
					var dispatchMethod = aptDispatch.getMethod("dispatchMethod", String.class, Godot.class,
							MemorySegment.class, int.class);
					Object result = dispatchMethod.invoke(null, godotName, obj, argsSeg, method.getParameterCount());
					if (method.getReturnType() != void.class && retSeg.address() != 0 && result != null) {
						writeTypedPtr(retSeg, result, method.getReturnType());
					}
					return;
				}
			}

			// Fallback: reflection-based dispatch
			int argc = method.getParameterCount();
			Object[] javaArgs = new Object[argc];
			Class<?>[] paramTypes = method.getParameterTypes();
			if (argc > 0) {
				MemorySegment sizedArgs = argsSeg.reinterpret((long) argc * ADDRESS.byteSize());
				for (int i = 0; i < argc; i++) {
					MemorySegment argPtr = sizedArgs.get(ADDRESS, (long) i * ADDRESS.byteSize());
					javaArgs[i] = readTypedPtr(argPtr, paramTypes[i]);
				}
			}

			Object result = method.invoke(obj, javaArgs);

			if (method.getReturnType() != void.class && retSeg.address() != 0) {
				writeTypedPtr(retSeg, result, method.getReturnType());
			}
		} catch (Throwable t) {
			logger.error("MethodDispatch ptrcall error", t);
		}
	}

	/** Read a value from a typed pointer (zero-copy). */
	private static Object readTypedPtr(MemorySegment ptr, Class<?> type) {
		if (ptr.address() == 0)
			return null;
		if (type == double.class || type == Double.class) {
			return ptr.reinterpret(8).get(JAVA_DOUBLE, 0);
		} else if (type == float.class || type == Float.class) {
			return (float) ptr.reinterpret(4).get(JAVA_FLOAT, 0);
		} else if (type == int.class || type == Integer.class) {
			return ptr.reinterpret(4).get(JAVA_INT, 0);
		} else if (type == long.class || type == Long.class) {
			return ptr.reinterpret(8).get(JAVA_LONG, 0);
		} else if (type == boolean.class || type == Boolean.class) {
			return ptr.get(JAVA_BYTE, 0) != 0;
		} else if (type == String.class) {
			return new org.godot.core.GodotString(ptr).toJavaString();
		} else if (Godot.class.isAssignableFrom(type)) {
			// RefCounted types: ptrcall passes RefPtr*, use ref_get_object
			MemorySegment objPtr = Bridge.callPtr(org.godot.internal.api.ApiIndex.REF_GET_OBJECT, ptr);
			long addr = objPtr.address();
			if (addr == 0) {
				// Not a RefPtr, try direct dereference (non-RefCounted Object**)
				addr = ptr.reinterpret(ADDRESS.byteSize()).get(ADDRESS, 0).address();
			}
			if (addr == 0)
				return null;
			Godot godotObj = JavaObjectMap.get(addr);
			if (godotObj != null)
				return godotObj;
			Variant var = Variant.fromObjectPtr(addr);
			return VariantUtils.toObject(var);
		} else {
			// Non-Godot object types: dereference pointer
			long objPtr = ptr.reinterpret(ADDRESS.byteSize()).get(ADDRESS, 0).address();
			if (objPtr == 0)
				return null;
			Godot godotObj = JavaObjectMap.get(objPtr);
			if (godotObj != null)
				return godotObj;
			Variant var = Variant.fromObjectPtr(objPtr);
			return VariantUtils.toObject(var);
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
}
