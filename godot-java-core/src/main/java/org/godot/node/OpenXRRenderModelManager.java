package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRRenderModelManager extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_tracker", 2814627380L), java.util.Map.entry("set_make_local_to_pose", 83702148L),
			java.util.Map.entry("get_make_local_to_pose", 201670096L), java.util.Map.entry("get_tracker", 2456466356L));

	OpenXRRenderModelManager(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRRenderModelManager(long nativePointer) {
		super(nativePointer);
	}

	public long getTracker() {
		return (long) super.call("get_tracker", new java.lang.Object[0]);
	}

	public void setTracker(long value) {
		super.call("set_tracker", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getMake_local_to_pose() {
		return (String) super.call("get_make_local_to_pose", new java.lang.Object[0]);
	}

	public void setMake_local_to_pose(String value) {
		super.call("set_make_local_to_pose", new java.lang.Object[]{(java.lang.Object) value});
	}
}
