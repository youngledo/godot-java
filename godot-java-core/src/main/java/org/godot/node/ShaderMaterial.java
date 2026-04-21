package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ShaderMaterial extends Material {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_shader_parameter", 2760726917L),
			java.util.Map.entry("set_shader_parameter", 3776071444L), java.util.Map.entry("get_shader", 2078273437L),
			java.util.Map.entry("set_shader", 3341921675L));

	ShaderMaterial(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ShaderMaterial(long nativePointer) {
		super(nativePointer);
	}

	public void set_shader_parameter(String param, Object value) {
		super.call("set_shader_parameter", new java.lang.Object[]{(java.lang.Object) param, (java.lang.Object) value});
	}

	public Object get_shader_parameter(String param) {
		return (Object) super.call("get_shader_parameter", new java.lang.Object[]{(java.lang.Object) param});
	}

	public Shader getShader() {
		return (Shader) super.call("get_shader", new java.lang.Object[0]);
	}

	public void setShader(Shader value) {
		super.call("set_shader", new java.lang.Object[]{(java.lang.Object) value});
	}
}
