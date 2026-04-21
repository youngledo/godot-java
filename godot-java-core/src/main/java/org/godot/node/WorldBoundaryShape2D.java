package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class WorldBoundaryShape2D extends Shape2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_distance", 373806689L), java.util.Map.entry("set_normal", 743155724L),
			java.util.Map.entry("get_normal", 3341600327L), java.util.Map.entry("get_distance", 1740695150L));

	WorldBoundaryShape2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WorldBoundaryShape2D(long nativePointer) {
		super(nativePointer);
	}

	public Vector2 getNormal() {
		return (Vector2) super.call("get_normal", new java.lang.Object[0]);
	}

	public void setNormal(Vector2 value) {
		super.call("set_normal", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getDistance() {
		return (double) super.call("get_distance", new java.lang.Object[0]);
	}

	public void setDistance(double value) {
		super.call("set_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
