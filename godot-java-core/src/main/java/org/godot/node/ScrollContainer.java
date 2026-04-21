package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ScrollContainer extends Container {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_h_scroll_bar", 4004517983L), java.util.Map.entry("set_h_scroll", 1286410249L),
			java.util.Map.entry("get_vertical_scroll_mode", 3987985145L),
			java.util.Map.entry("set_horizontal_custom_step", 373806689L),
			java.util.Map.entry("set_tile_scroll_hint", 2586408642L),
			java.util.Map.entry("get_v_scroll_bar", 2630340773L),
			java.util.Map.entry("get_horizontal_custom_step", 1740695150L),
			java.util.Map.entry("get_draw_focus_border", 2240911060L),
			java.util.Map.entry("set_scroll_hint_mode", 578158943L),
			java.util.Map.entry("is_following_focus", 36873697L),
			java.util.Map.entry("get_horizontal_scroll_mode", 3987985145L),
			java.util.Map.entry("set_vertical_custom_step", 373806689L),
			java.util.Map.entry("get_vertical_custom_step", 1740695150L),
			java.util.Map.entry("set_follow_focus", 2586408642L),
			java.util.Map.entry("get_scroll_hint_mode", 246835423L),
			java.util.Map.entry("ensure_control_visible", 1496901182L),
			java.util.Map.entry("set_draw_focus_border", 2586408642L), java.util.Map.entry("set_v_scroll", 1286410249L),
			java.util.Map.entry("set_vertical_scroll_mode", 2750506364L),
			java.util.Map.entry("set_deadzone", 1286410249L), java.util.Map.entry("get_deadzone", 3905245786L),
			java.util.Map.entry("set_horizontal_scroll_mode", 2750506364L),
			java.util.Map.entry("is_scroll_hint_tiled", 2240911060L), java.util.Map.entry("get_h_scroll", 3905245786L),
			java.util.Map.entry("get_v_scroll", 3905245786L));

	ScrollContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ScrollContainer(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_scroll_hint_tiled() {
		return (boolean) super.call("is_scroll_hint_tiled");
	}

	public boolean is_following_focus() {
		return (boolean) super.call("is_following_focus");
	}

	public void ensure_control_visible(Control control) {
		super.call("ensure_control_visible", new java.lang.Object[]{(java.lang.Object) control});
	}

	public boolean isFollow_focus() {
		return (boolean) super.call("is_following_focus", new java.lang.Object[0]);
	}

	public void setFollow_focus(boolean value) {
		super.call("set_follow_focus", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDraw_focus_border() {
		return (boolean) super.call("get_draw_focus_border", new java.lang.Object[0]);
	}

	public void setDraw_focus_border(boolean value) {
		super.call("set_draw_focus_border", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getScroll_horizontal() {
		return (long) super.call("get_h_scroll", new java.lang.Object[0]);
	}

	public void setScroll_horizontal(long value) {
		super.call("set_h_scroll", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getScroll_vertical() {
		return (long) super.call("get_v_scroll", new java.lang.Object[0]);
	}

	public void setScroll_vertical(long value) {
		super.call("set_v_scroll", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getScroll_horizontal_custom_step() {
		return (double) super.call("get_horizontal_custom_step", new java.lang.Object[0]);
	}

	public void setScroll_horizontal_custom_step(double value) {
		super.call("set_horizontal_custom_step", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getScroll_vertical_custom_step() {
		return (double) super.call("get_vertical_custom_step", new java.lang.Object[0]);
	}

	public void setScroll_vertical_custom_step(double value) {
		super.call("set_vertical_custom_step", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getHorizontal_scroll_mode() {
		return (long) super.call("get_horizontal_scroll_mode", new java.lang.Object[0]);
	}

	public void setHorizontal_scroll_mode(long value) {
		super.call("set_horizontal_scroll_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getVertical_scroll_mode() {
		return (long) super.call("get_vertical_scroll_mode", new java.lang.Object[0]);
	}

	public void setVertical_scroll_mode(long value) {
		super.call("set_vertical_scroll_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getScroll_deadzone() {
		return (long) super.call("get_deadzone", new java.lang.Object[0]);
	}

	public void setScroll_deadzone(long value) {
		super.call("set_deadzone", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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
