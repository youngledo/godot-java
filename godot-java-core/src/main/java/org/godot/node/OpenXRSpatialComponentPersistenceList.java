package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialComponentPersistenceList extends OpenXRSpatialComponentData {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_persistent_state", 923996154L),
			java.util.Map.entry("get_persistent_uuid", 844755477L));

	OpenXRSpatialComponentPersistenceList(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialComponentPersistenceList(long nativePointer) {
		super(nativePointer);
	}

	public String get_persistent_uuid(long index) {
		return (String) super.call("get_persistent_uuid", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public java.math.BigInteger get_persistent_state(long index) {
		return (java.math.BigInteger) super.call("get_persistent_state",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}
}
