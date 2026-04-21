package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class PacketPeer extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_encode_buffer_max_size", 1286410249L),
			java.util.Map.entry("get_packet_error", 3185525595L), java.util.Map.entry("get_var", 3442865206L),
			java.util.Map.entry("get_encode_buffer_max_size", 3905245786L), java.util.Map.entry("put_var", 2436251611L),
			java.util.Map.entry("get_packet", 2115431945L), java.util.Map.entry("put_packet", 680677267L),
			java.util.Map.entry("get_available_packet_count", 3905245786L));

	PacketPeer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PacketPeer(long nativePointer) {
		super(nativePointer);
	}

	public Object get_var(boolean allow_objects) {
		return (Object) super.call("get_var", new java.lang.Object[]{java.lang.Boolean.valueOf(allow_objects)});
	}

	public int put_var(Object var, boolean full_objects) {
		return (int) super.call("put_var",
				new java.lang.Object[]{(java.lang.Object) var, java.lang.Boolean.valueOf(full_objects)});
	}

	public int put_packet(byte[] buffer) {
		return (int) super.call("put_packet", new java.lang.Object[]{(java.lang.Object) buffer});
	}

	public long getEncode_buffer_max_size() {
		return (long) super.call("get_encode_buffer_max_size", new java.lang.Object[0]);
	}

	public void setEncode_buffer_max_size(long value) {
		super.call("set_encode_buffer_max_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
