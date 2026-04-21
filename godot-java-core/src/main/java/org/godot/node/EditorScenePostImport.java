package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class EditorScenePostImport extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_source_file", 201670096L));

	EditorScenePostImport(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorScenePostImport(long nativePointer) {
		super(nativePointer);
	}
}
