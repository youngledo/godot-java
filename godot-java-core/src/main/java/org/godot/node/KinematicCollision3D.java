package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;
import org.godot.core.RefCounted;
import org.godot.math.Vector3;

public class KinematicCollision3D extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_position", 1914908202L), java.util.Map.entry("get_depth", 1740695150L),
			java.util.Map.entry("get_collider_rid", 1231817359L),
			java.util.Map.entry("get_collider_velocity", 1914908202L), java.util.Map.entry("get_travel", 3360562783L),
			java.util.Map.entry("get_collider_shape", 2639523548L), java.util.Map.entry("get_collider", 2639523548L),
			java.util.Map.entry("get_collider_shape_index", 1591665591L),
			java.util.Map.entry("get_collider_id", 1591665591L), java.util.Map.entry("get_angle", 1242741860L),
			java.util.Map.entry("get_remainder", 3360562783L), java.util.Map.entry("get_local_shape", 2639523548L),
			java.util.Map.entry("get_collision_count", 3905245786L), java.util.Map.entry("get_normal", 1914908202L));

	KinematicCollision3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	KinematicCollision3D(long nativePointer) {
		super(nativePointer);
	}

	public Vector3 get_position(long collision_index) {
		return (Vector3) super.call("get_position", new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public Vector3 get_normal(long collision_index) {
		return (Vector3) super.call("get_normal", new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public double get_angle(long collision_index, Vector3 up_direction) {
		return (double) super.call("get_angle",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index), (java.lang.Object) up_direction});
	}

	public GodotObject get_local_shape(long collision_index) {
		return (GodotObject) super.call("get_local_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public GodotObject get_collider(long collision_index) {
		return (GodotObject) super.call("get_collider",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public java.math.BigInteger get_collider_id(long collision_index) {
		return (java.math.BigInteger) super.call("get_collider_id",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public long get_collider_rid(long collision_index) {
		return (long) super.call("get_collider_rid", new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public GodotObject get_collider_shape(long collision_index) {
		return (GodotObject) super.call("get_collider_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public int get_collider_shape_index(long collision_index) {
		return (int) super.call("get_collider_shape_index",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public Vector3 get_collider_velocity(long collision_index) {
		return (Vector3) super.call("get_collider_velocity",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}
}
