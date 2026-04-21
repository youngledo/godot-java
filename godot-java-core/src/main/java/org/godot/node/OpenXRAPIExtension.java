package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.core.RefCounted;
import org.godot.math.Transform3D;

public class OpenXRAPIExtension extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("begin_debug_label_region", 83702148L),
			java.util.Map.entry("insert_debug_label", 83702148L),
			java.util.Map.entry("set_custom_play_space", 1286410249L),
			java.util.Map.entry("get_predicted_display_time", 2455072627L),
			java.util.Map.entry("openxr_swapchain_release", 1286410249L),
			java.util.Map.entry("set_emulate_environment_blend_mode_alpha_blend", 2586408642L),
			java.util.Map.entry("find_action", 4106179378L), java.util.Map.entry("get_error_string", 990163283L),
			java.util.Map.entry("unregister_projection_views_extension", 1477360496L),
			java.util.Map.entry("get_render_state_z_near", 191475506L), java.util.Map.entry("get_session", 2455072627L),
			java.util.Map.entry("transform_from_pose", 2963875352L), java.util.Map.entry("get_play_space", 2455072627L),
			java.util.Map.entry("get_swapchain_format_name", 990163283L), java.util.Map.entry("xr_result", 3886436197L),
			java.util.Map.entry("openxr_swapchain_create", 2162228999L),
			java.util.Map.entry("register_projection_views_extension", 1477360496L),
			java.util.Map.entry("update_main_swapchain_size", 3218959716L),
			java.util.Map.entry("set_object_name", 2285447957L), java.util.Map.entry("set_render_region", 1763793166L),
			java.util.Map.entry("get_openxr_version", 2455072627L),
			java.util.Map.entry("openxr_swapchain_acquire", 1286410249L),
			java.util.Map.entry("get_hand_tracker", 3744713108L),
			java.util.Map.entry("openxr_swapchain_free", 1286410249L),
			java.util.Map.entry("set_velocity_texture", 2722037293L),
			java.util.Map.entry("is_environment_blend_mode_alpha_supported", 1579290861L),
			java.util.Map.entry("get_next_frame_time", 2455072627L),
			java.util.Map.entry("unregister_composition_layer_provider", 1477360496L),
			java.util.Map.entry("get_instance", 2455072627L),
			java.util.Map.entry("openxr_swapchain_get_swapchain", 3744713108L),
			java.util.Map.entry("register_frame_info_extension", 1477360496L),
			java.util.Map.entry("get_render_state_z_far", 191475506L),
			java.util.Map.entry("action_get_handle", 3917799429L),
			java.util.Map.entry("unregister_frame_info_extension", 1477360496L),
			java.util.Map.entry("set_velocity_depth_texture", 2722037293L),
			java.util.Map.entry("set_velocity_target_size", 1130785943L),
			java.util.Map.entry("openxr_is_enabled", 2703660260L), java.util.Map.entry("is_running", 2240911060L),
			java.util.Map.entry("register_composition_layer_provider", 1477360496L),
			java.util.Map.entry("get_supported_swapchain_formats", 3851388692L),
			java.util.Map.entry("is_initialized", 2240911060L), java.util.Map.entry("can_render", 2240911060L),
			java.util.Map.entry("openxr_swapchain_get_image", 937000113L),
			java.util.Map.entry("end_debug_label_region", 3218959716L),
			java.util.Map.entry("get_instance_proc_addr", 1597066294L),
			java.util.Map.entry("get_projection_layer", 2455072627L),
			java.util.Map.entry("get_system_id", 2455072627L));

	OpenXRAPIExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRAPIExtension(long nativePointer) {
		super(nativePointer);
	}

	public Transform3D transform_from_pose(Object pose) {
		return (Transform3D) super.call("transform_from_pose", new java.lang.Object[]{(java.lang.Object) pose});
	}

	public boolean xr_result(long result, String format, GodotArray args) {
		return (boolean) super.call("xr_result", new java.lang.Object[]{java.lang.Long.valueOf(result),
				(java.lang.Object) format, (java.lang.Object) args});
	}

	public boolean openxr_is_enabled(boolean check_run_in_editor) {
		return (boolean) super.call("openxr_is_enabled",
				new java.lang.Object[]{java.lang.Boolean.valueOf(check_run_in_editor)});
	}

	public java.math.BigInteger get_instance_proc_addr(String name) {
		return (java.math.BigInteger) super.call("get_instance_proc_addr",
				new java.lang.Object[]{(java.lang.Object) name});
	}

	public String get_error_string(long result) {
		return (String) super.call("get_error_string", new java.lang.Object[]{java.lang.Long.valueOf(result)});
	}

	public String get_swapchain_format_name(long swapchain_format) {
		return (String) super.call("get_swapchain_format_name",
				new java.lang.Object[]{java.lang.Long.valueOf(swapchain_format)});
	}

	public void set_object_name(long object_type, long object_handle, String object_name) {
		super.call("set_object_name", new java.lang.Object[]{java.lang.Long.valueOf(object_type),
				java.lang.Long.valueOf(object_handle), (java.lang.Object) object_name});
	}

	public void begin_debug_label_region(String label_name) {
		super.call("begin_debug_label_region", new java.lang.Object[]{(java.lang.Object) label_name});
	}

	public void end_debug_label_region() {
		super.call("end_debug_label_region");
	}

	public void insert_debug_label(String label_name) {
		super.call("insert_debug_label", new java.lang.Object[]{(java.lang.Object) label_name});
	}

	public boolean is_initialized() {
		return (boolean) super.call("is_initialized");
	}

	public boolean is_running() {
		return (boolean) super.call("is_running");
	}

	public boolean can_render() {
		return (boolean) super.call("can_render");
	}

	public long find_action(String name, long action_set) {
		return (long) super.call("find_action",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Long.valueOf(action_set)});
	}

	public java.math.BigInteger action_get_handle(long action) {
		return (java.math.BigInteger) super.call("action_get_handle",
				new java.lang.Object[]{java.lang.Long.valueOf(action)});
	}

	public java.math.BigInteger get_hand_tracker(long hand_index) {
		return (java.math.BigInteger) super.call("get_hand_tracker",
				new java.lang.Object[]{java.lang.Long.valueOf(hand_index)});
	}

	public void register_composition_layer_provider(OpenXRExtensionWrapper extension) {
		super.call("register_composition_layer_provider", new java.lang.Object[]{(java.lang.Object) extension});
	}

	public void unregister_composition_layer_provider(OpenXRExtensionWrapper extension) {
		super.call("unregister_composition_layer_provider", new java.lang.Object[]{(java.lang.Object) extension});
	}

	public void register_projection_views_extension(OpenXRExtensionWrapper extension) {
		super.call("register_projection_views_extension", new java.lang.Object[]{(java.lang.Object) extension});
	}

	public void unregister_projection_views_extension(OpenXRExtensionWrapper extension) {
		super.call("unregister_projection_views_extension", new java.lang.Object[]{(java.lang.Object) extension});
	}

	public void register_frame_info_extension(OpenXRExtensionWrapper extension) {
		super.call("register_frame_info_extension", new java.lang.Object[]{(java.lang.Object) extension});
	}

	public void unregister_frame_info_extension(OpenXRExtensionWrapper extension) {
		super.call("unregister_frame_info_extension", new java.lang.Object[]{(java.lang.Object) extension});
	}

	public java.math.BigInteger openxr_swapchain_create(long create_flags, long usage_flags, long swapchain_format,
			long width, long height, long sample_count, long array_size) {
		return (java.math.BigInteger) super.call("openxr_swapchain_create",
				new java.lang.Object[]{java.lang.Long.valueOf(create_flags), java.lang.Long.valueOf(usage_flags),
						java.lang.Long.valueOf(swapchain_format), java.lang.Long.valueOf(width),
						java.lang.Long.valueOf(height), java.lang.Long.valueOf(sample_count),
						java.lang.Long.valueOf(array_size)});
	}

	public void openxr_swapchain_free(long swapchain) {
		super.call("openxr_swapchain_free", new java.lang.Object[]{java.lang.Long.valueOf(swapchain)});
	}

	public java.math.BigInteger openxr_swapchain_get_swapchain(long swapchain) {
		return (java.math.BigInteger) super.call("openxr_swapchain_get_swapchain",
				new java.lang.Object[]{java.lang.Long.valueOf(swapchain)});
	}

	public void openxr_swapchain_acquire(long swapchain) {
		super.call("openxr_swapchain_acquire", new java.lang.Object[]{java.lang.Long.valueOf(swapchain)});
	}

	public long openxr_swapchain_get_image(long swapchain) {
		return (long) super.call("openxr_swapchain_get_image",
				new java.lang.Object[]{java.lang.Long.valueOf(swapchain)});
	}

	public void openxr_swapchain_release(long swapchain) {
		super.call("openxr_swapchain_release", new java.lang.Object[]{java.lang.Long.valueOf(swapchain)});
	}

	public int is_environment_blend_mode_alpha_supported() {
		return (int) super.call("is_environment_blend_mode_alpha_supported");
	}

	public void update_main_swapchain_size() {
		super.call("update_main_swapchain_size");
	}
}
