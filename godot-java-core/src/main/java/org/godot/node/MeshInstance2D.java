package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class MeshInstance2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_mesh", 194775623L), java.util.Map.entry("get_mesh", 1808005922L),
			java.util.Map.entry("set_texture", 4051416890L), java.util.Map.entry("get_texture", 3635182373L));

	MeshInstance2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MeshInstance2D(long nativePointer) {
		super(nativePointer);
	}

	public Mesh getMesh() {
		return (Mesh) super.call("get_mesh", new java.lang.Object[0]);
	}

	public void setMesh(Mesh value) {
		super.call("set_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getTexture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}
}
