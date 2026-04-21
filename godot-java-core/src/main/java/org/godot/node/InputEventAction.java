package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class InputEventAction extends InputEvent {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_action", 3304788590L), java.util.Map.entry("set_strength", 373806689L),
			java.util.Map.entry("get_event_index", 3905245786L), java.util.Map.entry("set_pressed", 2586408642L),
			java.util.Map.entry("get_action", 2002593661L), java.util.Map.entry("set_event_index", 1286410249L),
			java.util.Map.entry("get_strength", 1740695150L));

	InputEventAction(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventAction(long nativePointer) {
		super(nativePointer);
	}

	public String getAction() {
		return (String) super.call("get_action", new java.lang.Object[0]);
	}

	public void setAction(String value) {
		super.call("set_action", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isPressed() {
		return (boolean) super.call("is_pressed", new java.lang.Object[0]);
	}

	public void setPressed(boolean value) {
		super.call("set_pressed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getStrength() {
		return (double) super.call("get_strength", new java.lang.Object[0]);
	}

	public void setStrength(double value) {
		super.call("set_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getEvent_index() {
		return (long) super.call("get_event_index", new java.lang.Object[0]);
	}

	public void setEvent_index(long value) {
		super.call("set_event_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
