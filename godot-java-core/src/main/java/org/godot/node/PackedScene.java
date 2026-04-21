package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PackedScene extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_state", 3479783971L), java.util.Map.entry("pack", 2584678054L),
			java.util.Map.entry("instantiate", 2628778455L), java.util.Map.entry("can_instantiate", 36873697L));

	PackedScene(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PackedScene(long nativePointer) {
		super(nativePointer);
	}

	public int pack(Node path) {
		return (int) super.call("pack", new java.lang.Object[]{(java.lang.Object) path});
	}

	public Node instantiate(int edit_state) {
		return (Node) super.call("instantiate", new java.lang.Object[]{java.lang.Integer.valueOf(edit_state)});
	}

	public boolean can_instantiate() {
		return (boolean) super.call("can_instantiate");
	}
}
