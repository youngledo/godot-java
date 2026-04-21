package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeBillboard extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_keep_scale_enabled", 36873697L),
			java.util.Map.entry("get_billboard_type", 3724188517L),
			java.util.Map.entry("set_billboard_type", 1227463289L),
			java.util.Map.entry("set_keep_scale_enabled", 2586408642L));

	VisualShaderNodeBillboard(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeBillboard(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_keep_scale_enabled() {
		return (boolean) super.call("is_keep_scale_enabled");
	}

	public long getBillboard_type() {
		return (long) super.call("get_billboard_type", new java.lang.Object[0]);
	}

	public void setBillboard_type(long value) {
		super.call("set_billboard_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isKeep_scale() {
		return (boolean) super.call("is_keep_scale_enabled", new java.lang.Object[0]);
	}

	public void setKeep_scale(boolean value) {
		super.call("set_keep_scale_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
