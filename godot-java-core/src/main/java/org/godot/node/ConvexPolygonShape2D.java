package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ConvexPolygonShape2D extends Shape2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_points", 1509147220L), java.util.Map.entry("set_point_cloud", 1509147220L),
			java.util.Map.entry("get_points", 2961356807L));

	ConvexPolygonShape2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ConvexPolygonShape2D(long nativePointer) {
		super(nativePointer);
	}

	public double[][] getPoints() {
		return (double[][]) super.call("get_points", new java.lang.Object[0]);
	}

	public void setPoints(double[][] value) {
		super.call("set_points", new java.lang.Object[]{(java.lang.Object) value});
	}
}
