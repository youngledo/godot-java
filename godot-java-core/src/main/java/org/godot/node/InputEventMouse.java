package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class InputEventMouse extends InputEventWithModifiers {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_position", 743155724L), java.util.Map.entry("get_button_mask", 2512161324L),
			java.util.Map.entry("get_position", 3341600327L), java.util.Map.entry("set_button_mask", 3950145251L),
			java.util.Map.entry("get_global_position", 3341600327L),
			java.util.Map.entry("set_global_position", 743155724L));

	InputEventMouse(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventMouse(long nativePointer) {
		super(nativePointer);
	}

	public long getButton_mask() {
		return (long) super.call("get_button_mask", new java.lang.Object[0]);
	}

	public void setButton_mask(long value) {
		super.call("set_button_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector2 getPosition() {
		return (Vector2) super.call("get_position", new java.lang.Object[0]);
	}

	public void setPosition(Vector2 value) {
		super.call("set_position", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getGlobal_position() {
		return (Vector2) super.call("get_global_position", new java.lang.Object[0]);
	}

	public void setGlobal_position(Vector2 value) {
		super.call("set_global_position", new java.lang.Object[]{(java.lang.Object) value});
	}
}
