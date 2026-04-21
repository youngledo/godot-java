package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class RootMotionView extends VisualInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_animation_path", 4075236667L),
			java.util.Map.entry("set_animation_path", 1348162250L), java.util.Map.entry("get_zero_y", 36873697L),
			java.util.Map.entry("set_zero_y", 2586408642L), java.util.Map.entry("get_radius", 1740695150L),
			java.util.Map.entry("set_radius", 373806689L), java.util.Map.entry("set_color", 2920490490L),
			java.util.Map.entry("get_color", 3444240500L), java.util.Map.entry("set_cell_size", 373806689L),
			java.util.Map.entry("get_cell_size", 1740695150L));

	RootMotionView(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RootMotionView(long nativePointer) {
		super(nativePointer);
	}

	public String getAnimation_path() {
		return (String) super.call("get_animation_path", new java.lang.Object[0]);
	}

	public void setAnimation_path(String value) {
		super.call("set_animation_path", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getColor() {
		return (Color) super.call("get_color", new java.lang.Object[0]);
	}

	public void setColor(Color value) {
		super.call("set_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getCell_size() {
		return (double) super.call("get_cell_size", new java.lang.Object[0]);
	}

	public void setCell_size(double value) {
		super.call("set_cell_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRadius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setRadius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getZero_y() {
		return (boolean) super.call("get_zero_y", new java.lang.Object[0]);
	}

	public void setZero_y(boolean value) {
		super.call("set_zero_y", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
