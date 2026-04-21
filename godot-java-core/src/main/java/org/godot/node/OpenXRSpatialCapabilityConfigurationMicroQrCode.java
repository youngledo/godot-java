package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialCapabilityConfigurationMicroQrCode extends OpenXRSpatialCapabilityConfigurationBaseHeader {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_enabled_components", 235988956L));

	OpenXRSpatialCapabilityConfigurationMicroQrCode(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialCapabilityConfigurationMicroQrCode(long nativePointer) {
		super(nativePointer);
	}
}
