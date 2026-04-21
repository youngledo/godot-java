package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2i;

public class TileSetSource extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_tile_id", 880721226L), java.util.Map.entry("get_alternative_tile_id", 89881719L),
			java.util.Map.entry("get_tiles_count", 3905245786L), java.util.Map.entry("has_tile", 3900751641L),
			java.util.Map.entry("has_alternative_tile", 1073731340L),
			java.util.Map.entry("get_alternative_tiles_count", 2485466453L));

	TileSetSource(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TileSetSource(long nativePointer) {
		super(nativePointer);
	}

	public Vector2i get_tile_id(long index) {
		return (Vector2i) super.call("get_tile_id", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean has_tile(Vector2i atlas_coords) {
		return (boolean) super.call("has_tile", new java.lang.Object[]{(java.lang.Object) atlas_coords});
	}

	public int get_alternative_tiles_count(Vector2i atlas_coords) {
		return (int) super.call("get_alternative_tiles_count", new java.lang.Object[]{(java.lang.Object) atlas_coords});
	}

	public int get_alternative_tile_id(Vector2i atlas_coords, long index) {
		return (int) super.call("get_alternative_tile_id",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, java.lang.Long.valueOf(index)});
	}

	public boolean has_alternative_tile(Vector2i atlas_coords, long alternative_tile) {
		return (boolean) super.call("has_alternative_tile",
				new java.lang.Object[]{(java.lang.Object) atlas_coords, java.lang.Long.valueOf(alternative_tile)});
	}
}
