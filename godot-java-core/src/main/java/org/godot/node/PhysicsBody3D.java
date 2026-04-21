package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class PhysicsBody3D extends CollisionObject3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_gravity", 3360562783L),
			java.util.Map.entry("add_collision_exception_with", 1078189570L),
			java.util.Map.entry("set_axis_lock", 1787895195L), java.util.Map.entry("get_axis_lock", 2264617709L),
			java.util.Map.entry("remove_collision_exception_with", 1078189570L),
			java.util.Map.entry("move_and_collide", 3208792678L),
			java.util.Map.entry("get_collision_exceptions", 2915620761L),
			java.util.Map.entry("test_move", 2481691619L));

	PhysicsBody3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsBody3D(long nativePointer) {
		super(nativePointer);
	}

	public KinematicCollision3D move_and_collide(Vector3 motion, boolean test_only, double safe_margin,
			boolean recovery_as_collision, long max_collisions) {
		return (KinematicCollision3D) super.call("move_and_collide",
				new java.lang.Object[]{(java.lang.Object) motion, java.lang.Boolean.valueOf(test_only),
						java.lang.Double.valueOf(safe_margin), java.lang.Boolean.valueOf(recovery_as_collision),
						java.lang.Long.valueOf(max_collisions)});
	}

	public boolean test_move(Transform3D from, Vector3 motion, KinematicCollision3D collision, double safe_margin,
			boolean recovery_as_collision, long max_collisions) {
		return (boolean) super.call("test_move",
				new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) motion, (java.lang.Object) collision,
						java.lang.Double.valueOf(safe_margin), java.lang.Boolean.valueOf(recovery_as_collision),
						java.lang.Long.valueOf(max_collisions)});
	}

	public void set_axis_lock(int axis, boolean lock) {
		super.call("set_axis_lock",
				new java.lang.Object[]{java.lang.Integer.valueOf(axis), java.lang.Boolean.valueOf(lock)});
	}

	public boolean get_axis_lock(int axis) {
		return (boolean) super.call("get_axis_lock", new java.lang.Object[]{java.lang.Integer.valueOf(axis)});
	}

	public void add_collision_exception_with(Node body) {
		super.call("add_collision_exception_with", new java.lang.Object[]{(java.lang.Object) body});
	}

	public void remove_collision_exception_with(Node body) {
		super.call("remove_collision_exception_with", new java.lang.Object[]{(java.lang.Object) body});
	}

	public boolean getAxis_lock_linear_x() {
		return (boolean) super.call("get_axis_lock", new java.lang.Object[0]);
	}

	public void setAxis_lock_linear_x(boolean value) {
		super.call("set_axis_lock", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAxis_lock_linear_y() {
		return (boolean) super.call("get_axis_lock", new java.lang.Object[0]);
	}

	public void setAxis_lock_linear_y(boolean value) {
		super.call("set_axis_lock", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAxis_lock_linear_z() {
		return (boolean) super.call("get_axis_lock", new java.lang.Object[0]);
	}

	public void setAxis_lock_linear_z(boolean value) {
		super.call("set_axis_lock", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAxis_lock_angular_x() {
		return (boolean) super.call("get_axis_lock", new java.lang.Object[0]);
	}

	public void setAxis_lock_angular_x(boolean value) {
		super.call("set_axis_lock", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAxis_lock_angular_y() {
		return (boolean) super.call("get_axis_lock", new java.lang.Object[0]);
	}

	public void setAxis_lock_angular_y(boolean value) {
		super.call("set_axis_lock", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAxis_lock_angular_z() {
		return (boolean) super.call("get_axis_lock", new java.lang.Object[0]);
	}

	public void setAxis_lock_angular_z(boolean value) {
		super.call("set_axis_lock", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
