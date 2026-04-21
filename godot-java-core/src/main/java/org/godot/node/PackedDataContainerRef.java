package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class PackedDataContainerRef extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("size", 3905245786L));

	PackedDataContainerRef(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PackedDataContainerRef(long nativePointer) {
		super(nativePointer);
	}

	public int size() {
		return (int) super.call("size");
	}
}
