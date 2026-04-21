package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PacketPeerUDP extends PacketPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_local_port", 3905245786L), java.util.Map.entry("wait", 166280745L),
			java.util.Map.entry("get_packet_ip", 201670096L), java.util.Map.entry("join_multicast_group", 852856452L),
			java.util.Map.entry("set_dest_address", 993915709L), java.util.Map.entry("is_socket_connected", 36873697L),
			java.util.Map.entry("leave_multicast_group", 852856452L),
			java.util.Map.entry("get_packet_port", 3905245786L),
			java.util.Map.entry("set_broadcast_enabled", 2586408642L), java.util.Map.entry("bind", 4051239242L),
			java.util.Map.entry("is_bound", 36873697L), java.util.Map.entry("connect_to_host", 993915709L),
			java.util.Map.entry("close", 3218959716L));

	PacketPeerUDP(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PacketPeerUDP(long nativePointer) {
		super(nativePointer);
	}

	public int bind(long port, String bind_address, long recv_buf_size) {
		return (int) super.call("bind", new java.lang.Object[]{java.lang.Long.valueOf(port),
				(java.lang.Object) bind_address, java.lang.Long.valueOf(recv_buf_size)});
	}

	public void close() {
		super.call("close");
	}

	public int wait_() {
		return (int) super.call("wait");
	}

	public boolean is_bound() {
		return (boolean) super.call("is_bound");
	}

	public int connect_to_host(String host, long port) {
		return (int) super.call("connect_to_host",
				new java.lang.Object[]{(java.lang.Object) host, java.lang.Long.valueOf(port)});
	}

	public boolean is_socket_connected() {
		return (boolean) super.call("is_socket_connected");
	}

	public int set_dest_address(String host, long port) {
		return (int) super.call("set_dest_address",
				new java.lang.Object[]{(java.lang.Object) host, java.lang.Long.valueOf(port)});
	}

	public int join_multicast_group(String multicast_address, String interface_name) {
		return (int) super.call("join_multicast_group",
				new java.lang.Object[]{(java.lang.Object) multicast_address, (java.lang.Object) interface_name});
	}

	public int leave_multicast_group(String multicast_address, String interface_name) {
		return (int) super.call("leave_multicast_group",
				new java.lang.Object[]{(java.lang.Object) multicast_address, (java.lang.Object) interface_name});
	}
}
