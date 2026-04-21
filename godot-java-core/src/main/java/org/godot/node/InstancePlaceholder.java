package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;

public class InstancePlaceholder extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_instance_path", 201670096L), java.util.Map.entry("get_stored_values", 2230153369L),
			java.util.Map.entry("create_instance", 3794612210L));

	InstancePlaceholder(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InstancePlaceholder(long nativePointer) {
		super(nativePointer);
	}

	public GodotDictionary get_stored_values(boolean with_order) {
		return (GodotDictionary) super.call("get_stored_values",
				new java.lang.Object[]{java.lang.Boolean.valueOf(with_order)});
	}

	public Node create_instance(boolean replace, PackedScene custom_scene) {
		return (Node) super.call("create_instance",
				new java.lang.Object[]{java.lang.Boolean.valueOf(replace), (java.lang.Object) custom_scene});
	}
}
