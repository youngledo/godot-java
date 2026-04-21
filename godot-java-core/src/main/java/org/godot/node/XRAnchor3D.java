package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class XRAnchor3D extends XRNode3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_plane", 2753500971L), java.util.Map.entry("get_size", 3360562783L));

	XRAnchor3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRAnchor3D(long nativePointer) {
		super(nativePointer);
	}
}
