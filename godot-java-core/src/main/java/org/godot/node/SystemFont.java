package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SystemFont extends Font {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_oversampling", 1740695150L),
			java.util.Map.entry("is_modulate_color_glyphs", 36873697L),
			java.util.Map.entry("get_antialiasing", 4262718649L),
			java.util.Map.entry("set_disable_embedded_bitmaps", 2586408642L),
			java.util.Map.entry("set_keep_rounding_remainders", 2586408642L),
			java.util.Map.entry("get_msdf_pixel_range", 3905245786L),
			java.util.Map.entry("get_font_names", 1139954409L), java.util.Map.entry("get_generate_mipmaps", 36873697L),
			java.util.Map.entry("set_font_weight", 1286410249L), java.util.Map.entry("set_font_stretch", 1286410249L),
			java.util.Map.entry("get_subpixel_positioning", 1069238588L),
			java.util.Map.entry("set_subpixel_positioning", 4225742182L),
			java.util.Map.entry("set_msdf_size", 1286410249L), java.util.Map.entry("get_hinting", 3683214614L),
			java.util.Map.entry("set_font_names", 4015028928L), java.util.Map.entry("set_hinting", 1827459492L),
			java.util.Map.entry("get_font_italic", 36873697L), java.util.Map.entry("set_antialiasing", 1669900L),
			java.util.Map.entry("is_allow_system_fallback", 36873697L),
			java.util.Map.entry("set_msdf_pixel_range", 1286410249L),
			java.util.Map.entry("set_oversampling", 373806689L),
			java.util.Map.entry("set_generate_mipmaps", 2586408642L),
			java.util.Map.entry("get_keep_rounding_remainders", 36873697L),
			java.util.Map.entry("get_msdf_size", 3905245786L), java.util.Map.entry("set_force_autohinter", 2586408642L),
			java.util.Map.entry("is_force_autohinter", 36873697L), java.util.Map.entry("set_font_italic", 2586408642L),
			java.util.Map.entry("get_disable_embedded_bitmaps", 36873697L),
			java.util.Map.entry("is_multichannel_signed_distance_field", 36873697L),
			java.util.Map.entry("set_multichannel_signed_distance_field", 2586408642L),
			java.util.Map.entry("set_allow_system_fallback", 2586408642L),
			java.util.Map.entry("set_modulate_color_glyphs", 2586408642L));

	SystemFont(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SystemFont(long nativePointer) {
		super(nativePointer);
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

	public boolean is_multichannel_signed_distance_field() {
		return (boolean) super.call("is_multichannel_signed_distance_field");
	}

	public String[] getFont_names() {
		return (String[]) super.call("get_font_names", new java.lang.Object[0]);
	}

	public void setFont_names(String[] value) {
		super.call("set_font_names", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getFont_italic() {
		return (boolean) super.call("get_font_italic", new java.lang.Object[0]);
	}

	public void setFont_italic(boolean value) {
		super.call("set_font_italic", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public long getAntialiasing() {
		return (long) super.call("get_antialiasing", new java.lang.Object[0]);
	}

	public void setAntialiasing(long value) {
		super.call("set_antialiasing", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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

	public double getOversampling() {
		return (double) super.call("get_oversampling", new java.lang.Object[0]);
	}

	public void setOversampling(double value) {
		super.call("set_oversampling", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
