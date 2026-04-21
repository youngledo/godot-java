package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class Camera2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_anchor_mode", 155978067L), java.util.Map.entry("align", 3218959716L),
			java.util.Map.entry("set_process_callback", 4201947462L), java.util.Map.entry("make_current", 3218959716L),
			java.util.Map.entry("get_drag_margin", 2869120046L),
			java.util.Map.entry("is_limit_smoothing_enabled", 36873697L),
			java.util.Map.entry("set_drag_vertical_enabled", 2586408642L),
			java.util.Map.entry("get_drag_vertical_offset", 1740695150L),
			java.util.Map.entry("set_drag_vertical_offset", 373806689L),
			java.util.Map.entry("set_limit_smoothing_enabled", 2586408642L),
			java.util.Map.entry("get_position_smoothing_speed", 1740695150L),
			java.util.Map.entry("get_process_callback", 2325344499L),
			java.util.Map.entry("is_limit_enabled", 36873697L), java.util.Map.entry("get_offset", 3341600327L),
			java.util.Map.entry("get_custom_viewport", 3160264692L),
			java.util.Map.entry("set_position_smoothing_speed", 373806689L),
			java.util.Map.entry("force_update_scroll", 3218959716L),
			java.util.Map.entry("get_drag_horizontal_offset", 1740695150L),
			java.util.Map.entry("is_rotation_smoothing_enabled", 36873697L),
			java.util.Map.entry("set_enabled", 2586408642L),
			java.util.Map.entry("set_drag_horizontal_enabled", 2586408642L),
			java.util.Map.entry("is_drag_horizontal_enabled", 36873697L),
			java.util.Map.entry("is_ignoring_rotation", 36873697L), java.util.Map.entry("set_limit", 437707142L),
			java.util.Map.entry("set_custom_viewport", 1078189570L), java.util.Map.entry("set_offset", 743155724L),
			java.util.Map.entry("set_rotation_smoothing_speed", 373806689L),
			java.util.Map.entry("get_zoom", 3341600327L),
			java.util.Map.entry("set_rotation_smoothing_enabled", 2586408642L),
			java.util.Map.entry("get_screen_rotation", 1740695150L),
			java.util.Map.entry("set_position_smoothing_enabled", 2586408642L),
			java.util.Map.entry("is_enabled", 36873697L),
			java.util.Map.entry("get_screen_center_position", 3341600327L),
			java.util.Map.entry("is_screen_drawing_enabled", 36873697L),
			java.util.Map.entry("set_drag_margin", 4290182280L),
			java.util.Map.entry("get_target_position", 3341600327L),
			java.util.Map.entry("is_margin_drawing_enabled", 36873697L),
			java.util.Map.entry("set_anchor_mode", 2050398218L),
			java.util.Map.entry("set_ignore_rotation", 2586408642L),
			java.util.Map.entry("is_limit_drawing_enabled", 36873697L), java.util.Map.entry("get_limit", 1983885014L),
			java.util.Map.entry("is_position_smoothing_enabled", 36873697L),
			java.util.Map.entry("set_drag_horizontal_offset", 373806689L), java.util.Map.entry("set_zoom", 743155724L),
			java.util.Map.entry("set_margin_drawing_enabled", 2586408642L),
			java.util.Map.entry("set_screen_drawing_enabled", 2586408642L),
			java.util.Map.entry("set_limit_enabled", 2586408642L),
			java.util.Map.entry("is_drag_vertical_enabled", 36873697L), java.util.Map.entry("is_current", 36873697L),
			java.util.Map.entry("set_limit_drawing_enabled", 2586408642L),
			java.util.Map.entry("reset_smoothing", 3218959716L),
			java.util.Map.entry("get_rotation_smoothing_speed", 1740695150L));

	Camera2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Camera2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_ignoring_rotation() {
		return (boolean) super.call("is_ignoring_rotation");
	}

	public boolean is_enabled() {
		return (boolean) super.call("is_enabled");
	}

	public void make_current() {
		super.call("make_current");
	}

	public boolean is_current() {
		return (boolean) super.call("is_current");
	}

	public boolean is_limit_enabled() {
		return (boolean) super.call("is_limit_enabled");
	}

	public void set_limit(int margin, long limit) {
		super.call("set_limit",
				new java.lang.Object[]{java.lang.Integer.valueOf(margin), java.lang.Long.valueOf(limit)});
	}

	public int get_limit(int margin) {
		return (int) super.call("get_limit", new java.lang.Object[]{java.lang.Integer.valueOf(margin)});
	}

	public boolean is_limit_smoothing_enabled() {
		return (boolean) super.call("is_limit_smoothing_enabled");
	}

	public boolean is_drag_vertical_enabled() {
		return (boolean) super.call("is_drag_vertical_enabled");
	}

	public boolean is_drag_horizontal_enabled() {
		return (boolean) super.call("is_drag_horizontal_enabled");
	}

	public void set_drag_margin(int margin, double drag_margin) {
		super.call("set_drag_margin",
				new java.lang.Object[]{java.lang.Integer.valueOf(margin), java.lang.Double.valueOf(drag_margin)});
	}

	public double get_drag_margin(int margin) {
		return (double) super.call("get_drag_margin", new java.lang.Object[]{java.lang.Integer.valueOf(margin)});
	}

	public boolean is_position_smoothing_enabled() {
		return (boolean) super.call("is_position_smoothing_enabled");
	}

	public boolean is_rotation_smoothing_enabled() {
		return (boolean) super.call("is_rotation_smoothing_enabled");
	}

	public void force_update_scroll() {
		super.call("force_update_scroll");
	}

	public void reset_smoothing() {
		super.call("reset_smoothing");
	}

	public void align() {
		super.call("align");
	}

	public boolean is_screen_drawing_enabled() {
		return (boolean) super.call("is_screen_drawing_enabled");
	}

	public boolean is_limit_drawing_enabled() {
		return (boolean) super.call("is_limit_drawing_enabled");
	}

	public boolean is_margin_drawing_enabled() {
		return (boolean) super.call("is_margin_drawing_enabled");
	}

	public Vector2 getOffset() {
		return (Vector2) super.call("get_offset", new java.lang.Object[0]);
	}

	public void setOffset(Vector2 value) {
		super.call("set_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getAnchor_mode() {
		return (long) super.call("get_anchor_mode", new java.lang.Object[0]);
	}

	public void setAnchor_mode(long value) {
		super.call("set_anchor_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isIgnore_rotation() {
		return (boolean) super.call("is_ignoring_rotation", new java.lang.Object[0]);
	}

	public void setIgnore_rotation(boolean value) {
		super.call("set_ignore_rotation", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEnabled() {
		return (boolean) super.call("is_enabled", new java.lang.Object[0]);
	}

	public void setEnabled(boolean value) {
		super.call("set_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getZoom() {
		return (Vector2) super.call("get_zoom", new java.lang.Object[0]);
	}

	public void setZoom(Vector2 value) {
		super.call("set_zoom", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Viewport getCustom_viewport() {
		return (Viewport) super.call("get_custom_viewport", new java.lang.Object[0]);
	}

	public void setCustom_viewport(Viewport value) {
		super.call("set_custom_viewport", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getProcess_callback() {
		return (long) super.call("get_process_callback", new java.lang.Object[0]);
	}

	public void setProcess_callback(long value) {
		super.call("set_process_callback", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isLimit_enabled() {
		return (boolean) super.call("is_limit_enabled", new java.lang.Object[0]);
	}

	public void setLimit_enabled(boolean value) {
		super.call("set_limit_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getLimit_left() {
		return (long) super.call("get_limit", new java.lang.Object[0]);
	}

	public void setLimit_left(long value) {
		super.call("set_limit", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getLimit_top() {
		return (long) super.call("get_limit", new java.lang.Object[0]);
	}

	public void setLimit_top(long value) {
		super.call("set_limit", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getLimit_right() {
		return (long) super.call("get_limit", new java.lang.Object[0]);
	}

	public void setLimit_right(long value) {
		super.call("set_limit", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getLimit_bottom() {
		return (long) super.call("get_limit", new java.lang.Object[0]);
	}

	public void setLimit_bottom(long value) {
		super.call("set_limit", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isLimit_smoothed() {
		return (boolean) super.call("is_limit_smoothing_enabled", new java.lang.Object[0]);
	}

	public void setLimit_smoothed(boolean value) {
		super.call("set_limit_smoothing_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPosition_smoothing_enabled() {
		return (boolean) super.call("is_position_smoothing_enabled", new java.lang.Object[0]);
	}

	public void setPosition_smoothing_enabled(boolean value) {
		super.call("set_position_smoothing_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getPosition_smoothing_speed() {
		return (double) super.call("get_position_smoothing_speed", new java.lang.Object[0]);
	}

	public void setPosition_smoothing_speed(double value) {
		super.call("set_position_smoothing_speed", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isRotation_smoothing_enabled() {
		return (boolean) super.call("is_rotation_smoothing_enabled", new java.lang.Object[0]);
	}

	public void setRotation_smoothing_enabled(boolean value) {
		super.call("set_rotation_smoothing_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getRotation_smoothing_speed() {
		return (double) super.call("get_rotation_smoothing_speed", new java.lang.Object[0]);
	}

	public void setRotation_smoothing_speed(double value) {
		super.call("set_rotation_smoothing_speed", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isDrag_horizontal_enabled() {
		return (boolean) super.call("is_drag_horizontal_enabled", new java.lang.Object[0]);
	}

	public void setDrag_horizontal_enabled(boolean value) {
		super.call("set_drag_horizontal_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDrag_vertical_enabled() {
		return (boolean) super.call("is_drag_vertical_enabled", new java.lang.Object[0]);
	}

	public void setDrag_vertical_enabled(boolean value) {
		super.call("set_drag_vertical_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getDrag_horizontal_offset() {
		return (double) super.call("get_drag_horizontal_offset", new java.lang.Object[0]);
	}

	public void setDrag_horizontal_offset(double value) {
		super.call("set_drag_horizontal_offset", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDrag_vertical_offset() {
		return (double) super.call("get_drag_vertical_offset", new java.lang.Object[0]);
	}

	public void setDrag_vertical_offset(double value) {
		super.call("set_drag_vertical_offset", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDrag_left_margin() {
		return (double) super.call("get_drag_margin", new java.lang.Object[0]);
	}

	public void setDrag_left_margin(double value) {
		super.call("set_drag_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDrag_top_margin() {
		return (double) super.call("get_drag_margin", new java.lang.Object[0]);
	}

	public void setDrag_top_margin(double value) {
		super.call("set_drag_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDrag_right_margin() {
		return (double) super.call("get_drag_margin", new java.lang.Object[0]);
	}

	public void setDrag_right_margin(double value) {
		super.call("set_drag_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDrag_bottom_margin() {
		return (double) super.call("get_drag_margin", new java.lang.Object[0]);
	}

	public void setDrag_bottom_margin(double value) {
		super.call("set_drag_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isEditor_draw_screen() {
		return (boolean) super.call("is_screen_drawing_enabled", new java.lang.Object[0]);
	}

	public void setEditor_draw_screen(boolean value) {
		super.call("set_screen_drawing_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEditor_draw_limits() {
		return (boolean) super.call("is_limit_drawing_enabled", new java.lang.Object[0]);
	}

	public void setEditor_draw_limits(boolean value) {
		super.call("set_limit_drawing_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEditor_draw_drag_margin() {
		return (boolean) super.call("is_margin_drawing_enabled", new java.lang.Object[0]);
	}

	public void setEditor_draw_drag_margin(boolean value) {
		super.call("set_margin_drawing_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
