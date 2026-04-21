package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioStreamPlaybackPlaylist extends AudioStreamPlayback {
	AudioStreamPlaybackPlaylist(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamPlaybackPlaylist(long nativePointer) {
		super(nativePointer);
	}
}
