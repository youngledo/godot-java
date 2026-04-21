package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialComponentPlaneAlignmentList extends OpenXRSpatialComponentData {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_plane_alignment", 3340200270L));

	OpenXRSpatialComponentPlaneAlignmentList(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialComponentPlaneAlignmentList(long nativePointer) {
		super(nativePointer);
	}

	public int get_plane_alignment(long index) {
		return (int) super.call("get_plane_alignment", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}
}
