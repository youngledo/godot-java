package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Material extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("create_placeholder", 121922552L),
			java.util.Map.entry("set_render_priority", 1286410249L),
			java.util.Map.entry("inspect_native_shader_code", 3218959716L),
			java.util.Map.entry("get_render_priority", 3905245786L), java.util.Map.entry("set_next_pass", 2757459619L),
			java.util.Map.entry("get_next_pass", 5934680L));

	Material(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Material(long nativePointer) {
		super(nativePointer);
	}

	public void inspect_native_shader_code() {
		super.call("inspect_native_shader_code");
	}

	public Resource create_placeholder() {
		return (Resource) super.call("create_placeholder");
	}

	public long getRender_priority() {
		return (long) super.call("get_render_priority", new java.lang.Object[0]);
	}

	public void setRender_priority(long value) {
		super.call("set_render_priority", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Material getNext_pass() {
		return (Material) super.call("get_next_pass", new java.lang.Object[0]);
	}

	public void setNext_pass(Material value) {
		super.call("set_next_pass", new java.lang.Object[]{(java.lang.Object) value});
	}
}
