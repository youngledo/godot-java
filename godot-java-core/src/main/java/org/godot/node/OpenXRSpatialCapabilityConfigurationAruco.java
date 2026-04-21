package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialCapabilityConfigurationAruco extends OpenXRSpatialCapabilityConfigurationBaseHeader {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_aruco_dict", 1080386209L), java.util.Map.entry("set_aruco_dict", 2268055963L),
			java.util.Map.entry("get_enabled_components", 235988956L));

	OpenXRSpatialCapabilityConfigurationAruco(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialCapabilityConfigurationAruco(long nativePointer) {
		super(nativePointer);
	}

	public long getAruco_dict() {
		return (long) super.call("get_aruco_dict", new java.lang.Object[0]);
	}

	public void setAruco_dict(long value) {
		super.call("set_aruco_dict", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
