package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.math.Color;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class TileData extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_collision_polygon_one_way", 2522259332L),
			java.util.Map.entry("set_navigation_polygon", 2224691167L),
			java.util.Map.entry("set_custom_data_by_layer_id", 2152698145L),
			java.util.Map.entry("set_flip_v", 2586408642L), java.util.Map.entry("set_transpose", 2586408642L),
			java.util.Map.entry("get_occluder_polygon", 971166743L), java.util.Map.entry("set_occluder", 914399637L),
			java.util.Map.entry("get_terrain_peering_bit", 3831796792L),
			java.util.Map.entry("get_y_sort_origin", 3905245786L), java.util.Map.entry("get_flip_v", 36873697L),
			java.util.Map.entry("set_texture_origin", 1130785943L),
			java.util.Map.entry("set_occluder_polygons_count", 3937882851L),
			java.util.Map.entry("set_terrain_set", 1286410249L), java.util.Map.entry("get_occluder", 2377324099L),
			java.util.Map.entry("get_collision_polygons_count", 923996154L),
			java.util.Map.entry("set_probability", 373806689L), java.util.Map.entry("get_flip_h", 36873697L),
			java.util.Map.entry("remove_collision_polygon", 3937882851L),
			java.util.Map.entry("get_constant_linear_velocity", 2299179447L),
			java.util.Map.entry("set_constant_angular_velocity", 1602489585L),
			java.util.Map.entry("set_flip_h", 2586408642L), java.util.Map.entry("set_terrain", 1286410249L),
			java.util.Map.entry("set_modulate", 2920490490L), java.util.Map.entry("set_custom_data", 402577236L),
			java.util.Map.entry("get_z_index", 3905245786L),
			java.util.Map.entry("get_collision_polygon_points", 103942801L),
			java.util.Map.entry("get_material", 5934680L),
			java.util.Map.entry("get_custom_data_by_layer_id", 4227898402L),
			java.util.Map.entry("get_collision_polygon_one_way_margin", 3085491603L),
			java.util.Map.entry("set_terrain_peering_bit", 1084452308L),
			java.util.Map.entry("set_collision_polygon_one_way", 1383440665L),
			java.util.Map.entry("set_collision_polygon_one_way_margin", 3506521499L),
			java.util.Map.entry("remove_occluder_polygon", 3937882851L),
			java.util.Map.entry("get_navigation_polygon", 2907127272L),
			java.util.Map.entry("set_y_sort_origin", 1286410249L),
			java.util.Map.entry("get_texture_origin", 3690982128L), java.util.Map.entry("get_custom_data", 1868160156L),
			java.util.Map.entry("set_collision_polygons_count", 3937882851L),
			java.util.Map.entry("is_valid_terrain_peering_bit", 845723972L),
			java.util.Map.entry("get_transpose", 36873697L),
			java.util.Map.entry("set_collision_polygon_points", 3230546541L),
			java.util.Map.entry("set_material", 2757459619L),
			java.util.Map.entry("get_occluder_polygons_count", 923996154L),
			java.util.Map.entry("set_z_index", 1286410249L),
			java.util.Map.entry("get_constant_angular_velocity", 2339986948L),
			java.util.Map.entry("has_custom_data", 3927539163L),
			java.util.Map.entry("add_collision_polygon", 1286410249L),
			java.util.Map.entry("get_probability", 1740695150L),
			java.util.Map.entry("add_occluder_polygon", 1286410249L),
			java.util.Map.entry("set_constant_linear_velocity", 163021252L),
			java.util.Map.entry("get_terrain", 3905245786L), java.util.Map.entry("set_occluder_polygon", 164249167L),
			java.util.Map.entry("get_modulate", 3444240500L), java.util.Map.entry("get_terrain_set", 3905245786L));

	TileData(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TileData(long nativePointer) {
		super(nativePointer);
	}

	public void set_occluder_polygons_count(long layer_id, long polygons_count) {
		super.call("set_occluder_polygons_count",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), java.lang.Long.valueOf(polygons_count)});
	}

	public int get_occluder_polygons_count(long layer_id) {
		return (int) super.call("get_occluder_polygons_count",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id)});
	}

	public void add_occluder_polygon(long layer_id) {
		super.call("add_occluder_polygon", new java.lang.Object[]{java.lang.Long.valueOf(layer_id)});
	}

	public void remove_occluder_polygon(long layer_id, long polygon_index) {
		super.call("remove_occluder_polygon",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), java.lang.Long.valueOf(polygon_index)});
	}

	public void set_occluder_polygon(long layer_id, long polygon_index, OccluderPolygon2D polygon) {
		super.call("set_occluder_polygon", new java.lang.Object[]{java.lang.Long.valueOf(layer_id),
				java.lang.Long.valueOf(polygon_index), (java.lang.Object) polygon});
	}

	public OccluderPolygon2D get_occluder_polygon(long layer_id, long polygon_index, boolean flip_h, boolean flip_v,
			boolean transpose) {
		return (OccluderPolygon2D) super.call("get_occluder_polygon",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), java.lang.Long.valueOf(polygon_index),
						java.lang.Boolean.valueOf(flip_h), java.lang.Boolean.valueOf(flip_v),
						java.lang.Boolean.valueOf(transpose)});
	}

	public void set_occluder(long layer_id, OccluderPolygon2D occluder_polygon) {
		super.call("set_occluder",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), (java.lang.Object) occluder_polygon});
	}

	public OccluderPolygon2D get_occluder(long layer_id, boolean flip_h, boolean flip_v, boolean transpose) {
		return (OccluderPolygon2D) super.call("get_occluder",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), java.lang.Boolean.valueOf(flip_h),
						java.lang.Boolean.valueOf(flip_v), java.lang.Boolean.valueOf(transpose)});
	}

	public void set_constant_linear_velocity(long layer_id, Vector2 velocity) {
		super.call("set_constant_linear_velocity",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), (java.lang.Object) velocity});
	}

	public Vector2 get_constant_linear_velocity(long layer_id) {
		return (Vector2) super.call("get_constant_linear_velocity",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id)});
	}

	public void set_constant_angular_velocity(long layer_id, double velocity) {
		super.call("set_constant_angular_velocity",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), java.lang.Double.valueOf(velocity)});
	}

	public double get_constant_angular_velocity(long layer_id) {
		return (double) super.call("get_constant_angular_velocity",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id)});
	}

	public void set_collision_polygons_count(long layer_id, long polygons_count) {
		super.call("set_collision_polygons_count",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), java.lang.Long.valueOf(polygons_count)});
	}

	public int get_collision_polygons_count(long layer_id) {
		return (int) super.call("get_collision_polygons_count",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id)});
	}

	public void add_collision_polygon(long layer_id) {
		super.call("add_collision_polygon", new java.lang.Object[]{java.lang.Long.valueOf(layer_id)});
	}

	public void remove_collision_polygon(long layer_id, long polygon_index) {
		super.call("remove_collision_polygon",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), java.lang.Long.valueOf(polygon_index)});
	}

	public void set_collision_polygon_points(long layer_id, long polygon_index, double[][] polygon) {
		super.call("set_collision_polygon_points", new java.lang.Object[]{java.lang.Long.valueOf(layer_id),
				java.lang.Long.valueOf(polygon_index), (java.lang.Object) polygon});
	}

	public double[][] get_collision_polygon_points(long layer_id, long polygon_index) {
		return (double[][]) super.call("get_collision_polygon_points",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), java.lang.Long.valueOf(polygon_index)});
	}

	public void set_collision_polygon_one_way(long layer_id, long polygon_index, boolean one_way) {
		super.call("set_collision_polygon_one_way", new java.lang.Object[]{java.lang.Long.valueOf(layer_id),
				java.lang.Long.valueOf(polygon_index), java.lang.Boolean.valueOf(one_way)});
	}

	public boolean is_collision_polygon_one_way(long layer_id, long polygon_index) {
		return (boolean) super.call("is_collision_polygon_one_way",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), java.lang.Long.valueOf(polygon_index)});
	}

	public void set_collision_polygon_one_way_margin(long layer_id, long polygon_index, double one_way_margin) {
		super.call("set_collision_polygon_one_way_margin", new java.lang.Object[]{java.lang.Long.valueOf(layer_id),
				java.lang.Long.valueOf(polygon_index), java.lang.Double.valueOf(one_way_margin)});
	}

	public double get_collision_polygon_one_way_margin(long layer_id, long polygon_index) {
		return (double) super.call("get_collision_polygon_one_way_margin",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), java.lang.Long.valueOf(polygon_index)});
	}

	public void set_terrain_peering_bit(int peering_bit, long terrain) {
		super.call("set_terrain_peering_bit",
				new java.lang.Object[]{java.lang.Integer.valueOf(peering_bit), java.lang.Long.valueOf(terrain)});
	}

	public int get_terrain_peering_bit(int peering_bit) {
		return (int) super.call("get_terrain_peering_bit",
				new java.lang.Object[]{java.lang.Integer.valueOf(peering_bit)});
	}

	public boolean is_valid_terrain_peering_bit(int peering_bit) {
		return (boolean) super.call("is_valid_terrain_peering_bit",
				new java.lang.Object[]{java.lang.Integer.valueOf(peering_bit)});
	}

	public void set_navigation_polygon(long layer_id, NavigationPolygon navigation_polygon) {
		super.call("set_navigation_polygon",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), (java.lang.Object) navigation_polygon});
	}

	public NavigationPolygon get_navigation_polygon(long layer_id, boolean flip_h, boolean flip_v, boolean transpose) {
		return (NavigationPolygon) super.call("get_navigation_polygon",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), java.lang.Boolean.valueOf(flip_h),
						java.lang.Boolean.valueOf(flip_v), java.lang.Boolean.valueOf(transpose)});
	}

	public void set_custom_data(String layer_name, Object value) {
		super.call("set_custom_data", new java.lang.Object[]{(java.lang.Object) layer_name, (java.lang.Object) value});
	}

	public Object get_custom_data(String layer_name) {
		return (Object) super.call("get_custom_data", new java.lang.Object[]{(java.lang.Object) layer_name});
	}

	public boolean has_custom_data(String layer_name) {
		return (boolean) super.call("has_custom_data", new java.lang.Object[]{(java.lang.Object) layer_name});
	}

	public void set_custom_data_by_layer_id(long layer_id, Object value) {
		super.call("set_custom_data_by_layer_id",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id), (java.lang.Object) value});
	}

	public Object get_custom_data_by_layer_id(long layer_id) {
		return (Object) super.call("get_custom_data_by_layer_id",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_id)});
	}

	public boolean getFlip_h() {
		return (boolean) super.call("get_flip_h", new java.lang.Object[0]);
	}

	public void setFlip_h(boolean value) {
		super.call("set_flip_h", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getFlip_v() {
		return (boolean) super.call("get_flip_v", new java.lang.Object[0]);
	}

	public void setFlip_v(boolean value) {
		super.call("set_flip_v", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getTranspose() {
		return (boolean) super.call("get_transpose", new java.lang.Object[0]);
	}

	public void setTranspose(boolean value) {
		super.call("set_transpose", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2i getTexture_origin() {
		return (Vector2i) super.call("get_texture_origin", new java.lang.Object[0]);
	}

	public void setTexture_origin(Vector2i value) {
		super.call("set_texture_origin", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getModulate() {
		return (Color) super.call("get_modulate", new java.lang.Object[0]);
	}

	public void setModulate(Color value) {
		super.call("set_modulate", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Object getMaterial() {
		return (Object) super.call("get_material", new java.lang.Object[0]);
	}

	public void setMaterial(Object value) {
		super.call("set_material", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getZ_index() {
		return (long) super.call("get_z_index", new java.lang.Object[0]);
	}

	public void setZ_index(long value) {
		super.call("set_z_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getY_sort_origin() {
		return (long) super.call("get_y_sort_origin", new java.lang.Object[0]);
	}

	public void setY_sort_origin(long value) {
		super.call("set_y_sort_origin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTerrain_set() {
		return (long) super.call("get_terrain_set", new java.lang.Object[0]);
	}

	public void setTerrain_set(long value) {
		super.call("set_terrain_set", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTerrain() {
		return (long) super.call("get_terrain", new java.lang.Object[0]);
	}

	public void setTerrain(long value) {
		super.call("set_terrain", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getProbability() {
		return (double) super.call("get_probability", new java.lang.Object[0]);
	}

	public void setProbability(double value) {
		super.call("set_probability", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
