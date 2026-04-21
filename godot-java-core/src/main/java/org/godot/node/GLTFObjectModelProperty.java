package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.core.RefCounted;

public class GLTFObjectModelProperty extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_types", 4150728237L),
			java.util.Map.entry("get_gltf_to_godot_expression", 2240072449L),
			java.util.Map.entry("set_gltf_to_godot_expression", 1815845073L),
			java.util.Map.entry("set_node_paths", 381264803L), java.util.Map.entry("get_variant_type", 3416842102L),
			java.util.Map.entry("append_path_to_property", 1331931644L),
			java.util.Map.entry("has_json_pointers", 36873697L),
			java.util.Map.entry("set_godot_to_gltf_expression", 1815845073L),
			java.util.Map.entry("get_object_model_type", 1094778507L),
			java.util.Map.entry("set_object_model_type", 4108684086L), java.util.Map.entry("has_node_paths", 36873697L),
			java.util.Map.entry("append_node_path", 1348162250L), java.util.Map.entry("get_json_pointers", 3995934104L),
			java.util.Map.entry("set_variant_type", 2887708385L), java.util.Map.entry("set_json_pointers", 381264803L),
			java.util.Map.entry("get_godot_to_gltf_expression", 2240072449L),
			java.util.Map.entry("get_accessor_type", 1998183368L), java.util.Map.entry("get_node_paths", 3995934104L));

	GLTFObjectModelProperty(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFObjectModelProperty(long nativePointer) {
		super(nativePointer);
	}

	public void append_node_path(String node_path) {
		super.call("append_node_path", new java.lang.Object[]{(java.lang.Object) node_path});
	}

	public void append_path_to_property(String node_path, String prop_name) {
		super.call("append_path_to_property",
				new java.lang.Object[]{(java.lang.Object) node_path, (java.lang.Object) prop_name});
	}

	public boolean has_node_paths() {
		return (boolean) super.call("has_node_paths");
	}

	public boolean has_json_pointers() {
		return (boolean) super.call("has_json_pointers");
	}

	public void set_types(int variant_type, int obj_model_type) {
		super.call("set_types", new java.lang.Object[]{java.lang.Integer.valueOf(variant_type),
				java.lang.Integer.valueOf(obj_model_type)});
	}

	public Expression getGltf_to_godot_expression() {
		return (Expression) super.call("get_gltf_to_godot_expression", new java.lang.Object[0]);
	}

	public void setGltf_to_godot_expression(Expression value) {
		super.call("set_gltf_to_godot_expression", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Expression getGodot_to_gltf_expression() {
		return (Expression) super.call("get_godot_to_gltf_expression", new java.lang.Object[0]);
	}

	public void setGodot_to_gltf_expression(Expression value) {
		super.call("set_godot_to_gltf_expression", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getNode_paths() {
		return (GodotArray) super.call("get_node_paths", new java.lang.Object[0]);
	}

	public void setNode_paths(GodotArray value) {
		super.call("set_node_paths", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getObject_model_type() {
		return (long) super.call("get_object_model_type", new java.lang.Object[0]);
	}

	public void setObject_model_type(long value) {
		super.call("set_object_model_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String[] getJson_pointers() {
		return (String[]) super.call("get_json_pointers", new java.lang.Object[0]);
	}

	public void setJson_pointers(String[] value) {
		super.call("set_json_pointers", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getVariant_type() {
		return (long) super.call("get_variant_type", new java.lang.Object[0]);
	}

	public void setVariant_type(long value) {
		super.call("set_variant_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
