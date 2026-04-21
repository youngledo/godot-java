package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class TextServerManager extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_interfaces", 3995934104L), java.util.Map.entry("get_interface", 1672475555L),
			java.util.Map.entry("set_primary_interface", 1799689403L),
			java.util.Map.entry("remove_interface", 1799689403L),
			java.util.Map.entry("get_interface_count", 3905245786L), java.util.Map.entry("add_interface", 1799689403L),
			java.util.Map.entry("get_primary_interface", 905850878L),
			java.util.Map.entry("find_interface", 2240905781L));

	TextServerManager(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextServerManager(long nativePointer) {
		super(nativePointer);
	}

	public void add_interface(TextServer interface_) {
		super.call("add_interface", new java.lang.Object[]{(java.lang.Object) interface_});
	}

	public void remove_interface(TextServer interface_) {
		super.call("remove_interface", new java.lang.Object[]{(java.lang.Object) interface_});
	}

	public TextServer get_interface(long idx) {
		return (TextServer) super.call("get_interface", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public TextServer find_interface(String name) {
		return (TextServer) super.call("find_interface", new java.lang.Object[]{(java.lang.Object) name});
	}
}
