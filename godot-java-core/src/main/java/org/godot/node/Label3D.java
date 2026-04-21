package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.math.Color;
import org.godot.math.Vector2;

public class Label3D extends GeometryInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_outline_size", 3905245786L),
			java.util.Map.entry("set_structured_text_bidi_override", 55961453L),
			java.util.Map.entry("get_texture_filter", 3289213076L),
			java.util.Map.entry("get_vertical_alignment", 3274884059L),
			java.util.Map.entry("get_line_spacing", 1740695150L),
			java.util.Map.entry("set_alpha_antialiasing", 3212649852L),
			java.util.Map.entry("set_line_spacing", 373806689L), java.util.Map.entry("get_width", 1740695150L),
			java.util.Map.entry("get_language", 201670096L), java.util.Map.entry("set_language", 83702148L),
			java.util.Map.entry("get_structured_text_bidi_override", 3385126229L),
			java.util.Map.entry("set_uppercase", 2586408642L),
			java.util.Map.entry("get_structured_text_bidi_override_options", 3995934104L),
			java.util.Map.entry("set_pixel_size", 373806689L), java.util.Map.entry("set_texture_filter", 22904437L),
			java.util.Map.entry("set_structured_text_bidi_override_options", 381264803L),
			java.util.Map.entry("set_outline_render_priority", 1286410249L),
			java.util.Map.entry("get_offset", 3341600327L),
			java.util.Map.entry("get_alpha_antialiasing_edge", 1740695150L),
			java.util.Map.entry("set_render_priority", 1286410249L),
			java.util.Map.entry("set_alpha_antialiasing_edge", 373806689L), java.util.Map.entry("get_text", 201670096L),
			java.util.Map.entry("get_alpha_scissor_threshold", 1740695150L),
			java.util.Map.entry("set_outline_modulate", 2920490490L),
			java.util.Map.entry("set_alpha_scissor_threshold", 373806689L),
			java.util.Map.entry("get_billboard_mode", 1283840139L), java.util.Map.entry("get_font_size", 3905245786L),
			java.util.Map.entry("set_text", 83702148L), java.util.Map.entry("get_draw_flag", 259226453L),
			java.util.Map.entry("set_modulate", 2920490490L),
			java.util.Map.entry("set_autowrap_trim_flags", 2809697122L),
			java.util.Map.entry("get_outline_modulate", 3444240500L),
			java.util.Map.entry("get_render_priority", 3905245786L), java.util.Map.entry("set_offset", 743155724L),
			java.util.Map.entry("get_pixel_size", 1740695150L),
			java.util.Map.entry("generate_triangle_mesh", 3476533166L),
			java.util.Map.entry("get_text_direction", 2516697328L),
			java.util.Map.entry("get_outline_render_priority", 3905245786L),
			java.util.Map.entry("get_autowrap_mode", 1549071663L),
			java.util.Map.entry("set_autowrap_mode", 3289138044L),
			java.util.Map.entry("set_justification_flags", 2877345813L), java.util.Map.entry("is_uppercase", 36873697L),
			java.util.Map.entry("get_autowrap_trim_flags", 2340632602L), java.util.Map.entry("get_font", 3229501585L),
			java.util.Map.entry("set_font", 1262170328L), java.util.Map.entry("set_alpha_cut_mode", 2549142916L),
			java.util.Map.entry("get_alpha_cut_mode", 219468601L),
			java.util.Map.entry("get_horizontal_alignment", 341400642L),
			java.util.Map.entry("set_font_size", 1286410249L), java.util.Map.entry("set_text_direction", 1418190634L),
			java.util.Map.entry("set_outline_size", 1286410249L),
			java.util.Map.entry("get_alpha_antialiasing", 2889939400L),
			java.util.Map.entry("set_horizontal_alignment", 2312603777L),
			java.util.Map.entry("set_draw_flag", 1285833066L), java.util.Map.entry("set_width", 373806689L),
			java.util.Map.entry("get_justification_flags", 1583363614L),
			java.util.Map.entry("get_alpha_hash_scale", 1740695150L),
			java.util.Map.entry("set_billboard_mode", 4202036497L),
			java.util.Map.entry("set_vertical_alignment", 1796458609L),
			java.util.Map.entry("get_modulate", 3444240500L), java.util.Map.entry("set_alpha_hash_scale", 373806689L));

	Label3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Label3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_uppercase() {
		return (boolean) super.call("is_uppercase");
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

	public double getPixel_size() {
		return (double) super.call("get_pixel_size", new java.lang.Object[0]);
	}

	public void setPixel_size(double value) {
		super.call("set_pixel_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getOffset() {
		return (Vector2) super.call("get_offset", new java.lang.Object[0]);
	}

	public void setOffset(Vector2 value) {
		super.call("set_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getBillboard() {
		return (long) super.call("get_billboard_mode", new java.lang.Object[0]);
	}

	public void setBillboard(long value) {
		super.call("set_billboard_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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

	public long getOutline_render_priority() {
		return (long) super.call("get_outline_render_priority", new java.lang.Object[0]);
	}

	public void setOutline_render_priority(long value) {
		super.call("set_outline_render_priority", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Color getModulate() {
		return (Color) super.call("get_modulate", new java.lang.Object[0]);
	}

	public void setModulate(Color value) {
		super.call("set_modulate", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getOutline_modulate() {
		return (Color) super.call("get_outline_modulate", new java.lang.Object[0]);
	}

	public void setOutline_modulate(Color value) {
		super.call("set_outline_modulate", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getText() {
		return (String) super.call("get_text", new java.lang.Object[0]);
	}

	public void setText(String value) {
		super.call("set_text", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Font getFont() {
		return (Font) super.call("get_font", new java.lang.Object[0]);
	}

	public void setFont(Font value) {
		super.call("set_font", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getFont_size() {
		return (long) super.call("get_font_size", new java.lang.Object[0]);
	}

	public void setFont_size(long value) {
		super.call("set_font_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getOutline_size() {
		return (long) super.call("get_outline_size", new java.lang.Object[0]);
	}

	public void setOutline_size(long value) {
		super.call("set_outline_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getHorizontal_alignment() {
		return (long) super.call("get_horizontal_alignment", new java.lang.Object[0]);
	}

	public void setHorizontal_alignment(long value) {
		super.call("set_horizontal_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getVertical_alignment() {
		return (long) super.call("get_vertical_alignment", new java.lang.Object[0]);
	}

	public void setVertical_alignment(long value) {
		super.call("set_vertical_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isUppercase() {
		return (boolean) super.call("is_uppercase", new java.lang.Object[0]);
	}

	public void setUppercase(boolean value) {
		super.call("set_uppercase", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getLine_spacing() {
		return (double) super.call("get_line_spacing", new java.lang.Object[0]);
	}

	public void setLine_spacing(double value) {
		super.call("set_line_spacing", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getAutowrap_mode() {
		return (long) super.call("get_autowrap_mode", new java.lang.Object[0]);
	}

	public void setAutowrap_mode(long value) {
		super.call("set_autowrap_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getAutowrap_trim_flags() {
		return (long) super.call("get_autowrap_trim_flags", new java.lang.Object[0]);
	}

	public void setAutowrap_trim_flags(long value) {
		super.call("set_autowrap_trim_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getJustification_flags() {
		return (long) super.call("get_justification_flags", new java.lang.Object[0]);
	}

	public void setJustification_flags(long value) {
		super.call("set_justification_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getWidth() {
		return (double) super.call("get_width", new java.lang.Object[0]);
	}

	public void setWidth(double value) {
		super.call("set_width", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getText_direction() {
		return (long) super.call("get_text_direction", new java.lang.Object[0]);
	}

	public void setText_direction(long value) {
		super.call("set_text_direction", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getLanguage() {
		return (String) super.call("get_language", new java.lang.Object[0]);
	}

	public void setLanguage(String value) {
		super.call("set_language", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getStructured_text_bidi_override() {
		return (long) super.call("get_structured_text_bidi_override", new java.lang.Object[0]);
	}

	public void setStructured_text_bidi_override(long value) {
		super.call("set_structured_text_bidi_override", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public GodotArray getStructured_text_bidi_override_options() {
		return (GodotArray) super.call("get_structured_text_bidi_override_options", new java.lang.Object[0]);
	}

	public void setStructured_text_bidi_override_options(GodotArray value) {
		super.call("set_structured_text_bidi_override_options", new java.lang.Object[]{(java.lang.Object) value});
	}
}
