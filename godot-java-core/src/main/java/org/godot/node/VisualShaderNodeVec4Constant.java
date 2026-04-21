package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Quaternion;
import org.godot.math.Vector4;

public class VisualShaderNodeVec4Constant extends VisualShaderNodeConstant {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_constant", 1222331677L), java.util.Map.entry("set_constant", 1727505552L));

	VisualShaderNodeVec4Constant(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeVec4Constant(long nativePointer) {
		super(nativePointer);
	}

	public Quaternion getConstant() {
		return (Quaternion) super.call("get_constant", new java.lang.Object[0]);
	}

	public void setConstant(Quaternion value) {
		super.call("set_constant", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector4 getConstant_v4() {
		return (Vector4) super.call("_get_constant_v4", new java.lang.Object[0]);
	}

	public void setConstant_v4(Vector4 value) {
		super.call("_set_constant_v4", new java.lang.Object[]{(java.lang.Object) value});
	}
}
