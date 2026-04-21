package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeCompare extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_condition", 918742392L), java.util.Map.entry("set_comparison_type", 516558320L),
			java.util.Map.entry("set_function", 2370951349L), java.util.Map.entry("get_condition", 3281078941L),
			java.util.Map.entry("get_comparison_type", 3495315961L), java.util.Map.entry("get_function", 4089164265L));

	VisualShaderNodeCompare(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeCompare(long nativePointer) {
		super(nativePointer);
	}

	public long getType() {
		return (long) super.call("get_comparison_type", new java.lang.Object[0]);
	}

	public void setType(long value) {
		super.call("set_comparison_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFunction() {
		return (long) super.call("get_function", new java.lang.Object[0]);
	}

	public void setFunction(long value) {
		super.call("set_function", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCondition() {
		return (long) super.call("get_condition", new java.lang.Object[0]);
	}

	public void setCondition(long value) {
		super.call("set_condition", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
