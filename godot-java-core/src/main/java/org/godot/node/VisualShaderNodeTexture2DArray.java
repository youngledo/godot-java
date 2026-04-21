package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeTexture2DArray extends VisualShaderNodeSample3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_texture_array", 3984243839L),
			java.util.Map.entry("set_texture_array", 1278366092L));

	VisualShaderNodeTexture2DArray(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeTexture2DArray(long nativePointer) {
		super(nativePointer);
	}

	public Object getTexture_array() {
		return (Object) super.call("get_texture_array", new java.lang.Object[0]);
	}

	public void setTexture_array(Object value) {
		super.call("set_texture_array", new java.lang.Object[]{(java.lang.Object) value});
	}
}
