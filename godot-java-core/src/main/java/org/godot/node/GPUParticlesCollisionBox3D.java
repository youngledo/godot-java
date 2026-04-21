package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class GPUParticlesCollisionBox3D extends GPUParticlesCollision3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_size", 3460891852L), java.util.Map.entry("get_size", 3360562783L));

	GPUParticlesCollisionBox3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GPUParticlesCollisionBox3D(long nativePointer) {
		super(nativePointer);
	}

	public Vector3 getSize() {
		return (Vector3) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector3 value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}
}
