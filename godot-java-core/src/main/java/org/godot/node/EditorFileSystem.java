package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class EditorFileSystem extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("scan_sources", 3218959716L), java.util.Map.entry("reimport_files", 4015028928L),
			java.util.Map.entry("get_filesystem", 842323275L), java.util.Map.entry("get_filesystem_path", 3188521125L),
			java.util.Map.entry("get_scanning_progress", 1740695150L), java.util.Map.entry("scan", 3218959716L),
			java.util.Map.entry("update_file", 83702148L), java.util.Map.entry("is_scanning", 36873697L),
			java.util.Map.entry("get_file_type", 3135753539L));

	EditorFileSystem(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorFileSystem(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_scanning() {
		return (boolean) super.call("is_scanning");
	}

	public void scan() {
		super.call("scan");
	}

	public void scan_sources() {
		super.call("scan_sources");
	}

	public void update_file(String path) {
		super.call("update_file", new java.lang.Object[]{(java.lang.Object) path});
	}

	public EditorFileSystemDirectory get_filesystem_path(String path) {
		return (EditorFileSystemDirectory) super.call("get_filesystem_path",
				new java.lang.Object[]{(java.lang.Object) path});
	}

	public String get_file_type(String path) {
		return (String) super.call("get_file_type", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void reimport_files(String[] files) {
		super.call("reimport_files", new java.lang.Object[]{(java.lang.Object) files});
	}
}
