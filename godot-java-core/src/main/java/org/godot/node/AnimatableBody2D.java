package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimatableBody2D extends StaticBody2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_sync_to_physics", 2586408642L),
			java.util.Map.entry("is_sync_to_physics_enabled", 36873697L));

	AnimatableBody2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimatableBody2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_sync_to_physics_enabled() {
		return (boolean) super.call("is_sync_to_physics_enabled");
	}

	public boolean isSync_to_physics() {
		return (boolean) super.call("is_sync_to_physics_enabled", new java.lang.Object[0]);
	}

	public void setSync_to_physics(boolean value) {
		super.call("set_sync_to_physics", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
