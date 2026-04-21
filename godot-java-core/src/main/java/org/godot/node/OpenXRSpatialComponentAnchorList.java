package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;

public class OpenXRSpatialComponentAnchorList extends OpenXRSpatialComponentData {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_entity_pose", 1965739696L));

	OpenXRSpatialComponentAnchorList(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialComponentAnchorList(long nativePointer) {
		super(nativePointer);
	}

	public Transform3D get_entity_pose(long index) {
		return (Transform3D) super.call("get_entity_pose", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}
}
