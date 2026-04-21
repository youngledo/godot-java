package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class MultiMeshInstance3D extends GeometryInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_multimesh", 2246127404L), java.util.Map.entry("get_multimesh", 1385450523L));

	MultiMeshInstance3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MultiMeshInstance3D(long nativePointer) {
		super(nativePointer);
	}

	public MultiMesh getMultimesh() {
		return (MultiMesh) super.call("get_multimesh", new java.lang.Object[0]);
	}

	public void setMultimesh(MultiMesh value) {
		super.call("set_multimesh", new java.lang.Object[]{(java.lang.Object) value});
	}
}
