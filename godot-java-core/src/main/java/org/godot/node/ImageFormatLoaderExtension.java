package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ImageFormatLoaderExtension extends ImageFormatLoader {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_format_loader", 3218959716L),
			java.util.Map.entry("remove_format_loader", 3218959716L));

	ImageFormatLoaderExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ImageFormatLoaderExtension(long nativePointer) {
		super(nativePointer);
	}

	public void add_format_loader() {
		super.call("add_format_loader");
	}

	public void remove_format_loader() {
		super.call("remove_format_loader");
	}
}
