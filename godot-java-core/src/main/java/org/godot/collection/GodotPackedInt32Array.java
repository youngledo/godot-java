package org.godot.collection;

import org.godot.internal.api.VariantType;
import java.lang.foreign.MemorySegment;

/// Godot PackedInt32Array — space-efficient array of 32-bit integers.
public class GodotPackedInt32Array extends GodotPackedArray<Integer> {

	public GodotPackedInt32Array() {
		super(VariantType.PACKED_INT32_ARRAY.id());
	}

	public GodotPackedInt32Array(long nativePtr) {
		super(nativePtr, VariantType.PACKED_INT32_ARRAY.id());
	}

	public GodotPackedInt32Array(MemorySegment variantSeg) {
		super(variantSeg, VariantType.PACKED_INT32_ARRAY.id());
	}

	public static GodotPackedInt32Array fromJavaArray(int[] data) {
		GodotPackedInt32Array array = new GodotPackedInt32Array();
		if (data != null && data.length > 0) {
			array.resize(data.length);
			for (int i = 0; i < data.length; i++) {
				array.set(i, data[i]);
			}
		}
		return array;
	}

	public static GodotPackedInt32Array fromNative(long nativePtr) {
		if (nativePtr == 0)
			return null;
		return new GodotPackedInt32Array(nativePtr);
	}

	public int get(int index) {
		if (nativePtr == 0)
			return 0;
		Object result = callVariantMethodReturning("get", index);
		return result == null ? 0 : ((Number) result).intValue();
	}

	public void set(int index, int value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("set", index, value);
	}

	public void pushBack(int value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("push_back", value);
	}

	public void insert(int index, int value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("insert", index, value);
	}

	public byte removeAt(int index) {
		if (nativePtr == 0)
			return 0;
		int prev = get(index);
		callVariantMethod("remove_at", index);
		return (byte) prev;
	}

	public void fill(int value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("fill", value);
	}

	/// Convert to PackedByteArray.
	public GodotPackedByteArray toByteArray() {
		if (nativePtr == 0)
			return new GodotPackedByteArray();
		Object result = callVariantMethodReturning("to_byte_array");
		if (result instanceof GodotPackedByteArray)
			return (GodotPackedByteArray) result;
		return new GodotPackedByteArray();
	}

	@Override
	public GodotPackedArray<Integer> subarray(int begin, int end) {
		if (nativePtr == 0)
			return new GodotPackedInt32Array();
		Object result = callVariantMethodReturning("slice", begin, end);
		if (result instanceof GodotPackedArray)
			return (GodotPackedArray<Integer>) result;
		return new GodotPackedInt32Array();
	}

	@Override
	public int[] toJavaArray() {
		int len = size();
		if (len == 0)
			return new int[0];
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = get(i);
		}
		return arr;
	}
}
