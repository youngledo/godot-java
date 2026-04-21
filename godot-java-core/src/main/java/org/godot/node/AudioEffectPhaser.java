package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectPhaser extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_rate_hz", 373806689L), java.util.Map.entry("set_depth", 373806689L),
			java.util.Map.entry("get_rate_hz", 1740695150L), java.util.Map.entry("get_depth", 1740695150L),
			java.util.Map.entry("get_range_min_hz", 1740695150L), java.util.Map.entry("get_range_max_hz", 1740695150L),
			java.util.Map.entry("set_feedback", 373806689L), java.util.Map.entry("get_feedback", 1740695150L),
			java.util.Map.entry("set_range_max_hz", 373806689L), java.util.Map.entry("set_range_min_hz", 373806689L));

	AudioEffectPhaser(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectPhaser(long nativePointer) {
		super(nativePointer);
	}

	public double getRange_min_hz() {
		return (double) super.call("get_range_min_hz", new java.lang.Object[0]);
	}

	public void setRange_min_hz(double value) {
		super.call("set_range_min_hz", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRange_max_hz() {
		return (double) super.call("get_range_max_hz", new java.lang.Object[0]);
	}

	public void setRange_max_hz(double value) {
		super.call("set_range_max_hz", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRate_hz() {
		return (double) super.call("get_rate_hz", new java.lang.Object[0]);
	}

	public void setRate_hz(double value) {
		super.call("set_rate_hz", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFeedback() {
		return (double) super.call("get_feedback", new java.lang.Object[0]);
	}

	public void setFeedback(double value) {
		super.call("set_feedback", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDepth() {
		return (double) super.call("get_depth", new java.lang.Object[0]);
	}

	public void setDepth(double value) {
		super.call("set_depth", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
