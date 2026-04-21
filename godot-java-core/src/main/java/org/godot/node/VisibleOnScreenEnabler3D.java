package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisibleOnScreenEnabler3D extends VisibleOnScreenNotifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_enable_mode", 3352990031L),
			java.util.Map.entry("get_enable_node_path", 277076166L),
			java.util.Map.entry("set_enable_node_path", 1348162250L),
			java.util.Map.entry("set_enable_mode", 320303646L));

	VisibleOnScreenEnabler3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisibleOnScreenEnabler3D(long nativePointer) {
		super(nativePointer);
	}

	public long getEnable_mode() {
		return (long) super.call("get_enable_mode", new java.lang.Object[0]);
	}

	public void setEnable_mode(long value) {
		super.call("set_enable_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getEnable_node_path() {
		return (String) super.call("get_enable_node_path", new java.lang.Object[0]);
	}

	public void setEnable_node_path(String value) {
		super.call("set_enable_node_path", new java.lang.Object[]{(java.lang.Object) value});
	}
}
