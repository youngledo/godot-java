package org.godot.singleton;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.bridge.Bridge;
import org.godot.core.GodotStringName;
import org.godot.internal.api.ApiIndex;

/**
 * Typed wrapper for Godot's Engine singleton.
 *
 * <pre>
 * EngineSingleton engine = EngineSingleton.getInstance();
 * int fps = engine.get_frames_per_second();
 * </pre>
 */
public class EngineSingleton extends Godot {

	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_frames_per_second", 1740695150L),
			java.util.Map.entry("get_frames_drawn", 2455072627L),
			java.util.Map.entry("get_physics_frames", 3905245786L),
			java.util.Map.entry("get_physics_ticks", 3905245786L),
			java.util.Map.entry("get_process_frames", 3905245786L),
			java.util.Map.entry("get_physics_ticks_per_second", 3905245786L),
			java.util.Map.entry("set_physics_ticks_per_second", 1286410249L),
			java.util.Map.entry("get_max_fps", 3905245786L), java.util.Map.entry("set_max_fps", 1286410249L),
			java.util.Map.entry("get_time_scale", 191475506L), java.util.Map.entry("set_time_scale", 373806689L),
			java.util.Map.entry("is_in_physics_frame", 36873697L),
			java.util.Map.entry("get_physics_interpolation_fraction", 1740695150L),
			java.util.Map.entry("get_max_physics_steps_per_frame", 3905245786L),
			java.util.Map.entry("set_max_physics_steps_per_frame", 1286410249L),
			java.util.Map.entry("get_physics_jitter_fix", 1740695150L),
			java.util.Map.entry("set_physics_jitter_fix", 373806689L), java.util.Map.entry("is_editor_hint", 36873697L),
			java.util.Map.entry("get_version_info", 3102165223L), java.util.Map.entry("get_author_info", 3102165223L),
			java.util.Map.entry("get_copyright_info", 3995934104L),
			java.util.Map.entry("get_license_info", 3102165223L), java.util.Map.entry("get_license_text", 201670096L),
			java.util.Map.entry("get_architecture_name", 201670096L),
			java.util.Map.entry("is_embedded_in_editor", 36873697L),
			java.util.Map.entry("get_write_movie_path", 201670096L), java.util.Map.entry("get_main_loop", 1016888095L),
			java.util.Map.entry("get_singleton", 1371597918L), java.util.Map.entry("get_singleton_list", 1139954409L),
			java.util.Map.entry("has_singleton", 2619796661L), java.util.Map.entry("register_singleton", 965313290L),
			java.util.Map.entry("unregister_singleton", 3304788590L),
			java.util.Map.entry("get_script_language_count", 2455072627L),
			java.util.Map.entry("get_script_language", 2151255799L),
			java.util.Map.entry("register_script_language", 1850254898L),
			java.util.Map.entry("unregister_script_language", 1850254898L),
			java.util.Map.entry("capture_script_backtraces", 873284517L),
			java.util.Map.entry("set_print_error_messages", 2586408642L),
			java.util.Map.entry("is_printing_error_messages", 36873697L),
			java.util.Map.entry("set_print_to_stdout", 2586408642L),
			java.util.Map.entry("is_printing_to_stdout", 36873697L));

	private static volatile EngineSingleton instance;

	public EngineSingleton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	public EngineSingleton(long nativePointer) {
		super(nativePointer);
	}

	public static EngineSingleton getInstance() {
		if (instance == null) {
			synchronized (EngineSingleton.class) {
				if (instance == null) {
					GodotStringName name = GodotStringName.fromJavaString("Engine");
					MemorySegment ptr = Bridge.callPtr(ApiIndex.GLOBAL_GET_SINGLETON, name.segment());
					if (ptr.address() == 0) {
						throw new RuntimeException("Failed to get Engine singleton");
					}
					instance = new EngineSingleton(ptr);
				}
			}
		}
		return instance;
	}

	// ----------------------------------------------------------------
	// Frame / timing info
	// ----------------------------------------------------------------

	public int get_frames_per_second() {
		return (int) call("get_frames_per_second");
	}

	public int get_frames_drawn() {
		return (int) call("get_frames_drawn");
	}

	public int get_physics_frames() {
		return (int) call("get_physics_frames");
	}

	public int get_physics_ticks() {
		return (int) call("get_physics_ticks");
	}

	public int get_process_frames() {
		return (int) call("get_process_frames");
	}

	public double get_physics_interpolation_fraction() {
		return (double) call("get_physics_interpolation_fraction");
	}

	// ----------------------------------------------------------------
	// Configuration
	// ----------------------------------------------------------------

	public int get_physics_ticks_per_second() {
		return (int) call("get_physics_ticks_per_second");
	}

	public void set_physics_ticks_per_second(int ticks) {
		call("set_physics_ticks_per_second", ticks);
	}

	public int get_max_fps() {
		return (int) call("get_max_fps");
	}

	public void set_max_fps(int fps) {
		call("set_max_fps", fps);
	}

	public double get_time_scale() {
		return (double) call("get_time_scale");
	}

	public void set_time_scale(double scale) {
		call("set_time_scale", scale);
	}

	public int get_max_physics_steps_per_frame() {
		return (int) call("get_max_physics_steps_per_frame");
	}

	public void set_max_physics_steps_per_frame(int steps) {
		call("set_max_physics_steps_per_frame", steps);
	}

	public double get_physics_jitter_fix() {
		return (double) call("get_physics_jitter_fix");
	}

	public void set_physics_jitter_fix(double fix) {
		call("set_physics_jitter_fix", fix);
	}

	public boolean is_in_physics_frame() {
		return (boolean) call("is_in_physics_frame");
	}

	// ----------------------------------------------------------------
	// Editor / version
	// ----------------------------------------------------------------

	public boolean is_editor_hint() {
		return (boolean) call("is_editor_hint");
	}

	public Object get_version_info() {
		return call("get_version_info");
	}

	public String get_architecture_name() {
		return (String) call("get_architecture_name");
	}

	public boolean is_embedded_in_editor() {
		return (boolean) call("is_embedded_in_editor");
	}

	// ----------------------------------------------------------------
	// Print settings
	// ----------------------------------------------------------------

	public void set_print_error_messages(boolean enable) {
		call("set_print_error_messages", enable);
	}

	public boolean is_printing_error_messages() {
		return (boolean) call("is_printing_error_messages");
	}

	public void set_print_to_stdout(boolean enable) {
		call("set_print_to_stdout", enable);
	}

	public boolean is_printing_to_stdout() {
		return (boolean) call("is_printing_to_stdout");
	}
}
