package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SubtweenTweener extends Tweener {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_delay", 449181780L));

	SubtweenTweener(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SubtweenTweener(long nativePointer) {
		super(nativePointer);
	}
}
