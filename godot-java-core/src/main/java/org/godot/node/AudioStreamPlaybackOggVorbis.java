package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioStreamPlaybackOggVorbis extends AudioStreamPlaybackResampled {
	AudioStreamPlaybackOggVorbis(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamPlaybackOggVorbis(long nativePointer) {
		super(nativePointer);
	}
}
