package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OptimizedTranslation extends Translation {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("generate", 1466479800L));

	OptimizedTranslation(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OptimizedTranslation(long nativePointer) {
		super(nativePointer);
	}

	public void generate(Translation from) {
		super.call("generate", new java.lang.Object[]{(java.lang.Object) from});
	}
}
