package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class TileSetScenesCollectionSource extends TileSetSource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_scene_tile_display_placeholder", 1116898809L),
			java.util.Map.entry("set_scene_tile_id", 3937882851L),
			java.util.Map.entry("create_scene_tile", 1117465415L),
			java.util.Map.entry("set_scene_tile_scene", 3435852839L),
			java.util.Map.entry("get_scene_tile_id", 3744713108L),
			java.util.Map.entry("remove_scene_tile", 1286410249L),
			java.util.Map.entry("has_scene_tile_id", 3067735520L),
			java.util.Map.entry("set_scene_tile_display_placeholder", 300928843L),
			java.util.Map.entry("get_next_scene_tile_id", 3905245786L),
			java.util.Map.entry("get_scene_tiles_count", 2455072627L),
			java.util.Map.entry("get_scene_tile_scene", 511017218L));

	TileSetScenesCollectionSource(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TileSetScenesCollectionSource(long nativePointer) {
		super(nativePointer);
	}

	public int get_scene_tile_id(long index) {
		return (int) super.call("get_scene_tile_id", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean has_scene_tile_id(long id) {
		return (boolean) super.call("has_scene_tile_id", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public int create_scene_tile(PackedScene packed_scene, long id_override) {
		return (int) super.call("create_scene_tile",
				new java.lang.Object[]{(java.lang.Object) packed_scene, java.lang.Long.valueOf(id_override)});
	}

	public void set_scene_tile_id(long id, long new_id) {
		super.call("set_scene_tile_id",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(new_id)});
	}

	public void set_scene_tile_scene(long id, PackedScene packed_scene) {
		super.call("set_scene_tile_scene",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) packed_scene});
	}

	public PackedScene get_scene_tile_scene(long id) {
		return (PackedScene) super.call("get_scene_tile_scene", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void set_scene_tile_display_placeholder(long id, boolean display_placeholder) {
		super.call("set_scene_tile_display_placeholder",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(display_placeholder)});
	}

	public boolean get_scene_tile_display_placeholder(long id) {
		return (boolean) super.call("get_scene_tile_display_placeholder",
				new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void remove_scene_tile(long id) {
		super.call("remove_scene_tile", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}
}
