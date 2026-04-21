package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.core.Callable;
import org.godot.math.AABB;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class PhysicsServer3D extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("hinge_joint_set_param", 3165502333L),
			java.util.Map.entry("concave_polygon_shape_create", 529393457L),
			java.util.Map.entry("body_get_shape_count", 2198884583L),
			java.util.Map.entry("area_set_ray_pickable", 1265174801L),
			java.util.Map.entry("body_get_max_contacts_reported", 2198884583L),
			java.util.Map.entry("soft_body_get_total_mass", 866169185L),
			java.util.Map.entry("shape_get_type", 3418923367L),
			java.util.Map.entry("body_set_axis_velocity", 3227306858L),
			java.util.Map.entry("soft_body_get_state", 1850449534L),
			java.util.Map.entry("body_add_constant_central_force", 3227306858L),
			java.util.Map.entry("area_get_space", 3814569979L),
			java.util.Map.entry("body_is_continuous_collision_detection_enabled", 4155700596L),
			java.util.Map.entry("soft_body_create", 529393457L), java.util.Map.entry("body_set_state", 599977762L),
			java.util.Map.entry("pin_joint_set_local_a", 3227306858L),
			java.util.Map.entry("pin_joint_set_local_b", 3227306858L),
			java.util.Map.entry("soft_body_update_rendering_server", 2218179753L),
			java.util.Map.entry("soft_body_set_total_mass", 1794382983L),
			java.util.Map.entry("soft_body_get_damping_coefficient", 866169185L),
			java.util.Map.entry("body_set_force_integration_callback", 3059434249L),
			java.util.Map.entry("body_set_omit_force_integration", 1265174801L),
			java.util.Map.entry("soft_body_get_point_global_position", 3440143363L),
			java.util.Map.entry("joint_make_generic_6dof", 1684107643L), java.util.Map.entry("set_active", 2586408642L),
			java.util.Map.entry("custom_shape_create", 529393457L),
			java.util.Map.entry("body_set_enable_continuous_collision_detection", 1265174801L),
			java.util.Map.entry("soft_body_set_simulation_precision", 3411492887L),
			java.util.Map.entry("world_boundary_shape_create", 529393457L),
			java.util.Map.entry("joint_clear", 2722037293L),
			java.util.Map.entry("area_attach_object_instance_id", 3411492887L),
			java.util.Map.entry("soft_body_set_collision_mask", 3411492887L),
			java.util.Map.entry("body_get_collision_layer", 2198884583L),
			java.util.Map.entry("joint_make_hinge", 1684107643L),
			java.util.Map.entry("area_set_area_monitor_callback", 3379118538L),
			java.util.Map.entry("area_get_shape_count", 2198884583L),
			java.util.Map.entry("body_set_state_sync_callback", 3379118538L),
			java.util.Map.entry("body_add_constant_torque", 3227306858L),
			java.util.Map.entry("joint_make_pin", 4280171926L),
			java.util.Map.entry("space_get_direct_state", 2048616813L),
			java.util.Map.entry("body_is_omitting_force_integration", 4155700596L),
			java.util.Map.entry("soft_body_set_space", 395945892L),
			java.util.Map.entry("soft_body_is_point_pinned", 3120086654L),
			java.util.Map.entry("body_get_collision_mask", 2198884583L),
			java.util.Map.entry("body_attach_object_instance_id", 3411492887L),
			java.util.Map.entry("soft_body_get_simulation_precision", 2198884583L),
			java.util.Map.entry("generic_6dof_joint_set_param", 2600081391L),
			java.util.Map.entry("cylinder_shape_create", 529393457L),
			java.util.Map.entry("body_get_space", 3814569979L), java.util.Map.entry("soft_body_move_point", 831953689L),
			java.util.Map.entry("joint_create", 529393457L),
			java.util.Map.entry("soft_body_set_ray_pickable", 1265174801L),
			java.util.Map.entry("body_apply_force", 390416203L),
			java.util.Map.entry("body_reset_mass_properties", 2722037293L),
			java.util.Map.entry("area_set_shape_transform", 675327471L),
			java.util.Map.entry("body_is_axis_locked", 587853580L),
			java.util.Map.entry("soft_body_set_mesh", 395945892L),
			java.util.Map.entry("soft_body_set_shrinking_factor", 1794382983L),
			java.util.Map.entry("area_get_shape_transform", 1050775521L),
			java.util.Map.entry("body_apply_central_impulse", 3227306858L),
			java.util.Map.entry("area_set_space", 395945892L), java.util.Map.entry("body_create", 529393457L),
			java.util.Map.entry("body_remove_shape", 3411492887L),
			java.util.Map.entry("heightmap_shape_create", 529393457L),
			java.util.Map.entry("body_get_shape_transform", 1050775521L),
			java.util.Map.entry("body_get_constant_torque", 531438156L),
			java.util.Map.entry("area_set_monitorable", 1265174801L),
			java.util.Map.entry("soft_body_add_collision_exception", 395945892L),
			java.util.Map.entry("body_set_ray_pickable", 1265174801L),
			java.util.Map.entry("joint_is_disabled_collisions_between_bodies", 4155700596L),
			java.util.Map.entry("hinge_joint_get_param", 2129207581L),
			java.util.Map.entry("body_apply_central_force", 3227306858L),
			java.util.Map.entry("body_set_axis_lock", 2020836892L),
			java.util.Map.entry("sphere_shape_create", 529393457L),
			java.util.Map.entry("slider_joint_get_param", 3498644957L), java.util.Map.entry("area_create", 529393457L),
			java.util.Map.entry("body_set_shape_transform", 675327471L),
			java.util.Map.entry("soft_body_get_collision_mask", 2198884583L),
			java.util.Map.entry("shape_set_margin", 1794382983L),
			java.util.Map.entry("soft_body_get_collision_layer", 2198884583L),
			java.util.Map.entry("soft_body_apply_point_force", 831953689L),
			java.util.Map.entry("body_test_motion", 1944921792L),
			java.util.Map.entry("body_set_max_contacts_reported", 3411492887L),
			java.util.Map.entry("soft_body_set_collision_layer", 3411492887L),
			java.util.Map.entry("area_get_collision_mask", 2198884583L),
			java.util.Map.entry("area_set_param", 2980114638L), java.util.Map.entry("area_add_shape", 3711419014L),
			java.util.Map.entry("soft_body_apply_central_impulse", 3227306858L),
			java.util.Map.entry("pin_joint_set_param", 810685294L), java.util.Map.entry("body_get_mode", 2488819728L),
			java.util.Map.entry("space_create", 529393457L), java.util.Map.entry("space_is_active", 4155700596L),
			java.util.Map.entry("space_set_active", 1265174801L),
			java.util.Map.entry("body_set_collision_priority", 1794382983L),
			java.util.Map.entry("soft_body_remove_all_pinned_points", 2722037293L),
			java.util.Map.entry("area_remove_shape", 3411492887L), java.util.Map.entry("body_set_space", 395945892L),
			java.util.Map.entry("soft_body_remove_collision_exception", 395945892L),
			java.util.Map.entry("body_set_constant_torque", 3227306858L),
			java.util.Map.entry("soft_body_get_shrinking_factor", 866169185L),
			java.util.Map.entry("body_apply_torque", 3227306858L),
			java.util.Map.entry("body_get_direct_state", 3029727957L),
			java.util.Map.entry("soft_body_pin_point", 2658558584L), java.util.Map.entry("body_get_param", 3385027841L),
			java.util.Map.entry("shape_get_margin", 866169185L), java.util.Map.entry("body_set_mode", 606803466L),
			java.util.Map.entry("generic_6dof_joint_get_flag", 4158090196L),
			java.util.Map.entry("soft_body_set_pressure_coefficient", 1794382983L),
			java.util.Map.entry("body_set_collision_mask", 3411492887L),
			java.util.Map.entry("body_add_collision_exception", 395945892L),
			java.util.Map.entry("body_get_collision_priority", 866169185L),
			java.util.Map.entry("body_apply_torque_impulse", 3227306858L),
			java.util.Map.entry("body_set_constant_force", 3227306858L),
			java.util.Map.entry("slider_joint_set_param", 2264833593L),
			java.util.Map.entry("shape_get_data", 4171304767L),
			java.util.Map.entry("joint_disable_collisions_between_bodies", 1265174801L),
			java.util.Map.entry("shape_set_data", 3175752987L),
			java.util.Map.entry("body_remove_collision_exception", 395945892L),
			java.util.Map.entry("area_get_param", 890056067L),
			java.util.Map.entry("separation_ray_shape_create", 529393457L),
			java.util.Map.entry("generic_6dof_joint_get_param", 467122058L),
			java.util.Map.entry("area_set_shape", 2310537182L),
			java.util.Map.entry("soft_body_apply_central_force", 3227306858L),
			java.util.Map.entry("soft_body_set_damping_coefficient", 1794382983L),
			java.util.Map.entry("hinge_joint_set_flag", 1601626188L),
			java.util.Map.entry("joint_make_slider", 1684107643L),
			java.util.Map.entry("cone_twist_joint_get_param", 1134789658L),
			java.util.Map.entry("hinge_joint_get_flag", 4165147865L),
			java.util.Map.entry("space_set_param", 2406017470L), java.util.Map.entry("body_clear_shapes", 2722037293L),
			java.util.Map.entry("body_set_collision_layer", 3411492887L),
			java.util.Map.entry("body_set_param", 910941953L), java.util.Map.entry("body_get_state", 1850449534L),
			java.util.Map.entry("area_get_transform", 1128465797L),
			java.util.Map.entry("area_set_shape_disabled", 2658558584L),
			java.util.Map.entry("area_get_object_instance_id", 2198884583L),
			java.util.Map.entry("area_set_collision_mask", 3411492887L),
			java.util.Map.entry("soft_body_get_linear_stiffness", 866169185L),
			java.util.Map.entry("pin_joint_get_local_a", 531438156L),
			java.util.Map.entry("body_get_object_instance_id", 2198884583L),
			java.util.Map.entry("pin_joint_get_local_b", 531438156L),
			java.util.Map.entry("soft_body_apply_point_impulse", 831953689L),
			java.util.Map.entry("soft_body_set_state", 599977762L), java.util.Map.entry("body_add_shape", 3711419014L),
			java.util.Map.entry("body_get_shape", 1066463050L),
			java.util.Map.entry("soft_body_set_drag_coefficient", 1794382983L),
			java.util.Map.entry("body_set_shape_disabled", 2658558584L),
			java.util.Map.entry("soft_body_get_pressure_coefficient", 866169185L),
			java.util.Map.entry("body_set_shape", 2310537182L), java.util.Map.entry("body_apply_impulse", 390416203L),
			java.util.Map.entry("pin_joint_get_param", 2817972347L),
			java.util.Map.entry("generic_6dof_joint_set_flag", 3570926903L),
			java.util.Map.entry("body_get_constant_force", 531438156L),
			java.util.Map.entry("soft_body_get_drag_coefficient", 866169185L),
			java.util.Map.entry("joint_get_type", 4290791900L), java.util.Map.entry("capsule_shape_create", 529393457L),
			java.util.Map.entry("area_set_transform", 3935195649L),
			java.util.Map.entry("area_get_collision_layer", 2198884583L), java.util.Map.entry("free_rid", 2722037293L),
			java.util.Map.entry("area_clear_shapes", 2722037293L),
			java.util.Map.entry("soft_body_get_bounds", 974181306L),
			java.util.Map.entry("convex_polygon_shape_create", 529393457L),
			java.util.Map.entry("area_set_monitor_callback", 3379118538L),
			java.util.Map.entry("get_process_info", 1332958745L),
			java.util.Map.entry("soft_body_set_transform", 3935195649L),
			java.util.Map.entry("area_get_shape", 1066463050L),
			java.util.Map.entry("joint_set_solver_priority", 3411492887L),
			java.util.Map.entry("box_shape_create", 529393457L), java.util.Map.entry("space_get_param", 1523206731L),
			java.util.Map.entry("cone_twist_joint_set_param", 808587618L),
			java.util.Map.entry("body_add_constant_force", 390416203L),
			java.util.Map.entry("joint_get_solver_priority", 2198884583L),
			java.util.Map.entry("joint_make_cone_twist", 1684107643L),
			java.util.Map.entry("area_set_collision_layer", 3411492887L),
			java.util.Map.entry("soft_body_set_linear_stiffness", 1794382983L),
			java.util.Map.entry("soft_body_get_space", 3814569979L));

	PhysicsServer3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsServer3D(long nativePointer) {
		super(nativePointer);
	}

	public long world_boundary_shape_create() {
		return (long) super.call("world_boundary_shape_create");
	}

	public long separation_ray_shape_create() {
		return (long) super.call("separation_ray_shape_create");
	}

	public long sphere_shape_create() {
		return (long) super.call("sphere_shape_create");
	}

	public long box_shape_create() {
		return (long) super.call("box_shape_create");
	}

	public long capsule_shape_create() {
		return (long) super.call("capsule_shape_create");
	}

	public long cylinder_shape_create() {
		return (long) super.call("cylinder_shape_create");
	}

	public long convex_polygon_shape_create() {
		return (long) super.call("convex_polygon_shape_create");
	}

	public long concave_polygon_shape_create() {
		return (long) super.call("concave_polygon_shape_create");
	}

	public long heightmap_shape_create() {
		return (long) super.call("heightmap_shape_create");
	}

	public long custom_shape_create() {
		return (long) super.call("custom_shape_create");
	}

	public void shape_set_data(long shape, Object data) {
		super.call("shape_set_data", new java.lang.Object[]{java.lang.Long.valueOf(shape), (java.lang.Object) data});
	}

	public void shape_set_margin(long shape, double margin) {
		super.call("shape_set_margin",
				new java.lang.Object[]{java.lang.Long.valueOf(shape), java.lang.Double.valueOf(margin)});
	}

	public int shape_get_type(long shape) {
		return (int) super.call("shape_get_type", new java.lang.Object[]{java.lang.Long.valueOf(shape)});
	}

	public Object shape_get_data(long shape) {
		return (Object) super.call("shape_get_data", new java.lang.Object[]{java.lang.Long.valueOf(shape)});
	}

	public double shape_get_margin(long shape) {
		return (double) super.call("shape_get_margin", new java.lang.Object[]{java.lang.Long.valueOf(shape)});
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

	public PhysicsDirectSpaceState3D space_get_direct_state(long space) {
		return (PhysicsDirectSpaceState3D) super.call("space_get_direct_state",
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

	public void area_add_shape(long area, long shape, Transform3D transform, boolean disabled) {
		super.call("area_add_shape", new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Long.valueOf(shape),
				(java.lang.Object) transform, java.lang.Boolean.valueOf(disabled)});
	}

	public void area_set_shape(long area, long shape_idx, long shape) {
		super.call("area_set_shape", new java.lang.Object[]{java.lang.Long.valueOf(area),
				java.lang.Long.valueOf(shape_idx), java.lang.Long.valueOf(shape)});
	}

	public void area_set_shape_transform(long area, long shape_idx, Transform3D transform) {
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

	public Transform3D area_get_shape_transform(long area, long shape_idx) {
		return (Transform3D) super.call("area_get_shape_transform",
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

	public void area_set_transform(long area, Transform3D transform) {
		super.call("area_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(area), (java.lang.Object) transform});
	}

	public Object area_get_param(long area, int param) {
		return (Object) super.call("area_get_param",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Integer.valueOf(param)});
	}

	public Transform3D area_get_transform(long area) {
		return (Transform3D) super.call("area_get_transform", new java.lang.Object[]{java.lang.Long.valueOf(area)});
	}

	public void area_attach_object_instance_id(long area, long id) {
		super.call("area_attach_object_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Long.valueOf(id)});
	}

	public java.math.BigInteger area_get_object_instance_id(long area) {
		return (java.math.BigInteger) super.call("area_get_object_instance_id",
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

	public void area_set_ray_pickable(long area, boolean enable) {
		super.call("area_set_ray_pickable",
				new java.lang.Object[]{java.lang.Long.valueOf(area), java.lang.Boolean.valueOf(enable)});
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

	public void body_add_shape(long body, long shape, Transform3D transform, boolean disabled) {
		super.call("body_add_shape", new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(shape),
				(java.lang.Object) transform, java.lang.Boolean.valueOf(disabled)});
	}

	public void body_set_shape(long body, long shape_idx, long shape) {
		super.call("body_set_shape", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Long.valueOf(shape_idx), java.lang.Long.valueOf(shape)});
	}

	public void body_set_shape_transform(long body, long shape_idx, Transform3D transform) {
		super.call("body_set_shape_transform", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Long.valueOf(shape_idx), (java.lang.Object) transform});
	}

	public void body_set_shape_disabled(long body, long shape_idx, boolean disabled) {
		super.call("body_set_shape_disabled", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Long.valueOf(shape_idx), java.lang.Boolean.valueOf(disabled)});
	}

	public int body_get_shape_count(long body) {
		return (int) super.call("body_get_shape_count", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public long body_get_shape(long body, long shape_idx) {
		return (long) super.call("body_get_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(shape_idx)});
	}

	public Transform3D body_get_shape_transform(long body, long shape_idx) {
		return (Transform3D) super.call("body_get_shape_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(shape_idx)});
	}

	public void body_remove_shape(long body, long shape_idx) {
		super.call("body_remove_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(shape_idx)});
	}

	public void body_clear_shapes(long body) {
		super.call("body_clear_shapes", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_attach_object_instance_id(long body, long id) {
		super.call("body_attach_object_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(id)});
	}

	public java.math.BigInteger body_get_object_instance_id(long body) {
		return (java.math.BigInteger) super.call("body_get_object_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_enable_continuous_collision_detection(long body, boolean enable) {
		super.call("body_set_enable_continuous_collision_detection",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Boolean.valueOf(enable)});
	}

	public boolean body_is_continuous_collision_detection_enabled(long body) {
		return (boolean) super.call("body_is_continuous_collision_detection_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
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

	public void body_apply_central_impulse(long body, Vector3 impulse) {
		super.call("body_apply_central_impulse",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) impulse});
	}

	public void body_apply_impulse(long body, Vector3 impulse, Vector3 position) {
		super.call("body_apply_impulse", new java.lang.Object[]{java.lang.Long.valueOf(body),
				(java.lang.Object) impulse, (java.lang.Object) position});
	}

	public void body_apply_torque_impulse(long body, Vector3 impulse) {
		super.call("body_apply_torque_impulse",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) impulse});
	}

	public void body_apply_central_force(long body, Vector3 force) {
		super.call("body_apply_central_force",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) force});
	}

	public void body_apply_force(long body, Vector3 force, Vector3 position) {
		super.call("body_apply_force", new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) force,
				(java.lang.Object) position});
	}

	public void body_apply_torque(long body, Vector3 torque) {
		super.call("body_apply_torque",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) torque});
	}

	public void body_add_constant_central_force(long body, Vector3 force) {
		super.call("body_add_constant_central_force",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) force});
	}

	public void body_add_constant_force(long body, Vector3 force, Vector3 position) {
		super.call("body_add_constant_force", new java.lang.Object[]{java.lang.Long.valueOf(body),
				(java.lang.Object) force, (java.lang.Object) position});
	}

	public void body_add_constant_torque(long body, Vector3 torque) {
		super.call("body_add_constant_torque",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) torque});
	}

	public void body_set_constant_force(long body, Vector3 force) {
		super.call("body_set_constant_force",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) force});
	}

	public Vector3 body_get_constant_force(long body) {
		return (Vector3) super.call("body_get_constant_force", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_constant_torque(long body, Vector3 torque) {
		super.call("body_set_constant_torque",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) torque});
	}

	public Vector3 body_get_constant_torque(long body) {
		return (Vector3) super.call("body_get_constant_torque", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void body_set_axis_velocity(long body, Vector3 axis_velocity) {
		super.call("body_set_axis_velocity",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) axis_velocity});
	}

	public void body_set_axis_lock(long body, int axis, boolean lock) {
		super.call("body_set_axis_lock", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Integer.valueOf(axis), java.lang.Boolean.valueOf(lock)});
	}

	public boolean body_is_axis_locked(long body, int axis) {
		return (boolean) super.call("body_is_axis_locked",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Integer.valueOf(axis)});
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

	public void body_set_ray_pickable(long body, boolean enable) {
		super.call("body_set_ray_pickable",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Boolean.valueOf(enable)});
	}

	public boolean body_test_motion(long body, PhysicsTestMotionParameters3D parameters,
			PhysicsTestMotionResult3D result) {
		return (boolean) super.call("body_test_motion", new java.lang.Object[]{java.lang.Long.valueOf(body),
				(java.lang.Object) parameters, (java.lang.Object) result});
	}

	public PhysicsDirectBodyState3D body_get_direct_state(long body) {
		return (PhysicsDirectBodyState3D) super.call("body_get_direct_state",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public long soft_body_create() {
		return (long) super.call("soft_body_create");
	}

	public void soft_body_update_rendering_server(long body,
			PhysicsServer3DRenderingServerHandler rendering_server_handler) {
		super.call("soft_body_update_rendering_server",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) rendering_server_handler});
	}

	public void soft_body_set_space(long body, long space) {
		super.call("soft_body_set_space",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(space)});
	}

	public long soft_body_get_space(long body) {
		return (long) super.call("soft_body_get_space", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void soft_body_set_mesh(long body, long mesh) {
		super.call("soft_body_set_mesh",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(mesh)});
	}

	public AABB soft_body_get_bounds(long body) {
		return (AABB) super.call("soft_body_get_bounds", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void soft_body_set_collision_layer(long body, long layer) {
		super.call("soft_body_set_collision_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(layer)});
	}

	public long soft_body_get_collision_layer(long body) {
		return (long) super.call("soft_body_get_collision_layer", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void soft_body_set_collision_mask(long body, long mask) {
		super.call("soft_body_set_collision_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(mask)});
	}

	public long soft_body_get_collision_mask(long body) {
		return (long) super.call("soft_body_get_collision_mask", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void soft_body_add_collision_exception(long body, long body_b) {
		super.call("soft_body_add_collision_exception",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(body_b)});
	}

	public void soft_body_remove_collision_exception(long body, long body_b) {
		super.call("soft_body_remove_collision_exception",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(body_b)});
	}

	public void soft_body_set_state(long body, int state, Object variant) {
		super.call("soft_body_set_state", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Integer.valueOf(state), (java.lang.Object) variant});
	}

	public Object soft_body_get_state(long body, int state) {
		return (Object) super.call("soft_body_get_state",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Integer.valueOf(state)});
	}

	public void soft_body_set_transform(long body, Transform3D transform) {
		super.call("soft_body_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) transform});
	}

	public void soft_body_set_ray_pickable(long body, boolean enable) {
		super.call("soft_body_set_ray_pickable",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Boolean.valueOf(enable)});
	}

	public void soft_body_set_simulation_precision(long body, long simulation_precision) {
		super.call("soft_body_set_simulation_precision",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(simulation_precision)});
	}

	public int soft_body_get_simulation_precision(long body) {
		return (int) super.call("soft_body_get_simulation_precision",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void soft_body_set_total_mass(long body, double total_mass) {
		super.call("soft_body_set_total_mass",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Double.valueOf(total_mass)});
	}

	public double soft_body_get_total_mass(long body) {
		return (double) super.call("soft_body_get_total_mass", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void soft_body_set_linear_stiffness(long body, double stiffness) {
		super.call("soft_body_set_linear_stiffness",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Double.valueOf(stiffness)});
	}

	public double soft_body_get_linear_stiffness(long body) {
		return (double) super.call("soft_body_get_linear_stiffness",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void soft_body_set_shrinking_factor(long body, double shrinking_factor) {
		super.call("soft_body_set_shrinking_factor",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Double.valueOf(shrinking_factor)});
	}

	public double soft_body_get_shrinking_factor(long body) {
		return (double) super.call("soft_body_get_shrinking_factor",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void soft_body_set_pressure_coefficient(long body, double pressure_coefficient) {
		super.call("soft_body_set_pressure_coefficient",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Double.valueOf(pressure_coefficient)});
	}

	public double soft_body_get_pressure_coefficient(long body) {
		return (double) super.call("soft_body_get_pressure_coefficient",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void soft_body_set_damping_coefficient(long body, double damping_coefficient) {
		super.call("soft_body_set_damping_coefficient",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Double.valueOf(damping_coefficient)});
	}

	public double soft_body_get_damping_coefficient(long body) {
		return (double) super.call("soft_body_get_damping_coefficient",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void soft_body_set_drag_coefficient(long body, double drag_coefficient) {
		super.call("soft_body_set_drag_coefficient",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Double.valueOf(drag_coefficient)});
	}

	public double soft_body_get_drag_coefficient(long body) {
		return (double) super.call("soft_body_get_drag_coefficient",
				new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void soft_body_move_point(long body, long point_index, Vector3 global_position) {
		super.call("soft_body_move_point", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Long.valueOf(point_index), (java.lang.Object) global_position});
	}

	public Vector3 soft_body_get_point_global_position(long body, long point_index) {
		return (Vector3) super.call("soft_body_get_point_global_position",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(point_index)});
	}

	public void soft_body_remove_all_pinned_points(long body) {
		super.call("soft_body_remove_all_pinned_points", new java.lang.Object[]{java.lang.Long.valueOf(body)});
	}

	public void soft_body_pin_point(long body, long point_index, boolean pin) {
		super.call("soft_body_pin_point", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Long.valueOf(point_index), java.lang.Boolean.valueOf(pin)});
	}

	public boolean soft_body_is_point_pinned(long body, long point_index) {
		return (boolean) super.call("soft_body_is_point_pinned",
				new java.lang.Object[]{java.lang.Long.valueOf(body), java.lang.Long.valueOf(point_index)});
	}

	public void soft_body_apply_point_impulse(long body, long point_index, Vector3 impulse) {
		super.call("soft_body_apply_point_impulse", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Long.valueOf(point_index), (java.lang.Object) impulse});
	}

	public void soft_body_apply_point_force(long body, long point_index, Vector3 force) {
		super.call("soft_body_apply_point_force", new java.lang.Object[]{java.lang.Long.valueOf(body),
				java.lang.Long.valueOf(point_index), (java.lang.Object) force});
	}

	public void soft_body_apply_central_impulse(long body, Vector3 impulse) {
		super.call("soft_body_apply_central_impulse",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) impulse});
	}

	public void soft_body_apply_central_force(long body, Vector3 force) {
		super.call("soft_body_apply_central_force",
				new java.lang.Object[]{java.lang.Long.valueOf(body), (java.lang.Object) force});
	}

	public long joint_create() {
		return (long) super.call("joint_create");
	}

	public void joint_clear(long joint) {
		super.call("joint_clear", new java.lang.Object[]{java.lang.Long.valueOf(joint)});
	}

	public void joint_make_pin(long joint, long body_A, Vector3 local_A, long body_B, Vector3 local_B) {
		super.call("joint_make_pin",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Long.valueOf(body_A),
						(java.lang.Object) local_A, java.lang.Long.valueOf(body_B), (java.lang.Object) local_B});
	}

	public void pin_joint_set_param(long joint, int param, double value) {
		super.call("pin_joint_set_param", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double pin_joint_get_param(long joint, int param) {
		return (double) super.call("pin_joint_get_param",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Integer.valueOf(param)});
	}

	public void pin_joint_set_local_a(long joint, Vector3 local_A) {
		super.call("pin_joint_set_local_a",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), (java.lang.Object) local_A});
	}

	public Vector3 pin_joint_get_local_a(long joint) {
		return (Vector3) super.call("pin_joint_get_local_a", new java.lang.Object[]{java.lang.Long.valueOf(joint)});
	}

	public void pin_joint_set_local_b(long joint, Vector3 local_B) {
		super.call("pin_joint_set_local_b",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), (java.lang.Object) local_B});
	}

	public Vector3 pin_joint_get_local_b(long joint) {
		return (Vector3) super.call("pin_joint_get_local_b", new java.lang.Object[]{java.lang.Long.valueOf(joint)});
	}

	public void joint_make_hinge(long joint, long body_A, Transform3D hinge_A, long body_B, Transform3D hinge_B) {
		super.call("joint_make_hinge",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Long.valueOf(body_A),
						(java.lang.Object) hinge_A, java.lang.Long.valueOf(body_B), (java.lang.Object) hinge_B});
	}

	public void hinge_joint_set_param(long joint, int param, double value) {
		super.call("hinge_joint_set_param", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double hinge_joint_get_param(long joint, int param) {
		return (double) super.call("hinge_joint_get_param",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Integer.valueOf(param)});
	}

	public void hinge_joint_set_flag(long joint, int flag, boolean enabled) {
		super.call("hinge_joint_set_flag", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean hinge_joint_get_flag(long joint, int flag) {
		return (boolean) super.call("hinge_joint_get_flag",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Integer.valueOf(flag)});
	}

	public void joint_make_slider(long joint, long body_A, Transform3D local_ref_A, long body_B,
			Transform3D local_ref_B) {
		super.call("joint_make_slider",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Long.valueOf(body_A),
						(java.lang.Object) local_ref_A, java.lang.Long.valueOf(body_B),
						(java.lang.Object) local_ref_B});
	}

	public void slider_joint_set_param(long joint, int param, double value) {
		super.call("slider_joint_set_param", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double slider_joint_get_param(long joint, int param) {
		return (double) super.call("slider_joint_get_param",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Integer.valueOf(param)});
	}

	public void joint_make_cone_twist(long joint, long body_A, Transform3D local_ref_A, long body_B,
			Transform3D local_ref_B) {
		super.call("joint_make_cone_twist",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Long.valueOf(body_A),
						(java.lang.Object) local_ref_A, java.lang.Long.valueOf(body_B),
						(java.lang.Object) local_ref_B});
	}

	public void cone_twist_joint_set_param(long joint, int param, double value) {
		super.call("cone_twist_joint_set_param", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double cone_twist_joint_get_param(long joint, int param) {
		return (double) super.call("cone_twist_joint_get_param",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Integer.valueOf(param)});
	}

	public int joint_get_type(long joint) {
		return (int) super.call("joint_get_type", new java.lang.Object[]{java.lang.Long.valueOf(joint)});
	}

	public void joint_set_solver_priority(long joint, long priority) {
		super.call("joint_set_solver_priority",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Long.valueOf(priority)});
	}

	public int joint_get_solver_priority(long joint) {
		return (int) super.call("joint_get_solver_priority", new java.lang.Object[]{java.lang.Long.valueOf(joint)});
	}

	public void joint_disable_collisions_between_bodies(long joint, boolean disable) {
		super.call("joint_disable_collisions_between_bodies",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Boolean.valueOf(disable)});
	}

	public boolean joint_is_disabled_collisions_between_bodies(long joint) {
		return (boolean) super.call("joint_is_disabled_collisions_between_bodies",
				new java.lang.Object[]{java.lang.Long.valueOf(joint)});
	}

	public void joint_make_generic_6dof(long joint, long body_A, Transform3D local_ref_A, long body_B,
			Transform3D local_ref_B) {
		super.call("joint_make_generic_6dof",
				new java.lang.Object[]{java.lang.Long.valueOf(joint), java.lang.Long.valueOf(body_A),
						(java.lang.Object) local_ref_A, java.lang.Long.valueOf(body_B),
						(java.lang.Object) local_ref_B});
	}

	public void generic_6dof_joint_set_param(long joint, int axis, int param, double value) {
		super.call("generic_6dof_joint_set_param", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(axis), java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double generic_6dof_joint_get_param(long joint, int axis, int param) {
		return (double) super.call("generic_6dof_joint_get_param", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(axis), java.lang.Integer.valueOf(param)});
	}

	public void generic_6dof_joint_set_flag(long joint, int axis, int flag, boolean enable) {
		super.call("generic_6dof_joint_set_flag", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(axis), java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(enable)});
	}

	public boolean generic_6dof_joint_get_flag(long joint, int axis, int flag) {
		return (boolean) super.call("generic_6dof_joint_get_flag", new java.lang.Object[]{java.lang.Long.valueOf(joint),
				java.lang.Integer.valueOf(axis), java.lang.Integer.valueOf(flag)});
	}

	public void free_rid(long rid) {
		super.call("free_rid", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public int get_process_info(int process_info) {
		return (int) super.call("get_process_info", new java.lang.Object[]{java.lang.Integer.valueOf(process_info)});
	}
}
