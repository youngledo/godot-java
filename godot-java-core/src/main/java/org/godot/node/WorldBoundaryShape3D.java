package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Plane;

public class WorldBoundaryShape3D extends Shape3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_plane", 2753500971L), java.util.Map.entry("set_plane", 3505987427L));

	WorldBoundaryShape3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WorldBoundaryShape3D(long nativePointer) {
		super(nativePointer);
	}

	public Plane getPlane() {
		return (Plane) super.call("get_plane", new java.lang.Object[0]);
	}

	public void setPlane(Plane value) {
		super.call("set_plane", new java.lang.Object[]{(java.lang.Object) value});
	}
}
