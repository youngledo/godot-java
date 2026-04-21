package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class GridContainer extends Container {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_columns", 1286410249L), java.util.Map.entry("get_columns", 3905245786L));

	GridContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GridContainer(long nativePointer) {
		super(nativePointer);
	}

	public long getColumns() {
		return (long) super.call("get_columns", new java.lang.Object[0]);
	}

	public void setColumns(long value) {
		super.call("set_columns", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
