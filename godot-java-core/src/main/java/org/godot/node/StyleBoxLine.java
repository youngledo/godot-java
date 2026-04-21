package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class StyleBoxLine extends StyleBox {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_thickness", 1286410249L), java.util.Map.entry("set_vertical", 2586408642L),
			java.util.Map.entry("set_grow_begin", 373806689L), java.util.Map.entry("is_vertical", 36873697L),
			java.util.Map.entry("get_thickness", 3905245786L), java.util.Map.entry("set_grow_end", 373806689L),
			java.util.Map.entry("get_grow_end", 1740695150L), java.util.Map.entry("set_color", 2920490490L),
			java.util.Map.entry("get_color", 3444240500L), java.util.Map.entry("get_grow_begin", 1740695150L));

	StyleBoxLine(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StyleBoxLine(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_vertical() {
		return (boolean) super.call("is_vertical");
	}

	public Color getColor() {
		return (Color) super.call("get_color", new java.lang.Object[0]);
	}

	public void setColor(Color value) {
		super.call("set_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getGrow_begin() {
		return (double) super.call("get_grow_begin", new java.lang.Object[0]);
	}

	public void setGrow_begin(double value) {
		super.call("set_grow_begin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getGrow_end() {
		return (double) super.call("get_grow_end", new java.lang.Object[0]);
	}

	public void setGrow_end(double value) {
		super.call("set_grow_end", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getThickness() {
		return (long) super.call("get_thickness", new java.lang.Object[0]);
	}

	public void setThickness(long value) {
		super.call("set_thickness", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isVertical() {
		return (boolean) super.call("is_vertical", new java.lang.Object[0]);
	}

	public void setVertical(boolean value) {
		super.call("set_vertical", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
