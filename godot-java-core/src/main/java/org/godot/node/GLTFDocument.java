package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class GLTFDocument extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_fallback_image_format", 201670096L),
			java.util.Map.entry("get_supported_gltf_extensions", 2981934095L),
			java.util.Map.entry("get_image_format", 201670096L),
			java.util.Map.entry("import_object_model_property", 1206708632L),
			java.util.Map.entry("set_fallback_image_format", 83702148L),
			java.util.Map.entry("unregister_gltf_document_extension", 2684415758L),
			java.util.Map.entry("set_lossy_quality", 373806689L),
			java.util.Map.entry("export_object_model_property", 314209806L),
			java.util.Map.entry("get_visibility_mode", 3885445962L), java.util.Map.entry("set_image_format", 83702148L),
			java.util.Map.entry("set_root_node_mode", 463633402L),
			java.util.Map.entry("get_fallback_image_quality", 1740695150L),
			java.util.Map.entry("generate_buffer", 741783455L), java.util.Map.entry("get_lossy_quality", 1740695150L),
			java.util.Map.entry("register_gltf_document_extension", 3752678331L),
			java.util.Map.entry("get_root_node_mode", 948057992L),
			java.util.Map.entry("set_visibility_mode", 2803579218L),
			java.util.Map.entry("write_to_filesystem", 1784551478L),
			java.util.Map.entry("set_fallback_image_quality", 373806689L),
			java.util.Map.entry("append_from_buffer", 1616081266L), java.util.Map.entry("append_from_file", 866380864L),
			java.util.Map.entry("append_from_scene", 1622574258L), java.util.Map.entry("generate_scene", 596118388L));

	GLTFDocument(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFDocument(long nativePointer) {
		super(nativePointer);
	}

	public int append_from_file(String path, GLTFState state, long flags, String base_path) {
		return (int) super.call("append_from_file", new java.lang.Object[]{(java.lang.Object) path,
				(java.lang.Object) state, java.lang.Long.valueOf(flags), (java.lang.Object) base_path});
	}

	public int append_from_buffer(byte[] bytes, String base_path, GLTFState state, long flags) {
		return (int) super.call("append_from_buffer", new java.lang.Object[]{(java.lang.Object) bytes,
				(java.lang.Object) base_path, (java.lang.Object) state, java.lang.Long.valueOf(flags)});
	}

	public int append_from_scene(Node node, GLTFState state, long flags) {
		return (int) super.call("append_from_scene", new java.lang.Object[]{(java.lang.Object) node,
				(java.lang.Object) state, java.lang.Long.valueOf(flags)});
	}

	public Node generate_scene(GLTFState state, double bake_fps, boolean trimming, boolean remove_immutable_tracks) {
		return (Node) super.call("generate_scene",
				new java.lang.Object[]{(java.lang.Object) state, java.lang.Double.valueOf(bake_fps),
						java.lang.Boolean.valueOf(trimming), java.lang.Boolean.valueOf(remove_immutable_tracks)});
	}

	public byte[] generate_buffer(GLTFState state) {
		return (byte[]) super.call("generate_buffer", new java.lang.Object[]{(java.lang.Object) state});
	}

	public int write_to_filesystem(GLTFState state, String path) {
		return (int) super.call("write_to_filesystem",
				new java.lang.Object[]{(java.lang.Object) state, (java.lang.Object) path});
	}

	public GLTFObjectModelProperty import_object_model_property(GLTFState state, String json_pointer) {
		return (GLTFObjectModelProperty) super.call("import_object_model_property",
				new java.lang.Object[]{(java.lang.Object) state, (java.lang.Object) json_pointer});
	}

	public GLTFObjectModelProperty export_object_model_property(GLTFState state, String node_path, Node godot_node,
			long gltf_node_index) {
		return (GLTFObjectModelProperty) super.call("export_object_model_property",
				new java.lang.Object[]{(java.lang.Object) state, (java.lang.Object) node_path,
						(java.lang.Object) godot_node, java.lang.Long.valueOf(gltf_node_index)});
	}

	public void register_gltf_document_extension(GLTFDocumentExtension extension, boolean first_priority) {
		super.call("register_gltf_document_extension",
				new java.lang.Object[]{(java.lang.Object) extension, java.lang.Boolean.valueOf(first_priority)});
	}

	public void unregister_gltf_document_extension(GLTFDocumentExtension extension) {
		super.call("unregister_gltf_document_extension", new java.lang.Object[]{(java.lang.Object) extension});
	}

	public String getImage_format() {
		return (String) super.call("get_image_format", new java.lang.Object[0]);
	}

	public void setImage_format(String value) {
		super.call("set_image_format", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getLossy_quality() {
		return (double) super.call("get_lossy_quality", new java.lang.Object[0]);
	}

	public void setLossy_quality(double value) {
		super.call("set_lossy_quality", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public String getFallback_image_format() {
		return (String) super.call("get_fallback_image_format", new java.lang.Object[0]);
	}

	public void setFallback_image_format(String value) {
		super.call("set_fallback_image_format", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getFallback_image_quality() {
		return (double) super.call("get_fallback_image_quality", new java.lang.Object[0]);
	}

	public void setFallback_image_quality(double value) {
		super.call("set_fallback_image_quality", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getRoot_node_mode() {
		return (long) super.call("get_root_node_mode", new java.lang.Object[0]);
	}

	public void setRoot_node_mode(long value) {
		super.call("set_root_node_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getVisibility_mode() {
		return (long) super.call("get_visibility_mode", new java.lang.Object[0]);
	}

	public void setVisibility_mode(long value) {
		super.call("set_visibility_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
