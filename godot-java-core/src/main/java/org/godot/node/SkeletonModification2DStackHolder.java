package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SkeletonModification2DStackHolder extends SkeletonModification2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_held_modification_stack", 3907307132L),
			java.util.Map.entry("get_held_modification_stack", 2107508396L));

	SkeletonModification2DStackHolder(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonModification2DStackHolder(long nativePointer) {
		super(nativePointer);
	}
}
