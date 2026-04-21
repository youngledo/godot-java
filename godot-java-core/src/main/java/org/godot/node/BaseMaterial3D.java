package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector3;

public class BaseMaterial3D extends Material {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_particles_anim_loop", 2586408642L),
			java.util.Map.entry("get_stencil_effect_outline_thickness", 1740695150L),
			java.util.Map.entry("set_uv2_triplanar_blend_sharpness", 373806689L),
			java.util.Map.entry("get_distance_fade_max_distance", 1740695150L),
			java.util.Map.entry("get_transmittance_boost", 1740695150L),
			java.util.Map.entry("set_particles_anim_v_frames", 1286410249L),
			java.util.Map.entry("get_backlight", 3444240500L), java.util.Map.entry("set_diffuse_mode", 1045299638L),
			java.util.Map.entry("set_specular", 373806689L), java.util.Map.entry("set_rim_tint", 373806689L),
			java.util.Map.entry("set_emission_operator", 3825128922L),
			java.util.Map.entry("set_texture_filter", 22904437L),
			java.util.Map.entry("get_stencil_effect_color", 3444240500L),
			java.util.Map.entry("set_grow_enabled", 2586408642L), java.util.Map.entry("get_point_size", 1740695150L),
			java.util.Map.entry("set_shading_mode", 3368750322L), java.util.Map.entry("get_uv1_scale", 3360562783L),
			java.util.Map.entry("set_distance_fade_min_distance", 373806689L),
			java.util.Map.entry("set_msdf_pixel_range", 373806689L),
			java.util.Map.entry("get_ao_texture_channel", 568133867L), java.util.Map.entry("get_rim", 1740695150L),
			java.util.Map.entry("get_z_clip_scale", 1740695150L), java.util.Map.entry("set_albedo", 2920490490L),
			java.util.Map.entry("set_roughness", 373806689L),
			java.util.Map.entry("get_uv2_triplanar_blend_sharpness", 1740695150L),
			java.util.Map.entry("set_alpha_scissor_threshold", 373806689L),
			java.util.Map.entry("set_heightmap_deep_parallax_min_layers", 1286410249L),
			java.util.Map.entry("set_normal_scale", 373806689L),
			java.util.Map.entry("get_particles_anim_h_frames", 3905245786L),
			java.util.Map.entry("get_transmittance_depth", 1740695150L),
			java.util.Map.entry("get_refraction_texture_channel", 568133867L),
			java.util.Map.entry("get_clearcoat", 1740695150L),
			java.util.Map.entry("get_particles_anim_v_frames", 3905245786L),
			java.util.Map.entry("get_metallic_texture_channel", 568133867L),
			java.util.Map.entry("get_heightmap_deep_parallax_flip_tangent", 36873697L),
			java.util.Map.entry("get_feature", 1965241794L), java.util.Map.entry("get_texture", 329605813L),
			java.util.Map.entry("set_specular_mode", 584737147L),
			java.util.Map.entry("set_msdf_outline_size", 373806689L),
			java.util.Map.entry("set_stencil_mode", 2272367200L),
			java.util.Map.entry("get_msdf_pixel_range", 1740695150L),
			java.util.Map.entry("set_fov_override", 373806689L),
			java.util.Map.entry("set_detail_blend_mode", 2830186259L),
			java.util.Map.entry("get_blend_mode", 4022690962L), java.util.Map.entry("get_specular", 1740695150L),
			java.util.Map.entry("set_heightmap_deep_parallax_flip_tangent", 2586408642L),
			java.util.Map.entry("set_distance_fade", 1379478617L), java.util.Map.entry("set_blend_mode", 2830186259L),
			java.util.Map.entry("get_cull_mode", 1941499586L),
			java.util.Map.entry("set_transmittance_boost", 373806689L),
			java.util.Map.entry("set_refraction_texture_channel", 744167988L),
			java.util.Map.entry("get_roughness", 1740695150L),
			java.util.Map.entry("get_heightmap_deep_parallax_min_layers", 3905245786L),
			java.util.Map.entry("set_transmittance_depth", 373806689L),
			java.util.Map.entry("get_clearcoat_roughness", 1740695150L),
			java.util.Map.entry("get_uv1_triplanar_blend_sharpness", 1740695150L),
			java.util.Map.entry("get_fov_override", 1740695150L), java.util.Map.entry("get_uv2_offset", 3360562783L),
			java.util.Map.entry("get_msdf_outline_size", 1740695150L),
			java.util.Map.entry("set_roughness_texture_channel", 744167988L),
			java.util.Map.entry("set_point_size", 373806689L), java.util.Map.entry("get_albedo", 3444240500L),
			java.util.Map.entry("set_stencil_compare", 3741726481L),
			java.util.Map.entry("set_subsurface_scattering_strength", 373806689L),
			java.util.Map.entry("set_particles_anim_h_frames", 1286410249L),
			java.util.Map.entry("get_transparency", 990903061L), java.util.Map.entry("set_flag", 3070159527L),
			java.util.Map.entry("set_metallic_texture_channel", 744167988L),
			java.util.Map.entry("set_emission_energy_multiplier", 373806689L),
			java.util.Map.entry("set_uv1_offset", 3460891852L), java.util.Map.entry("get_distance_fade", 2694575734L),
			java.util.Map.entry("get_metallic", 1740695150L), java.util.Map.entry("get_heightmap_scale", 1740695150L),
			java.util.Map.entry("set_depth_draw_mode", 1456584748L),
			java.util.Map.entry("get_depth_draw_mode", 2578197639L),
			java.util.Map.entry("get_subsurface_scattering_strength", 1740695150L),
			java.util.Map.entry("set_ao_texture_channel", 744167988L),
			java.util.Map.entry("get_shading_mode", 2132070559L), java.util.Map.entry("get_flag", 1286410065L),
			java.util.Map.entry("set_stencil_effect_outline_thickness", 373806689L),
			java.util.Map.entry("set_clearcoat_roughness", 373806689L),
			java.util.Map.entry("set_proximity_fade_distance", 373806689L),
			java.util.Map.entry("get_distance_fade_min_distance", 1740695150L),
			java.util.Map.entry("set_emission_intensity", 373806689L),
			java.util.Map.entry("set_heightmap_scale", 373806689L), java.util.Map.entry("set_anisotropy", 373806689L),
			java.util.Map.entry("get_texture_filter", 3289213076L), java.util.Map.entry("set_grow", 373806689L),
			java.util.Map.entry("set_z_clip_scale", 373806689L), java.util.Map.entry("set_detail_uv", 456801921L),
			java.util.Map.entry("get_stencil_compare", 2824600492L), java.util.Map.entry("set_emission", 2920490490L),
			java.util.Map.entry("set_alpha_antialiasing", 3212649852L),
			java.util.Map.entry("set_depth_test", 3918692338L), java.util.Map.entry("get_grow", 1740695150L),
			java.util.Map.entry("get_anisotropy", 1740695150L), java.util.Map.entry("get_diffuse_mode", 3973617136L),
			java.util.Map.entry("set_stencil_reference", 1286410249L),
			java.util.Map.entry("get_alpha_antialiasing_edge", 1740695150L),
			java.util.Map.entry("get_emission", 3444240500L),
			java.util.Map.entry("set_alpha_antialiasing_edge", 373806689L),
			java.util.Map.entry("set_heightmap_deep_parallax_flip_binormal", 2586408642L),
			java.util.Map.entry("get_alpha_scissor_threshold", 1740695150L),
			java.util.Map.entry("get_heightmap_deep_parallax_max_layers", 3905245786L),
			java.util.Map.entry("set_proximity_fade_enabled", 2586408642L),
			java.util.Map.entry("get_uv1_offset", 3360562783L), java.util.Map.entry("get_depth_test", 3434785811L),
			java.util.Map.entry("get_billboard_mode", 1283840139L),
			java.util.Map.entry("get_detail_blend_mode", 4022690962L),
			java.util.Map.entry("get_emission_intensity", 1740695150L),
			java.util.Map.entry("set_transparency", 3435651667L), java.util.Map.entry("set_uv2_offset", 3460891852L),
			java.util.Map.entry("set_heightmap_deep_parallax", 2586408642L),
			java.util.Map.entry("get_detail_uv", 2306920512L),
			java.util.Map.entry("get_roughness_texture_channel", 568133867L),
			java.util.Map.entry("set_uv1_triplanar_blend_sharpness", 373806689L),
			java.util.Map.entry("set_distance_fade_max_distance", 373806689L),
			java.util.Map.entry("set_metallic", 373806689L),
			java.util.Map.entry("set_transmittance_color", 2920490490L),
			java.util.Map.entry("get_stencil_flags", 3905245786L),
			java.util.Map.entry("get_specular_mode", 2569953298L), java.util.Map.entry("set_cull_mode", 2338909218L),
			java.util.Map.entry("set_stencil_flags", 1286410249L),
			java.util.Map.entry("is_heightmap_deep_parallax_enabled", 36873697L),
			java.util.Map.entry("set_uv1_scale", 3460891852L), java.util.Map.entry("get_emission_operator", 974205018L),
			java.util.Map.entry("get_rim_tint", 1740695150L), java.util.Map.entry("get_uv2_scale", 3360562783L),
			java.util.Map.entry("get_refraction", 1740695150L), java.util.Map.entry("set_clearcoat", 373806689L),
			java.util.Map.entry("get_heightmap_deep_parallax_flip_binormal", 36873697L),
			java.util.Map.entry("get_particles_anim_loop", 36873697L),
			java.util.Map.entry("set_stencil_effect_color", 2920490490L),
			java.util.Map.entry("is_proximity_fade_enabled", 36873697L),
			java.util.Map.entry("is_grow_enabled", 36873697L),
			java.util.Map.entry("get_proximity_fade_distance", 1740695150L),
			java.util.Map.entry("get_transmittance_color", 3444240500L),
			java.util.Map.entry("set_refraction", 373806689L), java.util.Map.entry("get_ao_light_affect", 1740695150L),
			java.util.Map.entry("get_alpha_antialiasing", 2889939400L),
			java.util.Map.entry("set_uv2_scale", 3460891852L), java.util.Map.entry("get_stencil_mode", 2908443456L),
			java.util.Map.entry("set_backlight", 2920490490L), java.util.Map.entry("set_rim", 373806689L),
			java.util.Map.entry("get_alpha_hash_scale", 1740695150L),
			java.util.Map.entry("set_ao_light_affect", 373806689L),
			java.util.Map.entry("get_normal_scale", 1740695150L), java.util.Map.entry("set_feature", 2819288693L),
			java.util.Map.entry("set_heightmap_deep_parallax_max_layers", 1286410249L),
			java.util.Map.entry("set_billboard_mode", 4202036497L), java.util.Map.entry("set_texture", 464208135L),
			java.util.Map.entry("get_emission_energy_multiplier", 1740695150L),
			java.util.Map.entry("set_alpha_hash_scale", 373806689L),
			java.util.Map.entry("get_stencil_reference", 3905245786L));

	BaseMaterial3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	BaseMaterial3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_flag(int flag, boolean enable) {
		super.call("set_flag",
				new java.lang.Object[]{java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(enable)});
	}

	public boolean get_flag(int flag) {
		return (boolean) super.call("get_flag", new java.lang.Object[]{java.lang.Integer.valueOf(flag)});
	}

	public void set_feature(int feature, boolean enable) {
		super.call("set_feature",
				new java.lang.Object[]{java.lang.Integer.valueOf(feature), java.lang.Boolean.valueOf(enable)});
	}

	public boolean get_feature(int feature) {
		return (boolean) super.call("get_feature", new java.lang.Object[]{java.lang.Integer.valueOf(feature)});
	}

	public void set_texture(int param, Texture2D texture) {
		super.call("set_texture", new java.lang.Object[]{java.lang.Integer.valueOf(param), (java.lang.Object) texture});
	}

	public Texture2D get_texture(int param) {
		return (Texture2D) super.call("get_texture", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}

	public boolean is_heightmap_deep_parallax_enabled() {
		return (boolean) super.call("is_heightmap_deep_parallax_enabled");
	}

	public boolean is_grow_enabled() {
		return (boolean) super.call("is_grow_enabled");
	}

	public boolean is_proximity_fade_enabled() {
		return (boolean) super.call("is_proximity_fade_enabled");
	}

	public long getTransparency() {
		return (long) super.call("get_transparency", new java.lang.Object[0]);
	}

	public void setTransparency(long value) {
		super.call("set_transparency", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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

	public long getBlend_mode() {
		return (long) super.call("get_blend_mode", new java.lang.Object[0]);
	}

	public void setBlend_mode(long value) {
		super.call("set_blend_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCull_mode() {
		return (long) super.call("get_cull_mode", new java.lang.Object[0]);
	}

	public void setCull_mode(long value) {
		super.call("set_cull_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDepth_draw_mode() {
		return (long) super.call("get_depth_draw_mode", new java.lang.Object[0]);
	}

	public void setDepth_draw_mode(long value) {
		super.call("set_depth_draw_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getNo_depth_test() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setNo_depth_test(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getDepth_test() {
		return (long) super.call("get_depth_test", new java.lang.Object[0]);
	}

	public void setDepth_test(long value) {
		super.call("set_depth_test", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getShading_mode() {
		return (long) super.call("get_shading_mode", new java.lang.Object[0]);
	}

	public void setShading_mode(long value) {
		super.call("set_shading_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDiffuse_mode() {
		return (long) super.call("get_diffuse_mode", new java.lang.Object[0]);
	}

	public void setDiffuse_mode(long value) {
		super.call("set_diffuse_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSpecular_mode() {
		return (long) super.call("get_specular_mode", new java.lang.Object[0]);
	}

	public void setSpecular_mode(long value) {
		super.call("set_specular_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getDisable_ambient_light() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setDisable_ambient_light(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDisable_fog() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setDisable_fog(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDisable_specular_occlusion() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setDisable_specular_occlusion(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getVertex_color_use_as_albedo() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setVertex_color_use_as_albedo(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getVertex_color_is_srgb() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setVertex_color_is_srgb(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getAlbedo_color() {
		return (Color) super.call("get_albedo", new java.lang.Object[0]);
	}

	public void setAlbedo_color(Color value) {
		super.call("set_albedo", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getAlbedo_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setAlbedo_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getAlbedo_texture_force_srgb() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setAlbedo_texture_force_srgb(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAlbedo_texture_msdf() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setAlbedo_texture_msdf(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Texture2D getOrm_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setOrm_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getMetallic() {
		return (double) super.call("get_metallic", new java.lang.Object[0]);
	}

	public void setMetallic(double value) {
		super.call("set_metallic", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMetallic_specular() {
		return (double) super.call("get_specular", new java.lang.Object[0]);
	}

	public void setMetallic_specular(double value) {
		super.call("set_specular", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Texture2D getMetallic_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setMetallic_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getMetallic_texture_channel() {
		return (long) super.call("get_metallic_texture_channel", new java.lang.Object[0]);
	}

	public void setMetallic_texture_channel(long value) {
		super.call("set_metallic_texture_channel", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getRoughness() {
		return (double) super.call("get_roughness", new java.lang.Object[0]);
	}

	public void setRoughness(double value) {
		super.call("set_roughness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Texture2D getRoughness_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setRoughness_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getRoughness_texture_channel() {
		return (long) super.call("get_roughness_texture_channel", new java.lang.Object[0]);
	}

	public void setRoughness_texture_channel(long value) {
		super.call("set_roughness_texture_channel", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getEmission_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setEmission_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getEmission() {
		return (Color) super.call("get_emission", new java.lang.Object[0]);
	}

	public void setEmission(Color value) {
		super.call("set_emission", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getEmission_energy_multiplier() {
		return (double) super.call("get_emission_energy_multiplier", new java.lang.Object[0]);
	}

	public void setEmission_energy_multiplier(double value) {
		super.call("set_emission_energy_multiplier", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getEmission_intensity() {
		return (double) super.call("get_emission_intensity", new java.lang.Object[0]);
	}

	public void setEmission_intensity(double value) {
		super.call("set_emission_intensity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getEmission_operator() {
		return (long) super.call("get_emission_operator", new java.lang.Object[0]);
	}

	public void setEmission_operator(long value) {
		super.call("set_emission_operator", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getEmission_on_uv2() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setEmission_on_uv2(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Texture2D getEmission_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setEmission_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getNormal_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setNormal_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getNormal_scale() {
		return (double) super.call("get_normal_scale", new java.lang.Object[0]);
	}

	public void setNormal_scale(double value) {
		super.call("set_normal_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Texture2D getNormal_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setNormal_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getBent_normal_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setBent_normal_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Texture2D getBent_normal_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setBent_normal_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getRim_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setRim_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getRim() {
		return (double) super.call("get_rim", new java.lang.Object[0]);
	}

	public void setRim(double value) {
		super.call("set_rim", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRim_tint() {
		return (double) super.call("get_rim_tint", new java.lang.Object[0]);
	}

	public void setRim_tint(double value) {
		super.call("set_rim_tint", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Texture2D getRim_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setRim_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getClearcoat_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setClearcoat_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getClearcoat() {
		return (double) super.call("get_clearcoat", new java.lang.Object[0]);
	}

	public void setClearcoat(double value) {
		super.call("set_clearcoat", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getClearcoat_roughness() {
		return (double) super.call("get_clearcoat_roughness", new java.lang.Object[0]);
	}

	public void setClearcoat_roughness(double value) {
		super.call("set_clearcoat_roughness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Texture2D getClearcoat_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setClearcoat_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getAnisotropy_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setAnisotropy_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getAnisotropy() {
		return (double) super.call("get_anisotropy", new java.lang.Object[0]);
	}

	public void setAnisotropy(double value) {
		super.call("set_anisotropy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Texture2D getAnisotropy_flowmap() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setAnisotropy_flowmap(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getAo_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setAo_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getAo_light_affect() {
		return (double) super.call("get_ao_light_affect", new java.lang.Object[0]);
	}

	public void setAo_light_affect(double value) {
		super.call("set_ao_light_affect", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Texture2D getAo_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setAo_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getAo_on_uv2() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setAo_on_uv2(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getAo_texture_channel() {
		return (long) super.call("get_ao_texture_channel", new java.lang.Object[0]);
	}

	public void setAo_texture_channel(long value) {
		super.call("set_ao_texture_channel", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getHeightmap_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setHeightmap_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getHeightmap_scale() {
		return (double) super.call("get_heightmap_scale", new java.lang.Object[0]);
	}

	public void setHeightmap_scale(double value) {
		super.call("set_heightmap_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isHeightmap_deep_parallax() {
		return (boolean) super.call("is_heightmap_deep_parallax_enabled", new java.lang.Object[0]);
	}

	public void setHeightmap_deep_parallax(boolean value) {
		super.call("set_heightmap_deep_parallax", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getHeightmap_min_layers() {
		return (long) super.call("get_heightmap_deep_parallax_min_layers", new java.lang.Object[0]);
	}

	public void setHeightmap_min_layers(long value) {
		super.call("set_heightmap_deep_parallax_min_layers", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getHeightmap_max_layers() {
		return (long) super.call("get_heightmap_deep_parallax_max_layers", new java.lang.Object[0]);
	}

	public void setHeightmap_max_layers(long value) {
		super.call("set_heightmap_deep_parallax_max_layers", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getHeightmap_flip_tangent() {
		return (boolean) super.call("get_heightmap_deep_parallax_flip_tangent", new java.lang.Object[0]);
	}

	public void setHeightmap_flip_tangent(boolean value) {
		super.call("set_heightmap_deep_parallax_flip_tangent",
				new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getHeightmap_flip_binormal() {
		return (boolean) super.call("get_heightmap_deep_parallax_flip_binormal", new java.lang.Object[0]);
	}

	public void setHeightmap_flip_binormal(boolean value) {
		super.call("set_heightmap_deep_parallax_flip_binormal",
				new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Texture2D getHeightmap_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setHeightmap_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getHeightmap_flip_texture() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setHeightmap_flip_texture(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getSubsurf_scatter_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setSubsurf_scatter_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getSubsurf_scatter_strength() {
		return (double) super.call("get_subsurface_scattering_strength", new java.lang.Object[0]);
	}

	public void setSubsurf_scatter_strength(double value) {
		super.call("set_subsurface_scattering_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getSubsurf_scatter_skin_mode() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setSubsurf_scatter_skin_mode(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Texture2D getSubsurf_scatter_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setSubsurf_scatter_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getSubsurf_scatter_transmittance_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setSubsurf_scatter_transmittance_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getSubsurf_scatter_transmittance_color() {
		return (Color) super.call("get_transmittance_color", new java.lang.Object[0]);
	}

	public void setSubsurf_scatter_transmittance_color(Color value) {
		super.call("set_transmittance_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getSubsurf_scatter_transmittance_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setSubsurf_scatter_transmittance_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getSubsurf_scatter_transmittance_depth() {
		return (double) super.call("get_transmittance_depth", new java.lang.Object[0]);
	}

	public void setSubsurf_scatter_transmittance_depth(double value) {
		super.call("set_transmittance_depth", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSubsurf_scatter_transmittance_boost() {
		return (double) super.call("get_transmittance_boost", new java.lang.Object[0]);
	}

	public void setSubsurf_scatter_transmittance_boost(double value) {
		super.call("set_transmittance_boost", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getBacklight_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setBacklight_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getBacklight() {
		return (Color) super.call("get_backlight", new java.lang.Object[0]);
	}

	public void setBacklight(Color value) {
		super.call("set_backlight", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getBacklight_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setBacklight_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getRefraction_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setRefraction_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getRefraction_scale() {
		return (double) super.call("get_refraction", new java.lang.Object[0]);
	}

	public void setRefraction_scale(double value) {
		super.call("set_refraction", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Texture2D getRefraction_texture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setRefraction_texture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getRefraction_texture_channel() {
		return (long) super.call("get_refraction_texture_channel", new java.lang.Object[0]);
	}

	public void setRefraction_texture_channel(long value) {
		super.call("set_refraction_texture_channel", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getDetail_enabled() {
		return (boolean) super.call("get_feature", new java.lang.Object[0]);
	}

	public void setDetail_enabled(boolean value) {
		super.call("set_feature", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Texture2D getDetail_mask() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setDetail_mask(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getDetail_blend_mode() {
		return (long) super.call("get_detail_blend_mode", new java.lang.Object[0]);
	}

	public void setDetail_blend_mode(long value) {
		super.call("set_detail_blend_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDetail_uv_layer() {
		return (long) super.call("get_detail_uv", new java.lang.Object[0]);
	}

	public void setDetail_uv_layer(long value) {
		super.call("set_detail_uv", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Texture2D getDetail_albedo() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setDetail_albedo(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getDetail_normal() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setDetail_normal(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getUv1_scale() {
		return (Vector3) super.call("get_uv1_scale", new java.lang.Object[0]);
	}

	public void setUv1_scale(Vector3 value) {
		super.call("set_uv1_scale", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getUv1_offset() {
		return (Vector3) super.call("get_uv1_offset", new java.lang.Object[0]);
	}

	public void setUv1_offset(Vector3 value) {
		super.call("set_uv1_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getUv1_triplanar() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setUv1_triplanar(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getUv1_triplanar_sharpness() {
		return (double) super.call("get_uv1_triplanar_blend_sharpness", new java.lang.Object[0]);
	}

	public void setUv1_triplanar_sharpness(double value) {
		super.call("set_uv1_triplanar_blend_sharpness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getUv1_world_triplanar() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setUv1_world_triplanar(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector3 getUv2_scale() {
		return (Vector3) super.call("get_uv2_scale", new java.lang.Object[0]);
	}

	public void setUv2_scale(Vector3 value) {
		super.call("set_uv2_scale", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getUv2_offset() {
		return (Vector3) super.call("get_uv2_offset", new java.lang.Object[0]);
	}

	public void setUv2_offset(Vector3 value) {
		super.call("set_uv2_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getUv2_triplanar() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setUv2_triplanar(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getUv2_triplanar_sharpness() {
		return (double) super.call("get_uv2_triplanar_blend_sharpness", new java.lang.Object[0]);
	}

	public void setUv2_triplanar_sharpness(double value) {
		super.call("set_uv2_triplanar_blend_sharpness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getUv2_world_triplanar() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setUv2_world_triplanar(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getTexture_filter() {
		return (long) super.call("get_texture_filter", new java.lang.Object[0]);
	}

	public void setTexture_filter(long value) {
		super.call("set_texture_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getTexture_repeat() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setTexture_repeat(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDisable_receive_shadows() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setDisable_receive_shadows(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getShadow_to_opacity() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setShadow_to_opacity(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getBillboard_mode() {
		return (long) super.call("get_billboard_mode", new java.lang.Object[0]);
	}

	public void setBillboard_mode(long value) {
		super.call("set_billboard_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getBillboard_keep_scale() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setBillboard_keep_scale(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getParticles_anim_h_frames() {
		return (long) super.call("get_particles_anim_h_frames", new java.lang.Object[0]);
	}

	public void setParticles_anim_h_frames(long value) {
		super.call("set_particles_anim_h_frames", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getParticles_anim_v_frames() {
		return (long) super.call("get_particles_anim_v_frames", new java.lang.Object[0]);
	}

	public void setParticles_anim_v_frames(long value) {
		super.call("set_particles_anim_v_frames", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getParticles_anim_loop() {
		return (boolean) super.call("get_particles_anim_loop", new java.lang.Object[0]);
	}

	public void setParticles_anim_loop(boolean value) {
		super.call("set_particles_anim_loop", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isGrow() {
		return (boolean) super.call("is_grow_enabled", new java.lang.Object[0]);
	}

	public void setGrow(boolean value) {
		super.call("set_grow_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getGrow_amount() {
		return (double) super.call("get_grow", new java.lang.Object[0]);
	}

	public void setGrow_amount(double value) {
		super.call("set_grow", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getFixed_size() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setFixed_size(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getUse_point_size() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setUse_point_size(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getPoint_size() {
		return (double) super.call("get_point_size", new java.lang.Object[0]);
	}

	public void setPoint_size(double value) {
		super.call("set_point_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getUse_particle_trails() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setUse_particle_trails(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getUse_z_clip_scale() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setUse_z_clip_scale(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getZ_clip_scale() {
		return (double) super.call("get_z_clip_scale", new java.lang.Object[0]);
	}

	public void setZ_clip_scale(double value) {
		super.call("set_z_clip_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getUse_fov_override() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setUse_fov_override(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getFov_override() {
		return (double) super.call("get_fov_override", new java.lang.Object[0]);
	}

	public void setFov_override(double value) {
		super.call("set_fov_override", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isProximity_fade_enabled() {
		return (boolean) super.call("is_proximity_fade_enabled", new java.lang.Object[0]);
	}

	public void setProximity_fade_enabled(boolean value) {
		super.call("set_proximity_fade_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getProximity_fade_distance() {
		return (double) super.call("get_proximity_fade_distance", new java.lang.Object[0]);
	}

	public void setProximity_fade_distance(double value) {
		super.call("set_proximity_fade_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMsdf_pixel_range() {
		return (double) super.call("get_msdf_pixel_range", new java.lang.Object[0]);
	}

	public void setMsdf_pixel_range(double value) {
		super.call("set_msdf_pixel_range", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMsdf_outline_size() {
		return (double) super.call("get_msdf_outline_size", new java.lang.Object[0]);
	}

	public void setMsdf_outline_size(double value) {
		super.call("set_msdf_outline_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getDistance_fade_mode() {
		return (long) super.call("get_distance_fade", new java.lang.Object[0]);
	}

	public void setDistance_fade_mode(long value) {
		super.call("set_distance_fade", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getDistance_fade_min_distance() {
		return (double) super.call("get_distance_fade_min_distance", new java.lang.Object[0]);
	}

	public void setDistance_fade_min_distance(double value) {
		super.call("set_distance_fade_min_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDistance_fade_max_distance() {
		return (double) super.call("get_distance_fade_max_distance", new java.lang.Object[0]);
	}

	public void setDistance_fade_max_distance(double value) {
		super.call("set_distance_fade_max_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getStencil_mode() {
		return (long) super.call("get_stencil_mode", new java.lang.Object[0]);
	}

	public void setStencil_mode(long value) {
		super.call("set_stencil_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getStencil_flags() {
		return (long) super.call("get_stencil_flags", new java.lang.Object[0]);
	}

	public void setStencil_flags(long value) {
		super.call("set_stencil_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getStencil_compare() {
		return (long) super.call("get_stencil_compare", new java.lang.Object[0]);
	}

	public void setStencil_compare(long value) {
		super.call("set_stencil_compare", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getStencil_reference() {
		return (long) super.call("get_stencil_reference", new java.lang.Object[0]);
	}

	public void setStencil_reference(long value) {
		super.call("set_stencil_reference", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Color getStencil_color() {
		return (Color) super.call("get_stencil_effect_color", new java.lang.Object[0]);
	}

	public void setStencil_color(Color value) {
		super.call("set_stencil_effect_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getStencil_outline_thickness() {
		return (double) super.call("get_stencil_effect_outline_thickness", new java.lang.Object[0]);
	}

	public void setStencil_outline_thickness(double value) {
		super.call("set_stencil_effect_outline_thickness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
