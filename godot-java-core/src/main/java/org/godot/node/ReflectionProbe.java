package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector3;

public class ReflectionProbe extends VisualInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_ambient_color_energy", 1740695150L),
			java.util.Map.entry("set_intensity", 373806689L), java.util.Map.entry("set_blend_distance", 373806689L),
			java.util.Map.entry("set_mesh_lod_threshold", 373806689L),
			java.util.Map.entry("is_set_as_interior", 36873697L),
			java.util.Map.entry("get_reflection_mask", 3905245786L),
			java.util.Map.entry("get_ambient_mode", 1014607621L), java.util.Map.entry("get_update_mode", 2367550552L),
			java.util.Map.entry("get_max_distance", 1740695150L),
			java.util.Map.entry("is_box_projection_enabled", 36873697L),
			java.util.Map.entry("set_update_mode", 4090221187L), java.util.Map.entry("get_cull_mask", 3905245786L),
			java.util.Map.entry("get_size", 3360562783L), java.util.Map.entry("set_ambient_mode", 1748981278L),
			java.util.Map.entry("are_shadows_enabled", 36873697L),
			java.util.Map.entry("set_reflection_mask", 1286410249L), java.util.Map.entry("set_size", 3460891852L),
			java.util.Map.entry("set_enable_box_projection", 2586408642L),
			java.util.Map.entry("set_enable_shadows", 2586408642L),
			java.util.Map.entry("get_blend_distance", 1740695150L), java.util.Map.entry("set_as_interior", 2586408642L),
			java.util.Map.entry("set_max_distance", 373806689L),
			java.util.Map.entry("set_ambient_color_energy", 373806689L),
			java.util.Map.entry("get_mesh_lod_threshold", 1740695150L),
			java.util.Map.entry("set_cull_mask", 1286410249L), java.util.Map.entry("get_intensity", 1740695150L),
			java.util.Map.entry("get_ambient_color", 3444240500L),
			java.util.Map.entry("set_origin_offset", 3460891852L),
			java.util.Map.entry("get_origin_offset", 3360562783L),
			java.util.Map.entry("set_ambient_color", 2920490490L));

	ReflectionProbe(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ReflectionProbe(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_set_as_interior() {
		return (boolean) super.call("is_set_as_interior");
	}

	public boolean is_box_projection_enabled() {
		return (boolean) super.call("is_box_projection_enabled");
	}

	public boolean are_shadows_enabled() {
		return (boolean) super.call("are_shadows_enabled");
	}

	public long getUpdate_mode() {
		return (long) super.call("get_update_mode", new java.lang.Object[0]);
	}

	public void setUpdate_mode(long value) {
		super.call("set_update_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getIntensity() {
		return (double) super.call("get_intensity", new java.lang.Object[0]);
	}

	public void setIntensity(double value) {
		super.call("set_intensity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getBlend_distance() {
		return (double) super.call("get_blend_distance", new java.lang.Object[0]);
	}

	public void setBlend_distance(double value) {
		super.call("set_blend_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMax_distance() {
		return (double) super.call("get_max_distance", new java.lang.Object[0]);
	}

	public void setMax_distance(double value) {
		super.call("set_max_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector3 getSize() {
		return (Vector3) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector3 value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getOrigin_offset() {
		return (Vector3) super.call("get_origin_offset", new java.lang.Object[0]);
	}

	public void setOrigin_offset(Vector3 value) {
		super.call("set_origin_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isBox_projection() {
		return (boolean) super.call("is_box_projection_enabled", new java.lang.Object[0]);
	}

	public void setBox_projection(boolean value) {
		super.call("set_enable_box_projection", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isInterior() {
		return (boolean) super.call("is_set_as_interior", new java.lang.Object[0]);
	}

	public void setInterior(boolean value) {
		super.call("set_as_interior", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getEnable_shadows() {
		return (boolean) super.call("are_shadows_enabled", new java.lang.Object[0]);
	}

	public void setEnable_shadows(boolean value) {
		super.call("set_enable_shadows", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getCull_mask() {
		return (long) super.call("get_cull_mask", new java.lang.Object[0]);
	}

	public void setCull_mask(long value) {
		super.call("set_cull_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getReflection_mask() {
		return (long) super.call("get_reflection_mask", new java.lang.Object[0]);
	}

	public void setReflection_mask(long value) {
		super.call("set_reflection_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getMesh_lod_threshold() {
		return (double) super.call("get_mesh_lod_threshold", new java.lang.Object[0]);
	}

	public void setMesh_lod_threshold(double value) {
		super.call("set_mesh_lod_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getAmbient_mode() {
		return (long) super.call("get_ambient_mode", new java.lang.Object[0]);
	}

	public void setAmbient_mode(long value) {
		super.call("set_ambient_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Color getAmbient_color() {
		return (Color) super.call("get_ambient_color", new java.lang.Object[0]);
	}

	public void setAmbient_color(Color value) {
		super.call("set_ambient_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getAmbient_color_energy() {
		return (double) super.call("get_ambient_color_energy", new java.lang.Object[0]);
	}

	public void setAmbient_color_energy(double value) {
		super.call("set_ambient_color_energy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
