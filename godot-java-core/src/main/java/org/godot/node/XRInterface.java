package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;
import org.godot.math.Projection;
import org.godot.math.Transform3D;

public class XRInterface extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_play_area_mode", 3429955281L),
			java.util.Map.entry("get_environment_blend_mode", 1984334071L),
			java.util.Map.entry("get_camera_feed_id", 2455072627L), java.util.Map.entry("is_primary", 2240911060L),
			java.util.Map.entry("trigger_haptic_pulse", 3752640163L), java.util.Map.entry("uninitialize", 3218959716L),
			java.util.Map.entry("get_capabilities", 3905245786L),
			java.util.Map.entry("set_environment_blend_mode", 551152418L),
			java.util.Map.entry("start_passthrough", 2240911060L),
			java.util.Map.entry("get_render_target_size", 1497962370L),
			java.util.Map.entry("get_supported_environment_blend_modes", 2915620761L),
			java.util.Map.entry("get_name", 2002593661L), java.util.Map.entry("get_system_info", 2382534195L),
			java.util.Map.entry("set_anchor_detection_is_enabled", 2586408642L),
			java.util.Map.entry("set_primary", 2586408642L), java.util.Map.entry("get_play_area_mode", 1615132885L),
			java.util.Map.entry("get_tracking_status", 167423259L),
			java.util.Map.entry("is_passthrough_supported", 2240911060L),
			java.util.Map.entry("get_anchor_detection_is_enabled", 36873697L),
			java.util.Map.entry("get_view_count", 2455072627L),
			java.util.Map.entry("is_passthrough_enabled", 2240911060L),
			java.util.Map.entry("get_transform_for_view", 518934792L), java.util.Map.entry("get_play_area", 497664490L),
			java.util.Map.entry("is_initialized", 36873697L),
			java.util.Map.entry("supports_play_area_mode", 3429955281L),
			java.util.Map.entry("get_projection_for_view", 3766090294L), java.util.Map.entry("initialize", 2240911060L),
			java.util.Map.entry("stop_passthrough", 3218959716L));

	XRInterface(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRInterface(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_primary() {
		return (boolean) super.call("is_primary");
	}

	public boolean is_initialized() {
		return (boolean) super.call("is_initialized");
	}

	public boolean initialize() {
		return (boolean) super.call("initialize");
	}

	public void uninitialize() {
		super.call("uninitialize");
	}

	public void trigger_haptic_pulse(String action_name, String tracker_name, double frequency, double amplitude,
			double duration_sec, double delay_sec) {
		super.call("trigger_haptic_pulse",
				new java.lang.Object[]{(java.lang.Object) action_name, (java.lang.Object) tracker_name,
						java.lang.Double.valueOf(frequency), java.lang.Double.valueOf(amplitude),
						java.lang.Double.valueOf(duration_sec), java.lang.Double.valueOf(delay_sec)});
	}

	public boolean supports_play_area_mode(int mode) {
		return (boolean) super.call("supports_play_area_mode", new java.lang.Object[]{java.lang.Integer.valueOf(mode)});
	}

	public boolean is_passthrough_supported() {
		return (boolean) super.call("is_passthrough_supported");
	}

	public boolean is_passthrough_enabled() {
		return (boolean) super.call("is_passthrough_enabled");
	}

	public boolean start_passthrough() {
		return (boolean) super.call("start_passthrough");
	}

	public void stop_passthrough() {
		super.call("stop_passthrough");
	}

	public Transform3D get_transform_for_view(long view, Transform3D cam_transform) {
		return (Transform3D) super.call("get_transform_for_view",
				new java.lang.Object[]{java.lang.Long.valueOf(view), (java.lang.Object) cam_transform});
	}

	public Projection get_projection_for_view(long view, double aspect, double near, double far) {
		return (Projection) super.call("get_projection_for_view", new java.lang.Object[]{java.lang.Long.valueOf(view),
				java.lang.Double.valueOf(aspect), java.lang.Double.valueOf(near), java.lang.Double.valueOf(far)});
	}

	public boolean isInterface_is_primary() {
		return (boolean) super.call("is_primary", new java.lang.Object[0]);
	}

	public void setInterface_is_primary(boolean value) {
		super.call("set_primary", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getXr_play_area_mode() {
		return (long) super.call("get_play_area_mode", new java.lang.Object[0]);
	}

	public void setXr_play_area_mode(long value) {
		super.call("set_play_area_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getEnvironment_blend_mode() {
		return (long) super.call("get_environment_blend_mode", new java.lang.Object[0]);
	}

	public void setEnvironment_blend_mode(long value) {
		super.call("set_environment_blend_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getAr_is_anchor_detection_enabled() {
		return (boolean) super.call("get_anchor_detection_is_enabled", new java.lang.Object[0]);
	}

	public void setAr_is_anchor_detection_enabled(boolean value) {
		super.call("set_anchor_detection_is_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
