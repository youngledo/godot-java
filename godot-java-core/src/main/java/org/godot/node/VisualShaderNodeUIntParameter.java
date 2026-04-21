package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeUIntParameter extends VisualShaderNodeParameter {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_default_value", 3905245786L),
			java.util.Map.entry("is_default_value_enabled", 36873697L),
			java.util.Map.entry("set_default_value", 1286410249L),
			java.util.Map.entry("set_default_value_enabled", 2586408642L));

	VisualShaderNodeUIntParameter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeUIntParameter(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_default_value_enabled() {
		return (boolean) super.call("is_default_value_enabled");
	}

	public boolean isDefault_value_enabled() {
		return (boolean) super.call("is_default_value_enabled", new java.lang.Object[0]);
	}

	public void setDefault_value_enabled(boolean value) {
		super.call("set_default_value_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getDefault_value() {
		return (long) super.call("get_default_value", new java.lang.Object[0]);
	}

	public void setDefault_value(long value) {
		super.call("set_default_value", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
