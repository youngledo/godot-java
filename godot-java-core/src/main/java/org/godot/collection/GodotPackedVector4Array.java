package org.godot.collection;

import org.godot.internal.api.VariantType;
import java.lang.foreign.MemorySegment;

/// Godot PackedVector4Array — space-efficient array of Vector4 values (API 4.3+).
public class GodotPackedVector4Array extends GodotPackedArray<double[]> {

	public GodotPackedVector4Array() {
		super(VariantType.PACKED_VECTOR4_ARRAY.id());
	}

	public GodotPackedVector4Array(long nativePtr) {
		super(nativePtr, VariantType.PACKED_VECTOR4_ARRAY.id());
	}

	public GodotPackedVector4Array(MemorySegment variantSeg) {
		super(variantSeg, VariantType.PACKED_VECTOR4_ARRAY.id());
	}

	public static GodotPackedVector4Array fromNative(long nativePtr) {
		if (nativePtr == 0)
			return null;
		return new GodotPackedVector4Array(nativePtr);
	}

	/// Get Vector4 at index as [x, y, z, w].
	public double[] get(int index) {
		if (nativePtr == 0)
			return null;
		Object result = callVariantMethodReturning("get", index);
		if (result instanceof org.godot.math.Vector4 v) {
			return new double[]{v.x, v.y, v.z, v.w};
		}
		return null;
	}

	public void set(int index, double x, double y, double z, double w) {
		if (nativePtr == 0)
			return;
		callVariantMethod("set", index, new org.godot.math.Vector4(x, y, z, w));
	}

	public void pushBack(double x, double y, double z, double w) {
		if (nativePtr == 0)
			return;
		callVariantMethod("push_back", new org.godot.math.Vector4(x, y, z, w));
	}

	public GodotPackedByteArray toByteArray() {
		if (nativePtr == 0)
			return new GodotPackedByteArray();
		Object result = callVariantMethodReturning("to_byte_array");
		if (result instanceof GodotPackedByteArray)
			return (GodotPackedByteArray) result;
		return new GodotPackedByteArray();
	}

	@Override
	public GodotPackedArray<double[]> subarray(int begin, int end) {
		if (nativePtr == 0)
			return new GodotPackedVector4Array();
		Object result = callVariantMethodReturning("slice", begin, end);
		if (result instanceof GodotPackedArray)
			return (GodotPackedArray<double[]>) result;
		return new GodotPackedVector4Array();
	}

	@Override
	public double[][] toJavaArray() {
		int len = size();
		if (len == 0)
			return new double[0][];
		double[][] arr = new double[len][4];
		for (int i = 0; i < len; i++) {
			double[] v = get(i);
			if (v != null) {
				arr[i][0] = v[0];
				arr[i][1] = v[1];
				arr[i][2] = v[2];
				arr[i][3] = v[3];
			}
		}
		return arr;
	}
}
