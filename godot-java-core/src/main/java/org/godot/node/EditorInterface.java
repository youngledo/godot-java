package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.GodotObject;
import org.godot.core.Callable;
import org.godot.math.Rect2i;
import org.godot.math.Vector2i;

public class EditorInterface extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_object_edited", 1462101905L), java.util.Map.entry("get_inspector", 3517113938L),
			java.util.Map.entry("get_editor_theme", 3846893731L),
			java.util.Map.entry("popup_node_selector", 2444591477L),
			java.util.Map.entry("set_plugin_enabled", 2678287736L),
			java.util.Map.entry("get_current_feature_profile", 201670096L),
			java.util.Map.entry("get_selection", 2690272531L), java.util.Map.entry("get_selected_paths", 1139954409L),
			java.util.Map.entry("select_file", 83702148L), java.util.Map.entry("is_playing_scene", 36873697L),
			java.util.Map.entry("get_resource_filesystem", 780151678L),
			java.util.Map.entry("get_resource_previewer", 943486957L),
			java.util.Map.entry("get_command_palette", 2471163807L),
			java.util.Map.entry("popup_method_selector", 3585505226L),
			java.util.Map.entry("make_mesh_previews", 878078554L), java.util.Map.entry("edit_resource", 968641751L),
			java.util.Map.entry("play_custom_scene", 83702148L), java.util.Map.entry("play_current_scene", 3218959716L),
			java.util.Map.entry("get_current_path", 201670096L), java.util.Map.entry("get_script_editor", 90868003L),
			java.util.Map.entry("is_plugin_enabled", 3927539163L),
			java.util.Map.entry("get_editor_viewport_3d", 1970834490L),
			java.util.Map.entry("get_editor_settings", 4086932459L), java.util.Map.entry("restart_editor", 3216645846L),
			java.util.Map.entry("is_multi_window_enabled", 36873697L), java.util.Map.entry("close_scene", 166280745L),
			java.util.Map.entry("save_all_scenes", 3218959716L),
			java.util.Map.entry("set_current_feature_profile", 83702148L),
			java.util.Map.entry("get_editor_language", 201670096L),
			java.util.Map.entry("open_scene_from_path", 1168363258L),
			java.util.Map.entry("get_node_3d_rotate_snap", 1740695150L),
			java.util.Map.entry("get_editor_main_screen", 1706218421L),
			java.util.Map.entry("inspect_object", 127962172L),
			java.util.Map.entry("get_editor_viewport_2d", 3750751911L),
			java.util.Map.entry("get_playing_scene", 201670096L),
			java.util.Map.entry("get_edited_scene_root", 3160264692L),
			java.util.Map.entry("popup_dialog_centered_clamped", 3763385571L),
			java.util.Map.entry("is_movie_maker_enabled", 36873697L),
			java.util.Map.entry("mark_scene_as_unsaved", 3218959716L),
			java.util.Map.entry("add_root_node", 1078189570L),
			java.util.Map.entry("is_distraction_free_mode_enabled", 36873697L),
			java.util.Map.entry("edit_node", 1078189570L), java.util.Map.entry("popup_create_dialog", 495277124L),
			java.util.Map.entry("popup_dialog_centered_ratio", 2093669136L),
			java.util.Map.entry("play_main_scene", 3218959716L), java.util.Map.entry("get_editor_toaster", 3612675797L),
			java.util.Map.entry("is_node_3d_snap_enabled", 36873697L),
			java.util.Map.entry("set_distraction_free_mode", 2586408642L),
			java.util.Map.entry("popup_quick_open", 2271411043L), java.util.Map.entry("save_scene", 166280745L),
			java.util.Map.entry("get_current_directory", 201670096L),
			java.util.Map.entry("popup_dialog_centered", 346557367L),
			java.util.Map.entry("set_main_screen_editor", 83702148L),
			java.util.Map.entry("get_node_3d_scale_snap", 1740695150L),
			java.util.Map.entry("popup_dialog", 2015770942L),
			java.util.Map.entry("set_movie_maker_enabled", 2586408642L),
			java.util.Map.entry("get_editor_paths", 1595760068L),
			java.util.Map.entry("get_editor_undo_redo", 3819628421L),
			java.util.Map.entry("get_open_scene_roots", 3995934104L),
			java.util.Map.entry("get_editor_scale", 1740695150L), java.util.Map.entry("get_base_control", 2783021301L),
			java.util.Map.entry("reload_scene_from_path", 83702148L),
			java.util.Map.entry("popup_property_selector", 2955609011L),
			java.util.Map.entry("get_file_system_dock", 3751012327L),
			java.util.Map.entry("get_node_3d_translate_snap", 1740695150L),
			java.util.Map.entry("edit_script", 219829402L), java.util.Map.entry("get_open_scenes", 1139954409L),
			java.util.Map.entry("save_scene_as", 3647332257L), java.util.Map.entry("stop_playing_scene", 3218959716L),
			java.util.Map.entry("is_object_edited", 397768994L));

	EditorInterface(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorInterface(long nativePointer) {
		super(nativePointer);
	}

	public void restart_editor(boolean save) {
		super.call("restart_editor", new java.lang.Object[]{java.lang.Boolean.valueOf(save)});
	}

	public Texture2D[] make_mesh_previews(Mesh[] meshes, long preview_size) {
		return (Texture2D[]) super.call("make_mesh_previews",
				new java.lang.Object[]{(java.lang.Object) meshes, java.lang.Long.valueOf(preview_size)});
	}

	public void set_plugin_enabled(String plugin, boolean enabled) {
		super.call("set_plugin_enabled",
				new java.lang.Object[]{(java.lang.Object) plugin, java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_plugin_enabled(String plugin) {
		return (boolean) super.call("is_plugin_enabled", new java.lang.Object[]{(java.lang.Object) plugin});
	}

	public SubViewport get_editor_viewport_3d(long idx) {
		return (SubViewport) super.call("get_editor_viewport_3d", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public boolean is_distraction_free_mode_enabled() {
		return (boolean) super.call("is_distraction_free_mode_enabled");
	}

	public boolean is_multi_window_enabled() {
		return (boolean) super.call("is_multi_window_enabled");
	}

	public boolean is_node_3d_snap_enabled() {
		return (boolean) super.call("is_node_3d_snap_enabled");
	}

	public void popup_dialog(Window dialog, Rect2i rect) {
		super.call("popup_dialog", new java.lang.Object[]{(java.lang.Object) dialog, (java.lang.Object) rect});
	}

	public void popup_dialog_centered(Window dialog, Vector2i minsize) {
		super.call("popup_dialog_centered",
				new java.lang.Object[]{(java.lang.Object) dialog, (java.lang.Object) minsize});
	}

	public void popup_dialog_centered_ratio(Window dialog, double ratio) {
		super.call("popup_dialog_centered_ratio",
				new java.lang.Object[]{(java.lang.Object) dialog, java.lang.Double.valueOf(ratio)});
	}

	public void popup_dialog_centered_clamped(Window dialog, Vector2i minsize, double fallback_ratio) {
		super.call("popup_dialog_centered_clamped", new java.lang.Object[]{(java.lang.Object) dialog,
				(java.lang.Object) minsize, java.lang.Double.valueOf(fallback_ratio)});
	}

	public void popup_node_selector(Callable callback, String[] valid_types, Node current_value) {
		super.call("popup_node_selector", new java.lang.Object[]{(java.lang.Object) callback,
				(java.lang.Object) valid_types, (java.lang.Object) current_value});
	}

	public void popup_property_selector(GodotObject object, Callable callback, int[] type_filter,
			String current_value) {
		super.call("popup_property_selector", new java.lang.Object[]{(java.lang.Object) object,
				(java.lang.Object) callback, (java.lang.Object) type_filter, (java.lang.Object) current_value});
	}

	public void popup_method_selector(GodotObject object, Callable callback, String current_value) {
		super.call("popup_method_selector", new java.lang.Object[]{(java.lang.Object) object,
				(java.lang.Object) callback, (java.lang.Object) current_value});
	}

	public void popup_quick_open(Callable callback, String[] base_types) {
		super.call("popup_quick_open",
				new java.lang.Object[]{(java.lang.Object) callback, (java.lang.Object) base_types});
	}

	public void popup_create_dialog(Callable callback, String base_type, String current_type, String dialog_title,
			String[] type_blocklist) {
		super.call("popup_create_dialog",
				new java.lang.Object[]{(java.lang.Object) callback, (java.lang.Object) base_type,
						(java.lang.Object) current_type, (java.lang.Object) dialog_title,
						(java.lang.Object) type_blocklist});
	}

	public void select_file(String file) {
		super.call("select_file", new java.lang.Object[]{(java.lang.Object) file});
	}

	public void inspect_object(GodotObject object, String for_property, boolean inspector_only) {
		super.call("inspect_object", new java.lang.Object[]{(java.lang.Object) object, (java.lang.Object) for_property,
				java.lang.Boolean.valueOf(inspector_only)});
	}

	public void edit_resource(Resource resource) {
		super.call("edit_resource", new java.lang.Object[]{(java.lang.Object) resource});
	}

	public void edit_node(Node node) {
		super.call("edit_node", new java.lang.Object[]{(java.lang.Object) node});
	}

	public void edit_script(Script script, long line, long column, boolean grab_focus) {
		super.call("edit_script", new java.lang.Object[]{(java.lang.Object) script, java.lang.Long.valueOf(line),
				java.lang.Long.valueOf(column), java.lang.Boolean.valueOf(grab_focus)});
	}

	public void open_scene_from_path(String scene_filepath, boolean set_inherited) {
		super.call("open_scene_from_path",
				new java.lang.Object[]{(java.lang.Object) scene_filepath, java.lang.Boolean.valueOf(set_inherited)});
	}

	public void reload_scene_from_path(String scene_filepath) {
		super.call("reload_scene_from_path", new java.lang.Object[]{(java.lang.Object) scene_filepath});
	}

	public void set_object_edited(GodotObject object, boolean edited) {
		super.call("set_object_edited",
				new java.lang.Object[]{(java.lang.Object) object, java.lang.Boolean.valueOf(edited)});
	}

	public boolean is_object_edited(GodotObject object) {
		return (boolean) super.call("is_object_edited", new java.lang.Object[]{(java.lang.Object) object});
	}

	public void add_root_node(Node node) {
		super.call("add_root_node", new java.lang.Object[]{(java.lang.Object) node});
	}

	public int save_scene() {
		return (int) super.call("save_scene");
	}

	public void save_scene_as(String path, boolean with_preview) {
		super.call("save_scene_as",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Boolean.valueOf(with_preview)});
	}

	public void save_all_scenes() {
		super.call("save_all_scenes");
	}

	public int close_scene() {
		return (int) super.call("close_scene");
	}

	public void mark_scene_as_unsaved() {
		super.call("mark_scene_as_unsaved");
	}

	public void play_main_scene() {
		super.call("play_main_scene");
	}

	public void play_current_scene() {
		super.call("play_current_scene");
	}

	public void play_custom_scene(String scene_filepath) {
		super.call("play_custom_scene", new java.lang.Object[]{(java.lang.Object) scene_filepath});
	}

	public void stop_playing_scene() {
		super.call("stop_playing_scene");
	}

	public boolean is_playing_scene() {
		return (boolean) super.call("is_playing_scene");
	}

	public boolean is_movie_maker_enabled() {
		return (boolean) super.call("is_movie_maker_enabled");
	}

	public boolean isDistraction_free_mode() {
		return (boolean) super.call("is_distraction_free_mode_enabled", new java.lang.Object[0]);
	}

	public void setDistraction_free_mode(boolean value) {
		super.call("set_distraction_free_mode", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isMovie_maker_enabled() {
		return (boolean) super.call("is_movie_maker_enabled", new java.lang.Object[0]);
	}

	public void setMovie_maker_enabled(boolean value) {
		super.call("set_movie_maker_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
