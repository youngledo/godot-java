package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class XRFaceModifier3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_face_tracker", 2002593661L), java.util.Map.entry("get_target", 4075236667L),
			java.util.Map.entry("set_target", 1348162250L), java.util.Map.entry("set_face_tracker", 3304788590L));

	XRFaceModifier3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRFaceModifier3D(long nativePointer) {
		super(nativePointer);
	}

	public String getFace_tracker() {
		return (String) super.call("get_face_tracker", new java.lang.Object[0]);
	}

	public void setFace_tracker(String value) {
		super.call("set_face_tracker", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getTarget() {
		return (String) super.call("get_target", new java.lang.Object[0]);
	}

	public void setTarget(String value) {
		super.call("set_target", new java.lang.Object[]{(java.lang.Object) value});
	}
}
