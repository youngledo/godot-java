package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class Light3D extends VisualInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_correlated_color", 3444240500L), java.util.Map.entry("get_param", 1844084987L),
			java.util.Map.entry("set_shadow", 2586408642L), java.util.Map.entry("get_projector", 3635182373L),
			java.util.Map.entry("get_temperature", 1740695150L), java.util.Map.entry("set_editor_only", 2586408642L),
			java.util.Map.entry("get_color", 3444240500L), java.util.Map.entry("set_distance_fade_length", 373806689L),
			java.util.Map.entry("get_distance_fade_length", 1740695150L),
			java.util.Map.entry("get_bake_mode", 371737608L),
			java.util.Map.entry("get_shadow_caster_mask", 3905245786L), java.util.Map.entry("has_shadow", 36873697L),
			java.util.Map.entry("get_cull_mask", 3905245786L),
			java.util.Map.entry("get_distance_fade_begin", 1740695150L),
			java.util.Map.entry("set_temperature", 373806689L), java.util.Map.entry("set_projector", 4051416890L),
			java.util.Map.entry("set_distance_fade_begin", 373806689L),
			java.util.Map.entry("is_editor_only", 36873697L),
			java.util.Map.entry("get_shadow_reverse_cull_face", 36873697L),
			java.util.Map.entry("is_distance_fade_enabled", 36873697L),
			java.util.Map.entry("set_negative", 2586408642L), java.util.Map.entry("set_param", 1722734213L),
			java.util.Map.entry("set_shadow_caster_mask", 1286410249L), java.util.Map.entry("set_color", 2920490490L),
			java.util.Map.entry("set_cull_mask", 1286410249L),
			java.util.Map.entry("set_distance_fade_shadow", 373806689L),
			java.util.Map.entry("get_distance_fade_shadow", 1740695150L),
			java.util.Map.entry("set_enable_distance_fade", 2586408642L),
			java.util.Map.entry("set_shadow_reverse_cull_face", 2586408642L),
			java.util.Map.entry("set_bake_mode", 37739303L), java.util.Map.entry("is_negative", 36873697L));

	Light3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Light3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_editor_only() {
		return (boolean) super.call("is_editor_only");
	}

	public void set_param(int param, double value) {
		super.call("set_param",
				new java.lang.Object[]{java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double get_param(int param) {
		return (double) super.call("get_param", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}

	public boolean has_shadow() {
		return (boolean) super.call("has_shadow");
	}

	public boolean is_negative() {
		return (boolean) super.call("is_negative");
	}

	public boolean is_distance_fade_enabled() {
		return (boolean) super.call("is_distance_fade_enabled");
	}

	public double getLight_intensity_lumens() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setLight_intensity_lumens(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getLight_intensity_lux() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setLight_intensity_lux(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getLight_temperature() {
		return (double) super.call("get_temperature", new java.lang.Object[0]);
	}

	public void setLight_temperature(double value) {
		super.call("set_temperature", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Color getLight_color() {
		return (Color) super.call("get_color", new java.lang.Object[0]);
	}

	public void setLight_color(Color value) {
		super.call("set_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getLight_energy() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setLight_energy(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getLight_indirect_energy() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setLight_indirect_energy(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getLight_volumetric_fog_energy() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setLight_volumetric_fog_energy(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Object getLight_projector() {
		return (Object) super.call("get_projector", new java.lang.Object[0]);
	}

	public void setLight_projector(Object value) {
		super.call("set_projector", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getLight_size() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setLight_size(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getLight_angular_distance() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setLight_angular_distance(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isLight_negative() {
		return (boolean) super.call("is_negative", new java.lang.Object[0]);
	}

	public void setLight_negative(boolean value) {
		super.call("set_negative", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getLight_specular() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setLight_specular(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getLight_bake_mode() {
		return (long) super.call("get_bake_mode", new java.lang.Object[0]);
	}

	public void setLight_bake_mode(long value) {
		super.call("set_bake_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getLight_cull_mask() {
		return (long) super.call("get_cull_mask", new java.lang.Object[0]);
	}

	public void setLight_cull_mask(long value) {
		super.call("set_cull_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getShadow_enabled() {
		return (boolean) super.call("has_shadow", new java.lang.Object[0]);
	}

	public void setShadow_enabled(boolean value) {
		super.call("set_shadow", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getShadow_bias() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setShadow_bias(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getShadow_normal_bias() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setShadow_normal_bias(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getShadow_reverse_cull_face() {
		return (boolean) super.call("get_shadow_reverse_cull_face", new java.lang.Object[0]);
	}

	public void setShadow_reverse_cull_face(boolean value) {
		super.call("set_shadow_reverse_cull_face", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getShadow_transmittance_bias() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setShadow_transmittance_bias(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getShadow_opacity() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setShadow_opacity(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getShadow_blur() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setShadow_blur(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getShadow_caster_mask() {
		return (long) super.call("get_shadow_caster_mask", new java.lang.Object[0]);
	}

	public void setShadow_caster_mask(long value) {
		super.call("set_shadow_caster_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isDistance_fade_enabled() {
		return (boolean) super.call("is_distance_fade_enabled", new java.lang.Object[0]);
	}

	public void setDistance_fade_enabled(boolean value) {
		super.call("set_enable_distance_fade", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getDistance_fade_begin() {
		return (double) super.call("get_distance_fade_begin", new java.lang.Object[0]);
	}

	public void setDistance_fade_begin(double value) {
		super.call("set_distance_fade_begin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDistance_fade_shadow() {
		return (double) super.call("get_distance_fade_shadow", new java.lang.Object[0]);
	}

	public void setDistance_fade_shadow(double value) {
		super.call("set_distance_fade_shadow", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDistance_fade_length() {
		return (double) super.call("get_distance_fade_length", new java.lang.Object[0]);
	}

	public void setDistance_fade_length(double value) {
		super.call("set_distance_fade_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isEditor_only() {
		return (boolean) super.call("is_editor_only", new java.lang.Object[0]);
	}

	public void setEditor_only(boolean value) {
		super.call("set_editor_only", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
