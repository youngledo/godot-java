package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeCubemap extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_source", 2222048781L), java.util.Map.entry("set_texture_type", 1899718876L),
			java.util.Map.entry("get_texture_type", 3356498888L), java.util.Map.entry("set_cube_map", 1278366092L),
			java.util.Map.entry("set_source", 1625400621L), java.util.Map.entry("get_cube_map", 3984243839L));

	VisualShaderNodeCubemap(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeCubemap(long nativePointer) {
		super(nativePointer);
	}

	public long getSource() {
		return (long) super.call("get_source", new java.lang.Object[0]);
	}

	public void setSource(long value) {
		super.call("set_source", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Object getCube_map() {
		return (Object) super.call("get_cube_map", new java.lang.Object[0]);
	}

	public void setCube_map(Object value) {
		super.call("set_cube_map", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getTexture_type() {
		return (long) super.call("get_texture_type", new java.lang.Object[0]);
	}

	public void setTexture_type(long value) {
		super.call("set_texture_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
