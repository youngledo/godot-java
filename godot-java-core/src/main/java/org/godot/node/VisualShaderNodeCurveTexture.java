package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeCurveTexture extends VisualShaderNodeResizableBase {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_texture", 181872837L), java.util.Map.entry("get_texture", 2800800579L));

	VisualShaderNodeCurveTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeCurveTexture(long nativePointer) {
		super(nativePointer);
	}

	public CurveTexture getTexture() {
		return (CurveTexture) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(CurveTexture value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}
}
