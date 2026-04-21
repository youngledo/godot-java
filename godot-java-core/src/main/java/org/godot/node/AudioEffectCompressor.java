package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectCompressor extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_ratio", 1740695150L), java.util.Map.entry("get_gain", 1740695150L),
			java.util.Map.entry("set_gain", 373806689L), java.util.Map.entry("get_attack_us", 1740695150L),
			java.util.Map.entry("set_mix", 373806689L), java.util.Map.entry("set_attack_us", 373806689L),
			java.util.Map.entry("get_threshold", 1740695150L), java.util.Map.entry("set_sidechain", 3304788590L),
			java.util.Map.entry("get_sidechain", 2002593661L), java.util.Map.entry("set_ratio", 373806689L),
			java.util.Map.entry("set_threshold", 373806689L), java.util.Map.entry("set_release_ms", 373806689L),
			java.util.Map.entry("get_mix", 1740695150L), java.util.Map.entry("get_release_ms", 1740695150L));

	AudioEffectCompressor(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectCompressor(long nativePointer) {
		super(nativePointer);
	}

	public double getThreshold() {
		return (double) super.call("get_threshold", new java.lang.Object[0]);
	}

	public void setThreshold(double value) {
		super.call("set_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRatio() {
		return (double) super.call("get_ratio", new java.lang.Object[0]);
	}

	public void setRatio(double value) {
		super.call("set_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getGain() {
		return (double) super.call("get_gain", new java.lang.Object[0]);
	}

	public void setGain(double value) {
		super.call("set_gain", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAttack_us() {
		return (double) super.call("get_attack_us", new java.lang.Object[0]);
	}

	public void setAttack_us(double value) {
		super.call("set_attack_us", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRelease_ms() {
		return (double) super.call("get_release_ms", new java.lang.Object[0]);
	}

	public void setRelease_ms(double value) {
		super.call("set_release_ms", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMix() {
		return (double) super.call("get_mix", new java.lang.Object[0]);
	}

	public void setMix(double value) {
		super.call("set_mix", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public String getSidechain() {
		return (String) super.call("get_sidechain", new java.lang.Object[0]);
	}

	public void setSidechain(String value) {
		super.call("set_sidechain", new java.lang.Object[]{(java.lang.Object) value});
	}
}
