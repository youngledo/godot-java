package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class EditorResourceTooltipPlugin extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("request_thumbnail", 3245519720L));

	EditorResourceTooltipPlugin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorResourceTooltipPlugin(long nativePointer) {
		super(nativePointer);
	}

	public void request_thumbnail(String path, TextureRect control) {
		super.call("request_thumbnail", new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) control});
	}
}
