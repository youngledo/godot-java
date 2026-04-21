package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2i;

public class PlaceholderTextureLayered extends TextureLayered {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_size", 1130785943L), java.util.Map.entry("get_size", 3690982128L),
			java.util.Map.entry("set_layers", 1286410249L));

	PlaceholderTextureLayered(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PlaceholderTextureLayered(long nativePointer) {
		super(nativePointer);
	}

	public Vector2i getSize() {
		return (Vector2i) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector2i value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getLayers() {
		return (long) super.call("get_layers", new java.lang.Object[0]);
	}

	public void setLayers(long value) {
		super.call("set_layers", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
