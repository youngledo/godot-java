package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2;

public class NinePatchRect extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_draw_center", 2586408642L),
			java.util.Map.entry("is_draw_center_enabled", 36873697L),
			java.util.Map.entry("get_region_rect", 1639390495L), java.util.Map.entry("set_region_rect", 2046264180L),
			java.util.Map.entry("set_patch_margin", 437707142L), java.util.Map.entry("get_patch_margin", 1983885014L),
			java.util.Map.entry("set_texture", 4051416890L),
			java.util.Map.entry("get_h_axis_stretch_mode", 3317113799L),
			java.util.Map.entry("set_h_axis_stretch_mode", 3219608417L),
			java.util.Map.entry("get_v_axis_stretch_mode", 3317113799L),
			java.util.Map.entry("get_texture", 3635182373L),
			java.util.Map.entry("set_v_axis_stretch_mode", 3219608417L));

	NinePatchRect(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NinePatchRect(long nativePointer) {
		super(nativePointer);
	}

	public void set_patch_margin(int margin, long value) {
		super.call("set_patch_margin",
				new java.lang.Object[]{java.lang.Integer.valueOf(margin), java.lang.Long.valueOf(value)});
	}

	public int get_patch_margin(int margin) {
		return (int) super.call("get_patch_margin", new java.lang.Object[]{java.lang.Integer.valueOf(margin)});
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

	public boolean isDraw_center() {
		return (boolean) super.call("is_draw_center_enabled", new java.lang.Object[0]);
	}

	public void setDraw_center(boolean value) {
		super.call("set_draw_center", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Rect2 getRegion_rect() {
		return (Rect2) super.call("get_region_rect", new java.lang.Object[0]);
	}

	public void setRegion_rect(Rect2 value) {
		super.call("set_region_rect", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getPatch_margin_left() {
		return (long) super.call("get_patch_margin", new java.lang.Object[0]);
	}

	public void setPatch_margin_left(long value) {
		super.call("set_patch_margin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPatch_margin_top() {
		return (long) super.call("get_patch_margin", new java.lang.Object[0]);
	}

	public void setPatch_margin_top(long value) {
		super.call("set_patch_margin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPatch_margin_right() {
		return (long) super.call("get_patch_margin", new java.lang.Object[0]);
	}

	public void setPatch_margin_right(long value) {
		super.call("set_patch_margin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPatch_margin_bottom() {
		return (long) super.call("get_patch_margin", new java.lang.Object[0]);
	}

	public void setPatch_margin_bottom(long value) {
		super.call("set_patch_margin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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
}
