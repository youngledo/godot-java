package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class StreamPeerSocket extends StreamPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_status", 1156122502L), java.util.Map.entry("poll", 166280745L),
			java.util.Map.entry("disconnect_from_host", 3218959716L));

	StreamPeerSocket(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StreamPeerSocket(long nativePointer) {
		super(nativePointer);
	}

	public int poll() {
		return (int) super.call("poll");
	}

	public void disconnect_from_host() {
		super.call("disconnect_from_host");
	}
}
