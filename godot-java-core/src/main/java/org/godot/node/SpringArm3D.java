package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SpringArm3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_excluded_object", 2722037293L), java.util.Map.entry("get_hit_length", 191475506L),
			java.util.Map.entry("set_collision_mask", 1286410249L), java.util.Map.entry("get_margin", 191475506L),
			java.util.Map.entry("set_length", 373806689L), java.util.Map.entry("clear_excluded_objects", 3218959716L),
			java.util.Map.entry("set_margin", 373806689L), java.util.Map.entry("remove_excluded_object", 3521089500L),
			java.util.Map.entry("get_shape", 3214262478L), java.util.Map.entry("get_length", 1740695150L),
			java.util.Map.entry("set_shape", 1549710052L), java.util.Map.entry("get_collision_mask", 2455072627L));

	SpringArm3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SpringArm3D(long nativePointer) {
		super(nativePointer);
	}

	public void add_excluded_object(long rID) {
		super.call("add_excluded_object", new java.lang.Object[]{java.lang.Long.valueOf(rID)});
	}

	public boolean remove_excluded_object(long rID) {
		return (boolean) super.call("remove_excluded_object", new java.lang.Object[]{java.lang.Long.valueOf(rID)});
	}

	public void clear_excluded_objects() {
		super.call("clear_excluded_objects");
	}

	public long getCollision_mask() {
		return (long) super.call("get_collision_mask", new java.lang.Object[0]);
	}

	public void setCollision_mask(long value) {
		super.call("set_collision_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Shape3D getShape() {
		return (Shape3D) super.call("get_shape", new java.lang.Object[0]);
	}

	public void setShape(Shape3D value) {
		super.call("set_shape", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getSpring_length() {
		return (double) super.call("get_length", new java.lang.Object[0]);
	}

	public void setSpring_length(double value) {
		super.call("set_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMargin() {
		return (double) super.call("get_margin", new java.lang.Object[0]);
	}

	public void setMargin(double value) {
		super.call("set_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
