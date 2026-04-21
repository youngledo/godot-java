package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class WebSocketMultiplayerPeer extends MultiplayerPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_peer", 1381378851L), java.util.Map.entry("set_handshake_timeout", 373806689L),
			java.util.Map.entry("create_server", 2400822951L),
			java.util.Map.entry("get_supported_protocols", 1139954409L),
			java.util.Map.entry("get_max_queued_packets", 3905245786L),
			java.util.Map.entry("set_inbound_buffer_size", 1286410249L),
			java.util.Map.entry("set_outbound_buffer_size", 1286410249L),
			java.util.Map.entry("get_peer_address", 844755477L),
			java.util.Map.entry("get_handshake_headers", 1139954409L), java.util.Map.entry("get_peer_port", 923996154L),
			java.util.Map.entry("set_handshake_headers", 4015028928L),
			java.util.Map.entry("get_inbound_buffer_size", 3905245786L),
			java.util.Map.entry("get_outbound_buffer_size", 3905245786L),
			java.util.Map.entry("set_supported_protocols", 4015028928L),
			java.util.Map.entry("set_max_queued_packets", 1286410249L),
			java.util.Map.entry("get_handshake_timeout", 1740695150L),
			java.util.Map.entry("create_client", 1966198364L));

	WebSocketMultiplayerPeer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WebSocketMultiplayerPeer(long nativePointer) {
		super(nativePointer);
	}

	public int create_client(String url, TLSOptions tls_client_options) {
		return (int) super.call("create_client",
				new java.lang.Object[]{(java.lang.Object) url, (java.lang.Object) tls_client_options});
	}

	public int create_server(long port, String bind_address, TLSOptions tls_server_options) {
		return (int) super.call("create_server", new java.lang.Object[]{java.lang.Long.valueOf(port),
				(java.lang.Object) bind_address, (java.lang.Object) tls_server_options});
	}

	public WebSocketPeer get_peer(long peer_id) {
		return (WebSocketPeer) super.call("get_peer", new java.lang.Object[]{java.lang.Long.valueOf(peer_id)});
	}

	public String get_peer_address(long id) {
		return (String) super.call("get_peer_address", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public int get_peer_port(long id) {
		return (int) super.call("get_peer_port", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public String[] getSupported_protocols() {
		return (String[]) super.call("get_supported_protocols", new java.lang.Object[0]);
	}

	public void setSupported_protocols(String[] value) {
		super.call("set_supported_protocols", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String[] getHandshake_headers() {
		return (String[]) super.call("get_handshake_headers", new java.lang.Object[0]);
	}

	public void setHandshake_headers(String[] value) {
		super.call("set_handshake_headers", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getInbound_buffer_size() {
		return (long) super.call("get_inbound_buffer_size", new java.lang.Object[0]);
	}

	public void setInbound_buffer_size(long value) {
		super.call("set_inbound_buffer_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getOutbound_buffer_size() {
		return (long) super.call("get_outbound_buffer_size", new java.lang.Object[0]);
	}

	public void setOutbound_buffer_size(long value) {
		super.call("set_outbound_buffer_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getHandshake_timeout() {
		return (double) super.call("get_handshake_timeout", new java.lang.Object[0]);
	}

	public void setHandshake_timeout(double value) {
		super.call("set_handshake_timeout", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getMax_queued_packets() {
		return (long) super.call("get_max_queued_packets", new java.lang.Object[0]);
	}

	public void setMax_queued_packets(long value) {
		super.call("set_max_queued_packets", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
