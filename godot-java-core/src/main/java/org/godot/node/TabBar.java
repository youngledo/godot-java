package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2;
import org.godot.math.Vector2;

public class TabBar extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("ensure_tab_visible", 1286410249L),
			java.util.Map.entry("get_tab_icon_max_width", 923996154L),
			java.util.Map.entry("get_deselect_enabled", 36873697L),
			java.util.Map.entry("set_tab_button_icon", 666127730L), java.util.Map.entry("get_current_tab", 3905245786L),
			java.util.Map.entry("get_switch_on_drag_hover", 36873697L),
			java.util.Map.entry("get_tab_text_direction", 4235602388L),
			java.util.Map.entry("get_tab_button_icon", 3536238170L),
			java.util.Map.entry("set_max_tab_width", 1286410249L),
			java.util.Map.entry("set_tabs_rearrange_group", 1286410249L),
			java.util.Map.entry("get_tab_idx_at_point", 3820158470L),
			java.util.Map.entry("set_switch_on_drag_hover", 2586408642L),
			java.util.Map.entry("set_scroll_to_selected", 2586408642L),
			java.util.Map.entry("set_select_with_rmb", 2586408642L), java.util.Map.entry("get_tab_tooltip", 844755477L),
			java.util.Map.entry("set_tab_disabled", 300928843L), java.util.Map.entry("get_max_tab_width", 3905245786L),
			java.util.Map.entry("get_drag_to_rearrange_enabled", 36873697L),
			java.util.Map.entry("set_tab_close_display_policy", 2212906737L),
			java.util.Map.entry("select_previous_available", 2240911060L),
			java.util.Map.entry("set_clip_tabs", 2586408642L),
			java.util.Map.entry("select_next_available", 2240911060L),
			java.util.Map.entry("get_select_with_rmb", 36873697L), java.util.Map.entry("set_tab_icon", 666127730L),
			java.util.Map.entry("get_scrolling_enabled", 36873697L),
			java.util.Map.entry("set_current_tab", 1286410249L), java.util.Map.entry("set_tab_count", 1286410249L),
			java.util.Map.entry("get_scroll_to_selected", 36873697L), java.util.Map.entry("get_clip_tabs", 36873697L),
			java.util.Map.entry("get_tab_rect", 3327874267L),
			java.util.Map.entry("get_tab_close_display_policy", 2956568028L),
			java.util.Map.entry("set_tab_language", 501894301L), java.util.Map.entry("get_tab_language", 844755477L),
			java.util.Map.entry("get_tabs_rearrange_group", 3905245786L),
			java.util.Map.entry("get_tab_title", 844755477L), java.util.Map.entry("get_tab_metadata", 4227898402L),
			java.util.Map.entry("is_tab_disabled", 1116898809L), java.util.Map.entry("get_tab_count", 3905245786L),
			java.util.Map.entry("get_offset_buttons_visible", 36873697L),
			java.util.Map.entry("set_drag_to_rearrange_enabled", 2586408642L),
			java.util.Map.entry("get_close_with_middle_mouse", 36873697L),
			java.util.Map.entry("get_previous_tab", 3905245786L), java.util.Map.entry("remove_tab", 1286410249L),
			java.util.Map.entry("set_tab_metadata", 2152698145L), java.util.Map.entry("get_tab_offset", 3905245786L),
			java.util.Map.entry("set_deselect_enabled", 2586408642L), java.util.Map.entry("get_tab_icon", 3536238170L),
			java.util.Map.entry("set_scrolling_enabled", 2586408642L), java.util.Map.entry("clear_tabs", 3218959716L),
			java.util.Map.entry("set_tab_tooltip", 501894301L), java.util.Map.entry("set_tab_hidden", 300928843L),
			java.util.Map.entry("set_tab_title", 501894301L), java.util.Map.entry("get_tab_alignment", 2178122193L),
			java.util.Map.entry("set_tab_alignment", 2413632353L), java.util.Map.entry("move_tab", 3937882851L),
			java.util.Map.entry("set_tab_icon_max_width", 3937882851L), java.util.Map.entry("add_tab", 1465444425L),
			java.util.Map.entry("is_tab_hidden", 1116898809L),
			java.util.Map.entry("set_tab_text_direction", 1707680378L),
			java.util.Map.entry("set_close_with_middle_mouse", 2586408642L));

	TabBar(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TabBar(long nativePointer) {
		super(nativePointer);
	}

	public boolean select_previous_available() {
		return (boolean) super.call("select_previous_available");
	}

	public boolean select_next_available() {
		return (boolean) super.call("select_next_available");
	}

	public void set_tab_title(long tab_idx, String title) {
		super.call("set_tab_title", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx), (java.lang.Object) title});
	}

	public String get_tab_title(long tab_idx) {
		return (String) super.call("get_tab_title", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public void set_tab_tooltip(long tab_idx, String tooltip) {
		super.call("set_tab_tooltip",
				new java.lang.Object[]{java.lang.Long.valueOf(tab_idx), (java.lang.Object) tooltip});
	}

	public String get_tab_tooltip(long tab_idx) {
		return (String) super.call("get_tab_tooltip", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public void set_tab_text_direction(long tab_idx, int direction) {
		super.call("set_tab_text_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(tab_idx), java.lang.Integer.valueOf(direction)});
	}

	public int get_tab_text_direction(long tab_idx) {
		return (int) super.call("get_tab_text_direction", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public void set_tab_language(long tab_idx, String language) {
		super.call("set_tab_language",
				new java.lang.Object[]{java.lang.Long.valueOf(tab_idx), (java.lang.Object) language});
	}

	public String get_tab_language(long tab_idx) {
		return (String) super.call("get_tab_language", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public void set_tab_icon(long tab_idx, Texture2D icon) {
		super.call("set_tab_icon", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx), (java.lang.Object) icon});
	}

	public Texture2D get_tab_icon(long tab_idx) {
		return (Texture2D) super.call("get_tab_icon", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public void set_tab_icon_max_width(long tab_idx, long width) {
		super.call("set_tab_icon_max_width",
				new java.lang.Object[]{java.lang.Long.valueOf(tab_idx), java.lang.Long.valueOf(width)});
	}

	public int get_tab_icon_max_width(long tab_idx) {
		return (int) super.call("get_tab_icon_max_width", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public void set_tab_button_icon(long tab_idx, Texture2D icon) {
		super.call("set_tab_button_icon",
				new java.lang.Object[]{java.lang.Long.valueOf(tab_idx), (java.lang.Object) icon});
	}

	public Texture2D get_tab_button_icon(long tab_idx) {
		return (Texture2D) super.call("get_tab_button_icon", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public void set_tab_disabled(long tab_idx, boolean disabled) {
		super.call("set_tab_disabled",
				new java.lang.Object[]{java.lang.Long.valueOf(tab_idx), java.lang.Boolean.valueOf(disabled)});
	}

	public boolean is_tab_disabled(long tab_idx) {
		return (boolean) super.call("is_tab_disabled", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public void set_tab_hidden(long tab_idx, boolean hidden) {
		super.call("set_tab_hidden",
				new java.lang.Object[]{java.lang.Long.valueOf(tab_idx), java.lang.Boolean.valueOf(hidden)});
	}

	public boolean is_tab_hidden(long tab_idx) {
		return (boolean) super.call("is_tab_hidden", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public void set_tab_metadata(long tab_idx, Object metadata) {
		super.call("set_tab_metadata",
				new java.lang.Object[]{java.lang.Long.valueOf(tab_idx), (java.lang.Object) metadata});
	}

	public Object get_tab_metadata(long tab_idx) {
		return (Object) super.call("get_tab_metadata", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public void remove_tab(long tab_idx) {
		super.call("remove_tab", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public void add_tab(String title, Texture2D icon) {
		super.call("add_tab", new java.lang.Object[]{(java.lang.Object) title, (java.lang.Object) icon});
	}

	public int get_tab_idx_at_point(Vector2 point) {
		return (int) super.call("get_tab_idx_at_point", new java.lang.Object[]{(java.lang.Object) point});
	}

	public void ensure_tab_visible(long idx) {
		super.call("ensure_tab_visible", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public Rect2 get_tab_rect(long tab_idx) {
		return (Rect2) super.call("get_tab_rect", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public void move_tab(long from, long to) {
		super.call("move_tab", new java.lang.Object[]{java.lang.Long.valueOf(from), java.lang.Long.valueOf(to)});
	}

	public void clear_tabs() {
		super.call("clear_tabs");
	}

	public long getCurrent_tab() {
		return (long) super.call("get_current_tab", new java.lang.Object[0]);
	}

	public void setCurrent_tab(long value) {
		super.call("set_current_tab", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTab_alignment() {
		return (long) super.call("get_tab_alignment", new java.lang.Object[0]);
	}

	public void setTab_alignment(long value) {
		super.call("set_tab_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getClip_tabs() {
		return (boolean) super.call("get_clip_tabs", new java.lang.Object[0]);
	}

	public void setClip_tabs(boolean value) {
		super.call("set_clip_tabs", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getClose_with_middle_mouse() {
		return (boolean) super.call("get_close_with_middle_mouse", new java.lang.Object[0]);
	}

	public void setClose_with_middle_mouse(boolean value) {
		super.call("set_close_with_middle_mouse", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getTab_close_display_policy() {
		return (long) super.call("get_tab_close_display_policy", new java.lang.Object[0]);
	}

	public void setTab_close_display_policy(long value) {
		super.call("set_tab_close_display_policy", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMax_tab_width() {
		return (long) super.call("get_max_tab_width", new java.lang.Object[0]);
	}

	public void setMax_tab_width(long value) {
		super.call("set_max_tab_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getScrolling_enabled() {
		return (boolean) super.call("get_scrolling_enabled", new java.lang.Object[0]);
	}

	public void setScrolling_enabled(boolean value) {
		super.call("set_scrolling_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDrag_to_rearrange_enabled() {
		return (boolean) super.call("get_drag_to_rearrange_enabled", new java.lang.Object[0]);
	}

	public void setDrag_to_rearrange_enabled(boolean value) {
		super.call("set_drag_to_rearrange_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getSwitch_on_drag_hover() {
		return (boolean) super.call("get_switch_on_drag_hover", new java.lang.Object[0]);
	}

	public void setSwitch_on_drag_hover(boolean value) {
		super.call("set_switch_on_drag_hover", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getTabs_rearrange_group() {
		return (long) super.call("get_tabs_rearrange_group", new java.lang.Object[0]);
	}

	public void setTabs_rearrange_group(long value) {
		super.call("set_tabs_rearrange_group", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getScroll_to_selected() {
		return (boolean) super.call("get_scroll_to_selected", new java.lang.Object[0]);
	}

	public void setScroll_to_selected(boolean value) {
		super.call("set_scroll_to_selected", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getSelect_with_rmb() {
		return (boolean) super.call("get_select_with_rmb", new java.lang.Object[0]);
	}

	public void setSelect_with_rmb(boolean value) {
		super.call("set_select_with_rmb", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDeselect_enabled() {
		return (boolean) super.call("get_deselect_enabled", new java.lang.Object[0]);
	}

	public void setDeselect_enabled(boolean value) {
		super.call("set_deselect_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getTab_count() {
		return (long) super.call("get_tab_count", new java.lang.Object[0]);
	}

	public void setTab_count(long value) {
		super.call("set_tab_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
