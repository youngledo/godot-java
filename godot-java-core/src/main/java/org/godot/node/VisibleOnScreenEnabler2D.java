package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisibleOnScreenEnabler2D extends VisibleOnScreenNotifier2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_enable_mode", 2650445576L),
			java.util.Map.entry("get_enable_node_path", 277076166L),
			java.util.Map.entry("set_enable_node_path", 1348162250L),
			java.util.Map.entry("set_enable_mode", 2961788752L));

	VisibleOnScreenEnabler2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisibleOnScreenEnabler2D(long nativePointer) {
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
