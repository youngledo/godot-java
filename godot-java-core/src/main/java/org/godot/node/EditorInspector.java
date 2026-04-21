package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;

public class EditorInspector extends ScrollContainer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_edited_object", 2050059866L), java.util.Map.entry("edit", 3975164845L),
			java.util.Map.entry("instantiate_property_editor", 1429914152L),
			java.util.Map.entry("get_selected_path", 201670096L));

	EditorInspector(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorInspector(long nativePointer) {
		super(nativePointer);
	}

	public void edit(GodotObject object) {
		super.call("edit", new java.lang.Object[]{(java.lang.Object) object});
	}

	public EditorProperty instantiate_property_editor(GodotObject object, int type, String path, int hint,
			String hint_text, long usage, boolean wide) {
		return (EditorProperty) super.call("instantiate_property_editor",
				new java.lang.Object[]{(java.lang.Object) object, java.lang.Integer.valueOf(type),
						(java.lang.Object) path, java.lang.Integer.valueOf(hint), (java.lang.Object) hint_text,
						java.lang.Long.valueOf(usage), java.lang.Boolean.valueOf(wide)});
	}
}
