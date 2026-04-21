package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CSGTorus3D extends CSGPrimitive3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_inner_radius", 1740695150L), java.util.Map.entry("get_ring_sides", 3905245786L),
			java.util.Map.entry("set_ring_sides", 1286410249L), java.util.Map.entry("set_inner_radius", 373806689L),
			java.util.Map.entry("set_material", 2757459619L), java.util.Map.entry("get_material", 5934680L),
			java.util.Map.entry("set_sides", 1286410249L), java.util.Map.entry("get_sides", 3905245786L),
			java.util.Map.entry("get_smooth_faces", 36873697L), java.util.Map.entry("get_outer_radius", 1740695150L),
			java.util.Map.entry("set_outer_radius", 373806689L), java.util.Map.entry("set_smooth_faces", 2586408642L));

	CSGTorus3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CSGTorus3D(long nativePointer) {
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

	public long getSides() {
		return (long) super.call("get_sides", new java.lang.Object[0]);
	}

	public void setSides(long value) {
		super.call("set_sides", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRing_sides() {
		return (long) super.call("get_ring_sides", new java.lang.Object[0]);
	}

	public void setRing_sides(long value) {
		super.call("set_ring_sides", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getSmooth_faces() {
		return (boolean) super.call("get_smooth_faces", new java.lang.Object[0]);
	}

	public void setSmooth_faces(boolean value) {
		super.call("set_smooth_faces", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Object getMaterial() {
		return (Object) super.call("get_material", new java.lang.Object[0]);
	}

	public void setMaterial(Object value) {
		super.call("set_material", new java.lang.Object[]{(java.lang.Object) value});
	}
}
