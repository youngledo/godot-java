package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.core.RefCounted;

public class WebRTCPeerConnection extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("create_offer", 166280745L), java.util.Map.entry("set_default_extension", 3304788590L),
			java.util.Map.entry("set_local_description", 852856452L),
			java.util.Map.entry("set_remote_description", 852856452L),
			java.util.Map.entry("add_ice_candidate", 3958950400L),
			java.util.Map.entry("get_signaling_state", 3342956226L), java.util.Map.entry("initialize", 2625064318L),
			java.util.Map.entry("poll", 166280745L), java.util.Map.entry("get_gathering_state", 4262591401L),
			java.util.Map.entry("create_data_channel", 1288557393L), java.util.Map.entry("close", 3218959716L),
			java.util.Map.entry("get_connection_state", 2275710506L));

	WebRTCPeerConnection(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WebRTCPeerConnection(long nativePointer) {
		super(nativePointer);
	}

	public int initialize(GodotDictionary configuration) {
		return (int) super.call("initialize", new java.lang.Object[]{(java.lang.Object) configuration});
	}

	public WebRTCDataChannel create_data_channel(String label, GodotDictionary options) {
		return (WebRTCDataChannel) super.call("create_data_channel",
				new java.lang.Object[]{(java.lang.Object) label, (java.lang.Object) options});
	}

	public int create_offer() {
		return (int) super.call("create_offer");
	}

	public int set_local_description(String type, String sdp) {
		return (int) super.call("set_local_description",
				new java.lang.Object[]{(java.lang.Object) type, (java.lang.Object) sdp});
	}

	public int set_remote_description(String type, String sdp) {
		return (int) super.call("set_remote_description",
				new java.lang.Object[]{(java.lang.Object) type, (java.lang.Object) sdp});
	}

	public int add_ice_candidate(String media, long index, String name) {
		return (int) super.call("add_ice_candidate", new java.lang.Object[]{(java.lang.Object) media,
				java.lang.Long.valueOf(index), (java.lang.Object) name});
	}

	public int poll() {
		return (int) super.call("poll");
	}

	public void close() {
		super.call("close");
	}
}
