package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.core.RefCounted;
import org.godot.math.Color;
import org.godot.math.Rect2;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;
import org.godot.math.Vector3i;

public class TextServer extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("font_set_descent", 1892459533L),
			java.util.Map.entry("shaped_text_get_glyphs", 2684255073L),
			java.util.Map.entry("shaped_text_get_line_breaks_adv", 2376991424L),
			java.util.Map.entry("string_to_title", 2664628024L),
			java.util.Map.entry("font_is_modulate_color_glyphs", 4155700596L),
			java.util.Map.entry("shaped_text_get_spacing", 1213653558L),
			java.util.Map.entry("font_set_kerning", 3630965883L),
			java.util.Map.entry("shaped_text_set_bidi_override", 684822712L),
			java.util.Map.entry("shaped_text_get_ellipsis_pos", 2198884583L),
			java.util.Map.entry("font_get_spacing", 1213653558L),
			java.util.Map.entry("shaped_get_run_font_rid", 1066463050L), java.util.Map.entry("get_name", 201670096L),
			java.util.Map.entry("font_get_ot_name_strings", 1882737106L),
			java.util.Map.entry("shaped_text_get_carets", 1574219346L),
			java.util.Map.entry("shaped_get_run_range", 4069534484L),
			java.util.Map.entry("font_get_language_support_overrides", 2801473409L),
			java.util.Map.entry("get_support_data", 2362200018L),
			java.util.Map.entry("shaped_text_set_preserve_invalid", 1265174801L),
			java.util.Map.entry("font_is_allow_system_fallback", 4155700596L),
			java.util.Map.entry("shaped_text_get_grapheme_bounds", 2546185844L),
			java.util.Map.entry("percent_sign", 993269549L),
			java.util.Map.entry("font_set_texture_offsets", 3005398047L),
			java.util.Map.entry("shaped_text_set_direction", 1551430183L),
			java.util.Map.entry("shaped_text_get_trim_pos", 2198884583L),
			java.util.Map.entry("shaped_text_get_ascent", 866169185L),
			java.util.Map.entry("shaped_get_span_count", 2198884583L),
			java.util.Map.entry("font_has_char", 3120086654L), java.util.Map.entry("font_set_spacing", 1307259930L),
			java.util.Map.entry("font_get_kerning", 1019980169L),
			java.util.Map.entry("shaped_text_get_underline_thickness", 866169185L),
			java.util.Map.entry("shaped_set_span_update_font", 2022725822L),
			java.util.Map.entry("font_set_style", 898466325L),
			java.util.Map.entry("font_get_baseline_offset", 866169185L),
			java.util.Map.entry("font_set_force_autohinter", 1265174801L),
			java.util.Map.entry("font_is_language_supported", 3199320846L),
			java.util.Map.entry("shaped_text_has_object", 2360964694L),
			java.util.Map.entry("font_set_script_support_override", 2313957094L),
			java.util.Map.entry("string_to_upper", 2664628024L),
			java.util.Map.entry("shaped_get_run_font_size", 1120910005L),
			java.util.Map.entry("parse_structured_text", 3310685015L),
			java.util.Map.entry("shaped_text_add_object", 3664424789L),
			java.util.Map.entry("font_set_generate_mipmaps", 1265174801L),
			java.util.Map.entry("shaped_get_run_object", 4069510997L),
			java.util.Map.entry("font_set_antialiasing", 958337235L),
			java.util.Map.entry("font_get_weight", 2198884583L),
			java.util.Map.entry("font_set_allow_system_fallback", 1265174801L),
			java.util.Map.entry("font_get_glyph_texture_idx", 4292800474L),
			java.util.Map.entry("shaped_text_get_custom_punctuation", 642473191L),
			java.util.Map.entry("font_set_weight", 3411492887L),
			java.util.Map.entry("get_support_data_filename", 201670096L),
			java.util.Map.entry("shaped_text_closest_character_pos", 1120910005L),
			java.util.Map.entry("shaped_text_get_ellipsis_glyphs", 2684255073L),
			java.util.Map.entry("shaped_text_get_descent", 866169185L),
			java.util.Map.entry("font_render_glyph", 3810512262L),
			java.util.Map.entry("font_get_supported_glyphs", 788230395L),
			java.util.Map.entry("shaped_text_get_underline_position", 866169185L),
			java.util.Map.entry("font_set_modulate_color_glyphs", 1265174801L),
			java.util.Map.entry("font_get_language_support_override", 2829184646L),
			java.util.Map.entry("tag_to_name", 844755477L),
			java.util.Map.entry("font_get_global_oversampling", 1740695150L),
			java.util.Map.entry("draw_hex_code_box", 1602046441L),
			java.util.Map.entry("shaped_text_get_object_range", 2524675647L),
			java.util.Map.entry("shaped_text_set_preserve_control", 1265174801L),
			java.util.Map.entry("font_get_style_name", 642473191L),
			java.util.Map.entry("font_set_underline_position", 1892459533L), java.util.Map.entry("has", 3521089500L),
			java.util.Map.entry("shaped_get_span_text", 1464764419L),
			java.util.Map.entry("font_clear_textures", 2450610377L),
			java.util.Map.entry("font_set_multichannel_signed_distance_field", 1265174801L),
			java.util.Map.entry("shaped_text_get_word_breaks", 4099476853L),
			java.util.Map.entry("shaped_text_get_orientation", 3142708106L),
			java.util.Map.entry("shaped_text_resize_object", 790361552L),
			java.util.Map.entry("font_set_baseline_offset", 1794382983L),
			java.util.Map.entry("font_render_range", 4254580980L),
			java.util.Map.entry("is_locale_right_to_left", 3927539163L),
			java.util.Map.entry("shaped_text_get_custom_ellipsis", 2198884583L),
			java.util.Map.entry("font_get_msdf_pixel_range", 2198884583L),
			java.util.Map.entry("is_valid_identifier", 3927539163L),
			java.util.Map.entry("shaped_text_next_grapheme_pos", 1120910005L),
			java.util.Map.entry("font_supported_feature_list", 1882737106L),
			java.util.Map.entry("font_set_global_oversampling", 373806689L),
			java.util.Map.entry("name_to_tag", 1321353865L),
			java.util.Map.entry("font_get_glyph_texture_rid", 1451696141L),
			java.util.Map.entry("font_set_msdf_pixel_range", 3411492887L),
			java.util.Map.entry("font_get_supported_chars", 642473191L),
			java.util.Map.entry("font_get_disable_embedded_bitmaps", 4155700596L),
			java.util.Map.entry("font_get_glyph_size", 513728628L),
			java.util.Map.entry("font_set_variation_coordinates", 1217542888L),
			java.util.Map.entry("font_get_face_index", 2198884583L),
			java.util.Map.entry("font_set_stretch", 3411492887L),
			java.util.Map.entry("shaped_text_get_width", 866169185L),
			java.util.Map.entry("get_support_data_info", 201670096L),
			java.util.Map.entry("font_set_scale", 1892459533L),
			java.util.Map.entry("font_get_glyph_texture_size", 513728628L),
			java.util.Map.entry("shaped_get_run_text", 1464764419L), java.util.Map.entry("font_set_data", 1355495400L),
			java.util.Map.entry("font_set_face_index", 3411492887L),
			java.util.Map.entry("shaped_get_run_language", 1464764419L),
			java.util.Map.entry("font_set_glyph_offset", 1812632090L),
			java.util.Map.entry("string_get_word_breaks", 581857818L),
			java.util.Map.entry("font_get_underline_position", 755457166L),
			java.util.Map.entry("shaped_get_span_embedded_object", 4069510997L),
			java.util.Map.entry("font_draw_glyph", 3103234926L),
			java.util.Map.entry("shaped_get_run_glyph_range", 4069534484L),
			java.util.Map.entry("font_clear_system_fallback_cache", 3218959716L),
			java.util.Map.entry("font_get_texture_count", 1311001310L),
			java.util.Map.entry("font_set_disable_embedded_bitmaps", 1265174801L),
			java.util.Map.entry("font_clear_glyphs", 2450610377L), java.util.Map.entry("free_rid", 2722037293L),
			java.util.Map.entry("font_get_face_count", 2198884583L),
			java.util.Map.entry("font_set_style_name", 2726140452L),
			java.util.Map.entry("font_supported_variation_list", 1882737106L),
			java.util.Map.entry("font_draw_glyph_outline", 1976041553L),
			java.util.Map.entry("shaped_text_has_visible_chars", 4155700596L),
			java.util.Map.entry("font_get_underline_thickness", 755457166L),
			java.util.Map.entry("font_set_glyph_size", 1812632090L),
			java.util.Map.entry("font_get_subpixel_positioning", 2752233671L),
			java.util.Map.entry("font_get_char_from_glyph_index", 2156738276L),
			java.util.Map.entry("font_set_ascent", 1892459533L), java.util.Map.entry("spoof_check", 3927539163L),
			java.util.Map.entry("shaped_text_prev_character_pos", 1120910005L),
			java.util.Map.entry("shaped_text_is_ready", 4155700596L),
			java.util.Map.entry("shaped_text_hit_test_position", 3149310417L),
			java.util.Map.entry("font_get_msdf_size", 2198884583L),
			java.util.Map.entry("font_is_script_supported", 3199320846L),
			java.util.Map.entry("font_get_variation_coordinates", 1882737106L),
			java.util.Map.entry("get_features", 3905245786L),
			java.util.Map.entry("is_locale_using_support_data", 3927539163L),
			java.util.Map.entry("shaped_text_clear", 2722037293L),
			java.util.Map.entry("shaped_get_run_direction", 2413896864L),
			java.util.Map.entry("font_set_msdf_size", 3411492887L),
			java.util.Map.entry("font_get_stretch", 2198884583L),
			java.util.Map.entry("font_get_glyph_index", 1765635060L),
			java.util.Map.entry("shaped_text_hit_test_grapheme", 3149310417L),
			java.util.Map.entry("shaped_text_get_glyph_count", 2198884583L),
			java.util.Map.entry("font_set_transform", 1246044741L),
			java.util.Map.entry("font_get_glyph_list", 46086620L),
			java.util.Map.entry("shaped_get_span_object", 4069510997L),
			java.util.Map.entry("shaped_text_get_selection", 3714187733L),
			java.util.Map.entry("font_remove_kerning", 2141860016L), java.util.Map.entry("parse_number", 2664628024L),
			java.util.Map.entry("font_get_style", 3082502592L),
			java.util.Map.entry("shaped_text_get_parent", 3814569979L),
			java.util.Map.entry("font_remove_language_support_override", 2726140452L),
			java.util.Map.entry("get_hex_code_box_size", 3016396712L),
			java.util.Map.entry("shaped_text_get_character_breaks", 788230395L),
			java.util.Map.entry("string_to_lower", 2664628024L),
			java.util.Map.entry("font_get_fixed_size_scale_mode", 4113120379L),
			java.util.Map.entry("font_set_hinting", 1520010864L),
			java.util.Map.entry("shaped_text_get_line_breaks", 2651359741L),
			java.util.Map.entry("font_set_oversampling", 1794382983L), java.util.Map.entry("create_font", 529393457L),
			java.util.Map.entry("font_get_texture_offsets", 3420028887L),
			java.util.Map.entry("shaped_text_prev_grapheme_pos", 1120910005L),
			java.util.Map.entry("font_get_name", 642473191L),
			java.util.Map.entry("font_get_script_support_override", 2829184646L),
			java.util.Map.entry("shaped_text_get_object_glyph", 1260085030L),
			java.util.Map.entry("font_get_hinting", 3971592737L),
			java.util.Map.entry("shaped_text_get_preserve_invalid", 4155700596L),
			java.util.Map.entry("shaped_text_draw_outline", 1217146601L),
			java.util.Map.entry("font_get_opentype_feature_overrides", 1882737106L),
			java.util.Map.entry("shaped_text_get_preserve_control", 4155700596L),
			java.util.Map.entry("shaped_text_get_ellipsis_glyph_count", 2198884583L),
			java.util.Map.entry("shaped_text_overrun_trim_to_width", 2723146520L),
			java.util.Map.entry("font_is_force_autohinter", 4155700596L),
			java.util.Map.entry("font_get_keep_rounding_remainders", 4155700596L),
			java.util.Map.entry("font_get_transform", 213527486L),
			java.util.Map.entry("font_set_language_support_override", 2313957094L),
			java.util.Map.entry("font_set_texture_image", 2354485091L),
			java.util.Map.entry("font_get_embolden", 866169185L),
			java.util.Map.entry("font_get_script_support_overrides", 2801473409L),
			java.util.Map.entry("font_set_glyph_texture_idx", 4254580980L),
			java.util.Map.entry("save_support_data", 3927539163L),
			java.util.Map.entry("font_clear_size_cache", 2722037293L),
			java.util.Map.entry("shaped_text_draw", 1647687596L),
			java.util.Map.entry("shaped_text_next_character_pos", 1120910005L),
			java.util.Map.entry("shaped_text_duplicate", 41030802L),
			java.util.Map.entry("font_set_subpixel_positioning", 3830459669L),
			java.util.Map.entry("is_confusable", 1433197768L),
			java.util.Map.entry("shaped_text_get_object_rect", 447978354L),
			java.util.Map.entry("font_set_fixed_size_scale_mode", 1029390307L),
			java.util.Map.entry("shaped_get_text", 642473191L), java.util.Map.entry("font_remove_texture", 3810512262L),
			java.util.Map.entry("shaped_get_run_count", 2198884583L),
			java.util.Map.entry("shaped_text_get_range", 733700038L),
			java.util.Map.entry("font_is_multichannel_signed_distance_field", 4155700596L),
			java.util.Map.entry("format_number", 2664628024L), java.util.Map.entry("font_get_scale", 755457166L),
			java.util.Map.entry("font_get_oversampling", 866169185L),
			java.util.Map.entry("shaped_text_substr", 1937682086L),
			java.util.Map.entry("create_shaped_text", 1231398698L),
			java.util.Map.entry("shaped_text_get_inferred_direction", 3065904362L),
			java.util.Map.entry("font_remove_script_support_override", 2726140452L),
			java.util.Map.entry("shaped_text_shape", 3521089500L),
			java.util.Map.entry("font_remove_glyph", 3810512262L),
			java.util.Map.entry("shaped_text_fit_to_width", 530670926L),
			java.util.Map.entry("font_get_texture_image", 2451761155L),
			java.util.Map.entry("font_clear_kerning_map", 3411492887L),
			java.util.Map.entry("font_get_ascent", 755457166L),
			java.util.Map.entry("shaped_text_tab_align", 1283669550L),
			java.util.Map.entry("font_set_underline_thickness", 1892459533L),
			java.util.Map.entry("string_get_character_breaks", 2333794773L),
			java.util.Map.entry("font_get_generate_mipmaps", 4155700596L),
			java.util.Map.entry("shaped_text_set_custom_ellipsis", 3411492887L),
			java.util.Map.entry("strip_diacritics", 3135753539L),
			java.util.Map.entry("font_get_glyph_offset", 513728628L),
			java.util.Map.entry("font_get_size_cache_list", 2684255073L),
			java.util.Map.entry("font_set_name", 2726140452L), java.util.Map.entry("font_set_embolden", 1794382983L),
			java.util.Map.entry("shaped_get_span_meta", 4069510997L),
			java.util.Map.entry("font_set_glyph_advance", 3219397315L),
			java.util.Map.entry("font_get_size_cache_info", 2684255073L),
			java.util.Map.entry("font_get_glyph_advance", 2555689501L),
			java.util.Map.entry("font_get_glyph_contours", 2903964473L),
			java.util.Map.entry("shaped_text_get_dominant_direction_in_range", 3326907668L),
			java.util.Map.entry("shaped_text_sort_logical", 2670461153L),
			java.util.Map.entry("font_get_kerning_list", 1778388067L),
			java.util.Map.entry("shaped_text_set_spacing", 1307259930L),
			java.util.Map.entry("font_get_descent", 755457166L),
			java.util.Map.entry("shaped_text_get_direction", 3065904362L),
			java.util.Map.entry("font_get_fixed_size", 2198884583L),
			java.util.Map.entry("shaped_text_set_custom_punctuation", 2726140452L),
			java.util.Map.entry("font_get_antialiasing", 3389420495L),
			java.util.Map.entry("shaped_text_get_objects", 2684255073L),
			java.util.Map.entry("create_font_linked_variation", 41030802L),
			java.util.Map.entry("font_remove_size_cache", 2450610377L),
			java.util.Map.entry("font_set_opentype_feature_overrides", 1217542888L),
			java.util.Map.entry("load_support_data", 2323990056L),
			java.util.Map.entry("shaped_text_set_orientation", 3019609126L),
			java.util.Map.entry("font_set_keep_rounding_remainders", 1265174801L),
			java.util.Map.entry("is_valid_letter", 1116898809L),
			java.util.Map.entry("font_set_glyph_uv_rect", 1973324081L),
			java.util.Map.entry("font_get_glyph_uv_rect", 2274268786L),
			java.util.Map.entry("shaped_text_add_string", 623473029L),
			java.util.Map.entry("shaped_text_get_size", 2440833711L),
			java.util.Map.entry("font_set_fixed_size", 3411492887L), java.util.Map.entry("has_feature", 3967367083L));

	TextServer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextServer(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_feature(int feature) {
		return (boolean) super.call("has_feature", new java.lang.Object[]{java.lang.Integer.valueOf(feature)});
	}

	public boolean load_support_data(String filename) {
		return (boolean) super.call("load_support_data", new java.lang.Object[]{(java.lang.Object) filename});
	}

	public boolean save_support_data(String filename) {
		return (boolean) super.call("save_support_data", new java.lang.Object[]{(java.lang.Object) filename});
	}

	public boolean is_locale_using_support_data(String locale) {
		return (boolean) super.call("is_locale_using_support_data", new java.lang.Object[]{(java.lang.Object) locale});
	}

	public boolean is_locale_right_to_left(String locale) {
		return (boolean) super.call("is_locale_right_to_left", new java.lang.Object[]{(java.lang.Object) locale});
	}

	public long name_to_tag(String name) {
		return (long) super.call("name_to_tag", new java.lang.Object[]{(java.lang.Object) name});
	}

	public String tag_to_name(long tag) {
		return (String) super.call("tag_to_name", new java.lang.Object[]{java.lang.Long.valueOf(tag)});
	}

	public boolean has(long rid) {
		return (boolean) super.call("has", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public void free_rid(long rid) {
		super.call("free_rid", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public long create_font() {
		return (long) super.call("create_font");
	}

	public long create_font_linked_variation(long font_rid) {
		return (long) super.call("create_font_linked_variation",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_data(long font_rid, byte[] data) {
		super.call("font_set_data", new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) data});
	}

	public void font_set_face_index(long font_rid, long face_index) {
		super.call("font_set_face_index",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(face_index)});
	}

	public long font_get_face_index(long font_rid) {
		return (long) super.call("font_get_face_index", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public long font_get_face_count(long font_rid) {
		return (long) super.call("font_get_face_count", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_style(long font_rid, int style) {
		super.call("font_set_style",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Integer.valueOf(style)});
	}

	public int font_get_style(long font_rid) {
		return (int) super.call("font_get_style", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_name(long font_rid, String name) {
		super.call("font_set_name", new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) name});
	}

	public String font_get_name(long font_rid) {
		return (String) super.call("font_get_name", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public GodotDictionary font_get_ot_name_strings(long font_rid) {
		return (GodotDictionary) super.call("font_get_ot_name_strings",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_style_name(long font_rid, String name) {
		super.call("font_set_style_name",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) name});
	}

	public String font_get_style_name(long font_rid) {
		return (String) super.call("font_get_style_name", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_weight(long font_rid, long weight) {
		super.call("font_set_weight",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(weight)});
	}

	public long font_get_weight(long font_rid) {
		return (long) super.call("font_get_weight", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_stretch(long font_rid, long weight) {
		super.call("font_set_stretch",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(weight)});
	}

	public long font_get_stretch(long font_rid) {
		return (long) super.call("font_get_stretch", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_antialiasing(long font_rid, int antialiasing) {
		super.call("font_set_antialiasing",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Integer.valueOf(antialiasing)});
	}

	public int font_get_antialiasing(long font_rid) {
		return (int) super.call("font_get_antialiasing", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_disable_embedded_bitmaps(long font_rid, boolean disable_embedded_bitmaps) {
		super.call("font_set_disable_embedded_bitmaps", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Boolean.valueOf(disable_embedded_bitmaps)});
	}

	public boolean font_get_disable_embedded_bitmaps(long font_rid) {
		return (boolean) super.call("font_get_disable_embedded_bitmaps",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_generate_mipmaps(long font_rid, boolean generate_mipmaps) {
		super.call("font_set_generate_mipmaps",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Boolean.valueOf(generate_mipmaps)});
	}

	public boolean font_get_generate_mipmaps(long font_rid) {
		return (boolean) super.call("font_get_generate_mipmaps",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_multichannel_signed_distance_field(long font_rid, boolean msdf) {
		super.call("font_set_multichannel_signed_distance_field",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Boolean.valueOf(msdf)});
	}

	public boolean font_is_multichannel_signed_distance_field(long font_rid) {
		return (boolean) super.call("font_is_multichannel_signed_distance_field",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_msdf_pixel_range(long font_rid, long msdf_pixel_range) {
		super.call("font_set_msdf_pixel_range",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(msdf_pixel_range)});
	}

	public long font_get_msdf_pixel_range(long font_rid) {
		return (long) super.call("font_get_msdf_pixel_range", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_msdf_size(long font_rid, long msdf_size) {
		super.call("font_set_msdf_size",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(msdf_size)});
	}

	public long font_get_msdf_size(long font_rid) {
		return (long) super.call("font_get_msdf_size", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_fixed_size(long font_rid, long fixed_size) {
		super.call("font_set_fixed_size",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(fixed_size)});
	}

	public long font_get_fixed_size(long font_rid) {
		return (long) super.call("font_get_fixed_size", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_fixed_size_scale_mode(long font_rid, int fixed_size_scale_mode) {
		super.call("font_set_fixed_size_scale_mode", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Integer.valueOf(fixed_size_scale_mode)});
	}

	public int font_get_fixed_size_scale_mode(long font_rid) {
		return (int) super.call("font_get_fixed_size_scale_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_allow_system_fallback(long font_rid, boolean allow_system_fallback) {
		super.call("font_set_allow_system_fallback", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Boolean.valueOf(allow_system_fallback)});
	}

	public boolean font_is_allow_system_fallback(long font_rid) {
		return (boolean) super.call("font_is_allow_system_fallback",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_clear_system_fallback_cache() {
		super.call("font_clear_system_fallback_cache");
	}

	public void font_set_force_autohinter(long font_rid, boolean force_autohinter) {
		super.call("font_set_force_autohinter",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Boolean.valueOf(force_autohinter)});
	}

	public boolean font_is_force_autohinter(long font_rid) {
		return (boolean) super.call("font_is_force_autohinter",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_modulate_color_glyphs(long font_rid, boolean force_autohinter) {
		super.call("font_set_modulate_color_glyphs",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Boolean.valueOf(force_autohinter)});
	}

	public boolean font_is_modulate_color_glyphs(long font_rid) {
		return (boolean) super.call("font_is_modulate_color_glyphs",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_hinting(long font_rid, int hinting) {
		super.call("font_set_hinting",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Integer.valueOf(hinting)});
	}

	public int font_get_hinting(long font_rid) {
		return (int) super.call("font_get_hinting", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_subpixel_positioning(long font_rid, int subpixel_positioning) {
		super.call("font_set_subpixel_positioning", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Integer.valueOf(subpixel_positioning)});
	}

	public int font_get_subpixel_positioning(long font_rid) {
		return (int) super.call("font_get_subpixel_positioning",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_keep_rounding_remainders(long font_rid, boolean keep_rounding_remainders) {
		super.call("font_set_keep_rounding_remainders", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Boolean.valueOf(keep_rounding_remainders)});
	}

	public boolean font_get_keep_rounding_remainders(long font_rid) {
		return (boolean) super.call("font_get_keep_rounding_remainders",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_embolden(long font_rid, double strength) {
		super.call("font_set_embolden",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Double.valueOf(strength)});
	}

	public double font_get_embolden(long font_rid) {
		return (double) super.call("font_get_embolden", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_spacing(long font_rid, int spacing, long value) {
		super.call("font_set_spacing", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Integer.valueOf(spacing), java.lang.Long.valueOf(value)});
	}

	public long font_get_spacing(long font_rid, int spacing) {
		return (long) super.call("font_get_spacing",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Integer.valueOf(spacing)});
	}

	public void font_set_baseline_offset(long font_rid, double baseline_offset) {
		super.call("font_set_baseline_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Double.valueOf(baseline_offset)});
	}

	public double font_get_baseline_offset(long font_rid) {
		return (double) super.call("font_get_baseline_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_transform(long font_rid, Transform2D transform) {
		super.call("font_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) transform});
	}

	public Transform2D font_get_transform(long font_rid) {
		return (Transform2D) super.call("font_get_transform", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_variation_coordinates(long font_rid, GodotDictionary variation_coordinates) {
		super.call("font_set_variation_coordinates",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) variation_coordinates});
	}

	public GodotDictionary font_get_variation_coordinates(long font_rid) {
		return (GodotDictionary) super.call("font_get_variation_coordinates",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_oversampling(long font_rid, double oversampling) {
		super.call("font_set_oversampling",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Double.valueOf(oversampling)});
	}

	public double font_get_oversampling(long font_rid) {
		return (double) super.call("font_get_oversampling", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public Vector2i[] font_get_size_cache_list(long font_rid) {
		return (Vector2i[]) super.call("font_get_size_cache_list",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_clear_size_cache(long font_rid) {
		super.call("font_clear_size_cache", new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_remove_size_cache(long font_rid, Vector2i size) {
		super.call("font_remove_size_cache",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) size});
	}

	public GodotDictionary[] font_get_size_cache_info(long font_rid) {
		return (GodotDictionary[]) super.call("font_get_size_cache_info",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_ascent(long font_rid, long size, double ascent) {
		super.call("font_set_ascent", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Long.valueOf(size), java.lang.Double.valueOf(ascent)});
	}

	public double font_get_ascent(long font_rid, long size) {
		return (double) super.call("font_get_ascent",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(size)});
	}

	public void font_set_descent(long font_rid, long size, double descent) {
		super.call("font_set_descent", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Long.valueOf(size), java.lang.Double.valueOf(descent)});
	}

	public double font_get_descent(long font_rid, long size) {
		return (double) super.call("font_get_descent",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(size)});
	}

	public void font_set_underline_position(long font_rid, long size, double underline_position) {
		super.call("font_set_underline_position", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Long.valueOf(size), java.lang.Double.valueOf(underline_position)});
	}

	public double font_get_underline_position(long font_rid, long size) {
		return (double) super.call("font_get_underline_position",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(size)});
	}

	public void font_set_underline_thickness(long font_rid, long size, double underline_thickness) {
		super.call("font_set_underline_thickness", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Long.valueOf(size), java.lang.Double.valueOf(underline_thickness)});
	}

	public double font_get_underline_thickness(long font_rid, long size) {
		return (double) super.call("font_get_underline_thickness",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(size)});
	}

	public void font_set_scale(long font_rid, long size, double scale) {
		super.call("font_set_scale", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Long.valueOf(size), java.lang.Double.valueOf(scale)});
	}

	public double font_get_scale(long font_rid, long size) {
		return (double) super.call("font_get_scale",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(size)});
	}

	public long font_get_texture_count(long font_rid, Vector2i size) {
		return (long) super.call("font_get_texture_count",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) size});
	}

	public void font_clear_textures(long font_rid, Vector2i size) {
		super.call("font_clear_textures",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) size});
	}

	public void font_remove_texture(long font_rid, Vector2i size, long texture_index) {
		super.call("font_remove_texture", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(texture_index)});
	}

	public void font_set_texture_image(long font_rid, Vector2i size, long texture_index, Image image) {
		super.call("font_set_texture_image", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(texture_index), (java.lang.Object) image});
	}

	public Image font_get_texture_image(long font_rid, Vector2i size, long texture_index) {
		return (Image) super.call("font_get_texture_image", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(texture_index)});
	}

	public void font_set_texture_offsets(long font_rid, Vector2i size, long texture_index, int[] offset) {
		super.call("font_set_texture_offsets", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(texture_index), (java.lang.Object) offset});
	}

	public int[] font_get_texture_offsets(long font_rid, Vector2i size, long texture_index) {
		return (int[]) super.call("font_get_texture_offsets", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(texture_index)});
	}

	public int[] font_get_glyph_list(long font_rid, Vector2i size) {
		return (int[]) super.call("font_get_glyph_list",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) size});
	}

	public void font_clear_glyphs(long font_rid, Vector2i size) {
		super.call("font_clear_glyphs",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) size});
	}

	public void font_remove_glyph(long font_rid, Vector2i size, long glyph) {
		super.call("font_remove_glyph", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph)});
	}

	public Vector2 font_get_glyph_advance(long font_rid, long size, long glyph) {
		return (Vector2) super.call("font_get_glyph_advance", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Long.valueOf(size), java.lang.Long.valueOf(glyph)});
	}

	public void font_set_glyph_advance(long font_rid, long size, long glyph, Vector2 advance) {
		super.call("font_set_glyph_advance", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Long.valueOf(size), java.lang.Long.valueOf(glyph), (java.lang.Object) advance});
	}

	public Vector2 font_get_glyph_offset(long font_rid, Vector2i size, long glyph) {
		return (Vector2) super.call("font_get_glyph_offset", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph)});
	}

	public void font_set_glyph_offset(long font_rid, Vector2i size, long glyph, Vector2 offset) {
		super.call("font_set_glyph_offset", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph), (java.lang.Object) offset});
	}

	public Vector2 font_get_glyph_size(long font_rid, Vector2i size, long glyph) {
		return (Vector2) super.call("font_get_glyph_size", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph)});
	}

	public void font_set_glyph_size(long font_rid, Vector2i size, long glyph, Vector2 gl_size) {
		super.call("font_set_glyph_size", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph), (java.lang.Object) gl_size});
	}

	public Rect2 font_get_glyph_uv_rect(long font_rid, Vector2i size, long glyph) {
		return (Rect2) super.call("font_get_glyph_uv_rect", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph)});
	}

	public void font_set_glyph_uv_rect(long font_rid, Vector2i size, long glyph, Rect2 uv_rect) {
		super.call("font_set_glyph_uv_rect", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph), (java.lang.Object) uv_rect});
	}

	public long font_get_glyph_texture_idx(long font_rid, Vector2i size, long glyph) {
		return (long) super.call("font_get_glyph_texture_idx", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph)});
	}

	public void font_set_glyph_texture_idx(long font_rid, Vector2i size, long glyph, long texture_idx) {
		super.call("font_set_glyph_texture_idx", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph), java.lang.Long.valueOf(texture_idx)});
	}

	public long font_get_glyph_texture_rid(long font_rid, Vector2i size, long glyph) {
		return (long) super.call("font_get_glyph_texture_rid", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(glyph)});
	}

	public Vector2 font_get_glyph_texture_size(long font_rid, Vector2i size, long glyph) {
		return (Vector2) super.call("font_get_glyph_texture_size", new java.lang.Object[]{
				java.lang.Long.valueOf(font_rid), (java.lang.Object) size, java.lang.Long.valueOf(glyph)});
	}

	public GodotDictionary font_get_glyph_contours(long font, long size, long index) {
		return (GodotDictionary) super.call("font_get_glyph_contours", new java.lang.Object[]{
				java.lang.Long.valueOf(font), java.lang.Long.valueOf(size), java.lang.Long.valueOf(index)});
	}

	public Vector2i[] font_get_kerning_list(long font_rid, long size) {
		return (Vector2i[]) super.call("font_get_kerning_list",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(size)});
	}

	public void font_clear_kerning_map(long font_rid, long size) {
		super.call("font_clear_kerning_map",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(size)});
	}

	public void font_remove_kerning(long font_rid, long size, Vector2i glyph_pair) {
		super.call("font_remove_kerning", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Long.valueOf(size), (java.lang.Object) glyph_pair});
	}

	public void font_set_kerning(long font_rid, long size, Vector2i glyph_pair, Vector2 kerning) {
		super.call("font_set_kerning", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Long.valueOf(size), (java.lang.Object) glyph_pair, (java.lang.Object) kerning});
	}

	public Vector2 font_get_kerning(long font_rid, long size, Vector2i glyph_pair) {
		return (Vector2) super.call("font_get_kerning", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				java.lang.Long.valueOf(size), (java.lang.Object) glyph_pair});
	}

	public long font_get_glyph_index(long font_rid, long size, long char_, long variation_selector) {
		return (long) super.call("font_get_glyph_index",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(size),
						java.lang.Long.valueOf(char_), java.lang.Long.valueOf(variation_selector)});
	}

	public long font_get_char_from_glyph_index(long font_rid, long size, long glyph_index) {
		return (long) super.call("font_get_char_from_glyph_index", new java.lang.Object[]{
				java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(size), java.lang.Long.valueOf(glyph_index)});
	}

	public boolean font_has_char(long font_rid, long char_) {
		return (boolean) super.call("font_has_char",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(char_)});
	}

	public String font_get_supported_chars(long font_rid) {
		return (String) super.call("font_get_supported_chars",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public int[] font_get_supported_glyphs(long font_rid) {
		return (int[]) super.call("font_get_supported_glyphs",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_render_range(long font_rid, Vector2i size, long start, long end) {
		super.call("font_render_range", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(start), java.lang.Long.valueOf(end)});
	}

	public void font_render_glyph(long font_rid, Vector2i size, long index) {
		super.call("font_render_glyph", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) size, java.lang.Long.valueOf(index)});
	}

	public void font_draw_glyph(long font_rid, long canvas, long size, Vector2 pos, long index, Color color,
			double oversampling) {
		super.call("font_draw_glyph",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(canvas),
						java.lang.Long.valueOf(size), (java.lang.Object) pos, java.lang.Long.valueOf(index),
						(java.lang.Object) color, java.lang.Double.valueOf(oversampling)});
	}

	public void font_draw_glyph_outline(long font_rid, long canvas, long size, long outline_size, Vector2 pos,
			long index, Color color, double oversampling) {
		super.call("font_draw_glyph_outline",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), java.lang.Long.valueOf(canvas),
						java.lang.Long.valueOf(size), java.lang.Long.valueOf(outline_size), (java.lang.Object) pos,
						java.lang.Long.valueOf(index), (java.lang.Object) color,
						java.lang.Double.valueOf(oversampling)});
	}

	public boolean font_is_language_supported(long font_rid, String language) {
		return (boolean) super.call("font_is_language_supported",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) language});
	}

	public void font_set_language_support_override(long font_rid, String language, boolean supported) {
		super.call("font_set_language_support_override", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) language, java.lang.Boolean.valueOf(supported)});
	}

	public boolean font_get_language_support_override(long font_rid, String language) {
		return (boolean) super.call("font_get_language_support_override",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) language});
	}

	public void font_remove_language_support_override(long font_rid, String language) {
		super.call("font_remove_language_support_override",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) language});
	}

	public String[] font_get_language_support_overrides(long font_rid) {
		return (String[]) super.call("font_get_language_support_overrides",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public boolean font_is_script_supported(long font_rid, String script) {
		return (boolean) super.call("font_is_script_supported",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) script});
	}

	public void font_set_script_support_override(long font_rid, String script, boolean supported) {
		super.call("font_set_script_support_override", new java.lang.Object[]{java.lang.Long.valueOf(font_rid),
				(java.lang.Object) script, java.lang.Boolean.valueOf(supported)});
	}

	public boolean font_get_script_support_override(long font_rid, String script) {
		return (boolean) super.call("font_get_script_support_override",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) script});
	}

	public void font_remove_script_support_override(long font_rid, String script) {
		super.call("font_remove_script_support_override",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) script});
	}

	public String[] font_get_script_support_overrides(long font_rid) {
		return (String[]) super.call("font_get_script_support_overrides",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public void font_set_opentype_feature_overrides(long font_rid, GodotDictionary overrides) {
		super.call("font_set_opentype_feature_overrides",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid), (java.lang.Object) overrides});
	}

	public GodotDictionary font_get_opentype_feature_overrides(long font_rid) {
		return (GodotDictionary) super.call("font_get_opentype_feature_overrides",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public GodotDictionary font_supported_feature_list(long font_rid) {
		return (GodotDictionary) super.call("font_supported_feature_list",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public GodotDictionary font_supported_variation_list(long font_rid) {
		return (GodotDictionary) super.call("font_supported_variation_list",
				new java.lang.Object[]{java.lang.Long.valueOf(font_rid)});
	}

	public double font_get_global_oversampling() {
		return (double) super.call("font_get_global_oversampling");
	}

	public void font_set_global_oversampling(double oversampling) {
		super.call("font_set_global_oversampling", new java.lang.Object[]{java.lang.Double.valueOf(oversampling)});
	}

	public Vector2 get_hex_code_box_size(long size, long index) {
		return (Vector2) super.call("get_hex_code_box_size",
				new java.lang.Object[]{java.lang.Long.valueOf(size), java.lang.Long.valueOf(index)});
	}

	public void draw_hex_code_box(long canvas, long size, Vector2 pos, long index, Color color) {
		super.call("draw_hex_code_box",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas), java.lang.Long.valueOf(size),
						(java.lang.Object) pos, java.lang.Long.valueOf(index), (java.lang.Object) color});
	}

	public long create_shaped_text(int direction, int orientation) {
		return (long) super.call("create_shaped_text",
				new java.lang.Object[]{java.lang.Integer.valueOf(direction), java.lang.Integer.valueOf(orientation)});
	}

	public void shaped_text_clear(long rid) {
		super.call("shaped_text_clear", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public long shaped_text_duplicate(long rid) {
		return (long) super.call("shaped_text_duplicate", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public void shaped_text_set_direction(long shaped, int direction) {
		super.call("shaped_text_set_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Integer.valueOf(direction)});
	}

	public int shaped_text_get_direction(long shaped) {
		return (int) super.call("shaped_text_get_direction", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public int shaped_text_get_inferred_direction(long shaped) {
		return (int) super.call("shaped_text_get_inferred_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public void shaped_text_set_bidi_override(long shaped, GodotArray override) {
		super.call("shaped_text_set_bidi_override",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), (java.lang.Object) override});
	}

	public void shaped_text_set_custom_punctuation(long shaped, String punct) {
		super.call("shaped_text_set_custom_punctuation",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), (java.lang.Object) punct});
	}

	public String shaped_text_get_custom_punctuation(long shaped) {
		return (String) super.call("shaped_text_get_custom_punctuation",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public void shaped_text_set_custom_ellipsis(long shaped, long char_) {
		super.call("shaped_text_set_custom_ellipsis",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(char_)});
	}

	public long shaped_text_get_custom_ellipsis(long shaped) {
		return (long) super.call("shaped_text_get_custom_ellipsis",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public void shaped_text_set_orientation(long shaped, int orientation) {
		super.call("shaped_text_set_orientation",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Integer.valueOf(orientation)});
	}

	public int shaped_text_get_orientation(long shaped) {
		return (int) super.call("shaped_text_get_orientation", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public void shaped_text_set_preserve_invalid(long shaped, boolean enabled) {
		super.call("shaped_text_set_preserve_invalid",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean shaped_text_get_preserve_invalid(long shaped) {
		return (boolean) super.call("shaped_text_get_preserve_invalid",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public void shaped_text_set_preserve_control(long shaped, boolean enabled) {
		super.call("shaped_text_set_preserve_control",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean shaped_text_get_preserve_control(long shaped) {
		return (boolean) super.call("shaped_text_get_preserve_control",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public void shaped_text_set_spacing(long shaped, int spacing, long value) {
		super.call("shaped_text_set_spacing", new java.lang.Object[]{java.lang.Long.valueOf(shaped),
				java.lang.Integer.valueOf(spacing), java.lang.Long.valueOf(value)});
	}

	public long shaped_text_get_spacing(long shaped, int spacing) {
		return (long) super.call("shaped_text_get_spacing",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Integer.valueOf(spacing)});
	}

	public boolean shaped_text_add_string(long shaped, String text, long[] fonts, long size,
			GodotDictionary opentype_features, String language, Object meta) {
		return (boolean) super.call("shaped_text_add_string",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), (java.lang.Object) text,
						(java.lang.Object) fonts, java.lang.Long.valueOf(size), (java.lang.Object) opentype_features,
						(java.lang.Object) language, (java.lang.Object) meta});
	}

	public boolean shaped_text_add_object(long shaped, Object key, Vector2 size, int inline_align, long length,
			double baseline) {
		return (boolean) super.call("shaped_text_add_object",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), (java.lang.Object) key, (java.lang.Object) size,
						java.lang.Integer.valueOf(inline_align), java.lang.Long.valueOf(length),
						java.lang.Double.valueOf(baseline)});
	}

	public boolean shaped_text_resize_object(long shaped, Object key, Vector2 size, int inline_align, double baseline) {
		return (boolean) super.call("shaped_text_resize_object",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), (java.lang.Object) key, (java.lang.Object) size,
						java.lang.Integer.valueOf(inline_align), java.lang.Double.valueOf(baseline)});
	}

	public boolean shaped_text_has_object(long shaped, Object key) {
		return (boolean) super.call("shaped_text_has_object",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), (java.lang.Object) key});
	}

	public String shaped_get_text(long shaped) {
		return (String) super.call("shaped_get_text", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public long shaped_get_span_count(long shaped) {
		return (long) super.call("shaped_get_span_count", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public Object shaped_get_span_meta(long shaped, long index) {
		return (Object) super.call("shaped_get_span_meta",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index)});
	}

	public Object shaped_get_span_embedded_object(long shaped, long index) {
		return (Object) super.call("shaped_get_span_embedded_object",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index)});
	}

	public String shaped_get_span_text(long shaped, long index) {
		return (String) super.call("shaped_get_span_text",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index)});
	}

	public Object shaped_get_span_object(long shaped, long index) {
		return (Object) super.call("shaped_get_span_object",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index)});
	}

	public void shaped_set_span_update_font(long shaped, long index, long[] fonts, long size,
			GodotDictionary opentype_features) {
		super.call("shaped_set_span_update_font",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index),
						(java.lang.Object) fonts, java.lang.Long.valueOf(size), (java.lang.Object) opentype_features});
	}

	public long shaped_get_run_count(long shaped) {
		return (long) super.call("shaped_get_run_count", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public String shaped_get_run_text(long shaped, long index) {
		return (String) super.call("shaped_get_run_text",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index)});
	}

	public Vector2i shaped_get_run_range(long shaped, long index) {
		return (Vector2i) super.call("shaped_get_run_range",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index)});
	}

	public Vector2i shaped_get_run_glyph_range(long shaped, long index) {
		return (Vector2i) super.call("shaped_get_run_glyph_range",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index)});
	}

	public long shaped_get_run_font_rid(long shaped, long index) {
		return (long) super.call("shaped_get_run_font_rid",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index)});
	}

	public int shaped_get_run_font_size(long shaped, long index) {
		return (int) super.call("shaped_get_run_font_size",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index)});
	}

	public String shaped_get_run_language(long shaped, long index) {
		return (String) super.call("shaped_get_run_language",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index)});
	}

	public int shaped_get_run_direction(long shaped, long index) {
		return (int) super.call("shaped_get_run_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index)});
	}

	public Object shaped_get_run_object(long shaped, long index) {
		return (Object) super.call("shaped_get_run_object",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(index)});
	}

	public long shaped_text_substr(long shaped, long start, long length) {
		return (long) super.call("shaped_text_substr", new java.lang.Object[]{java.lang.Long.valueOf(shaped),
				java.lang.Long.valueOf(start), java.lang.Long.valueOf(length)});
	}

	public long shaped_text_get_parent(long shaped) {
		return (long) super.call("shaped_text_get_parent", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public double shaped_text_fit_to_width(long shaped, double width, int justification_flags) {
		return (double) super.call("shaped_text_fit_to_width", new java.lang.Object[]{java.lang.Long.valueOf(shaped),
				java.lang.Double.valueOf(width), java.lang.Integer.valueOf(justification_flags)});
	}

	public double shaped_text_tab_align(long shaped, double[] tab_stops) {
		return (double) super.call("shaped_text_tab_align",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), (java.lang.Object) tab_stops});
	}

	public boolean shaped_text_shape(long shaped) {
		return (boolean) super.call("shaped_text_shape", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public boolean shaped_text_is_ready(long shaped) {
		return (boolean) super.call("shaped_text_is_ready", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public boolean shaped_text_has_visible_chars(long shaped) {
		return (boolean) super.call("shaped_text_has_visible_chars",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public GodotDictionary[] shaped_text_get_glyphs(long shaped) {
		return (GodotDictionary[]) super.call("shaped_text_get_glyphs",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public GodotDictionary[] shaped_text_sort_logical(long shaped) {
		return (GodotDictionary[]) super.call("shaped_text_sort_logical",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public long shaped_text_get_glyph_count(long shaped) {
		return (long) super.call("shaped_text_get_glyph_count", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public Vector2i shaped_text_get_range(long shaped) {
		return (Vector2i) super.call("shaped_text_get_range", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public int[] shaped_text_get_line_breaks_adv(long shaped, double[] width, long start, boolean once,
			int break_flags) {
		return (int[]) super.call("shaped_text_get_line_breaks_adv",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), (java.lang.Object) width,
						java.lang.Long.valueOf(start), java.lang.Boolean.valueOf(once),
						java.lang.Integer.valueOf(break_flags)});
	}

	public int[] shaped_text_get_line_breaks(long shaped, double width, long start, int break_flags) {
		return (int[]) super.call("shaped_text_get_line_breaks",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Double.valueOf(width),
						java.lang.Long.valueOf(start), java.lang.Integer.valueOf(break_flags)});
	}

	public int[] shaped_text_get_word_breaks(long shaped, int grapheme_flags, int skip_grapheme_flags) {
		return (int[]) super.call("shaped_text_get_word_breaks", new java.lang.Object[]{java.lang.Long.valueOf(shaped),
				java.lang.Integer.valueOf(grapheme_flags), java.lang.Integer.valueOf(skip_grapheme_flags)});
	}

	public long shaped_text_get_trim_pos(long shaped) {
		return (long) super.call("shaped_text_get_trim_pos", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public long shaped_text_get_ellipsis_pos(long shaped) {
		return (long) super.call("shaped_text_get_ellipsis_pos",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public GodotDictionary[] shaped_text_get_ellipsis_glyphs(long shaped) {
		return (GodotDictionary[]) super.call("shaped_text_get_ellipsis_glyphs",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public long shaped_text_get_ellipsis_glyph_count(long shaped) {
		return (long) super.call("shaped_text_get_ellipsis_glyph_count",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public void shaped_text_overrun_trim_to_width(long shaped, double width, int overrun_trim_flags) {
		super.call("shaped_text_overrun_trim_to_width", new java.lang.Object[]{java.lang.Long.valueOf(shaped),
				java.lang.Double.valueOf(width), java.lang.Integer.valueOf(overrun_trim_flags)});
	}

	public GodotArray shaped_text_get_objects(long shaped) {
		return (GodotArray) super.call("shaped_text_get_objects",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public Rect2 shaped_text_get_object_rect(long shaped, Object key) {
		return (Rect2) super.call("shaped_text_get_object_rect",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), (java.lang.Object) key});
	}

	public Vector2i shaped_text_get_object_range(long shaped, Object key) {
		return (Vector2i) super.call("shaped_text_get_object_range",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), (java.lang.Object) key});
	}

	public long shaped_text_get_object_glyph(long shaped, Object key) {
		return (long) super.call("shaped_text_get_object_glyph",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), (java.lang.Object) key});
	}

	public Vector2 shaped_text_get_size(long shaped) {
		return (Vector2) super.call("shaped_text_get_size", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public double shaped_text_get_ascent(long shaped) {
		return (double) super.call("shaped_text_get_ascent", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public double shaped_text_get_descent(long shaped) {
		return (double) super.call("shaped_text_get_descent", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public double shaped_text_get_width(long shaped) {
		return (double) super.call("shaped_text_get_width", new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public double shaped_text_get_underline_position(long shaped) {
		return (double) super.call("shaped_text_get_underline_position",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public double shaped_text_get_underline_thickness(long shaped) {
		return (double) super.call("shaped_text_get_underline_thickness",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public GodotDictionary shaped_text_get_carets(long shaped, long position) {
		return (GodotDictionary) super.call("shaped_text_get_carets",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(position)});
	}

	public double[][] shaped_text_get_selection(long shaped, long start, long end) {
		return (double[][]) super.call("shaped_text_get_selection", new java.lang.Object[]{
				java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(start), java.lang.Long.valueOf(end)});
	}

	public long shaped_text_hit_test_grapheme(long shaped, double coords) {
		return (long) super.call("shaped_text_hit_test_grapheme",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Double.valueOf(coords)});
	}

	public long shaped_text_hit_test_position(long shaped, double coords) {
		return (long) super.call("shaped_text_hit_test_position",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Double.valueOf(coords)});
	}

	public Vector2 shaped_text_get_grapheme_bounds(long shaped, long pos) {
		return (Vector2) super.call("shaped_text_get_grapheme_bounds",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(pos)});
	}

	public long shaped_text_next_grapheme_pos(long shaped, long pos) {
		return (long) super.call("shaped_text_next_grapheme_pos",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(pos)});
	}

	public long shaped_text_prev_grapheme_pos(long shaped, long pos) {
		return (long) super.call("shaped_text_prev_grapheme_pos",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(pos)});
	}

	public int[] shaped_text_get_character_breaks(long shaped) {
		return (int[]) super.call("shaped_text_get_character_breaks",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped)});
	}

	public long shaped_text_next_character_pos(long shaped, long pos) {
		return (long) super.call("shaped_text_next_character_pos",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(pos)});
	}

	public long shaped_text_prev_character_pos(long shaped, long pos) {
		return (long) super.call("shaped_text_prev_character_pos",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(pos)});
	}

	public long shaped_text_closest_character_pos(long shaped, long pos) {
		return (long) super.call("shaped_text_closest_character_pos",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(pos)});
	}

	public void shaped_text_draw(long shaped, long canvas, Vector2 pos, double clip_l, double clip_r, Color color,
			double oversampling) {
		super.call("shaped_text_draw",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(canvas),
						(java.lang.Object) pos, java.lang.Double.valueOf(clip_l), java.lang.Double.valueOf(clip_r),
						(java.lang.Object) color, java.lang.Double.valueOf(oversampling)});
	}

	public void shaped_text_draw_outline(long shaped, long canvas, Vector2 pos, double clip_l, double clip_r,
			long outline_size, Color color, double oversampling) {
		super.call("shaped_text_draw_outline",
				new java.lang.Object[]{java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(canvas),
						(java.lang.Object) pos, java.lang.Double.valueOf(clip_l), java.lang.Double.valueOf(clip_r),
						java.lang.Long.valueOf(outline_size), (java.lang.Object) color,
						java.lang.Double.valueOf(oversampling)});
	}

	public int shaped_text_get_dominant_direction_in_range(long shaped, long start, long end) {
		return (int) super.call("shaped_text_get_dominant_direction_in_range", new java.lang.Object[]{
				java.lang.Long.valueOf(shaped), java.lang.Long.valueOf(start), java.lang.Long.valueOf(end)});
	}

	public String format_number(String number, String language) {
		return (String) super.call("format_number",
				new java.lang.Object[]{(java.lang.Object) number, (java.lang.Object) language});
	}

	public String parse_number(String number, String language) {
		return (String) super.call("parse_number",
				new java.lang.Object[]{(java.lang.Object) number, (java.lang.Object) language});
	}

	public String percent_sign(String language) {
		return (String) super.call("percent_sign", new java.lang.Object[]{(java.lang.Object) language});
	}

	public int[] string_get_word_breaks(String string, String language, long chars_per_line) {
		return (int[]) super.call("string_get_word_breaks", new java.lang.Object[]{(java.lang.Object) string,
				(java.lang.Object) language, java.lang.Long.valueOf(chars_per_line)});
	}

	public int[] string_get_character_breaks(String string, String language) {
		return (int[]) super.call("string_get_character_breaks",
				new java.lang.Object[]{(java.lang.Object) string, (java.lang.Object) language});
	}

	public long is_confusable(String string, String[] dict) {
		return (long) super.call("is_confusable",
				new java.lang.Object[]{(java.lang.Object) string, (java.lang.Object) dict});
	}

	public boolean spoof_check(String string) {
		return (boolean) super.call("spoof_check", new java.lang.Object[]{(java.lang.Object) string});
	}

	public String strip_diacritics(String string) {
		return (String) super.call("strip_diacritics", new java.lang.Object[]{(java.lang.Object) string});
	}

	public boolean is_valid_identifier(String string) {
		return (boolean) super.call("is_valid_identifier", new java.lang.Object[]{(java.lang.Object) string});
	}

	public boolean is_valid_letter(long unicode) {
		return (boolean) super.call("is_valid_letter", new java.lang.Object[]{java.lang.Long.valueOf(unicode)});
	}

	public String string_to_upper(String string, String language) {
		return (String) super.call("string_to_upper",
				new java.lang.Object[]{(java.lang.Object) string, (java.lang.Object) language});
	}

	public String string_to_lower(String string, String language) {
		return (String) super.call("string_to_lower",
				new java.lang.Object[]{(java.lang.Object) string, (java.lang.Object) language});
	}

	public String string_to_title(String string, String language) {
		return (String) super.call("string_to_title",
				new java.lang.Object[]{(java.lang.Object) string, (java.lang.Object) language});
	}

	public Vector3i[] parse_structured_text(int parser_type, GodotArray args, String text) {
		return (Vector3i[]) super.call("parse_structured_text", new java.lang.Object[]{
				java.lang.Integer.valueOf(parser_type), (java.lang.Object) args, (java.lang.Object) text});
	}
}
