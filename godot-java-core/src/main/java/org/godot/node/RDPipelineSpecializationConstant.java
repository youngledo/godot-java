package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDPipelineSpecializationConstant extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_value", 1214101251L), java.util.Map.entry("set_value", 1114965689L),
			java.util.Map.entry("get_constant_id", 3905245786L), java.util.Map.entry("set_constant_id", 1286410249L));

	RDPipelineSpecializationConstant(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDPipelineSpecializationConstant(long nativePointer) {
		super(nativePointer);
	}

	public Object getValue() {
		return (Object) super.call("get_value", new java.lang.Object[0]);
	}

	public void setValue(Object value) {
		super.call("set_value", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getConstant_id() {
		return (long) super.call("get_constant_id", new java.lang.Object[0]);
	}

	public void setConstant_id(long value) {
		super.call("set_constant_id", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
