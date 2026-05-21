package org.godot.collection;

import org.godot.internal.api.VariantType;
import java.lang.foreign.MemorySegment;

/// Godot PackedVector3Array — space-efficient array of Vector3 values.
public class GodotPackedVector3Array extends GodotPackedArray<double[]> {

	public GodotPackedVector3Array() {
		super(VariantType.PACKED_VECTOR3_ARRAY.id());
	}

	public GodotPackedVector3Array(long nativePtr) {
		super(nativePtr, VariantType.PACKED_VECTOR3_ARRAY.id());
	}

	public GodotPackedVector3Array(MemorySegment variantSeg) {
		super(variantSeg, VariantType.PACKED_VECTOR3_ARRAY.id());
	}

	public static GodotPackedVector3Array fromNative(long nativePtr) {
		if (nativePtr == 0)
			return null;
		return new GodotPackedVector3Array(nativePtr);
	}

	/// Get Vector3 at index as [x, y, z].
	public double[] get(int index) {
		if (nativePtr == 0)
			return null;
		Object result = callVariantMethodReturning("get", index);
		if (result instanceof org.godot.math.Vector3 v) {
			return new double[]{v.x, v.y, v.z};
		}
		return null;
	}

	public void set(int index, double x, double y, double z) {
		if (nativePtr == 0)
			return;
		callVariantMethod("set", index, new org.godot.math.Vector3(x, y, z));
	}

	public void pushBack(double x, double y, double z) {
		if (nativePtr == 0)
			return;
		callVariantMethod("push_back", new org.godot.math.Vector3(x, y, z));
	}

	public void insert(int index, double x, double y, double z) {
		if (nativePtr == 0)
			return;
		callVariantMethod("insert", index, new org.godot.math.Vector3(x, y, z));
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
			return new GodotPackedVector3Array();
		Object result = callVariantMethodReturning("slice", begin, end);
		if (result instanceof GodotPackedArray)
			return (GodotPackedArray<double[]>) result;
		return new GodotPackedVector3Array();
	}

	@Override
	public double[][] toJavaArray() {
		int len = size();
		if (len == 0)
			return new double[0][];
		double[][] arr = new double[len][3];
		for (int i = 0; i < len; i++) {
			double[] v = get(i);
			if (v != null) {
				arr[i][0] = v[0];
				arr[i][1] = v[1];
				arr[i][2] = v[2];
			}
		}
		return arr;
	}
}
