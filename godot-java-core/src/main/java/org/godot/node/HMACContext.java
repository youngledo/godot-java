package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class HMACContext extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("start", 3537364598L), java.util.Map.entry("update", 680677267L),
			java.util.Map.entry("finish", 2115431945L));

	HMACContext(MemorySegment nativePointer) {
		super(nativePointer);
	}

	HMACContext(long nativePointer) {
		super(nativePointer);
	}

	public int start(int hash_type, byte[] key) {
		return (int) super.call("start",
				new java.lang.Object[]{java.lang.Integer.valueOf(hash_type), (java.lang.Object) key});
	}

	public int update(byte[] data) {
		return (int) super.call("update", new java.lang.Object[]{(java.lang.Object) data});
	}

	public byte[] finish() {
		return (byte[]) super.call("finish");
	}
}
