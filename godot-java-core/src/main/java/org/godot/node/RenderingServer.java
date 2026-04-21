package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.core.Callable;
import org.godot.math.AABB;
import org.godot.math.Basis;
import org.godot.math.Color;
import org.godot.math.Plane;
import org.godot.math.Rect2;
import org.godot.math.Transform2D;
import org.godot.math.Transform3D;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;
import org.godot.math.Vector3;
import org.godot.math.Vector3i;

public class RenderingServer extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("multimesh_get_custom_aabb", 974181306L),
			java.util.Map.entry("viewport_get_render_info", 2041262392L),
			java.util.Map.entry("decal_set_modulate", 2948539648L),
			java.util.Map.entry("viewport_set_scaling_3d_scale", 1794382983L),
			java.util.Map.entry("decal_create", 529393457L),
			java.util.Map.entry("particles_collision_create", 529393457L),
			java.util.Map.entry("particles_collision_set_collision_type", 1497044930L),
			java.util.Map.entry("viewport_set_msaa_2d", 3764433340L),
			java.util.Map.entry("environment_glow_set_use_bicubic_upscale", 2586408642L),
			java.util.Map.entry("mesh_surface_get_format_offset", 2981368685L),
			java.util.Map.entry("skeleton_bone_get_transform_2d", 1324854622L),
			java.util.Map.entry("environment_set_background", 3937328877L),
			java.util.Map.entry("mesh_set_shadow_mesh", 395945892L),
			java.util.Map.entry("canvas_item_set_interpolated", 1265174801L),
			java.util.Map.entry("canvas_light_set_transform", 1246044741L),
			java.util.Map.entry("make_sphere_mesh", 2251015897L), java.util.Map.entry("occluder_create", 529393457L),
			java.util.Map.entry("camera_attributes_set_auto_exposure", 4266986332L),
			java.util.Map.entry("particles_restart", 2722037293L),
			java.util.Map.entry("mesh_get_blend_shape_mode", 4282291819L),
			java.util.Map.entry("viewport_set_anisotropic_filtering_level", 3953214029L),
			java.util.Map.entry("mesh_add_surface_from_arrays", 2342446560L),
			java.util.Map.entry("skeleton_allocate_data", 1904426712L),
			java.util.Map.entry("particles_collision_height_field_update", 2722037293L),
			java.util.Map.entry("multimesh_instance_reset_physics_interpolation", 3411492887L),
			java.util.Map.entry("multimesh_set_physics_interpolated", 1265174801L),
			java.util.Map.entry("light_set_bake_mode", 1048525260L),
			java.util.Map.entry("particles_set_emitting", 1265174801L),
			java.util.Map.entry("viewport_set_msaa_3d", 3764433340L),
			java.util.Map.entry("compositor_create", 529393457L),
			java.util.Map.entry("decal_set_emission_energy", 1794382983L),
			java.util.Map.entry("viewport_set_global_canvas_transform", 1246044741L),
			java.util.Map.entry("viewport_set_size", 4288446313L),
			java.util.Map.entry("texture_3d_placeholder_create", 529393457L),
			java.util.Map.entry("canvas_item_set_canvas_group_mode", 3973586316L),
			java.util.Map.entry("particles_collision_set_attractor_directionality", 1794382983L),
			java.util.Map.entry("instance_set_transform", 3935195649L),
			java.util.Map.entry("light_set_projector", 395945892L),
			java.util.Map.entry("particles_set_pre_process_time", 1794382983L),
			java.util.Map.entry("canvas_item_add_multiline", 3098767073L),
			java.util.Map.entry("viewport_set_render_direct_to_screen", 1265174801L),
			java.util.Map.entry("scenario_set_camera_attributes", 395945892L),
			java.util.Map.entry("canvas_item_set_z_as_relative_to_parent", 1265174801L),
			java.util.Map.entry("camera_attributes_set_dof_blur", 316272616L),
			java.util.Map.entry("particles_collision_set_cull_mask", 3411492887L),
			java.util.Map.entry("texture_3d_update", 684822712L), java.util.Map.entry("texture_replace", 395945892L),
			java.util.Map.entry("light_directional_set_sky_mode", 2559740754L),
			java.util.Map.entry("environment_set_bg_color", 2948539648L),
			java.util.Map.entry("multimesh_get_buffer", 3964669176L),
			java.util.Map.entry("voxel_gi_get_distance_field", 3348040486L),
			java.util.Map.entry("instances_cull_ray", 2208759584L),
			java.util.Map.entry("canvas_light_set_interpolated", 1265174801L),
			java.util.Map.entry("particles_set_draw_passes", 3411492887L),
			java.util.Map.entry("viewport_set_debug_draw", 2089420930L),
			java.util.Map.entry("instance_geometry_set_material_overlay", 395945892L),
			java.util.Map.entry("environment_set_canvas_max_layer", 3411492887L),
			java.util.Map.entry("reflection_probe_set_max_distance", 1794382983L),
			java.util.Map.entry("sky_set_mode", 3279019937L),
			java.util.Map.entry("canvas_item_set_distance_field_mode", 1265174801L),
			java.util.Map.entry("canvas_light_set_energy", 1794382983L),
			java.util.Map.entry("particles_set_one_shot", 1265174801L),
			java.util.Map.entry("instance_set_extra_visibility_margin", 1794382983L),
			java.util.Map.entry("canvas_item_set_instance_shader_parameter", 3477296213L),
			java.util.Map.entry("viewport_set_parent_viewport", 395945892L),
			java.util.Map.entry("particles_collision_set_field_texture", 395945892L),
			java.util.Map.entry("canvas_item_create", 529393457L),
			java.util.Map.entry("mesh_surface_get_format_skin_stride", 3188363337L),
			java.util.Map.entry("voxel_gi_set_normal_bias", 1794382983L),
			java.util.Map.entry("viewport_set_use_hdr_2d", 1265174801L),
			java.util.Map.entry("canvas_item_set_draw_index", 3411492887L),
			java.util.Map.entry("instance_geometry_set_material_override", 395945892L),
			java.util.Map.entry("canvas_item_get_instance_shader_parameter_default_value", 2621281810L),
			java.util.Map.entry("texture_get_native_handle", 1834114100L),
			java.util.Map.entry("skeleton_bone_set_transform_2d", 736082694L),
			java.util.Map.entry("particles_request_process_time", 1794382983L),
			java.util.Map.entry("reflection_probe_set_blend_distance", 1794382983L),
			java.util.Map.entry("canvas_set_item_repeat", 1739512717L),
			java.util.Map.entry("scenario_set_compositor", 395945892L),
			java.util.Map.entry("particles_get_current_aabb", 3952830260L),
			java.util.Map.entry("occluder_set_mesh", 3854404263L),
			java.util.Map.entry("canvas_light_set_item_shadow_cull_mask", 3411492887L),
			java.util.Map.entry("camera_attributes_set_dof_blur_quality", 2220136795L),
			java.util.Map.entry("particles_set_randomness_ratio", 1794382983L),
			java.util.Map.entry("texture_2d_layered_placeholder_create", 1394585590L),
			java.util.Map.entry("viewport_set_use_taa", 1265174801L),
			java.util.Map.entry("environment_set_fog_depth", 157498339L),
			java.util.Map.entry("set_debug_generate_wireframes", 2586408642L),
			java.util.Map.entry("voxel_gi_set_energy", 1794382983L),
			java.util.Map.entry("canvas_light_set_z_range", 4288446313L),
			java.util.Map.entry("environment_set_volumetric_fog_volume_size", 3937882851L),
			java.util.Map.entry("viewport_set_use_debanding", 1265174801L),
			java.util.Map.entry("reflection_probe_set_intensity", 1794382983L),
			java.util.Map.entry("particles_collision_set_box_extents", 3227306858L),
			java.util.Map.entry("canvas_texture_set_texture_filter", 1155129294L),
			java.util.Map.entry("canvas_item_add_texture_rect", 324864032L),
			java.util.Map.entry("is_on_render_thread", 2240911060L),
			java.util.Map.entry("canvas_item_set_visible", 1265174801L),
			java.util.Map.entry("viewport_set_default_canvas_item_texture_filter", 1155129294L),
			java.util.Map.entry("canvas_item_add_ellipse", 4188642757L),
			java.util.Map.entry("viewport_set_canvas_stacking", 3713930247L),
			java.util.Map.entry("viewport_attach_canvas", 395945892L),
			java.util.Map.entry("viewport_set_update_mode", 3161116010L),
			java.util.Map.entry("particles_collision_set_attractor_strength", 1794382983L),
			java.util.Map.entry("mesh_get_surface_count", 2198884583L),
			java.util.Map.entry("canvas_item_add_triangle_array", 660261329L),
			java.util.Map.entry("particles_set_amount", 3411492887L),
			java.util.Map.entry("skeleton_get_bone_count", 2198884583L),
			java.util.Map.entry("multimesh_set_mesh", 395945892L),
			java.util.Map.entry("multimesh_instance_get_transform_2d", 1324854622L),
			java.util.Map.entry("texture_2d_create", 2010018390L),
			java.util.Map.entry("canvas_item_get_instance_shader_parameter_list", 2684255073L),
			java.util.Map.entry("fog_volume_create", 529393457L),
			java.util.Map.entry("instance_set_visible", 1265174801L), java.util.Map.entry("mesh_clear", 2722037293L),
			java.util.Map.entry("particles_set_fractional_delta", 1265174801L),
			java.util.Map.entry("mesh_create_from_surfaces", 4291747531L),
			java.util.Map.entry("viewport_get_measured_render_time_gpu", 866169185L),
			java.util.Map.entry("camera_set_cull_mask", 3411492887L),
			java.util.Map.entry("multimesh_instance_get_color", 2946315076L),
			java.util.Map.entry("canvas_light_occluder_set_light_mask", 3411492887L),
			java.util.Map.entry("canvas_set_modulate", 2948539648L),
			java.util.Map.entry("texture_set_size_override", 4288446313L),
			java.util.Map.entry("reflection_probe_set_ambient_energy", 1794382983L),
			java.util.Map.entry("free_rid", 2722037293L), java.util.Map.entry("camera_attributes_create", 529393457L),
			java.util.Map.entry("shader_create", 529393457L),
			java.util.Map.entry("viewport_set_vrs_texture", 395945892L),
			java.util.Map.entry("environment_set_sdfgi_frames_to_update_light", 1251144068L),
			java.util.Map.entry("light_set_reverse_cull_face_mode", 1265174801L),
			java.util.Map.entry("canvas_light_occluder_set_enabled", 1265174801L),
			java.util.Map.entry("reflection_probe_set_resolution", 3411492887L),
			java.util.Map.entry("particles_get_emitting", 3521089500L),
			java.util.Map.entry("particles_request_process", 2722037293L),
			java.util.Map.entry("canvas_occluder_polygon_set_shape", 2103882027L),
			java.util.Map.entry("environment_set_ssr", 3607294374L),
			java.util.Map.entry("texture_2d_placeholder_create", 529393457L),
			java.util.Map.entry("canvas_item_set_copy_to_backbuffer", 2429202503L),
			java.util.Map.entry("texture_2d_update", 999539803L),
			java.util.Map.entry("environment_set_sdfgi_ray_count", 340137951L),
			java.util.Map.entry("positional_soft_shadow_filter_set_quality", 3613045266L),
			java.util.Map.entry("viewport_set_active", 1265174801L),
			java.util.Map.entry("particles_set_interpolate", 1265174801L),
			java.util.Map.entry("viewport_set_canvas_cull_mask", 3411492887L),
			java.util.Map.entry("get_white_texture", 529393457L),
			java.util.Map.entry("instance_attach_skeleton", 395945892L),
			java.util.Map.entry("canvas_light_set_color", 2948539648L),
			java.util.Map.entry("instance_create", 529393457L),
			java.util.Map.entry("shader_set_default_texture_parameter", 4094001817L),
			java.util.Map.entry("canvas_item_add_nine_patch", 389957886L),
			java.util.Map.entry("canvas_light_transform_physics_interpolation", 1246044741L),
			java.util.Map.entry("canvas_light_occluder_set_interpolated", 1265174801L),
			java.util.Map.entry("visibility_notifier_create", 529393457L),
			java.util.Map.entry("compositor_effect_set_callback", 487412485L),
			java.util.Map.entry("texture_get_path", 642473191L),
			java.util.Map.entry("directional_shadow_atlas_set_size", 300928843L),
			java.util.Map.entry("canvas_item_add_animation_slice", 2646834499L),
			java.util.Map.entry("reflection_probe_set_ambient_mode", 184163074L),
			java.util.Map.entry("canvas_light_occluder_set_as_sdf_collision", 1265174801L),
			java.util.Map.entry("instance_set_surface_override_material", 2310537182L),
			java.util.Map.entry("environment_set_tonemap", 2914312638L),
			java.util.Map.entry("canvas_item_set_self_modulate", 2948539648L),
			java.util.Map.entry("set_default_clear_color", 2920490490L),
			java.util.Map.entry("environment_set_tonemap_agx_contrast", 1794382983L),
			java.util.Map.entry("canvas_set_item_mirroring", 2343975398L),
			java.util.Map.entry("mesh_surface_get_format_normal_tangent_stride", 3188363337L),
			java.util.Map.entry("mesh_surface_set_material", 2310537182L),
			java.util.Map.entry("gi_set_use_half_resolution", 2586408642L),
			java.util.Map.entry("texture_set_path", 2726140452L),
			java.util.Map.entry("lightmap_set_probe_capture_data", 3217845880L),
			java.util.Map.entry("canvas_light_set_enabled", 1265174801L),
			java.util.Map.entry("texture_set_force_redraw_if_visible", 1265174801L),
			java.util.Map.entry("lightmap_create", 529393457L),
			java.util.Map.entry("scenario_set_fallback_environment", 395945892L),
			java.util.Map.entry("mesh_get_custom_aabb", 974181306L),
			java.util.Map.entry("mesh_surface_get_format_attribute_stride", 3188363337L),
			java.util.Map.entry("canvas_item_add_lcd_texture_rect_region", 359793297L),
			java.util.Map.entry("lightmap_set_probe_capture_update_speed", 373806689L),
			java.util.Map.entry("texture_get_format", 1932918979L),
			java.util.Map.entry("instance_set_scenario", 395945892L),
			java.util.Map.entry("bake_render_uv2", 1904608558L),
			java.util.Map.entry("multimesh_instance_set_transform_2d", 736082694L),
			java.util.Map.entry("voxel_gi_get_level_counts", 788230395L),
			java.util.Map.entry("canvas_item_set_draw_behind_parent", 1265174801L),
			java.util.Map.entry("is_render_loop_enabled", 36873697L),
			java.util.Map.entry("directional_light_create", 529393457L),
			java.util.Map.entry("viewport_set_screen_space_aa", 1447279591L),
			java.util.Map.entry("mesh_surface_get_material", 1066463050L),
			java.util.Map.entry("instance_geometry_set_visibility_range", 4263925858L),
			java.util.Map.entry("canvas_item_add_mesh", 316450961L),
			java.util.Map.entry("mesh_surface_get_arrays", 1778388067L),
			java.util.Map.entry("scenario_set_environment", 395945892L),
			java.util.Map.entry("light_directional_set_shadow_mode", 380462970L),
			java.util.Map.entry("canvas_item_add_set_transform", 1246044741L),
			java.util.Map.entry("material_set_shader", 395945892L),
			java.util.Map.entry("particles_set_process_material", 395945892L),
			java.util.Map.entry("instance_set_base", 395945892L),
			java.util.Map.entry("instance_attach_object_instance_id", 3411492887L),
			java.util.Map.entry("reflection_probe_set_reflection_mask", 3411492887L),
			java.util.Map.entry("environment_set_ssao", 3994732740L),
			java.util.Map.entry("voxel_gi_set_dynamic_range", 1794382983L),
			java.util.Map.entry("canvas_item_add_rect", 3523446176L),
			java.util.Map.entry("particles_set_interp_to_end", 1794382983L),
			java.util.Map.entry("texture_3d_create", 4036838706L),
			java.util.Map.entry("shader_set_path_hint", 2726140452L),
			java.util.Map.entry("viewport_set_texture_mipmap_bias", 1794382983L),
			java.util.Map.entry("particles_set_custom_aabb", 3696536120L),
			java.util.Map.entry("canvas_light_occluder_set_transform", 1246044741L),
			java.util.Map.entry("global_shader_parameter_get_list", 3995934104L),
			java.util.Map.entry("particles_set_transform_align", 3264971368L),
			java.util.Map.entry("instance_geometry_set_cast_shadows_setting", 3768836020L),
			java.util.Map.entry("texture_proxy_update", 395945892L),
			java.util.Map.entry("viewport_set_measure_render_time", 1265174801L),
			java.util.Map.entry("light_set_color", 2948539648L),
			java.util.Map.entry("voxel_gi_get_octree_cells", 3348040486L),
			java.util.Map.entry("set_boot_image_with_stretch", 1104470771L),
			java.util.Map.entry("reflection_probe_set_enable_box_projection", 1265174801L),
			java.util.Map.entry("canvas_item_set_light_mask", 3411492887L),
			java.util.Map.entry("material_set_next_pass", 395945892L),
			java.util.Map.entry("decal_set_normal_fade", 1794382983L),
			java.util.Map.entry("multimesh_set_buffer", 2960552364L),
			java.util.Map.entry("instances_cull_convex", 2488539944L),
			java.util.Map.entry("reflection_probe_set_size", 3227306858L),
			java.util.Map.entry("particles_set_trails", 2010054925L),
			java.util.Map.entry("viewport_set_transparent_background", 1265174801L),
			java.util.Map.entry("multimesh_set_buffer_interpolated", 659844711L),
			java.util.Map.entry("viewport_get_render_target", 3814569979L),
			java.util.Map.entry("instance_geometry_get_shader_parameter_default_value", 2621281810L),
			java.util.Map.entry("particles_collision_set_attractor_attenuation", 1794382983L),
			java.util.Map.entry("camera_set_camera_attributes", 395945892L),
			java.util.Map.entry("voxel_gi_set_interior", 1265174801L), java.util.Map.entry("canvas_create", 529393457L),
			java.util.Map.entry("environment_set_ssil_quality", 1713836683L),
			java.util.Map.entry("scenario_create", 529393457L),
			java.util.Map.entry("particles_set_lifetime", 1794382983L),
			java.util.Map.entry("mesh_set_blend_shape_mode", 1294662092L),
			java.util.Map.entry("voxel_gi_get_octree_size", 2607699645L),
			java.util.Map.entry("visibility_notifier_set_aabb", 3696536120L),
			java.util.Map.entry("instance_set_visibility_parent", 395945892L),
			java.util.Map.entry("viewport_get_update_mode", 3803901472L),
			java.util.Map.entry("canvas_item_add_polyline", 3098767073L),
			java.util.Map.entry("canvas_set_disable_scale", 2586408642L),
			java.util.Map.entry("decal_set_fade", 2513314492L),
			java.util.Map.entry("camera_set_environment", 395945892L),
			java.util.Map.entry("canvas_item_clear", 2722037293L),
			java.util.Map.entry("environment_set_bg_energy", 2513314492L),
			java.util.Map.entry("get_current_rendering_driver_name", 201670096L),
			java.util.Map.entry("particles_set_draw_pass_mesh", 2310537182L),
			java.util.Map.entry("canvas_light_set_texture_scale", 1794382983L),
			java.util.Map.entry("canvas_occluder_polygon_create", 529393457L),
			java.util.Map.entry("sky_set_material", 395945892L),
			java.util.Map.entry("instance_set_ignore_culling", 1265174801L),
			java.util.Map.entry("create_local_rendering_device", 1405107940L),
			java.util.Map.entry("instance_create2", 746547085L),
			java.util.Map.entry("canvas_light_set_item_cull_mask", 3411492887L),
			java.util.Map.entry("canvas_item_set_default_texture_repeat", 1652956681L),
			java.util.Map.entry("canvas_item_add_circle", 333077949L),
			java.util.Map.entry("multimesh_get_mesh", 3814569979L),
			java.util.Map.entry("voxel_gi_get_to_cell_xform", 1128465797L),
			java.util.Map.entry("texture_2d_layer_get", 2705440895L),
			java.util.Map.entry("lightmap_set_probe_interior", 1265174801L),
			java.util.Map.entry("sky_create", 529393457L), java.util.Map.entry("light_set_distance_fade", 1622292572L),
			java.util.Map.entry("voxel_gi_set_quality", 1538689978L),
			java.util.Map.entry("camera_set_transform", 3935195649L),
			java.util.Map.entry("instance_geometry_get_shader_parameter", 2621281810L),
			java.util.Map.entry("material_set_use_debanding", 2586408642L),
			java.util.Map.entry("environment_set_sky", 395945892L),
			java.util.Map.entry("canvas_item_set_z_index", 3411492887L),
			java.util.Map.entry("compositor_effect_set_enabled", 1265174801L),
			java.util.Map.entry("canvas_light_occluder_reset_physics_interpolation", 2722037293L),
			java.util.Map.entry("viewport_get_texture", 3814569979L), java.util.Map.entry("force_draw", 1076185472L),
			java.util.Map.entry("has_changed", 36873697L), java.util.Map.entry("mesh_add_surface", 1217542888L),
			java.util.Map.entry("viewport_set_occlusion_culling_build_quality", 2069725696L),
			java.util.Map.entry("multimesh_create", 529393457L),
			java.util.Map.entry("decal_set_albedo_mix", 1794382983L),
			java.util.Map.entry("canvas_item_transform_physics_interpolation", 1246044741L),
			java.util.Map.entry("canvas_light_set_height", 1794382983L),
			java.util.Map.entry("voxel_gi_get_data_cells", 3348040486L),
			java.util.Map.entry("camera_attributes_set_dof_blur_bokeh_shape", 1205058394L),
			java.util.Map.entry("canvas_item_set_visibility_layer", 3411492887L),
			java.util.Map.entry("canvas_light_set_blend_mode", 804895945L),
			java.util.Map.entry("texture_get_rd_texture", 2790148051L),
			java.util.Map.entry("omni_light_create", 529393457L),
			java.util.Map.entry("particles_set_amount_ratio", 1794382983L),
			java.util.Map.entry("canvas_item_reset_physics_interpolation", 2722037293L),
			java.util.Map.entry("texture_create_from_native_handle", 1682977582L),
			java.util.Map.entry("voxel_gi_set_propagation", 1794382983L),
			java.util.Map.entry("canvas_light_occluder_attach_to_canvas", 395945892L),
			java.util.Map.entry("light_set_shadow_caster_mask", 3411492887L),
			java.util.Map.entry("spot_light_create", 529393457L),
			java.util.Map.entry("lightmap_get_probe_capture_sh", 1569415609L),
			java.util.Map.entry("mesh_surface_get_format_index_stride", 3188363337L),
			java.util.Map.entry("canvas_item_set_custom_rect", 1333997032L),
			java.util.Map.entry("light_directional_set_blend_splits", 1265174801L),
			java.util.Map.entry("light_set_negative", 1265174801L),
			java.util.Map.entry("canvas_texture_set_shading_parameters", 2124967469L),
			java.util.Map.entry("environment_bake_panorama", 2452908646L),
			java.util.Map.entry("canvas_occluder_polygon_set_cull_mode", 1839404663L),
			java.util.Map.entry("viewport_set_default_canvas_item_texture_repeat", 1652956681L),
			java.util.Map.entry("canvas_item_add_multimesh", 2131855138L),
			java.util.Map.entry("get_test_cube", 529393457L),
			java.util.Map.entry("voxel_gi_allocate_data", 4108223027L),
			java.util.Map.entry("global_shader_parameter_get", 2760726917L),
			java.util.Map.entry("canvas_texture_set_channel", 3822119138L),
			java.util.Map.entry("has_os_feature", 3927539163L),
			java.util.Map.entry("multimesh_set_physics_interpolation_quality", 3934808223L),
			java.util.Map.entry("instance_geometry_set_lod_bias", 1794382983L),
			java.util.Map.entry("visibility_notifier_set_callbacks", 2689735388L),
			java.util.Map.entry("mesh_surface_get_format_vertex_stride", 3188363337L),
			java.util.Map.entry("mesh_surface_update_index_region", 2900195149L),
			java.util.Map.entry("viewport_set_snap_2d_vertices_to_pixel", 1265174801L),
			java.util.Map.entry("camera_set_compositor", 395945892L),
			java.util.Map.entry("sub_surface_scattering_set_quality", 64571803L),
			java.util.Map.entry("multimesh_get_aabb", 974181306L),
			java.util.Map.entry("decal_set_texture", 3953344054L),
			java.util.Map.entry("particles_set_fixed_fps", 3411492887L),
			java.util.Map.entry("instance_geometry_set_flag", 1014989537L),
			java.util.Map.entry("global_shader_parameter_get_type", 1601414142L),
			java.util.Map.entry("reflection_probe_set_ambient_color", 2948539648L),
			java.util.Map.entry("canvas_light_reset_physics_interpolation", 2722037293L),
			java.util.Map.entry("environment_set_glow", 2421724940L),
			java.util.Map.entry("shader_get_code", 642473191L),
			java.util.Map.entry("mesh_surface_update_skin_region", 2900195149L),
			java.util.Map.entry("light_set_cull_mask", 3411492887L),
			java.util.Map.entry("call_on_render_thread", 1611583062L),
			java.util.Map.entry("viewport_attach_camera", 395945892L),
			java.util.Map.entry("viewport_set_sdf_oversize_and_scale", 1329198632L),
			java.util.Map.entry("viewport_set_disable_3d", 1265174801L),
			java.util.Map.entry("light_set_shadow", 1265174801L),
			java.util.Map.entry("light_omni_set_shadow_mode", 2552677200L),
			java.util.Map.entry("particles_collision_set_sphere_radius", 1794382983L),
			java.util.Map.entry("environment_set_sdfgi_frames_to_converge", 2182444374L),
			java.util.Map.entry("canvas_light_attach_to_canvas", 395945892L),
			java.util.Map.entry("decal_set_distance_fade", 2972769666L),
			java.util.Map.entry("camera_set_frustum", 1889878953L),
			java.util.Map.entry("multimesh_instance_set_custom_data", 176975443L),
			java.util.Map.entry("get_frame_setup_time_cpu", 1740695150L),
			java.util.Map.entry("environment_set_sky_custom_fov", 1794382983L),
			java.util.Map.entry("canvas_item_set_use_parent_material", 1265174801L),
			java.util.Map.entry("get_video_adapter_vendor", 201670096L),
			java.util.Map.entry("viewport_set_disable_2d", 1265174801L),
			java.util.Map.entry("environment_set_ssr_roughness_quality", 1190026788L),
			java.util.Map.entry("canvas_item_set_material", 395945892L),
			java.util.Map.entry("canvas_item_set_clip", 1265174801L),
			java.util.Map.entry("canvas_light_set_shadow_enabled", 1265174801L),
			java.util.Map.entry("material_create", 529393457L),
			java.util.Map.entry("viewport_set_snap_2d_transforms_to_pixel", 1265174801L),
			java.util.Map.entry("material_set_render_priority", 3411492887L),
			java.util.Map.entry("particles_set_trail_bind_poses", 684822712L),
			java.util.Map.entry("particles_collision_set_height_field_mask", 3411492887L),
			java.util.Map.entry("environment_set_fog", 105051629L),
			java.util.Map.entry("environment_set_volumetric_fog_filter_active", 2586408642L),
			java.util.Map.entry("reflection_probe_set_origin_offset", 3227306858L),
			java.util.Map.entry("environment_set_ssr_half_size", 2586408642L),
			java.util.Map.entry("canvas_texture_set_texture_repeat", 1652956681L),
			java.util.Map.entry("particles_set_emission_transform", 3935195649L),
			java.util.Map.entry("environment_set_sdfgi", 3519144388L),
			java.util.Map.entry("canvas_item_add_polygon", 3580000528L),
			java.util.Map.entry("texture_2d_get", 4206205781L),
			java.util.Map.entry("canvas_light_set_mode", 2957564891L),
			java.util.Map.entry("instances_cull_aabb", 2570105777L),
			java.util.Map.entry("camera_set_use_vertical_aspect", 1265174801L),
			java.util.Map.entry("reflection_probe_set_as_interior", 1265174801L),
			java.util.Map.entry("instance_set_blend_shape_weight", 1892459533L),
			java.util.Map.entry("lightmap_get_probe_capture_tetrahedra", 788230395L),
			java.util.Map.entry("canvas_light_set_layer_range", 4288446313L),
			java.util.Map.entry("light_projectors_set_filter", 43944325L),
			java.util.Map.entry("viewport_set_use_xr", 1265174801L),
			java.util.Map.entry("get_default_clear_color", 3200896285L),
			java.util.Map.entry("canvas_item_add_texture_rect_region", 485157892L),
			java.util.Map.entry("multimesh_set_visible_instances", 3411492887L),
			java.util.Map.entry("skeleton_set_base_transform_2d", 1246044741L),
			java.util.Map.entry("particles_set_draw_order", 935028487L),
			java.util.Map.entry("fog_volume_set_material", 395945892L), java.util.Map.entry("mesh_create", 529393457L),
			java.util.Map.entry("viewport_set_positional_shadow_atlas_size", 1904426712L),
			java.util.Map.entry("global_shader_parameter_remove", 3304788590L),
			java.util.Map.entry("canvas_item_set_modulate", 2948539648L),
			java.util.Map.entry("particles_set_emitter_velocity", 3227306858L),
			java.util.Map.entry("mesh_get_surface", 186674697L), java.util.Map.entry("sky_bake_panorama", 3875285818L),
			java.util.Map.entry("compositor_effect_create", 529393457L),
			java.util.Map.entry("environment_set_adjustment", 876799838L),
			java.util.Map.entry("skeleton_bone_get_transform", 1050775521L),
			java.util.Map.entry("canvas_item_set_sort_children_by_y", 1265174801L),
			java.util.Map.entry("viewport_set_scenario", 395945892L),
			java.util.Map.entry("skeleton_bone_set_transform", 675327471L),
			java.util.Map.entry("viewport_remove_canvas", 395945892L),
			java.util.Map.entry("multimesh_instance_set_transform", 675327471L),
			java.util.Map.entry("canvas_light_set_texture_offset", 3201125042L),
			java.util.Map.entry("decal_set_cull_mask", 3411492887L),
			java.util.Map.entry("camera_set_orthogonal", 157498339L),
			java.util.Map.entry("multimesh_get_visible_instances", 2198884583L),
			java.util.Map.entry("set_render_loop_enabled", 2586408642L),
			java.util.Map.entry("canvas_light_set_shadow_color", 2948539648L),
			java.util.Map.entry("instance_geometry_get_shader_parameter_list", 2684255073L),
			java.util.Map.entry("texture_rd_create", 1434128712L),
			java.util.Map.entry("viewport_set_vrs_mode", 398809874L),
			java.util.Map.entry("global_shader_parameter_add", 463390080L),
			java.util.Map.entry("voxel_gi_set_use_two_bounces", 1265174801L),
			java.util.Map.entry("get_current_rendering_method", 201670096L),
			java.util.Map.entry("canvas_light_set_texture", 395945892L),
			java.util.Map.entry("instance_geometry_set_shader_parameter", 3477296213L),
			java.util.Map.entry("viewport_create", 529393457L),
			java.util.Map.entry("canvas_item_set_transform", 1246044741L),
			java.util.Map.entry("canvas_item_add_particles", 2575754278L),
			java.util.Map.entry("reflection_probe_create", 529393457L),
			java.util.Map.entry("global_shader_parameter_set_override", 3776071444L),
			java.util.Map.entry("light_set_param", 501936875L),
			java.util.Map.entry("shader_get_parameter_default", 2621281810L),
			java.util.Map.entry("compositor_set_compositor_effects", 684822712L),
			java.util.Map.entry("canvas_light_occluder_set_polygon", 395945892L),
			java.util.Map.entry("viewport_set_clear_mode", 3628367896L),
			java.util.Map.entry("sub_surface_scattering_set_scale", 1017552074L),
			java.util.Map.entry("environment_set_ambient_light", 1214961493L),
			java.util.Map.entry("particles_set_collision_base_size", 1794382983L),
			java.util.Map.entry("viewport_set_positional_shadow_atlas_quadrant_subdivision", 4288446313L),
			java.util.Map.entry("multimesh_get_buffer_rd_rid", 3814569979L),
			java.util.Map.entry("lightmap_set_baked_exposure_normalization", 1794382983L),
			java.util.Map.entry("fog_volume_set_size", 3227306858L),
			java.util.Map.entry("canvas_light_occluder_transform_physics_interpolation", 1246044741L),
			java.util.Map.entry("environment_set_camera_id", 3411492887L),
			java.util.Map.entry("shader_get_default_texture_parameter", 1464608890L),
			java.util.Map.entry("particles_set_explosiveness_ratio", 1794382983L),
			java.util.Map.entry("multimesh_allocate_data", 557240154L),
			java.util.Map.entry("viewport_set_environment_mode", 2196892182L),
			java.util.Map.entry("set_boot_image", 3759744527L), java.util.Map.entry("texture_3d_get", 2684255073L),
			java.util.Map.entry("particles_collision_set_height_field_resolution", 962977297L),
			java.util.Map.entry("viewport_set_use_occlusion_culling", 1265174801L),
			java.util.Map.entry("environment_set_ssao_quality", 189753569L),
			java.util.Map.entry("get_rendering_device", 1405107940L),
			java.util.Map.entry("viewport_set_canvas_transform", 3608606053L),
			java.util.Map.entry("material_set_param", 3477296213L),
			java.util.Map.entry("decals_set_filter", 3519875702L),
			java.util.Map.entry("mesh_surface_remove", 3411492887L), java.util.Map.entry("particles_emit", 4043136117L),
			java.util.Map.entry("particles_set_speed_scale", 1794382983L),
			java.util.Map.entry("screen_space_roughness_limiter_set_active", 916716790L),
			java.util.Map.entry("canvas_item_attach_skeleton", 395945892L),
			java.util.Map.entry("viewport_set_occlusion_rays_per_thread", 1286410249L),
			java.util.Map.entry("global_shader_parameter_set", 3776071444L),
			java.util.Map.entry("debug_canvas_item_get_rect", 624227424L),
			java.util.Map.entry("force_sync", 3218959716L),
			java.util.Map.entry("mesh_surface_update_vertex_region", 2900195149L),
			java.util.Map.entry("multimesh_get_command_buffer_rd_rid", 3814569979L),
			java.util.Map.entry("light_set_max_sdfgi_cascade", 3411492887L),
			java.util.Map.entry("instance_geometry_set_lightmap", 536974962L),
			java.util.Map.entry("canvas_texture_create", 529393457L),
			java.util.Map.entry("canvas_item_add_line", 1819681853L),
			java.util.Map.entry("canvas_light_create", 529393457L),
			java.util.Map.entry("multimesh_instance_get_custom_data", 2946315076L),
			java.util.Map.entry("request_frame_drawn_callback", 1611583062L),
			java.util.Map.entry("mesh_get_blend_shape_count", 2198884583L),
			java.util.Map.entry("multimesh_instance_get_transform", 1050775521L),
			java.util.Map.entry("particles_set_use_local_coordinates", 1265174801L),
			java.util.Map.entry("get_video_adapter_name", 201670096L),
			java.util.Map.entry("decal_set_size", 3227306858L),
			java.util.Map.entry("particles_is_inactive", 3521089500L),
			java.util.Map.entry("compositor_effect_set_flag", 3659527075L),
			java.util.Map.entry("skeleton_create", 529393457L), java.util.Map.entry("voxel_gi_create", 529393457L),
			java.util.Map.entry("canvas_set_shadow_texture_size", 1286410249L),
			java.util.Map.entry("lightmap_set_textures", 2646464759L),
			java.util.Map.entry("viewport_set_scaling_3d_mode", 2386524376L),
			java.util.Map.entry("canvas_light_set_shadow_filter", 393119659L),
			java.util.Map.entry("multimesh_get_instance_count", 2198884583L),
			java.util.Map.entry("canvas_item_add_primitive", 3731601077L),
			java.util.Map.entry("get_test_texture", 529393457L),
			java.util.Map.entry("fog_volume_set_shape", 3818703106L),
			java.util.Map.entry("mesh_set_custom_aabb", 3696536120L),
			java.util.Map.entry("particles_set_mode", 3492270028L), java.util.Map.entry("particles_create", 529393457L),
			java.util.Map.entry("material_get_param", 2621281810L),
			java.util.Map.entry("instance_set_layer_mask", 3411492887L),
			java.util.Map.entry("environment_set_volumetric_fog", 1553633833L),
			java.util.Map.entry("reflection_probe_set_cull_mask", 3411492887L),
			java.util.Map.entry("canvas_item_add_msdf_texture_rect_region", 97408773L),
			java.util.Map.entry("canvas_item_set_default_texture_filter", 1155129294L),
			java.util.Map.entry("texture_2d_layered_create", 913689023L),
			java.util.Map.entry("multimesh_instance_set_color", 176975443L),
			java.util.Map.entry("canvas_item_add_clip_ignore", 1265174801L),
			java.util.Map.entry("lightmaps_set_bicubic_filter", 2586408642L),
			java.util.Map.entry("camera_create", 529393457L), java.util.Map.entry("shader_set_code", 2726140452L),
			java.util.Map.entry("canvas_item_set_parent", 395945892L),
			java.util.Map.entry("instance_set_custom_aabb", 3696536120L),
			java.util.Map.entry("canvas_light_occluder_create", 529393457L),
			java.util.Map.entry("canvas_light_set_shadow_smooth", 1794382983L),
			java.util.Map.entry("camera_attributes_set_exposure", 2513314492L),
			java.util.Map.entry("canvas_item_get_instance_shader_parameter", 2621281810L),
			java.util.Map.entry("instance_teleport", 2722037293L),
			java.util.Map.entry("texture_proxy_create", 41030802L),
			java.util.Map.entry("viewport_set_fsr_sharpness", 1794382983L),
			java.util.Map.entry("get_video_adapter_type", 3099547011L),
			java.util.Map.entry("camera_set_perspective", 157498339L),
			java.util.Map.entry("voxel_gi_set_bias", 1794382983L),
			java.util.Map.entry("viewport_attach_to_screen", 1062245816L),
			java.util.Map.entry("reflection_probe_set_mesh_lod_threshold", 1794382983L),
			java.util.Map.entry("lightmap_get_probe_capture_points", 808965560L),
			java.util.Map.entry("reflection_probe_set_update_mode", 3853670147L),
			java.util.Map.entry("get_rendering_info", 3763192241L),
			java.util.Map.entry("multimesh_set_custom_aabb", 3696536120L),
			java.util.Map.entry("viewport_set_vrs_update_mode", 2696154815L),
			java.util.Map.entry("instance_geometry_set_transparency", 1794382983L),
			java.util.Map.entry("mesh_surface_update_attribute_region", 2900195149L),
			java.util.Map.entry("viewport_get_measured_render_time_cpu", 866169185L),
			java.util.Map.entry("directional_soft_shadow_filter_set_quality", 3613045266L),
			java.util.Map.entry("reflection_probe_set_enable_shadows", 1265174801L),
			java.util.Map.entry("particles_set_subemitter", 395945892L),
			java.util.Map.entry("voxel_gi_set_baked_exposure_normalization", 1794382983L),
			java.util.Map.entry("get_video_adapter_api_version", 201670096L),
			java.util.Map.entry("lightmap_get_probe_capture_bsp_tree", 788230395L),
			java.util.Map.entry("environment_create", 529393457L),
			java.util.Map.entry("environment_set_sky_orientation", 1735850857L),
			java.util.Map.entry("lightmap_set_probe_bounds", 3696536120L),
			java.util.Map.entry("instance_set_pivot_data", 1280615259L),
			java.util.Map.entry("get_shader_parameter_list", 2684255073L),
			java.util.Map.entry("multimesh_instances_reset_physics_interpolation", 2722037293L),
			java.util.Map.entry("mesh_surface_get_blend_shape_arrays", 1778388067L),
			java.util.Map.entry("sky_set_radiance_size", 3411492887L), java.util.Map.entry("has_feature", 598462696L),
			java.util.Map.entry("canvas_item_set_visibility_notifier", 3568945579L));

	RenderingServer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RenderingServer(long nativePointer) {
		super(nativePointer);
	}

	public long texture_2d_create(Image image) {
		return (long) super.call("texture_2d_create", new java.lang.Object[]{(java.lang.Object) image});
	}

	public long texture_2d_layered_create(Image[] layers, int layered_type) {
		return (long) super.call("texture_2d_layered_create",
				new java.lang.Object[]{(java.lang.Object) layers, java.lang.Integer.valueOf(layered_type)});
	}

	public long texture_3d_create(int format, long width, long height, long depth, boolean mipmaps, Image[] data) {
		return (long) super.call("texture_3d_create",
				new java.lang.Object[]{java.lang.Integer.valueOf(format), java.lang.Long.valueOf(width),
						java.lang.Long.valueOf(height), java.lang.Long.valueOf(depth),
						java.lang.Boolean.valueOf(mipmaps), (java.lang.Object) data});
	}

	public long texture_proxy_create(long base) {
		return (long) super.call("texture_proxy_create", new java.lang.Object[]{java.lang.Long.valueOf(base)});
	}

	public long texture_create_from_native_handle(int type, int format, long native_handle, long width, long height,
			long depth, long layers, int layered_type) {
		return (long) super.call("texture_create_from_native_handle",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Integer.valueOf(format),
						java.lang.Long.valueOf(native_handle), java.lang.Long.valueOf(width),
						java.lang.Long.valueOf(height), java.lang.Long.valueOf(depth), java.lang.Long.valueOf(layers),
						java.lang.Integer.valueOf(layered_type)});
	}

	public void texture_2d_update(long texture, Image image, long layer) {
		super.call("texture_2d_update", new java.lang.Object[]{java.lang.Long.valueOf(texture),
				(java.lang.Object) image, java.lang.Long.valueOf(layer)});
	}

	public void texture_3d_update(long texture, Image[] data) {
		super.call("texture_3d_update",
				new java.lang.Object[]{java.lang.Long.valueOf(texture), (java.lang.Object) data});
	}

	public void texture_proxy_update(long texture, long proxy_to) {
		super.call("texture_proxy_update",
				new java.lang.Object[]{java.lang.Long.valueOf(texture), java.lang.Long.valueOf(proxy_to)});
	}

	public long texture_2d_placeholder_create() {
		return (long) super.call("texture_2d_placeholder_create");
	}

	public long texture_2d_layered_placeholder_create(int layered_type) {
		return (long) super.call("texture_2d_layered_placeholder_create",
				new java.lang.Object[]{java.lang.Integer.valueOf(layered_type)});
	}

	public long texture_3d_placeholder_create() {
		return (long) super.call("texture_3d_placeholder_create");
	}

	public Image texture_2d_get(long texture) {
		return (Image) super.call("texture_2d_get", new java.lang.Object[]{java.lang.Long.valueOf(texture)});
	}

	public Image texture_2d_layer_get(long texture, long layer) {
		return (Image) super.call("texture_2d_layer_get",
				new java.lang.Object[]{java.lang.Long.valueOf(texture), java.lang.Long.valueOf(layer)});
	}

	public Image[] texture_3d_get(long texture) {
		return (Image[]) super.call("texture_3d_get", new java.lang.Object[]{java.lang.Long.valueOf(texture)});
	}

	public void texture_replace(long texture, long by_texture) {
		super.call("texture_replace",
				new java.lang.Object[]{java.lang.Long.valueOf(texture), java.lang.Long.valueOf(by_texture)});
	}

	public void texture_set_size_override(long texture, long width, long height) {
		super.call("texture_set_size_override", new java.lang.Object[]{java.lang.Long.valueOf(texture),
				java.lang.Long.valueOf(width), java.lang.Long.valueOf(height)});
	}

	public void texture_set_path(long texture, String path) {
		super.call("texture_set_path",
				new java.lang.Object[]{java.lang.Long.valueOf(texture), (java.lang.Object) path});
	}

	public String texture_get_path(long texture) {
		return (String) super.call("texture_get_path", new java.lang.Object[]{java.lang.Long.valueOf(texture)});
	}

	public int texture_get_format(long texture) {
		return (int) super.call("texture_get_format", new java.lang.Object[]{java.lang.Long.valueOf(texture)});
	}

	public void texture_set_force_redraw_if_visible(long texture, boolean enable) {
		super.call("texture_set_force_redraw_if_visible",
				new java.lang.Object[]{java.lang.Long.valueOf(texture), java.lang.Boolean.valueOf(enable)});
	}

	public long texture_rd_create(long rd_texture, int layer_type) {
		return (long) super.call("texture_rd_create",
				new java.lang.Object[]{java.lang.Long.valueOf(rd_texture), java.lang.Integer.valueOf(layer_type)});
	}

	public long texture_get_rd_texture(long texture, boolean srgb) {
		return (long) super.call("texture_get_rd_texture",
				new java.lang.Object[]{java.lang.Long.valueOf(texture), java.lang.Boolean.valueOf(srgb)});
	}

	public java.math.BigInteger texture_get_native_handle(long texture, boolean srgb) {
		return (java.math.BigInteger) super.call("texture_get_native_handle",
				new java.lang.Object[]{java.lang.Long.valueOf(texture), java.lang.Boolean.valueOf(srgb)});
	}

	public long shader_create() {
		return (long) super.call("shader_create");
	}

	public void shader_set_code(long shader, String code) {
		super.call("shader_set_code", new java.lang.Object[]{java.lang.Long.valueOf(shader), (java.lang.Object) code});
	}

	public void shader_set_path_hint(long shader, String path) {
		super.call("shader_set_path_hint",
				new java.lang.Object[]{java.lang.Long.valueOf(shader), (java.lang.Object) path});
	}

	public String shader_get_code(long shader) {
		return (String) super.call("shader_get_code", new java.lang.Object[]{java.lang.Long.valueOf(shader)});
	}

	public GodotDictionary[] get_shader_parameter_list(long shader) {
		return (GodotDictionary[]) super.call("get_shader_parameter_list",
				new java.lang.Object[]{java.lang.Long.valueOf(shader)});
	}

	public Object shader_get_parameter_default(long shader, String name) {
		return (Object) super.call("shader_get_parameter_default",
				new java.lang.Object[]{java.lang.Long.valueOf(shader), (java.lang.Object) name});
	}

	public void shader_set_default_texture_parameter(long shader, String name, long texture, long index) {
		super.call("shader_set_default_texture_parameter", new java.lang.Object[]{java.lang.Long.valueOf(shader),
				(java.lang.Object) name, java.lang.Long.valueOf(texture), java.lang.Long.valueOf(index)});
	}

	public long shader_get_default_texture_parameter(long shader, String name, long index) {
		return (long) super.call("shader_get_default_texture_parameter", new java.lang.Object[]{
				java.lang.Long.valueOf(shader), (java.lang.Object) name, java.lang.Long.valueOf(index)});
	}

	public long material_create() {
		return (long) super.call("material_create");
	}

	public void material_set_shader(long shader_material, long shader) {
		super.call("material_set_shader",
				new java.lang.Object[]{java.lang.Long.valueOf(shader_material), java.lang.Long.valueOf(shader)});
	}

	public void material_set_param(long material, String parameter, Object value) {
		super.call("material_set_param", new java.lang.Object[]{java.lang.Long.valueOf(material),
				(java.lang.Object) parameter, (java.lang.Object) value});
	}

	public Object material_get_param(long material, String parameter) {
		return (Object) super.call("material_get_param",
				new java.lang.Object[]{java.lang.Long.valueOf(material), (java.lang.Object) parameter});
	}

	public void material_set_render_priority(long material, long priority) {
		super.call("material_set_render_priority",
				new java.lang.Object[]{java.lang.Long.valueOf(material), java.lang.Long.valueOf(priority)});
	}

	public void material_set_next_pass(long material, long next_material) {
		super.call("material_set_next_pass",
				new java.lang.Object[]{java.lang.Long.valueOf(material), java.lang.Long.valueOf(next_material)});
	}

	public void material_set_use_debanding(boolean enable) {
		super.call("material_set_use_debanding", new java.lang.Object[]{java.lang.Boolean.valueOf(enable)});
	}

	public long mesh_create_from_surfaces(GodotDictionary[] surfaces, long blend_shape_count) {
		return (long) super.call("mesh_create_from_surfaces",
				new java.lang.Object[]{(java.lang.Object) surfaces, java.lang.Long.valueOf(blend_shape_count)});
	}

	public long mesh_create() {
		return (long) super.call("mesh_create");
	}

	public long mesh_surface_get_format_offset(int format, long vertex_count, long array_index) {
		return (long) super.call("mesh_surface_get_format_offset",
				new java.lang.Object[]{java.lang.Integer.valueOf(format), java.lang.Long.valueOf(vertex_count),
						java.lang.Long.valueOf(array_index)});
	}

	public long mesh_surface_get_format_vertex_stride(int format, long vertex_count) {
		return (long) super.call("mesh_surface_get_format_vertex_stride",
				new java.lang.Object[]{java.lang.Integer.valueOf(format), java.lang.Long.valueOf(vertex_count)});
	}

	public long mesh_surface_get_format_normal_tangent_stride(int format, long vertex_count) {
		return (long) super.call("mesh_surface_get_format_normal_tangent_stride",
				new java.lang.Object[]{java.lang.Integer.valueOf(format), java.lang.Long.valueOf(vertex_count)});
	}

	public long mesh_surface_get_format_attribute_stride(int format, long vertex_count) {
		return (long) super.call("mesh_surface_get_format_attribute_stride",
				new java.lang.Object[]{java.lang.Integer.valueOf(format), java.lang.Long.valueOf(vertex_count)});
	}

	public long mesh_surface_get_format_skin_stride(int format, long vertex_count) {
		return (long) super.call("mesh_surface_get_format_skin_stride",
				new java.lang.Object[]{java.lang.Integer.valueOf(format), java.lang.Long.valueOf(vertex_count)});
	}

	public long mesh_surface_get_format_index_stride(int format, long vertex_count) {
		return (long) super.call("mesh_surface_get_format_index_stride",
				new java.lang.Object[]{java.lang.Integer.valueOf(format), java.lang.Long.valueOf(vertex_count)});
	}

	public void mesh_add_surface(long mesh, GodotDictionary surface) {
		super.call("mesh_add_surface",
				new java.lang.Object[]{java.lang.Long.valueOf(mesh), (java.lang.Object) surface});
	}

	public void mesh_add_surface_from_arrays(long mesh, int primitive, GodotArray arrays, GodotArray blend_shapes,
			GodotDictionary lods, int compress_format) {
		super.call("mesh_add_surface_from_arrays",
				new java.lang.Object[]{java.lang.Long.valueOf(mesh), java.lang.Integer.valueOf(primitive),
						(java.lang.Object) arrays, (java.lang.Object) blend_shapes, (java.lang.Object) lods,
						java.lang.Integer.valueOf(compress_format)});
	}

	public int mesh_get_blend_shape_count(long mesh) {
		return (int) super.call("mesh_get_blend_shape_count", new java.lang.Object[]{java.lang.Long.valueOf(mesh)});
	}

	public void mesh_set_blend_shape_mode(long mesh, int mode) {
		super.call("mesh_set_blend_shape_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(mesh), java.lang.Integer.valueOf(mode)});
	}

	public int mesh_get_blend_shape_mode(long mesh) {
		return (int) super.call("mesh_get_blend_shape_mode", new java.lang.Object[]{java.lang.Long.valueOf(mesh)});
	}

	public void mesh_surface_set_material(long mesh, long surface, long material) {
		super.call("mesh_surface_set_material", new java.lang.Object[]{java.lang.Long.valueOf(mesh),
				java.lang.Long.valueOf(surface), java.lang.Long.valueOf(material)});
	}

	public long mesh_surface_get_material(long mesh, long surface) {
		return (long) super.call("mesh_surface_get_material",
				new java.lang.Object[]{java.lang.Long.valueOf(mesh), java.lang.Long.valueOf(surface)});
	}

	public GodotDictionary mesh_get_surface(long mesh, long surface) {
		return (GodotDictionary) super.call("mesh_get_surface",
				new java.lang.Object[]{java.lang.Long.valueOf(mesh), java.lang.Long.valueOf(surface)});
	}

	public GodotArray mesh_surface_get_arrays(long mesh, long surface) {
		return (GodotArray) super.call("mesh_surface_get_arrays",
				new java.lang.Object[]{java.lang.Long.valueOf(mesh), java.lang.Long.valueOf(surface)});
	}

	public GodotArray[] mesh_surface_get_blend_shape_arrays(long mesh, long surface) {
		return (GodotArray[]) super.call("mesh_surface_get_blend_shape_arrays",
				new java.lang.Object[]{java.lang.Long.valueOf(mesh), java.lang.Long.valueOf(surface)});
	}

	public int mesh_get_surface_count(long mesh) {
		return (int) super.call("mesh_get_surface_count", new java.lang.Object[]{java.lang.Long.valueOf(mesh)});
	}

	public void mesh_set_custom_aabb(long mesh, AABB aabb) {
		super.call("mesh_set_custom_aabb",
				new java.lang.Object[]{java.lang.Long.valueOf(mesh), (java.lang.Object) aabb});
	}

	public AABB mesh_get_custom_aabb(long mesh) {
		return (AABB) super.call("mesh_get_custom_aabb", new java.lang.Object[]{java.lang.Long.valueOf(mesh)});
	}

	public void mesh_surface_remove(long mesh, long surface) {
		super.call("mesh_surface_remove",
				new java.lang.Object[]{java.lang.Long.valueOf(mesh), java.lang.Long.valueOf(surface)});
	}

	public void mesh_clear(long mesh) {
		super.call("mesh_clear", new java.lang.Object[]{java.lang.Long.valueOf(mesh)});
	}

	public void mesh_surface_update_vertex_region(long mesh, long surface, long offset, byte[] data) {
		super.call("mesh_surface_update_vertex_region", new java.lang.Object[]{java.lang.Long.valueOf(mesh),
				java.lang.Long.valueOf(surface), java.lang.Long.valueOf(offset), (java.lang.Object) data});
	}

	public void mesh_surface_update_attribute_region(long mesh, long surface, long offset, byte[] data) {
		super.call("mesh_surface_update_attribute_region", new java.lang.Object[]{java.lang.Long.valueOf(mesh),
				java.lang.Long.valueOf(surface), java.lang.Long.valueOf(offset), (java.lang.Object) data});
	}

	public void mesh_surface_update_skin_region(long mesh, long surface, long offset, byte[] data) {
		super.call("mesh_surface_update_skin_region", new java.lang.Object[]{java.lang.Long.valueOf(mesh),
				java.lang.Long.valueOf(surface), java.lang.Long.valueOf(offset), (java.lang.Object) data});
	}

	public void mesh_surface_update_index_region(long mesh, long surface, long offset, byte[] data) {
		super.call("mesh_surface_update_index_region", new java.lang.Object[]{java.lang.Long.valueOf(mesh),
				java.lang.Long.valueOf(surface), java.lang.Long.valueOf(offset), (java.lang.Object) data});
	}

	public void mesh_set_shadow_mesh(long mesh, long shadow_mesh) {
		super.call("mesh_set_shadow_mesh",
				new java.lang.Object[]{java.lang.Long.valueOf(mesh), java.lang.Long.valueOf(shadow_mesh)});
	}

	public long multimesh_create() {
		return (long) super.call("multimesh_create");
	}

	public void multimesh_allocate_data(long multimesh, long instances, int transform_format, boolean color_format,
			boolean custom_data_format, boolean use_indirect) {
		super.call("multimesh_allocate_data",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh), java.lang.Long.valueOf(instances),
						java.lang.Integer.valueOf(transform_format), java.lang.Boolean.valueOf(color_format),
						java.lang.Boolean.valueOf(custom_data_format), java.lang.Boolean.valueOf(use_indirect)});
	}

	public int multimesh_get_instance_count(long multimesh) {
		return (int) super.call("multimesh_get_instance_count",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh)});
	}

	public void multimesh_set_mesh(long multimesh, long mesh) {
		super.call("multimesh_set_mesh",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh), java.lang.Long.valueOf(mesh)});
	}

	public void multimesh_instance_set_transform(long multimesh, long index, Transform3D transform) {
		super.call("multimesh_instance_set_transform", new java.lang.Object[]{java.lang.Long.valueOf(multimesh),
				java.lang.Long.valueOf(index), (java.lang.Object) transform});
	}

	public void multimesh_instance_set_transform_2d(long multimesh, long index, Transform2D transform) {
		super.call("multimesh_instance_set_transform_2d", new java.lang.Object[]{java.lang.Long.valueOf(multimesh),
				java.lang.Long.valueOf(index), (java.lang.Object) transform});
	}

	public void multimesh_instance_set_color(long multimesh, long index, Color color) {
		super.call("multimesh_instance_set_color", new java.lang.Object[]{java.lang.Long.valueOf(multimesh),
				java.lang.Long.valueOf(index), (java.lang.Object) color});
	}

	public void multimesh_instance_set_custom_data(long multimesh, long index, Color custom_data) {
		super.call("multimesh_instance_set_custom_data", new java.lang.Object[]{java.lang.Long.valueOf(multimesh),
				java.lang.Long.valueOf(index), (java.lang.Object) custom_data});
	}

	public long multimesh_get_mesh(long multimesh) {
		return (long) super.call("multimesh_get_mesh", new java.lang.Object[]{java.lang.Long.valueOf(multimesh)});
	}

	public AABB multimesh_get_aabb(long multimesh) {
		return (AABB) super.call("multimesh_get_aabb", new java.lang.Object[]{java.lang.Long.valueOf(multimesh)});
	}

	public void multimesh_set_custom_aabb(long multimesh, AABB aabb) {
		super.call("multimesh_set_custom_aabb",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh), (java.lang.Object) aabb});
	}

	public AABB multimesh_get_custom_aabb(long multimesh) {
		return (AABB) super.call("multimesh_get_custom_aabb",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh)});
	}

	public Transform3D multimesh_instance_get_transform(long multimesh, long index) {
		return (Transform3D) super.call("multimesh_instance_get_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh), java.lang.Long.valueOf(index)});
	}

	public Transform2D multimesh_instance_get_transform_2d(long multimesh, long index) {
		return (Transform2D) super.call("multimesh_instance_get_transform_2d",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh), java.lang.Long.valueOf(index)});
	}

	public Color multimesh_instance_get_color(long multimesh, long index) {
		return (Color) super.call("multimesh_instance_get_color",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh), java.lang.Long.valueOf(index)});
	}

	public Color multimesh_instance_get_custom_data(long multimesh, long index) {
		return (Color) super.call("multimesh_instance_get_custom_data",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh), java.lang.Long.valueOf(index)});
	}

	public void multimesh_set_visible_instances(long multimesh, long visible) {
		super.call("multimesh_set_visible_instances",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh), java.lang.Long.valueOf(visible)});
	}

	public int multimesh_get_visible_instances(long multimesh) {
		return (int) super.call("multimesh_get_visible_instances",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh)});
	}

	public void multimesh_set_buffer(long multimesh, double[] buffer) {
		super.call("multimesh_set_buffer",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh), (java.lang.Object) buffer});
	}

	public long multimesh_get_command_buffer_rd_rid(long multimesh) {
		return (long) super.call("multimesh_get_command_buffer_rd_rid",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh)});
	}

	public long multimesh_get_buffer_rd_rid(long multimesh) {
		return (long) super.call("multimesh_get_buffer_rd_rid",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh)});
	}

	public double[] multimesh_get_buffer(long multimesh) {
		return (double[]) super.call("multimesh_get_buffer", new java.lang.Object[]{java.lang.Long.valueOf(multimesh)});
	}

	public void multimesh_set_buffer_interpolated(long multimesh, double[] buffer, double[] buffer_previous) {
		super.call("multimesh_set_buffer_interpolated", new java.lang.Object[]{java.lang.Long.valueOf(multimesh),
				(java.lang.Object) buffer, (java.lang.Object) buffer_previous});
	}

	public void multimesh_set_physics_interpolated(long multimesh, boolean interpolated) {
		super.call("multimesh_set_physics_interpolated",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh), java.lang.Boolean.valueOf(interpolated)});
	}

	public void multimesh_set_physics_interpolation_quality(long multimesh, int quality) {
		super.call("multimesh_set_physics_interpolation_quality",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh), java.lang.Integer.valueOf(quality)});
	}

	public void multimesh_instance_reset_physics_interpolation(long multimesh, long index) {
		super.call("multimesh_instance_reset_physics_interpolation",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh), java.lang.Long.valueOf(index)});
	}

	public void multimesh_instances_reset_physics_interpolation(long multimesh) {
		super.call("multimesh_instances_reset_physics_interpolation",
				new java.lang.Object[]{java.lang.Long.valueOf(multimesh)});
	}

	public long skeleton_create() {
		return (long) super.call("skeleton_create");
	}

	public void skeleton_allocate_data(long skeleton, long bones, boolean is_2d_skeleton) {
		super.call("skeleton_allocate_data", new java.lang.Object[]{java.lang.Long.valueOf(skeleton),
				java.lang.Long.valueOf(bones), java.lang.Boolean.valueOf(is_2d_skeleton)});
	}

	public int skeleton_get_bone_count(long skeleton) {
		return (int) super.call("skeleton_get_bone_count", new java.lang.Object[]{java.lang.Long.valueOf(skeleton)});
	}

	public void skeleton_bone_set_transform(long skeleton, long bone, Transform3D transform) {
		super.call("skeleton_bone_set_transform", new java.lang.Object[]{java.lang.Long.valueOf(skeleton),
				java.lang.Long.valueOf(bone), (java.lang.Object) transform});
	}

	public Transform3D skeleton_bone_get_transform(long skeleton, long bone) {
		return (Transform3D) super.call("skeleton_bone_get_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(skeleton), java.lang.Long.valueOf(bone)});
	}

	public void skeleton_bone_set_transform_2d(long skeleton, long bone, Transform2D transform) {
		super.call("skeleton_bone_set_transform_2d", new java.lang.Object[]{java.lang.Long.valueOf(skeleton),
				java.lang.Long.valueOf(bone), (java.lang.Object) transform});
	}

	public Transform2D skeleton_bone_get_transform_2d(long skeleton, long bone) {
		return (Transform2D) super.call("skeleton_bone_get_transform_2d",
				new java.lang.Object[]{java.lang.Long.valueOf(skeleton), java.lang.Long.valueOf(bone)});
	}

	public void skeleton_set_base_transform_2d(long skeleton, Transform2D base_transform) {
		super.call("skeleton_set_base_transform_2d",
				new java.lang.Object[]{java.lang.Long.valueOf(skeleton), (java.lang.Object) base_transform});
	}

	public long directional_light_create() {
		return (long) super.call("directional_light_create");
	}

	public long omni_light_create() {
		return (long) super.call("omni_light_create");
	}

	public long spot_light_create() {
		return (long) super.call("spot_light_create");
	}

	public void light_set_color(long light, Color color) {
		super.call("light_set_color", new java.lang.Object[]{java.lang.Long.valueOf(light), (java.lang.Object) color});
	}

	public void light_set_param(long light, int param, double value) {
		super.call("light_set_param", new java.lang.Object[]{java.lang.Long.valueOf(light),
				java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public void light_set_shadow(long light, boolean enabled) {
		super.call("light_set_shadow",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Boolean.valueOf(enabled)});
	}

	public void light_set_projector(long light, long texture) {
		super.call("light_set_projector",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Long.valueOf(texture)});
	}

	public void light_set_negative(long light, boolean enable) {
		super.call("light_set_negative",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Boolean.valueOf(enable)});
	}

	public void light_set_cull_mask(long light, long mask) {
		super.call("light_set_cull_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Long.valueOf(mask)});
	}

	public void light_set_distance_fade(long decal, boolean enabled, double begin, double shadow, double length) {
		super.call("light_set_distance_fade",
				new java.lang.Object[]{java.lang.Long.valueOf(decal), java.lang.Boolean.valueOf(enabled),
						java.lang.Double.valueOf(begin), java.lang.Double.valueOf(shadow),
						java.lang.Double.valueOf(length)});
	}

	public void light_set_reverse_cull_face_mode(long light, boolean enabled) {
		super.call("light_set_reverse_cull_face_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Boolean.valueOf(enabled)});
	}

	public void light_set_shadow_caster_mask(long light, long mask) {
		super.call("light_set_shadow_caster_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Long.valueOf(mask)});
	}

	public void light_set_bake_mode(long light, int bake_mode) {
		super.call("light_set_bake_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Integer.valueOf(bake_mode)});
	}

	public void light_set_max_sdfgi_cascade(long light, long cascade) {
		super.call("light_set_max_sdfgi_cascade",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Long.valueOf(cascade)});
	}

	public void light_omni_set_shadow_mode(long light, int mode) {
		super.call("light_omni_set_shadow_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Integer.valueOf(mode)});
	}

	public void light_directional_set_shadow_mode(long light, int mode) {
		super.call("light_directional_set_shadow_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Integer.valueOf(mode)});
	}

	public void light_directional_set_blend_splits(long light, boolean enable) {
		super.call("light_directional_set_blend_splits",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Boolean.valueOf(enable)});
	}

	public void light_directional_set_sky_mode(long light, int mode) {
		super.call("light_directional_set_sky_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Integer.valueOf(mode)});
	}

	public void light_projectors_set_filter(int filter) {
		super.call("light_projectors_set_filter", new java.lang.Object[]{java.lang.Integer.valueOf(filter)});
	}

	public void lightmaps_set_bicubic_filter(boolean enable) {
		super.call("lightmaps_set_bicubic_filter", new java.lang.Object[]{java.lang.Boolean.valueOf(enable)});
	}

	public void positional_soft_shadow_filter_set_quality(int quality) {
		super.call("positional_soft_shadow_filter_set_quality",
				new java.lang.Object[]{java.lang.Integer.valueOf(quality)});
	}

	public void directional_soft_shadow_filter_set_quality(int quality) {
		super.call("directional_soft_shadow_filter_set_quality",
				new java.lang.Object[]{java.lang.Integer.valueOf(quality)});
	}

	public void directional_shadow_atlas_set_size(long size, boolean is_16bits) {
		super.call("directional_shadow_atlas_set_size",
				new java.lang.Object[]{java.lang.Long.valueOf(size), java.lang.Boolean.valueOf(is_16bits)});
	}

	public long reflection_probe_create() {
		return (long) super.call("reflection_probe_create");
	}

	public void reflection_probe_set_update_mode(long probe, int mode) {
		super.call("reflection_probe_set_update_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Integer.valueOf(mode)});
	}

	public void reflection_probe_set_intensity(long probe, double intensity) {
		super.call("reflection_probe_set_intensity",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Double.valueOf(intensity)});
	}

	public void reflection_probe_set_blend_distance(long probe, double blend_distance) {
		super.call("reflection_probe_set_blend_distance",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Double.valueOf(blend_distance)});
	}

	public void reflection_probe_set_ambient_mode(long probe, int mode) {
		super.call("reflection_probe_set_ambient_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Integer.valueOf(mode)});
	}

	public void reflection_probe_set_ambient_color(long probe, Color color) {
		super.call("reflection_probe_set_ambient_color",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), (java.lang.Object) color});
	}

	public void reflection_probe_set_ambient_energy(long probe, double energy) {
		super.call("reflection_probe_set_ambient_energy",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Double.valueOf(energy)});
	}

	public void reflection_probe_set_max_distance(long probe, double distance) {
		super.call("reflection_probe_set_max_distance",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Double.valueOf(distance)});
	}

	public void reflection_probe_set_size(long probe, Vector3 size) {
		super.call("reflection_probe_set_size",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), (java.lang.Object) size});
	}

	public void reflection_probe_set_origin_offset(long probe, Vector3 offset) {
		super.call("reflection_probe_set_origin_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), (java.lang.Object) offset});
	}

	public void reflection_probe_set_as_interior(long probe, boolean enable) {
		super.call("reflection_probe_set_as_interior",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Boolean.valueOf(enable)});
	}

	public void reflection_probe_set_enable_box_projection(long probe, boolean enable) {
		super.call("reflection_probe_set_enable_box_projection",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Boolean.valueOf(enable)});
	}

	public void reflection_probe_set_enable_shadows(long probe, boolean enable) {
		super.call("reflection_probe_set_enable_shadows",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Boolean.valueOf(enable)});
	}

	public void reflection_probe_set_cull_mask(long probe, long layers) {
		super.call("reflection_probe_set_cull_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Long.valueOf(layers)});
	}

	public void reflection_probe_set_reflection_mask(long probe, long layers) {
		super.call("reflection_probe_set_reflection_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Long.valueOf(layers)});
	}

	public void reflection_probe_set_resolution(long probe, long resolution) {
		super.call("reflection_probe_set_resolution",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Long.valueOf(resolution)});
	}

	public void reflection_probe_set_mesh_lod_threshold(long probe, double pixels) {
		super.call("reflection_probe_set_mesh_lod_threshold",
				new java.lang.Object[]{java.lang.Long.valueOf(probe), java.lang.Double.valueOf(pixels)});
	}

	public long decal_create() {
		return (long) super.call("decal_create");
	}

	public void decal_set_size(long decal, Vector3 size) {
		super.call("decal_set_size", new java.lang.Object[]{java.lang.Long.valueOf(decal), (java.lang.Object) size});
	}

	public void decal_set_texture(long decal, int type, long texture) {
		super.call("decal_set_texture", new java.lang.Object[]{java.lang.Long.valueOf(decal),
				java.lang.Integer.valueOf(type), java.lang.Long.valueOf(texture)});
	}

	public void decal_set_emission_energy(long decal, double energy) {
		super.call("decal_set_emission_energy",
				new java.lang.Object[]{java.lang.Long.valueOf(decal), java.lang.Double.valueOf(energy)});
	}

	public void decal_set_albedo_mix(long decal, double albedo_mix) {
		super.call("decal_set_albedo_mix",
				new java.lang.Object[]{java.lang.Long.valueOf(decal), java.lang.Double.valueOf(albedo_mix)});
	}

	public void decal_set_modulate(long decal, Color color) {
		super.call("decal_set_modulate",
				new java.lang.Object[]{java.lang.Long.valueOf(decal), (java.lang.Object) color});
	}

	public void decal_set_cull_mask(long decal, long mask) {
		super.call("decal_set_cull_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(decal), java.lang.Long.valueOf(mask)});
	}

	public void decal_set_distance_fade(long decal, boolean enabled, double begin, double length) {
		super.call("decal_set_distance_fade", new java.lang.Object[]{java.lang.Long.valueOf(decal),
				java.lang.Boolean.valueOf(enabled), java.lang.Double.valueOf(begin), java.lang.Double.valueOf(length)});
	}

	public void decal_set_fade(long decal, double above, double below) {
		super.call("decal_set_fade", new java.lang.Object[]{java.lang.Long.valueOf(decal),
				java.lang.Double.valueOf(above), java.lang.Double.valueOf(below)});
	}

	public void decal_set_normal_fade(long decal, double fade) {
		super.call("decal_set_normal_fade",
				new java.lang.Object[]{java.lang.Long.valueOf(decal), java.lang.Double.valueOf(fade)});
	}

	public void decals_set_filter(int filter) {
		super.call("decals_set_filter", new java.lang.Object[]{java.lang.Integer.valueOf(filter)});
	}

	public void gi_set_use_half_resolution(boolean half_resolution) {
		super.call("gi_set_use_half_resolution", new java.lang.Object[]{java.lang.Boolean.valueOf(half_resolution)});
	}

	public long voxel_gi_create() {
		return (long) super.call("voxel_gi_create");
	}

	public void voxel_gi_allocate_data(long voxel_gi, Transform3D to_cell_xform, AABB aabb, Vector3i octree_size,
			byte[] octree_cells, byte[] data_cells, byte[] distance_field, int[] level_counts) {
		super.call("voxel_gi_allocate_data",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi), (java.lang.Object) to_cell_xform,
						(java.lang.Object) aabb, (java.lang.Object) octree_size, (java.lang.Object) octree_cells,
						(java.lang.Object) data_cells, (java.lang.Object) distance_field,
						(java.lang.Object) level_counts});
	}

	public Vector3i voxel_gi_get_octree_size(long voxel_gi) {
		return (Vector3i) super.call("voxel_gi_get_octree_size",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi)});
	}

	public byte[] voxel_gi_get_octree_cells(long voxel_gi) {
		return (byte[]) super.call("voxel_gi_get_octree_cells",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi)});
	}

	public byte[] voxel_gi_get_data_cells(long voxel_gi) {
		return (byte[]) super.call("voxel_gi_get_data_cells", new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi)});
	}

	public byte[] voxel_gi_get_distance_field(long voxel_gi) {
		return (byte[]) super.call("voxel_gi_get_distance_field",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi)});
	}

	public int[] voxel_gi_get_level_counts(long voxel_gi) {
		return (int[]) super.call("voxel_gi_get_level_counts",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi)});
	}

	public Transform3D voxel_gi_get_to_cell_xform(long voxel_gi) {
		return (Transform3D) super.call("voxel_gi_get_to_cell_xform",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi)});
	}

	public void voxel_gi_set_dynamic_range(long voxel_gi, double range) {
		super.call("voxel_gi_set_dynamic_range",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi), java.lang.Double.valueOf(range)});
	}

	public void voxel_gi_set_propagation(long voxel_gi, double amount) {
		super.call("voxel_gi_set_propagation",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi), java.lang.Double.valueOf(amount)});
	}

	public void voxel_gi_set_energy(long voxel_gi, double energy) {
		super.call("voxel_gi_set_energy",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi), java.lang.Double.valueOf(energy)});
	}

	public void voxel_gi_set_baked_exposure_normalization(long voxel_gi, double baked_exposure) {
		super.call("voxel_gi_set_baked_exposure_normalization",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi), java.lang.Double.valueOf(baked_exposure)});
	}

	public void voxel_gi_set_bias(long voxel_gi, double bias) {
		super.call("voxel_gi_set_bias",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi), java.lang.Double.valueOf(bias)});
	}

	public void voxel_gi_set_normal_bias(long voxel_gi, double bias) {
		super.call("voxel_gi_set_normal_bias",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi), java.lang.Double.valueOf(bias)});
	}

	public void voxel_gi_set_interior(long voxel_gi, boolean enable) {
		super.call("voxel_gi_set_interior",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi), java.lang.Boolean.valueOf(enable)});
	}

	public void voxel_gi_set_use_two_bounces(long voxel_gi, boolean enable) {
		super.call("voxel_gi_set_use_two_bounces",
				new java.lang.Object[]{java.lang.Long.valueOf(voxel_gi), java.lang.Boolean.valueOf(enable)});
	}

	public void voxel_gi_set_quality(int quality) {
		super.call("voxel_gi_set_quality", new java.lang.Object[]{java.lang.Integer.valueOf(quality)});
	}

	public long lightmap_create() {
		return (long) super.call("lightmap_create");
	}

	public void lightmap_set_textures(long lightmap, long light, boolean uses_sh) {
		super.call("lightmap_set_textures", new java.lang.Object[]{java.lang.Long.valueOf(lightmap),
				java.lang.Long.valueOf(light), java.lang.Boolean.valueOf(uses_sh)});
	}

	public void lightmap_set_probe_bounds(long lightmap, AABB bounds) {
		super.call("lightmap_set_probe_bounds",
				new java.lang.Object[]{java.lang.Long.valueOf(lightmap), (java.lang.Object) bounds});
	}

	public void lightmap_set_probe_interior(long lightmap, boolean interior) {
		super.call("lightmap_set_probe_interior",
				new java.lang.Object[]{java.lang.Long.valueOf(lightmap), java.lang.Boolean.valueOf(interior)});
	}

	public void lightmap_set_probe_capture_data(long lightmap, double[][] points, double[][] point_sh, int[] tetrahedra,
			int[] bsp_tree) {
		super.call("lightmap_set_probe_capture_data",
				new java.lang.Object[]{java.lang.Long.valueOf(lightmap), (java.lang.Object) points,
						(java.lang.Object) point_sh, (java.lang.Object) tetrahedra, (java.lang.Object) bsp_tree});
	}

	public double[][] lightmap_get_probe_capture_points(long lightmap) {
		return (double[][]) super.call("lightmap_get_probe_capture_points",
				new java.lang.Object[]{java.lang.Long.valueOf(lightmap)});
	}

	public double[][] lightmap_get_probe_capture_sh(long lightmap) {
		return (double[][]) super.call("lightmap_get_probe_capture_sh",
				new java.lang.Object[]{java.lang.Long.valueOf(lightmap)});
	}

	public int[] lightmap_get_probe_capture_tetrahedra(long lightmap) {
		return (int[]) super.call("lightmap_get_probe_capture_tetrahedra",
				new java.lang.Object[]{java.lang.Long.valueOf(lightmap)});
	}

	public int[] lightmap_get_probe_capture_bsp_tree(long lightmap) {
		return (int[]) super.call("lightmap_get_probe_capture_bsp_tree",
				new java.lang.Object[]{java.lang.Long.valueOf(lightmap)});
	}

	public void lightmap_set_baked_exposure_normalization(long lightmap, double baked_exposure) {
		super.call("lightmap_set_baked_exposure_normalization",
				new java.lang.Object[]{java.lang.Long.valueOf(lightmap), java.lang.Double.valueOf(baked_exposure)});
	}

	public void lightmap_set_probe_capture_update_speed(double speed) {
		super.call("lightmap_set_probe_capture_update_speed", new java.lang.Object[]{java.lang.Double.valueOf(speed)});
	}

	public long particles_create() {
		return (long) super.call("particles_create");
	}

	public void particles_set_mode(long particles, int mode) {
		super.call("particles_set_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Integer.valueOf(mode)});
	}

	public void particles_set_emitting(long particles, boolean emitting) {
		super.call("particles_set_emitting",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Boolean.valueOf(emitting)});
	}

	public boolean particles_get_emitting(long particles) {
		return (boolean) super.call("particles_get_emitting",
				new java.lang.Object[]{java.lang.Long.valueOf(particles)});
	}

	public void particles_set_amount(long particles, long amount) {
		super.call("particles_set_amount",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Long.valueOf(amount)});
	}

	public void particles_set_amount_ratio(long particles, double ratio) {
		super.call("particles_set_amount_ratio",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Double.valueOf(ratio)});
	}

	public void particles_set_lifetime(long particles, double lifetime) {
		super.call("particles_set_lifetime",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Double.valueOf(lifetime)});
	}

	public void particles_set_one_shot(long particles, boolean one_shot) {
		super.call("particles_set_one_shot",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Boolean.valueOf(one_shot)});
	}

	public void particles_set_pre_process_time(long particles, double time) {
		super.call("particles_set_pre_process_time",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Double.valueOf(time)});
	}

	public void particles_request_process_time(long particles, double time) {
		super.call("particles_request_process_time",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Double.valueOf(time)});
	}

	public void particles_set_explosiveness_ratio(long particles, double ratio) {
		super.call("particles_set_explosiveness_ratio",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Double.valueOf(ratio)});
	}

	public void particles_set_randomness_ratio(long particles, double ratio) {
		super.call("particles_set_randomness_ratio",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Double.valueOf(ratio)});
	}

	public void particles_set_interp_to_end(long particles, double factor) {
		super.call("particles_set_interp_to_end",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Double.valueOf(factor)});
	}

	public void particles_set_emitter_velocity(long particles, Vector3 velocity) {
		super.call("particles_set_emitter_velocity",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), (java.lang.Object) velocity});
	}

	public void particles_set_custom_aabb(long particles, AABB aabb) {
		super.call("particles_set_custom_aabb",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), (java.lang.Object) aabb});
	}

	public void particles_set_speed_scale(long particles, double scale) {
		super.call("particles_set_speed_scale",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Double.valueOf(scale)});
	}

	public void particles_set_use_local_coordinates(long particles, boolean enable) {
		super.call("particles_set_use_local_coordinates",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Boolean.valueOf(enable)});
	}

	public void particles_set_process_material(long particles, long material) {
		super.call("particles_set_process_material",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Long.valueOf(material)});
	}

	public void particles_set_fixed_fps(long particles, long fps) {
		super.call("particles_set_fixed_fps",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Long.valueOf(fps)});
	}

	public void particles_set_interpolate(long particles, boolean enable) {
		super.call("particles_set_interpolate",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Boolean.valueOf(enable)});
	}

	public void particles_set_fractional_delta(long particles, boolean enable) {
		super.call("particles_set_fractional_delta",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Boolean.valueOf(enable)});
	}

	public void particles_set_collision_base_size(long particles, double size) {
		super.call("particles_set_collision_base_size",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Double.valueOf(size)});
	}

	public void particles_set_transform_align(long particles, int align) {
		super.call("particles_set_transform_align",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Integer.valueOf(align)});
	}

	public void particles_set_trails(long particles, boolean enable, double length_sec) {
		super.call("particles_set_trails", new java.lang.Object[]{java.lang.Long.valueOf(particles),
				java.lang.Boolean.valueOf(enable), java.lang.Double.valueOf(length_sec)});
	}

	public void particles_set_trail_bind_poses(long particles, Transform3D[] bind_poses) {
		super.call("particles_set_trail_bind_poses",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), (java.lang.Object) bind_poses});
	}

	public boolean particles_is_inactive(long particles) {
		return (boolean) super.call("particles_is_inactive", new java.lang.Object[]{java.lang.Long.valueOf(particles)});
	}

	public void particles_request_process(long particles) {
		super.call("particles_request_process", new java.lang.Object[]{java.lang.Long.valueOf(particles)});
	}

	public void particles_restart(long particles) {
		super.call("particles_restart", new java.lang.Object[]{java.lang.Long.valueOf(particles)});
	}

	public void particles_set_subemitter(long particles, long subemitter_particles) {
		super.call("particles_set_subemitter", new java.lang.Object[]{java.lang.Long.valueOf(particles),
				java.lang.Long.valueOf(subemitter_particles)});
	}

	public void particles_emit(long particles, Transform3D transform, Vector3 velocity, Color color, Color custom,
			long emit_flags) {
		super.call("particles_emit",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), (java.lang.Object) transform,
						(java.lang.Object) velocity, (java.lang.Object) color, (java.lang.Object) custom,
						java.lang.Long.valueOf(emit_flags)});
	}

	public void particles_set_draw_order(long particles, int order) {
		super.call("particles_set_draw_order",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Integer.valueOf(order)});
	}

	public void particles_set_draw_passes(long particles, long count) {
		super.call("particles_set_draw_passes",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), java.lang.Long.valueOf(count)});
	}

	public void particles_set_draw_pass_mesh(long particles, long pass, long mesh) {
		super.call("particles_set_draw_pass_mesh", new java.lang.Object[]{java.lang.Long.valueOf(particles),
				java.lang.Long.valueOf(pass), java.lang.Long.valueOf(mesh)});
	}

	public AABB particles_get_current_aabb(long particles) {
		return (AABB) super.call("particles_get_current_aabb",
				new java.lang.Object[]{java.lang.Long.valueOf(particles)});
	}

	public void particles_set_emission_transform(long particles, Transform3D transform) {
		super.call("particles_set_emission_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(particles), (java.lang.Object) transform});
	}

	public long particles_collision_create() {
		return (long) super.call("particles_collision_create");
	}

	public void particles_collision_set_collision_type(long particles_collision, int type) {
		super.call("particles_collision_set_collision_type",
				new java.lang.Object[]{java.lang.Long.valueOf(particles_collision), java.lang.Integer.valueOf(type)});
	}

	public void particles_collision_set_cull_mask(long particles_collision, long mask) {
		super.call("particles_collision_set_cull_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(particles_collision), java.lang.Long.valueOf(mask)});
	}

	public void particles_collision_set_sphere_radius(long particles_collision, double radius) {
		super.call("particles_collision_set_sphere_radius",
				new java.lang.Object[]{java.lang.Long.valueOf(particles_collision), java.lang.Double.valueOf(radius)});
	}

	public void particles_collision_set_box_extents(long particles_collision, Vector3 extents) {
		super.call("particles_collision_set_box_extents",
				new java.lang.Object[]{java.lang.Long.valueOf(particles_collision), (java.lang.Object) extents});
	}

	public void particles_collision_set_attractor_strength(long particles_collision, double strength) {
		super.call("particles_collision_set_attractor_strength", new java.lang.Object[]{
				java.lang.Long.valueOf(particles_collision), java.lang.Double.valueOf(strength)});
	}

	public void particles_collision_set_attractor_directionality(long particles_collision, double amount) {
		super.call("particles_collision_set_attractor_directionality",
				new java.lang.Object[]{java.lang.Long.valueOf(particles_collision), java.lang.Double.valueOf(amount)});
	}

	public void particles_collision_set_attractor_attenuation(long particles_collision, double curve) {
		super.call("particles_collision_set_attractor_attenuation",
				new java.lang.Object[]{java.lang.Long.valueOf(particles_collision), java.lang.Double.valueOf(curve)});
	}

	public void particles_collision_set_field_texture(long particles_collision, long texture) {
		super.call("particles_collision_set_field_texture",
				new java.lang.Object[]{java.lang.Long.valueOf(particles_collision), java.lang.Long.valueOf(texture)});
	}

	public void particles_collision_height_field_update(long particles_collision) {
		super.call("particles_collision_height_field_update",
				new java.lang.Object[]{java.lang.Long.valueOf(particles_collision)});
	}

	public void particles_collision_set_height_field_resolution(long particles_collision, int resolution) {
		super.call("particles_collision_set_height_field_resolution", new java.lang.Object[]{
				java.lang.Long.valueOf(particles_collision), java.lang.Integer.valueOf(resolution)});
	}

	public void particles_collision_set_height_field_mask(long particles_collision, long mask) {
		super.call("particles_collision_set_height_field_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(particles_collision), java.lang.Long.valueOf(mask)});
	}

	public long fog_volume_create() {
		return (long) super.call("fog_volume_create");
	}

	public void fog_volume_set_shape(long fog_volume, int shape) {
		super.call("fog_volume_set_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(fog_volume), java.lang.Integer.valueOf(shape)});
	}

	public void fog_volume_set_size(long fog_volume, Vector3 size) {
		super.call("fog_volume_set_size",
				new java.lang.Object[]{java.lang.Long.valueOf(fog_volume), (java.lang.Object) size});
	}

	public void fog_volume_set_material(long fog_volume, long material) {
		super.call("fog_volume_set_material",
				new java.lang.Object[]{java.lang.Long.valueOf(fog_volume), java.lang.Long.valueOf(material)});
	}

	public long visibility_notifier_create() {
		return (long) super.call("visibility_notifier_create");
	}

	public void visibility_notifier_set_aabb(long notifier, AABB aabb) {
		super.call("visibility_notifier_set_aabb",
				new java.lang.Object[]{java.lang.Long.valueOf(notifier), (java.lang.Object) aabb});
	}

	public void visibility_notifier_set_callbacks(long notifier, Callable enter_callable, Callable exit_callable) {
		super.call("visibility_notifier_set_callbacks", new java.lang.Object[]{java.lang.Long.valueOf(notifier),
				(java.lang.Object) enter_callable, (java.lang.Object) exit_callable});
	}

	public long occluder_create() {
		return (long) super.call("occluder_create");
	}

	public void occluder_set_mesh(long occluder, double[][] vertices, int[] indices) {
		super.call("occluder_set_mesh", new java.lang.Object[]{java.lang.Long.valueOf(occluder),
				(java.lang.Object) vertices, (java.lang.Object) indices});
	}

	public long camera_create() {
		return (long) super.call("camera_create");
	}

	public void camera_set_perspective(long camera, double fovy_degrees, double z_near, double z_far) {
		super.call("camera_set_perspective",
				new java.lang.Object[]{java.lang.Long.valueOf(camera), java.lang.Double.valueOf(fovy_degrees),
						java.lang.Double.valueOf(z_near), java.lang.Double.valueOf(z_far)});
	}

	public void camera_set_orthogonal(long camera, double size, double z_near, double z_far) {
		super.call("camera_set_orthogonal", new java.lang.Object[]{java.lang.Long.valueOf(camera),
				java.lang.Double.valueOf(size), java.lang.Double.valueOf(z_near), java.lang.Double.valueOf(z_far)});
	}

	public void camera_set_frustum(long camera, double size, Vector2 offset, double z_near, double z_far) {
		super.call("camera_set_frustum",
				new java.lang.Object[]{java.lang.Long.valueOf(camera), java.lang.Double.valueOf(size),
						(java.lang.Object) offset, java.lang.Double.valueOf(z_near), java.lang.Double.valueOf(z_far)});
	}

	public void camera_set_transform(long camera, Transform3D transform) {
		super.call("camera_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(camera), (java.lang.Object) transform});
	}

	public void camera_set_cull_mask(long camera, long layers) {
		super.call("camera_set_cull_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(camera), java.lang.Long.valueOf(layers)});
	}

	public void camera_set_environment(long camera, long env) {
		super.call("camera_set_environment",
				new java.lang.Object[]{java.lang.Long.valueOf(camera), java.lang.Long.valueOf(env)});
	}

	public void camera_set_camera_attributes(long camera, long effects) {
		super.call("camera_set_camera_attributes",
				new java.lang.Object[]{java.lang.Long.valueOf(camera), java.lang.Long.valueOf(effects)});
	}

	public void camera_set_compositor(long camera, long compositor) {
		super.call("camera_set_compositor",
				new java.lang.Object[]{java.lang.Long.valueOf(camera), java.lang.Long.valueOf(compositor)});
	}

	public void camera_set_use_vertical_aspect(long camera, boolean enable) {
		super.call("camera_set_use_vertical_aspect",
				new java.lang.Object[]{java.lang.Long.valueOf(camera), java.lang.Boolean.valueOf(enable)});
	}

	public long viewport_create() {
		return (long) super.call("viewport_create");
	}

	public void viewport_set_use_xr(long viewport, boolean use_xr) {
		super.call("viewport_set_use_xr",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(use_xr)});
	}

	public void viewport_set_size(long viewport, long width, long height) {
		super.call("viewport_set_size", new java.lang.Object[]{java.lang.Long.valueOf(viewport),
				java.lang.Long.valueOf(width), java.lang.Long.valueOf(height)});
	}

	public void viewport_set_active(long viewport, boolean active) {
		super.call("viewport_set_active",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(active)});
	}

	public void viewport_set_parent_viewport(long viewport, long parent_viewport) {
		super.call("viewport_set_parent_viewport",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Long.valueOf(parent_viewport)});
	}

	public void viewport_attach_to_screen(long viewport, Rect2 rect, long screen) {
		super.call("viewport_attach_to_screen", new java.lang.Object[]{java.lang.Long.valueOf(viewport),
				(java.lang.Object) rect, java.lang.Long.valueOf(screen)});
	}

	public void viewport_set_render_direct_to_screen(long viewport, boolean enabled) {
		super.call("viewport_set_render_direct_to_screen",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(enabled)});
	}

	public void viewport_set_canvas_cull_mask(long viewport, long canvas_cull_mask) {
		super.call("viewport_set_canvas_cull_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Long.valueOf(canvas_cull_mask)});
	}

	public void viewport_set_scaling_3d_mode(long viewport, int scaling_3d_mode) {
		super.call("viewport_set_scaling_3d_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Integer.valueOf(scaling_3d_mode)});
	}

	public void viewport_set_scaling_3d_scale(long viewport, double scale) {
		super.call("viewport_set_scaling_3d_scale",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Double.valueOf(scale)});
	}

	public void viewport_set_fsr_sharpness(long viewport, double sharpness) {
		super.call("viewport_set_fsr_sharpness",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Double.valueOf(sharpness)});
	}

	public void viewport_set_texture_mipmap_bias(long viewport, double mipmap_bias) {
		super.call("viewport_set_texture_mipmap_bias",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Double.valueOf(mipmap_bias)});
	}

	public void viewport_set_anisotropic_filtering_level(long viewport, int anisotropic_filtering_level) {
		super.call("viewport_set_anisotropic_filtering_level", new java.lang.Object[]{java.lang.Long.valueOf(viewport),
				java.lang.Integer.valueOf(anisotropic_filtering_level)});
	}

	public void viewport_set_update_mode(long viewport, int update_mode) {
		super.call("viewport_set_update_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Integer.valueOf(update_mode)});
	}

	public int viewport_get_update_mode(long viewport) {
		return (int) super.call("viewport_get_update_mode", new java.lang.Object[]{java.lang.Long.valueOf(viewport)});
	}

	public void viewport_set_clear_mode(long viewport, int clear_mode) {
		super.call("viewport_set_clear_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Integer.valueOf(clear_mode)});
	}

	public long viewport_get_render_target(long viewport) {
		return (long) super.call("viewport_get_render_target",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport)});
	}

	public long viewport_get_texture(long viewport) {
		return (long) super.call("viewport_get_texture", new java.lang.Object[]{java.lang.Long.valueOf(viewport)});
	}

	public void viewport_set_disable_3d(long viewport, boolean disable) {
		super.call("viewport_set_disable_3d",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(disable)});
	}

	public void viewport_set_disable_2d(long viewport, boolean disable) {
		super.call("viewport_set_disable_2d",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(disable)});
	}

	public void viewport_set_environment_mode(long viewport, int mode) {
		super.call("viewport_set_environment_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Integer.valueOf(mode)});
	}

	public void viewport_attach_camera(long viewport, long camera) {
		super.call("viewport_attach_camera",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Long.valueOf(camera)});
	}

	public void viewport_set_scenario(long viewport, long scenario) {
		super.call("viewport_set_scenario",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Long.valueOf(scenario)});
	}

	public void viewport_attach_canvas(long viewport, long canvas) {
		super.call("viewport_attach_canvas",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Long.valueOf(canvas)});
	}

	public void viewport_remove_canvas(long viewport, long canvas) {
		super.call("viewport_remove_canvas",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Long.valueOf(canvas)});
	}

	public void viewport_set_snap_2d_transforms_to_pixel(long viewport, boolean enabled) {
		super.call("viewport_set_snap_2d_transforms_to_pixel",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(enabled)});
	}

	public void viewport_set_snap_2d_vertices_to_pixel(long viewport, boolean enabled) {
		super.call("viewport_set_snap_2d_vertices_to_pixel",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(enabled)});
	}

	public void viewport_set_default_canvas_item_texture_filter(long viewport, int filter) {
		super.call("viewport_set_default_canvas_item_texture_filter",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Integer.valueOf(filter)});
	}

	public void viewport_set_default_canvas_item_texture_repeat(long viewport, int repeat) {
		super.call("viewport_set_default_canvas_item_texture_repeat",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Integer.valueOf(repeat)});
	}

	public void viewport_set_canvas_transform(long viewport, long canvas, Transform2D offset) {
		super.call("viewport_set_canvas_transform", new java.lang.Object[]{java.lang.Long.valueOf(viewport),
				java.lang.Long.valueOf(canvas), (java.lang.Object) offset});
	}

	public void viewport_set_canvas_stacking(long viewport, long canvas, long layer, long sublayer) {
		super.call("viewport_set_canvas_stacking", new java.lang.Object[]{java.lang.Long.valueOf(viewport),
				java.lang.Long.valueOf(canvas), java.lang.Long.valueOf(layer), java.lang.Long.valueOf(sublayer)});
	}

	public void viewport_set_transparent_background(long viewport, boolean enabled) {
		super.call("viewport_set_transparent_background",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(enabled)});
	}

	public void viewport_set_global_canvas_transform(long viewport, Transform2D transform) {
		super.call("viewport_set_global_canvas_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), (java.lang.Object) transform});
	}

	public void viewport_set_sdf_oversize_and_scale(long viewport, int oversize, int scale) {
		super.call("viewport_set_sdf_oversize_and_scale", new java.lang.Object[]{java.lang.Long.valueOf(viewport),
				java.lang.Integer.valueOf(oversize), java.lang.Integer.valueOf(scale)});
	}

	public void viewport_set_positional_shadow_atlas_size(long viewport, long size, boolean use_16_bits) {
		super.call("viewport_set_positional_shadow_atlas_size", new java.lang.Object[]{java.lang.Long.valueOf(viewport),
				java.lang.Long.valueOf(size), java.lang.Boolean.valueOf(use_16_bits)});
	}

	public void viewport_set_positional_shadow_atlas_quadrant_subdivision(long viewport, long quadrant,
			long subdivision) {
		super.call("viewport_set_positional_shadow_atlas_quadrant_subdivision",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Long.valueOf(quadrant),
						java.lang.Long.valueOf(subdivision)});
	}

	public void viewport_set_msaa_3d(long viewport, int msaa) {
		super.call("viewport_set_msaa_3d",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Integer.valueOf(msaa)});
	}

	public void viewport_set_msaa_2d(long viewport, int msaa) {
		super.call("viewport_set_msaa_2d",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Integer.valueOf(msaa)});
	}

	public void viewport_set_use_hdr_2d(long viewport, boolean enabled) {
		super.call("viewport_set_use_hdr_2d",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(enabled)});
	}

	public void viewport_set_screen_space_aa(long viewport, int mode) {
		super.call("viewport_set_screen_space_aa",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Integer.valueOf(mode)});
	}

	public void viewport_set_use_taa(long viewport, boolean enable) {
		super.call("viewport_set_use_taa",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(enable)});
	}

	public void viewport_set_use_debanding(long viewport, boolean enable) {
		super.call("viewport_set_use_debanding",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(enable)});
	}

	public void viewport_set_use_occlusion_culling(long viewport, boolean enable) {
		super.call("viewport_set_use_occlusion_culling",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(enable)});
	}

	public void viewport_set_occlusion_rays_per_thread(long rays_per_thread) {
		super.call("viewport_set_occlusion_rays_per_thread",
				new java.lang.Object[]{java.lang.Long.valueOf(rays_per_thread)});
	}

	public void viewport_set_occlusion_culling_build_quality(int quality) {
		super.call("viewport_set_occlusion_culling_build_quality",
				new java.lang.Object[]{java.lang.Integer.valueOf(quality)});
	}

	public int viewport_get_render_info(long viewport, int type, int info) {
		return (int) super.call("viewport_get_render_info", new java.lang.Object[]{java.lang.Long.valueOf(viewport),
				java.lang.Integer.valueOf(type), java.lang.Integer.valueOf(info)});
	}

	public void viewport_set_debug_draw(long viewport, int draw) {
		super.call("viewport_set_debug_draw",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Integer.valueOf(draw)});
	}

	public void viewport_set_measure_render_time(long viewport, boolean enable) {
		super.call("viewport_set_measure_render_time",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Boolean.valueOf(enable)});
	}

	public double viewport_get_measured_render_time_cpu(long viewport) {
		return (double) super.call("viewport_get_measured_render_time_cpu",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport)});
	}

	public double viewport_get_measured_render_time_gpu(long viewport) {
		return (double) super.call("viewport_get_measured_render_time_gpu",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport)});
	}

	public void viewport_set_vrs_mode(long viewport, int mode) {
		super.call("viewport_set_vrs_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Integer.valueOf(mode)});
	}

	public void viewport_set_vrs_update_mode(long viewport, int mode) {
		super.call("viewport_set_vrs_update_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Integer.valueOf(mode)});
	}

	public void viewport_set_vrs_texture(long viewport, long texture) {
		super.call("viewport_set_vrs_texture",
				new java.lang.Object[]{java.lang.Long.valueOf(viewport), java.lang.Long.valueOf(texture)});
	}

	public long sky_create() {
		return (long) super.call("sky_create");
	}

	public void sky_set_radiance_size(long sky, long radiance_size) {
		super.call("sky_set_radiance_size",
				new java.lang.Object[]{java.lang.Long.valueOf(sky), java.lang.Long.valueOf(radiance_size)});
	}

	public void sky_set_mode(long sky, int mode) {
		super.call("sky_set_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(sky), java.lang.Integer.valueOf(mode)});
	}

	public void sky_set_material(long sky, long material) {
		super.call("sky_set_material",
				new java.lang.Object[]{java.lang.Long.valueOf(sky), java.lang.Long.valueOf(material)});
	}

	public Image sky_bake_panorama(long sky, double energy, boolean bake_irradiance, Vector2i size) {
		return (Image) super.call("sky_bake_panorama", new java.lang.Object[]{java.lang.Long.valueOf(sky),
				java.lang.Double.valueOf(energy), java.lang.Boolean.valueOf(bake_irradiance), (java.lang.Object) size});
	}

	public long compositor_effect_create() {
		return (long) super.call("compositor_effect_create");
	}

	public void compositor_effect_set_enabled(long effect, boolean enabled) {
		super.call("compositor_effect_set_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(effect), java.lang.Boolean.valueOf(enabled)});
	}

	public void compositor_effect_set_callback(long effect, int callback_type, Callable callback) {
		super.call("compositor_effect_set_callback", new java.lang.Object[]{java.lang.Long.valueOf(effect),
				java.lang.Integer.valueOf(callback_type), (java.lang.Object) callback});
	}

	public void compositor_effect_set_flag(long effect, int flag, boolean set) {
		super.call("compositor_effect_set_flag", new java.lang.Object[]{java.lang.Long.valueOf(effect),
				java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(set)});
	}

	public long compositor_create() {
		return (long) super.call("compositor_create");
	}

	public void compositor_set_compositor_effects(long compositor, long[] effects) {
		super.call("compositor_set_compositor_effects",
				new java.lang.Object[]{java.lang.Long.valueOf(compositor), (java.lang.Object) effects});
	}

	public long environment_create() {
		return (long) super.call("environment_create");
	}

	public void environment_set_background(long env, int bg) {
		super.call("environment_set_background",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Integer.valueOf(bg)});
	}

	public void environment_set_camera_id(long env, long id) {
		super.call("environment_set_camera_id",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Long.valueOf(id)});
	}

	public void environment_set_sky(long env, long sky) {
		super.call("environment_set_sky",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Long.valueOf(sky)});
	}

	public void environment_set_sky_custom_fov(long env, double scale) {
		super.call("environment_set_sky_custom_fov",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Double.valueOf(scale)});
	}

	public void environment_set_sky_orientation(long env, Basis orientation) {
		super.call("environment_set_sky_orientation",
				new java.lang.Object[]{java.lang.Long.valueOf(env), (java.lang.Object) orientation});
	}

	public void environment_set_bg_color(long env, Color color) {
		super.call("environment_set_bg_color",
				new java.lang.Object[]{java.lang.Long.valueOf(env), (java.lang.Object) color});
	}

	public void environment_set_bg_energy(long env, double multiplier, double exposure_value) {
		super.call("environment_set_bg_energy", new java.lang.Object[]{java.lang.Long.valueOf(env),
				java.lang.Double.valueOf(multiplier), java.lang.Double.valueOf(exposure_value)});
	}

	public void environment_set_canvas_max_layer(long env, long max_layer) {
		super.call("environment_set_canvas_max_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Long.valueOf(max_layer)});
	}

	public void environment_set_ambient_light(long env, Color color, int ambient, double energy,
			double sky_contribution, int reflection_source) {
		super.call("environment_set_ambient_light",
				new java.lang.Object[]{java.lang.Long.valueOf(env), (java.lang.Object) color,
						java.lang.Integer.valueOf(ambient), java.lang.Double.valueOf(energy),
						java.lang.Double.valueOf(sky_contribution), java.lang.Integer.valueOf(reflection_source)});
	}

	public void environment_set_glow(long env, boolean enable, double[] levels, double intensity, double strength,
			double mix, double bloom_threshold, int blend_mode, double hdr_bleed_threshold, double hdr_bleed_scale,
			double hdr_luminance_cap, double glow_map_strength, long glow_map) {
		super.call("environment_set_glow",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Boolean.valueOf(enable),
						(java.lang.Object) levels, java.lang.Double.valueOf(intensity),
						java.lang.Double.valueOf(strength), java.lang.Double.valueOf(mix),
						java.lang.Double.valueOf(bloom_threshold), java.lang.Integer.valueOf(blend_mode),
						java.lang.Double.valueOf(hdr_bleed_threshold), java.lang.Double.valueOf(hdr_bleed_scale),
						java.lang.Double.valueOf(hdr_luminance_cap), java.lang.Double.valueOf(glow_map_strength),
						java.lang.Long.valueOf(glow_map)});
	}

	public void environment_set_tonemap(long env, int tone_mapper, double exposure, double white) {
		super.call("environment_set_tonemap",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Integer.valueOf(tone_mapper),
						java.lang.Double.valueOf(exposure), java.lang.Double.valueOf(white)});
	}

	public void environment_set_tonemap_agx_contrast(long env, double agx_contrast) {
		super.call("environment_set_tonemap_agx_contrast",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Double.valueOf(agx_contrast)});
	}

	public void environment_set_adjustment(long env, boolean enable, double brightness, double contrast,
			double saturation, boolean use_1d_color_correction, long color_correction) {
		super.call("environment_set_adjustment",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Boolean.valueOf(enable),
						java.lang.Double.valueOf(brightness), java.lang.Double.valueOf(contrast),
						java.lang.Double.valueOf(saturation), java.lang.Boolean.valueOf(use_1d_color_correction),
						java.lang.Long.valueOf(color_correction)});
	}

	public void environment_set_ssr(long env, boolean enable, long max_steps, double fade_in, double fade_out,
			double depth_tolerance) {
		super.call("environment_set_ssr",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Boolean.valueOf(enable),
						java.lang.Long.valueOf(max_steps), java.lang.Double.valueOf(fade_in),
						java.lang.Double.valueOf(fade_out), java.lang.Double.valueOf(depth_tolerance)});
	}

	public void environment_set_ssao(long env, boolean enable, double radius, double intensity, double power,
			double detail, double horizon, double sharpness, double light_affect, double ao_channel_affect) {
		super.call("environment_set_ssao",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Boolean.valueOf(enable),
						java.lang.Double.valueOf(radius), java.lang.Double.valueOf(intensity),
						java.lang.Double.valueOf(power), java.lang.Double.valueOf(detail),
						java.lang.Double.valueOf(horizon), java.lang.Double.valueOf(sharpness),
						java.lang.Double.valueOf(light_affect), java.lang.Double.valueOf(ao_channel_affect)});
	}

	public void environment_set_fog(long env, boolean enable, Color light_color, double light_energy,
			double sun_scatter, double density, double height, double height_density, double aerial_perspective,
			double sky_affect, int fog_mode) {
		super.call("environment_set_fog",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Boolean.valueOf(enable),
						(java.lang.Object) light_color, java.lang.Double.valueOf(light_energy),
						java.lang.Double.valueOf(sun_scatter), java.lang.Double.valueOf(density),
						java.lang.Double.valueOf(height), java.lang.Double.valueOf(height_density),
						java.lang.Double.valueOf(aerial_perspective), java.lang.Double.valueOf(sky_affect),
						java.lang.Integer.valueOf(fog_mode)});
	}

	public void environment_set_fog_depth(long env, double curve, double begin, double end) {
		super.call("environment_set_fog_depth", new java.lang.Object[]{java.lang.Long.valueOf(env),
				java.lang.Double.valueOf(curve), java.lang.Double.valueOf(begin), java.lang.Double.valueOf(end)});
	}

	public void environment_set_sdfgi(long env, boolean enable, long cascades, double min_cell_size, int y_scale,
			boolean use_occlusion, double bounce_feedback, boolean read_sky, double energy, double normal_bias,
			double probe_bias) {
		super.call("environment_set_sdfgi",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Boolean.valueOf(enable),
						java.lang.Long.valueOf(cascades), java.lang.Double.valueOf(min_cell_size),
						java.lang.Integer.valueOf(y_scale), java.lang.Boolean.valueOf(use_occlusion),
						java.lang.Double.valueOf(bounce_feedback), java.lang.Boolean.valueOf(read_sky),
						java.lang.Double.valueOf(energy), java.lang.Double.valueOf(normal_bias),
						java.lang.Double.valueOf(probe_bias)});
	}

	public void environment_set_volumetric_fog(long env, boolean enable, double density, Color albedo, Color emission,
			double emission_energy, double anisotropy, double length, double p_detail_spread, double gi_inject,
			boolean temporal_reprojection, double temporal_reprojection_amount, double ambient_inject,
			double sky_affect) {
		super.call("environment_set_volumetric_fog",
				new java.lang.Object[]{java.lang.Long.valueOf(env), java.lang.Boolean.valueOf(enable),
						java.lang.Double.valueOf(density), (java.lang.Object) albedo, (java.lang.Object) emission,
						java.lang.Double.valueOf(emission_energy), java.lang.Double.valueOf(anisotropy),
						java.lang.Double.valueOf(length), java.lang.Double.valueOf(p_detail_spread),
						java.lang.Double.valueOf(gi_inject), java.lang.Boolean.valueOf(temporal_reprojection),
						java.lang.Double.valueOf(temporal_reprojection_amount),
						java.lang.Double.valueOf(ambient_inject), java.lang.Double.valueOf(sky_affect)});
	}

	public void environment_glow_set_use_bicubic_upscale(boolean enable) {
		super.call("environment_glow_set_use_bicubic_upscale",
				new java.lang.Object[]{java.lang.Boolean.valueOf(enable)});
	}

	public void environment_set_ssr_half_size(boolean half_size) {
		super.call("environment_set_ssr_half_size", new java.lang.Object[]{java.lang.Boolean.valueOf(half_size)});
	}

	public void environment_set_ssr_roughness_quality(int quality) {
		super.call("environment_set_ssr_roughness_quality", new java.lang.Object[]{java.lang.Integer.valueOf(quality)});
	}

	public void environment_set_ssao_quality(int quality, boolean half_size, double adaptive_target, long blur_passes,
			double fadeout_from, double fadeout_to) {
		super.call("environment_set_ssao_quality",
				new java.lang.Object[]{java.lang.Integer.valueOf(quality), java.lang.Boolean.valueOf(half_size),
						java.lang.Double.valueOf(adaptive_target), java.lang.Long.valueOf(blur_passes),
						java.lang.Double.valueOf(fadeout_from), java.lang.Double.valueOf(fadeout_to)});
	}

	public void environment_set_ssil_quality(int quality, boolean half_size, double adaptive_target, long blur_passes,
			double fadeout_from, double fadeout_to) {
		super.call("environment_set_ssil_quality",
				new java.lang.Object[]{java.lang.Integer.valueOf(quality), java.lang.Boolean.valueOf(half_size),
						java.lang.Double.valueOf(adaptive_target), java.lang.Long.valueOf(blur_passes),
						java.lang.Double.valueOf(fadeout_from), java.lang.Double.valueOf(fadeout_to)});
	}

	public void environment_set_sdfgi_ray_count(int ray_count) {
		super.call("environment_set_sdfgi_ray_count", new java.lang.Object[]{java.lang.Integer.valueOf(ray_count)});
	}

	public void environment_set_sdfgi_frames_to_converge(int frames) {
		super.call("environment_set_sdfgi_frames_to_converge",
				new java.lang.Object[]{java.lang.Integer.valueOf(frames)});
	}

	public void environment_set_sdfgi_frames_to_update_light(int frames) {
		super.call("environment_set_sdfgi_frames_to_update_light",
				new java.lang.Object[]{java.lang.Integer.valueOf(frames)});
	}

	public void environment_set_volumetric_fog_volume_size(long size, long depth) {
		super.call("environment_set_volumetric_fog_volume_size",
				new java.lang.Object[]{java.lang.Long.valueOf(size), java.lang.Long.valueOf(depth)});
	}

	public void environment_set_volumetric_fog_filter_active(boolean active) {
		super.call("environment_set_volumetric_fog_filter_active",
				new java.lang.Object[]{java.lang.Boolean.valueOf(active)});
	}

	public Image environment_bake_panorama(long environment, boolean bake_irradiance, Vector2i size) {
		return (Image) super.call("environment_bake_panorama",
				new java.lang.Object[]{java.lang.Long.valueOf(environment), java.lang.Boolean.valueOf(bake_irradiance),
						(java.lang.Object) size});
	}

	public void screen_space_roughness_limiter_set_active(boolean enable, double amount, double limit) {
		super.call("screen_space_roughness_limiter_set_active", new java.lang.Object[]{
				java.lang.Boolean.valueOf(enable), java.lang.Double.valueOf(amount), java.lang.Double.valueOf(limit)});
	}

	public void sub_surface_scattering_set_quality(int quality) {
		super.call("sub_surface_scattering_set_quality", new java.lang.Object[]{java.lang.Integer.valueOf(quality)});
	}

	public void sub_surface_scattering_set_scale(double scale, double depth_scale) {
		super.call("sub_surface_scattering_set_scale",
				new java.lang.Object[]{java.lang.Double.valueOf(scale), java.lang.Double.valueOf(depth_scale)});
	}

	public long camera_attributes_create() {
		return (long) super.call("camera_attributes_create");
	}

	public void camera_attributes_set_dof_blur_quality(int quality, boolean use_jitter) {
		super.call("camera_attributes_set_dof_blur_quality",
				new java.lang.Object[]{java.lang.Integer.valueOf(quality), java.lang.Boolean.valueOf(use_jitter)});
	}

	public void camera_attributes_set_dof_blur_bokeh_shape(int shape) {
		super.call("camera_attributes_set_dof_blur_bokeh_shape",
				new java.lang.Object[]{java.lang.Integer.valueOf(shape)});
	}

	public void camera_attributes_set_dof_blur(long camera_attributes, boolean far_enable, double far_distance,
			double far_transition, boolean near_enable, double near_distance, double near_transition, double amount) {
		super.call("camera_attributes_set_dof_blur",
				new java.lang.Object[]{java.lang.Long.valueOf(camera_attributes), java.lang.Boolean.valueOf(far_enable),
						java.lang.Double.valueOf(far_distance), java.lang.Double.valueOf(far_transition),
						java.lang.Boolean.valueOf(near_enable), java.lang.Double.valueOf(near_distance),
						java.lang.Double.valueOf(near_transition), java.lang.Double.valueOf(amount)});
	}

	public void camera_attributes_set_exposure(long camera_attributes, double multiplier, double normalization) {
		super.call("camera_attributes_set_exposure", new java.lang.Object[]{java.lang.Long.valueOf(camera_attributes),
				java.lang.Double.valueOf(multiplier), java.lang.Double.valueOf(normalization)});
	}

	public void camera_attributes_set_auto_exposure(long camera_attributes, boolean enable, double min_sensitivity,
			double max_sensitivity, double speed, double scale) {
		super.call("camera_attributes_set_auto_exposure",
				new java.lang.Object[]{java.lang.Long.valueOf(camera_attributes), java.lang.Boolean.valueOf(enable),
						java.lang.Double.valueOf(min_sensitivity), java.lang.Double.valueOf(max_sensitivity),
						java.lang.Double.valueOf(speed), java.lang.Double.valueOf(scale)});
	}

	public long scenario_create() {
		return (long) super.call("scenario_create");
	}

	public void scenario_set_environment(long scenario, long environment) {
		super.call("scenario_set_environment",
				new java.lang.Object[]{java.lang.Long.valueOf(scenario), java.lang.Long.valueOf(environment)});
	}

	public void scenario_set_fallback_environment(long scenario, long environment) {
		super.call("scenario_set_fallback_environment",
				new java.lang.Object[]{java.lang.Long.valueOf(scenario), java.lang.Long.valueOf(environment)});
	}

	public void scenario_set_camera_attributes(long scenario, long effects) {
		super.call("scenario_set_camera_attributes",
				new java.lang.Object[]{java.lang.Long.valueOf(scenario), java.lang.Long.valueOf(effects)});
	}

	public void scenario_set_compositor(long scenario, long compositor) {
		super.call("scenario_set_compositor",
				new java.lang.Object[]{java.lang.Long.valueOf(scenario), java.lang.Long.valueOf(compositor)});
	}

	public long instance_create2(long base, long scenario) {
		return (long) super.call("instance_create2",
				new java.lang.Object[]{java.lang.Long.valueOf(base), java.lang.Long.valueOf(scenario)});
	}

	public long instance_create() {
		return (long) super.call("instance_create");
	}

	public void instance_set_base(long instance, long base) {
		super.call("instance_set_base",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Long.valueOf(base)});
	}

	public void instance_set_scenario(long instance, long scenario) {
		super.call("instance_set_scenario",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Long.valueOf(scenario)});
	}

	public void instance_set_layer_mask(long instance, long mask) {
		super.call("instance_set_layer_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Long.valueOf(mask)});
	}

	public void instance_set_pivot_data(long instance, double sorting_offset, boolean use_aabb_center) {
		super.call("instance_set_pivot_data", new java.lang.Object[]{java.lang.Long.valueOf(instance),
				java.lang.Double.valueOf(sorting_offset), java.lang.Boolean.valueOf(use_aabb_center)});
	}

	public void instance_set_transform(long instance, Transform3D transform) {
		super.call("instance_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), (java.lang.Object) transform});
	}

	public void instance_attach_object_instance_id(long instance, long id) {
		super.call("instance_attach_object_instance_id",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Long.valueOf(id)});
	}

	public void instance_set_blend_shape_weight(long instance, long shape, double weight) {
		super.call("instance_set_blend_shape_weight", new java.lang.Object[]{java.lang.Long.valueOf(instance),
				java.lang.Long.valueOf(shape), java.lang.Double.valueOf(weight)});
	}

	public void instance_set_surface_override_material(long instance, long surface, long material) {
		super.call("instance_set_surface_override_material", new java.lang.Object[]{java.lang.Long.valueOf(instance),
				java.lang.Long.valueOf(surface), java.lang.Long.valueOf(material)});
	}

	public void instance_set_visible(long instance, boolean visible) {
		super.call("instance_set_visible",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Boolean.valueOf(visible)});
	}

	public void instance_geometry_set_transparency(long instance, double transparency) {
		super.call("instance_geometry_set_transparency",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Double.valueOf(transparency)});
	}

	public void instance_teleport(long instance) {
		super.call("instance_teleport", new java.lang.Object[]{java.lang.Long.valueOf(instance)});
	}

	public void instance_set_custom_aabb(long instance, AABB aabb) {
		super.call("instance_set_custom_aabb",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), (java.lang.Object) aabb});
	}

	public void instance_attach_skeleton(long instance, long skeleton) {
		super.call("instance_attach_skeleton",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Long.valueOf(skeleton)});
	}

	public void instance_set_extra_visibility_margin(long instance, double margin) {
		super.call("instance_set_extra_visibility_margin",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Double.valueOf(margin)});
	}

	public void instance_set_visibility_parent(long instance, long parent) {
		super.call("instance_set_visibility_parent",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Long.valueOf(parent)});
	}

	public void instance_set_ignore_culling(long instance, boolean enabled) {
		super.call("instance_set_ignore_culling",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Boolean.valueOf(enabled)});
	}

	public void instance_geometry_set_flag(long instance, int flag, boolean enabled) {
		super.call("instance_geometry_set_flag", new java.lang.Object[]{java.lang.Long.valueOf(instance),
				java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(enabled)});
	}

	public void instance_geometry_set_cast_shadows_setting(long instance, int shadow_casting_setting) {
		super.call("instance_geometry_set_cast_shadows_setting", new java.lang.Object[]{
				java.lang.Long.valueOf(instance), java.lang.Integer.valueOf(shadow_casting_setting)});
	}

	public void instance_geometry_set_material_override(long instance, long material) {
		super.call("instance_geometry_set_material_override",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Long.valueOf(material)});
	}

	public void instance_geometry_set_material_overlay(long instance, long material) {
		super.call("instance_geometry_set_material_overlay",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Long.valueOf(material)});
	}

	public void instance_geometry_set_visibility_range(long instance, double min, double max, double min_margin,
			double max_margin, int fade_mode) {
		super.call("instance_geometry_set_visibility_range",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Double.valueOf(min),
						java.lang.Double.valueOf(max), java.lang.Double.valueOf(min_margin),
						java.lang.Double.valueOf(max_margin), java.lang.Integer.valueOf(fade_mode)});
	}

	public void instance_geometry_set_lightmap(long instance, long lightmap, Rect2 lightmap_uv_scale,
			long lightmap_slice) {
		super.call("instance_geometry_set_lightmap",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Long.valueOf(lightmap),
						(java.lang.Object) lightmap_uv_scale, java.lang.Long.valueOf(lightmap_slice)});
	}

	public void instance_geometry_set_lod_bias(long instance, double lod_bias) {
		super.call("instance_geometry_set_lod_bias",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), java.lang.Double.valueOf(lod_bias)});
	}

	public void instance_geometry_set_shader_parameter(long instance, String parameter, Object value) {
		super.call("instance_geometry_set_shader_parameter", new java.lang.Object[]{java.lang.Long.valueOf(instance),
				(java.lang.Object) parameter, (java.lang.Object) value});
	}

	public Object instance_geometry_get_shader_parameter(long instance, String parameter) {
		return (Object) super.call("instance_geometry_get_shader_parameter",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), (java.lang.Object) parameter});
	}

	public Object instance_geometry_get_shader_parameter_default_value(long instance, String parameter) {
		return (Object) super.call("instance_geometry_get_shader_parameter_default_value",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), (java.lang.Object) parameter});
	}

	public GodotDictionary[] instance_geometry_get_shader_parameter_list(long instance) {
		return (GodotDictionary[]) super.call("instance_geometry_get_shader_parameter_list",
				new java.lang.Object[]{java.lang.Long.valueOf(instance)});
	}

	public long[] instances_cull_aabb(AABB aabb, long scenario) {
		return (long[]) super.call("instances_cull_aabb",
				new java.lang.Object[]{(java.lang.Object) aabb, java.lang.Long.valueOf(scenario)});
	}

	public long[] instances_cull_ray(Vector3 from, Vector3 to, long scenario) {
		return (long[]) super.call("instances_cull_ray", new java.lang.Object[]{(java.lang.Object) from,
				(java.lang.Object) to, java.lang.Long.valueOf(scenario)});
	}

	public long[] instances_cull_convex(Plane[] convex, long scenario) {
		return (long[]) super.call("instances_cull_convex",
				new java.lang.Object[]{(java.lang.Object) convex, java.lang.Long.valueOf(scenario)});
	}

	public Image[] bake_render_uv2(long base, long[] material_overrides, Vector2i image_size) {
		return (Image[]) super.call("bake_render_uv2", new java.lang.Object[]{java.lang.Long.valueOf(base),
				(java.lang.Object) material_overrides, (java.lang.Object) image_size});
	}

	public long canvas_create() {
		return (long) super.call("canvas_create");
	}

	public void canvas_set_item_mirroring(long canvas, long item, Vector2 mirroring) {
		super.call("canvas_set_item_mirroring", new java.lang.Object[]{java.lang.Long.valueOf(canvas),
				java.lang.Long.valueOf(item), (java.lang.Object) mirroring});
	}

	public void canvas_set_item_repeat(long item, Vector2 repeat_size, long repeat_times) {
		super.call("canvas_set_item_repeat", new java.lang.Object[]{java.lang.Long.valueOf(item),
				(java.lang.Object) repeat_size, java.lang.Long.valueOf(repeat_times)});
	}

	public void canvas_set_modulate(long canvas, Color color) {
		super.call("canvas_set_modulate",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas), (java.lang.Object) color});
	}

	public void canvas_set_disable_scale(boolean disable) {
		super.call("canvas_set_disable_scale", new java.lang.Object[]{java.lang.Boolean.valueOf(disable)});
	}

	public long canvas_texture_create() {
		return (long) super.call("canvas_texture_create");
	}

	public void canvas_texture_set_channel(long canvas_texture, int channel, long texture) {
		super.call("canvas_texture_set_channel", new java.lang.Object[]{java.lang.Long.valueOf(canvas_texture),
				java.lang.Integer.valueOf(channel), java.lang.Long.valueOf(texture)});
	}

	public void canvas_texture_set_shading_parameters(long canvas_texture, Color base_color, double shininess) {
		super.call("canvas_texture_set_shading_parameters",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas_texture), (java.lang.Object) base_color,
						java.lang.Double.valueOf(shininess)});
	}

	public void canvas_texture_set_texture_filter(long canvas_texture, int filter) {
		super.call("canvas_texture_set_texture_filter",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas_texture), java.lang.Integer.valueOf(filter)});
	}

	public void canvas_texture_set_texture_repeat(long canvas_texture, int repeat) {
		super.call("canvas_texture_set_texture_repeat",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas_texture), java.lang.Integer.valueOf(repeat)});
	}

	public long canvas_item_create() {
		return (long) super.call("canvas_item_create");
	}

	public void canvas_item_set_parent(long item, long parent) {
		super.call("canvas_item_set_parent",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Long.valueOf(parent)});
	}

	public void canvas_item_set_default_texture_filter(long item, int filter) {
		super.call("canvas_item_set_default_texture_filter",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Integer.valueOf(filter)});
	}

	public void canvas_item_set_default_texture_repeat(long item, int repeat) {
		super.call("canvas_item_set_default_texture_repeat",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Integer.valueOf(repeat)});
	}

	public void canvas_item_set_visible(long item, boolean visible) {
		super.call("canvas_item_set_visible",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Boolean.valueOf(visible)});
	}

	public void canvas_item_set_light_mask(long item, long mask) {
		super.call("canvas_item_set_light_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Long.valueOf(mask)});
	}

	public void canvas_item_set_visibility_layer(long item, long visibility_layer) {
		super.call("canvas_item_set_visibility_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Long.valueOf(visibility_layer)});
	}

	public void canvas_item_set_transform(long item, Transform2D transform) {
		super.call("canvas_item_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) transform});
	}

	public void canvas_item_set_clip(long item, boolean clip) {
		super.call("canvas_item_set_clip",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Boolean.valueOf(clip)});
	}

	public void canvas_item_set_distance_field_mode(long item, boolean enabled) {
		super.call("canvas_item_set_distance_field_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Boolean.valueOf(enabled)});
	}

	public void canvas_item_set_custom_rect(long item, boolean use_custom_rect, Rect2 rect) {
		super.call("canvas_item_set_custom_rect", new java.lang.Object[]{java.lang.Long.valueOf(item),
				java.lang.Boolean.valueOf(use_custom_rect), (java.lang.Object) rect});
	}

	public void canvas_item_set_modulate(long item, Color color) {
		super.call("canvas_item_set_modulate",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) color});
	}

	public void canvas_item_set_self_modulate(long item, Color color) {
		super.call("canvas_item_set_self_modulate",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) color});
	}

	public void canvas_item_set_draw_behind_parent(long item, boolean enabled) {
		super.call("canvas_item_set_draw_behind_parent",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Boolean.valueOf(enabled)});
	}

	public void canvas_item_set_interpolated(long item, boolean interpolated) {
		super.call("canvas_item_set_interpolated",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Boolean.valueOf(interpolated)});
	}

	public void canvas_item_reset_physics_interpolation(long item) {
		super.call("canvas_item_reset_physics_interpolation", new java.lang.Object[]{java.lang.Long.valueOf(item)});
	}

	public void canvas_item_transform_physics_interpolation(long item, Transform2D transform) {
		super.call("canvas_item_transform_physics_interpolation",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) transform});
	}

	public void canvas_item_add_line(long item, Vector2 from, Vector2 to, Color color, double width,
			boolean antialiased) {
		super.call("canvas_item_add_line",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) from, (java.lang.Object) to,
						(java.lang.Object) color, java.lang.Double.valueOf(width),
						java.lang.Boolean.valueOf(antialiased)});
	}

	public void canvas_item_add_polyline(long item, double[][] points, double[][] colors, double width,
			boolean antialiased) {
		super.call("canvas_item_add_polyline",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) points,
						(java.lang.Object) colors, java.lang.Double.valueOf(width),
						java.lang.Boolean.valueOf(antialiased)});
	}

	public void canvas_item_add_multiline(long item, double[][] points, double[][] colors, double width,
			boolean antialiased) {
		super.call("canvas_item_add_multiline",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) points,
						(java.lang.Object) colors, java.lang.Double.valueOf(width),
						java.lang.Boolean.valueOf(antialiased)});
	}

	public void canvas_item_add_rect(long item, Rect2 rect, Color color, boolean antialiased) {
		super.call("canvas_item_add_rect", new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) rect,
				(java.lang.Object) color, java.lang.Boolean.valueOf(antialiased)});
	}

	public void canvas_item_add_circle(long item, Vector2 pos, double radius, Color color, boolean antialiased) {
		super.call("canvas_item_add_circle",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) pos,
						java.lang.Double.valueOf(radius), (java.lang.Object) color,
						java.lang.Boolean.valueOf(antialiased)});
	}

	public void canvas_item_add_ellipse(long item, Vector2 pos, double major, double minor, Color color,
			boolean antialiased) {
		super.call("canvas_item_add_ellipse",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) pos,
						java.lang.Double.valueOf(major), java.lang.Double.valueOf(minor), (java.lang.Object) color,
						java.lang.Boolean.valueOf(antialiased)});
	}

	public void canvas_item_add_texture_rect(long item, Rect2 rect, long texture, boolean tile, Color modulate,
			boolean transpose) {
		super.call("canvas_item_add_texture_rect",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) rect,
						java.lang.Long.valueOf(texture), java.lang.Boolean.valueOf(tile), (java.lang.Object) modulate,
						java.lang.Boolean.valueOf(transpose)});
	}

	public void canvas_item_add_msdf_texture_rect_region(long item, Rect2 rect, long texture, Rect2 src_rect,
			Color modulate, long outline_size, double px_range, double scale) {
		super.call("canvas_item_add_msdf_texture_rect_region",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) rect,
						java.lang.Long.valueOf(texture), (java.lang.Object) src_rect, (java.lang.Object) modulate,
						java.lang.Long.valueOf(outline_size), java.lang.Double.valueOf(px_range),
						java.lang.Double.valueOf(scale)});
	}

	public void canvas_item_add_lcd_texture_rect_region(long item, Rect2 rect, long texture, Rect2 src_rect,
			Color modulate) {
		super.call("canvas_item_add_lcd_texture_rect_region",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) rect,
						java.lang.Long.valueOf(texture), (java.lang.Object) src_rect, (java.lang.Object) modulate});
	}

	public void canvas_item_add_texture_rect_region(long item, Rect2 rect, long texture, Rect2 src_rect, Color modulate,
			boolean transpose, boolean clip_uv) {
		super.call("canvas_item_add_texture_rect_region",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) rect,
						java.lang.Long.valueOf(texture), (java.lang.Object) src_rect, (java.lang.Object) modulate,
						java.lang.Boolean.valueOf(transpose), java.lang.Boolean.valueOf(clip_uv)});
	}

	public void canvas_item_add_nine_patch(long item, Rect2 rect, Rect2 source, long texture, Vector2 topleft,
			Vector2 bottomright, int x_axis_mode, int y_axis_mode, boolean draw_center, Color modulate) {
		super.call("canvas_item_add_nine_patch",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) rect, (java.lang.Object) source,
						java.lang.Long.valueOf(texture), (java.lang.Object) topleft, (java.lang.Object) bottomright,
						java.lang.Integer.valueOf(x_axis_mode), java.lang.Integer.valueOf(y_axis_mode),
						java.lang.Boolean.valueOf(draw_center), (java.lang.Object) modulate});
	}

	public void canvas_item_add_primitive(long item, double[][] points, double[][] colors, double[][] uvs,
			long texture) {
		super.call("canvas_item_add_primitive",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) points,
						(java.lang.Object) colors, (java.lang.Object) uvs, java.lang.Long.valueOf(texture)});
	}

	public void canvas_item_add_polygon(long item, double[][] points, double[][] colors, double[][] uvs, long texture) {
		super.call("canvas_item_add_polygon",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) points,
						(java.lang.Object) colors, (java.lang.Object) uvs, java.lang.Long.valueOf(texture)});
	}

	public void canvas_item_add_triangle_array(long item, int[] indices, double[][] points, double[][] colors,
			double[][] uvs, int[] bones, double[] weights, long texture, long count) {
		super.call("canvas_item_add_triangle_array",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) indices,
						(java.lang.Object) points, (java.lang.Object) colors, (java.lang.Object) uvs,
						(java.lang.Object) bones, (java.lang.Object) weights, java.lang.Long.valueOf(texture),
						java.lang.Long.valueOf(count)});
	}

	public void canvas_item_add_mesh(long item, long mesh, Transform2D transform, Color modulate, long texture) {
		super.call("canvas_item_add_mesh",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Long.valueOf(mesh),
						(java.lang.Object) transform, (java.lang.Object) modulate, java.lang.Long.valueOf(texture)});
	}

	public void canvas_item_add_multimesh(long item, long mesh, long texture) {
		super.call("canvas_item_add_multimesh", new java.lang.Object[]{java.lang.Long.valueOf(item),
				java.lang.Long.valueOf(mesh), java.lang.Long.valueOf(texture)});
	}

	public void canvas_item_add_particles(long item, long particles, long texture) {
		super.call("canvas_item_add_particles", new java.lang.Object[]{java.lang.Long.valueOf(item),
				java.lang.Long.valueOf(particles), java.lang.Long.valueOf(texture)});
	}

	public void canvas_item_add_set_transform(long item, Transform2D transform) {
		super.call("canvas_item_add_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(item), (java.lang.Object) transform});
	}

	public void canvas_item_add_clip_ignore(long item, boolean ignore) {
		super.call("canvas_item_add_clip_ignore",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Boolean.valueOf(ignore)});
	}

	public void canvas_item_add_animation_slice(long item, double animation_length, double slice_begin,
			double slice_end, double offset) {
		super.call("canvas_item_add_animation_slice",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Double.valueOf(animation_length),
						java.lang.Double.valueOf(slice_begin), java.lang.Double.valueOf(slice_end),
						java.lang.Double.valueOf(offset)});
	}

	public void canvas_item_set_sort_children_by_y(long item, boolean enabled) {
		super.call("canvas_item_set_sort_children_by_y",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Boolean.valueOf(enabled)});
	}

	public void canvas_item_set_z_index(long item, long z_index) {
		super.call("canvas_item_set_z_index",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Long.valueOf(z_index)});
	}

	public void canvas_item_set_z_as_relative_to_parent(long item, boolean enabled) {
		super.call("canvas_item_set_z_as_relative_to_parent",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Boolean.valueOf(enabled)});
	}

	public void canvas_item_set_copy_to_backbuffer(long item, boolean enabled, Rect2 rect) {
		super.call("canvas_item_set_copy_to_backbuffer", new java.lang.Object[]{java.lang.Long.valueOf(item),
				java.lang.Boolean.valueOf(enabled), (java.lang.Object) rect});
	}

	public void canvas_item_attach_skeleton(long item, long skeleton) {
		super.call("canvas_item_attach_skeleton",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Long.valueOf(skeleton)});
	}

	public void canvas_item_clear(long item) {
		super.call("canvas_item_clear", new java.lang.Object[]{java.lang.Long.valueOf(item)});
	}

	public void canvas_item_set_draw_index(long item, long index) {
		super.call("canvas_item_set_draw_index",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Long.valueOf(index)});
	}

	public void canvas_item_set_material(long item, long material) {
		super.call("canvas_item_set_material",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Long.valueOf(material)});
	}

	public void canvas_item_set_use_parent_material(long item, boolean enabled) {
		super.call("canvas_item_set_use_parent_material",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Boolean.valueOf(enabled)});
	}

	public void canvas_item_set_instance_shader_parameter(long instance, String parameter, Object value) {
		super.call("canvas_item_set_instance_shader_parameter", new java.lang.Object[]{java.lang.Long.valueOf(instance),
				(java.lang.Object) parameter, (java.lang.Object) value});
	}

	public Object canvas_item_get_instance_shader_parameter(long instance, String parameter) {
		return (Object) super.call("canvas_item_get_instance_shader_parameter",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), (java.lang.Object) parameter});
	}

	public Object canvas_item_get_instance_shader_parameter_default_value(long instance, String parameter) {
		return (Object) super.call("canvas_item_get_instance_shader_parameter_default_value",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), (java.lang.Object) parameter});
	}

	public GodotDictionary[] canvas_item_get_instance_shader_parameter_list(long instance) {
		return (GodotDictionary[]) super.call("canvas_item_get_instance_shader_parameter_list",
				new java.lang.Object[]{java.lang.Long.valueOf(instance)});
	}

	public void canvas_item_set_visibility_notifier(long item, boolean enable, Rect2 area, Callable enter_callable,
			Callable exit_callable) {
		super.call("canvas_item_set_visibility_notifier",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Boolean.valueOf(enable),
						(java.lang.Object) area, (java.lang.Object) enter_callable, (java.lang.Object) exit_callable});
	}

	public void canvas_item_set_canvas_group_mode(long item, int mode, double clear_margin, boolean fit_empty,
			double fit_margin, boolean blur_mipmaps) {
		super.call("canvas_item_set_canvas_group_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(item), java.lang.Integer.valueOf(mode),
						java.lang.Double.valueOf(clear_margin), java.lang.Boolean.valueOf(fit_empty),
						java.lang.Double.valueOf(fit_margin), java.lang.Boolean.valueOf(blur_mipmaps)});
	}

	public Rect2 debug_canvas_item_get_rect(long item) {
		return (Rect2) super.call("debug_canvas_item_get_rect", new java.lang.Object[]{java.lang.Long.valueOf(item)});
	}

	public long canvas_light_create() {
		return (long) super.call("canvas_light_create");
	}

	public void canvas_light_attach_to_canvas(long light, long canvas) {
		super.call("canvas_light_attach_to_canvas",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Long.valueOf(canvas)});
	}

	public void canvas_light_set_enabled(long light, boolean enabled) {
		super.call("canvas_light_set_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Boolean.valueOf(enabled)});
	}

	public void canvas_light_set_texture_scale(long light, double scale) {
		super.call("canvas_light_set_texture_scale",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Double.valueOf(scale)});
	}

	public void canvas_light_set_transform(long light, Transform2D transform) {
		super.call("canvas_light_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(light), (java.lang.Object) transform});
	}

	public void canvas_light_set_texture(long light, long texture) {
		super.call("canvas_light_set_texture",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Long.valueOf(texture)});
	}

	public void canvas_light_set_texture_offset(long light, Vector2 offset) {
		super.call("canvas_light_set_texture_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(light), (java.lang.Object) offset});
	}

	public void canvas_light_set_color(long light, Color color) {
		super.call("canvas_light_set_color",
				new java.lang.Object[]{java.lang.Long.valueOf(light), (java.lang.Object) color});
	}

	public void canvas_light_set_height(long light, double height) {
		super.call("canvas_light_set_height",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Double.valueOf(height)});
	}

	public void canvas_light_set_energy(long light, double energy) {
		super.call("canvas_light_set_energy",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Double.valueOf(energy)});
	}

	public void canvas_light_set_z_range(long light, long min_z, long max_z) {
		super.call("canvas_light_set_z_range", new java.lang.Object[]{java.lang.Long.valueOf(light),
				java.lang.Long.valueOf(min_z), java.lang.Long.valueOf(max_z)});
	}

	public void canvas_light_set_layer_range(long light, long min_layer, long max_layer) {
		super.call("canvas_light_set_layer_range", new java.lang.Object[]{java.lang.Long.valueOf(light),
				java.lang.Long.valueOf(min_layer), java.lang.Long.valueOf(max_layer)});
	}

	public void canvas_light_set_item_cull_mask(long light, long mask) {
		super.call("canvas_light_set_item_cull_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Long.valueOf(mask)});
	}

	public void canvas_light_set_item_shadow_cull_mask(long light, long mask) {
		super.call("canvas_light_set_item_shadow_cull_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Long.valueOf(mask)});
	}

	public void canvas_light_set_mode(long light, int mode) {
		super.call("canvas_light_set_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Integer.valueOf(mode)});
	}

	public void canvas_light_set_shadow_enabled(long light, boolean enabled) {
		super.call("canvas_light_set_shadow_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Boolean.valueOf(enabled)});
	}

	public void canvas_light_set_shadow_filter(long light, int filter) {
		super.call("canvas_light_set_shadow_filter",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Integer.valueOf(filter)});
	}

	public void canvas_light_set_shadow_color(long light, Color color) {
		super.call("canvas_light_set_shadow_color",
				new java.lang.Object[]{java.lang.Long.valueOf(light), (java.lang.Object) color});
	}

	public void canvas_light_set_shadow_smooth(long light, double smooth) {
		super.call("canvas_light_set_shadow_smooth",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Double.valueOf(smooth)});
	}

	public void canvas_light_set_blend_mode(long light, int mode) {
		super.call("canvas_light_set_blend_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Integer.valueOf(mode)});
	}

	public void canvas_light_set_interpolated(long light, boolean interpolated) {
		super.call("canvas_light_set_interpolated",
				new java.lang.Object[]{java.lang.Long.valueOf(light), java.lang.Boolean.valueOf(interpolated)});
	}

	public void canvas_light_reset_physics_interpolation(long light) {
		super.call("canvas_light_reset_physics_interpolation", new java.lang.Object[]{java.lang.Long.valueOf(light)});
	}

	public void canvas_light_transform_physics_interpolation(long light, Transform2D transform) {
		super.call("canvas_light_transform_physics_interpolation",
				new java.lang.Object[]{java.lang.Long.valueOf(light), (java.lang.Object) transform});
	}

	public long canvas_light_occluder_create() {
		return (long) super.call("canvas_light_occluder_create");
	}

	public void canvas_light_occluder_attach_to_canvas(long occluder, long canvas) {
		super.call("canvas_light_occluder_attach_to_canvas",
				new java.lang.Object[]{java.lang.Long.valueOf(occluder), java.lang.Long.valueOf(canvas)});
	}

	public void canvas_light_occluder_set_enabled(long occluder, boolean enabled) {
		super.call("canvas_light_occluder_set_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(occluder), java.lang.Boolean.valueOf(enabled)});
	}

	public void canvas_light_occluder_set_polygon(long occluder, long polygon) {
		super.call("canvas_light_occluder_set_polygon",
				new java.lang.Object[]{java.lang.Long.valueOf(occluder), java.lang.Long.valueOf(polygon)});
	}

	public void canvas_light_occluder_set_as_sdf_collision(long occluder, boolean enable) {
		super.call("canvas_light_occluder_set_as_sdf_collision",
				new java.lang.Object[]{java.lang.Long.valueOf(occluder), java.lang.Boolean.valueOf(enable)});
	}

	public void canvas_light_occluder_set_transform(long occluder, Transform2D transform) {
		super.call("canvas_light_occluder_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(occluder), (java.lang.Object) transform});
	}

	public void canvas_light_occluder_set_light_mask(long occluder, long mask) {
		super.call("canvas_light_occluder_set_light_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(occluder), java.lang.Long.valueOf(mask)});
	}

	public void canvas_light_occluder_set_interpolated(long occluder, boolean interpolated) {
		super.call("canvas_light_occluder_set_interpolated",
				new java.lang.Object[]{java.lang.Long.valueOf(occluder), java.lang.Boolean.valueOf(interpolated)});
	}

	public void canvas_light_occluder_reset_physics_interpolation(long occluder) {
		super.call("canvas_light_occluder_reset_physics_interpolation",
				new java.lang.Object[]{java.lang.Long.valueOf(occluder)});
	}

	public void canvas_light_occluder_transform_physics_interpolation(long occluder, Transform2D transform) {
		super.call("canvas_light_occluder_transform_physics_interpolation",
				new java.lang.Object[]{java.lang.Long.valueOf(occluder), (java.lang.Object) transform});
	}

	public long canvas_occluder_polygon_create() {
		return (long) super.call("canvas_occluder_polygon_create");
	}

	public void canvas_occluder_polygon_set_shape(long occluder_polygon, double[][] shape, boolean closed) {
		super.call("canvas_occluder_polygon_set_shape", new java.lang.Object[]{java.lang.Long.valueOf(occluder_polygon),
				(java.lang.Object) shape, java.lang.Boolean.valueOf(closed)});
	}

	public void canvas_occluder_polygon_set_cull_mode(long occluder_polygon, int mode) {
		super.call("canvas_occluder_polygon_set_cull_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(occluder_polygon), java.lang.Integer.valueOf(mode)});
	}

	public void canvas_set_shadow_texture_size(long size) {
		super.call("canvas_set_shadow_texture_size", new java.lang.Object[]{java.lang.Long.valueOf(size)});
	}

	public void global_shader_parameter_add(String name, int type, Object default_value) {
		super.call("global_shader_parameter_add", new java.lang.Object[]{(java.lang.Object) name,
				java.lang.Integer.valueOf(type), (java.lang.Object) default_value});
	}

	public void global_shader_parameter_remove(String name) {
		super.call("global_shader_parameter_remove", new java.lang.Object[]{(java.lang.Object) name});
	}

	public String[] global_shader_parameter_get_list() {
		return (String[]) super.call("global_shader_parameter_get_list");
	}

	public void global_shader_parameter_set(String name, Object value) {
		super.call("global_shader_parameter_set",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) value});
	}

	public void global_shader_parameter_set_override(String name, Object value) {
		super.call("global_shader_parameter_set_override",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) value});
	}

	public Object global_shader_parameter_get(String name) {
		return (Object) super.call("global_shader_parameter_get", new java.lang.Object[]{(java.lang.Object) name});
	}

	public int global_shader_parameter_get_type(String name) {
		return (int) super.call("global_shader_parameter_get_type", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void free_rid(long rid) {
		super.call("free_rid", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public void request_frame_drawn_callback(Callable callable) {
		super.call("request_frame_drawn_callback", new java.lang.Object[]{(java.lang.Object) callable});
	}

	public boolean has_changed() {
		return (boolean) super.call("has_changed");
	}

	public java.math.BigInteger get_rendering_info(int info) {
		return (java.math.BigInteger) super.call("get_rendering_info",
				new java.lang.Object[]{java.lang.Integer.valueOf(info)});
	}

	public long make_sphere_mesh(long latitudes, long longitudes, double radius) {
		return (long) super.call("make_sphere_mesh", new java.lang.Object[]{java.lang.Long.valueOf(latitudes),
				java.lang.Long.valueOf(longitudes), java.lang.Double.valueOf(radius)});
	}

	public void set_boot_image_with_stretch(Image image, Color color, int stretch_mode, boolean use_filter) {
		super.call("set_boot_image_with_stretch",
				new java.lang.Object[]{(java.lang.Object) image, (java.lang.Object) color,
						java.lang.Integer.valueOf(stretch_mode), java.lang.Boolean.valueOf(use_filter)});
	}

	public void set_boot_image(Image image, Color color, boolean scale, boolean use_filter) {
		super.call("set_boot_image", new java.lang.Object[]{(java.lang.Object) image, (java.lang.Object) color,
				java.lang.Boolean.valueOf(scale), java.lang.Boolean.valueOf(use_filter)});
	}

	public boolean has_os_feature(String feature) {
		return (boolean) super.call("has_os_feature", new java.lang.Object[]{(java.lang.Object) feature});
	}

	public boolean is_render_loop_enabled() {
		return (boolean) super.call("is_render_loop_enabled");
	}

	public void force_sync() {
		super.call("force_sync");
	}

	public void force_draw(boolean swap_buffers, double frame_step) {
		super.call("force_draw",
				new java.lang.Object[]{java.lang.Boolean.valueOf(swap_buffers), java.lang.Double.valueOf(frame_step)});
	}

	public RenderingDevice create_local_rendering_device() {
		return (RenderingDevice) super.call("create_local_rendering_device");
	}

	public boolean is_on_render_thread() {
		return (boolean) super.call("is_on_render_thread");
	}

	public void call_on_render_thread(Callable callable) {
		super.call("call_on_render_thread", new java.lang.Object[]{(java.lang.Object) callable});
	}

	public boolean has_feature(int feature) {
		return (boolean) super.call("has_feature", new java.lang.Object[]{java.lang.Integer.valueOf(feature)});
	}

	public boolean isRender_loop_enabled() {
		return (boolean) super.call("is_render_loop_enabled", new java.lang.Object[0]);
	}

	public void setRender_loop_enabled(boolean value) {
		super.call("set_render_loop_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
