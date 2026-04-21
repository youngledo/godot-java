package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class EditorScriptPicker extends EditorResourcePicker {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_script_owner", 3160264692L), java.util.Map.entry("set_script_owner", 1078189570L));

	EditorScriptPicker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorScriptPicker(long nativePointer) {
		super(nativePointer);
	}

	public Node getScript_owner() {
		return (Node) super.call("get_script_owner", new java.lang.Object[0]);
	}

	public void setScript_owner(Node value) {
		super.call("set_script_owner", new java.lang.Object[]{(java.lang.Object) value});
	}
}
