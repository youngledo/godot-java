package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationNodeExtension extends AnimationNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_looping", 2035584311L), java.util.Map.entry("get_remaining_time", 2851904656L));

	AnimationNodeExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeExtension(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_looping(double[] node_info) {
		return (boolean) super.call("is_looping", new java.lang.Object[]{(java.lang.Object) node_info});
	}

	public double get_remaining_time(double[] node_info, boolean break_loop) {
		return (double) super.call("get_remaining_time",
				new java.lang.Object[]{(java.lang.Object) node_info, java.lang.Boolean.valueOf(break_loop)});
	}
}
