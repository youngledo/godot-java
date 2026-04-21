package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class ProceduralSkyMaterial extends Material {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_ground_bottom_color", 2920490490L),
			java.util.Map.entry("get_sky_top_color", 3444240500L),
			java.util.Map.entry("set_ground_energy_multiplier", 373806689L),
			java.util.Map.entry("get_ground_curve", 1740695150L),
			java.util.Map.entry("get_ground_bottom_color", 3444240500L),
			java.util.Map.entry("get_use_debanding", 36873697L), java.util.Map.entry("get_sky_curve", 1740695150L),
			java.util.Map.entry("get_sky_cover", 3635182373L), java.util.Map.entry("set_sky_top_color", 2920490490L),
			java.util.Map.entry("set_sky_cover_modulate", 2920490490L),
			java.util.Map.entry("get_sky_horizon_color", 3444240500L),
			java.util.Map.entry("get_sun_angle_max", 1740695150L),
			java.util.Map.entry("get_ground_horizon_color", 3444240500L),
			java.util.Map.entry("get_sun_curve", 1740695150L), java.util.Map.entry("set_energy_multiplier", 373806689L),
			java.util.Map.entry("get_energy_multiplier", 1740695150L),
			java.util.Map.entry("set_sky_horizon_color", 2920490490L),
			java.util.Map.entry("set_ground_horizon_color", 2920490490L),
			java.util.Map.entry("set_use_debanding", 2586408642L),
			java.util.Map.entry("get_ground_energy_multiplier", 1740695150L),
			java.util.Map.entry("set_sun_angle_max", 373806689L), java.util.Map.entry("set_ground_curve", 373806689L),
			java.util.Map.entry("get_sky_cover_modulate", 3444240500L),
			java.util.Map.entry("set_sun_curve", 373806689L),
			java.util.Map.entry("get_sky_energy_multiplier", 1740695150L),
			java.util.Map.entry("set_sky_energy_multiplier", 373806689L),
			java.util.Map.entry("set_sky_cover", 4051416890L), java.util.Map.entry("set_sky_curve", 373806689L));

	ProceduralSkyMaterial(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ProceduralSkyMaterial(long nativePointer) {
		super(nativePointer);
	}

	public Color getSky_top_color() {
		return (Color) super.call("get_sky_top_color", new java.lang.Object[0]);
	}

	public void setSky_top_color(Color value) {
		super.call("set_sky_top_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getSky_horizon_color() {
		return (Color) super.call("get_sky_horizon_color", new java.lang.Object[0]);
	}

	public void setSky_horizon_color(Color value) {
		super.call("set_sky_horizon_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getSky_curve() {
		return (double) super.call("get_sky_curve", new java.lang.Object[0]);
	}

	public void setSky_curve(double value) {
		super.call("set_sky_curve", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSky_energy_multiplier() {
		return (double) super.call("get_sky_energy_multiplier", new java.lang.Object[0]);
	}

	public void setSky_energy_multiplier(double value) {
		super.call("set_sky_energy_multiplier", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Texture2D getSky_cover() {
		return (Texture2D) super.call("get_sky_cover", new java.lang.Object[0]);
	}

	public void setSky_cover(Texture2D value) {
		super.call("set_sky_cover", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getSky_cover_modulate() {
		return (Color) super.call("get_sky_cover_modulate", new java.lang.Object[0]);
	}

	public void setSky_cover_modulate(Color value) {
		super.call("set_sky_cover_modulate", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getGround_bottom_color() {
		return (Color) super.call("get_ground_bottom_color", new java.lang.Object[0]);
	}

	public void setGround_bottom_color(Color value) {
		super.call("set_ground_bottom_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getGround_horizon_color() {
		return (Color) super.call("get_ground_horizon_color", new java.lang.Object[0]);
	}

	public void setGround_horizon_color(Color value) {
		super.call("set_ground_horizon_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getGround_curve() {
		return (double) super.call("get_ground_curve", new java.lang.Object[0]);
	}

	public void setGround_curve(double value) {
		super.call("set_ground_curve", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getGround_energy_multiplier() {
		return (double) super.call("get_ground_energy_multiplier", new java.lang.Object[0]);
	}

	public void setGround_energy_multiplier(double value) {
		super.call("set_ground_energy_multiplier", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSun_angle_max() {
		return (double) super.call("get_sun_angle_max", new java.lang.Object[0]);
	}

	public void setSun_angle_max(double value) {
		super.call("set_sun_angle_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSun_curve() {
		return (double) super.call("get_sun_curve", new java.lang.Object[0]);
	}

	public void setSun_curve(double value) {
		super.call("set_sun_curve", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getUse_debanding() {
		return (boolean) super.call("get_use_debanding", new java.lang.Object[0]);
	}

	public void setUse_debanding(boolean value) {
		super.call("set_use_debanding", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getEnergy_multiplier() {
		return (double) super.call("get_energy_multiplier", new java.lang.Object[0]);
	}

	public void setEnergy_multiplier(double value) {
		super.call("set_energy_multiplier", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
