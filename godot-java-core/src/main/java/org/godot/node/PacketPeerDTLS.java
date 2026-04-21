package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PacketPeerDTLS extends PacketPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("connect_to_peer", 2880188099L), java.util.Map.entry("get_status", 3248654679L),
			java.util.Map.entry("poll", 3218959716L), java.util.Map.entry("disconnect_from_peer", 3218959716L));

	PacketPeerDTLS(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PacketPeerDTLS(long nativePointer) {
		super(nativePointer);
	}

	public void poll() {
		super.call("poll");
	}

	public int connect_to_peer(PacketPeerUDP packet_peer, String hostname, TLSOptions client_options) {
		return (int) super.call("connect_to_peer", new java.lang.Object[]{(java.lang.Object) packet_peer,
				(java.lang.Object) hostname, (java.lang.Object) client_options});
	}

	public void disconnect_from_peer() {
		super.call("disconnect_from_peer");
	}
}
