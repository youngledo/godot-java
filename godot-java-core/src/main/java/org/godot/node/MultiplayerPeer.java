package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class MultiplayerPeer extends PacketPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_transfer_channel", 3905245786L),
			java.util.Map.entry("set_transfer_channel", 1286410249L),
			java.util.Map.entry("is_server_relay_supported", 36873697L),
			java.util.Map.entry("set_target_peer", 1286410249L),
			java.util.Map.entry("set_refuse_new_connections", 2586408642L), java.util.Map.entry("poll", 3218959716L),
			java.util.Map.entry("get_packet_mode", 3369852622L), java.util.Map.entry("get_packet_peer", 3905245786L),
			java.util.Map.entry("disconnect_peer", 4023243586L), java.util.Map.entry("get_unique_id", 3905245786L),
			java.util.Map.entry("get_connection_status", 2147374275L),
			java.util.Map.entry("is_refusing_new_connections", 36873697L),
			java.util.Map.entry("get_packet_channel", 3905245786L),
			java.util.Map.entry("set_transfer_mode", 950411049L), java.util.Map.entry("close", 3218959716L),
			java.util.Map.entry("generate_unique_id", 3905245786L),
			java.util.Map.entry("get_transfer_mode", 3369852622L));

	MultiplayerPeer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MultiplayerPeer(long nativePointer) {
		super(nativePointer);
	}

	public void poll() {
		super.call("poll");
	}

	public void close() {
		super.call("close");
	}

	public void disconnect_peer(long peer, boolean force) {
		super.call("disconnect_peer",
				new java.lang.Object[]{java.lang.Long.valueOf(peer), java.lang.Boolean.valueOf(force)});
	}

	public long generate_unique_id() {
		return (long) super.call("generate_unique_id");
	}

	public boolean is_refusing_new_connections() {
		return (boolean) super.call("is_refusing_new_connections");
	}

	public boolean is_server_relay_supported() {
		return (boolean) super.call("is_server_relay_supported");
	}

	public boolean isRefuse_new_connections() {
		return (boolean) super.call("is_refusing_new_connections", new java.lang.Object[0]);
	}

	public void setRefuse_new_connections(boolean value) {
		super.call("set_refuse_new_connections", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getTransfer_mode() {
		return (long) super.call("get_transfer_mode", new java.lang.Object[0]);
	}

	public void setTransfer_mode(long value) {
		super.call("set_transfer_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTransfer_channel() {
		return (long) super.call("get_transfer_channel", new java.lang.Object[0]);
	}

	public void setTransfer_channel(long value) {
		super.call("set_transfer_channel", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
