package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class NavigationObstacle2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_avoidance_enabled", 36873697L), java.util.Map.entry("set_vertices", 1509147220L),
			java.util.Map.entry("set_navigation_map", 2722037293L),
			java.util.Map.entry("get_affect_navigation_mesh", 36873697L),
			java.util.Map.entry("get_radius", 1740695150L), java.util.Map.entry("get_navigation_map", 2944877500L),
			java.util.Map.entry("set_avoidance_layers", 1286410249L),
			java.util.Map.entry("set_avoidance_enabled", 2586408642L), java.util.Map.entry("set_radius", 373806689L),
			java.util.Map.entry("set_affect_navigation_mesh", 2586408642L), java.util.Map.entry("get_rid", 2944877500L),
			java.util.Map.entry("set_avoidance_layer_value", 300928843L),
			java.util.Map.entry("set_velocity", 743155724L), java.util.Map.entry("get_velocity", 3341600327L),
			java.util.Map.entry("get_carve_navigation_mesh", 36873697L),
			java.util.Map.entry("set_carve_navigation_mesh", 2586408642L),
			java.util.Map.entry("get_avoidance_layers", 3905245786L),
			java.util.Map.entry("get_avoidance_layer_value", 1116898809L),
			java.util.Map.entry("get_vertices", 2961356807L));

	NavigationObstacle2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationObstacle2D(long nativePointer) {
		super(nativePointer);
	}

	public void set_avoidance_layer_value(long layer_number, boolean value) {
		super.call("set_avoidance_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_avoidance_layer_value(long layer_number) {
		return (boolean) super.call("get_avoidance_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public double getRadius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setRadius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double[][] getVertices() {
		return (double[][]) super.call("get_vertices", new java.lang.Object[0]);
	}

	public void setVertices(double[][] value) {
		super.call("set_vertices", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getAffect_navigation_mesh() {
		return (boolean) super.call("get_affect_navigation_mesh", new java.lang.Object[0]);
	}

	public void setAffect_navigation_mesh(boolean value) {
		super.call("set_affect_navigation_mesh", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getCarve_navigation_mesh() {
		return (boolean) super.call("get_carve_navigation_mesh", new java.lang.Object[0]);
	}

	public void setCarve_navigation_mesh(boolean value) {
		super.call("set_carve_navigation_mesh", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public long getAvoidance_layers() {
		return (long) super.call("get_avoidance_layers", new java.lang.Object[0]);
	}

	public void setAvoidance_layers(long value) {
		super.call("set_avoidance_layers", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
