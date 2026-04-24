package org.godot.core;

import org.godot.Godot;
import org.godot.bridge.Bridge;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.internal.api.ApiIndex;
import org.godot.internal.api.VariantType;
import org.godot.math.*;
import java.lang.foreign.MemorySegment;
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
	 * Write a Java object value directly into an uninitialized Variant memory
	 * segment. Uses byte-level writes to handle unaligned ret pointers from virtual
	 * dispatch upcalls (e.g. address 0x18e24ea2a).
	 */
	public static void writeVariantFromObject(MemorySegment ret, Object value) {
		if (value == null)
			return;
		long addr = ret.address();
		MemorySegment seg = MemorySegment.ofAddress(addr).reinterpret(24);
		if (value instanceof Boolean b) {
			writeUnalignedInt(seg, 0, VariantType.BOOL.id());
			seg.set(JAVA_BYTE, 8, (byte) (b ? 1 : 0));
		} else if (value instanceof Integer || value instanceof Long) {
			writeUnalignedInt(seg, 0, VariantType.INT.id());
			writeUnalignedLong(seg, 8, ((Number) value).longValue());
		} else if (value instanceof Float || value instanceof Double) {
			writeUnalignedInt(seg, 0, VariantType.FLOAT.id());
			writeUnalignedLong(seg, 8, Double.doubleToRawLongBits(((Number) value).doubleValue()));
		} else {
			Variant v = fromObject(value);
			Bridge.callVoid(org.godot.internal.api.ApiIndex.VARIANT_NEW_COPY, ret, v.getSegment());
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
		MemorySegment seg = variant.getSegment().reinterpret(80);
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
			// Variant OBJECT stores ObjectID, not a pointer. Resolve to actual pointer.
			MemorySegment objPtr = Bridge.callPtr(ApiIndex.OBJECT_GET_INSTANCE_FROM_ID, objectId);
			long ptr = objPtr.address();
			if (ptr == 0)
				return null;
			Object obj = org.godot.internal.ref.JavaObjectMap.get(ptr);
			if (obj != null)
				return obj;
			// Query Godot class name and create typed wrapper
			Godot typed = org.godot.internal.GodotClassRegistry.createTypedWrapper(ptr);
			if (typed != null) {
				org.godot.internal.ref.JavaObjectMap.put(ptr, typed);
				return typed;
			}
			return new org.godot.internal.ref.GenericGodotObject(ptr, "Object");
		}
		if (type == VariantType.RID.id())
			return seg.get(JAVA_LONG, 8);
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

	private static AABB readAABB(MemorySegment seg) {
		float px = Float.intBitsToFloat(seg.get(JAVA_INT, 8));
		float py = Float.intBitsToFloat(seg.get(JAVA_INT, 12));
		float pz = Float.intBitsToFloat(seg.get(JAVA_INT, 16));
		float sx = Float.intBitsToFloat(seg.get(JAVA_INT, 20));
		float sy = Float.intBitsToFloat(seg.get(JAVA_INT, 24));
		float sz = Float.intBitsToFloat(seg.get(JAVA_INT, 28));
		return new AABB(px, py, pz, sx, sy, sz);
	}

	private static Basis readBasis(MemorySegment seg) {
		double xx = Float.intBitsToFloat(seg.get(JAVA_INT, 8));
		double xy = Float.intBitsToFloat(seg.get(JAVA_INT, 12));
		double xz = Float.intBitsToFloat(seg.get(JAVA_INT, 16));
		double yx = Float.intBitsToFloat(seg.get(JAVA_INT, 20));
		double yy = Float.intBitsToFloat(seg.get(JAVA_INT, 24));
		double yz = Float.intBitsToFloat(seg.get(JAVA_INT, 28));
		double zx = Float.intBitsToFloat(seg.get(JAVA_INT, 32));
		double zy = Float.intBitsToFloat(seg.get(JAVA_INT, 36));
		double zz = Float.intBitsToFloat(seg.get(JAVA_INT, 40));
		return new Basis(xx, xy, xz, yx, yy, yz, zx, zy, zz);
	}

	private static Transform3D readTransform3D(MemorySegment seg) {
		double xx = Float.intBitsToFloat(seg.get(JAVA_INT, 8));
		double xy = Float.intBitsToFloat(seg.get(JAVA_INT, 12));
		double xz = Float.intBitsToFloat(seg.get(JAVA_INT, 16));
		double yx = Float.intBitsToFloat(seg.get(JAVA_INT, 20));
		double yy = Float.intBitsToFloat(seg.get(JAVA_INT, 24));
		double yz = Float.intBitsToFloat(seg.get(JAVA_INT, 28));
		double zx = Float.intBitsToFloat(seg.get(JAVA_INT, 32));
		double zy = Float.intBitsToFloat(seg.get(JAVA_INT, 36));
		double zz = Float.intBitsToFloat(seg.get(JAVA_INT, 40));
		float ox = Float.intBitsToFloat(seg.get(JAVA_INT, 44));
		float oy = Float.intBitsToFloat(seg.get(JAVA_INT, 48));
		float oz = Float.intBitsToFloat(seg.get(JAVA_INT, 52));
		return new Transform3D(new Basis(xx, xy, xz, yx, yy, yz, zx, zy, zz), new Vector3(ox, oy, oz));
	}

	private static Transform2D readTransform2D(MemorySegment seg) {
		float x0 = Float.intBitsToFloat(seg.get(JAVA_INT, 8));
		float y0 = Float.intBitsToFloat(seg.get(JAVA_INT, 12));
		float x1 = Float.intBitsToFloat(seg.get(JAVA_INT, 16));
		float y1 = Float.intBitsToFloat(seg.get(JAVA_INT, 20));
		float ox = Float.intBitsToFloat(seg.get(JAVA_INT, 24));
		float oy = Float.intBitsToFloat(seg.get(JAVA_INT, 28));
		return new Transform2D(new Vector2(x0, y0), new Vector2(x1, y1), new Vector2(ox, oy));
	}

	private static Projection readProjection(MemorySegment seg) {
		float[] m = new float[16];
		for (int i = 0; i < 16; i++) {
			m[i] = Float.intBitsToFloat(seg.get(JAVA_INT, 8 + i * 4));
		}
		return new Projection(new Vector4(m[0], m[1], m[2], m[3]), new Vector4(m[4], m[5], m[6], m[7]),
				new Vector4(m[8], m[9], m[10], m[11]), new Vector4(m[12], m[13], m[14], m[15]));
	}

	private static byte[] readPackedByteArray(MemorySegment variantSeg) {
		long arrayPtr = variantSeg.get(JAVA_LONG, 8);
		int size = (int) variantSeg.get(JAVA_LONG, 16);
		if (arrayPtr == 0 || size == 0)
			return new byte[0];
		MemorySegment arrSeg = MemorySegment.ofAddress(arrayPtr);
		byte[] result = new byte[size];
		for (int i = 0; i < size; i++) {
			result[i] = (byte) arrSeg.get(JAVA_INT, i);
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
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_FLOAT, 8, (float) t.x.x);
		seg.set(JAVA_FLOAT, 12, (float) t.x.y);
		seg.set(JAVA_FLOAT, 16, (float) t.y.x);
		seg.set(JAVA_FLOAT, 20, (float) t.y.y);
		seg.set(JAVA_FLOAT, 24, (float) t.origin.x);
		seg.set(JAVA_FLOAT, 28, (float) t.origin.y);
		seg.set(JAVA_INT, 0, VariantType.TRANSFORM2D.id());
		return new Variant(seg);
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
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_FLOAT, 8, (float) t.xx);
		seg.set(JAVA_FLOAT, 12, (float) t.xy);
		seg.set(JAVA_FLOAT, 16, (float) t.xz);
		seg.set(JAVA_FLOAT, 20, (float) t.yx);
		seg.set(JAVA_FLOAT, 24, (float) t.yy);
		seg.set(JAVA_FLOAT, 28, (float) t.yz);
		seg.set(JAVA_FLOAT, 32, (float) t.zx);
		seg.set(JAVA_FLOAT, 36, (float) t.zy);
		seg.set(JAVA_FLOAT, 40, (float) t.zz);
		seg.set(JAVA_FLOAT, 44, (float) t.ox);
		seg.set(JAVA_FLOAT, 48, (float) t.oy);
		seg.set(JAVA_FLOAT, 52, (float) t.oz);
		seg.set(JAVA_INT, 0, VariantType.TRANSFORM3D.id());
		return new Variant(seg);
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

	private static Variant fromAABB(AABB a) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_FLOAT, 8, (float) a.x);
		seg.set(JAVA_FLOAT, 12, (float) a.y);
		seg.set(JAVA_FLOAT, 16, (float) a.z);
		seg.set(JAVA_FLOAT, 20, (float) a.sizeX);
		seg.set(JAVA_FLOAT, 24, (float) a.sizeY);
		seg.set(JAVA_FLOAT, 28, (float) a.sizeZ);
		seg.set(JAVA_INT, 0, VariantType.AABB.id());
		return new Variant(seg);
	}

	private static Variant fromBasis(Basis b) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_FLOAT, 8, (float) b.xx);
		seg.set(JAVA_FLOAT, 12, (float) b.xy);
		seg.set(JAVA_FLOAT, 16, (float) b.xz);
		seg.set(JAVA_FLOAT, 20, (float) b.yx);
		seg.set(JAVA_FLOAT, 24, (float) b.yy);
		seg.set(JAVA_FLOAT, 28, (float) b.yz);
		seg.set(JAVA_FLOAT, 32, (float) b.zx);
		seg.set(JAVA_FLOAT, 36, (float) b.zy);
		seg.set(JAVA_FLOAT, 40, (float) b.zz);
		seg.set(JAVA_INT, 0, VariantType.BASIS.id());
		return new Variant(seg);
	}

	private static Variant fromProjection(Projection p) {
		MemorySegment seg = Bridge.allocVariant();
		seg.set(JAVA_FLOAT, 8, (float) p.x.x);
		seg.set(JAVA_FLOAT, 12, (float) p.x.y);
		seg.set(JAVA_FLOAT, 16, (float) p.x.z);
		seg.set(JAVA_FLOAT, 20, (float) p.x.w);
		seg.set(JAVA_FLOAT, 24, (float) p.y.x);
		seg.set(JAVA_FLOAT, 28, (float) p.y.y);
		seg.set(JAVA_FLOAT, 32, (float) p.y.z);
		seg.set(JAVA_FLOAT, 36, (float) p.y.w);
		seg.set(JAVA_FLOAT, 40, (float) p.z.x);
		seg.set(JAVA_FLOAT, 44, (float) p.z.y);
		seg.set(JAVA_FLOAT, 48, (float) p.z.z);
		seg.set(JAVA_FLOAT, 52, (float) p.z.w);
		seg.set(JAVA_FLOAT, 56, (float) p.w.x);
		seg.set(JAVA_FLOAT, 60, (float) p.w.y);
		seg.set(JAVA_FLOAT, 64, (float) p.w.z);
		seg.set(JAVA_FLOAT, 68, (float) p.w.w);
		seg.set(JAVA_INT, 0, VariantType.PROJECTION.id());
		return new Variant(seg);
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
