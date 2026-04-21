package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class EngineProfiler extends RefCounted {
	EngineProfiler(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EngineProfiler(long nativePointer) {
		super(nativePointer);
	}
}
