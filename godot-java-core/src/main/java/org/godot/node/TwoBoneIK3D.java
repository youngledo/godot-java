package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class TwoBoneIK3D extends IKModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_pole_direction", 258741388L), java.util.Map.entry("get_end_bone", 923996154L),
			java.util.Map.entry("set_target_node", 2761262315L), java.util.Map.entry("set_extend_end_bone", 300928843L),
			java.util.Map.entry("set_middle_bone_name", 501894301L),
			java.util.Map.entry("set_end_bone_length", 1602489585L),
			java.util.Map.entry("get_pole_direction_vector", 711720468L),
			java.util.Map.entry("get_root_bone_name", 844755477L),
			java.util.Map.entry("is_end_bone_extended", 1116898809L),
			java.util.Map.entry("get_target_node", 408788394L),
			java.util.Map.entry("is_using_virtual_end", 1116898809L),
			java.util.Map.entry("get_middle_bone_name", 844755477L),
			java.util.Map.entry("set_end_bone_name", 501894301L), java.util.Map.entry("set_pole_node", 2761262315L),
			java.util.Map.entry("set_root_bone_name", 501894301L),
			java.util.Map.entry("set_pole_direction_vector", 1530502735L),
			java.util.Map.entry("get_end_bone_name", 844755477L), java.util.Map.entry("set_end_bone", 3937882851L),
			java.util.Map.entry("set_middle_bone", 3937882851L), java.util.Map.entry("get_pole_direction", 377522128L),
			java.util.Map.entry("get_end_bone_direction", 1843036459L),
			java.util.Map.entry("get_root_bone", 923996154L), java.util.Map.entry("get_middle_bone", 923996154L),
			java.util.Map.entry("get_pole_node", 408788394L), java.util.Map.entry("set_use_virtual_end", 300928843L),
			java.util.Map.entry("set_end_bone_direction", 2838484201L),
			java.util.Map.entry("set_root_bone", 3937882851L), java.util.Map.entry("get_end_bone_length", 2339986948L));

	TwoBoneIK3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TwoBoneIK3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_target_node(long index, String target_node) {
		super.call("set_target_node",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) target_node});
	}

	public String get_target_node(long index) {
		return (String) super.call("get_target_node", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_pole_node(long index, String pole_node) {
		super.call("set_pole_node",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) pole_node});
	}

	public String get_pole_node(long index) {
		return (String) super.call("get_pole_node", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_root_bone_name(long index, String bone_name) {
		super.call("set_root_bone_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) bone_name});
	}

	public String get_root_bone_name(long index) {
		return (String) super.call("get_root_bone_name", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_root_bone(long index, long bone) {
		super.call("set_root_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(bone)});
	}

	public int get_root_bone(long index) {
		return (int) super.call("get_root_bone", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_middle_bone_name(long index, String bone_name) {
		super.call("set_middle_bone_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) bone_name});
	}

	public String get_middle_bone_name(long index) {
		return (String) super.call("get_middle_bone_name", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_middle_bone(long index, long bone) {
		super.call("set_middle_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(bone)});
	}

	public int get_middle_bone(long index) {
		return (int) super.call("get_middle_bone", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_pole_direction(long index, int direction) {
		super.call("set_pole_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(direction)});
	}

	public int get_pole_direction(long index) {
		return (int) super.call("get_pole_direction", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_pole_direction_vector(long index, Vector3 vector) {
		super.call("set_pole_direction_vector",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) vector});
	}

	public Vector3 get_pole_direction_vector(long index) {
		return (Vector3) super.call("get_pole_direction_vector", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_end_bone_name(long index, String bone_name) {
		super.call("set_end_bone_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) bone_name});
	}

	public String get_end_bone_name(long index) {
		return (String) super.call("get_end_bone_name", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_end_bone(long index, long bone) {
		super.call("set_end_bone", new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(bone)});
	}

	public int get_end_bone(long index) {
		return (int) super.call("get_end_bone", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_use_virtual_end(long index, boolean enabled) {
		super.call("set_use_virtual_end",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_using_virtual_end(long index) {
		return (boolean) super.call("is_using_virtual_end", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_extend_end_bone(long index, boolean enabled) {
		super.call("set_extend_end_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_end_bone_extended(long index) {
		return (boolean) super.call("is_end_bone_extended", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_end_bone_direction(long index, int bone_direction) {
		super.call("set_end_bone_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(bone_direction)});
	}

	public int get_end_bone_direction(long index) {
		return (int) super.call("get_end_bone_direction", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_end_bone_length(long index, double length) {
		super.call("set_end_bone_length",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(length)});
	}

	public double get_end_bone_length(long index) {
		return (double) super.call("get_end_bone_length", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public long getSetting_count() {
		return (long) super.call("get_setting_count", new java.lang.Object[0]);
	}

	public void setSetting_count(long value) {
		super.call("set_setting_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
