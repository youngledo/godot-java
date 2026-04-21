package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;
import org.godot.math.Vector3;

public class PlaneMesh extends PrimitiveMesh {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_center_offset", 3460891852L), java.util.Map.entry("set_size", 743155724L),
			java.util.Map.entry("get_orientation", 3227599250L),
			java.util.Map.entry("get_subdivide_depth", 3905245786L),
			java.util.Map.entry("set_subdivide_width", 1286410249L),
			java.util.Map.entry("get_subdivide_width", 3905245786L), java.util.Map.entry("get_size", 3341600327L),
			java.util.Map.entry("set_orientation", 2751399687L), java.util.Map.entry("get_center_offset", 3360562783L),
			java.util.Map.entry("set_subdivide_depth", 1286410249L));

	PlaneMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PlaneMesh(long nativePointer) {
		super(nativePointer);
	}

	public Vector2 getSize() {
		return (Vector2) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector2 value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSubdivide_width() {
		return (long) super.call("get_subdivide_width", new java.lang.Object[0]);
	}

	public void setSubdivide_width(long value) {
		super.call("set_subdivide_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSubdivide_depth() {
		return (long) super.call("get_subdivide_depth", new java.lang.Object[0]);
	}

	public void setSubdivide_depth(long value) {
		super.call("set_subdivide_depth", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector3 getCenter_offset() {
		return (Vector3) super.call("get_center_offset", new java.lang.Object[0]);
	}

	public void setCenter_offset(Vector3 value) {
		super.call("set_center_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getOrientation() {
		return (long) super.call("get_orientation", new java.lang.Object[0]);
	}

	public void setOrientation(long value) {
		super.call("set_orientation", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
