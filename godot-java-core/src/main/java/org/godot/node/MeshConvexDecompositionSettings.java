package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class MeshConvexDecompositionSettings extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_revolution_axes_clipping_bias", 1740695150L),
			java.util.Map.entry("set_max_concavity", 373806689L), java.util.Map.entry("get_normalize_mesh", 36873697L),
			java.util.Map.entry("get_project_hull_vertices", 36873697L),
			java.util.Map.entry("set_max_convex_hulls", 1286410249L),
			java.util.Map.entry("get_convex_hull_approximation", 36873697L),
			java.util.Map.entry("get_resolution", 3905245786L),
			java.util.Map.entry("set_min_volume_per_convex_hull", 373806689L),
			java.util.Map.entry("set_convex_hull_downsampling", 1286410249L),
			java.util.Map.entry("get_convex_hull_downsampling", 3905245786L),
			java.util.Map.entry("set_convex_hull_approximation", 2586408642L),
			java.util.Map.entry("get_max_convex_hulls", 3905245786L), java.util.Map.entry("get_mode", 23479454L),
			java.util.Map.entry("get_max_num_vertices_per_convex_hull", 3905245786L),
			java.util.Map.entry("get_max_concavity", 1740695150L),
			java.util.Map.entry("get_symmetry_planes_clipping_bias", 1740695150L),
			java.util.Map.entry("set_symmetry_planes_clipping_bias", 373806689L),
			java.util.Map.entry("set_normalize_mesh", 2586408642L),
			java.util.Map.entry("get_plane_downsampling", 3905245786L),
			java.util.Map.entry("get_min_volume_per_convex_hull", 1740695150L),
			java.util.Map.entry("set_project_hull_vertices", 2586408642L),
			java.util.Map.entry("set_plane_downsampling", 1286410249L),
			java.util.Map.entry("set_resolution", 1286410249L),
			java.util.Map.entry("set_max_num_vertices_per_convex_hull", 1286410249L),
			java.util.Map.entry("set_revolution_axes_clipping_bias", 373806689L),
			java.util.Map.entry("set_mode", 1668072869L));

	MeshConvexDecompositionSettings(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MeshConvexDecompositionSettings(long nativePointer) {
		super(nativePointer);
	}

	public double getMax_concavity() {
		return (double) super.call("get_max_concavity", new java.lang.Object[0]);
	}

	public void setMax_concavity(double value) {
		super.call("set_max_concavity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSymmetry_planes_clipping_bias() {
		return (double) super.call("get_symmetry_planes_clipping_bias", new java.lang.Object[0]);
	}

	public void setSymmetry_planes_clipping_bias(double value) {
		super.call("set_symmetry_planes_clipping_bias", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRevolution_axes_clipping_bias() {
		return (double) super.call("get_revolution_axes_clipping_bias", new java.lang.Object[0]);
	}

	public void setRevolution_axes_clipping_bias(double value) {
		super.call("set_revolution_axes_clipping_bias", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMin_volume_per_convex_hull() {
		return (double) super.call("get_min_volume_per_convex_hull", new java.lang.Object[0]);
	}

	public void setMin_volume_per_convex_hull(double value) {
		super.call("set_min_volume_per_convex_hull", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getResolution() {
		return (long) super.call("get_resolution", new java.lang.Object[0]);
	}

	public void setResolution(long value) {
		super.call("set_resolution", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMax_num_vertices_per_convex_hull() {
		return (long) super.call("get_max_num_vertices_per_convex_hull", new java.lang.Object[0]);
	}

	public void setMax_num_vertices_per_convex_hull(long value) {
		super.call("set_max_num_vertices_per_convex_hull", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPlane_downsampling() {
		return (long) super.call("get_plane_downsampling", new java.lang.Object[0]);
	}

	public void setPlane_downsampling(long value) {
		super.call("set_plane_downsampling", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getConvex_hull_downsampling() {
		return (long) super.call("get_convex_hull_downsampling", new java.lang.Object[0]);
	}

	public void setConvex_hull_downsampling(long value) {
		super.call("set_convex_hull_downsampling", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getNormalize_mesh() {
		return (boolean) super.call("get_normalize_mesh", new java.lang.Object[0]);
	}

	public void setNormalize_mesh(boolean value) {
		super.call("set_normalize_mesh", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getMode() {
		return (long) super.call("get_mode", new java.lang.Object[0]);
	}

	public void setMode(long value) {
		super.call("set_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getConvex_hull_approximation() {
		return (boolean) super.call("get_convex_hull_approximation", new java.lang.Object[0]);
	}

	public void setConvex_hull_approximation(boolean value) {
		super.call("set_convex_hull_approximation", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getMax_convex_hulls() {
		return (long) super.call("get_max_convex_hulls", new java.lang.Object[0]);
	}

	public void setMax_convex_hulls(long value) {
		super.call("set_max_convex_hulls", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getProject_hull_vertices() {
		return (boolean) super.call("get_project_hull_vertices", new java.lang.Object[0]);
	}

	public void setProject_hull_vertices(boolean value) {
		super.call("set_project_hull_vertices", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
