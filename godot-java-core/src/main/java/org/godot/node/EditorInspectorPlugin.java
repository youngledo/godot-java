package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class EditorInspectorPlugin extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_property_editor", 2042698479L),
			java.util.Map.entry("add_property_editor_for_multiple_properties", 788598683L),
			java.util.Map.entry("add_custom_control", 1496901182L));

	EditorInspectorPlugin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorInspectorPlugin(long nativePointer) {
		super(nativePointer);
	}

	public void add_custom_control(Control control) {
		super.call("add_custom_control", new java.lang.Object[]{(java.lang.Object) control});
	}

	public void add_property_editor(String property, Control editor, boolean add_to_end, String label) {
		super.call("add_property_editor", new java.lang.Object[]{(java.lang.Object) property, (java.lang.Object) editor,
				java.lang.Boolean.valueOf(add_to_end), (java.lang.Object) label});
	}

	public void add_property_editor_for_multiple_properties(String label, String[] properties, Control editor) {
		super.call("add_property_editor_for_multiple_properties", new java.lang.Object[]{(java.lang.Object) label,
				(java.lang.Object) properties, (java.lang.Object) editor});
	}
}
