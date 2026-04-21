package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class UDSServer extends SocketServer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("take_connection", 1623851112L), java.util.Map.entry("listen", 166001499L));

	UDSServer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	UDSServer(long nativePointer) {
		super(nativePointer);
	}

	public int listen(String path) {
		return (int) super.call("listen", new java.lang.Object[]{(java.lang.Object) path});
	}

	public StreamPeerUDS take_connection() {
		return (StreamPeerUDS) super.call("take_connection");
	}
}
