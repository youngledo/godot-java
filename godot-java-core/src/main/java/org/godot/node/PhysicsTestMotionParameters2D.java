package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.core.RefCounted;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;

public class PhysicsTestMotionParameters2D extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_exclude_bodies", 3995934104L), java.util.Map.entry("get_margin", 1740695150L),
			java.util.Map.entry("set_exclude_bodies", 381264803L), java.util.Map.entry("get_motion", 3341600327L),
			java.util.Map.entry("set_margin", 373806689L),
			java.util.Map.entry("set_recovery_as_collision_enabled", 2586408642L),
			java.util.Map.entry("is_collide_separation_ray_enabled", 36873697L),
			java.util.Map.entry("get_exclude_objects", 3995934104L), java.util.Map.entry("get_from", 3814499831L),
			java.util.Map.entry("set_motion", 743155724L),
			java.util.Map.entry("is_recovery_as_collision_enabled", 36873697L),
			java.util.Map.entry("set_exclude_objects", 381264803L), java.util.Map.entry("set_from", 2761652528L),
			java.util.Map.entry("set_collide_separation_ray_enabled", 2586408642L));

	PhysicsTestMotionParameters2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsTestMotionParameters2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_collide_separation_ray_enabled() {
		return (boolean) super.call("is_collide_separation_ray_enabled");
	}

	public boolean is_recovery_as_collision_enabled() {
		return (boolean) super.call("is_recovery_as_collision_enabled");
	}

	public Transform2D getFrom() {
		return (Transform2D) super.call("get_from", new java.lang.Object[0]);
	}

	public void setFrom(Transform2D value) {
		super.call("set_from", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getMotion() {
		return (Vector2) super.call("get_motion", new java.lang.Object[0]);
	}

	public void setMotion(Vector2 value) {
		super.call("set_motion", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getMargin() {
		return (double) super.call("get_margin", new java.lang.Object[0]);
	}

	public void setMargin(double value) {
		super.call("set_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isCollide_separation_ray() {
		return (boolean) super.call("is_collide_separation_ray_enabled", new java.lang.Object[0]);
	}

	public void setCollide_separation_ray(boolean value) {
		super.call("set_collide_separation_ray_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long[] getExclude_bodies() {
		return (long[]) super.call("get_exclude_bodies", new java.lang.Object[0]);
	}

	public void setExclude_bodies(long[] value) {
		super.call("set_exclude_bodies", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getExclude_objects() {
		return (GodotArray) super.call("get_exclude_objects", new java.lang.Object[0]);
	}

	public void setExclude_objects(GodotArray value) {
		super.call("set_exclude_objects", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isRecovery_as_collision() {
		return (boolean) super.call("is_recovery_as_collision_enabled", new java.lang.Object[0]);
	}

	public void setRecovery_as_collision(boolean value) {
		super.call("set_recovery_as_collision_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
