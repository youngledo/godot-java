package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;

public class Script extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_script_method_list", 2915620761L),
			java.util.Map.entry("get_source_code", 201670096L),
			java.util.Map.entry("get_property_default_value", 2138907829L),
			java.util.Map.entry("has_source_code", 36873697L), java.util.Map.entry("is_abstract", 36873697L),
			java.util.Map.entry("get_base_script", 278624046L),
			java.util.Map.entry("get_script_property_list", 2915620761L), java.util.Map.entry("is_tool", 36873697L),
			java.util.Map.entry("reload", 1633102583L), java.util.Map.entry("get_global_name", 2002593661L),
			java.util.Map.entry("get_rpc_config", 1214101251L),
			java.util.Map.entry("get_instance_base_type", 2002593661L),
			java.util.Map.entry("get_script_signal_list", 2915620761L), java.util.Map.entry("instance_has", 397768994L),
			java.util.Map.entry("set_source_code", 83702148L),
			java.util.Map.entry("get_script_constant_map", 2382534195L),
			java.util.Map.entry("has_script_signal", 2619796661L), java.util.Map.entry("can_instantiate", 36873697L));

	Script(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Script(long nativePointer) {
		super(nativePointer);
	}

	public boolean can_instantiate() {
		return (boolean) super.call("can_instantiate");
	}

	public boolean instance_has(GodotObject base_object) {
		return (boolean) super.call("instance_has", new java.lang.Object[]{(java.lang.Object) base_object});
	}

	public boolean has_source_code() {
		return (boolean) super.call("has_source_code");
	}

	public int reload(boolean keep_state) {
		return (int) super.call("reload", new java.lang.Object[]{java.lang.Boolean.valueOf(keep_state)});
	}

	public boolean has_script_signal(String signal_name) {
		return (boolean) super.call("has_script_signal", new java.lang.Object[]{(java.lang.Object) signal_name});
	}

	public Object get_property_default_value(String property) {
		return (Object) super.call("get_property_default_value", new java.lang.Object[]{(java.lang.Object) property});
	}

	public boolean is_tool() {
		return (boolean) super.call("is_tool");
	}

	public boolean is_abstract() {
		return (boolean) super.call("is_abstract");
	}

	public String getSource_code() {
		return (String) super.call("get_source_code", new java.lang.Object[0]);
	}

	public void setSource_code(String value) {
		super.call("set_source_code", new java.lang.Object[]{(java.lang.Object) value});
	}
}
