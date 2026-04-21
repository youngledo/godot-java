package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.GodotObject;

public class Engine extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_donor_info", 3102165223L),
			java.util.Map.entry("set_max_physics_steps_per_frame", 1286410249L),
			java.util.Map.entry("get_max_fps", 3905245786L), java.util.Map.entry("get_version_info", 3102165223L),
			java.util.Map.entry("get_frames_per_second", 1740695150L),
			java.util.Map.entry("get_physics_frames", 3905245786L),
			java.util.Map.entry("is_embedded_in_editor", 36873697L),
			java.util.Map.entry("get_write_movie_path", 201670096L), java.util.Map.entry("is_editor_hint", 36873697L),
			java.util.Map.entry("set_physics_ticks_per_second", 1286410249L),
			java.util.Map.entry("get_copyright_info", 3995934104L), java.util.Map.entry("get_license_text", 201670096L),
			java.util.Map.entry("set_time_scale", 373806689L),
			java.util.Map.entry("capture_script_backtraces", 873284517L),
			java.util.Map.entry("get_license_info", 3102165223L),
			java.util.Map.entry("get_script_language_count", 2455072627L),
			java.util.Map.entry("register_script_language", 1850254898L),
			java.util.Map.entry("has_singleton", 2619796661L), java.util.Map.entry("get_frames_drawn", 2455072627L),
			java.util.Map.entry("get_architecture_name", 201670096L), java.util.Map.entry("get_time_scale", 191475506L),
			java.util.Map.entry("get_process_frames", 3905245786L),
			java.util.Map.entry("set_print_error_messages", 2586408642L),
			java.util.Map.entry("is_printing_to_stdout", 36873697L),
			java.util.Map.entry("is_in_physics_frame", 36873697L), java.util.Map.entry("get_author_info", 3102165223L),
			java.util.Map.entry("register_singleton", 965313290L),
			java.util.Map.entry("set_print_to_stdout", 2586408642L), java.util.Map.entry("set_max_fps", 1286410249L),
			java.util.Map.entry("get_script_language", 2151255799L),
			java.util.Map.entry("get_max_physics_steps_per_frame", 3905245786L),
			java.util.Map.entry("get_physics_interpolation_fraction", 1740695150L),
			java.util.Map.entry("get_physics_ticks_per_second", 3905245786L),
			java.util.Map.entry("set_physics_jitter_fix", 373806689L),
			java.util.Map.entry("get_main_loop", 1016888095L), java.util.Map.entry("get_singleton_list", 1139954409L),
			java.util.Map.entry("get_singleton", 1371597918L), java.util.Map.entry("unregister_singleton", 3304788590L),
			java.util.Map.entry("is_printing_error_messages", 36873697L),
			java.util.Map.entry("get_physics_jitter_fix", 1740695150L),
			java.util.Map.entry("unregister_script_language", 1850254898L));

	Engine(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Engine(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_in_physics_frame() {
		return (boolean) super.call("is_in_physics_frame");
	}

	public boolean has_singleton(String name) {
		return (boolean) super.call("has_singleton", new java.lang.Object[]{(java.lang.Object) name});
	}

	public GodotObject get_singleton(String name) {
		return (GodotObject) super.call("get_singleton", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void register_singleton(String name, GodotObject instance) {
		super.call("register_singleton", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) instance});
	}

	public void unregister_singleton(String name) {
		super.call("unregister_singleton", new java.lang.Object[]{(java.lang.Object) name});
	}

	public int register_script_language(ScriptLanguage language) {
		return (int) super.call("register_script_language", new java.lang.Object[]{(java.lang.Object) language});
	}

	public int unregister_script_language(ScriptLanguage language) {
		return (int) super.call("unregister_script_language", new java.lang.Object[]{(java.lang.Object) language});
	}

	public ScriptLanguage get_script_language(long index) {
		return (ScriptLanguage) super.call("get_script_language",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public ScriptBacktrace[] capture_script_backtraces(boolean include_variables) {
		return (ScriptBacktrace[]) super.call("capture_script_backtraces",
				new java.lang.Object[]{java.lang.Boolean.valueOf(include_variables)});
	}

	public boolean is_editor_hint() {
		return (boolean) super.call("is_editor_hint");
	}

	public boolean is_embedded_in_editor() {
		return (boolean) super.call("is_embedded_in_editor");
	}

	public boolean is_printing_to_stdout() {
		return (boolean) super.call("is_printing_to_stdout");
	}

	public boolean is_printing_error_messages() {
		return (boolean) super.call("is_printing_error_messages");
	}

	public boolean isPrint_error_messages() {
		return (boolean) super.call("is_printing_error_messages", new java.lang.Object[0]);
	}

	public void setPrint_error_messages(boolean value) {
		super.call("set_print_error_messages", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPrint_to_stdout() {
		return (boolean) super.call("is_printing_to_stdout", new java.lang.Object[0]);
	}

	public void setPrint_to_stdout(boolean value) {
		super.call("set_print_to_stdout", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getPhysics_ticks_per_second() {
		return (long) super.call("get_physics_ticks_per_second", new java.lang.Object[0]);
	}

	public void setPhysics_ticks_per_second(long value) {
		super.call("set_physics_ticks_per_second", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMax_physics_steps_per_frame() {
		return (long) super.call("get_max_physics_steps_per_frame", new java.lang.Object[0]);
	}

	public void setMax_physics_steps_per_frame(long value) {
		super.call("set_max_physics_steps_per_frame", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMax_fps() {
		return (long) super.call("get_max_fps", new java.lang.Object[0]);
	}

	public void setMax_fps(long value) {
		super.call("set_max_fps", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getTime_scale() {
		return (double) super.call("get_time_scale", new java.lang.Object[0]);
	}

	public void setTime_scale(double value) {
		super.call("set_time_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPhysics_jitter_fix() {
		return (double) super.call("get_physics_jitter_fix", new java.lang.Object[0]);
	}

	public void setPhysics_jitter_fix(double value) {
		super.call("set_physics_jitter_fix", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
