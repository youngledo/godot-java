package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class FBXState extends GLTFState {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_allow_geometry_helper_nodes", 2586408642L),
			java.util.Map.entry("get_allow_geometry_helper_nodes", 2240911060L));

	FBXState(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FBXState(long nativePointer) {
		super(nativePointer);
	}

	public boolean getAllow_geometry_helper_nodes() {
		return (boolean) super.call("get_allow_geometry_helper_nodes", new java.lang.Object[0]);
	}

	public void setAllow_geometry_helper_nodes(boolean value) {
		super.call("set_allow_geometry_helper_nodes", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
