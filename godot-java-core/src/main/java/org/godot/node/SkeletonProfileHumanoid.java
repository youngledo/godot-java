package org.godot.node;

import java.lang.foreign.MemorySegment;

public class SkeletonProfileHumanoid extends SkeletonProfile {
	SkeletonProfileHumanoid(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonProfileHumanoid(long nativePointer) {
		super(nativePointer);
	}
}
