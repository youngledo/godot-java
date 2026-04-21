package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector2;

public class TextureProgressBar extends Range {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_nine_patch_stretch", 2586408642L),
			java.util.Map.entry("set_tint_progress", 2920490490L), java.util.Map.entry("set_over_texture", 4051416890L),
			java.util.Map.entry("set_fill_mode", 1286410249L), java.util.Map.entry("set_tint_under", 2920490490L),
			java.util.Map.entry("get_radial_initial_angle", 191475506L),
			java.util.Map.entry("set_progress_texture", 4051416890L),
			java.util.Map.entry("get_progress_texture", 3635182373L),
			java.util.Map.entry("get_radial_center_offset", 1497962370L),
			java.util.Map.entry("set_radial_center_offset", 743155724L),
			java.util.Map.entry("get_fill_mode", 2455072627L),
			java.util.Map.entry("get_texture_progress_offset", 3341600327L),
			java.util.Map.entry("get_tint_under", 3444240500L), java.util.Map.entry("get_under_texture", 3635182373L),
			java.util.Map.entry("get_over_texture", 3635182373L), java.util.Map.entry("get_tint_progress", 3444240500L),
			java.util.Map.entry("set_radial_initial_angle", 373806689L),
			java.util.Map.entry("set_texture_progress_offset", 743155724L),
			java.util.Map.entry("get_tint_over", 3444240500L), java.util.Map.entry("get_nine_patch_stretch", 36873697L),
			java.util.Map.entry("set_under_texture", 4051416890L),
			java.util.Map.entry("get_stretch_margin", 1983885014L), java.util.Map.entry("set_fill_degrees", 373806689L),
			java.util.Map.entry("set_stretch_margin", 437707142L), java.util.Map.entry("set_tint_over", 2920490490L),
			java.util.Map.entry("get_fill_degrees", 191475506L));

	TextureProgressBar(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextureProgressBar(long nativePointer) {
		super(nativePointer);
	}

	public void set_stretch_margin(int margin, long value) {
		super.call("set_stretch_margin",
				new java.lang.Object[]{java.lang.Integer.valueOf(margin), java.lang.Long.valueOf(value)});
	}

	public int get_stretch_margin(int margin) {
		return (int) super.call("get_stretch_margin", new java.lang.Object[]{java.lang.Integer.valueOf(margin)});
	}

	public long getFill_mode() {
		return (long) super.call("get_fill_mode", new java.lang.Object[0]);
	}

	public void setFill_mode(long value) {
		super.call("set_fill_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getRadial_initial_angle() {
		return (double) super.call("get_radial_initial_angle", new java.lang.Object[0]);
	}

	public void setRadial_initial_angle(double value) {
		super.call("set_radial_initial_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRadial_fill_degrees() {
		return (double) super.call("get_fill_degrees", new java.lang.Object[0]);
	}

	public void setRadial_fill_degrees(double value) {
		super.call("set_fill_degrees", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getRadial_center_offset() {
		return (Vector2) super.call("get_radial_center_offset", new java.lang.Object[0]);
	}

	public void setRadial_center_offset(Vector2 value) {
		super.call("set_radial_center_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getNine_patch_stretch() {
		return (boolean) super.call("get_nine_patch_stretch", new java.lang.Object[0]);
	}

	public void setNine_patch_stretch(boolean value) {
		super.call("set_nine_patch_stretch", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getStretch_margin_left() {
		return (long) super.call("get_stretch_margin", new java.lang.Object[0]);
	}

	public void setStretch_margin_left(long value) {
		super.call("set_stretch_margin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getStretch_margin_top() {
		return (long) super.call("get_stretch_margin", new java.lang.Object[0]);
	}

	public void setStretch_margin_top(long value) {
		super.call("set_stretch_margin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getStretch_margin_right() {
		return (long) super.call("get_stretch_margin", new java.lang.Object[0]);
	}

	public void setStretch_margin_right(long value) {
		super.call("set_stretch_margin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getStretch_margin_bottom() {
		return (long) super.call("get_stretch_margin", new java.lang.Object[0]);
	}

	public void setStretch_margin_bottom(long value) {
		super.call("set_stretch_margin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Texture2D getTexture_under() {
		return (Texture2D) super.call("get_under_texture", new java.lang.Object[0]);
	}

	public void setTexture_under(Texture2D value) {
		super.call("set_under_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getTexture_over() {
		return (Texture2D) super.call("get_over_texture", new java.lang.Object[0]);
	}

	public void setTexture_over(Texture2D value) {
		super.call("set_over_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getTexture_progress() {
		return (Texture2D) super.call("get_progress_texture", new java.lang.Object[0]);
	}

	public void setTexture_progress(Texture2D value) {
		super.call("set_progress_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getTexture_progress_offset() {
		return (Vector2) super.call("get_texture_progress_offset", new java.lang.Object[0]);
	}

	public void setTexture_progress_offset(Vector2 value) {
		super.call("set_texture_progress_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getTint_under() {
		return (Color) super.call("get_tint_under", new java.lang.Object[0]);
	}

	public void setTint_under(Color value) {
		super.call("set_tint_under", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getTint_over() {
		return (Color) super.call("get_tint_over", new java.lang.Object[0]);
	}

	public void setTint_over(Color value) {
		super.call("set_tint_over", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getTint_progress() {
		return (Color) super.call("get_tint_progress", new java.lang.Object[0]);
	}

	public void setTint_progress(Color value) {
		super.call("set_tint_progress", new java.lang.Object[]{(java.lang.Object) value});
	}
}
