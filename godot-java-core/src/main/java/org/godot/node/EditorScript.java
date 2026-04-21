package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class EditorScript extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_root_node", 1078189570L), java.util.Map.entry("get_scene", 3160264692L),
			java.util.Map.entry("get_editor_interface", 1976662476L));

	EditorScript(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorScript(long nativePointer) {
		super(nativePointer);
	}

	public void add_root_node(Node node) {
		super.call("add_root_node", new java.lang.Object[]{(java.lang.Object) node});
	}
}
