package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Occluder3D extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_indices", 1930428628L), java.util.Map.entry("get_vertices", 497664490L));

	Occluder3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Occluder3D(long nativePointer) {
		super(nativePointer);
	}
}
