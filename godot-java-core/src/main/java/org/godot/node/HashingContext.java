package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class HashingContext extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("start", 3940338335L), java.util.Map.entry("update", 680677267L),
			java.util.Map.entry("finish", 2115431945L));

	HashingContext(MemorySegment nativePointer) {
		super(nativePointer);
	}

	HashingContext(long nativePointer) {
		super(nativePointer);
	}

	public int start(int type) {
		return (int) super.call("start", new java.lang.Object[]{java.lang.Integer.valueOf(type)});
	}

	public int update(byte[] chunk) {
		return (int) super.call("update", new java.lang.Object[]{(java.lang.Object) chunk});
	}

	public byte[] finish() {
		return (byte[]) super.call("finish");
	}
}
