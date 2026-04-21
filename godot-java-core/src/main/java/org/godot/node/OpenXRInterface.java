package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Quaternion;
import org.godot.math.Vector3;

public class OpenXRInterface extends XRInterface {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_hand_tracking_supported", 2240911060L),
			java.util.Map.entry("set_vrs_min_radius", 373806689L), java.util.Map.entry("set_gpu_level", 2940842095L),
			java.util.Map.entry("get_render_target_size_multiplier", 1740695150L),
			java.util.Map.entry("get_foveation_level", 3905245786L),
			java.util.Map.entry("get_hand_joint_angular_velocity", 3529194242L),
			java.util.Map.entry("set_motion_range", 855158159L),
			java.util.Map.entry("is_hand_interaction_supported", 36873697L),
			java.util.Map.entry("is_foveation_supported", 36873697L),
			java.util.Map.entry("get_vrs_strength", 1740695150L),
			java.util.Map.entry("get_available_display_refresh_rates", 3995934104L),
			java.util.Map.entry("set_cpu_level", 2940842095L),
			java.util.Map.entry("get_hand_joint_position", 3529194242L),
			java.util.Map.entry("get_hand_tracking_source", 4092421202L),
			java.util.Map.entry("get_motion_range", 3955838114L),
			java.util.Map.entry("is_eye_gaze_interaction_supported", 2240911060L),
			java.util.Map.entry("get_hand_joint_radius", 901522724L),
			java.util.Map.entry("set_vrs_strength", 373806689L), java.util.Map.entry("get_vrs_min_radius", 1740695150L),
			java.util.Map.entry("set_render_target_size_multiplier", 373806689L),
			java.util.Map.entry("get_hand_joint_linear_velocity", 3529194242L),
			java.util.Map.entry("get_foveation_dynamic", 36873697L),
			java.util.Map.entry("get_action_sets", 3995934104L),
			java.util.Map.entry("get_hand_joint_flags", 720567706L),
			java.util.Map.entry("get_session_state", 896364779L),
			java.util.Map.entry("set_display_refresh_rate", 373806689L),
			java.util.Map.entry("get_display_refresh_rate", 1740695150L),
			java.util.Map.entry("set_action_set_active", 2678287736L),
			java.util.Map.entry("set_foveation_level", 1286410249L),
			java.util.Map.entry("is_action_set_active", 3927539163L),
			java.util.Map.entry("set_foveation_dynamic", 2586408642L),
			java.util.Map.entry("get_hand_joint_rotation", 1974618321L));

	OpenXRInterface(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRInterface(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_foveation_supported() {
		return (boolean) super.call("is_foveation_supported");
	}

	public boolean is_action_set_active(String name) {
		return (boolean) super.call("is_action_set_active", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void set_action_set_active(String name, boolean active) {
		super.call("set_action_set_active",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Boolean.valueOf(active)});
	}

	public void set_motion_range(int hand, int motion_range) {
		super.call("set_motion_range",
				new java.lang.Object[]{java.lang.Integer.valueOf(hand), java.lang.Integer.valueOf(motion_range)});
	}

	public int get_motion_range(int hand) {
		return (int) super.call("get_motion_range", new java.lang.Object[]{java.lang.Integer.valueOf(hand)});
	}

	public int get_hand_tracking_source(int hand) {
		return (int) super.call("get_hand_tracking_source", new java.lang.Object[]{java.lang.Integer.valueOf(hand)});
	}

	public int get_hand_joint_flags(int hand, int joint) {
		return (int) super.call("get_hand_joint_flags",
				new java.lang.Object[]{java.lang.Integer.valueOf(hand), java.lang.Integer.valueOf(joint)});
	}

	public Quaternion get_hand_joint_rotation(int hand, int joint) {
		return (Quaternion) super.call("get_hand_joint_rotation",
				new java.lang.Object[]{java.lang.Integer.valueOf(hand), java.lang.Integer.valueOf(joint)});
	}

	public Vector3 get_hand_joint_position(int hand, int joint) {
		return (Vector3) super.call("get_hand_joint_position",
				new java.lang.Object[]{java.lang.Integer.valueOf(hand), java.lang.Integer.valueOf(joint)});
	}

	public double get_hand_joint_radius(int hand, int joint) {
		return (double) super.call("get_hand_joint_radius",
				new java.lang.Object[]{java.lang.Integer.valueOf(hand), java.lang.Integer.valueOf(joint)});
	}

	public Vector3 get_hand_joint_linear_velocity(int hand, int joint) {
		return (Vector3) super.call("get_hand_joint_linear_velocity",
				new java.lang.Object[]{java.lang.Integer.valueOf(hand), java.lang.Integer.valueOf(joint)});
	}

	public Vector3 get_hand_joint_angular_velocity(int hand, int joint) {
		return (Vector3) super.call("get_hand_joint_angular_velocity",
				new java.lang.Object[]{java.lang.Integer.valueOf(hand), java.lang.Integer.valueOf(joint)});
	}

	public boolean is_hand_tracking_supported() {
		return (boolean) super.call("is_hand_tracking_supported");
	}

	public boolean is_hand_interaction_supported() {
		return (boolean) super.call("is_hand_interaction_supported");
	}

	public boolean is_eye_gaze_interaction_supported() {
		return (boolean) super.call("is_eye_gaze_interaction_supported");
	}

	public double getDisplay_refresh_rate() {
		return (double) super.call("get_display_refresh_rate", new java.lang.Object[0]);
	}

	public void setDisplay_refresh_rate(double value) {
		super.call("set_display_refresh_rate", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRender_target_size_multiplier() {
		return (double) super.call("get_render_target_size_multiplier", new java.lang.Object[0]);
	}

	public void setRender_target_size_multiplier(double value) {
		super.call("set_render_target_size_multiplier", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getFoveation_level() {
		return (long) super.call("get_foveation_level", new java.lang.Object[0]);
	}

	public void setFoveation_level(long value) {
		super.call("set_foveation_level", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getFoveation_dynamic() {
		return (boolean) super.call("get_foveation_dynamic", new java.lang.Object[0]);
	}

	public void setFoveation_dynamic(boolean value) {
		super.call("set_foveation_dynamic", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getVrs_min_radius() {
		return (double) super.call("get_vrs_min_radius", new java.lang.Object[0]);
	}

	public void setVrs_min_radius(double value) {
		super.call("set_vrs_min_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVrs_strength() {
		return (double) super.call("get_vrs_strength", new java.lang.Object[0]);
	}

	public void setVrs_strength(double value) {
		super.call("set_vrs_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
