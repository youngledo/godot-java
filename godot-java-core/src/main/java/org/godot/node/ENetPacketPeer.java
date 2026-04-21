package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ENetPacketPeer extends PacketPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("peer_disconnect_now", 1995695955L), java.util.Map.entry("is_active", 36873697L),
			java.util.Map.entry("get_statistic", 1642578323L), java.util.Map.entry("ping", 3218959716L),
			java.util.Map.entry("peer_disconnect_later", 1995695955L),
			java.util.Map.entry("get_remote_address", 201670096L), java.util.Map.entry("get_packet_flags", 3905245786L),
			java.util.Map.entry("get_state", 711068532L), java.util.Map.entry("set_timeout", 1649997291L),
			java.util.Map.entry("ping_interval", 1286410249L), java.util.Map.entry("get_remote_port", 3905245786L),
			java.util.Map.entry("reset", 3218959716L), java.util.Map.entry("throttle_configure", 1649997291L),
			java.util.Map.entry("send", 120522849L), java.util.Map.entry("get_channels", 3905245786L),
			java.util.Map.entry("peer_disconnect", 1995695955L));

	ENetPacketPeer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ENetPacketPeer(long nativePointer) {
		super(nativePointer);
	}

	public void peer_disconnect(long data) {
		super.call("peer_disconnect", new java.lang.Object[]{java.lang.Long.valueOf(data)});
	}

	public void peer_disconnect_later(long data) {
		super.call("peer_disconnect_later", new java.lang.Object[]{java.lang.Long.valueOf(data)});
	}

	public void peer_disconnect_now(long data) {
		super.call("peer_disconnect_now", new java.lang.Object[]{java.lang.Long.valueOf(data)});
	}

	public void ping() {
		super.call("ping");
	}

	public void ping_interval(long ping_interval) {
		super.call("ping_interval", new java.lang.Object[]{java.lang.Long.valueOf(ping_interval)});
	}

	public void reset() {
		super.call("reset");
	}

	public int send(long channel, byte[] packet, long flags) {
		return (int) super.call("send", new java.lang.Object[]{java.lang.Long.valueOf(channel),
				(java.lang.Object) packet, java.lang.Long.valueOf(flags)});
	}

	public void throttle_configure(long interval, long acceleration, long deceleration) {
		super.call("throttle_configure", new java.lang.Object[]{java.lang.Long.valueOf(interval),
				java.lang.Long.valueOf(acceleration), java.lang.Long.valueOf(deceleration)});
	}

	public void set_timeout(long timeout, long timeout_min, long timeout_max) {
		super.call("set_timeout", new java.lang.Object[]{java.lang.Long.valueOf(timeout),
				java.lang.Long.valueOf(timeout_min), java.lang.Long.valueOf(timeout_max)});
	}

	public double get_statistic(int statistic) {
		return (double) super.call("get_statistic", new java.lang.Object[]{java.lang.Integer.valueOf(statistic)});
	}

	public boolean is_active() {
		return (boolean) super.call("is_active");
	}
}
