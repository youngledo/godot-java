package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class SceneTreeTimer extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_time_left", 373806689L), java.util.Map.entry("get_time_left", 1740695150L));

	SceneTreeTimer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SceneTreeTimer(long nativePointer) {
		super(nativePointer);
	}

	public double getTime_left() {
		return (double) super.call("get_time_left", new java.lang.Object[0]);
	}

	public void setTime_left(double value) {
		super.call("set_time_left", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
