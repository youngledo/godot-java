package org.godot.collection;

import org.godot.internal.api.VariantType;
import java.lang.foreign.MemorySegment;

/// Godot PackedVector2Array — space-efficient array of Vector2 values.
public class GodotPackedVector2Array extends GodotPackedArray<double[]> {

	public GodotPackedVector2Array() {
		super(VariantType.PACKED_VECTOR2_ARRAY.id());
	}

	public GodotPackedVector2Array(long nativePtr) {
		super(nativePtr, VariantType.PACKED_VECTOR2_ARRAY.id());
	}

	public GodotPackedVector2Array(MemorySegment variantSeg) {
		super(variantSeg, VariantType.PACKED_VECTOR2_ARRAY.id());
	}

	public static GodotPackedVector2Array fromNative(long nativePtr) {
		if (nativePtr == 0)
			return null;
		return new GodotPackedVector2Array(nativePtr);
	}

	/// Get Vector2 at index as [x, y].
	public double[] get(int index) {
		if (nativePtr == 0)
			return null;
		Object result = callVariantMethodReturning("get", index);
		if (result instanceof org.godot.math.Vector2 v) {
			return new double[]{v.x, v.y};
		}
		return null;
	}

	public void set(int index, double x, double y) {
		if (nativePtr == 0)
			return;
		callVariantMethod("set", index, new org.godot.math.Vector2(x, y));
	}

	public void pushBack(double x, double y) {
		if (nativePtr == 0)
			return;
		callVariantMethod("push_back", new org.godot.math.Vector2(x, y));
	}

	public void insert(int index, double x, double y) {
		if (nativePtr == 0)
			return;
		callVariantMethod("insert", index, new org.godot.math.Vector2(x, y));
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
			return new GodotPackedVector2Array();
		Object result = callVariantMethodReturning("slice", begin, end);
		if (result instanceof GodotPackedArray)
			return (GodotPackedArray<double[]>) result;
		return new GodotPackedVector2Array();
	}

	@Override
	public double[][] toJavaArray() {
		int len = size();
		if (len == 0)
			return new double[0][];
		double[][] arr = new double[len][2];
		for (int i = 0; i < len; i++) {
			double[] v = get(i);
			if (v != null) {
				arr[i][0] = v[0];
				arr[i][1] = v[1];
			}
		}
		return arr;
	}
}
