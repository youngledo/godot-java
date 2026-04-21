package org.godot.node;

import java.lang.foreign.MemorySegment;

public class SpringBoneCollisionPlane3D extends SpringBoneCollision3D {
	SpringBoneCollisionPlane3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SpringBoneCollisionPlane3D(long nativePointer) {
		super(nativePointer);
	}
}
