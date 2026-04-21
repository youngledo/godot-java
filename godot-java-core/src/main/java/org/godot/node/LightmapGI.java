package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class LightmapGI extends VisualInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_use_denoiser", 2586408642L), java.util.Map.entry("get_bounces", 3905245786L),
			java.util.Map.entry("set_shadowmask_mode", 3451066572L),
			java.util.Map.entry("get_denoiser_strength", 1740695150L),
			java.util.Map.entry("set_light_data", 1790597277L), java.util.Map.entry("get_generate_probes", 3930596226L),
			java.util.Map.entry("get_bias", 1740695150L),
			java.util.Map.entry("is_using_texture_for_bounces", 36873697L),
			java.util.Map.entry("is_using_denoiser", 36873697L), java.util.Map.entry("get_shadowmask_mode", 785478560L),
			java.util.Map.entry("is_interior", 36873697L), java.util.Map.entry("set_directional", 2586408642L),
			java.util.Map.entry("get_max_texture_size", 3905245786L),
			java.util.Map.entry("is_supersampling_enabled", 36873697L),
			java.util.Map.entry("set_max_texture_size", 1286410249L),
			java.util.Map.entry("get_camera_attributes", 3921283215L),
			java.util.Map.entry("set_generate_probes", 549981046L),
			java.util.Map.entry("set_environment_custom_color", 2920490490L),
			java.util.Map.entry("get_environment_custom_color", 3444240500L),
			java.util.Map.entry("set_environment_custom_sky", 3336722921L),
			java.util.Map.entry("set_texel_scale", 373806689L), java.util.Map.entry("set_interior", 2586408642L),
			java.util.Map.entry("get_bounce_indirect_energy", 1740695150L), java.util.Map.entry("set_bias", 373806689L),
			java.util.Map.entry("set_bounce_indirect_energy", 373806689L),
			java.util.Map.entry("set_environment_custom_energy", 373806689L),
			java.util.Map.entry("set_use_texture_for_bounces", 2586408642L),
			java.util.Map.entry("set_bake_quality", 1192215803L),
			java.util.Map.entry("get_environment_custom_energy", 1740695150L),
			java.util.Map.entry("get_light_data", 290354153L), java.util.Map.entry("get_texel_scale", 1740695150L),
			java.util.Map.entry("is_directional", 36873697L), java.util.Map.entry("set_camera_attributes", 2817810567L),
			java.util.Map.entry("set_denoiser_strength", 373806689L),
			java.util.Map.entry("set_supersampling_enabled", 2586408642L),
			java.util.Map.entry("get_supersampling_factor", 1740695150L),
			java.util.Map.entry("set_supersampling_factor", 373806689L),
			java.util.Map.entry("set_bounces", 1286410249L), java.util.Map.entry("get_bake_quality", 688832735L),
			java.util.Map.entry("get_environment_mode", 4128646479L),
			java.util.Map.entry("get_denoiser_range", 3905245786L),
			java.util.Map.entry("get_environment_custom_sky", 1177136966L),
			java.util.Map.entry("set_environment_mode", 2282650285L),
			java.util.Map.entry("set_denoiser_range", 1286410249L));

	LightmapGI(MemorySegment nativePointer) {
		super(nativePointer);
	}

	LightmapGI(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_supersampling_enabled() {
		return (boolean) super.call("is_supersampling_enabled");
	}

	public boolean is_using_denoiser() {
		return (boolean) super.call("is_using_denoiser");
	}

	public boolean is_interior() {
		return (boolean) super.call("is_interior");
	}

	public boolean is_directional() {
		return (boolean) super.call("is_directional");
	}

	public boolean is_using_texture_for_bounces() {
		return (boolean) super.call("is_using_texture_for_bounces");
	}

	public long getQuality() {
		return (long) super.call("get_bake_quality", new java.lang.Object[0]);
	}

	public void setQuality(long value) {
		super.call("set_bake_quality", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isSupersampling() {
		return (boolean) super.call("is_supersampling_enabled", new java.lang.Object[0]);
	}

	public void setSupersampling(boolean value) {
		super.call("set_supersampling_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getSupersampling_factor() {
		return (double) super.call("get_supersampling_factor", new java.lang.Object[0]);
	}

	public void setSupersampling_factor(double value) {
		super.call("set_supersampling_factor", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getBounces() {
		return (long) super.call("get_bounces", new java.lang.Object[0]);
	}

	public void setBounces(long value) {
		super.call("set_bounces", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getBounce_indirect_energy() {
		return (double) super.call("get_bounce_indirect_energy", new java.lang.Object[0]);
	}

	public void setBounce_indirect_energy(double value) {
		super.call("set_bounce_indirect_energy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isDirectional() {
		return (boolean) super.call("is_directional", new java.lang.Object[0]);
	}

	public void setDirectional(boolean value) {
		super.call("set_directional", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getShadowmask_mode() {
		return (long) super.call("get_shadowmask_mode", new java.lang.Object[0]);
	}

	public void setShadowmask_mode(long value) {
		super.call("set_shadowmask_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isUse_texture_for_bounces() {
		return (boolean) super.call("is_using_texture_for_bounces", new java.lang.Object[0]);
	}

	public void setUse_texture_for_bounces(boolean value) {
		super.call("set_use_texture_for_bounces", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isInterior() {
		return (boolean) super.call("is_interior", new java.lang.Object[0]);
	}

	public void setInterior(boolean value) {
		super.call("set_interior", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isUse_denoiser() {
		return (boolean) super.call("is_using_denoiser", new java.lang.Object[0]);
	}

	public void setUse_denoiser(boolean value) {
		super.call("set_use_denoiser", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getDenoiser_strength() {
		return (double) super.call("get_denoiser_strength", new java.lang.Object[0]);
	}

	public void setDenoiser_strength(double value) {
		super.call("set_denoiser_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getDenoiser_range() {
		return (long) super.call("get_denoiser_range", new java.lang.Object[0]);
	}

	public void setDenoiser_range(long value) {
		super.call("set_denoiser_range", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getBias() {
		return (double) super.call("get_bias", new java.lang.Object[0]);
	}

	public void setBias(double value) {
		super.call("set_bias", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTexel_scale() {
		return (double) super.call("get_texel_scale", new java.lang.Object[0]);
	}

	public void setTexel_scale(double value) {
		super.call("set_texel_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getMax_texture_size() {
		return (long) super.call("get_max_texture_size", new java.lang.Object[0]);
	}

	public void setMax_texture_size(long value) {
		super.call("set_max_texture_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getEnvironment_mode() {
		return (long) super.call("get_environment_mode", new java.lang.Object[0]);
	}

	public void setEnvironment_mode(long value) {
		super.call("set_environment_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Sky getEnvironment_custom_sky() {
		return (Sky) super.call("get_environment_custom_sky", new java.lang.Object[0]);
	}

	public void setEnvironment_custom_sky(Sky value) {
		super.call("set_environment_custom_sky", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getEnvironment_custom_color() {
		return (Color) super.call("get_environment_custom_color", new java.lang.Object[0]);
	}

	public void setEnvironment_custom_color(Color value) {
		super.call("set_environment_custom_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getEnvironment_custom_energy() {
		return (double) super.call("get_environment_custom_energy", new java.lang.Object[0]);
	}

	public void setEnvironment_custom_energy(double value) {
		super.call("set_environment_custom_energy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Object getCamera_attributes() {
		return (Object) super.call("get_camera_attributes", new java.lang.Object[0]);
	}

	public void setCamera_attributes(Object value) {
		super.call("set_camera_attributes", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getGenerate_probes_subdiv() {
		return (long) super.call("get_generate_probes", new java.lang.Object[0]);
	}

	public void setGenerate_probes_subdiv(long value) {
		super.call("set_generate_probes", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public LightmapGIData getLight_data() {
		return (LightmapGIData) super.call("get_light_data", new java.lang.Object[0]);
	}

	public void setLight_data(LightmapGIData value) {
		super.call("set_light_data", new java.lang.Object[]{(java.lang.Object) value});
	}
}
