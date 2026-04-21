package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class InputEventJoypadButton extends InputEvent {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_pressure", 373806689L), java.util.Map.entry("get_pressure", 1740695150L),
			java.util.Map.entry("get_button_index", 595588182L), java.util.Map.entry("set_pressed", 2586408642L),
			java.util.Map.entry("set_button_index", 1466368136L));

	InputEventJoypadButton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventJoypadButton(long nativePointer) {
		super(nativePointer);
	}

	public long getButton_index() {
		return (long) super.call("get_button_index", new java.lang.Object[0]);
	}

	public void setButton_index(long value) {
		super.call("set_button_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getPressure() {
		return (double) super.call("get_pressure", new java.lang.Object[0]);
	}

	public void setPressure(double value) {
		super.call("set_pressure", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isPressed() {
		return (boolean) super.call("is_pressed", new java.lang.Object[0]);
	}

	public void setPressed(boolean value) {
		super.call("set_pressed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
