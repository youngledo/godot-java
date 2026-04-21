package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRAction extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_localized_name", 201670096L), java.util.Map.entry("get_action_type", 3536542431L),
			java.util.Map.entry("set_action_type", 1675238366L), java.util.Map.entry("get_toplevel_paths", 1139954409L),
			java.util.Map.entry("set_toplevel_paths", 4015028928L),
			java.util.Map.entry("set_localized_name", 83702148L));

	OpenXRAction(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRAction(long nativePointer) {
		super(nativePointer);
	}

	public String getLocalized_name() {
		return (String) super.call("get_localized_name", new java.lang.Object[0]);
	}

	public void setLocalized_name(String value) {
		super.call("set_localized_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getAction_type() {
		return (long) super.call("get_action_type", new java.lang.Object[0]);
	}

	public void setAction_type(long value) {
		super.call("set_action_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String[] getToplevel_paths() {
		return (String[]) super.call("get_toplevel_paths", new java.lang.Object[0]);
	}

	public void setToplevel_paths(String[] value) {
		super.call("set_toplevel_paths", new java.lang.Object[]{(java.lang.Object) value});
	}
}
