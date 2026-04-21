package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialCapabilityConfigurationAprilTag extends OpenXRSpatialCapabilityConfigurationBaseHeader {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_april_dict", 440273016L),
			java.util.Map.entry("get_enabled_components", 235988956L),
			java.util.Map.entry("set_april_dict", 3902905799L));

	OpenXRSpatialCapabilityConfigurationAprilTag(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialCapabilityConfigurationAprilTag(long nativePointer) {
		super(nativePointer);
	}

	public long getApril_dict() {
		return (long) super.call("get_april_dict", new java.lang.Object[0]);
	}

	public void setApril_dict(long value) {
		super.call("set_april_dict", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
