package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class XRController3D extends XRNode3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_button_pressed", 2619796661L), java.util.Map.entry("get_vector2", 3100822709L),
			java.util.Map.entry("get_tracker_hand", 4181770860L), java.util.Map.entry("get_input", 2760726917L),
			java.util.Map.entry("get_float", 2349060816L));

	XRController3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRController3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_button_pressed(String name) {
		return (boolean) super.call("is_button_pressed", new java.lang.Object[]{(java.lang.Object) name});
	}

	public Object get_input(String name) {
		return (Object) super.call("get_input", new java.lang.Object[]{(java.lang.Object) name});
	}

	public double get_float(String name) {
		return (double) super.call("get_float", new java.lang.Object[]{(java.lang.Object) name});
	}

	public Vector2 get_vector2(String name) {
		return (Vector2) super.call("get_vector2", new java.lang.Object[]{(java.lang.Object) name});
	}
}
