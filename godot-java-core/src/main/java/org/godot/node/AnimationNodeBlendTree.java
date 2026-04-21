package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class AnimationNodeBlendTree extends AnimationRootNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_node_list", 3995934104L), java.util.Map.entry("remove_node", 3304788590L),
			java.util.Map.entry("add_node", 1980270704L), java.util.Map.entry("get_node_position", 3100822709L),
			java.util.Map.entry("get_node", 625644256L), java.util.Map.entry("has_node", 2619796661L),
			java.util.Map.entry("connect_node", 2168001410L), java.util.Map.entry("set_node_position", 1999414630L),
			java.util.Map.entry("rename_node", 3740211285L), java.util.Map.entry("disconnect_node", 2415702435L),
			java.util.Map.entry("get_graph_offset", 3341600327L), java.util.Map.entry("set_graph_offset", 743155724L));

	AnimationNodeBlendTree(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeBlendTree(long nativePointer) {
		super(nativePointer);
	}

	public void add_node(String name, AnimationNode node, Vector2 position) {
		super.call("add_node",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) node, (java.lang.Object) position});
	}

	public AnimationNode get_node(String name) {
		return (AnimationNode) super.call("get_node", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void remove_node(String name) {
		super.call("remove_node", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void rename_node(String name, String new_name) {
		super.call("rename_node", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) new_name});
	}

	public boolean has_node(String name) {
		return (boolean) super.call("has_node", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void connect_node(String input_node, long input_index, String output_node) {
		super.call("connect_node", new java.lang.Object[]{(java.lang.Object) input_node,
				java.lang.Long.valueOf(input_index), (java.lang.Object) output_node});
	}

	public void disconnect_node(String input_node, long input_index) {
		super.call("disconnect_node",
				new java.lang.Object[]{(java.lang.Object) input_node, java.lang.Long.valueOf(input_index)});
	}

	public void set_node_position(String name, Vector2 position) {
		super.call("set_node_position", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) position});
	}

	public Vector2 get_node_position(String name) {
		return (Vector2) super.call("get_node_position", new java.lang.Object[]{(java.lang.Object) name});
	}

	public Vector2 getGraph_offset() {
		return (Vector2) super.call("get_graph_offset", new java.lang.Object[0]);
	}

	public void setGraph_offset(Vector2 value) {
		super.call("set_graph_offset", new java.lang.Object[]{(java.lang.Object) value});
	}
}
