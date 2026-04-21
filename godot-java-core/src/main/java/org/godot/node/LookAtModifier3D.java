package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class LookAtModifier3D extends SkeletonModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_origin_safe_margin", 1740695150L),
			java.util.Map.entry("is_target_within_limitation", 36873697L),
			java.util.Map.entry("get_primary_rotation_axis", 3050976882L),
			java.util.Map.entry("set_transition_type", 1058637742L),
			java.util.Map.entry("get_secondary_damp_threshold", 1740695150L),
			java.util.Map.entry("set_forward_axis", 3199955933L), java.util.Map.entry("set_target_node", 1348162250L),
			java.util.Map.entry("set_secondary_limit_angle", 373806689L),
			java.util.Map.entry("set_secondary_positive_limit_angle", 373806689L),
			java.util.Map.entry("get_origin_from", 4057166297L), java.util.Map.entry("set_origin_bone", 1286410249L),
			java.util.Map.entry("set_primary_positive_damp_threshold", 373806689L),
			java.util.Map.entry("set_ease_type", 1208105857L),
			java.util.Map.entry("get_origin_external_node", 4075236667L),
			java.util.Map.entry("get_primary_limit_angle", 1740695150L),
			java.util.Map.entry("set_primary_damp_threshold", 373806689L),
			java.util.Map.entry("get_origin_bone_name", 201670096L),
			java.util.Map.entry("get_forward_axis", 4076020284L),
			java.util.Map.entry("get_primary_positive_limit_angle", 1740695150L),
			java.util.Map.entry("is_interpolating", 36873697L), java.util.Map.entry("set_relative", 2586408642L),
			java.util.Map.entry("set_secondary_damp_threshold", 373806689L),
			java.util.Map.entry("set_duration", 373806689L),
			java.util.Map.entry("get_secondary_negative_damp_threshold", 1740695150L),
			java.util.Map.entry("set_origin_bone_name", 83702148L),
			java.util.Map.entry("set_secondary_positive_damp_threshold", 373806689L),
			java.util.Map.entry("get_primary_positive_damp_threshold", 1740695150L),
			java.util.Map.entry("set_primary_negative_damp_threshold", 373806689L),
			java.util.Map.entry("set_primary_limit_angle", 373806689L),
			java.util.Map.entry("set_origin_from", 4254695669L),
			java.util.Map.entry("get_secondary_positive_damp_threshold", 1740695150L),
			java.util.Map.entry("set_use_secondary_rotation", 2586408642L),
			java.util.Map.entry("set_primary_negative_limit_angle", 373806689L),
			java.util.Map.entry("get_primary_damp_threshold", 1740695150L),
			java.util.Map.entry("get_interpolation_remaining", 1740695150L),
			java.util.Map.entry("set_secondary_negative_limit_angle", 373806689L),
			java.util.Map.entry("get_bone_name", 201670096L), java.util.Map.entry("get_bone", 3905245786L),
			java.util.Map.entry("set_secondary_negative_damp_threshold", 373806689L),
			java.util.Map.entry("get_secondary_negative_limit_angle", 1740695150L),
			java.util.Map.entry("set_symmetry_limitation", 2586408642L),
			java.util.Map.entry("set_primary_positive_limit_angle", 373806689L),
			java.util.Map.entry("set_origin_safe_margin", 373806689L), java.util.Map.entry("set_bone", 1286410249L),
			java.util.Map.entry("get_target_node", 4075236667L), java.util.Map.entry("set_bone_name", 83702148L),
			java.util.Map.entry("is_limitation_symmetry", 36873697L),
			java.util.Map.entry("get_primary_negative_damp_threshold", 1740695150L),
			java.util.Map.entry("is_using_secondary_rotation", 36873697L),
			java.util.Map.entry("set_origin_external_node", 1348162250L),
			java.util.Map.entry("set_use_angle_limitation", 2586408642L), java.util.Map.entry("is_relative", 36873697L),
			java.util.Map.entry("is_using_angle_limitation", 36873697L),
			java.util.Map.entry("get_transition_type", 3842314528L),
			java.util.Map.entry("get_primary_negative_limit_angle", 1740695150L),
			java.util.Map.entry("set_primary_rotation_axis", 1144690656L),
			java.util.Map.entry("get_duration", 1740695150L), java.util.Map.entry("get_ease_type", 631880200L),
			java.util.Map.entry("set_origin_offset", 3460891852L), java.util.Map.entry("get_origin_bone", 3905245786L),
			java.util.Map.entry("get_secondary_limit_angle", 1740695150L),
			java.util.Map.entry("get_origin_offset", 3360562783L),
			java.util.Map.entry("get_secondary_positive_limit_angle", 1740695150L));

	LookAtModifier3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	LookAtModifier3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_using_secondary_rotation() {
		return (boolean) super.call("is_using_secondary_rotation");
	}

	public boolean is_relative() {
		return (boolean) super.call("is_relative");
	}

	public boolean is_using_angle_limitation() {
		return (boolean) super.call("is_using_angle_limitation");
	}

	public boolean is_limitation_symmetry() {
		return (boolean) super.call("is_limitation_symmetry");
	}

	public boolean is_interpolating() {
		return (boolean) super.call("is_interpolating");
	}

	public boolean is_target_within_limitation() {
		return (boolean) super.call("is_target_within_limitation");
	}

	public String getTarget_node() {
		return (String) super.call("get_target_node", new java.lang.Object[0]);
	}

	public void setTarget_node(String value) {
		super.call("set_target_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getBone_name() {
		return (String) super.call("get_bone_name", new java.lang.Object[0]);
	}

	public void setBone_name(String value) {
		super.call("set_bone_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getBone() {
		return (long) super.call("get_bone", new java.lang.Object[0]);
	}

	public void setBone(long value) {
		super.call("set_bone", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getForward_axis() {
		return (long) super.call("get_forward_axis", new java.lang.Object[0]);
	}

	public void setForward_axis(long value) {
		super.call("set_forward_axis", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPrimary_rotation_axis() {
		return (long) super.call("get_primary_rotation_axis", new java.lang.Object[0]);
	}

	public void setPrimary_rotation_axis(long value) {
		super.call("set_primary_rotation_axis", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isUse_secondary_rotation() {
		return (boolean) super.call("is_using_secondary_rotation", new java.lang.Object[0]);
	}

	public void setUse_secondary_rotation(boolean value) {
		super.call("set_use_secondary_rotation", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isRelative() {
		return (boolean) super.call("is_relative", new java.lang.Object[0]);
	}

	public void setRelative(boolean value) {
		super.call("set_relative", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getOrigin_from() {
		return (long) super.call("get_origin_from", new java.lang.Object[0]);
	}

	public void setOrigin_from(long value) {
		super.call("set_origin_from", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getOrigin_bone_name() {
		return (String) super.call("get_origin_bone_name", new java.lang.Object[0]);
	}

	public void setOrigin_bone_name(String value) {
		super.call("set_origin_bone_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getOrigin_bone() {
		return (long) super.call("get_origin_bone", new java.lang.Object[0]);
	}

	public void setOrigin_bone(long value) {
		super.call("set_origin_bone", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getOrigin_external_node() {
		return (String) super.call("get_origin_external_node", new java.lang.Object[0]);
	}

	public void setOrigin_external_node(String value) {
		super.call("set_origin_external_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getOrigin_offset() {
		return (Vector3) super.call("get_origin_offset", new java.lang.Object[0]);
	}

	public void setOrigin_offset(Vector3 value) {
		super.call("set_origin_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getOrigin_safe_margin() {
		return (double) super.call("get_origin_safe_margin", new java.lang.Object[0]);
	}

	public void setOrigin_safe_margin(double value) {
		super.call("set_origin_safe_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDuration() {
		return (double) super.call("get_duration", new java.lang.Object[0]);
	}

	public void setDuration(double value) {
		super.call("set_duration", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getTransition_type() {
		return (long) super.call("get_transition_type", new java.lang.Object[0]);
	}

	public void setTransition_type(long value) {
		super.call("set_transition_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getEase_type() {
		return (long) super.call("get_ease_type", new java.lang.Object[0]);
	}

	public void setEase_type(long value) {
		super.call("set_ease_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isUse_angle_limitation() {
		return (boolean) super.call("is_using_angle_limitation", new java.lang.Object[0]);
	}

	public void setUse_angle_limitation(boolean value) {
		super.call("set_use_angle_limitation", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isSymmetry_limitation() {
		return (boolean) super.call("is_limitation_symmetry", new java.lang.Object[0]);
	}

	public void setSymmetry_limitation(boolean value) {
		super.call("set_symmetry_limitation", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getPrimary_limit_angle() {
		return (double) super.call("get_primary_limit_angle", new java.lang.Object[0]);
	}

	public void setPrimary_limit_angle(double value) {
		super.call("set_primary_limit_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPrimary_damp_threshold() {
		return (double) super.call("get_primary_damp_threshold", new java.lang.Object[0]);
	}

	public void setPrimary_damp_threshold(double value) {
		super.call("set_primary_damp_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPrimary_positive_limit_angle() {
		return (double) super.call("get_primary_positive_limit_angle", new java.lang.Object[0]);
	}

	public void setPrimary_positive_limit_angle(double value) {
		super.call("set_primary_positive_limit_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPrimary_positive_damp_threshold() {
		return (double) super.call("get_primary_positive_damp_threshold", new java.lang.Object[0]);
	}

	public void setPrimary_positive_damp_threshold(double value) {
		super.call("set_primary_positive_damp_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPrimary_negative_limit_angle() {
		return (double) super.call("get_primary_negative_limit_angle", new java.lang.Object[0]);
	}

	public void setPrimary_negative_limit_angle(double value) {
		super.call("set_primary_negative_limit_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPrimary_negative_damp_threshold() {
		return (double) super.call("get_primary_negative_damp_threshold", new java.lang.Object[0]);
	}

	public void setPrimary_negative_damp_threshold(double value) {
		super.call("set_primary_negative_damp_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSecondary_limit_angle() {
		return (double) super.call("get_secondary_limit_angle", new java.lang.Object[0]);
	}

	public void setSecondary_limit_angle(double value) {
		super.call("set_secondary_limit_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSecondary_damp_threshold() {
		return (double) super.call("get_secondary_damp_threshold", new java.lang.Object[0]);
	}

	public void setSecondary_damp_threshold(double value) {
		super.call("set_secondary_damp_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSecondary_positive_limit_angle() {
		return (double) super.call("get_secondary_positive_limit_angle", new java.lang.Object[0]);
	}

	public void setSecondary_positive_limit_angle(double value) {
		super.call("set_secondary_positive_limit_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSecondary_positive_damp_threshold() {
		return (double) super.call("get_secondary_positive_damp_threshold", new java.lang.Object[0]);
	}

	public void setSecondary_positive_damp_threshold(double value) {
		super.call("set_secondary_positive_damp_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSecondary_negative_limit_angle() {
		return (double) super.call("get_secondary_negative_limit_angle", new java.lang.Object[0]);
	}

	public void setSecondary_negative_limit_angle(double value) {
		super.call("set_secondary_negative_limit_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSecondary_negative_damp_threshold() {
		return (double) super.call("get_secondary_negative_damp_threshold", new java.lang.Object[0]);
	}

	public void setSecondary_negative_damp_threshold(double value) {
		super.call("set_secondary_negative_damp_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
