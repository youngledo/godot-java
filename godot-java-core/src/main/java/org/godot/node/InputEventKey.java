package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class InputEventKey extends InputEventWithModifiers {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_keycode_with_modifiers", 1585896689L),
			java.util.Map.entry("as_text_physical_keycode", 201670096L),
			java.util.Map.entry("set_key_label", 888074362L), java.util.Map.entry("get_key_label", 1585896689L),
			java.util.Map.entry("get_unicode", 3905245786L), java.util.Map.entry("as_text_key_label", 201670096L),
			java.util.Map.entry("set_pressed", 2586408642L), java.util.Map.entry("set_unicode", 1286410249L),
			java.util.Map.entry("get_physical_keycode_with_modifiers", 1585896689L),
			java.util.Map.entry("get_location", 211810873L), java.util.Map.entry("as_text_keycode", 201670096L),
			java.util.Map.entry("set_physical_keycode", 888074362L), java.util.Map.entry("set_location", 634453155L),
			java.util.Map.entry("as_text_location", 201670096L),
			java.util.Map.entry("get_key_label_with_modifiers", 1585896689L),
			java.util.Map.entry("get_physical_keycode", 1585896689L), java.util.Map.entry("get_keycode", 1585896689L),
			java.util.Map.entry("set_echo", 2586408642L), java.util.Map.entry("set_keycode", 888074362L));

	InputEventKey(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventKey(long nativePointer) {
		super(nativePointer);
	}

	public String as_text_keycode() {
		return (String) super.call("as_text_keycode");
	}

	public String as_text_physical_keycode() {
		return (String) super.call("as_text_physical_keycode");
	}

	public String as_text_key_label() {
		return (String) super.call("as_text_key_label");
	}

	public String as_text_location() {
		return (String) super.call("as_text_location");
	}

	public boolean isPressed() {
		return (boolean) super.call("is_pressed", new java.lang.Object[0]);
	}

	public void setPressed(boolean value) {
		super.call("set_pressed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getKeycode() {
		return (long) super.call("get_keycode", new java.lang.Object[0]);
	}

	public void setKeycode(long value) {
		super.call("set_keycode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPhysical_keycode() {
		return (long) super.call("get_physical_keycode", new java.lang.Object[0]);
	}

	public void setPhysical_keycode(long value) {
		super.call("set_physical_keycode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getKey_label() {
		return (long) super.call("get_key_label", new java.lang.Object[0]);
	}

	public void setKey_label(long value) {
		super.call("set_key_label", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getUnicode() {
		return (long) super.call("get_unicode", new java.lang.Object[0]);
	}

	public void setUnicode(long value) {
		super.call("set_unicode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getLocation() {
		return (long) super.call("get_location", new java.lang.Object[0]);
	}

	public void setLocation(long value) {
		super.call("set_location", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isEcho() {
		return (boolean) super.call("is_echo", new java.lang.Object[0]);
	}

	public void setEcho(boolean value) {
		super.call("set_echo", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
