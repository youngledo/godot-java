package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class InputEventJoypadMotion extends InputEvent {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_axis", 4019121683L), java.util.Map.entry("set_axis", 1332685170L),
			java.util.Map.entry("set_axis_value", 373806689L), java.util.Map.entry("get_axis_value", 1740695150L));

	InputEventJoypadMotion(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventJoypadMotion(long nativePointer) {
		super(nativePointer);
	}

	public long getAxis() {
		return (long) super.call("get_axis", new java.lang.Object[0]);
	}

	public void setAxis(long value) {
		super.call("set_axis", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getAxis_value() {
		return (double) super.call("get_axis_value", new java.lang.Object[0]);
	}

	public void setAxis_value(double value) {
		super.call("set_axis_value", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
