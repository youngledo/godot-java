package org.godot.collection;

import org.godot.internal.api.VariantType;
import java.lang.foreign.MemorySegment;

/// Godot PackedInt64Array — space-efficient array of 64-bit integers.
public class GodotPackedInt64Array extends GodotPackedArray<Long> {

	public GodotPackedInt64Array() {
		super(VariantType.PACKED_INT64_ARRAY.id());
	}

	public GodotPackedInt64Array(long nativePtr) {
		super(nativePtr, VariantType.PACKED_INT64_ARRAY.id());
	}

	public GodotPackedInt64Array(MemorySegment variantSeg) {
		super(variantSeg, VariantType.PACKED_INT64_ARRAY.id());
	}

	public static GodotPackedInt64Array fromJavaArray(long[] data) {
		GodotPackedInt64Array array = new GodotPackedInt64Array();
		if (data != null && data.length > 0) {
			array.resize(data.length);
			for (int i = 0; i < data.length; i++) {
				array.set(i, data[i]);
			}
		}
		return array;
	}

	public static GodotPackedInt64Array fromNative(long nativePtr) {
		if (nativePtr == 0)
			return null;
		return new GodotPackedInt64Array(nativePtr);
	}

	public long get(int index) {
		if (nativePtr == 0)
			return 0L;
		Object result = callVariantMethodReturning("get", index);
		return result == null ? 0L : ((Number) result).longValue();
	}

	public void set(int index, long value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("set", index, value);
	}

	public void pushBack(long value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("push_back", value);
	}

	public void insert(int index, long value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("insert", index, value);
	}

	public void fill(long value) {
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
	public GodotPackedArray<Long> subarray(int begin, int end) {
		if (nativePtr == 0)
			return new GodotPackedInt64Array();
		Object result = callVariantMethodReturning("slice", begin, end);
		if (result instanceof GodotPackedArray)
			return (GodotPackedArray<Long>) result;
		return new GodotPackedInt64Array();
	}

	@Override
	public long[] toJavaArray() {
		int len = size();
		if (len == 0)
			return new long[0];
		long[] arr = new long[len];
		for (int i = 0; i < len; i++) {
			arr[i] = get(i);
		}
		return arr;
	}
}
