package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class PrismMesh extends PrimitiveMesh {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_left_to_right", 1740695150L), java.util.Map.entry("set_size", 3460891852L),
			java.util.Map.entry("get_subdivide_depth", 3905245786L),
			java.util.Map.entry("set_subdivide_width", 1286410249L),
			java.util.Map.entry("get_subdivide_height", 3905245786L),
			java.util.Map.entry("get_subdivide_width", 3905245786L), java.util.Map.entry("get_size", 3360562783L),
			java.util.Map.entry("set_left_to_right", 373806689L),
			java.util.Map.entry("set_subdivide_height", 1286410249L),
			java.util.Map.entry("set_subdivide_depth", 1286410249L));

	PrismMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PrismMesh(long nativePointer) {
		super(nativePointer);
	}

	public double getLeft_to_right() {
		return (double) super.call("get_left_to_right", new java.lang.Object[0]);
	}

	public void setLeft_to_right(double value) {
		super.call("set_left_to_right", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector3 getSize() {
		return (Vector3) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector3 value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSubdivide_width() {
		return (long) super.call("get_subdivide_width", new java.lang.Object[0]);
	}

	public void setSubdivide_width(long value) {
		super.call("set_subdivide_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSubdivide_height() {
		return (long) super.call("get_subdivide_height", new java.lang.Object[0]);
	}

	public void setSubdivide_height(long value) {
		super.call("set_subdivide_height", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSubdivide_depth() {
		return (long) super.call("get_subdivide_depth", new java.lang.Object[0]);
	}

	public void setSubdivide_depth(long value) {
		super.call("set_subdivide_depth", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
