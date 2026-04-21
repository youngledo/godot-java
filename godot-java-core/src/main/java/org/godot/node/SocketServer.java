package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class SocketServer extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_listening", 36873697L), java.util.Map.entry("stop", 3218959716L),
			java.util.Map.entry("take_socket_connection", 1883962599L),
			java.util.Map.entry("is_connection_available", 36873697L));

	SocketServer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SocketServer(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_connection_available() {
		return (boolean) super.call("is_connection_available");
	}

	public boolean is_listening() {
		return (boolean) super.call("is_listening");
	}

	public void stop() {
		super.call("stop");
	}

	public StreamPeerSocket take_socket_connection() {
		return (StreamPeerSocket) super.call("take_socket_connection");
	}
}
