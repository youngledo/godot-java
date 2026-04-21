package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;

public class VisualShaderNodeTransformConstant extends VisualShaderNodeConstant {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_constant", 3229777777L), java.util.Map.entry("set_constant", 2952846383L));

	VisualShaderNodeTransformConstant(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeTransformConstant(long nativePointer) {
		super(nativePointer);
	}

	public Transform3D getConstant() {
		return (Transform3D) super.call("get_constant", new java.lang.Object[0]);
	}

	public void setConstant(Transform3D value) {
		super.call("set_constant", new java.lang.Object[]{(java.lang.Object) value});
	}
}
