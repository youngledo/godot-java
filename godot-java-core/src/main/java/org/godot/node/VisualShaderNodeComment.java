package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeComment extends VisualShaderNodeFrame {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_description", 201670096L), java.util.Map.entry("set_description", 83702148L));

	VisualShaderNodeComment(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeComment(long nativePointer) {
		super(nativePointer);
	}

	public String getDescription() {
		return (String) super.call("get_description", new java.lang.Object[0]);
	}

	public void setDescription(String value) {
		super.call("set_description", new java.lang.Object[]{(java.lang.Object) value});
	}
}
