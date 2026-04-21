package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.AABB;

public class GeometryInstance3D extends VisualInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_lod_bias", 1740695150L),
			java.util.Map.entry("get_visibility_range_end_margin", 1740695150L),
			java.util.Map.entry("get_visibility_range_end", 1740695150L),
			java.util.Map.entry("set_material_override", 2757459619L),
			java.util.Map.entry("set_visibility_range_fade_mode", 1440117808L),
			java.util.Map.entry("set_gi_mode", 2548557163L), java.util.Map.entry("get_material_overlay", 5934680L),
			java.util.Map.entry("set_lightmap_texel_scale", 373806689L),
			java.util.Map.entry("get_custom_aabb", 1068685055L),
			java.util.Map.entry("get_lightmap_texel_scale", 1740695150L),
			java.util.Map.entry("set_lightmap_scale", 2462696582L),
			java.util.Map.entry("get_lightmap_scale", 798767852L),
			java.util.Map.entry("get_visibility_range_begin_margin", 1740695150L),
			java.util.Map.entry("get_visibility_range_fade_mode", 2067221882L),
			java.util.Map.entry("is_ignoring_occlusion_culling", 2240911060L),
			java.util.Map.entry("set_lod_bias", 373806689L),
			java.util.Map.entry("set_visibility_range_end_margin", 373806689L),
			java.util.Map.entry("set_extra_cull_margin", 373806689L),
			java.util.Map.entry("get_visibility_range_begin", 1740695150L),
			java.util.Map.entry("set_material_overlay", 2757459619L),
			java.util.Map.entry("get_material_override", 5934680L),
			java.util.Map.entry("set_visibility_range_end", 373806689L),
			java.util.Map.entry("set_visibility_range_begin", 373806689L),
			java.util.Map.entry("get_cast_shadows_setting", 3383019359L),
			java.util.Map.entry("get_transparency", 1740695150L), java.util.Map.entry("set_transparency", 373806689L),
			java.util.Map.entry("set_custom_aabb", 259215842L),
			java.util.Map.entry("get_instance_shader_parameter", 2760726917L),
			java.util.Map.entry("set_cast_shadows_setting", 856677339L),
			java.util.Map.entry("set_visibility_range_begin_margin", 373806689L),
			java.util.Map.entry("get_gi_mode", 2188566509L), java.util.Map.entry("get_extra_cull_margin", 1740695150L),
			java.util.Map.entry("set_instance_shader_parameter", 3776071444L),
			java.util.Map.entry("set_ignore_occlusion_culling", 2586408642L));

	GeometryInstance3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GeometryInstance3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_instance_shader_parameter(String name, Object value) {
		super.call("set_instance_shader_parameter",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) value});
	}

	public Object get_instance_shader_parameter(String name) {
		return (Object) super.call("get_instance_shader_parameter", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean is_ignoring_occlusion_culling() {
		return (boolean) super.call("is_ignoring_occlusion_culling");
	}

	public Object getMaterial_override() {
		return (Object) super.call("get_material_override", new java.lang.Object[0]);
	}

	public void setMaterial_override(Object value) {
		super.call("set_material_override", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Object getMaterial_overlay() {
		return (Object) super.call("get_material_overlay", new java.lang.Object[0]);
	}

	public void setMaterial_overlay(Object value) {
		super.call("set_material_overlay", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getTransparency() {
		return (double) super.call("get_transparency", new java.lang.Object[0]);
	}

	public void setTransparency(double value) {
		super.call("set_transparency", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getCast_shadow() {
		return (long) super.call("get_cast_shadows_setting", new java.lang.Object[0]);
	}

	public void setCast_shadow(long value) {
		super.call("set_cast_shadows_setting", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getExtra_cull_margin() {
		return (double) super.call("get_extra_cull_margin", new java.lang.Object[0]);
	}

	public void setExtra_cull_margin(double value) {
		super.call("set_extra_cull_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public AABB getCustom_aabb() {
		return (AABB) super.call("get_custom_aabb", new java.lang.Object[0]);
	}

	public void setCustom_aabb(AABB value) {
		super.call("set_custom_aabb", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getLod_bias() {
		return (double) super.call("get_lod_bias", new java.lang.Object[0]);
	}

	public void setLod_bias(double value) {
		super.call("set_lod_bias", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isIgnore_occlusion_culling() {
		return (boolean) super.call("is_ignoring_occlusion_culling", new java.lang.Object[0]);
	}

	public void setIgnore_occlusion_culling(boolean value) {
		super.call("set_ignore_occlusion_culling", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getGi_mode() {
		return (long) super.call("get_gi_mode", new java.lang.Object[0]);
	}

	public void setGi_mode(long value) {
		super.call("set_gi_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getGi_lightmap_texel_scale() {
		return (double) super.call("get_lightmap_texel_scale", new java.lang.Object[0]);
	}

	public void setGi_lightmap_texel_scale(double value) {
		super.call("set_lightmap_texel_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getGi_lightmap_scale() {
		return (long) super.call("get_lightmap_scale", new java.lang.Object[0]);
	}

	public void setGi_lightmap_scale(long value) {
		super.call("set_lightmap_scale", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getVisibility_range_begin() {
		return (double) super.call("get_visibility_range_begin", new java.lang.Object[0]);
	}

	public void setVisibility_range_begin(double value) {
		super.call("set_visibility_range_begin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVisibility_range_begin_margin() {
		return (double) super.call("get_visibility_range_begin_margin", new java.lang.Object[0]);
	}

	public void setVisibility_range_begin_margin(double value) {
		super.call("set_visibility_range_begin_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVisibility_range_end() {
		return (double) super.call("get_visibility_range_end", new java.lang.Object[0]);
	}

	public void setVisibility_range_end(double value) {
		super.call("set_visibility_range_end", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVisibility_range_end_margin() {
		return (double) super.call("get_visibility_range_end_margin", new java.lang.Object[0]);
	}

	public void setVisibility_range_end_margin(double value) {
		super.call("set_visibility_range_end_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getVisibility_range_fade_mode() {
		return (long) super.call("get_visibility_range_fade_mode", new java.lang.Object[0]);
	}

	public void setVisibility_range_fade_mode(long value) {
		super.call("set_visibility_range_fade_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
