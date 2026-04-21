package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Joint3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_solver_priority", 1286410249L),
			java.util.Map.entry("get_solver_priority", 3905245786L), java.util.Map.entry("set_node_b", 1348162250L),
			java.util.Map.entry("set_node_a", 1348162250L), java.util.Map.entry("get_node_a", 4075236667L),
			java.util.Map.entry("get_node_b", 4075236667L),
			java.util.Map.entry("set_exclude_nodes_from_collision", 2586408642L),
			java.util.Map.entry("get_exclude_nodes_from_collision", 36873697L),
			java.util.Map.entry("get_rid", 2944877500L));

	Joint3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Joint3D(long nativePointer) {
		super(nativePointer);
	}

	public String getNode_a() {
		return (String) super.call("get_node_a", new java.lang.Object[0]);
	}

	public void setNode_a(String value) {
		super.call("set_node_a", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getNode_b() {
		return (String) super.call("get_node_b", new java.lang.Object[0]);
	}

	public void setNode_b(String value) {
		super.call("set_node_b", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSolver_priority() {
		return (long) super.call("get_solver_priority", new java.lang.Object[0]);
	}

	public void setSolver_priority(long value) {
		super.call("set_solver_priority", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getExclude_nodes_from_collision() {
		return (boolean) super.call("get_exclude_nodes_from_collision", new java.lang.Object[0]);
	}

	public void setExclude_nodes_from_collision(boolean value) {
		super.call("set_exclude_nodes_from_collision", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
