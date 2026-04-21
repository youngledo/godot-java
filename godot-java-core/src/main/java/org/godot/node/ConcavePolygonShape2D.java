package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ConcavePolygonShape2D extends Shape2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_segments", 2961356807L), java.util.Map.entry("set_segments", 1509147220L));

	ConcavePolygonShape2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ConcavePolygonShape2D(long nativePointer) {
		super(nativePointer);
	}

	public double[][] getSegments() {
		return (double[][]) super.call("get_segments", new java.lang.Object[0]);
	}

	public void setSegments(double[][] value) {
		super.call("set_segments", new java.lang.Object[]{(java.lang.Object) value});
	}
}
