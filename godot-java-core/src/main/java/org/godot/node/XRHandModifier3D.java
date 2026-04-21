package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class XRHandModifier3D extends SkeletonModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_hand_tracker", 3304788590L), java.util.Map.entry("set_bone_update", 3635701455L),
			java.util.Map.entry("get_hand_tracker", 2002593661L), java.util.Map.entry("get_bone_update", 2873665691L));

	XRHandModifier3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRHandModifier3D(long nativePointer) {
		super(nativePointer);
	}

	public String getHand_tracker() {
		return (String) super.call("get_hand_tracker", new java.lang.Object[0]);
	}

	public void setHand_tracker(String value) {
		super.call("set_hand_tracker", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getBone_update() {
		return (long) super.call("get_bone_update", new java.lang.Object[0]);
	}

	public void setBone_update(long value) {
		super.call("set_bone_update", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
