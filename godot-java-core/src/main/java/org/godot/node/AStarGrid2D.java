package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.core.RefCounted;
import org.godot.math.Rect2i;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class AStarGrid2D extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_diagonal_mode", 3129282674L), java.util.Map.entry("update", 3218959716L),
			java.util.Map.entry("get_default_compute_heuristic", 2074731422L),
			java.util.Map.entry("is_in_boundsv", 3900751641L), java.util.Map.entry("set_region", 1763793166L),
			java.util.Map.entry("get_cell_size", 3341600327L), java.util.Map.entry("is_in_bounds", 2522259332L),
			java.util.Map.entry("set_point_solid", 1765703753L),
			java.util.Map.entry("get_point_weight_scale", 719993801L),
			java.util.Map.entry("is_point_solid", 3900751641L), java.util.Map.entry("set_cell_shape", 4130591146L),
			java.util.Map.entry("get_size", 3690982128L), java.util.Map.entry("set_point_weight_scale", 2262553149L),
			java.util.Map.entry("set_cell_size", 743155724L),
			java.util.Map.entry("get_point_data_in_region", 3893818462L),
			java.util.Map.entry("get_offset", 3341600327L), java.util.Map.entry("set_size", 1130785943L),
			java.util.Map.entry("is_jumping_enabled", 36873697L),
			java.util.Map.entry("fill_weight_scale_region", 2793244083L),
			java.util.Map.entry("set_diagonal_mode", 1017829798L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("is_dirty", 36873697L), java.util.Map.entry("get_region", 410525958L),
			java.util.Map.entry("fill_solid_region", 2261970063L), java.util.Map.entry("get_id_path", 1918132273L),
			java.util.Map.entry("set_default_estimate_heuristic", 1044375519L),
			java.util.Map.entry("get_point_position", 108438297L),
			java.util.Map.entry("set_jumping_enabled", 2586408642L),
			java.util.Map.entry("set_default_compute_heuristic", 1044375519L),
			java.util.Map.entry("get_default_estimate_heuristic", 2074731422L),
			java.util.Map.entry("set_offset", 743155724L), java.util.Map.entry("get_cell_shape", 3293463634L),
			java.util.Map.entry("get_point_path", 1641925693L));

	AStarGrid2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AStarGrid2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_in_bounds(long x, long y) {
		return (boolean) super.call("is_in_bounds",
				new java.lang.Object[]{java.lang.Long.valueOf(x), java.lang.Long.valueOf(y)});
	}

	public boolean is_in_boundsv(Vector2i id) {
		return (boolean) super.call("is_in_boundsv", new java.lang.Object[]{(java.lang.Object) id});
	}

	public boolean is_dirty() {
		return (boolean) super.call("is_dirty");
	}

	public void update() {
		super.call("update");
	}

	public boolean is_jumping_enabled() {
		return (boolean) super.call("is_jumping_enabled");
	}

	public void set_point_solid(Vector2i id, boolean solid) {
		super.call("set_point_solid", new java.lang.Object[]{(java.lang.Object) id, java.lang.Boolean.valueOf(solid)});
	}

	public boolean is_point_solid(Vector2i id) {
		return (boolean) super.call("is_point_solid", new java.lang.Object[]{(java.lang.Object) id});
	}

	public void set_point_weight_scale(Vector2i id, double weight_scale) {
		super.call("set_point_weight_scale",
				new java.lang.Object[]{(java.lang.Object) id, java.lang.Double.valueOf(weight_scale)});
	}

	public double get_point_weight_scale(Vector2i id) {
		return (double) super.call("get_point_weight_scale", new java.lang.Object[]{(java.lang.Object) id});
	}

	public void fill_solid_region(Rect2i region, boolean solid) {
		super.call("fill_solid_region",
				new java.lang.Object[]{(java.lang.Object) region, java.lang.Boolean.valueOf(solid)});
	}

	public void fill_weight_scale_region(Rect2i region, double weight_scale) {
		super.call("fill_weight_scale_region",
				new java.lang.Object[]{(java.lang.Object) region, java.lang.Double.valueOf(weight_scale)});
	}

	public void clear() {
		super.call("clear");
	}

	public Vector2 get_point_position(Vector2i id) {
		return (Vector2) super.call("get_point_position", new java.lang.Object[]{(java.lang.Object) id});
	}

	public GodotDictionary[] get_point_data_in_region(Rect2i region) {
		return (GodotDictionary[]) super.call("get_point_data_in_region",
				new java.lang.Object[]{(java.lang.Object) region});
	}

	public double[][] get_point_path(Vector2i from_id, Vector2i to_id, boolean allow_partial_path) {
		return (double[][]) super.call("get_point_path", new java.lang.Object[]{(java.lang.Object) from_id,
				(java.lang.Object) to_id, java.lang.Boolean.valueOf(allow_partial_path)});
	}

	public Vector2i[] get_id_path(Vector2i from_id, Vector2i to_id, boolean allow_partial_path) {
		return (Vector2i[]) super.call("get_id_path", new java.lang.Object[]{(java.lang.Object) from_id,
				(java.lang.Object) to_id, java.lang.Boolean.valueOf(allow_partial_path)});
	}

	public Rect2i getRegion() {
		return (Rect2i) super.call("get_region", new java.lang.Object[0]);
	}

	public void setRegion(Rect2i value) {
		super.call("set_region", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2i getSize() {
		return (Vector2i) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector2i value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getOffset() {
		return (Vector2) super.call("get_offset", new java.lang.Object[0]);
	}

	public void setOffset(Vector2 value) {
		super.call("set_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getCell_size() {
		return (Vector2) super.call("get_cell_size", new java.lang.Object[0]);
	}

	public void setCell_size(Vector2 value) {
		super.call("set_cell_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getCell_shape() {
		return (long) super.call("get_cell_shape", new java.lang.Object[0]);
	}

	public void setCell_shape(long value) {
		super.call("set_cell_shape", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isJumping_enabled() {
		return (boolean) super.call("is_jumping_enabled", new java.lang.Object[0]);
	}

	public void setJumping_enabled(boolean value) {
		super.call("set_jumping_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getDefault_compute_heuristic() {
		return (long) super.call("get_default_compute_heuristic", new java.lang.Object[0]);
	}

	public void setDefault_compute_heuristic(long value) {
		super.call("set_default_compute_heuristic", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDefault_estimate_heuristic() {
		return (long) super.call("get_default_estimate_heuristic", new java.lang.Object[0]);
	}

	public void setDefault_estimate_heuristic(long value) {
		super.call("set_default_estimate_heuristic", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDiagonal_mode() {
		return (long) super.call("get_diagonal_mode", new java.lang.Object[0]);
	}

	public void setDiagonal_mode(long value) {
		super.call("set_diagonal_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
