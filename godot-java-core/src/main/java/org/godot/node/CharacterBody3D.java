package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class CharacterBody3D extends PhysicsBody3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_floor_stop_on_slope_enabled", 2586408642L),
			java.util.Map.entry("is_on_ceiling_only", 36873697L), java.util.Map.entry("get_motion_mode", 3529553604L),
			java.util.Map.entry("move_and_slide", 2240911060L), java.util.Map.entry("is_on_ceiling", 36873697L),
			java.util.Map.entry("get_safe_margin", 1740695150L),
			java.util.Map.entry("get_last_slide_collision", 186875014L), java.util.Map.entry("is_on_floor", 36873697L),
			java.util.Map.entry("is_floor_stop_on_slope_enabled", 36873697L),
			java.util.Map.entry("get_wall_normal", 3360562783L),
			java.util.Map.entry("get_slide_collision_count", 3905245786L),
			java.util.Map.entry("is_slide_on_ceiling_enabled", 36873697L),
			java.util.Map.entry("get_floor_normal", 3360562783L),
			java.util.Map.entry("get_wall_min_slide_angle", 1740695150L),
			java.util.Map.entry("get_platform_velocity", 3360562783L), java.util.Map.entry("get_velocity", 3360562783L),
			java.util.Map.entry("set_wall_min_slide_angle", 373806689L),
			java.util.Map.entry("get_platform_on_leave", 996491171L),
			java.util.Map.entry("get_slide_collision", 107003663L), java.util.Map.entry("set_motion_mode", 2690739026L),
			java.util.Map.entry("set_safe_margin", 373806689L),
			java.util.Map.entry("set_floor_snap_length", 373806689L),
			java.util.Map.entry("get_position_delta", 3360562783L),
			java.util.Map.entry("set_platform_floor_layers", 1286410249L),
			java.util.Map.entry("set_floor_max_angle", 373806689L),
			java.util.Map.entry("set_up_direction", 3460891852L), java.util.Map.entry("is_on_floor_only", 36873697L),
			java.util.Map.entry("get_platform_wall_layers", 3905245786L),
			java.util.Map.entry("set_max_slides", 1286410249L), java.util.Map.entry("get_up_direction", 3360562783L),
			java.util.Map.entry("set_platform_wall_layers", 1286410249L),
			java.util.Map.entry("get_floor_angle", 2906300789L),
			java.util.Map.entry("get_floor_snap_length", 191475506L), java.util.Map.entry("is_on_wall_only", 36873697L),
			java.util.Map.entry("get_platform_angular_velocity", 3360562783L),
			java.util.Map.entry("is_floor_constant_speed_enabled", 36873697L),
			java.util.Map.entry("set_floor_block_on_wall_enabled", 2586408642L),
			java.util.Map.entry("set_slide_on_ceiling_enabled", 2586408642L),
			java.util.Map.entry("set_platform_on_leave", 1459986142L),
			java.util.Map.entry("is_floor_block_on_wall_enabled", 36873697L),
			java.util.Map.entry("set_velocity", 3460891852L),
			java.util.Map.entry("get_platform_floor_layers", 3905245786L), java.util.Map.entry("is_on_wall", 36873697L),
			java.util.Map.entry("get_floor_max_angle", 1740695150L),
			java.util.Map.entry("set_floor_constant_speed_enabled", 2586408642L),
			java.util.Map.entry("apply_floor_snap", 3218959716L), java.util.Map.entry("get_real_velocity", 3360562783L),
			java.util.Map.entry("get_max_slides", 3905245786L), java.util.Map.entry("get_last_motion", 3360562783L));

	CharacterBody3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CharacterBody3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean move_and_slide() {
		return (boolean) super.call("move_and_slide");
	}

	public void apply_floor_snap() {
		super.call("apply_floor_snap");
	}

	public boolean is_floor_stop_on_slope_enabled() {
		return (boolean) super.call("is_floor_stop_on_slope_enabled");
	}

	public boolean is_floor_constant_speed_enabled() {
		return (boolean) super.call("is_floor_constant_speed_enabled");
	}

	public boolean is_floor_block_on_wall_enabled() {
		return (boolean) super.call("is_floor_block_on_wall_enabled");
	}

	public boolean is_slide_on_ceiling_enabled() {
		return (boolean) super.call("is_slide_on_ceiling_enabled");
	}

	public boolean is_on_floor() {
		return (boolean) super.call("is_on_floor");
	}

	public boolean is_on_floor_only() {
		return (boolean) super.call("is_on_floor_only");
	}

	public boolean is_on_ceiling() {
		return (boolean) super.call("is_on_ceiling");
	}

	public boolean is_on_ceiling_only() {
		return (boolean) super.call("is_on_ceiling_only");
	}

	public boolean is_on_wall() {
		return (boolean) super.call("is_on_wall");
	}

	public boolean is_on_wall_only() {
		return (boolean) super.call("is_on_wall_only");
	}

	public double get_floor_angle(Vector3 up_direction) {
		return (double) super.call("get_floor_angle", new java.lang.Object[]{(java.lang.Object) up_direction});
	}

	public KinematicCollision3D get_slide_collision(long slide_idx) {
		return (KinematicCollision3D) super.call("get_slide_collision",
				new java.lang.Object[]{java.lang.Long.valueOf(slide_idx)});
	}

	public long getMotion_mode() {
		return (long) super.call("get_motion_mode", new java.lang.Object[0]);
	}

	public void setMotion_mode(long value) {
		super.call("set_motion_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector3 getUp_direction() {
		return (Vector3) super.call("get_up_direction", new java.lang.Object[0]);
	}

	public void setUp_direction(Vector3 value) {
		super.call("set_up_direction", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isSlide_on_ceiling() {
		return (boolean) super.call("is_slide_on_ceiling_enabled", new java.lang.Object[0]);
	}

	public void setSlide_on_ceiling(boolean value) {
		super.call("set_slide_on_ceiling_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector3 getVelocity() {
		return (Vector3) super.call("get_velocity", new java.lang.Object[0]);
	}

	public void setVelocity(Vector3 value) {
		super.call("set_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getMax_slides() {
		return (long) super.call("get_max_slides", new java.lang.Object[0]);
	}

	public void setMax_slides(long value) {
		super.call("set_max_slides", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getWall_min_slide_angle() {
		return (double) super.call("get_wall_min_slide_angle", new java.lang.Object[0]);
	}

	public void setWall_min_slide_angle(double value) {
		super.call("set_wall_min_slide_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isFloor_stop_on_slope() {
		return (boolean) super.call("is_floor_stop_on_slope_enabled", new java.lang.Object[0]);
	}

	public void setFloor_stop_on_slope(boolean value) {
		super.call("set_floor_stop_on_slope_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isFloor_constant_speed() {
		return (boolean) super.call("is_floor_constant_speed_enabled", new java.lang.Object[0]);
	}

	public void setFloor_constant_speed(boolean value) {
		super.call("set_floor_constant_speed_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isFloor_block_on_wall() {
		return (boolean) super.call("is_floor_block_on_wall_enabled", new java.lang.Object[0]);
	}

	public void setFloor_block_on_wall(boolean value) {
		super.call("set_floor_block_on_wall_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getFloor_max_angle() {
		return (double) super.call("get_floor_max_angle", new java.lang.Object[0]);
	}

	public void setFloor_max_angle(double value) {
		super.call("set_floor_max_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFloor_snap_length() {
		return (double) super.call("get_floor_snap_length", new java.lang.Object[0]);
	}

	public void setFloor_snap_length(double value) {
		super.call("set_floor_snap_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getPlatform_on_leave() {
		return (long) super.call("get_platform_on_leave", new java.lang.Object[0]);
	}

	public void setPlatform_on_leave(long value) {
		super.call("set_platform_on_leave", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPlatform_floor_layers() {
		return (long) super.call("get_platform_floor_layers", new java.lang.Object[0]);
	}

	public void setPlatform_floor_layers(long value) {
		super.call("set_platform_floor_layers", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPlatform_wall_layers() {
		return (long) super.call("get_platform_wall_layers", new java.lang.Object[0]);
	}

	public void setPlatform_wall_layers(long value) {
		super.call("set_platform_wall_layers", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getSafe_margin() {
		return (double) super.call("get_safe_margin", new java.lang.Object[0]);
	}

	public void setSafe_margin(double value) {
		super.call("set_safe_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
