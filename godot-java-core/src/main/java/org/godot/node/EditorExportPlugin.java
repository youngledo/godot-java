package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class EditorExportPlugin extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_export_platform", 282254641L),
			java.util.Map.entry("get_export_preset", 1610607222L), java.util.Map.entry("add_ios_framework", 83702148L),
			java.util.Map.entry("add_ios_cpp_code", 83702148L), java.util.Map.entry("add_macos_plugin_file", 83702148L),
			java.util.Map.entry("add_apple_embedded_platform_framework", 83702148L),
			java.util.Map.entry("add_file", 527928637L),
			java.util.Map.entry("add_apple_embedded_platform_bundle_file", 83702148L),
			java.util.Map.entry("skip", 3218959716L),
			java.util.Map.entry("add_apple_embedded_platform_linker_flags", 83702148L),
			java.util.Map.entry("add_ios_embedded_framework", 83702148L),
			java.util.Map.entry("add_ios_linker_flags", 83702148L),
			java.util.Map.entry("add_apple_embedded_platform_embedded_framework", 83702148L),
			java.util.Map.entry("add_ios_bundle_file", 83702148L), java.util.Map.entry("get_option", 2760726917L),
			java.util.Map.entry("add_ios_project_static_lib", 83702148L),
			java.util.Map.entry("add_apple_embedded_platform_cpp_code", 83702148L),
			java.util.Map.entry("add_ios_plist_content", 83702148L),
			java.util.Map.entry("add_apple_embedded_platform_project_static_lib", 83702148L),
			java.util.Map.entry("add_apple_embedded_platform_plist_content", 83702148L),
			java.util.Map.entry("add_shared_object", 3098291045L));

	EditorExportPlugin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorExportPlugin(long nativePointer) {
		super(nativePointer);
	}

	public void add_shared_object(String path, String[] tags, String target) {
		super.call("add_shared_object",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) tags, (java.lang.Object) target});
	}

	public void add_file(String path, byte[] file, boolean remap) {
		super.call("add_file", new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) file,
				java.lang.Boolean.valueOf(remap)});
	}

	public void add_apple_embedded_platform_project_static_lib(String path) {
		super.call("add_apple_embedded_platform_project_static_lib", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void add_apple_embedded_platform_framework(String path) {
		super.call("add_apple_embedded_platform_framework", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void add_apple_embedded_platform_embedded_framework(String path) {
		super.call("add_apple_embedded_platform_embedded_framework", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void add_apple_embedded_platform_plist_content(String plist_content) {
		super.call("add_apple_embedded_platform_plist_content",
				new java.lang.Object[]{(java.lang.Object) plist_content});
	}

	public void add_apple_embedded_platform_linker_flags(String flags) {
		super.call("add_apple_embedded_platform_linker_flags", new java.lang.Object[]{(java.lang.Object) flags});
	}

	public void add_apple_embedded_platform_bundle_file(String path) {
		super.call("add_apple_embedded_platform_bundle_file", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void add_apple_embedded_platform_cpp_code(String code) {
		super.call("add_apple_embedded_platform_cpp_code", new java.lang.Object[]{(java.lang.Object) code});
	}

	public void add_ios_project_static_lib(String path) {
		super.call("add_ios_project_static_lib", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void add_ios_framework(String path) {
		super.call("add_ios_framework", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void add_ios_embedded_framework(String path) {
		super.call("add_ios_embedded_framework", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void add_ios_plist_content(String plist_content) {
		super.call("add_ios_plist_content", new java.lang.Object[]{(java.lang.Object) plist_content});
	}

	public void add_ios_linker_flags(String flags) {
		super.call("add_ios_linker_flags", new java.lang.Object[]{(java.lang.Object) flags});
	}

	public void add_ios_bundle_file(String path) {
		super.call("add_ios_bundle_file", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void add_ios_cpp_code(String code) {
		super.call("add_ios_cpp_code", new java.lang.Object[]{(java.lang.Object) code});
	}

	public void add_macos_plugin_file(String path) {
		super.call("add_macos_plugin_file", new java.lang.Object[]{(java.lang.Object) path});
	}

	public void skip() {
		super.call("skip");
	}

	public Object get_option(String name) {
		return (Object) super.call("get_option", new java.lang.Object[]{(java.lang.Object) name});
	}
}
