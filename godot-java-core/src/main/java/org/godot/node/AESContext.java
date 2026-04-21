package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class AESContext extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("start", 3122411423L), java.util.Map.entry("update", 527836100L),
			java.util.Map.entry("get_iv_state", 2115431945L), java.util.Map.entry("finish", 3218959716L));

	AESContext(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AESContext(long nativePointer) {
		super(nativePointer);
	}

	public int start(int mode, byte[] key, byte[] iv) {
		return (int) super.call("start",
				new java.lang.Object[]{java.lang.Integer.valueOf(mode), (java.lang.Object) key, (java.lang.Object) iv});
	}

	public byte[] update(byte[] src) {
		return (byte[]) super.call("update", new java.lang.Object[]{(java.lang.Object) src});
	}

	public void finish() {
		super.call("finish");
	}
}
