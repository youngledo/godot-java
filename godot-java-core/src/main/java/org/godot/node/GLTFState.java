package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;

public class GLTFState extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_unique_names", 381264803L), java.util.Map.entry("set_buffer_views", 381264803L),
			java.util.Map.entry("set_major_version", 1286410249L), java.util.Map.entry("set_textures", 381264803L),
			java.util.Map.entry("set_animations", 381264803L), java.util.Map.entry("append_gltf_node", 3562288551L),
			java.util.Map.entry("set_buffers", 381264803L),
			java.util.Map.entry("set_handle_binary_image_mode", 854676334L),
			java.util.Map.entry("get_scene_node", 539202265L), java.util.Map.entry("set_cameras", 381264803L),
			java.util.Map.entry("get_nodes", 3995934104L),
			java.util.Map.entry("set_unique_animation_names", 381264803L),
			java.util.Map.entry("get_import_as_skeleton_bones", 36873697L),
			java.util.Map.entry("get_textures", 3995934104L), java.util.Map.entry("set_lights", 381264803L),
			java.util.Map.entry("get_animation_players_count", 923996154L),
			java.util.Map.entry("set_images", 381264803L), java.util.Map.entry("set_accessors", 381264803L),
			java.util.Map.entry("get_scene_name", 201670096L), java.util.Map.entry("set_filename", 83702148L),
			java.util.Map.entry("get_meshes", 3995934104L), java.util.Map.entry("set_copyright", 83702148L),
			java.util.Map.entry("get_use_named_skin_binds", 36873697L),
			java.util.Map.entry("get_animation_player", 1550200483L),
			java.util.Map.entry("get_node_index", 3810805390L), java.util.Map.entry("set_bake_fps", 373806689L),
			java.util.Map.entry("get_skins", 3995934104L), java.util.Map.entry("set_base_path", 83702148L),
			java.util.Map.entry("set_skeletons", 381264803L),
			java.util.Map.entry("set_import_as_skeleton_bones", 2586408642L),
			java.util.Map.entry("get_base_path", 201670096L), java.util.Map.entry("get_filename", 201670096L),
			java.util.Map.entry("get_minor_version", 3905245786L),
			java.util.Map.entry("set_create_animations", 2586408642L),
			java.util.Map.entry("set_additional_data", 3776071444L), java.util.Map.entry("get_materials", 3995934104L),
			java.util.Map.entry("get_cameras", 3995934104L),
			java.util.Map.entry("set_use_named_skin_binds", 2586408642L),
			java.util.Map.entry("append_data_to_buffers", 1460416665L), java.util.Map.entry("set_nodes", 381264803L),
			java.util.Map.entry("set_glb_data", 2971499966L),
			java.util.Map.entry("get_handle_binary_image", 3905245786L), java.util.Map.entry("get_images", 3995934104L),
			java.util.Map.entry("set_materials", 381264803L), java.util.Map.entry("get_root_nodes", 1930428628L),
			java.util.Map.entry("set_meshes", 381264803L), java.util.Map.entry("get_unique_names", 3995934104L),
			java.util.Map.entry("set_minor_version", 1286410249L),
			java.util.Map.entry("get_major_version", 3905245786L), java.util.Map.entry("get_glb_data", 2362200018L),
			java.util.Map.entry("get_copyright", 201670096L), java.util.Map.entry("set_scene_name", 83702148L),
			java.util.Map.entry("get_buffers", 3995934104L), java.util.Map.entry("get_skeletons", 3995934104L),
			java.util.Map.entry("get_lights", 3995934104L), java.util.Map.entry("get_create_animations", 36873697L),
			java.util.Map.entry("get_handle_binary_image_mode", 1363384196L),
			java.util.Map.entry("get_bake_fps", 1740695150L), java.util.Map.entry("get_buffer_views", 3995934104L),
			java.util.Map.entry("add_used_extension", 2678287736L), java.util.Map.entry("set_skins", 381264803L),
			java.util.Map.entry("set_root_nodes", 3614634198L),
			java.util.Map.entry("get_texture_samplers", 3995934104L),
			java.util.Map.entry("set_texture_samplers", 381264803L), java.util.Map.entry("get_animations", 3995934104L),
			java.util.Map.entry("get_json", 3102165223L), java.util.Map.entry("get_accessors", 3995934104L),
			java.util.Map.entry("get_unique_animation_names", 3995934104L),
			java.util.Map.entry("set_json", 4155329257L), java.util.Map.entry("set_handle_binary_image", 1286410249L),
			java.util.Map.entry("get_additional_data", 2760726917L));

	GLTFState(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFState(long nativePointer) {
		super(nativePointer);
	}

	public void add_used_extension(String extension_name, boolean required) {
		super.call("add_used_extension",
				new java.lang.Object[]{(java.lang.Object) extension_name, java.lang.Boolean.valueOf(required)});
	}

	public int append_data_to_buffers(byte[] data, boolean deduplication) {
		return (int) super.call("append_data_to_buffers",
				new java.lang.Object[]{(java.lang.Object) data, java.lang.Boolean.valueOf(deduplication)});
	}

	public int append_gltf_node(GLTFNode gltf_node, Node godot_scene_node, long parent_node_index) {
		return (int) super.call("append_gltf_node", new java.lang.Object[]{(java.lang.Object) gltf_node,
				(java.lang.Object) godot_scene_node, java.lang.Long.valueOf(parent_node_index)});
	}

	public int get_animation_players_count(long anim_player_index) {
		return (int) super.call("get_animation_players_count",
				new java.lang.Object[]{java.lang.Long.valueOf(anim_player_index)});
	}

	public AnimationPlayer get_animation_player(long anim_player_index) {
		return (AnimationPlayer) super.call("get_animation_player",
				new java.lang.Object[]{java.lang.Long.valueOf(anim_player_index)});
	}

	public Node get_scene_node(long gltf_node_index) {
		return (Node) super.call("get_scene_node", new java.lang.Object[]{java.lang.Long.valueOf(gltf_node_index)});
	}

	public int get_node_index(Node scene_node) {
		return (int) super.call("get_node_index", new java.lang.Object[]{(java.lang.Object) scene_node});
	}

	public Object get_additional_data(String extension_name) {
		return (Object) super.call("get_additional_data", new java.lang.Object[]{(java.lang.Object) extension_name});
	}

	public void set_additional_data(String extension_name, Object additional_data) {
		super.call("set_additional_data",
				new java.lang.Object[]{(java.lang.Object) extension_name, (java.lang.Object) additional_data});
	}

	public GodotDictionary getJson() {
		return (GodotDictionary) super.call("get_json", new java.lang.Object[0]);
	}

	public void setJson(GodotDictionary value) {
		super.call("set_json", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getMajor_version() {
		return (long) super.call("get_major_version", new java.lang.Object[0]);
	}

	public void setMajor_version(long value) {
		super.call("set_major_version", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMinor_version() {
		return (long) super.call("get_minor_version", new java.lang.Object[0]);
	}

	public void setMinor_version(long value) {
		super.call("set_minor_version", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getCopyright() {
		return (String) super.call("get_copyright", new java.lang.Object[0]);
	}

	public void setCopyright(String value) {
		super.call("set_copyright", new java.lang.Object[]{(java.lang.Object) value});
	}

	public byte[] getGlb_data() {
		return (byte[]) super.call("get_glb_data", new java.lang.Object[0]);
	}

	public void setGlb_data(byte[] value) {
		super.call("set_glb_data", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getUse_named_skin_binds() {
		return (boolean) super.call("get_use_named_skin_binds", new java.lang.Object[0]);
	}

	public void setUse_named_skin_binds(boolean value) {
		super.call("set_use_named_skin_binds", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public GodotArray getNodes() {
		return (GodotArray) super.call("get_nodes", new java.lang.Object[0]);
	}

	public void setNodes(GodotArray value) {
		super.call("set_nodes", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getBuffers() {
		return (GodotArray) super.call("get_buffers", new java.lang.Object[0]);
	}

	public void setBuffers(GodotArray value) {
		super.call("set_buffers", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getBuffer_views() {
		return (GodotArray) super.call("get_buffer_views", new java.lang.Object[0]);
	}

	public void setBuffer_views(GodotArray value) {
		super.call("set_buffer_views", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getAccessors() {
		return (GodotArray) super.call("get_accessors", new java.lang.Object[0]);
	}

	public void setAccessors(GodotArray value) {
		super.call("set_accessors", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getMeshes() {
		return (GodotArray) super.call("get_meshes", new java.lang.Object[0]);
	}

	public void setMeshes(GodotArray value) {
		super.call("set_meshes", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getMaterials() {
		return (GodotArray) super.call("get_materials", new java.lang.Object[0]);
	}

	public void setMaterials(GodotArray value) {
		super.call("set_materials", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getScene_name() {
		return (String) super.call("get_scene_name", new java.lang.Object[0]);
	}

	public void setScene_name(String value) {
		super.call("set_scene_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getBase_path() {
		return (String) super.call("get_base_path", new java.lang.Object[0]);
	}

	public void setBase_path(String value) {
		super.call("set_base_path", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getFilename() {
		return (String) super.call("get_filename", new java.lang.Object[0]);
	}

	public void setFilename(String value) {
		super.call("set_filename", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int[] getRoot_nodes() {
		return (int[]) super.call("get_root_nodes", new java.lang.Object[0]);
	}

	public void setRoot_nodes(int[] value) {
		super.call("set_root_nodes", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getTextures() {
		return (GodotArray) super.call("get_textures", new java.lang.Object[0]);
	}

	public void setTextures(GodotArray value) {
		super.call("set_textures", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getTexture_samplers() {
		return (GodotArray) super.call("get_texture_samplers", new java.lang.Object[0]);
	}

	public void setTexture_samplers(GodotArray value) {
		super.call("set_texture_samplers", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getImages() {
		return (GodotArray) super.call("get_images", new java.lang.Object[0]);
	}

	public void setImages(GodotArray value) {
		super.call("set_images", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getSkins() {
		return (GodotArray) super.call("get_skins", new java.lang.Object[0]);
	}

	public void setSkins(GodotArray value) {
		super.call("set_skins", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getCameras() {
		return (GodotArray) super.call("get_cameras", new java.lang.Object[0]);
	}

	public void setCameras(GodotArray value) {
		super.call("set_cameras", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getLights() {
		return (GodotArray) super.call("get_lights", new java.lang.Object[0]);
	}

	public void setLights(GodotArray value) {
		super.call("set_lights", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getUnique_names() {
		return (GodotArray) super.call("get_unique_names", new java.lang.Object[0]);
	}

	public void setUnique_names(GodotArray value) {
		super.call("set_unique_names", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getUnique_animation_names() {
		return (GodotArray) super.call("get_unique_animation_names", new java.lang.Object[0]);
	}

	public void setUnique_animation_names(GodotArray value) {
		super.call("set_unique_animation_names", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getSkeletons() {
		return (GodotArray) super.call("get_skeletons", new java.lang.Object[0]);
	}

	public void setSkeletons(GodotArray value) {
		super.call("set_skeletons", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getCreate_animations() {
		return (boolean) super.call("get_create_animations", new java.lang.Object[0]);
	}

	public void setCreate_animations(boolean value) {
		super.call("set_create_animations", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getImport_as_skeleton_bones() {
		return (boolean) super.call("get_import_as_skeleton_bones", new java.lang.Object[0]);
	}

	public void setImport_as_skeleton_bones(boolean value) {
		super.call("set_import_as_skeleton_bones", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public GodotArray getAnimations() {
		return (GodotArray) super.call("get_animations", new java.lang.Object[0]);
	}

	public void setAnimations(GodotArray value) {
		super.call("set_animations", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getHandle_binary_image_mode() {
		return (long) super.call("get_handle_binary_image_mode", new java.lang.Object[0]);
	}

	public void setHandle_binary_image_mode(long value) {
		super.call("set_handle_binary_image_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getBake_fps() {
		return (double) super.call("get_bake_fps", new java.lang.Object[0]);
	}

	public void setBake_fps(double value) {
		super.call("set_bake_fps", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getHandle_binary_image() {
		return (long) super.call("get_handle_binary_image", new java.lang.Object[0]);
	}

	public void setHandle_binary_image(long value) {
		super.call("set_handle_binary_image", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
