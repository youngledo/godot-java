package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class TabContainer extends Container {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_tab_icon_max_width", 923996154L),
			java.util.Map.entry("get_deselect_enabled", 36873697L),
			java.util.Map.entry("set_tab_button_icon", 666127730L), java.util.Map.entry("get_current_tab", 3905245786L),
			java.util.Map.entry("get_switch_on_drag_hover", 36873697L),
			java.util.Map.entry("get_tab_button_icon", 3536238170L),
			java.util.Map.entry("is_all_tabs_in_front", 36873697L),
			java.util.Map.entry("set_tabs_rearrange_group", 1286410249L),
			java.util.Map.entry("get_tab_idx_at_point", 3820158470L),
			java.util.Map.entry("set_switch_on_drag_hover", 2586408642L),
			java.util.Map.entry("get_tab_tooltip", 844755477L), java.util.Map.entry("set_tab_disabled", 300928843L),
			java.util.Map.entry("get_drag_to_rearrange_enabled", 36873697L),
			java.util.Map.entry("get_popup", 111095082L),
			java.util.Map.entry("get_use_hidden_tabs_for_min_size", 36873697L),
			java.util.Map.entry("select_previous_available", 2240911060L),
			java.util.Map.entry("set_clip_tabs", 2586408642L), java.util.Map.entry("get_tab_focus_mode", 2132829277L),
			java.util.Map.entry("select_next_available", 2240911060L), java.util.Map.entry("set_tab_icon", 666127730L),
			java.util.Map.entry("are_tabs_visible", 36873697L), java.util.Map.entry("set_current_tab", 1286410249L),
			java.util.Map.entry("get_clip_tabs", 36873697L), java.util.Map.entry("get_tab_control", 1065994134L),
			java.util.Map.entry("get_tabs_rearrange_group", 3905245786L),
			java.util.Map.entry("get_current_tab_control", 2783021301L),
			java.util.Map.entry("get_tab_title", 844755477L), java.util.Map.entry("get_tab_metadata", 4227898402L),
			java.util.Map.entry("is_tab_disabled", 1116898809L), java.util.Map.entry("get_tab_count", 3905245786L),
			java.util.Map.entry("set_drag_to_rearrange_enabled", 2586408642L),
			java.util.Map.entry("get_previous_tab", 3905245786L), java.util.Map.entry("set_tab_metadata", 2152698145L),
			java.util.Map.entry("set_deselect_enabled", 2586408642L), java.util.Map.entry("get_tab_icon", 3536238170L),
			java.util.Map.entry("set_tab_tooltip", 501894301L), java.util.Map.entry("set_tab_hidden", 300928843L),
			java.util.Map.entry("set_tabs_position", 256673370L),
			java.util.Map.entry("get_tab_idx_from_control", 2787397975L),
			java.util.Map.entry("get_tab_alignment", 2178122193L), java.util.Map.entry("set_tab_title", 501894301L),
			java.util.Map.entry("set_tab_alignment", 2413632353L),
			java.util.Map.entry("set_tab_icon_max_width", 3937882851L), java.util.Map.entry("set_popup", 1078189570L),
			java.util.Map.entry("get_tabs_position", 919937023L),
			java.util.Map.entry("set_use_hidden_tabs_for_min_size", 2586408642L),
			java.util.Map.entry("set_tab_focus_mode", 3232914922L),
			java.util.Map.entry("set_tabs_visible", 2586408642L),
			java.util.Map.entry("set_all_tabs_in_front", 2586408642L),
			java.util.Map.entry("is_tab_hidden", 1116898809L), java.util.Map.entry("get_tab_bar", 1865451809L));

	TabContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TabContainer(long nativePointer) {
		super(nativePointer);
	}

	public boolean select_previous_available() {
		return (boolean) super.call("select_previous_available");
	}

	public boolean select_next_available() {
		return (boolean) super.call("select_next_available");
	}

	public Control get_tab_control(long tab_idx) {
		return (Control) super.call("get_tab_control", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public boolean are_tabs_visible() {
		return (boolean) super.call("are_tabs_visible");
	}

	public boolean is_all_tabs_in_front() {
		return (boolean) super.call("is_all_tabs_in_front");
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

	public void set_tab_button_icon(long tab_idx, Texture2D icon) {
		super.call("set_tab_button_icon",
				new java.lang.Object[]{java.lang.Long.valueOf(tab_idx), (java.lang.Object) icon});
	}

	public Texture2D get_tab_button_icon(long tab_idx) {
		return (Texture2D) super.call("get_tab_button_icon", new java.lang.Object[]{java.lang.Long.valueOf(tab_idx)});
	}

	public int get_tab_idx_at_point(Vector2 point) {
		return (int) super.call("get_tab_idx_at_point", new java.lang.Object[]{(java.lang.Object) point});
	}

	public int get_tab_idx_from_control(Control control) {
		return (int) super.call("get_tab_idx_from_control", new java.lang.Object[]{(java.lang.Object) control});
	}

	public long getTab_alignment() {
		return (long) super.call("get_tab_alignment", new java.lang.Object[0]);
	}

	public void setTab_alignment(long value) {
		super.call("set_tab_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCurrent_tab() {
		return (long) super.call("get_current_tab", new java.lang.Object[0]);
	}

	public void setCurrent_tab(long value) {
		super.call("set_current_tab", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTabs_position() {
		return (long) super.call("get_tabs_position", new java.lang.Object[0]);
	}

	public void setTabs_position(long value) {
		super.call("set_tabs_position", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getClip_tabs() {
		return (boolean) super.call("get_clip_tabs", new java.lang.Object[0]);
	}

	public void setClip_tabs(boolean value) {
		super.call("set_clip_tabs", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getTabs_visible() {
		return (boolean) super.call("are_tabs_visible", new java.lang.Object[0]);
	}

	public void setTabs_visible(boolean value) {
		super.call("set_tabs_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isAll_tabs_in_front() {
		return (boolean) super.call("is_all_tabs_in_front", new java.lang.Object[0]);
	}

	public void setAll_tabs_in_front(boolean value) {
		super.call("set_all_tabs_in_front", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getSwitch_on_drag_hover() {
		return (boolean) super.call("get_switch_on_drag_hover", new java.lang.Object[0]);
	}

	public void setSwitch_on_drag_hover(boolean value) {
		super.call("set_switch_on_drag_hover", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDrag_to_rearrange_enabled() {
		return (boolean) super.call("get_drag_to_rearrange_enabled", new java.lang.Object[0]);
	}

	public void setDrag_to_rearrange_enabled(boolean value) {
		super.call("set_drag_to_rearrange_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getTabs_rearrange_group() {
		return (long) super.call("get_tabs_rearrange_group", new java.lang.Object[0]);
	}

	public void setTabs_rearrange_group(long value) {
		super.call("set_tabs_rearrange_group", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getUse_hidden_tabs_for_min_size() {
		return (boolean) super.call("get_use_hidden_tabs_for_min_size", new java.lang.Object[0]);
	}

	public void setUse_hidden_tabs_for_min_size(boolean value) {
		super.call("set_use_hidden_tabs_for_min_size", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getTab_focus_mode() {
		return (long) super.call("get_tab_focus_mode", new java.lang.Object[0]);
	}

	public void setTab_focus_mode(long value) {
		super.call("set_tab_focus_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getDeselect_enabled() {
		return (boolean) super.call("get_deselect_enabled", new java.lang.Object[0]);
	}

	public void setDeselect_enabled(boolean value) {
		super.call("set_deselect_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
