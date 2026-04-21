package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;

public class VisualShaderNode extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_input_port_default_value", 150923387L),
			java.util.Map.entry("get_default_input_port", 1894493699L),
			java.util.Map.entry("get_default_input_values", 3995934104L),
			java.util.Map.entry("remove_input_port_default_value", 1286410249L),
			java.util.Map.entry("clear_default_input_values", 3218959716L),
			java.util.Map.entry("get_frame", 3905245786L), java.util.Map.entry("set_frame", 1286410249L),
			java.util.Map.entry("get_output_port_for_preview", 3905245786L),
			java.util.Map.entry("get_input_port_default_value", 4227898402L),
			java.util.Map.entry("set_default_input_values", 381264803L),
			java.util.Map.entry("set_output_port_for_preview", 1286410249L));

	VisualShaderNode(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNode(long nativePointer) {
		super(nativePointer);
	}

	public int get_default_input_port(int type) {
		return (int) super.call("get_default_input_port", new java.lang.Object[]{java.lang.Integer.valueOf(type)});
	}

	public void set_input_port_default_value(long port, Object value, Object prev_value) {
		super.call("set_input_port_default_value", new java.lang.Object[]{java.lang.Long.valueOf(port),
				(java.lang.Object) value, (java.lang.Object) prev_value});
	}

	public Object get_input_port_default_value(long port) {
		return (Object) super.call("get_input_port_default_value",
				new java.lang.Object[]{java.lang.Long.valueOf(port)});
	}

	public void remove_input_port_default_value(long port) {
		super.call("remove_input_port_default_value", new java.lang.Object[]{java.lang.Long.valueOf(port)});
	}

	public void clear_default_input_values() {
		super.call("clear_default_input_values");
	}

	public long getOutput_port_for_preview() {
		return (long) super.call("get_output_port_for_preview", new java.lang.Object[0]);
	}

	public void setOutput_port_for_preview(long value) {
		super.call("set_output_port_for_preview", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public GodotArray getDefault_input_values() {
		return (GodotArray) super.call("get_default_input_values", new java.lang.Object[0]);
	}

	public void setDefault_input_values(GodotArray value) {
		super.call("set_default_input_values", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getExpanded_output_ports() {
		return (GodotArray) super.call("_get_output_ports_expanded", new java.lang.Object[0]);
	}

	public void setExpanded_output_ports(GodotArray value) {
		super.call("_set_output_ports_expanded", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getLinked_parent_graph_frame() {
		return (long) super.call("get_frame", new java.lang.Object[0]);
	}

	public void setLinked_parent_graph_frame(long value) {
		super.call("set_frame", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
