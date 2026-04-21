package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialQueryResultData extends OpenXRSpatialComponentData {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_entity_id", 923996154L), java.util.Map.entry("get_capacity", 3905245786L),
			java.util.Map.entry("get_entity_state", 1411962015L));

	OpenXRSpatialQueryResultData(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialQueryResultData(long nativePointer) {
		super(nativePointer);
	}

	public java.math.BigInteger get_entity_id(long index) {
		return (java.math.BigInteger) super.call("get_entity_id",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_entity_state(long index) {
		return (int) super.call("get_entity_state", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}
}
