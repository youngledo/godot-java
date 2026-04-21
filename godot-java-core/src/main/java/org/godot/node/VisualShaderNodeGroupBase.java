package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeGroupBase extends VisualShaderNodeResizableBase {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_inputs", 83702148L), java.util.Map.entry("clear_output_ports", 3218959716L),
			java.util.Map.entry("get_inputs", 201670096L), java.util.Map.entry("get_outputs", 201670096L),
			java.util.Map.entry("get_input_port_count", 3905245786L),
			java.util.Map.entry("remove_output_port", 1286410249L), java.util.Map.entry("has_input_port", 1116898809L),
			java.util.Map.entry("set_input_port_name", 501894301L), java.util.Map.entry("set_outputs", 83702148L),
			java.util.Map.entry("get_output_port_count", 3905245786L),
			java.util.Map.entry("get_free_output_port_id", 3905245786L),
			java.util.Map.entry("set_output_port_type", 3937882851L),
			java.util.Map.entry("get_free_input_port_id", 3905245786L),
			java.util.Map.entry("add_input_port", 2285447957L), java.util.Map.entry("has_output_port", 1116898809L),
			java.util.Map.entry("clear_input_ports", 3218959716L),
			java.util.Map.entry("is_valid_port_name", 3927539163L),
			java.util.Map.entry("remove_input_port", 1286410249L),
			java.util.Map.entry("set_input_port_type", 3937882851L),
			java.util.Map.entry("add_output_port", 2285447957L),
			java.util.Map.entry("set_output_port_name", 501894301L));

	VisualShaderNodeGroupBase(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeGroupBase(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_valid_port_name(String name) {
		return (boolean) super.call("is_valid_port_name", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void add_input_port(long id, long type, String name) {
		super.call("add_input_port", new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(type),
				(java.lang.Object) name});
	}

	public void remove_input_port(long id) {
		super.call("remove_input_port", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public boolean has_input_port(long id) {
		return (boolean) super.call("has_input_port", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void clear_input_ports() {
		super.call("clear_input_ports");
	}

	public void add_output_port(long id, long type, String name) {
		super.call("add_output_port", new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(type),
				(java.lang.Object) name});
	}

	public void remove_output_port(long id) {
		super.call("remove_output_port", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public boolean has_output_port(long id) {
		return (boolean) super.call("has_output_port", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void clear_output_ports() {
		super.call("clear_output_ports");
	}

	public void set_input_port_name(long id, String name) {
		super.call("set_input_port_name", new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) name});
	}

	public void set_input_port_type(long id, long type) {
		super.call("set_input_port_type",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(type)});
	}

	public void set_output_port_name(long id, String name) {
		super.call("set_output_port_name", new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) name});
	}

	public void set_output_port_type(long id, long type) {
		super.call("set_output_port_type",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(type)});
	}
}
