package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class MultiMeshInstance2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_multimesh", 2246127404L), java.util.Map.entry("get_multimesh", 1385450523L),
			java.util.Map.entry("set_texture", 4051416890L), java.util.Map.entry("get_texture", 3635182373L));

	MultiMeshInstance2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MultiMeshInstance2D(long nativePointer) {
		super(nativePointer);
	}

	public MultiMesh getMultimesh() {
		return (MultiMesh) super.call("get_multimesh", new java.lang.Object[0]);
	}

	public void setMultimesh(MultiMesh value) {
		super.call("set_multimesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getTexture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}
}
