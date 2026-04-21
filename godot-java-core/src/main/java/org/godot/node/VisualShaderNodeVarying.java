package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeVarying extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_varying_name", 83702148L), java.util.Map.entry("get_varying_name", 201670096L),
			java.util.Map.entry("get_varying_type", 523183580L), java.util.Map.entry("set_varying_type", 3565867981L));

	VisualShaderNodeVarying(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeVarying(long nativePointer) {
		super(nativePointer);
	}

	public String getVarying_name() {
		return (String) super.call("get_varying_name", new java.lang.Object[0]);
	}

	public void setVarying_name(String value) {
		super.call("set_varying_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getVarying_type() {
		return (long) super.call("get_varying_type", new java.lang.Object[0]);
	}

	public void setVarying_type(long value) {
		super.call("set_varying_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
