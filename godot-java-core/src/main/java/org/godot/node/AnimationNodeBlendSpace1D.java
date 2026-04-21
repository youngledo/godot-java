package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationNodeBlendSpace1D extends AnimationRootNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_blend_point_node", 665599029L),
			java.util.Map.entry("get_blend_point_position", 2339986948L),
			java.util.Map.entry("set_blend_point_position", 1602489585L),
			java.util.Map.entry("set_blend_point_node", 4240341528L),
			java.util.Map.entry("remove_blend_point", 1286410249L), java.util.Map.entry("get_snap", 1740695150L),
			java.util.Map.entry("set_use_sync", 2586408642L), java.util.Map.entry("get_blend_mode", 1547667849L),
			java.util.Map.entry("set_blend_mode", 2600869457L), java.util.Map.entry("add_blend_point", 285050433L),
			java.util.Map.entry("get_min_space", 1740695150L), java.util.Map.entry("set_max_space", 373806689L),
			java.util.Map.entry("get_max_space", 1740695150L), java.util.Map.entry("get_value_label", 201670096L),
			java.util.Map.entry("set_snap", 373806689L), java.util.Map.entry("set_min_space", 373806689L),
			java.util.Map.entry("get_blend_point_count", 3905245786L),
			java.util.Map.entry("set_value_label", 83702148L), java.util.Map.entry("is_using_sync", 36873697L));

	AnimationNodeBlendSpace1D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeBlendSpace1D(long nativePointer) {
		super(nativePointer);
	}

	public void add_blend_point(AnimationRootNode node, double pos, long at_index) {
		super.call("add_blend_point", new java.lang.Object[]{(java.lang.Object) node, java.lang.Double.valueOf(pos),
				java.lang.Long.valueOf(at_index)});
	}

	public void set_blend_point_position(long point, double pos) {
		super.call("set_blend_point_position",
				new java.lang.Object[]{java.lang.Long.valueOf(point), java.lang.Double.valueOf(pos)});
	}

	public double get_blend_point_position(long point) {
		return (double) super.call("get_blend_point_position", new java.lang.Object[]{java.lang.Long.valueOf(point)});
	}

	public void set_blend_point_node(long point, AnimationRootNode node) {
		super.call("set_blend_point_node",
				new java.lang.Object[]{java.lang.Long.valueOf(point), (java.lang.Object) node});
	}

	public AnimationRootNode get_blend_point_node(long point) {
		return (AnimationRootNode) super.call("get_blend_point_node",
				new java.lang.Object[]{java.lang.Long.valueOf(point)});
	}

	public void remove_blend_point(long point) {
		super.call("remove_blend_point", new java.lang.Object[]{java.lang.Long.valueOf(point)});
	}

	public boolean is_using_sync() {
		return (boolean) super.call("is_using_sync");
	}

	public double getMin_space() {
		return (double) super.call("get_min_space", new java.lang.Object[0]);
	}

	public void setMin_space(double value) {
		super.call("set_min_space", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMax_space() {
		return (double) super.call("get_max_space", new java.lang.Object[0]);
	}

	public void setMax_space(double value) {
		super.call("set_max_space", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSnap() {
		return (double) super.call("get_snap", new java.lang.Object[0]);
	}

	public void setSnap(double value) {
		super.call("set_snap", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public String getValue_label() {
		return (String) super.call("get_value_label", new java.lang.Object[0]);
	}

	public void setValue_label(String value) {
		super.call("set_value_label", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getBlend_mode() {
		return (long) super.call("get_blend_mode", new java.lang.Object[0]);
	}

	public void setBlend_mode(long value) {
		super.call("set_blend_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isSync() {
		return (boolean) super.call("is_using_sync", new java.lang.Object[0]);
	}

	public void setSync(boolean value) {
		super.call("set_use_sync", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
