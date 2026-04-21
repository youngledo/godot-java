package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.Callable;

public class MultiplayerSpawner extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_spawn_function", 1611583062L), java.util.Map.entry("spawn", 1991184589L),
			java.util.Map.entry("get_spawn_function", 1307783378L), java.util.Map.entry("get_spawn_limit", 3905245786L),
			java.util.Map.entry("get_spawn_path", 4075236667L), java.util.Map.entry("set_spawn_limit", 1286410249L),
			java.util.Map.entry("add_spawnable_scene", 83702148L), java.util.Map.entry("set_spawn_path", 1348162250L),
			java.util.Map.entry("clear_spawnable_scenes", 3218959716L),
			java.util.Map.entry("get_spawnable_scene_count", 3905245786L),
			java.util.Map.entry("get_spawnable_scene", 844755477L));

	MultiplayerSpawner(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MultiplayerSpawner(long nativePointer) {
		super(nativePointer);
	}

	public void add_spawnable_scene(String path) {
		super.call("add_spawnable_scene", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String get_spawnable_scene(long index) {
		return (String) super.call("get_spawnable_scene", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void clear_spawnable_scenes() {
		super.call("clear_spawnable_scenes");
	}

	public Node spawn(Object data) {
		return (Node) super.call("spawn", new java.lang.Object[]{(java.lang.Object) data});
	}

	public String getSpawn_path() {
		return (String) super.call("get_spawn_path", new java.lang.Object[0]);
	}

	public void setSpawn_path(String value) {
		super.call("set_spawn_path", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSpawn_limit() {
		return (long) super.call("get_spawn_limit", new java.lang.Object[0]);
	}

	public void setSpawn_limit(long value) {
		super.call("set_spawn_limit", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Callable getSpawn_function() {
		return (Callable) super.call("get_spawn_function", new java.lang.Object[0]);
	}

	public void setSpawn_function(Callable value) {
		super.call("set_spawn_function", new java.lang.Object[]{(java.lang.Object) value});
	}
}
