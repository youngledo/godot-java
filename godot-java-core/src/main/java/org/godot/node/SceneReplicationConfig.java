package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SceneReplicationConfig extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("property_set_spawn", 3868023870L),
			java.util.Map.entry("property_get_sync", 3456846888L), java.util.Map.entry("get_properties", 3995934104L),
			java.util.Map.entry("property_get_watch", 3456846888L), java.util.Map.entry("remove_property", 1348162250L),
			java.util.Map.entry("property_set_replication_mode", 3200083865L),
			java.util.Map.entry("property_set_watch", 3868023870L),
			java.util.Map.entry("property_get_index", 1382022557L),
			java.util.Map.entry("property_get_replication_mode", 2870606336L),
			java.util.Map.entry("property_get_spawn", 3456846888L),
			java.util.Map.entry("property_set_sync", 3868023870L), java.util.Map.entry("has_property", 861721659L),
			java.util.Map.entry("add_property", 4094619021L));

	SceneReplicationConfig(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SceneReplicationConfig(long nativePointer) {
		super(nativePointer);
	}

	public void add_property(String path, long index) {
		super.call("add_property", new java.lang.Object[]{(java.lang.Object) path, java.lang.Long.valueOf(index)});
	}

	public boolean has_property(String path) {
		return (boolean) super.call("has_property", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void remove_property(String path) {
		super.call("remove_property", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int property_get_index(String path) {
		return (int) super.call("property_get_index", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean property_get_spawn(String path) {
		return (boolean) super.call("property_get_spawn", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void property_set_spawn(String path, boolean enabled) {
		super.call("property_set_spawn",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Boolean.valueOf(enabled)});
	}

	public int property_get_replication_mode(String path) {
		return (int) super.call("property_get_replication_mode", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void property_set_replication_mode(String path, int mode) {
		super.call("property_set_replication_mode",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Integer.valueOf(mode)});
	}

	public boolean property_get_sync(String path) {
		return (boolean) super.call("property_get_sync", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void property_set_sync(String path, boolean enabled) {
		super.call("property_set_sync",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Boolean.valueOf(enabled)});
	}

	public boolean property_get_watch(String path) {
		return (boolean) super.call("property_get_watch", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void property_set_watch(String path, boolean enabled) {
		super.call("property_set_watch",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Boolean.valueOf(enabled)});
	}
}
