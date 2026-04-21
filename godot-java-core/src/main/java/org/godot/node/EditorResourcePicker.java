package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class EditorResourcePicker extends HBoxContainer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_base_type", 201670096L), java.util.Map.entry("set_toggle_pressed", 2586408642L),
			java.util.Map.entry("set_editable", 2586408642L), java.util.Map.entry("set_edited_resource", 968641751L),
			java.util.Map.entry("get_edited_resource", 2674603643L), java.util.Map.entry("is_toggle_mode", 36873697L),
			java.util.Map.entry("is_editable", 36873697L), java.util.Map.entry("set_base_type", 83702148L),
			java.util.Map.entry("set_toggle_mode", 2586408642L), java.util.Map.entry("get_allowed_types", 1139954409L));

	EditorResourcePicker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorResourcePicker(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_toggle_mode() {
		return (boolean) super.call("is_toggle_mode");
	}

	public boolean is_editable() {
		return (boolean) super.call("is_editable");
	}

	public String getBase_type() {
		return (String) super.call("get_base_type", new java.lang.Object[0]);
	}

	public void setBase_type(String value) {
		super.call("set_base_type", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Resource getEdited_resource() {
		return (Resource) super.call("get_edited_resource", new java.lang.Object[0]);
	}

	public void setEdited_resource(Resource value) {
		super.call("set_edited_resource", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isEditable() {
		return (boolean) super.call("is_editable", new java.lang.Object[0]);
	}

	public void setEditable(boolean value) {
		super.call("set_editable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isToggle_mode() {
		return (boolean) super.call("is_toggle_mode", new java.lang.Object[0]);
	}

	public void setToggle_mode(boolean value) {
		super.call("set_toggle_mode", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
