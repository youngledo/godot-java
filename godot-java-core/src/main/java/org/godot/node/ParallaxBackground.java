package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class ParallaxBackground extends CanvasLayer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_scroll_offset", 743155724L),
			java.util.Map.entry("set_scroll_base_offset", 743155724L),
			java.util.Map.entry("get_scroll_base_offset", 3341600327L),
			java.util.Map.entry("set_limit_begin", 743155724L), java.util.Map.entry("get_limit_end", 3341600327L),
			java.util.Map.entry("get_scroll_base_scale", 3341600327L),
			java.util.Map.entry("set_ignore_camera_zoom", 2586408642L),
			java.util.Map.entry("set_limit_end", 743155724L), java.util.Map.entry("get_limit_begin", 3341600327L),
			java.util.Map.entry("is_ignore_camera_zoom", 2240911060L),
			java.util.Map.entry("set_scroll_base_scale", 743155724L),
			java.util.Map.entry("get_scroll_offset", 3341600327L));

	ParallaxBackground(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ParallaxBackground(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_ignore_camera_zoom() {
		return (boolean) super.call("is_ignore_camera_zoom");
	}

	public Vector2 getScroll_offset() {
		return (Vector2) super.call("get_scroll_offset", new java.lang.Object[0]);
	}

	public void setScroll_offset(Vector2 value) {
		super.call("set_scroll_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getScroll_base_offset() {
		return (Vector2) super.call("get_scroll_base_offset", new java.lang.Object[0]);
	}

	public void setScroll_base_offset(Vector2 value) {
		super.call("set_scroll_base_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getScroll_base_scale() {
		return (Vector2) super.call("get_scroll_base_scale", new java.lang.Object[0]);
	}

	public void setScroll_base_scale(Vector2 value) {
		super.call("set_scroll_base_scale", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getScroll_limit_begin() {
		return (Vector2) super.call("get_limit_begin", new java.lang.Object[0]);
	}

	public void setScroll_limit_begin(Vector2 value) {
		super.call("set_limit_begin", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getScroll_limit_end() {
		return (Vector2) super.call("get_limit_end", new java.lang.Object[0]);
	}

	public void setScroll_limit_end(Vector2 value) {
		super.call("set_limit_end", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isScroll_ignore_camera_zoom() {
		return (boolean) super.call("is_ignore_camera_zoom", new java.lang.Object[0]);
	}

	public void setScroll_ignore_camera_zoom(boolean value) {
		super.call("set_ignore_camera_zoom", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
