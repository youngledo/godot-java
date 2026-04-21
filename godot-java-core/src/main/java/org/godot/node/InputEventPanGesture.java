package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class InputEventPanGesture extends InputEventGesture {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_delta", 3341600327L), java.util.Map.entry("set_delta", 743155724L));

	InputEventPanGesture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventPanGesture(long nativePointer) {
		super(nativePointer);
	}

	public Vector2 getDelta() {
		return (Vector2) super.call("get_delta", new java.lang.Object[0]);
	}

	public void setDelta(Vector2 value) {
		super.call("set_delta", new java.lang.Object[]{(java.lang.Object) value});
	}
}
