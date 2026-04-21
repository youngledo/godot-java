package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialEntityTracker extends XRPositionalTracker {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_spatial_tracking_state", 2170234447L),
			java.util.Map.entry("set_entity", 2722037293L),
			java.util.Map.entry("get_spatial_tracking_state", 3351876560L),
			java.util.Map.entry("get_entity", 2944877500L));

	OpenXRSpatialEntityTracker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialEntityTracker(long nativePointer) {
		super(nativePointer);
	}

	public long getEntity() {
		return (long) super.call("get_entity", new java.lang.Object[0]);
	}

	public void setEntity(long value) {
		super.call("set_entity", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSpatial_tracking_state() {
		return (long) super.call("get_spatial_tracking_state", new java.lang.Object[0]);
	}

	public void setSpatial_tracking_state(long value) {
		super.call("set_spatial_tracking_state", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
