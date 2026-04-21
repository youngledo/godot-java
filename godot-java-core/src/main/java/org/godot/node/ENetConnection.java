package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.core.RefCounted;

public class ENetConnection extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("broadcast", 2772371345L), java.util.Map.entry("get_local_port", 3905245786L),
			java.util.Map.entry("get_peers", 2915620761L), java.util.Map.entry("dtls_server_setup", 1262296096L),
			java.util.Map.entry("create_host", 117198950L), java.util.Map.entry("compress", 2660215187L),
			java.util.Map.entry("destroy", 3218959716L), java.util.Map.entry("create_host_bound", 1515002313L),
			java.util.Map.entry("channel_limit", 1286410249L), java.util.Map.entry("flush", 3218959716L),
			java.util.Map.entry("connect_to_host", 2171300490L), java.util.Map.entry("get_max_channels", 3905245786L),
			java.util.Map.entry("socket_send", 1100646812L), java.util.Map.entry("service", 2402345344L),
			java.util.Map.entry("dtls_client_setup", 1966198364L), java.util.Map.entry("pop_statistic", 2166904170L),
			java.util.Map.entry("refuse_new_connections", 2586408642L),
			java.util.Map.entry("bandwidth_limit", 2302169788L));

	ENetConnection(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ENetConnection(long nativePointer) {
		super(nativePointer);
	}

	public int create_host_bound(String bind_address, long bind_port, long max_peers, long max_channels,
			long in_bandwidth, long out_bandwidth) {
		return (int) super.call("create_host_bound",
				new java.lang.Object[]{(java.lang.Object) bind_address, java.lang.Long.valueOf(bind_port),
						java.lang.Long.valueOf(max_peers), java.lang.Long.valueOf(max_channels),
						java.lang.Long.valueOf(in_bandwidth), java.lang.Long.valueOf(out_bandwidth)});
	}

	public int create_host(long max_peers, long max_channels, long in_bandwidth, long out_bandwidth) {
		return (int) super.call("create_host",
				new java.lang.Object[]{java.lang.Long.valueOf(max_peers), java.lang.Long.valueOf(max_channels),
						java.lang.Long.valueOf(in_bandwidth), java.lang.Long.valueOf(out_bandwidth)});
	}

	public void destroy() {
		super.call("destroy");
	}

	public ENetPacketPeer connect_to_host(String address, long port, long channels, long data) {
		return (ENetPacketPeer) super.call("connect_to_host", new java.lang.Object[]{(java.lang.Object) address,
				java.lang.Long.valueOf(port), java.lang.Long.valueOf(channels), java.lang.Long.valueOf(data)});
	}

	public GodotArray service(long timeout) {
		return (GodotArray) super.call("service", new java.lang.Object[]{java.lang.Long.valueOf(timeout)});
	}

	public void flush() {
		super.call("flush");
	}

	public void bandwidth_limit(long in_bandwidth, long out_bandwidth) {
		super.call("bandwidth_limit",
				new java.lang.Object[]{java.lang.Long.valueOf(in_bandwidth), java.lang.Long.valueOf(out_bandwidth)});
	}

	public void channel_limit(long limit) {
		super.call("channel_limit", new java.lang.Object[]{java.lang.Long.valueOf(limit)});
	}

	public void broadcast(long channel, byte[] packet, long flags) {
		super.call("broadcast", new java.lang.Object[]{java.lang.Long.valueOf(channel), (java.lang.Object) packet,
				java.lang.Long.valueOf(flags)});
	}

	public void compress(int mode) {
		super.call("compress", new java.lang.Object[]{java.lang.Integer.valueOf(mode)});
	}

	public int dtls_server_setup(TLSOptions server_options) {
		return (int) super.call("dtls_server_setup", new java.lang.Object[]{(java.lang.Object) server_options});
	}

	public int dtls_client_setup(String hostname, TLSOptions client_options) {
		return (int) super.call("dtls_client_setup",
				new java.lang.Object[]{(java.lang.Object) hostname, (java.lang.Object) client_options});
	}

	public void refuse_new_connections(boolean refuse) {
		super.call("refuse_new_connections", new java.lang.Object[]{java.lang.Boolean.valueOf(refuse)});
	}

	public double pop_statistic(int statistic) {
		return (double) super.call("pop_statistic", new java.lang.Object[]{java.lang.Integer.valueOf(statistic)});
	}

	public void socket_send(String destination_address, long destination_port, byte[] packet) {
		super.call("socket_send", new java.lang.Object[]{(java.lang.Object) destination_address,
				java.lang.Long.valueOf(destination_port), (java.lang.Object) packet});
	}
}
