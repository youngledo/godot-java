package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CSGMesh3D extends CSGPrimitive3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_material", 2757459619L), java.util.Map.entry("get_material", 5934680L),
			java.util.Map.entry("set_mesh", 194775623L), java.util.Map.entry("get_mesh", 4081188045L));

	CSGMesh3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CSGMesh3D(long nativePointer) {
		super(nativePointer);
	}

	public Object getMesh() {
		return (Object) super.call("get_mesh", new java.lang.Object[0]);
	}

	public void setMesh(Object value) {
		super.call("set_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Object getMaterial() {
		return (Object) super.call("get_material", new java.lang.Object[0]);
	}

	public void setMaterial(Object value) {
		super.call("set_material", new java.lang.Object[]{(java.lang.Object) value});
	}
}
