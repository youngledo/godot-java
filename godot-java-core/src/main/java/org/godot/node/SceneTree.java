package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;

public class SceneTree extends MainLoop {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("reload_current_scene", 166280745L),
			java.util.Map.entry("is_quit_on_go_back", 36873697L), java.util.Map.entry("set_pause", 2586408642L),
			java.util.Map.entry("create_timer", 2709170273L),
			java.util.Map.entry("is_accessibility_enabled", 36873697L),
			java.util.Map.entry("queue_delete", 3975164845L), java.util.Map.entry("unload_current_scene", 3218959716L),
			java.util.Map.entry("set_group", 1279312029L),
			java.util.Map.entry("set_debug_collisions_hint", 2586408642L),
			java.util.Map.entry("is_multiplayer_poll_enabled", 36873697L),
			java.util.Map.entry("notify_group_flags", 1245489420L),
			java.util.Map.entry("get_first_node_in_group", 4071044623L),
			java.util.Map.entry("get_edited_scene_root", 3160264692L),
			java.util.Map.entry("get_node_count", 3905245786L),
			java.util.Map.entry("is_physics_interpolation_enabled", 36873697L),
			java.util.Map.entry("is_accessibility_supported", 36873697L),
			java.util.Map.entry("change_scene_to_file", 166001499L), java.util.Map.entry("has_group", 2619796661L),
			java.util.Map.entry("get_node_count_in_group", 2458036349L),
			java.util.Map.entry("set_quit_on_go_back", 2586408642L),
			java.util.Map.entry("set_debug_navigation_hint", 2586408642L),
			java.util.Map.entry("notify_group", 2415702435L), java.util.Map.entry("set_current_scene", 1078189570L),
			java.util.Map.entry("set_auto_accept_quit", 2586408642L),
			java.util.Map.entry("get_nodes_in_group", 689397652L), java.util.Map.entry("set_multiplayer", 2385607013L),
			java.util.Map.entry("call_group_flags", 1527739229L),
			java.util.Map.entry("set_debug_paths_hint", 2586408642L), java.util.Map.entry("get_frame", 3905245786L),
			java.util.Map.entry("get_current_scene", 3160264692L),
			java.util.Map.entry("is_debugging_paths_hint", 36873697L),
			java.util.Map.entry("get_multiplayer", 3453401404L), java.util.Map.entry("call_group", 1257962832L),
			java.util.Map.entry("create_tween", 3426978995L),
			java.util.Map.entry("set_multiplayer_poll_enabled", 2586408642L),
			java.util.Map.entry("change_scene_to_packed", 107349098L),
			java.util.Map.entry("set_edited_scene_root", 1078189570L), java.util.Map.entry("is_paused", 36873697L),
			java.util.Map.entry("set_physics_interpolation_enabled", 2586408642L),
			java.util.Map.entry("is_debugging_collisions_hint", 36873697L),
			java.util.Map.entry("change_scene_to_node", 2584678054L),
			java.util.Map.entry("get_processed_tweens", 2915620761L), java.util.Map.entry("quit", 1995695955L),
			java.util.Map.entry("set_group_flags", 3497599527L), java.util.Map.entry("get_root", 1757182445L),
			java.util.Map.entry("is_debugging_navigation_hint", 36873697L),
			java.util.Map.entry("is_auto_accept_quit", 36873697L));

	SceneTree(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SceneTree(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_group(String name) {
		return (boolean) super.call("has_group", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean is_accessibility_enabled() {
		return (boolean) super.call("is_accessibility_enabled");
	}

	public boolean is_accessibility_supported() {
		return (boolean) super.call("is_accessibility_supported");
	}

	public boolean is_auto_accept_quit() {
		return (boolean) super.call("is_auto_accept_quit");
	}

	public boolean is_quit_on_go_back() {
		return (boolean) super.call("is_quit_on_go_back");
	}

	public boolean is_debugging_collisions_hint() {
		return (boolean) super.call("is_debugging_collisions_hint");
	}

	public boolean is_debugging_paths_hint() {
		return (boolean) super.call("is_debugging_paths_hint");
	}

	public boolean is_debugging_navigation_hint() {
		return (boolean) super.call("is_debugging_navigation_hint");
	}

	public boolean is_paused() {
		return (boolean) super.call("is_paused");
	}

	public SceneTreeTimer create_timer(double time_sec, boolean process_always, boolean process_in_physics,
			boolean ignore_time_scale) {
		return (SceneTreeTimer) super.call("create_timer",
				new java.lang.Object[]{java.lang.Double.valueOf(time_sec), java.lang.Boolean.valueOf(process_always),
						java.lang.Boolean.valueOf(process_in_physics), java.lang.Boolean.valueOf(ignore_time_scale)});
	}

	public Tween create_tween() {
		return (Tween) super.call("create_tween");
	}

	public void quit(long exit_code) {
		super.call("quit", new java.lang.Object[]{java.lang.Long.valueOf(exit_code)});
	}

	public boolean is_physics_interpolation_enabled() {
		return (boolean) super.call("is_physics_interpolation_enabled");
	}

	public void queue_delete(GodotObject obj) {
		super.call("queue_delete", new java.lang.Object[]{(java.lang.Object) obj});
	}

	public void call_group_flags(long flags, String group, String method) {
		super.call("call_group_flags", new java.lang.Object[]{java.lang.Long.valueOf(flags), (java.lang.Object) group,
				(java.lang.Object) method});
	}

	public void notify_group_flags(long call_flags, String group, long notification) {
		super.call("notify_group_flags", new java.lang.Object[]{java.lang.Long.valueOf(call_flags),
				(java.lang.Object) group, java.lang.Long.valueOf(notification)});
	}

	public void set_group_flags(long call_flags, String group, String property, Object value) {
		super.call("set_group_flags", new java.lang.Object[]{java.lang.Long.valueOf(call_flags),
				(java.lang.Object) group, (java.lang.Object) property, (java.lang.Object) value});
	}

	public void call_group(String group, String method) {
		super.call("call_group", new java.lang.Object[]{(java.lang.Object) group, (java.lang.Object) method});
	}

	public void notify_group(String group, long notification) {
		super.call("notify_group",
				new java.lang.Object[]{(java.lang.Object) group, java.lang.Long.valueOf(notification)});
	}

	public void set_group(String group, String property, Object value) {
		super.call("set_group", new java.lang.Object[]{(java.lang.Object) group, (java.lang.Object) property,
				(java.lang.Object) value});
	}

	public Node[] get_nodes_in_group(String group) {
		return (Node[]) super.call("get_nodes_in_group", new java.lang.Object[]{(java.lang.Object) group});
	}

	public Node get_first_node_in_group(String group) {
		return (Node) super.call("get_first_node_in_group", new java.lang.Object[]{(java.lang.Object) group});
	}

	public int get_node_count_in_group(String group) {
		return (int) super.call("get_node_count_in_group", new java.lang.Object[]{(java.lang.Object) group});
	}

	public int change_scene_to_file(String path) {
		return (int) super.call("change_scene_to_file", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int change_scene_to_packed(PackedScene packed_scene) {
		return (int) super.call("change_scene_to_packed", new java.lang.Object[]{(java.lang.Object) packed_scene});
	}

	public int change_scene_to_node(Node node) {
		return (int) super.call("change_scene_to_node", new java.lang.Object[]{(java.lang.Object) node});
	}

	public int reload_current_scene() {
		return (int) super.call("reload_current_scene");
	}

	public void unload_current_scene() {
		super.call("unload_current_scene");
	}

	public void set_multiplayer(MultiplayerAPI multiplayer, String root_path) {
		super.call("set_multiplayer",
				new java.lang.Object[]{(java.lang.Object) multiplayer, (java.lang.Object) root_path});
	}

	public MultiplayerAPI get_multiplayer(String for_path) {
		return (MultiplayerAPI) super.call("get_multiplayer", new java.lang.Object[]{(java.lang.Object) for_path});
	}

	public boolean is_multiplayer_poll_enabled() {
		return (boolean) super.call("is_multiplayer_poll_enabled");
	}

	public boolean isAuto_accept_quit() {
		return (boolean) super.call("is_auto_accept_quit", new java.lang.Object[0]);
	}

	public void setAuto_accept_quit(boolean value) {
		super.call("set_auto_accept_quit", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isQuit_on_go_back() {
		return (boolean) super.call("is_quit_on_go_back", new java.lang.Object[0]);
	}

	public void setQuit_on_go_back(boolean value) {
		super.call("set_quit_on_go_back", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDebug_collisions_hint() {
		return (boolean) super.call("is_debugging_collisions_hint", new java.lang.Object[0]);
	}

	public void setDebug_collisions_hint(boolean value) {
		super.call("set_debug_collisions_hint", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDebug_paths_hint() {
		return (boolean) super.call("is_debugging_paths_hint", new java.lang.Object[0]);
	}

	public void setDebug_paths_hint(boolean value) {
		super.call("set_debug_paths_hint", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDebug_navigation_hint() {
		return (boolean) super.call("is_debugging_navigation_hint", new java.lang.Object[0]);
	}

	public void setDebug_navigation_hint(boolean value) {
		super.call("set_debug_navigation_hint", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPaused() {
		return (boolean) super.call("is_paused", new java.lang.Object[0]);
	}

	public void setPaused(boolean value) {
		super.call("set_pause", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Node getEdited_scene_root() {
		return (Node) super.call("get_edited_scene_root", new java.lang.Object[0]);
	}

	public void setEdited_scene_root(Node value) {
		super.call("set_edited_scene_root", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Node getCurrent_scene() {
		return (Node) super.call("get_current_scene", new java.lang.Object[0]);
	}

	public void setCurrent_scene(Node value) {
		super.call("set_current_scene", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Node getRoot() {
		return (Node) super.call("get_root", new java.lang.Object[0]);
	}

	public void setRoot(Node value) {
		super.call("set_root", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isMultiplayer_poll() {
		return (boolean) super.call("is_multiplayer_poll_enabled", new java.lang.Object[0]);
	}

	public void setMultiplayer_poll(boolean value) {
		super.call("set_multiplayer_poll_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPhysics_interpolation() {
		return (boolean) super.call("is_physics_interpolation_enabled", new java.lang.Object[0]);
	}

	public void setPhysics_interpolation(boolean value) {
		super.call("set_physics_interpolation_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
