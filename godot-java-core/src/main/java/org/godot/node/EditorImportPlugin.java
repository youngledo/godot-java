package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;

public class EditorImportPlugin extends ResourceImporter {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("append_import_external_resource", 320493106L));

	EditorImportPlugin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorImportPlugin(long nativePointer) {
		super(nativePointer);
	}

	public int append_import_external_resource(String path, GodotDictionary custom_options, String custom_importer,
			Object generator_parameters) {
		return (int) super.call("append_import_external_resource",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) custom_options,
						(java.lang.Object) custom_importer, (java.lang.Object) generator_parameters});
	}
}
