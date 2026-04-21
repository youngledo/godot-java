package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class XRBodyModifier3D extends SkeletonModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_body_tracker", 3304788590L), java.util.Map.entry("set_body_update", 2211199417L),
			java.util.Map.entry("get_body_tracker", 2002593661L), java.util.Map.entry("set_bone_update", 3356796943L),
			java.util.Map.entry("get_body_update", 2642335328L), java.util.Map.entry("get_bone_update", 1309305964L));

	XRBodyModifier3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRBodyModifier3D(long nativePointer) {
		super(nativePointer);
	}

	public String getBody_tracker() {
		return (String) super.call("get_body_tracker", new java.lang.Object[0]);
	}

	public void setBody_tracker(String value) {
		super.call("set_body_tracker", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getBody_update() {
		return (long) super.call("get_body_update", new java.lang.Object[0]);
	}

	public void setBody_update(long value) {
		super.call("set_body_update", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBone_update() {
		return (long) super.call("get_bone_update", new java.lang.Object[0]);
	}

	public void setBone_update(long value) {
		super.call("set_bone_update", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
