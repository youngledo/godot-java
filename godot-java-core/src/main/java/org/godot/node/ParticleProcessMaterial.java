package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector2;
import org.godot.math.Vector3;

public class ParticleProcessMaterial extends Material {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_emission_ring_cone_angle", 373806689L),
			java.util.Map.entry("set_inherit_velocity_ratio", 373806689L),
			java.util.Map.entry("set_sub_emitter_amount_at_start", 1286410249L),
			java.util.Map.entry("get_sub_emitter_mode", 2399052877L),
			java.util.Map.entry("get_emission_ring_height", 1740695150L),
			java.util.Map.entry("is_attractor_interaction_enabled", 36873697L),
			java.util.Map.entry("set_particle_flag", 1711815571L),
			java.util.Map.entry("get_emission_point_texture", 3635182373L),
			java.util.Map.entry("set_emission_ring_axis", 3460891852L),
			java.util.Map.entry("set_emission_ring_radius", 373806689L),
			java.util.Map.entry("set_emission_ring_inner_radius", 373806689L),
			java.util.Map.entry("get_emission_box_extents", 3360562783L),
			java.util.Map.entry("set_emission_normal_texture", 4051416890L),
			java.util.Map.entry("set_direction", 3460891852L), java.util.Map.entry("get_direction", 3360562783L),
			java.util.Map.entry("is_collision_using_scale", 36873697L),
			java.util.Map.entry("set_alpha_curve", 4051416890L),
			java.util.Map.entry("set_sub_emitter_frequency", 373806689L),
			java.util.Map.entry("set_lifetime_randomness", 373806689L),
			java.util.Map.entry("get_param_max", 3903786503L),
			java.util.Map.entry("get_emission_sphere_radius", 1740695150L),
			java.util.Map.entry("set_turbulence_enabled", 2586408642L), java.util.Map.entry("get_gravity", 3360562783L),
			java.util.Map.entry("set_flatness", 373806689L),
			java.util.Map.entry("set_emission_ring_height", 373806689L),
			java.util.Map.entry("set_sub_emitter_amount_at_end", 1286410249L),
			java.util.Map.entry("set_param", 676779352L),
			java.util.Map.entry("set_emission_color_texture", 4051416890L),
			java.util.Map.entry("get_emission_shape", 3719733018L),
			java.util.Map.entry("get_emission_normal_texture", 3635182373L),
			java.util.Map.entry("get_turbulence_noise_strength", 1740695150L),
			java.util.Map.entry("set_sub_emitter_keep_velocity", 2586408642L),
			java.util.Map.entry("set_emission_shape_offset", 3460891852L),
			java.util.Map.entry("get_collision_friction", 1740695150L),
			java.util.Map.entry("set_color_initial_ramp", 4051416890L),
			java.util.Map.entry("get_particle_flag", 3895316907L),
			java.util.Map.entry("set_velocity_pivot", 3460891852L),
			java.util.Map.entry("set_emission_shape_scale", 3460891852L),
			java.util.Map.entry("set_sub_emitter_amount_at_collision", 1286410249L),
			java.util.Map.entry("get_alpha_curve", 3635182373L), java.util.Map.entry("get_param", 2623708480L),
			java.util.Map.entry("get_emission_curve", 3635182373L), java.util.Map.entry("set_param_max", 2295964248L),
			java.util.Map.entry("get_emission_shape_scale", 3360562783L),
			java.util.Map.entry("get_sub_emitter_keep_velocity", 36873697L),
			java.util.Map.entry("set_emission_point_count", 1286410249L),
			java.util.Map.entry("set_turbulence_noise_speed", 3460891852L),
			java.util.Map.entry("get_flatness", 1740695150L),
			java.util.Map.entry("get_sub_emitter_frequency", 1740695150L),
			java.util.Map.entry("get_inherit_velocity_ratio", 191475506L),
			java.util.Map.entry("set_collision_mode", 653804659L), java.util.Map.entry("get_color", 3444240500L),
			java.util.Map.entry("set_emission_shape", 461501442L),
			java.util.Map.entry("set_emission_box_extents", 3460891852L),
			java.util.Map.entry("get_turbulence_noise_speed_random", 1740695150L),
			java.util.Map.entry("set_param_min", 2295964248L),
			java.util.Map.entry("set_emission_point_texture", 4051416890L),
			java.util.Map.entry("get_velocity_limit_curve", 3635182373L),
			java.util.Map.entry("set_turbulence_noise_scale", 373806689L),
			java.util.Map.entry("get_param_min", 3903786503L), java.util.Map.entry("get_spread", 1740695150L),
			java.util.Map.entry("get_param_texture", 3489372978L),
			java.util.Map.entry("set_velocity_limit_curve", 4051416890L),
			java.util.Map.entry("set_param_texture", 526976089L), java.util.Map.entry("get_color_ramp", 3635182373L),
			java.util.Map.entry("get_sub_emitter_amount_at_end", 3905245786L),
			java.util.Map.entry("set_sub_emitter_mode", 2161806672L),
			java.util.Map.entry("set_turbulence_noise_speed_random", 373806689L),
			java.util.Map.entry("set_spread", 373806689L),
			java.util.Map.entry("set_turbulence_noise_strength", 373806689L),
			java.util.Map.entry("get_emission_ring_radius", 1740695150L),
			java.util.Map.entry("set_color_ramp", 4051416890L),
			java.util.Map.entry("set_collision_use_scale", 2586408642L),
			java.util.Map.entry("set_collision_bounce", 373806689L),
			java.util.Map.entry("get_velocity_pivot", 3783033775L),
			java.util.Map.entry("get_sub_emitter_amount_at_collision", 3905245786L),
			java.util.Map.entry("get_emission_ring_cone_angle", 1740695150L),
			java.util.Map.entry("set_attractor_interaction_enabled", 2586408642L),
			java.util.Map.entry("set_color", 2920490490L),
			java.util.Map.entry("get_sub_emitter_amount_at_start", 3905245786L),
			java.util.Map.entry("set_collision_friction", 373806689L),
			java.util.Map.entry("set_emission_sphere_radius", 373806689L),
			java.util.Map.entry("set_emission_curve", 4051416890L),
			java.util.Map.entry("get_emission_color_texture", 3635182373L),
			java.util.Map.entry("set_gravity", 3460891852L),
			java.util.Map.entry("get_emission_ring_inner_radius", 1740695150L),
			java.util.Map.entry("get_turbulence_enabled", 36873697L),
			java.util.Map.entry("get_collision_mode", 139371864L),
			java.util.Map.entry("get_emission_ring_axis", 3360562783L),
			java.util.Map.entry("get_turbulence_noise_speed", 3360562783L),
			java.util.Map.entry("get_color_initial_ramp", 3635182373L),
			java.util.Map.entry("get_emission_shape_offset", 3360562783L),
			java.util.Map.entry("get_turbulence_noise_scale", 1740695150L),
			java.util.Map.entry("get_emission_point_count", 3905245786L),
			java.util.Map.entry("get_lifetime_randomness", 1740695150L),
			java.util.Map.entry("get_collision_bounce", 1740695150L));

	ParticleProcessMaterial(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ParticleProcessMaterial(long nativePointer) {
		super(nativePointer);
	}

	public void set_param(int param, Vector2 value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Integer.valueOf(param), (java.lang.Object) value});
	}

	public Vector2 get_param(int param) {
		return (Vector2) super.call("get_param", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}

	public void set_param_min(int param, double value) {
		super.call("set_param_min",
				new java.lang.Object[]{java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double get_param_min(int param) {
		return (double) super.call("get_param_min", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}

	public void set_param_max(int param, double value) {
		super.call("set_param_max",
				new java.lang.Object[]{java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double get_param_max(int param) {
		return (double) super.call("get_param_max", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}

	public void set_param_texture(int param, Texture2D texture) {
		super.call("set_param_texture",
				new java.lang.Object[]{java.lang.Integer.valueOf(param), (java.lang.Object) texture});
	}

	public Texture2D get_param_texture(int param) {
		return (Texture2D) super.call("get_param_texture", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}

	public void set_particle_flag(int particle_flag, boolean enable) {
		super.call("set_particle_flag",
				new java.lang.Object[]{java.lang.Integer.valueOf(particle_flag), java.lang.Boolean.valueOf(enable)});
	}

	public boolean get_particle_flag(int particle_flag) {
		return (boolean) super.call("get_particle_flag",
				new java.lang.Object[]{java.lang.Integer.valueOf(particle_flag)});
	}

	public boolean is_attractor_interaction_enabled() {
		return (boolean) super.call("is_attractor_interaction_enabled");
	}

	public boolean is_collision_using_scale() {
		return (boolean) super.call("is_collision_using_scale");
	}

	public double getLifetime_randomness() {
		return (double) super.call("get_lifetime_randomness", new java.lang.Object[0]);
	}

	public void setLifetime_randomness(double value) {
		super.call("set_lifetime_randomness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getParticle_flag_align_y() {
		return (boolean) super.call("get_particle_flag", new java.lang.Object[0]);
	}

	public void setParticle_flag_align_y(boolean value) {
		super.call("set_particle_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getParticle_flag_rotate_y() {
		return (boolean) super.call("get_particle_flag", new java.lang.Object[0]);
	}

	public void setParticle_flag_rotate_y(boolean value) {
		super.call("set_particle_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getParticle_flag_disable_z() {
		return (boolean) super.call("get_particle_flag", new java.lang.Object[0]);
	}

	public void setParticle_flag_disable_z(boolean value) {
		super.call("set_particle_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getParticle_flag_damping_as_friction() {
		return (boolean) super.call("get_particle_flag", new java.lang.Object[0]);
	}

	public void setParticle_flag_damping_as_friction(boolean value) {
		super.call("set_particle_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector3 getEmission_shape_offset() {
		return (Vector3) super.call("get_emission_shape_offset", new java.lang.Object[0]);
	}

	public void setEmission_shape_offset(Vector3 value) {
		super.call("set_emission_shape_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getEmission_shape_scale() {
		return (Vector3) super.call("get_emission_shape_scale", new java.lang.Object[0]);
	}

	public void setEmission_shape_scale(Vector3 value) {
		super.call("set_emission_shape_scale", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getEmission_shape() {
		return (long) super.call("get_emission_shape", new java.lang.Object[0]);
	}

	public void setEmission_shape(long value) {
		super.call("set_emission_shape", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getEmission_sphere_radius() {
		return (double) super.call("get_emission_sphere_radius", new java.lang.Object[0]);
	}

	public void setEmission_sphere_radius(double value) {
		super.call("set_emission_sphere_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector3 getEmission_box_extents() {
		return (Vector3) super.call("get_emission_box_extents", new java.lang.Object[0]);
	}

	public void setEmission_box_extents(Vector3 value) {
		super.call("set_emission_box_extents", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getEmission_point_texture() {
		return (Texture2D) super.call("get_emission_point_texture", new java.lang.Object[0]);
	}

	public void setEmission_point_texture(Texture2D value) {
		super.call("set_emission_point_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getEmission_normal_texture() {
		return (Texture2D) super.call("get_emission_normal_texture", new java.lang.Object[0]);
	}

	public void setEmission_normal_texture(Texture2D value) {
		super.call("set_emission_normal_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getEmission_color_texture() {
		return (Texture2D) super.call("get_emission_color_texture", new java.lang.Object[0]);
	}

	public void setEmission_color_texture(Texture2D value) {
		super.call("set_emission_color_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getEmission_point_count() {
		return (long) super.call("get_emission_point_count", new java.lang.Object[0]);
	}

	public void setEmission_point_count(long value) {
		super.call("set_emission_point_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector3 getEmission_ring_axis() {
		return (Vector3) super.call("get_emission_ring_axis", new java.lang.Object[0]);
	}

	public void setEmission_ring_axis(Vector3 value) {
		super.call("set_emission_ring_axis", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getEmission_ring_height() {
		return (double) super.call("get_emission_ring_height", new java.lang.Object[0]);
	}

	public void setEmission_ring_height(double value) {
		super.call("set_emission_ring_height", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getEmission_ring_radius() {
		return (double) super.call("get_emission_ring_radius", new java.lang.Object[0]);
	}

	public void setEmission_ring_radius(double value) {
		super.call("set_emission_ring_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getEmission_ring_inner_radius() {
		return (double) super.call("get_emission_ring_inner_radius", new java.lang.Object[0]);
	}

	public void setEmission_ring_inner_radius(double value) {
		super.call("set_emission_ring_inner_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getEmission_ring_cone_angle() {
		return (double) super.call("get_emission_ring_cone_angle", new java.lang.Object[0]);
	}

	public void setEmission_ring_cone_angle(double value) {
		super.call("set_emission_ring_cone_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getAngle() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setAngle(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getAngle_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setAngle_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAngle_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setAngle_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public CurveTexture getAngle_curve() {
		return (CurveTexture) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setAngle_curve(CurveTexture value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getInherit_velocity_ratio() {
		return (double) super.call("get_inherit_velocity_ratio", new java.lang.Object[0]);
	}

	public void setInherit_velocity_ratio(double value) {
		super.call("set_inherit_velocity_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector3 getVelocity_pivot() {
		return (Vector3) super.call("get_velocity_pivot", new java.lang.Object[0]);
	}

	public void setVelocity_pivot(Vector3 value) {
		super.call("set_velocity_pivot", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getDirection() {
		return (Vector3) super.call("get_direction", new java.lang.Object[0]);
	}

	public void setDirection(Vector3 value) {
		super.call("set_direction", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getSpread() {
		return (double) super.call("get_spread", new java.lang.Object[0]);
	}

	public void setSpread(double value) {
		super.call("set_spread", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFlatness() {
		return (double) super.call("get_flatness", new java.lang.Object[0]);
	}

	public void setFlatness(double value) {
		super.call("set_flatness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getInitial_velocity() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setInitial_velocity(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getInitial_velocity_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setInitial_velocity_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getInitial_velocity_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setInitial_velocity_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getAngular_velocity() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setAngular_velocity(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getAngular_velocity_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setAngular_velocity_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAngular_velocity_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setAngular_velocity_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public CurveTexture getAngular_velocity_curve() {
		return (CurveTexture) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setAngular_velocity_curve(CurveTexture value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getDirectional_velocity() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setDirectional_velocity(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getDirectional_velocity_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setDirectional_velocity_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDirectional_velocity_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setDirectional_velocity_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public CurveXYZTexture getDirectional_velocity_curve() {
		return (CurveXYZTexture) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setDirectional_velocity_curve(CurveXYZTexture value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getOrbit_velocity() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setOrbit_velocity(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getOrbit_velocity_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setOrbit_velocity_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getOrbit_velocity_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setOrbit_velocity_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Object getOrbit_velocity_curve() {
		return (Object) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setOrbit_velocity_curve(Object value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getRadial_velocity() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setRadial_velocity(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getRadial_velocity_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setRadial_velocity_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRadial_velocity_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setRadial_velocity_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public CurveTexture getRadial_velocity_curve() {
		return (CurveTexture) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setRadial_velocity_curve(CurveTexture value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public CurveTexture getVelocity_limit_curve() {
		return (CurveTexture) super.call("get_velocity_limit_curve", new java.lang.Object[0]);
	}

	public void setVelocity_limit_curve(CurveTexture value) {
		super.call("set_velocity_limit_curve", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getGravity() {
		return (Vector3) super.call("get_gravity", new java.lang.Object[0]);
	}

	public void setGravity(Vector3 value) {
		super.call("set_gravity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getLinear_accel() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setLinear_accel(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getLinear_accel_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setLinear_accel_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getLinear_accel_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setLinear_accel_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public CurveTexture getLinear_accel_curve() {
		return (CurveTexture) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setLinear_accel_curve(CurveTexture value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getRadial_accel() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setRadial_accel(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getRadial_accel_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setRadial_accel_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRadial_accel_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setRadial_accel_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public CurveTexture getRadial_accel_curve() {
		return (CurveTexture) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setRadial_accel_curve(CurveTexture value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getTangential_accel() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setTangential_accel(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getTangential_accel_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setTangential_accel_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTangential_accel_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setTangential_accel_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public CurveTexture getTangential_accel_curve() {
		return (CurveTexture) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setTangential_accel_curve(CurveTexture value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getDamping() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setDamping(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getDamping_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setDamping_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDamping_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setDamping_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public CurveTexture getDamping_curve() {
		return (CurveTexture) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setDamping_curve(CurveTexture value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isAttractor_interaction_enabled() {
		return (boolean) super.call("is_attractor_interaction_enabled", new java.lang.Object[0]);
	}

	public void setAttractor_interaction_enabled(boolean value) {
		super.call("set_attractor_interaction_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getScale() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setScale(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getScale_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setScale_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getScale_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setScale_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Object getScale_curve() {
		return (Object) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setScale_curve(Object value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getScale_over_velocity() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setScale_over_velocity(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getScale_over_velocity_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setScale_over_velocity_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getScale_over_velocity_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setScale_over_velocity_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Object getScale_over_velocity_curve() {
		return (Object) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setScale_over_velocity_curve(Object value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getColor() {
		return (Color) super.call("get_color", new java.lang.Object[0]);
	}

	public void setColor(Color value) {
		super.call("set_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GradientTexture1D getColor_ramp() {
		return (GradientTexture1D) super.call("get_color_ramp", new java.lang.Object[0]);
	}

	public void setColor_ramp(GradientTexture1D value) {
		super.call("set_color_ramp", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GradientTexture1D getColor_initial_ramp() {
		return (GradientTexture1D) super.call("get_color_initial_ramp", new java.lang.Object[0]);
	}

	public void setColor_initial_ramp(GradientTexture1D value) {
		super.call("set_color_initial_ramp", new java.lang.Object[]{(java.lang.Object) value});
	}

	public CurveTexture getAlpha_curve() {
		return (CurveTexture) super.call("get_alpha_curve", new java.lang.Object[0]);
	}

	public void setAlpha_curve(CurveTexture value) {
		super.call("set_alpha_curve", new java.lang.Object[]{(java.lang.Object) value});
	}

	public CurveTexture getEmission_curve() {
		return (CurveTexture) super.call("get_emission_curve", new java.lang.Object[0]);
	}

	public void setEmission_curve(CurveTexture value) {
		super.call("set_emission_curve", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getHue_variation() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setHue_variation(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getHue_variation_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setHue_variation_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getHue_variation_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setHue_variation_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public CurveTexture getHue_variation_curve() {
		return (CurveTexture) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setHue_variation_curve(CurveTexture value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getAnim_speed() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setAnim_speed(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getAnim_speed_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setAnim_speed_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAnim_speed_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setAnim_speed_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public CurveTexture getAnim_speed_curve() {
		return (CurveTexture) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setAnim_speed_curve(CurveTexture value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getAnim_offset() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setAnim_offset(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getAnim_offset_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setAnim_offset_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAnim_offset_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setAnim_offset_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public CurveTexture getAnim_offset_curve() {
		return (CurveTexture) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setAnim_offset_curve(CurveTexture value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getTurbulence_enabled() {
		return (boolean) super.call("get_turbulence_enabled", new java.lang.Object[0]);
	}

	public void setTurbulence_enabled(boolean value) {
		super.call("set_turbulence_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getTurbulence_noise_strength() {
		return (double) super.call("get_turbulence_noise_strength", new java.lang.Object[0]);
	}

	public void setTurbulence_noise_strength(double value) {
		super.call("set_turbulence_noise_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTurbulence_noise_scale() {
		return (double) super.call("get_turbulence_noise_scale", new java.lang.Object[0]);
	}

	public void setTurbulence_noise_scale(double value) {
		super.call("set_turbulence_noise_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector3 getTurbulence_noise_speed() {
		return (Vector3) super.call("get_turbulence_noise_speed", new java.lang.Object[0]);
	}

	public void setTurbulence_noise_speed(Vector3 value) {
		super.call("set_turbulence_noise_speed", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getTurbulence_noise_speed_random() {
		return (double) super.call("get_turbulence_noise_speed_random", new java.lang.Object[0]);
	}

	public void setTurbulence_noise_speed_random(double value) {
		super.call("set_turbulence_noise_speed_random", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getTurbulence_influence() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setTurbulence_influence(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getTurbulence_influence_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setTurbulence_influence_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTurbulence_influence_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setTurbulence_influence_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getTurbulence_initial_displacement() {
		return (Vector2) super.call("get_param", new java.lang.Object[0]);
	}

	public void setTurbulence_initial_displacement(Vector2 value) {
		super.call("set_param", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getTurbulence_initial_displacement_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setTurbulence_initial_displacement_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTurbulence_initial_displacement_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setTurbulence_initial_displacement_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public CurveTexture getTurbulence_influence_over_life() {
		return (CurveTexture) super.call("get_param_texture", new java.lang.Object[0]);
	}

	public void setTurbulence_influence_over_life(CurveTexture value) {
		super.call("set_param_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getCollision_mode() {
		return (long) super.call("get_collision_mode", new java.lang.Object[0]);
	}

	public void setCollision_mode(long value) {
		super.call("set_collision_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getCollision_friction() {
		return (double) super.call("get_collision_friction", new java.lang.Object[0]);
	}

	public void setCollision_friction(double value) {
		super.call("set_collision_friction", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getCollision_bounce() {
		return (double) super.call("get_collision_bounce", new java.lang.Object[0]);
	}

	public void setCollision_bounce(double value) {
		super.call("set_collision_bounce", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isCollision_use_scale() {
		return (boolean) super.call("is_collision_using_scale", new java.lang.Object[0]);
	}

	public void setCollision_use_scale(boolean value) {
		super.call("set_collision_use_scale", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSub_emitter_mode() {
		return (long) super.call("get_sub_emitter_mode", new java.lang.Object[0]);
	}

	public void setSub_emitter_mode(long value) {
		super.call("set_sub_emitter_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getSub_emitter_frequency() {
		return (double) super.call("get_sub_emitter_frequency", new java.lang.Object[0]);
	}

	public void setSub_emitter_frequency(double value) {
		super.call("set_sub_emitter_frequency", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getSub_emitter_amount_at_end() {
		return (long) super.call("get_sub_emitter_amount_at_end", new java.lang.Object[0]);
	}

	public void setSub_emitter_amount_at_end(long value) {
		super.call("set_sub_emitter_amount_at_end", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSub_emitter_amount_at_collision() {
		return (long) super.call("get_sub_emitter_amount_at_collision", new java.lang.Object[0]);
	}

	public void setSub_emitter_amount_at_collision(long value) {
		super.call("set_sub_emitter_amount_at_collision", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSub_emitter_amount_at_start() {
		return (long) super.call("get_sub_emitter_amount_at_start", new java.lang.Object[0]);
	}

	public void setSub_emitter_amount_at_start(long value) {
		super.call("set_sub_emitter_amount_at_start", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getSub_emitter_keep_velocity() {
		return (boolean) super.call("get_sub_emitter_keep_velocity", new java.lang.Object[0]);
	}

	public void setSub_emitter_keep_velocity(boolean value) {
		super.call("set_sub_emitter_keep_velocity", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
