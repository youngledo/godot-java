package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class InputMap extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_action_description", 957595536L),
			java.util.Map.entry("action_set_deadzone", 4135858297L),
			java.util.Map.entry("action_get_deadzone", 1391627649L),
			java.util.Map.entry("event_is_action", 3193353650L), java.util.Map.entry("action_add_event", 518302593L),
			java.util.Map.entry("load_from_project_settings", 3218959716L),
			java.util.Map.entry("add_action", 1195233573L), java.util.Map.entry("has_action", 2619796661L),
			java.util.Map.entry("action_get_events", 689397652L), java.util.Map.entry("action_erase_event", 518302593L),
			java.util.Map.entry("action_erase_events", 3304788590L), java.util.Map.entry("erase_action", 3304788590L),
			java.util.Map.entry("get_actions", 2915620761L), java.util.Map.entry("action_has_event", 1185871985L));

	InputMap(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputMap(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_action(String action) {
		return (boolean) super.call("has_action", new java.lang.Object[]{(java.lang.Object) action});
	}

	public void add_action(String action, double deadzone) {
		super.call("add_action", new java.lang.Object[]{(java.lang.Object) action, java.lang.Double.valueOf(deadzone)});
	}

	public void erase_action(String action) {
		super.call("erase_action", new java.lang.Object[]{(java.lang.Object) action});
	}

	public String get_action_description(String action) {
		return (String) super.call("get_action_description", new java.lang.Object[]{(java.lang.Object) action});
	}

	public void action_set_deadzone(String action, double deadzone) {
		super.call("action_set_deadzone",
				new java.lang.Object[]{(java.lang.Object) action, java.lang.Double.valueOf(deadzone)});
	}

	public double action_get_deadzone(String action) {
		return (double) super.call("action_get_deadzone", new java.lang.Object[]{(java.lang.Object) action});
	}

	public void action_add_event(String action, InputEvent event) {
		super.call("action_add_event", new java.lang.Object[]{(java.lang.Object) action, (java.lang.Object) event});
	}

	public boolean action_has_event(String action, InputEvent event) {
		return (boolean) super.call("action_has_event",
				new java.lang.Object[]{(java.lang.Object) action, (java.lang.Object) event});
	}

	public void action_erase_event(String action, InputEvent event) {
		super.call("action_erase_event", new java.lang.Object[]{(java.lang.Object) action, (java.lang.Object) event});
	}

	public void action_erase_events(String action) {
		super.call("action_erase_events", new java.lang.Object[]{(java.lang.Object) action});
	}

	public InputEvent[] action_get_events(String action) {
		return (InputEvent[]) super.call("action_get_events", new java.lang.Object[]{(java.lang.Object) action});
	}

	public boolean event_is_action(InputEvent event, String action, boolean exact_match) {
		return (boolean) super.call("event_is_action", new java.lang.Object[]{(java.lang.Object) event,
				(java.lang.Object) action, java.lang.Boolean.valueOf(exact_match)});
	}

	public void load_from_project_settings() {
		super.call("load_from_project_settings");
	}
}
