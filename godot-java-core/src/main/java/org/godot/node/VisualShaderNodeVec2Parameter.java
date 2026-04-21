package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class VisualShaderNodeVec2Parameter extends VisualShaderNodeParameter {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_default_value", 3341600327L),
			java.util.Map.entry("is_default_value_enabled", 36873697L),
			java.util.Map.entry("set_default_value", 743155724L),
			java.util.Map.entry("set_default_value_enabled", 2586408642L));

	VisualShaderNodeVec2Parameter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeVec2Parameter(long nativePointer) {
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

	public Vector2 getDefault_value() {
		return (Vector2) super.call("get_default_value", new java.lang.Object[0]);
	}

	public void setDefault_value(Vector2 value) {
		super.call("set_default_value", new java.lang.Object[]{(java.lang.Object) value});
	}
}
