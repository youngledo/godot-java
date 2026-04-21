package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeDerivativeFunc extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_op_type", 377800221L), java.util.Map.entry("set_function", 1944704156L),
			java.util.Map.entry("get_op_type", 3997800514L), java.util.Map.entry("set_precision", 797270566L),
			java.util.Map.entry("get_precision", 3822547323L), java.util.Map.entry("get_function", 2389093396L));

	VisualShaderNodeDerivativeFunc(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeDerivativeFunc(long nativePointer) {
		super(nativePointer);
	}

	public long getOp_type() {
		return (long) super.call("get_op_type", new java.lang.Object[0]);
	}

	public void setOp_type(long value) {
		super.call("set_op_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFunction() {
		return (long) super.call("get_function", new java.lang.Object[0]);
	}

	public void setFunction(long value) {
		super.call("set_function", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPrecision() {
		return (long) super.call("get_precision", new java.lang.Object[0]);
	}

	public void setPrecision(long value) {
		super.call("set_precision", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
