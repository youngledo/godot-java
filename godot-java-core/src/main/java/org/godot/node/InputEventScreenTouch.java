package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class InputEventScreenTouch extends InputEventFromWindow {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_index", 3905245786L), java.util.Map.entry("set_position", 743155724L),
			java.util.Map.entry("get_position", 3341600327L), java.util.Map.entry("set_double_tap", 2586408642L),
			java.util.Map.entry("is_double_tap", 36873697L), java.util.Map.entry("set_pressed", 2586408642L),
			java.util.Map.entry("set_canceled", 2586408642L), java.util.Map.entry("set_index", 1286410249L));

	InputEventScreenTouch(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventScreenTouch(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_double_tap() {
		return (boolean) super.call("is_double_tap");
	}

	public long getIndex() {
		return (long) super.call("get_index", new java.lang.Object[0]);
	}

	public void setIndex(long value) {
		super.call("set_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector2 getPosition() {
		return (Vector2) super.call("get_position", new java.lang.Object[0]);
	}

	public void setPosition(Vector2 value) {
		super.call("set_position", new java.lang.Object[]{(java.lang.Object) value});
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

	public boolean isDouble_tap() {
		return (boolean) super.call("is_double_tap", new java.lang.Object[0]);
	}

	public void setDouble_tap(boolean value) {
		super.call("set_double_tap", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
