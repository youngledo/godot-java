package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class AnimationNodeStateMachine extends AnimationRootNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_transition_to", 659327637L), java.util.Map.entry("get_node", 625644256L),
			java.util.Map.entry("add_transition", 795486887L), java.util.Map.entry("set_node_position", 1999414630L),
			java.util.Map.entry("get_transition_count", 3905245786L),
			java.util.Map.entry("set_graph_offset", 743155724L), java.util.Map.entry("get_node_name", 739213945L),
			java.util.Map.entry("replace_node", 2559412862L), java.util.Map.entry("get_transition", 4192381260L),
			java.util.Map.entry("set_reset_ends", 2586408642L), java.util.Map.entry("get_node_list", 3995934104L),
			java.util.Map.entry("remove_node", 3304788590L), java.util.Map.entry("get_node_position", 3100822709L),
			java.util.Map.entry("has_node", 2619796661L),
			java.util.Map.entry("remove_transition_by_index", 1286410249L),
			java.util.Map.entry("get_transition_from", 659327637L),
			java.util.Map.entry("is_allow_transition_to_self", 36873697L),
			java.util.Map.entry("set_allow_transition_to_self", 2586408642L),
			java.util.Map.entry("remove_transition", 3740211285L),
			java.util.Map.entry("get_state_machine_type", 1140726469L), java.util.Map.entry("add_node", 1980270704L),
			java.util.Map.entry("rename_node", 3740211285L), java.util.Map.entry("get_graph_offset", 3341600327L),
			java.util.Map.entry("has_transition", 471820014L),
			java.util.Map.entry("set_state_machine_type", 2584759088L),
			java.util.Map.entry("are_ends_reset", 36873697L));

	AnimationNodeStateMachine(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeStateMachine(long nativePointer) {
		super(nativePointer);
	}

	public void add_node(String name, AnimationNode node, Vector2 position) {
		super.call("add_node",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) node, (java.lang.Object) position});
	}

	public void replace_node(String name, AnimationNode node) {
		super.call("replace_node", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) node});
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

	public String get_node_name(AnimationNode node) {
		return (String) super.call("get_node_name", new java.lang.Object[]{(java.lang.Object) node});
	}

	public void set_node_position(String name, Vector2 position) {
		super.call("set_node_position", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) position});
	}

	public Vector2 get_node_position(String name) {
		return (Vector2) super.call("get_node_position", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean has_transition(String from, String to) {
		return (boolean) super.call("has_transition",
				new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to});
	}

	public void add_transition(String from, String to, AnimationNodeStateMachineTransition transition) {
		super.call("add_transition",
				new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to, (java.lang.Object) transition});
	}

	public AnimationNodeStateMachineTransition get_transition(long idx) {
		return (AnimationNodeStateMachineTransition) super.call("get_transition",
				new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_transition_from(long idx) {
		return (String) super.call("get_transition_from", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_transition_to(long idx) {
		return (String) super.call("get_transition_to", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void remove_transition_by_index(long idx) {
		super.call("remove_transition_by_index", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void remove_transition(String from, String to) {
		super.call("remove_transition", new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to});
	}

	public boolean is_allow_transition_to_self() {
		return (boolean) super.call("is_allow_transition_to_self");
	}

	public boolean are_ends_reset() {
		return (boolean) super.call("are_ends_reset");
	}

	public long getState_machine_type() {
		return (long) super.call("get_state_machine_type", new java.lang.Object[0]);
	}

	public void setState_machine_type(long value) {
		super.call("set_state_machine_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isAllow_transition_to_self() {
		return (boolean) super.call("is_allow_transition_to_self", new java.lang.Object[0]);
	}

	public void setAllow_transition_to_self(boolean value) {
		super.call("set_allow_transition_to_self", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getReset_ends() {
		return (boolean) super.call("are_ends_reset", new java.lang.Object[0]);
	}

	public void setReset_ends(boolean value) {
		super.call("set_reset_ends", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
