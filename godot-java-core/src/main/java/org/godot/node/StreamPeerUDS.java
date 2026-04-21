package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class StreamPeerUDS extends StreamPeerSocket {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("bind", 166001499L), java.util.Map.entry("connect_to_host", 166001499L),
			java.util.Map.entry("get_connected_path", 201670096L));

	StreamPeerUDS(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StreamPeerUDS(long nativePointer) {
		super(nativePointer);
	}

	public int bind(String path) {
		return (int) super.call("bind", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int connect_to_host(String path) {
		return (int) super.call("connect_to_host", new java.lang.Object[]{(java.lang.Object) path});
	}
}
