package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;

public class PhysicsShapeQueryParameters2D extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_exclude", 3995934104L), java.util.Map.entry("get_margin", 1740695150L),
			java.util.Map.entry("get_motion", 3341600327L), java.util.Map.entry("set_margin", 373806689L),
			java.util.Map.entry("get_shape", 121922552L), java.util.Map.entry("set_shape", 968641751L),
			java.util.Map.entry("get_transform", 3814499831L), java.util.Map.entry("get_collision_mask", 3905245786L),
			java.util.Map.entry("set_shape_rid", 2722037293L),
			java.util.Map.entry("is_collide_with_bodies_enabled", 36873697L),
			java.util.Map.entry("is_collide_with_areas_enabled", 36873697L),
			java.util.Map.entry("set_collision_mask", 1286410249L), java.util.Map.entry("set_exclude", 381264803L),
			java.util.Map.entry("get_shape_rid", 2944877500L), java.util.Map.entry("set_motion", 743155724L),
			java.util.Map.entry("set_collide_with_bodies", 2586408642L),
			java.util.Map.entry("set_collide_with_areas", 2586408642L),
			java.util.Map.entry("set_transform", 2761652528L));

	PhysicsShapeQueryParameters2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsShapeQueryParameters2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_collide_with_bodies_enabled() {
		return (boolean) super.call("is_collide_with_bodies_enabled");
	}

	public boolean is_collide_with_areas_enabled() {
		return (boolean) super.call("is_collide_with_areas_enabled");
	}

	public long getCollision_mask() {
		return (long) super.call("get_collision_mask", new java.lang.Object[0]);
	}

	public void setCollision_mask(long value) {
		super.call("set_collision_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long[] getExclude() {
		return (long[]) super.call("get_exclude", new java.lang.Object[0]);
	}

	public void setExclude(long[] value) {
		super.call("set_exclude", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getMargin() {
		return (double) super.call("get_margin", new java.lang.Object[0]);
	}

	public void setMargin(double value) {
		super.call("set_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getMotion() {
		return (Vector2) super.call("get_motion", new java.lang.Object[0]);
	}

	public void setMotion(Vector2 value) {
		super.call("set_motion", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Shape2D getShape() {
		return (Shape2D) super.call("get_shape", new java.lang.Object[0]);
	}

	public void setShape(Shape2D value) {
		super.call("set_shape", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getShape_rid() {
		return (long) super.call("get_shape_rid", new java.lang.Object[0]);
	}

	public void setShape_rid(long value) {
		super.call("set_shape_rid", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Transform2D getTransform() {
		return (Transform2D) super.call("get_transform", new java.lang.Object[0]);
	}

	public void setTransform(Transform2D value) {
		super.call("set_transform", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isCollide_with_bodies() {
		return (boolean) super.call("is_collide_with_bodies_enabled", new java.lang.Object[0]);
	}

	public void setCollide_with_bodies(boolean value) {
		super.call("set_collide_with_bodies", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isCollide_with_areas() {
		return (boolean) super.call("is_collide_with_areas_enabled", new java.lang.Object[0]);
	}

	public void setCollide_with_areas(boolean value) {
		super.call("set_collide_with_areas", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
