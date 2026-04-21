package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class CanvasModulate extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_color", 2920490490L), java.util.Map.entry("get_color", 3444240500L));

	CanvasModulate(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CanvasModulate(long nativePointer) {
		super(nativePointer);
	}

	public Color getColor() {
		return (Color) super.call("get_color", new java.lang.Object[0]);
	}

	public void setColor(Color value) {
		super.call("set_color", new java.lang.Object[]{(java.lang.Object) value});
	}
}
