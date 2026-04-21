package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectStereoEnhance extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_pan_pullout", 373806689L), java.util.Map.entry("get_surround", 1740695150L),
			java.util.Map.entry("get_time_pullout", 1740695150L), java.util.Map.entry("set_time_pullout", 373806689L),
			java.util.Map.entry("get_pan_pullout", 1740695150L), java.util.Map.entry("set_surround", 373806689L));

	AudioEffectStereoEnhance(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectStereoEnhance(long nativePointer) {
		super(nativePointer);
	}

	public double getPan_pullout() {
		return (double) super.call("get_pan_pullout", new java.lang.Object[0]);
	}

	public void setPan_pullout(double value) {
		super.call("set_pan_pullout", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTime_pullout_ms() {
		return (double) super.call("get_time_pullout", new java.lang.Object[0]);
	}

	public void setTime_pullout_ms(double value) {
		super.call("set_time_pullout", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSurround() {
		return (double) super.call("get_surround", new java.lang.Object[0]);
	}

	public void setSurround(double value) {
		super.call("set_surround", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
