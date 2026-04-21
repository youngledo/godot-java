package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class CollisionPolygon3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_depth", 373806689L), java.util.Map.entry("set_disabled", 2586408642L),
			java.util.Map.entry("get_depth", 1740695150L), java.util.Map.entry("set_enable_debug_fill", 2586408642L),
			java.util.Map.entry("get_margin", 1740695150L), java.util.Map.entry("is_disabled", 36873697L),
			java.util.Map.entry("set_debug_color", 2920490490L), java.util.Map.entry("set_margin", 373806689L),
			java.util.Map.entry("get_debug_color", 3444240500L), java.util.Map.entry("set_polygon", 1509147220L),
			java.util.Map.entry("get_polygon", 2961356807L), java.util.Map.entry("get_enable_debug_fill", 36873697L));

	CollisionPolygon3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CollisionPolygon3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_disabled() {
		return (boolean) super.call("is_disabled");
	}

	public double getDepth() {
		return (double) super.call("get_depth", new java.lang.Object[0]);
	}

	public void setDepth(double value) {
		super.call("set_depth", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isDisabled() {
		return (boolean) super.call("is_disabled", new java.lang.Object[0]);
	}

	public void setDisabled(boolean value) {
		super.call("set_disabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double[][] getPolygon() {
		return (double[][]) super.call("get_polygon", new java.lang.Object[0]);
	}

	public void setPolygon(double[][] value) {
		super.call("set_polygon", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getMargin() {
		return (double) super.call("get_margin", new java.lang.Object[0]);
	}

	public void setMargin(double value) {
		super.call("set_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Color getDebug_color() {
		return (Color) super.call("get_debug_color", new java.lang.Object[0]);
	}

	public void setDebug_color(Color value) {
		super.call("set_debug_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getDebug_fill() {
		return (boolean) super.call("get_enable_debug_fill", new java.lang.Object[0]);
	}

	public void setDebug_fill(boolean value) {
		super.call("set_enable_debug_fill", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
