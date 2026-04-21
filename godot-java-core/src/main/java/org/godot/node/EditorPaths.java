package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class EditorPaths extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_self_contained", 36873697L), java.util.Map.entry("get_cache_dir", 201670096L),
			java.util.Map.entry("get_self_contained_file", 201670096L),
			java.util.Map.entry("get_project_settings_dir", 201670096L),
			java.util.Map.entry("get_config_dir", 201670096L), java.util.Map.entry("get_data_dir", 201670096L));

	EditorPaths(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorPaths(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_self_contained() {
		return (boolean) super.call("is_self_contained");
	}
}
