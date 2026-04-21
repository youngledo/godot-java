package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PacketPeerStream extends PacketPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_input_buffer_max_size", 3905245786L),
			java.util.Map.entry("get_output_buffer_max_size", 3905245786L),
			java.util.Map.entry("set_stream_peer", 3281897016L),
			java.util.Map.entry("set_input_buffer_max_size", 1286410249L),
			java.util.Map.entry("get_stream_peer", 2741655269L),
			java.util.Map.entry("set_output_buffer_max_size", 1286410249L));

	PacketPeerStream(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PacketPeerStream(long nativePointer) {
		super(nativePointer);
	}

	public long getInput_buffer_max_size() {
		return (long) super.call("get_input_buffer_max_size", new java.lang.Object[0]);
	}

	public void setInput_buffer_max_size(long value) {
		super.call("set_input_buffer_max_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getOutput_buffer_max_size() {
		return (long) super.call("get_output_buffer_max_size", new java.lang.Object[0]);
	}

	public void setOutput_buffer_max_size(long value) {
		super.call("set_output_buffer_max_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public StreamPeer getStream_peer() {
		return (StreamPeer) super.call("get_stream_peer", new java.lang.Object[0]);
	}

	public void setStream_peer(StreamPeer value) {
		super.call("set_stream_peer", new java.lang.Object[]{(java.lang.Object) value});
	}
}
