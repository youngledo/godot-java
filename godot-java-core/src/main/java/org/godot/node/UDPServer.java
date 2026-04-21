package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class UDPServer extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_local_port", 3905245786L),
			java.util.Map.entry("get_max_pending_connections", 3905245786L),
			java.util.Map.entry("is_listening", 36873697L),
			java.util.Map.entry("set_max_pending_connections", 1286410249L),
			java.util.Map.entry("take_connection", 808734560L), java.util.Map.entry("stop", 3218959716L),
			java.util.Map.entry("poll", 166280745L), java.util.Map.entry("listen", 3167955072L),
			java.util.Map.entry("is_connection_available", 36873697L));

	UDPServer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	UDPServer(long nativePointer) {
		super(nativePointer);
	}

	public int listen(long port, String bind_address) {
		return (int) super.call("listen",
				new java.lang.Object[]{java.lang.Long.valueOf(port), (java.lang.Object) bind_address});
	}

	public int poll() {
		return (int) super.call("poll");
	}

	public boolean is_connection_available() {
		return (boolean) super.call("is_connection_available");
	}

	public boolean is_listening() {
		return (boolean) super.call("is_listening");
	}

	public PacketPeerUDP take_connection() {
		return (PacketPeerUDP) super.call("take_connection");
	}

	public void stop() {
		super.call("stop");
	}

	public long getMax_pending_connections() {
		return (long) super.call("get_max_pending_connections", new java.lang.Object[0]);
	}

	public void setMax_pending_connections(long value) {
		super.call("set_max_pending_connections", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
