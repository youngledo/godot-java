package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class StreamPeerTLS extends StreamPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_stream", 2741655269L), java.util.Map.entry("disconnect_from_stream", 3218959716L),
			java.util.Map.entry("accept_stream", 4292689651L), java.util.Map.entry("get_status", 1128380576L),
			java.util.Map.entry("poll", 3218959716L), java.util.Map.entry("connect_to_stream", 57169517L));

	StreamPeerTLS(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StreamPeerTLS(long nativePointer) {
		super(nativePointer);
	}

	public void poll() {
		super.call("poll");
	}

	public int accept_stream(StreamPeer stream, TLSOptions server_options) {
		return (int) super.call("accept_stream",
				new java.lang.Object[]{(java.lang.Object) stream, (java.lang.Object) server_options});
	}

	public int connect_to_stream(StreamPeer stream, String common_name, TLSOptions client_options) {
		return (int) super.call("connect_to_stream", new java.lang.Object[]{(java.lang.Object) stream,
				(java.lang.Object) common_name, (java.lang.Object) client_options});
	}

	public void disconnect_from_stream() {
		super.call("disconnect_from_stream");
	}
}
