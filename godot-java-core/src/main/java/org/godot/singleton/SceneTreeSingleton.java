package org.godot.singleton;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.bridge.Bridge;
import org.godot.core.GodotStringName;
import org.godot.internal.api.ApiIndex;

/**
 * Typed wrapper for Godot's SceneTree singleton.
 *
 * <pre>
 * SceneTreeSingleton tree = SceneTreeSingleton.getInstance();
 * int frame = tree.get_frame();
 * int nodeCount = tree.get_node_count();
 * </pre>
 *
 * Note: SceneTree is only available at runtime (not in editor tool mode).
 */
public class SceneTreeSingleton extends Godot {

	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_root", 3102165223L), java.util.Map.entry("has_group", 2619796661L),
			java.util.Map.entry("is_auto_accept_quit", 1740695150L),
			java.util.Map.entry("set_auto_accept_quit", 2586408642L),
			java.util.Map.entry("is_quit_on_go_back", 1740695150L),
			java.util.Map.entry("set_quit_on_go_back", 2586408642L), java.util.Map.entry("set_pause", 2586408642L),
			java.util.Map.entry("is_paused", 1740695150L), java.util.Map.entry("create_timer", 2988792421L),
			java.util.Map.entry("create_tween", 3102165223L), java.util.Map.entry("get_processed_tweens", 3102165223L),
			java.util.Map.entry("get_node_count", 2455072627L), java.util.Map.entry("get_frame", 2455072627L),
			java.util.Map.entry("quit", 1850254898L), java.util.Map.entry("set_debug_collisions_hint", 2586408642L),
			java.util.Map.entry("is_debugging_collisions_hint", 1740695150L),
			java.util.Map.entry("set_debug_paths_hint", 2586408642L),
			java.util.Map.entry("is_debugging_paths_hint", 1740695150L),
			java.util.Map.entry("set_debug_navigation_hint", 2586408642L),
			java.util.Map.entry("is_debugging_navigation_hint", 1740695150L),
			java.util.Map.entry("set_edited_scene_root", 1850254898L),
			java.util.Map.entry("get_edited_scene_root", 3102165223L),
			java.util.Map.entry("set_physics_interpolation_enabled", 2586408642L),
			java.util.Map.entry("is_physics_interpolation_enabled", 1740695150L),
			java.util.Map.entry("queue_delete", 1850254898L), java.util.Map.entry("call_group_flags", 2988792421L),
			java.util.Map.entry("notify_group_flags", 2988792421L), java.util.Map.entry("set_group_flags", 2988792421L),
			java.util.Map.entry("call_group", 3287961647L), java.util.Map.entry("notify_group", 3287961647L),
			java.util.Map.entry("set_group", 3287961647L), java.util.Map.entry("get_nodes_in_group", 201670096L));

	private static volatile SceneTreeSingleton instance;

	public SceneTreeSingleton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	public SceneTreeSingleton(long nativePointer) {
		super(nativePointer);
	}

	/**
	 * Get the SceneTree singleton instance.
	 *
	 * Note: SceneTree is not a global singleton in Godot. It is accessed via
	 * {@code Engine.get_main_loop()}. This method resolves it through the
	 * "SceneTree" name lookup.
	 */
	public static SceneTreeSingleton getInstance() {
		if (instance == null) {
			synchronized (SceneTreeSingleton.class) {
				if (instance == null) {
					GodotStringName name = GodotStringName.fromJavaString("SceneTree");
					MemorySegment ptr = Bridge.callPtr(ApiIndex.GLOBAL_GET_SINGLETON, name.segment());
					if (ptr.address() == 0) {
						throw new RuntimeException("Failed to get SceneTree singleton");
					}
					instance = new SceneTreeSingleton(ptr);
				}
			}
		}
		return instance;
	}

	// ----------------------------------------------------------------
	// Scene tree info
	// ----------------------------------------------------------------

	public Object get_root() {
		return call("get_root");
	}

	public int get_node_count() {
		return (int) call("get_node_count");
	}

	public int get_frame() {
		return (int) call("get_frame");
	}

	public boolean has_group(String group) {
		return (boolean) call("has_group", group);
	}

	// ----------------------------------------------------------------
	// Pause
	// ----------------------------------------------------------------

	public void set_pause(boolean enable) {
		call("set_pause", enable);
	}

	public boolean is_paused() {
		return (boolean) call("is_paused");
	}

	// ----------------------------------------------------------------
	// Quit
	// ----------------------------------------------------------------

	public void quit() {
		call("quit", 0);
	}

	public void quit(int exit_code) {
		call("quit", exit_code);
	}

	// ----------------------------------------------------------------
	// Auto-quit settings
	// ----------------------------------------------------------------

	public boolean is_auto_accept_quit() {
		return (boolean) call("is_auto_accept_quit");
	}

	public void set_auto_accept_quit(boolean enabled) {
		call("set_auto_accept_quit", enabled);
	}

	public boolean is_quit_on_go_back() {
		return (boolean) call("is_quit_on_go_back");
	}

	public void set_quit_on_go_back(boolean enabled) {
		call("set_quit_on_go_back", enabled);
	}

	// ----------------------------------------------------------------
	// Timer / Tween
	// ----------------------------------------------------------------

	public Object create_timer(double time_sec) {
		return call("create_timer", time_sec, true, false, false);
	}

	public Object create_timer(double time_sec, boolean process_always, boolean process_in_physics,
			boolean ignore_time_scale) {
		return call("create_timer", time_sec, process_always, process_in_physics, ignore_time_scale);
	}

	public Object create_tween() {
		return call("create_tween");
	}

	public Object get_processed_tweens() {
		return call("get_processed_tweens");
	}

	// ----------------------------------------------------------------
	// Debug
	// ----------------------------------------------------------------

	public void set_debug_collisions_hint(boolean enable) {
		call("set_debug_collisions_hint", enable);
	}

	public boolean is_debugging_collisions_hint() {
		return (boolean) call("is_debugging_collisions_hint");
	}

	public void set_debug_paths_hint(boolean enable) {
		call("set_debug_paths_hint", enable);
	}

	public boolean is_debugging_paths_hint() {
		return (boolean) call("is_debugging_paths_hint");
	}

	public void set_debug_navigation_hint(boolean enable) {
		call("set_debug_navigation_hint", enable);
	}

	public boolean is_debugging_navigation_hint() {
		return (boolean) call("is_debugging_navigation_hint");
	}

	// ----------------------------------------------------------------
	// Physics interpolation
	// ----------------------------------------------------------------

	public void set_physics_interpolation_enabled(boolean enabled) {
		call("set_physics_interpolation_enabled", enabled);
	}

	public boolean is_physics_interpolation_enabled() {
		return (boolean) call("is_physics_interpolation_enabled");
	}

	// ----------------------------------------------------------------
	// Group operations
	// ----------------------------------------------------------------

	public void call_group(int flags, String group, String method) {
		call("call_group_flags", flags, group, method);
	}

	public void notify_group(int flags, String group, int notification) {
		call("notify_group_flags", flags, group, notification);
	}

	public void queue_delete(Object obj) {
		call("queue_delete", obj);
	}
}
