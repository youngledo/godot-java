package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.math.Color;
import org.godot.math.Vector2i;

public class TileSet extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_physics_layer_collision_mask", 3937882851L),
			java.util.Map.entry("add_physics_layer", 1025054187L),
			java.util.Map.entry("get_physics_layer_collision_priority", 2339986948L),
			java.util.Map.entry("set_physics_layer_collision_priority", 1602489585L),
			java.util.Map.entry("add_pattern", 763712015L), java.util.Map.entry("has_source", 1116898809L),
			java.util.Map.entry("remove_terrain_set", 1286410249L),
			java.util.Map.entry("set_navigation_layer_layer_value", 1383440665L),
			java.util.Map.entry("move_custom_data_layer", 3937882851L),
			java.util.Map.entry("get_navigation_layers_count", 3905245786L),
			java.util.Map.entry("set_coords_level_tile_proxy", 1769939278L),
			java.util.Map.entry("get_navigation_layer_layers", 923996154L),
			java.util.Map.entry("set_terrain_name", 2285447957L),
			java.util.Map.entry("get_custom_data_layer_type", 2990820875L),
			java.util.Map.entry("set_alternative_level_tile_proxy", 3862385460L),
			java.util.Map.entry("get_occlusion_layers_count", 3905245786L),
			java.util.Map.entry("remove_navigation_layer", 1286410249L),
			java.util.Map.entry("get_physics_layers_count", 3905245786L),
			java.util.Map.entry("move_terrain", 1649997291L),
			java.util.Map.entry("remove_occlusion_layer", 1286410249L),
			java.util.Map.entry("set_uv_clipping", 2586408642L),
			java.util.Map.entry("move_occlusion_layer", 3937882851L),
			java.util.Map.entry("set_tile_offset_axis", 3300198521L),
			java.util.Map.entry("set_terrain_set_mode", 3943003916L),
			java.util.Map.entry("get_tile_layout", 194628839L),
			java.util.Map.entry("set_source_level_tile_proxy", 3937882851L),
			java.util.Map.entry("has_coords_level_tile_proxy", 3957903770L),
			java.util.Map.entry("move_physics_layer", 3937882851L), java.util.Map.entry("remove_terrain", 3937882851L),
			java.util.Map.entry("get_terrain_color", 2165839948L),
			java.util.Map.entry("set_terrain_color", 3733378741L), java.util.Map.entry("get_source", 1763540252L),
			java.util.Map.entry("get_tile_size", 3690982128L),
			java.util.Map.entry("get_occlusion_layer_sdf_collision", 1116898809L),
			java.util.Map.entry("get_physics_layer_collision_mask", 923996154L),
			java.util.Map.entry("add_navigation_layer", 1025054187L),
			java.util.Map.entry("set_tile_shape", 2131427112L), java.util.Map.entry("get_terrain_name", 1391810591L),
			java.util.Map.entry("map_tile_proxy", 4267935328L),
			java.util.Map.entry("remove_source_level_tile_proxy", 1286410249L),
			java.util.Map.entry("remove_alternative_level_tile_proxy", 2328951467L),
			java.util.Map.entry("set_custom_data_layer_type", 3492912874L),
			java.util.Map.entry("clear_tile_proxies", 3218959716L), java.util.Map.entry("set_source_id", 3937882851L),
			java.util.Map.entry("get_source_count", 3905245786L),
			java.util.Map.entry("get_custom_data_layers_count", 3905245786L),
			java.util.Map.entry("set_physics_layer_collision_layer", 3937882851L),
			java.util.Map.entry("remove_source", 1286410249L), java.util.Map.entry("get_tile_shape", 716918169L),
			java.util.Map.entry("set_physics_layer_physics_material", 1018687357L),
			java.util.Map.entry("get_terrains_count", 923996154L),
			java.util.Map.entry("get_tile_offset_axis", 762494114L),
			java.util.Map.entry("get_custom_data_layer_by_name", 1321353865L),
			java.util.Map.entry("get_alternative_level_tile_proxy", 2303761075L),
			java.util.Map.entry("get_terrain_sets_count", 3905245786L),
			java.util.Map.entry("get_physics_layer_physics_material", 788318639L),
			java.util.Map.entry("set_tile_size", 1130785943L),
			java.util.Map.entry("set_occlusion_layer_light_mask", 3937882851L),
			java.util.Map.entry("has_custom_data_layer_by_name", 3927539163L),
			java.util.Map.entry("is_uv_clipping", 36873697L), java.util.Map.entry("get_pattern", 4207737510L),
			java.util.Map.entry("get_coords_level_tile_proxy", 2856536371L),
			java.util.Map.entry("remove_pattern", 1286410249L), java.util.Map.entry("get_patterns_count", 2455072627L),
			java.util.Map.entry("remove_physics_layer", 1286410249L),
			java.util.Map.entry("set_navigation_layer_layers", 3937882851L),
			java.util.Map.entry("get_navigation_layer_layer_value", 2522259332L),
			java.util.Map.entry("add_custom_data_layer", 1025054187L),
			java.util.Map.entry("get_physics_layer_collision_layer", 923996154L),
			java.util.Map.entry("get_next_source_id", 3905245786L),
			java.util.Map.entry("remove_custom_data_layer", 1286410249L),
			java.util.Map.entry("add_terrain", 1230568737L),
			java.util.Map.entry("get_occlusion_layer_light_mask", 923996154L),
			java.util.Map.entry("get_terrain_set_mode", 2084469411L),
			java.util.Map.entry("set_occlusion_layer_sdf_collision", 300928843L),
			java.util.Map.entry("get_custom_data_layer_name", 844755477L),
			java.util.Map.entry("get_source_id", 923996154L), java.util.Map.entry("set_tile_layout", 1071216679L),
			java.util.Map.entry("add_terrain_set", 1025054187L),
			java.util.Map.entry("set_custom_data_layer_name", 501894301L),
			java.util.Map.entry("cleanup_invalid_tile_proxies", 3218959716L),
			java.util.Map.entry("move_navigation_layer", 3937882851L),
			java.util.Map.entry("add_occlusion_layer", 1025054187L),
			java.util.Map.entry("has_source_level_tile_proxy", 3067735520L),
			java.util.Map.entry("remove_coords_level_tile_proxy", 2311374912L),
			java.util.Map.entry("get_source_level_tile_proxy", 3744713108L),
			java.util.Map.entry("add_source", 1059186179L),
			java.util.Map.entry("has_alternative_level_tile_proxy", 180086755L),
			java.util.Map.entry("move_terrain_set", 3937882851L));

	TileSet(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TileSet(long nativePointer) {
		super(nativePointer);
	}

	public int add_source(TileSetSource source, long atlas_source_id_override) {
		return (int) super.call("add_source",
				new java.lang.Object[]{(java.lang.Object) source, java.lang.Long.valueOf(atlas_source_id_override)});
	}

	public void remove_source(long source_id) {
		super.call("remove_source", new java.lang.Object[]{java.lang.Long.valueOf(source_id)});
	}

	public void set_source_id(long source_id, long new_source_id) {
		super.call("set_source_id",
				new java.lang.Object[]{java.lang.Long.valueOf(source_id), java.lang.Long.valueOf(new_source_id)});
	}

	public int get_source_id(long index) {
		return (int) super.call("get_source_id", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean has_source(long source_id) {
		return (boolean) super.call("has_source", new java.lang.Object[]{java.lang.Long.valueOf(source_id)});
	}

	public TileSetSource get_source(long source_id) {
		return (TileSetSource) super.call("get_source", new java.lang.Object[]{java.lang.Long.valueOf(source_id)});
	}

	public boolean is_uv_clipping() {
		return (boolean) super.call("is_uv_clipping");
	}

	public void add_occlusion_layer(long to_position) {
		super.call("add_occlusion_layer", new java.lang.Object[]{java.lang.Long.valueOf(to_position)});
	}

	public void move_occlusion_layer(long layer_index, long to_position) {
		super.call("move_occlusion_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), java.lang.Long.valueOf(to_position)});
	}

	public void remove_occlusion_layer(long layer_index) {
		super.call("remove_occlusion_layer", new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public void set_occlusion_layer_light_mask(long layer_index, long light_mask) {
		super.call("set_occlusion_layer_light_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), java.lang.Long.valueOf(light_mask)});
	}

	public int get_occlusion_layer_light_mask(long layer_index) {
		return (int) super.call("get_occlusion_layer_light_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public void set_occlusion_layer_sdf_collision(long layer_index, boolean sdf_collision) {
		super.call("set_occlusion_layer_sdf_collision",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), java.lang.Boolean.valueOf(sdf_collision)});
	}

	public boolean get_occlusion_layer_sdf_collision(long layer_index) {
		return (boolean) super.call("get_occlusion_layer_sdf_collision",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public void add_physics_layer(long to_position) {
		super.call("add_physics_layer", new java.lang.Object[]{java.lang.Long.valueOf(to_position)});
	}

	public void move_physics_layer(long layer_index, long to_position) {
		super.call("move_physics_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), java.lang.Long.valueOf(to_position)});
	}

	public void remove_physics_layer(long layer_index) {
		super.call("remove_physics_layer", new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public void set_physics_layer_collision_layer(long layer_index, long layer) {
		super.call("set_physics_layer_collision_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), java.lang.Long.valueOf(layer)});
	}

	public long get_physics_layer_collision_layer(long layer_index) {
		return (long) super.call("get_physics_layer_collision_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public void set_physics_layer_collision_mask(long layer_index, long mask) {
		super.call("set_physics_layer_collision_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), java.lang.Long.valueOf(mask)});
	}

	public long get_physics_layer_collision_mask(long layer_index) {
		return (long) super.call("get_physics_layer_collision_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public void set_physics_layer_collision_priority(long layer_index, double priority) {
		super.call("set_physics_layer_collision_priority",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), java.lang.Double.valueOf(priority)});
	}

	public double get_physics_layer_collision_priority(long layer_index) {
		return (double) super.call("get_physics_layer_collision_priority",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public void set_physics_layer_physics_material(long layer_index, PhysicsMaterial physics_material) {
		super.call("set_physics_layer_physics_material",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), (java.lang.Object) physics_material});
	}

	public PhysicsMaterial get_physics_layer_physics_material(long layer_index) {
		return (PhysicsMaterial) super.call("get_physics_layer_physics_material",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public void add_terrain_set(long to_position) {
		super.call("add_terrain_set", new java.lang.Object[]{java.lang.Long.valueOf(to_position)});
	}

	public void move_terrain_set(long terrain_set, long to_position) {
		super.call("move_terrain_set",
				new java.lang.Object[]{java.lang.Long.valueOf(terrain_set), java.lang.Long.valueOf(to_position)});
	}

	public void remove_terrain_set(long terrain_set) {
		super.call("remove_terrain_set", new java.lang.Object[]{java.lang.Long.valueOf(terrain_set)});
	}

	public void set_terrain_set_mode(long terrain_set, int mode) {
		super.call("set_terrain_set_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(terrain_set), java.lang.Integer.valueOf(mode)});
	}

	public int get_terrain_set_mode(long terrain_set) {
		return (int) super.call("get_terrain_set_mode", new java.lang.Object[]{java.lang.Long.valueOf(terrain_set)});
	}

	public int get_terrains_count(long terrain_set) {
		return (int) super.call("get_terrains_count", new java.lang.Object[]{java.lang.Long.valueOf(terrain_set)});
	}

	public void add_terrain(long terrain_set, long to_position) {
		super.call("add_terrain",
				new java.lang.Object[]{java.lang.Long.valueOf(terrain_set), java.lang.Long.valueOf(to_position)});
	}

	public void move_terrain(long terrain_set, long terrain_index, long to_position) {
		super.call("move_terrain", new java.lang.Object[]{java.lang.Long.valueOf(terrain_set),
				java.lang.Long.valueOf(terrain_index), java.lang.Long.valueOf(to_position)});
	}

	public void remove_terrain(long terrain_set, long terrain_index) {
		super.call("remove_terrain",
				new java.lang.Object[]{java.lang.Long.valueOf(terrain_set), java.lang.Long.valueOf(terrain_index)});
	}

	public void set_terrain_name(long terrain_set, long terrain_index, String name) {
		super.call("set_terrain_name", new java.lang.Object[]{java.lang.Long.valueOf(terrain_set),
				java.lang.Long.valueOf(terrain_index), (java.lang.Object) name});
	}

	public String get_terrain_name(long terrain_set, long terrain_index) {
		return (String) super.call("get_terrain_name",
				new java.lang.Object[]{java.lang.Long.valueOf(terrain_set), java.lang.Long.valueOf(terrain_index)});
	}

	public void set_terrain_color(long terrain_set, long terrain_index, Color color) {
		super.call("set_terrain_color", new java.lang.Object[]{java.lang.Long.valueOf(terrain_set),
				java.lang.Long.valueOf(terrain_index), (java.lang.Object) color});
	}

	public Color get_terrain_color(long terrain_set, long terrain_index) {
		return (Color) super.call("get_terrain_color",
				new java.lang.Object[]{java.lang.Long.valueOf(terrain_set), java.lang.Long.valueOf(terrain_index)});
	}

	public void add_navigation_layer(long to_position) {
		super.call("add_navigation_layer", new java.lang.Object[]{java.lang.Long.valueOf(to_position)});
	}

	public void move_navigation_layer(long layer_index, long to_position) {
		super.call("move_navigation_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), java.lang.Long.valueOf(to_position)});
	}

	public void remove_navigation_layer(long layer_index) {
		super.call("remove_navigation_layer", new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public void set_navigation_layer_layers(long layer_index, long layers) {
		super.call("set_navigation_layer_layers",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), java.lang.Long.valueOf(layers)});
	}

	public long get_navigation_layer_layers(long layer_index) {
		return (long) super.call("get_navigation_layer_layers",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public void set_navigation_layer_layer_value(long layer_index, long layer_number, boolean value) {
		super.call("set_navigation_layer_layer_value", new java.lang.Object[]{java.lang.Long.valueOf(layer_index),
				java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_navigation_layer_layer_value(long layer_index, long layer_number) {
		return (boolean) super.call("get_navigation_layer_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), java.lang.Long.valueOf(layer_number)});
	}

	public void add_custom_data_layer(long to_position) {
		super.call("add_custom_data_layer", new java.lang.Object[]{java.lang.Long.valueOf(to_position)});
	}

	public void move_custom_data_layer(long layer_index, long to_position) {
		super.call("move_custom_data_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), java.lang.Long.valueOf(to_position)});
	}

	public void remove_custom_data_layer(long layer_index) {
		super.call("remove_custom_data_layer", new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public int get_custom_data_layer_by_name(String layer_name) {
		return (int) super.call("get_custom_data_layer_by_name", new java.lang.Object[]{(java.lang.Object) layer_name});
	}

	public void set_custom_data_layer_name(long layer_index, String layer_name) {
		super.call("set_custom_data_layer_name",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), (java.lang.Object) layer_name});
	}

	public boolean has_custom_data_layer_by_name(String layer_name) {
		return (boolean) super.call("has_custom_data_layer_by_name",
				new java.lang.Object[]{(java.lang.Object) layer_name});
	}

	public String get_custom_data_layer_name(long layer_index) {
		return (String) super.call("get_custom_data_layer_name",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public void set_custom_data_layer_type(long layer_index, int layer_type) {
		super.call("set_custom_data_layer_type",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index), java.lang.Integer.valueOf(layer_type)});
	}

	public int get_custom_data_layer_type(long layer_index) {
		return (int) super.call("get_custom_data_layer_type",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_index)});
	}

	public void set_source_level_tile_proxy(long source_from, long source_to) {
		super.call("set_source_level_tile_proxy",
				new java.lang.Object[]{java.lang.Long.valueOf(source_from), java.lang.Long.valueOf(source_to)});
	}

	public int get_source_level_tile_proxy(long source_from) {
		return (int) super.call("get_source_level_tile_proxy",
				new java.lang.Object[]{java.lang.Long.valueOf(source_from)});
	}

	public boolean has_source_level_tile_proxy(long source_from) {
		return (boolean) super.call("has_source_level_tile_proxy",
				new java.lang.Object[]{java.lang.Long.valueOf(source_from)});
	}

	public void remove_source_level_tile_proxy(long source_from) {
		super.call("remove_source_level_tile_proxy", new java.lang.Object[]{java.lang.Long.valueOf(source_from)});
	}

	public void set_coords_level_tile_proxy(long p_source_from, Vector2i coords_from, long source_to,
			Vector2i coords_to) {
		super.call("set_coords_level_tile_proxy", new java.lang.Object[]{java.lang.Long.valueOf(p_source_from),
				(java.lang.Object) coords_from, java.lang.Long.valueOf(source_to), (java.lang.Object) coords_to});
	}

	public GodotArray get_coords_level_tile_proxy(long source_from, Vector2i coords_from) {
		return (GodotArray) super.call("get_coords_level_tile_proxy",
				new java.lang.Object[]{java.lang.Long.valueOf(source_from), (java.lang.Object) coords_from});
	}

	public boolean has_coords_level_tile_proxy(long source_from, Vector2i coords_from) {
		return (boolean) super.call("has_coords_level_tile_proxy",
				new java.lang.Object[]{java.lang.Long.valueOf(source_from), (java.lang.Object) coords_from});
	}

	public void remove_coords_level_tile_proxy(long source_from, Vector2i coords_from) {
		super.call("remove_coords_level_tile_proxy",
				new java.lang.Object[]{java.lang.Long.valueOf(source_from), (java.lang.Object) coords_from});
	}

	public void set_alternative_level_tile_proxy(long source_from, Vector2i coords_from, long alternative_from,
			long source_to, Vector2i coords_to, long alternative_to) {
		super.call("set_alternative_level_tile_proxy",
				new java.lang.Object[]{java.lang.Long.valueOf(source_from), (java.lang.Object) coords_from,
						java.lang.Long.valueOf(alternative_from), java.lang.Long.valueOf(source_to),
						(java.lang.Object) coords_to, java.lang.Long.valueOf(alternative_to)});
	}

	public GodotArray get_alternative_level_tile_proxy(long source_from, Vector2i coords_from, long alternative_from) {
		return (GodotArray) super.call("get_alternative_level_tile_proxy",
				new java.lang.Object[]{java.lang.Long.valueOf(source_from), (java.lang.Object) coords_from,
						java.lang.Long.valueOf(alternative_from)});
	}

	public boolean has_alternative_level_tile_proxy(long source_from, Vector2i coords_from, long alternative_from) {
		return (boolean) super.call("has_alternative_level_tile_proxy",
				new java.lang.Object[]{java.lang.Long.valueOf(source_from), (java.lang.Object) coords_from,
						java.lang.Long.valueOf(alternative_from)});
	}

	public void remove_alternative_level_tile_proxy(long source_from, Vector2i coords_from, long alternative_from) {
		super.call("remove_alternative_level_tile_proxy", new java.lang.Object[]{java.lang.Long.valueOf(source_from),
				(java.lang.Object) coords_from, java.lang.Long.valueOf(alternative_from)});
	}

	public GodotArray map_tile_proxy(long source_from, Vector2i coords_from, long alternative_from) {
		return (GodotArray) super.call("map_tile_proxy", new java.lang.Object[]{java.lang.Long.valueOf(source_from),
				(java.lang.Object) coords_from, java.lang.Long.valueOf(alternative_from)});
	}

	public void cleanup_invalid_tile_proxies() {
		super.call("cleanup_invalid_tile_proxies");
	}

	public void clear_tile_proxies() {
		super.call("clear_tile_proxies");
	}

	public int add_pattern(TileMapPattern pattern, long index) {
		return (int) super.call("add_pattern",
				new java.lang.Object[]{(java.lang.Object) pattern, java.lang.Long.valueOf(index)});
	}

	public TileMapPattern get_pattern(long index) {
		return (TileMapPattern) super.call("get_pattern", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void remove_pattern(long index) {
		super.call("remove_pattern", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public long getTile_shape() {
		return (long) super.call("get_tile_shape", new java.lang.Object[0]);
	}

	public void setTile_shape(long value) {
		super.call("set_tile_shape", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTile_layout() {
		return (long) super.call("get_tile_layout", new java.lang.Object[0]);
	}

	public void setTile_layout(long value) {
		super.call("set_tile_layout", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTile_offset_axis() {
		return (long) super.call("get_tile_offset_axis", new java.lang.Object[0]);
	}

	public void setTile_offset_axis(long value) {
		super.call("set_tile_offset_axis", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector2i getTile_size() {
		return (Vector2i) super.call("get_tile_size", new java.lang.Object[0]);
	}

	public void setTile_size(Vector2i value) {
		super.call("set_tile_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isUv_clipping() {
		return (boolean) super.call("is_uv_clipping", new java.lang.Object[0]);
	}

	public void setUv_clipping(boolean value) {
		super.call("set_uv_clipping", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
