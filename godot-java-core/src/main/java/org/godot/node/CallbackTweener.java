package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CallbackTweener extends Tweener {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_delay", 3008182292L));

	CallbackTweener(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CallbackTweener(long nativePointer) {
		super(nativePointer);
	}
}
