package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CircleShape2D extends Shape2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_radius", 1740695150L), java.util.Map.entry("set_radius", 373806689L));

	CircleShape2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CircleShape2D(long nativePointer) {
		super(nativePointer);
	}

	public double getRadius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setRadius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
