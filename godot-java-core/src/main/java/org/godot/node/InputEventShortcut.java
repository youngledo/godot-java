package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class InputEventShortcut extends InputEvent {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_shortcut", 857163497L), java.util.Map.entry("get_shortcut", 3766804753L));

	InputEventShortcut(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventShortcut(long nativePointer) {
		super(nativePointer);
	}

	public Shortcut getShortcut() {
		return (Shortcut) super.call("get_shortcut", new java.lang.Object[0]);
	}

	public void setShortcut(Shortcut value) {
		super.call("set_shortcut", new java.lang.Object[]{(java.lang.Object) value});
	}
}
