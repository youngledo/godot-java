package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class TorusMesh extends PrimitiveMesh {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_inner_radius", 1740695150L), java.util.Map.entry("set_inner_radius", 373806689L),
			java.util.Map.entry("set_ring_segments", 1286410249L), java.util.Map.entry("get_outer_radius", 1740695150L),
			java.util.Map.entry("get_rings", 3905245786L), java.util.Map.entry("get_ring_segments", 3905245786L),
			java.util.Map.entry("set_outer_radius", 373806689L), java.util.Map.entry("set_rings", 1286410249L));

	TorusMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TorusMesh(long nativePointer) {
		super(nativePointer);
	}

	public double getInner_radius() {
		return (double) super.call("get_inner_radius", new java.lang.Object[0]);
	}

	public void setInner_radius(double value) {
		super.call("set_inner_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getOuter_radius() {
		return (double) super.call("get_outer_radius", new java.lang.Object[0]);
	}

	public void setOuter_radius(double value) {
		super.call("set_outer_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getRings() {
		return (long) super.call("get_rings", new java.lang.Object[0]);
	}

	public void setRings(long value) {
		super.call("set_rings", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRing_segments() {
		return (long) super.call("get_ring_segments", new java.lang.Object[0]);
	}

	public void setRing_segments(long value) {
		super.call("set_ring_segments", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
