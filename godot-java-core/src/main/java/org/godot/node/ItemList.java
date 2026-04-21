package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Rect2;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class ItemList extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_allow_reselect", 2586408642L), java.util.Map.entry("select", 972357352L),
			java.util.Map.entry("get_item_at_position", 2300324924L), java.util.Map.entry("set_item_text", 501894301L),
			java.util.Map.entry("set_tile_scroll_hint", 2586408642L),
			java.util.Map.entry("set_scroll_hint_mode", 2917787337L),
			java.util.Map.entry("set_item_selectable", 300928843L), java.util.Map.entry("set_item_count", 1286410249L),
			java.util.Map.entry("remove_item", 1286410249L), java.util.Map.entry("set_max_text_lines", 1286410249L),
			java.util.Map.entry("set_allow_rmb_select", 2586408642L),
			java.util.Map.entry("set_select_mode", 928267388L), java.util.Map.entry("get_icon_scale", 1740695150L),
			java.util.Map.entry("get_max_columns", 3905245786L), java.util.Map.entry("add_item", 359861678L),
			java.util.Map.entry("get_item_text", 844755477L),
			java.util.Map.entry("is_item_tooltip_enabled", 1116898809L),
			java.util.Map.entry("get_scroll_hint_mode", 2522227939L),
			java.util.Map.entry("get_selected_items", 969006518L), java.util.Map.entry("set_allow_search", 2586408642L),
			java.util.Map.entry("is_item_selectable", 1116898809L),
			java.util.Map.entry("get_item_text_direction", 4235602388L),
			java.util.Map.entry("is_selected", 1116898809L), java.util.Map.entry("set_item_icon", 666127730L),
			java.util.Map.entry("set_item_icon_modulate", 2878471219L),
			java.util.Map.entry("is_item_disabled", 1116898809L),
			java.util.Map.entry("get_text_overrun_behavior", 3779142101L),
			java.util.Map.entry("get_allow_rmb_select", 36873697L),
			java.util.Map.entry("get_item_custom_bg_color", 3457211756L),
			java.util.Map.entry("is_item_icon_transposed", 1116898809L),
			java.util.Map.entry("set_auto_width", 2586408642L), java.util.Map.entry("get_item_tooltip", 844755477L),
			java.util.Map.entry("set_auto_height", 2586408642L),
			java.util.Map.entry("get_item_custom_fg_color", 3457211756L),
			java.util.Map.entry("get_item_auto_translate_mode", 906302372L),
			java.util.Map.entry("set_item_custom_bg_color", 2878471219L),
			java.util.Map.entry("set_item_custom_fg_color", 2878471219L),
			java.util.Map.entry("add_icon_item", 4256579627L), java.util.Map.entry("get_h_scroll_bar", 4004517983L),
			java.util.Map.entry("sort_items_by_text", 3218959716L),
			java.util.Map.entry("get_fixed_icon_size", 3690982128L),
			java.util.Map.entry("is_anything_selected", 2240911060L),
			java.util.Map.entry("set_fixed_column_width", 1286410249L),
			java.util.Map.entry("has_auto_width", 36873697L), java.util.Map.entry("get_item_language", 844755477L),
			java.util.Map.entry("get_v_scroll_bar", 2630340773L), java.util.Map.entry("get_icon_mode", 3353929232L),
			java.util.Map.entry("has_wraparound_items", 36873697L), java.util.Map.entry("get_allow_search", 36873697L),
			java.util.Map.entry("set_fixed_icon_size", 1130785943L),
			java.util.Map.entry("set_item_text_direction", 1707680378L),
			java.util.Map.entry("set_wraparound_items", 2586408642L),
			java.util.Map.entry("set_item_disabled", 300928843L), java.util.Map.entry("set_item_metadata", 2152698145L),
			java.util.Map.entry("get_item_icon_region", 3327874267L),
			java.util.Map.entry("get_item_metadata", 4227898402L), java.util.Map.entry("get_item_count", 3905245786L),
			java.util.Map.entry("get_allow_reselect", 36873697L),
			java.util.Map.entry("get_item_icon_modulate", 3457211756L),
			java.util.Map.entry("get_item_rect", 159227807L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("has_auto_height", 36873697L), java.util.Map.entry("set_max_columns", 1286410249L),
			java.util.Map.entry("set_item_icon_region", 1356297692L), java.util.Map.entry("move_item", 3937882851L),
			java.util.Map.entry("get_max_text_lines", 3905245786L),
			java.util.Map.entry("get_fixed_column_width", 3905245786L),
			java.util.Map.entry("set_item_language", 501894301L), java.util.Map.entry("deselect_all", 3218959716L),
			java.util.Map.entry("is_same_column_width", 36873697L), java.util.Map.entry("get_select_mode", 1191945842L),
			java.util.Map.entry("ensure_current_is_visible", 3218959716L),
			java.util.Map.entry("set_item_tooltip_enabled", 300928843L),
			java.util.Map.entry("get_item_icon", 3536238170L), java.util.Map.entry("deselect", 1286410249L),
			java.util.Map.entry("set_same_column_width", 2586408642L),
			java.util.Map.entry("set_icon_scale", 373806689L), java.util.Map.entry("set_item_tooltip", 501894301L),
			java.util.Map.entry("set_item_auto_translate_mode", 287402019L),
			java.util.Map.entry("set_item_icon_transposed", 300928843L),
			java.util.Map.entry("set_icon_mode", 2025053633L), java.util.Map.entry("is_scroll_hint_tiled", 2240911060L),
			java.util.Map.entry("set_text_overrun_behavior", 1008890932L),
			java.util.Map.entry("force_update_list_size", 3218959716L));

	ItemList(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ItemList(long nativePointer) {
		super(nativePointer);
	}

	public int add_item(String text, Texture2D icon, boolean selectable) {
		return (int) super.call("add_item", new java.lang.Object[]{(java.lang.Object) text, (java.lang.Object) icon,
				java.lang.Boolean.valueOf(selectable)});
	}

	public int add_icon_item(Texture2D icon, boolean selectable) {
		return (int) super.call("add_icon_item",
				new java.lang.Object[]{(java.lang.Object) icon, java.lang.Boolean.valueOf(selectable)});
	}

	public void set_item_text(long idx, String text) {
		super.call("set_item_text", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) text});
	}

	public String get_item_text(long idx) {
		return (String) super.call("get_item_text", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_icon(long idx, Texture2D icon) {
		super.call("set_item_icon", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) icon});
	}

	public Texture2D get_item_icon(long idx) {
		return (Texture2D) super.call("get_item_icon", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_text_direction(long idx, int direction) {
		super.call("set_item_text_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Integer.valueOf(direction)});
	}

	public int get_item_text_direction(long idx) {
		return (int) super.call("get_item_text_direction", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_language(long idx, String language) {
		super.call("set_item_language",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) language});
	}

	public String get_item_language(long idx) {
		return (String) super.call("get_item_language", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_auto_translate_mode(long idx, int mode) {
		super.call("set_item_auto_translate_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Integer.valueOf(mode)});
	}

	public int get_item_auto_translate_mode(long idx) {
		return (int) super.call("get_item_auto_translate_mode", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_icon_transposed(long idx, boolean transposed) {
		super.call("set_item_icon_transposed",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(transposed)});
	}

	public boolean is_item_icon_transposed(long idx) {
		return (boolean) super.call("is_item_icon_transposed", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_icon_region(long idx, Rect2 rect) {
		super.call("set_item_icon_region",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) rect});
	}

	public Rect2 get_item_icon_region(long idx) {
		return (Rect2) super.call("get_item_icon_region", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_icon_modulate(long idx, Color modulate) {
		super.call("set_item_icon_modulate",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) modulate});
	}

	public Color get_item_icon_modulate(long idx) {
		return (Color) super.call("get_item_icon_modulate", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_selectable(long idx, boolean selectable) {
		super.call("set_item_selectable",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(selectable)});
	}

	public boolean is_item_selectable(long idx) {
		return (boolean) super.call("is_item_selectable", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_disabled(long idx, boolean disabled) {
		super.call("set_item_disabled",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(disabled)});
	}

	public boolean is_item_disabled(long idx) {
		return (boolean) super.call("is_item_disabled", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_metadata(long idx, Object metadata) {
		super.call("set_item_metadata",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) metadata});
	}

	public Object get_item_metadata(long idx) {
		return (Object) super.call("get_item_metadata", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_custom_bg_color(long idx, Color custom_bg_color) {
		super.call("set_item_custom_bg_color",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) custom_bg_color});
	}

	public Color get_item_custom_bg_color(long idx) {
		return (Color) super.call("get_item_custom_bg_color", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_custom_fg_color(long idx, Color custom_fg_color) {
		super.call("set_item_custom_fg_color",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) custom_fg_color});
	}

	public Color get_item_custom_fg_color(long idx) {
		return (Color) super.call("get_item_custom_fg_color", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public Rect2 get_item_rect(long idx, boolean expand) {
		return (Rect2) super.call("get_item_rect",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(expand)});
	}

	public void set_item_tooltip_enabled(long idx, boolean enable) {
		super.call("set_item_tooltip_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(enable)});
	}

	public boolean is_item_tooltip_enabled(long idx) {
		return (boolean) super.call("is_item_tooltip_enabled", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_item_tooltip(long idx, String tooltip) {
		super.call("set_item_tooltip", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) tooltip});
	}

	public String get_item_tooltip(long idx) {
		return (String) super.call("get_item_tooltip", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void select(long idx, boolean single) {
		super.call("select", new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(single)});
	}

	public void deselect(long idx) {
		super.call("deselect", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void deselect_all() {
		super.call("deselect_all");
	}

	public boolean is_selected(long idx) {
		return (boolean) super.call("is_selected", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void move_item(long from_idx, long to_idx) {
		super.call("move_item",
				new java.lang.Object[]{java.lang.Long.valueOf(from_idx), java.lang.Long.valueOf(to_idx)});
	}

	public void remove_item(long idx) {
		super.call("remove_item", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void clear() {
		super.call("clear");
	}

	public void sort_items_by_text() {
		super.call("sort_items_by_text");
	}

	public boolean is_same_column_width() {
		return (boolean) super.call("is_same_column_width");
	}

	public boolean has_auto_width() {
		return (boolean) super.call("has_auto_width");
	}

	public boolean has_auto_height() {
		return (boolean) super.call("has_auto_height");
	}

	public boolean is_anything_selected() {
		return (boolean) super.call("is_anything_selected");
	}

	public int get_item_at_position(Vector2 position, boolean exact) {
		return (int) super.call("get_item_at_position",
				new java.lang.Object[]{(java.lang.Object) position, java.lang.Boolean.valueOf(exact)});
	}

	public void ensure_current_is_visible() {
		super.call("ensure_current_is_visible");
	}

	public boolean is_scroll_hint_tiled() {
		return (boolean) super.call("is_scroll_hint_tiled");
	}

	public boolean has_wraparound_items() {
		return (boolean) super.call("has_wraparound_items");
	}

	public void force_update_list_size() {
		super.call("force_update_list_size");
	}

	public long getSelect_mode() {
		return (long) super.call("get_select_mode", new java.lang.Object[0]);
	}

	public void setSelect_mode(long value) {
		super.call("set_select_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getAllow_reselect() {
		return (boolean) super.call("get_allow_reselect", new java.lang.Object[0]);
	}

	public void setAllow_reselect(boolean value) {
		super.call("set_allow_reselect", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAllow_rmb_select() {
		return (boolean) super.call("get_allow_rmb_select", new java.lang.Object[0]);
	}

	public void setAllow_rmb_select(boolean value) {
		super.call("set_allow_rmb_select", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAllow_search() {
		return (boolean) super.call("get_allow_search", new java.lang.Object[0]);
	}

	public void setAllow_search(boolean value) {
		super.call("set_allow_search", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getMax_text_lines() {
		return (long) super.call("get_max_text_lines", new java.lang.Object[0]);
	}

	public void setMax_text_lines(long value) {
		super.call("set_max_text_lines", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getAuto_width() {
		return (boolean) super.call("has_auto_width", new java.lang.Object[0]);
	}

	public void setAuto_width(boolean value) {
		super.call("set_auto_width", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAuto_height() {
		return (boolean) super.call("has_auto_height", new java.lang.Object[0]);
	}

	public void setAuto_height(boolean value) {
		super.call("set_auto_height", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getText_overrun_behavior() {
		return (long) super.call("get_text_overrun_behavior", new java.lang.Object[0]);
	}

	public void setText_overrun_behavior(long value) {
		super.call("set_text_overrun_behavior", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getWraparound_items() {
		return (boolean) super.call("has_wraparound_items", new java.lang.Object[0]);
	}

	public void setWraparound_items(boolean value) {
		super.call("set_wraparound_items", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getScroll_hint_mode() {
		return (long) super.call("get_scroll_hint_mode", new java.lang.Object[0]);
	}

	public void setScroll_hint_mode(long value) {
		super.call("set_scroll_hint_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isTile_scroll_hint() {
		return (boolean) super.call("is_scroll_hint_tiled", new java.lang.Object[0]);
	}

	public void setTile_scroll_hint(boolean value) {
		super.call("set_tile_scroll_hint", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getItem_count() {
		return (long) super.call("get_item_count", new java.lang.Object[0]);
	}

	public void setItem_count(long value) {
		super.call("set_item_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMax_columns() {
		return (long) super.call("get_max_columns", new java.lang.Object[0]);
	}

	public void setMax_columns(long value) {
		super.call("set_max_columns", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isSame_column_width() {
		return (boolean) super.call("is_same_column_width", new java.lang.Object[0]);
	}

	public void setSame_column_width(boolean value) {
		super.call("set_same_column_width", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getFixed_column_width() {
		return (long) super.call("get_fixed_column_width", new java.lang.Object[0]);
	}

	public void setFixed_column_width(long value) {
		super.call("set_fixed_column_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getIcon_mode() {
		return (long) super.call("get_icon_mode", new java.lang.Object[0]);
	}

	public void setIcon_mode(long value) {
		super.call("set_icon_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getIcon_scale() {
		return (double) super.call("get_icon_scale", new java.lang.Object[0]);
	}

	public void setIcon_scale(double value) {
		super.call("set_icon_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2i getFixed_icon_size() {
		return (Vector2i) super.call("get_fixed_icon_size", new java.lang.Object[0]);
	}

	public void setFixed_icon_size(Vector2i value) {
		super.call("set_fixed_icon_size", new java.lang.Object[]{(java.lang.Object) value});
	}
}
