package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialComponentMarkerList extends OpenXRSpatialComponentData {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_marker_data", 4069510997L), java.util.Map.entry("get_marker_id", 923996154L),
			java.util.Map.entry("get_marker_type", 2627847866L));

	OpenXRSpatialComponentMarkerList(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialComponentMarkerList(long nativePointer) {
		super(nativePointer);
	}

	public int get_marker_type(long index) {
		return (int) super.call("get_marker_type", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public long get_marker_id(long index) {
		return (long) super.call("get_marker_id", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public Object get_marker_data(long snapshot, long index) {
		return (Object) super.call("get_marker_data",
				new java.lang.Object[]{java.lang.Long.valueOf(snapshot), java.lang.Long.valueOf(index)});
	}
}
