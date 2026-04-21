package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class ReferenceRect extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_border_color", 3444240500L), java.util.Map.entry("get_editor_only", 36873697L),
			java.util.Map.entry("set_border_width", 373806689L), java.util.Map.entry("set_border_color", 2920490490L),
			java.util.Map.entry("set_editor_only", 2586408642L), java.util.Map.entry("get_border_width", 1740695150L));

	ReferenceRect(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ReferenceRect(long nativePointer) {
		super(nativePointer);
	}

	public Color getBorder_color() {
		return (Color) super.call("get_border_color", new java.lang.Object[0]);
	}

	public void setBorder_color(Color value) {
		super.call("set_border_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getBorder_width() {
		return (double) super.call("get_border_width", new java.lang.Object[0]);
	}

	public void setBorder_width(double value) {
		super.call("set_border_width", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getEditor_only() {
		return (boolean) super.call("get_editor_only", new java.lang.Object[0]);
	}

	public void setEditor_only(boolean value) {
		super.call("set_editor_only", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
