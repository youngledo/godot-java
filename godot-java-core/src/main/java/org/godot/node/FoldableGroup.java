package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class FoldableGroup extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_allow_folding_all", 36873697L),
			java.util.Map.entry("set_allow_folding_all", 2586408642L),
			java.util.Map.entry("get_expanded_container", 1427441056L),
			java.util.Map.entry("get_containers", 3995934104L));

	FoldableGroup(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FoldableGroup(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_allow_folding_all() {
		return (boolean) super.call("is_allow_folding_all");
	}

	public boolean isAllow_folding_all() {
		return (boolean) super.call("is_allow_folding_all", new java.lang.Object[0]);
	}

	public void setAllow_folding_all(boolean value) {
		super.call("set_allow_folding_all", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
