package org.godot.node;

import java.lang.foreign.MemorySegment;

public class IntervalTweener extends Tweener {
	IntervalTweener(MemorySegment nativePointer) {
		super(nativePointer);
	}

	IntervalTweener(long nativePointer) {
		super(nativePointer);
	}
}
