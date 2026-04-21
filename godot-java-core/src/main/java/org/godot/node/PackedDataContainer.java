package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PackedDataContainer extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("size", 3905245786L), java.util.Map.entry("pack", 966674026L));

	PackedDataContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PackedDataContainer(long nativePointer) {
		super(nativePointer);
	}

	public int pack(Object value) {
		return (int) super.call("pack", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int size() {
		return (int) super.call("size");
	}
}
