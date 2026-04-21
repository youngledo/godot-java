package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class JavaClass extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_java_method_list", 3995934104L),
			java.util.Map.entry("has_java_method", 2619796661L),
			java.util.Map.entry("get_java_parent_class", 541536347L),
			java.util.Map.entry("get_java_class_name", 201670096L));

	JavaClass(MemorySegment nativePointer) {
		super(nativePointer);
	}

	JavaClass(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_java_method(String method) {
		return (boolean) super.call("has_java_method", new java.lang.Object[]{(java.lang.Object) method});
	}
}
