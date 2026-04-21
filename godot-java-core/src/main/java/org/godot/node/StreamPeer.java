package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.core.RefCounted;

public class StreamPeer extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_u64", 2455072627L), java.util.Map.entry("get_string", 2309358862L),
			java.util.Map.entry("put_data", 680677267L), java.util.Map.entry("put_partial_data", 2934048347L),
			java.util.Map.entry("put_var", 738511890L), java.util.Map.entry("set_big_endian", 2586408642L),
			java.util.Map.entry("put_32", 1286410249L), java.util.Map.entry("get_64", 2455072627L),
			java.util.Map.entry("put_16", 1286410249L), java.util.Map.entry("put_utf8_string", 83702148L),
			java.util.Map.entry("is_big_endian_enabled", 36873697L), java.util.Map.entry("put_u32", 1286410249L),
			java.util.Map.entry("get_8", 2455072627L), java.util.Map.entry("put_u8", 1286410249L),
			java.util.Map.entry("put_double", 373806689L), java.util.Map.entry("put_u16", 1286410249L),
			java.util.Map.entry("get_utf8_string", 2309358862L), java.util.Map.entry("get_32", 2455072627L),
			java.util.Map.entry("get_u32", 2455072627L), java.util.Map.entry("get_u8", 2455072627L),
			java.util.Map.entry("get_16", 2455072627L), java.util.Map.entry("get_double", 191475506L),
			java.util.Map.entry("put_8", 1286410249L), java.util.Map.entry("get_available_bytes", 3905245786L),
			java.util.Map.entry("put_64", 1286410249L), java.util.Map.entry("get_float", 191475506L),
			java.util.Map.entry("get_half", 191475506L), java.util.Map.entry("get_partial_data", 1171824711L),
			java.util.Map.entry("put_u64", 1286410249L), java.util.Map.entry("put_string", 83702148L),
			java.util.Map.entry("get_var", 3442865206L), java.util.Map.entry("put_float", 373806689L),
			java.util.Map.entry("get_data", 1171824711L), java.util.Map.entry("put_half", 373806689L),
			java.util.Map.entry("get_u16", 2455072627L));

	StreamPeer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StreamPeer(long nativePointer) {
		super(nativePointer);
	}

	public int put_data(byte[] data) {
		return (int) super.call("put_data", new java.lang.Object[]{(java.lang.Object) data});
	}

	public GodotArray put_partial_data(byte[] data) {
		return (GodotArray) super.call("put_partial_data", new java.lang.Object[]{(java.lang.Object) data});
	}

	public GodotArray get_data(long bytes) {
		return (GodotArray) super.call("get_data", new java.lang.Object[]{java.lang.Long.valueOf(bytes)});
	}

	public GodotArray get_partial_data(long bytes) {
		return (GodotArray) super.call("get_partial_data", new java.lang.Object[]{java.lang.Long.valueOf(bytes)});
	}

	public boolean is_big_endian_enabled() {
		return (boolean) super.call("is_big_endian_enabled");
	}

	public void put_8(long value) {
		super.call("put_8", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public void put_u8(long value) {
		super.call("put_u8", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public void put_16(long value) {
		super.call("put_16", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public void put_u16(long value) {
		super.call("put_u16", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public void put_32(long value) {
		super.call("put_32", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public void put_u32(long value) {
		super.call("put_u32", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public void put_64(long value) {
		super.call("put_64", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public void put_u64(long value) {
		super.call("put_u64", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public void put_half(double value) {
		super.call("put_half", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public void put_float(double value) {
		super.call("put_float", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public void put_double(double value) {
		super.call("put_double", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public void put_string(String value) {
		super.call("put_string", new java.lang.Object[]{(java.lang.Object) value});
	}

	public void put_utf8_string(String value) {
		super.call("put_utf8_string", new java.lang.Object[]{(java.lang.Object) value});
	}

	public void put_var(Object value, boolean full_objects) {
		super.call("put_var",
				new java.lang.Object[]{(java.lang.Object) value, java.lang.Boolean.valueOf(full_objects)});
	}

	public String get_string(long bytes) {
		return (String) super.call("get_string", new java.lang.Object[]{java.lang.Long.valueOf(bytes)});
	}

	public String get_utf8_string(long bytes) {
		return (String) super.call("get_utf8_string", new java.lang.Object[]{java.lang.Long.valueOf(bytes)});
	}

	public Object get_var(boolean allow_objects) {
		return (Object) super.call("get_var", new java.lang.Object[]{java.lang.Boolean.valueOf(allow_objects)});
	}

	public boolean isBig_endian() {
		return (boolean) super.call("is_big_endian_enabled", new java.lang.Object[0]);
	}

	public void setBig_endian(boolean value) {
		super.call("set_big_endian", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
