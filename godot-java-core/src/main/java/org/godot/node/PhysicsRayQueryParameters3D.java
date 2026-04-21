package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;
import org.godot.math.Vector3;

public class PhysicsRayQueryParameters3D extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_exclude", 3995934104L), java.util.Map.entry("get_to", 3360562783L),
			java.util.Map.entry("is_hit_from_inside_enabled", 36873697L),
			java.util.Map.entry("get_collision_mask", 3905245786L),
			java.util.Map.entry("set_hit_back_faces", 2586408642L),
			java.util.Map.entry("set_hit_from_inside", 2586408642L),
			java.util.Map.entry("is_collide_with_bodies_enabled", 36873697L),
			java.util.Map.entry("is_collide_with_areas_enabled", 36873697L),
			java.util.Map.entry("set_collision_mask", 1286410249L), java.util.Map.entry("set_exclude", 381264803L),
			java.util.Map.entry("get_from", 3360562783L), java.util.Map.entry("create", 3110599579L),
			java.util.Map.entry("is_hit_back_faces_enabled", 36873697L), java.util.Map.entry("set_to", 3460891852L),
			java.util.Map.entry("set_collide_with_bodies", 2586408642L),
			java.util.Map.entry("set_collide_with_areas", 2586408642L), java.util.Map.entry("set_from", 3460891852L));

	PhysicsRayQueryParameters3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsRayQueryParameters3D(long nativePointer) {
		super(nativePointer);
	}

	public PhysicsRayQueryParameters3D create(Vector3 from, Vector3 to, long collision_mask, long[] exclude) {
		return (PhysicsRayQueryParameters3D) super.call("create", new java.lang.Object[]{(java.lang.Object) from,
				(java.lang.Object) to, java.lang.Long.valueOf(collision_mask), (java.lang.Object) exclude});
	}

	public boolean is_collide_with_bodies_enabled() {
		return (boolean) super.call("is_collide_with_bodies_enabled");
	}

	public boolean is_collide_with_areas_enabled() {
		return (boolean) super.call("is_collide_with_areas_enabled");
	}

	public boolean is_hit_from_inside_enabled() {
		return (boolean) super.call("is_hit_from_inside_enabled");
	}

	public boolean is_hit_back_faces_enabled() {
		return (boolean) super.call("is_hit_back_faces_enabled");
	}

	public Vector3 getFrom() {
		return (Vector3) super.call("get_from", new java.lang.Object[0]);
	}

	public void setFrom(Vector3 value) {
		super.call("set_from", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getTo() {
		return (Vector3) super.call("get_to", new java.lang.Object[0]);
	}

	public void setTo(Vector3 value) {
		super.call("set_to", new java.lang.Object[]{(java.lang.Object) value});
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

	public boolean isHit_from_inside() {
		return (boolean) super.call("is_hit_from_inside_enabled", new java.lang.Object[0]);
	}

	public void setHit_from_inside(boolean value) {
		super.call("set_hit_from_inside", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isHit_back_faces() {
		return (boolean) super.call("is_hit_back_faces_enabled", new java.lang.Object[0]);
	}

	public void setHit_back_faces(boolean value) {
		super.call("set_hit_back_faces", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
