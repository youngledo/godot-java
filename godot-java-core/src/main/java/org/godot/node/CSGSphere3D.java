package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CSGSphere3D extends CSGPrimitive3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_radial_segments", 3905245786L), java.util.Map.entry("set_material", 2757459619L),
			java.util.Map.entry("get_material", 5934680L), java.util.Map.entry("set_radial_segments", 1286410249L),
			java.util.Map.entry("get_smooth_faces", 36873697L), java.util.Map.entry("get_radius", 1740695150L),
			java.util.Map.entry("set_radius", 373806689L), java.util.Map.entry("get_rings", 3905245786L),
			java.util.Map.entry("set_rings", 1286410249L), java.util.Map.entry("set_smooth_faces", 2586408642L));

	CSGSphere3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CSGSphere3D(long nativePointer) {
		super(nativePointer);
	}

	public double getRadius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setRadius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getRadial_segments() {
		return (long) super.call("get_radial_segments", new java.lang.Object[0]);
	}

	public void setRadial_segments(long value) {
		super.call("set_radial_segments", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRings() {
		return (long) super.call("get_rings", new java.lang.Object[0]);
	}

	public void setRings(long value) {
		super.call("set_rings", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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
