package org.godot;

import org.godot.internal.api.ApiIndex;
import org.godot.bridge.Bridge;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.builtin.BuiltinMethodCache;
import org.godot.core.Callable;
import org.godot.core.GodotString;
import org.godot.core.GodotStringName;
import org.godot.internal.dispatch.Dispatch;
import org.godot.internal.ref.JavaObjectMap;
import org.godot.core.Signal;
import org.godot.core.Variant;
import org.godot.core.VariantUtils;
import org.godot.internal.api.VariantType;
import org.godot.math.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import static java.lang.foreign.ValueLayout.JAVA_BYTE;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;
import static java.lang.foreign.ValueLayout.JAVA_FLOAT;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.JAVA_LONG;
import static java.lang.foreign.ValueLayout.JAVA_SHORT;
import static java.lang.foreign.ValueLayout.ADDRESS;

public abstract class Godot {

	public static final int NOTIFICATION_ACCESSIBILITY_UPDATE = 3000;
	public static final int NOTIFICATION_ACCESSIBILITY_INVALIDATE = 3001;

	private static final Logger logger = LogManager.getLogger(Godot.class);

	/** Cache: "className::methodName" → MethodBind pointer. Never evicted. */
	private static final ConcurrentHashMap<String, MemorySegment> METHOD_BIND_CACHE = new ConcurrentHashMap<>();
	private static final ConcurrentHashMap<String, MethodHandle> BUILTIN_CONSTRUCTOR_CACHE = new ConcurrentHashMap<>();
	private static final ConcurrentHashMap<Integer, MethodHandle> BUILTIN_DESTRUCTOR_CACHE = new ConcurrentHashMap<>();
	private static final BigInteger UINT64_MAX = new BigInteger("18446744073709551615");
	private static final FunctionDescriptor BUILTIN_CONSTRUCTOR_DESC = FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
	private static final FunctionDescriptor BUILTIN_DESTRUCTOR_DESC = FunctionDescriptor.ofVoid(ADDRESS);

	private static MemorySegment getCachedMethodBind(String className, String methodName, long hash) {
		String key = className + "::" + methodName;
		return METHOD_BIND_CACHE.computeIfAbsent(key, k -> {
			GodotStringName methodSn = GodotStringName.fromJavaString(methodName);
			GodotStringName classNameSn = GodotStringName.fromJavaString(className);
			return Bridge.callPtr2S1L(ApiIndex.CLASSDB_GET_METHOD_BIND, classNameSn.segment(), methodSn.segment(),
					hash);
		});
	}

	protected volatile long nativeObject;

	private volatile boolean valid = true;

	protected Godot(long nativeObject) {
		this.nativeObject = nativeObject;
	}

	protected Godot(MemorySegment nativeSegment) {
		this(nativeSegment.address());
	}

	protected Godot() {
		this.nativeObject = 0;
	}

	/**
	 * Programmatically instantiate a registered {@code @GodotClass} by name.
	 * Creates both the native Godot object and the Java wrapper, binds them, and
	 * returns the typed Java instance.
	 *
	 * @param godotClassName
	 *            the name registered via {@code @GodotClass(name=...)}
	 * @param <T>
	 *            the expected Java type
	 * @return a fully initialized Godot-backed Java instance, or null on failure
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Godot> T create(String godotClassName) {
		String parentName = Dispatch.getParentClass(godotClassName);
		if (parentName == null) {
			logger.error("Godot.create: unknown class '{}'", godotClassName);
			return null;
		}

		MemorySegment nativeObj = Bridge.runScoped(() -> {
			GodotStringName parentSn = GodotStringName.fromJavaString(parentName);
			return Bridge.callPtr(ApiIndex.CLASSDB_CONSTRUCT_OBJECT2, parentSn.segment());
		});
		long nativePtr = nativeObj.address();
		if (nativePtr == 0) {
			logger.error("Godot.create: native construction failed for '{}' (parent='{}')", godotClassName, parentName);
			return null;
		}

		Godot instance = Dispatch.createInstance(godotClassName, nativePtr);
		if (instance == null) {
			logger.error("Godot.create: Dispatch.createInstance returned null for '{}'", godotClassName);
			return null;
		}
		JavaObjectMap.put(nativePtr, instance);

		Bridge.runScoped(() -> {
			GodotStringName classNameSn = GodotStringName.fromJavaString(godotClassName);
			Bridge.callVoid(ApiIndex.OBJECT_SET_INSTANCE, nativeObj, classNameSn.segment(), nativeObj);
			return null;
		});

		return (T) instance;
	}

	public long getPtr() {
		return nativeObject;
	}

	public final long getNativeObject() {
		return nativeObject;
	}

	public final void setNativeObject(long ptr) {
		this.nativeObject = ptr;
	}

	public boolean isValid() {
		return valid && nativeObject != 0;
	}

	public void invalidate() {
		this.valid = false;
		this.nativeObject = 0;
	}

	protected void checkValid() {
		if (!valid || nativeObject == 0) {
			throw new org.godot.exception.GodotInvalidObjectException(getClass().getSimpleName()
					+ " has been freed (nativeObject=0x" + Long.toHexString(nativeObject) + ")");
		}
	}

	// ----------------------------------------------------------------
	// Method hash resolution
	// ----------------------------------------------------------------

	public static final class HashResult {
		static final HashResult NOT_FOUND = new HashResult(0, null);
		public final long hash;
		public final String className;

		public HashResult(long hash, String className) {
			this.hash = hash;
			this.className = className;
		}

		boolean isFound() {
			return hash != 0;
		}
	}

	protected HashResult resolveMethodHash(String methodName) {
		return HashResult.NOT_FOUND;
	}

	protected String getGodotClassName() {
		return null;
	}

	// ----------------------------------------------------------------
	// Method call
	// ----------------------------------------------------------------

	public java.lang.Object call(String methodName, java.lang.Object... args) {
		checkValid();

		if ("get_instance_id".equals(methodName) && args.length == 0) {
			return Bridge.runDowncall(
					() -> Bridge.callLong(ApiIndex.OBJECT_GET_INSTANCE_ID, MemorySegment.ofAddress(nativeObject)));
		}

		return Bridge.runDowncall(() -> Bridge.runScoped(() -> {
			int depth = Bridge.callDepth();
			if (depth >= Bridge.MAX_CALL_DEPTH) {
				throw new RuntimeException("Maximum call depth exceeded: " + depth);
			}
			int argc = args.length;
			if (argc > Bridge.MAX_CALL_ARGS) {
				throw new RuntimeException("Too many arguments: " + argc + " (max " + Bridge.MAX_CALL_ARGS + ")");
			}

			try {
				// Destroy previous result at this depth to release RefCounted refs.
				// CALL_FRAMES is zero-initialized, so first call is a no-op.
				Bridge.destroyVariant(Bridge.resultSlot(depth));
				MemorySegment argPtrs;
				if (argc > 0) {
					argPtrs = Bridge.argPtrsSlot(depth);
					for (int i = 0; i < argc; i++) {
						MemorySegment slot = Bridge.argSlot(depth, i);
						VariantUtils.fromObjectInto(args[i], slot);
						argPtrs.set(ADDRESS, (long) i * ADDRESS.byteSize(), slot);
					}
				} else {
					argPtrs = MemorySegment.NULL;
				}

				MemorySegment resultVar = Bridge.resultSlot(depth);
				MemorySegment errorVar = Bridge.errorSlot(depth);

				return Bridge.withCallDepth(depth, () -> {
					HashResult hashResult = resolveMethodHash(methodName);
					if (hashResult.isFound()) {
						MemorySegment methodBind = getCachedMethodBind(hashResult.className, methodName,
								hashResult.hash);
						if (methodBind.address() == 0) {
							throw new RuntimeException(
									"Method bind not found: " + methodName + " on " + hashResult.className);
						}
						Bridge.callVoid(ApiIndex.OBJECT_METHOD_BIND_CALL, methodBind,
								MemorySegment.ofAddress(nativeObject), argPtrs, (long) argc, resultVar, errorVar);
					} else {
						GodotStringName methodSn = GodotStringName.fromJavaString(methodName);
						Bridge.callVoid(ApiIndex.OBJECT_CALL_SCRIPT_METHOD, MemorySegment.ofAddress(nativeObject),
								methodSn.segment(), argPtrs, (long) argc, resultVar, errorVar);
					}

					int errorCode = errorVar.get(JAVA_INT, 0);
					if (errorCode != 0) {
						StringBuilder sb = new StringBuilder();
						sb.append("Call error ").append(errorCode).append(" calling ").append(methodName);
						sb.append(" (arg=").append(errorVar.get(JAVA_INT, 4));
						sb.append(", expected=").append(errorVar.get(JAVA_INT, 8)).append(")");
						throw new RuntimeException(sb.toString());
					}

					Variant resultVariant = new Variant(resultVar);
					return VariantUtils.toObject(resultVariant);
				});
			} finally {
				for (int i = 0; i < argc; i++) {
					Bridge.destroyVariant(Bridge.argSlot(depth, i));
				}
			}
		}));
	}

	/**
	 * Call a method on this object at the end of the current frame (deferred).
	 * Equivalent to GDScript's call_deferred().
	 */
	public void callDeferred(String methodName, java.lang.Object... args) {
		java.lang.Object[] combined = new java.lang.Object[(args != null ? args.length : 0) + 1];
		combined[0] = methodName;
		if (args != null && args.length > 0) {
			System.arraycopy(args, 0, combined, 1, args.length);
		}
		call("call_deferred", combined);
	}

	protected java.lang.Object callEngine(String className, String methodName, long hash, java.lang.Object... args) {
		checkValid();
		return callMethodBind(className, methodName, hash, MemorySegment.ofAddress(nativeObject), args);
	}

	protected void callEngineVoid(String className, String methodName, long hash, Object... typedArgs) {
		checkValid();
		callMethodBindPtrVoid(className, methodName, hash, MemorySegment.ofAddress(nativeObject), typedArgs);
	}

	protected boolean callEngineBool(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 1, ret -> ret.get(JAVA_BYTE, 0) != 0, typedArgs);
	}

	protected int callEngineInt32(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 4, ret -> ret.get(JAVA_INT, 0), typedArgs);
	}

	protected byte callEngineInt8(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 1, ret -> ret.get(JAVA_BYTE, 0), typedArgs);
	}

	protected short callEngineUint8(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 1, ret -> (short) Byte.toUnsignedInt(ret.get(JAVA_BYTE, 0)),
				typedArgs);
	}

	protected short callEngineInt16(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 2, ret -> ret.get(JAVA_SHORT, 0), typedArgs);
	}

	protected int callEngineUint16(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 2, ret -> Short.toUnsignedInt(ret.get(JAVA_SHORT, 0)),
				typedArgs);
	}

	protected long callEngineInt64(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 8, ret -> ret.get(JAVA_LONG, 0), typedArgs);
	}

	protected long callEngineUint32(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 4, ret -> Integer.toUnsignedLong(ret.get(JAVA_INT, 0)),
				typedArgs);
	}

	protected BigInteger callEngineUint64(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 8, ret -> unsignedLongToBigInteger(ret.get(JAVA_LONG, 0)),
				typedArgs);
	}

	protected long callEngineRid(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 8, ret -> ret.get(JAVA_LONG, 0), typedArgs);
	}

	protected String callEngineString(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 16, VariantType.STRING.id(),
				ret -> readTypedBuiltinAsString(ret, VariantType.STRING.id()), typedArgs);
	}

	protected String callEngineStringName(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 8, VariantType.STRING_NAME.id(),
				ret -> readTypedBuiltinAsString(ret, VariantType.STRING_NAME.id()), typedArgs);
	}

	protected String callEngineNodePath(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 8, VariantType.NODE_PATH.id(),
				ret -> readTypedBuiltinAsString(ret, VariantType.NODE_PATH.id()), typedArgs);
	}

	protected Vector2 callEngineVector2(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 16, Vector2::fromSegment, typedArgs);
	}

	protected Vector2i callEngineVector2i(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 8, Vector2i::fromSegment, typedArgs);
	}

	protected Rect2 callEngineRect2(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 32, Rect2::fromSegment, typedArgs);
	}

	protected Rect2i callEngineRect2i(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 16, Rect2i::fromSegment, typedArgs);
	}

	protected Vector3 callEngineVector3(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 24, Vector3::fromSegment, typedArgs);
	}

	protected Vector3i callEngineVector3i(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 12, Vector3i::fromSegment, typedArgs);
	}

	protected Transform2D callEngineTransform2D(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 48, Transform2D::fromSegment, typedArgs);
	}

	protected Vector4 callEngineVector4(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 32, Vector4::fromSegment, typedArgs);
	}

	protected Vector4i callEngineVector4i(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 16, Vector4i::fromSegment, typedArgs);
	}

	protected Plane callEnginePlane(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 32, Plane::fromSegment, typedArgs);
	}

	protected Quaternion callEngineQuaternion(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 32, Quaternion::fromSegment, typedArgs);
	}

	protected AABB callEngineAABB(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 48, AABB::fromSegment, typedArgs);
	}

	protected Basis callEngineBasis(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 72, Basis::fromSegment, typedArgs);
	}

	protected Transform3D callEngineTransform3D(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 96, Transform3D::fromSegment, typedArgs);
	}

	protected Projection callEngineProjection(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 64, Projection::fromSegment, typedArgs);
	}

	protected Color callEngineColor(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 16, Color::fromSegment, typedArgs);
	}

	protected <T extends Godot> T callEngineObject(String className, String methodName, long hash,
			String expectedClassName, boolean refCountedReturn, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 8,
				ret -> wrapTypedObject(readTypedObjectPointer(ret, refCountedReturn), expectedClassName,
						refCountedReturn),
				typedArgs);
	}

	protected Object callEngineVariant(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, Variant.SIZE, VARIANT_SENTINEL,
				ret -> VariantUtils.toObject(new Variant(ret)), typedArgs);
	}

	protected GodotArray callEngineArray(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 8, VariantType.ARRAY.id(), Godot::readTypedArrayReturn,
				typedArgs);
	}

	protected GodotDictionary callEngineDictionary(String className, String methodName, long hash,
			Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 8, VariantType.DICTIONARY.id(),
				Godot::readTypedDictionaryReturn, typedArgs);
	}

	protected String[] callEngineTypedStringArray(String className, String methodName, long hash, Object... typedArgs) {
		return stringArrayFromGodotArray(callEngineArray(className, methodName, hash, typedArgs));
	}

	protected long[] callEngineTypedIntArray(String className, String methodName, long hash, Object... typedArgs) {
		return longArrayFromGodotArray(callEngineArray(className, methodName, hash, typedArgs));
	}

	protected byte[] callEnginePackedByteArray(String className, String methodName, long hash, Object... typedArgs) {
		return (byte[]) callEngineTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_BYTE_ARRAY.id(), typedArgs);
	}

	protected int[] callEnginePackedInt32Array(String className, String methodName, long hash, Object... typedArgs) {
		return (int[]) callEngineTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_INT32_ARRAY.id(), typedArgs);
	}

	protected long[] callEnginePackedInt64Array(String className, String methodName, long hash, Object... typedArgs) {
		return (long[]) callEngineTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_INT64_ARRAY.id(), typedArgs);
	}

	protected double[] callEnginePackedFloat32Array(String className, String methodName, long hash,
			Object... typedArgs) {
		return floatArrayToDoubleArray((float[]) callEngineTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_FLOAT32_ARRAY.id(), typedArgs));
	}

	protected double[] callEnginePackedFloat64Array(String className, String methodName, long hash,
			Object... typedArgs) {
		return (double[]) callEngineTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_FLOAT64_ARRAY.id(), typedArgs);
	}

	protected String[] callEnginePackedStringArray(String className, String methodName, long hash,
			Object... typedArgs) {
		return (String[]) callEngineTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_STRING_ARRAY.id(), typedArgs);
	}

	protected double[][] callEnginePackedVector2Array(String className, String methodName, long hash,
			Object... typedArgs) {
		return vector2ArrayToDoubleArray((Vector2[]) callEngineTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_VECTOR2_ARRAY.id(), typedArgs));
	}

	protected double[][] callEnginePackedVector3Array(String className, String methodName, long hash,
			Object... typedArgs) {
		return vector3ArrayToDoubleArray((Vector3[]) callEngineTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_VECTOR3_ARRAY.id(), typedArgs));
	}

	protected double[][] callEnginePackedColorArray(String className, String methodName, long hash,
			Object... typedArgs) {
		return colorArrayToDoubleArray((Color[]) callEngineTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_COLOR_ARRAY.id(), typedArgs));
	}

	protected float callEngineFloat32(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 4, ret -> ret.get(JAVA_FLOAT, 0), typedArgs);
	}

	protected double callEngineFloat64(String className, String methodName, long hash, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, 8, ret -> ret.get(JAVA_DOUBLE, 0), typedArgs);
	}

	/**
	 * Call a static method on a Godot engine class. Uses the method bind with a
	 * null object pointer, which is how the GDExtension API dispatches static
	 * methods.
	 */
	protected static java.lang.Object callStatic(String className, String methodName, long hash,
			java.lang.Object... args) {
		return callMethodBind(className, methodName, hash, MemorySegment.NULL, args);
	}

	protected static void callStaticVoid(String className, String methodName, long hash, Object... typedArgs) {
		callMethodBindPtrVoid(className, methodName, hash, MemorySegment.NULL, typedArgs);
	}

	protected static boolean callStaticBool(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 1, ret -> ret.get(JAVA_BYTE, 0) != 0, typedArgs);
	}

	protected static int callStaticInt32(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 4, ret -> ret.get(JAVA_INT, 0), typedArgs);
	}

	protected static byte callStaticInt8(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 1, ret -> ret.get(JAVA_BYTE, 0), typedArgs);
	}

	protected static short callStaticUint8(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 1, ret -> (short) Byte.toUnsignedInt(ret.get(JAVA_BYTE, 0)),
				typedArgs);
	}

	protected static short callStaticInt16(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 2, ret -> ret.get(JAVA_SHORT, 0), typedArgs);
	}

	protected static int callStaticUint16(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 2, ret -> Short.toUnsignedInt(ret.get(JAVA_SHORT, 0)),
				typedArgs);
	}

	protected static long callStaticInt64(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 8, ret -> ret.get(JAVA_LONG, 0), typedArgs);
	}

	protected static long callStaticUint32(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 4, ret -> Integer.toUnsignedLong(ret.get(JAVA_INT, 0)),
				typedArgs);
	}

	protected static BigInteger callStaticUint64(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 8, ret -> unsignedLongToBigInteger(ret.get(JAVA_LONG, 0)),
				typedArgs);
	}

	protected static long callStaticRid(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 8, ret -> ret.get(JAVA_LONG, 0), typedArgs);
	}

	protected static String callStaticString(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 16, VariantType.STRING.id(),
				ret -> readTypedBuiltinAsString(ret, VariantType.STRING.id()), typedArgs);
	}

	protected static String callStaticStringName(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 8, VariantType.STRING_NAME.id(),
				ret -> readTypedBuiltinAsString(ret, VariantType.STRING_NAME.id()), typedArgs);
	}

	protected static String callStaticNodePath(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 8, VariantType.NODE_PATH.id(),
				ret -> readTypedBuiltinAsString(ret, VariantType.NODE_PATH.id()), typedArgs);
	}

	protected static Vector2 callStaticVector2(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 16, Vector2::fromSegment, typedArgs);
	}

	protected static Vector2i callStaticVector2i(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 8, Vector2i::fromSegment, typedArgs);
	}

	protected static Rect2 callStaticRect2(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 32, Rect2::fromSegment, typedArgs);
	}

	protected static Rect2i callStaticRect2i(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 16, Rect2i::fromSegment, typedArgs);
	}

	protected static Vector3 callStaticVector3(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 24, Vector3::fromSegment, typedArgs);
	}

	protected static Vector3i callStaticVector3i(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 12, Vector3i::fromSegment, typedArgs);
	}

	protected static Transform2D callStaticTransform2D(String className, String methodName, long hash,
			Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 48, Transform2D::fromSegment, typedArgs);
	}

	protected static Vector4 callStaticVector4(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 32, Vector4::fromSegment, typedArgs);
	}

	protected static Vector4i callStaticVector4i(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 16, Vector4i::fromSegment, typedArgs);
	}

	protected static Plane callStaticPlane(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 32, Plane::fromSegment, typedArgs);
	}

	protected static Quaternion callStaticQuaternion(String className, String methodName, long hash,
			Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 32, Quaternion::fromSegment, typedArgs);
	}

	protected static AABB callStaticAABB(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 48, AABB::fromSegment, typedArgs);
	}

	protected static Basis callStaticBasis(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 72, Basis::fromSegment, typedArgs);
	}

	protected static Transform3D callStaticTransform3D(String className, String methodName, long hash,
			Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 96, Transform3D::fromSegment, typedArgs);
	}

	protected static Projection callStaticProjection(String className, String methodName, long hash,
			Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 64, Projection::fromSegment, typedArgs);
	}

	protected static Color callStaticColor(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 16, Color::fromSegment, typedArgs);
	}

	protected static <T extends Godot> T callStaticObject(String className, String methodName, long hash,
			String expectedClassName, boolean refCountedReturn, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 8,
				ret -> wrapTypedObject(readTypedObjectPointer(ret, refCountedReturn), expectedClassName,
						refCountedReturn),
				typedArgs);
	}

	protected static Object callStaticVariant(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, Variant.SIZE, VARIANT_SENTINEL,
				ret -> VariantUtils.toObject(new Variant(ret)), typedArgs);
	}

	protected static GodotArray callStaticArray(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 8, VariantType.ARRAY.id(), Godot::readTypedArrayReturn,
				typedArgs);
	}

	protected static GodotDictionary callStaticDictionary(String className, String methodName, long hash,
			Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 8, VariantType.DICTIONARY.id(),
				Godot::readTypedDictionaryReturn, typedArgs);
	}

	protected static String[] callStaticTypedStringArray(String className, String methodName, long hash,
			Object... typedArgs) {
		return stringArrayFromGodotArray(callStaticArray(className, methodName, hash, typedArgs));
	}

	protected static long[] callStaticTypedIntArray(String className, String methodName, long hash,
			Object... typedArgs) {
		return longArrayFromGodotArray(callStaticArray(className, methodName, hash, typedArgs));
	}

	protected static byte[] callStaticPackedByteArray(String className, String methodName, long hash,
			Object... typedArgs) {
		return (byte[]) callStaticTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_BYTE_ARRAY.id(), typedArgs);
	}

	protected static int[] callStaticPackedInt32Array(String className, String methodName, long hash,
			Object... typedArgs) {
		return (int[]) callStaticTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_INT32_ARRAY.id(), typedArgs);
	}

	protected static long[] callStaticPackedInt64Array(String className, String methodName, long hash,
			Object... typedArgs) {
		return (long[]) callStaticTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_INT64_ARRAY.id(), typedArgs);
	}

	protected static double[] callStaticPackedFloat32Array(String className, String methodName, long hash,
			Object... typedArgs) {
		return floatArrayToDoubleArray((float[]) callStaticTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_FLOAT32_ARRAY.id(), typedArgs));
	}

	protected static double[] callStaticPackedFloat64Array(String className, String methodName, long hash,
			Object... typedArgs) {
		return (double[]) callStaticTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_FLOAT64_ARRAY.id(), typedArgs);
	}

	protected static String[] callStaticPackedStringArray(String className, String methodName, long hash,
			Object... typedArgs) {
		return (String[]) callStaticTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_STRING_ARRAY.id(), typedArgs);
	}

	protected static double[][] callStaticPackedVector2Array(String className, String methodName, long hash,
			Object... typedArgs) {
		return vector2ArrayToDoubleArray((Vector2[]) callStaticTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_VECTOR2_ARRAY.id(), typedArgs));
	}

	protected static double[][] callStaticPackedVector3Array(String className, String methodName, long hash,
			Object... typedArgs) {
		return vector3ArrayToDoubleArray((Vector3[]) callStaticTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_VECTOR3_ARRAY.id(), typedArgs));
	}

	protected static double[][] callStaticPackedColorArray(String className, String methodName, long hash,
			Object... typedArgs) {
		return colorArrayToDoubleArray((Color[]) callStaticTypedBuiltinObject(className, methodName, hash, 16,
				VariantType.PACKED_COLOR_ARRAY.id(), typedArgs));
	}

	protected static float callStaticFloat32(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 4, ret -> ret.get(JAVA_FLOAT, 0), typedArgs);
	}

	protected static double callStaticFloat64(String className, String methodName, long hash, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, 8, ret -> ret.get(JAVA_DOUBLE, 0), typedArgs);
	}

	private <T> T callEnginePtr(String className, String methodName, long hash, long returnSize,
			Function<MemorySegment, T> reader, Object... typedArgs) {
		checkValid();
		return callEnginePtr(className, methodName, hash, returnSize, -1, reader, typedArgs);
	}

	private <T> T callEnginePtr(String className, String methodName, long hash, long returnSize, int returnVariantType,
			Function<MemorySegment, T> reader, Object... typedArgs) {
		checkValid();
		return callMethodBindPtr(className, methodName, hash, MemorySegment.ofAddress(nativeObject), returnSize,
				returnVariantType, reader, typedArgs);
	}

	private Object callEngineTypedBuiltinObject(String className, String methodName, long hash, long returnSize,
			int returnVariantType, Object... typedArgs) {
		return callEnginePtr(className, methodName, hash, returnSize, returnVariantType,
				ret -> readTypedBuiltinAsObject(ret, returnVariantType), typedArgs);
	}

	private static <T> T callStaticPtr(String className, String methodName, long hash, long returnSize,
			Function<MemorySegment, T> reader, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, returnSize, -1, reader, typedArgs);
	}

	private static <T> T callStaticPtr(String className, String methodName, long hash, long returnSize,
			int returnVariantType, Function<MemorySegment, T> reader, Object... typedArgs) {
		return callMethodBindPtr(className, methodName, hash, MemorySegment.NULL, returnSize, returnVariantType, reader,
				typedArgs);
	}

	private static Object callStaticTypedBuiltinObject(String className, String methodName, long hash, long returnSize,
			int returnVariantType, Object... typedArgs) {
		return callStaticPtr(className, methodName, hash, returnSize, returnVariantType,
				ret -> readTypedBuiltinAsObject(ret, returnVariantType), typedArgs);
	}

	private static <T> T callMethodBindPtr(String className, String methodName, long hash, MemorySegment object,
			long returnSize, int returnVariantType, Function<MemorySegment, T> reader, Object... typedArgs) {
		return Bridge.runDowncall(() -> Bridge.runScoped(() -> {
			MemorySegment methodBind = getCachedMethodBind(className, methodName, hash);
			if (methodBind.address() == 0) {
				throw new RuntimeException("Method bind not found: " + methodName + " on " + className);
			}

			TypedArgFrame args = typedArgFrame(typedArgs);
			MemorySegment ret = Bridge.allocate(returnSize);
			try {
				Bridge.callVoid(ApiIndex.OBJECT_METHOD_BIND_PTRCALL, methodBind, object, args.argPtrs(), ret);
				return reader.apply(ret);
			} finally {
				destroyTypedBuiltin(ret, returnVariantType);
				args.destroy();
			}
		}));
	}

	private static void callMethodBindPtrVoid(String className, String methodName, long hash, MemorySegment object,
			Object... typedArgs) {
		Bridge.runDowncall(() -> Bridge.runScoped(() -> {
			MemorySegment methodBind = getCachedMethodBind(className, methodName, hash);
			if (methodBind.address() == 0) {
				throw new RuntimeException("Method bind not found: " + methodName + " on " + className);
			}

			TypedArgFrame args = typedArgFrame(typedArgs);
			try {
				Bridge.callVoid(ApiIndex.OBJECT_METHOD_BIND_PTRCALL, methodBind, object, args.argPtrs(),
						MemorySegment.NULL);
				return null;
			} finally {
				args.destroy();
			}
		}));
	}

	protected static Object typedStringArg(String value) {
		return new TypedStringArg(value);
	}

	protected static Object typedStringNameArg(String value) {
		return new TypedStringNameArg(value);
	}

	protected static Object typedNodePathArg(String value) {
		return new TypedNodePathArg(value);
	}

	protected static Object typedObjectArg(Godot value, boolean refCounted) {
		return new TypedObjectArg(value, refCounted);
	}

	protected static Object typedVariantArg(Object value) {
		return new TypedVariantArg(value);
	}

	protected static Object typedInt8Arg(long value) {
		if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
			throw new IllegalArgumentException("int8 argument out of range: " + value);
		}
		return new TypedSizedIntegerArg(value, 1);
	}

	protected static Object typedUint8Arg(long value) {
		if (value < 0 || value > 0xffL) {
			throw new IllegalArgumentException("uint8 argument out of range: " + value);
		}
		return new TypedSizedIntegerArg(value, 1);
	}

	protected static Object typedInt16Arg(long value) {
		if (value < Short.MIN_VALUE || value > Short.MAX_VALUE) {
			throw new IllegalArgumentException("int16 argument out of range: " + value);
		}
		return new TypedSizedIntegerArg(value, 2);
	}

	protected static Object typedUint16Arg(long value) {
		if (value < 0 || value > 0xffffL) {
			throw new IllegalArgumentException("uint16 argument out of range: " + value);
		}
		return new TypedSizedIntegerArg(value, 2);
	}

	protected static Object typedUint32Arg(long value) {
		if (value < 0 || value > 0xffffffffL) {
			throw new IllegalArgumentException("uint32 argument out of range: " + value);
		}
		return new TypedSizedIntegerArg(value, 4);
	}

	protected static Object typedUint64Arg(BigInteger value) {
		if (value == null || value.signum() < 0 || value.compareTo(UINT64_MAX) > 0) {
			throw new IllegalArgumentException("uint64 argument out of range: " + value);
		}
		return new TypedUint64Arg(value);
	}

	protected static Object typedUint64Arg(long value) {
		return new TypedUint64Arg(BigInteger.valueOf(value));
	}

	protected static Object typedPackedByteArrayArg(byte[] value) {
		return new TypedPackedArrayArg(value, VariantType.PACKED_BYTE_ARRAY.id(), 16, 694024632L);
	}

	protected static Object typedPackedInt32ArrayArg(int[] value) {
		return new TypedPackedArrayArg(value, VariantType.PACKED_INT32_ARRAY.id(), 16, 694024632L);
	}

	protected static Object typedPackedInt64ArrayArg(long[] value) {
		return new TypedPackedArrayArg(value, VariantType.PACKED_INT64_ARRAY.id(), 16, 694024632L);
	}

	protected static Object typedPackedFloat32ArrayArg(double[] value) {
		return new TypedPackedArrayArg(value, VariantType.PACKED_FLOAT32_ARRAY.id(), 16, 4094791666L);
	}

	protected static Object typedPackedFloat64ArrayArg(double[] value) {
		return new TypedPackedArrayArg(value, VariantType.PACKED_FLOAT64_ARRAY.id(), 16, 4094791666L);
	}

	protected static Object typedPackedStringArrayArg(String[] value) {
		return new TypedPackedArrayArg(value, VariantType.PACKED_STRING_ARRAY.id(), 16, 816187996L);
	}

	protected static Object typedPackedVector2ArrayArg(double[][] value) {
		return new TypedPackedArrayArg(value, VariantType.PACKED_VECTOR2_ARRAY.id(), 16, 4188891560L);
	}

	protected static Object typedPackedVector3ArrayArg(double[][] value) {
		return new TypedPackedArrayArg(value, VariantType.PACKED_VECTOR3_ARRAY.id(), 16, 3295363524L);
	}

	protected static Object typedPackedColorArrayArg(double[][] value) {
		return new TypedPackedArrayArg(value, VariantType.PACKED_COLOR_ARRAY.id(), 16, 1007858200L);
	}

	protected static Object typedArrayArg(GodotArray value) {
		return new TypedBuiltinArg(value, VariantType.ARRAY.id(), 8);
	}

	protected static Object typedDictionaryArg(GodotDictionary value) {
		return new TypedBuiltinArg(value, VariantType.DICTIONARY.id(), 8);
	}

	protected static Object typedCallableArg(Callable value) {
		return new TypedBuiltinArg(value, VariantType.CALLABLE.id(), 16);
	}

	protected static Object typedSignalArg(Signal value) {
		return new TypedBuiltinArg(value, VariantType.SIGNAL.id(), 16);
	}

	private static TypedArgFrame typedArgFrame(Object[] typedArgs) {
		int argc = typedArgs != null ? typedArgs.length : 0;
		if (argc == 0) {
			return TypedArgFrame.EMPTY;
		}
		MemorySegment argPtrs = Bridge.allocate((long) argc * ADDRESS.byteSize());
		NativeTypedArg[] nativeArgs = new NativeTypedArg[argc];
		for (int i = 0; i < argc; i++) {
			NativeTypedArg nativeArg = typedArgSlot(typedArgs[i]);
			nativeArgs[i] = nativeArg;
			argPtrs.set(ADDRESS, (long) i * ADDRESS.byteSize(), nativeArg.segment());
		}
		return new TypedArgFrame(argPtrs, nativeArgs);
	}

	private static NativeTypedArg typedArgSlot(Object value) {
		if (value instanceof Boolean b) {
			MemorySegment slot = Bridge.allocate(1);
			slot.set(JAVA_BYTE, 0, b ? (byte) 1 : (byte) 0);
			return NativeTypedArg.primitive(slot);
		}
		if (value instanceof Float f) {
			MemorySegment slot = Bridge.allocate(4);
			slot.set(JAVA_FLOAT, 0, f);
			return NativeTypedArg.primitive(slot);
		}
		if (value instanceof Double d) {
			MemorySegment slot = Bridge.allocate(8);
			slot.set(JAVA_DOUBLE, 0, d);
			return NativeTypedArg.primitive(slot);
		}
		if (value instanceof Byte || value instanceof Short || value instanceof Integer) {
			MemorySegment slot = Bridge.allocate(4);
			slot.set(JAVA_INT, 0, ((Number) value).intValue());
			return NativeTypedArg.primitive(slot);
		}
		if (value instanceof Long l) {
			MemorySegment slot = Bridge.allocate(8);
			slot.set(JAVA_LONG, 0, l);
			return NativeTypedArg.primitive(slot);
		}
		if (value instanceof BigInteger i) {
			MemorySegment slot = Bridge.allocate(8);
			slot.set(JAVA_LONG, 0, i.longValue());
			return NativeTypedArg.primitive(slot);
		}
		if (value instanceof TypedSizedIntegerArg integerArg) {
			MemorySegment slot = Bridge.allocate(integerArg.size());
			if (integerArg.size() == 1) {
				slot.set(JAVA_BYTE, 0, (byte) integerArg.value());
			} else if (integerArg.size() == 2) {
				slot.set(JAVA_SHORT, 0, (short) integerArg.value());
			} else {
				slot.set(JAVA_INT, 0, (int) integerArg.value());
			}
			return NativeTypedArg.primitive(slot);
		}
		if (value instanceof TypedUint64Arg integerArg) {
			MemorySegment slot = Bridge.allocate(8);
			slot.set(JAVA_LONG, 0, integerArg.value().longValue());
			return NativeTypedArg.primitive(slot);
		}
		if (value instanceof TypedStringArg s) {
			return new NativeTypedArg(GodotString.fromJavaString(s.value()).segment(), VariantType.STRING.id());
		}
		if (value instanceof TypedStringNameArg s) {
			return new NativeTypedArg(GodotStringName.fromJavaStringUncached(s.value()).segment(),
					VariantType.STRING_NAME.id());
		}
		if (value instanceof TypedNodePathArg s) {
			return new NativeTypedArg(constructBuiltinFromString(VariantType.NODE_PATH.id(), s.value()),
					VariantType.NODE_PATH.id());
		}
		if (value instanceof TypedObjectArg objectArg) {
			return typedObjectArgSlot(objectArg);
		}
		if (value instanceof TypedVariantArg variantArg) {
			MemorySegment slot = Bridge.allocVariant();
			VariantUtils.fromObjectInto(variantArg.value(), slot);
			return new NativeTypedArg(slot, VARIANT_SENTINEL);
		}
		if (value instanceof TypedBuiltinArg builtinArg) {
			return typedBuiltinArgSlot(builtinArg);
		}
		if (value instanceof TypedPackedArrayArg packedArrayArg) {
			return typedPackedArrayArgSlot(packedArrayArg);
		}
		MemorySegment builtinSlot = typedBuiltinStructArgSlot(value);
		if (builtinSlot != null) {
			return NativeTypedArg.primitive(builtinSlot);
		}
		throw new IllegalArgumentException(
				"Unsupported typed ptrcall argument: " + (value == null ? "null" : value.getClass().getName()));
	}

	private static MemorySegment typedBuiltinStructArgSlot(Object value) {
		if (value instanceof Vector2 v)
			return writeBuiltinStruct(16, v::toSegment);
		if (value instanceof Vector2i v)
			return writeBuiltinStruct(8, v::toSegment);
		if (value instanceof Rect2 v)
			return writeBuiltinStruct(32, v::toSegment);
		if (value instanceof Rect2i v)
			return writeBuiltinStruct(16, v::toSegment);
		if (value instanceof Vector3 v)
			return writeBuiltinStruct(24, v::toSegment);
		if (value instanceof Vector3i v)
			return writeBuiltinStruct(12, v::toSegment);
		if (value instanceof Transform2D v)
			return writeBuiltinStruct(48, v::toSegment);
		if (value instanceof Vector4 v)
			return writeBuiltinStruct(32, v::toSegment);
		if (value instanceof Vector4i v)
			return writeBuiltinStruct(16, v::toSegment);
		if (value instanceof Plane v)
			return writeBuiltinStruct(32, v::toSegment);
		if (value instanceof Quaternion v)
			return writeBuiltinStruct(32, v::toSegment);
		if (value instanceof AABB v)
			return writeBuiltinStruct(48, v::toSegment);
		if (value instanceof Basis v)
			return writeBuiltinStruct(72, v::toSegment);
		if (value instanceof Transform3D v)
			return writeBuiltinStruct(96, v::toSegment);
		if (value instanceof Projection v)
			return writeBuiltinStruct(64, v::toSegment);
		if (value instanceof Color v)
			return writeBuiltinStruct(16, v::toSegment);
		return null;
	}

	private static NativeTypedArg typedBuiltinArgSlot(TypedBuiltinArg arg) {
		MemorySegment variant = Bridge.allocVariant();
		MemorySegment slot = Bridge.allocate(arg.size());
		try {
			VariantUtils.fromObjectInto(arg.value(), variant);
			MethodHandle extractor = Variant.getTypeExtractor(arg.variantType());
			if (extractor == null) {
				throw new IllegalStateException("No Variant extractor for builtin type " + arg.variantType());
			}
			extractor.invoke(slot, variant);
			return new NativeTypedArg(slot, arg.variantType());
		} catch (Throwable t) {
			throw new RuntimeException("Failed to build typed builtin argument for type " + arg.variantType(), t);
		} finally {
			Bridge.destroyVariant(variant);
		}
	}

	private static NativeTypedArg typedPackedArrayArgSlot(TypedPackedArrayArg arg) {
		MemorySegment slot = Bridge.allocate(arg.size());
		invokeBuiltinConstructor(arg.variantType(), 0, slot, MemorySegment.NULL);
		try {
			appendPackedArrayValues(slot, arg);
			return new NativeTypedArg(slot, arg.variantType());
		} catch (RuntimeException e) {
			destroyTypedBuiltin(slot, arg.variantType());
			throw e;
		}
	}

	private static void appendPackedArrayValues(MemorySegment slot, TypedPackedArrayArg arg) {
		if (arg.value() == null) {
			return;
		}
		if (arg.value() instanceof byte[] values) {
			for (byte value : values) {
				invokePackedArrayAppend(slot, arg, Integer.valueOf(Byte.toUnsignedInt(value)));
			}
			return;
		}
		if (arg.value() instanceof int[] values) {
			for (int value : values) {
				invokePackedArrayAppend(slot, arg, Integer.valueOf(value));
			}
			return;
		}
		if (arg.value() instanceof long[] values) {
			for (long value : values) {
				invokePackedArrayAppend(slot, arg, Long.valueOf(value));
			}
			return;
		}
		if (arg.value() instanceof double[] values) {
			boolean isFloat32 = arg.variantType() == VariantType.PACKED_FLOAT32_ARRAY.id();
			for (double value : values) {
				if (isFloat32) {
					invokePackedArrayAppend(slot, arg, Float.valueOf((float) value));
				} else {
					invokePackedArrayAppend(slot, arg, Double.valueOf(value));
				}
			}
			return;
		}
		if (arg.value() instanceof String[] values) {
			for (String value : values) {
				invokePackedArrayAppend(slot, arg, typedStringArg(value));
			}
			return;
		}
		if (arg.value() instanceof double[][] values) {
			for (double[] value : values) {
				invokePackedArrayAppend(slot, arg, packedVectorElement(arg.variantType(), value));
			}
			return;
		}
		throw new IllegalArgumentException("Unsupported packed array argument: " + arg.value().getClass().getName());
	}

	private static Object packedVectorElement(int variantType, double[] value) {
		if (variantType == VariantType.PACKED_VECTOR2_ARRAY.id()) {
			requirePackedElementSize(value, 2, "PackedVector2Array");
			return new Vector2(value[0], value[1]);
		}
		if (variantType == VariantType.PACKED_VECTOR3_ARRAY.id()) {
			requirePackedElementSize(value, 3, "PackedVector3Array");
			return new Vector3(value[0], value[1], value[2]);
		}
		if (variantType == VariantType.PACKED_COLOR_ARRAY.id()) {
			requirePackedElementSize(value, 4, "PackedColorArray");
			return new Color(value[0], value[1], value[2], value[3]);
		}
		throw new IllegalArgumentException("Unsupported packed vector array type: " + variantType);
	}

	private static void requirePackedElementSize(double[] value, int size, String typeName) {
		if (value == null || value.length < size) {
			throw new IllegalArgumentException(typeName + " elements must contain at least " + size + " values");
		}
	}

	private static void invokePackedArrayAppend(MemorySegment slot, TypedPackedArrayArg arg, Object value) {
		MethodHandle append = BuiltinMethodCache.getMethod(arg.variantType(), "append", arg.appendHash());
		TypedArgFrame frame = typedArgFrame(new Object[]{value});
		MemorySegment ret = Bridge.allocate(1);
		try {
			BuiltinMethodCache.invoke(append, slot, frame.argPtrs(), ret, 1);
			if (ret.get(JAVA_BYTE, 0) == 0) {
				throw new IllegalStateException("Failed to append value to packed array type " + arg.variantType());
			}
		} finally {
			frame.destroy();
		}
	}

	private static NativeTypedArg typedObjectArgSlot(TypedObjectArg arg) {
		if (arg.value() == null || !arg.value().isValid()) {
			MemorySegment slot = Bridge.allocate(ADDRESS.byteSize());
			slot.set(ADDRESS, 0, MemorySegment.NULL);
			return NativeTypedArg.primitive(slot);
		}
		MemorySegment object = MemorySegment.ofAddress(arg.value().getPtr());
		if (arg.refCounted()) {
			MemorySegment slot = Bridge.allocate(8);
			Bridge.callVoid(ApiIndex.REF_SET_OBJECT, slot, object);
			return new NativeTypedArg(slot, REF_PTR_SENTINEL);
		}
		MemorySegment slot = Bridge.allocate(ADDRESS.byteSize());
		slot.set(ADDRESS, 0, object);
		return NativeTypedArg.primitive(slot);
	}

	private static MemorySegment writeBuiltinStruct(long size, java.util.function.Consumer<MemorySegment> writer) {
		MemorySegment slot = Bridge.allocate(size);
		writer.accept(slot);
		return slot;
	}

	private static String readTypedBuiltinAsString(MemorySegment value, int variantType) {
		try {
			if (variantType == VariantType.STRING.id()) {
				return new GodotString(value).toJavaString();
			}
			MemorySegment variant = Bridge.allocVariant();
			MethodHandle ctor = Variant.getTypeConstructor(variantType);
			if (ctor == null) {
				throw new IllegalStateException("No Variant constructor for builtin type " + variantType);
			}
			ctor.invoke(variant, value);
			try {
				MemorySegment outString = Bridge.allocate(16);
				Bridge.callVoid(ApiIndex.VARIANT_STRINGIFY, variant, outString);
				return new GodotString(outString).toJavaString();
			} finally {
				Bridge.destroyVariant(variant);
			}
		} catch (Throwable t) {
			throw new RuntimeException("Failed to read typed builtin as String", t);
		}
	}

	private static BigInteger unsignedLongToBigInteger(long value) {
		return new BigInteger(Long.toUnsignedString(value));
	}

	private static Object readTypedBuiltinAsObject(MemorySegment value, int variantType) {
		try {
			MemorySegment variant = Bridge.allocVariant();
			MethodHandle ctor = Variant.getTypeConstructor(variantType);
			if (ctor == null) {
				throw new IllegalStateException("No Variant constructor for builtin type " + variantType);
			}
			ctor.invoke(variant, value);
			try {
				return VariantUtils.toObject(new Variant(variant));
			} finally {
				Bridge.destroyVariant(variant);
			}
		} catch (Throwable t) {
			throw new RuntimeException("Failed to read typed builtin as Object", t);
		}
	}

	private static GodotArray readTypedArrayReturn(MemorySegment value) {
		return readOwnedBuiltinReturn(value, VariantType.ARRAY.id(), GodotArray::fromOwnedVariant);
	}

	private static GodotDictionary readTypedDictionaryReturn(MemorySegment value) {
		return readOwnedBuiltinReturn(value, VariantType.DICTIONARY.id(), GodotDictionary::fromOwnedVariant);
	}

	private static <T> T readOwnedBuiltinReturn(MemorySegment value, int variantType,
			Function<MemorySegment, T> reader) {
		try {
			MemorySegment variant = Bridge.allocVariant();
			MethodHandle ctor = Variant.getTypeConstructor(variantType);
			if (ctor == null) {
				throw new IllegalStateException("No Variant constructor for builtin type " + variantType);
			}
			ctor.invoke(variant, value);
			try {
				return reader.apply(variant);
			} finally {
				Bridge.destroyVariant(variant);
			}
		} catch (Throwable t) {
			throw new RuntimeException("Failed to read owned typed builtin return type " + variantType, t);
		}
	}

	private static String[] stringArrayFromGodotArray(GodotArray array) {
		if (array == null || !array.isValid()) {
			return new String[0];
		}
		int size = array.size();
		String[] result = new String[size];
		for (int i = 0; i < size; i++) {
			Object value = array.get(i);
			result[i] = value == null ? null : value.toString();
		}
		return result;
	}

	private static long[] longArrayFromGodotArray(GodotArray array) {
		if (array == null || !array.isValid()) {
			return new long[0];
		}
		int size = array.size();
		long[] result = new long[size];
		for (int i = 0; i < size; i++) {
			Object value = array.get(i);
			if (!(value instanceof Number number)) {
				throw new IllegalStateException("typedarray::int element " + i + " was "
						+ (value == null ? "null" : value.getClass().getName()));
			}
			result[i] = number.longValue();
		}
		return result;
	}

	private static double[] floatArrayToDoubleArray(float[] values) {
		double[] result = new double[values.length];
		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}
		return result;
	}

	private static double[][] vector2ArrayToDoubleArray(Vector2[] values) {
		double[][] result = new double[values.length][2];
		for (int i = 0; i < values.length; i++) {
			result[i][0] = values[i].x;
			result[i][1] = values[i].y;
		}
		return result;
	}

	private static double[][] vector3ArrayToDoubleArray(Vector3[] values) {
		double[][] result = new double[values.length][3];
		for (int i = 0; i < values.length; i++) {
			result[i][0] = values[i].x;
			result[i][1] = values[i].y;
			result[i][2] = values[i].z;
		}
		return result;
	}

	private static double[][] colorArrayToDoubleArray(Color[] values) {
		double[][] result = new double[values.length][4];
		for (int i = 0; i < values.length; i++) {
			result[i][0] = values[i].r;
			result[i][1] = values[i].g;
			result[i][2] = values[i].b;
			result[i][3] = values[i].a;
		}
		return result;
	}

	private static long readTypedObjectPointer(MemorySegment ret, boolean refCountedReturn) {
		if (refCountedReturn) {
			MemorySegment object = Bridge.callPtr(ApiIndex.REF_GET_OBJECT, ret);
			return object.address();
		}
		return ret.get(ADDRESS, 0).address();
	}

	@SuppressWarnings("unchecked")
	private static <T extends Godot> T wrapTypedObject(long ptr, String expectedClassName, boolean refCounted) {
		if (ptr == 0) {
			return null;
		}
		Godot existing = org.godot.internal.ref.JavaObjectMap.get(ptr);
		if (existing != null) {
			return (T) existing;
		}
		Godot created = org.godot.internal.GodotClassRegistry.create(expectedClassName, ptr);
		if (created == null) {
			created = org.godot.internal.GodotClassRegistry.createTypedWrapper(ptr);
		}
		if (created == null) {
			created = new org.godot.internal.ref.GenericGodotObject(ptr, expectedClassName);
		}
		org.godot.internal.ref.JavaObjectMap.put(ptr, created);
		if (refCounted) {
			org.godot.internal.ref.RefCountedHelper.reference(ptr);
		}
		return (T) created;
	}

	private static MemorySegment constructBuiltinFromString(int variantType, String value) {
		GodotString string = GodotString.fromJavaString(value);
		MemorySegment result = Bridge.allocate(8);
		MemorySegment args = Bridge.allocate(ADDRESS.byteSize());
		args.set(ADDRESS, 0, string.segment());
		invokeBuiltinConstructor(variantType, 2, result, args);
		destroyTypedBuiltin(string.segment(), VariantType.STRING.id());
		return result;
	}

	private static void invokeBuiltinConstructor(int variantType, int constructor, MemorySegment result,
			MemorySegment args) {
		try {
			getBuiltinConstructor(variantType, constructor).invoke(result, args);
		} catch (Throwable t) {
			throw new RuntimeException("Builtin constructor failed for type " + variantType, t);
		}
	}

	private static MethodHandle getBuiltinConstructor(int variantType, int constructor) {
		String key = variantType + ":" + constructor;
		return BUILTIN_CONSTRUCTOR_CACHE.computeIfAbsent(key, ignored -> {
			try {
				MemorySegment ptr = Bridge.callPtr(ApiIndex.VARIANT_GET_PTR_CONSTRUCTOR, variantType, constructor);
				if (ptr.address() == 0) {
					throw new IllegalStateException(
							"No builtin constructor for type " + variantType + " index " + constructor);
				}
				return Linker.nativeLinker().downcallHandle(ptr, BUILTIN_CONSTRUCTOR_DESC);
			} catch (Throwable t) {
				throw new RuntimeException("Failed to load builtin constructor for type " + variantType, t);
			}
		});
	}

	private static void destroyTypedBuiltin(MemorySegment value, int variantType) {
		if (variantType == VARIANT_SENTINEL) {
			Bridge.destroyVariant(value);
			return;
		}
		if (variantType < 0 || value == null || value.address() == 0) {
			return;
		}
		try {
			getBuiltinDestructor(variantType).invoke(value);
		} catch (Throwable t) {
			logger.warn("Failed to destroy typed builtin type {}: {}", variantType, t.getMessage());
		}
	}

	private static MethodHandle getBuiltinDestructor(int variantType) {
		return BUILTIN_DESTRUCTOR_CACHE.computeIfAbsent(variantType, ignored -> {
			try {
				MemorySegment ptr = Bridge.callPtr(ApiIndex.VARIANT_GET_PTR_DESTRUCTOR, variantType);
				if (ptr.address() == 0) {
					throw new IllegalStateException("No builtin destructor for type " + variantType);
				}
				return Linker.nativeLinker().downcallHandle(ptr, BUILTIN_DESTRUCTOR_DESC);
			} catch (Throwable t) {
				throw new RuntimeException("Failed to load builtin destructor for type " + variantType, t);
			}
		});
	}

	private record TypedStringArg(String value) {
	}

	private record TypedStringNameArg(String value) {
	}

	private record TypedNodePathArg(String value) {
	}

	private record TypedObjectArg(Godot value, boolean refCounted) {
	}

	private static final int REF_PTR_SENTINEL = -2;
	private static final int VARIANT_SENTINEL = -3;

	private record NativeTypedArg(MemorySegment segment, int destroyVariantType) {
		static NativeTypedArg primitive(MemorySegment segment) {
			return new NativeTypedArg(segment, -1);
		}

		void destroy() {
			if (destroyVariantType == REF_PTR_SENTINEL) {
				try {
					Bridge.callVoid(ApiIndex.REF_SET_OBJECT, segment, MemorySegment.NULL);
				} catch (RuntimeException ignored) {
				}
				return;
			}
			if (destroyVariantType == VARIANT_SENTINEL) {
				Bridge.destroyVariant(segment);
				return;
			}
			destroyTypedBuiltin(segment, destroyVariantType);
		}
	}

	private record TypedVariantArg(Object value) {
	}

	private record TypedSizedIntegerArg(long value, long size) {
	}

	private record TypedUint64Arg(BigInteger value) {
	}

	private record TypedBuiltinArg(Object value, int variantType, long size) {
	}

	private record TypedPackedArrayArg(Object value, int variantType, long size, long appendHash) {
	}

	private record TypedArgFrame(MemorySegment argPtrs, NativeTypedArg[] args) {
		static final TypedArgFrame EMPTY = new TypedArgFrame(MemorySegment.NULL, new NativeTypedArg[0]);

		void destroy() {
			for (NativeTypedArg arg : args) {
				arg.destroy();
			}
		}
	}

	private static java.lang.Object callMethodBind(String className, String methodName, long hash, MemorySegment object,
			java.lang.Object... args) {
		return Bridge.runDowncall(() -> Bridge.runScoped(() -> {
			int depth = Bridge.callDepth();
			if (depth >= Bridge.MAX_CALL_DEPTH) {
				throw new RuntimeException("Maximum call depth exceeded: " + depth);
			}
			int argc = args != null ? args.length : 0;
			if (argc > Bridge.MAX_CALL_ARGS) {
				throw new RuntimeException("Too many arguments: " + argc + " (max " + Bridge.MAX_CALL_ARGS + ")");
			}

			try {
				Bridge.destroyVariant(Bridge.resultSlot(depth));
				MemorySegment argPtrs;
				if (argc > 0) {
					argPtrs = Bridge.argPtrsSlot(depth);
					for (int i = 0; i < argc; i++) {
						MemorySegment slot = Bridge.argSlot(depth, i);
						VariantUtils.fromObjectInto(args[i], slot);
						argPtrs.set(ADDRESS, (long) i * ADDRESS.byteSize(), slot);
					}
				} else {
					argPtrs = MemorySegment.NULL;
				}

				MemorySegment resultVar = Bridge.resultSlot(depth);
				MemorySegment errorVar = Bridge.errorSlot(depth);

				return Bridge.withCallDepth(depth, () -> {
					MemorySegment methodBind = getCachedMethodBind(className, methodName, hash);
					if (methodBind.address() == 0) {
						throw new RuntimeException("Method bind not found: " + methodName + " on " + className);
					}
					Bridge.callVoid(ApiIndex.OBJECT_METHOD_BIND_CALL, methodBind, object, argPtrs, (long) argc,
							resultVar, errorVar);

					int errorCode = errorVar.get(JAVA_INT, 0);
					if (errorCode != 0) {
						StringBuilder sb = new StringBuilder();
						sb.append("Call error ").append(errorCode).append(" calling ").append(className).append(".")
								.append(methodName);
						sb.append(" (arg=").append(errorVar.get(JAVA_INT, 4));
						sb.append(", expected=").append(errorVar.get(JAVA_INT, 8)).append(")");
						throw new RuntimeException(sb.toString());
					}

					Variant resultVariant = new Variant(resultVar);
					return VariantUtils.toObject(resultVariant);
				});
			} finally {
				if (args != null) {
					for (int i = 0; i < argc; i++) {
						Bridge.destroyVariant(Bridge.argSlot(depth, i));
					}
				}
			}
		}));
	}

	// ----------------------------------------------------------------
	// Signal emission
	// ----------------------------------------------------------------

	public int emitSignal(String signalName, java.lang.Object... args) {
		checkValid();

		return Bridge.runDowncall(() -> Bridge.runScoped(() -> {
			int depth = Bridge.callDepth();
			if (depth >= Bridge.MAX_CALL_DEPTH) {
				return -1;
			}

			HashResult hr = resolveMethodHash("emit_signal");
			if (!hr.isFound()) {
				return -1;
			}

			MemorySegment methodBind = getCachedMethodBind(hr.className, "emit_signal", hr.hash);
			if (methodBind.address() == 0) {
				return -2;
			}

			int argc = 1 + (args != null ? args.length : 0);
			if (argc > Bridge.MAX_CALL_ARGS) {
				return -1;
			}

			try {
				Bridge.destroyVariant(Bridge.resultSlot(depth));
				MemorySegment argPtrs = Bridge.argPtrsSlot(depth);

				MemorySegment snSlot = Bridge.argSlot(depth, 0);
				Variant.fromStringNameInto(GodotStringName.fromJavaString(signalName), snSlot);
				argPtrs.set(ADDRESS, 0, snSlot);

				for (int i = 0; args != null && i < args.length; i++) {
					MemorySegment slot = Bridge.argSlot(depth, i + 1);
					VariantUtils.fromObjectInto(args[i], slot);
					argPtrs.set(ADDRESS, (long) (i + 1) * ADDRESS.byteSize(), slot);
				}

				MemorySegment resultVar = Bridge.resultSlot(depth);
				MemorySegment errorVar = Bridge.errorSlot(depth);

				return Bridge.withCallDepth(depth, () -> {
					Bridge.callVoid(ApiIndex.OBJECT_METHOD_BIND_CALL, methodBind, MemorySegment.ofAddress(nativeObject),
							argPtrs, (long) argc, resultVar, errorVar);

					int errorCode = errorVar.get(JAVA_INT, 0);
					if (errorCode != 0) {
						logger.error("emit_signal '{}' failed: error={}", signalName, errorCode);
						return -3;
					}

					Variant resultVariant = new Variant(resultVar);
					java.lang.Object result = VariantUtils.toObject(resultVariant);
					if (result instanceof Number) {
						return ((Number) result).intValue();
					}
					return 0;
				});
			} finally {
				for (int i = 0; i < argc; i++) {
					Bridge.destroyVariant(Bridge.argSlot(depth, i));
				}
			}
		}));
	}

	// ----------------------------------------------------------------
	// Virtual lifecycle methods
	// ----------------------------------------------------------------

	public void _ready() {
	}

	public void _process(double delta) {
	}

	public void _physicsProcess(double delta) {
	}

	public void _enterTree() {
	}

	public void _exitTree() {
	}

	public boolean _input(java.lang.Object event) {
		return false;
	}

	public boolean _shortcutInput(java.lang.Object event) {
		return false;
	}

	public boolean _unhandledInput(java.lang.Object event) {
		return false;
	}

	public boolean _unhandledKeyInput(java.lang.Object event) {
		return false;
	}

	public void _draw() {
	}

	public void _integrateForces(java.lang.Object state) {
	}

	public boolean _guiInput(java.lang.Object event) {
		return false;
	}

	public GodotArray _getConfigurationWarnings() {
		return new GodotArray();
	}

	public GodotArray _getAccessibilityConfigurationWarnings() {
		return new GodotArray();
	}

	public Godot _getFocusedAccessibilityElement() {
		return null;
	}

	public void _notification(int what) {
	}

	public void _accessibilityUpdate() {
	}

	public void _accessibilityInvalidate() {
	}

	public void onNotification(int what) {
		_notification(what);
		switch (what) {
			case NOTIFICATION_ACCESSIBILITY_UPDATE -> _accessibilityUpdate();
			case NOTIFICATION_ACCESSIBILITY_INVALIDATE -> _accessibilityInvalidate();
			default -> {
			}
		}
	}

	// ----------------------------------------------------------------
	// Property access
	// ----------------------------------------------------------------

	public java.lang.Object getProperty(String name) {
		checkValid();
		try {
			return call("get_" + name);
		} catch (RuntimeException e) {
			return call(name);
		}
	}

	public void setProperty(String name, java.lang.Object value) {
		checkValid();
		call("set_" + name, value);
	}

	// ----------------------------------------------------------------
	// Signal connection
	// ----------------------------------------------------------------

	public boolean connect(String signalName, org.godot.core.Callable callable, int flags) {
		checkValid();
		java.lang.Object result = call("connect", signalName, callable, flags);
		if (result instanceof Number) {
			return ((Number) result).intValue() == 0;
		}
		return false;
	}

	public void disconnect(String signalName, org.godot.core.Callable callable) {
		checkValid();
		call("disconnect", signalName, callable);
	}

	public boolean isConnected(String signalName, org.godot.core.Callable callable) {
		checkValid();
		java.lang.Object result = call("is_connected", signalName, callable);
		if (result instanceof Boolean) {
			return (Boolean) result;
		}
		if (result instanceof Number) {
			return ((Number) result).intValue() != 0;
		}
		return false;
	}

	// ----------------------------------------------------------------
	// Lifecycle
	// ----------------------------------------------------------------

	public void free() {
		if (nativeObject != 0) {
			org.godot.internal.ref.JavaObjectMap.remove(nativeObject);
			nativeObject = 0;
		}
	}

	/**
	 * Hot reload: reload user code from the given JAR path.
	 *
	 * <p>
	 * Creates a new URLClassLoader pointing at the JAR, unregisters all existing
	 * user classes from Godot's ClassDB, rescans using the new ClassLoader, and
	 * re-registers all classes.
	 *
	 * <p>
	 * Godot-side state (@Export properties) is preserved. Java-side non-exported
	 * fields are reset to defaults.
	 *
	 * @param jarPath
	 *            Absolute path to the updated JAR file
	 */
	public static void reloadUserCode(String jarPath) {
		logger.info("Hot reload triggered: {}", jarPath);
		try {
			java.net.URL jarUrl = new java.io.File(jarPath).toURI().toURL();
			java.net.URLClassLoader newLoader = new java.net.URLClassLoader(new java.net.URL[]{jarUrl},
					Godot.class.getClassLoader());

			java.util.List<Class<?>> newClasses = org.godot.registration.Scanner.rescan(newLoader);
			org.godot.registration.Registry.reloadUserClasses(newClasses);

			logger.info("Hot reload complete: {} classes reloaded", newClasses.size());
		} catch (Exception e) {
			logger.error("Hot reload failed", e);
		}
	}

	/**
	 * Schedule a task to run on the Godot main thread. If already on the main
	 * thread, executes immediately. Otherwise, queues for execution at the next
	 * main-thread tick.
	 */
	public static void runOnMainThread(Runnable task) {
		if (task == null)
			return;
		if (org.godot.internal.ThreadChecker.isMainThread()) {
			task.run();
		} else {
			org.godot.internal.DeferredExecutor.callDeferred(task);
		}
	}

	public void onFreed() {
	}

	@Override
	public String toString() {
		if (nativeObject == 0)
			return getClass().getSimpleName() + "[invalid]";
		return getClass().getSimpleName() + "[@" + Long.toHexString(nativeObject) + "]";
	}
}
