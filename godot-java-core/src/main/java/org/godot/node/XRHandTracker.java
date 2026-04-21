package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class XRHandTracker extends XRPositionalTracker {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_hand_joint_angular_velocity", 1978646737L),
			java.util.Map.entry("get_hand_joint_linear_velocity", 547240792L),
			java.util.Map.entry("set_hand_joint_flags", 3028437365L),
			java.util.Map.entry("set_hand_joint_radius", 2723659615L),
			java.util.Map.entry("set_hand_tracking_source", 2958308861L),
			java.util.Map.entry("get_hand_joint_flags", 1730972401L),
			java.util.Map.entry("get_hand_joint_angular_velocity", 547240792L),
			java.util.Map.entry("get_hand_joint_transform", 1090840196L),
			java.util.Map.entry("set_hand_joint_transform", 2529959613L),
			java.util.Map.entry("set_has_tracking_data", 2586408642L),
			java.util.Map.entry("get_hand_tracking_source", 2475045250L),
			java.util.Map.entry("set_hand_joint_linear_velocity", 1978646737L),
			java.util.Map.entry("get_hand_joint_radius", 3400025734L),
			java.util.Map.entry("get_has_tracking_data", 36873697L));

	XRHandTracker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRHandTracker(long nativePointer) {
		super(nativePointer);
	}

	public void set_hand_joint_flags(int joint, int flags) {
		super.call("set_hand_joint_flags",
				new java.lang.Object[]{java.lang.Integer.valueOf(joint), java.lang.Integer.valueOf(flags)});
	}

	public int get_hand_joint_flags(int joint) {
		return (int) super.call("get_hand_joint_flags", new java.lang.Object[]{java.lang.Integer.valueOf(joint)});
	}

	public void set_hand_joint_transform(int joint, Transform3D transform) {
		super.call("set_hand_joint_transform",
				new java.lang.Object[]{java.lang.Integer.valueOf(joint), (java.lang.Object) transform});
	}

	public Transform3D get_hand_joint_transform(int joint) {
		return (Transform3D) super.call("get_hand_joint_transform",
				new java.lang.Object[]{java.lang.Integer.valueOf(joint)});
	}

	public void set_hand_joint_radius(int joint, double radius) {
		super.call("set_hand_joint_radius",
				new java.lang.Object[]{java.lang.Integer.valueOf(joint), java.lang.Double.valueOf(radius)});
	}

	public double get_hand_joint_radius(int joint) {
		return (double) super.call("get_hand_joint_radius", new java.lang.Object[]{java.lang.Integer.valueOf(joint)});
	}

	public void set_hand_joint_linear_velocity(int joint, Vector3 linear_velocity) {
		super.call("set_hand_joint_linear_velocity",
				new java.lang.Object[]{java.lang.Integer.valueOf(joint), (java.lang.Object) linear_velocity});
	}

	public Vector3 get_hand_joint_linear_velocity(int joint) {
		return (Vector3) super.call("get_hand_joint_linear_velocity",
				new java.lang.Object[]{java.lang.Integer.valueOf(joint)});
	}

	public void set_hand_joint_angular_velocity(int joint, Vector3 angular_velocity) {
		super.call("set_hand_joint_angular_velocity",
				new java.lang.Object[]{java.lang.Integer.valueOf(joint), (java.lang.Object) angular_velocity});
	}

	public Vector3 get_hand_joint_angular_velocity(int joint) {
		return (Vector3) super.call("get_hand_joint_angular_velocity",
				new java.lang.Object[]{java.lang.Integer.valueOf(joint)});
	}

	public boolean getHas_tracking_data() {
		return (boolean) super.call("get_has_tracking_data", new java.lang.Object[0]);
	}

	public void setHas_tracking_data(boolean value) {
		super.call("set_has_tracking_data", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getHand_tracking_source() {
		return (long) super.call("get_hand_tracking_source", new java.lang.Object[0]);
	}

	public void setHand_tracking_source(long value) {
		super.call("set_hand_tracking_source", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
