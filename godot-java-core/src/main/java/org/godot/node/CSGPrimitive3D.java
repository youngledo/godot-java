package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CSGPrimitive3D extends CSGShape3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_flip_faces", 2240911060L), java.util.Map.entry("set_flip_faces", 2586408642L));

	CSGPrimitive3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CSGPrimitive3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean getFlip_faces() {
		return (boolean) super.call("get_flip_faces", new java.lang.Object[0]);
	}

	public void setFlip_faces(boolean value) {
		super.call("set_flip_faces", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
