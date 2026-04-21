package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class InputEventFromWindow extends InputEvent {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_window_id", 3905245786L), java.util.Map.entry("set_window_id", 1286410249L));

	InputEventFromWindow(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventFromWindow(long nativePointer) {
		super(nativePointer);
	}

	public long getWindow_id() {
		return (long) super.call("get_window_id", new java.lang.Object[0]);
	}

	public void setWindow_id(long value) {
		super.call("set_window_id", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
