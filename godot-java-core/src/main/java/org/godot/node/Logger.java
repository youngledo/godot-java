package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class Logger extends RefCounted {
	Logger(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Logger(long nativePointer) {
		super(nativePointer);
	}
}
