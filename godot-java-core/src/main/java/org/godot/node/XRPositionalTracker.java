package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class XRPositionalTracker extends XRTracker {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_pose", 3451230163L), java.util.Map.entry("set_input", 3776071444L),
			java.util.Map.entry("has_pose", 2619796661L), java.util.Map.entry("get_pose", 4099720006L),
			java.util.Map.entry("invalidate_pose", 3304788590L), java.util.Map.entry("set_tracker_profile", 83702148L),
			java.util.Map.entry("get_tracker_hand", 4181770860L), java.util.Map.entry("get_input", 2760726917L),
			java.util.Map.entry("get_tracker_profile", 201670096L),
			java.util.Map.entry("set_tracker_hand", 3904108980L));

	XRPositionalTracker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRPositionalTracker(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_pose(String name) {
		return (boolean) super.call("has_pose", new java.lang.Object[]{(java.lang.Object) name});
	}

	public XRPose get_pose(String name) {
		return (XRPose) super.call("get_pose", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void invalidate_pose(String name) {
		super.call("invalidate_pose", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void set_pose(String name, Transform3D transform, Vector3 linear_velocity, Vector3 angular_velocity,
			int tracking_confidence) {
		super.call("set_pose",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) transform,
						(java.lang.Object) linear_velocity, (java.lang.Object) angular_velocity,
						java.lang.Integer.valueOf(tracking_confidence)});
	}

	public Object get_input(String name) {
		return (Object) super.call("get_input", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void set_input(String name, Object value) {
		super.call("set_input", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) value});
	}

	public String getProfile() {
		return (String) super.call("get_tracker_profile", new java.lang.Object[0]);
	}

	public void setProfile(String value) {
		super.call("set_tracker_profile", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getHand() {
		return (long) super.call("get_tracker_hand", new java.lang.Object[0]);
	}

	public void setHand(long value) {
		super.call("set_tracker_hand", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
