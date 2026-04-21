package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;

public class PhysicsBody2D extends CollisionObject2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_gravity", 3341600327L),
			java.util.Map.entry("add_collision_exception_with", 1078189570L),
			java.util.Map.entry("remove_collision_exception_with", 1078189570L),
			java.util.Map.entry("move_and_collide", 3681923724L),
			java.util.Map.entry("get_collision_exceptions", 2915620761L),
			java.util.Map.entry("test_move", 3324464701L));

	PhysicsBody2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsBody2D(long nativePointer) {
		super(nativePointer);
	}

	public KinematicCollision2D move_and_collide(Vector2 motion, boolean test_only, double safe_margin,
			boolean recovery_as_collision) {
		return (KinematicCollision2D) super.call("move_and_collide",
				new java.lang.Object[]{(java.lang.Object) motion, java.lang.Boolean.valueOf(test_only),
						java.lang.Double.valueOf(safe_margin), java.lang.Boolean.valueOf(recovery_as_collision)});
	}

	public boolean test_move(Transform2D from, Vector2 motion, KinematicCollision2D collision, double safe_margin,
			boolean recovery_as_collision) {
		return (boolean) super.call("test_move",
				new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) motion, (java.lang.Object) collision,
						java.lang.Double.valueOf(safe_margin), java.lang.Boolean.valueOf(recovery_as_collision)});
	}

	public void add_collision_exception_with(Node body) {
		super.call("add_collision_exception_with", new java.lang.Object[]{(java.lang.Object) body});
	}

	public void remove_collision_exception_with(Node body) {
		super.call("remove_collision_exception_with", new java.lang.Object[]{(java.lang.Object) body});
	}
}
