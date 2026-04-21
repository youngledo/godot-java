package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class MethodTweener extends Tweener {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_trans", 3740975367L), java.util.Map.entry("set_delay", 266477812L),
			java.util.Map.entry("set_ease", 315540545L));

	MethodTweener(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MethodTweener(long nativePointer) {
		super(nativePointer);
	}
}
