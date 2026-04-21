package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class DTLSServer extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("take_connection", 3946580474L), java.util.Map.entry("setup", 1262296096L));

	DTLSServer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	DTLSServer(long nativePointer) {
		super(nativePointer);
	}

	public int setup(TLSOptions server_options) {
		return (int) super.call("setup", new java.lang.Object[]{(java.lang.Object) server_options});
	}

	public PacketPeerDTLS take_connection(PacketPeerUDP udp_peer) {
		return (PacketPeerDTLS) super.call("take_connection", new java.lang.Object[]{(java.lang.Object) udp_peer});
	}
}
