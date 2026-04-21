package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PhysicsServer3DExtension extends PhysicsServer3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("body_test_motion_is_excluding_body", 4155700596L),
			java.util.Map.entry("body_test_motion_is_excluding_object", 1116898809L));

	PhysicsServer3DExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsServer3DExtension(long nativePointer) {
		super(nativePointer);
	}

	public boolean body_test_motion_is_excluding_body(long body) {
		return (boolean) super.call("body_test_motion_is_excluding_body",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public boolean body_test_motion_is_excluding_object(long object) {
		return (boolean) super.call("body_test_motion_is_excluding_object",
				new java.lang.Object[]{java.lang.Long.valueOf(object)});
	}
}
