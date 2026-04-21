package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ResourceImporterOggVorbis extends ResourceImporter {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("load_from_buffer", 354904730L), java.util.Map.entry("load_from_file", 797568536L));

	ResourceImporterOggVorbis(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceImporterOggVorbis(long nativePointer) {
		super(nativePointer);
	}

	public AudioStreamOggVorbis load_from_buffer(byte[] stream_data) {
		return (AudioStreamOggVorbis) super.call("load_from_buffer",
				new java.lang.Object[]{(java.lang.Object) stream_data});
	}

	public AudioStreamOggVorbis load_from_file(String path) {
		return (AudioStreamOggVorbis) super.call("load_from_file", new java.lang.Object[]{(java.lang.Object) path});
	}
}
