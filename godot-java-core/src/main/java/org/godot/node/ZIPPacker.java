package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class ZIPPacker extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("write_file", 680677267L), java.util.Map.entry("set_compression_level", 1286410249L),
			java.util.Map.entry("get_compression_level", 3905245786L), java.util.Map.entry("close_file", 166280745L),
			java.util.Map.entry("start_file", 166001499L), java.util.Map.entry("close", 166280745L),
			java.util.Map.entry("open", 1936816515L));

	ZIPPacker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ZIPPacker(long nativePointer) {
		super(nativePointer);
	}

	public int open(String path, int append) {
		return (int) super.call("open",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Integer.valueOf(append)});
	}

	public int start_file(String path) {
		return (int) super.call("start_file", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int write_file(byte[] data) {
		return (int) super.call("write_file", new java.lang.Object[]{(java.lang.Object) data});
	}

	public int close_file() {
		return (int) super.call("close_file");
	}

	public int close() {
		return (int) super.call("close");
	}

	public long getCompression_level() {
		return (long) super.call("get_compression_level", new java.lang.Object[0]);
	}

	public void setCompression_level(long value) {
		super.call("set_compression_level", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
