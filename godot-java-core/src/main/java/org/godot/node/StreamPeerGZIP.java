package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class StreamPeerGZIP extends StreamPeer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("start_decompression", 781582770L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("start_compression", 781582770L), java.util.Map.entry("finish", 166280745L));

	StreamPeerGZIP(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StreamPeerGZIP(long nativePointer) {
		super(nativePointer);
	}

	public int start_compression(boolean use_deflate, long buffer_size) {
		return (int) super.call("start_compression",
				new java.lang.Object[]{java.lang.Boolean.valueOf(use_deflate), java.lang.Long.valueOf(buffer_size)});
	}

	public int start_decompression(boolean use_deflate, long buffer_size) {
		return (int) super.call("start_decompression",
				new java.lang.Object[]{java.lang.Boolean.valueOf(use_deflate), java.lang.Long.valueOf(buffer_size)});
	}

	public int finish() {
		return (int) super.call("finish");
	}

	public void clear() {
		super.call("clear");
	}
}
