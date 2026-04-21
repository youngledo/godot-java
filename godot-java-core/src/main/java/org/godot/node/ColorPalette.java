package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ColorPalette extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_colors", 3546319833L), java.util.Map.entry("get_colors", 1392750486L));

	ColorPalette(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ColorPalette(long nativePointer) {
		super(nativePointer);
	}

	public double[][] getColors() {
		return (double[][]) super.call("get_colors", new java.lang.Object[0]);
	}

	public void setColors(double[][] value) {
		super.call("set_colors", new java.lang.Object[]{(java.lang.Object) value});
	}
}
