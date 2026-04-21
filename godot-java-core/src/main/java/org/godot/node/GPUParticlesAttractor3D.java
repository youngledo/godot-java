package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class GPUParticlesAttractor3D extends VisualInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_cull_mask", 1286410249L), java.util.Map.entry("get_directionality", 1740695150L),
			java.util.Map.entry("set_strength", 373806689L), java.util.Map.entry("get_cull_mask", 3905245786L),
			java.util.Map.entry("set_attenuation", 373806689L), java.util.Map.entry("get_attenuation", 1740695150L),
			java.util.Map.entry("set_directionality", 373806689L), java.util.Map.entry("get_strength", 1740695150L));

	GPUParticlesAttractor3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GPUParticlesAttractor3D(long nativePointer) {
		super(nativePointer);
	}

	public double getStrength() {
		return (double) super.call("get_strength", new java.lang.Object[0]);
	}

	public void setStrength(double value) {
		super.call("set_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAttenuation() {
		return (double) super.call("get_attenuation", new java.lang.Object[0]);
	}

	public void setAttenuation(double value) {
		super.call("set_attenuation", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDirectionality() {
		return (double) super.call("get_directionality", new java.lang.Object[0]);
	}

	public void setDirectionality(double value) {
		super.call("set_directionality", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getCull_mask() {
		return (long) super.call("get_cull_mask", new java.lang.Object[0]);
	}

	public void setCull_mask(long value) {
		super.call("set_cull_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
