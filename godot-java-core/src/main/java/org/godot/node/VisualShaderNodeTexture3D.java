package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeTexture3D extends VisualShaderNodeSample3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_texture", 1188404210L), java.util.Map.entry("get_texture", 373985333L));

	VisualShaderNodeTexture3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeTexture3D(long nativePointer) {
		super(nativePointer);
	}

	public Texture3D getTexture() {
		return (Texture3D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture3D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}
}
