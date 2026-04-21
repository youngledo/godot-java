package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PanoramaSkyMaterial extends Material {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_filtering_enabled", 2586408642L),
			java.util.Map.entry("is_filtering_enabled", 36873697L), java.util.Map.entry("set_panorama", 4051416890L),
			java.util.Map.entry("get_panorama", 3635182373L), java.util.Map.entry("set_energy_multiplier", 373806689L),
			java.util.Map.entry("get_energy_multiplier", 1740695150L));

	PanoramaSkyMaterial(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PanoramaSkyMaterial(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_filtering_enabled() {
		return (boolean) super.call("is_filtering_enabled");
	}

	public Texture2D getPanorama() {
		return (Texture2D) super.call("get_panorama", new java.lang.Object[0]);
	}

	public void setPanorama(Texture2D value) {
		super.call("set_panorama", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isFilter() {
		return (boolean) super.call("is_filtering_enabled", new java.lang.Object[0]);
	}

	public void setFilter(boolean value) {
		super.call("set_filtering_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getEnergy_multiplier() {
		return (double) super.call("get_energy_multiplier", new java.lang.Object[0]);
	}

	public void setEnergy_multiplier(double value) {
		super.call("set_energy_multiplier", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
