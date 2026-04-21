package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Rect2;

public class StyleBoxTexture extends StyleBox {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_texture_margin_all", 373806689L),
			java.util.Map.entry("is_draw_center_enabled", 36873697L),
			java.util.Map.entry("get_region_rect", 1639390495L), java.util.Map.entry("set_texture_margin", 4290182280L),
			java.util.Map.entry("get_texture_margin", 2869120046L), java.util.Map.entry("set_draw_center", 2586408642L),
			java.util.Map.entry("set_region_rect", 2046264180L), java.util.Map.entry("set_modulate", 2920490490L),
			java.util.Map.entry("set_texture", 4051416890L), java.util.Map.entry("get_expand_margin", 2869120046L),
			java.util.Map.entry("set_expand_margin_all", 373806689L),
			java.util.Map.entry("get_h_axis_stretch_mode", 3807744063L),
			java.util.Map.entry("set_expand_margin", 4290182280L), java.util.Map.entry("get_modulate", 3444240500L),
			java.util.Map.entry("set_h_axis_stretch_mode", 2965538783L),
			java.util.Map.entry("get_v_axis_stretch_mode", 3807744063L),
			java.util.Map.entry("get_texture", 3635182373L),
			java.util.Map.entry("set_v_axis_stretch_mode", 2965538783L));

	StyleBoxTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StyleBoxTexture(long nativePointer) {
		super(nativePointer);
	}

	public void set_texture_margin(int margin, double size) {
		super.call("set_texture_margin",
				new java.lang.Object[]{java.lang.Integer.valueOf(margin), java.lang.Double.valueOf(size)});
	}

	public double get_texture_margin(int margin) {
		return (double) super.call("get_texture_margin", new java.lang.Object[]{java.lang.Integer.valueOf(margin)});
	}

	public void set_expand_margin(int margin, double size) {
		super.call("set_expand_margin",
				new java.lang.Object[]{java.lang.Integer.valueOf(margin), java.lang.Double.valueOf(size)});
	}

	public double get_expand_margin(int margin) {
		return (double) super.call("get_expand_margin", new java.lang.Object[]{java.lang.Integer.valueOf(margin)});
	}

	public boolean is_draw_center_enabled() {
		return (boolean) super.call("is_draw_center_enabled");
	}

	public Texture2D getTexture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getTexture_margin_left() {
		return (double) super.call("get_texture_margin", new java.lang.Object[0]);
	}

	public void setTexture_margin_left(double value) {
		super.call("set_texture_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTexture_margin_top() {
		return (double) super.call("get_texture_margin", new java.lang.Object[0]);
	}

	public void setTexture_margin_top(double value) {
		super.call("set_texture_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTexture_margin_right() {
		return (double) super.call("get_texture_margin", new java.lang.Object[0]);
	}

	public void setTexture_margin_right(double value) {
		super.call("set_texture_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTexture_margin_bottom() {
		return (double) super.call("get_texture_margin", new java.lang.Object[0]);
	}

	public void setTexture_margin_bottom(double value) {
		super.call("set_texture_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getExpand_margin_left() {
		return (double) super.call("get_expand_margin", new java.lang.Object[0]);
	}

	public void setExpand_margin_left(double value) {
		super.call("set_expand_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getExpand_margin_top() {
		return (double) super.call("get_expand_margin", new java.lang.Object[0]);
	}

	public void setExpand_margin_top(double value) {
		super.call("set_expand_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getExpand_margin_right() {
		return (double) super.call("get_expand_margin", new java.lang.Object[0]);
	}

	public void setExpand_margin_right(double value) {
		super.call("set_expand_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getExpand_margin_bottom() {
		return (double) super.call("get_expand_margin", new java.lang.Object[0]);
	}

	public void setExpand_margin_bottom(double value) {
		super.call("set_expand_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getAxis_stretch_horizontal() {
		return (long) super.call("get_h_axis_stretch_mode", new java.lang.Object[0]);
	}

	public void setAxis_stretch_horizontal(long value) {
		super.call("set_h_axis_stretch_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getAxis_stretch_vertical() {
		return (long) super.call("get_v_axis_stretch_mode", new java.lang.Object[0]);
	}

	public void setAxis_stretch_vertical(long value) {
		super.call("set_v_axis_stretch_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Rect2 getRegion_rect() {
		return (Rect2) super.call("get_region_rect", new java.lang.Object[0]);
	}

	public void setRegion_rect(Rect2 value) {
		super.call("set_region_rect", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getModulate_color() {
		return (Color) super.call("get_modulate", new java.lang.Object[0]);
	}

	public void setModulate_color(Color value) {
		super.call("set_modulate", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isDraw_center() {
		return (boolean) super.call("is_draw_center_enabled", new java.lang.Object[0]);
	}

	public void setDraw_center(boolean value) {
		super.call("set_draw_center", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
