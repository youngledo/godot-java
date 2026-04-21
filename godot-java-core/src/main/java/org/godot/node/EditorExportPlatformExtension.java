package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class EditorExportPlatformExtension extends EditorExportPlatform {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_config_error", 201670096L), java.util.Map.entry("set_config_error", 3089850668L),
			java.util.Map.entry("get_config_missing_templates", 36873697L),
			java.util.Map.entry("set_config_missing_templates", 1695273946L));

	EditorExportPlatformExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorExportPlatformExtension(long nativePointer) {
		super(nativePointer);
	}
}
