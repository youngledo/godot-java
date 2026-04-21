package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ImageTexture extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_image", 532598488L), java.util.Map.entry("get_format", 3847873762L),
			java.util.Map.entry("create_from_image", 2775144163L), java.util.Map.entry("update", 532598488L),
			java.util.Map.entry("set_size_override", 1130785943L));

	ImageTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ImageTexture(long nativePointer) {
		super(nativePointer);
	}

	public ImageTexture create_from_image(Image image) {
		return (ImageTexture) super.call("create_from_image", new java.lang.Object[]{(java.lang.Object) image});
	}

	public void update(Image image) {
		super.call("update", new java.lang.Object[]{(java.lang.Object) image});
	}

	public Image getImage() {
		return (Image) super.call("get_image", new java.lang.Object[0]);
	}

	public void setImage(Image value) {
		super.call("_set_image", new java.lang.Object[]{(java.lang.Object) value});
	}
}
