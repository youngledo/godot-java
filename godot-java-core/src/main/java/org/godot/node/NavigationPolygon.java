package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.math.Rect2;
import org.godot.math.Vector2;

public class NavigationPolygon extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_baking_rect", 2046264180L), java.util.Map.entry("set_vertices", 1509147220L),
			java.util.Map.entry("get_outline", 3946907486L),
			java.util.Map.entry("set_parsed_collision_mask", 1286410249L),
			java.util.Map.entry("get_polygon", 3668444399L), java.util.Map.entry("get_outline_count", 3905245786L),
			java.util.Map.entry("get_source_geometry_group_name", 2002593661L),
			java.util.Map.entry("get_agent_radius", 1740695150L), java.util.Map.entry("get_baking_rect", 1639390495L),
			java.util.Map.entry("get_cell_size", 1740695150L),
			java.util.Map.entry("set_sample_partition_type", 2441478482L),
			java.util.Map.entry("add_outline", 1509147220L),
			java.util.Map.entry("get_source_geometry_mode", 459686762L),
			java.util.Map.entry("get_parsed_collision_mask_value", 1116898809L),
			java.util.Map.entry("get_vertices", 2961356807L), java.util.Map.entry("set_cell_size", 373806689L),
			java.util.Map.entry("get_baking_rect_offset", 3341600327L),
			java.util.Map.entry("get_polygon_count", 3905245786L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("set_border_size", 373806689L),
			java.util.Map.entry("set_source_geometry_mode", 4002316705L),
			java.util.Map.entry("get_sample_partition_type", 3887422851L),
			java.util.Map.entry("set_parsed_collision_mask_value", 300928843L),
			java.util.Map.entry("add_polygon", 3614634198L), java.util.Map.entry("set_baking_rect_offset", 743155724L),
			java.util.Map.entry("add_outline_at_index", 1569738947L), java.util.Map.entry("set_outline", 1201971903L),
			java.util.Map.entry("clear_polygons", 3218959716L),
			java.util.Map.entry("get_parsed_geometry_type", 1073219508L),
			java.util.Map.entry("get_parsed_collision_mask", 3905245786L),
			java.util.Map.entry("clear_outlines", 3218959716L),
			java.util.Map.entry("set_source_geometry_group_name", 3304788590L),
			java.util.Map.entry("get_navigation_mesh", 330232164L), java.util.Map.entry("set_agent_radius", 373806689L),
			java.util.Map.entry("remove_outline", 1286410249L),
			java.util.Map.entry("make_polygons_from_outlines", 3218959716L),
			java.util.Map.entry("get_border_size", 1740695150L),
			java.util.Map.entry("set_parsed_geometry_type", 2507971764L));

	NavigationPolygon(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationPolygon(long nativePointer) {
		super(nativePointer);
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

	public void add_outline(double[][] outline) {
		super.call("add_outline", new java.lang.Object[]{(java.lang.Object) outline});
	}

	public void add_outline_at_index(double[][] outline, long index) {
		super.call("add_outline_at_index",
				new java.lang.Object[]{(java.lang.Object) outline, java.lang.Long.valueOf(index)});
	}

	public void set_outline(long idx, double[][] outline) {
		super.call("set_outline", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) outline});
	}

	public double[][] get_outline(long idx) {
		return (double[][]) super.call("get_outline", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void remove_outline(long idx) {
		super.call("remove_outline", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void clear_outlines() {
		super.call("clear_outlines");
	}

	public void make_polygons_from_outlines() {
		super.call("make_polygons_from_outlines");
	}

	public void set_parsed_collision_mask_value(long layer_number, boolean value) {
		super.call("set_parsed_collision_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_parsed_collision_mask_value(long layer_number) {
		return (boolean) super.call("get_parsed_collision_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
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

	public GodotArray getOutlines() {
		return (GodotArray) super.call("_get_outlines", new java.lang.Object[0]);
	}

	public void setOutlines(GodotArray value) {
		super.call("_set_outlines", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSample_partition_type() {
		return (long) super.call("get_sample_partition_type", new java.lang.Object[0]);
	}

	public void setSample_partition_type(long value) {
		super.call("set_sample_partition_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getParsed_geometry_type() {
		return (long) super.call("get_parsed_geometry_type", new java.lang.Object[0]);
	}

	public void setParsed_geometry_type(long value) {
		super.call("set_parsed_geometry_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getParsed_collision_mask() {
		return (long) super.call("get_parsed_collision_mask", new java.lang.Object[0]);
	}

	public void setParsed_collision_mask(long value) {
		super.call("set_parsed_collision_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSource_geometry_mode() {
		return (long) super.call("get_source_geometry_mode", new java.lang.Object[0]);
	}

	public void setSource_geometry_mode(long value) {
		super.call("set_source_geometry_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getSource_geometry_group_name() {
		return (String) super.call("get_source_geometry_group_name", new java.lang.Object[0]);
	}

	public void setSource_geometry_group_name(String value) {
		super.call("set_source_geometry_group_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getCell_size() {
		return (double) super.call("get_cell_size", new java.lang.Object[0]);
	}

	public void setCell_size(double value) {
		super.call("set_cell_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getBorder_size() {
		return (double) super.call("get_border_size", new java.lang.Object[0]);
	}

	public void setBorder_size(double value) {
		super.call("set_border_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAgent_radius() {
		return (double) super.call("get_agent_radius", new java.lang.Object[0]);
	}

	public void setAgent_radius(double value) {
		super.call("set_agent_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Rect2 getBaking_rect() {
		return (Rect2) super.call("get_baking_rect", new java.lang.Object[0]);
	}

	public void setBaking_rect(Rect2 value) {
		super.call("set_baking_rect", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getBaking_rect_offset() {
		return (Vector2) super.call("get_baking_rect_offset", new java.lang.Object[0]);
	}

	public void setBaking_rect_offset(Vector2 value) {
		super.call("set_baking_rect_offset", new java.lang.Object[]{(java.lang.Object) value});
	}
}
