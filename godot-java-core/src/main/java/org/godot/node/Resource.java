package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class Resource extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("setup_local_to_scene", 3218959716L),
			java.util.Map.entry("set_id_for_path", 3186203200L), java.util.Map.entry("get_path", 201670096L),
			java.util.Map.entry("is_local_to_scene", 36873697L), java.util.Map.entry("set_path_cache", 83702148L),
			java.util.Map.entry("is_built_in", 36873697L), java.util.Map.entry("set_scene_unique_id", 83702148L),
			java.util.Map.entry("duplicate", 482882304L), java.util.Map.entry("get_rid", 2944877500L),
			java.util.Map.entry("get_id_for_path", 3135753539L),
			java.util.Map.entry("generate_scene_unique_id", 2841200299L),
			java.util.Map.entry("set_local_to_scene", 2586408642L), java.util.Map.entry("set_name", 83702148L),
			java.util.Map.entry("duplicate_deep", 905779109L), java.util.Map.entry("get_name", 201670096L),
			java.util.Map.entry("get_scene_unique_id", 201670096L), java.util.Map.entry("emit_changed", 3218959716L),
			java.util.Map.entry("take_over_path", 83702148L), java.util.Map.entry("reset_state", 3218959716L),
			java.util.Map.entry("set_path", 83702148L), java.util.Map.entry("get_local_scene", 3160264692L));

	Resource(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Resource(long nativePointer) {
		super(nativePointer);
	}

	public void take_over_path(String path) {
		super.call("take_over_path", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean is_local_to_scene() {
		return (boolean) super.call("is_local_to_scene");
	}

	public void setup_local_to_scene() {
		super.call("setup_local_to_scene");
	}

	public void reset_state() {
		super.call("reset_state");
	}

	public void set_id_for_path(String path, String id) {
		super.call("set_id_for_path", new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) id});
	}

	public String get_id_for_path(String path) {
		return (String) super.call("get_id_for_path", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean is_built_in() {
		return (boolean) super.call("is_built_in");
	}

	public String generate_scene_unique_id() {
		return (String) super.call("generate_scene_unique_id");
	}

	public void emit_changed() {
		super.call("emit_changed");
	}

	public Resource duplicate(boolean deep) {
		return (Resource) super.call("duplicate", new java.lang.Object[]{java.lang.Boolean.valueOf(deep)});
	}

	public Resource duplicate_deep(int deep_subresources_mode) {
		return (Resource) super.call("duplicate_deep",
				new java.lang.Object[]{java.lang.Integer.valueOf(deep_subresources_mode)});
	}

	public boolean isResource_local_to_scene() {
		return (boolean) super.call("is_local_to_scene", new java.lang.Object[0]);
	}

	public void setResource_local_to_scene(boolean value) {
		super.call("set_local_to_scene", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getResource_path() {
		return (String) super.call("get_path", new java.lang.Object[0]);
	}

	public void setResource_path(String value) {
		super.call("set_path", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getResource_name() {
		return (String) super.call("get_name", new java.lang.Object[0]);
	}

	public void setResource_name(String value) {
		super.call("set_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getResource_scene_unique_id() {
		return (String) super.call("get_scene_unique_id", new java.lang.Object[0]);
	}

	public void setResource_scene_unique_id(String value) {
		super.call("set_scene_unique_id", new java.lang.Object[]{(java.lang.Object) value});
	}
}
