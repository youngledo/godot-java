package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotArray;

public class ResourceLoader extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("load_threaded_request", 3614384323L),
			java.util.Map.entry("load_threaded_get_status", 4137685479L),
			java.util.Map.entry("set_abort_on_missing_resources", 2586408642L),
			java.util.Map.entry("add_resource_format_loader", 2896595483L),
			java.util.Map.entry("load_threaded_get", 1748875256L), java.util.Map.entry("list_directory", 3538744774L),
			java.util.Map.entry("get_resource_uid", 1597066294L), java.util.Map.entry("load", 3358495409L),
			java.util.Map.entry("get_dependencies", 3538744774L),
			java.util.Map.entry("get_recognized_extensions_for_type", 3538744774L),
			java.util.Map.entry("has_cached", 2323990056L), java.util.Map.entry("exists", 4185558881L),
			java.util.Map.entry("remove_resource_format_loader", 405397102L),
			java.util.Map.entry("get_cached_ref", 1748875256L));

	ResourceLoader(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceLoader(long nativePointer) {
		super(nativePointer);
	}

	public int load_threaded_request(String path, String type_hint, boolean use_sub_threads, int cache_mode) {
		return (int) super.call("load_threaded_request",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) type_hint,
						java.lang.Boolean.valueOf(use_sub_threads), java.lang.Integer.valueOf(cache_mode)});
	}

	public int load_threaded_get_status(String path, GodotArray progress) {
		return (int) super.call("load_threaded_get_status",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) progress});
	}

	public Resource load_threaded_get(String path) {
		return (Resource) super.call("load_threaded_get", new java.lang.Object[]{(java.lang.Object) path});
	}

	public Resource load(String path, String type_hint, int cache_mode) {
		return (Resource) super.call("load", new java.lang.Object[]{(java.lang.Object) path,
				(java.lang.Object) type_hint, java.lang.Integer.valueOf(cache_mode)});
	}

	public String[] get_recognized_extensions_for_type(String type) {
		return (String[]) super.call("get_recognized_extensions_for_type",
				new java.lang.Object[]{(java.lang.Object) type});
	}

	public void add_resource_format_loader(ResourceFormatLoader format_loader, boolean at_front) {
		super.call("add_resource_format_loader",
				new java.lang.Object[]{(java.lang.Object) format_loader, java.lang.Boolean.valueOf(at_front)});
	}

	public void remove_resource_format_loader(ResourceFormatLoader format_loader) {
		super.call("remove_resource_format_loader", new java.lang.Object[]{(java.lang.Object) format_loader});
	}

	public String[] get_dependencies(String path) {
		return (String[]) super.call("get_dependencies", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean has_cached(String path) {
		return (boolean) super.call("has_cached", new java.lang.Object[]{(java.lang.Object) path});
	}

	public Resource get_cached_ref(String path) {
		return (Resource) super.call("get_cached_ref", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean exists(String path, String type_hint) {
		return (boolean) super.call("exists",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) type_hint});
	}

	public long get_resource_uid(String path) {
		return (long) super.call("get_resource_uid", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String[] list_directory(String directory_path) {
		return (String[]) super.call("list_directory", new java.lang.Object[]{(java.lang.Object) directory_path});
	}
}
