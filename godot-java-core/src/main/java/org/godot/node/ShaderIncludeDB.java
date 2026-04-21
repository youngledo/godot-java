package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class ShaderIncludeDB extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("list_built_in_include_files", 2981934095L),
			java.util.Map.entry("get_built_in_include_file", 1703090593L),
			java.util.Map.entry("has_built_in_include_file", 2323990056L));

	ShaderIncludeDB(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ShaderIncludeDB(long nativePointer) {
		super(nativePointer);
	}

	public String[] list_built_in_include_files() {
		return (String[]) super.call("list_built_in_include_files");
	}

	public boolean has_built_in_include_file(String filename) {
		return (boolean) super.call("has_built_in_include_file", new java.lang.Object[]{(java.lang.Object) filename});
	}

	public String get_built_in_include_file(String filename) {
		return (String) super.call("get_built_in_include_file", new java.lang.Object[]{(java.lang.Object) filename});
	}
}
