package org.godot.internal.api;

/**
 * Auto-generated virtual method definitions from extension_api.json. DO NOT
 * EDIT.
 *
 * Contains a reverse lookup: compatibility hash → method names. Different Godot
 * classes may assign different hashes to the same virtual method; all hashes
 * are stored here.
 */
public final class VirtualMethods {

	private VirtualMethods() {
	}

	/** Total number of unique virtual method names. */
	public static final int COUNT = 1144;

	private static final java.util.Map<Long, java.util.Set<String>> _HASH_TO_NAMES = new java.util.HashMap<>();
	static {
		_HASH_TO_NAMES.put(3341600327L,
				java.util.Set.of("_get_total_gravity", "_get_center_of_mass", "_get_center_of_mass_local",
						"_get_linear_velocity", "_get_constant_force", "_get_minimum_size",
						"_get_contents_minimum_size"));
		_HASH_TO_NAMES.put(1740695150L,
				java.util.Set.of("_get_total_linear_damp", "_get_total_angular_damp", "_get_inverse_mass",
						"_get_inverse_inertia", "_get_angular_velocity", "_get_constant_torque", "_get_step",
						"_get_stream_sampling_rate", "_get_playback_position", "_get_length",
						"_font_get_global_oversampling", "_get_bpm", "_get_priority"));
		_HASH_TO_NAMES.put(743155724L, java.util.Set.of("_set_linear_velocity", "_apply_central_impulse",
				"_apply_central_force", "_add_constant_central_force", "_set_constant_force"));
		_HASH_TO_NAMES.put(373806689L,
				java.util.Set.of("_set_angular_velocity", "_apply_torque_impulse", "_apply_torque",
						"_add_constant_torque", "_set_constant_torque", "_start", "_seek", "_process",
						"_physics_process", "_update", "_font_set_global_oversampling", "_reference_oversampling_level",
						"_unreference_oversampling_level", "_set_fsr_sharpness", "_set_texture_mipmap_bias",
						"_process_modification_with_delta", "_step", "_value_changed", "_execute"));
		_HASH_TO_NAMES.put(2761652528L, java.util.Set.of("_set_transform"));
		_HASH_TO_NAMES.put(3814499831L, java.util.Set.of("_get_transform"));
		_HASH_TO_NAMES.put(2656412154L, java.util.Set.of("_get_velocity_at_local_position"));
		_HASH_TO_NAMES.put(3108078480L, java.util.Set.of("_apply_impulse", "_apply_force", "_add_constant_force"));
		_HASH_TO_NAMES.put(2586408642L,
				java.util.Set.of("_set_sleep_state", "_set_paused", "_set_refuse_new_connections", "_set_use_debanding",
						"_set_anchor_detection_is_enabled", "_toggled", "_set_read_only", "_set_active",
						"_confirm_code_completion", "_request_code_completion", "_make_visible",
						"_profiling_set_save_native_calls"));
		_HASH_TO_NAMES.put(36873697L, java.util.Set.of("_is_sleeping", "_was_string_packet", "_is_ordered",
				"_is_negotiated", "_is_playing", "_process_silence", "_has_alpha", "_has_mipmaps", "_is_paused",
				"_is_monophonic", "_has_loop", "_has_valid_configuration", "_has_filter", "_is_server",
				"_is_refusing_new_connections", "_is_server_relay_supported", "_is_initialized",
				"_get_anchor_detection_is_enabled", "_can_be_hidden", "_is_selectable_when_hidden", "_is_active",
				"_query", "_generate_small_preview_automatically", "_can_generate_small_preview", "_is_highend",
				"_can_do_next_pass", "_can_use_render_priority", "_can_import_threaded", "_is_flushing_queries",
				"_has_main_screen", "_can_instantiate", "_has_source_code", "_is_tool", "_is_valid", "_is_abstract",
				"_is_placeholder_fallback_enabled", "_has_named_classes", "_supports_builtin_mode",
				"_supports_documentation", "_can_inherit_from_file", "_can_make_function"));
		_HASH_TO_NAMES.put(1286410249L,
				java.util.Set.of("_set_collision_layer", "_set_collision_mask", "_set_capacity",
						"_prepare_view_configuration", "_on_instance_created", "_on_session_created",
						"_on_viewport_composition_layer_destroyed", "_set_audio_track", "_get_internal_import_options",
						"_set_transfer_channel", "_set_target_peer", "_set_anisotropic_filtering_level",
						"_setup_session", "_backspace", "_cut", "_copy", "_paste", "_paste_primary_clipboard",
						"_mouse_shape_enter", "_mouse_shape_exit", "_placeholder_erased", "_update_layout"));
		_HASH_TO_NAMES.put(3905245786L,
				java.util.Set.of("_get_collision_layer", "_get_collision_mask", "_get_contact_count",
						"_get_component_type", "_get_available_packet_count", "_get_max_packet_size", "_get_id",
						"_get_max_packet_life_time", "_get_max_retransmits", "_get_buffered_amount", "_get_loop_count",
						"_get_surface_count", "_get_blend_shape_count", "_get_width", "_get_height", "_get_depth",
						"_get_channels", "_get_mix_rate", "_get_features", "_get_audio_mix_rate", "_get_beat_count",
						"_get_bar_beats", "_get_packet_channel", "_get_transfer_channel", "_get_packet_peer",
						"_get_unique_id", "_get_capabilities", "_get_camera_feed_id", "_get_priority",
						"_get_input_port_count", "_get_output_port_count", "_get_property_count", "_get_preset_count",
						"_get_import_order", "_get_format_version", "_get_view_count", "_get_layered_type",
						"_get_layers", "_get_remote_sender_id", "_get_customization_configuration_hash",
						"_get_available_bytes", "_debug_get_stack_level_count", "_get_options_count"));
		_HASH_TO_NAMES.put(2299179447L,
				java.util.Set.of("_get_contact_local_position", "_get_contact_local_normal",
						"_get_contact_local_velocity_at_position", "_get_contact_collider_position",
						"_get_contact_collider_velocity_at_position", "_get_contact_impulse"));
		_HASH_TO_NAMES.put(923996154L,
				java.util.Set.of("_get_contact_local_shape", "_get_contact_collider_id", "_get_contact_collider_shape",
						"_get_structure_data", "_surface_get_array_len", "_surface_get_array_index_len",
						"_surface_get_format", "_surface_get_primitive_type", "_get_property_default_index",
						"_debug_get_stack_level_line"));
		_HASH_TO_NAMES.put(495598643L, java.util.Set.of("_get_contact_collider"));
		_HASH_TO_NAMES.put(3332903315L, java.util.Set.of("_get_contact_collider_object"));
		_HASH_TO_NAMES.put(3218959716L,
				java.util.Set.of("_integrate_forces", "_clear_highlighting_cache", "_update_cache", "_deactivate_feed",
						"_close", "_stop", "_tag_used_streams", "_enter_tree", "_exit_tree", "_ready",
						"_on_register_metadata", "_on_before_instance_created", "_on_instance_destroyed", "_on_process",
						"_on_sync_actions", "_on_pre_render", "_on_main_swapchains_created", "_on_session_destroyed",
						"_on_state_idle", "_on_state_ready", "_on_state_synchronized", "_on_state_visible",
						"_on_state_focused", "_on_state_stopping", "_on_state_loss_pending", "_on_state_exiting",
						"_play", "_draw", "_font_clear_system_fallback_cache", "_cleanup", "_write_end", "_redraw",
						"_poll", "_initialize", "_finalize", "_uninitialize", "_process", "_pre_render", "_end_frame",
						"_process_modification", "_validate_bone_names", "_breakpoints_cleared_in_tree", "_pressed",
						"_update_property", "_sync", "_flush_queries", "_end_sync", "_finish", "_run",
						"_draw_editor_gizmo", "_clear", "_save_external_data", "_apply_changes", "_enable_plugin",
						"_disable_plugin", "_mouse_enter", "_mouse_exit", "_export_end", "_end_customize_scenes",
						"_end_customize_resources", "_update_exports", "_thread_enter", "_thread_exit",
						"_reload_all_scripts", "_profiling_start", "_profiling_stop", "_frame", "_setup_local_to_scene",
						"_reset_state"));
		_HASH_TO_NAMES.put(2506717822L, java.util.Set.of("_get_space_state"));
		_HASH_TO_NAMES.put(3485342025L, java.util.Set.of("_get_line_syntax_highlighting", "_surface_get_lods"));
		_HASH_TO_NAMES.put(2240911060L,
				java.util.Set.of("_activate_feed", "_initialize", "_shut_down", "_build",
						"_editor_can_reload_from_file", "_is_using_templates", "_overrides_external_editor",
						"_should_update_export_options", "_poll_export"));
		_HASH_TO_NAMES.put(2275962004L, java.util.Set.of("_draw"));
		_HASH_TO_NAMES.put(408950903L, java.util.Set.of("_get_draw_rect"));
		_HASH_TO_NAMES.put(3735564539L, java.util.Set.of("_test_mask"));
		_HASH_TO_NAMES.put(1068685055L, java.util.Set.of("_get_aabb"));
		_HASH_TO_NAMES.put(4291131558L, java.util.Set.of("_get_build_dependencies", "_get_classes_used"));
		_HASH_TO_NAMES.put(50157827L,
				java.util.Set.of("_mix_resampled", "_set_instance_create_info_and_get_next_pointer",
						"_set_hand_joint_locations_and_get_next_pointer", "_set_projection_views_and_get_next_pointer",
						"_set_reference_space_create_info_and_get_next_pointer",
						"_set_view_configuration_and_get_next_pointer", "_profiling_get_accumulated_data",
						"_profiling_get_frame_data"));
		_HASH_TO_NAMES.put(3099858825L, java.util.Set.of("_get_packet", "_put_packet"));
		_HASH_TO_NAMES.put(166280745L, java.util.Set.of("_poll", "_create_offer"));
		_HASH_TO_NAMES.put(1999768052L, java.util.Set.of("_set_write_mode"));
		_HASH_TO_NAMES.put(2848495172L, java.util.Set.of("_get_write_mode"));
		_HASH_TO_NAMES.put(3501143017L, java.util.Set.of("_get_ready_state"));
		_HASH_TO_NAMES.put(201670096L, java.util.Set.of("_get_label", "_get_protocol", "_converts_to", "_get_name",
				"_get_support_data_filename", "_get_support_data_info", "_get_stream_name", "_get_caption",
				"_get_gizmo_name", "_get_description", "_get_category", "_get_importer_name", "_get_visible_name",
				"_get_save_extension", "_get_resource_type", "_get_plugin_name", "_accessibility_get_contextual_info",
				"_get_source_code", "_get_class_icon_path", "_get_type", "_get_extension", "_debug_get_error",
				"_get_os_name", "_get_options_tooltip", "_get_debug_protocol"));
		_HASH_TO_NAMES.put(3738334489L, java.util.Set.of("_propagate_input_event"));
		_HASH_TO_NAMES.put(420958145L, java.util.Set.of("_integrate_forces"));
		_HASH_TO_NAMES.put(397768994L, java.util.Set.of("_can_handle", "_handles", "_instance_has"));
		_HASH_TO_NAMES.put(3975164845L, java.util.Set.of("_parse_begin", "_parse_end", "_set_create_options", "_edit"));
		_HASH_TO_NAMES.put(357144787L, java.util.Set.of("_parse_category", "_parse_group"));
		_HASH_TO_NAMES.put(1087679910L, java.util.Set.of("_parse_property"));
		_HASH_TO_NAMES.put(925936155L, java.util.Set.of("_mix"));
		_HASH_TO_NAMES.put(3776071444L,
				java.util.Set.of("_set_parameter", "_add_global_constant", "_add_named_global_constant"));
		_HASH_TO_NAMES.put(2760726917L, java.util.Set.of("_get_parameter", "_get_parameter_default_value",
				"_get_script_method_argument_count", "_get_property_default_value"));
		_HASH_TO_NAMES.put(2794699034L, java.util.Set.of("_save"));
		_HASH_TO_NAMES.put(993915709L, java.util.Set.of("_set_uid"));
		_HASH_TO_NAMES.put(3190994482L, java.util.Set.of("_recognize", "_handles"));
		_HASH_TO_NAMES.put(1567505034L, java.util.Set.of("_get_recognized_extensions"));
		_HASH_TO_NAMES.put(710996192L, java.util.Set.of("_recognize_path"));
		_HASH_TO_NAMES.put(1649997291L, java.util.Set.of("_process"));
		_HASH_TO_NAMES.put(2716908335L, java.util.Set.of("_post_process_key_value"));
		_HASH_TO_NAMES.put(1139954409L,
				java.util.Set.of("_get_configuration_warnings", "_get_accessibility_configuration_warnings",
						"_get_recognized_extensions", "_get_supported_extensions", "_get_suggested_tracker_names",
						"_get_file_extensions", "_get_extensions", "_get_breakpoints", "_get_reserved_words",
						"_get_comment_delimiters", "_get_doc_comment_delimiters", "_get_string_delimiters",
						"_get_platform_features", "_get_supported_languages"));
		_HASH_TO_NAMES.put(3754044979L, java.util.Set.of("_input", "_shortcut_input", "_unhandled_input",
				"_unhandled_key_input", "_gui_input"));
		_HASH_TO_NAMES.put(2944877500L, java.util.Set.of("_get_focused_accessibility_element", "_get_shader_rid",
				"_get_uniform_buffer", "_get_environment", "_get_camera_attributes", "_get_rid"));
		_HASH_TO_NAMES.put(663333327L, java.util.Set.of("_surface_get_arrays", "_surface_get_blend_shape_arrays"));
		_HASH_TO_NAMES.put(3671737478L, java.util.Set.of("_surface_set_material"));
		_HASH_TO_NAMES.put(2897466400L, java.util.Set.of("_surface_get_material"));
		_HASH_TO_NAMES.put(659327637L, java.util.Set.of("_get_blend_shape_name"));
		_HASH_TO_NAMES.put(3780747571L, java.util.Set.of("_set_blend_shape_name"));
		_HASH_TO_NAMES.put(325183270L, java.util.Set.of("_convert"));
		_HASH_TO_NAMES.put(3554694381L, java.util.Set.of("_get_requested_extensions"));
		_HASH_TO_NAMES.put(3744713108L,
				java.util.Set.of("_set_system_properties_and_get_next_pointer",
						"_set_session_create_and_get_next_pointer", "_set_swapchain_create_info_and_get_next_pointer",
						"_set_frame_wait_info_and_get_next_pointer", "_set_frame_end_info_and_get_next_pointer",
						"_set_view_locate_info_and_get_next_pointer", "_get_composition_layer",
						"_get_composition_layer_order", "_get_header", "_debug_get_stack_level_instance"));
		_HASH_TO_NAMES.put(998575451L, java.util.Set.of("_print_view_configuration_info"));
		_HASH_TO_NAMES.put(2455072627L,
				java.util.Set.of("_get_composition_layer_count", "_get_configuration", "_get_view_count"));
		_HASH_TO_NAMES.put(2981934095L, java.util.Set.of("_get_suggested_tracker_names", "_get_supported_extensions",
				"_get_saveable_image_formats"));
		_HASH_TO_NAMES.put(2722037293L,
				java.util.Set.of("_on_pre_draw_viewport", "_on_post_draw_viewport", "_free_rid",
						"_font_clear_size_cache", "_shaped_text_clear", "_area_clear_shapes", "_body_clear_shapes",
						"_body_reset_mass_properties", "_soft_body_remove_all_pinned_points", "_joint_clear"));
		_HASH_TO_NAMES.put(3067735520L, java.util.Set.of("_on_event_polled", "_handle_menu_selected"));
		_HASH_TO_NAMES.put(2250464348L, java.util.Set.of("_set_viewport_composition_layer_and_get_next_pointer"));
		_HASH_TO_NAMES.put(2915620761L, java.util.Set.of("_get_viewport_composition_layer_extension_properties",
				"_get_modified_files_data", "_get_branch_list", "_get_remotes", "_debug_get_current_stack_info"));
		_HASH_TO_NAMES.put(2382534195L,
				java.util.Set.of("_get_viewport_composition_layer_extension_property_defaults"));
		_HASH_TO_NAMES.put(3726637545L,
				java.util.Set.of("_set_android_surface_swapchain_create_info_and_get_next_pointer"));
		_HASH_TO_NAMES.put(2522259332L, java.util.Set.of("_is_pixel_opaque", "_filter_neighbor"));
		_HASH_TO_NAMES.put(1384643611L, java.util.Set.of("_draw"));
		_HASH_TO_NAMES.put(3819628907L, java.util.Set.of("_draw_rect"));
		_HASH_TO_NAMES.put(4094143664L, java.util.Set.of("_draw_rect_region"));
		_HASH_TO_NAMES.put(3847873762L, java.util.Set.of("_get_format"));
		_HASH_TO_NAMES.put(3995934104L,
				java.util.Set.of("_get_data", "_get_parameter_list", "_create_mesh_array", "_get_documentation",
						"_get_script_signal_list", "_get_script_method_list", "_get_script_property_list",
						"_get_members", "_get_public_functions", "_get_public_annotations", "_get_export_options"));
		_HASH_TO_NAMES.put(1157301103L, java.util.Set.of("_toggle"));
		_HASH_TO_NAMES.put(381264803L, java.util.Set.of("_add_frame"));
		_HASH_TO_NAMES.put(3948312143L, java.util.Set.of("_tick"));
		_HASH_TO_NAMES.put(3635182373L,
				java.util.Set.of("_get_texture", "_get_plugin_icon", "_get_logo", "_get_run_icon"));
		_HASH_TO_NAMES.put(3760540541L, java.util.Set.of("_load_image"));
		_HASH_TO_NAMES.put(1930428628L, java.util.Set.of("_get_allowed_size_flags_horizontal",
				"_get_allowed_size_flags_vertical", "_get_peer_ids"));
		_HASH_TO_NAMES.put(3967367083L, java.util.Set.of("_has_feature"));
		_HASH_TO_NAMES.put(3521089500L, java.util.Set.of("_has", "_shaped_text_shape", "_shaped_text_update_breaks",
				"_shaped_text_update_justification_ops", "_pre_draw_viewport"));
		_HASH_TO_NAMES.put(2323990056L, java.util.Set.of("_load_support_data", "_initialize", "_checkout_branch"));
		_HASH_TO_NAMES.put(3927539163L,
				java.util.Set.of("_save_support_data", "_is_locale_using_support_data", "_is_locale_right_to_left",
						"_is_valid_identifier", "_spoof_check", "_handles_file", "_handles", "_has_capture", "_exists",
						"_is_control_flow_keyword", "_handles_global_class_type", "_is_executable"));
		_HASH_TO_NAMES.put(2362200018L, java.util.Set.of("_get_support_data"));
		_HASH_TO_NAMES.put(1321353865L, java.util.Set.of("_name_to_tag", "_get_resource_uid"));
		_HASH_TO_NAMES.put(844755477L,
				java.util.Set.of("_tag_to_name", "_get_input_port_name", "_get_output_port_name", "_get_property_name",
						"_get_preset_name", "_debug_get_stack_level_function", "_debug_get_stack_level_source",
						"_get_option_label", "_get_option_tooltip", "_get_device_architecture"));
		_HASH_TO_NAMES.put(529393457L,
				java.util.Set.of("_create_font", "_get_vrs_texture", "_get_color_texture", "_get_depth_texture",
						"_get_velocity_texture", "_world_boundary_shape_create", "_separation_ray_shape_create",
						"_sphere_shape_create", "_box_shape_create", "_capsule_shape_create", "_cylinder_shape_create",
						"_convex_polygon_shape_create", "_concave_polygon_shape_create", "_heightmap_shape_create",
						"_custom_shape_create", "_space_create", "_area_create", "_body_create", "_soft_body_create",
						"_joint_create", "_segment_shape_create", "_circle_shape_create", "_rectangle_shape_create"));
		_HASH_TO_NAMES.put(41030802L, java.util.Set.of("_create_font_linked_variation", "_shaped_text_duplicate"));
		_HASH_TO_NAMES.put(1355495400L, java.util.Set.of("_font_set_data"));
		_HASH_TO_NAMES.put(4288446313L, java.util.Set.of("_font_set_data_ptr"));
		_HASH_TO_NAMES.put(3411492887L, java.util.Set.of("_font_set_face_index", "_font_set_weight",
				"_font_set_stretch", "_font_set_msdf_pixel_range", "_font_set_msdf_size", "_font_set_fixed_size",
				"_font_clear_kerning_map", "_shaped_text_set_custom_ellipsis", "_space_set_debug_contacts",
				"_area_remove_shape", "_area_attach_object_instance_id", "_area_set_collision_layer",
				"_area_set_collision_mask", "_body_remove_shape", "_body_attach_object_instance_id",
				"_body_set_collision_layer", "_body_set_collision_mask", "_body_set_user_flags",
				"_body_set_max_contacts_reported", "_soft_body_set_collision_layer", "_soft_body_set_collision_mask",
				"_soft_body_set_simulation_precision", "_joint_set_solver_priority", "_area_attach_canvas_instance_id",
				"_body_attach_canvas_instance_id"));
		_HASH_TO_NAMES.put(2198884583L,
				java.util.Set.of("_font_get_face_index", "_font_get_face_count", "_font_get_weight",
						"_font_get_stretch", "_font_get_msdf_pixel_range", "_font_get_msdf_size",
						"_font_get_fixed_size", "_shaped_text_get_custom_ellipsis", "_shaped_get_span_count",
						"_shaped_get_run_count", "_shaped_text_get_glyphs", "_shaped_text_get_glyph_count",
						"_shaped_text_get_trim_pos", "_shaped_text_get_ellipsis_pos",
						"_shaped_text_get_ellipsis_glyph_count", "_shaped_text_get_ellipsis_glyphs",
						"_space_get_contact_count", "_area_get_shape_count", "_area_get_object_instance_id",
						"_area_get_collision_layer", "_area_get_collision_mask", "_body_get_shape_count",
						"_body_get_object_instance_id", "_body_get_collision_layer", "_body_get_collision_mask",
						"_body_get_user_flags", "_body_get_max_contacts_reported", "_soft_body_get_collision_layer",
						"_soft_body_get_collision_mask", "_soft_body_get_simulation_precision",
						"_joint_get_solver_priority", "_area_get_canvas_instance_id", "_body_get_canvas_instance_id"));
		_HASH_TO_NAMES.put(898466325L, java.util.Set.of("_font_set_style"));
		_HASH_TO_NAMES.put(3082502592L, java.util.Set.of("_font_get_style"));
		_HASH_TO_NAMES.put(2726140452L,
				java.util.Set.of("_font_set_name", "_font_set_style_name", "_font_remove_language_support_override",
						"_font_remove_script_support_override", "_shaped_text_set_custom_punctuation"));
		_HASH_TO_NAMES.put(642473191L, java.util.Set.of("_font_get_name", "_font_get_style_name",
				"_font_get_supported_chars", "_shaped_text_get_custom_punctuation", "_shaped_get_text"));
		_HASH_TO_NAMES.put(1882737106L,
				java.util.Set.of("_font_get_ot_name_strings", "_font_get_variation_coordinates",
						"_font_get_opentype_feature_overrides", "_font_supported_feature_list",
						"_font_supported_variation_list"));
		_HASH_TO_NAMES.put(958337235L, java.util.Set.of("_font_set_antialiasing"));
		_HASH_TO_NAMES.put(3389420495L, java.util.Set.of("_font_get_antialiasing"));
		_HASH_TO_NAMES.put(1265174801L,
				java.util.Set.of("_font_set_disable_embedded_bitmaps", "_font_set_generate_mipmaps",
						"_font_set_multichannel_signed_distance_field", "_font_set_allow_system_fallback",
						"_font_set_force_autohinter", "_font_set_modulate_color_glyphs",
						"_font_set_keep_rounding_remainders", "_shaped_text_set_preserve_invalid",
						"_shaped_text_set_preserve_control", "_space_set_active", "_area_set_monitorable",
						"_area_set_ray_pickable", "_body_set_enable_continuous_collision_detection",
						"_body_set_omit_force_integration", "_body_set_ray_pickable", "_soft_body_set_ray_pickable",
						"_joint_disable_collisions_between_bodies", "_area_set_pickable", "_body_set_pickable"));
		_HASH_TO_NAMES.put(4155700596L,
				java.util.Set.of("_font_get_disable_embedded_bitmaps", "_font_get_generate_mipmaps",
						"_font_is_multichannel_signed_distance_field", "_font_is_allow_system_fallback",
						"_font_is_force_autohinter", "_font_is_modulate_color_glyphs",
						"_font_get_keep_rounding_remainders", "_shaped_text_get_preserve_invalid",
						"_shaped_text_get_preserve_control", "_shaped_text_is_ready", "_space_is_active",
						"_body_is_continuous_collision_detection_enabled", "_body_is_omitting_force_integration",
						"_joint_is_disabled_collisions_between_bodies"));
		_HASH_TO_NAMES.put(1029390307L, java.util.Set.of("_font_set_fixed_size_scale_mode"));
		_HASH_TO_NAMES.put(4113120379L, java.util.Set.of("_font_get_fixed_size_scale_mode"));
		_HASH_TO_NAMES.put(1520010864L, java.util.Set.of("_font_set_hinting"));
		_HASH_TO_NAMES.put(3971592737L, java.util.Set.of("_font_get_hinting"));
		_HASH_TO_NAMES.put(3830459669L, java.util.Set.of("_font_set_subpixel_positioning"));
		_HASH_TO_NAMES.put(2752233671L, java.util.Set.of("_font_get_subpixel_positioning"));
		_HASH_TO_NAMES.put(1794382983L,
				java.util.Set.of("_font_set_embolden", "_font_set_baseline_offset", "_font_set_oversampling",
						"_shape_set_custom_solver_bias", "_shape_set_margin", "_body_set_collision_priority",
						"_body_set_contacts_reported_depth_threshold", "_soft_body_set_total_mass",
						"_soft_body_set_linear_stiffness", "_soft_body_set_shrinking_factor",
						"_soft_body_set_pressure_coefficient", "_soft_body_set_damping_coefficient",
						"_soft_body_set_drag_coefficient", "_body_apply_torque_impulse", "_body_apply_torque",
						"_body_add_constant_torque", "_body_set_constant_torque"));
		_HASH_TO_NAMES.put(866169185L,
				java.util.Set.of("_font_get_embolden", "_font_get_baseline_offset", "_font_get_oversampling",
						"_shaped_text_get_ascent", "_shaped_text_get_descent", "_shaped_text_get_width",
						"_shaped_text_get_underline_position", "_shaped_text_get_underline_thickness",
						"_shape_get_margin", "_shape_get_custom_solver_bias", "_body_get_collision_priority",
						"_body_get_contacts_reported_depth_threshold", "_soft_body_get_total_mass",
						"_soft_body_get_linear_stiffness", "_soft_body_get_shrinking_factor",
						"_soft_body_get_pressure_coefficient", "_soft_body_get_damping_coefficient",
						"_soft_body_get_drag_coefficient", "_body_get_constant_torque"));
		_HASH_TO_NAMES.put(1307259930L, java.util.Set.of("_font_set_spacing", "_shaped_text_set_spacing"));
		_HASH_TO_NAMES.put(1213653558L, java.util.Set.of("_font_get_spacing", "_shaped_text_get_spacing"));
		_HASH_TO_NAMES.put(1246044741L, java.util.Set.of("_font_set_transform", "_area_set_transform"));
		_HASH_TO_NAMES.put(213527486L, java.util.Set.of("_font_get_transform", "_area_get_transform"));
		_HASH_TO_NAMES.put(1217542888L,
				java.util.Set.of("_font_set_variation_coordinates", "_font_set_opentype_feature_overrides"));
		_HASH_TO_NAMES.put(2684255073L, java.util.Set.of("_font_get_size_cache_list", "_font_get_size_cache_info",
				"_shaped_text_get_objects", "_body_get_collision_exceptions", "_soft_body_get_collision_exceptions"));
		_HASH_TO_NAMES.put(2450610377L,
				java.util.Set.of("_font_remove_size_cache", "_font_clear_textures", "_font_clear_glyphs"));
		_HASH_TO_NAMES.put(1892459533L, java.util.Set.of("_font_set_ascent", "_font_set_descent",
				"_font_set_underline_position", "_font_set_underline_thickness", "_font_set_scale"));
		_HASH_TO_NAMES.put(755457166L, java.util.Set.of("_font_get_ascent", "_font_get_descent",
				"_font_get_underline_position", "_font_get_underline_thickness", "_font_get_scale"));
		_HASH_TO_NAMES.put(1311001310L, java.util.Set.of("_font_get_texture_count"));
		_HASH_TO_NAMES.put(3810512262L,
				java.util.Set.of("_font_remove_texture", "_font_remove_glyph", "_font_render_glyph"));
		_HASH_TO_NAMES.put(2354485091L, java.util.Set.of("_font_set_texture_image"));
		_HASH_TO_NAMES.put(2451761155L, java.util.Set.of("_font_get_texture_image"));
		_HASH_TO_NAMES.put(3005398047L, java.util.Set.of("_font_set_texture_offsets"));
		_HASH_TO_NAMES.put(3420028887L, java.util.Set.of("_font_get_texture_offsets"));
		_HASH_TO_NAMES.put(46086620L, java.util.Set.of("_font_get_glyph_list"));
		_HASH_TO_NAMES.put(2555689501L, java.util.Set.of("_font_get_glyph_advance"));
		_HASH_TO_NAMES.put(3219397315L, java.util.Set.of("_font_set_glyph_advance"));
		_HASH_TO_NAMES.put(513728628L,
				java.util.Set.of("_font_get_glyph_offset", "_font_get_glyph_size", "_font_get_glyph_texture_size"));
		_HASH_TO_NAMES.put(1812632090L, java.util.Set.of("_font_set_glyph_offset", "_font_set_glyph_size"));
		_HASH_TO_NAMES.put(2274268786L, java.util.Set.of("_font_get_glyph_uv_rect"));
		_HASH_TO_NAMES.put(1973324081L, java.util.Set.of("_font_set_glyph_uv_rect"));
		_HASH_TO_NAMES.put(4292800474L, java.util.Set.of("_font_get_glyph_texture_idx"));
		_HASH_TO_NAMES.put(4254580980L, java.util.Set.of("_font_set_glyph_texture_idx", "_font_render_range"));
		_HASH_TO_NAMES.put(1451696141L, java.util.Set.of("_font_get_glyph_texture_rid"));
		_HASH_TO_NAMES.put(2903964473L, java.util.Set.of("_font_get_glyph_contours"));
		_HASH_TO_NAMES.put(1778388067L, java.util.Set.of("_font_get_kerning_list"));
		_HASH_TO_NAMES.put(2141860016L, java.util.Set.of("_font_remove_kerning"));
		_HASH_TO_NAMES.put(3630965883L, java.util.Set.of("_font_set_kerning"));
		_HASH_TO_NAMES.put(1019980169L, java.util.Set.of("_font_get_kerning"));
		_HASH_TO_NAMES.put(1765635060L, java.util.Set.of("_font_get_glyph_index"));
		_HASH_TO_NAMES.put(2156738276L,
				java.util.Set.of("_font_get_char_from_glyph_index", "_shaped_text_get_dominant_direction_in_range"));
		_HASH_TO_NAMES.put(3120086654L, java.util.Set.of("_font_has_char", "_soft_body_is_point_pinned"));
		_HASH_TO_NAMES.put(788230395L,
				java.util.Set.of("_font_get_supported_glyphs", "_shaped_text_get_character_breaks"));
		_HASH_TO_NAMES.put(404525066L, java.util.Set.of("_font_draw_glyph"));
		_HASH_TO_NAMES.put(940535541L, java.util.Set.of("_font_draw_glyph_outline"));
		_HASH_TO_NAMES.put(3199320846L, java.util.Set.of("_font_is_language_supported", "_font_is_script_supported"));
		_HASH_TO_NAMES.put(2313957094L,
				java.util.Set.of("_font_set_language_support_override", "_font_set_script_support_override"));
		_HASH_TO_NAMES.put(2829184646L,
				java.util.Set.of("_font_get_language_support_override", "_font_get_script_support_override"));
		_HASH_TO_NAMES.put(2801473409L,
				java.util.Set.of("_font_get_language_support_overrides", "_font_get_script_support_overrides"));
		_HASH_TO_NAMES.put(3016396712L, java.util.Set.of("_get_hex_code_box_size"));
		_HASH_TO_NAMES.put(1602046441L, java.util.Set.of("_draw_hex_code_box"));
		_HASH_TO_NAMES.put(1431128392L, java.util.Set.of("_create_shaped_text"));
		_HASH_TO_NAMES.put(4276135416L, java.util.Set.of("_shaped_text_set_direction"));
		_HASH_TO_NAMES.put(3065904362L,
				java.util.Set.of("_shaped_text_get_direction", "_shaped_text_get_inferred_direction"));
		_HASH_TO_NAMES.put(684822712L, java.util.Set.of("_shaped_text_set_bidi_override"));
		_HASH_TO_NAMES.put(2306444742L, java.util.Set.of("_shaped_text_set_orientation"));
		_HASH_TO_NAMES.put(3142708106L, java.util.Set.of("_shaped_text_get_orientation"));
		_HASH_TO_NAMES.put(875249313L, java.util.Set.of("_shaped_text_add_string"));
		_HASH_TO_NAMES.put(2452224230L, java.util.Set.of("_shaped_text_add_object"));
		_HASH_TO_NAMES.put(2747466775L, java.util.Set.of("_shaped_text_resize_object"));
		_HASH_TO_NAMES.put(2360964694L, java.util.Set.of("_shaped_text_has_object"));
		_HASH_TO_NAMES.put(4069510997L, java.util.Set.of("_shaped_get_span_meta", "_shaped_get_span_embedded_object",
				"_shaped_get_span_object", "_shaped_get_run_object"));
		_HASH_TO_NAMES.put(1464764419L,
				java.util.Set.of("_shaped_get_span_text", "_shaped_get_run_text", "_shaped_get_run_language"));
		_HASH_TO_NAMES.put(2569459151L, java.util.Set.of("_shaped_set_span_update_font"));
		_HASH_TO_NAMES.put(4069534484L, java.util.Set.of("_shaped_get_run_range", "_shaped_get_run_glyph_range"));
		_HASH_TO_NAMES.put(1066463050L,
				java.util.Set.of("_shaped_get_run_font_rid", "_area_get_shape", "_body_get_shape"));
		_HASH_TO_NAMES.put(1120910005L,
				java.util.Set.of("_shaped_get_run_font_size", "_shaped_text_next_grapheme_pos",
						"_shaped_text_prev_grapheme_pos", "_shaped_text_next_character_pos",
						"_shaped_text_prev_character_pos", "_shaped_text_closest_character_pos"));
		_HASH_TO_NAMES.put(2413896864L, java.util.Set.of("_shaped_get_run_direction"));
		_HASH_TO_NAMES.put(1937682086L, java.util.Set.of("_shaped_text_substr"));
		_HASH_TO_NAMES.put(3814569979L, java.util.Set.of("_shaped_text_get_parent", "_area_get_space",
				"_body_get_space", "_soft_body_get_space"));
		_HASH_TO_NAMES.put(1426448222L, java.util.Set.of("_shaped_text_fit_to_width"));
		_HASH_TO_NAMES.put(1283669550L, java.util.Set.of("_shaped_text_tab_align"));
		_HASH_TO_NAMES.put(3917799429L, java.util.Set.of("_shaped_text_sort_logical"));
		_HASH_TO_NAMES.put(733700038L, java.util.Set.of("_shaped_text_get_range"));
		_HASH_TO_NAMES.put(1488467363L, java.util.Set.of("_shaped_text_get_line_breaks_adv"));
		_HASH_TO_NAMES.put(3131311977L, java.util.Set.of("_shaped_text_get_line_breaks"));
		_HASH_TO_NAMES.put(2423529412L, java.util.Set.of("_shaped_text_get_word_breaks"));
		_HASH_TO_NAMES.put(3364950921L, java.util.Set.of("_shaped_text_overrun_trim_to_width"));
		_HASH_TO_NAMES.put(447978354L, java.util.Set.of("_shaped_text_get_object_rect"));
		_HASH_TO_NAMES.put(2524675647L, java.util.Set.of("_shaped_text_get_object_range"));
		_HASH_TO_NAMES.put(1260085030L, java.util.Set.of("_shaped_text_get_object_glyph"));
		_HASH_TO_NAMES.put(2440833711L, java.util.Set.of("_shaped_text_get_size", "_body_get_constant_force"));
		_HASH_TO_NAMES.put(1191777527L, java.util.Set.of("_shaped_text_get_carets"));
		_HASH_TO_NAMES.put(3714187733L, java.util.Set.of("_shaped_text_get_selection"));
		_HASH_TO_NAMES.put(3149310417L,
				java.util.Set.of("_shaped_text_hit_test_grapheme", "_shaped_text_hit_test_position"));
		_HASH_TO_NAMES.put(2079930245L, java.util.Set.of("_shaped_text_draw"));
		_HASH_TO_NAMES.put(601976754L, java.util.Set.of("_shaped_text_draw_outline"));
		_HASH_TO_NAMES.put(2546185844L, java.util.Set.of("_shaped_text_get_grapheme_bounds"));
		_HASH_TO_NAMES.put(315676799L, java.util.Set.of("_format_number", "_parse_number", "_string_to_upper",
				"_string_to_lower", "_string_to_title"));
		_HASH_TO_NAMES.put(3135753539L, java.util.Set.of("_percent_sign", "_strip_diacritics", "_get_resource_type",
				"_get_resource_script_class", "_get_unsaved_status", "_validate_path"));
		_HASH_TO_NAMES.put(1116898809L, java.util.Set.of("_is_valid_letter"));
		_HASH_TO_NAMES.put(3658450588L, java.util.Set.of("_string_get_word_breaks"));
		_HASH_TO_NAMES.put(2509056759L, java.util.Set.of("_string_get_character_breaks"));
		_HASH_TO_NAMES.put(1433197768L, java.util.Set.of("_is_confusable"));
		_HASH_TO_NAMES.put(3310685015L, java.util.Set.of("_parse_structured_text"));
		_HASH_TO_NAMES.put(2549190337L, java.util.Set.of("_get_audio_speaker_mode"));
		_HASH_TO_NAMES.put(1866453460L, java.util.Set.of("_write_begin"));
		_HASH_TO_NAMES.put(2784607037L, java.util.Set.of("_write_frame"));
		_HASH_TO_NAMES.put(3093715447L, java.util.Set.of("_instantiate_playback"));
		_HASH_TO_NAMES.put(3102165223L, java.util.Set.of("_get_tags", "_get_child_nodes", "_get_system_info",
				"_get_state", "_get_constants", "_get_public_constants"));
		_HASH_TO_NAMES.put(912931771L, java.util.Set.of("_process_animation_node"));
		_HASH_TO_NAMES.put(4015028928L, java.util.Set.of("_popup_menu"));
		_HASH_TO_NAMES.put(625644256L, java.util.Set.of("_get_child_by_name"));
		_HASH_TO_NAMES.put(2619796661L, java.util.Set.of("_is_parameter_read_only", "_handles_type", "_has_method",
				"_has_static_method", "_has_script_signal", "_has_property_default_value"));
		_HASH_TO_NAMES.put(2139827523L, java.util.Set.of("_process"));
		_HASH_TO_NAMES.put(3811255416L, java.util.Set.of("_get_internal_option_visibility"));
		_HASH_TO_NAMES.put(3957349696L, java.util.Set.of("_get_internal_option_update_view_required"));
		_HASH_TO_NAMES.put(3641982463L, java.util.Set.of("_internal_process"));
		_HASH_TO_NAMES.put(83702148L,
				java.util.Set.of("_get_import_options", "_stage_file", "_unstage_file", "_discard_file", "_commit",
						"_create_branch", "_remove_branch", "_remove_remote", "_pull", "_fetch", "_set_source_code"));
		_HASH_TO_NAMES.put(298836892L, java.util.Set.of("_get_option_visibility"));
		_HASH_TO_NAMES.put(1078189570L, java.util.Set.of("_pre_process", "_post_process"));
		_HASH_TO_NAMES.put(1868713439L, java.util.Set.of("_get_handle_name"));
		_HASH_TO_NAMES.put(361316320L, java.util.Set.of("_is_handle_highlighted"));
		_HASH_TO_NAMES.put(2144196525L, java.util.Set.of("_get_handle_value"));
		_HASH_TO_NAMES.put(300928843L, java.util.Set.of("_begin_handle_action", "_disconnect_peer"));
		_HASH_TO_NAMES.put(2210262157L, java.util.Set.of("_set_handle"));
		_HASH_TO_NAMES.put(3655739840L, java.util.Set.of("_commit_handle"));
		_HASH_TO_NAMES.put(2055005479L, java.util.Set.of("_subgizmos_intersect_ray"));
		_HASH_TO_NAMES.put(1653813165L, java.util.Set.of("_subgizmos_intersect_frustum"));
		_HASH_TO_NAMES.put(3616898986L, java.util.Set.of("_set_subgizmo_transform"));
		_HASH_TO_NAMES.put(1965739696L, java.util.Set.of("_get_subgizmo_transform"));
		_HASH_TO_NAMES.put(3411059856L, java.util.Set.of("_commit_subgizmos"));
		_HASH_TO_NAMES.put(2115431945L, java.util.Set.of("_get_packet_script", "_get_ip_modification"));
		_HASH_TO_NAMES.put(680677267L, java.util.Set.of("_put_packet_script"));
		_HASH_TO_NAMES.put(3369852622L, java.util.Set.of("_get_packet_mode", "_get_transfer_mode"));
		_HASH_TO_NAMES.put(950411049L, java.util.Set.of("_set_transfer_mode"));
		_HASH_TO_NAMES.put(2147374275L, java.util.Set.of("_get_connection_status"));
		_HASH_TO_NAMES.put(330693286L, java.util.Set.of("_physics_process", "_process"));
		_HASH_TO_NAMES.put(1530502735L, java.util.Set.of("_set_vertex", "_set_normal"));
		_HASH_TO_NAMES.put(259215842L, java.util.Set.of("_set_aabb"));
		_HASH_TO_NAMES.put(3072623270L, java.util.Set.of("_configure"));
		_HASH_TO_NAMES.put(2002593661L,
				java.util.Set.of("_get_name", "_get_global_name", "_get_instance_base_type", "_get_doc_class_name"));
		_HASH_TO_NAMES.put(2693703033L, java.util.Set.of("_supports_play_area_mode", "_set_play_area_mode"));
		_HASH_TO_NAMES.put(1615132885L, java.util.Set.of("_get_play_area_mode"));
		_HASH_TO_NAMES.put(497664490L, java.util.Set.of("_get_play_area"));
		_HASH_TO_NAMES.put(1497962370L, java.util.Set.of("_get_render_target_size"));
		_HASH_TO_NAMES.put(4183770049L, java.util.Set.of("_get_camera_transform"));
		_HASH_TO_NAMES.put(518934792L, java.util.Set.of("_get_transform_for_view"));
		_HASH_TO_NAMES.put(4067457445L, java.util.Set.of("_get_projection_for_view"));
		_HASH_TO_NAMES.put(1500923256L, java.util.Set.of("_get_vrs_texture_format"));
		_HASH_TO_NAMES.put(1378122625L, java.util.Set.of("_post_draw_viewport"));
		_HASH_TO_NAMES.put(1761182771L, java.util.Set.of("_get_suggested_pose_names"));
		_HASH_TO_NAMES.put(167423259L, java.util.Set.of("_get_tracking_status"));
		_HASH_TO_NAMES.put(3752640163L, java.util.Set.of("_trigger_haptic_pulse"));
		_HASH_TO_NAMES.put(1905827158L, java.util.Set.of("_has_gizmo"));
		_HASH_TO_NAMES.put(1418965287L, java.util.Set.of("_create_gizmo"));
		_HASH_TO_NAMES.put(173330131L, java.util.Set.of("_redraw"));
		_HASH_TO_NAMES.put(3888674840L, java.util.Set.of("_get_handle_name"));
		_HASH_TO_NAMES.put(2665780718L, java.util.Set.of("_is_handle_highlighted"));
		_HASH_TO_NAMES.put(2887724832L, java.util.Set.of("_get_handle_value"));
		_HASH_TO_NAMES.put(3363704593L, java.util.Set.of("_begin_handle_action"));
		_HASH_TO_NAMES.put(1249646868L, java.util.Set.of("_set_handle"));
		_HASH_TO_NAMES.put(1939863962L, java.util.Set.of("_commit_handle"));
		_HASH_TO_NAMES.put(1781916302L, java.util.Set.of("_subgizmos_intersect_ray"));
		_HASH_TO_NAMES.put(3514748524L, java.util.Set.of("_subgizmos_intersect_frustum"));
		_HASH_TO_NAMES.put(3700343508L, java.util.Set.of("_get_subgizmo_transform"));
		_HASH_TO_NAMES.put(2435388792L, java.util.Set.of("_set_subgizmo_transform"));
		_HASH_TO_NAMES.put(2282018236L, java.util.Set.of("_commit_subgizmos"));
		_HASH_TO_NAMES.put(2926744397L, java.util.Set.of("_skeleton_changed"));
		_HASH_TO_NAMES.put(2840492092L, java.util.Set.of("_intersect_ray"));
		_HASH_TO_NAMES.put(522407812L, java.util.Set.of("_intersect_point"));
		_HASH_TO_NAMES.put(1584897015L, java.util.Set.of("_intersect_shape"));
		_HASH_TO_NAMES.put(1410701151L, java.util.Set.of("_cast_motion"));
		_HASH_TO_NAMES.put(871510130L, java.util.Set.of("_collide_shape"));
		_HASH_TO_NAMES.put(772675997L, java.util.Set.of("_rest_info"));
		_HASH_TO_NAMES.put(255939159L, java.util.Set.of("_generate"));
		_HASH_TO_NAMES.put(1601192835L, java.util.Set.of("_generate_from_path"));
		_HASH_TO_NAMES.put(1336744649L, java.util.Set.of("_set_credentials"));
		_HASH_TO_NAMES.put(1366379175L, java.util.Set.of("_get_diff"));
		_HASH_TO_NAMES.put(2841200299L,
				java.util.Set.of("_get_vcs_name", "_get_current_branch_name", "_get_image_file_extension"));
		_HASH_TO_NAMES.put(1171824711L, java.util.Set.of("_get_previous_commits"));
		_HASH_TO_NAMES.put(3186203200L, java.util.Set.of("_create_remote"));
		_HASH_TO_NAMES.put(2678287736L, java.util.Set.of("_push", "_log_message"));
		_HASH_TO_NAMES.put(2796572089L, java.util.Set.of("_get_line_diff"));
		_HASH_TO_NAMES.put(2607901833L, java.util.Set.of("_capture"));
		_HASH_TO_NAMES.put(1208513123L, java.util.Set.of("_goto_script_line"));
		_HASH_TO_NAMES.put(2338735218L, java.util.Set.of("_breakpoint_set_in_tree"));
		_HASH_TO_NAMES.put(1287173294L, java.util.Set.of("_get_return_icon_type"));
		_HASH_TO_NAMES.put(4102573379L, java.util.Set.of("_get_input_port_type", "_get_output_port_type"));
		_HASH_TO_NAMES.put(4227898402L, java.util.Set.of("_get_input_port_default_value"));
		_HASH_TO_NAMES.put(1894493699L, java.util.Set.of("_get_default_input_port"));
		_HASH_TO_NAMES.put(647634434L, java.util.Set.of("_get_property_options"));
		_HASH_TO_NAMES.put(4287175357L, java.util.Set.of("_get_code"));
		_HASH_TO_NAMES.put(1924221678L, java.util.Set.of("_get_func_code"));
		_HASH_TO_NAMES.put(3956542358L, java.util.Set.of("_get_global_code"));
		_HASH_TO_NAMES.put(1932120545L, java.util.Set.of("_is_available"));
		_HASH_TO_NAMES.put(31984339L, java.util.Set.of("_process_custom_fx"));
		_HASH_TO_NAMES.put(3392948163L, java.util.Set.of("_get_shader_mode"));
		_HASH_TO_NAMES.put(520498173L, java.util.Set.of("_get_import_options"));
		_HASH_TO_NAMES.put(240466755L, java.util.Set.of("_get_option_visibility"));
		_HASH_TO_NAMES.put(4108152118L, java.util.Set.of("_import"));
		_HASH_TO_NAMES.put(3937882851L, java.util.Set.of("_handle_unicode_input"));
		_HASH_TO_NAMES.put(3175752987L, java.util.Set.of("_shape_set_data"));
		_HASH_TO_NAMES.put(3418923367L, java.util.Set.of("_shape_get_type"));
		_HASH_TO_NAMES.put(4171304767L, java.util.Set.of("_shape_get_data"));
		_HASH_TO_NAMES.put(2406017470L, java.util.Set.of("_space_set_param"));
		_HASH_TO_NAMES.put(1523206731L, java.util.Set.of("_space_get_param"));
		_HASH_TO_NAMES.put(2048616813L, java.util.Set.of("_space_get_direct_state"));
		_HASH_TO_NAMES.put(808965560L, java.util.Set.of("_space_get_contacts"));
		_HASH_TO_NAMES.put(395945892L, java.util.Set.of("_area_set_space", "_body_set_space",
				"_body_add_collision_exception", "_body_remove_collision_exception", "_soft_body_set_space",
				"_soft_body_add_collision_exception", "_soft_body_remove_collision_exception", "_soft_body_set_mesh"));
		_HASH_TO_NAMES.put(2153848567L, java.util.Set.of("_area_add_shape", "_body_add_shape"));
		_HASH_TO_NAMES.put(2310537182L, java.util.Set.of("_area_set_shape", "_body_set_shape"));
		_HASH_TO_NAMES.put(675327471L, java.util.Set.of("_area_set_shape_transform", "_body_set_shape_transform"));
		_HASH_TO_NAMES.put(2658558584L,
				java.util.Set.of("_area_set_shape_disabled", "_body_set_shape_disabled", "_soft_body_pin_point"));
		_HASH_TO_NAMES.put(1050775521L, java.util.Set.of("_area_get_shape_transform", "_body_get_shape_transform"));
		_HASH_TO_NAMES.put(2980114638L, java.util.Set.of("_area_set_param"));
		_HASH_TO_NAMES.put(3935195649L, java.util.Set.of("_area_set_transform", "_soft_body_set_transform"));
		_HASH_TO_NAMES.put(890056067L, java.util.Set.of("_area_get_param"));
		_HASH_TO_NAMES.put(1128465797L, java.util.Set.of("_area_get_transform"));
		_HASH_TO_NAMES.put(3379118538L, java.util.Set.of("_area_set_monitor_callback",
				"_area_set_area_monitor_callback", "_body_set_state_sync_callback"));
		_HASH_TO_NAMES.put(606803466L, java.util.Set.of("_body_set_mode"));
		_HASH_TO_NAMES.put(2488819728L, java.util.Set.of("_body_get_mode"));
		_HASH_TO_NAMES.put(910941953L, java.util.Set.of("_body_set_param"));
		_HASH_TO_NAMES.put(3385027841L, java.util.Set.of("_body_get_param"));
		_HASH_TO_NAMES.put(599977762L, java.util.Set.of("_body_set_state", "_soft_body_set_state"));
		_HASH_TO_NAMES.put(1850449534L, java.util.Set.of("_body_get_state", "_soft_body_get_state"));
		_HASH_TO_NAMES.put(3227306858L,
				java.util.Set.of("_body_apply_central_impulse", "_body_apply_torque_impulse",
						"_body_apply_central_force", "_body_apply_torque", "_body_add_constant_central_force",
						"_body_add_constant_torque", "_body_set_constant_force", "_body_set_constant_torque",
						"_body_set_axis_velocity", "_soft_body_apply_central_impulse", "_soft_body_apply_central_force",
						"_pin_joint_set_local_a", "_pin_joint_set_local_b"));
		_HASH_TO_NAMES.put(3214966418L,
				java.util.Set.of("_body_apply_impulse", "_body_apply_force", "_body_add_constant_force"));
		_HASH_TO_NAMES.put(531438156L, java.util.Set.of("_body_get_constant_force", "_body_get_constant_torque",
				"_pin_joint_get_local_a", "_pin_joint_get_local_b"));
		_HASH_TO_NAMES.put(2020836892L, java.util.Set.of("_body_set_axis_lock"));
		_HASH_TO_NAMES.put(587853580L, java.util.Set.of("_body_is_axis_locked"));
		_HASH_TO_NAMES.put(2828036238L, java.util.Set.of("_body_set_force_integration_callback"));
		_HASH_TO_NAMES.put(3627463434L, java.util.Set.of("_body_test_motion"));
		_HASH_TO_NAMES.put(3029727957L, java.util.Set.of("_body_get_direct_state"));
		_HASH_TO_NAMES.put(2218179753L, java.util.Set.of("_soft_body_update_rendering_server"));
		_HASH_TO_NAMES.put(974181306L, java.util.Set.of("_soft_body_get_bounds"));
		_HASH_TO_NAMES.put(831953689L, java.util.Set.of("_soft_body_move_point", "_soft_body_apply_point_impulse",
				"_soft_body_apply_point_force"));
		_HASH_TO_NAMES.put(3440143363L, java.util.Set.of("_soft_body_get_point_global_position"));
		_HASH_TO_NAMES.put(4280171926L, java.util.Set.of("_joint_make_pin"));
		_HASH_TO_NAMES.put(810685294L, java.util.Set.of("_pin_joint_set_param"));
		_HASH_TO_NAMES.put(2817972347L, java.util.Set.of("_pin_joint_get_param"));
		_HASH_TO_NAMES.put(1684107643L, java.util.Set.of("_joint_make_hinge", "_joint_make_slider",
				"_joint_make_cone_twist", "_joint_make_generic_6dof"));
		_HASH_TO_NAMES.put(4069547571L, java.util.Set.of("_joint_make_hinge_simple"));
		_HASH_TO_NAMES.put(3165502333L, java.util.Set.of("_hinge_joint_set_param"));
		_HASH_TO_NAMES.put(2129207581L, java.util.Set.of("_hinge_joint_get_param"));
		_HASH_TO_NAMES.put(1601626188L, java.util.Set.of("_hinge_joint_set_flag"));
		_HASH_TO_NAMES.put(4165147865L, java.util.Set.of("_hinge_joint_get_flag"));
		_HASH_TO_NAMES.put(2264833593L, java.util.Set.of("_slider_joint_set_param"));
		_HASH_TO_NAMES.put(3498644957L, java.util.Set.of("_slider_joint_get_param"));
		_HASH_TO_NAMES.put(808587618L, java.util.Set.of("_cone_twist_joint_set_param"));
		_HASH_TO_NAMES.put(1134789658L, java.util.Set.of("_cone_twist_joint_get_param"));
		_HASH_TO_NAMES.put(2600081391L, java.util.Set.of("_generic_6dof_joint_set_param"));
		_HASH_TO_NAMES.put(467122058L, java.util.Set.of("_generic_6dof_joint_get_param"));
		_HASH_TO_NAMES.put(3570926903L, java.util.Set.of("_generic_6dof_joint_set_flag"));
		_HASH_TO_NAMES.put(4158090196L, java.util.Set.of("_generic_6dof_joint_get_flag"));
		_HASH_TO_NAMES.put(4290791900L, java.util.Set.of("_joint_get_type"));
		_HASH_TO_NAMES.put(1332958745L, java.util.Set.of("_get_process_info"));
		_HASH_TO_NAMES.put(3229777777L, java.util.Set.of("_get_cam_transform", "_get_transform"));
		_HASH_TO_NAMES.put(2910717950L, java.util.Set.of("_get_cam_projection"));
		_HASH_TO_NAMES.put(711720468L,
				java.util.Set.of("_get_view_eye_offset", "_get_contact_local_position", "_get_contact_local_normal",
						"_get_contact_impulse", "_get_contact_local_velocity_at_position",
						"_get_contact_collider_position", "_get_contact_collider_velocity_at_position"));
		_HASH_TO_NAMES.put(3179846605L, java.util.Set.of("_get_view_projection"));
		_HASH_TO_NAMES.put(93366828L, java.util.Set.of("_draw_port"));
		_HASH_TO_NAMES.put(1779768129L, java.util.Set.of("_is_in_input_hotzone", "_is_in_output_hotzone"));
		_HASH_TO_NAMES.put(3932192302L, java.util.Set.of("_get_connection_line"));
		_HASH_TO_NAMES.put(4216241294L, java.util.Set.of("_is_node_hover_valid"));
		_HASH_TO_NAMES.put(412946943L, java.util.Set.of("_import_preflight"));
		_HASH_TO_NAMES.put(2067053794L, java.util.Set.of("_parse_node_extensions"));
		_HASH_TO_NAMES.put(3201673288L, java.util.Set.of("_parse_image_data"));
		_HASH_TO_NAMES.put(1624327185L, java.util.Set.of("_parse_texture_json"));
		_HASH_TO_NAMES.put(1446147484L, java.util.Set.of("_import_object_model_property"));
		_HASH_TO_NAMES.put(1704600462L,
				java.util.Set.of("_import_post_parse", "_import_pre_generate", "_export_preserialize", "_export_post"));
		_HASH_TO_NAMES.put(3810899026L, java.util.Set.of("_generate_scene_node"));
		_HASH_TO_NAMES.put(4064279746L, java.util.Set.of("_import_node", "_export_node"));
		_HASH_TO_NAMES.put(295478427L, java.util.Set.of("_import_post", "_export_preflight", "_export_post_convert"));
		_HASH_TO_NAMES.put(147612932L, java.util.Set.of("_convert_scene_node"));
		_HASH_TO_NAMES.put(4111022730L, java.util.Set.of("_export_object_model_property"));
		_HASH_TO_NAMES.put(276886664L, java.util.Set.of("_serialize_image_to_bytes"));
		_HASH_TO_NAMES.put(1844337242L, java.util.Set.of("_save_image_at_path"));
		_HASH_TO_NAMES.put(2565166506L, java.util.Set.of("_serialize_texture_json"));
		_HASH_TO_NAMES.put(3085491603L, java.util.Set.of("_estimate_cost", "_compute_cost"));
		_HASH_TO_NAMES.put(3749238728L, java.util.Set.of("_import_scene"));
		_HASH_TO_NAMES.put(2594487047L, java.util.Set.of("_recognize_path"));
		_HASH_TO_NAMES.put(6257701L, java.util.Set.of("_get_dependencies"));
		_HASH_TO_NAMES.put(223715120L, java.util.Set.of("_rename_dependencies"));
		_HASH_TO_NAMES.put(2885906527L, java.util.Set.of("_load"));
		_HASH_TO_NAMES.put(2560709669L, java.util.Set.of("_filter_code_completion_candidates"));
		_HASH_TO_NAMES.put(1576865988L, java.util.Set.of("_parse_file"));
		_HASH_TO_NAMES.put(3655284255L, java.util.Set.of("_get_layer_data"));
		_HASH_TO_NAMES.put(3715736492L, java.util.Set.of("_use_tile_data_runtime_update"));
		_HASH_TO_NAMES.put(1627322126L, java.util.Set.of("_tile_data_runtime_update"));
		_HASH_TO_NAMES.put(3156113851L, java.util.Set.of("_update_cells", "_reload_scripts"));
		_HASH_TO_NAMES.put(134930648L, java.util.Set.of("_post_import"));
		_HASH_TO_NAMES.put(3907307132L, java.util.Set.of("_setup_modification"));
		_HASH_TO_NAMES.put(1659796816L, java.util.Set.of("_instantiate"));
		_HASH_TO_NAMES.put(2022529123L, java.util.Set.of("_intersect_ray"));
		_HASH_TO_NAMES.put(3378904092L, java.util.Set.of("_intersect_point"));
		_HASH_TO_NAMES.put(728953575L, java.util.Set.of("_intersect_shape"));
		_HASH_TO_NAMES.put(2320624824L, java.util.Set.of("_cast_motion", "_collide_shape"));
		_HASH_TO_NAMES.put(856242757L, java.util.Set.of("_rest_info"));
		_HASH_TO_NAMES.put(2056183332L, java.util.Set.of("_get_closest_point_to_object_volume"));
		_HASH_TO_NAMES.put(1062211774L, java.util.Set.of("_forward_canvas_gui_input"));
		_HASH_TO_NAMES.put(1496901182L,
				java.util.Set.of("_forward_canvas_draw_over_viewport", "_forward_canvas_force_draw_over_viewport",
						"_forward_3d_draw_over_viewport", "_forward_3d_force_draw_over_viewport"));
		_HASH_TO_NAMES.put(1018736637L, java.util.Set.of("_forward_3d_gui_input"));
		_HASH_TO_NAMES.put(4155329257L, java.util.Set.of("_set_state"));
		_HASH_TO_NAMES.put(853519107L, java.util.Set.of("_set_window_layout", "_get_window_layout"));
		_HASH_TO_NAMES.put(3911848509L, java.util.Set.of("_run_scene"));
		_HASH_TO_NAMES.put(3694835298L, java.util.Set.of("_set_multiplayer_peer"));
		_HASH_TO_NAMES.put(3223692825L, java.util.Set.of("_get_multiplayer_peer"));
		_HASH_TO_NAMES.put(3673574758L, java.util.Set.of("_rpc"));
		_HASH_TO_NAMES.put(1171879464L, java.util.Set.of("_object_configuration_add", "_object_configuration_remove"));
		_HASH_TO_NAMES.put(294648086L, java.util.Set.of("_instantiate_playback"));
		_HASH_TO_NAMES.put(370287496L, java.util.Set.of("_integrate_forces"));
		_HASH_TO_NAMES.put(27079556L, java.util.Set.of("_log_error"));
		_HASH_TO_NAMES.put(1240598777L, java.util.Set.of("_shape_get_type"));
		_HASH_TO_NAMES.put(738864683L, java.util.Set.of("_shape_collide"));
		_HASH_TO_NAMES.put(949194586L, java.util.Set.of("_space_set_param"));
		_HASH_TO_NAMES.put(874111783L, java.util.Set.of("_space_get_param"));
		_HASH_TO_NAMES.put(3160173886L, java.util.Set.of("_space_get_direct_state"));
		_HASH_TO_NAMES.put(2222557395L, java.util.Set.of("_space_get_contacts"));
		_HASH_TO_NAMES.put(888317420L, java.util.Set.of("_area_add_shape", "_body_add_shape"));
		_HASH_TO_NAMES.put(736082694L, java.util.Set.of("_area_set_shape_transform", "_body_set_shape_transform"));
		_HASH_TO_NAMES.put(1324854622L, java.util.Set.of("_area_get_shape_transform", "_body_get_shape_transform"));
		_HASH_TO_NAMES.put(1257146028L, java.util.Set.of("_area_set_param"));
		_HASH_TO_NAMES.put(3047435120L, java.util.Set.of("_area_get_param"));
		_HASH_TO_NAMES.put(1658067650L, java.util.Set.of("_body_set_mode"));
		_HASH_TO_NAMES.put(3261702585L, java.util.Set.of("_body_get_mode"));
		_HASH_TO_NAMES.put(2556489974L, java.util.Set.of("_body_set_shape_as_one_way_collision"));
		_HASH_TO_NAMES.put(1882257015L, java.util.Set.of("_body_set_continuous_collision_detection_mode"));
		_HASH_TO_NAMES.put(2661282217L, java.util.Set.of("_body_get_continuous_collision_detection_mode"));
		_HASH_TO_NAMES.put(2715630609L, java.util.Set.of("_body_set_param"));
		_HASH_TO_NAMES.put(3208033526L, java.util.Set.of("_body_get_param"));
		_HASH_TO_NAMES.put(1706355209L, java.util.Set.of("_body_set_state"));
		_HASH_TO_NAMES.put(4036367961L, java.util.Set.of("_body_get_state"));
		_HASH_TO_NAMES.put(3201125042L, java.util.Set.of("_body_apply_central_impulse", "_body_apply_central_force",
				"_body_add_constant_central_force", "_body_set_constant_force", "_body_set_axis_velocity"));
		_HASH_TO_NAMES.put(2762675110L,
				java.util.Set.of("_body_apply_impulse", "_body_apply_force", "_body_add_constant_force"));
		_HASH_TO_NAMES.put(2131476465L, java.util.Set.of("_body_collide_shape"));
		_HASH_TO_NAMES.put(1191931871L, java.util.Set.of("_body_get_direct_state"));
		_HASH_TO_NAMES.put(104979818L, java.util.Set.of("_body_test_motion"));
		_HASH_TO_NAMES.put(3972556514L, java.util.Set.of("_joint_set_param"));
		_HASH_TO_NAMES.put(4016448949L, java.util.Set.of("_joint_get_param"));
		_HASH_TO_NAMES.put(2607799521L, java.util.Set.of("_joint_make_pin"));
		_HASH_TO_NAMES.put(438649616L, java.util.Set.of("_joint_make_groove"));
		_HASH_TO_NAMES.put(1276049561L, java.util.Set.of("_joint_make_damped_spring"));
		_HASH_TO_NAMES.put(3520002352L, java.util.Set.of("_pin_joint_set_flag"));
		_HASH_TO_NAMES.put(2647867364L, java.util.Set.of("_pin_joint_get_flag"));
		_HASH_TO_NAMES.put(550574241L, java.util.Set.of("_pin_joint_set_param"));
		_HASH_TO_NAMES.put(348281383L, java.util.Set.of("_pin_joint_get_param"));
		_HASH_TO_NAMES.put(220564071L, java.util.Set.of("_damped_spring_joint_set_param"));
		_HASH_TO_NAMES.put(2075871277L, java.util.Set.of("_damped_spring_joint_get_param"));
		_HASH_TO_NAMES.put(4262502231L, java.util.Set.of("_joint_get_type"));
		_HASH_TO_NAMES.put(576496006L, java.util.Set.of("_get_process_info"));
		_HASH_TO_NAMES.put(2793216201L, java.util.Set.of("_get_render_scene_buffers"));
		_HASH_TO_NAMES.put(1288715698L, java.util.Set.of("_get_render_scene_data"));
		_HASH_TO_NAMES.put(2310605070L, java.util.Set.of("_input_event"));
		_HASH_TO_NAMES.put(3533781844L, java.util.Set.of("_export_file"));
		_HASH_TO_NAMES.put(2765511433L, java.util.Set.of("_export_begin"));
		_HASH_TO_NAMES.put(1312023292L, java.util.Set.of("_begin_customize_resources", "_begin_customize_scenes"));
		_HASH_TO_NAMES.put(307917495L, java.util.Set.of("_customize_resource"));
		_HASH_TO_NAMES.put(498701822L, java.util.Set.of("_customize_scene"));
		_HASH_TO_NAMES.put(488349689L, java.util.Set.of("_get_export_options"));
		_HASH_TO_NAMES.put(2837326714L, java.util.Set.of("_get_export_options_overrides"));
		_HASH_TO_NAMES.put(1866233299L, java.util.Set.of("_should_update_export_options", "_supports_platform"));
		_HASH_TO_NAMES.put(3537301980L, java.util.Set.of("_get_export_option_visibility"));
		_HASH_TO_NAMES.put(3340251247L, java.util.Set.of("_get_export_option_warning"));
		_HASH_TO_NAMES.put(1057664154L, java.util.Set.of("_get_export_features", "_get_android_dependencies",
				"_get_android_dependencies_maven_repos", "_get_android_libraries"));
		_HASH_TO_NAMES.put(4013372917L, java.util.Set.of("_get_android_manifest_activity_element_contents",
				"_get_android_manifest_application_element_contents", "_get_android_manifest_element_contents"));
		_HASH_TO_NAMES.put(3304965187L, java.util.Set.of("_update_android_prebuilt_manifest"));
		_HASH_TO_NAMES.put(1847696837L, java.util.Set.of("_input_event"));
		_HASH_TO_NAMES.put(556197845L, java.util.Set.of("_has_point"));
		_HASH_TO_NAMES.put(1292548940L, java.util.Set.of("_structured_text_parser"));
		_HASH_TO_NAMES.put(3674420000L, java.util.Set.of("_get_tooltip"));
		_HASH_TO_NAMES.put(2233896889L, java.util.Set.of("_get_drag_data"));
		_HASH_TO_NAMES.put(2603004011L, java.util.Set.of("_can_drop_data"));
		_HASH_TO_NAMES.put(3699746064L, java.util.Set.of("_drop_data"));
		_HASH_TO_NAMES.put(1976279298L, java.util.Set.of("_make_custom_tooltip"));
		_HASH_TO_NAMES.put(2174079723L, java.util.Set.of("_get_accessibility_container_name"));
		_HASH_TO_NAMES.put(3360562783L,
				java.util.Set.of("_get_total_gravity", "_get_center_of_mass", "_get_center_of_mass_local",
						"_get_inverse_inertia", "_get_linear_velocity", "_get_angular_velocity", "_get_constant_force",
						"_get_constant_torque"));
		_HASH_TO_NAMES.put(2716978435L, java.util.Set.of("_get_principal_inertia_axes", "_get_inverse_inertia_tensor"));
		_HASH_TO_NAMES.put(3460891852L,
				java.util.Set.of("_set_linear_velocity", "_set_angular_velocity", "_apply_central_impulse",
						"_apply_torque_impulse", "_apply_central_force", "_apply_torque", "_add_constant_central_force",
						"_add_constant_torque", "_set_constant_force", "_set_constant_torque"));
		_HASH_TO_NAMES.put(2952846383L, java.util.Set.of("_set_transform"));
		_HASH_TO_NAMES.put(192990374L, java.util.Set.of("_get_velocity_at_local_position"));
		_HASH_TO_NAMES.put(1714681797L, java.util.Set.of("_apply_impulse", "_apply_force", "_add_constant_force"));
		_HASH_TO_NAMES.put(2069328350L, java.util.Set.of("_get_space_state"));
		_HASH_TO_NAMES.put(278624046L, java.util.Set.of("_get_base_script"));
		_HASH_TO_NAMES.put(3669307804L, java.util.Set.of("_inherits_script"));
		_HASH_TO_NAMES.put(1107568780L, java.util.Set.of("_instance_create", "_placeholder_instance_create"));
		_HASH_TO_NAMES.put(1413768114L, java.util.Set.of("_reload"));
		_HASH_TO_NAMES.put(4028089122L, java.util.Set.of("_get_method_info"));
		_HASH_TO_NAMES.put(3096237657L, java.util.Set.of("_get_language"));
		_HASH_TO_NAMES.put(2458036349L, java.util.Set.of("_get_member_line"));
		_HASH_TO_NAMES.put(1214101251L, java.util.Set.of("_get_rpc_config"));
		_HASH_TO_NAMES.put(2275710506L, java.util.Set.of("_get_connection_state"));
		_HASH_TO_NAMES.put(4262591401L, java.util.Set.of("_get_gathering_state"));
		_HASH_TO_NAMES.put(3342956226L, java.util.Set.of("_get_signaling_state"));
		_HASH_TO_NAMES.put(1494659981L, java.util.Set.of("_initialize"));
		_HASH_TO_NAMES.put(4111292546L, java.util.Set.of("_create_data_channel"));
		_HASH_TO_NAMES.put(852856452L, java.util.Set.of("_set_remote_description", "_set_local_description"));
		_HASH_TO_NAMES.put(3958950400L, java.util.Set.of("_add_ice_candidate"));
		_HASH_TO_NAMES.put(1970324172L, java.util.Set.of("_get_plural_message"));
		_HASH_TO_NAMES.put(3639719779L, java.util.Set.of("_get_message"));
		_HASH_TO_NAMES.put(298948178L,
				java.util.Set.of("_get_data", "_get_partial_data", "_put_data", "_put_partial_data"));
		_HASH_TO_NAMES.put(3583744548L, java.util.Set.of("_make_template"));
		_HASH_TO_NAMES.put(3147814860L, java.util.Set.of("_get_built_in_templates"));
		_HASH_TO_NAMES.put(1697887509L, java.util.Set.of("_validate"));
		_HASH_TO_NAMES.put(1981248198L, java.util.Set.of("_create_script"));
		_HASH_TO_NAMES.put(2878152881L, java.util.Set.of("_find_function"));
		_HASH_TO_NAMES.put(1243061914L, java.util.Set.of("_make_function"));
		_HASH_TO_NAMES.put(552845695L, java.util.Set.of("_open_in_external_editor"));
		_HASH_TO_NAMES.put(2969522789L, java.util.Set.of("_preferred_file_name_casing"));
		_HASH_TO_NAMES.put(950756616L, java.util.Set.of("_complete_code"));
		_HASH_TO_NAMES.put(3143837309L, java.util.Set.of("_lookup_code"));
		_HASH_TO_NAMES.put(2531480354L, java.util.Set.of("_auto_indent_code"));
		_HASH_TO_NAMES.put(3304788590L, java.util.Set.of("_remove_named_global_constant"));
		_HASH_TO_NAMES.put(335235777L,
				java.util.Set.of("_debug_get_stack_level_locals", "_debug_get_stack_level_members"));
		_HASH_TO_NAMES.put(4123630098L, java.util.Set.of("_debug_get_globals"));
		_HASH_TO_NAMES.put(1135811067L, java.util.Set.of("_debug_parse_stack_level_expression"));
		_HASH_TO_NAMES.put(1957307671L, java.util.Set.of("_reload_tool_script"));
		_HASH_TO_NAMES.put(2248993622L, java.util.Set.of("_get_global_class_name"));
		_HASH_TO_NAMES.put(1387456631L, java.util.Set.of("_get_preset_features", "_get_binary_extensions"));
		_HASH_TO_NAMES.put(969350244L, java.util.Set.of("_get_export_option_visibility"));
		_HASH_TO_NAMES.put(805886795L, java.util.Set.of("_get_export_option_warning"));
		_HASH_TO_NAMES.put(3536238170L, java.util.Set.of("_get_option_icon"));
		_HASH_TO_NAMES.put(1726914928L, java.util.Set.of("_run"));
		_HASH_TO_NAMES.put(493961987L, java.util.Set.of("_can_export", "_has_valid_export_configuration"));
		_HASH_TO_NAMES.put(3117166915L, java.util.Set.of("_has_valid_project_configuration"));
		_HASH_TO_NAMES.put(1328957260L, java.util.Set.of("_export_project", "_export_pack", "_export_zip"));
		_HASH_TO_NAMES.put(454765315L, java.util.Set.of("_export_pack_patch", "_export_zip_patch"));
		_HASH_TO_NAMES.put(3076455711L, java.util.Set.of("_save_layout_to_config"));
		_HASH_TO_NAMES.put(2838822993L, java.util.Set.of("_load_layout_from_config"));
		_HASH_TO_NAMES.put(2153177966L, java.util.Set.of("_estimate_cost", "_compute_cost"));
		_HASH_TO_NAMES.put(3957903770L, java.util.Set.of("_use_tile_data_runtime_update"));
		_HASH_TO_NAMES.put(4223434291L, java.util.Set.of("_tile_data_runtime_update"));
		_HASH_TO_NAMES.put(3789807118L, java.util.Set.of("_create"));
		_HASH_TO_NAMES.put(3089850668L, java.util.Set.of("_set_path_cache"));
		_HASH_TO_NAMES.put(2153422729L, java.util.Set.of("_render_callback"));
		_HASH_TO_NAMES.put(4100114520L, java.util.Set.of("_make_tooltip_for_path"));
	}
	/**
	 * Reverse lookup: compatibility hash → method names (unmodifiable). Used by
	 * get_virtual_func to find the method name from Godot's hash.
	 */
	public static final java.util.Map<Long, java.util.Set<String>> HASH_TO_NAMES = java.util.Collections
			.unmodifiableMap(_HASH_TO_NAMES);
}
