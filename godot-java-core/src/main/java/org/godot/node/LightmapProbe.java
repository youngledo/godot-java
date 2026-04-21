package org.godot.node;

import java.lang.foreign.MemorySegment;

public class LightmapProbe extends Node3D {
	LightmapProbe(MemorySegment nativePointer) {
		super(nativePointer);
	}

	LightmapProbe(long nativePointer) {
		super(nativePointer);
	}
}
