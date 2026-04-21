package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class FastNoiseLite extends Noise {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_noise_type", 2624461392L),
			java.util.Map.entry("set_fractal_ping_pong_strength", 373806689L),
			java.util.Map.entry("get_domain_warp_fractal_gain", 1740695150L),
			java.util.Map.entry("set_cellular_return_type", 2654169698L),
			java.util.Map.entry("set_domain_warp_frequency", 373806689L),
			java.util.Map.entry("set_cellular_jitter", 373806689L),
			java.util.Map.entry("set_domain_warp_type", 3629692980L),
			java.util.Map.entry("get_noise_type", 1458108610L),
			java.util.Map.entry("get_fractal_weighted_strength", 1740695150L),
			java.util.Map.entry("set_fractal_gain", 373806689L),
			java.util.Map.entry("get_domain_warp_fractal_type", 407716934L),
			java.util.Map.entry("get_fractal_gain", 1740695150L),
			java.util.Map.entry("get_domain_warp_fractal_lacunarity", 1740695150L),
			java.util.Map.entry("set_frequency", 373806689L),
			java.util.Map.entry("get_cellular_return_type", 3699796343L),
			java.util.Map.entry("get_domain_warp_type", 2980162020L),
			java.util.Map.entry("get_fractal_type", 1036889279L),
			java.util.Map.entry("get_cellular_distance_function", 2021274088L),
			java.util.Map.entry("get_domain_warp_amplitude", 1740695150L),
			java.util.Map.entry("set_fractal_weighted_strength", 373806689L),
			java.util.Map.entry("get_offset", 3360562783L), java.util.Map.entry("is_domain_warp_enabled", 36873697L),
			java.util.Map.entry("set_domain_warp_amplitude", 373806689L),
			java.util.Map.entry("set_domain_warp_fractal_lacunarity", 373806689L),
			java.util.Map.entry("set_domain_warp_fractal_gain", 373806689L),
			java.util.Map.entry("get_fractal_lacunarity", 1740695150L),
			java.util.Map.entry("set_fractal_type", 4132731174L),
			java.util.Map.entry("set_fractal_octaves", 1286410249L),
			java.util.Map.entry("set_domain_warp_fractal_type", 3999408287L),
			java.util.Map.entry("get_seed", 3905245786L), java.util.Map.entry("set_fractal_lacunarity", 373806689L),
			java.util.Map.entry("set_cellular_distance_function", 1006013267L),
			java.util.Map.entry("get_domain_warp_fractal_octaves", 3905245786L),
			java.util.Map.entry("get_frequency", 1740695150L), java.util.Map.entry("set_seed", 1286410249L),
			java.util.Map.entry("get_domain_warp_frequency", 1740695150L),
			java.util.Map.entry("set_domain_warp_enabled", 2586408642L),
			java.util.Map.entry("set_domain_warp_fractal_octaves", 1286410249L),
			java.util.Map.entry("get_cellular_jitter", 1740695150L),
			java.util.Map.entry("get_fractal_octaves", 3905245786L), java.util.Map.entry("set_offset", 3460891852L),
			java.util.Map.entry("get_fractal_ping_pong_strength", 1740695150L));

	FastNoiseLite(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FastNoiseLite(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_domain_warp_enabled() {
		return (boolean) super.call("is_domain_warp_enabled");
	}

	public long getNoise_type() {
		return (long) super.call("get_noise_type", new java.lang.Object[0]);
	}

	public void setNoise_type(long value) {
		super.call("set_noise_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSeed() {
		return (long) super.call("get_seed", new java.lang.Object[0]);
	}

	public void setSeed(long value) {
		super.call("set_seed", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getFrequency() {
		return (double) super.call("get_frequency", new java.lang.Object[0]);
	}

	public void setFrequency(double value) {
		super.call("set_frequency", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector3 getOffset() {
		return (Vector3) super.call("get_offset", new java.lang.Object[0]);
	}

	public void setOffset(Vector3 value) {
		super.call("set_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getFractal_type() {
		return (long) super.call("get_fractal_type", new java.lang.Object[0]);
	}

	public void setFractal_type(long value) {
		super.call("set_fractal_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFractal_octaves() {
		return (long) super.call("get_fractal_octaves", new java.lang.Object[0]);
	}

	public void setFractal_octaves(long value) {
		super.call("set_fractal_octaves", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getFractal_lacunarity() {
		return (double) super.call("get_fractal_lacunarity", new java.lang.Object[0]);
	}

	public void setFractal_lacunarity(double value) {
		super.call("set_fractal_lacunarity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFractal_gain() {
		return (double) super.call("get_fractal_gain", new java.lang.Object[0]);
	}

	public void setFractal_gain(double value) {
		super.call("set_fractal_gain", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFractal_weighted_strength() {
		return (double) super.call("get_fractal_weighted_strength", new java.lang.Object[0]);
	}

	public void setFractal_weighted_strength(double value) {
		super.call("set_fractal_weighted_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFractal_ping_pong_strength() {
		return (double) super.call("get_fractal_ping_pong_strength", new java.lang.Object[0]);
	}

	public void setFractal_ping_pong_strength(double value) {
		super.call("set_fractal_ping_pong_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getCellular_distance_function() {
		return (long) super.call("get_cellular_distance_function", new java.lang.Object[0]);
	}

	public void setCellular_distance_function(long value) {
		super.call("set_cellular_distance_function", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getCellular_jitter() {
		return (double) super.call("get_cellular_jitter", new java.lang.Object[0]);
	}

	public void setCellular_jitter(double value) {
		super.call("set_cellular_jitter", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getCellular_return_type() {
		return (long) super.call("get_cellular_return_type", new java.lang.Object[0]);
	}

	public void setCellular_return_type(long value) {
		super.call("set_cellular_return_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isDomain_warp_enabled() {
		return (boolean) super.call("is_domain_warp_enabled", new java.lang.Object[0]);
	}

	public void setDomain_warp_enabled(boolean value) {
		super.call("set_domain_warp_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getDomain_warp_type() {
		return (long) super.call("get_domain_warp_type", new java.lang.Object[0]);
	}

	public void setDomain_warp_type(long value) {
		super.call("set_domain_warp_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getDomain_warp_amplitude() {
		return (double) super.call("get_domain_warp_amplitude", new java.lang.Object[0]);
	}

	public void setDomain_warp_amplitude(double value) {
		super.call("set_domain_warp_amplitude", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDomain_warp_frequency() {
		return (double) super.call("get_domain_warp_frequency", new java.lang.Object[0]);
	}

	public void setDomain_warp_frequency(double value) {
		super.call("set_domain_warp_frequency", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getDomain_warp_fractal_type() {
		return (long) super.call("get_domain_warp_fractal_type", new java.lang.Object[0]);
	}

	public void setDomain_warp_fractal_type(long value) {
		super.call("set_domain_warp_fractal_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDomain_warp_fractal_octaves() {
		return (long) super.call("get_domain_warp_fractal_octaves", new java.lang.Object[0]);
	}

	public void setDomain_warp_fractal_octaves(long value) {
		super.call("set_domain_warp_fractal_octaves", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getDomain_warp_fractal_lacunarity() {
		return (double) super.call("get_domain_warp_fractal_lacunarity", new java.lang.Object[0]);
	}

	public void setDomain_warp_fractal_lacunarity(double value) {
		super.call("set_domain_warp_fractal_lacunarity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDomain_warp_fractal_gain() {
		return (double) super.call("get_domain_warp_fractal_gain", new java.lang.Object[0]);
	}

	public void setDomain_warp_fractal_gain(double value) {
		super.call("set_domain_warp_fractal_gain", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
