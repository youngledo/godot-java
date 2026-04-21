package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class InputEventMouseButton extends InputEventMouse {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_factor", 1740695150L), java.util.Map.entry("set_factor", 373806689L),
			java.util.Map.entry("is_double_click", 36873697L), java.util.Map.entry("get_button_index", 1132662608L),
			java.util.Map.entry("set_double_click", 2586408642L), java.util.Map.entry("set_pressed", 2586408642L),
			java.util.Map.entry("set_canceled", 2586408642L), java.util.Map.entry("set_button_index", 3624991109L));

	InputEventMouseButton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventMouseButton(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_double_click() {
		return (boolean) super.call("is_double_click");
	}

	public double getFactor() {
		return (double) super.call("get_factor", new java.lang.Object[0]);
	}

	public void setFactor(double value) {
		super.call("set_factor", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getButton_index() {
		return (long) super.call("get_button_index", new java.lang.Object[0]);
	}

	public void setButton_index(long value) {
		super.call("set_button_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isCanceled() {
		return (boolean) super.call("is_canceled", new java.lang.Object[0]);
	}

	public void setCanceled(boolean value) {
		super.call("set_canceled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPressed() {
		return (boolean) super.call("is_pressed", new java.lang.Object[0]);
	}

	public void setPressed(boolean value) {
		super.call("set_pressed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDouble_click() {
		return (boolean) super.call("is_double_click", new java.lang.Object[0]);
	}

	public void setDouble_click(boolean value) {
		super.call("set_double_click", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
