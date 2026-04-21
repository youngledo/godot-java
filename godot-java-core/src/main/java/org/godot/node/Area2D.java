package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class Area2D extends CollisionObject2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_overlapping_areas", 3995934104L),
			java.util.Map.entry("get_gravity_point_unit_distance", 1740695150L),
			java.util.Map.entry("overlaps_body", 3093956946L), java.util.Map.entry("get_priority", 3905245786L),
			java.util.Map.entry("set_gravity_point_center", 743155724L),
			java.util.Map.entry("get_linear_damp", 1740695150L), java.util.Map.entry("set_monitoring", 2586408642L),
			java.util.Map.entry("set_angular_damp", 373806689L), java.util.Map.entry("overlaps_area", 3093956946L),
			java.util.Map.entry("get_audio_bus_name", 2002593661L),
			java.util.Map.entry("has_overlapping_bodies", 36873697L),
			java.util.Map.entry("get_gravity_space_override_mode", 3990256304L),
			java.util.Map.entry("get_angular_damp", 1740695150L),
			java.util.Map.entry("is_overriding_audio_bus", 36873697L),
			java.util.Map.entry("set_linear_damp_space_override_mode", 2879900038L),
			java.util.Map.entry("get_overlapping_bodies", 3995934104L),
			java.util.Map.entry("set_angular_damp_space_override_mode", 2879900038L),
			java.util.Map.entry("set_audio_bus_override", 2586408642L),
			java.util.Map.entry("get_gravity_point_center", 3341600327L),
			java.util.Map.entry("set_priority", 1286410249L), java.util.Map.entry("set_monitorable", 2586408642L),
			java.util.Map.entry("is_gravity_a_point", 36873697L), java.util.Map.entry("get_gravity", 1740695150L),
			java.util.Map.entry("has_overlapping_areas", 36873697L),
			java.util.Map.entry("get_linear_damp_space_override_mode", 3990256304L),
			java.util.Map.entry("get_angular_damp_space_override_mode", 3990256304L),
			java.util.Map.entry("is_monitoring", 36873697L), java.util.Map.entry("set_gravity", 373806689L),
			java.util.Map.entry("is_monitorable", 36873697L), java.util.Map.entry("set_audio_bus_name", 3304788590L),
			java.util.Map.entry("set_gravity_space_override_mode", 2879900038L),
			java.util.Map.entry("set_gravity_is_point", 2586408642L),
			java.util.Map.entry("set_gravity_direction", 743155724L),
			java.util.Map.entry("get_gravity_direction", 3341600327L),
			java.util.Map.entry("set_linear_damp", 373806689L),
			java.util.Map.entry("set_gravity_point_unit_distance", 373806689L));

	Area2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Area2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_gravity_a_point() {
		return (boolean) super.call("is_gravity_a_point");
	}

	public boolean is_monitoring() {
		return (boolean) super.call("is_monitoring");
	}

	public boolean is_monitorable() {
		return (boolean) super.call("is_monitorable");
	}

	public boolean has_overlapping_bodies() {
		return (boolean) super.call("has_overlapping_bodies");
	}

	public boolean has_overlapping_areas() {
		return (boolean) super.call("has_overlapping_areas");
	}

	public boolean overlaps_body(Node body) {
		return (boolean) super.call("overlaps_body", new java.lang.Object[]{(java.lang.Object) body});
	}

	public boolean overlaps_area(Node area) {
		return (boolean) super.call("overlaps_area", new java.lang.Object[]{(java.lang.Object) area});
	}

	public boolean is_overriding_audio_bus() {
		return (boolean) super.call("is_overriding_audio_bus");
	}

	public boolean isMonitoring() {
		return (boolean) super.call("is_monitoring", new java.lang.Object[0]);
	}

	public void setMonitoring(boolean value) {
		super.call("set_monitoring", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isMonitorable() {
		return (boolean) super.call("is_monitorable", new java.lang.Object[0]);
	}

	public void setMonitorable(boolean value) {
		super.call("set_monitorable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getPriority() {
		return (long) super.call("get_priority", new java.lang.Object[0]);
	}

	public void setPriority(long value) {
		super.call("set_priority", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getGravity_space_override() {
		return (long) super.call("get_gravity_space_override_mode", new java.lang.Object[0]);
	}

	public void setGravity_space_override(long value) {
		super.call("set_gravity_space_override_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isGravity_point() {
		return (boolean) super.call("is_gravity_a_point", new java.lang.Object[0]);
	}

	public void setGravity_point(boolean value) {
		super.call("set_gravity_is_point", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getGravity_point_unit_distance() {
		return (double) super.call("get_gravity_point_unit_distance", new java.lang.Object[0]);
	}

	public void setGravity_point_unit_distance(double value) {
		super.call("set_gravity_point_unit_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getGravity_point_center() {
		return (Vector2) super.call("get_gravity_point_center", new java.lang.Object[0]);
	}

	public void setGravity_point_center(Vector2 value) {
		super.call("set_gravity_point_center", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getGravity_direction() {
		return (Vector2) super.call("get_gravity_direction", new java.lang.Object[0]);
	}

	public void setGravity_direction(Vector2 value) {
		super.call("set_gravity_direction", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getGravity() {
		return (double) super.call("get_gravity", new java.lang.Object[0]);
	}

	public void setGravity(double value) {
		super.call("set_gravity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getLinear_damp_space_override() {
		return (long) super.call("get_linear_damp_space_override_mode", new java.lang.Object[0]);
	}

	public void setLinear_damp_space_override(long value) {
		super.call("set_linear_damp_space_override_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getLinear_damp() {
		return (double) super.call("get_linear_damp", new java.lang.Object[0]);
	}

	public void setLinear_damp(double value) {
		super.call("set_linear_damp", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getAngular_damp_space_override() {
		return (long) super.call("get_angular_damp_space_override_mode", new java.lang.Object[0]);
	}

	public void setAngular_damp_space_override(long value) {
		super.call("set_angular_damp_space_override_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getAngular_damp() {
		return (double) super.call("get_angular_damp", new java.lang.Object[0]);
	}

	public void setAngular_damp(double value) {
		super.call("set_angular_damp", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isAudio_bus_override() {
		return (boolean) super.call("is_overriding_audio_bus", new java.lang.Object[0]);
	}

	public void setAudio_bus_override(boolean value) {
		super.call("set_audio_bus_override", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getAudio_bus_name() {
		return (String) super.call("get_audio_bus_name", new java.lang.Object[0]);
	}

	public void setAudio_bus_name(String value) {
		super.call("set_audio_bus_name", new java.lang.Object[]{(java.lang.Object) value});
	}
}
