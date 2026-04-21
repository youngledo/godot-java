package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class TileMap extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("update_internals", 3218959716L),
			java.util.Map.entry("notify_runtime_tile_data_update", 1025054187L),
			java.util.Map.entry("set_layer_modulate", 2878471219L),
			java.util.Map.entry("get_cell_alternative_tile", 551761942L),
			java.util.Map.entry("set_cells_terrain_path", 3578627656L),
			java.util.Map.entry("is_layer_enabled", 1116898809L),
			java.util.Map.entry("get_cell_atlas_coords", 1869815066L),
			java.util.Map.entry("get_cell_source_id", 551761942L),
			java.util.Map.entry("get_layer_y_sort_origin", 923996154L),
			java.util.Map.entry("set_collision_visibility_mode", 3193440636L),
			java.util.Map.entry("set_pattern", 1195853946L),
			java.util.Map.entry("set_rendering_quadrant_size", 1286410249L),
			java.util.Map.entry("get_layer_z_index", 923996154L),
			java.util.Map.entry("set_collision_animatable", 2586408642L),
			java.util.Map.entry("set_layer_navigation_map", 4040184819L),
			java.util.Map.entry("set_layer_y_sort_enabled", 300928843L),
			java.util.Map.entry("map_pattern", 1864516957L), java.util.Map.entry("get_cell_tile_data", 2849631287L),
			java.util.Map.entry("get_layer_modulate", 3457211756L), java.util.Map.entry("get_layer_name", 844755477L),
			java.util.Map.entry("get_collision_visibility_mode", 1697018252L),
			java.util.Map.entry("move_layer", 3937882851L), java.util.Map.entry("erase_cell", 2311374912L),
			java.util.Map.entry("get_tileset", 2678226422L),
			java.util.Map.entry("get_rendering_quadrant_size", 3905245786L),
			java.util.Map.entry("get_layers_count", 3905245786L), java.util.Map.entry("add_layer", 1286410249L),
			java.util.Map.entry("get_used_cells", 663333327L), java.util.Map.entry("fix_invalid_tiles", 3218959716L),
			java.util.Map.entry("get_neighbor_cell", 986575103L), java.util.Map.entry("set_cell", 966713560L),
			java.util.Map.entry("get_navigation_map", 495598643L),
			java.util.Map.entry("get_layer_for_body_rid", 3917799429L),
			java.util.Map.entry("set_cells_terrain_connect", 3578627656L),
			java.util.Map.entry("get_pattern", 2833570986L),
			java.util.Map.entry("is_layer_y_sort_enabled", 1116898809L),
			java.util.Map.entry("set_layer_z_index", 3937882851L),
			java.util.Map.entry("is_layer_navigation_enabled", 1116898809L),
			java.util.Map.entry("get_navigation_visibility_mode", 1697018252L),
			java.util.Map.entry("map_to_local", 108438297L), java.util.Map.entry("get_surrounding_cells", 2673526557L),
			java.util.Map.entry("get_layer_navigation_map", 495598643L),
			java.util.Map.entry("clear_layer", 1286410249L), java.util.Map.entry("set_layer_enabled", 300928843L),
			java.util.Map.entry("is_cell_transposed", 2908343862L), java.util.Map.entry("set_layer_name", 501894301L),
			java.util.Map.entry("get_used_cells_by_id", 2931012785L),
			java.util.Map.entry("get_coords_for_body_rid", 291584212L),
			java.util.Map.entry("set_navigation_map", 4040184819L),
			java.util.Map.entry("set_layer_navigation_enabled", 300928843L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("is_collision_animatable", 36873697L),
			java.util.Map.entry("is_cell_flipped_h", 2908343862L),
			java.util.Map.entry("set_navigation_visibility_mode", 3193440636L),
			java.util.Map.entry("remove_layer", 1286410249L), java.util.Map.entry("local_to_map", 837806996L),
			java.util.Map.entry("set_layer_y_sort_origin", 3937882851L),
			java.util.Map.entry("get_used_rect", 410525958L), java.util.Map.entry("is_cell_flipped_v", 2908343862L),
			java.util.Map.entry("force_update", 1025054187L), java.util.Map.entry("set_tileset", 774531446L));

	TileMap(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TileMap(long nativePointer) {
		super(nativePointer);
	}

	public void set_navigation_map(long layer, long map) {
		super.call("set_navigation_map",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Long.valueOf(map)});
	}

	public long get_navigation_map(long layer) {
		return (long) super.call("get_navigation_map", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public void force_update(long layer) {
		super.call("force_update", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public void add_layer(long to_position) {
		super.call("add_layer", new java.lang.Object[]{java.lang.Long.valueOf(to_position)});
	}

	public void move_layer(long layer, long to_position) {
		super.call("move_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Long.valueOf(to_position)});
	}

	public void remove_layer(long layer) {
		super.call("remove_layer", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public void set_layer_name(long layer, String name) {
		super.call("set_layer_name", new java.lang.Object[]{java.lang.Long.valueOf(layer), (java.lang.Object) name});
	}

	public String get_layer_name(long layer) {
		return (String) super.call("get_layer_name", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public void set_layer_enabled(long layer, boolean enabled) {
		super.call("set_layer_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_layer_enabled(long layer) {
		return (boolean) super.call("is_layer_enabled", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public void set_layer_modulate(long layer, Color modulate) {
		super.call("set_layer_modulate",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), (java.lang.Object) modulate});
	}

	public Color get_layer_modulate(long layer) {
		return (Color) super.call("get_layer_modulate", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public void set_layer_y_sort_enabled(long layer, boolean y_sort_enabled) {
		super.call("set_layer_y_sort_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Boolean.valueOf(y_sort_enabled)});
	}

	public boolean is_layer_y_sort_enabled(long layer) {
		return (boolean) super.call("is_layer_y_sort_enabled", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public void set_layer_y_sort_origin(long layer, long y_sort_origin) {
		super.call("set_layer_y_sort_origin",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Long.valueOf(y_sort_origin)});
	}

	public int get_layer_y_sort_origin(long layer) {
		return (int) super.call("get_layer_y_sort_origin", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public void set_layer_z_index(long layer, long z_index) {
		super.call("set_layer_z_index",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Long.valueOf(z_index)});
	}

	public int get_layer_z_index(long layer) {
		return (int) super.call("get_layer_z_index", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public void set_layer_navigation_enabled(long layer, boolean enabled) {
		super.call("set_layer_navigation_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_layer_navigation_enabled(long layer) {
		return (boolean) super.call("is_layer_navigation_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public void set_layer_navigation_map(long layer, long map) {
		super.call("set_layer_navigation_map",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Long.valueOf(map)});
	}

	public long get_layer_navigation_map(long layer) {
		return (long) super.call("get_layer_navigation_map", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public boolean is_collision_animatable() {
		return (boolean) super.call("is_collision_animatable");
	}

	public void set_cell(long layer, Vector2i coords, long source_id, Vector2i atlas_coords, long alternative_tile) {
		super.call("set_cell",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), (java.lang.Object) coords,
						java.lang.Long.valueOf(source_id), (java.lang.Object) atlas_coords,
						java.lang.Long.valueOf(alternative_tile)});
	}

	public void erase_cell(long layer, Vector2i coords) {
		super.call("erase_cell", new java.lang.Object[]{java.lang.Long.valueOf(layer), (java.lang.Object) coords});
	}

	public int get_cell_source_id(long layer, Vector2i coords, boolean use_proxies) {
		return (int) super.call("get_cell_source_id", new java.lang.Object[]{java.lang.Long.valueOf(layer),
				(java.lang.Object) coords, java.lang.Boolean.valueOf(use_proxies)});
	}

	public Vector2i get_cell_atlas_coords(long layer, Vector2i coords, boolean use_proxies) {
		return (Vector2i) super.call("get_cell_atlas_coords", new java.lang.Object[]{java.lang.Long.valueOf(layer),
				(java.lang.Object) coords, java.lang.Boolean.valueOf(use_proxies)});
	}

	public int get_cell_alternative_tile(long layer, Vector2i coords, boolean use_proxies) {
		return (int) super.call("get_cell_alternative_tile", new java.lang.Object[]{java.lang.Long.valueOf(layer),
				(java.lang.Object) coords, java.lang.Boolean.valueOf(use_proxies)});
	}

	public TileData get_cell_tile_data(long layer, Vector2i coords, boolean use_proxies) {
		return (TileData) super.call("get_cell_tile_data", new java.lang.Object[]{java.lang.Long.valueOf(layer),
				(java.lang.Object) coords, java.lang.Boolean.valueOf(use_proxies)});
	}

	public boolean is_cell_flipped_h(long layer, Vector2i coords, boolean use_proxies) {
		return (boolean) super.call("is_cell_flipped_h", new java.lang.Object[]{java.lang.Long.valueOf(layer),
				(java.lang.Object) coords, java.lang.Boolean.valueOf(use_proxies)});
	}

	public boolean is_cell_flipped_v(long layer, Vector2i coords, boolean use_proxies) {
		return (boolean) super.call("is_cell_flipped_v", new java.lang.Object[]{java.lang.Long.valueOf(layer),
				(java.lang.Object) coords, java.lang.Boolean.valueOf(use_proxies)});
	}

	public boolean is_cell_transposed(long layer, Vector2i coords, boolean use_proxies) {
		return (boolean) super.call("is_cell_transposed", new java.lang.Object[]{java.lang.Long.valueOf(layer),
				(java.lang.Object) coords, java.lang.Boolean.valueOf(use_proxies)});
	}

	public Vector2i get_coords_for_body_rid(long body) {
		return (Vector2i) super.call("get_coords_for_body_rid", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public int get_layer_for_body_rid(long body) {
		return (int) super.call("get_layer_for_body_rid", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public TileMapPattern get_pattern(long layer, Vector2i[] coords_array) {
		return (TileMapPattern) super.call("get_pattern",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), (java.lang.Object) coords_array});
	}

	public Vector2i map_pattern(Vector2i position_in_tilemap, Vector2i coords_in_pattern, TileMapPattern pattern) {
		return (Vector2i) super.call("map_pattern", new java.lang.Object[]{(java.lang.Object) position_in_tilemap,
				(java.lang.Object) coords_in_pattern, (java.lang.Object) pattern});
	}

	public void set_pattern(long layer, Vector2i position, TileMapPattern pattern) {
		super.call("set_pattern", new java.lang.Object[]{java.lang.Long.valueOf(layer), (java.lang.Object) position,
				(java.lang.Object) pattern});
	}

	public void set_cells_terrain_connect(long layer, Vector2i[] cells, long terrain_set, long terrain,
			boolean ignore_empty_terrains) {
		super.call("set_cells_terrain_connect",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), (java.lang.Object) cells,
						java.lang.Long.valueOf(terrain_set), java.lang.Long.valueOf(terrain),
						java.lang.Boolean.valueOf(ignore_empty_terrains)});
	}

	public void set_cells_terrain_path(long layer, Vector2i[] path, long terrain_set, long terrain,
			boolean ignore_empty_terrains) {
		super.call("set_cells_terrain_path",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), (java.lang.Object) path,
						java.lang.Long.valueOf(terrain_set), java.lang.Long.valueOf(terrain),
						java.lang.Boolean.valueOf(ignore_empty_terrains)});
	}

	public void fix_invalid_tiles() {
		super.call("fix_invalid_tiles");
	}

	public void clear_layer(long layer) {
		super.call("clear_layer", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public void clear() {
		super.call("clear");
	}

	public void update_internals() {
		super.call("update_internals");
	}

	public void notify_runtime_tile_data_update(long layer) {
		super.call("notify_runtime_tile_data_update", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public Vector2i[] get_surrounding_cells(Vector2i coords) {
		return (Vector2i[]) super.call("get_surrounding_cells", new java.lang.Object[]{(java.lang.Object) coords});
	}

	public Vector2i[] get_used_cells(long layer) {
		return (Vector2i[]) super.call("get_used_cells", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public Vector2i[] get_used_cells_by_id(long layer, long source_id, Vector2i atlas_coords, long alternative_tile) {
		return (Vector2i[]) super.call("get_used_cells_by_id",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Long.valueOf(source_id),
						(java.lang.Object) atlas_coords, java.lang.Long.valueOf(alternative_tile)});
	}

	public Vector2 map_to_local(Vector2i map_position) {
		return (Vector2) super.call("map_to_local", new java.lang.Object[]{(java.lang.Object) map_position});
	}

	public Vector2i local_to_map(Vector2 local_position) {
		return (Vector2i) super.call("local_to_map", new java.lang.Object[]{(java.lang.Object) local_position});
	}

	public Vector2i get_neighbor_cell(Vector2i coords, int neighbor) {
		return (Vector2i) super.call("get_neighbor_cell",
				new java.lang.Object[]{(java.lang.Object) coords, java.lang.Integer.valueOf(neighbor)});
	}

	public TileSet getTile_set() {
		return (TileSet) super.call("get_tileset", new java.lang.Object[0]);
	}

	public void setTile_set(TileSet value) {
		super.call("set_tileset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getRendering_quadrant_size() {
		return (long) super.call("get_rendering_quadrant_size", new java.lang.Object[0]);
	}

	public void setRendering_quadrant_size(long value) {
		super.call("set_rendering_quadrant_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isCollision_animatable() {
		return (boolean) super.call("is_collision_animatable", new java.lang.Object[0]);
	}

	public void setCollision_animatable(boolean value) {
		super.call("set_collision_animatable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getCollision_visibility_mode() {
		return (long) super.call("get_collision_visibility_mode", new java.lang.Object[0]);
	}

	public void setCollision_visibility_mode(long value) {
		super.call("set_collision_visibility_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getNavigation_visibility_mode() {
		return (long) super.call("get_navigation_visibility_mode", new java.lang.Object[0]);
	}

	public void setNavigation_visibility_mode(long value) {
		super.call("set_navigation_visibility_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
