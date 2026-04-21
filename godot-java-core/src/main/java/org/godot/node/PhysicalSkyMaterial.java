package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class PhysicalSkyMaterial extends Material {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_rayleigh_coefficient", 373806689L),
			java.util.Map.entry("set_use_debanding", 2586408642L),
			java.util.Map.entry("get_rayleigh_coefficient", 1740695150L),
			java.util.Map.entry("set_mie_coefficient", 373806689L), java.util.Map.entry("get_mie_color", 3444240500L),
			java.util.Map.entry("get_turbidity", 1740695150L), java.util.Map.entry("get_use_debanding", 36873697L),
			java.util.Map.entry("get_night_sky", 3635182373L), java.util.Map.entry("set_mie_eccentricity", 373806689L),
			java.util.Map.entry("get_sun_disk_scale", 1740695150L), java.util.Map.entry("set_turbidity", 373806689L),
			java.util.Map.entry("set_ground_color", 2920490490L),
			java.util.Map.entry("get_rayleigh_color", 3444240500L),
			java.util.Map.entry("get_mie_coefficient", 1740695150L),
			java.util.Map.entry("get_mie_eccentricity", 1740695150L),
			java.util.Map.entry("set_sun_disk_scale", 373806689L),
			java.util.Map.entry("set_rayleigh_color", 2920490490L),
			java.util.Map.entry("get_ground_color", 3444240500L),
			java.util.Map.entry("set_energy_multiplier", 373806689L),
			java.util.Map.entry("get_energy_multiplier", 1740695150L),
			java.util.Map.entry("set_mie_color", 2920490490L), java.util.Map.entry("set_night_sky", 4051416890L));

	PhysicalSkyMaterial(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicalSkyMaterial(long nativePointer) {
		super(nativePointer);
	}

	public double getRayleigh_coefficient() {
		return (double) super.call("get_rayleigh_coefficient", new java.lang.Object[0]);
	}

	public void setRayleigh_coefficient(double value) {
		super.call("set_rayleigh_coefficient", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Color getRayleigh_color() {
		return (Color) super.call("get_rayleigh_color", new java.lang.Object[0]);
	}

	public void setRayleigh_color(Color value) {
		super.call("set_rayleigh_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getMie_coefficient() {
		return (double) super.call("get_mie_coefficient", new java.lang.Object[0]);
	}

	public void setMie_coefficient(double value) {
		super.call("set_mie_coefficient", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMie_eccentricity() {
		return (double) super.call("get_mie_eccentricity", new java.lang.Object[0]);
	}

	public void setMie_eccentricity(double value) {
		super.call("set_mie_eccentricity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Color getMie_color() {
		return (Color) super.call("get_mie_color", new java.lang.Object[0]);
	}

	public void setMie_color(Color value) {
		super.call("set_mie_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getTurbidity() {
		return (double) super.call("get_turbidity", new java.lang.Object[0]);
	}

	public void setTurbidity(double value) {
		super.call("set_turbidity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSun_disk_scale() {
		return (double) super.call("get_sun_disk_scale", new java.lang.Object[0]);
	}

	public void setSun_disk_scale(double value) {
		super.call("set_sun_disk_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Color getGround_color() {
		return (Color) super.call("get_ground_color", new java.lang.Object[0]);
	}

	public void setGround_color(Color value) {
		super.call("set_ground_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getEnergy_multiplier() {
		return (double) super.call("get_energy_multiplier", new java.lang.Object[0]);
	}

	public void setEnergy_multiplier(double value) {
		super.call("set_energy_multiplier", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getUse_debanding() {
		return (boolean) super.call("get_use_debanding", new java.lang.Object[0]);
	}

	public void setUse_debanding(boolean value) {
		super.call("set_use_debanding", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Texture2D getNight_sky() {
		return (Texture2D) super.call("get_night_sky", new java.lang.Object[0]);
	}

	public void setNight_sky(Texture2D value) {
		super.call("set_night_sky", new java.lang.Object[]{(java.lang.Object) value});
	}
}
