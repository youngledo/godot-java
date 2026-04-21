package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Timer extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_one_shot", 36873697L),
			java.util.Map.entry("set_timer_process_callback", 3469495063L),
			java.util.Map.entry("is_stopped", 36873697L), java.util.Map.entry("set_autostart", 2586408642L),
			java.util.Map.entry("get_timer_process_callback", 2672570227L),
			java.util.Map.entry("has_autostart", 36873697L), java.util.Map.entry("start", 1392008558L),
			java.util.Map.entry("set_paused", 2586408642L), java.util.Map.entry("get_time_left", 1740695150L),
			java.util.Map.entry("get_wait_time", 1740695150L), java.util.Map.entry("stop", 3218959716L),
			java.util.Map.entry("is_paused", 36873697L), java.util.Map.entry("set_ignore_time_scale", 2586408642L),
			java.util.Map.entry("set_wait_time", 373806689L),
			java.util.Map.entry("is_ignoring_time_scale", 2240911060L),
			java.util.Map.entry("set_one_shot", 2586408642L));

	Timer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Timer(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_one_shot() {
		return (boolean) super.call("is_one_shot");
	}

	public boolean has_autostart() {
		return (boolean) super.call("has_autostart");
	}

	public void start(double time_sec) {
		super.call("start", new java.lang.Object[]{java.lang.Double.valueOf(time_sec)});
	}

	public void stop() {
		super.call("stop");
	}

	public boolean is_paused() {
		return (boolean) super.call("is_paused");
	}

	public boolean is_ignoring_time_scale() {
		return (boolean) super.call("is_ignoring_time_scale");
	}

	public boolean is_stopped() {
		return (boolean) super.call("is_stopped");
	}

	public long getProcess_callback() {
		return (long) super.call("get_timer_process_callback", new java.lang.Object[0]);
	}

	public void setProcess_callback(long value) {
		super.call("set_timer_process_callback", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getWait_time() {
		return (double) super.call("get_wait_time", new java.lang.Object[0]);
	}

	public void setWait_time(double value) {
		super.call("set_wait_time", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isOne_shot() {
		return (boolean) super.call("is_one_shot", new java.lang.Object[0]);
	}

	public void setOne_shot(boolean value) {
		super.call("set_one_shot", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAutostart() {
		return (boolean) super.call("has_autostart", new java.lang.Object[0]);
	}

	public void setAutostart(boolean value) {
		super.call("set_autostart", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPaused() {
		return (boolean) super.call("is_paused", new java.lang.Object[0]);
	}

	public void setPaused(boolean value) {
		super.call("set_paused", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isIgnore_time_scale() {
		return (boolean) super.call("is_ignoring_time_scale", new java.lang.Object[0]);
	}

	public void setIgnore_time_scale(boolean value) {
		super.call("set_ignore_time_scale", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getTime_left() {
		return (double) super.call("get_time_left", new java.lang.Object[0]);
	}

	public void setTime_left(double value) {
		super.call("set_time_left", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
