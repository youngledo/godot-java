package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;

public class WebRTCMultiplayerPeer extends MultiplayerPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_peers", 2382534195L), java.util.Map.entry("create_mesh", 2641732907L),
			java.util.Map.entry("remove_peer", 1286410249L), java.util.Map.entry("add_peer", 4078953270L),
			java.util.Map.entry("has_peer", 3067735520L), java.util.Map.entry("get_peer", 3554694381L),
			java.util.Map.entry("create_server", 2865356025L), java.util.Map.entry("create_client", 2641732907L));

	WebRTCMultiplayerPeer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WebRTCMultiplayerPeer(long nativePointer) {
		super(nativePointer);
	}

	public int create_server(GodotArray channels_config) {
		return (int) super.call("create_server", new java.lang.Object[]{(java.lang.Object) channels_config});
	}

	public int create_client(long peer_id, GodotArray channels_config) {
		return (int) super.call("create_client",
				new java.lang.Object[]{java.lang.Long.valueOf(peer_id), (java.lang.Object) channels_config});
	}

	public int create_mesh(long peer_id, GodotArray channels_config) {
		return (int) super.call("create_mesh",
				new java.lang.Object[]{java.lang.Long.valueOf(peer_id), (java.lang.Object) channels_config});
	}

	public int add_peer(WebRTCPeerConnection peer, long peer_id, long unreliable_lifetime) {
		return (int) super.call("add_peer", new java.lang.Object[]{(java.lang.Object) peer,
				java.lang.Long.valueOf(peer_id), java.lang.Long.valueOf(unreliable_lifetime)});
	}

	public void remove_peer(long peer_id) {
		super.call("remove_peer", new java.lang.Object[]{java.lang.Long.valueOf(peer_id)});
	}

	public boolean has_peer(long peer_id) {
		return (boolean) super.call("has_peer", new java.lang.Object[]{java.lang.Long.valueOf(peer_id)});
	}

	public GodotDictionary get_peer(long peer_id) {
		return (GodotDictionary) super.call("get_peer", new java.lang.Object[]{java.lang.Long.valueOf(peer_id)});
	}
}
