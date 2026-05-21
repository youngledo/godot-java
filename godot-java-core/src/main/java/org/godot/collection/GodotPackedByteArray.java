package org.godot.collection;

import org.godot.internal.api.VariantType;
import java.lang.foreign.MemorySegment;

/**
 * Godot PackedByteArray — space-efficient byte buffer with engine methods.
 *
 * Wraps the Godot native PackedArray&lt;u8&gt; type. Use
 * {@link #fromJavaArray(byte[])} to create from Java data, or
 * {@link #toJavaArray()} to extract bytes.
 */
public class GodotPackedByteArray extends GodotPackedArray<Byte> {

	public GodotPackedByteArray() {
		super(VariantType.PACKED_BYTE_ARRAY.id());
	}

	public GodotPackedByteArray(long nativePtr) {
		super(nativePtr, VariantType.PACKED_BYTE_ARRAY.id());
	}

	public GodotPackedByteArray(MemorySegment variantSeg) {
		super(variantSeg, VariantType.PACKED_BYTE_ARRAY.id());
	}

	/// Create from a Java byte array.
	public static GodotPackedByteArray fromJavaArray(byte[] data) {
		GodotPackedByteArray array = new GodotPackedByteArray();
		if (data != null && data.length > 0) {
			array.resize(data.length);
			for (int i = 0; i < data.length; i++) {
				array.set(i, data[i]);
			}
		}
		return array;
	}

	/// Create from native pointer (returns null if ptr is 0).
	public static GodotPackedByteArray fromNative(long nativePtr) {
		if (nativePtr == 0)
			return null;
		return new GodotPackedByteArray(nativePtr);
	}

	/// Get byte at index.
	public byte get(int index) {
		if (nativePtr == 0)
			return 0;
		Object result = callVariantMethodReturning("get", index);
		return result == null ? 0 : ((Number) result).byteValue();
	}

	/// Set byte at index.
	public void set(int index, byte value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("set", index, (int) value);
	}

	/// Push a byte to the end.
	public void pushBack(byte value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("push_back", (int) value);
	}

	/// Insert a byte at the given index.
	public void insert(int index, byte value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("insert", index, (int) value);
	}

	/// Remove and return the byte at the given index.
	public byte removeAt(int index) {
		if (nativePtr == 0)
			return 0;
		byte prev = get(index);
		callVariantMethod("remove_at", index);
		return prev;
	}

	/// Fill all elements with the given value.
	public void fill(byte value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("fill", (int) value);
	}

	/// Encode a double value at the given byte offset (8 bytes, little-endian).
	public void encodeDouble(int byteOffset, double value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("encode_double", byteOffset, value);
	}

	/// Decode a double value from the given byte offset.
	public double decodeDouble(int byteOffset) {
		if (nativePtr == 0)
			return 0.0;
		Object result = callVariantMethodReturning("decode_double", byteOffset);
		return result == null ? 0.0 : ((Number) result).doubleValue();
	}

	/// Encode a float value at the given byte offset (4 bytes).
	public void encodeFloat(int byteOffset, float value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("encode_float", byteOffset, (double) value);
	}

	/// Decode a float value from the given byte offset.
	public float decodeFloat(int byteOffset) {
		if (nativePtr == 0)
			return 0f;
		Object result = callVariantMethodReturning("decode_float", byteOffset);
		return result == null ? 0f : ((Number) result).floatValue();
	}

	/// Encode a 32-bit int at the given byte offset.
	public void encodeS32(int byteOffset, int value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("encode_s32", byteOffset, value);
	}

	/// Decode a 32-bit int from the given byte offset.
	public int decodeS32(int byteOffset) {
		if (nativePtr == 0)
			return 0;
		Object result = callVariantMethodReturning("decode_s32", byteOffset);
		return result == null ? 0 : ((Number) result).intValue();
	}

	/// Encode a 64-bit int at the given byte offset.
	public void encodeS64(int byteOffset, long value) {
		if (nativePtr == 0)
			return;
		callVariantMethod("encode_s64", byteOffset, value);
	}

	/// Decode a 64-bit int from the given byte offset.
	public long decodeS64(int byteOffset) {
		if (nativePtr == 0)
			return 0L;
		Object result = callVariantMethodReturning("decode_s64", byteOffset);
		return result == null ? 0L : ((Number) result).longValue();
	}

	/// Compress the data using the given compression mode (0=fastlz, 1=deflate, 2=zstd, 3=gzip).
	public GodotPackedByteArray compress(int compressionMode) {
		if (nativePtr == 0)
			return new GodotPackedByteArray();
		Object result = callVariantMethodReturning("compress", compressionMode);
		if (result instanceof GodotPackedByteArray)
			return (GodotPackedByteArray) result;
		if (result instanceof byte[])
			return fromJavaArray((byte[]) result);
		return new GodotPackedByteArray();
	}

	/// Decompress the data with a known buffer size.
	public GodotPackedByteArray decompress(int bufferSize, int compressionMode) {
		if (nativePtr == 0)
			return new GodotPackedByteArray();
		Object result = callVariantMethodReturning("decompress", bufferSize, compressionMode);
		if (result instanceof GodotPackedByteArray)
			return (GodotPackedByteArray) result;
		if (result instanceof byte[])
			return fromJavaArray((byte[]) result);
		return new GodotPackedByteArray();
	}

	/// Convert to PackedFloat32Array (every 4 bytes -> one float).
	public GodotPackedArray<?> toFloat32Array() {
		if (nativePtr == 0)
			return new GodotPackedFloat32Array();
		Object result = callVariantMethodReturning("to_float32_array");
		return result instanceof GodotPackedArray ? (GodotPackedArray<?>) result : new GodotPackedFloat32Array();
	}

	/// Convert to PackedFloat64Array (every 8 bytes -> one double).
	public GodotPackedArray<?> toFloat64Array() {
		if (nativePtr == 0)
			return new GodotPackedFloat64Array();
		Object result = callVariantMethodReturning("to_float64_array");
		return result instanceof GodotPackedArray ? (GodotPackedArray<?>) result : new GodotPackedFloat64Array();
	}

	/// Convert to PackedInt32Array (every 4 bytes -> one int).
	public GodotPackedArray<?> toInt32Array() {
		if (nativePtr == 0)
			return new GodotPackedInt32Array();
		Object result = callVariantMethodReturning("to_int32_array");
		return result instanceof GodotPackedArray ? (GodotPackedArray<?>) result : new GodotPackedInt32Array();
	}

	/// Convert to PackedInt64Array (every 8 bytes -> one long).
	public GodotPackedArray<?> toInt64Array() {
		if (nativePtr == 0)
			return new GodotPackedInt64Array();
		Object result = callVariantMethodReturning("to_int64_array");
		return result instanceof GodotPackedArray ? (GodotPackedArray<?>) result : new GodotPackedInt64Array();
	}

	@Override
	public GodotPackedArray<Byte> subarray(int begin, int end) {
		if (nativePtr == 0)
			return new GodotPackedByteArray();
		Object result = callVariantMethodReturning("slice", begin, end);
		if (result instanceof GodotPackedArray)
			return (GodotPackedArray<Byte>) result;
		return new GodotPackedByteArray();
	}

	@Override
	public byte[] toJavaArray() {
		int len = size();
		if (len == 0)
			return new byte[0];
		byte[] arr = new byte[len];
		for (int i = 0; i < len; i++) {
			arr[i] = get(i);
		}
		return arr;
	}
}
