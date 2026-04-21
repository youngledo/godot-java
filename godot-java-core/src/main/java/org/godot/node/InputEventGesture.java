package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class InputEventGesture extends InputEventWithModifiers {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_position", 743155724L), java.util.Map.entry("get_position", 3341600327L));

	InputEventGesture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventGesture(long nativePointer) {
		super(nativePointer);
	}

	public Vector2 getPosition() {
		return (Vector2) super.call("get_position", new java.lang.Object[0]);
	}

	public void setPosition(Vector2 value) {
		super.call("set_position", new java.lang.Object[]{(java.lang.Object) value});
	}
}
