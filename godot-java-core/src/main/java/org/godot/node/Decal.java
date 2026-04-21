package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector3;

public class Decal extends VisualInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_size", 3460891852L), java.util.Map.entry("set_distance_fade_begin", 373806689L),
			java.util.Map.entry("get_lower_fade", 1740695150L), java.util.Map.entry("get_emission_energy", 1740695150L),
			java.util.Map.entry("is_distance_fade_enabled", 36873697L),
			java.util.Map.entry("set_albedo_mix", 373806689L), java.util.Map.entry("set_upper_fade", 373806689L),
			java.util.Map.entry("get_albedo_mix", 1740695150L), java.util.Map.entry("set_emission_energy", 373806689L),
			java.util.Map.entry("set_normal_fade", 373806689L),
			java.util.Map.entry("set_distance_fade_length", 373806689L),
			java.util.Map.entry("set_cull_mask", 1286410249L),
			java.util.Map.entry("get_distance_fade_length", 1740695150L),
			java.util.Map.entry("set_enable_distance_fade", 2586408642L),
			java.util.Map.entry("get_normal_fade", 1740695150L), java.util.Map.entry("set_modulate", 2920490490L),
			java.util.Map.entry("get_upper_fade", 1740695150L),
			java.util.Map.entry("get_distance_fade_begin", 1740695150L),
			java.util.Map.entry("get_cull_mask", 3905245786L), java.util.Map.entry("get_size", 3360562783L),
			java.util.Map.entry("set_texture", 2086764391L), java.util.Map.entry("set_lower_fade", 373806689L),
			java.util.Map.entry("get_modulate", 3444240500L), java.util.Map.entry("get_texture", 3244119503L));

	Decal(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Decal(long nativePointer) {
		super(nativePointer);
	}

	public void set_texture(int type, Texture2D texture) {
		super.call("set_texture", new java.lang.Object[]{java.lang.Integer.valueOf(type), (java.lang.Object) texture});
	}

	public Texture2D get_texture(int type) {
		return (Texture2D) super.call("get_texture", new java.lang.Object[]{java.lang.Integer.valueOf(type)});
	}

	public boolean is_distance_fade_enabled() {
		return (boolean) super.call("is_distance_fade_enabled");
	}

	public Vector3 getSize() {
		return (Vector3) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector3 value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Object getTexture_albedo() {
		return (Object) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture_albedo(Object value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Object getTexture_normal() {
		return (Object) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture_normal(Object value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Object getTexture_orm() {
		return (Object) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture_orm(Object value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Object getTexture_emission() {
		return (Object) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture_emission(Object value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getEmission_energy() {
		return (double) super.call("get_emission_energy", new java.lang.Object[0]);
	}

	public void setEmission_energy(double value) {
		super.call("set_emission_energy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Color getModulate() {
		return (Color) super.call("get_modulate", new java.lang.Object[0]);
	}

	public void setModulate(Color value) {
		super.call("set_modulate", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getAlbedo_mix() {
		return (double) super.call("get_albedo_mix", new java.lang.Object[0]);
	}

	public void setAlbedo_mix(double value) {
		super.call("set_albedo_mix", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getNormal_fade() {
		return (double) super.call("get_normal_fade", new java.lang.Object[0]);
	}

	public void setNormal_fade(double value) {
		super.call("set_normal_fade", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getUpper_fade() {
		return (double) super.call("get_upper_fade", new java.lang.Object[0]);
	}

	public void setUpper_fade(double value) {
		super.call("set_upper_fade", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getLower_fade() {
		return (double) super.call("get_lower_fade", new java.lang.Object[0]);
	}

	public void setLower_fade(double value) {
		super.call("set_lower_fade", new java.lang.Object[]{java.lang.Double.valueOf(value)});
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

	public double getDistance_fade_length() {
		return (double) super.call("get_distance_fade_length", new java.lang.Object[0]);
	}

	public void setDistance_fade_length(double value) {
		super.call("set_distance_fade_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getCull_mask() {
		return (long) super.call("get_cull_mask", new java.lang.Object[0]);
	}

	public void setCull_mask(long value) {
		super.call("set_cull_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
