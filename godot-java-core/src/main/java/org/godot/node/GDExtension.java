package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class GDExtension extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_library_open", 36873697L),
			java.util.Map.entry("get_minimum_library_initialization_level", 964858755L));

	GDExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GDExtension(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_library_open() {
		return (boolean) super.call("is_library_open");
	}
}
