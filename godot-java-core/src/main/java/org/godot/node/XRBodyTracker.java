package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;

public class XRBodyTracker extends XRPositionalTracker {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_joint_transform", 2635424328L),
			java.util.Map.entry("get_joint_transform", 3474811534L),
			java.util.Map.entry("set_has_tracking_data", 2586408642L),
			java.util.Map.entry("get_joint_flags", 1030162609L), java.util.Map.entry("set_body_flags", 2103235750L),
			java.util.Map.entry("get_body_flags", 3543166366L), java.util.Map.entry("set_joint_flags", 592144999L),
			java.util.Map.entry("get_has_tracking_data", 36873697L));

	XRBodyTracker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRBodyTracker(long nativePointer) {
		super(nativePointer);
	}

	public void set_joint_flags(int joint, int flags) {
		super.call("set_joint_flags",
				new java.lang.Object[]{java.lang.Integer.valueOf(joint), java.lang.Integer.valueOf(flags)});
	}

	public int get_joint_flags(int joint) {
		return (int) super.call("get_joint_flags", new java.lang.Object[]{java.lang.Integer.valueOf(joint)});
	}

	public void set_joint_transform(int joint, Transform3D transform) {
		super.call("set_joint_transform",
				new java.lang.Object[]{java.lang.Integer.valueOf(joint), (java.lang.Object) transform});
	}

	public Transform3D get_joint_transform(int joint) {
		return (Transform3D) super.call("get_joint_transform",
				new java.lang.Object[]{java.lang.Integer.valueOf(joint)});
	}

	public boolean getHas_tracking_data() {
		return (boolean) super.call("get_has_tracking_data", new java.lang.Object[0]);
	}

	public void setHas_tracking_data(boolean value) {
		super.call("set_has_tracking_data", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getBody_flags() {
		return (long) super.call("get_body_flags", new java.lang.Object[0]);
	}

	public void setBody_flags(long value) {
		super.call("set_body_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
