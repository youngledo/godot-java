package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class WeakRef extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_ref", 1214101251L));

	WeakRef(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WeakRef(long nativePointer) {
		super(nativePointer);
	}
}
