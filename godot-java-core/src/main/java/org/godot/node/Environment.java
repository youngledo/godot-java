package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector3;

public class Environment extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_volumetric_fog_albedo", 3444240500L),
			java.util.Map.entry("set_ambient_source", 2607780160L),
			java.util.Map.entry("set_ssr_depth_tolerance", 373806689L),
			java.util.Map.entry("get_fog_aerial_perspective", 1740695150L),
			java.util.Map.entry("get_volumetric_fog_temporal_reprojection_amount", 1740695150L),
			java.util.Map.entry("set_tonemap_agx_contrast", 373806689L),
			java.util.Map.entry("set_volumetric_fog_detail_spread", 373806689L),
			java.util.Map.entry("is_sdfgi_using_occlusion", 36873697L),
			java.util.Map.entry("get_glow_hdr_bleed_scale", 1740695150L),
			java.util.Map.entry("set_fog_height_density", 373806689L),
			java.util.Map.entry("is_volumetric_fog_temporal_reprojection_enabled", 36873697L),
			java.util.Map.entry("get_adjustment_brightness", 1740695150L),
			java.util.Map.entry("get_glow_intensity", 1740695150L),
			java.util.Map.entry("get_ambient_light_color", 3444240500L),
			java.util.Map.entry("get_ssao_sharpness", 1740695150L), java.util.Map.entry("set_fog_enabled", 2586408642L),
			java.util.Map.entry("is_ssil_enabled", 36873697L), java.util.Map.entry("set_ssao_power", 373806689L),
			java.util.Map.entry("get_ssr_max_steps", 3905245786L), java.util.Map.entry("set_ssil_enabled", 2586408642L),
			java.util.Map.entry("set_ssil_intensity", 373806689L), java.util.Map.entry("set_glow_strength", 373806689L),
			java.util.Map.entry("set_glow_hdr_luminance_cap", 373806689L),
			java.util.Map.entry("set_volumetric_fog_emission", 2920490490L),
			java.util.Map.entry("set_ssao_radius", 373806689L), java.util.Map.entry("get_ssil_sharpness", 1740695150L),
			java.util.Map.entry("set_bg_energy_multiplier", 373806689L),
			java.util.Map.entry("set_fog_height", 373806689L), java.util.Map.entry("get_ssao_radius", 1740695150L),
			java.util.Map.entry("set_adjustment_brightness", 373806689L),
			java.util.Map.entry("set_adjustment_color_correction", 1790811099L),
			java.util.Map.entry("set_sdfgi_energy", 373806689L), java.util.Map.entry("get_fog_height", 1740695150L),
			java.util.Map.entry("set_ssr_fade_in", 373806689L),
			java.util.Map.entry("set_glow_hdr_bleed_threshold", 373806689L),
			java.util.Map.entry("get_volumetric_fog_density", 1740695150L), java.util.Map.entry("get_sky", 1177136966L),
			java.util.Map.entry("set_ssao_intensity", 373806689L),
			java.util.Map.entry("get_fog_light_color", 3444240500L),
			java.util.Map.entry("set_adjustment_enabled", 2586408642L),
			java.util.Map.entry("get_glow_strength", 1740695150L),
			java.util.Map.entry("set_volumetric_fog_enabled", 2586408642L),
			java.util.Map.entry("is_sdfgi_reading_sky_light", 36873697L),
			java.util.Map.entry("set_fog_depth_end", 373806689L), java.util.Map.entry("get_ssil_radius", 1740695150L),
			java.util.Map.entry("get_ssao_power", 1740695150L), java.util.Map.entry("get_sdfgi_cascades", 3905245786L),
			java.util.Map.entry("set_fog_light_color", 2920490490L),
			java.util.Map.entry("set_ambient_light_sky_contribution", 373806689L),
			java.util.Map.entry("get_ssao_ao_channel_affect", 1740695150L),
			java.util.Map.entry("set_adjustment_contrast", 373806689L),
			java.util.Map.entry("set_glow_enabled", 2586408642L),
			java.util.Map.entry("set_volumetric_fog_temporal_reprojection_enabled", 2586408642L),
			java.util.Map.entry("get_adjustment_color_correction", 4037048985L),
			java.util.Map.entry("set_ssao_detail", 373806689L), java.util.Map.entry("set_sdfgi_cascades", 1286410249L),
			java.util.Map.entry("is_glow_normalized", 36873697L), java.util.Map.entry("get_glow_level", 2339986948L),
			java.util.Map.entry("get_glow_bloom", 1740695150L), java.util.Map.entry("set_bg_intensity", 373806689L),
			java.util.Map.entry("get_ssr_depth_tolerance", 1740695150L),
			java.util.Map.entry("get_bg_color", 3444240500L),
			java.util.Map.entry("is_volumetric_fog_enabled", 36873697L),
			java.util.Map.entry("get_volumetric_fog_anisotropy", 1740695150L),
			java.util.Map.entry("get_glow_mix", 1740695150L), java.util.Map.entry("get_glow_map", 4037048985L),
			java.util.Map.entry("get_volumetric_fog_length", 1740695150L),
			java.util.Map.entry("set_glow_level", 1602489585L), java.util.Map.entry("get_ssao_horizon", 1740695150L),
			java.util.Map.entry("get_fog_mode", 2456062483L),
			java.util.Map.entry("get_volumetric_fog_ambient_inject", 1740695150L),
			java.util.Map.entry("set_sky_custom_fov", 373806689L), java.util.Map.entry("get_fog_density", 1740695150L),
			java.util.Map.entry("get_background", 1843210413L),
			java.util.Map.entry("set_volumetric_fog_density", 373806689L),
			java.util.Map.entry("set_tonemap_agx_white", 373806689L),
			java.util.Map.entry("get_sky_rotation", 3360562783L), java.util.Map.entry("set_background", 4071623990L),
			java.util.Map.entry("get_tonemap_white", 1740695150L), java.util.Map.entry("set_bg_color", 2920490490L),
			java.util.Map.entry("get_ambient_light_energy", 1740695150L),
			java.util.Map.entry("get_bg_intensity", 1740695150L), java.util.Map.entry("is_ssao_enabled", 36873697L),
			java.util.Map.entry("set_sdfgi_use_occlusion", 2586408642L),
			java.util.Map.entry("set_glow_normalized", 2586408642L),
			java.util.Map.entry("set_tonemap_white", 373806689L), java.util.Map.entry("set_glow_mix", 373806689L),
			java.util.Map.entry("set_glow_map", 1790811099L), java.util.Map.entry("set_tonemap_exposure", 373806689L),
			java.util.Map.entry("set_fog_sun_scatter", 373806689L),
			java.util.Map.entry("get_adjustment_saturation", 1740695150L),
			java.util.Map.entry("get_ssao_direct_light_affect", 1740695150L),
			java.util.Map.entry("get_reflection_source", 777700713L),
			java.util.Map.entry("set_ssr_fade_out", 373806689L),
			java.util.Map.entry("get_tonemap_exposure", 1740695150L),
			java.util.Map.entry("get_fog_sun_scatter", 1740695150L),
			java.util.Map.entry("set_fog_aerial_perspective", 373806689L),
			java.util.Map.entry("get_ssao_detail", 1740695150L), java.util.Map.entry("set_ssil_sharpness", 373806689L),
			java.util.Map.entry("get_glow_map_strength", 1740695150L),
			java.util.Map.entry("get_sdfgi_max_distance", 1740695150L),
			java.util.Map.entry("get_sdfgi_energy", 1740695150L),
			java.util.Map.entry("get_bg_energy_multiplier", 1740695150L),
			java.util.Map.entry("set_volumetric_fog_sky_affect", 373806689L),
			java.util.Map.entry("set_ssil_normal_rejection", 373806689L),
			java.util.Map.entry("get_glow_hdr_bleed_threshold", 1740695150L),
			java.util.Map.entry("set_sdfgi_enabled", 2586408642L),
			java.util.Map.entry("get_fog_depth_curve", 1740695150L),
			java.util.Map.entry("set_glow_intensity", 373806689L), java.util.Map.entry("set_sky", 3336722921L),
			java.util.Map.entry("set_ssao_enabled", 2586408642L),
			java.util.Map.entry("get_ssil_intensity", 1740695150L),
			java.util.Map.entry("get_fog_sky_affect", 1740695150L),
			java.util.Map.entry("set_fog_depth_curve", 373806689L), java.util.Map.entry("set_ssr_enabled", 2586408642L),
			java.util.Map.entry("set_volumetric_fog_anisotropy", 373806689L),
			java.util.Map.entry("get_adjustment_contrast", 1740695150L),
			java.util.Map.entry("set_ssao_horizon", 373806689L),
			java.util.Map.entry("set_volumetric_fog_length", 373806689L),
			java.util.Map.entry("set_fog_depth_begin", 373806689L),
			java.util.Map.entry("set_glow_map_strength", 373806689L),
			java.util.Map.entry("is_adjustment_enabled", 36873697L),
			java.util.Map.entry("set_volumetric_fog_temporal_reprojection_amount", 373806689L),
			java.util.Map.entry("set_sdfgi_bounce_feedback", 373806689L),
			java.util.Map.entry("set_glow_hdr_bleed_scale", 373806689L),
			java.util.Map.entry("set_volumetric_fog_emission_energy", 373806689L),
			java.util.Map.entry("get_sdfgi_probe_bias", 1740695150L), java.util.Map.entry("set_fog_mode", 3059806579L),
			java.util.Map.entry("set_sdfgi_probe_bias", 373806689L),
			java.util.Map.entry("get_fog_depth_begin", 1740695150L),
			java.util.Map.entry("get_fog_depth_end", 1740695150L),
			java.util.Map.entry("set_sdfgi_cascade0_distance", 373806689L),
			java.util.Map.entry("get_ssr_fade_out", 1740695150L), java.util.Map.entry("set_glow_bloom", 373806689L),
			java.util.Map.entry("set_ambient_light_color", 2920490490L),
			java.util.Map.entry("set_reflection_source", 299673197L),
			java.util.Map.entry("set_fog_light_energy", 373806689L),
			java.util.Map.entry("set_sdfgi_min_cell_size", 373806689L),
			java.util.Map.entry("get_sdfgi_normal_bias", 1740695150L),
			java.util.Map.entry("get_volumetric_fog_emission_energy", 1740695150L),
			java.util.Map.entry("get_fog_height_density", 1740695150L),
			java.util.Map.entry("get_camera_feed_id", 3905245786L),
			java.util.Map.entry("set_ssao_direct_light_affect", 373806689L),
			java.util.Map.entry("set_volumetric_fog_ambient_inject", 373806689L),
			java.util.Map.entry("get_fog_light_energy", 1740695150L),
			java.util.Map.entry("get_volumetric_fog_detail_spread", 1740695150L),
			java.util.Map.entry("set_ambient_light_energy", 373806689L),
			java.util.Map.entry("is_sdfgi_enabled", 36873697L),
			java.util.Map.entry("set_volumetric_fog_albedo", 2920490490L),
			java.util.Map.entry("set_volumetric_fog_gi_inject", 373806689L),
			java.util.Map.entry("get_ambient_light_sky_contribution", 1740695150L),
			java.util.Map.entry("get_tonemap_agx_white", 1740695150L),
			java.util.Map.entry("get_sdfgi_cascade0_distance", 1740695150L),
			java.util.Map.entry("get_sky_custom_fov", 1740695150L), java.util.Map.entry("set_ssil_radius", 373806689L),
			java.util.Map.entry("set_sky_rotation", 3460891852L),
			java.util.Map.entry("set_sdfgi_read_sky_light", 2586408642L),
			java.util.Map.entry("set_adjustment_saturation", 373806689L),
			java.util.Map.entry("set_ssao_ao_channel_affect", 373806689L),
			java.util.Map.entry("get_tonemapper", 2908408137L),
			java.util.Map.entry("get_ssil_normal_rejection", 1740695150L),
			java.util.Map.entry("set_ssr_max_steps", 1286410249L),
			java.util.Map.entry("get_sdfgi_min_cell_size", 1740695150L),
			java.util.Map.entry("set_camera_feed_id", 1286410249L),
			java.util.Map.entry("get_volumetric_fog_emission", 3444240500L),
			java.util.Map.entry("get_glow_hdr_luminance_cap", 1740695150L),
			java.util.Map.entry("set_sdfgi_normal_bias", 373806689L),
			java.util.Map.entry("set_ssao_sharpness", 373806689L),
			java.util.Map.entry("set_sdfgi_y_scale", 3608608372L), java.util.Map.entry("get_ambient_source", 67453933L),
			java.util.Map.entry("get_volumetric_fog_gi_inject", 1740695150L),
			java.util.Map.entry("is_ssr_enabled", 36873697L), java.util.Map.entry("get_sdfgi_y_scale", 2568002245L),
			java.util.Map.entry("set_fog_sky_affect", 373806689L), java.util.Map.entry("set_fog_density", 373806689L),
			java.util.Map.entry("is_fog_enabled", 36873697L),
			java.util.Map.entry("get_tonemap_agx_contrast", 1740695150L),
			java.util.Map.entry("set_tonemapper", 1509116664L),
			java.util.Map.entry("get_sdfgi_bounce_feedback", 1740695150L),
			java.util.Map.entry("get_volumetric_fog_sky_affect", 1740695150L),
			java.util.Map.entry("get_canvas_max_layer", 3905245786L),
			java.util.Map.entry("set_glow_blend_mode", 2561587761L),
			java.util.Map.entry("get_glow_blend_mode", 1529667332L),
			java.util.Map.entry("set_canvas_max_layer", 1286410249L),
			java.util.Map.entry("get_ssr_fade_in", 1740695150L), java.util.Map.entry("get_ssao_intensity", 1740695150L),
			java.util.Map.entry("set_sdfgi_max_distance", 373806689L),
			java.util.Map.entry("is_glow_enabled", 36873697L));

	Environment(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Environment(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_ssr_enabled() {
		return (boolean) super.call("is_ssr_enabled");
	}

	public boolean is_ssao_enabled() {
		return (boolean) super.call("is_ssao_enabled");
	}

	public boolean is_ssil_enabled() {
		return (boolean) super.call("is_ssil_enabled");
	}

	public boolean is_sdfgi_enabled() {
		return (boolean) super.call("is_sdfgi_enabled");
	}

	public boolean is_sdfgi_using_occlusion() {
		return (boolean) super.call("is_sdfgi_using_occlusion");
	}

	public boolean is_sdfgi_reading_sky_light() {
		return (boolean) super.call("is_sdfgi_reading_sky_light");
	}

	public boolean is_glow_enabled() {
		return (boolean) super.call("is_glow_enabled");
	}

	public void set_glow_level(long idx, double intensity) {
		super.call("set_glow_level",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Double.valueOf(intensity)});
	}

	public double get_glow_level(long idx) {
		return (double) super.call("get_glow_level", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public boolean is_glow_normalized() {
		return (boolean) super.call("is_glow_normalized");
	}

	public boolean is_fog_enabled() {
		return (boolean) super.call("is_fog_enabled");
	}

	public boolean is_volumetric_fog_enabled() {
		return (boolean) super.call("is_volumetric_fog_enabled");
	}

	public boolean is_volumetric_fog_temporal_reprojection_enabled() {
		return (boolean) super.call("is_volumetric_fog_temporal_reprojection_enabled");
	}

	public boolean is_adjustment_enabled() {
		return (boolean) super.call("is_adjustment_enabled");
	}

	public long getBackground_mode() {
		return (long) super.call("get_background", new java.lang.Object[0]);
	}

	public void setBackground_mode(long value) {
		super.call("set_background", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Color getBackground_color() {
		return (Color) super.call("get_bg_color", new java.lang.Object[0]);
	}

	public void setBackground_color(Color value) {
		super.call("set_bg_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getBackground_energy_multiplier() {
		return (double) super.call("get_bg_energy_multiplier", new java.lang.Object[0]);
	}

	public void setBackground_energy_multiplier(double value) {
		super.call("set_bg_energy_multiplier", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getBackground_intensity() {
		return (double) super.call("get_bg_intensity", new java.lang.Object[0]);
	}

	public void setBackground_intensity(double value) {
		super.call("set_bg_intensity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getBackground_canvas_max_layer() {
		return (long) super.call("get_canvas_max_layer", new java.lang.Object[0]);
	}

	public void setBackground_canvas_max_layer(long value) {
		super.call("set_canvas_max_layer", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBackground_camera_feed_id() {
		return (long) super.call("get_camera_feed_id", new java.lang.Object[0]);
	}

	public void setBackground_camera_feed_id(long value) {
		super.call("set_camera_feed_id", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Sky getSky() {
		return (Sky) super.call("get_sky", new java.lang.Object[0]);
	}

	public void setSky(Sky value) {
		super.call("set_sky", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getSky_custom_fov() {
		return (double) super.call("get_sky_custom_fov", new java.lang.Object[0]);
	}

	public void setSky_custom_fov(double value) {
		super.call("set_sky_custom_fov", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector3 getSky_rotation() {
		return (Vector3) super.call("get_sky_rotation", new java.lang.Object[0]);
	}

	public void setSky_rotation(Vector3 value) {
		super.call("set_sky_rotation", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getAmbient_light_source() {
		return (long) super.call("get_ambient_source", new java.lang.Object[0]);
	}

	public void setAmbient_light_source(long value) {
		super.call("set_ambient_source", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Color getAmbient_light_color() {
		return (Color) super.call("get_ambient_light_color", new java.lang.Object[0]);
	}

	public void setAmbient_light_color(Color value) {
		super.call("set_ambient_light_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getAmbient_light_sky_contribution() {
		return (double) super.call("get_ambient_light_sky_contribution", new java.lang.Object[0]);
	}

	public void setAmbient_light_sky_contribution(double value) {
		super.call("set_ambient_light_sky_contribution", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAmbient_light_energy() {
		return (double) super.call("get_ambient_light_energy", new java.lang.Object[0]);
	}

	public void setAmbient_light_energy(double value) {
		super.call("set_ambient_light_energy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getReflected_light_source() {
		return (long) super.call("get_reflection_source", new java.lang.Object[0]);
	}

	public void setReflected_light_source(long value) {
		super.call("set_reflection_source", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTonemap_mode() {
		return (long) super.call("get_tonemapper", new java.lang.Object[0]);
	}

	public void setTonemap_mode(long value) {
		super.call("set_tonemapper", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getTonemap_exposure() {
		return (double) super.call("get_tonemap_exposure", new java.lang.Object[0]);
	}

	public void setTonemap_exposure(double value) {
		super.call("set_tonemap_exposure", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTonemap_white() {
		return (double) super.call("get_tonemap_white", new java.lang.Object[0]);
	}

	public void setTonemap_white(double value) {
		super.call("set_tonemap_white", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTonemap_agx_white() {
		return (double) super.call("get_tonemap_agx_white", new java.lang.Object[0]);
	}

	public void setTonemap_agx_white(double value) {
		super.call("set_tonemap_agx_white", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTonemap_agx_contrast() {
		return (double) super.call("get_tonemap_agx_contrast", new java.lang.Object[0]);
	}

	public void setTonemap_agx_contrast(double value) {
		super.call("set_tonemap_agx_contrast", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isSsr_enabled() {
		return (boolean) super.call("is_ssr_enabled", new java.lang.Object[0]);
	}

	public void setSsr_enabled(boolean value) {
		super.call("set_ssr_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSsr_max_steps() {
		return (long) super.call("get_ssr_max_steps", new java.lang.Object[0]);
	}

	public void setSsr_max_steps(long value) {
		super.call("set_ssr_max_steps", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getSsr_fade_in() {
		return (double) super.call("get_ssr_fade_in", new java.lang.Object[0]);
	}

	public void setSsr_fade_in(double value) {
		super.call("set_ssr_fade_in", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSsr_fade_out() {
		return (double) super.call("get_ssr_fade_out", new java.lang.Object[0]);
	}

	public void setSsr_fade_out(double value) {
		super.call("set_ssr_fade_out", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSsr_depth_tolerance() {
		return (double) super.call("get_ssr_depth_tolerance", new java.lang.Object[0]);
	}

	public void setSsr_depth_tolerance(double value) {
		super.call("set_ssr_depth_tolerance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isSsao_enabled() {
		return (boolean) super.call("is_ssao_enabled", new java.lang.Object[0]);
	}

	public void setSsao_enabled(boolean value) {
		super.call("set_ssao_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getSsao_radius() {
		return (double) super.call("get_ssao_radius", new java.lang.Object[0]);
	}

	public void setSsao_radius(double value) {
		super.call("set_ssao_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSsao_intensity() {
		return (double) super.call("get_ssao_intensity", new java.lang.Object[0]);
	}

	public void setSsao_intensity(double value) {
		super.call("set_ssao_intensity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSsao_power() {
		return (double) super.call("get_ssao_power", new java.lang.Object[0]);
	}

	public void setSsao_power(double value) {
		super.call("set_ssao_power", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSsao_detail() {
		return (double) super.call("get_ssao_detail", new java.lang.Object[0]);
	}

	public void setSsao_detail(double value) {
		super.call("set_ssao_detail", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSsao_horizon() {
		return (double) super.call("get_ssao_horizon", new java.lang.Object[0]);
	}

	public void setSsao_horizon(double value) {
		super.call("set_ssao_horizon", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSsao_sharpness() {
		return (double) super.call("get_ssao_sharpness", new java.lang.Object[0]);
	}

	public void setSsao_sharpness(double value) {
		super.call("set_ssao_sharpness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSsao_light_affect() {
		return (double) super.call("get_ssao_direct_light_affect", new java.lang.Object[0]);
	}

	public void setSsao_light_affect(double value) {
		super.call("set_ssao_direct_light_affect", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSsao_ao_channel_affect() {
		return (double) super.call("get_ssao_ao_channel_affect", new java.lang.Object[0]);
	}

	public void setSsao_ao_channel_affect(double value) {
		super.call("set_ssao_ao_channel_affect", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isSsil_enabled() {
		return (boolean) super.call("is_ssil_enabled", new java.lang.Object[0]);
	}

	public void setSsil_enabled(boolean value) {
		super.call("set_ssil_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getSsil_radius() {
		return (double) super.call("get_ssil_radius", new java.lang.Object[0]);
	}

	public void setSsil_radius(double value) {
		super.call("set_ssil_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSsil_intensity() {
		return (double) super.call("get_ssil_intensity", new java.lang.Object[0]);
	}

	public void setSsil_intensity(double value) {
		super.call("set_ssil_intensity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSsil_sharpness() {
		return (double) super.call("get_ssil_sharpness", new java.lang.Object[0]);
	}

	public void setSsil_sharpness(double value) {
		super.call("set_ssil_sharpness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSsil_normal_rejection() {
		return (double) super.call("get_ssil_normal_rejection", new java.lang.Object[0]);
	}

	public void setSsil_normal_rejection(double value) {
		super.call("set_ssil_normal_rejection", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isSdfgi_enabled() {
		return (boolean) super.call("is_sdfgi_enabled", new java.lang.Object[0]);
	}

	public void setSdfgi_enabled(boolean value) {
		super.call("set_sdfgi_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isSdfgi_use_occlusion() {
		return (boolean) super.call("is_sdfgi_using_occlusion", new java.lang.Object[0]);
	}

	public void setSdfgi_use_occlusion(boolean value) {
		super.call("set_sdfgi_use_occlusion", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isSdfgi_read_sky_light() {
		return (boolean) super.call("is_sdfgi_reading_sky_light", new java.lang.Object[0]);
	}

	public void setSdfgi_read_sky_light(boolean value) {
		super.call("set_sdfgi_read_sky_light", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getSdfgi_bounce_feedback() {
		return (double) super.call("get_sdfgi_bounce_feedback", new java.lang.Object[0]);
	}

	public void setSdfgi_bounce_feedback(double value) {
		super.call("set_sdfgi_bounce_feedback", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getSdfgi_cascades() {
		return (long) super.call("get_sdfgi_cascades", new java.lang.Object[0]);
	}

	public void setSdfgi_cascades(long value) {
		super.call("set_sdfgi_cascades", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getSdfgi_min_cell_size() {
		return (double) super.call("get_sdfgi_min_cell_size", new java.lang.Object[0]);
	}

	public void setSdfgi_min_cell_size(double value) {
		super.call("set_sdfgi_min_cell_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSdfgi_cascade0_distance() {
		return (double) super.call("get_sdfgi_cascade0_distance", new java.lang.Object[0]);
	}

	public void setSdfgi_cascade0_distance(double value) {
		super.call("set_sdfgi_cascade0_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSdfgi_max_distance() {
		return (double) super.call("get_sdfgi_max_distance", new java.lang.Object[0]);
	}

	public void setSdfgi_max_distance(double value) {
		super.call("set_sdfgi_max_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getSdfgi_y_scale() {
		return (long) super.call("get_sdfgi_y_scale", new java.lang.Object[0]);
	}

	public void setSdfgi_y_scale(long value) {
		super.call("set_sdfgi_y_scale", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getSdfgi_energy() {
		return (double) super.call("get_sdfgi_energy", new java.lang.Object[0]);
	}

	public void setSdfgi_energy(double value) {
		super.call("set_sdfgi_energy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSdfgi_normal_bias() {
		return (double) super.call("get_sdfgi_normal_bias", new java.lang.Object[0]);
	}

	public void setSdfgi_normal_bias(double value) {
		super.call("set_sdfgi_normal_bias", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSdfgi_probe_bias() {
		return (double) super.call("get_sdfgi_probe_bias", new java.lang.Object[0]);
	}

	public void setSdfgi_probe_bias(double value) {
		super.call("set_sdfgi_probe_bias", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isGlow_enabled() {
		return (boolean) super.call("is_glow_enabled", new java.lang.Object[0]);
	}

	public void setGlow_enabled(boolean value) {
		super.call("set_glow_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isGlow_normalized() {
		return (boolean) super.call("is_glow_normalized", new java.lang.Object[0]);
	}

	public void setGlow_normalized(boolean value) {
		super.call("set_glow_normalized", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getGlow_intensity() {
		return (double) super.call("get_glow_intensity", new java.lang.Object[0]);
	}

	public void setGlow_intensity(double value) {
		super.call("set_glow_intensity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getGlow_strength() {
		return (double) super.call("get_glow_strength", new java.lang.Object[0]);
	}

	public void setGlow_strength(double value) {
		super.call("set_glow_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getGlow_mix() {
		return (double) super.call("get_glow_mix", new java.lang.Object[0]);
	}

	public void setGlow_mix(double value) {
		super.call("set_glow_mix", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getGlow_bloom() {
		return (double) super.call("get_glow_bloom", new java.lang.Object[0]);
	}

	public void setGlow_bloom(double value) {
		super.call("set_glow_bloom", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getGlow_blend_mode() {
		return (long) super.call("get_glow_blend_mode", new java.lang.Object[0]);
	}

	public void setGlow_blend_mode(long value) {
		super.call("set_glow_blend_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getGlow_hdr_threshold() {
		return (double) super.call("get_glow_hdr_bleed_threshold", new java.lang.Object[0]);
	}

	public void setGlow_hdr_threshold(double value) {
		super.call("set_glow_hdr_bleed_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getGlow_hdr_scale() {
		return (double) super.call("get_glow_hdr_bleed_scale", new java.lang.Object[0]);
	}

	public void setGlow_hdr_scale(double value) {
		super.call("set_glow_hdr_bleed_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getGlow_hdr_luminance_cap() {
		return (double) super.call("get_glow_hdr_luminance_cap", new java.lang.Object[0]);
	}

	public void setGlow_hdr_luminance_cap(double value) {
		super.call("set_glow_hdr_luminance_cap", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getGlow_map_strength() {
		return (double) super.call("get_glow_map_strength", new java.lang.Object[0]);
	}

	public void setGlow_map_strength(double value) {
		super.call("set_glow_map_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Texture2D getGlow_map() {
		return (Texture2D) super.call("get_glow_map", new java.lang.Object[0]);
	}

	public void setGlow_map(Texture2D value) {
		super.call("set_glow_map", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isFog_enabled() {
		return (boolean) super.call("is_fog_enabled", new java.lang.Object[0]);
	}

	public void setFog_enabled(boolean value) {
		super.call("set_fog_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getFog_mode() {
		return (long) super.call("get_fog_mode", new java.lang.Object[0]);
	}

	public void setFog_mode(long value) {
		super.call("set_fog_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Color getFog_light_color() {
		return (Color) super.call("get_fog_light_color", new java.lang.Object[0]);
	}

	public void setFog_light_color(Color value) {
		super.call("set_fog_light_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getFog_light_energy() {
		return (double) super.call("get_fog_light_energy", new java.lang.Object[0]);
	}

	public void setFog_light_energy(double value) {
		super.call("set_fog_light_energy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFog_sun_scatter() {
		return (double) super.call("get_fog_sun_scatter", new java.lang.Object[0]);
	}

	public void setFog_sun_scatter(double value) {
		super.call("set_fog_sun_scatter", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFog_density() {
		return (double) super.call("get_fog_density", new java.lang.Object[0]);
	}

	public void setFog_density(double value) {
		super.call("set_fog_density", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFog_aerial_perspective() {
		return (double) super.call("get_fog_aerial_perspective", new java.lang.Object[0]);
	}

	public void setFog_aerial_perspective(double value) {
		super.call("set_fog_aerial_perspective", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFog_sky_affect() {
		return (double) super.call("get_fog_sky_affect", new java.lang.Object[0]);
	}

	public void setFog_sky_affect(double value) {
		super.call("set_fog_sky_affect", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFog_height() {
		return (double) super.call("get_fog_height", new java.lang.Object[0]);
	}

	public void setFog_height(double value) {
		super.call("set_fog_height", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFog_height_density() {
		return (double) super.call("get_fog_height_density", new java.lang.Object[0]);
	}

	public void setFog_height_density(double value) {
		super.call("set_fog_height_density", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFog_depth_curve() {
		return (double) super.call("get_fog_depth_curve", new java.lang.Object[0]);
	}

	public void setFog_depth_curve(double value) {
		super.call("set_fog_depth_curve", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFog_depth_begin() {
		return (double) super.call("get_fog_depth_begin", new java.lang.Object[0]);
	}

	public void setFog_depth_begin(double value) {
		super.call("set_fog_depth_begin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFog_depth_end() {
		return (double) super.call("get_fog_depth_end", new java.lang.Object[0]);
	}

	public void setFog_depth_end(double value) {
		super.call("set_fog_depth_end", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isVolumetric_fog_enabled() {
		return (boolean) super.call("is_volumetric_fog_enabled", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_enabled(boolean value) {
		super.call("set_volumetric_fog_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getVolumetric_fog_density() {
		return (double) super.call("get_volumetric_fog_density", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_density(double value) {
		super.call("set_volumetric_fog_density", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Color getVolumetric_fog_albedo() {
		return (Color) super.call("get_volumetric_fog_albedo", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_albedo(Color value) {
		super.call("set_volumetric_fog_albedo", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getVolumetric_fog_emission() {
		return (Color) super.call("get_volumetric_fog_emission", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_emission(Color value) {
		super.call("set_volumetric_fog_emission", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getVolumetric_fog_emission_energy() {
		return (double) super.call("get_volumetric_fog_emission_energy", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_emission_energy(double value) {
		super.call("set_volumetric_fog_emission_energy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVolumetric_fog_gi_inject() {
		return (double) super.call("get_volumetric_fog_gi_inject", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_gi_inject(double value) {
		super.call("set_volumetric_fog_gi_inject", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVolumetric_fog_anisotropy() {
		return (double) super.call("get_volumetric_fog_anisotropy", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_anisotropy(double value) {
		super.call("set_volumetric_fog_anisotropy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVolumetric_fog_length() {
		return (double) super.call("get_volumetric_fog_length", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_length(double value) {
		super.call("set_volumetric_fog_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVolumetric_fog_detail_spread() {
		return (double) super.call("get_volumetric_fog_detail_spread", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_detail_spread(double value) {
		super.call("set_volumetric_fog_detail_spread", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVolumetric_fog_ambient_inject() {
		return (double) super.call("get_volumetric_fog_ambient_inject", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_ambient_inject(double value) {
		super.call("set_volumetric_fog_ambient_inject", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVolumetric_fog_sky_affect() {
		return (double) super.call("get_volumetric_fog_sky_affect", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_sky_affect(double value) {
		super.call("set_volumetric_fog_sky_affect", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isVolumetric_fog_temporal_reprojection_enabled() {
		return (boolean) super.call("is_volumetric_fog_temporal_reprojection_enabled", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_temporal_reprojection_enabled(boolean value) {
		super.call("set_volumetric_fog_temporal_reprojection_enabled",
				new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getVolumetric_fog_temporal_reprojection_amount() {
		return (double) super.call("get_volumetric_fog_temporal_reprojection_amount", new java.lang.Object[0]);
	}

	public void setVolumetric_fog_temporal_reprojection_amount(double value) {
		super.call("set_volumetric_fog_temporal_reprojection_amount",
				new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isAdjustment_enabled() {
		return (boolean) super.call("is_adjustment_enabled", new java.lang.Object[0]);
	}

	public void setAdjustment_enabled(boolean value) {
		super.call("set_adjustment_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getAdjustment_brightness() {
		return (double) super.call("get_adjustment_brightness", new java.lang.Object[0]);
	}

	public void setAdjustment_brightness(double value) {
		super.call("set_adjustment_brightness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAdjustment_contrast() {
		return (double) super.call("get_adjustment_contrast", new java.lang.Object[0]);
	}

	public void setAdjustment_contrast(double value) {
		super.call("set_adjustment_contrast", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAdjustment_saturation() {
		return (double) super.call("get_adjustment_saturation", new java.lang.Object[0]);
	}

	public void setAdjustment_saturation(double value) {
		super.call("set_adjustment_saturation", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Object getAdjustment_color_correction() {
		return (Object) super.call("get_adjustment_color_correction", new java.lang.Object[0]);
	}

	public void setAdjustment_color_correction(Object value) {
		super.call("set_adjustment_color_correction", new java.lang.Object[]{(java.lang.Object) value});
	}
}
