package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SphereShape3D extends Shape3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_radius", 1740695150L), java.util.Map.entry("set_radius", 373806689L));

	SphereShape3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SphereShape3D(long nativePointer) {
		super(nativePointer);
	}

	public double getRadius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setRadius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
