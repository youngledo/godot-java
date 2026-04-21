package org.godot;

import java.lang.foreign.MemorySegment;

/**
 * Base class for all Godot engine objects. This class represents the Godot C++
 * Object type used in the extension API. Generated classes that need this type
 * should use {@link Godot} directly.
 */
public class GodotObject extends Godot {

	protected GodotObject() {
	}

	protected GodotObject(MemorySegment nativePtr) {
		super(nativePtr);
	}

	protected GodotObject(long nativePtr) {
		super(nativePtr);
	}
}
