package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.core.Callable;

public class NavigationServer2DManager extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("register_server", 2137474292L),
			java.util.Map.entry("set_default_server", 2956805083L));

	NavigationServer2DManager(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationServer2DManager(long nativePointer) {
		super(nativePointer);
	}

	public void register_server(String name, Callable create_callback) {
		super.call("register_server",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) create_callback});
	}

	public void set_default_server(String name, long priority) {
		super.call("set_default_server",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Long.valueOf(priority)});
	}
}
