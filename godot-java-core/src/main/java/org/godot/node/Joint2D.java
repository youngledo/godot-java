package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Joint2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_bias", 373806689L), java.util.Map.entry("set_node_b", 1348162250L),
			java.util.Map.entry("set_node_a", 1348162250L), java.util.Map.entry("get_node_a", 4075236667L),
			java.util.Map.entry("get_node_b", 4075236667L),
			java.util.Map.entry("set_exclude_nodes_from_collision", 2586408642L),
			java.util.Map.entry("get_bias", 1740695150L),
			java.util.Map.entry("get_exclude_nodes_from_collision", 36873697L),
			java.util.Map.entry("get_rid", 2944877500L));

	Joint2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Joint2D(long nativePointer) {
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

	public double getBias() {
		return (double) super.call("get_bias", new java.lang.Object[0]);
	}

	public void setBias(double value) {
		super.call("set_bias", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getDisable_collision() {
		return (boolean) super.call("get_exclude_nodes_from_collision", new java.lang.Object[0]);
	}

	public void setDisable_collision(boolean value) {
		super.call("set_exclude_nodes_from_collision", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
