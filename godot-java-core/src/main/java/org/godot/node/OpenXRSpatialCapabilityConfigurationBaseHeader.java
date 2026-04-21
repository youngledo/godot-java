package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class OpenXRSpatialCapabilityConfigurationBaseHeader extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("has_valid_configuration", 36873697L));

	OpenXRSpatialCapabilityConfigurationBaseHeader(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialCapabilityConfigurationBaseHeader(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_valid_configuration() {
		return (boolean) super.call("has_valid_configuration");
	}
}
