package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class XRPose extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_tracking_confidence", 2064923680L),
			java.util.Map.entry("get_transform", 3229777777L),
			java.util.Map.entry("set_tracking_confidence", 4171656666L),
			java.util.Map.entry("get_angular_velocity", 3360562783L),
			java.util.Map.entry("set_linear_velocity", 3460891852L), java.util.Map.entry("set_name", 3304788590L),
			java.util.Map.entry("set_angular_velocity", 3460891852L),
			java.util.Map.entry("get_adjusted_transform", 3229777777L),
			java.util.Map.entry("set_has_tracking_data", 2586408642L),
			java.util.Map.entry("get_linear_velocity", 3360562783L), java.util.Map.entry("get_name", 2002593661L),
			java.util.Map.entry("set_transform", 2952846383L), java.util.Map.entry("get_has_tracking_data", 36873697L));

	XRPose(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRPose(long nativePointer) {
		super(nativePointer);
	}

	public boolean getHas_tracking_data() {
		return (boolean) super.call("get_has_tracking_data", new java.lang.Object[0]);
	}

	public void setHas_tracking_data(boolean value) {
		super.call("set_has_tracking_data", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getName() {
		return (String) super.call("get_name", new java.lang.Object[0]);
	}

	public void setName(String value) {
		super.call("set_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getTransform() {
		return (String) super.call("get_transform", new java.lang.Object[0]);
	}

	public void setTransform(String value) {
		super.call("set_transform", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getLinear_velocity() {
		return (String) super.call("get_linear_velocity", new java.lang.Object[0]);
	}

	public void setLinear_velocity(String value) {
		super.call("set_linear_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getAngular_velocity() {
		return (String) super.call("get_angular_velocity", new java.lang.Object[0]);
	}

	public void setAngular_velocity(String value) {
		super.call("set_angular_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getTracking_confidence() {
		return (long) super.call("get_tracking_confidence", new java.lang.Object[0]);
	}

	public void setTracking_confidence(long value) {
		super.call("set_tracking_confidence", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
