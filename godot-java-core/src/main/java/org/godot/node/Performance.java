package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotArray;
import org.godot.core.Callable;

public class Performance extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_monitor", 1943275655L),
			java.util.Map.entry("get_monitor_modification_time", 2455072627L),
			java.util.Map.entry("add_custom_monitor", 3655788610L),
			java.util.Map.entry("has_custom_monitor", 2041966384L),
			java.util.Map.entry("get_custom_monitor", 2138907829L),
			java.util.Map.entry("get_custom_monitor_names", 2915620761L),
			java.util.Map.entry("get_custom_monitor_types", 969006518L),
			java.util.Map.entry("remove_custom_monitor", 3304788590L));

	Performance(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Performance(long nativePointer) {
		super(nativePointer);
	}

	public double get_monitor(int monitor) {
		return (double) super.call("get_monitor", new java.lang.Object[]{java.lang.Integer.valueOf(monitor)});
	}

	public void add_custom_monitor(String id, Callable callable, GodotArray arguments, int type) {
		super.call("add_custom_monitor", new java.lang.Object[]{(java.lang.Object) id, (java.lang.Object) callable,
				(java.lang.Object) arguments, java.lang.Integer.valueOf(type)});
	}

	public void remove_custom_monitor(String id) {
		super.call("remove_custom_monitor", new java.lang.Object[]{(java.lang.Object) id});
	}

	public boolean has_custom_monitor(String id) {
		return (boolean) super.call("has_custom_monitor", new java.lang.Object[]{(java.lang.Object) id});
	}

	public Object get_custom_monitor(String id) {
		return (Object) super.call("get_custom_monitor", new java.lang.Object[]{(java.lang.Object) id});
	}
}
