package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeParameterRef extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_parameter_name", 83702148L),
			java.util.Map.entry("get_parameter_name", 201670096L));

	VisualShaderNodeParameterRef(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeParameterRef(long nativePointer) {
		super(nativePointer);
	}

	public String getParameter_name() {
		return (String) super.call("get_parameter_name", new java.lang.Object[0]);
	}

	public void setParameter_name(String value) {
		super.call("set_parameter_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getParam_type() {
		return (long) super.call("_get_parameter_type", new java.lang.Object[0]);
	}

	public void setParam_type(long value) {
		super.call("_set_parameter_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
