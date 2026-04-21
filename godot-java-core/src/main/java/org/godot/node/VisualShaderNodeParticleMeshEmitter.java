package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeParticleMeshEmitter extends VisualShaderNodeParticleEmitter {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_surface_index", 3905245786L),
			java.util.Map.entry("set_use_all_surfaces", 2586408642L), java.util.Map.entry("set_mesh", 194775623L),
			java.util.Map.entry("get_mesh", 1808005922L), java.util.Map.entry("set_surface_index", 1286410249L),
			java.util.Map.entry("is_use_all_surfaces", 36873697L));

	VisualShaderNodeParticleMeshEmitter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeParticleMeshEmitter(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_use_all_surfaces() {
		return (boolean) super.call("is_use_all_surfaces");
	}

	public Mesh getMesh() {
		return (Mesh) super.call("get_mesh", new java.lang.Object[0]);
	}

	public void setMesh(Mesh value) {
		super.call("set_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isUse_all_surfaces() {
		return (boolean) super.call("is_use_all_surfaces", new java.lang.Object[0]);
	}

	public void setUse_all_surfaces(boolean value) {
		super.call("set_use_all_surfaces", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSurface_index() {
		return (long) super.call("get_surface_index", new java.lang.Object[0]);
	}

	public void setSurface_index(long value) {
		super.call("set_surface_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
