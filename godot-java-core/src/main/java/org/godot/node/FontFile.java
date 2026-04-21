package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Rect2;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class FontFile extends Font {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_oversampling", 1740695150L),
			java.util.Map.entry("set_disable_embedded_bitmaps", 2586408642L),
			java.util.Map.entry("get_texture_image", 3878418953L),
			java.util.Map.entry("get_extra_baseline_offset", 2339986948L),
			java.util.Map.entry("set_font_weight", 1286410249L), java.util.Map.entry("get_generate_mipmaps", 36873697L),
			java.util.Map.entry("get_script_support_override", 3927539163L),
			java.util.Map.entry("clear_cache", 3218959716L),
			java.util.Map.entry("get_language_support_overrides", 1139954409L),
			java.util.Map.entry("set_msdf_size", 1286410249L), java.util.Map.entry("get_glyph_index", 864943070L),
			java.util.Map.entry("set_glyph_size", 921719850L), java.util.Map.entry("set_msdf_pixel_range", 1286410249L),
			java.util.Map.entry("set_generate_mipmaps", 2586408642L),
			java.util.Map.entry("get_language_support_override", 3927539163L),
			java.util.Map.entry("get_glyph_advance", 1601573536L), java.util.Map.entry("set_glyph_advance", 947991729L),
			java.util.Map.entry("set_glyph_offset", 921719850L), java.util.Map.entry("get_data", 2362200018L),
			java.util.Map.entry("set_allow_system_fallback", 2586408642L), java.util.Map.entry("set_data", 2971499966L),
			java.util.Map.entry("set_modulate_color_glyphs", 2586408642L),
			java.util.Map.entry("clear_glyphs", 2311374912L),
			java.util.Map.entry("get_char_from_glyph_index", 3175239445L),
			java.util.Map.entry("set_extra_baseline_offset", 1602489585L),
			java.util.Map.entry("get_antialiasing", 4262718649L),
			java.util.Map.entry("get_msdf_pixel_range", 3905245786L),
			java.util.Map.entry("set_script_support_override", 2678287736L),
			java.util.Map.entry("set_glyph_uv_rect", 3821620992L), java.util.Map.entry("remove_texture", 2328951467L),
			java.util.Map.entry("clear_textures", 2311374912L), java.util.Map.entry("get_kerning_list", 2345056839L),
			java.util.Map.entry("get_cache_count", 3905245786L), java.util.Map.entry("remove_size_cache", 2311374912L),
			java.util.Map.entry("get_glyph_offset", 3205412300L), java.util.Map.entry("remove_glyph", 2328951467L),
			java.util.Map.entry("clear_kerning_map", 3937882851L), java.util.Map.entry("get_cache_scale", 3085491603L),
			java.util.Map.entry("set_transform", 30160968L), java.util.Map.entry("set_hinting", 1827459492L),
			java.util.Map.entry("get_fixed_size", 3905245786L), java.util.Map.entry("get_glyph_uv_rect", 3927917900L),
			java.util.Map.entry("get_opentype_feature_overrides", 3102165223L),
			java.util.Map.entry("get_texture_count", 1987661582L),
			java.util.Map.entry("set_multichannel_signed_distance_field", 2586408642L),
			java.util.Map.entry("set_kerning", 3182200918L), java.util.Map.entry("get_glyph_size", 3205412300L),
			java.util.Map.entry("get_fixed_size_scale_mode", 753873478L),
			java.util.Map.entry("remove_language_support_override", 83702148L),
			java.util.Map.entry("get_face_index", 923996154L), java.util.Map.entry("set_extra_spacing", 62942285L),
			java.util.Map.entry("get_size_cache_list", 663333327L),
			java.util.Map.entry("set_glyph_texture_idx", 355564111L),
			java.util.Map.entry("set_face_index", 3937882851L),
			java.util.Map.entry("get_subpixel_positioning", 1069238588L),
			java.util.Map.entry("get_extra_spacing", 1924257185L), java.util.Map.entry("set_fixed_size", 1286410249L),
			java.util.Map.entry("get_embolden", 2339986948L), java.util.Map.entry("get_glyph_list", 681709689L),
			java.util.Map.entry("get_hinting", 3683214614L),
			java.util.Map.entry("remove_script_support_override", 83702148L),
			java.util.Map.entry("is_allow_system_fallback", 36873697L),
			java.util.Map.entry("load_bitmap_font", 166001499L), java.util.Map.entry("set_oversampling", 373806689L),
			java.util.Map.entry("remove_cache", 1286410249L), java.util.Map.entry("set_font_style_name", 83702148L),
			java.util.Map.entry("get_transform", 3836996910L), java.util.Map.entry("is_force_autohinter", 36873697L),
			java.util.Map.entry("get_cache_underline_thickness", 3085491603L),
			java.util.Map.entry("render_glyph", 2328951467L), java.util.Map.entry("set_texture_offsets", 2849993437L),
			java.util.Map.entry("set_cache_underline_position", 3506521499L),
			java.util.Map.entry("get_texture_offsets", 3703444828L),
			java.util.Map.entry("get_cache_ascent", 3085491603L), java.util.Map.entry("get_kerning", 1611912865L),
			java.util.Map.entry("get_variation_coordinates", 3485342025L),
			java.util.Map.entry("get_cache_underline_position", 3085491603L),
			java.util.Map.entry("set_cache_underline_thickness", 3506521499L),
			java.util.Map.entry("is_modulate_color_glyphs", 36873697L),
			java.util.Map.entry("set_keep_rounding_remainders", 2586408642L),
			java.util.Map.entry("set_embolden", 1602489585L), java.util.Map.entry("set_font_stretch", 1286410249L),
			java.util.Map.entry("set_fixed_size_scale_mode", 1660989956L),
			java.util.Map.entry("set_subpixel_positioning", 4225742182L),
			java.util.Map.entry("set_cache_descent", 3506521499L), java.util.Map.entry("set_font_name", 83702148L),
			java.util.Map.entry("render_range", 355564111L),
			java.util.Map.entry("set_language_support_override", 2678287736L),
			java.util.Map.entry("set_cache_ascent", 3506521499L), java.util.Map.entry("set_antialiasing", 1669900L),
			java.util.Map.entry("set_texture_image", 4157974066L), java.util.Map.entry("set_font_style", 918070724L),
			java.util.Map.entry("get_keep_rounding_remainders", 36873697L),
			java.util.Map.entry("get_msdf_size", 3905245786L), java.util.Map.entry("get_cache_descent", 3085491603L),
			java.util.Map.entry("get_script_support_overrides", 1139954409L),
			java.util.Map.entry("set_force_autohinter", 2586408642L),
			java.util.Map.entry("get_glyph_texture_idx", 1629411054L),
			java.util.Map.entry("remove_kerning", 3930204747L),
			java.util.Map.entry("set_variation_coordinates", 64545446L),
			java.util.Map.entry("get_disable_embedded_bitmaps", 36873697L),
			java.util.Map.entry("is_multichannel_signed_distance_field", 36873697L),
			java.util.Map.entry("set_cache_scale", 3506521499L), java.util.Map.entry("load_dynamic_font", 166001499L),
			java.util.Map.entry("clear_size_cache", 1286410249L),
			java.util.Map.entry("set_opentype_feature_overrides", 4155329257L));

	FontFile(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FontFile(long nativePointer) {
		super(nativePointer);
	}

	public int load_bitmap_font(String path) {
		return (int) super.call("load_bitmap_font", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int load_dynamic_font(String path) {
		return (int) super.call("load_dynamic_font", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean is_multichannel_signed_distance_field() {
		return (boolean) super.call("is_multichannel_signed_distance_field");
	}

	public boolean is_allow_system_fallback() {
		return (boolean) super.call("is_allow_system_fallback");
	}

	public boolean is_force_autohinter() {
		return (boolean) super.call("is_force_autohinter");
	}

	public boolean is_modulate_color_glyphs() {
		return (boolean) super.call("is_modulate_color_glyphs");
	}

	public void clear_cache() {
		super.call("clear_cache");
	}

	public void remove_cache(long cache_index) {
		super.call("remove_cache", new java.lang.Object[]{java.lang.Long.valueOf(cache_index)});
	}

	public Vector2i[] get_size_cache_list(long cache_index) {
		return (Vector2i[]) super.call("get_size_cache_list",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index)});
	}

	public void clear_size_cache(long cache_index) {
		super.call("clear_size_cache", new java.lang.Object[]{java.lang.Long.valueOf(cache_index)});
	}

	public void remove_size_cache(long cache_index, Vector2i size) {
		super.call("remove_size_cache",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), (java.lang.Object) size});
	}

	public void set_variation_coordinates(long cache_index, GodotDictionary variation_coordinates) {
		super.call("set_variation_coordinates",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), (java.lang.Object) variation_coordinates});
	}

	public GodotDictionary get_variation_coordinates(long cache_index) {
		return (GodotDictionary) super.call("get_variation_coordinates",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index)});
	}

	public void set_embolden(long cache_index, double strength) {
		super.call("set_embolden",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), java.lang.Double.valueOf(strength)});
	}

	public double get_embolden(long cache_index) {
		return (double) super.call("get_embolden", new java.lang.Object[]{java.lang.Long.valueOf(cache_index)});
	}

	public void set_transform(long cache_index, Transform2D transform) {
		super.call("set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), (java.lang.Object) transform});
	}

	public Transform2D get_transform(long cache_index) {
		return (Transform2D) super.call("get_transform", new java.lang.Object[]{java.lang.Long.valueOf(cache_index)});
	}

	public void set_extra_spacing(long cache_index, int spacing, long value) {
		super.call("set_extra_spacing", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				java.lang.Integer.valueOf(spacing), java.lang.Long.valueOf(value)});
	}

	public long get_extra_spacing(long cache_index, int spacing) {
		return (long) super.call("get_extra_spacing",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), java.lang.Integer.valueOf(spacing)});
	}

	public void set_extra_baseline_offset(long cache_index, double baseline_offset) {
		super.call("set_extra_baseline_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), java.lang.Double.valueOf(baseline_offset)});
	}

	public double get_extra_baseline_offset(long cache_index) {
		return (double) super.call("get_extra_baseline_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index)});
	}

	public void set_face_index(long cache_index, long face_index) {
		super.call("set_face_index",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), java.lang.Long.valueOf(face_index)});
	}

	public long get_face_index(long cache_index) {
		return (long) super.call("get_face_index", new java.lang.Object[]{java.lang.Long.valueOf(cache_index)});
	}

	public void set_cache_ascent(long cache_index, long size, double ascent) {
		super.call("set_cache_ascent", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				java.lang.Long.valueOf(size), java.lang.Double.valueOf(ascent)});
	}

	public double get_cache_ascent(long cache_index, long size) {
		return (double) super.call("get_cache_ascent",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), java.lang.Long.valueOf(size)});
	}

	public void set_cache_descent(long cache_index, long size, double descent) {
		super.call("set_cache_descent", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				java.lang.Long.valueOf(size), java.lang.Double.valueOf(descent)});
	}

	public double get_cache_descent(long cache_index, long size) {
		return (double) super.call("get_cache_descent",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), java.lang.Long.valueOf(size)});
	}

	public void set_cache_underline_position(long cache_index, long size, double underline_position) {
		super.call("set_cache_underline_position", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				java.lang.Long.valueOf(size), java.lang.Double.valueOf(underline_position)});
	}

	public double get_cache_underline_position(long cache_index, long size) {
		return (double) super.call("get_cache_underline_position",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), java.lang.Long.valueOf(size)});
	}

	public void set_cache_underline_thickness(long cache_index, long size, double underline_thickness) {
		super.call("set_cache_underline_thickness", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				java.lang.Long.valueOf(size), java.lang.Double.valueOf(underline_thickness)});
	}

	public double get_cache_underline_thickness(long cache_index, long size) {
		return (double) super.call("get_cache_underline_thickness",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), java.lang.Long.valueOf(size)});
	}

	public void set_cache_scale(long cache_index, long size, double scale) {
		super.call("set_cache_scale", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				java.lang.Long.valueOf(size), java.lang.Double.valueOf(scale)});
	}

	public double get_cache_scale(long cache_index, long size) {
		return (double) super.call("get_cache_scale",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), java.lang.Long.valueOf(size)});
	}

	public int get_texture_count(long cache_index, Vector2i size) {
		return (int) super.call("get_texture_count",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), (java.lang.Object) size});
	}

	public void clear_textures(long cache_index, Vector2i size) {
		super.call("clear_textures",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), (java.lang.Object) size});
	}

	public void remove_texture(long cache_index, Vector2i size, long texture_index) {
		super.call("remove_texture", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(texture_index)});
	}

	public void set_texture_image(long cache_index, Vector2i size, long texture_index, Image image) {
		super.call("set_texture_image", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(texture_index), (java.lang.Object) image});
	}

	public Image get_texture_image(long cache_index, Vector2i size, long texture_index) {
		return (Image) super.call("get_texture_image", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(texture_index)});
	}

	public void set_texture_offsets(long cache_index, Vector2i size, long texture_index, int[] offset) {
		super.call("set_texture_offsets", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(texture_index), (java.lang.Object) offset});
	}

	public int[] get_texture_offsets(long cache_index, Vector2i size, long texture_index) {
		return (int[]) super.call("get_texture_offsets", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(texture_index)});
	}

	public int[] get_glyph_list(long cache_index, Vector2i size) {
		return (int[]) super.call("get_glyph_list",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), (java.lang.Object) size});
	}

	public void clear_glyphs(long cache_index, Vector2i size) {
		super.call("clear_glyphs",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), (java.lang.Object) size});
	}

	public void remove_glyph(long cache_index, Vector2i size, long glyph) {
		super.call("remove_glyph", new java.lang.Object[]{java.lang.Long.valueOf(cache_index), (java.lang.Object) size,
				java.lang.Long.valueOf(glyph)});
	}

	public void set_glyph_advance(long cache_index, long size, long glyph, Vector2 advance) {
		super.call("set_glyph_advance", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				java.lang.Long.valueOf(size), java.lang.Long.valueOf(glyph), (java.lang.Object) advance});
	}

	public Vector2 get_glyph_advance(long cache_index, long size, long glyph) {
		return (Vector2) super.call("get_glyph_advance", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				java.lang.Long.valueOf(size), java.lang.Long.valueOf(glyph)});
	}

	public void set_glyph_offset(long cache_index, Vector2i size, long glyph, Vector2 offset) {
		super.call("set_glyph_offset", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph), (java.lang.Object) offset});
	}

	public Vector2 get_glyph_offset(long cache_index, Vector2i size, long glyph) {
		return (Vector2) super.call("get_glyph_offset", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph)});
	}

	public void set_glyph_size(long cache_index, Vector2i size, long glyph, Vector2 gl_size) {
		super.call("set_glyph_size", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph), (java.lang.Object) gl_size});
	}

	public Vector2 get_glyph_size(long cache_index, Vector2i size, long glyph) {
		return (Vector2) super.call("get_glyph_size", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph)});
	}

	public void set_glyph_uv_rect(long cache_index, Vector2i size, long glyph, Rect2 uv_rect) {
		super.call("set_glyph_uv_rect", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph), (java.lang.Object) uv_rect});
	}

	public Rect2 get_glyph_uv_rect(long cache_index, Vector2i size, long glyph) {
		return (Rect2) super.call("get_glyph_uv_rect", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph)});
	}

	public void set_glyph_texture_idx(long cache_index, Vector2i size, long glyph, long texture_idx) {
		super.call("set_glyph_texture_idx", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph), java.lang.Long.valueOf(texture_idx)});
	}

	public int get_glyph_texture_idx(long cache_index, Vector2i size, long glyph) {
		return (int) super.call("get_glyph_texture_idx", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph)});
	}

	public Vector2i[] get_kerning_list(long cache_index, long size) {
		return (Vector2i[]) super.call("get_kerning_list",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), java.lang.Long.valueOf(size)});
	}

	public void clear_kerning_map(long cache_index, long size) {
		super.call("clear_kerning_map",
				new java.lang.Object[]{java.lang.Long.valueOf(cache_index), java.lang.Long.valueOf(size)});
	}

	public void remove_kerning(long cache_index, long size, Vector2i glyph_pair) {
		super.call("remove_kerning", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				java.lang.Long.valueOf(size), (java.lang.Object) glyph_pair});
	}

	public void set_kerning(long cache_index, long size, Vector2i glyph_pair, Vector2 kerning) {
		super.call("set_kerning", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				java.lang.Long.valueOf(size), (java.lang.Object) glyph_pair, (java.lang.Object) kerning});
	}

	public Vector2 get_kerning(long cache_index, long size, Vector2i glyph_pair) {
		return (Vector2) super.call("get_kerning", new java.lang.Object[]{java.lang.Long.valueOf(cache_index),
				java.lang.Long.valueOf(size), (java.lang.Object) glyph_pair});
	}

	public void render_range(long cache_index, Vector2i size, long start, long end) {
		super.call("render_range", new java.lang.Object[]{java.lang.Long.valueOf(cache_index), (java.lang.Object) size,
				java.lang.Long.valueOf(start), java.lang.Long.valueOf(end)});
	}

	public void render_glyph(long cache_index, Vector2i size, long index) {
		super.call("render_glyph", new java.lang.Object[]{java.lang.Long.valueOf(cache_index), (java.lang.Object) size,
				java.lang.Long.valueOf(index)});
	}

	public void set_language_support_override(String language, boolean supported) {
		super.call("set_language_support_override",
				new java.lang.Object[]{(java.lang.Object) language, java.lang.Boolean.valueOf(supported)});
	}

	public boolean get_language_support_override(String language) {
		return (boolean) super.call("get_language_support_override",
				new java.lang.Object[]{(java.lang.Object) language});
	}

	public void remove_language_support_override(String language) {
		super.call("remove_language_support_override", new java.lang.Object[]{(java.lang.Object) language});
	}

	public void set_script_support_override(String script, boolean supported) {
		super.call("set_script_support_override",
				new java.lang.Object[]{(java.lang.Object) script, java.lang.Boolean.valueOf(supported)});
	}

	public boolean get_script_support_override(String script) {
		return (boolean) super.call("get_script_support_override", new java.lang.Object[]{(java.lang.Object) script});
	}

	public void remove_script_support_override(String script) {
		super.call("remove_script_support_override", new java.lang.Object[]{(java.lang.Object) script});
	}

	public int get_glyph_index(long size, long char_, long variation_selector) {
		return (int) super.call("get_glyph_index", new java.lang.Object[]{java.lang.Long.valueOf(size),
				java.lang.Long.valueOf(char_), java.lang.Long.valueOf(variation_selector)});
	}

	public long get_char_from_glyph_index(long size, long glyph_index) {
		return (long) super.call("get_char_from_glyph_index",
				new java.lang.Object[]{java.lang.Long.valueOf(size), java.lang.Long.valueOf(glyph_index)});
	}

	public byte[] getData() {
		return (byte[]) super.call("get_data", new java.lang.Object[0]);
	}

	public void setData(byte[] value) {
		super.call("set_data", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getGenerate_mipmaps() {
		return (boolean) super.call("get_generate_mipmaps", new java.lang.Object[0]);
	}

	public void setGenerate_mipmaps(boolean value) {
		super.call("set_generate_mipmaps", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDisable_embedded_bitmaps() {
		return (boolean) super.call("get_disable_embedded_bitmaps", new java.lang.Object[0]);
	}

	public void setDisable_embedded_bitmaps(boolean value) {
		super.call("set_disable_embedded_bitmaps", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getAntialiasing() {
		return (long) super.call("get_antialiasing", new java.lang.Object[0]);
	}

	public void setAntialiasing(long value) {
		super.call("set_antialiasing", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getFont_name() {
		return (String) super.call("get_font_name", new java.lang.Object[0]);
	}

	public void setFont_name(String value) {
		super.call("set_font_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getStyle_name() {
		return (String) super.call("get_font_style_name", new java.lang.Object[0]);
	}

	public void setStyle_name(String value) {
		super.call("set_font_style_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getFont_style() {
		return (long) super.call("get_font_style", new java.lang.Object[0]);
	}

	public void setFont_style(long value) {
		super.call("set_font_style", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFont_weight() {
		return (long) super.call("get_font_weight", new java.lang.Object[0]);
	}

	public void setFont_weight(long value) {
		super.call("set_font_weight", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFont_stretch() {
		return (long) super.call("get_font_stretch", new java.lang.Object[0]);
	}

	public void setFont_stretch(long value) {
		super.call("set_font_stretch", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSubpixel_positioning() {
		return (long) super.call("get_subpixel_positioning", new java.lang.Object[0]);
	}

	public void setSubpixel_positioning(long value) {
		super.call("set_subpixel_positioning", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getKeep_rounding_remainders() {
		return (boolean) super.call("get_keep_rounding_remainders", new java.lang.Object[0]);
	}

	public void setKeep_rounding_remainders(boolean value) {
		super.call("set_keep_rounding_remainders", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isMultichannel_signed_distance_field() {
		return (boolean) super.call("is_multichannel_signed_distance_field", new java.lang.Object[0]);
	}

	public void setMultichannel_signed_distance_field(boolean value) {
		super.call("set_multichannel_signed_distance_field", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getMsdf_pixel_range() {
		return (long) super.call("get_msdf_pixel_range", new java.lang.Object[0]);
	}

	public void setMsdf_pixel_range(long value) {
		super.call("set_msdf_pixel_range", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMsdf_size() {
		return (long) super.call("get_msdf_size", new java.lang.Object[0]);
	}

	public void setMsdf_size(long value) {
		super.call("set_msdf_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isAllow_system_fallback() {
		return (boolean) super.call("is_allow_system_fallback", new java.lang.Object[0]);
	}

	public void setAllow_system_fallback(boolean value) {
		super.call("set_allow_system_fallback", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isForce_autohinter() {
		return (boolean) super.call("is_force_autohinter", new java.lang.Object[0]);
	}

	public void setForce_autohinter(boolean value) {
		super.call("set_force_autohinter", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isModulate_color_glyphs() {
		return (boolean) super.call("is_modulate_color_glyphs", new java.lang.Object[0]);
	}

	public void setModulate_color_glyphs(boolean value) {
		super.call("set_modulate_color_glyphs", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getHinting() {
		return (long) super.call("get_hinting", new java.lang.Object[0]);
	}

	public void setHinting(long value) {
		super.call("set_hinting", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFixed_size() {
		return (long) super.call("get_fixed_size", new java.lang.Object[0]);
	}

	public void setFixed_size(long value) {
		super.call("set_fixed_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFixed_size_scale_mode() {
		return (long) super.call("get_fixed_size_scale_mode", new java.lang.Object[0]);
	}

	public void setFixed_size_scale_mode(long value) {
		super.call("set_fixed_size_scale_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public GodotDictionary getOpentype_feature_overrides() {
		return (GodotDictionary) super.call("get_opentype_feature_overrides", new java.lang.Object[0]);
	}

	public void setOpentype_feature_overrides(GodotDictionary value) {
		super.call("set_opentype_feature_overrides", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getOversampling() {
		return (double) super.call("get_oversampling", new java.lang.Object[0]);
	}

	public void setOversampling(double value) {
		super.call("set_oversampling", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
