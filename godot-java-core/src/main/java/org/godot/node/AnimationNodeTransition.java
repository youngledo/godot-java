package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationNodeTransition extends AnimationNodeSync {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_input_as_auto_advance", 300928843L),
			java.util.Map.entry("get_xfade_time", 1740695150L),
			java.util.Map.entry("is_allow_transition_to_self", 36873697L),
			java.util.Map.entry("is_input_set_as_auto_advance", 1116898809L),
			java.util.Map.entry("set_input_reset", 300928843L),
			java.util.Map.entry("set_allow_transition_to_self", 2586408642L),
			java.util.Map.entry("set_input_break_loop_at_end", 300928843L),
			java.util.Map.entry("get_xfade_curve", 2460114913L), java.util.Map.entry("set_input_count", 1286410249L),
			java.util.Map.entry("set_xfade_curve", 270443179L),
			java.util.Map.entry("is_input_loop_broken_at_end", 1116898809L),
			java.util.Map.entry("set_xfade_time", 373806689L), java.util.Map.entry("is_input_reset", 1116898809L));

	AnimationNodeTransition(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeTransition(long nativePointer) {
		super(nativePointer);
	}

	public void set_input_as_auto_advance(long input, boolean enable) {
		super.call("set_input_as_auto_advance",
				new java.lang.Object[]{java.lang.Long.valueOf(input), java.lang.Boolean.valueOf(enable)});
	}

	public boolean is_input_set_as_auto_advance(long input) {
		return (boolean) super.call("is_input_set_as_auto_advance",
				new java.lang.Object[]{java.lang.Long.valueOf(input)});
	}

	public void set_input_break_loop_at_end(long input, boolean enable) {
		super.call("set_input_break_loop_at_end",
				new java.lang.Object[]{java.lang.Long.valueOf(input), java.lang.Boolean.valueOf(enable)});
	}

	public boolean is_input_loop_broken_at_end(long input) {
		return (boolean) super.call("is_input_loop_broken_at_end",
				new java.lang.Object[]{java.lang.Long.valueOf(input)});
	}

	public void set_input_reset(long input, boolean enable) {
		super.call("set_input_reset",
				new java.lang.Object[]{java.lang.Long.valueOf(input), java.lang.Boolean.valueOf(enable)});
	}

	public boolean is_input_reset(long input) {
		return (boolean) super.call("is_input_reset", new java.lang.Object[]{java.lang.Long.valueOf(input)});
	}

	public boolean is_allow_transition_to_self() {
		return (boolean) super.call("is_allow_transition_to_self");
	}

	public double getXfade_time() {
		return (double) super.call("get_xfade_time", new java.lang.Object[0]);
	}

	public void setXfade_time(double value) {
		super.call("set_xfade_time", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Curve getXfade_curve() {
		return (Curve) super.call("get_xfade_curve", new java.lang.Object[0]);
	}

	public void setXfade_curve(Curve value) {
		super.call("set_xfade_curve", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isAllow_transition_to_self() {
		return (boolean) super.call("is_allow_transition_to_self", new java.lang.Object[0]);
	}

	public void setAllow_transition_to_self(boolean value) {
		super.call("set_allow_transition_to_self", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getInput_count() {
		return (long) super.call("get_input_count", new java.lang.Object[0]);
	}

	public void setInput_count(long value) {
		super.call("set_input_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
