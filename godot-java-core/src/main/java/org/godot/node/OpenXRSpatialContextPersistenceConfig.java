package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialContextPersistenceConfig extends OpenXRStructureBase {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_persistence_context", 2722037293L),
			java.util.Map.entry("remove_persistence_context", 2722037293L));

	OpenXRSpatialContextPersistenceConfig(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialContextPersistenceConfig(long nativePointer) {
		super(nativePointer);
	}

	public void add_persistence_context(long persistence_context) {
		super.call("add_persistence_context", new java.lang.Object[]{java.lang.Long.valueOf(persistence_context)});
	}

	public void remove_persistence_context(long persistence_context) {
		super.call("remove_persistence_context", new java.lang.Object[]{java.lang.Long.valueOf(persistence_context)});
	}
}
