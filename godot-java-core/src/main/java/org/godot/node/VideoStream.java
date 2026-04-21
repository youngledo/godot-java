package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VideoStream extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_file", 83702148L), java.util.Map.entry("get_file", 2841200299L));

	VideoStream(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VideoStream(long nativePointer) {
		super(nativePointer);
	}

	public String getFile() {
		return (String) super.call("get_file", new java.lang.Object[0]);
	}

	public void setFile(String value) {
		super.call("set_file", new java.lang.Object[]{(java.lang.Object) value});
	}
}
