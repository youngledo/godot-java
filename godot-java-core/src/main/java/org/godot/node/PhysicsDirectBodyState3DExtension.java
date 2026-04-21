package org.godot.node;

import java.lang.foreign.MemorySegment;

public class PhysicsDirectBodyState3DExtension extends PhysicsDirectBodyState3D {
	PhysicsDirectBodyState3DExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsDirectBodyState3DExtension(long nativePointer) {
		super(nativePointer);
	}
}
