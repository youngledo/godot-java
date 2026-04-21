package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PhysicalBoneSimulator3D extends SkeletonModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_simulating_physics", 36873697L),
			java.util.Map.entry("physical_bones_start_simulation", 2787316981L),
			java.util.Map.entry("physical_bones_remove_collision_exception", 2722037293L),
			java.util.Map.entry("physical_bones_stop_simulation", 3218959716L),
			java.util.Map.entry("physical_bones_add_collision_exception", 2722037293L));

	PhysicalBoneSimulator3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicalBoneSimulator3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_simulating_physics() {
		return (boolean) super.call("is_simulating_physics");
	}

	public void physical_bones_stop_simulation() {
		super.call("physical_bones_stop_simulation");
	}

	public void physical_bones_start_simulation(String[] bones) {
		super.call("physical_bones_start_simulation", new java.lang.Object[]{(java.lang.Object) bones});
	}

	public void physical_bones_add_collision_exception(long exception) {
		super.call("physical_bones_add_collision_exception", new java.lang.Object[]{java.lang.Long.valueOf(exception)});
	}

	public void physical_bones_remove_collision_exception(long exception) {
		super.call("physical_bones_remove_collision_exception",
				new java.lang.Object[]{java.lang.Long.valueOf(exception)});
	}
}
