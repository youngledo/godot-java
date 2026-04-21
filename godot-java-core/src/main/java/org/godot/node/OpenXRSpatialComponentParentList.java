package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialComponentParentList extends OpenXRSpatialComponentData {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_parent", 495598643L));

	OpenXRSpatialComponentParentList(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialComponentParentList(long nativePointer) {
		super(nativePointer);
	}

	public long get_parent(long index) {
		return (long) super.call("get_parent", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}
}
