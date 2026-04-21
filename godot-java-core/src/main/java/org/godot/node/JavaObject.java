package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class JavaObject extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("has_java_method", 2619796661L), java.util.Map.entry("get_java_class", 541536347L));

	JavaObject(MemorySegment nativePointer) {
		super(nativePointer);
	}

	JavaObject(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_java_method(String method) {
		return (boolean) super.call("has_java_method", new java.lang.Object[]{(java.lang.Object) method});
	}
}
