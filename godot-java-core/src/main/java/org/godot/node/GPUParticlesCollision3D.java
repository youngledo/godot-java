package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class GPUParticlesCollision3D extends VisualInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_cull_mask", 1286410249L), java.util.Map.entry("get_cull_mask", 3905245786L));

	GPUParticlesCollision3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GPUParticlesCollision3D(long nativePointer) {
		super(nativePointer);
	}

	public long getCull_mask() {
		return (long) super.call("get_cull_mask", new java.lang.Object[0]);
	}

	public void setCull_mask(long value) {
		super.call("set_cull_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
