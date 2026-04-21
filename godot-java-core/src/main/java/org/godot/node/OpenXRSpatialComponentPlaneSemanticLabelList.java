package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialComponentPlaneSemanticLabelList extends OpenXRSpatialComponentData {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_plane_semantic_label", 1889332427L));

	OpenXRSpatialComponentPlaneSemanticLabelList(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialComponentPlaneSemanticLabelList(long nativePointer) {
		super(nativePointer);
	}

	public int get_plane_semantic_label(long index) {
		return (int) super.call("get_plane_semantic_label", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}
}
