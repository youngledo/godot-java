package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;
import org.godot.core.RefCounted;
import org.godot.math.Vector3;

public class PhysicsTestMotionResult3D extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_collision_depth", 218038398L),
			java.util.Map.entry("get_collision_point", 1914908202L),
			java.util.Map.entry("get_collider_velocity", 1914908202L),
			java.util.Map.entry("get_collider_rid", 1231817359L),
			java.util.Map.entry("get_collision_normal", 1914908202L), java.util.Map.entry("get_travel", 3360562783L),
			java.util.Map.entry("get_collision_unsafe_fraction", 1740695150L),
			java.util.Map.entry("get_collider_shape", 1591665591L), java.util.Map.entry("get_collider", 2639523548L),
			java.util.Map.entry("get_collision_local_shape", 1591665591L),
			java.util.Map.entry("get_collider_id", 1591665591L),
			java.util.Map.entry("get_collision_safe_fraction", 1740695150L),
			java.util.Map.entry("get_remainder", 3360562783L), java.util.Map.entry("get_collision_count", 3905245786L));

	PhysicsTestMotionResult3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsTestMotionResult3D(long nativePointer) {
		super(nativePointer);
	}

	public Vector3 get_collision_point(long collision_index) {
		return (Vector3) super.call("get_collision_point",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public Vector3 get_collision_normal(long collision_index) {
		return (Vector3) super.call("get_collision_normal",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public Vector3 get_collider_velocity(long collision_index) {
		return (Vector3) super.call("get_collider_velocity",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public java.math.BigInteger get_collider_id(long collision_index) {
		return (java.math.BigInteger) super.call("get_collider_id",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public long get_collider_rid(long collision_index) {
		return (long) super.call("get_collider_rid", new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public GodotObject get_collider(long collision_index) {
		return (GodotObject) super.call("get_collider",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public int get_collider_shape(long collision_index) {
		return (int) super.call("get_collider_shape", new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public int get_collision_local_shape(long collision_index) {
		return (int) super.call("get_collision_local_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}

	public double get_collision_depth(long collision_index) {
		return (double) super.call("get_collision_depth",
				new java.lang.Object[]{java.lang.Long.valueOf(collision_index)});
	}
}
