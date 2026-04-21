package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class FileSystemDock extends EditorDock {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("navigate_to_path", 83702148L),
			java.util.Map.entry("remove_resource_tooltip_plugin", 2258356838L),
			java.util.Map.entry("add_resource_tooltip_plugin", 2258356838L));

	FileSystemDock(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FileSystemDock(long nativePointer) {
		super(nativePointer);
	}

	public void navigate_to_path(String path) {
		super.call("navigate_to_path", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void add_resource_tooltip_plugin(EditorResourceTooltipPlugin plugin) {
		super.call("add_resource_tooltip_plugin", new java.lang.Object[]{(java.lang.Object) plugin});
	}

	public void remove_resource_tooltip_plugin(EditorResourceTooltipPlugin plugin) {
		super.call("remove_resource_tooltip_plugin", new java.lang.Object[]{(java.lang.Object) plugin});
	}
}
