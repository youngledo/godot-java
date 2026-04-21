package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class DirectionalLight2D extends Light2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_max_distance", 1740695150L), java.util.Map.entry("set_max_distance", 373806689L));

	DirectionalLight2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	DirectionalLight2D(long nativePointer) {
		super(nativePointer);
	}

	public double getHeight() {
		return (double) super.call("get_height", new java.lang.Object[0]);
	}

	public void setHeight(double value) {
		super.call("set_height", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMax_distance() {
		return (double) super.call("get_max_distance", new java.lang.Object[0]);
	}

	public void setMax_distance(double value) {
		super.call("set_max_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
