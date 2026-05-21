package org.godot.collection;

import org.godot.internal.api.VariantType;
import java.lang.foreign.MemorySegment;

/// Godot PackedFloat64Array — space-efficient array of 64-bit doubles.
public class GodotPackedFloat64Array extends GodotPackedArray<Double> {

	public GodotPackedFloat64Array() {
		super(VariantType.PACKED_FLOAT64_ARRAY.id());
	}

	public GodotPackedFloat64Array(long nativePtr) {
		super(nativePtr, VariantType.PACKED_FLOAT64_ARRAY.id());
	}

	public GodotPackedFloat64Array(MemorySegment variantSeg) {
		super(variantSeg, VariantType.PACKED_FLOAT64_ARRAY.id());
	}

	public static GodotPackedFloat64Array fromJavaArray(double[] data) {
		GodotPackedFloat64Array array = new GodotPackedFloat64Array();
		if (data != null && data.length > 0) {
			array.resize(data.length);
			for (int i = 0; i < data.length; i++) {
				array.set(i, data[i]);
			}
		}
		return array;
	}

	public static GodotPackedFloat64Array fromNative(long nativePtr) {
		if (nativePtr == 0)
			return null;
		return new GodotPackedFloat64Array(nativePtr);
	}

	public double get(int index) {
		if (nativePtr == 0)
			return 0.0;
		Object result = callVariantMethodReturning("get", index);
		return result == null ? 0.0 : ((Number) result).doubleValue();
	}

	public void set(int index, double value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("set", index, value);
	}

	public void pushBack(double value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("push_back", value);
	}

	public void insert(int index, double value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("insert", index, value);
	}

	public void fill(double value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("fill", value);
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
	public GodotPackedArray<Double> subarray(int begin, int end) {
		if (nativePtr == 0)
			return new GodotPackedFloat64Array();
		Object result = callVariantMethodReturning("slice", begin, end);
		if (result instanceof GodotPackedArray)
			return (GodotPackedArray<Double>) result;
		return new GodotPackedFloat64Array();
	}

	@Override
	public double[] toJavaArray() {
		int len = size();
		if (len == 0)
			return new double[0];
		double[] arr = new double[len];
		for (int i = 0; i < len; i++) {
			arr[i] = get(i);
		}
		return arr;
	}
}
