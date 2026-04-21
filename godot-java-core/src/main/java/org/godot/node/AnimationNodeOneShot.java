package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationNodeOneShot extends AnimationNodeSync {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_fadeout_time", 373806689L), java.util.Map.entry("set_autorestart", 2586408642L),
			java.util.Map.entry("has_autorestart", 36873697L), java.util.Map.entry("set_abort_on_reset", 2586408642L),
			java.util.Map.entry("set_fadein_curve", 270443179L),
			java.util.Map.entry("set_autorestart_delay", 373806689L), java.util.Map.entry("get_mix_mode", 3076550526L),
			java.util.Map.entry("get_fadein_time", 1740695150L), java.util.Map.entry("set_fadeout_curve", 270443179L),
			java.util.Map.entry("get_fadein_curve", 2460114913L), java.util.Map.entry("set_mix_mode", 1018899799L),
			java.util.Map.entry("set_fadein_time", 373806689L), java.util.Map.entry("get_fadeout_curve", 2460114913L),
			java.util.Map.entry("set_break_loop_at_end", 2586408642L),
			java.util.Map.entry("is_aborted_on_reset", 36873697L),
			java.util.Map.entry("get_autorestart_delay", 1740695150L),
			java.util.Map.entry("get_fadeout_time", 1740695150L),
			java.util.Map.entry("is_loop_broken_at_end", 36873697L),
			java.util.Map.entry("set_autorestart_random_delay", 373806689L),
			java.util.Map.entry("get_autorestart_random_delay", 1740695150L));

	AnimationNodeOneShot(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeOneShot(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_loop_broken_at_end() {
		return (boolean) super.call("is_loop_broken_at_end");
	}

	public boolean is_aborted_on_reset() {
		return (boolean) super.call("is_aborted_on_reset");
	}

	public boolean has_autorestart() {
		return (boolean) super.call("has_autorestart");
	}

	public long getMix_mode() {
		return (long) super.call("get_mix_mode", new java.lang.Object[0]);
	}

	public void setMix_mode(long value) {
		super.call("set_mix_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getFadein_time() {
		return (double) super.call("get_fadein_time", new java.lang.Object[0]);
	}

	public void setFadein_time(double value) {
		super.call("set_fadein_time", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Curve getFadein_curve() {
		return (Curve) super.call("get_fadein_curve", new java.lang.Object[0]);
	}

	public void setFadein_curve(Curve value) {
		super.call("set_fadein_curve", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getFadeout_time() {
		return (double) super.call("get_fadeout_time", new java.lang.Object[0]);
	}

	public void setFadeout_time(double value) {
		super.call("set_fadeout_time", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Curve getFadeout_curve() {
		return (Curve) super.call("get_fadeout_curve", new java.lang.Object[0]);
	}

	public void setFadeout_curve(Curve value) {
		super.call("set_fadeout_curve", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isBreak_loop_at_end() {
		return (boolean) super.call("is_loop_broken_at_end", new java.lang.Object[0]);
	}

	public void setBreak_loop_at_end(boolean value) {
		super.call("set_break_loop_at_end", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isAbort_on_reset() {
		return (boolean) super.call("is_aborted_on_reset", new java.lang.Object[0]);
	}

	public void setAbort_on_reset(boolean value) {
		super.call("set_abort_on_reset", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAutorestart() {
		return (boolean) super.call("has_autorestart", new java.lang.Object[0]);
	}

	public void setAutorestart(boolean value) {
		super.call("set_autorestart", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getAutorestart_delay() {
		return (double) super.call("get_autorestart_delay", new java.lang.Object[0]);
	}

	public void setAutorestart_delay(double value) {
		super.call("set_autorestart_delay", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAutorestart_random_delay() {
		return (double) super.call("get_autorestart_random_delay", new java.lang.Object[0]);
	}

	public void setAutorestart_random_delay(double value) {
		super.call("set_autorestart_random_delay", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
