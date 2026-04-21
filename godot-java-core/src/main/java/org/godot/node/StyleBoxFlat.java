package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector2;

public class StyleBoxFlat extends StyleBox {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_border_color", 3444240500L), java.util.Map.entry("get_skew", 3341600327L),
			java.util.Map.entry("set_shadow_size", 1286410249L), java.util.Map.entry("get_corner_detail", 3905245786L),
			java.util.Map.entry("set_shadow_offset", 743155724L),
			java.util.Map.entry("get_border_width_min", 3905245786L),
			java.util.Map.entry("get_shadow_size", 3905245786L), java.util.Map.entry("get_bg_color", 3444240500L),
			java.util.Map.entry("get_border_blend", 36873697L), java.util.Map.entry("get_border_width", 1983885014L),
			java.util.Map.entry("set_border_width_all", 1286410249L),
			java.util.Map.entry("set_corner_detail", 1286410249L),
			java.util.Map.entry("get_shadow_offset", 3341600327L), java.util.Map.entry("get_aa_size", 1740695150L),
			java.util.Map.entry("set_skew", 743155724L), java.util.Map.entry("set_aa_size", 373806689L),
			java.util.Map.entry("set_border_blend", 2586408642L), java.util.Map.entry("get_expand_margin", 2869120046L),
			java.util.Map.entry("set_expand_margin_all", 373806689L),
			java.util.Map.entry("get_shadow_color", 3444240500L), java.util.Map.entry("set_expand_margin", 4290182280L),
			java.util.Map.entry("is_draw_center_enabled", 36873697L),
			java.util.Map.entry("set_shadow_color", 2920490490L), java.util.Map.entry("get_corner_radius", 3982397690L),
			java.util.Map.entry("set_bg_color", 2920490490L), java.util.Map.entry("set_corner_radius", 2696158768L),
			java.util.Map.entry("set_draw_center", 2586408642L),
			java.util.Map.entry("set_corner_radius_all", 1286410249L),
			java.util.Map.entry("set_border_width", 437707142L), java.util.Map.entry("set_border_color", 2920490490L),
			java.util.Map.entry("is_anti_aliased", 36873697L), java.util.Map.entry("set_anti_aliased", 2586408642L));

	StyleBoxFlat(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StyleBoxFlat(long nativePointer) {
		super(nativePointer);
	}

	public void set_border_width(int margin, long width) {
		super.call("set_border_width",
				new java.lang.Object[]{java.lang.Integer.valueOf(margin), java.lang.Long.valueOf(width)});
	}

	public int get_border_width(int margin) {
		return (int) super.call("get_border_width", new java.lang.Object[]{java.lang.Integer.valueOf(margin)});
	}

	public void set_corner_radius(int corner, long radius) {
		super.call("set_corner_radius",
				new java.lang.Object[]{java.lang.Integer.valueOf(corner), java.lang.Long.valueOf(radius)});
	}

	public int get_corner_radius(int corner) {
		return (int) super.call("get_corner_radius", new java.lang.Object[]{java.lang.Integer.valueOf(corner)});
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

	public boolean is_anti_aliased() {
		return (boolean) super.call("is_anti_aliased");
	}

	public Color getBg_color() {
		return (Color) super.call("get_bg_color", new java.lang.Object[0]);
	}

	public void setBg_color(Color value) {
		super.call("set_bg_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isDraw_center() {
		return (boolean) super.call("is_draw_center_enabled", new java.lang.Object[0]);
	}

	public void setDraw_center(boolean value) {
		super.call("set_draw_center", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getSkew() {
		return (Vector2) super.call("get_skew", new java.lang.Object[0]);
	}

	public void setSkew(Vector2 value) {
		super.call("set_skew", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getBorder_width_left() {
		return (long) super.call("get_border_width", new java.lang.Object[0]);
	}

	public void setBorder_width_left(long value) {
		super.call("set_border_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBorder_width_top() {
		return (long) super.call("get_border_width", new java.lang.Object[0]);
	}

	public void setBorder_width_top(long value) {
		super.call("set_border_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBorder_width_right() {
		return (long) super.call("get_border_width", new java.lang.Object[0]);
	}

	public void setBorder_width_right(long value) {
		super.call("set_border_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBorder_width_bottom() {
		return (long) super.call("get_border_width", new java.lang.Object[0]);
	}

	public void setBorder_width_bottom(long value) {
		super.call("set_border_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Color getBorder_color() {
		return (Color) super.call("get_border_color", new java.lang.Object[0]);
	}

	public void setBorder_color(Color value) {
		super.call("set_border_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getBorder_blend() {
		return (boolean) super.call("get_border_blend", new java.lang.Object[0]);
	}

	public void setBorder_blend(boolean value) {
		super.call("set_border_blend", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getCorner_radius_top_left() {
		return (long) super.call("get_corner_radius", new java.lang.Object[0]);
	}

	public void setCorner_radius_top_left(long value) {
		super.call("set_corner_radius", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCorner_radius_top_right() {
		return (long) super.call("get_corner_radius", new java.lang.Object[0]);
	}

	public void setCorner_radius_top_right(long value) {
		super.call("set_corner_radius", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCorner_radius_bottom_right() {
		return (long) super.call("get_corner_radius", new java.lang.Object[0]);
	}

	public void setCorner_radius_bottom_right(long value) {
		super.call("set_corner_radius", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCorner_radius_bottom_left() {
		return (long) super.call("get_corner_radius", new java.lang.Object[0]);
	}

	public void setCorner_radius_bottom_left(long value) {
		super.call("set_corner_radius", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCorner_detail() {
		return (long) super.call("get_corner_detail", new java.lang.Object[0]);
	}

	public void setCorner_detail(long value) {
		super.call("set_corner_detail", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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

	public Color getShadow_color() {
		return (Color) super.call("get_shadow_color", new java.lang.Object[0]);
	}

	public void setShadow_color(Color value) {
		super.call("set_shadow_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getShadow_size() {
		return (long) super.call("get_shadow_size", new java.lang.Object[0]);
	}

	public void setShadow_size(long value) {
		super.call("set_shadow_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector2 getShadow_offset() {
		return (Vector2) super.call("get_shadow_offset", new java.lang.Object[0]);
	}

	public void setShadow_offset(Vector2 value) {
		super.call("set_shadow_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isAnti_aliasing() {
		return (boolean) super.call("is_anti_aliased", new java.lang.Object[0]);
	}

	public void setAnti_aliasing(boolean value) {
		super.call("set_anti_aliased", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getAnti_aliasing_size() {
		return (double) super.call("get_aa_size", new java.lang.Object[0]);
	}

	public void setAnti_aliasing_size(double value) {
		super.call("set_aa_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
