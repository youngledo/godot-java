package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.math.AABB;
import org.godot.math.Vector3;

public class NavigationMesh extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_agent_max_slope", 373806689L), java.util.Map.entry("set_cell_height", 373806689L),
			java.util.Map.entry("get_region_merge_size", 1740695150L), java.util.Map.entry("get_polygon", 3668444399L),
			java.util.Map.entry("get_collision_mask", 3905245786L),
			java.util.Map.entry("get_filter_low_hanging_obstacles", 36873697L),
			java.util.Map.entry("set_edge_max_error", 373806689L),
			java.util.Map.entry("set_collision_mask", 1286410249L),
			java.util.Map.entry("get_filter_ledge_spans", 36873697L),
			java.util.Map.entry("get_source_geometry_mode", 2770484141L),
			java.util.Map.entry("set_detail_sample_max_error", 373806689L),
			java.util.Map.entry("set_filter_baking_aabb_offset", 3460891852L),
			java.util.Map.entry("set_agent_max_climb", 373806689L),
			java.util.Map.entry("get_collision_mask_value", 1116898809L),
			java.util.Map.entry("get_source_group_name", 2002593661L),
			java.util.Map.entry("get_polygon_count", 3905245786L), java.util.Map.entry("set_border_size", 373806689L),
			java.util.Map.entry("get_edge_max_length", 1740695150L),
			java.util.Map.entry("set_filter_baking_aabb", 259215842L),
			java.util.Map.entry("get_agent_height", 1740695150L),
			java.util.Map.entry("set_vertices_per_polygon", 373806689L),
			java.util.Map.entry("set_agent_radius", 373806689L),
			java.util.Map.entry("get_filter_walkable_low_height_spans", 36873697L),
			java.util.Map.entry("get_cell_height", 1740695150L),
			java.util.Map.entry("get_vertices_per_polygon", 1740695150L),
			java.util.Map.entry("set_collision_mask_value", 300928843L),
			java.util.Map.entry("get_region_min_size", 1740695150L),
			java.util.Map.entry("set_agent_height", 373806689L),
			java.util.Map.entry("set_filter_low_hanging_obstacles", 2586408642L),
			java.util.Map.entry("get_filter_baking_aabb", 1068685055L), java.util.Map.entry("set_vertices", 334873810L),
			java.util.Map.entry("get_filter_baking_aabb_offset", 3360562783L),
			java.util.Map.entry("get_agent_radius", 191475506L), java.util.Map.entry("get_cell_size", 1740695150L),
			java.util.Map.entry("set_filter_ledge_spans", 2586408642L),
			java.util.Map.entry("set_region_min_size", 373806689L),
			java.util.Map.entry("set_sample_partition_type", 2472437533L),
			java.util.Map.entry("get_edge_max_error", 1740695150L), java.util.Map.entry("create_from_mesh", 194775623L),
			java.util.Map.entry("set_edge_max_length", 373806689L),
			java.util.Map.entry("get_agent_max_climb", 1740695150L),
			java.util.Map.entry("set_filter_walkable_low_height_spans", 2586408642L),
			java.util.Map.entry("get_detail_sample_distance", 1740695150L),
			java.util.Map.entry("set_source_group_name", 3304788590L), java.util.Map.entry("get_vertices", 497664490L),
			java.util.Map.entry("set_cell_size", 373806689L), java.util.Map.entry("set_region_merge_size", 373806689L),
			java.util.Map.entry("clear", 3218959716L), java.util.Map.entry("set_source_geometry_mode", 2700825194L),
			java.util.Map.entry("get_sample_partition_type", 833513918L),
			java.util.Map.entry("add_polygon", 3614634198L), java.util.Map.entry("get_agent_max_slope", 1740695150L),
			java.util.Map.entry("get_parsed_geometry_type", 3928011953L),
			java.util.Map.entry("clear_polygons", 3218959716L),
			java.util.Map.entry("get_detail_sample_max_error", 1740695150L),
			java.util.Map.entry("set_detail_sample_distance", 373806689L),
			java.util.Map.entry("get_border_size", 1740695150L),
			java.util.Map.entry("set_parsed_geometry_type", 3064713163L));

	NavigationMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationMesh(long nativePointer) {
		super(nativePointer);
	}

	public void set_collision_mask_value(long layer_number, boolean value) {
		super.call("set_collision_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_collision_mask_value(long layer_number) {
		return (boolean) super.call("get_collision_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public void add_polygon(int[] polygon) {
		super.call("add_polygon", new java.lang.Object[]{(java.lang.Object) polygon});
	}

	public int[] get_polygon(long idx) {
		return (int[]) super.call("get_polygon", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void clear_polygons() {
		super.call("clear_polygons");
	}

	public void create_from_mesh(Mesh mesh) {
		super.call("create_from_mesh", new java.lang.Object[]{(java.lang.Object) mesh});
	}

	public void clear() {
		super.call("clear");
	}

	public double[][] getVertices() {
		return (double[][]) super.call("get_vertices", new java.lang.Object[0]);
	}

	public void setVertices(double[][] value) {
		super.call("set_vertices", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getPolygons() {
		return (GodotArray) super.call("_get_polygons", new java.lang.Object[0]);
	}

	public void setPolygons(GodotArray value) {
		super.call("_set_polygons", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSample_partition_type() {
		return (long) super.call("get_sample_partition_type", new java.lang.Object[0]);
	}

	public void setSample_partition_type(long value) {
		super.call("set_sample_partition_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getGeometry_parsed_geometry_type() {
		return (long) super.call("get_parsed_geometry_type", new java.lang.Object[0]);
	}

	public void setGeometry_parsed_geometry_type(long value) {
		super.call("set_parsed_geometry_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getGeometry_collision_mask() {
		return (long) super.call("get_collision_mask", new java.lang.Object[0]);
	}

	public void setGeometry_collision_mask(long value) {
		super.call("set_collision_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getGeometry_source_geometry_mode() {
		return (long) super.call("get_source_geometry_mode", new java.lang.Object[0]);
	}

	public void setGeometry_source_geometry_mode(long value) {
		super.call("set_source_geometry_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getGeometry_source_group_name() {
		return (String) super.call("get_source_group_name", new java.lang.Object[0]);
	}

	public void setGeometry_source_group_name(String value) {
		super.call("set_source_group_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getCell_size() {
		return (double) super.call("get_cell_size", new java.lang.Object[0]);
	}

	public void setCell_size(double value) {
		super.call("set_cell_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getCell_height() {
		return (double) super.call("get_cell_height", new java.lang.Object[0]);
	}

	public void setCell_height(double value) {
		super.call("set_cell_height", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getBorder_size() {
		return (double) super.call("get_border_size", new java.lang.Object[0]);
	}

	public void setBorder_size(double value) {
		super.call("set_border_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAgent_height() {
		return (double) super.call("get_agent_height", new java.lang.Object[0]);
	}

	public void setAgent_height(double value) {
		super.call("set_agent_height", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAgent_radius() {
		return (double) super.call("get_agent_radius", new java.lang.Object[0]);
	}

	public void setAgent_radius(double value) {
		super.call("set_agent_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAgent_max_climb() {
		return (double) super.call("get_agent_max_climb", new java.lang.Object[0]);
	}

	public void setAgent_max_climb(double value) {
		super.call("set_agent_max_climb", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAgent_max_slope() {
		return (double) super.call("get_agent_max_slope", new java.lang.Object[0]);
	}

	public void setAgent_max_slope(double value) {
		super.call("set_agent_max_slope", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRegion_min_size() {
		return (double) super.call("get_region_min_size", new java.lang.Object[0]);
	}

	public void setRegion_min_size(double value) {
		super.call("set_region_min_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRegion_merge_size() {
		return (double) super.call("get_region_merge_size", new java.lang.Object[0]);
	}

	public void setRegion_merge_size(double value) {
		super.call("set_region_merge_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getEdge_max_length() {
		return (double) super.call("get_edge_max_length", new java.lang.Object[0]);
	}

	public void setEdge_max_length(double value) {
		super.call("set_edge_max_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getEdge_max_error() {
		return (double) super.call("get_edge_max_error", new java.lang.Object[0]);
	}

	public void setEdge_max_error(double value) {
		super.call("set_edge_max_error", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVertices_per_polygon() {
		return (double) super.call("get_vertices_per_polygon", new java.lang.Object[0]);
	}

	public void setVertices_per_polygon(double value) {
		super.call("set_vertices_per_polygon", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDetail_sample_distance() {
		return (double) super.call("get_detail_sample_distance", new java.lang.Object[0]);
	}

	public void setDetail_sample_distance(double value) {
		super.call("set_detail_sample_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDetail_sample_max_error() {
		return (double) super.call("get_detail_sample_max_error", new java.lang.Object[0]);
	}

	public void setDetail_sample_max_error(double value) {
		super.call("set_detail_sample_max_error", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getFilter_low_hanging_obstacles() {
		return (boolean) super.call("get_filter_low_hanging_obstacles", new java.lang.Object[0]);
	}

	public void setFilter_low_hanging_obstacles(boolean value) {
		super.call("set_filter_low_hanging_obstacles", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getFilter_ledge_spans() {
		return (boolean) super.call("get_filter_ledge_spans", new java.lang.Object[0]);
	}

	public void setFilter_ledge_spans(boolean value) {
		super.call("set_filter_ledge_spans", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getFilter_walkable_low_height_spans() {
		return (boolean) super.call("get_filter_walkable_low_height_spans", new java.lang.Object[0]);
	}

	public void setFilter_walkable_low_height_spans(boolean value) {
		super.call("set_filter_walkable_low_height_spans", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public AABB getFilter_baking_aabb() {
		return (AABB) super.call("get_filter_baking_aabb", new java.lang.Object[0]);
	}

	public void setFilter_baking_aabb(AABB value) {
		super.call("set_filter_baking_aabb", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getFilter_baking_aabb_offset() {
		return (Vector3) super.call("get_filter_baking_aabb_offset", new java.lang.Object[0]);
	}

	public void setFilter_baking_aabb_offset(Vector3 value) {
		super.call("set_filter_baking_aabb_offset", new java.lang.Object[]{(java.lang.Object) value});
	}
}
