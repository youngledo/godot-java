package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class SkeletonIK3D extends SkeletonModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_target_transform", 3229777777L), java.util.Map.entry("get_root_bone", 2002593661L),
			java.util.Map.entry("get_parent_skeleton", 1488626673L),
			java.util.Map.entry("get_magnet_position", 3360562783L),
			java.util.Map.entry("set_target_transform", 2952846383L), java.util.Map.entry("start", 107499316L),
			java.util.Map.entry("set_target_node", 1348162250L),
			java.util.Map.entry("set_magnet_position", 3460891852L),
			java.util.Map.entry("set_interpolation", 373806689L),
			java.util.Map.entry("set_max_iterations", 1286410249L),
			java.util.Map.entry("get_interpolation", 1740695150L), java.util.Map.entry("get_tip_bone", 2002593661L),
			java.util.Map.entry("is_running", 2240911060L), java.util.Map.entry("set_use_magnet", 2586408642L),
			java.util.Map.entry("set_min_distance", 373806689L), java.util.Map.entry("stop", 3218959716L),
			java.util.Map.entry("set_override_tip_basis", 2586408642L),
			java.util.Map.entry("get_max_iterations", 3905245786L), java.util.Map.entry("set_tip_bone", 3304788590L),
			java.util.Map.entry("get_target_node", 277076166L), java.util.Map.entry("set_root_bone", 3304788590L),
			java.util.Map.entry("is_override_tip_basis", 36873697L),
			java.util.Map.entry("get_min_distance", 1740695150L), java.util.Map.entry("is_using_magnet", 36873697L));

	SkeletonIK3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonIK3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_override_tip_basis() {
		return (boolean) super.call("is_override_tip_basis");
	}

	public boolean is_using_magnet() {
		return (boolean) super.call("is_using_magnet");
	}

	public boolean is_running() {
		return (boolean) super.call("is_running");
	}

	public void start(boolean one_time) {
		super.call("start", new java.lang.Object[]{java.lang.Boolean.valueOf(one_time)});
	}

	public void stop() {
		super.call("stop");
	}

	public String getRoot_bone() {
		return (String) super.call("get_root_bone", new java.lang.Object[0]);
	}

	public void setRoot_bone(String value) {
		super.call("set_root_bone", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getTip_bone() {
		return (String) super.call("get_tip_bone", new java.lang.Object[0]);
	}

	public void setTip_bone(String value) {
		super.call("set_tip_bone", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Transform3D getTarget() {
		return (Transform3D) super.call("get_target_transform", new java.lang.Object[0]);
	}

	public void setTarget(Transform3D value) {
		super.call("set_target_transform", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isOverride_tip_basis() {
		return (boolean) super.call("is_override_tip_basis", new java.lang.Object[0]);
	}

	public void setOverride_tip_basis(boolean value) {
		super.call("set_override_tip_basis", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isUse_magnet() {
		return (boolean) super.call("is_using_magnet", new java.lang.Object[0]);
	}

	public void setUse_magnet(boolean value) {
		super.call("set_use_magnet", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector3 getMagnet() {
		return (Vector3) super.call("get_magnet_position", new java.lang.Object[0]);
	}

	public void setMagnet(Vector3 value) {
		super.call("set_magnet_position", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getTarget_node() {
		return (String) super.call("get_target_node", new java.lang.Object[0]);
	}

	public void setTarget_node(String value) {
		super.call("set_target_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getMin_distance() {
		return (double) super.call("get_min_distance", new java.lang.Object[0]);
	}

	public void setMin_distance(double value) {
		super.call("set_min_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getMax_iterations() {
		return (long) super.call("get_max_iterations", new java.lang.Object[0]);
	}

	public void setMax_iterations(long value) {
		super.call("set_max_iterations", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getInterpolation() {
		return (double) super.call("get_interpolation", new java.lang.Object[0]);
	}

	public void setInterpolation(double value) {
		super.call("set_interpolation", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
