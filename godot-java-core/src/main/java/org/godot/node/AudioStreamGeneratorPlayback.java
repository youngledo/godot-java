package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class AudioStreamGeneratorPlayback extends AudioStreamPlaybackResampled {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("clear_buffer", 3218959716L), java.util.Map.entry("push_buffer", 1361156557L),
			java.util.Map.entry("can_push_buffer", 1116898809L),
			java.util.Map.entry("get_frames_available", 3905245786L), java.util.Map.entry("push_frame", 3975407249L),
			java.util.Map.entry("get_skips", 3905245786L));

	AudioStreamGeneratorPlayback(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamGeneratorPlayback(long nativePointer) {
		super(nativePointer);
	}

	public boolean push_frame(Vector2 frame) {
		return (boolean) super.call("push_frame", new java.lang.Object[]{(java.lang.Object) frame});
	}

	public boolean can_push_buffer(long amount) {
		return (boolean) super.call("can_push_buffer", new java.lang.Object[]{java.lang.Long.valueOf(amount)});
	}

	public boolean push_buffer(double[][] frames) {
		return (boolean) super.call("push_buffer", new java.lang.Object[]{(java.lang.Object) frames});
	}

	public void clear_buffer() {
		super.call("clear_buffer");
	}
}
