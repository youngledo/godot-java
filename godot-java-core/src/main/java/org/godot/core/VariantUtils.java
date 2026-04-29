package org.godot.core;

import org.godot.Godot;
import org.godot.bridge.Bridge;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.internal.api.ApiIndex;
import org.godot.internal.api.VariantType;
import org.godot.math.*;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_BYTE;
import static java.lang.foreign.ValueLayout.JAVA_FLOAT;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

/**
 * Utility for converting between Java objects and Godot Variants.
 */
public final class VariantUtils {

	private VariantUtils() {
	}

	public static Variant fromObject(Object value) {
		if (value == null)
			return Variant.fromNil();
		if (value instanceof Boolean)
			return Variant.fromBoolean((Boolean) value);
		if (value instanceof Rid rid)
			return Variant.fromRid(rid.id());
		if (value instanceof Integer || value instanceof Long)
			return Variant.fromInt(((Number) value).longValue());
		if (value instanceof Float || value instanceof Double)
			return Variant.fromFloat(((Number) value).doubleValue());
		if (value instanceof String)
			return Variant.fromString((String) value);
		if (value instanceof GodotStringName sn)
			return Variant.fromStringName(sn);
		if (value instanceof Vector2 v2)
			return Variant.fromVector2(v2);
		if (value instanceof Vector3 v3)
			return Variant.fromVector3(v3);
		if (value instanceof Color c)
			return fromColor(c);
		if (value instanceof Rect2 r)
			return fromRect2(r);
		if (value instanceof Rect2i r)
			return fromRect2i(r);
		if (value instanceof Transform2D t)
			return fromTransform2D(t);
		if (value instanceof Vector2i v)
			return fromVector2i(v);
		if (value instanceof Vector3i v)
			return fromVector3i(v);
		if (value instanceof Vector4 v4)
			return fromVector4(v4);
		if (value instanceof Vector4i v)
			return fromVector4i(v);
		if (value instanceof Transform3D t)
			return fromTransform3D(t);
		if (value instanceof Quaternion q)
			return fromQuaternion(q);
		if (value instanceof Plane p)
			return fromPlane(p);
		if (value instanceof AABB a)
			return fromAABB(a);
		if (value instanceof Basis b)
			return fromBasis(b);
		if (value instanceof Projection p)
			return fromProjection(p);
		if (value instanceof GodotDictionary d)
			return fromGodotDictionary(d);
		if (value instanceof Callable callable)
			return fromCallable(callable);
		if (value instanceof Signal signal)
			return fromSignal(signal);
		if (value instanceof Godot godot)
			return fromGodotObject(godot);
		return Variant.fromString(value.toString());
	}

	private static Variant fromGodotObject(Godot godot) {
		return Variant.fromObjectPtr(godot.getPtr());
	}

	/**
	 * Write a Java object value directly into a pre-allocated Variant slot. For
	 * common types (null, bool, int, float, String, Vector2, Vector3, Godot
	 * objects) writes directly without allocation. For rare complex types falls
	 * back to fromObject + VARIANT_NEW_COPY.
	 */
	public static void fromObjectInto(Object value, MemorySegment target) {
		if (value == null) {
			target.set(JAVA_INT, 0, VariantType.NIL.id());
			return;
		}
		if (value instanceof Boolean b) {
			target.set(JAVA_INT, 0, VariantType.BOOL.id());
			target.set(JAVA_BYTE, 8, (byte) (b ? 1 : 0));
			return;
		}
		if (value instanceof Rid rid) {
			target.set(JAVA_INT, 0, VariantType.RID.id());
			target.set(JAVA_LONG, 8, rid.id());
			return;
		}
		if (value instanceof Integer || value instanceof Long) {
			target.set(JAVA_INT, 0, VariantType.INT.id());
			target.set(JAVA_LONG, 8, ((Number) value).longValue());
			return;
		}
		if (value instanceof Float || value instanceof Double) {
			target.set(JAVA_INT, 0, VariantType.FLOAT.id());
			target.set(JAVA_LONG, 8, Double.doubleToRawLongBits(((Number) value).doubleValue()));
			return;
		}
		if (value instanceof String s) {
			Variant.fromStringInto(s, target);
			return;
		}
		if (value instanceof GodotStringName sn) {
			Variant.fromStringNameInto(sn, target);
			return;
		}
		if (value instanceof Vector2 v2) {
			target.set(JAVA_INT, 0, VariantType.VECTOR2.id());
			target.set(JAVA_INT, 8, Float.floatToRawIntBits((float) v2.x));
			target.set(JAVA_INT, 12, Float.floatToRawIntBits((float) v2.y));
			return;
		}
		if (value instanceof Vector3 v3) {
			target.set(JAVA_INT, 0, VariantType.VECTOR3.id());
			target.set(JAVA_INT, 8, Float.floatToRawIntBits((float) v3.x));
			target.set(JAVA_INT, 12, Float.floatToRawIntBits((float) v3.y));
			target.set(JAVA_INT, 16, Float.floatToRawIntBits((float) v3.z));
			return;
		}
		if (value instanceof Color c) {
			target.set(JAVA_INT, 0, VariantType.COLOR.id());
			target.set(JAVA_FLOAT, 8, (float) c.r);
			target.set(JAVA_FLOAT, 12, (float) c.g);
			target.set(JAVA_FLOAT, 16, (float) c.b);
			target.set(JAVA_FLOAT, 20, (float) c.a);
			return;
		}
		if (value instanceof Godot godot) {
			Variant.fromObjectPtrInto(godot.getPtr(), target);
			return;
		}
		// Fallback for complex types
		Variant v = fromObject(value);
		Bridge.callVoid(ApiIndex.VARIANT_NEW_COPY, target, v.getSegment());
		Bridge.destroyVariant(v.getSegment());
	}

	/**
	 * Write a Java object value directly into an uninitialized Variant memory
	 * segment. Uses byte-level writes to handle unaligned ret pointers from virtual
	 * dispatch upcalls (e.g. address 0x18e24ea2a).
	 */
	public static void writeVariantFromObject(MemorySegment ret, Object value) {
		if (value == null) {
			// Must write NIL — ret is uninitialized and Godot will use whatever is there
			long addr = ret.address();
			if (addr != 0) {
				MemorySegment seg = MemorySegment.ofAddress(addr).reinterpret(Variant.SIZE);
				for (long i = 0; i < Variant.SIZE; i++) {
					seg.set(JAVA_BYTE, i, (byte) 0);
				}
			}
			return;
		}
		long addr = ret.address();
		MemorySegment seg = MemorySegment.ofAddress(addr).reinterpret(Variant.SIZE);
		if (value instanceof Boolean b) {
			writeUnalignedInt(seg, 0, VariantType.BOOL.id());
			seg.set(JAVA_BYTE, 8, (byte) (b ? 1 : 0));
		} else if (value instanceof Rid rid) {
			writeUnalignedInt(seg, 0, VariantType.RID.id());
			writeUnalignedLong(seg, 8, rid.id());
		} else if (value instanceof Integer || value instanceof Long) {
			writeUnalignedInt(seg, 0, VariantType.INT.id());
			writeUnalignedLong(seg, 8, ((Number) value).longValue());
		} else if (value instanceof Float || value instanceof Double) {
			writeUnalignedInt(seg, 0, VariantType.FLOAT.id());
			writeUnalignedLong(seg, 8, Double.doubleToRawLongBits(((Number) value).doubleValue()));
		} else {
			Variant v = fromObject(value);
			Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_NEW_COPY, ret, v.getSegment());
			Bridge.destroyVariant(v.getSegment());
		}
	}

	private static void writeUnalignedInt(MemorySegment seg, long offset, int value) {
		seg.set(JAVA_BYTE, offset, (byte) (value & 0xFF));
		seg.set(JAVA_BYTE, offset + 1, (byte) ((value >> 8) & 0xFF));
		seg.set(JAVA_BYTE, offset + 2, (byte) ((value >> 16) & 0xFF));
		seg.set(JAVA_BYTE, offset + 3, (byte) ((value >> 24) & 0xFF));
	}

	private static void writeUnalignedLong(MemorySegment seg, long offset, long value) {
		for (int i = 0; i < 8; i++) {
			seg.set(JAVA_BYTE, offset + i, (byte) ((value >> (i * 8)) & 0xFF));
		}
	}

	public static Object toObject(Variant variant) {
		if (variant == null)
			return null;
		int type = variant.getType();
		if (type == VariantType.NIL.id())
			return null;
		// Ensure segment is large enough for all variant data types (max 72 bytes for
		// Projection)
		MemorySegment seg = variant.getSegment().reinterpret(Variant.SIZE);
		if (type == VariantType.BOOL.id())
			return variant.asBoolean();
		if (type == VariantType.INT.id())
			return variant.asLong();
		if (type == VariantType.FLOAT.id())
			return variant.asDouble();
		if (type == VariantType.STRING.id())
			return variant.asString();
		if (type == VariantType.STRING_NAME.id()) {
			MemorySegment retBuf = Bridge.allocate(8);
			Bridge.callVoid(ApiIndex.VARIANT_STRINGIFY, seg, retBuf);
			return new GodotString(retBuf).toJavaString();
		}
		if (type == VariantType.VECTOR2.id())
			return readVector2(seg);
		if (type == VariantType.VECTOR2I.id())
			return readVector2i(seg);
		if (type == VariantType.VECTOR3.id())
			return readVector3(seg);
		if (type == VariantType.VECTOR3I.id())
			return readVector3i(seg);
		if (type == VariantType.VECTOR4.id())
			return readVector4(seg);
		if (type == VariantType.VECTOR4I.id())
			return readVector4i(seg);
		if (type == VariantType.RECT2.id())
			return readRect2(seg);
		if (type == VariantType.RECT2I.id())
			return readRect2i(seg);
		if (type == VariantType.COLOR.id())
			return readColor(seg);
		if (type == VariantType.PLANE.id())
			return readPlane(seg);
		if (type == VariantType.QUATERNION.id())
			return readQuaternion(seg);
		if (type == VariantType.AABB.id())
			return readAABB(seg);
		if (type == VariantType.BASIS.id())
			return readBasis(seg);
		if (type == VariantType.TRANSFORM3D.id())
			return readTransform3D(seg);
		if (type == VariantType.TRANSFORM2D.id())
			return readTransform2D(seg);
		if (type == VariantType.PROJECTION.id())
			return readProjection(seg);
		if (type == VariantType.DICTIONARY.id()) {
			long ptr = seg.get(JAVA_LONG, 8);
			return new GodotDictionary(ptr);
		}
		if (type == VariantType.ARRAY.id())
			return new GodotArray(seg);
		if (type == VariantType.OBJECT.id()) {
			long objectId = seg.get(JAVA_LONG, 8);
			if (objectId == 0)
				return null;
			// Godot ObjectID bit 63 = RefCounted flag (OBJECTDB_REFERENCE_BIT).
			// Only RefCounted objects need reference() to prevent premature freeing.
			boolean isRefCounted = (objectId & (1L << 63)) != 0;
			// Variant OBJECT stores ObjectID, not a pointer. Resolve to actual pointer.
			MemorySegment objPtr = Bridge.callPtr(ApiIndex.OBJECT_GET_INSTANCE_FROM_ID, objectId);
			long ptr = objPtr.address();
			if (ptr == 0)
				return null;
			Object obj = org.godot.internal.ref.JavaObjectMap.get(ptr);
			if (obj instanceof Godot g)
				return g;
			// Query Godot class name and create typed wrapper
			Godot typed = org.godot.internal.GodotClassRegistry.createTypedWrapper(ptr);
			if (typed != null) {
				org.godot.internal.ref.JavaObjectMap.put(ptr, typed);
				if (isRefCounted) {
					org.godot.internal.ref.RefCountedHelper.reference(ptr);
				}
				return typed;
			}
			org.godot.internal.ref.GenericGodotObject generic = new org.godot.internal.ref.GenericGodotObject(ptr,
					"Object");
			if (isRefCounted) {
				org.godot.internal.ref.RefCountedHelper.reference(ptr);
			}
			return generic;
		}
		if (type == VariantType.RID.id())
			return new Rid(seg.get(JAVA_LONG, 8));
		if (type == VariantType.CALLABLE.id())
			return new Callable(null, "");
		if (type == VariantType.SIGNAL.id()) {
			long objPtr = seg.get(JAVA_LONG, 8);
			if (objPtr == 0)
				return new Signal(null, "");
			Godot obj = (Godot) org.godot.internal.ref.JavaObjectMap.get(objPtr);
			if (obj == null) {
				obj = org.godot.internal.GodotClassRegistry.createTypedWrapper(objPtr);
				if (obj != null)
					org.godot.internal.ref.JavaObjectMap.put(objPtr, obj);
			}
			if (obj == null)
				obj = new org.godot.internal.ref.GenericGodotObject(objPtr, "Object");
			return new Signal(obj, "");
		}
		if (type == VariantType.PACKED_BYTE_ARRAY.id())
			return readPackedByteArray(seg);
		if (type == VariantType.PACKED_INT32_ARRAY.id())
			return readPackedInt32Array(seg);
		if (type == VariantType.PACKED_INT64_ARRAY.id())
			return readPackedInt64Array(seg);
		if (type == VariantType.PACKED_FLOAT32_ARRAY.id())
			return readPackedFloat32Array(seg);
		if (type == VariantType.PACKED_FLOAT64_ARRAY.id())
			return readPackedFloat64Array(seg);
		if (type == VariantType.PACKED_STRING_ARRAY.id())
			return readPackedStringArray(seg);
		if (type == VariantType.PACKED_VECTOR2_ARRAY.id())
			return readPackedVector2Array(seg);
		if (type == VariantType.PACKED_VECTOR3_ARRAY.id())
			return readPackedVector3Array(seg);
		if (type == VariantType.PACKED_COLOR_ARRAY.id())
			return readPackedColorArray(seg);
		if (type == VariantType.PACKED_VECTOR4_ARRAY.id())
			return readPackedVector4Array(seg);
		return variant.asString();
	}

	// ------------------------------------------------------------------------
	// Read methods (Variant → Java objects)
	// ------------------------------------------------------------------------

	private static Vector2 readVector2(MemorySegment seg) {
		float x = Float.intBitsToFloat(seg.get(JAVA_INT, 8));
		float y = Float.intBitsToFloat(seg.get(JAVA_INT, 12));
		return new Vector2(x, y);
	}

	private static Vector2i readVector2i(MemorySegment seg) {
		int x = seg.get(JAVA_INT, 8);
		int y = seg.get(JAVA_INT, 12);
		return new Vector2i(x, y);
	}

	private static Vector3 readVector3(MemorySegment seg) {
		float x = Float.intBitsToFloat(seg.get(JAVA_INT, 8));
		float y = Float.intBitsToFloat(seg.get(JAVA_INT, 12));
		float z = Float.intBitsToFloat(seg.get(JAVA_INT, 16));
		return new Vector3(x, y, z);
	}

	private static Vector3i readVector3i(MemorySegment seg) {
		int x = seg.get(JAVA_INT, 8);
		int y = seg.get(JAVA_INT, 12);
		int z = seg.get(JAVA_INT, 16);
		return new Vector3i(x, y, z);
	}

	private static Vector4 readVector4(MemorySegment seg) {
		float x = Float.intBitsToFloat(seg.get(JAVA_INT, 8));
		float y = Float.intBitsToFloat(seg.get(JAVA_INT, 12));
		float z = Float.intBitsToFloat(seg.get(JAVA_INT, 16));
		float w = Float.intBitsToFloat(seg.get(JAVA_INT, 20));
		return new Vector4(x, y, z, w);
	}

	private static Vector4i readVector4i(MemorySegment seg) {
		int x = seg.get(JAVA_INT, 8);
		int y = seg.get(JAVA_INT, 12);
		int z = seg.get(JAVA_INT, 16);
		int w = seg.get(JAVA_INT, 20);
		return new Vector4i(x, y, z, w);
	}

	private static Rect2 readRect2(MemorySegment seg) {
		float px = Float.intBitsToFloat(seg.get(JAVA_INT, 8));
		float py = Float.intBitsToFloat(seg.get(JAVA_INT, 12));
		float sx = Float.intBitsToFloat(seg.get(JAVA_INT, 16));
		float sy = Float.intBitsToFloat(seg.get(JAVA_INT, 20));
		return new Rect2(px, py, sx, sy);
	}

	private static Rect2i readRect2i(MemorySegment seg) {
		int px = seg.get(JAVA_INT, 8);
		int py = seg.get(JAVA_INT, 12);
		int sx = seg.get(JAVA_INT, 16);
		int sy = seg.get(JAVA_INT, 20);
		return new Rect2i(px, py, sx, sy);
	}

	private static Color readColor(MemorySegment seg) {
		float r = Float.intBitsToFloat(seg.get(JAVA_INT, 8));
		float g = Float.intBitsToFloat(seg.get(JAVA_INT, 12));
		float b = Float.intBitsToFloat(seg.get(JAVA_INT, 16));
		float a = Float.intBitsToFloat(seg.get(JAVA_INT, 20));
		return new Color(r, g, b, a);
	}

	private static Plane readPlane(MemorySegment seg) {
		float nx = Float.intBitsToFloat(seg.get(JAVA_INT, 8));
		float ny = Float.intBitsToFloat(seg.get(JAVA_INT, 12));
		float nz = Float.intBitsToFloat(seg.get(JAVA_INT, 16));
		float d = Float.intBitsToFloat(seg.get(JAVA_INT, 20));
		return new Plane(nx, ny, nz, d);
	}

	private static Quaternion readQuaternion(MemorySegment seg) {
		float x = Float.intBitsToFloat(seg.get(JAVA_INT, 8));
		float y = Float.intBitsToFloat(seg.get(JAVA_INT, 12));
		float z = Float.intBitsToFloat(seg.get(JAVA_INT, 16));
		float w = Float.intBitsToFloat(seg.get(JAVA_INT, 20));
		return new Quaternion(x, y, z, w);
	}

	private static AABB readAABB(MemorySegment variantSeg) {
		MethodHandle ext = Variant.getTypeExtractor(VariantType.AABB.id());
		if (ext != null) {
			try {
				MemorySegment buf = Bridge.allocate(24);
				ext.invoke(buf, variantSeg);
				float f0 = buf.get(JAVA_FLOAT, 0);
				float f1 = buf.get(JAVA_FLOAT, 4);
				float f2 = buf.get(JAVA_FLOAT, 8);
				float f3 = buf.get(JAVA_FLOAT, 12);
				float f4 = buf.get(JAVA_FLOAT, 16);
				float f5 = buf.get(JAVA_FLOAT, 20);
				return new AABB(f0, f1, f2, f3, f4, f5);
			} catch (Throwable ignored) {
			}
		}
		return new AABB();
	}

	private static Basis readBasis(MemorySegment variantSeg) {
		MethodHandle ext = Variant.getTypeExtractor(VariantType.BASIS.id());
		if (ext != null) {
			try {
				MemorySegment buf = Bridge.allocate(36);
				ext.invoke(buf, variantSeg);
				float f0 = buf.get(JAVA_FLOAT, 0);
				float f1 = buf.get(JAVA_FLOAT, 4);
				float f2 = buf.get(JAVA_FLOAT, 8);
				float f3 = buf.get(JAVA_FLOAT, 12);
				float f4 = buf.get(JAVA_FLOAT, 16);
				float f5 = buf.get(JAVA_FLOAT, 20);
				float f6 = buf.get(JAVA_FLOAT, 24);
				float f7 = buf.get(JAVA_FLOAT, 28);
				float f8 = buf.get(JAVA_FLOAT, 32);
				return new Basis(f0, f1, f2, f3, f4, f5, f6, f7, f8);
			} catch (Throwable ignored) {
			}
		}
		return new Basis();
	}

	private static Transform3D readTransform3D(MemorySegment variantSeg) {
		MethodHandle ext = Variant.getTypeExtractor(VariantType.TRANSFORM3D.id());
		if (ext != null) {
			try {
				MemorySegment buf = Bridge.allocate(48);
				ext.invoke(buf, variantSeg);
				Basis b = new Basis(buf.get(JAVA_FLOAT, 0), buf.get(JAVA_FLOAT, 4), buf.get(JAVA_FLOAT, 8),
						buf.get(JAVA_FLOAT, 12), buf.get(JAVA_FLOAT, 16), buf.get(JAVA_FLOAT, 20),
						buf.get(JAVA_FLOAT, 24), buf.get(JAVA_FLOAT, 28), buf.get(JAVA_FLOAT, 32));
				Vector3 o = new Vector3(buf.get(JAVA_FLOAT, 36), buf.get(JAVA_FLOAT, 40), buf.get(JAVA_FLOAT, 44));
				return new Transform3D(b, o);
			} catch (Throwable ignored) {
			}
		}
		return new Transform3D();
	}

	private static Transform2D readTransform2D(MemorySegment variantSeg) {
		MethodHandle ext = Variant.getTypeExtractor(VariantType.TRANSFORM2D.id());
		if (ext != null) {
			try {
				MemorySegment buf = Bridge.allocate(24);
				ext.invoke(buf, variantSeg);
				return new Transform2D(new Vector2(buf.get(JAVA_FLOAT, 0), buf.get(JAVA_FLOAT, 4)),
						new Vector2(buf.get(JAVA_FLOAT, 8), buf.get(JAVA_FLOAT, 12)),
						new Vector2(buf.get(JAVA_FLOAT, 16), buf.get(JAVA_FLOAT, 20)));
			} catch (Throwable ignored) {
			}
		}
		return new Transform2D();
	}

	private static Projection readProjection(MemorySegment variantSeg) {
		MethodHandle ext = Variant.getTypeExtractor(VariantType.PROJECTION.id());
		if (ext != null) {
			try {
				MemorySegment buf = Bridge.allocate(64);
				ext.invoke(buf, variantSeg);
				return new Projection(
						new Vector4(buf.get(JAVA_FLOAT, 0), buf.get(JAVA_FLOAT, 4), buf.get(JAVA_FLOAT, 8),
								buf.get(JAVA_FLOAT, 12)),
						new Vector4(buf.get(JAVA_FLOAT, 16), buf.get(JAVA_FLOAT, 20), buf.get(JAVA_FLOAT, 24),
								buf.get(JAVA_FLOAT, 28)),
						new Vector4(buf.get(JAVA_FLOAT, 32), buf.get(JAVA_FLOAT, 36), buf.get(JAVA_FLOAT, 40),
								buf.get(JAVA_FLOAT, 44)),
						new Vector4(buf.get(JAVA_FLOAT, 48), buf.get(JAVA_FLOAT, 52), buf.get(JAVA_FLOAT, 56),
								buf.get(JAVA_FLOAT, 60)));
			} catch (Throwable ignored) {
			}
		}
		return new Projection();
	}

	private static byte[] readPackedByteArray(MemorySegment variantSeg) {
		long arrayPtr = variantSeg.get(JAVA_LONG, 8);
		int size = (int) variantSeg.get(JAVA_LONG, 16);
		if (arrayPtr == 0 || size == 0)
			return new byte[0];
		MemorySegment arrSeg = MemorySegment.ofAddress(arrayPtr).reinterpret(size);
		byte[] result = new byte[size];
		for (int i = 0; i < size; i++) {
			result[i] = arrSeg.get(JAVA_BYTE, (long) i);
		}
		return result;
	}

	private static int[] readPackedInt32Array(MemorySegment variantSeg) {
		long arrayPtr = variantSeg.get(JAVA_LONG, 8);
		int size = (int) variantSeg.get(JAVA_LONG, 16);
		if (arrayPtr == 0 || size == 0)
			return new int[0];
		MemorySegment arrSeg = MemorySegment.ofAddress(arrayPtr);
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = arrSeg.get(JAVA_INT, i * 4L);
		}
		return result;
	}

	private static long[] readPackedInt64Array(MemorySegment variantSeg) {
		long arrayPtr = variantSeg.get(JAVA_LONG, 8);
		int size = (int) variantSeg.get(JAVA_LONG, 16);
		if (arrayPtr == 0 || size == 0)
			return new long[0];
		MemorySegment arrSeg = MemorySegment.ofAddress(arrayPtr);
		long[] result = new long[size];
		for (int i = 0; i < size; i++) {
			result[i] = arrSeg.get(JAVA_LONG, i * 8L);
		}
		return result;
	}

	private static float[] readPackedFloat32Array(MemorySegment variantSeg) {
		long arrayPtr = variantSeg.get(JAVA_LONG, 8);
		int size = (int) variantSeg.get(JAVA_LONG, 16);
		if (arrayPtr == 0 || size == 0)
			return new float[0];
		MemorySegment arrSeg = MemorySegment.ofAddress(arrayPtr);
		float[] result = new float[size];
		for (int i = 0; i < size; i++) {
			result[i] = arrSeg.get(JAVA_FLOAT, i * 4L);
		}
		return result;
	}

	private static double[] readPackedFloat64Array(MemorySegment variantSeg) {
		long arrayPtr = variantSeg.get(JAVA_LONG, 8);
		int size = (int) variantSeg.get(JAVA_LONG, 16);
		if (arrayPtr == 0 || size == 0)
			return new double[0];
		MemorySegment arrSeg = MemorySegment.ofAddress(arrayPtr);
		double[] result = new double[size];
		for (int i = 0; i < size; i++) {
			result[i] = arrSeg.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE, i * 8L);
		}
		return result;
	}

	private static String[] readPackedStringArray(MemorySegment variantSeg) {
		long arrayPtr = variantSeg.get(JAVA_LONG, 8);
		int size = (int) variantSeg.get(JAVA_LONG, 16);
		if (arrayPtr == 0 || size == 0)
			return new String[0];
		MemorySegment arrSeg = MemorySegment.ofAddress(arrayPtr);
		String[] result = new String[size];
		for (int i = 0; i < size; i++) {
			long strPtr = arrSeg.get(JAVA_LONG, i * 8L);
			if (strPtr != 0)
				result[i] = new GodotString(MemorySegment.ofAddress(strPtr)).toJavaString();
		}
		return result;
	}

	private static Vector2[] readPackedVector2Array(MemorySegment variantSeg) {
		long arrayPtr = variantSeg.get(JAVA_LONG, 8);
		int size = (int) variantSeg.get(JAVA_LONG, 16);
		if (arrayPtr == 0 || size == 0)
			return new Vector2[0];
		MemorySegment arrSeg = MemorySegment.ofAddress(arrayPtr);
		Vector2[] result = new Vector2[size];
		for (int i = 0; i < size; i++) {
			float x = arrSeg.get(JAVA_FLOAT, i * 8L);
			float y = arrSeg.get(JAVA_FLOAT, i * 8L + 4);
			result[i] = new Vector2(x, y);
		}
		return result;
	}

	private static Vector3[] readPackedVector3Array(MemorySegment variantSeg) {
		long arrayPtr = variantSeg.get(JAVA_LONG, 8);
		int size = (int) variantSeg.get(JAVA_LONG, 16);
		if (arrayPtr == 0 || size == 0)
			return new Vector3[0];
		MemorySegment arrSeg = MemorySegment.ofAddress(arrayPtr);
		Vector3[] result = new Vector3[size];
		for (int i = 0; i < size; i++) {
			float x = arrSeg.get(JAVA_FLOAT, i * 12L);
			float y = arrSeg.get(JAVA_FLOAT, i * 12L + 4);
			float z = arrSeg.get(JAVA_FLOAT, i * 12L + 8);
			result[i] = new Vector3(x, y, z);
		}
		return result;
	}

	private static Color[] readPackedColorArray(MemorySegment variantSeg) {
		long arrayPtr = variantSeg.get(JAVA_LONG, 8);
		int size = (int) variantSeg.get(JAVA_LONG, 16);
		if (arrayPtr == 0 || size == 0)
			return new Color[0];
		MemorySegment arrSeg = MemorySegment.ofAddress(arrayPtr);
		Color[] result = new Color[size];
		for (int i = 0; i < size; i++) {
			float r = arrSeg.get(JAVA_FLOAT, i * 16L);
			float g = arrSeg.get(JAVA_FLOAT, i * 16L + 4);
			float b = arrSeg.get(JAVA_FLOAT, i * 16L + 8);
			float a = arrSeg.get(JAVA_FLOAT, i * 16L + 12);
			result[i] = new Color(r, g, b, a);
		}
		return result;
	}

	private static Vector4[] readPackedVector4Array(MemorySegment variantSeg) {
		long arrayPtr = variantSeg.get(JAVA_LONG, 8);
		int size = (int) variantSeg.get(JAVA_LONG, 16);
		if (arrayPtr == 0 || size == 0)
			return new Vector4[0];
		MemorySegment arrSeg = MemorySegment.ofAddress(arrayPtr);
		Vector4[] result = new Vector4[size];
		for (int i = 0; i < size; i++) {
			float x = arrSeg.get(JAVA_FLOAT, i * 16L);
			float y = arrSeg.get(JAVA_FLOAT, i * 16L + 4);
			float z = arrSeg.get(JAVA_FLOAT, i * 16L + 8);
			float w = arrSeg.get(JAVA_FLOAT, i * 16L + 12);
			result[i] = new Vector4(x, y, z, w);
		}
		return result;
	}

	// ------------------------------------------------------------------------
	// From methods (Java objects → Variant)
	// ------------------------------------------------------------------------

	private static Variant fromColor(Color c) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_FLOAT, 8, (float) c.r);
		seg.set(JAVA_FLOAT, 12, (float) c.g);
		seg.set(JAVA_FLOAT, 16, (float) c.b);
		seg.set(JAVA_FLOAT, 20, (float) c.a);
		seg.set(JAVA_INT, 0, VariantType.COLOR.id());
		return new Variant(seg);
	}

	private static Variant fromRect2(Rect2 r) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_FLOAT, 8, (float) r.position.x);
		seg.set(JAVA_FLOAT, 12, (float) r.position.y);
		seg.set(JAVA_FLOAT, 16, (float) r.size.x);
		seg.set(JAVA_FLOAT, 20, (float) r.size.y);
		seg.set(JAVA_INT, 0, VariantType.RECT2.id());
		return new Variant(seg);
	}

	private static Variant fromRect2i(Rect2i r) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_INT, 8, r.x);
		seg.set(JAVA_INT, 12, r.y);
		seg.set(JAVA_INT, 16, r.width);
		seg.set(JAVA_INT, 20, r.height);
		seg.set(JAVA_INT, 0, VariantType.RECT2I.id());
		return new Variant(seg);
	}

	private static Variant fromTransform2D(Transform2D t) {
		MethodHandle ctor = Variant.getTypeConstructor(VariantType.TRANSFORM2D.id());
		if (ctor != null) {
			try {
				MemorySegment buf = Bridge.allocate(24);
				buf.set(JAVA_FLOAT, 0, (float) t.x.x);
				buf.set(JAVA_FLOAT, 4, (float) t.x.y);
				buf.set(JAVA_FLOAT, 8, (float) t.y.x);
				buf.set(JAVA_FLOAT, 12, (float) t.y.y);
				buf.set(JAVA_FLOAT, 16, (float) t.origin.x);
				buf.set(JAVA_FLOAT, 20, (float) t.origin.y);
				Variant v = Variant.allocate();
				ctor.invoke(v.getSegment(), buf);
				return v;
			} catch (Throwable ignored) {
			}
		}
		return Variant.fromNil();
	}

	private static Variant fromVector2i(Vector2i v) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_INT, 8, v.x);
		seg.set(JAVA_INT, 12, v.y);
		seg.set(JAVA_INT, 0, VariantType.VECTOR2I.id());
		return new Variant(seg);
	}

	private static Variant fromVector3i(Vector3i v) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_INT, 8, v.x);
		seg.set(JAVA_INT, 12, v.y);
		seg.set(JAVA_INT, 16, v.z);
		seg.set(JAVA_INT, 0, VariantType.VECTOR3I.id());
		return new Variant(seg);
	}

	private static Variant fromVector4(Vector4 v) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_FLOAT, 8, (float) v.x);
		seg.set(JAVA_FLOAT, 12, (float) v.y);
		seg.set(JAVA_FLOAT, 16, (float) v.z);
		seg.set(JAVA_FLOAT, 20, (float) v.w);
		seg.set(JAVA_INT, 0, VariantType.VECTOR4.id());
		return new Variant(seg);
	}

	private static Variant fromVector4i(Vector4i v) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_INT, 8, v.x);
		seg.set(JAVA_INT, 12, v.y);
		seg.set(JAVA_INT, 16, v.z);
		seg.set(JAVA_INT, 20, v.w);
		seg.set(JAVA_INT, 0, VariantType.VECTOR4I.id());
		return new Variant(seg);
	}

	private static Variant fromTransform3D(Transform3D t) {
		MethodHandle ctor = Variant.getTypeConstructor(VariantType.TRANSFORM3D.id());
		if (ctor != null) {
			try {
				MemorySegment buf = Bridge.allocate(48);
				buf.set(JAVA_FLOAT, 0, (float) t.xx);
				buf.set(JAVA_FLOAT, 4, (float) t.xy);
				buf.set(JAVA_FLOAT, 8, (float) t.xz);
				buf.set(JAVA_FLOAT, 12, (float) t.yx);
				buf.set(JAVA_FLOAT, 16, (float) t.yy);
				buf.set(JAVA_FLOAT, 20, (float) t.yz);
				buf.set(JAVA_FLOAT, 24, (float) t.zx);
				buf.set(JAVA_FLOAT, 28, (float) t.zy);
				buf.set(JAVA_FLOAT, 32, (float) t.zz);
				buf.set(JAVA_FLOAT, 36, (float) t.ox);
				buf.set(JAVA_FLOAT, 40, (float) t.oy);
				buf.set(JAVA_FLOAT, 44, (float) t.oz);
				Variant v = Variant.allocate();
				ctor.invoke(v.getSegment(), buf);
				return v;
			} catch (Throwable ignored) {
			}
		}
		return Variant.fromNil();
	}

	private static Variant fromQuaternion(Quaternion q) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_FLOAT, 8, (float) q.x);
		seg.set(JAVA_FLOAT, 12, (float) q.y);
		seg.set(JAVA_FLOAT, 16, (float) q.z);
		seg.set(JAVA_FLOAT, 20, (float) q.w);
		seg.set(JAVA_INT, 0, VariantType.QUATERNION.id());
		return new Variant(seg);
	}

	private static Variant fromPlane(Plane p) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_FLOAT, 8, (float) p.x);
		seg.set(JAVA_FLOAT, 12, (float) p.y);
		seg.set(JAVA_FLOAT, 16, (float) p.z);
		seg.set(JAVA_FLOAT, 20, (float) p.d);
		seg.set(JAVA_INT, 0, VariantType.PLANE.id());
		return new Variant(seg);
	}

	private static Variant fromAABB(AABB t) {
		MethodHandle ctor = Variant.getTypeConstructor(VariantType.AABB.id());
		if (ctor != null) {
			try {
				MemorySegment buf = Bridge.allocate(24);
				buf.set(JAVA_FLOAT, 0, (float) t.x);
				buf.set(JAVA_FLOAT, 4, (float) t.y);
				buf.set(JAVA_FLOAT, 8, (float) t.z);
				buf.set(JAVA_FLOAT, 12, (float) t.sizeX);
				buf.set(JAVA_FLOAT, 16, (float) t.sizeY);
				buf.set(JAVA_FLOAT, 20, (float) t.sizeZ);
				Variant v = Variant.allocate();
				ctor.invoke(v.getSegment(), buf);
				return v;
			} catch (Throwable ignored) {
			}
		}
		return Variant.fromNil();
	}

	private static Variant fromBasis(Basis t) {
		MethodHandle ctor = Variant.getTypeConstructor(VariantType.BASIS.id());
		if (ctor != null) {
			try {
				MemorySegment buf = Bridge.allocate(36);
				buf.set(JAVA_FLOAT, 0, (float) t.xx);
				buf.set(JAVA_FLOAT, 4, (float) t.xy);
				buf.set(JAVA_FLOAT, 8, (float) t.xz);
				buf.set(JAVA_FLOAT, 12, (float) t.yx);
				buf.set(JAVA_FLOAT, 16, (float) t.yy);
				buf.set(JAVA_FLOAT, 20, (float) t.yz);
				buf.set(JAVA_FLOAT, 24, (float) t.zx);
				buf.set(JAVA_FLOAT, 28, (float) t.zy);
				buf.set(JAVA_FLOAT, 32, (float) t.zz);
				Variant v = Variant.allocate();
				ctor.invoke(v.getSegment(), buf);
				return v;
			} catch (Throwable ignored) {
			}
		}
		return Variant.fromNil();
	}

	private static Variant fromProjection(Projection t) {
		MethodHandle ctor = Variant.getTypeConstructor(VariantType.PROJECTION.id());
		if (ctor != null) {
			try {
				MemorySegment buf = Bridge.allocate(64);
				buf.set(JAVA_FLOAT, 0, (float) t.x.x);
				buf.set(JAVA_FLOAT, 4, (float) t.x.y);
				buf.set(JAVA_FLOAT, 8, (float) t.x.z);
				buf.set(JAVA_FLOAT, 12, (float) t.x.w);
				buf.set(JAVA_FLOAT, 16, (float) t.y.x);
				buf.set(JAVA_FLOAT, 20, (float) t.y.y);
				buf.set(JAVA_FLOAT, 24, (float) t.y.z);
				buf.set(JAVA_FLOAT, 28, (float) t.y.w);
				buf.set(JAVA_FLOAT, 32, (float) t.z.x);
				buf.set(JAVA_FLOAT, 36, (float) t.z.y);
				buf.set(JAVA_FLOAT, 40, (float) t.z.z);
				buf.set(JAVA_FLOAT, 44, (float) t.z.w);
				buf.set(JAVA_FLOAT, 48, (float) t.w.x);
				buf.set(JAVA_FLOAT, 52, (float) t.w.y);
				buf.set(JAVA_FLOAT, 56, (float) t.w.z);
				buf.set(JAVA_FLOAT, 60, (float) t.w.w);
				Variant v = Variant.allocate();
				ctor.invoke(v.getSegment(), buf);
				return v;
			} catch (Throwable ignored) {
			}
		}
		return Variant.fromNil();
	}

	private static Variant fromGodotDictionary(GodotDictionary d) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_LONG, 8, d.getPtr());
		seg.set(JAVA_INT, 0, VariantType.DICTIONARY.id());
		return new Variant(seg);
	}

	private static Variant fromCallable(Callable callable) {
		if (callable.getObject() == null) {
			MemorySegment seg = Bridge.allocVariant();
			seg.set(JAVA_INT, 0, VariantType.CALLABLE.id());
			return new Variant(seg);
		}

		// Register dispatch and create native callable via callable_custom_create2
		long key = org.godot.bridge.CallableDispatch.registerCallable(callable.getObject(), callable.getMethod());

		// Allocate Callable variant (24 bytes: 4 type + 4 padding + 16 data)
		MemorySegment seg = Bridge.arena().allocate(Variant.SIZE, 8);
		seg.set(JAVA_INT, 0, VariantType.CALLABLE.id());

		// Allocate GDExtensionCallableCustomInfo2 struct (96 bytes)
		MemorySegment infoSeg = Bridge.allocate(96);
		for (long i = 0; i < 96; i += 8) {
			infoSeg.set(ADDRESS, i, MemorySegment.ofAddress(0));
		}

		// Fill GDExtensionCallableCustomInfo2:
		// 0: callable_userdata (dispatch key as pointer)
		infoSeg.set(ADDRESS, 0, MemorySegment.ofAddress(key));
		// 8: token (library pointer)
		infoSeg.set(ADDRESS, 8, MemorySegment.ofAddress(Bridge.libraryPtr()));
		// 16: object_id (instance ID, not pointer)
		long instanceId = Bridge.callLong(ApiIndex.OBJECT_GET_INSTANCE_ID,
				MemorySegment.ofAddress(callable.getObject().getPtr()));
		infoSeg.set(JAVA_LONG, 16, instanceId);
		// 24: call_func
		infoSeg.set(ADDRESS, 24, org.godot.bridge.CallableDispatch.getCallStub());

		// Call callable_custom_create2(r_callable, info)
		Bridge.callVoid(ApiIndex.CALLABLE_CUSTOM_CREATE2, seg.asSlice(8), infoSeg);

		return new Variant(seg);
	}

	private static Variant fromSignal(Signal signal) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_INT, 0, VariantType.SIGNAL.id());
		return new Variant(seg);
	}
}
