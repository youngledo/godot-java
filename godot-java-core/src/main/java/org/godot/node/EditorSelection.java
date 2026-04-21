package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class EditorSelection extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_top_selected_nodes", 2915620761L),
			java.util.Map.entry("get_transformable_selected_nodes", 2915620761L),
			java.util.Map.entry("remove_node", 1078189570L), java.util.Map.entry("add_node", 1078189570L),
			java.util.Map.entry("clear", 3218959716L), java.util.Map.entry("get_selected_nodes", 2915620761L));

	EditorSelection(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorSelection(long nativePointer) {
		super(nativePointer);
	}

	public void clear() {
		super.call("clear");
	}

	public void add_node(Node node) {
		super.call("add_node", new java.lang.Object[]{(java.lang.Object) node});
	}

	public void remove_node(Node node) {
		super.call("remove_node", new java.lang.Object[]{(java.lang.Object) node});
	}
}
