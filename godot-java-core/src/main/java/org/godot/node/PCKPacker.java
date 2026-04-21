package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class PCKPacker extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("flush", 1633102583L), java.util.Map.entry("add_file_removal", 166001499L),
			java.util.Map.entry("add_file", 2215643711L), java.util.Map.entry("pck_start", 508410629L));

	PCKPacker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PCKPacker(long nativePointer) {
		super(nativePointer);
	}

	public int pck_start(String pck_path, long alignment, String key, boolean encrypt_directory) {
		return (int) super.call("pck_start",
				new java.lang.Object[]{(java.lang.Object) pck_path, java.lang.Long.valueOf(alignment),
						(java.lang.Object) key, java.lang.Boolean.valueOf(encrypt_directory)});
	}

	public int add_file(String target_path, String source_path, boolean encrypt) {
		return (int) super.call("add_file", new java.lang.Object[]{(java.lang.Object) target_path,
				(java.lang.Object) source_path, java.lang.Boolean.valueOf(encrypt)});
	}

	public int add_file_removal(String target_path) {
		return (int) super.call("add_file_removal", new java.lang.Object[]{(java.lang.Object) target_path});
	}

	public int flush(boolean verbose) {
		return (int) super.call("flush", new java.lang.Object[]{java.lang.Boolean.valueOf(verbose)});
	}
}
