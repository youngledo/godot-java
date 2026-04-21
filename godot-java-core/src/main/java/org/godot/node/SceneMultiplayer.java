package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.Callable;

public class SceneMultiplayer extends MultiplayerAPI {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_server_relay_enabled", 2586408642L),
			java.util.Map.entry("set_root_path", 1348162250L),
			java.util.Map.entry("is_object_decoding_allowed", 36873697L),
			java.util.Map.entry("get_max_sync_packet_size", 3905245786L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("set_refuse_new_connections", 2586408642L),
			java.util.Map.entry("set_max_delta_packet_size", 1286410249L),
			java.util.Map.entry("is_server_relay_enabled", 36873697L), java.util.Map.entry("send_auth", 506032537L),
			java.util.Map.entry("complete_auth", 844576869L),
			java.util.Map.entry("get_authenticating_peers", 969006518L),
			java.util.Map.entry("set_auth_timeout", 373806689L), java.util.Map.entry("get_root_path", 4075236667L),
			java.util.Map.entry("disconnect_peer", 1286410249L), java.util.Map.entry("get_auth_timeout", 1740695150L),
			java.util.Map.entry("is_refusing_new_connections", 36873697L),
			java.util.Map.entry("set_allow_object_decoding", 2586408642L),
			java.util.Map.entry("set_auth_callback", 1611583062L), java.util.Map.entry("send_bytes", 1307428718L),
			java.util.Map.entry("get_max_delta_packet_size", 3905245786L),
			java.util.Map.entry("get_auth_callback", 1307783378L),
			java.util.Map.entry("set_max_sync_packet_size", 1286410249L));

	SceneMultiplayer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SceneMultiplayer(long nativePointer) {
		super(nativePointer);
	}

	public void clear() {
		super.call("clear");
	}

	public void disconnect_peer(long id) {
		super.call("disconnect_peer", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public int send_auth(long id, byte[] data) {
		return (int) super.call("send_auth",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) data});
	}

	public int complete_auth(long id) {
		return (int) super.call("complete_auth", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public boolean is_refusing_new_connections() {
		return (boolean) super.call("is_refusing_new_connections");
	}

	public boolean is_object_decoding_allowed() {
		return (boolean) super.call("is_object_decoding_allowed");
	}

	public boolean is_server_relay_enabled() {
		return (boolean) super.call("is_server_relay_enabled");
	}

	public int send_bytes(byte[] bytes, long id, int mode, long channel) {
		return (int) super.call("send_bytes", new java.lang.Object[]{(java.lang.Object) bytes,
				java.lang.Long.valueOf(id), java.lang.Integer.valueOf(mode), java.lang.Long.valueOf(channel)});
	}

	public String getRoot_path() {
		return (String) super.call("get_root_path", new java.lang.Object[0]);
	}

	public void setRoot_path(String value) {
		super.call("set_root_path", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Callable getAuth_callback() {
		return (Callable) super.call("get_auth_callback", new java.lang.Object[0]);
	}

	public void setAuth_callback(Callable value) {
		super.call("set_auth_callback", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getAuth_timeout() {
		return (double) super.call("get_auth_timeout", new java.lang.Object[0]);
	}

	public void setAuth_timeout(double value) {
		super.call("set_auth_timeout", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isAllow_object_decoding() {
		return (boolean) super.call("is_object_decoding_allowed", new java.lang.Object[0]);
	}

	public void setAllow_object_decoding(boolean value) {
		super.call("set_allow_object_decoding", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isRefuse_new_connections() {
		return (boolean) super.call("is_refusing_new_connections", new java.lang.Object[0]);
	}

	public void setRefuse_new_connections(boolean value) {
		super.call("set_refuse_new_connections", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isServer_relay() {
		return (boolean) super.call("is_server_relay_enabled", new java.lang.Object[0]);
	}

	public void setServer_relay(boolean value) {
		super.call("set_server_relay_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getMax_sync_packet_size() {
		return (long) super.call("get_max_sync_packet_size", new java.lang.Object[0]);
	}

	public void setMax_sync_packet_size(long value) {
		super.call("set_max_sync_packet_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMax_delta_packet_size() {
		return (long) super.call("get_max_delta_packet_size", new java.lang.Object[0]);
	}

	public void setMax_delta_packet_size(long value) {
		super.call("set_max_delta_packet_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
