package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;

public class OpenXRPlaneTracker extends OpenXRSpatialEntityTracker {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_mesh_offset", 3229777777L), java.util.Map.entry("set_plane_label", 83702148L),
			java.util.Map.entry("set_mesh_data", 1877193149L), java.util.Map.entry("set_plane_alignment", 1214382230L),
			java.util.Map.entry("get_plane_label", 201670096L), java.util.Map.entry("clear_mesh_data", 3218959716L),
			java.util.Map.entry("set_bounds_size", 743155724L), java.util.Map.entry("get_mesh", 4081188045L),
			java.util.Map.entry("get_shape", 3358509884L), java.util.Map.entry("get_plane_alignment", 845541441L),
			java.util.Map.entry("get_bounds_size", 3341600327L));

	OpenXRPlaneTracker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRPlaneTracker(long nativePointer) {
		super(nativePointer);
	}

	public void set_mesh_data(Transform3D origin, double[][] vertices, int[] indices) {
		super.call("set_mesh_data", new java.lang.Object[]{(java.lang.Object) origin, (java.lang.Object) vertices,
				(java.lang.Object) indices});
	}

	public void clear_mesh_data() {
		super.call("clear_mesh_data");
	}

	public Shape3D get_shape(double thickness) {
		return (Shape3D) super.call("get_shape", new java.lang.Object[]{java.lang.Double.valueOf(thickness)});
	}

	public long getBounds_size() {
		return (long) super.call("get_bounds_size", new java.lang.Object[0]);
	}

	public void setBounds_size(long value) {
		super.call("set_bounds_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPlane_alignment() {
		return (long) super.call("get_plane_alignment", new java.lang.Object[0]);
	}

	public void setPlane_alignment(long value) {
		super.call("set_plane_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getPlane_label() {
		return (String) super.call("get_plane_label", new java.lang.Object[0]);
	}

	public void setPlane_label(String value) {
		super.call("set_plane_label", new java.lang.Object[]{(java.lang.Object) value});
	}
}
