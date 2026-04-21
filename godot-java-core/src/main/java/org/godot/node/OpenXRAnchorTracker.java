package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRAnchorTracker extends OpenXRSpatialEntityTracker {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("has_uuid", 36873697L), java.util.Map.entry("get_uuid", 201670096L),
			java.util.Map.entry("set_uuid", 83702148L));

	OpenXRAnchorTracker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRAnchorTracker(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_uuid() {
		return (boolean) super.call("has_uuid");
	}

	public String getUuid() {
		return (String) super.call("get_uuid", new java.lang.Object[0]);
	}

	public void setUuid(String value) {
		super.call("set_uuid", new java.lang.Object[]{(java.lang.Object) value});
	}
}
