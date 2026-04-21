package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class TCPServer extends SocketServer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_local_port", 3905245786L), java.util.Map.entry("take_connection", 30545006L),
			java.util.Map.entry("listen", 3167955072L));

	TCPServer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TCPServer(long nativePointer) {
		super(nativePointer);
	}

	public int listen(long port, String bind_address) {
		return (int) super.call("listen",
				new java.lang.Object[]{java.lang.Long.valueOf(port), (java.lang.Object) bind_address});
	}

	public StreamPeerTCP take_connection() {
		return (StreamPeerTCP) super.call("take_connection");
	}
}
