package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRMarkerTracker extends OpenXRSpatialEntityTracker {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_marker_data", 1214101251L), java.util.Map.entry("get_marker_id", 3905245786L),
			java.util.Map.entry("set_marker_type", 2156241362L), java.util.Map.entry("set_bounds_size", 743155724L),
			java.util.Map.entry("set_marker_id", 1286410249L), java.util.Map.entry("get_marker_type", 612702862L),
			java.util.Map.entry("set_marker_data", 1114965689L), java.util.Map.entry("get_bounds_size", 3341600327L));

	OpenXRMarkerTracker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRMarkerTracker(long nativePointer) {
		super(nativePointer);
	}

	public long getBounds_size() {
		return (long) super.call("get_bounds_size", new java.lang.Object[0]);
	}

	public void setBounds_size(long value) {
		super.call("set_bounds_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMarker_type() {
		return (long) super.call("get_marker_type", new java.lang.Object[0]);
	}

	public void setMarker_type(long value) {
		super.call("set_marker_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMarker_id() {
		return (long) super.call("get_marker_id", new java.lang.Object[0]);
	}

	public void setMarker_id(long value) {
		super.call("set_marker_id", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
