package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeInput extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_input_real_name", 201670096L), java.util.Map.entry("get_input_name", 201670096L),
			java.util.Map.entry("set_input_name", 83702148L));

	VisualShaderNodeInput(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeInput(long nativePointer) {
		super(nativePointer);
	}

	public String getInput_name() {
		return (String) super.call("get_input_name", new java.lang.Object[0]);
	}

	public void setInput_name(String value) {
		super.call("set_input_name", new java.lang.Object[]{(java.lang.Object) value});
	}
}
