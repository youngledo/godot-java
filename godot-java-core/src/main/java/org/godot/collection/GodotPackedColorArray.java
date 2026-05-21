package org.godot.collection;

import org.godot.internal.api.VariantType;
import java.lang.foreign.MemorySegment;

/// Godot PackedColorArray — space-efficient array of Color values.
public class GodotPackedColorArray extends GodotPackedArray<double[]> {

	public GodotPackedColorArray() {
		super(VariantType.PACKED_COLOR_ARRAY.id());
	}

	public GodotPackedColorArray(long nativePtr) {
		super(nativePtr, VariantType.PACKED_COLOR_ARRAY.id());
	}

	public GodotPackedColorArray(MemorySegment variantSeg) {
		super(variantSeg, VariantType.PACKED_COLOR_ARRAY.id());
	}

	public static GodotPackedColorArray fromNative(long nativePtr) {
		if (nativePtr == 0)
			return null;
		return new GodotPackedColorArray(nativePtr);
	}

	/// Get Color at index as [r, g, b, a].
	public double[] get(int index) {
		if (nativePtr == 0)
			return null;
		Object result = callVariantMethodReturning("get", index);
		if (result instanceof org.godot.math.Color c) {
			return new double[]{c.r, c.g, c.b, c.a};
		}
		return null;
	}

	public void set(int index, double r, double g, double b, double a) {
		if (nativePtr == 0)
			return;
		callVariantMethod("set", index, new org.godot.math.Color(r, g, b, a));
	}

	public void pushBack(double r, double g, double b, double a) {
		if (nativePtr == 0)
			return;
		callVariantMethod("push_back", new org.godot.math.Color(r, g, b, a));
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
			return new GodotPackedColorArray();
		Object result = callVariantMethodReturning("slice", begin, end);
		if (result instanceof GodotPackedArray)
			return (GodotPackedArray<double[]>) result;
		return new GodotPackedColorArray();
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
