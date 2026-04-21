package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class ImageFormatLoader extends RefCounted {
	ImageFormatLoader(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ImageFormatLoader(long nativePointer) {
		super(nativePointer);
	}
}
