package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2;
import org.godot.math.Vector2;

public class Tree extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_auto_tooltip_enabled", 36873697L), java.util.Map.entry("get_selected", 1514277247L),
			java.util.Map.entry("set_allow_reselect", 2586408642L), java.util.Map.entry("get_column_title", 844755477L),
			java.util.Map.entry("get_item_at_position", 4193340126L),
			java.util.Map.entry("is_v_scroll_enabled", 36873697L),
			java.util.Map.entry("get_column_expand_ratio", 923996154L),
			java.util.Map.entry("set_h_scroll_enabled", 2586408642L),
			java.util.Map.entry("set_tile_scroll_hint", 2586408642L),
			java.util.Map.entry("set_scroll_hint_mode", 415911924L),
			java.util.Map.entry("is_folding_hidden", 36873697L), java.util.Map.entry("is_root_hidden", 36873697L),
			java.util.Map.entry("set_column_custom_minimum_width", 3937882851L),
			java.util.Map.entry("get_selected_column", 3905245786L),
			java.util.Map.entry("set_column_title_alignment", 3276431499L),
			java.util.Map.entry("set_allow_rmb_select", 2586408642L), java.util.Map.entry("set_hide_root", 2586408642L),
			java.util.Map.entry("set_select_mode", 3223887270L),
			java.util.Map.entry("get_drop_section_at_position", 3820158470L),
			java.util.Map.entry("get_scroll_hint_mode", 553087187L),
			java.util.Map.entry("get_button_id_at_position", 3820158470L),
			java.util.Map.entry("set_column_title_tooltip_text", 501894301L),
			java.util.Map.entry("get_edited", 1514277247L), java.util.Map.entry("set_allow_search", 2586408642L),
			java.util.Map.entry("edit_selected", 2595650253L),
			java.util.Map.entry("set_enable_recursive_folding", 2586408642L),
			java.util.Map.entry("is_drag_unfolding_enabled", 36873697L),
			java.util.Map.entry("ensure_cursor_is_visible", 3218959716L),
			java.util.Map.entry("set_auto_tooltip", 2586408642L),
			java.util.Map.entry("get_column_title_direction", 4235602388L),
			java.util.Map.entry("get_allow_rmb_select", 36873697L),
			java.util.Map.entry("set_v_scroll_enabled", 2586408642L),
			java.util.Map.entry("set_hide_folding", 2586408642L), java.util.Map.entry("get_scroll", 3341600327L),
			java.util.Map.entry("set_column_titles_visible", 2586408642L),
			java.util.Map.entry("set_column_title", 501894301L), java.util.Map.entry("scroll_to_item", 1314737213L),
			java.util.Map.entry("get_column_width", 923996154L),
			java.util.Map.entry("set_column_expand_ratio", 3937882851L),
			java.util.Map.entry("set_column_clip_content", 300928843L),
			java.util.Map.entry("get_column_title_alignment", 4171562184L),
			java.util.Map.entry("get_pressed_button", 3905245786L),
			java.util.Map.entry("is_column_clipping_content", 1116898809L),
			java.util.Map.entry("get_allow_search", 36873697L), java.util.Map.entry("is_h_scroll_enabled", 36873697L),
			java.util.Map.entry("set_column_expand", 300928843L), java.util.Map.entry("get_next_selected", 873446299L),
			java.util.Map.entry("get_columns", 3905245786L), java.util.Map.entry("set_selected", 2662547442L),
			java.util.Map.entry("are_column_titles_visible", 36873697L),
			java.util.Map.entry("set_columns", 1286410249L),
			java.util.Map.entry("get_column_title_language", 844755477L),
			java.util.Map.entry("set_drop_mode_flags", 1286410249L),
			java.util.Map.entry("get_allow_reselect", 36873697L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("set_enable_drag_unfolding", 2586408642L),
			java.util.Map.entry("set_column_title_direction", 1707680378L),
			java.util.Map.entry("set_column_title_language", 501894301L),
			java.util.Map.entry("get_custom_popup_rect", 1639390495L),
			java.util.Map.entry("get_edited_column", 3905245786L),
			java.util.Map.entry("get_column_title_tooltip_text", 844755477L),
			java.util.Map.entry("deselect_all", 3218959716L), java.util.Map.entry("get_drop_mode_flags", 3905245786L),
			java.util.Map.entry("is_column_expanding", 1116898809L),
			java.util.Map.entry("is_recursive_folding_enabled", 36873697L),
			java.util.Map.entry("get_select_mode", 100748571L), java.util.Map.entry("create_item", 528467046L),
			java.util.Map.entry("get_item_area_rect", 47968679L), java.util.Map.entry("get_root", 1514277247L),
			java.util.Map.entry("is_scroll_hint_tiled", 2240911060L),
			java.util.Map.entry("get_column_at_position", 3820158470L));

	Tree(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Tree(long nativePointer) {
		super(nativePointer);
	}

	public void clear() {
		super.call("clear");
	}

	public TreeItem create_item(TreeItem parent, long index) {
		return (TreeItem) super.call("create_item",
				new java.lang.Object[]{(java.lang.Object) parent, java.lang.Long.valueOf(index)});
	}

	public void set_column_custom_minimum_width(long column, long min_width) {
		super.call("set_column_custom_minimum_width",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Long.valueOf(min_width)});
	}

	public void set_column_expand(long column, boolean expand) {
		super.call("set_column_expand",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Boolean.valueOf(expand)});
	}

	public void set_column_expand_ratio(long column, long ratio) {
		super.call("set_column_expand_ratio",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Long.valueOf(ratio)});
	}

	public void set_column_clip_content(long column, boolean enable) {
		super.call("set_column_clip_content",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Boolean.valueOf(enable)});
	}

	public boolean is_column_expanding(long column) {
		return (boolean) super.call("is_column_expanding", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public boolean is_column_clipping_content(long column) {
		return (boolean) super.call("is_column_clipping_content",
				new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public int get_column_expand_ratio(long column) {
		return (int) super.call("get_column_expand_ratio", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public int get_column_width(long column) {
		return (int) super.call("get_column_width", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public boolean is_root_hidden() {
		return (boolean) super.call("is_root_hidden");
	}

	public TreeItem get_next_selected(TreeItem from) {
		return (TreeItem) super.call("get_next_selected", new java.lang.Object[]{(java.lang.Object) from});
	}

	public void set_selected(TreeItem item, long column) {
		super.call("set_selected", new java.lang.Object[]{(java.lang.Object) item, java.lang.Long.valueOf(column)});
	}

	public void deselect_all() {
		super.call("deselect_all");
	}

	public boolean edit_selected(boolean force_edit) {
		return (boolean) super.call("edit_selected", new java.lang.Object[]{java.lang.Boolean.valueOf(force_edit)});
	}

	public Rect2 get_item_area_rect(TreeItem item, long column, long button_index) {
		return (Rect2) super.call("get_item_area_rect", new java.lang.Object[]{(java.lang.Object) item,
				java.lang.Long.valueOf(column), java.lang.Long.valueOf(button_index)});
	}

	public TreeItem get_item_at_position(Vector2 position) {
		return (TreeItem) super.call("get_item_at_position", new java.lang.Object[]{(java.lang.Object) position});
	}

	public int get_column_at_position(Vector2 position) {
		return (int) super.call("get_column_at_position", new java.lang.Object[]{(java.lang.Object) position});
	}

	public int get_drop_section_at_position(Vector2 position) {
		return (int) super.call("get_drop_section_at_position", new java.lang.Object[]{(java.lang.Object) position});
	}

	public int get_button_id_at_position(Vector2 position) {
		return (int) super.call("get_button_id_at_position", new java.lang.Object[]{(java.lang.Object) position});
	}

	public void ensure_cursor_is_visible() {
		super.call("ensure_cursor_is_visible");
	}

	public boolean are_column_titles_visible() {
		return (boolean) super.call("are_column_titles_visible");
	}

	public void set_column_title(long column, String title) {
		super.call("set_column_title",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) title});
	}

	public String get_column_title(long column) {
		return (String) super.call("get_column_title", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_column_title_tooltip_text(long column, String tooltip_text) {
		super.call("set_column_title_tooltip_text",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) tooltip_text});
	}

	public String get_column_title_tooltip_text(long column) {
		return (String) super.call("get_column_title_tooltip_text",
				new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_column_title_alignment(long column, int title_alignment) {
		super.call("set_column_title_alignment",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Integer.valueOf(title_alignment)});
	}

	public int get_column_title_alignment(long column) {
		return (int) super.call("get_column_title_alignment", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_column_title_direction(long column, int direction) {
		super.call("set_column_title_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Integer.valueOf(direction)});
	}

	public int get_column_title_direction(long column) {
		return (int) super.call("get_column_title_direction", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_column_title_language(long column, String language) {
		super.call("set_column_title_language",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) language});
	}

	public String get_column_title_language(long column) {
		return (String) super.call("get_column_title_language", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void scroll_to_item(TreeItem item, boolean center_on_item) {
		super.call("scroll_to_item",
				new java.lang.Object[]{(java.lang.Object) item, java.lang.Boolean.valueOf(center_on_item)});
	}

	public boolean is_h_scroll_enabled() {
		return (boolean) super.call("is_h_scroll_enabled");
	}

	public boolean is_v_scroll_enabled() {
		return (boolean) super.call("is_v_scroll_enabled");
	}

	public boolean is_scroll_hint_tiled() {
		return (boolean) super.call("is_scroll_hint_tiled");
	}

	public boolean is_folding_hidden() {
		return (boolean) super.call("is_folding_hidden");
	}

	public boolean is_recursive_folding_enabled() {
		return (boolean) super.call("is_recursive_folding_enabled");
	}

	public boolean is_drag_unfolding_enabled() {
		return (boolean) super.call("is_drag_unfolding_enabled");
	}

	public boolean is_auto_tooltip_enabled() {
		return (boolean) super.call("is_auto_tooltip_enabled");
	}

	public long getColumns() {
		return (long) super.call("get_columns", new java.lang.Object[0]);
	}

	public void setColumns(long value) {
		super.call("set_columns", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getColumn_titles_visible() {
		return (boolean) super.call("are_column_titles_visible", new java.lang.Object[0]);
	}

	public void setColumn_titles_visible(boolean value) {
		super.call("set_column_titles_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public boolean isHide_folding() {
		return (boolean) super.call("is_folding_hidden", new java.lang.Object[0]);
	}

	public void setHide_folding(boolean value) {
		super.call("set_hide_folding", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEnable_recursive_folding() {
		return (boolean) super.call("is_recursive_folding_enabled", new java.lang.Object[0]);
	}

	public void setEnable_recursive_folding(boolean value) {
		super.call("set_enable_recursive_folding", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEnable_drag_unfolding() {
		return (boolean) super.call("is_drag_unfolding_enabled", new java.lang.Object[0]);
	}

	public void setEnable_drag_unfolding(boolean value) {
		super.call("set_enable_drag_unfolding", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isHide_root() {
		return (boolean) super.call("is_root_hidden", new java.lang.Object[0]);
	}

	public void setHide_root(boolean value) {
		super.call("set_hide_root", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getDrop_mode_flags() {
		return (long) super.call("get_drop_mode_flags", new java.lang.Object[0]);
	}

	public void setDrop_mode_flags(long value) {
		super.call("set_drop_mode_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSelect_mode() {
		return (long) super.call("get_select_mode", new java.lang.Object[0]);
	}

	public void setSelect_mode(long value) {
		super.call("set_select_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isAuto_tooltip() {
		return (boolean) super.call("is_auto_tooltip_enabled", new java.lang.Object[0]);
	}

	public void setAuto_tooltip(boolean value) {
		super.call("set_auto_tooltip", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isScroll_horizontal_enabled() {
		return (boolean) super.call("is_h_scroll_enabled", new java.lang.Object[0]);
	}

	public void setScroll_horizontal_enabled(boolean value) {
		super.call("set_h_scroll_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isScroll_vertical_enabled() {
		return (boolean) super.call("is_v_scroll_enabled", new java.lang.Object[0]);
	}

	public void setScroll_vertical_enabled(boolean value) {
		super.call("set_v_scroll_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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
}
