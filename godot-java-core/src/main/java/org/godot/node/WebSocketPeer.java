package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class WebSocketPeer extends PacketPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_current_outbound_buffered_amount", 3905245786L),
			java.util.Map.entry("get_close_reason", 201670096L),
			java.util.Map.entry("get_supported_protocols", 1139954409L), java.util.Map.entry("poll", 3218959716L),
			java.util.Map.entry("get_connected_port", 3905245786L), java.util.Map.entry("get_ready_state", 346482985L),
			java.util.Map.entry("get_handshake_headers", 1139954409L),
			java.util.Map.entry("set_handshake_headers", 4015028928L), java.util.Map.entry("send_text", 166001499L),
			java.util.Map.entry("set_no_delay", 2586408642L),
			java.util.Map.entry("get_outbound_buffer_size", 3905245786L),
			java.util.Map.entry("accept_stream", 255125695L),
			java.util.Map.entry("set_supported_protocols", 4015028928L),
			java.util.Map.entry("set_max_queued_packets", 1286410249L), java.util.Map.entry("close", 1047156615L),
			java.util.Map.entry("was_string_packet", 36873697L), java.util.Map.entry("get_requested_url", 201670096L),
			java.util.Map.entry("get_max_queued_packets", 3905245786L),
			java.util.Map.entry("set_inbound_buffer_size", 1286410249L),
			java.util.Map.entry("set_outbound_buffer_size", 1286410249L),
			java.util.Map.entry("get_connected_host", 201670096L), java.util.Map.entry("connect_to_url", 1966198364L),
			java.util.Map.entry("get_inbound_buffer_size", 3905245786L),
			java.util.Map.entry("set_heartbeat_interval", 373806689L),
			java.util.Map.entry("get_heartbeat_interval", 1740695150L), java.util.Map.entry("send", 2780360567L),
			java.util.Map.entry("get_selected_protocol", 201670096L),
			java.util.Map.entry("get_close_code", 3905245786L));

	WebSocketPeer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WebSocketPeer(long nativePointer) {
		super(nativePointer);
	}

	public int connect_to_url(String url, TLSOptions tls_client_options) {
		return (int) super.call("connect_to_url",
				new java.lang.Object[]{(java.lang.Object) url, (java.lang.Object) tls_client_options});
	}

	public int accept_stream(StreamPeer stream) {
		return (int) super.call("accept_stream", new java.lang.Object[]{(java.lang.Object) stream});
	}

	public int send(byte[] message, int write_mode) {
		return (int) super.call("send",
				new java.lang.Object[]{(java.lang.Object) message, java.lang.Integer.valueOf(write_mode)});
	}

	public int send_text(String message) {
		return (int) super.call("send_text", new java.lang.Object[]{(java.lang.Object) message});
	}

	public boolean was_string_packet() {
		return (boolean) super.call("was_string_packet");
	}

	public void poll() {
		super.call("poll");
	}

	public void close(long code, String reason) {
		super.call("close", new java.lang.Object[]{java.lang.Long.valueOf(code), (java.lang.Object) reason});
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

	public long getMax_queued_packets() {
		return (long) super.call("get_max_queued_packets", new java.lang.Object[0]);
	}

	public void setMax_queued_packets(long value) {
		super.call("set_max_queued_packets", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getHeartbeat_interval() {
		return (long) super.call("get_heartbeat_interval", new java.lang.Object[0]);
	}

	public void setHeartbeat_interval(long value) {
		super.call("set_heartbeat_interval", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
