package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class OpenXRSpatialComponentData extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_capacity", 1286410249L));

	OpenXRSpatialComponentData(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialComponentData(long nativePointer) {
		super(nativePointer);
	}
}
