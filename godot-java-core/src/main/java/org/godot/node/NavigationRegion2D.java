package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class NavigationRegion2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_region_rid", 2944877500L),
			java.util.Map.entry("set_navigation_polygon", 1515040758L),
			java.util.Map.entry("set_travel_cost", 373806689L), java.util.Map.entry("get_travel_cost", 1740695150L),
			java.util.Map.entry("get_enter_cost", 1740695150L), java.util.Map.entry("set_navigation_map", 2722037293L),
			java.util.Map.entry("is_baking", 36873697L), java.util.Map.entry("set_use_edge_connections", 2586408642L),
			java.util.Map.entry("bake_navigation_polygon", 3216645846L),
			java.util.Map.entry("get_navigation_map", 2944877500L), java.util.Map.entry("get_bounds", 1639390495L),
			java.util.Map.entry("get_rid", 2944877500L), java.util.Map.entry("is_enabled", 36873697L),
			java.util.Map.entry("set_enter_cost", 373806689L),
			java.util.Map.entry("get_navigation_polygon", 1046532237L), java.util.Map.entry("set_enabled", 2586408642L),
			java.util.Map.entry("set_navigation_layers", 1286410249L),
			java.util.Map.entry("get_navigation_layer_value", 1116898809L),
			java.util.Map.entry("get_use_edge_connections", 36873697L),
			java.util.Map.entry("get_navigation_layers", 3905245786L),
			java.util.Map.entry("set_navigation_layer_value", 300928843L));

	NavigationRegion2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationRegion2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_enabled() {
		return (boolean) super.call("is_enabled");
	}

	public void set_navigation_layer_value(long layer_number, boolean value) {
		super.call("set_navigation_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_navigation_layer_value(long layer_number) {
		return (boolean) super.call("get_navigation_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public void bake_navigation_polygon(boolean on_thread) {
		super.call("bake_navigation_polygon", new java.lang.Object[]{java.lang.Boolean.valueOf(on_thread)});
	}

	public boolean is_baking() {
		return (boolean) super.call("is_baking");
	}

	public NavigationPolygon getNavigation_polygon() {
		return (NavigationPolygon) super.call("get_navigation_polygon", new java.lang.Object[0]);
	}

	public void setNavigation_polygon(NavigationPolygon value) {
		super.call("set_navigation_polygon", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isEnabled() {
		return (boolean) super.call("is_enabled", new java.lang.Object[0]);
	}

	public void setEnabled(boolean value) {
		super.call("set_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getUse_edge_connections() {
		return (boolean) super.call("get_use_edge_connections", new java.lang.Object[0]);
	}

	public void setUse_edge_connections(boolean value) {
		super.call("set_use_edge_connections", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getNavigation_layers() {
		return (long) super.call("get_navigation_layers", new java.lang.Object[0]);
	}

	public void setNavigation_layers(long value) {
		super.call("set_navigation_layers", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getEnter_cost() {
		return (double) super.call("get_enter_cost", new java.lang.Object[0]);
	}

	public void setEnter_cost(double value) {
		super.call("set_enter_cost", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTravel_cost() {
		return (double) super.call("get_travel_cost", new java.lang.Object[0]);
	}

	public void setTravel_cost(double value) {
		super.call("set_travel_cost", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
