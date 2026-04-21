package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class VisualShaderNodeVec3Parameter extends VisualShaderNodeParameter {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_default_value", 3360562783L),
			java.util.Map.entry("is_default_value_enabled", 36873697L),
			java.util.Map.entry("set_default_value", 3460891852L),
			java.util.Map.entry("set_default_value_enabled", 2586408642L));

	VisualShaderNodeVec3Parameter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeVec3Parameter(long nativePointer) {
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

	public Vector3 getDefault_value() {
		return (Vector3) super.call("get_default_value", new java.lang.Object[0]);
	}

	public void setDefault_value(Vector3 value) {
		super.call("set_default_value", new java.lang.Object[]{(java.lang.Object) value});
	}
}
