package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class VisualShaderNodeVec3Constant extends VisualShaderNodeConstant {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_constant", 3360562783L), java.util.Map.entry("set_constant", 3460891852L));

	VisualShaderNodeVec3Constant(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeVec3Constant(long nativePointer) {
		super(nativePointer);
	}

	public Vector3 getConstant() {
		return (Vector3) super.call("get_constant", new java.lang.Object[0]);
	}

	public void setConstant(Vector3 value) {
		super.call("set_constant", new java.lang.Object[]{(java.lang.Object) value});
	}
}
