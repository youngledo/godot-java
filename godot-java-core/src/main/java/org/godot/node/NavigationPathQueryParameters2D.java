package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;
import org.godot.math.Vector2;

public class NavigationPathQueryParameters2D extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_pathfinding_algorithm", 2783519915L),
			java.util.Map.entry("set_path_return_max_length", 373806689L),
			java.util.Map.entry("set_included_regions", 381264803L),
			java.util.Map.entry("set_target_position", 743155724L), java.util.Map.entry("get_simplify_path", 36873697L),
			java.util.Map.entry("set_simplify_epsilon", 373806689L),
			java.util.Map.entry("get_start_position", 3341600327L),
			java.util.Map.entry("get_path_search_max_polygons", 3905245786L),
			java.util.Map.entry("set_excluded_regions", 381264803L),
			java.util.Map.entry("set_simplify_path", 2586408642L),
			java.util.Map.entry("get_metadata_flags", 488152976L),
			java.util.Map.entry("set_path_search_max_distance", 373806689L),
			java.util.Map.entry("get_target_position", 3341600327L),
			java.util.Map.entry("get_simplify_epsilon", 1740695150L),
			java.util.Map.entry("get_pathfinding_algorithm", 3000421146L),
			java.util.Map.entry("get_path_postprocessing", 3798118993L),
			java.util.Map.entry("get_path_search_max_distance", 1740695150L),
			java.util.Map.entry("set_start_position", 743155724L), java.util.Map.entry("set_metadata_flags", 24274129L),
			java.util.Map.entry("get_excluded_regions", 3995934104L),
			java.util.Map.entry("set_path_postprocessing", 2864409082L),
			java.util.Map.entry("set_path_return_max_radius", 373806689L), java.util.Map.entry("set_map", 2722037293L),
			java.util.Map.entry("get_path_return_max_radius", 1740695150L),
			java.util.Map.entry("get_included_regions", 3995934104L),
			java.util.Map.entry("set_path_search_max_polygons", 1286410249L),
			java.util.Map.entry("set_navigation_layers", 1286410249L),
			java.util.Map.entry("get_path_return_max_length", 1740695150L), java.util.Map.entry("get_map", 2944877500L),
			java.util.Map.entry("get_navigation_layers", 3905245786L));

	NavigationPathQueryParameters2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationPathQueryParameters2D(long nativePointer) {
		super(nativePointer);
	}

	public long getMap() {
		return (long) super.call("get_map", new java.lang.Object[0]);
	}

	public void setMap(long value) {
		super.call("set_map", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector2 getStart_position() {
		return (Vector2) super.call("get_start_position", new java.lang.Object[0]);
	}

	public void setStart_position(Vector2 value) {
		super.call("set_start_position", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getTarget_position() {
		return (Vector2) super.call("get_target_position", new java.lang.Object[0]);
	}

	public void setTarget_position(Vector2 value) {
		super.call("set_target_position", new java.lang.Object[]{(java.lang.Object) value});
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

	public long getMetadata_flags() {
		return (long) super.call("get_metadata_flags", new java.lang.Object[0]);
	}

	public void setMetadata_flags(long value) {
		super.call("set_metadata_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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

	public long[] getExcluded_regions() {
		return (long[]) super.call("get_excluded_regions", new java.lang.Object[0]);
	}

	public void setExcluded_regions(long[] value) {
		super.call("set_excluded_regions", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long[] getIncluded_regions() {
		return (long[]) super.call("get_included_regions", new java.lang.Object[0]);
	}

	public void setIncluded_regions(long[] value) {
		super.call("set_included_regions", new java.lang.Object[]{(java.lang.Object) value});
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
}
