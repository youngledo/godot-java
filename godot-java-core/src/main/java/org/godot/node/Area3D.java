package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class Area3D extends CollisionObject3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_overlapping_areas", 3995934104L),
			java.util.Map.entry("get_gravity_point_unit_distance", 1740695150L),
			java.util.Map.entry("get_priority", 3905245786L),
			java.util.Map.entry("set_gravity_point_center", 3460891852L),
			java.util.Map.entry("set_reverb_uniformity", 373806689L),
			java.util.Map.entry("set_reverb_bus_name", 3304788590L),
			java.util.Map.entry("set_angular_damp", 373806689L), java.util.Map.entry("get_audio_bus_name", 2002593661L),
			java.util.Map.entry("set_wind_force_magnitude", 373806689L),
			java.util.Map.entry("get_gravity_space_override_mode", 958191869L),
			java.util.Map.entry("get_angular_damp", 1740695150L),
			java.util.Map.entry("is_overriding_audio_bus", 36873697L),
			java.util.Map.entry("get_reverb_bus_name", 2002593661L),
			java.util.Map.entry("set_linear_damp_space_override_mode", 2311433571L),
			java.util.Map.entry("get_overlapping_bodies", 3995934104L),
			java.util.Map.entry("set_angular_damp_space_override_mode", 2311433571L),
			java.util.Map.entry("is_using_reverb_bus", 36873697L),
			java.util.Map.entry("get_gravity_point_center", 3360562783L),
			java.util.Map.entry("is_gravity_a_point", 36873697L), java.util.Map.entry("get_gravity", 1740695150L),
			java.util.Map.entry("has_overlapping_areas", 36873697L),
			java.util.Map.entry("get_angular_damp_space_override_mode", 958191869L),
			java.util.Map.entry("is_monitoring", 36873697L), java.util.Map.entry("set_audio_bus_name", 3304788590L),
			java.util.Map.entry("set_gravity_space_override_mode", 2311433571L),
			java.util.Map.entry("get_gravity_direction", 3360562783L),
			java.util.Map.entry("set_linear_damp", 373806689L), java.util.Map.entry("overlaps_body", 3093956946L),
			java.util.Map.entry("get_linear_damp", 1740695150L),
			java.util.Map.entry("get_wind_attenuation_factor", 1740695150L),
			java.util.Map.entry("set_monitoring", 2586408642L), java.util.Map.entry("overlaps_area", 3093956946L),
			java.util.Map.entry("has_overlapping_bodies", 36873697L),
			java.util.Map.entry("set_audio_bus_override", 2586408642L),
			java.util.Map.entry("set_priority", 1286410249L), java.util.Map.entry("set_monitorable", 2586408642L),
			java.util.Map.entry("get_reverb_uniformity", 1740695150L),
			java.util.Map.entry("set_use_reverb_bus", 2586408642L),
			java.util.Map.entry("get_linear_damp_space_override_mode", 958191869L),
			java.util.Map.entry("get_wind_force_magnitude", 1740695150L),
			java.util.Map.entry("set_gravity", 373806689L), java.util.Map.entry("is_monitorable", 36873697L),
			java.util.Map.entry("get_reverb_amount", 1740695150L),
			java.util.Map.entry("set_wind_attenuation_factor", 373806689L),
			java.util.Map.entry("set_gravity_is_point", 2586408642L),
			java.util.Map.entry("set_reverb_amount", 373806689L),
			java.util.Map.entry("set_gravity_direction", 3460891852L),
			java.util.Map.entry("set_wind_source_path", 1348162250L),
			java.util.Map.entry("get_wind_source_path", 4075236667L),
			java.util.Map.entry("set_gravity_point_unit_distance", 373806689L));

	Area3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Area3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_gravity_a_point() {
		return (boolean) super.call("is_gravity_a_point");
	}

	public boolean is_monitorable() {
		return (boolean) super.call("is_monitorable");
	}

	public boolean is_monitoring() {
		return (boolean) super.call("is_monitoring");
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

	public boolean is_using_reverb_bus() {
		return (boolean) super.call("is_using_reverb_bus");
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

	public Vector3 getGravity_point_center() {
		return (Vector3) super.call("get_gravity_point_center", new java.lang.Object[0]);
	}

	public void setGravity_point_center(Vector3 value) {
		super.call("set_gravity_point_center", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getGravity_direction() {
		return (Vector3) super.call("get_gravity_direction", new java.lang.Object[0]);
	}

	public void setGravity_direction(Vector3 value) {
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

	public double getWind_force_magnitude() {
		return (double) super.call("get_wind_force_magnitude", new java.lang.Object[0]);
	}

	public void setWind_force_magnitude(double value) {
		super.call("set_wind_force_magnitude", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getWind_attenuation_factor() {
		return (double) super.call("get_wind_attenuation_factor", new java.lang.Object[0]);
	}

	public void setWind_attenuation_factor(double value) {
		super.call("set_wind_attenuation_factor", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public String getWind_source_path() {
		return (String) super.call("get_wind_source_path", new java.lang.Object[0]);
	}

	public void setWind_source_path(String value) {
		super.call("set_wind_source_path", new java.lang.Object[]{(java.lang.Object) value});
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

	public boolean isReverb_bus_enabled() {
		return (boolean) super.call("is_using_reverb_bus", new java.lang.Object[0]);
	}

	public void setReverb_bus_enabled(boolean value) {
		super.call("set_use_reverb_bus", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getReverb_bus_name() {
		return (String) super.call("get_reverb_bus_name", new java.lang.Object[0]);
	}

	public void setReverb_bus_name(String value) {
		super.call("set_reverb_bus_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getReverb_bus_amount() {
		return (double) super.call("get_reverb_amount", new java.lang.Object[0]);
	}

	public void setReverb_bus_amount(double value) {
		super.call("set_reverb_amount", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getReverb_bus_uniformity() {
		return (double) super.call("get_reverb_uniformity", new java.lang.Object[0]);
	}

	public void setReverb_bus_uniformity(double value) {
		super.call("set_reverb_uniformity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
