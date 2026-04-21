package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRIPBinding extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_paths", 1139954409L), java.util.Map.entry("has_path", 3927539163L),
			java.util.Map.entry("set_paths", 4015028928L), java.util.Map.entry("get_action", 4072409085L),
			java.util.Map.entry("get_path_count", 3905245786L),
			java.util.Map.entry("set_binding_modifiers", 381264803L),
			java.util.Map.entry("get_binding_modifiers", 3995934104L), java.util.Map.entry("set_action", 349361333L),
			java.util.Map.entry("set_binding_path", 83702148L),
			java.util.Map.entry("get_binding_modifier", 3538296211L), java.util.Map.entry("add_path", 83702148L),
			java.util.Map.entry("get_binding_path", 201670096L),
			java.util.Map.entry("get_binding_modifier_count", 3905245786L),
			java.util.Map.entry("remove_path", 83702148L));

	OpenXRIPBinding(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRIPBinding(long nativePointer) {
		super(nativePointer);
	}

	public OpenXRActionBindingModifier get_binding_modifier(long index) {
		return (OpenXRActionBindingModifier) super.call("get_binding_modifier",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean has_path(String path) {
		return (boolean) super.call("has_path", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void add_path(String path) {
		super.call("add_path", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void remove_path(String path) {
		super.call("remove_path", new java.lang.Object[]{(java.lang.Object) path});
	}

	public OpenXRAction getAction() {
		return (OpenXRAction) super.call("get_action", new java.lang.Object[0]);
	}

	public void setAction(OpenXRAction value) {
		super.call("set_action", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getBinding_path() {
		return (String) super.call("get_binding_path", new java.lang.Object[0]);
	}

	public void setBinding_path(String value) {
		super.call("set_binding_path", new java.lang.Object[]{(java.lang.Object) value});
	}

	public OpenXRActionBindingModifier getBinding_modifiers() {
		return (OpenXRActionBindingModifier) super.call("get_binding_modifiers", new java.lang.Object[0]);
	}

	public void setBinding_modifiers(OpenXRActionBindingModifier value) {
		super.call("set_binding_modifiers", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String[] getPaths() {
		return (String[]) super.call("get_paths", new java.lang.Object[0]);
	}

	public void setPaths(String[] value) {
		super.call("set_paths", new java.lang.Object[]{(java.lang.Object) value});
	}
}
