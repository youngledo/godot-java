package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeExpression extends VisualShaderNodeGroupBase {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_expression", 201670096L), java.util.Map.entry("set_expression", 83702148L));

	VisualShaderNodeExpression(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeExpression(long nativePointer) {
		super(nativePointer);
	}

	public String getExpression() {
		return (String) super.call("get_expression", new java.lang.Object[0]);
	}

	public void setExpression(String value) {
		super.call("set_expression", new java.lang.Object[]{(java.lang.Object) value});
	}
}
