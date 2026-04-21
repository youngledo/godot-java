package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class BoneConstraint3D extends SkeletonModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_reference_node", 2761262315L), java.util.Map.entry("set_amount", 1602489585L),
			java.util.Map.entry("get_apply_bone_name", 844755477L),
			java.util.Map.entry("get_reference_node", 408788394L),
			java.util.Map.entry("get_setting_count", 3905245786L), java.util.Map.entry("get_apply_bone", 923996154L),
			java.util.Map.entry("get_reference_type", 3456416152L),
			java.util.Map.entry("set_setting_count", 1286410249L), java.util.Map.entry("clear_setting", 3218959716L),
			java.util.Map.entry("set_apply_bone", 3937882851L),
			java.util.Map.entry("get_reference_bone_name", 844755477L),
			java.util.Map.entry("get_reference_bone", 923996154L),
			java.util.Map.entry("set_reference_type", 1830520418L),
			java.util.Map.entry("set_reference_bone_name", 501894301L),
			java.util.Map.entry("set_apply_bone_name", 501894301L), java.util.Map.entry("get_amount", 2339986948L),
			java.util.Map.entry("set_reference_bone", 3937882851L));

	BoneConstraint3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	BoneConstraint3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_amount(long index, double amount) {
		super.call("set_amount",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(amount)});
	}

	public double get_amount(long index) {
		return (double) super.call("get_amount", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_apply_bone_name(long index, String bone_name) {
		super.call("set_apply_bone_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) bone_name});
	}

	public String get_apply_bone_name(long index) {
		return (String) super.call("get_apply_bone_name", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_apply_bone(long index, long bone) {
		super.call("set_apply_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(bone)});
	}

	public int get_apply_bone(long index) {
		return (int) super.call("get_apply_bone", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_reference_type(long index, int type) {
		super.call("set_reference_type",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(type)});
	}

	public int get_reference_type(long index) {
		return (int) super.call("get_reference_type", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_reference_bone_name(long index, String bone_name) {
		super.call("set_reference_bone_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) bone_name});
	}

	public String get_reference_bone_name(long index) {
		return (String) super.call("get_reference_bone_name", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_reference_bone(long index, long bone) {
		super.call("set_reference_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(bone)});
	}

	public int get_reference_bone(long index) {
		return (int) super.call("get_reference_bone", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_reference_node(long index, String node) {
		super.call("set_reference_node",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) node});
	}

	public String get_reference_node(long index) {
		return (String) super.call("get_reference_node", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void clear_setting() {
		super.call("clear_setting");
	}
}
