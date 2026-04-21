package org.godot.core;

import org.godot.Godot;
import java.lang.foreign.MemorySegment;

/**
 * Base for Godot reference-counted objects (RefCounted). RefCounted objects are
 * Godot's reference-counted base class, similar to Java's reference counting
 * but managed by Godot's memory system.
 */
public class RefCounted extends Godot {

	protected RefCounted() {
		this(0);
	}

	protected RefCounted(MemorySegment nativePtr) {
		super(nativePtr);
	}

	protected RefCounted(long nativeObject) {
		super(nativeObject);
	}

	/** Create a new RefCounted wrapper for an existing native object. */
	public static RefCounted fromNative(long nativePtr) {
		if (nativePtr == 0)
			return null;
		RefCounted obj = new RefCounted(nativePtr);
		org.godot.internal.ref.JavaObjectMap.put(nativePtr, obj);
		return obj;
	}

	/** Reference this object (increment Godot reference count). */
	public void reference() {
		if (nativeObject == 0)
			return;
		call("reference");
	}

	/** Unreference this object (decrement Godot reference count). */
	public void unreference() {
		if (nativeObject == 0)
			return;
		call("unreference");
		// After unreference, the object may have been freed — invalidate wrapper
		free();
	}
}
