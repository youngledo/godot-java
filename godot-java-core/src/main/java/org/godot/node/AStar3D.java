package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;
import org.godot.math.Vector3;

public class AStar3D extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("are_points_connected", 2288175859L),
			java.util.Map.entry("get_point_capacity", 3905245786L),
			java.util.Map.entry("get_available_point_id", 3905245786L),
			java.util.Map.entry("get_point_connections", 2865087369L),
			java.util.Map.entry("get_point_count", 3905245786L), java.util.Map.entry("get_point_ids", 3851388692L),
			java.util.Map.entry("get_point_weight_scale", 2339986948L),
			java.util.Map.entry("set_point_disabled", 972357352L),
			java.util.Map.entry("get_closest_point", 3241074317L), java.util.Map.entry("connect_points", 3710494224L),
			java.util.Map.entry("set_point_weight_scale", 1602489585L),
			java.util.Map.entry("reserve_space", 1286410249L), java.util.Map.entry("disconnect_points", 3710494224L),
			java.util.Map.entry("clear", 3218959716L), java.util.Map.entry("is_point_disabled", 1116898809L),
			java.util.Map.entry("has_point", 1116898809L),
			java.util.Map.entry("get_closest_position_in_segment", 192990374L),
			java.util.Map.entry("set_neighbor_filter_enabled", 2586408642L),
			java.util.Map.entry("get_id_path", 3136199648L), java.util.Map.entry("get_point_position", 711720468L),
			java.util.Map.entry("remove_point", 1286410249L),
			java.util.Map.entry("is_neighbor_filter_enabled", 36873697L), java.util.Map.entry("add_point", 1038703438L),
			java.util.Map.entry("set_point_position", 1530502735L), java.util.Map.entry("get_point_path", 1562654675L));

	AStar3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AStar3D(long nativePointer) {
		super(nativePointer);
	}

	public void add_point(long id, Vector3 position, double weight_scale) {
		super.call("add_point", new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) position,
				java.lang.Double.valueOf(weight_scale)});
	}

	public Vector3 get_point_position(long id) {
		return (Vector3) super.call("get_point_position", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void set_point_position(long id, Vector3 position) {
		super.call("set_point_position",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) position});
	}

	public double get_point_weight_scale(long id) {
		return (double) super.call("get_point_weight_scale", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void set_point_weight_scale(long id, double weight_scale) {
		super.call("set_point_weight_scale",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Double.valueOf(weight_scale)});
	}

	public void remove_point(long id) {
		super.call("remove_point", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public boolean has_point(long id) {
		return (boolean) super.call("has_point", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public long[] get_point_connections(long id) {
		return (long[]) super.call("get_point_connections", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void set_point_disabled(long id, boolean disabled) {
		super.call("set_point_disabled",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(disabled)});
	}

	public boolean is_point_disabled(long id) {
		return (boolean) super.call("is_point_disabled", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public boolean is_neighbor_filter_enabled() {
		return (boolean) super.call("is_neighbor_filter_enabled");
	}

	public void connect_points(long id, long to_id, boolean bidirectional) {
		super.call("connect_points", new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(to_id),
				java.lang.Boolean.valueOf(bidirectional)});
	}

	public void disconnect_points(long id, long to_id, boolean bidirectional) {
		super.call("disconnect_points", new java.lang.Object[]{java.lang.Long.valueOf(id),
				java.lang.Long.valueOf(to_id), java.lang.Boolean.valueOf(bidirectional)});
	}

	public boolean are_points_connected(long id, long to_id, boolean bidirectional) {
		return (boolean) super.call("are_points_connected", new java.lang.Object[]{java.lang.Long.valueOf(id),
				java.lang.Long.valueOf(to_id), java.lang.Boolean.valueOf(bidirectional)});
	}

	public void reserve_space(long num_nodes) {
		super.call("reserve_space", new java.lang.Object[]{java.lang.Long.valueOf(num_nodes)});
	}

	public void clear() {
		super.call("clear");
	}

	public long get_closest_point(Vector3 to_position, boolean include_disabled) {
		return (long) super.call("get_closest_point",
				new java.lang.Object[]{(java.lang.Object) to_position, java.lang.Boolean.valueOf(include_disabled)});
	}

	public Vector3 get_closest_position_in_segment(Vector3 to_position) {
		return (Vector3) super.call("get_closest_position_in_segment",
				new java.lang.Object[]{(java.lang.Object) to_position});
	}

	public double[][] get_point_path(long from_id, long to_id, boolean allow_partial_path) {
		return (double[][]) super.call("get_point_path", new java.lang.Object[]{java.lang.Long.valueOf(from_id),
				java.lang.Long.valueOf(to_id), java.lang.Boolean.valueOf(allow_partial_path)});
	}

	public long[] get_id_path(long from_id, long to_id, boolean allow_partial_path) {
		return (long[]) super.call("get_id_path", new java.lang.Object[]{java.lang.Long.valueOf(from_id),
				java.lang.Long.valueOf(to_id), java.lang.Boolean.valueOf(allow_partial_path)});
	}

	public boolean isNeighbor_filter_enabled() {
		return (boolean) super.call("is_neighbor_filter_enabled", new java.lang.Object[0]);
	}

	public void setNeighbor_filter_enabled(boolean value) {
		super.call("set_neighbor_filter_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
