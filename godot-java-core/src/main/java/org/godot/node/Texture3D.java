package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Texture3D extends Texture {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_width", 3905245786L), java.util.Map.entry("get_format", 3847873762L),
			java.util.Map.entry("create_placeholder", 121922552L), java.util.Map.entry("get_depth", 3905245786L),
			java.util.Map.entry("get_data", 3995934104L), java.util.Map.entry("get_height", 3905245786L),
			java.util.Map.entry("has_mipmaps", 36873697L));

	Texture3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Texture3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_mipmaps() {
		return (boolean) super.call("has_mipmaps");
	}

	public Resource create_placeholder() {
		return (Resource) super.call("create_placeholder");
	}
}
