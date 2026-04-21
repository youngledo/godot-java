package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class RemoteTransform2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_remote_node", 1348162250L),
			java.util.Map.entry("set_update_position", 2586408642L),
			java.util.Map.entry("set_update_scale", 2586408642L), java.util.Map.entry("get_update_position", 36873697L),
			java.util.Map.entry("get_remote_node", 4075236667L), java.util.Map.entry("get_update_rotation", 36873697L),
			java.util.Map.entry("get_update_scale", 36873697L),
			java.util.Map.entry("set_use_global_coordinates", 2586408642L),
			java.util.Map.entry("get_use_global_coordinates", 36873697L),
			java.util.Map.entry("force_update_cache", 3218959716L),
			java.util.Map.entry("set_update_rotation", 2586408642L));

	RemoteTransform2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RemoteTransform2D(long nativePointer) {
		super(nativePointer);
	}

	public void force_update_cache() {
		super.call("force_update_cache");
	}

	public String getRemote_path() {
		return (String) super.call("get_remote_node", new java.lang.Object[0]);
	}

	public void setRemote_path(String value) {
		super.call("set_remote_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getUse_global_coordinates() {
		return (boolean) super.call("get_use_global_coordinates", new java.lang.Object[0]);
	}

	public void setUse_global_coordinates(boolean value) {
		super.call("set_use_global_coordinates", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getUpdate_position() {
		return (boolean) super.call("get_update_position", new java.lang.Object[0]);
	}

	public void setUpdate_position(boolean value) {
		super.call("set_update_position", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getUpdate_rotation() {
		return (boolean) super.call("get_update_rotation", new java.lang.Object[0]);
	}

	public void setUpdate_rotation(boolean value) {
		super.call("set_update_rotation", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getUpdate_scale() {
		return (boolean) super.call("get_update_scale", new java.lang.Object[0]);
	}

	public void setUpdate_scale(boolean value) {
		super.call("set_update_scale", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
