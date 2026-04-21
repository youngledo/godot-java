package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class FileDialog extends ConfirmationDialog {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_current_file", 83702148L), java.util.Map.entry("get_use_native_dialog", 36873697L),
			java.util.Map.entry("is_showing_hidden_files", 36873697L), java.util.Map.entry("get_vbox", 915758477L),
			java.util.Map.entry("set_favorite_list", 4015028928L),
			java.util.Map.entry("is_customization_flag_enabled", 3722277863L),
			java.util.Map.entry("set_get_thumbnail_callback", 1611583062L),
			java.util.Map.entry("is_mode_overriding_title", 36873697L),
			java.util.Map.entry("get_option_name", 844755477L), java.util.Map.entry("get_current_path", 201670096L),
			java.util.Map.entry("get_option_values", 647634434L), java.util.Map.entry("set_current_path", 83702148L),
			java.util.Map.entry("add_filter", 914921954L), java.util.Map.entry("get_current_file", 201670096L),
			java.util.Map.entry("set_use_native_dialog", 2586408642L),
			java.util.Map.entry("set_filename_filter", 83702148L),
			java.util.Map.entry("set_option_values", 3353661094L), java.util.Map.entry("get_option_count", 3905245786L),
			java.util.Map.entry("get_current_dir", 201670096L),
			java.util.Map.entry("get_selected_options", 3102165223L), java.util.Map.entry("get_filters", 1139954409L),
			java.util.Map.entry("set_file_mode", 3654936397L), java.util.Map.entry("set_root_subfolder", 83702148L),
			java.util.Map.entry("set_mode_overrides_title", 2586408642L),
			java.util.Map.entry("clear_filename_filter", 3218959716L), java.util.Map.entry("get_access", 3344081076L),
			java.util.Map.entry("set_option_name", 501894301L), java.util.Map.entry("get_root_subfolder", 201670096L),
			java.util.Map.entry("set_filters", 4015028928L), java.util.Map.entry("get_filename_filter", 201670096L),
			java.util.Map.entry("set_display_mode", 2692197101L),
			java.util.Map.entry("set_option_default", 3937882851L),
			java.util.Map.entry("set_get_icon_callback", 1611583062L),
			java.util.Map.entry("clear_filters", 3218959716L), java.util.Map.entry("get_line_edit", 4071694264L),
			java.util.Map.entry("set_current_dir", 83702148L),
			java.util.Map.entry("set_show_hidden_files", 2586408642L),
			java.util.Map.entry("get_recent_list", 2981934095L), java.util.Map.entry("get_option_default", 923996154L),
			java.util.Map.entry("set_customization_flag_enabled", 3849177100L),
			java.util.Map.entry("get_file_mode", 4074825319L), java.util.Map.entry("get_display_mode", 1092104624L),
			java.util.Map.entry("invalidate", 3218959716L), java.util.Map.entry("add_option", 149592325L),
			java.util.Map.entry("get_favorite_list", 2981934095L), java.util.Map.entry("set_recent_list", 4015028928L),
			java.util.Map.entry("deselect_all", 3218959716L), java.util.Map.entry("popup_file_dialog", 3218959716L),
			java.util.Map.entry("set_option_count", 1286410249L), java.util.Map.entry("set_access", 4104413466L));

	FileDialog(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FileDialog(long nativePointer) {
		super(nativePointer);
	}

	public void clear_filters() {
		super.call("clear_filters");
	}

	public void add_filter(String filter, String description, String mime_type) {
		super.call("add_filter", new java.lang.Object[]{(java.lang.Object) filter, (java.lang.Object) description,
				(java.lang.Object) mime_type});
	}

	public void clear_filename_filter() {
		super.call("clear_filename_filter");
	}

	public String get_option_name(long option) {
		return (String) super.call("get_option_name", new java.lang.Object[]{java.lang.Long.valueOf(option)});
	}

	public String[] get_option_values(long option) {
		return (String[]) super.call("get_option_values", new java.lang.Object[]{java.lang.Long.valueOf(option)});
	}

	public int get_option_default(long option) {
		return (int) super.call("get_option_default", new java.lang.Object[]{java.lang.Long.valueOf(option)});
	}

	public void set_option_name(long option, String name) {
		super.call("set_option_name", new java.lang.Object[]{java.lang.Long.valueOf(option), (java.lang.Object) name});
	}

	public void set_option_values(long option, String[] values) {
		super.call("set_option_values",
				new java.lang.Object[]{java.lang.Long.valueOf(option), (java.lang.Object) values});
	}

	public void set_option_default(long option, long default_value_index) {
		super.call("set_option_default",
				new java.lang.Object[]{java.lang.Long.valueOf(option), java.lang.Long.valueOf(default_value_index)});
	}

	public void add_option(String name, String[] values, long default_value_index) {
		super.call("add_option", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) values,
				java.lang.Long.valueOf(default_value_index)});
	}

	public boolean is_mode_overriding_title() {
		return (boolean) super.call("is_mode_overriding_title");
	}

	public boolean is_showing_hidden_files() {
		return (boolean) super.call("is_showing_hidden_files");
	}

	public void set_customization_flag_enabled(int flag, boolean enabled) {
		super.call("set_customization_flag_enabled",
				new java.lang.Object[]{java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_customization_flag_enabled(int flag) {
		return (boolean) super.call("is_customization_flag_enabled",
				new java.lang.Object[]{java.lang.Integer.valueOf(flag)});
	}

	public void deselect_all() {
		super.call("deselect_all");
	}

	public void popup_file_dialog() {
		super.call("popup_file_dialog");
	}

	public void invalidate() {
		super.call("invalidate");
	}

	public boolean isMode_overrides_title() {
		return (boolean) super.call("is_mode_overriding_title", new java.lang.Object[0]);
	}

	public void setMode_overrides_title(boolean value) {
		super.call("set_mode_overrides_title", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getFile_mode() {
		return (long) super.call("get_file_mode", new java.lang.Object[0]);
	}

	public void setFile_mode(long value) {
		super.call("set_file_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDisplay_mode() {
		return (long) super.call("get_display_mode", new java.lang.Object[0]);
	}

	public void setDisplay_mode(long value) {
		super.call("set_display_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getAccess() {
		return (long) super.call("get_access", new java.lang.Object[0]);
	}

	public void setAccess(long value) {
		super.call("set_access", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getRoot_subfolder() {
		return (String) super.call("get_root_subfolder", new java.lang.Object[0]);
	}

	public void setRoot_subfolder(String value) {
		super.call("set_root_subfolder", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String[] getFilters() {
		return (String[]) super.call("get_filters", new java.lang.Object[0]);
	}

	public void setFilters(String[] value) {
		super.call("set_filters", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getFilename_filter() {
		return (String) super.call("get_filename_filter", new java.lang.Object[0]);
	}

	public void setFilename_filter(String value) {
		super.call("set_filename_filter", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isShow_hidden_files() {
		return (boolean) super.call("is_showing_hidden_files", new java.lang.Object[0]);
	}

	public void setShow_hidden_files(boolean value) {
		super.call("set_show_hidden_files", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getUse_native_dialog() {
		return (boolean) super.call("get_use_native_dialog", new java.lang.Object[0]);
	}

	public void setUse_native_dialog(boolean value) {
		super.call("set_use_native_dialog", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getOption_count() {
		return (long) super.call("get_option_count", new java.lang.Object[0]);
	}

	public void setOption_count(long value) {
		super.call("set_option_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isHidden_files_toggle_enabled() {
		return (boolean) super.call("is_customization_flag_enabled", new java.lang.Object[0]);
	}

	public void setHidden_files_toggle_enabled(boolean value) {
		super.call("set_customization_flag_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isFile_filter_toggle_enabled() {
		return (boolean) super.call("is_customization_flag_enabled", new java.lang.Object[0]);
	}

	public void setFile_filter_toggle_enabled(boolean value) {
		super.call("set_customization_flag_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isFile_sort_options_enabled() {
		return (boolean) super.call("is_customization_flag_enabled", new java.lang.Object[0]);
	}

	public void setFile_sort_options_enabled(boolean value) {
		super.call("set_customization_flag_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isFolder_creation_enabled() {
		return (boolean) super.call("is_customization_flag_enabled", new java.lang.Object[0]);
	}

	public void setFolder_creation_enabled(boolean value) {
		super.call("set_customization_flag_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isFavorites_enabled() {
		return (boolean) super.call("is_customization_flag_enabled", new java.lang.Object[0]);
	}

	public void setFavorites_enabled(boolean value) {
		super.call("set_customization_flag_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isRecent_list_enabled() {
		return (boolean) super.call("is_customization_flag_enabled", new java.lang.Object[0]);
	}

	public void setRecent_list_enabled(boolean value) {
		super.call("set_customization_flag_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isLayout_toggle_enabled() {
		return (boolean) super.call("is_customization_flag_enabled", new java.lang.Object[0]);
	}

	public void setLayout_toggle_enabled(boolean value) {
		super.call("set_customization_flag_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isOverwrite_warning_enabled() {
		return (boolean) super.call("is_customization_flag_enabled", new java.lang.Object[0]);
	}

	public void setOverwrite_warning_enabled(boolean value) {
		super.call("set_customization_flag_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDeleting_enabled() {
		return (boolean) super.call("is_customization_flag_enabled", new java.lang.Object[0]);
	}

	public void setDeleting_enabled(boolean value) {
		super.call("set_customization_flag_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getCurrent_dir() {
		return (String) super.call("get_current_dir", new java.lang.Object[0]);
	}

	public void setCurrent_dir(String value) {
		super.call("set_current_dir", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getCurrent_file() {
		return (String) super.call("get_current_file", new java.lang.Object[0]);
	}

	public void setCurrent_file(String value) {
		super.call("set_current_file", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getCurrent_path() {
		return (String) super.call("get_current_path", new java.lang.Object[0]);
	}

	public void setCurrent_path(String value) {
		super.call("set_current_path", new java.lang.Object[]{(java.lang.Object) value});
	}
}
