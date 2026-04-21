package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class Tweener extends RefCounted {
	Tweener(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Tweener(long nativePointer) {
		super(nativePointer);
	}
}
