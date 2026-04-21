package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;
import org.godot.math.Vector3;

public class Camera3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_keep_aspect_mode", 1740651252L), java.util.Map.entry("get_frustum", 3995934104L),
			java.util.Map.entry("get_cull_mask_value", 1116898809L), java.util.Map.entry("get_projection", 2624185235L),
			java.util.Map.entry("set_projection", 4218540108L), java.util.Map.entry("set_attributes", 2817810567L),
			java.util.Map.entry("set_environment", 4143518816L), java.util.Map.entry("make_current", 3218959716L),
			java.util.Map.entry("get_h_offset", 1740695150L), java.util.Map.entry("get_v_offset", 1740695150L),
			java.util.Map.entry("get_attributes", 3921283215L), java.util.Map.entry("get_cull_mask", 3905245786L),
			java.util.Map.entry("get_size", 1740695150L), java.util.Map.entry("get_camera_rid", 2944877500L),
			java.util.Map.entry("set_perspective", 2385087082L), java.util.Map.entry("set_v_offset", 373806689L),
			java.util.Map.entry("project_ray_normal", 1718073306L), java.util.Map.entry("get_far", 1740695150L),
			java.util.Map.entry("set_fov", 373806689L), java.util.Map.entry("set_orthogonal", 2385087082L),
			java.util.Map.entry("set_doppler_tracking", 3109431270L),
			java.util.Map.entry("get_keep_aspect_mode", 2790278316L),
			java.util.Map.entry("project_local_ray_normal", 1718073306L),
			java.util.Map.entry("set_cull_mask_value", 300928843L), java.util.Map.entry("set_compositor", 1586754307L),
			java.util.Map.entry("set_frustum", 354890663L), java.util.Map.entry("project_position", 2171975744L),
			java.util.Map.entry("get_camera_projection", 2910717950L), java.util.Map.entry("set_near", 373806689L),
			java.util.Map.entry("is_position_behind", 3108956480L),
			java.util.Map.entry("project_ray_origin", 1718073306L), java.util.Map.entry("get_near", 1740695150L),
			java.util.Map.entry("get_doppler_tracking", 1584483649L),
			java.util.Map.entry("set_frustum_offset", 743155724L),
			java.util.Map.entry("unproject_position", 3758901831L), java.util.Map.entry("set_h_offset", 373806689L),
			java.util.Map.entry("get_pyramid_shape_rid", 529393457L),
			java.util.Map.entry("get_environment", 3082064660L), java.util.Map.entry("set_size", 373806689L),
			java.util.Map.entry("clear_current", 3216645846L), java.util.Map.entry("get_frustum_offset", 3341600327L),
			java.util.Map.entry("get_compositor", 3647707413L), java.util.Map.entry("get_fov", 1740695150L),
			java.util.Map.entry("set_current", 2586408642L), java.util.Map.entry("set_far", 373806689L),
			java.util.Map.entry("set_cull_mask", 1286410249L), java.util.Map.entry("get_camera_transform", 3229777777L),
			java.util.Map.entry("is_current", 36873697L), java.util.Map.entry("is_position_in_frustum", 3108956480L));

	Camera3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Camera3D(long nativePointer) {
		super(nativePointer);
	}

	public Vector3 project_ray_normal(Vector2 screen_point) {
		return (Vector3) super.call("project_ray_normal", new java.lang.Object[]{(java.lang.Object) screen_point});
	}

	public Vector3 project_local_ray_normal(Vector2 screen_point) {
		return (Vector3) super.call("project_local_ray_normal",
				new java.lang.Object[]{(java.lang.Object) screen_point});
	}

	public Vector3 project_ray_origin(Vector2 screen_point) {
		return (Vector3) super.call("project_ray_origin", new java.lang.Object[]{(java.lang.Object) screen_point});
	}

	public Vector2 unproject_position(Vector3 world_point) {
		return (Vector2) super.call("unproject_position", new java.lang.Object[]{(java.lang.Object) world_point});
	}

	public boolean is_position_behind(Vector3 world_point) {
		return (boolean) super.call("is_position_behind", new java.lang.Object[]{(java.lang.Object) world_point});
	}

	public Vector3 project_position(Vector2 screen_point, double z_depth) {
		return (Vector3) super.call("project_position",
				new java.lang.Object[]{(java.lang.Object) screen_point, java.lang.Double.valueOf(z_depth)});
	}

	public void set_perspective(double fov, double z_near, double z_far) {
		super.call("set_perspective", new java.lang.Object[]{java.lang.Double.valueOf(fov),
				java.lang.Double.valueOf(z_near), java.lang.Double.valueOf(z_far)});
	}

	public void set_orthogonal(double size, double z_near, double z_far) {
		super.call("set_orthogonal", new java.lang.Object[]{java.lang.Double.valueOf(size),
				java.lang.Double.valueOf(z_near), java.lang.Double.valueOf(z_far)});
	}

	public void set_frustum(double size, Vector2 offset, double z_near, double z_far) {
		super.call("set_frustum", new java.lang.Object[]{java.lang.Double.valueOf(size), (java.lang.Object) offset,
				java.lang.Double.valueOf(z_near), java.lang.Double.valueOf(z_far)});
	}

	public void make_current() {
		super.call("make_current");
	}

	public void clear_current(boolean enable_next) {
		super.call("clear_current", new java.lang.Object[]{java.lang.Boolean.valueOf(enable_next)});
	}

	public boolean is_current() {
		return (boolean) super.call("is_current");
	}

	public boolean is_position_in_frustum(Vector3 world_point) {
		return (boolean) super.call("is_position_in_frustum", new java.lang.Object[]{(java.lang.Object) world_point});
	}

	public void set_cull_mask_value(long layer_number, boolean value) {
		super.call("set_cull_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_cull_mask_value(long layer_number) {
		return (boolean) super.call("get_cull_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public long getKeep_aspect() {
		return (long) super.call("get_keep_aspect_mode", new java.lang.Object[0]);
	}

	public void setKeep_aspect(long value) {
		super.call("set_keep_aspect_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCull_mask() {
		return (long) super.call("get_cull_mask", new java.lang.Object[0]);
	}

	public void setCull_mask(long value) {
		super.call("set_cull_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Environment getEnvironment() {
		return (Environment) super.call("get_environment", new java.lang.Object[0]);
	}

	public void setEnvironment(Environment value) {
		super.call("set_environment", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Object getAttributes() {
		return (Object) super.call("get_attributes", new java.lang.Object[0]);
	}

	public void setAttributes(Object value) {
		super.call("set_attributes", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Compositor getCompositor() {
		return (Compositor) super.call("get_compositor", new java.lang.Object[0]);
	}

	public void setCompositor(Compositor value) {
		super.call("set_compositor", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getH_offset() {
		return (double) super.call("get_h_offset", new java.lang.Object[0]);
	}

	public void setH_offset(double value) {
		super.call("set_h_offset", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getV_offset() {
		return (double) super.call("get_v_offset", new java.lang.Object[0]);
	}

	public void setV_offset(double value) {
		super.call("set_v_offset", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getDoppler_tracking() {
		return (long) super.call("get_doppler_tracking", new java.lang.Object[0]);
	}

	public void setDoppler_tracking(long value) {
		super.call("set_doppler_tracking", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getProjection() {
		return (long) super.call("get_projection", new java.lang.Object[0]);
	}

	public void setProjection(long value) {
		super.call("set_projection", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isCurrent() {
		return (boolean) super.call("is_current", new java.lang.Object[0]);
	}

	public void setCurrent(boolean value) {
		super.call("set_current", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getFov() {
		return (double) super.call("get_fov", new java.lang.Object[0]);
	}

	public void setFov(double value) {
		super.call("set_fov", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSize() {
		return (double) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(double value) {
		super.call("set_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getFrustum_offset() {
		return (Vector2) super.call("get_frustum_offset", new java.lang.Object[0]);
	}

	public void setFrustum_offset(Vector2 value) {
		super.call("set_frustum_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getNear() {
		return (double) super.call("get_near", new java.lang.Object[0]);
	}

	public void setNear(double value) {
		super.call("set_near", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFar() {
		return (double) super.call("get_far", new java.lang.Object[0]);
	}

	public void setFar(double value) {
		super.call("set_far", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
