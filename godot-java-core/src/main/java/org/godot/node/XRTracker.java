package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class XRTracker extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_tracker_name", 2002593661L), java.util.Map.entry("get_tracker_type", 2784508102L),
			java.util.Map.entry("get_tracker_desc", 201670096L), java.util.Map.entry("set_tracker_desc", 83702148L),
			java.util.Map.entry("set_tracker_type", 3055763575L), java.util.Map.entry("set_tracker_name", 3304788590L));

	XRTracker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRTracker(long nativePointer) {
		super(nativePointer);
	}

	public long getType() {
		return (long) super.call("get_tracker_type", new java.lang.Object[0]);
	}

	public void setType(long value) {
		super.call("set_tracker_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getName() {
		return (String) super.call("get_tracker_name", new java.lang.Object[0]);
	}

	public void setName(String value) {
		super.call("set_tracker_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getDescription() {
		return (String) super.call("get_tracker_desc", new java.lang.Object[0]);
	}

	public void setDescription(String value) {
		super.call("set_tracker_desc", new java.lang.Object[]{(java.lang.Object) value});
	}
}
