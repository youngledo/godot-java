package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AnimationRootNode extends AnimationNode {
	AnimationRootNode(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationRootNode(long nativePointer) {
		super(nativePointer);
	}
}
