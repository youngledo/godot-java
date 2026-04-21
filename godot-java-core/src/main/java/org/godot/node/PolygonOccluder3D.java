package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PolygonOccluder3D extends Occluder3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_polygon", 1509147220L), java.util.Map.entry("get_polygon", 2961356807L));

	PolygonOccluder3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PolygonOccluder3D(long nativePointer) {
		super(nativePointer);
	}

	public double[][] getPolygon() {
		return (double[][]) super.call("get_polygon", new java.lang.Object[0]);
	}

	public void setPolygon(double[][] value) {
		super.call("set_polygon", new java.lang.Object[]{(java.lang.Object) value});
	}
}
