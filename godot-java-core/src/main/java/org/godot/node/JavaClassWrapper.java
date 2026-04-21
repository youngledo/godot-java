package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class JavaClassWrapper extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_exception", 3277089691L), java.util.Map.entry("wrap", 1124367868L));

	JavaClassWrapper(MemorySegment nativePointer) {
		super(nativePointer);
	}

	JavaClassWrapper(long nativePointer) {
		super(nativePointer);
	}

	public JavaClass wrap(String name) {
		return (JavaClass) super.call("wrap", new java.lang.Object[]{(java.lang.Object) name});
	}
}
