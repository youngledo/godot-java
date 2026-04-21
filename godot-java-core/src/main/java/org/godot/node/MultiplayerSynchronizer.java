package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.Callable;

public class MultiplayerSynchronizer extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_root_path", 1348162250L),
			java.util.Map.entry("set_replication_interval", 373806689L),
			java.util.Map.entry("get_replication_interval", 1740695150L),
			java.util.Map.entry("remove_visibility_filter", 1611583062L),
			java.util.Map.entry("get_delta_interval", 1740695150L),
			java.util.Map.entry("set_visibility_for", 300928843L),
			java.util.Map.entry("get_visibility_update_mode", 3352241418L),
			java.util.Map.entry("update_visibility", 1995695955L),
			java.util.Map.entry("is_visibility_public", 36873697L),
			java.util.Map.entry("set_visibility_public", 2586408642L),
			java.util.Map.entry("add_visibility_filter", 1611583062L),
			java.util.Map.entry("get_visibility_for", 1116898809L), java.util.Map.entry("get_root_path", 4075236667L),
			java.util.Map.entry("set_replication_config", 3889206742L),
			java.util.Map.entry("set_delta_interval", 373806689L),
			java.util.Map.entry("get_replication_config", 3200254614L),
			java.util.Map.entry("set_visibility_update_mode", 3494860300L));

	MultiplayerSynchronizer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MultiplayerSynchronizer(long nativePointer) {
		super(nativePointer);
	}

	public void update_visibility(long for_peer) {
		super.call("update_visibility", new java.lang.Object[]{java.lang.Long.valueOf(for_peer)});
	}

	public boolean is_visibility_public() {
		return (boolean) super.call("is_visibility_public");
	}

	public void add_visibility_filter(Callable filter) {
		super.call("add_visibility_filter", new java.lang.Object[]{(java.lang.Object) filter});
	}

	public void remove_visibility_filter(Callable filter) {
		super.call("remove_visibility_filter", new java.lang.Object[]{(java.lang.Object) filter});
	}

	public void set_visibility_for(long peer, boolean visible) {
		super.call("set_visibility_for",
				new java.lang.Object[]{java.lang.Long.valueOf(peer), java.lang.Boolean.valueOf(visible)});
	}

	public boolean get_visibility_for(long peer) {
		return (boolean) super.call("get_visibility_for", new java.lang.Object[]{java.lang.Long.valueOf(peer)});
	}

	public String getRoot_path() {
		return (String) super.call("get_root_path", new java.lang.Object[0]);
	}

	public void setRoot_path(String value) {
		super.call("set_root_path", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getReplication_interval() {
		return (double) super.call("get_replication_interval", new java.lang.Object[0]);
	}

	public void setReplication_interval(double value) {
		super.call("set_replication_interval", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDelta_interval() {
		return (double) super.call("get_delta_interval", new java.lang.Object[0]);
	}

	public void setDelta_interval(double value) {
		super.call("set_delta_interval", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public SceneReplicationConfig getReplication_config() {
		return (SceneReplicationConfig) super.call("get_replication_config", new java.lang.Object[0]);
	}

	public void setReplication_config(SceneReplicationConfig value) {
		super.call("set_replication_config", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getVisibility_update_mode() {
		return (long) super.call("get_visibility_update_mode", new java.lang.Object[0]);
	}

	public void setVisibility_update_mode(long value) {
		super.call("set_visibility_update_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isPublic_visibility() {
		return (boolean) super.call("is_visibility_public", new java.lang.Object[0]);
	}

	public void setPublic_visibility(boolean value) {
		super.call("set_visibility_public", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
