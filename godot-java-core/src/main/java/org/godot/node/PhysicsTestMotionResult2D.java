package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class PhysicsTestMotionResult2D extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_collision_depth", 1740695150L),
			java.util.Map.entry("get_collision_point", 3341600327L),
			java.util.Map.entry("get_collider_velocity", 3341600327L),
			java.util.Map.entry("get_collider_rid", 2944877500L),
			java.util.Map.entry("get_collision_normal", 3341600327L), java.util.Map.entry("get_travel", 3341600327L),
			java.util.Map.entry("get_collider_shape", 3905245786L),
			java.util.Map.entry("get_collision_unsafe_fraction", 1740695150L),
			java.util.Map.entry("get_collider", 1981248198L),
			java.util.Map.entry("get_collision_local_shape", 3905245786L),
			java.util.Map.entry("get_collider_id", 3905245786L),
			java.util.Map.entry("get_collision_safe_fraction", 1740695150L),
			java.util.Map.entry("get_remainder", 3341600327L));

	PhysicsTestMotionResult2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsTestMotionResult2D(long nativePointer) {
		super(nativePointer);
	}
}
