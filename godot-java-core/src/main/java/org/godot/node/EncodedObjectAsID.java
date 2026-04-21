package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class EncodedObjectAsID extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_object_id", 1286410249L), java.util.Map.entry("get_object_id", 3905245786L));

	EncodedObjectAsID(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EncodedObjectAsID(long nativePointer) {
		super(nativePointer);
	}

	public long getObject_id() {
		return (long) super.call("get_object_id", new java.lang.Object[0]);
	}

	public void setObject_id(long value) {
		super.call("set_object_id", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
