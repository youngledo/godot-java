package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotDictionary;

public class ProjectSettings extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("has_setting", 3927539163L), java.util.Map.entry("set_order", 2956805083L),
			java.util.Map.entry("check_changed_settings_in_group", 3927539163L),
			java.util.Map.entry("get_order", 1321353865L),
			java.util.Map.entry("get_setting_with_override", 2760726917L), java.util.Map.entry("clear", 83702148L),
			java.util.Map.entry("save", 166280745L), java.util.Map.entry("get_setting", 223050753L),
			java.util.Map.entry("add_property_info", 4155329257L), java.util.Map.entry("set_as_internal", 2678287736L),
			java.util.Map.entry("save_custom", 166001499L),
			java.util.Map.entry("get_setting_with_override_and_custom_features", 2434817427L),
			java.util.Map.entry("load_resource_pack", 708980503L),
			java.util.Map.entry("get_changed_settings", 1139954409L),
			java.util.Map.entry("set_initial_value", 402577236L),
			java.util.Map.entry("get_global_class_list", 2915620761L), java.util.Map.entry("set_setting", 402577236L),
			java.util.Map.entry("localize_path", 3135753539L), java.util.Map.entry("globalize_path", 3135753539L),
			java.util.Map.entry("set_restart_if_changed", 2678287736L),
			java.util.Map.entry("set_as_basic", 2678287736L));

	ProjectSettings(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ProjectSettings(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_setting(String name) {
		return (boolean) super.call("has_setting", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void set_setting(String name, Object value) {
		super.call("set_setting", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) value});
	}

	public Object get_setting(String name, Object default_value) {
		return (Object) super.call("get_setting",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) default_value});
	}

	public Object get_setting_with_override(String name) {
		return (Object) super.call("get_setting_with_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public Object get_setting_with_override_and_custom_features(String name, String[] features) {
		return (Object) super.call("get_setting_with_override_and_custom_features",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) features});
	}

	public void set_order(String name, long position) {
		super.call("set_order", new java.lang.Object[]{(java.lang.Object) name, java.lang.Long.valueOf(position)});
	}

	public int get_order(String name) {
		return (int) super.call("get_order", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void set_initial_value(String name, Object value) {
		super.call("set_initial_value", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) value});
	}

	public void set_as_basic(String name, boolean basic) {
		super.call("set_as_basic", new java.lang.Object[]{(java.lang.Object) name, java.lang.Boolean.valueOf(basic)});
	}

	public void set_as_internal(String name, boolean internal) {
		super.call("set_as_internal",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Boolean.valueOf(internal)});
	}

	public void add_property_info(GodotDictionary hint) {
		super.call("add_property_info", new java.lang.Object[]{(java.lang.Object) hint});
	}

	public void set_restart_if_changed(String name, boolean restart) {
		super.call("set_restart_if_changed",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Boolean.valueOf(restart)});
	}

	public void clear(String name) {
		super.call("clear", new java.lang.Object[]{(java.lang.Object) name});
	}

	public String localize_path(String path) {
		return (String) super.call("localize_path", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String globalize_path(String path) {
		return (String) super.call("globalize_path", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int save() {
		return (int) super.call("save");
	}

	public boolean load_resource_pack(String pack, boolean replace_files, long offset) {
		return (boolean) super.call("load_resource_pack", new java.lang.Object[]{(java.lang.Object) pack,
				java.lang.Boolean.valueOf(replace_files), java.lang.Long.valueOf(offset)});
	}

	public int save_custom(String file) {
		return (int) super.call("save_custom", new java.lang.Object[]{(java.lang.Object) file});
	}

	public boolean check_changed_settings_in_group(String setting_prefix) {
		return (boolean) super.call("check_changed_settings_in_group",
				new java.lang.Object[]{(java.lang.Object) setting_prefix});
	}
}
