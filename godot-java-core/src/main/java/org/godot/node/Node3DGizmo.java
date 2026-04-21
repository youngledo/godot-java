package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class Node3DGizmo extends RefCounted {
	Node3DGizmo(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Node3DGizmo(long nativePointer) {
		super(nativePointer);
	}
}
