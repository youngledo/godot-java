package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.core.RefCounted;

public class SceneState extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_path", 201670096L),
			java.util.Map.entry("is_node_instance_placeholder", 1116898809L),
			java.util.Map.entry("get_node_property_name", 351665558L),
			java.util.Map.entry("get_connection_source", 408788394L),
			java.util.Map.entry("get_node_owner_path", 408788394L),
			java.util.Map.entry("get_connection_count", 3905245786L), java.util.Map.entry("get_node_path", 2272487792L),
			java.util.Map.entry("get_connection_target", 408788394L),
			java.util.Map.entry("get_connection_unbinds", 923996154L),
			java.util.Map.entry("get_base_scene_state", 3479783971L),
			java.util.Map.entry("get_node_count", 3905245786L), java.util.Map.entry("get_node_name", 659327637L),
			java.util.Map.entry("get_connection_method", 659327637L),
			java.util.Map.entry("get_node_instance", 511017218L),
			java.util.Map.entry("get_connection_flags", 923996154L), java.util.Map.entry("get_node_index", 923996154L),
			java.util.Map.entry("get_node_property_value", 678354945L),
			java.util.Map.entry("get_connection_signal", 659327637L),
			java.util.Map.entry("get_node_groups", 647634434L), java.util.Map.entry("get_node_type", 659327637L),
			java.util.Map.entry("get_node_instance_placeholder", 844755477L),
			java.util.Map.entry("get_node_property_count", 923996154L),
			java.util.Map.entry("get_connection_binds", 663333327L));

	SceneState(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SceneState(long nativePointer) {
		super(nativePointer);
	}

	public String get_node_type(long idx) {
		return (String) super.call("get_node_type", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_node_name(long idx) {
		return (String) super.call("get_node_name", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_node_path(long idx, boolean for_parent) {
		return (String) super.call("get_node_path",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(for_parent)});
	}

	public String get_node_owner_path(long idx) {
		return (String) super.call("get_node_owner_path", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public boolean is_node_instance_placeholder(long idx) {
		return (boolean) super.call("is_node_instance_placeholder",
				new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_node_instance_placeholder(long idx) {
		return (String) super.call("get_node_instance_placeholder",
				new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public PackedScene get_node_instance(long idx) {
		return (PackedScene) super.call("get_node_instance", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String[] get_node_groups(long idx) {
		return (String[]) super.call("get_node_groups", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int get_node_index(long idx) {
		return (int) super.call("get_node_index", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int get_node_property_count(long idx) {
		return (int) super.call("get_node_property_count", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_node_property_name(long idx, long prop_idx) {
		return (String) super.call("get_node_property_name",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Long.valueOf(prop_idx)});
	}

	public Object get_node_property_value(long idx, long prop_idx) {
		return (Object) super.call("get_node_property_value",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Long.valueOf(prop_idx)});
	}

	public String get_connection_source(long idx) {
		return (String) super.call("get_connection_source", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_connection_signal(long idx) {
		return (String) super.call("get_connection_signal", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_connection_target(long idx) {
		return (String) super.call("get_connection_target", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_connection_method(long idx) {
		return (String) super.call("get_connection_method", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int get_connection_flags(long idx) {
		return (int) super.call("get_connection_flags", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public GodotArray get_connection_binds(long idx) {
		return (GodotArray) super.call("get_connection_binds", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int get_connection_unbinds(long idx) {
		return (int) super.call("get_connection_unbinds", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}
}
