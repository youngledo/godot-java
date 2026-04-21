package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class Path3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_debug_custom_color", 2920490490L),
			java.util.Map.entry("get_debug_custom_color", 3444240500L), java.util.Map.entry("get_curve", 4244715212L),
			java.util.Map.entry("set_curve", 408955118L));

	Path3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Path3D(long nativePointer) {
		super(nativePointer);
	}

	public Curve3D getCurve() {
		return (Curve3D) super.call("get_curve", new java.lang.Object[0]);
	}

	public void setCurve(Curve3D value) {
		super.call("set_curve", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getDebug_custom_color() {
		return (Color) super.call("get_debug_custom_color", new java.lang.Object[0]);
	}

	public void setDebug_custom_color(Color value) {
		super.call("set_debug_custom_color", new java.lang.Object[]{(java.lang.Object) value});
	}
}
