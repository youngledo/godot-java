package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector2;

public class NavigationAgent2D extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_avoidance_mask", 1286410249L),
			java.util.Map.entry("set_path_metadata_flags", 24274129L),
			java.util.Map.entry("get_debug_enabled", 36873697L),
			java.util.Map.entry("set_path_desired_distance", 373806689L),
			java.util.Map.entry("get_time_horizon_agents", 1740695150L), java.util.Map.entry("get_radius", 1740695150L),
			java.util.Map.entry("get_debug_path_custom_point_size", 1740695150L),
			java.util.Map.entry("set_radius", 373806689L), java.util.Map.entry("get_debug_use_custom", 36873697L),
			java.util.Map.entry("get_path_search_max_polygons", 3905245786L),
			java.util.Map.entry("is_target_reached", 36873697L),
			java.util.Map.entry("get_debug_path_custom_color", 3444240500L),
			java.util.Map.entry("get_debug_path_custom_line_width", 1740695150L),
			java.util.Map.entry("set_path_search_max_distance", 373806689L),
			java.util.Map.entry("is_target_reachable", 2240911060L),
			java.util.Map.entry("is_navigation_finished", 2240911060L),
			java.util.Map.entry("get_pathfinding_algorithm", 3000421146L),
			java.util.Map.entry("get_avoidance_layers", 3905245786L),
			java.util.Map.entry("get_final_position", 1497962370L),
			java.util.Map.entry("get_avoidance_enabled", 36873697L),
			java.util.Map.entry("get_path_length", 1740695150L),
			java.util.Map.entry("set_avoidance_mask_value", 300928843L),
			java.util.Map.entry("set_debug_enabled", 2586408642L),
			java.util.Map.entry("set_path_return_max_radius", 373806689L),
			java.util.Map.entry("get_path_return_max_radius", 1740695150L), java.util.Map.entry("get_rid", 2944877500L),
			java.util.Map.entry("set_avoidance_layer_value", 300928843L),
			java.util.Map.entry("get_velocity", 1497962370L),
			java.util.Map.entry("get_avoidance_priority", 1740695150L),
			java.util.Map.entry("get_max_speed", 1740695150L),
			java.util.Map.entry("get_current_navigation_result", 166799483L),
			java.util.Map.entry("set_time_horizon_obstacles", 373806689L),
			java.util.Map.entry("get_navigation_layer_value", 1116898809L),
			java.util.Map.entry("distance_to_target", 1740695150L),
			java.util.Map.entry("set_debug_use_custom", 2586408642L),
			java.util.Map.entry("get_navigation_layers", 3905245786L),
			java.util.Map.entry("get_avoidance_mask_value", 1116898809L),
			java.util.Map.entry("get_avoidance_mask", 3905245786L),
			java.util.Map.entry("set_pathfinding_algorithm", 2783519915L),
			java.util.Map.entry("set_path_return_max_length", 373806689L),
			java.util.Map.entry("get_path_desired_distance", 1740695150L),
			java.util.Map.entry("set_time_horizon_agents", 373806689L),
			java.util.Map.entry("get_neighbor_distance", 1740695150L),
			java.util.Map.entry("get_navigation_map", 2944877500L),
			java.util.Map.entry("set_target_position", 743155724L),
			java.util.Map.entry("set_avoidance_layers", 1286410249L),
			java.util.Map.entry("set_avoidance_enabled", 2586408642L),
			java.util.Map.entry("get_simplify_path", 36873697L),
			java.util.Map.entry("set_simplify_epsilon", 373806689L),
			java.util.Map.entry("get_path_metadata_flags", 488152976L),
			java.util.Map.entry("get_current_navigation_path", 2961356807L),
			java.util.Map.entry("set_simplify_path", 2586408642L),
			java.util.Map.entry("get_time_horizon_obstacles", 1740695150L),
			java.util.Map.entry("set_max_speed", 373806689L),
			java.util.Map.entry("get_next_path_position", 1497962370L),
			java.util.Map.entry("set_neighbor_distance", 373806689L),
			java.util.Map.entry("get_target_position", 3341600327L),
			java.util.Map.entry("get_simplify_epsilon", 1740695150L),
			java.util.Map.entry("get_path_postprocessing", 3798118993L),
			java.util.Map.entry("get_path_search_max_distance", 1740695150L),
			java.util.Map.entry("set_path_max_distance", 373806689L),
			java.util.Map.entry("set_navigation_layer_value", 300928843L),
			java.util.Map.entry("get_avoidance_layer_value", 1116898809L),
			java.util.Map.entry("set_debug_path_custom_point_size", 373806689L),
			java.util.Map.entry("set_debug_path_custom_line_width", 373806689L),
			java.util.Map.entry("set_path_postprocessing", 2864409082L),
			java.util.Map.entry("get_path_max_distance", 191475506L),
			java.util.Map.entry("set_navigation_map", 2722037293L),
			java.util.Map.entry("set_target_desired_distance", 373806689L),
			java.util.Map.entry("get_target_desired_distance", 1740695150L),
			java.util.Map.entry("set_path_search_max_polygons", 1286410249L),
			java.util.Map.entry("set_velocity_forced", 743155724L), java.util.Map.entry("set_velocity", 743155724L),
			java.util.Map.entry("set_max_neighbors", 1286410249L),
			java.util.Map.entry("set_navigation_layers", 1286410249L),
			java.util.Map.entry("get_path_return_max_length", 1740695150L),
			java.util.Map.entry("get_current_navigation_path_index", 3905245786L),
			java.util.Map.entry("get_max_neighbors", 3905245786L),
			java.util.Map.entry("set_avoidance_priority", 373806689L),
			java.util.Map.entry("set_debug_path_custom_color", 2920490490L));

	NavigationAgent2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationAgent2D(long nativePointer) {
		super(nativePointer);
	}

	public void set_navigation_layer_value(long layer_number, boolean value) {
		super.call("set_navigation_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_navigation_layer_value(long layer_number) {
		return (boolean) super.call("get_navigation_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public double distance_to_target() {
		return (double) super.call("distance_to_target");
	}

	public boolean is_target_reached() {
		return (boolean) super.call("is_target_reached");
	}

	public boolean is_target_reachable() {
		return (boolean) super.call("is_target_reachable");
	}

	public boolean is_navigation_finished() {
		return (boolean) super.call("is_navigation_finished");
	}

	public void set_avoidance_layer_value(long layer_number, boolean value) {
		super.call("set_avoidance_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_avoidance_layer_value(long layer_number) {
		return (boolean) super.call("get_avoidance_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public void set_avoidance_mask_value(long mask_number, boolean value) {
		super.call("set_avoidance_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(mask_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_avoidance_mask_value(long mask_number) {
		return (boolean) super.call("get_avoidance_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(mask_number)});
	}

	public Vector2 getTarget_position() {
		return (Vector2) super.call("get_target_position", new java.lang.Object[0]);
	}

	public void setTarget_position(Vector2 value) {
		super.call("set_target_position", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getPath_desired_distance() {
		return (double) super.call("get_path_desired_distance", new java.lang.Object[0]);
	}

	public void setPath_desired_distance(double value) {
		super.call("set_path_desired_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTarget_desired_distance() {
		return (double) super.call("get_target_desired_distance", new java.lang.Object[0]);
	}

	public void setTarget_desired_distance(double value) {
		super.call("set_target_desired_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPath_max_distance() {
		return (double) super.call("get_path_max_distance", new java.lang.Object[0]);
	}

	public void setPath_max_distance(double value) {
		super.call("set_path_max_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getNavigation_layers() {
		return (long) super.call("get_navigation_layers", new java.lang.Object[0]);
	}

	public void setNavigation_layers(long value) {
		super.call("set_navigation_layers", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPathfinding_algorithm() {
		return (long) super.call("get_pathfinding_algorithm", new java.lang.Object[0]);
	}

	public void setPathfinding_algorithm(long value) {
		super.call("set_pathfinding_algorithm", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPath_postprocessing() {
		return (long) super.call("get_path_postprocessing", new java.lang.Object[0]);
	}

	public void setPath_postprocessing(long value) {
		super.call("set_path_postprocessing", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPath_metadata_flags() {
		return (long) super.call("get_path_metadata_flags", new java.lang.Object[0]);
	}

	public void setPath_metadata_flags(long value) {
		super.call("set_path_metadata_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getSimplify_path() {
		return (boolean) super.call("get_simplify_path", new java.lang.Object[0]);
	}

	public void setSimplify_path(boolean value) {
		super.call("set_simplify_path", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getSimplify_epsilon() {
		return (double) super.call("get_simplify_epsilon", new java.lang.Object[0]);
	}

	public void setSimplify_epsilon(double value) {
		super.call("set_simplify_epsilon", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPath_return_max_length() {
		return (double) super.call("get_path_return_max_length", new java.lang.Object[0]);
	}

	public void setPath_return_max_length(double value) {
		super.call("set_path_return_max_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPath_return_max_radius() {
		return (double) super.call("get_path_return_max_radius", new java.lang.Object[0]);
	}

	public void setPath_return_max_radius(double value) {
		super.call("set_path_return_max_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getPath_search_max_polygons() {
		return (long) super.call("get_path_search_max_polygons", new java.lang.Object[0]);
	}

	public void setPath_search_max_polygons(long value) {
		super.call("set_path_search_max_polygons", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getPath_search_max_distance() {
		return (double) super.call("get_path_search_max_distance", new java.lang.Object[0]);
	}

	public void setPath_search_max_distance(double value) {
		super.call("set_path_search_max_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getAvoidance_enabled() {
		return (boolean) super.call("get_avoidance_enabled", new java.lang.Object[0]);
	}

	public void setAvoidance_enabled(boolean value) {
		super.call("set_avoidance_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getVelocity() {
		return (Vector2) super.call("get_velocity", new java.lang.Object[0]);
	}

	public void setVelocity(Vector2 value) {
		super.call("set_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getRadius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setRadius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getNeighbor_distance() {
		return (double) super.call("get_neighbor_distance", new java.lang.Object[0]);
	}

	public void setNeighbor_distance(double value) {
		super.call("set_neighbor_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getMax_neighbors() {
		return (long) super.call("get_max_neighbors", new java.lang.Object[0]);
	}

	public void setMax_neighbors(long value) {
		super.call("set_max_neighbors", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getTime_horizon_agents() {
		return (double) super.call("get_time_horizon_agents", new java.lang.Object[0]);
	}

	public void setTime_horizon_agents(double value) {
		super.call("set_time_horizon_agents", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTime_horizon_obstacles() {
		return (double) super.call("get_time_horizon_obstacles", new java.lang.Object[0]);
	}

	public void setTime_horizon_obstacles(double value) {
		super.call("set_time_horizon_obstacles", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMax_speed() {
		return (double) super.call("get_max_speed", new java.lang.Object[0]);
	}

	public void setMax_speed(double value) {
		super.call("set_max_speed", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getAvoidance_layers() {
		return (long) super.call("get_avoidance_layers", new java.lang.Object[0]);
	}

	public void setAvoidance_layers(long value) {
		super.call("set_avoidance_layers", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getAvoidance_mask() {
		return (long) super.call("get_avoidance_mask", new java.lang.Object[0]);
	}

	public void setAvoidance_mask(long value) {
		super.call("set_avoidance_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getAvoidance_priority() {
		return (double) super.call("get_avoidance_priority", new java.lang.Object[0]);
	}

	public void setAvoidance_priority(double value) {
		super.call("set_avoidance_priority", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getDebug_enabled() {
		return (boolean) super.call("get_debug_enabled", new java.lang.Object[0]);
	}

	public void setDebug_enabled(boolean value) {
		super.call("set_debug_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDebug_use_custom() {
		return (boolean) super.call("get_debug_use_custom", new java.lang.Object[0]);
	}

	public void setDebug_use_custom(boolean value) {
		super.call("set_debug_use_custom", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getDebug_path_custom_color() {
		return (Color) super.call("get_debug_path_custom_color", new java.lang.Object[0]);
	}

	public void setDebug_path_custom_color(Color value) {
		super.call("set_debug_path_custom_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getDebug_path_custom_point_size() {
		return (double) super.call("get_debug_path_custom_point_size", new java.lang.Object[0]);
	}

	public void setDebug_path_custom_point_size(double value) {
		super.call("set_debug_path_custom_point_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDebug_path_custom_line_width() {
		return (double) super.call("get_debug_path_custom_line_width", new java.lang.Object[0]);
	}

	public void setDebug_path_custom_line_width(double value) {
		super.call("set_debug_path_custom_line_width", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
