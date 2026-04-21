package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;
import org.godot.math.Vector2;

public class KinematicCollision2D extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_position", 3341600327L), java.util.Map.entry("get_depth", 1740695150L),
			java.util.Map.entry("get_collider_rid", 2944877500L),
			java.util.Map.entry("get_collider_velocity", 3341600327L), java.util.Map.entry("get_travel", 3341600327L),
			java.util.Map.entry("get_collider_shape", 1981248198L), java.util.Map.entry("get_collider", 1981248198L),
			java.util.Map.entry("get_collider_shape_index", 3905245786L),
			java.util.Map.entry("get_collider_id", 3905245786L), java.util.Map.entry("get_angle", 2841063350L),
			java.util.Map.entry("get_remainder", 3341600327L), java.util.Map.entry("get_local_shape", 1981248198L),
			java.util.Map.entry("get_normal", 3341600327L));

	KinematicCollision2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	KinematicCollision2D(long nativePointer) {
		super(nativePointer);
	}

	public double get_angle(Vector2 up_direction) {
		return (double) super.call("get_angle", new java.lang.Object[]{(java.lang.Object) up_direction});
	}
}
