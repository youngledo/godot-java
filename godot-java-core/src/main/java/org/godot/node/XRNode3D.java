package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class XRNode3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_tracker", 3304788590L), java.util.Map.entry("get_pose", 2806551826L),
			java.util.Map.entry("set_pose_name", 3304788590L), java.util.Map.entry("get_pose_name", 2002593661L),
			java.util.Map.entry("trigger_haptic_pulse", 508576839L), java.util.Map.entry("get_is_active", 36873697L),
			java.util.Map.entry("set_show_when_tracked", 2586408642L),
			java.util.Map.entry("get_show_when_tracked", 36873697L),
			java.util.Map.entry("get_has_tracking_data", 36873697L), java.util.Map.entry("get_tracker", 2002593661L));

	XRNode3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRNode3D(long nativePointer) {
		super(nativePointer);
	}

	public void trigger_haptic_pulse(String action_name, double frequency, double amplitude, double duration_sec,
			double delay_sec) {
		super.call("trigger_haptic_pulse",
				new java.lang.Object[]{(java.lang.Object) action_name, java.lang.Double.valueOf(frequency),
						java.lang.Double.valueOf(amplitude), java.lang.Double.valueOf(duration_sec),
						java.lang.Double.valueOf(delay_sec)});
	}

	public String getTracker() {
		return (String) super.call("get_tracker", new java.lang.Object[0]);
	}

	public void setTracker(String value) {
		super.call("set_tracker", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getPose() {
		return (String) super.call("get_pose_name", new java.lang.Object[0]);
	}

	public void setPose(String value) {
		super.call("set_pose_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getShow_when_tracked() {
		return (boolean) super.call("get_show_when_tracked", new java.lang.Object[0]);
	}

	public void setShow_when_tracked(boolean value) {
		super.call("set_show_when_tracked", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
