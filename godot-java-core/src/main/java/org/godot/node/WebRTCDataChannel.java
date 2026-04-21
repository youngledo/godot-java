package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class WebRTCDataChannel extends PacketPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("was_string_packet", 36873697L), java.util.Map.entry("is_ordered", 36873697L),
			java.util.Map.entry("set_write_mode", 1999768052L), java.util.Map.entry("get_label", 201670096L),
			java.util.Map.entry("get_protocol", 201670096L), java.util.Map.entry("poll", 166280745L),
			java.util.Map.entry("get_id", 3905245786L), java.util.Map.entry("get_ready_state", 3501143017L),
			java.util.Map.entry("get_write_mode", 2848495172L), java.util.Map.entry("get_buffered_amount", 3905245786L),
			java.util.Map.entry("is_negotiated", 36873697L),
			java.util.Map.entry("get_max_packet_life_time", 3905245786L),
			java.util.Map.entry("get_max_retransmits", 3905245786L), java.util.Map.entry("close", 3218959716L));

	WebRTCDataChannel(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WebRTCDataChannel(long nativePointer) {
		super(nativePointer);
	}

	public int poll() {
		return (int) super.call("poll");
	}

	public void close() {
		super.call("close");
	}

	public boolean was_string_packet() {
		return (boolean) super.call("was_string_packet");
	}

	public boolean is_ordered() {
		return (boolean) super.call("is_ordered");
	}

	public boolean is_negotiated() {
		return (boolean) super.call("is_negotiated");
	}

	public long getWrite_mode() {
		return (long) super.call("get_write_mode", new java.lang.Object[0]);
	}

	public void setWrite_mode(long value) {
		super.call("set_write_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
