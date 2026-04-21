package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.Godot;

public class MainLoop extends Godot {
	MainLoop(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MainLoop(long nativePointer) {
		super(nativePointer);
	}
}
