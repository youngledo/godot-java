package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ImageTextureLayered extends TextureLayered {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("create_from_images", 2785773503L), java.util.Map.entry("update_layer", 3331733361L));

	ImageTextureLayered(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ImageTextureLayered(long nativePointer) {
		super(nativePointer);
	}

	public int create_from_images(Image[] images) {
		return (int) super.call("create_from_images", new java.lang.Object[]{(java.lang.Object) images});
	}

	public void update_layer(Image image, long layer) {
		super.call("update_layer", new java.lang.Object[]{(java.lang.Object) image, java.lang.Long.valueOf(layer)});
	}
}
