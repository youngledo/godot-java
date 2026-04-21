package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;

public class EditorSettings extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("has_shortcut", 3927539163L), java.util.Map.entry("has_setting", 3927539163L),
			java.util.Map.entry("erase", 83702148L), java.util.Map.entry("set_builtin_action_override", 1209351045L),
			java.util.Map.entry("remove_shortcut", 83702148L),
			java.util.Map.entry("check_changed_settings_in_group", 3927539163L),
			java.util.Map.entry("get_setting", 1868160156L), java.util.Map.entry("add_property_info", 4155329257L),
			java.util.Map.entry("get_favorites", 1139954409L), java.util.Map.entry("set_recent_dirs", 4015028928L),
			java.util.Map.entry("mark_setting_changed", 83702148L),
			java.util.Map.entry("set_project_metadata", 2504492430L),
			java.util.Map.entry("get_changed_settings", 1139954409L), java.util.Map.entry("set_favorites", 4015028928L),
			java.util.Map.entry("get_project_metadata", 89809366L),
			java.util.Map.entry("set_initial_value", 1529169264L), java.util.Map.entry("add_shortcut", 4124020929L),
			java.util.Map.entry("set_setting", 402577236L), java.util.Map.entry("get_shortcut", 1149070301L),
			java.util.Map.entry("get_recent_dirs", 1139954409L), java.util.Map.entry("is_shortcut", 699917945L),
			java.util.Map.entry("get_shortcut_list", 2981934095L));

	EditorSettings(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorSettings(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_setting(String name) {
		return (boolean) super.call("has_setting", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void set_setting(String name, Object value) {
		super.call("set_setting", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) value});
	}

	public Object get_setting(String name) {
		return (Object) super.call("get_setting", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void erase(String property) {
		super.call("erase", new java.lang.Object[]{(java.lang.Object) property});
	}

	public void set_initial_value(String name, Object value, boolean update_current) {
		super.call("set_initial_value", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) value,
				java.lang.Boolean.valueOf(update_current)});
	}

	public void add_property_info(GodotDictionary info) {
		super.call("add_property_info", new java.lang.Object[]{(java.lang.Object) info});
	}

	public void set_project_metadata(String section, String key, Object data) {
		super.call("set_project_metadata",
				new java.lang.Object[]{(java.lang.Object) section, (java.lang.Object) key, (java.lang.Object) data});
	}

	public Object get_project_metadata(String section, String key, Object default_) {
		return (Object) super.call("get_project_metadata", new java.lang.Object[]{(java.lang.Object) section,
				(java.lang.Object) key, (java.lang.Object) default_});
	}

	public void set_builtin_action_override(String name, InputEvent[] actions_list) {
		super.call("set_builtin_action_override",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) actions_list});
	}

	public void add_shortcut(String path, Shortcut shortcut) {
		super.call("add_shortcut", new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) shortcut});
	}

	public void remove_shortcut(String path) {
		super.call("remove_shortcut", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean is_shortcut(String path, InputEvent event) {
		return (boolean) super.call("is_shortcut",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) event});
	}

	public boolean has_shortcut(String path) {
		return (boolean) super.call("has_shortcut", new java.lang.Object[]{(java.lang.Object) path});
	}

	public Shortcut get_shortcut(String path) {
		return (Shortcut) super.call("get_shortcut", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean check_changed_settings_in_group(String setting_prefix) {
		return (boolean) super.call("check_changed_settings_in_group",
				new java.lang.Object[]{(java.lang.Object) setting_prefix});
	}

	public void mark_setting_changed(String setting) {
		super.call("mark_setting_changed", new java.lang.Object[]{(java.lang.Object) setting});
	}
}
