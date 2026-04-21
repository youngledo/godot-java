package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;

public class OS extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_in_low_processor_usage_mode", 36873697L),
			java.util.Map.entry("get_process_id", 3905245786L), java.util.Map.entry("shell_open", 166001499L),
			java.util.Map.entry("get_system_ca_certificates", 2841200299L),
			java.util.Map.entry("set_low_processor_usage_mode", 2586408642L),
			java.util.Map.entry("move_to_trash", 2113323047L), java.util.Map.entry("get_user_data_dir", 201670096L),
			java.util.Map.entry("set_environment", 3605043004L),
			java.util.Map.entry("get_video_adapter_driver_info", 1139954409L), java.util.Map.entry("crash", 83702148L),
			java.util.Map.entry("get_restart_on_exit_arguments", 1139954409L),
			java.util.Map.entry("close_midi_inputs", 3218959716L), java.util.Map.entry("get_cache_dir", 201670096L),
			java.util.Map.entry("create_process", 2903767230L),
			java.util.Map.entry("read_string_from_stdin", 723587915L),
			java.util.Map.entry("get_static_memory_usage", 3905245786L), java.util.Map.entry("get_name", 201670096L),
			java.util.Map.entry("get_cmdline_args", 2981934095L), java.util.Map.entry("get_processor_name", 201670096L),
			java.util.Map.entry("get_distribution_name", 201670096L),
			java.util.Map.entry("is_restart_on_exit_set", 36873697L),
			java.util.Map.entry("get_connected_midi_inputs", 2981934095L),
			java.util.Map.entry("is_process_running", 1116898809L), java.util.Map.entry("get_stderr_type", 1704816237L),
			java.util.Map.entry("get_system_dir", 3073895123L),
			java.util.Map.entry("get_thread_caller_id", 3905245786L),
			java.util.Map.entry("get_granted_permissions", 1139954409L),
			java.util.Map.entry("get_model_name", 201670096L), java.util.Map.entry("get_system_fonts", 1139954409L),
			java.util.Map.entry("get_locale_language", 201670096L), java.util.Map.entry("execute", 1488299882L),
			java.util.Map.entry("delay_usec", 998575451L), java.util.Map.entry("set_thread_name", 166001499L),
			java.util.Map.entry("get_version_alias", 201670096L),
			java.util.Map.entry("read_buffer_from_stdin", 3249455752L),
			java.util.Map.entry("has_environment", 3927539163L), java.util.Map.entry("get_unique_id", 201670096L),
			java.util.Map.entry("get_entropy", 47165747L), java.util.Map.entry("remove_logger", 4261188958L),
			java.util.Map.entry("shell_show_in_file_manager", 3565188097L),
			java.util.Map.entry("open_midi_inputs", 3218959716L),
			java.util.Map.entry("is_keycode_unicode", 1116898809L),
			java.util.Map.entry("get_low_processor_usage_mode_sleep_usec", 3905245786L),
			java.util.Map.entry("set_low_processor_usage_mode_sleep_usec", 1286410249L),
			java.util.Map.entry("revoke_granted_permissions", 3218959716L),
			java.util.Map.entry("set_use_file_access_save_and_swap", 2586408642L),
			java.util.Map.entry("is_sandboxed", 36873697L), java.util.Map.entry("execute_with_pipe", 2851312030L),
			java.util.Map.entry("get_config_dir", 201670096L),
			java.util.Map.entry("get_cmdline_user_args", 2981934095L),
			java.util.Map.entry("get_process_exit_code", 923996154L), java.util.Map.entry("get_data_dir", 201670096L),
			java.util.Map.entry("create_instance", 1080601263L),
			java.util.Map.entry("get_system_font_path_for_text", 197317981L),
			java.util.Map.entry("get_stdin_type", 1704816237L), java.util.Map.entry("delay_msec", 998575451L),
			java.util.Map.entry("get_stdout_type", 1704816237L), java.util.Map.entry("alert", 1783970740L),
			java.util.Map.entry("set_delta_smoothing", 2586408642L),
			java.util.Map.entry("set_restart_on_exit", 3331453935L),
			java.util.Map.entry("get_keycode_string", 2261993717L),
			java.util.Map.entry("get_static_memory_peak_usage", 3905245786L),
			java.util.Map.entry("get_memory_info", 3102165223L), java.util.Map.entry("get_environment", 3135753539L),
			java.util.Map.entry("add_logger", 4261188958L), java.util.Map.entry("get_processor_count", 3905245786L),
			java.util.Map.entry("get_main_thread_id", 3905245786L),
			java.util.Map.entry("get_executable_path", 201670096L), java.util.Map.entry("is_debug_build", 36873697L),
			java.util.Map.entry("open_with_program", 2848259907L), java.util.Map.entry("get_version", 201670096L),
			java.util.Map.entry("get_system_font_path", 626580860L), java.util.Map.entry("kill", 844576869L),
			java.util.Map.entry("unset_environment", 3089850668L),
			java.util.Map.entry("find_keycode_from_string", 1084858572L),
			java.util.Map.entry("request_permissions", 2240911060L), java.util.Map.entry("get_locale", 201670096L),
			java.util.Map.entry("is_delta_smoothing_enabled", 36873697L),
			java.util.Map.entry("request_permission", 2323990056L), java.util.Map.entry("has_feature", 3927539163L),
			java.util.Map.entry("is_userfs_persistent", 36873697L), java.util.Map.entry("is_stdout_verbose", 36873697L),
			java.util.Map.entry("get_temp_dir", 201670096L));

	OS(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OS(long nativePointer) {
		super(nativePointer);
	}

	public byte[] get_entropy(long size) {
		return (byte[]) super.call("get_entropy", new java.lang.Object[]{java.lang.Long.valueOf(size)});
	}

	public void open_midi_inputs() {
		super.call("open_midi_inputs");
	}

	public void close_midi_inputs() {
		super.call("close_midi_inputs");
	}

	public void alert(String text, String title) {
		super.call("alert", new java.lang.Object[]{(java.lang.Object) text, (java.lang.Object) title});
	}

	public void crash(String message) {
		super.call("crash", new java.lang.Object[]{(java.lang.Object) message});
	}

	public boolean is_in_low_processor_usage_mode() {
		return (boolean) super.call("is_in_low_processor_usage_mode");
	}

	public boolean is_delta_smoothing_enabled() {
		return (boolean) super.call("is_delta_smoothing_enabled");
	}

	public String get_system_font_path(String font_name, long weight, long stretch, boolean italic) {
		return (String) super.call("get_system_font_path", new java.lang.Object[]{(java.lang.Object) font_name,
				java.lang.Long.valueOf(weight), java.lang.Long.valueOf(stretch), java.lang.Boolean.valueOf(italic)});
	}

	public String[] get_system_font_path_for_text(String font_name, String text, String locale, String script,
			long weight, long stretch, boolean italic) {
		return (String[]) super.call("get_system_font_path_for_text",
				new java.lang.Object[]{(java.lang.Object) font_name, (java.lang.Object) text, (java.lang.Object) locale,
						(java.lang.Object) script, java.lang.Long.valueOf(weight), java.lang.Long.valueOf(stretch),
						java.lang.Boolean.valueOf(italic)});
	}

	public String read_string_from_stdin(long buffer_size) {
		return (String) super.call("read_string_from_stdin",
				new java.lang.Object[]{java.lang.Long.valueOf(buffer_size)});
	}

	public byte[] read_buffer_from_stdin(long buffer_size) {
		return (byte[]) super.call("read_buffer_from_stdin",
				new java.lang.Object[]{java.lang.Long.valueOf(buffer_size)});
	}

	public int execute(String path, String[] arguments, GodotArray output, boolean read_stderr, boolean open_console) {
		return (int) super.call("execute",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) arguments, (java.lang.Object) output,
						java.lang.Boolean.valueOf(read_stderr), java.lang.Boolean.valueOf(open_console)});
	}

	public GodotDictionary execute_with_pipe(String path, String[] arguments, boolean blocking) {
		return (GodotDictionary) super.call("execute_with_pipe", new java.lang.Object[]{(java.lang.Object) path,
				(java.lang.Object) arguments, java.lang.Boolean.valueOf(blocking)});
	}

	public int create_process(String path, String[] arguments, boolean open_console) {
		return (int) super.call("create_process", new java.lang.Object[]{(java.lang.Object) path,
				(java.lang.Object) arguments, java.lang.Boolean.valueOf(open_console)});
	}

	public int create_instance(String[] arguments) {
		return (int) super.call("create_instance", new java.lang.Object[]{(java.lang.Object) arguments});
	}

	public int open_with_program(String program_path, String[] paths) {
		return (int) super.call("open_with_program",
				new java.lang.Object[]{(java.lang.Object) program_path, (java.lang.Object) paths});
	}

	public int kill(long pid) {
		return (int) super.call("kill", new java.lang.Object[]{java.lang.Long.valueOf(pid)});
	}

	public int shell_open(String uri) {
		return (int) super.call("shell_open", new java.lang.Object[]{(java.lang.Object) uri});
	}

	public int shell_show_in_file_manager(String file_or_dir_path, boolean open_folder) {
		return (int) super.call("shell_show_in_file_manager",
				new java.lang.Object[]{(java.lang.Object) file_or_dir_path, java.lang.Boolean.valueOf(open_folder)});
	}

	public boolean is_process_running(long pid) {
		return (boolean) super.call("is_process_running", new java.lang.Object[]{java.lang.Long.valueOf(pid)});
	}

	public int get_process_exit_code(long pid) {
		return (int) super.call("get_process_exit_code", new java.lang.Object[]{java.lang.Long.valueOf(pid)});
	}

	public boolean has_environment(String variable) {
		return (boolean) super.call("has_environment", new java.lang.Object[]{(java.lang.Object) variable});
	}

	public String get_environment(String variable) {
		return (String) super.call("get_environment", new java.lang.Object[]{(java.lang.Object) variable});
	}

	public void set_environment(String variable, String value) {
		super.call("set_environment", new java.lang.Object[]{(java.lang.Object) variable, (java.lang.Object) value});
	}

	public void unset_environment(String variable) {
		super.call("unset_environment", new java.lang.Object[]{(java.lang.Object) variable});
	}

	public void set_restart_on_exit(boolean restart, String[] arguments) {
		super.call("set_restart_on_exit",
				new java.lang.Object[]{java.lang.Boolean.valueOf(restart), (java.lang.Object) arguments});
	}

	public boolean is_restart_on_exit_set() {
		return (boolean) super.call("is_restart_on_exit_set");
	}

	public void delay_usec(long usec) {
		super.call("delay_usec", new java.lang.Object[]{java.lang.Long.valueOf(usec)});
	}

	public void delay_msec(long msec) {
		super.call("delay_msec", new java.lang.Object[]{java.lang.Long.valueOf(msec)});
	}

	public boolean is_userfs_persistent() {
		return (boolean) super.call("is_userfs_persistent");
	}

	public boolean is_stdout_verbose() {
		return (boolean) super.call("is_stdout_verbose");
	}

	public boolean is_debug_build() {
		return (boolean) super.call("is_debug_build");
	}

	public int move_to_trash(String path) {
		return (int) super.call("move_to_trash", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String get_system_dir(int dir, boolean shared_storage) {
		return (String) super.call("get_system_dir",
				new java.lang.Object[]{java.lang.Integer.valueOf(dir), java.lang.Boolean.valueOf(shared_storage)});
	}

	public String get_keycode_string(int code) {
		return (String) super.call("get_keycode_string", new java.lang.Object[]{java.lang.Integer.valueOf(code)});
	}

	public boolean is_keycode_unicode(long code) {
		return (boolean) super.call("is_keycode_unicode", new java.lang.Object[]{java.lang.Long.valueOf(code)});
	}

	public int find_keycode_from_string(String string) {
		return (int) super.call("find_keycode_from_string", new java.lang.Object[]{(java.lang.Object) string});
	}

	public boolean has_feature(String tag_name) {
		return (boolean) super.call("has_feature", new java.lang.Object[]{(java.lang.Object) tag_name});
	}

	public boolean is_sandboxed() {
		return (boolean) super.call("is_sandboxed");
	}

	public boolean request_permission(String name) {
		return (boolean) super.call("request_permission", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean request_permissions() {
		return (boolean) super.call("request_permissions");
	}

	public void revoke_granted_permissions() {
		super.call("revoke_granted_permissions");
	}

	public void add_logger(Logger logger) {
		super.call("add_logger", new java.lang.Object[]{(java.lang.Object) logger});
	}

	public void remove_logger(Logger logger) {
		super.call("remove_logger", new java.lang.Object[]{(java.lang.Object) logger});
	}

	public boolean isLow_processor_usage_mode() {
		return (boolean) super.call("is_in_low_processor_usage_mode", new java.lang.Object[0]);
	}

	public void setLow_processor_usage_mode(boolean value) {
		super.call("set_low_processor_usage_mode", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getLow_processor_usage_mode_sleep_usec() {
		return (long) super.call("get_low_processor_usage_mode_sleep_usec", new java.lang.Object[0]);
	}

	public void setLow_processor_usage_mode_sleep_usec(long value) {
		super.call("set_low_processor_usage_mode_sleep_usec", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isDelta_smoothing() {
		return (boolean) super.call("is_delta_smoothing_enabled", new java.lang.Object[0]);
	}

	public void setDelta_smoothing(boolean value) {
		super.call("set_delta_smoothing", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
