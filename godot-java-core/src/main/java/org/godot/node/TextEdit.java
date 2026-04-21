package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.core.Callable;
import org.godot.math.Color;
import org.godot.math.Rect2i;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class TextEdit extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_gutter_clickable", 300928843L),
			java.util.Map.entry("set_structured_text_bidi_override", 55961453L),
			java.util.Map.entry("get_tab_input_mode", 36873697L), java.util.Map.entry("set_tab_size", 1286410249L),
			java.util.Map.entry("get_selection_at_line_column", 1810224333L),
			java.util.Map.entry("set_virtual_keyboard_show_on_focus", 2586408642L),
			java.util.Map.entry("set_move_caret_on_right_click_enabled", 2586408642L),
			java.util.Map.entry("get_structured_text_bidi_override", 3385126229L),
			java.util.Map.entry("get_structured_text_bidi_override_options", 3995934104L),
			java.util.Map.entry("get_last_unhidden_line", 3905245786L),
			java.util.Map.entry("get_virtual_keyboard_show_on_focus", 36873697L),
			java.util.Map.entry("get_total_gutter_width", 3905245786L),
			java.util.Map.entry("clear_undo_history", 3218959716L),
			java.util.Map.entry("is_deselect_on_focus_loss_enabled", 36873697L),
			java.util.Map.entry("is_scroll_past_end_of_file_enabled", 36873697L),
			java.util.Map.entry("add_gutter", 1025054187L),
			java.util.Map.entry("get_next_composite_character_column", 3175239445L),
			java.util.Map.entry("skip_selection_for_next_occurrence", 3218959716L),
			java.util.Map.entry("set_deselect_on_focus_loss_enabled", 2586408642L),
			java.util.Map.entry("set_use_default_word_separators", 2586408642L),
			java.util.Map.entry("set_highlight_all_occurrences", 2586408642L),
			java.util.Map.entry("get_caret_wrap_index", 1591665591L),
			java.util.Map.entry("set_context_menu_enabled", 2586408642L),
			java.util.Map.entry("is_selecting_enabled", 36873697L),
			java.util.Map.entry("set_shortcut_keys_enabled", 2586408642L),
			java.util.Map.entry("get_line_count", 3905245786L), java.util.Map.entry("cut", 1025054187L),
			java.util.Map.entry("is_drag_and_drop_selection_enabled", 36873697L),
			java.util.Map.entry("set_gutter_draw", 300928843L),
			java.util.Map.entry("set_virtual_keyboard_enabled", 2586408642L),
			java.util.Map.entry("get_v_scroll_bar", 3226026593L), java.util.Map.entry("set_gutter_type", 1088959071L),
			java.util.Map.entry("get_autowrap_mode", 1549071663L),
			java.util.Map.entry("set_indent_wrapped_lines", 2586408642L),
			java.util.Map.entry("set_line_as_center_visible", 2230941749L),
			java.util.Map.entry("get_line_gutter_icon", 2584904275L),
			java.util.Map.entry("set_autowrap_mode", 3289138044L),
			java.util.Map.entry("get_selection_column", 1591665591L), java.util.Map.entry("search", 1203739136L),
			java.util.Map.entry("is_highlight_current_line_enabled", 36873697L),
			java.util.Map.entry("get_caret_blink_interval", 1740695150L),
			java.util.Map.entry("get_line_wrapped_text", 647634434L),
			java.util.Map.entry("end_multicaret_edit", 3218959716L),
			java.util.Map.entry("get_line_gutter_item_color", 2165839948L),
			java.util.Map.entry("get_local_mouse_pos", 3341600327L),
			java.util.Map.entry("get_line_gutter_metadata", 678354945L),
			java.util.Map.entry("set_text_direction", 119160795L),
			java.util.Map.entry("is_emoji_menu_enabled", 36873697L), java.util.Map.entry("get_tab_size", 3905245786L),
			java.util.Map.entry("get_selection_to_column", 1591665591L),
			java.util.Map.entry("set_line_background_color", 2878471219L),
			java.util.Map.entry("set_caret_blink_enabled", 2586408642L),
			java.util.Map.entry("is_in_mulitcaret_edit", 36873697L), java.util.Map.entry("is_editable", 36873697L),
			java.util.Map.entry("is_gutter_clickable", 1116898809L),
			java.util.Map.entry("is_caret_blink_enabled", 36873697L),
			java.util.Map.entry("set_selection_origin_column", 2230941749L),
			java.util.Map.entry("set_draw_tabs", 2586408642L),
			java.util.Map.entry("get_selection_from_column", 1591665591L),
			java.util.Map.entry("get_line_wrap_count", 923996154L), java.util.Map.entry("deselect", 1025054187L),
			java.util.Map.entry("is_custom_word_separators_enabled", 36873697L),
			java.util.Map.entry("is_line_gutter_clickable", 2522259332L),
			java.util.Map.entry("delete_selection", 1025054187L),
			java.util.Map.entry("get_selection_origin_line", 1591665591L),
			java.util.Map.entry("is_drawing_spaces", 36873697L), java.util.Map.entry("set_draw_minimap", 2586408642L),
			java.util.Map.entry("set_syntax_highlighter", 2765644541L),
			java.util.Map.entry("is_drawing_caret_when_editable_disabled", 36873697L),
			java.util.Map.entry("get_next_visible_line_offset_from", 3175239445L),
			java.util.Map.entry("is_caret_after_selection_origin", 1051549951L),
			java.util.Map.entry("remove_text", 4275841770L),
			java.util.Map.entry("get_scroll_pos_for_line", 3929084198L),
			java.util.Map.entry("get_line_width", 688195400L), java.util.Map.entry("select_all", 3218959716L),
			java.util.Map.entry("is_drawing_minimap", 36873697L),
			java.util.Map.entry("set_custom_word_separators", 83702148L),
			java.util.Map.entry("has_ime_text", 36873697L), java.util.Map.entry("get_line_gutter_text", 1391810591L),
			java.util.Map.entry("set_editable", 2586408642L),
			java.util.Map.entry("get_line_background_color", 3457211756L),
			java.util.Map.entry("tag_saved_version", 3218959716L),
			java.util.Map.entry("get_saved_version", 3905245786L),
			java.util.Map.entry("set_structured_text_bidi_override_options", 381264803L),
			java.util.Map.entry("add_caret_at_carets", 2586408642L),
			java.util.Map.entry("get_line_ranges_from_carets", 2393089247L),
			java.util.Map.entry("is_empty_selection_clipboard_enabled", 36873697L),
			java.util.Map.entry("set_fit_content_width_enabled", 2586408642L),
			java.util.Map.entry("collapse_carets", 228654177L),
			java.util.Map.entry("set_empty_selection_clipboard_enabled", 2586408642L),
			java.util.Map.entry("set_v_scroll_speed", 373806689L), java.util.Map.entry("remove_caret", 1286410249L),
			java.util.Map.entry("multicaret_edit_ignore_caret", 1116898809L),
			java.util.Map.entry("set_selection_origin_line", 195434140L),
			java.util.Map.entry("set_line_gutter_text", 2285447957L),
			java.util.Map.entry("set_caret_mid_grapheme_enabled", 2586408642L),
			java.util.Map.entry("set_gutter_custom_draw", 957362965L), java.util.Map.entry("set_text", 83702148L),
			java.util.Map.entry("get_syntax_highlighter", 2721131626L),
			java.util.Map.entry("get_visible_line_count_in_range", 3175239445L),
			java.util.Map.entry("get_gutter_name", 844755477L),
			java.util.Map.entry("set_backspace_deletes_composite_character_enabled", 2586408642L),
			java.util.Map.entry("center_viewport_to_caret", 1995695955L),
			java.util.Map.entry("is_context_menu_enabled", 36873697L),
			java.util.Map.entry("insert_line_at", 501894301L),
			java.util.Map.entry("set_highlight_current_line", 2586408642L),
			java.util.Map.entry("get_pos_at_line_column", 410388347L),
			java.util.Map.entry("get_visible_line_count", 3905245786L), java.util.Map.entry("paste", 1025054187L),
			java.util.Map.entry("get_custom_word_separators", 201670096L),
			java.util.Map.entry("get_line_with_ime", 844755477L), java.util.Map.entry("undo", 3218959716L),
			java.util.Map.entry("backspace", 1025054187L), java.util.Map.entry("is_menu_visible", 36873697L),
			java.util.Map.entry("is_shortcut_keys_enabled", 36873697L),
			java.util.Map.entry("is_smooth_scroll_enabled", 36873697L),
			java.util.Map.entry("set_line_as_last_visible", 2230941749L),
			java.util.Map.entry("remove_gutter", 1286410249L),
			java.util.Map.entry("set_draw_control_chars", 2586408642L),
			java.util.Map.entry("get_selection_from_line", 1591665591L),
			java.util.Map.entry("get_last_full_visible_line_wrap_index", 3905245786L),
			java.util.Map.entry("is_backspace_deletes_composite_character_enabled", 36873697L),
			java.util.Map.entry("get_caret_type", 2830252959L), java.util.Map.entry("has_redo", 36873697L),
			java.util.Map.entry("set_line_as_first_visible", 2230941749L),
			java.util.Map.entry("cancel_ime", 3218959716L), java.util.Map.entry("end_action", 3218959716L),
			java.util.Map.entry("get_line", 844755477L),
			java.util.Map.entry("set_multiple_carets_enabled", 2586408642L),
			java.util.Map.entry("set_caret_type", 1211596914L),
			java.util.Map.entry("set_fit_content_height_enabled", 2586408642L),
			java.util.Map.entry("is_middle_mouse_paste_enabled", 36873697L),
			java.util.Map.entry("get_line_height", 3905245786L), java.util.Map.entry("get_v_scroll_speed", 1740695150L),
			java.util.Map.entry("get_gutter_count", 3905245786L), java.util.Map.entry("get_caret_column", 1591665591L),
			java.util.Map.entry("adjust_viewport_to_caret", 1995695955L), java.util.Map.entry("select", 2560984452L),
			java.util.Map.entry("is_virtual_keyboard_enabled", 36873697L),
			java.util.Map.entry("merge_gutters", 3937882851L),
			java.util.Map.entry("get_previous_composite_character_column", 3175239445L),
			java.util.Map.entry("get_last_full_visible_line", 3905245786L),
			java.util.Map.entry("get_selection_mode", 3750106938L), java.util.Map.entry("get_gutter_width", 923996154L),
			java.util.Map.entry("has_undo", 36873697L), java.util.Map.entry("get_language", 201670096L),
			java.util.Map.entry("is_default_word_separators_enabled", 36873697L),
			java.util.Map.entry("set_language", 83702148L), java.util.Map.entry("set_placeholder", 83702148L),
			java.util.Map.entry("set_gutter_name", 501894301L), java.util.Map.entry("is_line_wrapped", 1116898809L),
			java.util.Map.entry("is_move_caret_on_right_click_enabled", 36873697L),
			java.util.Map.entry("is_highlight_all_occurrences_enabled", 36873697L),
			java.util.Map.entry("set_minimap_width", 1286410249L), java.util.Map.entry("set_v_scroll", 373806689L),
			java.util.Map.entry("insert_text", 1881564334L), java.util.Map.entry("is_overtype_mode_enabled", 36873697L),
			java.util.Map.entry("get_total_visible_line_count", 3905245786L),
			java.util.Map.entry("set_draw_spaces", 2586408642L),
			java.util.Map.entry("get_first_non_whitespace_column", 923996154L),
			java.util.Map.entry("get_minimap_width", 3905245786L),
			java.util.Map.entry("is_gutter_overwritable", 1116898809L),
			java.util.Map.entry("is_dragging_cursor", 36873697L), java.util.Map.entry("apply_ime", 3218959716L),
			java.util.Map.entry("set_search_text", 83702148L), java.util.Map.entry("get_h_scroll_bar", 3774687988L),
			java.util.Map.entry("merge_overlapping_carets", 3218959716L),
			java.util.Map.entry("get_word_under_caret", 3929349208L),
			java.util.Map.entry("get_selection_to_line", 1591665591L), java.util.Map.entry("set_h_scroll", 1286410249L),
			java.util.Map.entry("swap_lines", 3937882851L), java.util.Map.entry("set_selecting_enabled", 2586408642L),
			java.util.Map.entry("adjust_carets_after_edit", 1770277138L),
			java.util.Map.entry("get_minimap_visible_lines", 3905245786L),
			java.util.Map.entry("get_caret_count", 3905245786L), java.util.Map.entry("get_selected_text", 2309358862L),
			java.util.Map.entry("get_first_visible_line", 3905245786L),
			java.util.Map.entry("is_fit_content_width_enabled", 36873697L), java.util.Map.entry("copy", 1025054187L),
			java.util.Map.entry("set_drag_and_drop_selection_enabled", 2586408642L),
			java.util.Map.entry("set_line_gutter_icon", 176101966L), java.util.Map.entry("get_menu", 229722558L),
			java.util.Map.entry("has_selection", 2824505868L),
			java.util.Map.entry("set_emoji_menu_enabled", 2586408642L),
			java.util.Map.entry("get_sorted_carets", 2131714034L), java.util.Map.entry("is_drawing_tabs", 36873697L),
			java.util.Map.entry("get_version", 3905245786L), java.util.Map.entry("get_line_column_at_pos", 3472935744L),
			java.util.Map.entry("get_draw_control_chars", 36873697L),
			java.util.Map.entry("is_multiple_carets_enabled", 36873697L),
			java.util.Map.entry("get_line_wrapping_mode", 3562716114L),
			java.util.Map.entry("get_caret_draw_pos", 478253731L), java.util.Map.entry("get_h_scroll", 3905245786L),
			java.util.Map.entry("is_caret_visible", 1051549951L),
			java.util.Map.entry("set_line_gutter_clickable", 1383440665L),
			java.util.Map.entry("is_indent_wrapped_lines", 36873697L),
			java.util.Map.entry("remove_secondary_carets", 3218959716L),
			java.util.Map.entry("remove_line_at", 972357352L), java.util.Map.entry("get_word_at_pos", 3674420000L),
			java.util.Map.entry("set_scroll_past_end_of_file_enabled", 2586408642L),
			java.util.Map.entry("get_caret_line", 1591665591L), java.util.Map.entry("get_selection_line", 1591665591L),
			java.util.Map.entry("get_text", 201670096L), java.util.Map.entry("select_word_under_caret", 1025054187L),
			java.util.Map.entry("set_use_custom_word_separators", 2586408642L),
			java.util.Map.entry("is_caret_mid_grapheme_enabled", 36873697L),
			java.util.Map.entry("get_minimap_line_at_pos", 2485466453L),
			java.util.Map.entry("set_caret_line", 1302582944L),
			java.util.Map.entry("add_selection_for_next_occurrence", 3218959716L),
			java.util.Map.entry("set_overtype_mode_enabled", 2586408642L),
			java.util.Map.entry("get_next_visible_line_index_offset_from", 3386475622L),
			java.util.Map.entry("get_selection_origin_column", 1591665591L),
			java.util.Map.entry("menu_option", 1286410249L),
			java.util.Map.entry("get_caret_index_edit_order", 969006518L),
			java.util.Map.entry("set_caret_column", 3796796178L),
			java.util.Map.entry("set_draw_caret_when_editable_disabled", 2586408642L),
			java.util.Map.entry("get_placeholder", 201670096L),
			java.util.Map.entry("begin_multicaret_edit", 3218959716L),
			java.util.Map.entry("set_selection_mode", 1658801786L),
			java.util.Map.entry("set_smooth_scroll_enabled", 2586408642L),
			java.util.Map.entry("set_gutter_overwritable", 300928843L),
			java.util.Map.entry("paste_primary_clipboard", 1025054187L),
			java.util.Map.entry("is_gutter_drawn", 1116898809L), java.util.Map.entry("get_text_direction", 797257663L),
			java.util.Map.entry("insert_text_at_caret", 2697778442L),
			java.util.Map.entry("set_tooltip_request_func", 1611583062L), java.util.Map.entry("redo", 3218959716L),
			java.util.Map.entry("set_line_wrapping_mode", 2525115309L),
			java.util.Map.entry("start_action", 2834827583L), java.util.Map.entry("end_complex_operation", 3218959716L),
			java.util.Map.entry("is_mouse_over_selection", 1840282309L),
			java.util.Map.entry("get_rect_at_line_column", 3256618057L),
			java.util.Map.entry("begin_complex_operation", 3218959716L),
			java.util.Map.entry("get_line_wrap_index_at_column", 3175239445L),
			java.util.Map.entry("set_tab_input_mode", 2586408642L),
			java.util.Map.entry("set_line_gutter_metadata", 2060538656L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("set_gutter_width", 3937882851L),
			java.util.Map.entry("set_middle_mouse_paste_enabled", 2586408642L),
			java.util.Map.entry("set_line", 501894301L), java.util.Map.entry("set_caret_blink_interval", 373806689L),
			java.util.Map.entry("is_fit_content_height_enabled", 36873697L),
			java.util.Map.entry("get_gutter_type", 1159699127L), java.util.Map.entry("add_caret", 50157827L),
			java.util.Map.entry("set_line_gutter_item_color", 3733378741L),
			java.util.Map.entry("get_indent_level", 923996154L), java.util.Map.entry("set_search_flags", 1286410249L),
			java.util.Map.entry("get_v_scroll", 1740695150L));

	TextEdit(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextEdit(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_ime_text() {
		return (boolean) super.call("has_ime_text");
	}

	public void cancel_ime() {
		super.call("cancel_ime");
	}

	public void apply_ime() {
		super.call("apply_ime");
	}

	public boolean is_editable() {
		return (boolean) super.call("is_editable");
	}

	public boolean is_indent_wrapped_lines() {
		return (boolean) super.call("is_indent_wrapped_lines");
	}

	public boolean is_overtype_mode_enabled() {
		return (boolean) super.call("is_overtype_mode_enabled");
	}

	public boolean is_context_menu_enabled() {
		return (boolean) super.call("is_context_menu_enabled");
	}

	public boolean is_emoji_menu_enabled() {
		return (boolean) super.call("is_emoji_menu_enabled");
	}

	public boolean is_backspace_deletes_composite_character_enabled() {
		return (boolean) super.call("is_backspace_deletes_composite_character_enabled");
	}

	public boolean is_shortcut_keys_enabled() {
		return (boolean) super.call("is_shortcut_keys_enabled");
	}

	public boolean is_virtual_keyboard_enabled() {
		return (boolean) super.call("is_virtual_keyboard_enabled");
	}

	public boolean is_middle_mouse_paste_enabled() {
		return (boolean) super.call("is_middle_mouse_paste_enabled");
	}

	public boolean is_empty_selection_clipboard_enabled() {
		return (boolean) super.call("is_empty_selection_clipboard_enabled");
	}

	public void clear() {
		super.call("clear");
	}

	public void set_line(long line, String new_text) {
		super.call("set_line", new java.lang.Object[]{java.lang.Long.valueOf(line), (java.lang.Object) new_text});
	}

	public String get_line(long line) {
		return (String) super.call("get_line", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public String get_line_with_ime(long line) {
		return (String) super.call("get_line_with_ime", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public int get_line_width(long line, long wrap_index) {
		return (int) super.call("get_line_width",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(wrap_index)});
	}

	public int get_indent_level(long line) {
		return (int) super.call("get_indent_level", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public int get_first_non_whitespace_column(long line) {
		return (int) super.call("get_first_non_whitespace_column",
				new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void swap_lines(long from_line, long to_line) {
		super.call("swap_lines",
				new java.lang.Object[]{java.lang.Long.valueOf(from_line), java.lang.Long.valueOf(to_line)});
	}

	public void insert_line_at(long line, String text) {
		super.call("insert_line_at", new java.lang.Object[]{java.lang.Long.valueOf(line), (java.lang.Object) text});
	}

	public void remove_line_at(long line, boolean move_carets_down) {
		super.call("remove_line_at",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Boolean.valueOf(move_carets_down)});
	}

	public void insert_text_at_caret(String text, long caret_index) {
		super.call("insert_text_at_caret",
				new java.lang.Object[]{(java.lang.Object) text, java.lang.Long.valueOf(caret_index)});
	}

	public void insert_text(String text, long line, long column, boolean before_selection_begin,
			boolean before_selection_end) {
		super.call("insert_text",
				new java.lang.Object[]{(java.lang.Object) text, java.lang.Long.valueOf(line),
						java.lang.Long.valueOf(column), java.lang.Boolean.valueOf(before_selection_begin),
						java.lang.Boolean.valueOf(before_selection_end)});
	}

	public void remove_text(long from_line, long from_column, long to_line, long to_column) {
		super.call("remove_text",
				new java.lang.Object[]{java.lang.Long.valueOf(from_line), java.lang.Long.valueOf(from_column),
						java.lang.Long.valueOf(to_line), java.lang.Long.valueOf(to_column)});
	}

	public int get_next_visible_line_offset_from(long line, long visible_amount) {
		return (int) super.call("get_next_visible_line_offset_from",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(visible_amount)});
	}

	public Vector2i get_next_visible_line_index_offset_from(long line, long wrap_index, long visible_amount) {
		return (Vector2i) super.call("get_next_visible_line_index_offset_from",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(wrap_index),
						java.lang.Long.valueOf(visible_amount)});
	}

	public void backspace(long caret_index) {
		super.call("backspace", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public void cut(long caret_index) {
		super.call("cut", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public void copy(long caret_index) {
		super.call("copy", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public void paste(long caret_index) {
		super.call("paste", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public void paste_primary_clipboard(long caret_index) {
		super.call("paste_primary_clipboard", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public void start_action(int action) {
		super.call("start_action", new java.lang.Object[]{java.lang.Integer.valueOf(action)});
	}

	public void end_action() {
		super.call("end_action");
	}

	public void begin_complex_operation() {
		super.call("begin_complex_operation");
	}

	public void end_complex_operation() {
		super.call("end_complex_operation");
	}

	public boolean has_undo() {
		return (boolean) super.call("has_undo");
	}

	public boolean has_redo() {
		return (boolean) super.call("has_redo");
	}

	public void undo() {
		super.call("undo");
	}

	public void redo() {
		super.call("redo");
	}

	public void clear_undo_history() {
		super.call("clear_undo_history");
	}

	public void tag_saved_version() {
		super.call("tag_saved_version");
	}

	public Vector2i search(String text, long flags, long from_line, long from_column) {
		return (Vector2i) super.call("search", new java.lang.Object[]{(java.lang.Object) text,
				java.lang.Long.valueOf(flags), java.lang.Long.valueOf(from_line), java.lang.Long.valueOf(from_column)});
	}

	public String get_word_at_pos(Vector2 position) {
		return (String) super.call("get_word_at_pos", new java.lang.Object[]{(java.lang.Object) position});
	}

	public Vector2i get_line_column_at_pos(Vector2i position, boolean clamp_line, boolean clamp_column) {
		return (Vector2i) super.call("get_line_column_at_pos", new java.lang.Object[]{(java.lang.Object) position,
				java.lang.Boolean.valueOf(clamp_line), java.lang.Boolean.valueOf(clamp_column)});
	}

	public Vector2i get_pos_at_line_column(long line, long column) {
		return (Vector2i) super.call("get_pos_at_line_column",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(column)});
	}

	public Rect2i get_rect_at_line_column(long line, long column) {
		return (Rect2i) super.call("get_rect_at_line_column",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(column)});
	}

	public int get_minimap_line_at_pos(Vector2i position) {
		return (int) super.call("get_minimap_line_at_pos", new java.lang.Object[]{(java.lang.Object) position});
	}

	public boolean is_dragging_cursor() {
		return (boolean) super.call("is_dragging_cursor");
	}

	public boolean is_mouse_over_selection(boolean edges, long caret_index) {
		return (boolean) super.call("is_mouse_over_selection",
				new java.lang.Object[]{java.lang.Boolean.valueOf(edges), java.lang.Long.valueOf(caret_index)});
	}

	public boolean is_caret_blink_enabled() {
		return (boolean) super.call("is_caret_blink_enabled");
	}

	public boolean is_drawing_caret_when_editable_disabled() {
		return (boolean) super.call("is_drawing_caret_when_editable_disabled");
	}

	public boolean is_move_caret_on_right_click_enabled() {
		return (boolean) super.call("is_move_caret_on_right_click_enabled");
	}

	public boolean is_caret_mid_grapheme_enabled() {
		return (boolean) super.call("is_caret_mid_grapheme_enabled");
	}

	public boolean is_multiple_carets_enabled() {
		return (boolean) super.call("is_multiple_carets_enabled");
	}

	public int add_caret(long line, long column) {
		return (int) super.call("add_caret",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(column)});
	}

	public void remove_caret(long caret) {
		super.call("remove_caret", new java.lang.Object[]{java.lang.Long.valueOf(caret)});
	}

	public void remove_secondary_carets() {
		super.call("remove_secondary_carets");
	}

	public void add_caret_at_carets(boolean below) {
		super.call("add_caret_at_carets", new java.lang.Object[]{java.lang.Boolean.valueOf(below)});
	}

	public int[] get_sorted_carets(boolean include_ignored_carets) {
		return (int[]) super.call("get_sorted_carets",
				new java.lang.Object[]{java.lang.Boolean.valueOf(include_ignored_carets)});
	}

	public void collapse_carets(long from_line, long from_column, long to_line, long to_column, boolean inclusive) {
		super.call("collapse_carets",
				new java.lang.Object[]{java.lang.Long.valueOf(from_line), java.lang.Long.valueOf(from_column),
						java.lang.Long.valueOf(to_line), java.lang.Long.valueOf(to_column),
						java.lang.Boolean.valueOf(inclusive)});
	}

	public void merge_overlapping_carets() {
		super.call("merge_overlapping_carets");
	}

	public void begin_multicaret_edit() {
		super.call("begin_multicaret_edit");
	}

	public void end_multicaret_edit() {
		super.call("end_multicaret_edit");
	}

	public boolean is_in_mulitcaret_edit() {
		return (boolean) super.call("is_in_mulitcaret_edit");
	}

	public boolean multicaret_edit_ignore_caret(long caret_index) {
		return (boolean) super.call("multicaret_edit_ignore_caret",
				new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public boolean is_caret_visible(long caret_index) {
		return (boolean) super.call("is_caret_visible", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public Vector2 get_caret_draw_pos(long caret_index) {
		return (Vector2) super.call("get_caret_draw_pos", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public void set_caret_line(long line, boolean adjust_viewport, boolean can_be_hidden, long wrap_index,
			long caret_index) {
		super.call("set_caret_line",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Boolean.valueOf(adjust_viewport),
						java.lang.Boolean.valueOf(can_be_hidden), java.lang.Long.valueOf(wrap_index),
						java.lang.Long.valueOf(caret_index)});
	}

	public int get_caret_line(long caret_index) {
		return (int) super.call("get_caret_line", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public void set_caret_column(long column, boolean adjust_viewport, long caret_index) {
		super.call("set_caret_column", new java.lang.Object[]{java.lang.Long.valueOf(column),
				java.lang.Boolean.valueOf(adjust_viewport), java.lang.Long.valueOf(caret_index)});
	}

	public int get_caret_column(long caret_index) {
		return (int) super.call("get_caret_column", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public int get_next_composite_character_column(long line, long column) {
		return (int) super.call("get_next_composite_character_column",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(column)});
	}

	public int get_previous_composite_character_column(long line, long column) {
		return (int) super.call("get_previous_composite_character_column",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(column)});
	}

	public int get_caret_wrap_index(long caret_index) {
		return (int) super.call("get_caret_wrap_index", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public String get_word_under_caret(long caret_index) {
		return (String) super.call("get_word_under_caret", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public boolean is_default_word_separators_enabled() {
		return (boolean) super.call("is_default_word_separators_enabled");
	}

	public boolean is_custom_word_separators_enabled() {
		return (boolean) super.call("is_custom_word_separators_enabled");
	}

	public boolean is_selecting_enabled() {
		return (boolean) super.call("is_selecting_enabled");
	}

	public boolean is_deselect_on_focus_loss_enabled() {
		return (boolean) super.call("is_deselect_on_focus_loss_enabled");
	}

	public boolean is_drag_and_drop_selection_enabled() {
		return (boolean) super.call("is_drag_and_drop_selection_enabled");
	}

	public void select_all() {
		super.call("select_all");
	}

	public void select_word_under_caret(long caret_index) {
		super.call("select_word_under_caret", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public void add_selection_for_next_occurrence() {
		super.call("add_selection_for_next_occurrence");
	}

	public void skip_selection_for_next_occurrence() {
		super.call("skip_selection_for_next_occurrence");
	}

	public void select(long origin_line, long origin_column, long caret_line, long caret_column, long caret_index) {
		super.call("select",
				new java.lang.Object[]{java.lang.Long.valueOf(origin_line), java.lang.Long.valueOf(origin_column),
						java.lang.Long.valueOf(caret_line), java.lang.Long.valueOf(caret_column),
						java.lang.Long.valueOf(caret_index)});
	}

	public boolean has_selection(long caret_index) {
		return (boolean) super.call("has_selection", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public String get_selected_text(long caret_index) {
		return (String) super.call("get_selected_text", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public int get_selection_at_line_column(long line, long column, boolean include_edges, boolean only_selections) {
		return (int) super.call("get_selection_at_line_column",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(column),
						java.lang.Boolean.valueOf(include_edges), java.lang.Boolean.valueOf(only_selections)});
	}

	public Vector2i[] get_line_ranges_from_carets(boolean only_selections, boolean merge_adjacent) {
		return (Vector2i[]) super.call("get_line_ranges_from_carets", new java.lang.Object[]{
				java.lang.Boolean.valueOf(only_selections), java.lang.Boolean.valueOf(merge_adjacent)});
	}

	public int get_selection_origin_line(long caret_index) {
		return (int) super.call("get_selection_origin_line",
				new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public int get_selection_origin_column(long caret_index) {
		return (int) super.call("get_selection_origin_column",
				new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public void set_selection_origin_line(long line, boolean can_be_hidden, long wrap_index, long caret_index) {
		super.call("set_selection_origin_line",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Boolean.valueOf(can_be_hidden),
						java.lang.Long.valueOf(wrap_index), java.lang.Long.valueOf(caret_index)});
	}

	public void set_selection_origin_column(long column, long caret_index) {
		super.call("set_selection_origin_column",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Long.valueOf(caret_index)});
	}

	public int get_selection_from_line(long caret_index) {
		return (int) super.call("get_selection_from_line", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public int get_selection_from_column(long caret_index) {
		return (int) super.call("get_selection_from_column",
				new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public int get_selection_to_line(long caret_index) {
		return (int) super.call("get_selection_to_line", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public int get_selection_to_column(long caret_index) {
		return (int) super.call("get_selection_to_column", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public boolean is_caret_after_selection_origin(long caret_index) {
		return (boolean) super.call("is_caret_after_selection_origin",
				new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public void deselect(long caret_index) {
		super.call("deselect", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public void delete_selection(long caret_index) {
		super.call("delete_selection", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public boolean is_line_wrapped(long line) {
		return (boolean) super.call("is_line_wrapped", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public int get_line_wrap_count(long line) {
		return (int) super.call("get_line_wrap_count", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public int get_line_wrap_index_at_column(long line, long column) {
		return (int) super.call("get_line_wrap_index_at_column",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(column)});
	}

	public String[] get_line_wrapped_text(long line) {
		return (String[]) super.call("get_line_wrapped_text", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public boolean is_smooth_scroll_enabled() {
		return (boolean) super.call("is_smooth_scroll_enabled");
	}

	public boolean is_scroll_past_end_of_file_enabled() {
		return (boolean) super.call("is_scroll_past_end_of_file_enabled");
	}

	public boolean is_fit_content_height_enabled() {
		return (boolean) super.call("is_fit_content_height_enabled");
	}

	public boolean is_fit_content_width_enabled() {
		return (boolean) super.call("is_fit_content_width_enabled");
	}

	public double get_scroll_pos_for_line(long line, long wrap_index) {
		return (double) super.call("get_scroll_pos_for_line",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(wrap_index)});
	}

	public void set_line_as_first_visible(long line, long wrap_index) {
		super.call("set_line_as_first_visible",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(wrap_index)});
	}

	public void set_line_as_center_visible(long line, long wrap_index) {
		super.call("set_line_as_center_visible",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(wrap_index)});
	}

	public void set_line_as_last_visible(long line, long wrap_index) {
		super.call("set_line_as_last_visible",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(wrap_index)});
	}

	public int get_visible_line_count_in_range(long from_line, long to_line) {
		return (int) super.call("get_visible_line_count_in_range",
				new java.lang.Object[]{java.lang.Long.valueOf(from_line), java.lang.Long.valueOf(to_line)});
	}

	public void adjust_viewport_to_caret(long caret_index) {
		super.call("adjust_viewport_to_caret", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public void center_viewport_to_caret(long caret_index) {
		super.call("center_viewport_to_caret", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public boolean is_drawing_minimap() {
		return (boolean) super.call("is_drawing_minimap");
	}

	public void add_gutter(long at) {
		super.call("add_gutter", new java.lang.Object[]{java.lang.Long.valueOf(at)});
	}

	public void remove_gutter(long gutter) {
		super.call("remove_gutter", new java.lang.Object[]{java.lang.Long.valueOf(gutter)});
	}

	public void set_gutter_name(long gutter, String name) {
		super.call("set_gutter_name", new java.lang.Object[]{java.lang.Long.valueOf(gutter), (java.lang.Object) name});
	}

	public String get_gutter_name(long gutter) {
		return (String) super.call("get_gutter_name", new java.lang.Object[]{java.lang.Long.valueOf(gutter)});
	}

	public void set_gutter_type(long gutter, int type) {
		super.call("set_gutter_type",
				new java.lang.Object[]{java.lang.Long.valueOf(gutter), java.lang.Integer.valueOf(type)});
	}

	public int get_gutter_type(long gutter) {
		return (int) super.call("get_gutter_type", new java.lang.Object[]{java.lang.Long.valueOf(gutter)});
	}

	public void set_gutter_width(long gutter, long width) {
		super.call("set_gutter_width",
				new java.lang.Object[]{java.lang.Long.valueOf(gutter), java.lang.Long.valueOf(width)});
	}

	public int get_gutter_width(long gutter) {
		return (int) super.call("get_gutter_width", new java.lang.Object[]{java.lang.Long.valueOf(gutter)});
	}

	public void set_gutter_draw(long gutter, boolean draw) {
		super.call("set_gutter_draw",
				new java.lang.Object[]{java.lang.Long.valueOf(gutter), java.lang.Boolean.valueOf(draw)});
	}

	public boolean is_gutter_drawn(long gutter) {
		return (boolean) super.call("is_gutter_drawn", new java.lang.Object[]{java.lang.Long.valueOf(gutter)});
	}

	public void set_gutter_clickable(long gutter, boolean clickable) {
		super.call("set_gutter_clickable",
				new java.lang.Object[]{java.lang.Long.valueOf(gutter), java.lang.Boolean.valueOf(clickable)});
	}

	public boolean is_gutter_clickable(long gutter) {
		return (boolean) super.call("is_gutter_clickable", new java.lang.Object[]{java.lang.Long.valueOf(gutter)});
	}

	public void set_gutter_overwritable(long gutter, boolean overwritable) {
		super.call("set_gutter_overwritable",
				new java.lang.Object[]{java.lang.Long.valueOf(gutter), java.lang.Boolean.valueOf(overwritable)});
	}

	public boolean is_gutter_overwritable(long gutter) {
		return (boolean) super.call("is_gutter_overwritable", new java.lang.Object[]{java.lang.Long.valueOf(gutter)});
	}

	public void merge_gutters(long from_line, long to_line) {
		super.call("merge_gutters",
				new java.lang.Object[]{java.lang.Long.valueOf(from_line), java.lang.Long.valueOf(to_line)});
	}

	public void set_gutter_custom_draw(long column, Callable draw_callback) {
		super.call("set_gutter_custom_draw",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) draw_callback});
	}

	public void set_line_gutter_metadata(long line, long gutter, Object metadata) {
		super.call("set_line_gutter_metadata", new java.lang.Object[]{java.lang.Long.valueOf(line),
				java.lang.Long.valueOf(gutter), (java.lang.Object) metadata});
	}

	public Object get_line_gutter_metadata(long line, long gutter) {
		return (Object) super.call("get_line_gutter_metadata",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(gutter)});
	}

	public void set_line_gutter_text(long line, long gutter, String text) {
		super.call("set_line_gutter_text", new java.lang.Object[]{java.lang.Long.valueOf(line),
				java.lang.Long.valueOf(gutter), (java.lang.Object) text});
	}

	public String get_line_gutter_text(long line, long gutter) {
		return (String) super.call("get_line_gutter_text",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(gutter)});
	}

	public void set_line_gutter_icon(long line, long gutter, Texture2D icon) {
		super.call("set_line_gutter_icon", new java.lang.Object[]{java.lang.Long.valueOf(line),
				java.lang.Long.valueOf(gutter), (java.lang.Object) icon});
	}

	public Texture2D get_line_gutter_icon(long line, long gutter) {
		return (Texture2D) super.call("get_line_gutter_icon",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(gutter)});
	}

	public void set_line_gutter_item_color(long line, long gutter, Color color) {
		super.call("set_line_gutter_item_color", new java.lang.Object[]{java.lang.Long.valueOf(line),
				java.lang.Long.valueOf(gutter), (java.lang.Object) color});
	}

	public Color get_line_gutter_item_color(long line, long gutter) {
		return (Color) super.call("get_line_gutter_item_color",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(gutter)});
	}

	public void set_line_gutter_clickable(long line, long gutter, boolean clickable) {
		super.call("set_line_gutter_clickable", new java.lang.Object[]{java.lang.Long.valueOf(line),
				java.lang.Long.valueOf(gutter), java.lang.Boolean.valueOf(clickable)});
	}

	public boolean is_line_gutter_clickable(long line, long gutter) {
		return (boolean) super.call("is_line_gutter_clickable",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(gutter)});
	}

	public void set_line_background_color(long line, Color color) {
		super.call("set_line_background_color",
				new java.lang.Object[]{java.lang.Long.valueOf(line), (java.lang.Object) color});
	}

	public Color get_line_background_color(long line) {
		return (Color) super.call("get_line_background_color", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public boolean is_highlight_current_line_enabled() {
		return (boolean) super.call("is_highlight_current_line_enabled");
	}

	public boolean is_highlight_all_occurrences_enabled() {
		return (boolean) super.call("is_highlight_all_occurrences_enabled");
	}

	public boolean is_drawing_tabs() {
		return (boolean) super.call("is_drawing_tabs");
	}

	public boolean is_drawing_spaces() {
		return (boolean) super.call("is_drawing_spaces");
	}

	public boolean is_menu_visible() {
		return (boolean) super.call("is_menu_visible");
	}

	public void menu_option(long option) {
		super.call("menu_option", new java.lang.Object[]{java.lang.Long.valueOf(option)});
	}

	public void adjust_carets_after_edit(long caret, long from_line, long from_col, long to_line, long to_col) {
		super.call("adjust_carets_after_edit",
				new java.lang.Object[]{java.lang.Long.valueOf(caret), java.lang.Long.valueOf(from_line),
						java.lang.Long.valueOf(from_col), java.lang.Long.valueOf(to_line),
						java.lang.Long.valueOf(to_col)});
	}

	public int get_selection_line(long caret_index) {
		return (int) super.call("get_selection_line", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public int get_selection_column(long caret_index) {
		return (int) super.call("get_selection_column", new java.lang.Object[]{java.lang.Long.valueOf(caret_index)});
	}

	public String getText() {
		return (String) super.call("get_text", new java.lang.Object[0]);
	}

	public void setText(String value) {
		super.call("set_text", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getPlaceholder_text() {
		return (String) super.call("get_placeholder", new java.lang.Object[0]);
	}

	public void setPlaceholder_text(String value) {
		super.call("set_placeholder", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isEditable() {
		return (boolean) super.call("is_editable", new java.lang.Object[0]);
	}

	public void setEditable(boolean value) {
		super.call("set_editable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isContext_menu_enabled() {
		return (boolean) super.call("is_context_menu_enabled", new java.lang.Object[0]);
	}

	public void setContext_menu_enabled(boolean value) {
		super.call("set_context_menu_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEmoji_menu_enabled() {
		return (boolean) super.call("is_emoji_menu_enabled", new java.lang.Object[0]);
	}

	public void setEmoji_menu_enabled(boolean value) {
		super.call("set_emoji_menu_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isBackspace_deletes_composite_character_enabled() {
		return (boolean) super.call("is_backspace_deletes_composite_character_enabled", new java.lang.Object[0]);
	}

	public void setBackspace_deletes_composite_character_enabled(boolean value) {
		super.call("set_backspace_deletes_composite_character_enabled",
				new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isShortcut_keys_enabled() {
		return (boolean) super.call("is_shortcut_keys_enabled", new java.lang.Object[0]);
	}

	public void setShortcut_keys_enabled(boolean value) {
		super.call("set_shortcut_keys_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isSelecting_enabled() {
		return (boolean) super.call("is_selecting_enabled", new java.lang.Object[0]);
	}

	public void setSelecting_enabled(boolean value) {
		super.call("set_selecting_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDeselect_on_focus_loss_enabled() {
		return (boolean) super.call("is_deselect_on_focus_loss_enabled", new java.lang.Object[0]);
	}

	public void setDeselect_on_focus_loss_enabled(boolean value) {
		super.call("set_deselect_on_focus_loss_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDrag_and_drop_selection_enabled() {
		return (boolean) super.call("is_drag_and_drop_selection_enabled", new java.lang.Object[0]);
	}

	public void setDrag_and_drop_selection_enabled(boolean value) {
		super.call("set_drag_and_drop_selection_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isMiddle_mouse_paste_enabled() {
		return (boolean) super.call("is_middle_mouse_paste_enabled", new java.lang.Object[0]);
	}

	public void setMiddle_mouse_paste_enabled(boolean value) {
		super.call("set_middle_mouse_paste_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEmpty_selection_clipboard_enabled() {
		return (boolean) super.call("is_empty_selection_clipboard_enabled", new java.lang.Object[0]);
	}

	public void setEmpty_selection_clipboard_enabled(boolean value) {
		super.call("set_empty_selection_clipboard_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getWrap_mode() {
		return (long) super.call("get_line_wrapping_mode", new java.lang.Object[0]);
	}

	public void setWrap_mode(long value) {
		super.call("set_line_wrapping_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getAutowrap_mode() {
		return (long) super.call("get_autowrap_mode", new java.lang.Object[0]);
	}

	public void setAutowrap_mode(long value) {
		super.call("set_autowrap_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isIndent_wrapped_lines() {
		return (boolean) super.call("is_indent_wrapped_lines", new java.lang.Object[0]);
	}

	public void setIndent_wrapped_lines(boolean value) {
		super.call("set_indent_wrapped_lines", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getTab_input_mode() {
		return (boolean) super.call("get_tab_input_mode", new java.lang.Object[0]);
	}

	public void setTab_input_mode(boolean value) {
		super.call("set_tab_input_mode", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isVirtual_keyboard_enabled() {
		return (boolean) super.call("is_virtual_keyboard_enabled", new java.lang.Object[0]);
	}

	public void setVirtual_keyboard_enabled(boolean value) {
		super.call("set_virtual_keyboard_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getVirtual_keyboard_show_on_focus() {
		return (boolean) super.call("get_virtual_keyboard_show_on_focus", new java.lang.Object[0]);
	}

	public void setVirtual_keyboard_show_on_focus(boolean value) {
		super.call("set_virtual_keyboard_show_on_focus", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isScroll_smooth() {
		return (boolean) super.call("is_smooth_scroll_enabled", new java.lang.Object[0]);
	}

	public void setScroll_smooth(boolean value) {
		super.call("set_smooth_scroll_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getScroll_v_scroll_speed() {
		return (double) super.call("get_v_scroll_speed", new java.lang.Object[0]);
	}

	public void setScroll_v_scroll_speed(double value) {
		super.call("set_v_scroll_speed", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isScroll_past_end_of_file() {
		return (boolean) super.call("is_scroll_past_end_of_file_enabled", new java.lang.Object[0]);
	}

	public void setScroll_past_end_of_file(boolean value) {
		super.call("set_scroll_past_end_of_file_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getScroll_vertical() {
		return (double) super.call("get_v_scroll", new java.lang.Object[0]);
	}

	public void setScroll_vertical(double value) {
		super.call("set_v_scroll", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getScroll_horizontal() {
		return (long) super.call("get_h_scroll", new java.lang.Object[0]);
	}

	public void setScroll_horizontal(long value) {
		super.call("set_h_scroll", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isScroll_fit_content_height() {
		return (boolean) super.call("is_fit_content_height_enabled", new java.lang.Object[0]);
	}

	public void setScroll_fit_content_height(boolean value) {
		super.call("set_fit_content_height_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isScroll_fit_content_width() {
		return (boolean) super.call("is_fit_content_width_enabled", new java.lang.Object[0]);
	}

	public void setScroll_fit_content_width(boolean value) {
		super.call("set_fit_content_width_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isMinimap_draw() {
		return (boolean) super.call("is_drawing_minimap", new java.lang.Object[0]);
	}

	public void setMinimap_draw(boolean value) {
		super.call("set_draw_minimap", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getMinimap_width() {
		return (long) super.call("get_minimap_width", new java.lang.Object[0]);
	}

	public void setMinimap_width(long value) {
		super.call("set_minimap_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCaret_type() {
		return (long) super.call("get_caret_type", new java.lang.Object[0]);
	}

	public void setCaret_type(long value) {
		super.call("set_caret_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isCaret_blink() {
		return (boolean) super.call("is_caret_blink_enabled", new java.lang.Object[0]);
	}

	public void setCaret_blink(boolean value) {
		super.call("set_caret_blink_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getCaret_blink_interval() {
		return (double) super.call("get_caret_blink_interval", new java.lang.Object[0]);
	}

	public void setCaret_blink_interval(double value) {
		super.call("set_caret_blink_interval", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isCaret_draw_when_editable_disabled() {
		return (boolean) super.call("is_drawing_caret_when_editable_disabled", new java.lang.Object[0]);
	}

	public void setCaret_draw_when_editable_disabled(boolean value) {
		super.call("set_draw_caret_when_editable_disabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isCaret_move_on_right_click() {
		return (boolean) super.call("is_move_caret_on_right_click_enabled", new java.lang.Object[0]);
	}

	public void setCaret_move_on_right_click(boolean value) {
		super.call("set_move_caret_on_right_click_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isCaret_mid_grapheme() {
		return (boolean) super.call("is_caret_mid_grapheme_enabled", new java.lang.Object[0]);
	}

	public void setCaret_mid_grapheme(boolean value) {
		super.call("set_caret_mid_grapheme_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isCaret_multiple() {
		return (boolean) super.call("is_multiple_carets_enabled", new java.lang.Object[0]);
	}

	public void setCaret_multiple(boolean value) {
		super.call("set_multiple_carets_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isUse_default_word_separators() {
		return (boolean) super.call("is_default_word_separators_enabled", new java.lang.Object[0]);
	}

	public void setUse_default_word_separators(boolean value) {
		super.call("set_use_default_word_separators", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isUse_custom_word_separators() {
		return (boolean) super.call("is_custom_word_separators_enabled", new java.lang.Object[0]);
	}

	public void setUse_custom_word_separators(boolean value) {
		super.call("set_use_custom_word_separators", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getCustom_word_separators() {
		return (String) super.call("get_custom_word_separators", new java.lang.Object[0]);
	}

	public void setCustom_word_separators(String value) {
		super.call("set_custom_word_separators", new java.lang.Object[]{(java.lang.Object) value});
	}

	public SyntaxHighlighter getSyntax_highlighter() {
		return (SyntaxHighlighter) super.call("get_syntax_highlighter", new java.lang.Object[0]);
	}

	public void setSyntax_highlighter(SyntaxHighlighter value) {
		super.call("set_syntax_highlighter", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isHighlight_all_occurrences() {
		return (boolean) super.call("is_highlight_all_occurrences_enabled", new java.lang.Object[0]);
	}

	public void setHighlight_all_occurrences(boolean value) {
		super.call("set_highlight_all_occurrences", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isHighlight_current_line() {
		return (boolean) super.call("is_highlight_current_line_enabled", new java.lang.Object[0]);
	}

	public void setHighlight_current_line(boolean value) {
		super.call("set_highlight_current_line", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDraw_control_chars() {
		return (boolean) super.call("get_draw_control_chars", new java.lang.Object[0]);
	}

	public void setDraw_control_chars(boolean value) {
		super.call("set_draw_control_chars", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDraw_tabs() {
		return (boolean) super.call("is_drawing_tabs", new java.lang.Object[0]);
	}

	public void setDraw_tabs(boolean value) {
		super.call("set_draw_tabs", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDraw_spaces() {
		return (boolean) super.call("is_drawing_spaces", new java.lang.Object[0]);
	}

	public void setDraw_spaces(boolean value) {
		super.call("set_draw_spaces", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getText_direction() {
		return (long) super.call("get_text_direction", new java.lang.Object[0]);
	}

	public void setText_direction(long value) {
		super.call("set_text_direction", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getLanguage() {
		return (String) super.call("get_language", new java.lang.Object[0]);
	}

	public void setLanguage(String value) {
		super.call("set_language", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getStructured_text_bidi_override() {
		return (long) super.call("get_structured_text_bidi_override", new java.lang.Object[0]);
	}

	public void setStructured_text_bidi_override(long value) {
		super.call("set_structured_text_bidi_override", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public GodotArray getStructured_text_bidi_override_options() {
		return (GodotArray) super.call("get_structured_text_bidi_override_options", new java.lang.Object[0]);
	}

	public void setStructured_text_bidi_override_options(GodotArray value) {
		super.call("set_structured_text_bidi_override_options", new java.lang.Object[]{(java.lang.Object) value});
	}
}
