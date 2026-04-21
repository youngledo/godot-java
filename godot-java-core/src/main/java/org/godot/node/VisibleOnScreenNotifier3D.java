package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.AABB;

public class VisibleOnScreenNotifier3D extends VisualInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("is_on_screen", 36873697L), java.util.Map.entry("set_aabb", 259215842L));

	VisibleOnScreenNotifier3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisibleOnScreenNotifier3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_on_screen() {
		return (boolean) super.call("is_on_screen");
	}

	public AABB getAabb() {
		return (AABB) super.call("get_aabb", new java.lang.Object[0]);
	}

	public void setAabb(AABB value) {
		super.call("set_aabb", new java.lang.Object[]{(java.lang.Object) value});
	}
}
