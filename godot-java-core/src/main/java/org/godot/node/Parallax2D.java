package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class Parallax2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_scroll_scale", 743155724L),
			java.util.Map.entry("get_follow_viewport", 2240911060L), java.util.Map.entry("get_autoscroll", 3341600327L),
			java.util.Map.entry("get_limit_end", 3341600327L), java.util.Map.entry("get_repeat_times", 3905245786L),
			java.util.Map.entry("set_limit_end", 743155724L), java.util.Map.entry("get_limit_begin", 3341600327L),
			java.util.Map.entry("set_scroll_offset", 743155724L),
			java.util.Map.entry("set_follow_viewport", 2586408642L), java.util.Map.entry("set_limit_begin", 743155724L),
			java.util.Map.entry("is_ignore_camera_scroll", 2240911060L),
			java.util.Map.entry("set_screen_offset", 743155724L), java.util.Map.entry("set_autoscroll", 743155724L),
			java.util.Map.entry("get_repeat_size", 3341600327L),
			java.util.Map.entry("set_ignore_camera_scroll", 2586408642L),
			java.util.Map.entry("get_screen_offset", 3341600327L), java.util.Map.entry("set_repeat_size", 743155724L),
			java.util.Map.entry("set_repeat_times", 1286410249L), java.util.Map.entry("get_scroll_offset", 3341600327L),
			java.util.Map.entry("get_scroll_scale", 3341600327L));

	Parallax2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Parallax2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_ignore_camera_scroll() {
		return (boolean) super.call("is_ignore_camera_scroll");
	}

	public Vector2 getScroll_scale() {
		return (Vector2) super.call("get_scroll_scale", new java.lang.Object[0]);
	}

	public void setScroll_scale(Vector2 value) {
		super.call("set_scroll_scale", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getScroll_offset() {
		return (Vector2) super.call("get_scroll_offset", new java.lang.Object[0]);
	}

	public void setScroll_offset(Vector2 value) {
		super.call("set_scroll_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getRepeat_size() {
		return (Vector2) super.call("get_repeat_size", new java.lang.Object[0]);
	}

	public void setRepeat_size(Vector2 value) {
		super.call("set_repeat_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getAutoscroll() {
		return (Vector2) super.call("get_autoscroll", new java.lang.Object[0]);
	}

	public void setAutoscroll(Vector2 value) {
		super.call("set_autoscroll", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getRepeat_times() {
		return (long) super.call("get_repeat_times", new java.lang.Object[0]);
	}

	public void setRepeat_times(long value) {
		super.call("set_repeat_times", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector2 getLimit_begin() {
		return (Vector2) super.call("get_limit_begin", new java.lang.Object[0]);
	}

	public void setLimit_begin(Vector2 value) {
		super.call("set_limit_begin", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getLimit_end() {
		return (Vector2) super.call("get_limit_end", new java.lang.Object[0]);
	}

	public void setLimit_end(Vector2 value) {
		super.call("set_limit_end", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getFollow_viewport() {
		return (boolean) super.call("get_follow_viewport", new java.lang.Object[0]);
	}

	public void setFollow_viewport(boolean value) {
		super.call("set_follow_viewport", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isIgnore_camera_scroll() {
		return (boolean) super.call("is_ignore_camera_scroll", new java.lang.Object[0]);
	}

	public void setIgnore_camera_scroll(boolean value) {
		super.call("set_ignore_camera_scroll", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getScreen_offset() {
		return (Vector2) super.call("get_screen_offset", new java.lang.Object[0]);
	}

	public void setScreen_offset(Vector2 value) {
		super.call("set_screen_offset", new java.lang.Object[]{(java.lang.Object) value});
	}
}
