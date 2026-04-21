package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class GDExtensionManager extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_loaded_extensions", 1139954409L),
			java.util.Map.entry("load_extension", 4024158731L), java.util.Map.entry("reload_extension", 4024158731L),
			java.util.Map.entry("is_extension_loaded", 3927539163L),
			java.util.Map.entry("load_extension_from_function", 1565094761L),
			java.util.Map.entry("unload_extension", 4024158731L), java.util.Map.entry("get_extension", 49743343L));

	GDExtensionManager(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GDExtensionManager(long nativePointer) {
		super(nativePointer);
	}

	public int load_extension(String path) {
		return (int) super.call("load_extension", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int load_extension_from_function(String path, Object init_func) {
		return (int) super.call("load_extension_from_function",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) init_func});
	}

	public int reload_extension(String path) {
		return (int) super.call("reload_extension", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int unload_extension(String path) {
		return (int) super.call("unload_extension", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean is_extension_loaded(String path) {
		return (boolean) super.call("is_extension_loaded", new java.lang.Object[]{(java.lang.Object) path});
	}

	public GDExtension get_extension(String path) {
		return (GDExtension) super.call("get_extension", new java.lang.Object[]{(java.lang.Object) path});
	}
}
