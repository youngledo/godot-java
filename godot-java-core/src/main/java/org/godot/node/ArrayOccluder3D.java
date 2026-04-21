package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ArrayOccluder3D extends Occluder3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_arrays", 3233972621L), java.util.Map.entry("set_vertices", 334873810L),
			java.util.Map.entry("set_indices", 3614634198L));

	ArrayOccluder3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ArrayOccluder3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_arrays(double[][] vertices, int[] indices) {
		super.call("set_arrays", new java.lang.Object[]{(java.lang.Object) vertices, (java.lang.Object) indices});
	}

	public double[][] getVertices() {
		return (double[][]) super.call("get_vertices", new java.lang.Object[0]);
	}

	public void setVertices(double[][] value) {
		super.call("set_vertices", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int[] getIndices() {
		return (int[]) super.call("get_indices", new java.lang.Object[0]);
	}

	public void setIndices(int[] value) {
		super.call("set_indices", new java.lang.Object[]{(java.lang.Object) value});
	}
}
