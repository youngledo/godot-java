package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectHardLimiter extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_ceiling_db", 1740695150L), java.util.Map.entry("get_pre_gain_db", 1740695150L),
			java.util.Map.entry("set_ceiling_db", 373806689L), java.util.Map.entry("set_release", 373806689L),
			java.util.Map.entry("set_pre_gain_db", 373806689L), java.util.Map.entry("get_release", 1740695150L));

	AudioEffectHardLimiter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectHardLimiter(long nativePointer) {
		super(nativePointer);
	}

	public double getPre_gain_db() {
		return (double) super.call("get_pre_gain_db", new java.lang.Object[0]);
	}

	public void setPre_gain_db(double value) {
		super.call("set_pre_gain_db", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getCeiling_db() {
		return (double) super.call("get_ceiling_db", new java.lang.Object[0]);
	}

	public void setCeiling_db(double value) {
		super.call("set_ceiling_db", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRelease() {
		return (double) super.call("get_release", new java.lang.Object[0]);
	}

	public void setRelease(double value) {
		super.call("set_release", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
