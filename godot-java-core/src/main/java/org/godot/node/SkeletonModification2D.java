package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SkeletonModification2D extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_execution_mode", 3905245786L), java.util.Map.entry("set_enabled", 2586408642L),
			java.util.Map.entry("get_modification_stack", 2137761694L), java.util.Map.entry("clamp_angle", 1229502682L),
			java.util.Map.entry("get_editor_draw_gizmo", 36873697L), java.util.Map.entry("get_enabled", 2240911060L),
			java.util.Map.entry("get_is_setup", 36873697L), java.util.Map.entry("set_is_setup", 2586408642L),
			java.util.Map.entry("set_editor_draw_gizmo", 2586408642L),
			java.util.Map.entry("set_execution_mode", 1286410249L));

	SkeletonModification2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonModification2D(long nativePointer) {
		super(nativePointer);
	}

	public double clamp_angle(double angle, double min, double max, boolean invert) {
		return (double) super.call("clamp_angle", new java.lang.Object[]{java.lang.Double.valueOf(angle),
				java.lang.Double.valueOf(min), java.lang.Double.valueOf(max), java.lang.Boolean.valueOf(invert)});
	}

	public boolean getEnabled() {
		return (boolean) super.call("get_enabled", new java.lang.Object[0]);
	}

	public void setEnabled(boolean value) {
		super.call("set_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getExecution_mode() {
		return (long) super.call("get_execution_mode", new java.lang.Object[0]);
	}

	public void setExecution_mode(long value) {
		super.call("set_execution_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
