package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.Callable;

public class EditorPlugin extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("remove_scene_format_importer_plugin", 2637776123L),
			java.util.Map.entry("add_tool_submenu_item", 1019428915L),
			java.util.Map.entry("add_translation_parser_plugin", 3116463128L),
			java.util.Map.entry("add_autoload_singleton", 3186203200L),
			java.util.Map.entry("queue_save_layout", 3218959716L),
			java.util.Map.entry("remove_undo_redo_inspector_hook_callback", 1611583062L),
			java.util.Map.entry("remove_custom_type", 83702148L),
			java.util.Map.entry("get_editor_interface", 4223731786L),
			java.util.Map.entry("add_node_3d_gizmo_plugin", 1541015022L),
			java.util.Map.entry("remove_inspector_plugin", 546395733L),
			java.util.Map.entry("remove_control_from_docks", 1496901182L),
			java.util.Map.entry("get_plugin_version", 201670096L),
			java.util.Map.entry("remove_translation_parser_plugin", 3116463128L),
			java.util.Map.entry("add_context_menu_plugin", 1904221872L),
			java.util.Map.entry("remove_control_from_container", 3092750152L),
			java.util.Map.entry("add_scene_format_importer_plugin", 2764104752L),
			java.util.Map.entry("add_export_platform", 3431312373L),
			java.util.Map.entry("remove_tool_menu_item", 83702148L),
			java.util.Map.entry("make_bottom_panel_item_visible", 1496901182L),
			java.util.Map.entry("remove_context_menu_plugin", 2281511854L),
			java.util.Map.entry("add_import_plugin", 3113975762L),
			java.util.Map.entry("add_inspector_plugin", 546395733L),
			java.util.Map.entry("remove_import_plugin", 2312482773L),
			java.util.Map.entry("remove_scene_post_import_plugin", 3045178206L),
			java.util.Map.entry("update_overlays", 3905245786L),
			java.util.Map.entry("add_resource_conversion_plugin", 2124849111L),
			java.util.Map.entry("add_scene_post_import_plugin", 3492436322L),
			java.util.Map.entry("add_custom_type", 1986814599L),
			java.util.Map.entry("remove_resource_conversion_plugin", 2124849111L),
			java.util.Map.entry("get_script_create_dialog", 3121871482L),
			java.util.Map.entry("add_control_to_bottom_panel", 111032269L),
			java.util.Map.entry("set_input_event_forwarding_always_enabled", 3218959716L),
			java.util.Map.entry("get_undo_redo", 773492341L),
			java.util.Map.entry("remove_export_platform", 3431312373L),
			java.util.Map.entry("add_debugger_plugin", 3749880309L),
			java.util.Map.entry("add_undo_redo_inspector_hook_callback", 1611583062L),
			java.util.Map.entry("remove_autoload_singleton", 83702148L), java.util.Map.entry("add_dock", 158651717L),
			java.util.Map.entry("remove_export_plugin", 4095952207L),
			java.util.Map.entry("remove_node_3d_gizmo_plugin", 1541015022L),
			java.util.Map.entry("remove_control_from_bottom_panel", 1496901182L),
			java.util.Map.entry("add_control_to_dock", 2994930786L),
			java.util.Map.entry("set_dock_tab_icon", 3450529724L),
			java.util.Map.entry("add_export_plugin", 4095952207L),
			java.util.Map.entry("set_force_draw_over_forwarding_enabled", 3218959716L),
			java.util.Map.entry("hide_bottom_panel", 3218959716L),
			java.util.Map.entry("add_control_to_container", 3092750152L),
			java.util.Map.entry("remove_dock", 158651717L), java.util.Map.entry("remove_debugger_plugin", 3749880309L),
			java.util.Map.entry("get_export_as_menu", 1775878644L),
			java.util.Map.entry("add_tool_menu_item", 2137474292L));

	EditorPlugin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorPlugin(long nativePointer) {
		super(nativePointer);
	}

	public void add_dock(EditorDock dock) {
		super.call("add_dock", new java.lang.Object[]{(java.lang.Object) dock});
	}

	public void remove_dock(EditorDock dock) {
		super.call("remove_dock", new java.lang.Object[]{(java.lang.Object) dock});
	}

	public void add_control_to_container(int container, Control control) {
		super.call("add_control_to_container",
				new java.lang.Object[]{java.lang.Integer.valueOf(container), (java.lang.Object) control});
	}

	public void remove_control_from_container(int container, Control control) {
		super.call("remove_control_from_container",
				new java.lang.Object[]{java.lang.Integer.valueOf(container), (java.lang.Object) control});
	}

	public void add_tool_menu_item(String name, Callable callable) {
		super.call("add_tool_menu_item", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) callable});
	}

	public void add_tool_submenu_item(String name, PopupMenu submenu) {
		super.call("add_tool_submenu_item",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) submenu});
	}

	public void remove_tool_menu_item(String name) {
		super.call("remove_tool_menu_item", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void add_custom_type(String type, String base, Script script, Texture2D icon) {
		super.call("add_custom_type", new java.lang.Object[]{(java.lang.Object) type, (java.lang.Object) base,
				(java.lang.Object) script, (java.lang.Object) icon});
	}

	public void remove_custom_type(String type) {
		super.call("remove_custom_type", new java.lang.Object[]{(java.lang.Object) type});
	}

	public void add_control_to_dock(int slot, Control control, Shortcut shortcut) {
		super.call("add_control_to_dock", new java.lang.Object[]{java.lang.Integer.valueOf(slot),
				(java.lang.Object) control, (java.lang.Object) shortcut});
	}

	public void remove_control_from_docks(Control control) {
		super.call("remove_control_from_docks", new java.lang.Object[]{(java.lang.Object) control});
	}

	public void set_dock_tab_icon(Control control, Texture2D icon) {
		super.call("set_dock_tab_icon", new java.lang.Object[]{(java.lang.Object) control, (java.lang.Object) icon});
	}

	public Button add_control_to_bottom_panel(Control control, String title, Shortcut shortcut) {
		return (Button) super.call("add_control_to_bottom_panel", new java.lang.Object[]{(java.lang.Object) control,
				(java.lang.Object) title, (java.lang.Object) shortcut});
	}

	public void remove_control_from_bottom_panel(Control control) {
		super.call("remove_control_from_bottom_panel", new java.lang.Object[]{(java.lang.Object) control});
	}

	public void add_autoload_singleton(String name, String path) {
		super.call("add_autoload_singleton", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) path});
	}

	public void remove_autoload_singleton(String name) {
		super.call("remove_autoload_singleton", new java.lang.Object[]{(java.lang.Object) name});
	}

	public int update_overlays() {
		return (int) super.call("update_overlays");
	}

	public void make_bottom_panel_item_visible(Control item) {
		super.call("make_bottom_panel_item_visible", new java.lang.Object[]{(java.lang.Object) item});
	}

	public void hide_bottom_panel() {
		super.call("hide_bottom_panel");
	}

	public void add_undo_redo_inspector_hook_callback(Callable callable) {
		super.call("add_undo_redo_inspector_hook_callback", new java.lang.Object[]{(java.lang.Object) callable});
	}

	public void remove_undo_redo_inspector_hook_callback(Callable callable) {
		super.call("remove_undo_redo_inspector_hook_callback", new java.lang.Object[]{(java.lang.Object) callable});
	}

	public void queue_save_layout() {
		super.call("queue_save_layout");
	}

	public void add_translation_parser_plugin(EditorTranslationParserPlugin parser) {
		super.call("add_translation_parser_plugin", new java.lang.Object[]{(java.lang.Object) parser});
	}

	public void remove_translation_parser_plugin(EditorTranslationParserPlugin parser) {
		super.call("remove_translation_parser_plugin", new java.lang.Object[]{(java.lang.Object) parser});
	}

	public void add_import_plugin(EditorImportPlugin importer, boolean first_priority) {
		super.call("add_import_plugin",
				new java.lang.Object[]{(java.lang.Object) importer, java.lang.Boolean.valueOf(first_priority)});
	}

	public void remove_import_plugin(EditorImportPlugin importer) {
		super.call("remove_import_plugin", new java.lang.Object[]{(java.lang.Object) importer});
	}

	public void add_scene_format_importer_plugin(EditorSceneFormatImporter scene_format_importer,
			boolean first_priority) {
		super.call("add_scene_format_importer_plugin", new java.lang.Object[]{(java.lang.Object) scene_format_importer,
				java.lang.Boolean.valueOf(first_priority)});
	}

	public void remove_scene_format_importer_plugin(EditorSceneFormatImporter scene_format_importer) {
		super.call("remove_scene_format_importer_plugin",
				new java.lang.Object[]{(java.lang.Object) scene_format_importer});
	}

	public void add_scene_post_import_plugin(EditorScenePostImportPlugin scene_import_plugin, boolean first_priority) {
		super.call("add_scene_post_import_plugin", new java.lang.Object[]{(java.lang.Object) scene_import_plugin,
				java.lang.Boolean.valueOf(first_priority)});
	}

	public void remove_scene_post_import_plugin(EditorScenePostImportPlugin scene_import_plugin) {
		super.call("remove_scene_post_import_plugin", new java.lang.Object[]{(java.lang.Object) scene_import_plugin});
	}

	public void add_export_plugin(EditorExportPlugin plugin) {
		super.call("add_export_plugin", new java.lang.Object[]{(java.lang.Object) plugin});
	}

	public void remove_export_plugin(EditorExportPlugin plugin) {
		super.call("remove_export_plugin", new java.lang.Object[]{(java.lang.Object) plugin});
	}

	public void add_export_platform(EditorExportPlatform platform) {
		super.call("add_export_platform", new java.lang.Object[]{(java.lang.Object) platform});
	}

	public void remove_export_platform(EditorExportPlatform platform) {
		super.call("remove_export_platform", new java.lang.Object[]{(java.lang.Object) platform});
	}

	public void add_node_3d_gizmo_plugin(EditorNode3DGizmoPlugin plugin) {
		super.call("add_node_3d_gizmo_plugin", new java.lang.Object[]{(java.lang.Object) plugin});
	}

	public void remove_node_3d_gizmo_plugin(EditorNode3DGizmoPlugin plugin) {
		super.call("remove_node_3d_gizmo_plugin", new java.lang.Object[]{(java.lang.Object) plugin});
	}

	public void add_inspector_plugin(EditorInspectorPlugin plugin) {
		super.call("add_inspector_plugin", new java.lang.Object[]{(java.lang.Object) plugin});
	}

	public void remove_inspector_plugin(EditorInspectorPlugin plugin) {
		super.call("remove_inspector_plugin", new java.lang.Object[]{(java.lang.Object) plugin});
	}

	public void add_resource_conversion_plugin(EditorResourceConversionPlugin plugin) {
		super.call("add_resource_conversion_plugin", new java.lang.Object[]{(java.lang.Object) plugin});
	}

	public void remove_resource_conversion_plugin(EditorResourceConversionPlugin plugin) {
		super.call("remove_resource_conversion_plugin", new java.lang.Object[]{(java.lang.Object) plugin});
	}

	public void set_input_event_forwarding_always_enabled() {
		super.call("set_input_event_forwarding_always_enabled");
	}

	public void set_force_draw_over_forwarding_enabled() {
		super.call("set_force_draw_over_forwarding_enabled");
	}

	public void add_context_menu_plugin(int slot, EditorContextMenuPlugin plugin) {
		super.call("add_context_menu_plugin",
				new java.lang.Object[]{java.lang.Integer.valueOf(slot), (java.lang.Object) plugin});
	}

	public void remove_context_menu_plugin(EditorContextMenuPlugin plugin) {
		super.call("remove_context_menu_plugin", new java.lang.Object[]{(java.lang.Object) plugin});
	}

	public void add_debugger_plugin(EditorDebuggerPlugin script) {
		super.call("add_debugger_plugin", new java.lang.Object[]{(java.lang.Object) script});
	}

	public void remove_debugger_plugin(EditorDebuggerPlugin script) {
		super.call("remove_debugger_plugin", new java.lang.Object[]{(java.lang.Object) script});
	}
}
