package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialCapabilityConfigurationPlaneTracking extends OpenXRSpatialCapabilityConfigurationBaseHeader {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_enabled_components", 235988956L),
			java.util.Map.entry("supports_labels", 2240911060L), java.util.Map.entry("supports_mesh_2d", 2240911060L),
			java.util.Map.entry("supports_polygons", 2240911060L));

	OpenXRSpatialCapabilityConfigurationPlaneTracking(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialCapabilityConfigurationPlaneTracking(long nativePointer) {
		super(nativePointer);
	}

	public boolean supports_mesh_2d() {
		return (boolean) super.call("supports_mesh_2d");
	}

	public boolean supports_polygons() {
		return (boolean) super.call("supports_polygons");
	}

	public boolean supports_labels() {
		return (boolean) super.call("supports_labels");
	}
}
