package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationNodeTimeSeek extends AnimationNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_explicit_elapse", 2586408642L),
			java.util.Map.entry("is_explicit_elapse", 36873697L));

	AnimationNodeTimeSeek(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeTimeSeek(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_explicit_elapse() {
		return (boolean) super.call("is_explicit_elapse");
	}

	public boolean isExplicit_elapse() {
		return (boolean) super.call("is_explicit_elapse", new java.lang.Object[0]);
	}

	public void setExplicit_elapse(boolean value) {
		super.call("set_explicit_elapse", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
