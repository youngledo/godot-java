package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CapsuleShape2D extends Shape2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_radius", 1740695150L), java.util.Map.entry("get_mid_height", 1740695150L),
			java.util.Map.entry("set_height", 373806689L), java.util.Map.entry("set_radius", 373806689L),
			java.util.Map.entry("get_height", 1740695150L), java.util.Map.entry("set_mid_height", 373806689L));

	CapsuleShape2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CapsuleShape2D(long nativePointer) {
		super(nativePointer);
	}

	public double getRadius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setRadius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getHeight() {
		return (double) super.call("get_height", new java.lang.Object[0]);
	}

	public void setHeight(double value) {
		super.call("set_height", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMid_height() {
		return (double) super.call("get_mid_height", new java.lang.Object[0]);
	}

	public void setMid_height(double value) {
		super.call("set_mid_height", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
