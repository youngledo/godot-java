package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ENetMultiplayerPeer extends MultiplayerPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("create_mesh", 844576869L), java.util.Map.entry("get_peer", 3793311544L),
			java.util.Map.entry("create_server", 2917761309L), java.util.Map.entry("add_mesh_peer", 1293458335L),
			java.util.Map.entry("set_bind_ip", 83702148L), java.util.Map.entry("get_host", 4103238886L),
			java.util.Map.entry("create_client", 2327163476L));

	ENetMultiplayerPeer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ENetMultiplayerPeer(long nativePointer) {
		super(nativePointer);
	}

	public int create_server(long port, long max_clients, long max_channels, long in_bandwidth, long out_bandwidth) {
		return (int) super.call("create_server",
				new java.lang.Object[]{java.lang.Long.valueOf(port), java.lang.Long.valueOf(max_clients),
						java.lang.Long.valueOf(max_channels), java.lang.Long.valueOf(in_bandwidth),
						java.lang.Long.valueOf(out_bandwidth)});
	}

	public int create_client(String address, long port, long channel_count, long in_bandwidth, long out_bandwidth,
			long local_port) {
		return (int) super.call("create_client",
				new java.lang.Object[]{(java.lang.Object) address, java.lang.Long.valueOf(port),
						java.lang.Long.valueOf(channel_count), java.lang.Long.valueOf(in_bandwidth),
						java.lang.Long.valueOf(out_bandwidth), java.lang.Long.valueOf(local_port)});
	}

	public int create_mesh(long unique_id) {
		return (int) super.call("create_mesh", new java.lang.Object[]{java.lang.Long.valueOf(unique_id)});
	}

	public int add_mesh_peer(long peer_id, ENetConnection host) {
		return (int) super.call("add_mesh_peer",
				new java.lang.Object[]{java.lang.Long.valueOf(peer_id), (java.lang.Object) host});
	}

	public ENetPacketPeer get_peer(long id) {
		return (ENetPacketPeer) super.call("get_peer", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public ENetConnection getHost() {
		return (ENetConnection) super.call("get_host", new java.lang.Object[0]);
	}

	public void setHost(ENetConnection value) {
		super.call("set_host", new java.lang.Object[]{(java.lang.Object) value});
	}
}
