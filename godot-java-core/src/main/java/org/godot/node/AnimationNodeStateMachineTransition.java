package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationNodeStateMachineTransition extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_reset", 36873697L), java.util.Map.entry("get_advance_expression", 201670096L),
			java.util.Map.entry("get_priority", 3905245786L), java.util.Map.entry("get_xfade_time", 1740695150L),
			java.util.Map.entry("set_advance_mode", 1210869868L), java.util.Map.entry("set_reset", 2586408642L),
			java.util.Map.entry("set_advance_condition", 3304788590L),
			java.util.Map.entry("get_advance_condition", 2002593661L),
			java.util.Map.entry("get_xfade_curve", 2460114913L), java.util.Map.entry("set_switch_mode", 2074906633L),
			java.util.Map.entry("set_xfade_curve", 270443179L), java.util.Map.entry("get_advance_mode", 61101689L),
			java.util.Map.entry("set_advance_expression", 83702148L), java.util.Map.entry("set_xfade_time", 373806689L),
			java.util.Map.entry("set_break_loop_at_end", 2586408642L),
			java.util.Map.entry("get_switch_mode", 2138562085L),
			java.util.Map.entry("is_loop_broken_at_end", 36873697L), java.util.Map.entry("set_priority", 1286410249L));

	AnimationNodeStateMachineTransition(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeStateMachineTransition(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_loop_broken_at_end() {
		return (boolean) super.call("is_loop_broken_at_end");
	}

	public boolean is_reset() {
		return (boolean) super.call("is_reset");
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

	public boolean isBreak_loop_at_end() {
		return (boolean) super.call("is_loop_broken_at_end", new java.lang.Object[0]);
	}

	public void setBreak_loop_at_end(boolean value) {
		super.call("set_break_loop_at_end", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isReset() {
		return (boolean) super.call("is_reset", new java.lang.Object[0]);
	}

	public void setReset(boolean value) {
		super.call("set_reset", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getPriority() {
		return (long) super.call("get_priority", new java.lang.Object[0]);
	}

	public void setPriority(long value) {
		super.call("set_priority", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwitch_mode() {
		return (long) super.call("get_switch_mode", new java.lang.Object[0]);
	}

	public void setSwitch_mode(long value) {
		super.call("set_switch_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getAdvance_mode() {
		return (long) super.call("get_advance_mode", new java.lang.Object[0]);
	}

	public void setAdvance_mode(long value) {
		super.call("set_advance_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getAdvance_condition() {
		return (String) super.call("get_advance_condition", new java.lang.Object[0]);
	}

	public void setAdvance_condition(String value) {
		super.call("set_advance_condition", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getAdvance_expression() {
		return (String) super.call("get_advance_expression", new java.lang.Object[0]);
	}

	public void setAdvance_expression(String value) {
		super.call("set_advance_expression", new java.lang.Object[]{(java.lang.Object) value});
	}
}
