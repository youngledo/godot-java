package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.core.Callable;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;

public class PhysicsServer2D extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("concave_polygon_shape_create", 529393457L),
			java.util.Map.entry("body_get_shape_count", 2198884583L),
			java.util.Map.entry("body_get_max_contacts_reported", 2198884583L),
			java.util.Map.entry("damped_spring_joint_set_param", 220564071L),
			java.util.Map.entry("shape_get_type", 1240598777L),
			java.util.Map.entry("body_set_axis_velocity", 3201125042L),
			java.util.Map.entry("body_add_constant_central_force", 3201125042L),
			java.util.Map.entry("area_get_space", 3814569979L), java.util.Map.entry("body_set_state", 1706355209L),
			java.util.Map.entry("body_set_force_integration_callback", 3059434249L),
			java.util.Map.entry("body_set_omit_force_integration", 1265174801L),
			java.util.Map.entry("set_active", 2586408642L),
			java.util.Map.entry("world_boundary_shape_create", 529393457L),
			java.util.Map.entry("joint_clear", 2722037293L),
			java.util.Map.entry("area_attach_object_instance_id", 3411492887L),
			java.util.Map.entry("body_get_collision_layer", 2198884583L),
			java.util.Map.entry("damped_spring_joint_get_param", 2075871277L),
			java.util.Map.entry("area_set_area_monitor_callback", 3379118538L),
			java.util.Map.entry("area_get_shape_count", 2198884583L),
			java.util.Map.entry("body_set_state_sync_callback", 3379118538L),
			java.util.Map.entry("body_add_constant_torque", 1794382983L),
			java.util.Map.entry("joint_make_pin", 1612646186L),
			java.util.Map.entry("space_get_direct_state", 3160173886L),
			java.util.Map.entry("body_is_omitting_force_integration", 4155700596L),
			java.util.Map.entry("body_get_collision_mask", 2198884583L),
			java.util.Map.entry("body_attach_object_instance_id", 3411492887L),
			java.util.Map.entry("joint_make_groove", 481430435L), java.util.Map.entry("body_get_space", 3814569979L),
			java.util.Map.entry("joint_create", 529393457L), java.util.Map.entry("pin_joint_set_flag", 3520002352L),
			java.util.Map.entry("rectangle_shape_create", 529393457L),
			java.util.Map.entry("body_apply_force", 205485391L),
			java.util.Map.entry("body_get_continuous_collision_detection_mode", 2661282217L),
			java.util.Map.entry("body_reset_mass_properties", 2722037293L),
			java.util.Map.entry("area_set_shape_transform", 736082694L),
			java.util.Map.entry("area_get_shape_transform", 1324854622L),
			java.util.Map.entry("body_apply_central_impulse", 3201125042L),
			java.util.Map.entry("area_set_space", 395945892L), java.util.Map.entry("body_create", 529393457L),
			java.util.Map.entry("body_remove_shape", 3411492887L),
			java.util.Map.entry("body_get_shape_transform", 1324854622L),
			java.util.Map.entry("body_get_constant_torque", 866169185L),
			java.util.Map.entry("area_set_monitorable", 1265174801L),
			java.util.Map.entry("pin_joint_get_flag", 2647867364L),
			java.util.Map.entry("joint_is_disabled_collisions_between_bodies", 4155700596L),
			java.util.Map.entry("body_apply_central_force", 3201125042L),
			java.util.Map.entry("area_create", 529393457L), java.util.Map.entry("body_set_shape_transform", 736082694L),
			java.util.Map.entry("area_get_canvas_instance_id", 2198884583L),
			java.util.Map.entry("body_set_shape_as_one_way_collision", 2556489974L),
			java.util.Map.entry("body_test_motion", 1699844009L),
			java.util.Map.entry("body_set_max_contacts_reported", 3411492887L),
			java.util.Map.entry("area_get_collision_mask", 2198884583L),
			java.util.Map.entry("body_get_canvas_instance_id", 2198884583L),
			java.util.Map.entry("area_set_param", 1257146028L), java.util.Map.entry("area_add_shape", 339056240L),
			java.util.Map.entry("pin_joint_set_param", 550574241L), java.util.Map.entry("body_get_mode", 3261702585L),
			java.util.Map.entry("space_create", 529393457L), java.util.Map.entry("space_is_active", 4155700596L),
			java.util.Map.entry("space_set_active", 1265174801L),
			java.util.Map.entry("body_set_collision_priority", 1794382983L),
			java.util.Map.entry("area_remove_shape", 3411492887L), java.util.Map.entry("body_set_space", 395945892L),
			java.util.Map.entry("joint_make_damped_spring", 1994657646L),
			java.util.Map.entry("body_set_constant_torque", 1794382983L),
			java.util.Map.entry("body_apply_torque", 1794382983L),
			java.util.Map.entry("body_get_direct_state", 1191931871L),
			java.util.Map.entry("area_attach_canvas_instance_id", 3411492887L),
			java.util.Map.entry("body_get_param", 3208033526L), java.util.Map.entry("body_set_mode", 1658067650L),
			java.util.Map.entry("body_set_collision_mask", 3411492887L),
			java.util.Map.entry("body_add_collision_exception", 395945892L),
			java.util.Map.entry("body_get_collision_priority", 866169185L),
			java.util.Map.entry("body_apply_torque_impulse", 1794382983L),
			java.util.Map.entry("body_set_constant_force", 3201125042L),
			java.util.Map.entry("body_set_continuous_collision_detection_mode", 1882257015L),
			java.util.Map.entry("joint_set_param", 3972556514L), java.util.Map.entry("shape_get_data", 4171304767L),
			java.util.Map.entry("joint_disable_collisions_between_bodies", 1265174801L),
			java.util.Map.entry("shape_set_data", 3175752987L),
			java.util.Map.entry("body_remove_collision_exception", 395945892L),
			java.util.Map.entry("area_get_param", 3047435120L),
			java.util.Map.entry("separation_ray_shape_create", 529393457L),
			java.util.Map.entry("area_set_shape", 2310537182L),
			java.util.Map.entry("body_attach_canvas_instance_id", 3411492887L),
			java.util.Map.entry("space_set_param", 949194586L), java.util.Map.entry("body_clear_shapes", 2722037293L),
			java.util.Map.entry("body_set_collision_layer", 3411492887L),
			java.util.Map.entry("body_set_param", 2715630609L), java.util.Map.entry("body_get_state", 4036367961L),
			java.util.Map.entry("area_get_transform", 213527486L),
			java.util.Map.entry("area_set_shape_disabled", 2658558584L),
			java.util.Map.entry("area_get_object_instance_id", 2198884583L),
			java.util.Map.entry("area_set_collision_mask", 3411492887L),
			java.util.Map.entry("body_get_object_instance_id", 2198884583L),
			java.util.Map.entry("body_add_shape", 339056240L), java.util.Map.entry("body_get_shape", 1066463050L),
			java.util.Map.entry("body_set_shape_disabled", 2658558584L),
			java.util.Map.entry("body_set_shape", 2310537182L), java.util.Map.entry("body_apply_impulse", 205485391L),
			java.util.Map.entry("pin_joint_get_param", 348281383L),
			java.util.Map.entry("body_get_constant_force", 2440833711L),
			java.util.Map.entry("joint_get_type", 4262502231L), java.util.Map.entry("capsule_shape_create", 529393457L),
			java.util.Map.entry("area_set_transform", 1246044741L),
			java.util.Map.entry("area_get_collision_layer", 2198884583L), java.util.Map.entry("free_rid", 2722037293L),
			java.util.Map.entry("area_clear_shapes", 2722037293L),
			java.util.Map.entry("segment_shape_create", 529393457L),
			java.util.Map.entry("convex_polygon_shape_create", 529393457L),
			java.util.Map.entry("area_set_monitor_callback", 3379118538L),
			java.util.Map.entry("get_process_info", 576496006L), java.util.Map.entry("joint_get_param", 4016448949L),
			java.util.Map.entry("area_get_shape", 1066463050L), java.util.Map.entry("circle_shape_create", 529393457L),
			java.util.Map.entry("space_get_param", 874111783L),
			java.util.Map.entry("body_add_constant_force", 205485391L),
			java.util.Map.entry("area_set_collision_layer", 3411492887L));

	PhysicsServer2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsServer2D(long nativePointer) {
		super(nativePointer);
	}

	public long world_boundary_shape_create() {
		return (long) super.call("world_boundary_shape_create");
	}

	public long separation_ray_shape_create() {
		return (long) super.call("separation_ray_shape_create");
	}

	public long segment_shape_create() {
		return (long) super.call("segment_shape_create");
	}

	public long circle_shape_create() {
		return (long) super.call("circle_shape_create");
	}

	public long rectangle_shape_create() {
		return (long) super.call("rectangle_shape_create");
	}

	public long capsule_shape_create() {
		return (long) super.call("capsule_shape_create");
	}

	public long convex_polygon_shape_create() {
		return (long) super.call("convex_polygon_shape_create");
	}

	public long concave_polygon_shape_create() {
		return (long) super.call("concave_polygon_shape_create");
	}

	public void shape_set_data(long shape, Object data) {
		super.call("shape_set_data", new java.lang.Object[]{java.lang.Long.valueOf(shape), (java.lang.Object) data});
	}

	public int shape_get_type(long shape) {
		return (int) super.call("shape_get_type", new java.lang.Object[]{java.lang.Long.valueOf(shape)});
	}

	public Object shape_get_data(long shape) {
		return (Object) super.call("shape_get_data", new java.lang.Object[]{java.lang.Long.valueOf(shape)});
	}

	public long space_create() {
		return (long) super.call("space_create");
	}

	public void space_set_active(long space, boolean active) {
		super.call("space_set_active",
				new java.lang.Object[]{java.lang.Long.valueOf(space), java.lang.Boolean.valueOf(active)});
	}

	public boolean space_is_active(long space) {
		return (boolean) super.call("space_is_active", new java.lang.Object[]{java.lang.Long.valueOf(space)});
	}

	public void space_set_param(long space, int param, double value) {
		super.call("space_set_param", new java.lang.Object[]{java.lang.Long.valueOf(space),
				java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double space_get_param(long space, int param) {
		return (double) super.call("space_get_param",
				new java.lang.Object[]{java.lang.Long.valueOf(space), java.lang.Integer.valueOf(param)});
	}

	public PhysicsDirectSpaceState2D space_get_direct_state(long space) {
		return (PhysicsDirectSpaceState2D) super.call("space_get_direct_state",
				new java.lang.Object[]{java.lang.Long.valueOf(space)});
	}

	public long area_create() {
		return (long) super.call("area_create");
	}

	public void area_set_space(long area, long space) {
		super.call("area_set_space",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Long.valueOf(space)});
	}

	public long area_get_space(long area) {
		return (long) super.call("area_get_space", new java.lang.Object[]{java.lang.Long.valueOf(area)});
	}

	public void area_add_shape(long area, long shape, Transform2D transform, boolean disabled) {
		super.call("area_add_shape", new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Long.valueOf(shape),
				(java.lang.Object) transform, java.lang.Boolean.valueOf(disabled)});
	}

	public void area_set_shape(long area, long shape_idx, long shape) {
		super.call("area_set_shape", new java.lang.Object[]{java.lang.Long.valueOf(area),
				java.lang.Long.valueOf(shape_idx), java.lang.Long.valueOf(shape)});
	}

	public void area_set_shape_transform(long area, long shape_idx, Transform2D transform) {
		super.call("area_set_shape_transform", new java.lang.Object[]{java.lang.Long.valueOf(area),
				java.lang.Long.valueOf(shape_idx), (java.lang.Object) transform});
	}

	public void area_set_shape_disabled(long area, long shape_idx, boolean disabled) {
		super.call("area_set_shape_disabled", new java.lang.Object[]{java.lang.Long.valueOf(area),
				java.lang.Long.valueOf(shape_idx), java.lang.Boolean.valueOf(disabled)});
	}

	public int area_get_shape_count(long area) {
		return (int) super.call("area_get_shape_count", new java.lang.Object[]{java.lang.Long.valueOf(area)});
	}

	public long area_get_shape(long area, long shape_idx) {
		return (long) super.call("area_get_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Long.valueOf(shape_idx)});
	}

	public Transform2D area_get_shape_transform(long area, long shape_idx) {
		return (Transform2D) super.call("area_get_shape_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Long.valueOf(shape_idx)});
	}

	public void area_remove_shape(long area, long shape_idx) {
		super.call("area_remove_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Long.valueOf(shape_idx)});
	}

	public void area_clear_shapes(long area) {
		super.call("area_clear_shapes", new java.lang.Object[]{java.lang.Long.valueOf(area)});
	}

	public void area_set_collision_layer(long area, long layer) {
		super.call("area_set_collision_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Long.valueOf(layer)});
	}

	public long area_get_collision_layer(long area) {
		return (long) super.call("area_get_collision_layer", new java.lang.Object[]{java.lang.Long.valueOf(area)});
	}

	public void area_set_collision_mask(long area, long mask) {
		super.call("area_set_collision_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Long.valueOf(mask)});
	}

	public long area_get_collision_mask(long area) {
		return (long) super.call("area_get_collision_mask", new java.lang.Object[]{java.lang.Long.valueOf(area)});
	}

	public void area_set_param(long area, int param, Object value) {
		super.call("area_set_param", new java.lang.Object[]{java.lang.Long.valueOf(area),
				java.lang.Integer.valueOf(param), (java.lang.Object) value});
	}

	public void area_set_transform(long area, Transform2D transform) {
		super.call("area_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(area), (java.lang.Object) transform});
	}

	public Object area_get_param(long area, int param) {
		return (Object) super.call("area_get_param",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Integer.valueOf(param)});
	}

	public Transform2D area_get_transform(long area) {
		return (Transform2D) super.call("area_get_transform", new java.lang.Object[]{java.lang.Long.valueOf(area)});
	}

	public void area_attach_object_instance_id(long area, long id) {
		super.call("area_attach_object_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Long.valueOf(id)});
	}

	public java.math.BigInteger area_get_object_instance_id(long area) {
		return (java.math.BigInteger) super.call("area_get_object_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(area)});
	}

	public void area_attach_canvas_instance_id(long area, long id) {
		super.call("area_attach_canvas_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Long.valueOf(id)});
	}

	public java.math.BigInteger area_get_canvas_instance_id(long area) {
		return (java.math.BigInteger) super.call("area_get_canvas_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(area)});
	}

	public void area_set_monitor_callback(long area, Callable callback) {
		super.call("area_set_monitor_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(area), (java.lang.Object) callback});
	}

	public void area_set_area_monitor_callback(long area, Callable callback) {
		super.call("area_set_area_monitor_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(area), (java.lang.Object) callback});
	}

	public void area_set_monitorable(long area, boolean monitorable) {
		super.call("area_set_monitorable",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Boolean.valueOf(monitorable)});
	}

	public long body_create() {
		return (long) super.call("body_create");
	}

	public void body_set_space(long body, long space) {
		super.call("body_set_space",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(space)});
	}

	public long body_get_space(long body) {
		return (long) super.call("body_get_space", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_mode(long body, int mode) {
		super.call("body_set_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Integer.valueOf(mode)});
	}

	public int body_get_mode(long body) {
		return (int) super.call("body_get_mode", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_add_shape(long body, long shape, Transform2D transform, boolean disabled) {
		super.call("body_add_shape", new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(shape),
				(java.lang.Object) transform, java.lang.Boolean.valueOf(disabled)});
	}

	public void body_set_shape(long body, long shape_idx, long shape) {
		super.call("body_set_shape", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Long.valueOf(shape_idx), java.lang.Long.valueOf(shape)});
	}

	public void body_set_shape_transform(long body, long shape_idx, Transform2D transform) {
		super.call("body_set_shape_transform", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Long.valueOf(shape_idx), (java.lang.Object) transform});
	}

	public int body_get_shape_count(long body) {
		return (int) super.call("body_get_shape_count", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public long body_get_shape(long body, long shape_idx) {
		return (long) super.call("body_get_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(shape_idx)});
	}

	public Transform2D body_get_shape_transform(long body, long shape_idx) {
		return (Transform2D) super.call("body_get_shape_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(shape_idx)});
	}

	public void body_remove_shape(long body, long shape_idx) {
		super.call("body_remove_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(shape_idx)});
	}

	public void body_clear_shapes(long body) {
		super.call("body_clear_shapes", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_shape_disabled(long body, long shape_idx, boolean disabled) {
		super.call("body_set_shape_disabled", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Long.valueOf(shape_idx), java.lang.Boolean.valueOf(disabled)});
	}

	public void body_set_shape_as_one_way_collision(long body, long shape_idx, boolean enable, double margin) {
		super.call("body_set_shape_as_one_way_collision",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(shape_idx),
						java.lang.Boolean.valueOf(enable), java.lang.Double.valueOf(margin)});
	}

	public void body_attach_object_instance_id(long body, long id) {
		super.call("body_attach_object_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(id)});
	}

	public java.math.BigInteger body_get_object_instance_id(long body) {
		return (java.math.BigInteger) super.call("body_get_object_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_attach_canvas_instance_id(long body, long id) {
		super.call("body_attach_canvas_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(id)});
	}

	public java.math.BigInteger body_get_canvas_instance_id(long body) {
		return (java.math.BigInteger) super.call("body_get_canvas_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_continuous_collision_detection_mode(long body, int mode) {
		super.call("body_set_continuous_collision_detection_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Integer.valueOf(mode)});
	}

	public int body_get_continuous_collision_detection_mode(long body) {
		return (int) super.call("body_get_continuous_collision_detection_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_collision_layer(long body, long layer) {
		super.call("body_set_collision_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(layer)});
	}

	public long body_get_collision_layer(long body) {
		return (long) super.call("body_get_collision_layer", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_collision_mask(long body, long mask) {
		super.call("body_set_collision_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(mask)});
	}

	public long body_get_collision_mask(long body) {
		return (long) super.call("body_get_collision_mask", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_collision_priority(long body, double priority) {
		super.call("body_set_collision_priority",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Double.valueOf(priority)});
	}

	public double body_get_collision_priority(long body) {
		return (double) super.call("body_get_collision_priority", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_param(long body, int param, Object value) {
		super.call("body_set_param", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Integer.valueOf(param), (java.lang.Object) value});
	}

	public Object body_get_param(long body, int param) {
		return (Object) super.call("body_get_param",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Integer.valueOf(param)});
	}

	public void body_reset_mass_properties(long body) {
		super.call("body_reset_mass_properties", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_state(long body, int state, Object value) {
		super.call("body_set_state", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Integer.valueOf(state), (java.lang.Object) value});
	}

	public Object body_get_state(long body, int state) {
		return (Object) super.call("body_get_state",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Integer.valueOf(state)});
	}

	public void body_apply_central_impulse(long body, Vector2 impulse) {
		super.call("body_apply_central_impulse",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) impulse});
	}

	public void body_apply_torque_impulse(long body, double impulse) {
		super.call("body_apply_torque_impulse",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Double.valueOf(impulse)});
	}

	public void body_apply_impulse(long body, Vector2 impulse, Vector2 position) {
		super.call("body_apply_impulse", new java.lang.Object[]{java.lang.Long.valueOf(body),
				(java.lang.Object) impulse, (java.lang.Object) position});
	}

	public void body_apply_central_force(long body, Vector2 force) {
		super.call("body_apply_central_force",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) force});
	}

	public void body_apply_force(long body, Vector2 force, Vector2 position) {
		super.call("body_apply_force", new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) force,
				(java.lang.Object) position});
	}

	public void body_apply_torque(long body, double torque) {
		super.call("body_apply_torque",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Double.valueOf(torque)});
	}

	public void body_add_constant_central_force(long body, Vector2 force) {
		super.call("body_add_constant_central_force",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) force});
	}

	public void body_add_constant_force(long body, Vector2 force, Vector2 position) {
		super.call("body_add_constant_force", new java.lang.Object[]{java.lang.Long.valueOf(body),
				(java.lang.Object) force, (java.lang.Object) position});
	}

	public void body_add_constant_torque(long body, double torque) {
		super.call("body_add_constant_torque",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Double.valueOf(torque)});
	}

	public void body_set_constant_force(long body, Vector2 force) {
		super.call("body_set_constant_force",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) force});
	}

	public Vector2 body_get_constant_force(long body) {
		return (Vector2) super.call("body_get_constant_force", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_constant_torque(long body, double torque) {
		super.call("body_set_constant_torque",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Double.valueOf(torque)});
	}

	public double body_get_constant_torque(long body) {
		return (double) super.call("body_get_constant_torque", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_axis_velocity(long body, Vector2 axis_velocity) {
		super.call("body_set_axis_velocity",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) axis_velocity});
	}

	public void body_add_collision_exception(long body, long excepted_body) {
		super.call("body_add_collision_exception",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(excepted_body)});
	}

	public void body_remove_collision_exception(long body, long excepted_body) {
		super.call("body_remove_collision_exception",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(excepted_body)});
	}

	public void body_set_max_contacts_reported(long body, long amount) {
		super.call("body_set_max_contacts_reported",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(amount)});
	}

	public int body_get_max_contacts_reported(long body) {
		return (int) super.call("body_get_max_contacts_reported", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_omit_force_integration(long body, boolean enable) {
		super.call("body_set_omit_force_integration",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Boolean.valueOf(enable)});
	}

	public boolean body_is_omitting_force_integration(long body) {
		return (boolean) super.call("body_is_omitting_force_integration",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_state_sync_callback(long body, Callable callable) {
		super.call("body_set_state_sync_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) callable});
	}

	public void body_set_force_integration_callback(long body, Callable callable, Object userdata) {
		super.call("body_set_force_integration_callback", new java.lang.Object[]{java.lang.Long.valueOf(body),
				(java.lang.Object) callable, (java.lang.Object) userdata});
	}

	public boolean body_test_motion(long body, PhysicsTestMotionParameters2D parameters,
			PhysicsTestMotionResult2D result) {
		return (boolean) super.call("body_test_motion", new java.lang.Object[]{java.lang.Long.valueOf(body),
				(java.lang.Object) parameters, (java.lang.Object) result});
	}

	public PhysicsDirectBodyState2D body_get_direct_state(long body) {
		return (PhysicsDirectBodyState2D) super.call("body_get_direct_state",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public long joint_create() {
		return (long) super.call("joint_create");
	}

	public void joint_clear(long joint) {
		super.call("joint_clear", new java.lang.Object[]{java.lang.Long.valueOf(joint)});
	}

	public void joint_set_param(long joint, int param, double value) {
		super.call("joint_set_param", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double joint_get_param(long joint, int param) {
		return (double) super.call("joint_get_param",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Integer.valueOf(param)});
	}

	public void joint_disable_collisions_between_bodies(long joint, boolean disable) {
		super.call("joint_disable_collisions_between_bodies",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Boolean.valueOf(disable)});
	}

	public boolean joint_is_disabled_collisions_between_bodies(long joint) {
		return (boolean) super.call("joint_is_disabled_collisions_between_bodies",
				new java.lang.Object[]{java.lang.Long.valueOf(joint)});
	}

	public void joint_make_pin(long joint, Vector2 anchor, long body_a, long body_b) {
		super.call("joint_make_pin", new java.lang.Object[]{java.lang.Long.valueOf(joint), (java.lang.Object) anchor,
				java.lang.Long.valueOf(body_a), java.lang.Long.valueOf(body_b)});
	}

	public void joint_make_groove(long joint, Vector2 groove1_a, Vector2 groove2_a, Vector2 anchor_b, long body_a,
			long body_b) {
		super.call("joint_make_groove",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), (java.lang.Object) groove1_a,
						(java.lang.Object) groove2_a, (java.lang.Object) anchor_b, java.lang.Long.valueOf(body_a),
						java.lang.Long.valueOf(body_b)});
	}

	public void joint_make_damped_spring(long joint, Vector2 anchor_a, Vector2 anchor_b, long body_a, long body_b) {
		super.call("joint_make_damped_spring",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), (java.lang.Object) anchor_a,
						(java.lang.Object) anchor_b, java.lang.Long.valueOf(body_a), java.lang.Long.valueOf(body_b)});
	}

	public void pin_joint_set_flag(long joint, int flag, boolean enabled) {
		super.call("pin_joint_set_flag", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean pin_joint_get_flag(long joint, int flag) {
		return (boolean) super.call("pin_joint_get_flag",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Integer.valueOf(flag)});
	}

	public void pin_joint_set_param(long joint, int param, double value) {
		super.call("pin_joint_set_param", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double pin_joint_get_param(long joint, int param) {
		return (double) super.call("pin_joint_get_param",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Integer.valueOf(param)});
	}

	public void damped_spring_joint_set_param(long joint, int param, double value) {
		super.call("damped_spring_joint_set_param", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double damped_spring_joint_get_param(long joint, int param) {
		return (double) super.call("damped_spring_joint_get_param",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Integer.valueOf(param)});
	}

	public int joint_get_type(long joint) {
		return (int) super.call("joint_get_type", new java.lang.Object[]{java.lang.Long.valueOf(joint)});
	}

	public void free_rid(long rid) {
		super.call("free_rid", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public int get_process_info(int process_info) {
		return (int) super.call("get_process_info", new java.lang.Object[]{java.lang.Integer.valueOf(process_info)});
	}
}
