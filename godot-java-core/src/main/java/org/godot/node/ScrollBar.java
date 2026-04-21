package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ScrollBar extends Range {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_custom_step", 1740695150L), java.util.Map.entry("set_custom_step", 373806689L));

	ScrollBar(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ScrollBar(long nativePointer) {
		super(nativePointer);
	}

	public double getCustom_step() {
		return (double) super.call("get_custom_step", new java.lang.Object[0]);
	}

	public void setCustom_step(double value) {
		super.call("set_custom_step", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
