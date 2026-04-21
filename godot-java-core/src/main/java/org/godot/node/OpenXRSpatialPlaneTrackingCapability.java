package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialPlaneTrackingCapability extends OpenXRExtensionWrapper {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("is_supported", 2240911060L));

	OpenXRSpatialPlaneTrackingCapability(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialPlaneTrackingCapability(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_supported() {
		return (boolean) super.call("is_supported");
	}
}
