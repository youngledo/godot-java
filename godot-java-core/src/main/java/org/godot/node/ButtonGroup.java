package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ButtonGroup extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_allow_unpress", 2240911060L), java.util.Map.entry("get_buttons", 2915620761L),
			java.util.Map.entry("set_allow_unpress", 2586408642L),
			java.util.Map.entry("get_pressed_button", 3886434893L));

	ButtonGroup(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ButtonGroup(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_allow_unpress() {
		return (boolean) super.call("is_allow_unpress");
	}

	public boolean isAllow_unpress() {
		return (boolean) super.call("is_allow_unpress", new java.lang.Object[0]);
	}

	public void setAllow_unpress(boolean value) {
		super.call("set_allow_unpress", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
