package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class GLTFTexture extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_src_image", 3905245786L), java.util.Map.entry("set_src_image", 1286410249L),
			java.util.Map.entry("set_sampler", 1286410249L), java.util.Map.entry("get_sampler", 3905245786L));

	GLTFTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFTexture(long nativePointer) {
		super(nativePointer);
	}

	public long getSrc_image() {
		return (long) super.call("get_src_image", new java.lang.Object[0]);
	}

	public void setSrc_image(long value) {
		super.call("set_src_image", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSampler() {
		return (long) super.call("get_sampler", new java.lang.Object[0]);
	}

	public void setSampler(long value) {
		super.call("set_sampler", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
