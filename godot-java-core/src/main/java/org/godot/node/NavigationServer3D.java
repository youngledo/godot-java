package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.core.Callable;
import org.godot.math.AABB;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class NavigationServer3D extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("region_get_connections_count", 2198884583L),
			java.util.Map.entry("get_debug_enabled", 36873697L),
			java.util.Map.entry("map_get_edge_connection_margin", 866169185L),
			java.util.Map.entry("map_get_random_point", 722801526L),
			java.util.Map.entry("region_get_closest_point_normal", 2056183332L),
			java.util.Map.entry("link_is_bidirectional", 4155700596L), java.util.Map.entry("agent_set_map", 395945892L),
			java.util.Map.entry("obstacle_get_vertices", 808965560L),
			java.util.Map.entry("obstacle_set_use_3d_avoidance", 1265174801L),
			java.util.Map.entry("map_get_cell_height", 866169185L),
			java.util.Map.entry("map_get_use_edge_connections", 4155700596L),
			java.util.Map.entry("region_set_navigation_mesh", 2764952978L),
			java.util.Map.entry("region_set_travel_cost", 1794382983L),
			java.util.Map.entry("agent_get_neighbor_distance", 866169185L),
			java.util.Map.entry("obstacle_get_paused", 4155700596L),
			java.util.Map.entry("region_get_use_edge_connections", 4155700596L),
			java.util.Map.entry("link_create", 529393457L), java.util.Map.entry("map_set_active", 1265174801L),
			java.util.Map.entry("map_get_closest_point_normal", 2056183332L),
			java.util.Map.entry("agent_set_neighbor_distance", 1794382983L),
			java.util.Map.entry("obstacle_get_radius", 866169185L),
			java.util.Map.entry("region_get_connection_pathway_start", 3440143363L),
			java.util.Map.entry("map_get_obstacles", 2684255073L),
			java.util.Map.entry("region_get_use_async_iterations", 4155700596L),
			java.util.Map.entry("region_get_enabled", 4155700596L),
			java.util.Map.entry("map_get_use_async_iterations", 4155700596L),
			java.util.Map.entry("agent_set_velocity_forced", 3227306858L),
			java.util.Map.entry("set_active", 2586408642L), java.util.Map.entry("set_debug_enabled", 2586408642L),
			java.util.Map.entry("agent_get_max_speed", 866169185L),
			java.util.Map.entry("map_get_closest_point_owner", 553364610L),
			java.util.Map.entry("get_maps", 3995934104L), java.util.Map.entry("obstacle_set_vertices", 4030257846L),
			java.util.Map.entry("link_set_end_position", 3227306858L),
			java.util.Map.entry("agent_set_avoidance_callback", 3379118538L),
			java.util.Map.entry("map_get_links", 2684255073L),
			java.util.Map.entry("link_get_iteration_id", 2198884583L),
			java.util.Map.entry("region_bake_navigation_mesh", 1401173477L),
			java.util.Map.entry("obstacle_set_paused", 1265174801L),
			java.util.Map.entry("region_get_iteration_id", 2198884583L),
			java.util.Map.entry("map_set_edge_connection_margin", 1794382983L),
			java.util.Map.entry("map_set_use_async_iterations", 1265174801L),
			java.util.Map.entry("link_set_enabled", 1265174801L),
			java.util.Map.entry("link_set_bidirectional", 1265174801L),
			java.util.Map.entry("map_get_iteration_id", 2198884583L),
			java.util.Map.entry("agent_set_time_horizon_agents", 1794382983L),
			java.util.Map.entry("source_geometry_parser_create", 529393457L),
			java.util.Map.entry("link_set_enter_cost", 1794382983L), java.util.Map.entry("map_get_path", 276783190L),
			java.util.Map.entry("region_get_transform", 1128465797L),
			java.util.Map.entry("obstacle_create", 529393457L),
			java.util.Map.entry("map_get_link_connection_radius", 866169185L),
			java.util.Map.entry("region_set_map", 395945892L), java.util.Map.entry("obstacle_get_map", 3814569979L),
			java.util.Map.entry("obstacle_get_use_3d_avoidance", 4155700596L),
			java.util.Map.entry("agent_get_height", 866169185L),
			java.util.Map.entry("agent_set_time_horizon_obstacles", 1794382983L),
			java.util.Map.entry("obstacle_get_height", 866169185L),
			java.util.Map.entry("link_set_owner_id", 3411492887L),
			java.util.Map.entry("agent_set_velocity", 3227306858L),
			java.util.Map.entry("agent_get_position", 531438156L),
			java.util.Map.entry("region_owns_point", 2360011153L),
			java.util.Map.entry("agent_get_avoidance_layers", 2198884583L),
			java.util.Map.entry("map_get_merge_rasterizer_cell_scale", 866169185L),
			java.util.Map.entry("region_get_owner_id", 2198884583L), java.util.Map.entry("region_create", 529393457L),
			java.util.Map.entry("map_set_merge_rasterizer_cell_scale", 1794382983L),
			java.util.Map.entry("link_set_map", 395945892L),
			java.util.Map.entry("agent_set_avoidance_layers", 3411492887L),
			java.util.Map.entry("obstacle_set_radius", 1794382983L),
			java.util.Map.entry("agent_set_height", 1794382983L),
			java.util.Map.entry("is_baking_navigation_mesh", 3142026141L),
			java.util.Map.entry("link_get_end_position", 531438156L),
			java.util.Map.entry("region_set_enter_cost", 1794382983L),
			java.util.Map.entry("link_get_travel_cost", 866169185L),
			java.util.Map.entry("agent_set_max_neighbors", 3411492887L),
			java.util.Map.entry("link_get_navigation_layers", 2198884583L),
			java.util.Map.entry("agent_has_avoidance_callback", 4155700596L),
			java.util.Map.entry("simplify_path", 2344122170L),
			java.util.Map.entry("parse_source_geometry_data", 3172802542L),
			java.util.Map.entry("obstacle_set_velocity", 3227306858L),
			java.util.Map.entry("agent_get_velocity", 531438156L),
			java.util.Map.entry("region_set_use_edge_connections", 1265174801L),
			java.util.Map.entry("link_get_owner_id", 2198884583L), java.util.Map.entry("obstacle_set_map", 395945892L),
			java.util.Map.entry("map_set_use_edge_connections", 1265174801L),
			java.util.Map.entry("agent_get_max_neighbors", 2198884583L),
			java.util.Map.entry("region_set_navigation_layers", 3411492887L),
			java.util.Map.entry("agent_set_avoidance_priority", 1794382983L),
			java.util.Map.entry("map_get_closest_point_to_segment", 3830095642L),
			java.util.Map.entry("bake_from_source_geometry_data_async", 1286748856L),
			java.util.Map.entry("map_set_cell_size", 1794382983L),
			java.util.Map.entry("bake_from_source_geometry_data", 1286748856L),
			java.util.Map.entry("region_get_enter_cost", 866169185L),
			java.util.Map.entry("region_get_navigation_layers", 2198884583L),
			java.util.Map.entry("link_set_start_position", 3227306858L),
			java.util.Map.entry("obstacle_set_avoidance_enabled", 1265174801L),
			java.util.Map.entry("agent_get_time_horizon_obstacles", 866169185L),
			java.util.Map.entry("map_get_closest_point", 2056183332L),
			java.util.Map.entry("obstacle_set_height", 1794382983L),
			java.util.Map.entry("region_get_random_point", 722801526L),
			java.util.Map.entry("agent_get_avoidance_priority", 866169185L),
			java.util.Map.entry("link_get_map", 3814569979L), java.util.Map.entry("obstacle_get_velocity", 531438156L),
			java.util.Map.entry("region_set_owner_id", 3411492887L),
			java.util.Map.entry("link_get_enabled", 4155700596L),
			java.util.Map.entry("agent_set_avoidance_enabled", 1265174801L),
			java.util.Map.entry("map_get_regions", 2684255073L), java.util.Map.entry("agent_set_radius", 1794382983L),
			java.util.Map.entry("map_create", 529393457L), java.util.Map.entry("agent_set_position", 3227306858L),
			java.util.Map.entry("region_get_closest_point_to_segment", 3830095642L),
			java.util.Map.entry("source_geometry_parser_set_callback", 3379118538L),
			java.util.Map.entry("agent_get_map", 3814569979L), java.util.Map.entry("region_get_map", 3814569979L),
			java.util.Map.entry("obstacle_set_position", 3227306858L),
			java.util.Map.entry("region_set_use_async_iterations", 1265174801L),
			java.util.Map.entry("obstacle_get_avoidance_enabled", 4155700596L),
			java.util.Map.entry("query_path", 2146930868L), java.util.Map.entry("map_get_up", 531438156L),
			java.util.Map.entry("map_get_agents", 2684255073L),
			java.util.Map.entry("region_set_transform", 3935195649L),
			java.util.Map.entry("map_get_cell_size", 866169185L),
			java.util.Map.entry("agent_get_avoidance_mask", 2198884583L),
			java.util.Map.entry("agent_get_avoidance_enabled", 4155700596L),
			java.util.Map.entry("agent_set_max_speed", 1794382983L),
			java.util.Map.entry("link_get_start_position", 531438156L),
			java.util.Map.entry("link_get_enter_cost", 866169185L), java.util.Map.entry("map_is_active", 4155700596L),
			java.util.Map.entry("agent_get_use_3d_avoidance", 4155700596L),
			java.util.Map.entry("agent_get_paused", 4155700596L),
			java.util.Map.entry("agent_is_map_changed", 4155700596L),
			java.util.Map.entry("agent_set_use_3d_avoidance", 1265174801L),
			java.util.Map.entry("region_get_closest_point", 2056183332L),
			java.util.Map.entry("link_set_travel_cost", 1794382983L),
			java.util.Map.entry("agent_get_radius", 866169185L),
			java.util.Map.entry("link_set_navigation_layers", 3411492887L),
			java.util.Map.entry("agent_create", 529393457L),
			java.util.Map.entry("agent_set_avoidance_mask", 3411492887L),
			java.util.Map.entry("region_get_connection_pathway_end", 3440143363L),
			java.util.Map.entry("map_force_update", 2722037293L), java.util.Map.entry("free_rid", 2722037293L),
			java.util.Map.entry("get_process_info", 1938440894L),
			java.util.Map.entry("region_get_travel_cost", 866169185L),
			java.util.Map.entry("region_get_bounds", 974181306L),
			java.util.Map.entry("map_set_link_connection_radius", 1794382983L),
			java.util.Map.entry("obstacle_set_avoidance_layers", 3411492887L),
			java.util.Map.entry("agent_get_time_horizon_agents", 866169185L),
			java.util.Map.entry("map_set_up", 3227306858L),
			java.util.Map.entry("obstacle_get_avoidance_layers", 2198884583L),
			java.util.Map.entry("map_set_cell_height", 1794382983L),
			java.util.Map.entry("obstacle_get_position", 531438156L),
			java.util.Map.entry("region_set_enabled", 1265174801L),
			java.util.Map.entry("agent_set_paused", 1265174801L));

	NavigationServer3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationServer3D(long nativePointer) {
		super(nativePointer);
	}

	public long map_create() {
		return (long) super.call("map_create");
	}

	public void map_set_active(long map, boolean active) {
		super.call("map_set_active",
				new java.lang.Object[]{java.lang.Long.valueOf(map), java.lang.Boolean.valueOf(active)});
	}

	public boolean map_is_active(long map) {
		return (boolean) super.call("map_is_active", new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public void map_set_up(long map, Vector3 up) {
		super.call("map_set_up", new java.lang.Object[]{java.lang.Long.valueOf(map), (java.lang.Object) up});
	}

	public Vector3 map_get_up(long map) {
		return (Vector3) super.call("map_get_up", new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public void map_set_cell_size(long map, double cell_size) {
		super.call("map_set_cell_size",
				new java.lang.Object[]{java.lang.Long.valueOf(map), java.lang.Double.valueOf(cell_size)});
	}

	public double map_get_cell_size(long map) {
		return (double) super.call("map_get_cell_size", new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public void map_set_cell_height(long map, double cell_height) {
		super.call("map_set_cell_height",
				new java.lang.Object[]{java.lang.Long.valueOf(map), java.lang.Double.valueOf(cell_height)});
	}

	public double map_get_cell_height(long map) {
		return (double) super.call("map_get_cell_height", new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public void map_set_merge_rasterizer_cell_scale(long map, double scale) {
		super.call("map_set_merge_rasterizer_cell_scale",
				new java.lang.Object[]{java.lang.Long.valueOf(map), java.lang.Double.valueOf(scale)});
	}

	public double map_get_merge_rasterizer_cell_scale(long map) {
		return (double) super.call("map_get_merge_rasterizer_cell_scale",
				new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public void map_set_use_edge_connections(long map, boolean enabled) {
		super.call("map_set_use_edge_connections",
				new java.lang.Object[]{java.lang.Long.valueOf(map), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean map_get_use_edge_connections(long map) {
		return (boolean) super.call("map_get_use_edge_connections",
				new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public void map_set_edge_connection_margin(long map, double margin) {
		super.call("map_set_edge_connection_margin",
				new java.lang.Object[]{java.lang.Long.valueOf(map), java.lang.Double.valueOf(margin)});
	}

	public double map_get_edge_connection_margin(long map) {
		return (double) super.call("map_get_edge_connection_margin",
				new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public void map_set_link_connection_radius(long map, double radius) {
		super.call("map_set_link_connection_radius",
				new java.lang.Object[]{java.lang.Long.valueOf(map), java.lang.Double.valueOf(radius)});
	}

	public double map_get_link_connection_radius(long map) {
		return (double) super.call("map_get_link_connection_radius",
				new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public double[][] map_get_path(long map, Vector3 origin, Vector3 destination, boolean optimize,
			long navigation_layers) {
		return (double[][]) super.call("map_get_path",
				new java.lang.Object[]{java.lang.Long.valueOf(map), (java.lang.Object) origin,
						(java.lang.Object) destination, java.lang.Boolean.valueOf(optimize),
						java.lang.Long.valueOf(navigation_layers)});
	}

	public Vector3 map_get_closest_point_to_segment(long map, Vector3 start, Vector3 end, boolean use_collision) {
		return (Vector3) super.call("map_get_closest_point_to_segment",
				new java.lang.Object[]{java.lang.Long.valueOf(map), (java.lang.Object) start, (java.lang.Object) end,
						java.lang.Boolean.valueOf(use_collision)});
	}

	public Vector3 map_get_closest_point(long map, Vector3 to_point) {
		return (Vector3) super.call("map_get_closest_point",
				new java.lang.Object[]{java.lang.Long.valueOf(map), (java.lang.Object) to_point});
	}

	public Vector3 map_get_closest_point_normal(long map, Vector3 to_point) {
		return (Vector3) super.call("map_get_closest_point_normal",
				new java.lang.Object[]{java.lang.Long.valueOf(map), (java.lang.Object) to_point});
	}

	public long map_get_closest_point_owner(long map, Vector3 to_point) {
		return (long) super.call("map_get_closest_point_owner",
				new java.lang.Object[]{java.lang.Long.valueOf(map), (java.lang.Object) to_point});
	}

	public long[] map_get_links(long map) {
		return (long[]) super.call("map_get_links", new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public long[] map_get_regions(long map) {
		return (long[]) super.call("map_get_regions", new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public long[] map_get_agents(long map) {
		return (long[]) super.call("map_get_agents", new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public long[] map_get_obstacles(long map) {
		return (long[]) super.call("map_get_obstacles", new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public void map_force_update(long map) {
		super.call("map_force_update", new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public long map_get_iteration_id(long map) {
		return (long) super.call("map_get_iteration_id", new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public void map_set_use_async_iterations(long map, boolean enabled) {
		super.call("map_set_use_async_iterations",
				new java.lang.Object[]{java.lang.Long.valueOf(map), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean map_get_use_async_iterations(long map) {
		return (boolean) super.call("map_get_use_async_iterations",
				new java.lang.Object[]{java.lang.Long.valueOf(map)});
	}

	public Vector3 map_get_random_point(long map, long navigation_layers, boolean uniformly) {
		return (Vector3) super.call("map_get_random_point", new java.lang.Object[]{java.lang.Long.valueOf(map),
				java.lang.Long.valueOf(navigation_layers), java.lang.Boolean.valueOf(uniformly)});
	}

	public void query_path(NavigationPathQueryParameters3D parameters, NavigationPathQueryResult3D result,
			Callable callback) {
		super.call("query_path", new java.lang.Object[]{(java.lang.Object) parameters, (java.lang.Object) result,
				(java.lang.Object) callback});
	}

	public long region_create() {
		return (long) super.call("region_create");
	}

	public long region_get_iteration_id(long region) {
		return (long) super.call("region_get_iteration_id", new java.lang.Object[]{java.lang.Long.valueOf(region)});
	}

	public void region_set_use_async_iterations(long region, boolean enabled) {
		super.call("region_set_use_async_iterations",
				new java.lang.Object[]{java.lang.Long.valueOf(region), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean region_get_use_async_iterations(long region) {
		return (boolean) super.call("region_get_use_async_iterations",
				new java.lang.Object[]{java.lang.Long.valueOf(region)});
	}

	public void region_set_enabled(long region, boolean enabled) {
		super.call("region_set_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(region), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean region_get_enabled(long region) {
		return (boolean) super.call("region_get_enabled", new java.lang.Object[]{java.lang.Long.valueOf(region)});
	}

	public void region_set_use_edge_connections(long region, boolean enabled) {
		super.call("region_set_use_edge_connections",
				new java.lang.Object[]{java.lang.Long.valueOf(region), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean region_get_use_edge_connections(long region) {
		return (boolean) super.call("region_get_use_edge_connections",
				new java.lang.Object[]{java.lang.Long.valueOf(region)});
	}

	public void region_set_enter_cost(long region, double enter_cost) {
		super.call("region_set_enter_cost",
				new java.lang.Object[]{java.lang.Long.valueOf(region), java.lang.Double.valueOf(enter_cost)});
	}

	public double region_get_enter_cost(long region) {
		return (double) super.call("region_get_enter_cost", new java.lang.Object[]{java.lang.Long.valueOf(region)});
	}

	public void region_set_travel_cost(long region, double travel_cost) {
		super.call("region_set_travel_cost",
				new java.lang.Object[]{java.lang.Long.valueOf(region), java.lang.Double.valueOf(travel_cost)});
	}

	public double region_get_travel_cost(long region) {
		return (double) super.call("region_get_travel_cost", new java.lang.Object[]{java.lang.Long.valueOf(region)});
	}

	public void region_set_owner_id(long region, long owner_id) {
		super.call("region_set_owner_id",
				new java.lang.Object[]{java.lang.Long.valueOf(region), java.lang.Long.valueOf(owner_id)});
	}

	public java.math.BigInteger region_get_owner_id(long region) {
		return (java.math.BigInteger) super.call("region_get_owner_id",
				new java.lang.Object[]{java.lang.Long.valueOf(region)});
	}

	public boolean region_owns_point(long region, Vector3 point) {
		return (boolean) super.call("region_owns_point",
				new java.lang.Object[]{java.lang.Long.valueOf(region), (java.lang.Object) point});
	}

	public void region_set_map(long region, long map) {
		super.call("region_set_map",
				new java.lang.Object[]{java.lang.Long.valueOf(region), java.lang.Long.valueOf(map)});
	}

	public long region_get_map(long region) {
		return (long) super.call("region_get_map", new java.lang.Object[]{java.lang.Long.valueOf(region)});
	}

	public void region_set_navigation_layers(long region, long navigation_layers) {
		super.call("region_set_navigation_layers",
				new java.lang.Object[]{java.lang.Long.valueOf(region), java.lang.Long.valueOf(navigation_layers)});
	}

	public long region_get_navigation_layers(long region) {
		return (long) super.call("region_get_navigation_layers",
				new java.lang.Object[]{java.lang.Long.valueOf(region)});
	}

	public void region_set_transform(long region, Transform3D transform) {
		super.call("region_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(region), (java.lang.Object) transform});
	}

	public Transform3D region_get_transform(long region) {
		return (Transform3D) super.call("region_get_transform", new java.lang.Object[]{java.lang.Long.valueOf(region)});
	}

	public void region_set_navigation_mesh(long region, NavigationMesh navigation_mesh) {
		super.call("region_set_navigation_mesh",
				new java.lang.Object[]{java.lang.Long.valueOf(region), (java.lang.Object) navigation_mesh});
	}

	public void region_bake_navigation_mesh(NavigationMesh navigation_mesh, Node root_node) {
		super.call("region_bake_navigation_mesh",
				new java.lang.Object[]{(java.lang.Object) navigation_mesh, (java.lang.Object) root_node});
	}

	public int region_get_connections_count(long region) {
		return (int) super.call("region_get_connections_count", new java.lang.Object[]{java.lang.Long.valueOf(region)});
	}

	public Vector3 region_get_connection_pathway_start(long region, long connection) {
		return (Vector3) super.call("region_get_connection_pathway_start",
				new java.lang.Object[]{java.lang.Long.valueOf(region), java.lang.Long.valueOf(connection)});
	}

	public Vector3 region_get_connection_pathway_end(long region, long connection) {
		return (Vector3) super.call("region_get_connection_pathway_end",
				new java.lang.Object[]{java.lang.Long.valueOf(region), java.lang.Long.valueOf(connection)});
	}

	public Vector3 region_get_closest_point_to_segment(long region, Vector3 start, Vector3 end, boolean use_collision) {
		return (Vector3) super.call("region_get_closest_point_to_segment",
				new java.lang.Object[]{java.lang.Long.valueOf(region), (java.lang.Object) start, (java.lang.Object) end,
						java.lang.Boolean.valueOf(use_collision)});
	}

	public Vector3 region_get_closest_point(long region, Vector3 to_point) {
		return (Vector3) super.call("region_get_closest_point",
				new java.lang.Object[]{java.lang.Long.valueOf(region), (java.lang.Object) to_point});
	}

	public Vector3 region_get_closest_point_normal(long region, Vector3 to_point) {
		return (Vector3) super.call("region_get_closest_point_normal",
				new java.lang.Object[]{java.lang.Long.valueOf(region), (java.lang.Object) to_point});
	}

	public Vector3 region_get_random_point(long region, long navigation_layers, boolean uniformly) {
		return (Vector3) super.call("region_get_random_point", new java.lang.Object[]{java.lang.Long.valueOf(region),
				java.lang.Long.valueOf(navigation_layers), java.lang.Boolean.valueOf(uniformly)});
	}

	public AABB region_get_bounds(long region) {
		return (AABB) super.call("region_get_bounds", new java.lang.Object[]{java.lang.Long.valueOf(region)});
	}

	public long link_create() {
		return (long) super.call("link_create");
	}

	public long link_get_iteration_id(long link) {
		return (long) super.call("link_get_iteration_id", new java.lang.Object[]{java.lang.Long.valueOf(link)});
	}

	public void link_set_map(long link, long map) {
		super.call("link_set_map", new java.lang.Object[]{java.lang.Long.valueOf(link), java.lang.Long.valueOf(map)});
	}

	public long link_get_map(long link) {
		return (long) super.call("link_get_map", new java.lang.Object[]{java.lang.Long.valueOf(link)});
	}

	public void link_set_enabled(long link, boolean enabled) {
		super.call("link_set_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(link), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean link_get_enabled(long link) {
		return (boolean) super.call("link_get_enabled", new java.lang.Object[]{java.lang.Long.valueOf(link)});
	}

	public void link_set_bidirectional(long link, boolean bidirectional) {
		super.call("link_set_bidirectional",
				new java.lang.Object[]{java.lang.Long.valueOf(link), java.lang.Boolean.valueOf(bidirectional)});
	}

	public boolean link_is_bidirectional(long link) {
		return (boolean) super.call("link_is_bidirectional", new java.lang.Object[]{java.lang.Long.valueOf(link)});
	}

	public void link_set_navigation_layers(long link, long navigation_layers) {
		super.call("link_set_navigation_layers",
				new java.lang.Object[]{java.lang.Long.valueOf(link), java.lang.Long.valueOf(navigation_layers)});
	}

	public long link_get_navigation_layers(long link) {
		return (long) super.call("link_get_navigation_layers", new java.lang.Object[]{java.lang.Long.valueOf(link)});
	}

	public void link_set_start_position(long link, Vector3 position) {
		super.call("link_set_start_position",
				new java.lang.Object[]{java.lang.Long.valueOf(link), (java.lang.Object) position});
	}

	public Vector3 link_get_start_position(long link) {
		return (Vector3) super.call("link_get_start_position", new java.lang.Object[]{java.lang.Long.valueOf(link)});
	}

	public void link_set_end_position(long link, Vector3 position) {
		super.call("link_set_end_position",
				new java.lang.Object[]{java.lang.Long.valueOf(link), (java.lang.Object) position});
	}

	public Vector3 link_get_end_position(long link) {
		return (Vector3) super.call("link_get_end_position", new java.lang.Object[]{java.lang.Long.valueOf(link)});
	}

	public void link_set_enter_cost(long link, double enter_cost) {
		super.call("link_set_enter_cost",
				new java.lang.Object[]{java.lang.Long.valueOf(link), java.lang.Double.valueOf(enter_cost)});
	}

	public double link_get_enter_cost(long link) {
		return (double) super.call("link_get_enter_cost", new java.lang.Object[]{java.lang.Long.valueOf(link)});
	}

	public void link_set_travel_cost(long link, double travel_cost) {
		super.call("link_set_travel_cost",
				new java.lang.Object[]{java.lang.Long.valueOf(link), java.lang.Double.valueOf(travel_cost)});
	}

	public double link_get_travel_cost(long link) {
		return (double) super.call("link_get_travel_cost", new java.lang.Object[]{java.lang.Long.valueOf(link)});
	}

	public void link_set_owner_id(long link, long owner_id) {
		super.call("link_set_owner_id",
				new java.lang.Object[]{java.lang.Long.valueOf(link), java.lang.Long.valueOf(owner_id)});
	}

	public java.math.BigInteger link_get_owner_id(long link) {
		return (java.math.BigInteger) super.call("link_get_owner_id",
				new java.lang.Object[]{java.lang.Long.valueOf(link)});
	}

	public long agent_create() {
		return (long) super.call("agent_create");
	}

	public void agent_set_avoidance_enabled(long agent, boolean enabled) {
		super.call("agent_set_avoidance_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean agent_get_avoidance_enabled(long agent) {
		return (boolean) super.call("agent_get_avoidance_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_use_3d_avoidance(long agent, boolean enabled) {
		super.call("agent_set_use_3d_avoidance",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean agent_get_use_3d_avoidance(long agent) {
		return (boolean) super.call("agent_get_use_3d_avoidance",
				new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_map(long agent, long map) {
		super.call("agent_set_map", new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Long.valueOf(map)});
	}

	public long agent_get_map(long agent) {
		return (long) super.call("agent_get_map", new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_paused(long agent, boolean paused) {
		super.call("agent_set_paused",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Boolean.valueOf(paused)});
	}

	public boolean agent_get_paused(long agent) {
		return (boolean) super.call("agent_get_paused", new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_neighbor_distance(long agent, double distance) {
		super.call("agent_set_neighbor_distance",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Double.valueOf(distance)});
	}

	public double agent_get_neighbor_distance(long agent) {
		return (double) super.call("agent_get_neighbor_distance",
				new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_max_neighbors(long agent, long count) {
		super.call("agent_set_max_neighbors",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Long.valueOf(count)});
	}

	public int agent_get_max_neighbors(long agent) {
		return (int) super.call("agent_get_max_neighbors", new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_time_horizon_agents(long agent, double time_horizon) {
		super.call("agent_set_time_horizon_agents",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Double.valueOf(time_horizon)});
	}

	public double agent_get_time_horizon_agents(long agent) {
		return (double) super.call("agent_get_time_horizon_agents",
				new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_time_horizon_obstacles(long agent, double time_horizon) {
		super.call("agent_set_time_horizon_obstacles",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Double.valueOf(time_horizon)});
	}

	public double agent_get_time_horizon_obstacles(long agent) {
		return (double) super.call("agent_get_time_horizon_obstacles",
				new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_radius(long agent, double radius) {
		super.call("agent_set_radius",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Double.valueOf(radius)});
	}

	public double agent_get_radius(long agent) {
		return (double) super.call("agent_get_radius", new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_height(long agent, double height) {
		super.call("agent_set_height",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Double.valueOf(height)});
	}

	public double agent_get_height(long agent) {
		return (double) super.call("agent_get_height", new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_max_speed(long agent, double max_speed) {
		super.call("agent_set_max_speed",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Double.valueOf(max_speed)});
	}

	public double agent_get_max_speed(long agent) {
		return (double) super.call("agent_get_max_speed", new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_velocity_forced(long agent, Vector3 velocity) {
		super.call("agent_set_velocity_forced",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), (java.lang.Object) velocity});
	}

	public void agent_set_velocity(long agent, Vector3 velocity) {
		super.call("agent_set_velocity",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), (java.lang.Object) velocity});
	}

	public Vector3 agent_get_velocity(long agent) {
		return (Vector3) super.call("agent_get_velocity", new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_position(long agent, Vector3 position) {
		super.call("agent_set_position",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), (java.lang.Object) position});
	}

	public Vector3 agent_get_position(long agent) {
		return (Vector3) super.call("agent_get_position", new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public boolean agent_is_map_changed(long agent) {
		return (boolean) super.call("agent_is_map_changed", new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_avoidance_callback(long agent, Callable callback) {
		super.call("agent_set_avoidance_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), (java.lang.Object) callback});
	}

	public boolean agent_has_avoidance_callback(long agent) {
		return (boolean) super.call("agent_has_avoidance_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_avoidance_layers(long agent, long layers) {
		super.call("agent_set_avoidance_layers",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Long.valueOf(layers)});
	}

	public long agent_get_avoidance_layers(long agent) {
		return (long) super.call("agent_get_avoidance_layers", new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_avoidance_mask(long agent, long mask) {
		super.call("agent_set_avoidance_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Long.valueOf(mask)});
	}

	public long agent_get_avoidance_mask(long agent) {
		return (long) super.call("agent_get_avoidance_mask", new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public void agent_set_avoidance_priority(long agent, double priority) {
		super.call("agent_set_avoidance_priority",
				new java.lang.Object[]{java.lang.Long.valueOf(agent), java.lang.Double.valueOf(priority)});
	}

	public double agent_get_avoidance_priority(long agent) {
		return (double) super.call("agent_get_avoidance_priority",
				new java.lang.Object[]{java.lang.Long.valueOf(agent)});
	}

	public long obstacle_create() {
		return (long) super.call("obstacle_create");
	}

	public void obstacle_set_avoidance_enabled(long obstacle, boolean enabled) {
		super.call("obstacle_set_avoidance_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean obstacle_get_avoidance_enabled(long obstacle) {
		return (boolean) super.call("obstacle_get_avoidance_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle)});
	}

	public void obstacle_set_use_3d_avoidance(long obstacle, boolean enabled) {
		super.call("obstacle_set_use_3d_avoidance",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean obstacle_get_use_3d_avoidance(long obstacle) {
		return (boolean) super.call("obstacle_get_use_3d_avoidance",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle)});
	}

	public void obstacle_set_map(long obstacle, long map) {
		super.call("obstacle_set_map",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle), java.lang.Long.valueOf(map)});
	}

	public long obstacle_get_map(long obstacle) {
		return (long) super.call("obstacle_get_map", new java.lang.Object[]{java.lang.Long.valueOf(obstacle)});
	}

	public void obstacle_set_paused(long obstacle, boolean paused) {
		super.call("obstacle_set_paused",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle), java.lang.Boolean.valueOf(paused)});
	}

	public boolean obstacle_get_paused(long obstacle) {
		return (boolean) super.call("obstacle_get_paused", new java.lang.Object[]{java.lang.Long.valueOf(obstacle)});
	}

	public void obstacle_set_radius(long obstacle, double radius) {
		super.call("obstacle_set_radius",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle), java.lang.Double.valueOf(radius)});
	}

	public double obstacle_get_radius(long obstacle) {
		return (double) super.call("obstacle_get_radius", new java.lang.Object[]{java.lang.Long.valueOf(obstacle)});
	}

	public void obstacle_set_height(long obstacle, double height) {
		super.call("obstacle_set_height",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle), java.lang.Double.valueOf(height)});
	}

	public double obstacle_get_height(long obstacle) {
		return (double) super.call("obstacle_get_height", new java.lang.Object[]{java.lang.Long.valueOf(obstacle)});
	}

	public void obstacle_set_velocity(long obstacle, Vector3 velocity) {
		super.call("obstacle_set_velocity",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle), (java.lang.Object) velocity});
	}

	public Vector3 obstacle_get_velocity(long obstacle) {
		return (Vector3) super.call("obstacle_get_velocity", new java.lang.Object[]{java.lang.Long.valueOf(obstacle)});
	}

	public void obstacle_set_position(long obstacle, Vector3 position) {
		super.call("obstacle_set_position",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle), (java.lang.Object) position});
	}

	public Vector3 obstacle_get_position(long obstacle) {
		return (Vector3) super.call("obstacle_get_position", new java.lang.Object[]{java.lang.Long.valueOf(obstacle)});
	}

	public void obstacle_set_vertices(long obstacle, double[][] vertices) {
		super.call("obstacle_set_vertices",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle), (java.lang.Object) vertices});
	}

	public double[][] obstacle_get_vertices(long obstacle) {
		return (double[][]) super.call("obstacle_get_vertices",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle)});
	}

	public void obstacle_set_avoidance_layers(long obstacle, long layers) {
		super.call("obstacle_set_avoidance_layers",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle), java.lang.Long.valueOf(layers)});
	}

	public long obstacle_get_avoidance_layers(long obstacle) {
		return (long) super.call("obstacle_get_avoidance_layers",
				new java.lang.Object[]{java.lang.Long.valueOf(obstacle)});
	}

	public void parse_source_geometry_data(NavigationMesh navigation_mesh,
			NavigationMeshSourceGeometryData3D source_geometry_data, Node root_node, Callable callback) {
		super.call("parse_source_geometry_data", new java.lang.Object[]{(java.lang.Object) navigation_mesh,
				(java.lang.Object) source_geometry_data, (java.lang.Object) root_node, (java.lang.Object) callback});
	}

	public void bake_from_source_geometry_data(NavigationMesh navigation_mesh,
			NavigationMeshSourceGeometryData3D source_geometry_data, Callable callback) {
		super.call("bake_from_source_geometry_data", new java.lang.Object[]{(java.lang.Object) navigation_mesh,
				(java.lang.Object) source_geometry_data, (java.lang.Object) callback});
	}

	public void bake_from_source_geometry_data_async(NavigationMesh navigation_mesh,
			NavigationMeshSourceGeometryData3D source_geometry_data, Callable callback) {
		super.call("bake_from_source_geometry_data_async", new java.lang.Object[]{(java.lang.Object) navigation_mesh,
				(java.lang.Object) source_geometry_data, (java.lang.Object) callback});
	}

	public boolean is_baking_navigation_mesh(NavigationMesh navigation_mesh) {
		return (boolean) super.call("is_baking_navigation_mesh",
				new java.lang.Object[]{(java.lang.Object) navigation_mesh});
	}

	public long source_geometry_parser_create() {
		return (long) super.call("source_geometry_parser_create");
	}

	public void source_geometry_parser_set_callback(long parser, Callable callback) {
		super.call("source_geometry_parser_set_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(parser), (java.lang.Object) callback});
	}

	public double[][] simplify_path(double[][] path, double epsilon) {
		return (double[][]) super.call("simplify_path",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Double.valueOf(epsilon)});
	}

	public void free_rid(long rid) {
		super.call("free_rid", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public int get_process_info(int process_info) {
		return (int) super.call("get_process_info", new java.lang.Object[]{java.lang.Integer.valueOf(process_info)});
	}
}
