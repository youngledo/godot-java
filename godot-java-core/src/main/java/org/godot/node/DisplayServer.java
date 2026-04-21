package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.GodotObject;
import org.godot.collection.GodotDictionary;
import org.godot.core.Callable;
import org.godot.math.Color;
import org.godot.math.Rect2;
import org.godot.math.Rect2i;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;
import org.godot.math.Vector3i;

public class DisplayServer extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("window_get_popup_safe_rect", 2161169500L), java.util.Map.entry("beep", 4051624405L),
			java.util.Map.entry("window_get_native_handle", 1096425680L),
			java.util.Map.entry("accessibility_update_set_scroll_x_range", 2513314492L),
			java.util.Map.entry("unregister_additional_output", 3975164845L),
			java.util.Map.entry("is_dark_mode_supported", 36873697L),
			java.util.Map.entry("window_can_draw", 1051549951L), java.util.Map.entry("cursor_get_shape", 1087724927L),
			java.util.Map.entry("accessibility_update_add_custom_action", 4153150897L),
			java.util.Map.entry("get_window_list", 1930428628L),
			java.util.Map.entry("global_menu_set_item_indentation_level", 3474840532L),
			java.util.Map.entry("tts_set_utterance_callback", 109679083L), java.util.Map.entry("get_name", 201670096L),
			java.util.Map.entry("accessibility_update_set_state_description", 2726140452L),
			java.util.Map.entry("clipboard_has_image", 36873697L),
			java.util.Map.entry("global_menu_is_item_disabled", 3511468594L),
			java.util.Map.entry("mouse_get_mode", 1353961651L), java.util.Map.entry("get_screen_count", 3905245786L),
			java.util.Map.entry("virtual_keyboard_hide", 3218959716L),
			java.util.Map.entry("status_indicator_set_tooltip", 501894301L),
			java.util.Map.entry("screen_get_image", 3813388802L),
			java.util.Map.entry("accessibility_update_set_text_selection", 3119144029L),
			java.util.Map.entry("mouse_get_button_state", 2512161324L),
			java.util.Map.entry("global_menu_remove_item", 2956805083L),
			java.util.Map.entry("screen_get_image_rect", 2601441065L),
			java.util.Map.entry("accessibility_update_set_table_column_count", 3411492887L),
			java.util.Map.entry("window_set_window_event_callback", 1091192925L),
			java.util.Map.entry("accessibility_update_set_member_of", 395945892L),
			java.util.Map.entry("accessibility_update_set_scroll_y", 1794382983L),
			java.util.Map.entry("accessibility_update_set_scroll_x", 1794382983L),
			java.util.Map.entry("accessibility_update_set_role_description", 2726140452L),
			java.util.Map.entry("global_menu_set_item_checkable", 4108344793L),
			java.util.Map.entry("global_menu_is_item_radio_checkable", 3511468594L),
			java.util.Map.entry("accessibility_update_set_language", 2726140452L),
			java.util.Map.entry("global_menu_get_item_max_states", 3422818498L),
			java.util.Map.entry("window_get_min_size", 763922886L),
			java.util.Map.entry("window_get_max_size", 763922886L),
			java.util.Map.entry("global_menu_set_popup_callbacks", 3893727526L),
			java.util.Map.entry("accessibility_should_reduce_transparency", 3905245786L),
			java.util.Map.entry("accessibility_update_set_table_row_index", 3411492887L),
			java.util.Map.entry("global_menu_set_item_callback", 3809915389L),
			java.util.Map.entry("tts_pause", 3218959716L),
			java.util.Map.entry("keyboard_get_current_layout", 3905245786L),
			java.util.Map.entry("accessibility_should_increase_contrast", 3905245786L),
			java.util.Map.entry("accessibility_element_get_meta", 4171304767L),
			java.util.Map.entry("accessibility_update_set_num_jump", 1794382983L),
			java.util.Map.entry("status_indicator_set_menu", 4040184819L),
			java.util.Map.entry("accessibility_update_add_child", 395945892L),
			java.util.Map.entry("accessibility_update_set_table_row_count", 3411492887L),
			java.util.Map.entry("global_menu_add_icon_item", 3867083847L),
			java.util.Map.entry("accessibility_update_add_related_controls", 395945892L),
			java.util.Map.entry("window_get_size_with_decorations", 763922886L),
			java.util.Map.entry("ime_get_text", 201670096L),
			java.util.Map.entry("accessibility_update_set_num_range", 2513314492L),
			java.util.Map.entry("screen_get_usable_rect", 2439012528L),
			java.util.Map.entry("global_menu_get_item_tag", 330672633L),
			java.util.Map.entry("mouse_set_mode", 348288463L),
			java.util.Map.entry("accessibility_update_set_focus", 2722037293L),
			java.util.Map.entry("accessibility_update_set_flag", 3758675396L),
			java.util.Map.entry("global_menu_get_item_callback", 748666903L),
			java.util.Map.entry("global_menu_set_item_hover_callbacks", 3809915389L),
			java.util.Map.entry("screen_set_orientation", 2211511631L),
			java.util.Map.entry("accessibility_update_set_list_item_expanded", 1265174801L),
			java.util.Map.entry("global_menu_set_item_radio_checkable", 4108344793L),
			java.util.Map.entry("global_menu_add_submenu_item", 2828985934L),
			java.util.Map.entry("accessibility_create_sub_text_edit_elements", 2702009895L),
			java.util.Map.entry("dialog_input_text", 3088703427L),
			java.util.Map.entry("virtual_keyboard_show", 3042891259L),
			java.util.Map.entry("global_menu_add_multistate_item", 3297554655L),
			java.util.Map.entry("set_icon", 532598488L),
			java.util.Map.entry("global_menu_set_item_submenu", 965966136L),
			java.util.Map.entry("accessibility_update_set_extra_info", 2726140452L),
			java.util.Map.entry("keyboard_get_keycode_from_physical", 3447613187L),
			java.util.Map.entry("global_menu_is_item_checkable", 3511468594L),
			java.util.Map.entry("window_get_position_with_decorations", 763922886L),
			java.util.Map.entry("accessibility_update_set_popup_type", 2040885448L),
			java.util.Map.entry("window_start_resize", 4009722312L),
			java.util.Map.entry("global_menu_get_item_index_from_text", 2878152881L),
			java.util.Map.entry("is_dark_mode", 36873697L),
			java.util.Map.entry("accessibility_update_set_value", 2726140452L),
			java.util.Map.entry("window_start_drag", 1995695955L),
			java.util.Map.entry("accessibility_set_window_rect", 2386961724L),
			java.util.Map.entry("global_menu_add_separator", 3214812433L),
			java.util.Map.entry("accessibility_update_add_related_flow_to", 395945892L),
			java.util.Map.entry("global_menu_set_item_accelerator", 566943293L),
			java.util.Map.entry("accessibility_has_element", 4155700596L),
			java.util.Map.entry("accessibility_update_set_background_color", 2948539648L),
			java.util.Map.entry("has_additional_outputs", 36873697L),
			java.util.Map.entry("global_menu_set_item_key_callback", 3809915389L),
			java.util.Map.entry("window_set_size", 2019273902L),
			java.util.Map.entry("window_get_safe_title_margins", 2295066620L),
			java.util.Map.entry("global_menu_set_item_tag", 453659863L),
			java.util.Map.entry("accessibility_update_set_table_column_index", 3411492887L),
			java.util.Map.entry("window_set_transient", 3937882851L),
			java.util.Map.entry("accessibility_update_add_related_radio_group", 395945892L),
			java.util.Map.entry("accessibility_update_set_table_cell_position", 4288446313L),
			java.util.Map.entry("global_menu_is_item_checked", 3511468594L),
			java.util.Map.entry("accessibility_element_set_meta", 3175752987L),
			java.util.Map.entry("accessibility_set_window_focused", 300928843L),
			java.util.Map.entry("accessibility_update_set_scroll_y_range", 2513314492L),
			java.util.Map.entry("status_indicator_get_rect", 3327874267L),
			java.util.Map.entry("global_menu_set_item_text", 965966136L),
			java.util.Map.entry("window_set_window_buttons_offset", 2019273902L),
			java.util.Map.entry("window_request_attention", 1995695955L),
			java.util.Map.entry("color_picker", 151643214L),
			java.util.Map.entry("tablet_get_current_driver", 201670096L),
			java.util.Map.entry("global_menu_set_item_hidden", 4108344793L),
			java.util.Map.entry("accessibility_update_set_active_descendant", 395945892L),
			java.util.Map.entry("accessibility_update_set_num_value", 1794382983L),
			java.util.Map.entry("tts_is_paused", 36873697L),
			java.util.Map.entry("enable_for_stealing_focus", 1286410249L),
			java.util.Map.entry("global_menu_get_item_indentation_level", 3422818498L),
			java.util.Map.entry("get_accent_color", 3444240500L),
			java.util.Map.entry("window_set_rect_changed_callback", 1091192925L),
			java.util.Map.entry("get_keyboard_focus_screen", 3905245786L),
			java.util.Map.entry("accessibility_free_element", 2722037293L),
			java.util.Map.entry("keyboard_set_current_layout", 1286410249L),
			java.util.Map.entry("accessibility_update_set_placeholder", 2726140452L),
			java.util.Map.entry("get_screen_from_rect", 741354659L),
			java.util.Map.entry("accessibility_update_set_description", 2726140452L),
			java.util.Map.entry("get_primary_screen", 3905245786L),
			java.util.Map.entry("accessibility_update_set_name", 2726140452L),
			java.util.Map.entry("accessibility_update_set_error_message", 395945892L),
			java.util.Map.entry("cursor_set_custom_image", 1816663697L),
			java.util.Map.entry("global_menu_get_item_tooltip", 591067909L),
			java.util.Map.entry("get_window_at_screen_position", 2485466453L),
			java.util.Map.entry("process_events", 3218959716L), java.util.Map.entry("tts_stop", 3218959716L),
			java.util.Map.entry("clipboard_get_primary", 201670096L),
			java.util.Map.entry("accessibility_create_element", 2968347744L),
			java.util.Map.entry("tablet_set_current_driver", 83702148L),
			java.util.Map.entry("global_menu_get_system_menu_roots", 3102165223L),
			java.util.Map.entry("accessibility_update_set_tooltip", 2726140452L),
			java.util.Map.entry("window_get_active_popup", 3905245786L),
			java.util.Map.entry("screen_get_scale", 909105437L),
			java.util.Map.entry("accessibility_update_set_url", 2726140452L),
			java.util.Map.entry("has_hardware_keyboard", 36873697L),
			java.util.Map.entry("global_menu_get_item_text", 591067909L),
			java.util.Map.entry("accessibility_update_set_live", 2683302212L),
			java.util.Map.entry("accessibility_update_set_list_item_count", 3411492887L),
			java.util.Map.entry("window_set_ime_position", 2019273902L),
			java.util.Map.entry("global_menu_set_item_state", 3474840532L),
			java.util.Map.entry("get_base_color", 3444240500L),
			java.util.Map.entry("accessibility_update_add_action", 2898696987L),
			java.util.Map.entry("global_menu_get_item_state", 3422818498L),
			java.util.Map.entry("global_menu_get_item_accelerator", 936065394L),
			java.util.Map.entry("global_menu_add_check_item", 3616842746L),
			java.util.Map.entry("global_menu_set_item_disabled", 4108344793L),
			java.util.Map.entry("dialog_show", 4115553226L), java.util.Map.entry("clipboard_get", 201670096L),
			java.util.Map.entry("window_set_exclusive", 300928843L), java.util.Map.entry("window_get_flag", 802816991L),
			java.util.Map.entry("accessibility_create_sub_element", 1949948826L),
			java.util.Map.entry("screen_get_refresh_rate", 909105437L),
			java.util.Map.entry("global_menu_add_icon_check_item", 3867083847L),
			java.util.Map.entry("accessibility_update_set_transform", 1246044741L),
			java.util.Map.entry("global_menu_add_radio_check_item", 3616842746L),
			java.util.Map.entry("force_process_and_drop_events", 3218959716L),
			java.util.Map.entry("keyboard_get_layout_count", 3905245786L),
			java.util.Map.entry("file_dialog_with_options_show", 1448789813L),
			java.util.Map.entry("register_additional_output", 3975164845L),
			java.util.Map.entry("global_menu_set_item_icon", 3201338066L),
			java.util.Map.entry("window_set_popup_safe_rect", 3317281434L),
			java.util.Map.entry("clipboard_set_primary", 83702148L),
			java.util.Map.entry("accessibility_update_set_in_page_link_target", 395945892L),
			java.util.Map.entry("global_menu_get_item_icon", 3591713183L),
			java.util.Map.entry("screen_get_max_scale", 1740695150L),
			java.util.Map.entry("get_display_safe_area", 410525958L),
			java.util.Map.entry("window_is_focused", 1051549951L), java.util.Map.entry("cursor_set_shape", 2026291549L),
			java.util.Map.entry("window_get_attached_instance_id", 1591665591L),
			java.util.Map.entry("accessibility_update_set_classname", 2726140452L),
			java.util.Map.entry("status_indicator_set_icon", 666127730L),
			java.util.Map.entry("accessibility_update_set_list_item_index", 3411492887L),
			java.util.Map.entry("window_set_flag", 254894155L), java.util.Map.entry("window_get_position", 763922886L),
			java.util.Map.entry("show_emoji_and_symbol_picker", 4051624405L),
			java.util.Map.entry("window_set_input_text_callback", 1091192925L),
			java.util.Map.entry("get_display_cutouts", 3995934104L),
			java.util.Map.entry("is_window_transparency_available", 36873697L),
			java.util.Map.entry("accessibility_update_add_related_details", 395945892L),
			java.util.Map.entry("set_system_theme_change_callback", 1611583062L),
			java.util.Map.entry("window_set_color", 2920490490L),
			java.util.Map.entry("accessibility_update_set_text_align", 3725995085L),
			java.util.Map.entry("screen_get_dpi", 181039630L),
			java.util.Map.entry("accessibility_update_set_role", 3352768215L),
			java.util.Map.entry("global_menu_get_item_submenu", 591067909L),
			java.util.Map.entry("window_maximize_on_title_dbl_click", 36873697L),
			java.util.Map.entry("global_menu_get_item_count", 1321353865L),
			java.util.Map.entry("tts_get_voices_for_language", 4291131558L),
			java.util.Map.entry("warp_mouse", 1130785943L), java.util.Map.entry("screen_is_kept_on", 36873697L),
			java.util.Map.entry("global_menu_set_item_max_states", 3474840532L),
			java.util.Map.entry("accessibility_should_reduce_animation", 3905245786L),
			java.util.Map.entry("window_set_mouse_passthrough", 1993637420L),
			java.util.Map.entry("tts_is_speaking", 36873697L), java.util.Map.entry("mouse_get_position", 3690982128L),
			java.util.Map.entry("accessibility_update_set_checked", 1265174801L),
			java.util.Map.entry("tts_get_voices", 3995934104L),
			java.util.Map.entry("accessibility_update_set_bounds", 1378122625L),
			java.util.Map.entry("window_get_title_size", 2925301799L),
			java.util.Map.entry("accessibility_update_set_previous_on_line", 395945892L),
			java.util.Map.entry("screen_get_position", 1725937825L),
			java.util.Map.entry("window_get_mode", 2185728461L),
			java.util.Map.entry("global_menu_add_icon_radio_check_item", 3867083847L),
			java.util.Map.entry("window_set_position", 2019273902L),
			java.util.Map.entry("accessibility_update_set_list_orientation", 1265174801L),
			java.util.Map.entry("global_menu_is_item_hidden", 3511468594L),
			java.util.Map.entry("accessibility_update_set_table_cell_span", 4288446313L),
			java.util.Map.entry("screen_get_size", 1725937825L), java.util.Map.entry("window_set_mode", 1319965401L),
			java.util.Map.entry("window_minimize_on_title_dbl_click", 36873697L),
			java.util.Map.entry("accessibility_update_set_shortcut", 2726140452L),
			java.util.Map.entry("window_set_input_event_callback", 1091192925L),
			java.util.Map.entry("delete_status_indicator", 1286410249L),
			java.util.Map.entry("tablet_get_driver_count", 3905245786L),
			java.util.Map.entry("window_set_ime_active", 1661950165L),
			java.util.Map.entry("window_get_size", 763922886L), java.util.Map.entry("tts_speak", 903992738L),
			java.util.Map.entry("window_move_to_foreground", 1995695955L),
			java.util.Map.entry("keyboard_get_layout_name", 844755477L),
			java.util.Map.entry("accessibility_update_set_text_decorations", 1672422386L),
			java.util.Map.entry("accessibility_update_set_color_value", 2948539648L),
			java.util.Map.entry("keyboard_get_layout_language", 844755477L),
			java.util.Map.entry("clipboard_has", 36873697L),
			java.util.Map.entry("global_menu_set_item_tooltip", 965966136L),
			java.util.Map.entry("is_touchscreen_available", 36873697L),
			java.util.Map.entry("accessibility_update_add_related_labeled_by", 395945892L),
			java.util.Map.entry("keyboard_get_label_from_physical", 3447613187L),
			java.util.Map.entry("window_get_current_screen", 1591665591L),
			java.util.Map.entry("accessibility_update_add_related_described_by", 395945892L),
			java.util.Map.entry("window_set_vsync_mode", 2179333492L),
			java.util.Map.entry("create_status_indicator", 1904285171L),
			java.util.Map.entry("global_menu_get_item_index_from_tag", 2941063483L),
			java.util.Map.entry("screen_set_keep_on", 2586408642L),
			java.util.Map.entry("window_set_drop_files_callback", 1091192925L),
			java.util.Map.entry("accessibility_get_window_root", 495598643L),
			java.util.Map.entry("window_is_maximize_allowed", 1051549951L),
			java.util.Map.entry("virtual_keyboard_get_height", 3905245786L),
			java.util.Map.entry("window_set_current_screen", 2230941749L),
			java.util.Map.entry("window_set_max_size", 2019273902L),
			java.util.Map.entry("accessibility_update_set_foreground_color", 2948539648L),
			java.util.Map.entry("tablet_get_driver_name", 844755477L),
			java.util.Map.entry("global_menu_set_item_checked", 4108344793L),
			java.util.Map.entry("set_hardware_keyboard_connection_change_callback", 1611583062L),
			java.util.Map.entry("get_swap_cancel_ok", 2240911060L),
			java.util.Map.entry("screen_get_pixel", 1532707496L), java.util.Map.entry("tts_resume", 3218959716L),
			java.util.Map.entry("window_set_title", 441246282L),
			java.util.Map.entry("global_menu_get_item_key_callback", 748666903L),
			java.util.Map.entry("accessibility_update_set_next_on_line", 395945892L),
			java.util.Map.entry("accessibility_update_set_num_step", 1794382983L),
			java.util.Map.entry("accessibility_update_set_list_item_level", 3411492887L),
			java.util.Map.entry("window_get_vsync_mode", 578873795L),
			java.util.Map.entry("status_indicator_set_callback", 957362965L),
			java.util.Map.entry("global_menu_add_item", 3616842746L),
			java.util.Map.entry("screen_get_orientation", 133818562L),
			java.util.Map.entry("file_dialog_show", 1386825884L),
			java.util.Map.entry("accessibility_screen_reader_active", 3905245786L),
			java.util.Map.entry("accessibility_update_set_list_item_selected", 1265174801L),
			java.util.Map.entry("global_menu_clear", 83702148L), java.util.Map.entry("ime_get_selection", 3690982128L),
			java.util.Map.entry("clipboard_set", 83702148L),
			java.util.Map.entry("help_set_search_callbacks", 1687350599L),
			java.util.Map.entry("set_native_icon", 83702148L),
			java.util.Map.entry("accessibility_update_set_text_orientation", 1265174801L),
			java.util.Map.entry("has_feature", 334065950L), java.util.Map.entry("window_set_min_size", 2019273902L),
			java.util.Map.entry("clipboard_get_image", 4190603485L));

	DisplayServer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	DisplayServer(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_feature(int feature) {
		return (boolean) super.call("has_feature", new java.lang.Object[]{java.lang.Integer.valueOf(feature)});
	}

	public void help_set_search_callbacks(Callable search_callback, Callable action_callback) {
		super.call("help_set_search_callbacks",
				new java.lang.Object[]{(java.lang.Object) search_callback, (java.lang.Object) action_callback});
	}

	public void global_menu_set_popup_callbacks(String menu_root, Callable open_callback, Callable close_callback) {
		super.call("global_menu_set_popup_callbacks", new java.lang.Object[]{(java.lang.Object) menu_root,
				(java.lang.Object) open_callback, (java.lang.Object) close_callback});
	}

	public int global_menu_add_submenu_item(String menu_root, String label, String submenu, long index) {
		return (int) super.call("global_menu_add_submenu_item", new java.lang.Object[]{(java.lang.Object) menu_root,
				(java.lang.Object) label, (java.lang.Object) submenu, java.lang.Long.valueOf(index)});
	}

	public int global_menu_add_item(String menu_root, String label, Callable callback, Callable key_callback,
			Object tag, int accelerator, long index) {
		return (int) super.call("global_menu_add_item",
				new java.lang.Object[]{(java.lang.Object) menu_root, (java.lang.Object) label,
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int global_menu_add_check_item(String menu_root, String label, Callable callback, Callable key_callback,
			Object tag, int accelerator, long index) {
		return (int) super.call("global_menu_add_check_item",
				new java.lang.Object[]{(java.lang.Object) menu_root, (java.lang.Object) label,
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int global_menu_add_icon_item(String menu_root, Texture2D icon, String label, Callable callback,
			Callable key_callback, Object tag, int accelerator, long index) {
		return (int) super.call("global_menu_add_icon_item",
				new java.lang.Object[]{(java.lang.Object) menu_root, (java.lang.Object) icon, (java.lang.Object) label,
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int global_menu_add_icon_check_item(String menu_root, Texture2D icon, String label, Callable callback,
			Callable key_callback, Object tag, int accelerator, long index) {
		return (int) super.call("global_menu_add_icon_check_item",
				new java.lang.Object[]{(java.lang.Object) menu_root, (java.lang.Object) icon, (java.lang.Object) label,
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int global_menu_add_radio_check_item(String menu_root, String label, Callable callback,
			Callable key_callback, Object tag, int accelerator, long index) {
		return (int) super.call("global_menu_add_radio_check_item",
				new java.lang.Object[]{(java.lang.Object) menu_root, (java.lang.Object) label,
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int global_menu_add_icon_radio_check_item(String menu_root, Texture2D icon, String label, Callable callback,
			Callable key_callback, Object tag, int accelerator, long index) {
		return (int) super.call("global_menu_add_icon_radio_check_item",
				new java.lang.Object[]{(java.lang.Object) menu_root, (java.lang.Object) icon, (java.lang.Object) label,
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int global_menu_add_multistate_item(String menu_root, String label, long max_states, long default_state,
			Callable callback, Callable key_callback, Object tag, int accelerator, long index) {
		return (int) super.call("global_menu_add_multistate_item",
				new java.lang.Object[]{(java.lang.Object) menu_root, (java.lang.Object) label,
						java.lang.Long.valueOf(max_states), java.lang.Long.valueOf(default_state),
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int global_menu_add_separator(String menu_root, long index) {
		return (int) super.call("global_menu_add_separator",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(index)});
	}

	public int global_menu_get_item_index_from_text(String menu_root, String text) {
		return (int) super.call("global_menu_get_item_index_from_text",
				new java.lang.Object[]{(java.lang.Object) menu_root, (java.lang.Object) text});
	}

	public int global_menu_get_item_index_from_tag(String menu_root, Object tag) {
		return (int) super.call("global_menu_get_item_index_from_tag",
				new java.lang.Object[]{(java.lang.Object) menu_root, (java.lang.Object) tag});
	}

	public boolean global_menu_is_item_checked(String menu_root, long idx) {
		return (boolean) super.call("global_menu_is_item_checked",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public boolean global_menu_is_item_checkable(String menu_root, long idx) {
		return (boolean) super.call("global_menu_is_item_checkable",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public boolean global_menu_is_item_radio_checkable(String menu_root, long idx) {
		return (boolean) super.call("global_menu_is_item_radio_checkable",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public Callable global_menu_get_item_callback(String menu_root, long idx) {
		return (Callable) super.call("global_menu_get_item_callback",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public Callable global_menu_get_item_key_callback(String menu_root, long idx) {
		return (Callable) super.call("global_menu_get_item_key_callback",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public Object global_menu_get_item_tag(String menu_root, long idx) {
		return (Object) super.call("global_menu_get_item_tag",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public String global_menu_get_item_text(String menu_root, long idx) {
		return (String) super.call("global_menu_get_item_text",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public String global_menu_get_item_submenu(String menu_root, long idx) {
		return (String) super.call("global_menu_get_item_submenu",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public int global_menu_get_item_accelerator(String menu_root, long idx) {
		return (int) super.call("global_menu_get_item_accelerator",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public boolean global_menu_is_item_disabled(String menu_root, long idx) {
		return (boolean) super.call("global_menu_is_item_disabled",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public boolean global_menu_is_item_hidden(String menu_root, long idx) {
		return (boolean) super.call("global_menu_is_item_hidden",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public String global_menu_get_item_tooltip(String menu_root, long idx) {
		return (String) super.call("global_menu_get_item_tooltip",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public int global_menu_get_item_state(String menu_root, long idx) {
		return (int) super.call("global_menu_get_item_state",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public int global_menu_get_item_max_states(String menu_root, long idx) {
		return (int) super.call("global_menu_get_item_max_states",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public Texture2D global_menu_get_item_icon(String menu_root, long idx) {
		return (Texture2D) super.call("global_menu_get_item_icon",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public int global_menu_get_item_indentation_level(String menu_root, long idx) {
		return (int) super.call("global_menu_get_item_indentation_level",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public void global_menu_set_item_checked(String menu_root, long idx, boolean checked) {
		super.call("global_menu_set_item_checked", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(checked)});
	}

	public void global_menu_set_item_checkable(String menu_root, long idx, boolean checkable) {
		super.call("global_menu_set_item_checkable", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(checkable)});
	}

	public void global_menu_set_item_radio_checkable(String menu_root, long idx, boolean checkable) {
		super.call("global_menu_set_item_radio_checkable", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(checkable)});
	}

	public void global_menu_set_item_callback(String menu_root, long idx, Callable callback) {
		super.call("global_menu_set_item_callback", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), (java.lang.Object) callback});
	}

	public void global_menu_set_item_hover_callbacks(String menu_root, long idx, Callable callback) {
		super.call("global_menu_set_item_hover_callbacks", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), (java.lang.Object) callback});
	}

	public void global_menu_set_item_key_callback(String menu_root, long idx, Callable key_callback) {
		super.call("global_menu_set_item_key_callback", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), (java.lang.Object) key_callback});
	}

	public void global_menu_set_item_tag(String menu_root, long idx, Object tag) {
		super.call("global_menu_set_item_tag", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), (java.lang.Object) tag});
	}

	public void global_menu_set_item_text(String menu_root, long idx, String text) {
		super.call("global_menu_set_item_text", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), (java.lang.Object) text});
	}

	public void global_menu_set_item_submenu(String menu_root, long idx, String submenu) {
		super.call("global_menu_set_item_submenu", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), (java.lang.Object) submenu});
	}

	public void global_menu_set_item_accelerator(String menu_root, long idx, int keycode) {
		super.call("global_menu_set_item_accelerator", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), java.lang.Integer.valueOf(keycode)});
	}

	public void global_menu_set_item_disabled(String menu_root, long idx, boolean disabled) {
		super.call("global_menu_set_item_disabled", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(disabled)});
	}

	public void global_menu_set_item_hidden(String menu_root, long idx, boolean hidden) {
		super.call("global_menu_set_item_hidden", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(hidden)});
	}

	public void global_menu_set_item_tooltip(String menu_root, long idx, String tooltip) {
		super.call("global_menu_set_item_tooltip", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), (java.lang.Object) tooltip});
	}

	public void global_menu_set_item_state(String menu_root, long idx, long state) {
		super.call("global_menu_set_item_state", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), java.lang.Long.valueOf(state)});
	}

	public void global_menu_set_item_max_states(String menu_root, long idx, long max_states) {
		super.call("global_menu_set_item_max_states", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), java.lang.Long.valueOf(max_states)});
	}

	public void global_menu_set_item_icon(String menu_root, long idx, Texture2D icon) {
		super.call("global_menu_set_item_icon", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), (java.lang.Object) icon});
	}

	public void global_menu_set_item_indentation_level(String menu_root, long idx, long level) {
		super.call("global_menu_set_item_indentation_level", new java.lang.Object[]{(java.lang.Object) menu_root,
				java.lang.Long.valueOf(idx), java.lang.Long.valueOf(level)});
	}

	public int global_menu_get_item_count(String menu_root) {
		return (int) super.call("global_menu_get_item_count", new java.lang.Object[]{(java.lang.Object) menu_root});
	}

	public void global_menu_remove_item(String menu_root, long idx) {
		super.call("global_menu_remove_item",
				new java.lang.Object[]{(java.lang.Object) menu_root, java.lang.Long.valueOf(idx)});
	}

	public void global_menu_clear(String menu_root) {
		super.call("global_menu_clear", new java.lang.Object[]{(java.lang.Object) menu_root});
	}

	public GodotDictionary global_menu_get_system_menu_roots() {
		return (GodotDictionary) super.call("global_menu_get_system_menu_roots");
	}

	public boolean tts_is_speaking() {
		return (boolean) super.call("tts_is_speaking");
	}

	public boolean tts_is_paused() {
		return (boolean) super.call("tts_is_paused");
	}

	public GodotDictionary[] tts_get_voices() {
		return (GodotDictionary[]) super.call("tts_get_voices");
	}

	public String[] tts_get_voices_for_language(String language) {
		return (String[]) super.call("tts_get_voices_for_language",
				new java.lang.Object[]{(java.lang.Object) language});
	}

	public void tts_speak(String text, String voice, long volume, double pitch, double rate, long utterance_id,
			boolean interrupt) {
		super.call("tts_speak",
				new java.lang.Object[]{(java.lang.Object) text, (java.lang.Object) voice,
						java.lang.Long.valueOf(volume), java.lang.Double.valueOf(pitch), java.lang.Double.valueOf(rate),
						java.lang.Long.valueOf(utterance_id), java.lang.Boolean.valueOf(interrupt)});
	}

	public void tts_pause() {
		super.call("tts_pause");
	}

	public void tts_resume() {
		super.call("tts_resume");
	}

	public void tts_stop() {
		super.call("tts_stop");
	}

	public void tts_set_utterance_callback(int event, Callable callable) {
		super.call("tts_set_utterance_callback",
				new java.lang.Object[]{java.lang.Integer.valueOf(event), (java.lang.Object) callable});
	}

	public boolean is_dark_mode_supported() {
		return (boolean) super.call("is_dark_mode_supported");
	}

	public boolean is_dark_mode() {
		return (boolean) super.call("is_dark_mode");
	}

	public void mouse_set_mode(int mouse_mode) {
		super.call("mouse_set_mode", new java.lang.Object[]{java.lang.Integer.valueOf(mouse_mode)});
	}

	public int mouse_get_mode() {
		return (int) super.call("mouse_get_mode");
	}

	public void warp_mouse(Vector2i position) {
		super.call("warp_mouse", new java.lang.Object[]{(java.lang.Object) position});
	}

	public Vector2i mouse_get_position() {
		return (Vector2i) super.call("mouse_get_position");
	}

	public int mouse_get_button_state() {
		return (int) super.call("mouse_get_button_state");
	}

	public void clipboard_set(String clipboard) {
		super.call("clipboard_set", new java.lang.Object[]{(java.lang.Object) clipboard});
	}

	public String clipboard_get() {
		return (String) super.call("clipboard_get");
	}

	public Image clipboard_get_image() {
		return (Image) super.call("clipboard_get_image");
	}

	public boolean clipboard_has() {
		return (boolean) super.call("clipboard_has");
	}

	public boolean clipboard_has_image() {
		return (boolean) super.call("clipboard_has_image");
	}

	public void clipboard_set_primary(String clipboard_primary) {
		super.call("clipboard_set_primary", new java.lang.Object[]{(java.lang.Object) clipboard_primary});
	}

	public String clipboard_get_primary() {
		return (String) super.call("clipboard_get_primary");
	}

	public int get_screen_from_rect(Rect2 rect) {
		return (int) super.call("get_screen_from_rect", new java.lang.Object[]{(java.lang.Object) rect});
	}

	public Vector2i screen_get_position(long screen) {
		return (Vector2i) super.call("screen_get_position", new java.lang.Object[]{java.lang.Long.valueOf(screen)});
	}

	public Vector2i screen_get_size(long screen) {
		return (Vector2i) super.call("screen_get_size", new java.lang.Object[]{java.lang.Long.valueOf(screen)});
	}

	public Rect2i screen_get_usable_rect(long screen) {
		return (Rect2i) super.call("screen_get_usable_rect", new java.lang.Object[]{java.lang.Long.valueOf(screen)});
	}

	public int screen_get_dpi(long screen) {
		return (int) super.call("screen_get_dpi", new java.lang.Object[]{java.lang.Long.valueOf(screen)});
	}

	public double screen_get_scale(long screen) {
		return (double) super.call("screen_get_scale", new java.lang.Object[]{java.lang.Long.valueOf(screen)});
	}

	public boolean is_touchscreen_available() {
		return (boolean) super.call("is_touchscreen_available");
	}

	public double screen_get_max_scale() {
		return (double) super.call("screen_get_max_scale");
	}

	public double screen_get_refresh_rate(long screen) {
		return (double) super.call("screen_get_refresh_rate", new java.lang.Object[]{java.lang.Long.valueOf(screen)});
	}

	public Color screen_get_pixel(Vector2i position) {
		return (Color) super.call("screen_get_pixel", new java.lang.Object[]{(java.lang.Object) position});
	}

	public Image screen_get_image(long screen) {
		return (Image) super.call("screen_get_image", new java.lang.Object[]{java.lang.Long.valueOf(screen)});
	}

	public Image screen_get_image_rect(Rect2i rect) {
		return (Image) super.call("screen_get_image_rect", new java.lang.Object[]{(java.lang.Object) rect});
	}

	public void screen_set_orientation(int orientation, long screen) {
		super.call("screen_set_orientation",
				new java.lang.Object[]{java.lang.Integer.valueOf(orientation), java.lang.Long.valueOf(screen)});
	}

	public int screen_get_orientation(long screen) {
		return (int) super.call("screen_get_orientation", new java.lang.Object[]{java.lang.Long.valueOf(screen)});
	}

	public void screen_set_keep_on(boolean enable) {
		super.call("screen_set_keep_on", new java.lang.Object[]{java.lang.Boolean.valueOf(enable)});
	}

	public boolean screen_is_kept_on() {
		return (boolean) super.call("screen_is_kept_on");
	}

	public int get_window_at_screen_position(Vector2i position) {
		return (int) super.call("get_window_at_screen_position", new java.lang.Object[]{(java.lang.Object) position});
	}

	public long window_get_native_handle(int handle_type, long window_id) {
		return (long) super.call("window_get_native_handle",
				new java.lang.Object[]{java.lang.Integer.valueOf(handle_type), java.lang.Long.valueOf(window_id)});
	}

	public int window_get_active_popup() {
		return (int) super.call("window_get_active_popup");
	}

	public void window_set_popup_safe_rect(long window, Rect2i rect) {
		super.call("window_set_popup_safe_rect",
				new java.lang.Object[]{java.lang.Long.valueOf(window), (java.lang.Object) rect});
	}

	public Rect2i window_get_popup_safe_rect(long window) {
		return (Rect2i) super.call("window_get_popup_safe_rect",
				new java.lang.Object[]{java.lang.Long.valueOf(window)});
	}

	public void window_set_title(String title, long window_id) {
		super.call("window_set_title",
				new java.lang.Object[]{(java.lang.Object) title, java.lang.Long.valueOf(window_id)});
	}

	public Vector2i window_get_title_size(String title, long window_id) {
		return (Vector2i) super.call("window_get_title_size",
				new java.lang.Object[]{(java.lang.Object) title, java.lang.Long.valueOf(window_id)});
	}

	public void window_set_mouse_passthrough(double[][] region, long window_id) {
		super.call("window_set_mouse_passthrough",
				new java.lang.Object[]{(java.lang.Object) region, java.lang.Long.valueOf(window_id)});
	}

	public int window_get_current_screen(long window_id) {
		return (int) super.call("window_get_current_screen", new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public void window_set_current_screen(long screen, long window_id) {
		super.call("window_set_current_screen",
				new java.lang.Object[]{java.lang.Long.valueOf(screen), java.lang.Long.valueOf(window_id)});
	}

	public Vector2i window_get_position(long window_id) {
		return (Vector2i) super.call("window_get_position", new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public Vector2i window_get_position_with_decorations(long window_id) {
		return (Vector2i) super.call("window_get_position_with_decorations",
				new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public void window_set_position(Vector2i position, long window_id) {
		super.call("window_set_position",
				new java.lang.Object[]{(java.lang.Object) position, java.lang.Long.valueOf(window_id)});
	}

	public Vector2i window_get_size(long window_id) {
		return (Vector2i) super.call("window_get_size", new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public void window_set_size(Vector2i size, long window_id) {
		super.call("window_set_size",
				new java.lang.Object[]{(java.lang.Object) size, java.lang.Long.valueOf(window_id)});
	}

	public void window_set_rect_changed_callback(Callable callback, long window_id) {
		super.call("window_set_rect_changed_callback",
				new java.lang.Object[]{(java.lang.Object) callback, java.lang.Long.valueOf(window_id)});
	}

	public void window_set_window_event_callback(Callable callback, long window_id) {
		super.call("window_set_window_event_callback",
				new java.lang.Object[]{(java.lang.Object) callback, java.lang.Long.valueOf(window_id)});
	}

	public void window_set_input_event_callback(Callable callback, long window_id) {
		super.call("window_set_input_event_callback",
				new java.lang.Object[]{(java.lang.Object) callback, java.lang.Long.valueOf(window_id)});
	}

	public void window_set_input_text_callback(Callable callback, long window_id) {
		super.call("window_set_input_text_callback",
				new java.lang.Object[]{(java.lang.Object) callback, java.lang.Long.valueOf(window_id)});
	}

	public void window_set_drop_files_callback(Callable callback, long window_id) {
		super.call("window_set_drop_files_callback",
				new java.lang.Object[]{(java.lang.Object) callback, java.lang.Long.valueOf(window_id)});
	}

	public java.math.BigInteger window_get_attached_instance_id(long window_id) {
		return (java.math.BigInteger) super.call("window_get_attached_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public Vector2i window_get_max_size(long window_id) {
		return (Vector2i) super.call("window_get_max_size", new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public void window_set_max_size(Vector2i max_size, long window_id) {
		super.call("window_set_max_size",
				new java.lang.Object[]{(java.lang.Object) max_size, java.lang.Long.valueOf(window_id)});
	}

	public Vector2i window_get_min_size(long window_id) {
		return (Vector2i) super.call("window_get_min_size", new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public void window_set_min_size(Vector2i min_size, long window_id) {
		super.call("window_set_min_size",
				new java.lang.Object[]{(java.lang.Object) min_size, java.lang.Long.valueOf(window_id)});
	}

	public Vector2i window_get_size_with_decorations(long window_id) {
		return (Vector2i) super.call("window_get_size_with_decorations",
				new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public int window_get_mode(long window_id) {
		return (int) super.call("window_get_mode", new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public void window_set_mode(int mode, long window_id) {
		super.call("window_set_mode",
				new java.lang.Object[]{java.lang.Integer.valueOf(mode), java.lang.Long.valueOf(window_id)});
	}

	public void window_set_flag(int flag, boolean enabled, long window_id) {
		super.call("window_set_flag", new java.lang.Object[]{java.lang.Integer.valueOf(flag),
				java.lang.Boolean.valueOf(enabled), java.lang.Long.valueOf(window_id)});
	}

	public boolean window_get_flag(int flag, long window_id) {
		return (boolean) super.call("window_get_flag",
				new java.lang.Object[]{java.lang.Integer.valueOf(flag), java.lang.Long.valueOf(window_id)});
	}

	public void window_set_window_buttons_offset(Vector2i offset, long window_id) {
		super.call("window_set_window_buttons_offset",
				new java.lang.Object[]{(java.lang.Object) offset, java.lang.Long.valueOf(window_id)});
	}

	public Vector3i window_get_safe_title_margins(long window_id) {
		return (Vector3i) super.call("window_get_safe_title_margins",
				new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public void window_request_attention(long window_id) {
		super.call("window_request_attention", new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public void window_move_to_foreground(long window_id) {
		super.call("window_move_to_foreground", new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public boolean window_is_focused(long window_id) {
		return (boolean) super.call("window_is_focused", new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public boolean window_can_draw(long window_id) {
		return (boolean) super.call("window_can_draw", new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public void window_set_transient(long window_id, long parent_window_id) {
		super.call("window_set_transient",
				new java.lang.Object[]{java.lang.Long.valueOf(window_id), java.lang.Long.valueOf(parent_window_id)});
	}

	public void window_set_exclusive(long window_id, boolean exclusive) {
		super.call("window_set_exclusive",
				new java.lang.Object[]{java.lang.Long.valueOf(window_id), java.lang.Boolean.valueOf(exclusive)});
	}

	public void window_set_ime_active(boolean active, long window_id) {
		super.call("window_set_ime_active",
				new java.lang.Object[]{java.lang.Boolean.valueOf(active), java.lang.Long.valueOf(window_id)});
	}

	public void window_set_ime_position(Vector2i position, long window_id) {
		super.call("window_set_ime_position",
				new java.lang.Object[]{(java.lang.Object) position, java.lang.Long.valueOf(window_id)});
	}

	public void window_set_vsync_mode(int vsync_mode, long window_id) {
		super.call("window_set_vsync_mode",
				new java.lang.Object[]{java.lang.Integer.valueOf(vsync_mode), java.lang.Long.valueOf(window_id)});
	}

	public int window_get_vsync_mode(long window_id) {
		return (int) super.call("window_get_vsync_mode", new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public boolean window_is_maximize_allowed(long window_id) {
		return (boolean) super.call("window_is_maximize_allowed",
				new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public boolean window_maximize_on_title_dbl_click() {
		return (boolean) super.call("window_maximize_on_title_dbl_click");
	}

	public boolean window_minimize_on_title_dbl_click() {
		return (boolean) super.call("window_minimize_on_title_dbl_click");
	}

	public void window_start_drag(long window_id) {
		super.call("window_start_drag", new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public void window_start_resize(int edge, long window_id) {
		super.call("window_start_resize",
				new java.lang.Object[]{java.lang.Integer.valueOf(edge), java.lang.Long.valueOf(window_id)});
	}

	public void window_set_color(Color color) {
		super.call("window_set_color", new java.lang.Object[]{(java.lang.Object) color});
	}

	public int accessibility_should_increase_contrast() {
		return (int) super.call("accessibility_should_increase_contrast");
	}

	public int accessibility_should_reduce_animation() {
		return (int) super.call("accessibility_should_reduce_animation");
	}

	public int accessibility_should_reduce_transparency() {
		return (int) super.call("accessibility_should_reduce_transparency");
	}

	public int accessibility_screen_reader_active() {
		return (int) super.call("accessibility_screen_reader_active");
	}

	public long accessibility_create_element(long window_id, int role) {
		return (long) super.call("accessibility_create_element",
				new java.lang.Object[]{java.lang.Long.valueOf(window_id), java.lang.Integer.valueOf(role)});
	}

	public long accessibility_create_sub_element(long parent_rid, int role, long insert_pos) {
		return (long) super.call("accessibility_create_sub_element",
				new java.lang.Object[]{java.lang.Long.valueOf(parent_rid), java.lang.Integer.valueOf(role),
						java.lang.Long.valueOf(insert_pos)});
	}

	public long accessibility_create_sub_text_edit_elements(long parent_rid, long shaped_text, double min_height,
			long insert_pos, boolean is_last_line) {
		return (long) super.call("accessibility_create_sub_text_edit_elements",
				new java.lang.Object[]{java.lang.Long.valueOf(parent_rid), java.lang.Long.valueOf(shaped_text),
						java.lang.Double.valueOf(min_height), java.lang.Long.valueOf(insert_pos),
						java.lang.Boolean.valueOf(is_last_line)});
	}

	public boolean accessibility_has_element(long id) {
		return (boolean) super.call("accessibility_has_element", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void accessibility_free_element(long id) {
		super.call("accessibility_free_element", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void accessibility_element_set_meta(long id, Object meta) {
		super.call("accessibility_element_set_meta",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) meta});
	}

	public Object accessibility_element_get_meta(long id) {
		return (Object) super.call("accessibility_element_get_meta",
				new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void accessibility_set_window_rect(long window_id, Rect2 rect_out, Rect2 rect_in) {
		super.call("accessibility_set_window_rect", new java.lang.Object[]{java.lang.Long.valueOf(window_id),
				(java.lang.Object) rect_out, (java.lang.Object) rect_in});
	}

	public void accessibility_set_window_focused(long window_id, boolean focused) {
		super.call("accessibility_set_window_focused",
				new java.lang.Object[]{java.lang.Long.valueOf(window_id), java.lang.Boolean.valueOf(focused)});
	}

	public void accessibility_update_set_focus(long id) {
		super.call("accessibility_update_set_focus", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public long accessibility_get_window_root(long window_id) {
		return (long) super.call("accessibility_get_window_root",
				new java.lang.Object[]{java.lang.Long.valueOf(window_id)});
	}

	public void accessibility_update_set_role(long id, int role) {
		super.call("accessibility_update_set_role",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Integer.valueOf(role)});
	}

	public void accessibility_update_set_name(long id, String name) {
		super.call("accessibility_update_set_name",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) name});
	}

	public void accessibility_update_set_extra_info(long id, String name) {
		super.call("accessibility_update_set_extra_info",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) name});
	}

	public void accessibility_update_set_description(long id, String description) {
		super.call("accessibility_update_set_description",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) description});
	}

	public void accessibility_update_set_value(long id, String value) {
		super.call("accessibility_update_set_value",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) value});
	}

	public void accessibility_update_set_tooltip(long id, String tooltip) {
		super.call("accessibility_update_set_tooltip",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) tooltip});
	}

	public void accessibility_update_set_bounds(long id, Rect2 p_rect) {
		super.call("accessibility_update_set_bounds",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) p_rect});
	}

	public void accessibility_update_set_transform(long id, Transform2D transform) {
		super.call("accessibility_update_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) transform});
	}

	public void accessibility_update_add_child(long id, long child_id) {
		super.call("accessibility_update_add_child",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(child_id)});
	}

	public void accessibility_update_add_related_controls(long id, long related_id) {
		super.call("accessibility_update_add_related_controls",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(related_id)});
	}

	public void accessibility_update_add_related_details(long id, long related_id) {
		super.call("accessibility_update_add_related_details",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(related_id)});
	}

	public void accessibility_update_add_related_described_by(long id, long related_id) {
		super.call("accessibility_update_add_related_described_by",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(related_id)});
	}

	public void accessibility_update_add_related_flow_to(long id, long related_id) {
		super.call("accessibility_update_add_related_flow_to",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(related_id)});
	}

	public void accessibility_update_add_related_labeled_by(long id, long related_id) {
		super.call("accessibility_update_add_related_labeled_by",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(related_id)});
	}

	public void accessibility_update_add_related_radio_group(long id, long related_id) {
		super.call("accessibility_update_add_related_radio_group",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(related_id)});
	}

	public void accessibility_update_set_active_descendant(long id, long other_id) {
		super.call("accessibility_update_set_active_descendant",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(other_id)});
	}

	public void accessibility_update_set_next_on_line(long id, long other_id) {
		super.call("accessibility_update_set_next_on_line",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(other_id)});
	}

	public void accessibility_update_set_previous_on_line(long id, long other_id) {
		super.call("accessibility_update_set_previous_on_line",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(other_id)});
	}

	public void accessibility_update_set_member_of(long id, long group_id) {
		super.call("accessibility_update_set_member_of",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(group_id)});
	}

	public void accessibility_update_set_in_page_link_target(long id, long other_id) {
		super.call("accessibility_update_set_in_page_link_target",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(other_id)});
	}

	public void accessibility_update_set_error_message(long id, long other_id) {
		super.call("accessibility_update_set_error_message",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(other_id)});
	}

	public void accessibility_update_set_live(long id, int live) {
		super.call("accessibility_update_set_live",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Integer.valueOf(live)});
	}

	public void accessibility_update_add_action(long id, int action, Callable callable) {
		super.call("accessibility_update_add_action", new java.lang.Object[]{java.lang.Long.valueOf(id),
				java.lang.Integer.valueOf(action), (java.lang.Object) callable});
	}

	public void accessibility_update_add_custom_action(long id, long action_id, String action_description) {
		super.call("accessibility_update_add_custom_action", new java.lang.Object[]{java.lang.Long.valueOf(id),
				java.lang.Long.valueOf(action_id), (java.lang.Object) action_description});
	}

	public void accessibility_update_set_table_row_count(long id, long count) {
		super.call("accessibility_update_set_table_row_count",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(count)});
	}

	public void accessibility_update_set_table_column_count(long id, long count) {
		super.call("accessibility_update_set_table_column_count",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(count)});
	}

	public void accessibility_update_set_table_row_index(long id, long index) {
		super.call("accessibility_update_set_table_row_index",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(index)});
	}

	public void accessibility_update_set_table_column_index(long id, long index) {
		super.call("accessibility_update_set_table_column_index",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(index)});
	}

	public void accessibility_update_set_table_cell_position(long id, long row_index, long column_index) {
		super.call("accessibility_update_set_table_cell_position", new java.lang.Object[]{java.lang.Long.valueOf(id),
				java.lang.Long.valueOf(row_index), java.lang.Long.valueOf(column_index)});
	}

	public void accessibility_update_set_table_cell_span(long id, long row_span, long column_span) {
		super.call("accessibility_update_set_table_cell_span", new java.lang.Object[]{java.lang.Long.valueOf(id),
				java.lang.Long.valueOf(row_span), java.lang.Long.valueOf(column_span)});
	}

	public void accessibility_update_set_list_item_count(long id, long size) {
		super.call("accessibility_update_set_list_item_count",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(size)});
	}

	public void accessibility_update_set_list_item_index(long id, long index) {
		super.call("accessibility_update_set_list_item_index",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(index)});
	}

	public void accessibility_update_set_list_item_level(long id, long level) {
		super.call("accessibility_update_set_list_item_level",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(level)});
	}

	public void accessibility_update_set_list_item_selected(long id, boolean selected) {
		super.call("accessibility_update_set_list_item_selected",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(selected)});
	}

	public void accessibility_update_set_list_item_expanded(long id, boolean expanded) {
		super.call("accessibility_update_set_list_item_expanded",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(expanded)});
	}

	public void accessibility_update_set_popup_type(long id, int popup) {
		super.call("accessibility_update_set_popup_type",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Integer.valueOf(popup)});
	}

	public void accessibility_update_set_checked(long id, boolean checekd) {
		super.call("accessibility_update_set_checked",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(checekd)});
	}

	public void accessibility_update_set_num_value(long id, double position) {
		super.call("accessibility_update_set_num_value",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Double.valueOf(position)});
	}

	public void accessibility_update_set_num_range(long id, double min, double max) {
		super.call("accessibility_update_set_num_range", new java.lang.Object[]{java.lang.Long.valueOf(id),
				java.lang.Double.valueOf(min), java.lang.Double.valueOf(max)});
	}

	public void accessibility_update_set_num_step(long id, double step) {
		super.call("accessibility_update_set_num_step",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Double.valueOf(step)});
	}

	public void accessibility_update_set_num_jump(long id, double jump) {
		super.call("accessibility_update_set_num_jump",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Double.valueOf(jump)});
	}

	public void accessibility_update_set_scroll_x(long id, double position) {
		super.call("accessibility_update_set_scroll_x",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Double.valueOf(position)});
	}

	public void accessibility_update_set_scroll_x_range(long id, double min, double max) {
		super.call("accessibility_update_set_scroll_x_range", new java.lang.Object[]{java.lang.Long.valueOf(id),
				java.lang.Double.valueOf(min), java.lang.Double.valueOf(max)});
	}

	public void accessibility_update_set_scroll_y(long id, double position) {
		super.call("accessibility_update_set_scroll_y",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Double.valueOf(position)});
	}

	public void accessibility_update_set_scroll_y_range(long id, double min, double max) {
		super.call("accessibility_update_set_scroll_y_range", new java.lang.Object[]{java.lang.Long.valueOf(id),
				java.lang.Double.valueOf(min), java.lang.Double.valueOf(max)});
	}

	public void accessibility_update_set_text_decorations(long id, boolean underline, boolean strikethrough,
			boolean overline) {
		super.call("accessibility_update_set_text_decorations",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(underline),
						java.lang.Boolean.valueOf(strikethrough), java.lang.Boolean.valueOf(overline)});
	}

	public void accessibility_update_set_text_align(long id, int align) {
		super.call("accessibility_update_set_text_align",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Integer.valueOf(align)});
	}

	public void accessibility_update_set_text_selection(long id, long text_start_id, long start_char, long text_end_id,
			long end_char) {
		super.call("accessibility_update_set_text_selection",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(text_start_id),
						java.lang.Long.valueOf(start_char), java.lang.Long.valueOf(text_end_id),
						java.lang.Long.valueOf(end_char)});
	}

	public void accessibility_update_set_flag(long id, int flag, boolean value) {
		super.call("accessibility_update_set_flag", new java.lang.Object[]{java.lang.Long.valueOf(id),
				java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(value)});
	}

	public void accessibility_update_set_classname(long id, String classname) {
		super.call("accessibility_update_set_classname",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) classname});
	}

	public void accessibility_update_set_placeholder(long id, String placeholder) {
		super.call("accessibility_update_set_placeholder",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) placeholder});
	}

	public void accessibility_update_set_language(long id, String language) {
		super.call("accessibility_update_set_language",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) language});
	}

	public void accessibility_update_set_text_orientation(long id, boolean vertical) {
		super.call("accessibility_update_set_text_orientation",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(vertical)});
	}

	public void accessibility_update_set_list_orientation(long id, boolean vertical) {
		super.call("accessibility_update_set_list_orientation",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(vertical)});
	}

	public void accessibility_update_set_shortcut(long id, String shortcut) {
		super.call("accessibility_update_set_shortcut",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) shortcut});
	}

	public void accessibility_update_set_url(long id, String url) {
		super.call("accessibility_update_set_url",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) url});
	}

	public void accessibility_update_set_role_description(long id, String description) {
		super.call("accessibility_update_set_role_description",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) description});
	}

	public void accessibility_update_set_state_description(long id, String description) {
		super.call("accessibility_update_set_state_description",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) description});
	}

	public void accessibility_update_set_color_value(long id, Color color) {
		super.call("accessibility_update_set_color_value",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) color});
	}

	public void accessibility_update_set_background_color(long id, Color color) {
		super.call("accessibility_update_set_background_color",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) color});
	}

	public void accessibility_update_set_foreground_color(long id, Color color) {
		super.call("accessibility_update_set_foreground_color",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) color});
	}

	public Vector2i ime_get_selection() {
		return (Vector2i) super.call("ime_get_selection");
	}

	public String ime_get_text() {
		return (String) super.call("ime_get_text");
	}

	public void virtual_keyboard_show(String existing_text, Rect2 position, int type, long max_length,
			long cursor_start, long cursor_end) {
		super.call("virtual_keyboard_show",
				new java.lang.Object[]{(java.lang.Object) existing_text, (java.lang.Object) position,
						java.lang.Integer.valueOf(type), java.lang.Long.valueOf(max_length),
						java.lang.Long.valueOf(cursor_start), java.lang.Long.valueOf(cursor_end)});
	}

	public void virtual_keyboard_hide() {
		super.call("virtual_keyboard_hide");
	}

	public int virtual_keyboard_get_height() {
		return (int) super.call("virtual_keyboard_get_height");
	}

	public boolean has_hardware_keyboard() {
		return (boolean) super.call("has_hardware_keyboard");
	}

	public void cursor_set_shape(int shape) {
		super.call("cursor_set_shape", new java.lang.Object[]{java.lang.Integer.valueOf(shape)});
	}

	public int cursor_get_shape() {
		return (int) super.call("cursor_get_shape");
	}

	public void cursor_set_custom_image(Resource cursor, int shape, Vector2 hotspot) {
		super.call("cursor_set_custom_image", new java.lang.Object[]{(java.lang.Object) cursor,
				java.lang.Integer.valueOf(shape), (java.lang.Object) hotspot});
	}

	public void enable_for_stealing_focus(long process_id) {
		super.call("enable_for_stealing_focus", new java.lang.Object[]{java.lang.Long.valueOf(process_id)});
	}

	public int dialog_show(String title, String description, String[] buttons, Callable callback) {
		return (int) super.call("dialog_show", new java.lang.Object[]{(java.lang.Object) title,
				(java.lang.Object) description, (java.lang.Object) buttons, (java.lang.Object) callback});
	}

	public int dialog_input_text(String title, String description, String existing_text, Callable callback) {
		return (int) super.call("dialog_input_text", new java.lang.Object[]{(java.lang.Object) title,
				(java.lang.Object) description, (java.lang.Object) existing_text, (java.lang.Object) callback});
	}

	public int file_dialog_show(String title, String current_directory, String filename, boolean show_hidden, int mode,
			String[] filters, Callable callback, long parent_window_id) {
		return (int) super.call("file_dialog_show",
				new java.lang.Object[]{(java.lang.Object) title, (java.lang.Object) current_directory,
						(java.lang.Object) filename, java.lang.Boolean.valueOf(show_hidden),
						java.lang.Integer.valueOf(mode), (java.lang.Object) filters, (java.lang.Object) callback,
						java.lang.Long.valueOf(parent_window_id)});
	}

	public int file_dialog_with_options_show(String title, String current_directory, String root, String filename,
			boolean show_hidden, int mode, String[] filters, GodotDictionary[] options, Callable callback,
			long parent_window_id) {
		return (int) super.call("file_dialog_with_options_show",
				new java.lang.Object[]{(java.lang.Object) title, (java.lang.Object) current_directory,
						(java.lang.Object) root, (java.lang.Object) filename, java.lang.Boolean.valueOf(show_hidden),
						java.lang.Integer.valueOf(mode), (java.lang.Object) filters, (java.lang.Object) options,
						(java.lang.Object) callback, java.lang.Long.valueOf(parent_window_id)});
	}

	public void beep() {
		super.call("beep");
	}

	public int keyboard_get_layout_count() {
		return (int) super.call("keyboard_get_layout_count");
	}

	public int keyboard_get_current_layout() {
		return (int) super.call("keyboard_get_current_layout");
	}

	public void keyboard_set_current_layout(long index) {
		super.call("keyboard_set_current_layout", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String keyboard_get_layout_language(long index) {
		return (String) super.call("keyboard_get_layout_language",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String keyboard_get_layout_name(long index) {
		return (String) super.call("keyboard_get_layout_name", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int keyboard_get_keycode_from_physical(int keycode) {
		return (int) super.call("keyboard_get_keycode_from_physical",
				new java.lang.Object[]{java.lang.Integer.valueOf(keycode)});
	}

	public int keyboard_get_label_from_physical(int keycode) {
		return (int) super.call("keyboard_get_label_from_physical",
				new java.lang.Object[]{java.lang.Integer.valueOf(keycode)});
	}

	public void show_emoji_and_symbol_picker() {
		super.call("show_emoji_and_symbol_picker");
	}

	public boolean color_picker(Callable callback) {
		return (boolean) super.call("color_picker", new java.lang.Object[]{(java.lang.Object) callback});
	}

	public void process_events() {
		super.call("process_events");
	}

	public void force_process_and_drop_events() {
		super.call("force_process_and_drop_events");
	}

	public int create_status_indicator(Texture2D icon, String tooltip, Callable callback) {
		return (int) super.call("create_status_indicator", new java.lang.Object[]{(java.lang.Object) icon,
				(java.lang.Object) tooltip, (java.lang.Object) callback});
	}

	public void status_indicator_set_icon(long id, Texture2D icon) {
		super.call("status_indicator_set_icon",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) icon});
	}

	public void status_indicator_set_tooltip(long id, String tooltip) {
		super.call("status_indicator_set_tooltip",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) tooltip});
	}

	public void status_indicator_set_menu(long id, long menu_rid) {
		super.call("status_indicator_set_menu",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(menu_rid)});
	}

	public void status_indicator_set_callback(long id, Callable callback) {
		super.call("status_indicator_set_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) callback});
	}

	public Rect2 status_indicator_get_rect(long id) {
		return (Rect2) super.call("status_indicator_get_rect", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void delete_status_indicator(long id) {
		super.call("delete_status_indicator", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public int tablet_get_driver_count() {
		return (int) super.call("tablet_get_driver_count");
	}

	public String tablet_get_driver_name(long idx) {
		return (String) super.call("tablet_get_driver_name", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String tablet_get_current_driver() {
		return (String) super.call("tablet_get_current_driver");
	}

	public void tablet_set_current_driver(String name) {
		super.call("tablet_set_current_driver", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean is_window_transparency_available() {
		return (boolean) super.call("is_window_transparency_available");
	}

	public void register_additional_output(GodotObject object) {
		super.call("register_additional_output", new java.lang.Object[]{(java.lang.Object) object});
	}

	public void unregister_additional_output(GodotObject object) {
		super.call("unregister_additional_output", new java.lang.Object[]{(java.lang.Object) object});
	}

	public boolean has_additional_outputs() {
		return (boolean) super.call("has_additional_outputs");
	}
}
