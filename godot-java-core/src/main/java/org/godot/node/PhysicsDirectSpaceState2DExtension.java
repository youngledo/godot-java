package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PhysicsDirectSpaceState2DExtension extends PhysicsDirectSpaceState2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("is_body_excluded_from_query", 4155700596L));

	PhysicsDirectSpaceState2DExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsDirectSpaceState2DExtension(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_body_excluded_from_query(long body) {
		return (boolean) super.call("is_body_excluded_from_query",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}
}
