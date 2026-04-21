package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectDelay extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_feedback_delay_ms", 373806689L), java.util.Map.entry("get_dry", 191475506L),
			java.util.Map.entry("get_tap2_level_db", 1740695150L), java.util.Map.entry("set_tap2_level_db", 373806689L),
			java.util.Map.entry("set_tap2_pan", 373806689L), java.util.Map.entry("set_tap1_level_db", 373806689L),
			java.util.Map.entry("set_dry", 373806689L), java.util.Map.entry("set_feedback_lowpass", 373806689L),
			java.util.Map.entry("set_tap1_delay_ms", 373806689L), java.util.Map.entry("get_tap1_delay_ms", 1740695150L),
			java.util.Map.entry("get_tap1_level_db", 1740695150L), java.util.Map.entry("set_tap1_active", 2586408642L),
			java.util.Map.entry("set_tap2_delay_ms", 373806689L),
			java.util.Map.entry("get_feedback_delay_ms", 1740695150L),
			java.util.Map.entry("set_tap2_active", 2586408642L), java.util.Map.entry("get_tap2_pan", 1740695150L),
			java.util.Map.entry("set_feedback_active", 2586408642L),
			java.util.Map.entry("get_feedback_lowpass", 1740695150L), java.util.Map.entry("get_tap1_pan", 1740695150L),
			java.util.Map.entry("is_feedback_active", 36873697L),
			java.util.Map.entry("get_feedback_level_db", 1740695150L),
			java.util.Map.entry("get_tap2_delay_ms", 1740695150L), java.util.Map.entry("is_tap1_active", 36873697L),
			java.util.Map.entry("set_tap1_pan", 373806689L), java.util.Map.entry("is_tap2_active", 36873697L),
			java.util.Map.entry("set_feedback_level_db", 373806689L));

	AudioEffectDelay(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectDelay(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_tap1_active() {
		return (boolean) super.call("is_tap1_active");
	}

	public boolean is_tap2_active() {
		return (boolean) super.call("is_tap2_active");
	}

	public boolean is_feedback_active() {
		return (boolean) super.call("is_feedback_active");
	}

	public double getDry() {
		return (double) super.call("get_dry", new java.lang.Object[0]);
	}

	public void setDry(double value) {
		super.call("set_dry", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isTap1_active() {
		return (boolean) super.call("is_tap1_active", new java.lang.Object[0]);
	}

	public void setTap1_active(boolean value) {
		super.call("set_tap1_active", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getTap1_delay_ms() {
		return (double) super.call("get_tap1_delay_ms", new java.lang.Object[0]);
	}

	public void setTap1_delay_ms(double value) {
		super.call("set_tap1_delay_ms", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTap1_level_db() {
		return (double) super.call("get_tap1_level_db", new java.lang.Object[0]);
	}

	public void setTap1_level_db(double value) {
		super.call("set_tap1_level_db", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTap1_pan() {
		return (double) super.call("get_tap1_pan", new java.lang.Object[0]);
	}

	public void setTap1_pan(double value) {
		super.call("set_tap1_pan", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isTap2_active() {
		return (boolean) super.call("is_tap2_active", new java.lang.Object[0]);
	}

	public void setTap2_active(boolean value) {
		super.call("set_tap2_active", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getTap2_delay_ms() {
		return (double) super.call("get_tap2_delay_ms", new java.lang.Object[0]);
	}

	public void setTap2_delay_ms(double value) {
		super.call("set_tap2_delay_ms", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTap2_level_db() {
		return (double) super.call("get_tap2_level_db", new java.lang.Object[0]);
	}

	public void setTap2_level_db(double value) {
		super.call("set_tap2_level_db", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTap2_pan() {
		return (double) super.call("get_tap2_pan", new java.lang.Object[0]);
	}

	public void setTap2_pan(double value) {
		super.call("set_tap2_pan", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isFeedback_active() {
		return (boolean) super.call("is_feedback_active", new java.lang.Object[0]);
	}

	public void setFeedback_active(boolean value) {
		super.call("set_feedback_active", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getFeedback_delay_ms() {
		return (double) super.call("get_feedback_delay_ms", new java.lang.Object[0]);
	}

	public void setFeedback_delay_ms(double value) {
		super.call("set_feedback_delay_ms", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFeedback_level_db() {
		return (double) super.call("get_feedback_level_db", new java.lang.Object[0]);
	}

	public void setFeedback_level_db(double value) {
		super.call("set_feedback_level_db", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFeedback_lowpass() {
		return (double) super.call("get_feedback_lowpass", new java.lang.Object[0]);
	}

	public void setFeedback_lowpass(double value) {
		super.call("set_feedback_lowpass", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
