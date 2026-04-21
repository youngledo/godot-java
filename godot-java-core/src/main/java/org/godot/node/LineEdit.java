package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;

public class LineEdit extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("select", 1328111411L),
			java.util.Map.entry("set_structured_text_bidi_override", 55961453L),
			java.util.Map.entry("is_virtual_keyboard_enabled", 36873697L),
			java.util.Map.entry("set_select_all_on_focus", 2586408642L),
			java.util.Map.entry("get_previous_composite_character_column", 923996154L),
			java.util.Map.entry("has_undo", 36873697L), java.util.Map.entry("set_clear_button_enabled", 2586408642L),
			java.util.Map.entry("is_caret_force_displayed", 36873697L), java.util.Map.entry("get_language", 201670096L),
			java.util.Map.entry("set_virtual_keyboard_show_on_focus", 2586408642L),
			java.util.Map.entry("set_language", 83702148L),
			java.util.Map.entry("get_structured_text_bidi_override", 3385126229L),
			java.util.Map.entry("set_placeholder", 83702148L),
			java.util.Map.entry("get_structured_text_bidi_override_options", 3995934104L),
			java.util.Map.entry("get_virtual_keyboard_show_on_focus", 36873697L),
			java.util.Map.entry("get_max_length", 3905245786L),
			java.util.Map.entry("is_deselect_on_focus_loss_enabled", 36873697L),
			java.util.Map.entry("edit", 107499316L),
			java.util.Map.entry("get_next_composite_character_column", 923996154L),
			java.util.Map.entry("set_deselect_on_focus_loss_enabled", 2586408642L),
			java.util.Map.entry("set_context_menu_enabled", 2586408642L),
			java.util.Map.entry("is_selecting_enabled", 36873697L), java.util.Map.entry("apply_ime", 3218959716L),
			java.util.Map.entry("set_shortcut_keys_enabled", 2586408642L),
			java.util.Map.entry("get_virtual_keyboard_type", 1928699316L),
			java.util.Map.entry("is_drag_and_drop_selection_enabled", 36873697L),
			java.util.Map.entry("set_selecting_enabled", 2586408642L),
			java.util.Map.entry("set_virtual_keyboard_enabled", 2586408642L),
			java.util.Map.entry("set_right_icon", 4051416890L),
			java.util.Map.entry("get_caret_blink_interval", 1740695150L),
			java.util.Map.entry("get_selected_text", 2841200299L),
			java.util.Map.entry("set_expand_to_text_length_enabled", 2586408642L),
			java.util.Map.entry("get_horizontal_alignment", 341400642L), java.util.Map.entry("set_secret", 2586408642L),
			java.util.Map.entry("delete_char_at_caret", 3218959716L),
			java.util.Map.entry("get_icon_expand_mode", 3273584435L),
			java.util.Map.entry("set_drag_and_drop_selection_enabled", 2586408642L),
			java.util.Map.entry("set_text_direction", 119160795L),
			java.util.Map.entry("is_emoji_menu_enabled", 36873697L), java.util.Map.entry("delete_text", 3937882851L),
			java.util.Map.entry("get_selection_to_column", 3905245786L), java.util.Map.entry("get_menu", 229722558L),
			java.util.Map.entry("is_editing", 36873697L), java.util.Map.entry("has_selection", 36873697L),
			java.util.Map.entry("set_caret_blink_enabled", 2586408642L),
			java.util.Map.entry("set_emoji_menu_enabled", 2586408642L), java.util.Map.entry("is_editable", 36873697L),
			java.util.Map.entry("get_draw_control_chars", 36873697L),
			java.util.Map.entry("is_caret_blink_enabled", 36873697L), java.util.Map.entry("set_flat", 2586408642L),
			java.util.Map.entry("get_selection_from_column", 3905245786L), java.util.Map.entry("deselect", 3218959716L),
			java.util.Map.entry("is_flat", 36873697L), java.util.Map.entry("get_scroll_offset", 1740695150L),
			java.util.Map.entry("set_keep_editing_on_text_submit", 2586408642L),
			java.util.Map.entry("select_all", 3218959716L), java.util.Map.entry("has_ime_text", 36873697L),
			java.util.Map.entry("set_icon_expand_mode", 3019903192L), java.util.Map.entry("set_editable", 2586408642L),
			java.util.Map.entry("set_structured_text_bidi_override_options", 381264803L),
			java.util.Map.entry("get_text", 201670096L),
			java.util.Map.entry("is_caret_mid_grapheme_enabled", 36873697L),
			java.util.Map.entry("is_select_all_on_focus", 36873697L), java.util.Map.entry("menu_option", 1286410249L),
			java.util.Map.entry("set_caret_column", 1286410249L),
			java.util.Map.entry("set_caret_mid_grapheme_enabled", 2586408642L),
			java.util.Map.entry("set_text", 83702148L), java.util.Map.entry("get_placeholder", 201670096L),
			java.util.Map.entry("set_backspace_deletes_composite_character_enabled", 2586408642L),
			java.util.Map.entry("get_secret_character", 201670096L),
			java.util.Map.entry("get_text_direction", 797257663L),
			java.util.Map.entry("is_context_menu_enabled", 2240911060L), java.util.Map.entry("is_secret", 36873697L),
			java.util.Map.entry("unedit", 3218959716L), java.util.Map.entry("insert_text_at_caret", 83702148L),
			java.util.Map.entry("is_expand_to_text_length_enabled", 36873697L),
			java.util.Map.entry("is_menu_visible", 36873697L),
			java.util.Map.entry("is_shortcut_keys_enabled", 36873697L),
			java.util.Map.entry("set_draw_control_chars", 2586408642L),
			java.util.Map.entry("get_right_icon", 255860311L), java.util.Map.entry("get_right_icon_scale", 1740695150L),
			java.util.Map.entry("set_right_icon_scale", 373806689L),
			java.util.Map.entry("is_editing_kept_on_text_submit", 36873697L),
			java.util.Map.entry("is_backspace_deletes_composite_character_enabled", 36873697L),
			java.util.Map.entry("is_clear_button_enabled", 36873697L),
			java.util.Map.entry("set_horizontal_alignment", 2312603777L), java.util.Map.entry("has_redo", 36873697L),
			java.util.Map.entry("clear", 3218959716L), java.util.Map.entry("cancel_ime", 3218959716L),
			java.util.Map.entry("set_middle_mouse_paste_enabled", 2586408642L),
			java.util.Map.entry("set_caret_blink_interval", 373806689L),
			java.util.Map.entry("set_secret_character", 83702148L), java.util.Map.entry("set_max_length", 1286410249L),
			java.util.Map.entry("set_virtual_keyboard_type", 2696893573L),
			java.util.Map.entry("is_middle_mouse_paste_enabled", 36873697L),
			java.util.Map.entry("get_caret_column", 3905245786L),
			java.util.Map.entry("set_caret_force_displayed", 2586408642L));

	LineEdit(MemorySegment nativePointer) {
		super(nativePointer);
	}

	LineEdit(long nativePointer) {
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

	public void edit(boolean hide_focus) {
		super.call("edit", new java.lang.Object[]{java.lang.Boolean.valueOf(hide_focus)});
	}

	public void unedit() {
		super.call("unedit");
	}

	public boolean is_editing() {
		return (boolean) super.call("is_editing");
	}

	public boolean is_editing_kept_on_text_submit() {
		return (boolean) super.call("is_editing_kept_on_text_submit");
	}

	public void clear() {
		super.call("clear");
	}

	public void select(long from, long to) {
		super.call("select", new java.lang.Object[]{java.lang.Long.valueOf(from), java.lang.Long.valueOf(to)});
	}

	public void select_all() {
		super.call("select_all");
	}

	public void deselect() {
		super.call("deselect");
	}

	public boolean has_undo() {
		return (boolean) super.call("has_undo");
	}

	public boolean has_redo() {
		return (boolean) super.call("has_redo");
	}

	public boolean has_selection() {
		return (boolean) super.call("has_selection");
	}

	public int get_next_composite_character_column(long column) {
		return (int) super.call("get_next_composite_character_column",
				new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public int get_previous_composite_character_column(long column) {
		return (int) super.call("get_previous_composite_character_column",
				new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public boolean is_expand_to_text_length_enabled() {
		return (boolean) super.call("is_expand_to_text_length_enabled");
	}

	public boolean is_caret_blink_enabled() {
		return (boolean) super.call("is_caret_blink_enabled");
	}

	public boolean is_caret_mid_grapheme_enabled() {
		return (boolean) super.call("is_caret_mid_grapheme_enabled");
	}

	public boolean is_caret_force_displayed() {
		return (boolean) super.call("is_caret_force_displayed");
	}

	public void insert_text_at_caret(String text) {
		super.call("insert_text_at_caret", new java.lang.Object[]{(java.lang.Object) text});
	}

	public void delete_char_at_caret() {
		super.call("delete_char_at_caret");
	}

	public void delete_text(long from_column, long to_column) {
		super.call("delete_text",
				new java.lang.Object[]{java.lang.Long.valueOf(from_column), java.lang.Long.valueOf(to_column)});
	}

	public boolean is_editable() {
		return (boolean) super.call("is_editable");
	}

	public boolean is_secret() {
		return (boolean) super.call("is_secret");
	}

	public void menu_option(long option) {
		super.call("menu_option", new java.lang.Object[]{java.lang.Long.valueOf(option)});
	}

	public boolean is_menu_visible() {
		return (boolean) super.call("is_menu_visible");
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

	public boolean is_virtual_keyboard_enabled() {
		return (boolean) super.call("is_virtual_keyboard_enabled");
	}

	public boolean is_clear_button_enabled() {
		return (boolean) super.call("is_clear_button_enabled");
	}

	public boolean is_shortcut_keys_enabled() {
		return (boolean) super.call("is_shortcut_keys_enabled");
	}

	public boolean is_middle_mouse_paste_enabled() {
		return (boolean) super.call("is_middle_mouse_paste_enabled");
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

	public boolean is_flat() {
		return (boolean) super.call("is_flat");
	}

	public boolean is_select_all_on_focus() {
		return (boolean) super.call("is_select_all_on_focus");
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

	public long getAlignment() {
		return (long) super.call("get_horizontal_alignment", new java.lang.Object[0]);
	}

	public void setAlignment(long value) {
		super.call("set_horizontal_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMax_length() {
		return (long) super.call("get_max_length", new java.lang.Object[0]);
	}

	public void setMax_length(long value) {
		super.call("set_max_length", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isEditable() {
		return (boolean) super.call("is_editable", new java.lang.Object[0]);
	}

	public void setEditable(boolean value) {
		super.call("set_editable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isKeep_editing_on_text_submit() {
		return (boolean) super.call("is_editing_kept_on_text_submit", new java.lang.Object[0]);
	}

	public void setKeep_editing_on_text_submit(boolean value) {
		super.call("set_keep_editing_on_text_submit", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isExpand_to_text_length() {
		return (boolean) super.call("is_expand_to_text_length_enabled", new java.lang.Object[0]);
	}

	public void setExpand_to_text_length(boolean value) {
		super.call("set_expand_to_text_length_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public boolean isClear_button_enabled() {
		return (boolean) super.call("is_clear_button_enabled", new java.lang.Object[0]);
	}

	public void setClear_button_enabled(boolean value) {
		super.call("set_clear_button_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isShortcut_keys_enabled() {
		return (boolean) super.call("is_shortcut_keys_enabled", new java.lang.Object[0]);
	}

	public void setShortcut_keys_enabled(boolean value) {
		super.call("set_shortcut_keys_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isMiddle_mouse_paste_enabled() {
		return (boolean) super.call("is_middle_mouse_paste_enabled", new java.lang.Object[0]);
	}

	public void setMiddle_mouse_paste_enabled(boolean value) {
		super.call("set_middle_mouse_paste_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public boolean isFlat() {
		return (boolean) super.call("is_flat", new java.lang.Object[0]);
	}

	public void setFlat(boolean value) {
		super.call("set_flat", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDraw_control_chars() {
		return (boolean) super.call("get_draw_control_chars", new java.lang.Object[0]);
	}

	public void setDraw_control_chars(boolean value) {
		super.call("set_draw_control_chars", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isSelect_all_on_focus() {
		return (boolean) super.call("is_select_all_on_focus", new java.lang.Object[0]);
	}

	public void setSelect_all_on_focus(boolean value) {
		super.call("set_select_all_on_focus", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public long getVirtual_keyboard_type() {
		return (long) super.call("get_virtual_keyboard_type", new java.lang.Object[0]);
	}

	public void setVirtual_keyboard_type(long value) {
		super.call("set_virtual_keyboard_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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

	public long getCaret_column() {
		return (long) super.call("get_caret_column", new java.lang.Object[0]);
	}

	public void setCaret_column(long value) {
		super.call("set_caret_column", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isCaret_force_displayed() {
		return (boolean) super.call("is_caret_force_displayed", new java.lang.Object[0]);
	}

	public void setCaret_force_displayed(boolean value) {
		super.call("set_caret_force_displayed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isCaret_mid_grapheme() {
		return (boolean) super.call("is_caret_mid_grapheme_enabled", new java.lang.Object[0]);
	}

	public void setCaret_mid_grapheme(boolean value) {
		super.call("set_caret_mid_grapheme_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isSecret() {
		return (boolean) super.call("is_secret", new java.lang.Object[0]);
	}

	public void setSecret(boolean value) {
		super.call("set_secret", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getSecret_character() {
		return (String) super.call("get_secret_character", new java.lang.Object[0]);
	}

	public void setSecret_character(String value) {
		super.call("set_secret_character", new java.lang.Object[]{(java.lang.Object) value});
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

	public Texture2D getRight_icon() {
		return (Texture2D) super.call("get_right_icon", new java.lang.Object[0]);
	}

	public void setRight_icon(Texture2D value) {
		super.call("set_right_icon", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getIcon_expand_mode() {
		return (long) super.call("get_icon_expand_mode", new java.lang.Object[0]);
	}

	public void setIcon_expand_mode(long value) {
		super.call("set_icon_expand_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getRight_icon_scale() {
		return (double) super.call("get_right_icon_scale", new java.lang.Object[0]);
	}

	public void setRight_icon_scale(double value) {
		super.call("set_right_icon_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
