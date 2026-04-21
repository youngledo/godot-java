package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class GPUParticlesAttractorVectorField3D extends GPUParticlesAttractor3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_size", 3460891852L), java.util.Map.entry("get_size", 3360562783L),
			java.util.Map.entry("set_texture", 1188404210L), java.util.Map.entry("get_texture", 373985333L));

	GPUParticlesAttractorVectorField3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GPUParticlesAttractorVectorField3D(long nativePointer) {
		super(nativePointer);
	}

	public Vector3 getSize() {
		return (Vector3) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector3 value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture3D getTexture() {
		return (Texture3D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture3D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}
}
