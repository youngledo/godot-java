package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ImageTexture3D extends Texture3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("create", 1130379827L), java.util.Map.entry("update", 381264803L));

	ImageTexture3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ImageTexture3D(long nativePointer) {
		super(nativePointer);
	}

	public int create(int format, long width, long height, long depth, boolean use_mipmaps, Image[] data) {
		return (int) super.call("create",
				new java.lang.Object[]{java.lang.Integer.valueOf(format), java.lang.Long.valueOf(width),
						java.lang.Long.valueOf(height), java.lang.Long.valueOf(depth),
						java.lang.Boolean.valueOf(use_mipmaps), (java.lang.Object) data});
	}

	public void update(Image[] data) {
		super.call("update", new java.lang.Object[]{(java.lang.Object) data});
	}
}
