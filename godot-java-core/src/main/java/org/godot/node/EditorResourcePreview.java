package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;

public class EditorResourcePreview extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_preview_generator", 332288124L),
			java.util.Map.entry("check_for_invalidation", 83702148L),
			java.util.Map.entry("queue_edited_resource_preview", 1608376650L),
			java.util.Map.entry("queue_resource_preview", 233177534L),
			java.util.Map.entry("remove_preview_generator", 332288124L));

	EditorResourcePreview(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorResourcePreview(long nativePointer) {
		super(nativePointer);
	}

	public void queue_resource_preview(String path, GodotObject receiver, String receiver_func, Object userdata) {
		super.call("queue_resource_preview", new java.lang.Object[]{(java.lang.Object) path,
				(java.lang.Object) receiver, (java.lang.Object) receiver_func, (java.lang.Object) userdata});
	}

	public void queue_edited_resource_preview(Resource resource, GodotObject receiver, String receiver_func,
			Object userdata) {
		super.call("queue_edited_resource_preview", new java.lang.Object[]{(java.lang.Object) resource,
				(java.lang.Object) receiver, (java.lang.Object) receiver_func, (java.lang.Object) userdata});
	}

	public void add_preview_generator(EditorResourcePreviewGenerator generator) {
		super.call("add_preview_generator", new java.lang.Object[]{(java.lang.Object) generator});
	}

	public void remove_preview_generator(EditorResourcePreviewGenerator generator) {
		super.call("remove_preview_generator", new java.lang.Object[]{(java.lang.Object) generator});
	}

	public void check_for_invalidation(String path) {
		super.call("check_for_invalidation", new java.lang.Object[]{(java.lang.Object) path});
	}
}
