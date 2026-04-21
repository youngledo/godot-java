package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationNodeAnimation extends AnimationRootNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_animation", 2002593661L), java.util.Map.entry("get_play_mode", 2061244637L),
			java.util.Map.entry("get_loop_mode", 1988889481L), java.util.Map.entry("set_timeline_length", 373806689L),
			java.util.Map.entry("get_timeline_length", 1740695150L),
			java.util.Map.entry("set_stretch_time_scale", 2586408642L),
			java.util.Map.entry("set_start_offset", 373806689L),
			java.util.Map.entry("set_use_custom_timeline", 2586408642L),
			java.util.Map.entry("is_using_custom_timeline", 36873697L),
			java.util.Map.entry("get_start_offset", 1740695150L), java.util.Map.entry("set_loop_mode", 3155355575L),
			java.util.Map.entry("is_stretching_time_scale", 36873697L),
			java.util.Map.entry("set_animation", 3304788590L), java.util.Map.entry("set_play_mode", 3347718873L),
			java.util.Map.entry("set_advance_on_start", 2586408642L),
			java.util.Map.entry("is_advance_on_start", 36873697L));

	AnimationNodeAnimation(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeAnimation(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_advance_on_start() {
		return (boolean) super.call("is_advance_on_start");
	}

	public boolean is_using_custom_timeline() {
		return (boolean) super.call("is_using_custom_timeline");
	}

	public boolean is_stretching_time_scale() {
		return (boolean) super.call("is_stretching_time_scale");
	}

	public String getAnimation() {
		return (String) super.call("get_animation", new java.lang.Object[0]);
	}

	public void setAnimation(String value) {
		super.call("set_animation", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getPlay_mode() {
		return (long) super.call("get_play_mode", new java.lang.Object[0]);
	}

	public void setPlay_mode(long value) {
		super.call("set_play_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isAdvance_on_start() {
		return (boolean) super.call("is_advance_on_start", new java.lang.Object[0]);
	}

	public void setAdvance_on_start(boolean value) {
		super.call("set_advance_on_start", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isUse_custom_timeline() {
		return (boolean) super.call("is_using_custom_timeline", new java.lang.Object[0]);
	}

	public void setUse_custom_timeline(boolean value) {
		super.call("set_use_custom_timeline", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getTimeline_length() {
		return (double) super.call("get_timeline_length", new java.lang.Object[0]);
	}

	public void setTimeline_length(double value) {
		super.call("set_timeline_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isStretch_time_scale() {
		return (boolean) super.call("is_stretching_time_scale", new java.lang.Object[0]);
	}

	public void setStretch_time_scale(boolean value) {
		super.call("set_stretch_time_scale", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getStart_offset() {
		return (double) super.call("get_start_offset", new java.lang.Object[0]);
	}

	public void setStart_offset(double value) {
		super.call("set_start_offset", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getLoop_mode() {
		return (long) super.call("get_loop_mode", new java.lang.Object[0]);
	}

	public void setLoop_mode(long value) {
		super.call("set_loop_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
