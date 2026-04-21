package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class NavigationLink3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_travel_cost", 373806689L),
			java.util.Map.entry("get_global_end_position", 3360562783L),
			java.util.Map.entry("get_travel_cost", 1740695150L), java.util.Map.entry("get_enter_cost", 1740695150L),
			java.util.Map.entry("set_navigation_map", 2722037293L),
			java.util.Map.entry("set_global_start_position", 3460891852L),
			java.util.Map.entry("get_navigation_map", 2944877500L),
			java.util.Map.entry("get_start_position", 3360562783L), java.util.Map.entry("get_rid", 2944877500L),
			java.util.Map.entry("is_enabled", 36873697L), java.util.Map.entry("set_bidirectional", 2586408642L),
			java.util.Map.entry("set_enter_cost", 373806689L), java.util.Map.entry("set_enabled", 2586408642L),
			java.util.Map.entry("set_end_position", 3460891852L),
			java.util.Map.entry("get_global_start_position", 3360562783L),
			java.util.Map.entry("set_navigation_layers", 1286410249L),
			java.util.Map.entry("get_end_position", 3360562783L),
			java.util.Map.entry("get_navigation_layer_value", 1116898809L),
			java.util.Map.entry("set_global_end_position", 3460891852L),
			java.util.Map.entry("is_bidirectional", 36873697L), java.util.Map.entry("set_start_position", 3460891852L),
			java.util.Map.entry("get_navigation_layers", 3905245786L),
			java.util.Map.entry("set_navigation_layer_value", 300928843L));

	NavigationLink3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationLink3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_enabled() {
		return (boolean) super.call("is_enabled");
	}

	public boolean is_bidirectional() {
		return (boolean) super.call("is_bidirectional");
	}

	public void set_navigation_layer_value(long layer_number, boolean value) {
		super.call("set_navigation_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_navigation_layer_value(long layer_number) {
		return (boolean) super.call("get_navigation_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public boolean isEnabled() {
		return (boolean) super.call("is_enabled", new java.lang.Object[0]);
	}

	public void setEnabled(boolean value) {
		super.call("set_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isBidirectional() {
		return (boolean) super.call("is_bidirectional", new java.lang.Object[0]);
	}

	public void setBidirectional(boolean value) {
		super.call("set_bidirectional", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getNavigation_layers() {
		return (long) super.call("get_navigation_layers", new java.lang.Object[0]);
	}

	public void setNavigation_layers(long value) {
		super.call("set_navigation_layers", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector3 getStart_position() {
		return (Vector3) super.call("get_start_position", new java.lang.Object[0]);
	}

	public void setStart_position(Vector3 value) {
		super.call("set_start_position", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getEnd_position() {
		return (Vector3) super.call("get_end_position", new java.lang.Object[0]);
	}

	public void setEnd_position(Vector3 value) {
		super.call("set_end_position", new java.lang.Object[]{(java.lang.Object) value});
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
