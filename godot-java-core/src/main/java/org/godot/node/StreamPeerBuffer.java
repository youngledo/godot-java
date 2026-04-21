package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class StreamPeerBuffer extends StreamPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_position", 3905245786L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("resize", 1286410249L), java.util.Map.entry("get_size", 3905245786L),
			java.util.Map.entry("get_data_array", 2362200018L), java.util.Map.entry("duplicate", 2474064677L),
			java.util.Map.entry("seek", 1286410249L), java.util.Map.entry("set_data_array", 2971499966L));

	StreamPeerBuffer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StreamPeerBuffer(long nativePointer) {
		super(nativePointer);
	}

	public void seek(long position) {
		super.call("seek", new java.lang.Object[]{java.lang.Long.valueOf(position)});
	}

	public void resize(long size) {
		super.call("resize", new java.lang.Object[]{java.lang.Long.valueOf(size)});
	}

	public void clear() {
		super.call("clear");
	}

	public StreamPeerBuffer duplicate() {
		return (StreamPeerBuffer) super.call("duplicate");
	}

	public byte[] getData_array() {
		return (byte[]) super.call("get_data_array", new java.lang.Object[0]);
	}

	public void setData_array(byte[] value) {
		super.call("set_data_array", new java.lang.Object[]{(java.lang.Object) value});
	}
}
