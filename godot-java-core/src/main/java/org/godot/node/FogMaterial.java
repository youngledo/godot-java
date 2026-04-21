package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class FogMaterial extends Material {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_density", 1740695150L), java.util.Map.entry("get_height_falloff", 1740695150L),
			java.util.Map.entry("get_emission", 3444240500L), java.util.Map.entry("set_height_falloff", 373806689L),
			java.util.Map.entry("get_albedo", 3444240500L), java.util.Map.entry("set_albedo", 2920490490L),
			java.util.Map.entry("set_density_texture", 1188404210L),
			java.util.Map.entry("get_density_texture", 373985333L), java.util.Map.entry("set_emission", 2920490490L),
			java.util.Map.entry("set_edge_fade", 373806689L), java.util.Map.entry("get_edge_fade", 1740695150L),
			java.util.Map.entry("set_density", 373806689L));

	FogMaterial(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FogMaterial(long nativePointer) {
		super(nativePointer);
	}

	public double getDensity() {
		return (double) super.call("get_density", new java.lang.Object[0]);
	}

	public void setDensity(double value) {
		super.call("set_density", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Color getAlbedo() {
		return (Color) super.call("get_albedo", new java.lang.Object[0]);
	}

	public void setAlbedo(Color value) {
		super.call("set_albedo", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getEmission() {
		return (Color) super.call("get_emission", new java.lang.Object[0]);
	}

	public void setEmission(Color value) {
		super.call("set_emission", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getHeight_falloff() {
		return (double) super.call("get_height_falloff", new java.lang.Object[0]);
	}

	public void setHeight_falloff(double value) {
		super.call("set_height_falloff", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getEdge_fade() {
		return (double) super.call("get_edge_fade", new java.lang.Object[0]);
	}

	public void setEdge_fade(double value) {
		super.call("set_edge_fade", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Texture3D getDensity_texture() {
		return (Texture3D) super.call("get_density_texture", new java.lang.Object[0]);
	}

	public void setDensity_texture(Texture3D value) {
		super.call("set_density_texture", new java.lang.Object[]{(java.lang.Object) value});
	}
}
