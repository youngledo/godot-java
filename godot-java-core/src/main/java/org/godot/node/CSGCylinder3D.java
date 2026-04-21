package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CSGCylinder3D extends CSGPrimitive3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_material", 2757459619L), java.util.Map.entry("get_material", 5934680L),
			java.util.Map.entry("set_sides", 1286410249L), java.util.Map.entry("get_sides", 3905245786L),
			java.util.Map.entry("get_smooth_faces", 36873697L), java.util.Map.entry("get_radius", 1740695150L),
			java.util.Map.entry("set_cone", 2586408642L), java.util.Map.entry("set_height", 373806689L),
			java.util.Map.entry("set_radius", 373806689L), java.util.Map.entry("get_height", 1740695150L),
			java.util.Map.entry("is_cone", 36873697L), java.util.Map.entry("set_smooth_faces", 2586408642L));

	CSGCylinder3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CSGCylinder3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_cone() {
		return (boolean) super.call("is_cone");
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

	public long getSides() {
		return (long) super.call("get_sides", new java.lang.Object[0]);
	}

	public void setSides(long value) {
		super.call("set_sides", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isCone() {
		return (boolean) super.call("is_cone", new java.lang.Object[0]);
	}

	public void setCone(boolean value) {
		super.call("set_cone", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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
