package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class StreamPeerTCP extends StreamPeerSocket {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_local_port", 3905245786L), java.util.Map.entry("bind", 3167955072L),
			java.util.Map.entry("set_no_delay", 2586408642L), java.util.Map.entry("connect_to_host", 993915709L),
			java.util.Map.entry("get_connected_port", 3905245786L),
			java.util.Map.entry("get_connected_host", 201670096L));

	StreamPeerTCP(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StreamPeerTCP(long nativePointer) {
		super(nativePointer);
	}

	public int bind(long port, String host) {
		return (int) super.call("bind", new java.lang.Object[]{java.lang.Long.valueOf(port), (java.lang.Object) host});
	}

	public int connect_to_host(String host, long port) {
		return (int) super.call("connect_to_host",
				new java.lang.Object[]{(java.lang.Object) host, java.lang.Long.valueOf(port)});
	}
}
