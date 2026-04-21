package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;

public class Shader extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_mode", 3392948163L), java.util.Map.entry("set_code", 83702148L),
			java.util.Map.entry("get_shader_uniform_list", 1230511656L),
			java.util.Map.entry("inspect_native_shader_code", 3218959716L),
			java.util.Map.entry("set_default_texture_parameter", 3850209648L),
			java.util.Map.entry("get_default_texture_parameter", 4213877425L),
			java.util.Map.entry("get_code", 201670096L));

	Shader(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Shader(long nativePointer) {
		super(nativePointer);
	}

	public void set_default_texture_parameter(String name, Texture texture, long index) {
		super.call("set_default_texture_parameter", new java.lang.Object[]{(java.lang.Object) name,
				(java.lang.Object) texture, java.lang.Long.valueOf(index)});
	}

	public Texture get_default_texture_parameter(String name, long index) {
		return (Texture) super.call("get_default_texture_parameter",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Long.valueOf(index)});
	}

	public GodotArray get_shader_uniform_list(boolean get_groups) {
		return (GodotArray) super.call("get_shader_uniform_list",
				new java.lang.Object[]{java.lang.Boolean.valueOf(get_groups)});
	}

	public void inspect_native_shader_code() {
		super.call("inspect_native_shader_code");
	}

	public String getCode() {
		return (String) super.call("get_code", new java.lang.Object[0]);
	}

	public void setCode(String value) {
		super.call("set_code", new java.lang.Object[]{(java.lang.Object) value});
	}
}
