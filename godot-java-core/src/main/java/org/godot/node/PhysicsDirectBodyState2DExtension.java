package org.godot.node;

import java.lang.foreign.MemorySegment;

public class PhysicsDirectBodyState2DExtension extends PhysicsDirectBodyState2D {
	PhysicsDirectBodyState2DExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsDirectBodyState2DExtension(long nativePointer) {
		super(nativePointer);
	}
}
