package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Color;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;

public class Font extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_font_weight", 3905245786L), java.util.Map.entry("draw_string", 1976686372L),
			java.util.Map.entry("draw_char", 3500170256L), java.util.Map.entry("has_char", 1116898809L),
			java.util.Map.entry("draw_char_outline", 1684114874L),
			java.util.Map.entry("get_underline_thickness", 378113874L), java.util.Map.entry("get_descent", 378113874L),
			java.util.Map.entry("get_string_size", 1868866121L),
			java.util.Map.entry("get_underline_position", 378113874L), java.util.Map.entry("get_height", 378113874L),
			java.util.Map.entry("get_supported_variation_list", 3102165223L),
			java.util.Map.entry("get_supported_feature_list", 3102165223L),
			java.util.Map.entry("draw_string_outline", 701417663L),
			java.util.Map.entry("get_font_stretch", 3905245786L), java.util.Map.entry("set_fallbacks", 381264803L),
			java.util.Map.entry("get_rids", 3995934104L), java.util.Map.entry("get_face_count", 3905245786L),
			java.util.Map.entry("get_ot_name_strings", 3102165223L),
			java.util.Map.entry("get_multiline_string_size", 519636710L),
			java.util.Map.entry("find_variation", 2553855095L), java.util.Map.entry("get_fallbacks", 3995934104L),
			java.util.Map.entry("get_font_style_name", 201670096L),
			java.util.Map.entry("is_language_supported", 3927539163L),
			java.util.Map.entry("is_script_supported", 3927539163L), java.util.Map.entry("get_ascent", 378113874L),
			java.util.Map.entry("get_opentype_features", 3102165223L),
			java.util.Map.entry("draw_multiline_string_outline", 4147839237L),
			java.util.Map.entry("get_font_name", 201670096L), java.util.Map.entry("draw_multiline_string", 2686601589L),
			java.util.Map.entry("get_char_size", 3016396712L), java.util.Map.entry("get_supported_chars", 201670096L),
			java.util.Map.entry("set_cache_capacity", 3937882851L), java.util.Map.entry("get_spacing", 1310880908L),
			java.util.Map.entry("get_font_style", 2520224254L));

	Font(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Font(long nativePointer) {
		super(nativePointer);
	}

	public long find_variation(GodotDictionary variation_coordinates, long face_index, double strength,
			Transform2D transform, long spacing_top, long spacing_bottom, long spacing_space, long spacing_glyph,
			double baseline_offset) {
		return (long) super.call("find_variation",
				new java.lang.Object[]{(java.lang.Object) variation_coordinates, java.lang.Long.valueOf(face_index),
						java.lang.Double.valueOf(strength), (java.lang.Object) transform,
						java.lang.Long.valueOf(spacing_top), java.lang.Long.valueOf(spacing_bottom),
						java.lang.Long.valueOf(spacing_space), java.lang.Long.valueOf(spacing_glyph),
						java.lang.Double.valueOf(baseline_offset)});
	}

	public double get_height(long font_size) {
		return (double) super.call("get_height", new java.lang.Object[]{java.lang.Long.valueOf(font_size)});
	}

	public double get_ascent(long font_size) {
		return (double) super.call("get_ascent", new java.lang.Object[]{java.lang.Long.valueOf(font_size)});
	}

	public double get_descent(long font_size) {
		return (double) super.call("get_descent", new java.lang.Object[]{java.lang.Long.valueOf(font_size)});
	}

	public double get_underline_position(long font_size) {
		return (double) super.call("get_underline_position", new java.lang.Object[]{java.lang.Long.valueOf(font_size)});
	}

	public double get_underline_thickness(long font_size) {
		return (double) super.call("get_underline_thickness",
				new java.lang.Object[]{java.lang.Long.valueOf(font_size)});
	}

	public int get_spacing(int spacing) {
		return (int) super.call("get_spacing", new java.lang.Object[]{java.lang.Integer.valueOf(spacing)});
	}

	public void set_cache_capacity(long single_line, long multi_line) {
		super.call("set_cache_capacity",
				new java.lang.Object[]{java.lang.Long.valueOf(single_line), java.lang.Long.valueOf(multi_line)});
	}

	public Vector2 get_string_size(String text, int alignment, double width, long font_size, int justification_flags,
			int direction, int orientation) {
		return (Vector2) super.call("get_string_size",
				new java.lang.Object[]{(java.lang.Object) text, java.lang.Integer.valueOf(alignment),
						java.lang.Double.valueOf(width), java.lang.Long.valueOf(font_size),
						java.lang.Integer.valueOf(justification_flags), java.lang.Integer.valueOf(direction),
						java.lang.Integer.valueOf(orientation)});
	}

	public Vector2 get_multiline_string_size(String text, int alignment, double width, long font_size, long max_lines,
			int brk_flags, int justification_flags, int direction, int orientation) {
		return (Vector2) super.call("get_multiline_string_size",
				new java.lang.Object[]{(java.lang.Object) text, java.lang.Integer.valueOf(alignment),
						java.lang.Double.valueOf(width), java.lang.Long.valueOf(font_size),
						java.lang.Long.valueOf(max_lines), java.lang.Integer.valueOf(brk_flags),
						java.lang.Integer.valueOf(justification_flags), java.lang.Integer.valueOf(direction),
						java.lang.Integer.valueOf(orientation)});
	}

	public void draw_string(long canvas_item, Vector2 pos, String text, int alignment, double width, long font_size,
			Color modulate, int justification_flags, int direction, int orientation, double oversampling) {
		super.call("draw_string",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas_item), (java.lang.Object) pos,
						(java.lang.Object) text, java.lang.Integer.valueOf(alignment), java.lang.Double.valueOf(width),
						java.lang.Long.valueOf(font_size), (java.lang.Object) modulate,
						java.lang.Integer.valueOf(justification_flags), java.lang.Integer.valueOf(direction),
						java.lang.Integer.valueOf(orientation), java.lang.Double.valueOf(oversampling)});
	}

	public void draw_multiline_string(long canvas_item, Vector2 pos, String text, int alignment, double width,
			long font_size, long max_lines, Color modulate, int brk_flags, int justification_flags, int direction,
			int orientation, double oversampling) {
		super.call("draw_multiline_string",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas_item), (java.lang.Object) pos,
						(java.lang.Object) text, java.lang.Integer.valueOf(alignment), java.lang.Double.valueOf(width),
						java.lang.Long.valueOf(font_size), java.lang.Long.valueOf(max_lines),
						(java.lang.Object) modulate, java.lang.Integer.valueOf(brk_flags),
						java.lang.Integer.valueOf(justification_flags), java.lang.Integer.valueOf(direction),
						java.lang.Integer.valueOf(orientation), java.lang.Double.valueOf(oversampling)});
	}

	public void draw_string_outline(long canvas_item, Vector2 pos, String text, int alignment, double width,
			long font_size, long size, Color modulate, int justification_flags, int direction, int orientation,
			double oversampling) {
		super.call("draw_string_outline",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas_item), (java.lang.Object) pos,
						(java.lang.Object) text, java.lang.Integer.valueOf(alignment), java.lang.Double.valueOf(width),
						java.lang.Long.valueOf(font_size), java.lang.Long.valueOf(size), (java.lang.Object) modulate,
						java.lang.Integer.valueOf(justification_flags), java.lang.Integer.valueOf(direction),
						java.lang.Integer.valueOf(orientation), java.lang.Double.valueOf(oversampling)});
	}

	public void draw_multiline_string_outline(long canvas_item, Vector2 pos, String text, int alignment, double width,
			long font_size, long max_lines, long size, Color modulate, int brk_flags, int justification_flags,
			int direction, int orientation, double oversampling) {
		super.call("draw_multiline_string_outline",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas_item), (java.lang.Object) pos,
						(java.lang.Object) text, java.lang.Integer.valueOf(alignment), java.lang.Double.valueOf(width),
						java.lang.Long.valueOf(font_size), java.lang.Long.valueOf(max_lines),
						java.lang.Long.valueOf(size), (java.lang.Object) modulate, java.lang.Integer.valueOf(brk_flags),
						java.lang.Integer.valueOf(justification_flags), java.lang.Integer.valueOf(direction),
						java.lang.Integer.valueOf(orientation), java.lang.Double.valueOf(oversampling)});
	}

	public Vector2 get_char_size(long char_, long font_size) {
		return (Vector2) super.call("get_char_size",
				new java.lang.Object[]{java.lang.Long.valueOf(char_), java.lang.Long.valueOf(font_size)});
	}

	public double draw_char(long canvas_item, Vector2 pos, long char_, long font_size, Color modulate,
			double oversampling) {
		return (double) super.call("draw_char",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas_item), (java.lang.Object) pos,
						java.lang.Long.valueOf(char_), java.lang.Long.valueOf(font_size), (java.lang.Object) modulate,
						java.lang.Double.valueOf(oversampling)});
	}

	public double draw_char_outline(long canvas_item, Vector2 pos, long char_, long font_size, long size,
			Color modulate, double oversampling) {
		return (double) super.call("draw_char_outline",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas_item), (java.lang.Object) pos,
						java.lang.Long.valueOf(char_), java.lang.Long.valueOf(font_size), java.lang.Long.valueOf(size),
						(java.lang.Object) modulate, java.lang.Double.valueOf(oversampling)});
	}

	public boolean has_char(long char_) {
		return (boolean) super.call("has_char", new java.lang.Object[]{java.lang.Long.valueOf(char_)});
	}

	public boolean is_language_supported(String language) {
		return (boolean) super.call("is_language_supported", new java.lang.Object[]{(java.lang.Object) language});
	}

	public boolean is_script_supported(String script) {
		return (boolean) super.call("is_script_supported", new java.lang.Object[]{(java.lang.Object) script});
	}

	public Font[] getFallbacks() {
		return (Font[]) super.call("get_fallbacks", new java.lang.Object[0]);
	}

	public void setFallbacks(Font[] value) {
		super.call("set_fallbacks", new java.lang.Object[]{(java.lang.Object) value});
	}
}
