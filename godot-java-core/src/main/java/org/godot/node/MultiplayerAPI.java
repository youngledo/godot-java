package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;
import org.godot.collection.GodotArray;
import org.godot.core.RefCounted;

public class MultiplayerAPI extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_peers", 969006518L), java.util.Map.entry("rpc", 2077486355L),
			java.util.Map.entry("object_configuration_add", 1171879464L), java.util.Map.entry("poll", 166280745L),
			java.util.Map.entry("get_multiplayer_peer", 3223692825L),
			java.util.Map.entry("has_multiplayer_peer", 2240911060L),
			java.util.Map.entry("object_configuration_remove", 1171879464L),
			java.util.Map.entry("set_default_interface", 3304788590L),
			java.util.Map.entry("get_default_interface", 2737447660L), java.util.Map.entry("is_server", 2240911060L),
			java.util.Map.entry("set_multiplayer_peer", 3694835298L),
			java.util.Map.entry("get_remote_sender_id", 2455072627L),
			java.util.Map.entry("create_default_interface", 3294156723L),
			java.util.Map.entry("get_unique_id", 2455072627L));

	MultiplayerAPI(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MultiplayerAPI(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_multiplayer_peer() {
		return (boolean) super.call("has_multiplayer_peer");
	}

	public boolean is_server() {
		return (boolean) super.call("is_server");
	}

	public int poll() {
		return (int) super.call("poll");
	}

	public int rpc(long peer, GodotObject object, String method, GodotArray arguments) {
		return (int) super.call("rpc", new java.lang.Object[]{java.lang.Long.valueOf(peer), (java.lang.Object) object,
				(java.lang.Object) method, (java.lang.Object) arguments});
	}

	public int object_configuration_add(GodotObject object, Object configuration) {
		return (int) super.call("object_configuration_add",
				new java.lang.Object[]{(java.lang.Object) object, (java.lang.Object) configuration});
	}

	public int object_configuration_remove(GodotObject object, Object configuration) {
		return (int) super.call("object_configuration_remove",
				new java.lang.Object[]{(java.lang.Object) object, (java.lang.Object) configuration});
	}

	public MultiplayerAPI create_default_interface() {
		return (MultiplayerAPI) super.call("create_default_interface");
	}

	public MultiplayerPeer getMultiplayer_peer() {
		return (MultiplayerPeer) super.call("get_multiplayer_peer", new java.lang.Object[0]);
	}

	public void setMultiplayer_peer(MultiplayerPeer value) {
		super.call("set_multiplayer_peer", new java.lang.Object[]{(java.lang.Object) value});
	}
}
