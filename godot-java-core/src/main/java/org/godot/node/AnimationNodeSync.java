package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationNodeSync extends AnimationNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_use_sync", 2586408642L), java.util.Map.entry("is_using_sync", 36873697L));

	AnimationNodeSync(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeSync(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_using_sync() {
		return (boolean) super.call("is_using_sync");
	}

	public boolean isSync() {
		return (boolean) super.call("is_using_sync", new java.lang.Object[0]);
	}

	public void setSync(boolean value) {
		super.call("set_use_sync", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
