package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SeparationRayShape3D extends Shape3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_length", 373806689L), java.util.Map.entry("set_slide_on_slope", 2586408642L),
			java.util.Map.entry("get_slide_on_slope", 36873697L), java.util.Map.entry("get_length", 1740695150L));

	SeparationRayShape3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SeparationRayShape3D(long nativePointer) {
		super(nativePointer);
	}

	public double getLength() {
		return (double) super.call("get_length", new java.lang.Object[0]);
	}

	public void setLength(double value) {
		super.call("set_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getSlide_on_slope() {
		return (boolean) super.call("get_slide_on_slope", new java.lang.Object[0]);
	}

	public void setSlide_on_slope(boolean value) {
		super.call("set_slide_on_slope", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
