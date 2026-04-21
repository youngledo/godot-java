package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectLimiter extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_ceiling_db", 1740695150L), java.util.Map.entry("set_ceiling_db", 373806689L),
			java.util.Map.entry("set_threshold_db", 373806689L),
			java.util.Map.entry("get_soft_clip_ratio", 1740695150L),
			java.util.Map.entry("set_soft_clip_db", 373806689L), java.util.Map.entry("get_soft_clip_db", 1740695150L),
			java.util.Map.entry("get_threshold_db", 1740695150L),
			java.util.Map.entry("set_soft_clip_ratio", 373806689L));

	AudioEffectLimiter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectLimiter(long nativePointer) {
		super(nativePointer);
	}

	public double getCeiling_db() {
		return (double) super.call("get_ceiling_db", new java.lang.Object[0]);
	}

	public void setCeiling_db(double value) {
		super.call("set_ceiling_db", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getThreshold_db() {
		return (double) super.call("get_threshold_db", new java.lang.Object[0]);
	}

	public void setThreshold_db(double value) {
		super.call("set_threshold_db", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSoft_clip_db() {
		return (double) super.call("get_soft_clip_db", new java.lang.Object[0]);
	}

	public void setSoft_clip_db(double value) {
		super.call("set_soft_clip_db", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSoft_clip_ratio() {
		return (double) super.call("get_soft_clip_ratio", new java.lang.Object[0]);
	}

	public void setSoft_clip_ratio(double value) {
		super.call("set_soft_clip_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
