package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class JNISingleton extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("has_java_method", 2619796661L));

	JNISingleton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	JNISingleton(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_java_method(String method) {
		return (boolean) super.call("has_java_method", new java.lang.Object[]{(java.lang.Object) method});
	}
}
