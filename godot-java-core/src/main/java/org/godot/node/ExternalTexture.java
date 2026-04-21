package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class ExternalTexture extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_size", 743155724L), java.util.Map.entry("get_external_texture_id", 3905245786L),
			java.util.Map.entry("set_external_buffer_id", 1286410249L));

	ExternalTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ExternalTexture(long nativePointer) {
		super(nativePointer);
	}

	public Vector2 getSize() {
		return (Vector2) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector2 value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}
}
