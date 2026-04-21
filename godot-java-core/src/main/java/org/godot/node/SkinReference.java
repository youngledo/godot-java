package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class SkinReference extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_skin", 2074563878L), java.util.Map.entry("get_skeleton", 2944877500L));

	SkinReference(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkinReference(long nativePointer) {
		super(nativePointer);
	}
}
