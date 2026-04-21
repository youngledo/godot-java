package org.godot.internal.ref;

import org.godot.Godot;

/**
 * Generic wrapper for Godot objects that don't have a corresponding Java class.
 * Used for objects created by Godot (e.g., ClassDB.instantiate, get_children)
 * that were not created through the Java registration path.
 */
public class GenericGodotObject extends Godot {

	private final String className;

	public GenericGodotObject(long nativePtr, String className) {
		super(nativePtr);
		this.className = className;
	}

	@Override
	protected String getGodotClassName() {
		return className;
	}
}
