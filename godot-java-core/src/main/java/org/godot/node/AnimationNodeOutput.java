package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AnimationNodeOutput extends AnimationNode {
	AnimationNodeOutput(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeOutput(long nativePointer) {
		super(nativePointer);
	}
}
