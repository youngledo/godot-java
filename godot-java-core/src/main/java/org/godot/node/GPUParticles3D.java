package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.AABB;
import org.godot.math.Color;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class GPUParticles3D extends GeometryInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("convert_from_particles", 1078189570L),
			java.util.Map.entry("get_explosiveness_ratio", 1740695150L),
			java.util.Map.entry("set_fractional_delta", 2586408642L),
			java.util.Map.entry("set_amount_ratio", 373806689L), java.util.Map.entry("capture_aabb", 1068685055L),
			java.util.Map.entry("get_interp_to_end", 1740695150L), java.util.Map.entry("set_draw_order", 1208074815L),
			java.util.Map.entry("get_skin", 2074563878L), java.util.Map.entry("set_use_fixed_seed", 2586408642L),
			java.util.Map.entry("get_process_material", 5934680L),
			java.util.Map.entry("get_visibility_aabb", 1068685055L),
			java.util.Map.entry("set_use_local_coordinates", 2586408642L),
			java.util.Map.entry("set_interpolate", 2586408642L), java.util.Map.entry("get_fractional_delta", 36873697L),
			java.util.Map.entry("get_draw_passes", 3905245786L), java.util.Map.entry("get_interpolate", 36873697L),
			java.util.Map.entry("set_emitting", 2586408642L), java.util.Map.entry("get_draw_order", 3770381780L),
			java.util.Map.entry("get_use_fixed_seed", 36873697L), java.util.Map.entry("set_sub_emitter", 1348162250L),
			java.util.Map.entry("set_visibility_aabb", 259215842L), java.util.Map.entry("get_lifetime", 1740695150L),
			java.util.Map.entry("get_fixed_fps", 3905245786L), java.util.Map.entry("get_trail_lifetime", 1740695150L),
			java.util.Map.entry("request_particles_process", 373806689L),
			java.util.Map.entry("get_speed_scale", 1740695150L), java.util.Map.entry("set_trail_enabled", 2586408642L),
			java.util.Map.entry("set_process_material", 2757459619L),
			java.util.Map.entry("is_trail_enabled", 36873697L),
			java.util.Map.entry("set_explosiveness_ratio", 373806689L), java.util.Map.entry("get_one_shot", 36873697L),
			java.util.Map.entry("get_randomness_ratio", 1740695150L),
			java.util.Map.entry("get_draw_pass_mesh", 1576363275L), java.util.Map.entry("emit_particle", 992173727L),
			java.util.Map.entry("set_draw_pass_mesh", 969122797L),
			java.util.Map.entry("set_randomness_ratio", 373806689L), java.util.Map.entry("get_amount", 3905245786L),
			java.util.Map.entry("set_collision_base_size", 373806689L),
			java.util.Map.entry("set_draw_passes", 1286410249L), java.util.Map.entry("is_emitting", 36873697L),
			java.util.Map.entry("set_amount", 1286410249L), java.util.Map.entry("set_skin", 3971435618L),
			java.util.Map.entry("restart", 107499316L), java.util.Map.entry("set_fixed_fps", 1286410249L),
			java.util.Map.entry("get_use_local_coordinates", 36873697L),
			java.util.Map.entry("set_speed_scale", 373806689L),
			java.util.Map.entry("get_collision_base_size", 1740695150L), java.util.Map.entry("get_seed", 3905245786L),
			java.util.Map.entry("set_transform_align", 3892425954L),
			java.util.Map.entry("set_interp_to_end", 373806689L),
			java.util.Map.entry("set_pre_process_time", 373806689L),
			java.util.Map.entry("get_sub_emitter", 4075236667L), java.util.Map.entry("set_seed", 1286410249L),
			java.util.Map.entry("get_pre_process_time", 1740695150L), java.util.Map.entry("set_lifetime", 373806689L),
			java.util.Map.entry("set_trail_lifetime", 373806689L),
			java.util.Map.entry("get_transform_align", 2100992166L), java.util.Map.entry("set_one_shot", 2586408642L),
			java.util.Map.entry("get_amount_ratio", 1740695150L));

	GPUParticles3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GPUParticles3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_emitting() {
		return (boolean) super.call("is_emitting");
	}

	public void set_draw_pass_mesh(long pass, Mesh mesh) {
		super.call("set_draw_pass_mesh", new java.lang.Object[]{java.lang.Long.valueOf(pass), (java.lang.Object) mesh});
	}

	public Mesh get_draw_pass_mesh(long pass) {
		return (Mesh) super.call("get_draw_pass_mesh", new java.lang.Object[]{java.lang.Long.valueOf(pass)});
	}

	public void restart(boolean keep_seed) {
		super.call("restart", new java.lang.Object[]{java.lang.Boolean.valueOf(keep_seed)});
	}

	public AABB capture_aabb() {
		return (AABB) super.call("capture_aabb");
	}

	public void emit_particle(Transform3D xform, Vector3 velocity, Color color, Color custom, long flags) {
		super.call("emit_particle", new java.lang.Object[]{(java.lang.Object) xform, (java.lang.Object) velocity,
				(java.lang.Object) color, (java.lang.Object) custom, java.lang.Long.valueOf(flags)});
	}

	public boolean is_trail_enabled() {
		return (boolean) super.call("is_trail_enabled");
	}

	public void convert_from_particles(Node particles) {
		super.call("convert_from_particles", new java.lang.Object[]{(java.lang.Object) particles});
	}

	public void request_particles_process(double process_time) {
		super.call("request_particles_process", new java.lang.Object[]{java.lang.Double.valueOf(process_time)});
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

	public double getAmount_ratio() {
		return (double) super.call("get_amount_ratio", new java.lang.Object[0]);
	}

	public void setAmount_ratio(double value) {
		super.call("set_amount_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public String getSub_emitter() {
		return (String) super.call("get_sub_emitter", new java.lang.Object[0]);
	}

	public void setSub_emitter(String value) {
		super.call("set_sub_emitter", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getLifetime() {
		return (double) super.call("get_lifetime", new java.lang.Object[0]);
	}

	public void setLifetime(double value) {
		super.call("set_lifetime", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getInterp_to_end() {
		return (double) super.call("get_interp_to_end", new java.lang.Object[0]);
	}

	public void setInterp_to_end(double value) {
		super.call("set_interp_to_end", new java.lang.Object[]{java.lang.Double.valueOf(value)});
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

	public long getFixed_fps() {
		return (long) super.call("get_fixed_fps", new java.lang.Object[0]);
	}

	public void setFixed_fps(long value) {
		super.call("set_fixed_fps", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getInterpolate() {
		return (boolean) super.call("get_interpolate", new java.lang.Object[0]);
	}

	public void setInterpolate(boolean value) {
		super.call("set_interpolate", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getFract_delta() {
		return (boolean) super.call("get_fractional_delta", new java.lang.Object[0]);
	}

	public void setFract_delta(boolean value) {
		super.call("set_fractional_delta", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getCollision_base_size() {
		return (double) super.call("get_collision_base_size", new java.lang.Object[0]);
	}

	public void setCollision_base_size(double value) {
		super.call("set_collision_base_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public AABB getVisibility_aabb() {
		return (AABB) super.call("get_visibility_aabb", new java.lang.Object[0]);
	}

	public void setVisibility_aabb(AABB value) {
		super.call("set_visibility_aabb", new java.lang.Object[]{(java.lang.Object) value});
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

	public long getTransform_align() {
		return (long) super.call("get_transform_align", new java.lang.Object[0]);
	}

	public void setTransform_align(long value) {
		super.call("set_transform_align", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isTrail_enabled() {
		return (boolean) super.call("is_trail_enabled", new java.lang.Object[0]);
	}

	public void setTrail_enabled(boolean value) {
		super.call("set_trail_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getTrail_lifetime() {
		return (double) super.call("get_trail_lifetime", new java.lang.Object[0]);
	}

	public void setTrail_lifetime(double value) {
		super.call("set_trail_lifetime", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Object getProcess_material() {
		return (Object) super.call("get_process_material", new java.lang.Object[0]);
	}

	public void setProcess_material(Object value) {
		super.call("set_process_material", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getDraw_passes() {
		return (long) super.call("get_draw_passes", new java.lang.Object[0]);
	}

	public void setDraw_passes(long value) {
		super.call("set_draw_passes", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Mesh getDraw_pass_1() {
		return (Mesh) super.call("get_draw_pass_mesh", new java.lang.Object[0]);
	}

	public void setDraw_pass_1(Mesh value) {
		super.call("set_draw_pass_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Mesh getDraw_pass_2() {
		return (Mesh) super.call("get_draw_pass_mesh", new java.lang.Object[0]);
	}

	public void setDraw_pass_2(Mesh value) {
		super.call("set_draw_pass_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Mesh getDraw_pass_3() {
		return (Mesh) super.call("get_draw_pass_mesh", new java.lang.Object[0]);
	}

	public void setDraw_pass_3(Mesh value) {
		super.call("set_draw_pass_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Mesh getDraw_pass_4() {
		return (Mesh) super.call("get_draw_pass_mesh", new java.lang.Object[0]);
	}

	public void setDraw_pass_4(Mesh value) {
		super.call("set_draw_pass_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Skin getDraw_skin() {
		return (Skin) super.call("get_skin", new java.lang.Object[0]);
	}

	public void setDraw_skin(Skin value) {
		super.call("set_skin", new java.lang.Object[]{(java.lang.Object) value});
	}
}
