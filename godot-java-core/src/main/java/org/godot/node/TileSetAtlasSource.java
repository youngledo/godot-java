package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2i;
import org.godot.math.Vector2i;

public class TileSetAtlasSource extends TileSetSource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_separation", 1130785943L), java.util.Map.entry("get_atlas_grid_size", 3690982128L),
			java.util.Map.entry("get_tile_animation_separation", 3050897911L),
			java.util.Map.entry("set_tile_animation_mode", 3192753483L),
			java.util.Map.entry("set_tile_animation_frame_duration", 2843487787L),
			java.util.Map.entry("get_tile_data", 3534028207L), java.util.Map.entry("create_tile", 190528769L),
			java.util.Map.entry("get_runtime_tile_texture_region", 104874263L),
			java.util.Map.entry("has_tiles_outside_texture", 36873697L),
			java.util.Map.entry("remove_tile", 1130785943L), java.util.Map.entry("get_tile_size_in_atlas", 3050897911L),
			java.util.Map.entry("get_margins", 3690982128L),
			java.util.Map.entry("set_texture_region_size", 1130785943L),
			java.util.Map.entry("get_separation", 3690982128L),
			java.util.Map.entry("get_tile_texture_region", 241857547L),
			java.util.Map.entry("set_tile_animation_separation", 1941061099L),
			java.util.Map.entry("remove_alternative_tile", 3200960707L),
			java.util.Map.entry("get_next_alternative_tile_id", 2485466453L),
			java.util.Map.entry("create_alternative_tile", 2226298068L),
			java.util.Map.entry("get_tile_animation_total_duration", 719993801L),
			java.util.Map.entry("set_tile_animation_columns", 3200960707L),
			java.util.Map.entry("set_alternative_tile_id", 1499785778L),
			java.util.Map.entry("move_tile_in_atlas", 3870111920L),
			java.util.Map.entry("set_use_texture_padding", 2586408642L),
			java.util.Map.entry("set_margins", 1130785943L),
			java.util.Map.entry("set_tile_animation_frames_count", 3200960707L),
			java.util.Map.entry("get_tile_at_coords", 3050897911L),
			java.util.Map.entry("get_tile_animation_frame_duration", 1802448425L),
			java.util.Map.entry("get_texture_region_size", 3690982128L),
			java.util.Map.entry("get_tiles_to_be_removed_on_change", 1240378054L),
			java.util.Map.entry("set_tile_animation_speed", 2262553149L),
			java.util.Map.entry("get_tile_animation_speed", 719993801L),
			java.util.Map.entry("get_runtime_texture", 3635182373L),
			java.util.Map.entry("get_tile_animation_frames_count", 2485466453L),
			java.util.Map.entry("set_texture", 4051416890L),
			java.util.Map.entry("get_tile_animation_mode", 4025349959L),
			java.util.Map.entry("has_room_for_tile", 3018597268L),
			java.util.Map.entry("get_tile_animation_columns", 2485466453L),
			java.util.Map.entry("get_use_texture_padding", 36873697L),
			java.util.Map.entry("clear_tiles_outside_texture", 3218959716L),
			java.util.Map.entry("get_texture", 3635182373L));

	TileSetAtlasSource(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TileSetAtlasSource(long nativePointer) {
		super(nativePointer);
	}

	public void create_tile(Vector2i atlas_coords, Vector2i size) {
		super.call("create_tile", new java.lang.Object[]{(java.lang.Object) atlas_coords, (java.lang.Object) size});
	}

	public void remove_tile(Vector2i atlas_coords) {
		super.call("remove_tile", new java.lang.Object[]{(java.lang.Object) atlas_coords});
	}

	public void move_tile_in_atlas(Vector2i atlas_coords, Vector2i new_atlas_coords, Vector2i new_size) {
		super.call("move_tile_in_atlas", new java.lang.Object[]{(java.lang.Object) atlas_coords,
				(java.lang.Object) new_atlas_coords, (java.lang.Object) new_size});
	}

	public Vector2i get_tile_size_in_atlas(Vector2i atlas_coords) {
		return (Vector2i) super.call("get_tile_size_in_atlas", new java.lang.Object[]{(java.lang.Object) atlas_coords});
	}

	public boolean has_room_for_tile(Vector2i atlas_coords, Vector2i size, long animation_columns,
			Vector2i animation_separation, long frames_count, Vector2i ignored_tile) {
		return (boolean) super.call("has_room_for_tile",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, (java.lang.Object) size,
						java.lang.Long.valueOf(animation_columns), (java.lang.Object) animation_separation,
						java.lang.Long.valueOf(frames_count), (java.lang.Object) ignored_tile});
	}

	public double[][] get_tiles_to_be_removed_on_change(Texture2D texture, Vector2i margins, Vector2i separation,
			Vector2i texture_region_size) {
		return (double[][]) super.call("get_tiles_to_be_removed_on_change",
				new java.lang.Object[]{(java.lang.Object) texture, (java.lang.Object) margins,
						(java.lang.Object) separation, (java.lang.Object) texture_region_size});
	}

	public Vector2i get_tile_at_coords(Vector2i atlas_coords) {
		return (Vector2i) super.call("get_tile_at_coords", new java.lang.Object[]{(java.lang.Object) atlas_coords});
	}

	public boolean has_tiles_outside_texture() {
		return (boolean) super.call("has_tiles_outside_texture");
	}

	public void clear_tiles_outside_texture() {
		super.call("clear_tiles_outside_texture");
	}

	public void set_tile_animation_columns(Vector2i atlas_coords, long frame_columns) {
		super.call("set_tile_animation_columns",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, java.lang.Long.valueOf(frame_columns)});
	}

	public int get_tile_animation_columns(Vector2i atlas_coords) {
		return (int) super.call("get_tile_animation_columns", new java.lang.Object[]{(java.lang.Object) atlas_coords});
	}

	public void set_tile_animation_separation(Vector2i atlas_coords, Vector2i separation) {
		super.call("set_tile_animation_separation",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, (java.lang.Object) separation});
	}

	public Vector2i get_tile_animation_separation(Vector2i atlas_coords) {
		return (Vector2i) super.call("get_tile_animation_separation",
				new java.lang.Object[]{(java.lang.Object) atlas_coords});
	}

	public void set_tile_animation_speed(Vector2i atlas_coords, double speed) {
		super.call("set_tile_animation_speed",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, java.lang.Double.valueOf(speed)});
	}

	public double get_tile_animation_speed(Vector2i atlas_coords) {
		return (double) super.call("get_tile_animation_speed", new java.lang.Object[]{(java.lang.Object) atlas_coords});
	}

	public void set_tile_animation_mode(Vector2i atlas_coords, int mode) {
		super.call("set_tile_animation_mode",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, java.lang.Integer.valueOf(mode)});
	}

	public int get_tile_animation_mode(Vector2i atlas_coords) {
		return (int) super.call("get_tile_animation_mode", new java.lang.Object[]{(java.lang.Object) atlas_coords});
	}

	public void set_tile_animation_frames_count(Vector2i atlas_coords, long frames_count) {
		super.call("set_tile_animation_frames_count",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, java.lang.Long.valueOf(frames_count)});
	}

	public int get_tile_animation_frames_count(Vector2i atlas_coords) {
		return (int) super.call("get_tile_animation_frames_count",
				new java.lang.Object[]{(java.lang.Object) atlas_coords});
	}

	public void set_tile_animation_frame_duration(Vector2i atlas_coords, long frame_index, double duration) {
		super.call("set_tile_animation_frame_duration", new java.lang.Object[]{(java.lang.Object) atlas_coords,
				java.lang.Long.valueOf(frame_index), java.lang.Double.valueOf(duration)});
	}

	public double get_tile_animation_frame_duration(Vector2i atlas_coords, long frame_index) {
		return (double) super.call("get_tile_animation_frame_duration",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, java.lang.Long.valueOf(frame_index)});
	}

	public double get_tile_animation_total_duration(Vector2i atlas_coords) {
		return (double) super.call("get_tile_animation_total_duration",
				new java.lang.Object[]{(java.lang.Object) atlas_coords});
	}

	public int create_alternative_tile(Vector2i atlas_coords, long alternative_id_override) {
		return (int) super.call("create_alternative_tile", new java.lang.Object[]{(java.lang.Object) atlas_coords,
				java.lang.Long.valueOf(alternative_id_override)});
	}

	public void remove_alternative_tile(Vector2i atlas_coords, long alternative_tile) {
		super.call("remove_alternative_tile",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, java.lang.Long.valueOf(alternative_tile)});
	}

	public void set_alternative_tile_id(Vector2i atlas_coords, long alternative_tile, long new_id) {
		super.call("set_alternative_tile_id", new java.lang.Object[]{(java.lang.Object) atlas_coords,
				java.lang.Long.valueOf(alternative_tile), java.lang.Long.valueOf(new_id)});
	}

	public int get_next_alternative_tile_id(Vector2i atlas_coords) {
		return (int) super.call("get_next_alternative_tile_id",
				new java.lang.Object[]{(java.lang.Object) atlas_coords});
	}

	public TileData get_tile_data(Vector2i atlas_coords, long alternative_tile) {
		return (TileData) super.call("get_tile_data",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, java.lang.Long.valueOf(alternative_tile)});
	}

	public Rect2i get_tile_texture_region(Vector2i atlas_coords, long frame) {
		return (Rect2i) super.call("get_tile_texture_region",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, java.lang.Long.valueOf(frame)});
	}

	public Rect2i get_runtime_tile_texture_region(Vector2i atlas_coords, long frame) {
		return (Rect2i) super.call("get_runtime_tile_texture_region",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, java.lang.Long.valueOf(frame)});
	}

	public Texture2D getTexture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2i getMargins() {
		return (Vector2i) super.call("get_margins", new java.lang.Object[0]);
	}

	public void setMargins(Vector2i value) {
		super.call("set_margins", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2i getSeparation() {
		return (Vector2i) super.call("get_separation", new java.lang.Object[0]);
	}

	public void setSeparation(Vector2i value) {
		super.call("set_separation", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2i getTexture_region_size() {
		return (Vector2i) super.call("get_texture_region_size", new java.lang.Object[0]);
	}

	public void setTexture_region_size(Vector2i value) {
		super.call("set_texture_region_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getUse_texture_padding() {
		return (boolean) super.call("get_use_texture_padding", new java.lang.Object[0]);
	}

	public void setUse_texture_padding(boolean value) {
		super.call("set_use_texture_padding", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
