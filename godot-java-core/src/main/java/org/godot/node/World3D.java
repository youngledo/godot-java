package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class World3D extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_fallback_environment", 3082064660L),
			java.util.Map.entry("set_fallback_environment", 4143518816L),
			java.util.Map.entry("get_navigation_map", 2944877500L), java.util.Map.entry("get_space", 2944877500L),
			java.util.Map.entry("set_camera_attributes", 2817810567L),
			java.util.Map.entry("get_camera_attributes", 3921283215L),
			java.util.Map.entry("get_direct_space_state", 2069328350L),
			java.util.Map.entry("set_environment", 4143518816L), java.util.Map.entry("get_scenario", 2944877500L),
			java.util.Map.entry("get_environment", 3082064660L));

	World3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	World3D(long nativePointer) {
		super(nativePointer);
	}

	public Environment getEnvironment() {
		return (Environment) super.call("get_environment", new java.lang.Object[0]);
	}

	public void setEnvironment(Environment value) {
		super.call("set_environment", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Environment getFallback_environment() {
		return (Environment) super.call("get_fallback_environment", new java.lang.Object[0]);
	}

	public void setFallback_environment(Environment value) {
		super.call("set_fallback_environment", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Object getCamera_attributes() {
		return (Object) super.call("get_camera_attributes", new java.lang.Object[0]);
	}

	public void setCamera_attributes(Object value) {
		super.call("set_camera_attributes", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSpace() {
		return (long) super.call("get_space", new java.lang.Object[0]);
	}

	public void setSpace(long value) {
		super.call("set_space", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getNavigation_map() {
		return (long) super.call("get_navigation_map", new java.lang.Object[0]);
	}

	public void setNavigation_map(long value) {
		super.call("set_navigation_map", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getScenario() {
		return (long) super.call("get_scenario", new java.lang.Object[0]);
	}

	public void setScenario(long value) {
		super.call("set_scenario", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public PhysicsDirectSpaceState3D getDirect_space_state() {
		return (PhysicsDirectSpaceState3D) super.call("get_direct_space_state", new java.lang.Object[0]);
	}

	public void setDirect_space_state(PhysicsDirectSpaceState3D value) {
		super.call("set_direct_space_state", new java.lang.Object[]{(java.lang.Object) value});
	}
}
