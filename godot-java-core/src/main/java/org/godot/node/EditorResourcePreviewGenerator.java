package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class EditorResourcePreviewGenerator extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("request_draw_and_wait", 145472570L));

	EditorResourcePreviewGenerator(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorResourcePreviewGenerator(long nativePointer) {
		super(nativePointer);
	}

	public void request_draw_and_wait(long viewport) {
		super.call("request_draw_and_wait", new java.lang.Object[]{java.lang.Long.valueOf(viewport)});
	}
}
