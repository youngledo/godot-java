package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class World2D extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_navigation_map", 2944877500L), java.util.Map.entry("get_space", 2944877500L),
			java.util.Map.entry("get_direct_space_state", 2506717822L), java.util.Map.entry("get_canvas", 2944877500L));

	World2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	World2D(long nativePointer) {
		super(nativePointer);
	}

	public long getCanvas() {
		return (long) super.call("get_canvas", new java.lang.Object[0]);
	}

	public void setCanvas(long value) {
		super.call("set_canvas", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getNavigation_map() {
		return (long) super.call("get_navigation_map", new java.lang.Object[0]);
	}

	public void setNavigation_map(long value) {
		super.call("set_navigation_map", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSpace() {
		return (long) super.call("get_space", new java.lang.Object[0]);
	}

	public void setSpace(long value) {
		super.call("set_space", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public PhysicsDirectSpaceState2D getDirect_space_state() {
		return (PhysicsDirectSpaceState2D) super.call("get_direct_space_state", new java.lang.Object[0]);
	}

	public void setDirect_space_state(PhysicsDirectSpaceState2D value) {
		super.call("set_direct_space_state", new java.lang.Object[]{(java.lang.Object) value});
	}
}
