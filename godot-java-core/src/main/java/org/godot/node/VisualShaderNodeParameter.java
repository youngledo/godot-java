package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeParameter extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_parameter_name", 83702148L),
			java.util.Map.entry("set_instance_index", 1286410249L),
			java.util.Map.entry("get_instance_index", 3905245786L), java.util.Map.entry("get_qualifier", 3558406205L),
			java.util.Map.entry("get_parameter_name", 201670096L), java.util.Map.entry("set_qualifier", 1276489447L));

	VisualShaderNodeParameter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeParameter(long nativePointer) {
		super(nativePointer);
	}

	public String getParameter_name() {
		return (String) super.call("get_parameter_name", new java.lang.Object[0]);
	}

	public void setParameter_name(String value) {
		super.call("set_parameter_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getQualifier() {
		return (long) super.call("get_qualifier", new java.lang.Object[0]);
	}

	public void setQualifier(long value) {
		super.call("set_qualifier", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getInstance_index() {
		return (long) super.call("get_instance_index", new java.lang.Object[0]);
	}

	public void setInstance_index(long value) {
		super.call("set_instance_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
