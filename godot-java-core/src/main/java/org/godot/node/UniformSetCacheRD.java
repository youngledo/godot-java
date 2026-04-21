package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class UniformSetCacheRD extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_cache", 658571723L));

	UniformSetCacheRD(MemorySegment nativePointer) {
		super(nativePointer);
	}

	UniformSetCacheRD(long nativePointer) {
		super(nativePointer);
	}

	public long get_cache(long shader, long set, RDUniform[] uniforms) {
		return (long) super.call("get_cache", new java.lang.Object[]{java.lang.Long.valueOf(shader),
				java.lang.Long.valueOf(set), (java.lang.Object) uniforms});
	}
}
