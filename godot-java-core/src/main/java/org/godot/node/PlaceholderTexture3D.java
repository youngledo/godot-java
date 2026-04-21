package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3i;

public class PlaceholderTexture3D extends Texture3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_size", 560364750L), java.util.Map.entry("get_size", 2785653706L));

	PlaceholderTexture3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PlaceholderTexture3D(long nativePointer) {
		super(nativePointer);
	}

	public Vector3i getSize() {
		return (Vector3i) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector3i value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}
}
