package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector2;

public class CPUParticles2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("convert_from_particles", 1078189570L),
			java.util.Map.entry("get_explosiveness_ratio", 1740695150L),
			java.util.Map.entry("get_scale_curve_x", 2460114913L),
			java.util.Map.entry("get_scale_curve_y", 2460114913L),
			java.util.Map.entry("set_fractional_delta", 2586408642L),
			java.util.Map.entry("get_emission_colors", 1392750486L),
			java.util.Map.entry("set_particle_flag", 4178137949L),
			java.util.Map.entry("set_emission_rect_extents", 743155724L),
			java.util.Map.entry("set_emission_ring_inner_radius", 373806689L),
			java.util.Map.entry("set_emission_ring_radius", 373806689L),
			java.util.Map.entry("set_draw_order", 4183193490L), java.util.Map.entry("set_scale_curve_x", 270443179L),
			java.util.Map.entry("set_scale_curve_y", 270443179L), java.util.Map.entry("set_direction", 743155724L),
			java.util.Map.entry("get_direction", 3341600327L), java.util.Map.entry("set_use_fixed_seed", 2586408642L),
			java.util.Map.entry("set_lifetime_randomness", 373806689L),
			java.util.Map.entry("set_use_local_coordinates", 2586408642L),
			java.util.Map.entry("get_fractional_delta", 36873697L), java.util.Map.entry("get_param_max", 2038050600L),
			java.util.Map.entry("get_emission_sphere_radius", 1740695150L),
			java.util.Map.entry("get_gravity", 3341600327L), java.util.Map.entry("set_emitting", 2586408642L),
			java.util.Map.entry("get_draw_order", 1668655735L), java.util.Map.entry("get_use_fixed_seed", 36873697L),
			java.util.Map.entry("get_emission_shape", 1740246024L), java.util.Map.entry("get_lifetime", 1740695150L),
			java.util.Map.entry("set_color_initial_ramp", 2756054477L),
			java.util.Map.entry("get_fixed_fps", 3905245786L), java.util.Map.entry("set_param_curve", 2959350143L),
			java.util.Map.entry("get_particle_flag", 2829976507L),
			java.util.Map.entry("request_particles_process", 373806689L),
			java.util.Map.entry("get_speed_scale", 1740695150L), java.util.Map.entry("get_texture", 3635182373L),
			java.util.Map.entry("get_emission_rect_extents", 3341600327L),
			java.util.Map.entry("set_explosiveness_ratio", 373806689L),
			java.util.Map.entry("set_param_max", 3320615296L), java.util.Map.entry("get_one_shot", 36873697L),
			java.util.Map.entry("get_randomness_ratio", 1740695150L), java.util.Map.entry("get_color", 3444240500L),
			java.util.Map.entry("set_emission_shape", 393763892L), java.util.Map.entry("set_param_min", 3320615296L),
			java.util.Map.entry("get_emission_points", 2961356807L),
			java.util.Map.entry("get_param_curve", 2603158474L), java.util.Map.entry("get_param_min", 2038050600L),
			java.util.Map.entry("set_emission_points", 1509147220L), java.util.Map.entry("get_spread", 1740695150L),
			java.util.Map.entry("set_randomness_ratio", 373806689L), java.util.Map.entry("get_amount", 3905245786L),
			java.util.Map.entry("get_color_ramp", 132272999L), java.util.Map.entry("get_split_scale", 2240911060L),
			java.util.Map.entry("is_emitting", 36873697L), java.util.Map.entry("set_spread", 373806689L),
			java.util.Map.entry("get_emission_ring_radius", 1740695150L),
			java.util.Map.entry("set_amount", 1286410249L), java.util.Map.entry("restart", 107499316L),
			java.util.Map.entry("set_color_ramp", 2756054477L), java.util.Map.entry("set_fixed_fps", 1286410249L),
			java.util.Map.entry("set_emission_normals", 1509147220L),
			java.util.Map.entry("get_use_local_coordinates", 36873697L),
			java.util.Map.entry("set_speed_scale", 373806689L), java.util.Map.entry("get_seed", 3905245786L),
			java.util.Map.entry("set_color", 2920490490L),
			java.util.Map.entry("set_emission_sphere_radius", 373806689L),
			java.util.Map.entry("set_split_scale", 2586408642L),
			java.util.Map.entry("set_pre_process_time", 373806689L), java.util.Map.entry("set_seed", 1286410249L),
			java.util.Map.entry("set_gravity", 743155724L), java.util.Map.entry("get_pre_process_time", 1740695150L),
			java.util.Map.entry("get_emission_ring_inner_radius", 1740695150L),
			java.util.Map.entry("set_lifetime", 373806689L), java.util.Map.entry("set_texture", 4051416890L),
			java.util.Map.entry("get_color_initial_ramp", 132272999L),
			java.util.Map.entry("get_emission_normals", 2961356807L), java.util.Map.entry("set_one_shot", 2586408642L),
			java.util.Map.entry("get_lifetime_randomness", 1740695150L),
			java.util.Map.entry("set_emission_colors", 3546319833L));

	CPUParticles2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CPUParticles2D(long nativePointer) {
		super(nativePointer);
	}

	public void request_particles_process(double process_time) {
		super.call("request_particles_process", new java.lang.Object[]{java.lang.Double.valueOf(process_time)});
	}

	public boolean is_emitting() {
		return (boolean) super.call("is_emitting");
	}

	public void restart(boolean keep_seed) {
		super.call("restart", new java.lang.Object[]{java.lang.Boolean.valueOf(keep_seed)});
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

	public void set_param_curve(int param, Curve curve) {
		super.call("set_param_curve",
				new java.lang.Object[]{java.lang.Integer.valueOf(param), (java.lang.Object) curve});
	}

	public Curve get_param_curve(int param) {
		return (Curve) super.call("get_param_curve", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}

	public void set_particle_flag(int particle_flag, boolean enable) {
		super.call("set_particle_flag",
				new java.lang.Object[]{java.lang.Integer.valueOf(particle_flag), java.lang.Boolean.valueOf(enable)});
	}

	public boolean get_particle_flag(int particle_flag) {
		return (boolean) super.call("get_particle_flag",
				new java.lang.Object[]{java.lang.Integer.valueOf(particle_flag)});
	}

	public void convert_from_particles(Node particles) {
		super.call("convert_from_particles", new java.lang.Object[]{(java.lang.Object) particles});
	}

	public boolean isEmitting() {
		return (boolean) super.call("is_emitting", new java.lang.Object[0]);
	}

	public void setEmitting(boolean value) {
		super.call("set_emitting", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getAmount() {
		return (long) super.call("get_amount", new java.lang.Object[0]);
	}

	public void setAmount(long value) {
		super.call("set_amount", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Texture2D getTexture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getLifetime() {
		return (double) super.call("get_lifetime", new java.lang.Object[0]);
	}

	public void setLifetime(double value) {
		super.call("set_lifetime", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getOne_shot() {
		return (boolean) super.call("get_one_shot", new java.lang.Object[0]);
	}

	public void setOne_shot(boolean value) {
		super.call("set_one_shot", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getPreprocess() {
		return (double) super.call("get_pre_process_time", new java.lang.Object[0]);
	}

	public void setPreprocess(double value) {
		super.call("set_pre_process_time", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSpeed_scale() {
		return (double) super.call("get_speed_scale", new java.lang.Object[0]);
	}

	public void setSpeed_scale(double value) {
		super.call("set_speed_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getExplosiveness() {
		return (double) super.call("get_explosiveness_ratio", new java.lang.Object[0]);
	}

	public void setExplosiveness(double value) {
		super.call("set_explosiveness_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRandomness() {
		return (double) super.call("get_randomness_ratio", new java.lang.Object[0]);
	}

	public void setRandomness(double value) {
		super.call("set_randomness_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getUse_fixed_seed() {
		return (boolean) super.call("get_use_fixed_seed", new java.lang.Object[0]);
	}

	public void setUse_fixed_seed(boolean value) {
		super.call("set_use_fixed_seed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSeed() {
		return (long) super.call("get_seed", new java.lang.Object[0]);
	}

	public void setSeed(long value) {
		super.call("set_seed", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getLifetime_randomness() {
		return (double) super.call("get_lifetime_randomness", new java.lang.Object[0]);
	}

	public void setLifetime_randomness(double value) {
		super.call("set_lifetime_randomness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getFixed_fps() {
		return (long) super.call("get_fixed_fps", new java.lang.Object[0]);
	}

	public void setFixed_fps(long value) {
		super.call("set_fixed_fps", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getFract_delta() {
		return (boolean) super.call("get_fractional_delta", new java.lang.Object[0]);
	}

	public void setFract_delta(boolean value) {
		super.call("set_fractional_delta", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getLocal_coords() {
		return (boolean) super.call("get_use_local_coordinates", new java.lang.Object[0]);
	}

	public void setLocal_coords(boolean value) {
		super.call("set_use_local_coordinates", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getDraw_order() {
		return (long) super.call("get_draw_order", new java.lang.Object[0]);
	}

	public void setDraw_order(long value) {
		super.call("set_draw_order", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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

	public Vector2 getEmission_rect_extents() {
		return (Vector2) super.call("get_emission_rect_extents", new java.lang.Object[0]);
	}

	public void setEmission_rect_extents(Vector2 value) {
		super.call("set_emission_rect_extents", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[][] getEmission_points() {
		return (double[][]) super.call("get_emission_points", new java.lang.Object[0]);
	}

	public void setEmission_points(double[][] value) {
		super.call("set_emission_points", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[][] getEmission_normals() {
		return (double[][]) super.call("get_emission_normals", new java.lang.Object[0]);
	}

	public void setEmission_normals(double[][] value) {
		super.call("set_emission_normals", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[][] getEmission_colors() {
		return (double[][]) super.call("get_emission_colors", new java.lang.Object[0]);
	}

	public void setEmission_colors(double[][] value) {
		super.call("set_emission_colors", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getEmission_ring_inner_radius() {
		return (double) super.call("get_emission_ring_inner_radius", new java.lang.Object[0]);
	}

	public void setEmission_ring_inner_radius(double value) {
		super.call("set_emission_ring_inner_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getEmission_ring_radius() {
		return (double) super.call("get_emission_ring_radius", new java.lang.Object[0]);
	}

	public void setEmission_ring_radius(double value) {
		super.call("set_emission_ring_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getParticle_flag_align_y() {
		return (boolean) super.call("get_particle_flag", new java.lang.Object[0]);
	}

	public void setParticle_flag_align_y(boolean value) {
		super.call("set_particle_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getDirection() {
		return (Vector2) super.call("get_direction", new java.lang.Object[0]);
	}

	public void setDirection(Vector2 value) {
		super.call("set_direction", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getSpread() {
		return (double) super.call("get_spread", new java.lang.Object[0]);
	}

	public void setSpread(double value) {
		super.call("set_spread", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getGravity() {
		return (Vector2) super.call("get_gravity", new java.lang.Object[0]);
	}

	public void setGravity(Vector2 value) {
		super.call("set_gravity", new java.lang.Object[]{(java.lang.Object) value});
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

	public Curve getAngular_velocity_curve() {
		return (Curve) super.call("get_param_curve", new java.lang.Object[0]);
	}

	public void setAngular_velocity_curve(Curve value) {
		super.call("set_param_curve", new java.lang.Object[]{(java.lang.Object) value});
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

	public Curve getOrbit_velocity_curve() {
		return (Curve) super.call("get_param_curve", new java.lang.Object[0]);
	}

	public void setOrbit_velocity_curve(Curve value) {
		super.call("set_param_curve", new java.lang.Object[]{(java.lang.Object) value});
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

	public Curve getLinear_accel_curve() {
		return (Curve) super.call("get_param_curve", new java.lang.Object[0]);
	}

	public void setLinear_accel_curve(Curve value) {
		super.call("set_param_curve", new java.lang.Object[]{(java.lang.Object) value});
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

	public Curve getRadial_accel_curve() {
		return (Curve) super.call("get_param_curve", new java.lang.Object[0]);
	}

	public void setRadial_accel_curve(Curve value) {
		super.call("set_param_curve", new java.lang.Object[]{(java.lang.Object) value});
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

	public Curve getTangential_accel_curve() {
		return (Curve) super.call("get_param_curve", new java.lang.Object[0]);
	}

	public void setTangential_accel_curve(Curve value) {
		super.call("set_param_curve", new java.lang.Object[]{(java.lang.Object) value});
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

	public Curve getDamping_curve() {
		return (Curve) super.call("get_param_curve", new java.lang.Object[0]);
	}

	public void setDamping_curve(Curve value) {
		super.call("set_param_curve", new java.lang.Object[]{(java.lang.Object) value});
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

	public Curve getAngle_curve() {
		return (Curve) super.call("get_param_curve", new java.lang.Object[0]);
	}

	public void setAngle_curve(Curve value) {
		super.call("set_param_curve", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getScale_amount_min() {
		return (double) super.call("get_param_min", new java.lang.Object[0]);
	}

	public void setScale_amount_min(double value) {
		super.call("set_param_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getScale_amount_max() {
		return (double) super.call("get_param_max", new java.lang.Object[0]);
	}

	public void setScale_amount_max(double value) {
		super.call("set_param_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Curve getScale_amount_curve() {
		return (Curve) super.call("get_param_curve", new java.lang.Object[0]);
	}

	public void setScale_amount_curve(Curve value) {
		super.call("set_param_curve", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getSplit_scale() {
		return (boolean) super.call("get_split_scale", new java.lang.Object[0]);
	}

	public void setSplit_scale(boolean value) {
		super.call("set_split_scale", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Curve getScale_curve_x() {
		return (Curve) super.call("get_scale_curve_x", new java.lang.Object[0]);
	}

	public void setScale_curve_x(Curve value) {
		super.call("set_scale_curve_x", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Curve getScale_curve_y() {
		return (Curve) super.call("get_scale_curve_y", new java.lang.Object[0]);
	}

	public void setScale_curve_y(Curve value) {
		super.call("set_scale_curve_y", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getColor() {
		return (Color) super.call("get_color", new java.lang.Object[0]);
	}

	public void setColor(Color value) {
		super.call("set_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Gradient getColor_ramp() {
		return (Gradient) super.call("get_color_ramp", new java.lang.Object[0]);
	}

	public void setColor_ramp(Gradient value) {
		super.call("set_color_ramp", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Gradient getColor_initial_ramp() {
		return (Gradient) super.call("get_color_initial_ramp", new java.lang.Object[0]);
	}

	public void setColor_initial_ramp(Gradient value) {
		super.call("set_color_initial_ramp", new java.lang.Object[]{(java.lang.Object) value});
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

	public Curve getHue_variation_curve() {
		return (Curve) super.call("get_param_curve", new java.lang.Object[0]);
	}

	public void setHue_variation_curve(Curve value) {
		super.call("set_param_curve", new java.lang.Object[]{(java.lang.Object) value});
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

	public Curve getAnim_speed_curve() {
		return (Curve) super.call("get_param_curve", new java.lang.Object[0]);
	}

	public void setAnim_speed_curve(Curve value) {
		super.call("set_param_curve", new java.lang.Object[]{(java.lang.Object) value});
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

	public Curve getAnim_offset_curve() {
		return (Curve) super.call("get_param_curve", new java.lang.Object[0]);
	}

	public void setAnim_offset_curve(Curve value) {
		super.call("set_param_curve", new java.lang.Object[]{(java.lang.Object) value});
	}
}
