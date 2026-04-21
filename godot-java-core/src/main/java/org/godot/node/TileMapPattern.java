package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2i;

public class TileMapPattern extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_size", 1130785943L), java.util.Map.entry("remove_cell", 4153096796L),
			java.util.Map.entry("get_used_cells", 3995934104L), java.util.Map.entry("set_cell", 2224802556L),
			java.util.Map.entry("has_cell", 3900751641L), java.util.Map.entry("get_cell_alternative_tile", 2485466453L),
			java.util.Map.entry("get_size", 3690982128L), java.util.Map.entry("get_cell_atlas_coords", 3050897911L),
			java.util.Map.entry("is_empty", 36873697L), java.util.Map.entry("get_cell_source_id", 2485466453L));

	TileMapPattern(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TileMapPattern(long nativePointer) {
		super(nativePointer);
	}

	public void set_cell(Vector2i coords, long source_id, Vector2i atlas_coords, long alternative_tile) {
		super.call("set_cell", new java.lang.Object[]{(java.lang.Object) coords, java.lang.Long.valueOf(source_id),
				(java.lang.Object) atlas_coords, java.lang.Long.valueOf(alternative_tile)});
	}

	public boolean has_cell(Vector2i coords) {
		return (boolean) super.call("has_cell", new java.lang.Object[]{(java.lang.Object) coords});
	}

	public void remove_cell(Vector2i coords, boolean update_size) {
		super.call("remove_cell",
				new java.lang.Object[]{(java.lang.Object) coords, java.lang.Boolean.valueOf(update_size)});
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

	public boolean is_empty() {
		return (boolean) super.call("is_empty");
	}
}
