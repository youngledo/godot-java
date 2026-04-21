package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector2;

public class SpriteBase3D extends GeometryInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("generate_triangle_mesh", 3476533166L), java.util.Map.entry("set_flip_v", 2586408642L),
			java.util.Map.entry("is_centered", 36873697L), java.util.Map.entry("set_axis", 1144690656L),
			java.util.Map.entry("get_texture_filter", 3289213076L),
			java.util.Map.entry("set_alpha_antialiasing", 3212649852L), java.util.Map.entry("is_flipped_h", 36873697L),
			java.util.Map.entry("set_centered", 2586408642L), java.util.Map.entry("set_pixel_size", 373806689L),
			java.util.Map.entry("set_alpha_cut_mode", 227561226L),
			java.util.Map.entry("get_alpha_cut_mode", 336003791L), java.util.Map.entry("set_texture_filter", 22904437L),
			java.util.Map.entry("get_offset", 3341600327L), java.util.Map.entry("is_flipped_v", 36873697L),
			java.util.Map.entry("get_alpha_antialiasing_edge", 1740695150L),
			java.util.Map.entry("get_axis", 3050976882L), java.util.Map.entry("get_alpha_antialiasing", 2889939400L),
			java.util.Map.entry("set_render_priority", 1286410249L),
			java.util.Map.entry("set_alpha_antialiasing_edge", 373806689L),
			java.util.Map.entry("set_draw_flag", 1135633219L),
			java.util.Map.entry("get_alpha_scissor_threshold", 1740695150L),
			java.util.Map.entry("get_item_rect", 1639390495L),
			java.util.Map.entry("set_alpha_scissor_threshold", 373806689L),
			java.util.Map.entry("get_billboard_mode", 1283840139L),
			java.util.Map.entry("get_alpha_hash_scale", 1740695150L), java.util.Map.entry("set_flip_h", 2586408642L),
			java.util.Map.entry("get_draw_flag", 1733036628L), java.util.Map.entry("set_billboard_mode", 4202036497L),
			java.util.Map.entry("set_modulate", 2920490490L), java.util.Map.entry("set_offset", 743155724L),
			java.util.Map.entry("get_render_priority", 3905245786L), java.util.Map.entry("get_modulate", 3444240500L),
			java.util.Map.entry("set_alpha_hash_scale", 373806689L),
			java.util.Map.entry("get_pixel_size", 1740695150L));

	SpriteBase3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SpriteBase3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_centered() {
		return (boolean) super.call("is_centered");
	}

	public boolean is_flipped_h() {
		return (boolean) super.call("is_flipped_h");
	}

	public boolean is_flipped_v() {
		return (boolean) super.call("is_flipped_v");
	}

	public void set_draw_flag(int flag, boolean enabled) {
		super.call("set_draw_flag",
				new java.lang.Object[]{java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean get_draw_flag(int flag) {
		return (boolean) super.call("get_draw_flag", new java.lang.Object[]{java.lang.Integer.valueOf(flag)});
	}

	public TriangleMesh generate_triangle_mesh() {
		return (TriangleMesh) super.call("generate_triangle_mesh");
	}

	public boolean isCentered() {
		return (boolean) super.call("is_centered", new java.lang.Object[0]);
	}

	public void setCentered(boolean value) {
		super.call("set_centered", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getOffset() {
		return (Vector2) super.call("get_offset", new java.lang.Object[0]);
	}

	public void setOffset(Vector2 value) {
		super.call("set_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isFlip_h() {
		return (boolean) super.call("is_flipped_h", new java.lang.Object[0]);
	}

	public void setFlip_h(boolean value) {
		super.call("set_flip_h", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isFlip_v() {
		return (boolean) super.call("is_flipped_v", new java.lang.Object[0]);
	}

	public void setFlip_v(boolean value) {
		super.call("set_flip_v", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getModulate() {
		return (Color) super.call("get_modulate", new java.lang.Object[0]);
	}

	public void setModulate(Color value) {
		super.call("set_modulate", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getPixel_size() {
		return (double) super.call("get_pixel_size", new java.lang.Object[0]);
	}

	public void setPixel_size(double value) {
		super.call("set_pixel_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getAxis() {
		return (long) super.call("get_axis", new java.lang.Object[0]);
	}

	public void setAxis(long value) {
		super.call("set_axis", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBillboard() {
		return (long) super.call("get_billboard_mode", new java.lang.Object[0]);
	}

	public void setBillboard(long value) {
		super.call("set_billboard_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getTransparent() {
		return (boolean) super.call("get_draw_flag", new java.lang.Object[0]);
	}

	public void setTransparent(boolean value) {
		super.call("set_draw_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getShaded() {
		return (boolean) super.call("get_draw_flag", new java.lang.Object[0]);
	}

	public void setShaded(boolean value) {
		super.call("set_draw_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDouble_sided() {
		return (boolean) super.call("get_draw_flag", new java.lang.Object[0]);
	}

	public void setDouble_sided(boolean value) {
		super.call("set_draw_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getNo_depth_test() {
		return (boolean) super.call("get_draw_flag", new java.lang.Object[0]);
	}

	public void setNo_depth_test(boolean value) {
		super.call("set_draw_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getFixed_size() {
		return (boolean) super.call("get_draw_flag", new java.lang.Object[0]);
	}

	public void setFixed_size(boolean value) {
		super.call("set_draw_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getAlpha_cut() {
		return (long) super.call("get_alpha_cut_mode", new java.lang.Object[0]);
	}

	public void setAlpha_cut(long value) {
		super.call("set_alpha_cut_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getAlpha_scissor_threshold() {
		return (double) super.call("get_alpha_scissor_threshold", new java.lang.Object[0]);
	}

	public void setAlpha_scissor_threshold(double value) {
		super.call("set_alpha_scissor_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAlpha_hash_scale() {
		return (double) super.call("get_alpha_hash_scale", new java.lang.Object[0]);
	}

	public void setAlpha_hash_scale(double value) {
		super.call("set_alpha_hash_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getAlpha_antialiasing_mode() {
		return (long) super.call("get_alpha_antialiasing", new java.lang.Object[0]);
	}

	public void setAlpha_antialiasing_mode(long value) {
		super.call("set_alpha_antialiasing", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getAlpha_antialiasing_edge() {
		return (double) super.call("get_alpha_antialiasing_edge", new java.lang.Object[0]);
	}

	public void setAlpha_antialiasing_edge(double value) {
		super.call("set_alpha_antialiasing_edge", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getTexture_filter() {
		return (long) super.call("get_texture_filter", new java.lang.Object[0]);
	}

	public void setTexture_filter(long value) {
		super.call("set_texture_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRender_priority() {
		return (long) super.call("get_render_priority", new java.lang.Object[0]);
	}

	public void setRender_priority(long value) {
		super.call("set_render_priority", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
