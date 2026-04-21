package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class TileMapLayer extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("update_internals", 3218959716L),
			java.util.Map.entry("is_collision_enabled", 36873697L),
			java.util.Map.entry("notify_runtime_tile_data_update", 3218959716L),
			java.util.Map.entry("get_cell_alternative_tile", 2485466453L),
			java.util.Map.entry("set_cells_terrain_path", 748968311L),
			java.util.Map.entry("get_cell_atlas_coords", 3050897911L),
			java.util.Map.entry("get_physics_quadrant_size", 3905245786L),
			java.util.Map.entry("get_cell_source_id", 2485466453L), java.util.Map.entry("set_pattern", 1491151770L),
			java.util.Map.entry("set_collision_visibility_mode", 3508099847L),
			java.util.Map.entry("set_rendering_quadrant_size", 1286410249L),
			java.util.Map.entry("get_y_sort_origin", 3905245786L), java.util.Map.entry("map_pattern", 1864516957L),
			java.util.Map.entry("get_tile_map_data_as_array", 2362200018L),
			java.util.Map.entry("get_cell_tile_data", 205084707L),
			java.util.Map.entry("set_collision_enabled", 2586408642L),
			java.util.Map.entry("get_collision_visibility_mode", 338220793L),
			java.util.Map.entry("erase_cell", 1130785943L), java.util.Map.entry("set_enabled", 2586408642L),
			java.util.Map.entry("is_x_draw_order_reversed", 36873697L),
			java.util.Map.entry("set_x_draw_order_reversed", 2586408642L),
			java.util.Map.entry("is_navigation_enabled", 36873697L), java.util.Map.entry("set_tile_set", 774531446L),
			java.util.Map.entry("get_rendering_quadrant_size", 3905245786L),
			java.util.Map.entry("has_body_rid", 4155700596L),
			java.util.Map.entry("set_tile_map_data_from_array", 2971499966L),
			java.util.Map.entry("get_tile_set", 2678226422L), java.util.Map.entry("get_used_cells", 3995934104L),
			java.util.Map.entry("fix_invalid_tiles", 3218959716L), java.util.Map.entry("get_neighbor_cell", 986575103L),
			java.util.Map.entry("set_cell", 2428518503L), java.util.Map.entry("get_navigation_map", 2944877500L),
			java.util.Map.entry("set_cells_terrain_connect", 748968311L),
			java.util.Map.entry("get_pattern", 3820813253L), java.util.Map.entry("set_occlusion_enabled", 2586408642L),
			java.util.Map.entry("is_enabled", 36873697L), java.util.Map.entry("set_y_sort_origin", 1286410249L),
			java.util.Map.entry("get_navigation_visibility_mode", 338220793L),
			java.util.Map.entry("map_to_local", 108438297L), java.util.Map.entry("get_surrounding_cells", 2673526557L),
			java.util.Map.entry("set_navigation_enabled", 2586408642L),
			java.util.Map.entry("set_physics_quadrant_size", 1286410249L),
			java.util.Map.entry("is_occlusion_enabled", 36873697L),
			java.util.Map.entry("is_cell_transposed", 3900751641L),
			java.util.Map.entry("get_used_cells_by_id", 4175304538L),
			java.util.Map.entry("get_coords_for_body_rid", 733700038L),
			java.util.Map.entry("set_navigation_map", 2722037293L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("is_cell_flipped_h", 3900751641L),
			java.util.Map.entry("set_navigation_visibility_mode", 3508099847L),
			java.util.Map.entry("set_use_kinematic_bodies", 2586408642L),
			java.util.Map.entry("local_to_map", 837806996L), java.util.Map.entry("get_used_rect", 410525958L),
			java.util.Map.entry("is_cell_flipped_v", 3900751641L),
			java.util.Map.entry("is_using_kinematic_bodies", 36873697L));

	TileMapLayer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TileMapLayer(long nativePointer) {
		super(nativePointer);
	}

	public void set_cell(Vector2i coords, long source_id, Vector2i atlas_coords, long alternative_tile) {
		super.call("set_cell", new java.lang.Object[]{(java.lang.Object) coords, java.lang.Long.valueOf(source_id),
				(java.lang.Object) atlas_coords, java.lang.Long.valueOf(alternative_tile)});
	}

	public void erase_cell(Vector2i coords) {
		super.call("erase_cell", new java.lang.Object[]{(java.lang.Object) coords});
	}

	public void fix_invalid_tiles() {
		super.call("fix_invalid_tiles");
	}

	public void clear() {
		super.call("clear");
	}

	public int get_cell_source_id(Vector2i coords) {
		return (int) super.call("get_cell_source_id", new java.lang.Object[]{(java.lang.Object) coords});
	}

	public Vector2i get_cell_atlas_coords(Vector2i coords) {
		return (Vector2i) super.call("get_cell_atlas_coords", new java.lang.Object[]{(java.lang.Object) coords});
	}

	public int get_cell_alternative_tile(Vector2i coords) {
		return (int) super.call("get_cell_alternative_tile", new java.lang.Object[]{(java.lang.Object) coords});
	}

	public TileData get_cell_tile_data(Vector2i coords) {
		return (TileData) super.call("get_cell_tile_data", new java.lang.Object[]{(java.lang.Object) coords});
	}

	public boolean is_cell_flipped_h(Vector2i coords) {
		return (boolean) super.call("is_cell_flipped_h", new java.lang.Object[]{(java.lang.Object) coords});
	}

	public boolean is_cell_flipped_v(Vector2i coords) {
		return (boolean) super.call("is_cell_flipped_v", new java.lang.Object[]{(java.lang.Object) coords});
	}

	public boolean is_cell_transposed(Vector2i coords) {
		return (boolean) super.call("is_cell_transposed", new java.lang.Object[]{(java.lang.Object) coords});
	}

	public Vector2i[] get_used_cells_by_id(long source_id, Vector2i atlas_coords, long alternative_tile) {
		return (Vector2i[]) super.call("get_used_cells_by_id", new java.lang.Object[]{java.lang.Long.valueOf(source_id),
				(java.lang.Object) atlas_coords, java.lang.Long.valueOf(alternative_tile)});
	}

	public TileMapPattern get_pattern(Vector2i[] coords_array) {
		return (TileMapPattern) super.call("get_pattern", new java.lang.Object[]{(java.lang.Object) coords_array});
	}

	public void set_pattern(Vector2i position, TileMapPattern pattern) {
		super.call("set_pattern", new java.lang.Object[]{(java.lang.Object) position, (java.lang.Object) pattern});
	}

	public void set_cells_terrain_connect(Vector2i[] cells, long terrain_set, long terrain,
			boolean ignore_empty_terrains) {
		super.call("set_cells_terrain_connect",
				new java.lang.Object[]{(java.lang.Object) cells, java.lang.Long.valueOf(terrain_set),
						java.lang.Long.valueOf(terrain), java.lang.Boolean.valueOf(ignore_empty_terrains)});
	}

	public void set_cells_terrain_path(Vector2i[] path, long terrain_set, long terrain, boolean ignore_empty_terrains) {
		super.call("set_cells_terrain_path",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Long.valueOf(terrain_set),
						java.lang.Long.valueOf(terrain), java.lang.Boolean.valueOf(ignore_empty_terrains)});
	}

	public boolean has_body_rid(long body) {
		return (boolean) super.call("has_body_rid", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public Vector2i get_coords_for_body_rid(long body) {
		return (Vector2i) super.call("get_coords_for_body_rid", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void update_internals() {
		super.call("update_internals");
	}

	public void notify_runtime_tile_data_update() {
		super.call("notify_runtime_tile_data_update");
	}

	public Vector2i map_pattern(Vector2i position_in_tilemap, Vector2i coords_in_pattern, TileMapPattern pattern) {
		return (Vector2i) super.call("map_pattern", new java.lang.Object[]{(java.lang.Object) position_in_tilemap,
				(java.lang.Object) coords_in_pattern, (java.lang.Object) pattern});
	}

	public Vector2i[] get_surrounding_cells(Vector2i coords) {
		return (Vector2i[]) super.call("get_surrounding_cells", new java.lang.Object[]{(java.lang.Object) coords});
	}

	public Vector2i get_neighbor_cell(Vector2i coords, int neighbor) {
		return (Vector2i) super.call("get_neighbor_cell",
				new java.lang.Object[]{(java.lang.Object) coords, java.lang.Integer.valueOf(neighbor)});
	}

	public Vector2 map_to_local(Vector2i map_position) {
		return (Vector2) super.call("map_to_local", new java.lang.Object[]{(java.lang.Object) map_position});
	}

	public Vector2i local_to_map(Vector2 local_position) {
		return (Vector2i) super.call("local_to_map", new java.lang.Object[]{(java.lang.Object) local_position});
	}

	public boolean is_enabled() {
		return (boolean) super.call("is_enabled");
	}

	public boolean is_x_draw_order_reversed() {
		return (boolean) super.call("is_x_draw_order_reversed");
	}

	public boolean is_collision_enabled() {
		return (boolean) super.call("is_collision_enabled");
	}

	public boolean is_using_kinematic_bodies() {
		return (boolean) super.call("is_using_kinematic_bodies");
	}

	public boolean is_occlusion_enabled() {
		return (boolean) super.call("is_occlusion_enabled");
	}

	public boolean is_navigation_enabled() {
		return (boolean) super.call("is_navigation_enabled");
	}

	public byte[] getTile_map_data() {
		return (byte[]) super.call("get_tile_map_data_as_array", new java.lang.Object[0]);
	}

	public void setTile_map_data(byte[] value) {
		super.call("set_tile_map_data_from_array", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isEnabled() {
		return (boolean) super.call("is_enabled", new java.lang.Object[0]);
	}

	public void setEnabled(boolean value) {
		super.call("set_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public TileSet getTile_set() {
		return (TileSet) super.call("get_tile_set", new java.lang.Object[0]);
	}

	public void setTile_set(TileSet value) {
		super.call("set_tile_set", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isOcclusion_enabled() {
		return (boolean) super.call("is_occlusion_enabled", new java.lang.Object[0]);
	}

	public void setOcclusion_enabled(boolean value) {
		super.call("set_occlusion_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getY_sort_origin() {
		return (long) super.call("get_y_sort_origin", new java.lang.Object[0]);
	}

	public void setY_sort_origin(long value) {
		super.call("set_y_sort_origin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isX_draw_order_reversed() {
		return (boolean) super.call("is_x_draw_order_reversed", new java.lang.Object[0]);
	}

	public void setX_draw_order_reversed(boolean value) {
		super.call("set_x_draw_order_reversed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getRendering_quadrant_size() {
		return (long) super.call("get_rendering_quadrant_size", new java.lang.Object[0]);
	}

	public void setRendering_quadrant_size(long value) {
		super.call("set_rendering_quadrant_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isCollision_enabled() {
		return (boolean) super.call("is_collision_enabled", new java.lang.Object[0]);
	}

	public void setCollision_enabled(boolean value) {
		super.call("set_collision_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isUse_kinematic_bodies() {
		return (boolean) super.call("is_using_kinematic_bodies", new java.lang.Object[0]);
	}

	public void setUse_kinematic_bodies(boolean value) {
		super.call("set_use_kinematic_bodies", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getCollision_visibility_mode() {
		return (long) super.call("get_collision_visibility_mode", new java.lang.Object[0]);
	}

	public void setCollision_visibility_mode(long value) {
		super.call("set_collision_visibility_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPhysics_quadrant_size() {
		return (long) super.call("get_physics_quadrant_size", new java.lang.Object[0]);
	}

	public void setPhysics_quadrant_size(long value) {
		super.call("set_physics_quadrant_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isNavigation_enabled() {
		return (boolean) super.call("is_navigation_enabled", new java.lang.Object[0]);
	}

	public void setNavigation_enabled(boolean value) {
		super.call("set_navigation_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getNavigation_visibility_mode() {
		return (long) super.call("get_navigation_visibility_mode", new java.lang.Object[0]);
	}

	public void setNavigation_visibility_mode(long value) {
		super.call("set_navigation_visibility_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
