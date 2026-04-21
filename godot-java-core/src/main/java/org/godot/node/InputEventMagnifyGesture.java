package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class InputEventMagnifyGesture extends InputEventGesture {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_factor", 1740695150L), java.util.Map.entry("set_factor", 373806689L));

	InputEventMagnifyGesture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventMagnifyGesture(long nativePointer) {
		super(nativePointer);
	}

	public double getFactor() {
		return (double) super.call("get_factor", new java.lang.Object[0]);
	}

	public void setFactor(double value) {
		super.call("set_factor", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
