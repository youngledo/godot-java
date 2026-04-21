package org.godot.node;

import java.lang.foreign.MemorySegment;

public class LightmapperRD extends Lightmapper {
	LightmapperRD(MemorySegment nativePointer) {
		super(nativePointer);
	}

	LightmapperRD(long nativePointer) {
		super(nativePointer);
	}
}
