package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class EditorExportPreset extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_customized_files_count", 3905245786L),
			java.util.Map.entry("get_export_filter", 4227045696L), java.util.Map.entry("get_encrypt_pck", 36873697L),
			java.util.Map.entry("has_export_file", 2323990056L), java.util.Map.entry("get_export_path", 201670096L),
			java.util.Map.entry("get_encrypt_directory", 36873697L), java.util.Map.entry("has", 2619796661L),
			java.util.Map.entry("is_dedicated_server", 36873697L),
			java.util.Map.entry("get_project_setting", 2138907829L),
			java.util.Map.entry("get_custom_features", 201670096L), java.util.Map.entry("get_version", 1132184663L),
			java.util.Map.entry("get_patches", 1139954409L),
			java.util.Map.entry("get_encryption_in_filter", 201670096L),
			java.util.Map.entry("get_preset_name", 201670096L), java.util.Map.entry("get_include_filter", 201670096L),
			java.util.Map.entry("get_file_export_mode", 407825436L), java.util.Map.entry("is_runnable", 36873697L),
			java.util.Map.entry("are_advanced_options_enabled", 36873697L),
			java.util.Map.entry("get_script_export_mode", 2835358398L),
			java.util.Map.entry("get_files_to_export", 1139954409L),
			java.util.Map.entry("get_exclude_filter", 201670096L),
			java.util.Map.entry("get_encryption_key", 201670096L),
			java.util.Map.entry("get_encryption_ex_filter", 201670096L), java.util.Map.entry("get_or_env", 389838787L),
			java.util.Map.entry("get_customized_files", 3102165223L));

	EditorExportPreset(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorExportPreset(long nativePointer) {
		super(nativePointer);
	}

	public boolean has(String property) {
		return (boolean) super.call("has", new java.lang.Object[]{(java.lang.Object) property});
	}

	public boolean has_export_file(String path) {
		return (boolean) super.call("has_export_file", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int get_file_export_mode(String path, int default_) {
		return (int) super.call("get_file_export_mode",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Integer.valueOf(default_)});
	}

	public Object get_project_setting(String name) {
		return (Object) super.call("get_project_setting", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean is_runnable() {
		return (boolean) super.call("is_runnable");
	}

	public boolean are_advanced_options_enabled() {
		return (boolean) super.call("are_advanced_options_enabled");
	}

	public boolean is_dedicated_server() {
		return (boolean) super.call("is_dedicated_server");
	}

	public Object get_or_env(String name, String env_var) {
		return (Object) super.call("get_or_env",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) env_var});
	}

	public String get_version(String name, boolean windows_version) {
		return (String) super.call("get_version",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Boolean.valueOf(windows_version)});
	}
}
