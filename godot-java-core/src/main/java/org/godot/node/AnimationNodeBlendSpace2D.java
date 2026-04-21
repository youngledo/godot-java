package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class AnimationNodeBlendSpace2D extends AnimationRootNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_blend_point_position", 163021252L),
			java.util.Map.entry("set_blend_point_node", 4240341528L), java.util.Map.entry("get_snap", 3341600327L),
			java.util.Map.entry("set_y_label", 83702148L), java.util.Map.entry("set_use_sync", 2586408642L),
			java.util.Map.entry("get_blend_mode", 1398433632L), java.util.Map.entry("set_blend_mode", 81193520L),
			java.util.Map.entry("add_blend_point", 402261981L), java.util.Map.entry("set_max_space", 743155724L),
			java.util.Map.entry("set_snap", 743155724L), java.util.Map.entry("get_y_label", 201670096L),
			java.util.Map.entry("set_min_space", 743155724L), java.util.Map.entry("get_triangle_point", 50157827L),
			java.util.Map.entry("get_blend_point_count", 3905245786L), java.util.Map.entry("is_using_sync", 36873697L),
			java.util.Map.entry("get_blend_point_node", 665599029L),
			java.util.Map.entry("get_blend_point_position", 2299179447L),
			java.util.Map.entry("remove_blend_point", 1286410249L), java.util.Map.entry("add_triangle", 753017335L),
			java.util.Map.entry("get_triangle_count", 3905245786L),
			java.util.Map.entry("get_auto_triangles", 36873697L), java.util.Map.entry("get_min_space", 3341600327L),
			java.util.Map.entry("get_x_label", 201670096L), java.util.Map.entry("get_max_space", 3341600327L),
			java.util.Map.entry("remove_triangle", 1286410249L), java.util.Map.entry("set_auto_triangles", 2586408642L),
			java.util.Map.entry("set_x_label", 83702148L));

	AnimationNodeBlendSpace2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNodeBlendSpace2D(long nativePointer) {
		super(nativePointer);
	}

	public void add_blend_point(AnimationRootNode node, Vector2 pos, long at_index) {
		super.call("add_blend_point", new java.lang.Object[]{(java.lang.Object) node, (java.lang.Object) pos,
				java.lang.Long.valueOf(at_index)});
	}

	public void set_blend_point_position(long point, Vector2 pos) {
		super.call("set_blend_point_position",
				new java.lang.Object[]{java.lang.Long.valueOf(point), (java.lang.Object) pos});
	}

	public Vector2 get_blend_point_position(long point) {
		return (Vector2) super.call("get_blend_point_position", new java.lang.Object[]{java.lang.Long.valueOf(point)});
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

	public void add_triangle(long x, long y, long z, long at_index) {
		super.call("add_triangle", new java.lang.Object[]{java.lang.Long.valueOf(x), java.lang.Long.valueOf(y),
				java.lang.Long.valueOf(z), java.lang.Long.valueOf(at_index)});
	}

	public int get_triangle_point(long triangle, long point) {
		return (int) super.call("get_triangle_point",
				new java.lang.Object[]{java.lang.Long.valueOf(triangle), java.lang.Long.valueOf(point)});
	}

	public void remove_triangle(long triangle) {
		super.call("remove_triangle", new java.lang.Object[]{java.lang.Long.valueOf(triangle)});
	}

	public boolean is_using_sync() {
		return (boolean) super.call("is_using_sync");
	}

	public boolean getAuto_triangles() {
		return (boolean) super.call("get_auto_triangles", new java.lang.Object[0]);
	}

	public void setAuto_triangles(boolean value) {
		super.call("set_auto_triangles", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public int[] getTriangles() {
		return (int[]) super.call("_get_triangles", new java.lang.Object[0]);
	}

	public void setTriangles(int[] value) {
		super.call("_set_triangles", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getMin_space() {
		return (Vector2) super.call("get_min_space", new java.lang.Object[0]);
	}

	public void setMin_space(Vector2 value) {
		super.call("set_min_space", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getMax_space() {
		return (Vector2) super.call("get_max_space", new java.lang.Object[0]);
	}

	public void setMax_space(Vector2 value) {
		super.call("set_max_space", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getSnap() {
		return (Vector2) super.call("get_snap", new java.lang.Object[0]);
	}

	public void setSnap(Vector2 value) {
		super.call("set_snap", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getX_label() {
		return (String) super.call("get_x_label", new java.lang.Object[0]);
	}

	public void setX_label(String value) {
		super.call("set_x_label", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getY_label() {
		return (String) super.call("get_y_label", new java.lang.Object[0]);
	}

	public void setY_label(String value) {
		super.call("set_y_label", new java.lang.Object[]{(java.lang.Object) value});
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
