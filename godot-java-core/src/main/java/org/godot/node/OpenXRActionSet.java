package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRActionSet extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_action", 349361333L), java.util.Map.entry("get_action_count", 3905245786L),
			java.util.Map.entry("get_localized_name", 201670096L), java.util.Map.entry("get_priority", 3905245786L),
			java.util.Map.entry("set_actions", 381264803L), java.util.Map.entry("remove_action", 349361333L),
			java.util.Map.entry("get_actions", 3995934104L), java.util.Map.entry("set_priority", 1286410249L),
			java.util.Map.entry("set_localized_name", 83702148L));

	OpenXRActionSet(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRActionSet(long nativePointer) {
		super(nativePointer);
	}

	public void add_action(OpenXRAction action) {
		super.call("add_action", new java.lang.Object[]{(java.lang.Object) action});
	}

	public void remove_action(OpenXRAction action) {
		super.call("remove_action", new java.lang.Object[]{(java.lang.Object) action});
	}

	public String getLocalized_name() {
		return (String) super.call("get_localized_name", new java.lang.Object[0]);
	}

	public void setLocalized_name(String value) {
		super.call("set_localized_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getPriority() {
		return (long) super.call("get_priority", new java.lang.Object[0]);
	}

	public void setPriority(long value) {
		super.call("set_priority", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public OpenXRAction getActions() {
		return (OpenXRAction) super.call("get_actions", new java.lang.Object[0]);
	}

	public void setActions(OpenXRAction value) {
		super.call("set_actions", new java.lang.Object[]{(java.lang.Object) value});
	}
}
