package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class OpenXRStructureBase extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_next", 2798796760L), java.util.Map.entry("set_next", 334698771L),
			java.util.Map.entry("get_structure_type", 2455072627L));

	OpenXRStructureBase(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRStructureBase(long nativePointer) {
		super(nativePointer);
	}

	public OpenXRStructureBase getNext() {
		return (OpenXRStructureBase) super.call("get_next", new java.lang.Object[0]);
	}

	public void setNext(OpenXRStructureBase value) {
		super.call("set_next", new java.lang.Object[]{(java.lang.Object) value});
	}
}
