package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;
import org.godot.core.Callable;
import org.godot.core.RefCounted;

public class Tween extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("play", 3218959716L), java.util.Map.entry("set_parallel", 1942052223L),
			java.util.Map.entry("bind_node", 2946786331L), java.util.Map.entry("tween_method", 2337877153L),
			java.util.Map.entry("tween_property", 4049770449L), java.util.Map.entry("set_trans", 3965963875L),
			java.util.Map.entry("set_pause_mode", 3363368837L), java.util.Map.entry("parallel", 3426978995L),
			java.util.Map.entry("custom_step", 330693286L), java.util.Map.entry("get_total_elapsed_time", 1740695150L),
			java.util.Map.entry("set_loops", 2670836414L), java.util.Map.entry("tween_subtween", 1567358477L),
			java.util.Map.entry("chain", 3426978995L), java.util.Map.entry("interpolate_value", 3452526450L),
			java.util.Map.entry("set_speed_scale", 3961971106L), java.util.Map.entry("kill", 3218959716L),
			java.util.Map.entry("pause", 3218959716L), java.util.Map.entry("tween_callback", 1540176488L),
			java.util.Map.entry("is_running", 2240911060L), java.util.Map.entry("tween_interval", 413360199L),
			java.util.Map.entry("set_process_mode", 855258840L), java.util.Map.entry("set_ease", 1208117252L),
			java.util.Map.entry("stop", 3218959716L), java.util.Map.entry("is_valid", 2240911060L),
			java.util.Map.entry("set_ignore_time_scale", 1942052223L),
			java.util.Map.entry("get_loops_left", 3905245786L));

	Tween(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Tween(long nativePointer) {
		super(nativePointer);
	}

	public PropertyTweener tween_property(GodotObject object, String property, Object final_val, double duration) {
		return (PropertyTweener) super.call("tween_property", new java.lang.Object[]{(java.lang.Object) object,
				(java.lang.Object) property, (java.lang.Object) final_val, java.lang.Double.valueOf(duration)});
	}

	public IntervalTweener tween_interval(double time) {
		return (IntervalTweener) super.call("tween_interval", new java.lang.Object[]{java.lang.Double.valueOf(time)});
	}

	public CallbackTweener tween_callback(Callable callback) {
		return (CallbackTweener) super.call("tween_callback", new java.lang.Object[]{(java.lang.Object) callback});
	}

	public MethodTweener tween_method(Callable method, Object from, Object to, double duration) {
		return (MethodTweener) super.call("tween_method", new java.lang.Object[]{(java.lang.Object) method,
				(java.lang.Object) from, (java.lang.Object) to, java.lang.Double.valueOf(duration)});
	}

	public SubtweenTweener tween_subtween(Tween subtween) {
		return (SubtweenTweener) super.call("tween_subtween", new java.lang.Object[]{(java.lang.Object) subtween});
	}

	public boolean custom_step(double delta) {
		return (boolean) super.call("custom_step", new java.lang.Object[]{java.lang.Double.valueOf(delta)});
	}

	public void stop() {
		super.call("stop");
	}

	public void pause() {
		super.call("pause");
	}

	public void play() {
		super.call("play");
	}

	public void kill() {
		super.call("kill");
	}

	public boolean is_running() {
		return (boolean) super.call("is_running");
	}

	public boolean is_valid() {
		return (boolean) super.call("is_valid");
	}

	public Tween bind_node(Node node) {
		return (Tween) super.call("bind_node", new java.lang.Object[]{(java.lang.Object) node});
	}

	public Tween parallel() {
		return (Tween) super.call("parallel");
	}

	public Tween chain() {
		return (Tween) super.call("chain");
	}

	public Object interpolate_value(Object initial_value, Object delta_value, double elapsed_time, double duration,
			int trans_type, int ease_type) {
		return (Object) super.call("interpolate_value",
				new java.lang.Object[]{(java.lang.Object) initial_value, (java.lang.Object) delta_value,
						java.lang.Double.valueOf(elapsed_time), java.lang.Double.valueOf(duration),
						java.lang.Integer.valueOf(trans_type), java.lang.Integer.valueOf(ease_type)});
	}
}
