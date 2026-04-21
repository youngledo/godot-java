package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Texture3DRD extends Texture3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_texture_rd_rid", 2722037293L),
			java.util.Map.entry("get_texture_rd_rid", 2944877500L));

	Texture3DRD(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Texture3DRD(long nativePointer) {
		super(nativePointer);
	}

	public long getTexture_rd_rid() {
		return (long) super.call("get_texture_rd_rid", new java.lang.Object[0]);
	}

	public void setTexture_rd_rid(long value) {
		super.call("set_texture_rd_rid", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
