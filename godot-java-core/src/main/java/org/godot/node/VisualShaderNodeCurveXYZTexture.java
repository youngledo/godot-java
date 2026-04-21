package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeCurveXYZTexture extends VisualShaderNodeResizableBase {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_texture", 8031783L), java.util.Map.entry("get_texture", 1950275015L));

	VisualShaderNodeCurveXYZTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeCurveXYZTexture(long nativePointer) {
		super(nativePointer);
	}

	public CurveXYZTexture getTexture() {
		return (CurveXYZTexture) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(CurveXYZTexture value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}
}
