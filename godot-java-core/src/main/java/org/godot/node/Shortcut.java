package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Shortcut extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("matches_event", 3738334489L), java.util.Map.entry("set_events", 381264803L),
			java.util.Map.entry("get_as_text", 201670096L), java.util.Map.entry("has_valid_event", 36873697L),
			java.util.Map.entry("get_events", 3995934104L));

	Shortcut(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Shortcut(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_valid_event() {
		return (boolean) super.call("has_valid_event");
	}

	public boolean matches_event(InputEvent event) {
		return (boolean) super.call("matches_event", new java.lang.Object[]{(java.lang.Object) event});
	}

	public InputEvent[] getEvents() {
		return (InputEvent[]) super.call("get_events", new java.lang.Object[0]);
	}

	public void setEvents(InputEvent[] value) {
		super.call("set_events", new java.lang.Object[]{(java.lang.Object) value});
	}
}
