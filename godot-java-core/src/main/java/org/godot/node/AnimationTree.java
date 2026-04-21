package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationTree extends AnimationMixer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_animation_player", 1348162250L),
			java.util.Map.entry("get_advance_expression_base_node", 4075236667L),
			java.util.Map.entry("get_animation_player", 4075236667L),
			java.util.Map.entry("get_process_callback", 891317132L),
			java.util.Map.entry("set_advance_expression_base_node", 1348162250L),
			java.util.Map.entry("set_tree_root", 2581683800L), java.util.Map.entry("get_tree_root", 4110384712L),
			java.util.Map.entry("set_process_callback", 1723352826L));

	AnimationTree(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationTree(long nativePointer) {
		super(nativePointer);
	}

	public AnimationRootNode getTree_root() {
		return (AnimationRootNode) super.call("get_tree_root", new java.lang.Object[0]);
	}

	public void setTree_root(AnimationRootNode value) {
		super.call("set_tree_root", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getAdvance_expression_base_node() {
		return (String) super.call("get_advance_expression_base_node", new java.lang.Object[0]);
	}

	public void setAdvance_expression_base_node(String value) {
		super.call("set_advance_expression_base_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getAnim_player() {
		return (String) super.call("get_animation_player", new java.lang.Object[0]);
	}

	public void setAnim_player(String value) {
		super.call("set_animation_player", new java.lang.Object[]{(java.lang.Object) value});
	}
}
