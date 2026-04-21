package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class ZIPReader extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_files", 2981934095L), java.util.Map.entry("file_exists", 35364943L),
			java.util.Map.entry("get_compression_level", 3694577386L), java.util.Map.entry("close", 166280745L),
			java.util.Map.entry("open", 166001499L), java.util.Map.entry("read_file", 740857591L));

	ZIPReader(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ZIPReader(long nativePointer) {
		super(nativePointer);
	}

	public int open(String path) {
		return (int) super.call("open", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int close() {
		return (int) super.call("close");
	}

	public byte[] read_file(String path, boolean case_sensitive) {
		return (byte[]) super.call("read_file",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Boolean.valueOf(case_sensitive)});
	}

	public boolean file_exists(String path, boolean case_sensitive) {
		return (boolean) super.call("file_exists",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Boolean.valueOf(case_sensitive)});
	}

	public int get_compression_level(String path, boolean case_sensitive) {
		return (int) super.call("get_compression_level",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Boolean.valueOf(case_sensitive)});
	}
}
