package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class TextureLayered extends Texture {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_width", 3905245786L), java.util.Map.entry("get_layered_type", 518123893L),
			java.util.Map.entry("get_format", 3847873762L), java.util.Map.entry("get_layers", 3905245786L),
			java.util.Map.entry("get_layer_data", 3655284255L), java.util.Map.entry("get_height", 3905245786L),
			java.util.Map.entry("has_mipmaps", 36873697L));

	TextureLayered(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextureLayered(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_mipmaps() {
		return (boolean) super.call("has_mipmaps");
	}

	public Image get_layer_data(long layer) {
		return (Image) super.call("get_layer_data", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}
}
