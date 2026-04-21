package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class AudioEffectInstance extends RefCounted {
	AudioEffectInstance(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectInstance(long nativePointer) {
		super(nativePointer);
	}
}
