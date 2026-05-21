package org.godot.collection;

import org.godot.internal.api.VariantType;
import java.lang.foreign.MemorySegment;

/// Godot PackedStringArray — space-efficient array of strings.
public class GodotPackedStringArray extends GodotPackedArray<String> {

	public GodotPackedStringArray() {
		super(VariantType.PACKED_STRING_ARRAY.id());
	}

	public GodotPackedStringArray(long nativePtr) {
		super(nativePtr, VariantType.PACKED_STRING_ARRAY.id());
	}

	public GodotPackedStringArray(MemorySegment variantSeg) {
		super(variantSeg, VariantType.PACKED_STRING_ARRAY.id());
	}

	public static GodotPackedStringArray fromJavaArray(String[] data) {
		GodotPackedStringArray array = new GodotPackedStringArray();
		if (data != null && data.length > 0) {
			array.resize(data.length);
			for (int i = 0; i < data.length; i++) {
				array.set(i, data[i]);
			}
		}
		return array;
	}

	public static GodotPackedStringArray fromNative(long nativePtr) {
		if (nativePtr == 0)
			return null;
		return new GodotPackedStringArray(nativePtr);
	}

	public String get(int index) {
		if (nativePtr == 0)
			return null;
		Object result = callVariantMethodReturning("get", index);
		return result == null ? null : result.toString();
	}

	public void set(int index, String value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("set", index, value);
	}

	public void pushBack(String value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("push_back", value);
	}

	public void insert(int index, String value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("insert", index, value);
	}

	public void fill(String value) {
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
	public GodotPackedArray<String> subarray(int begin, int end) {
		if (nativePtr == 0)
			return new GodotPackedStringArray();
		Object result = callVariantMethodReturning("slice", begin, end);
		if (result instanceof GodotPackedArray)
			return (GodotPackedArray<String>) result;
		return new GodotPackedStringArray();
	}

	@Override
	public String[] toJavaArray() {
		int len = size();
		if (len == 0)
			return new String[0];
		String[] arr = new String[len];
		for (int i = 0; i < len; i++) {
			arr[i] = get(i);
		}
		return arr;
	}
}
