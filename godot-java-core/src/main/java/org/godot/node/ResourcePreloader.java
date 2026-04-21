package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;

public class ResourcePreloader extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("remove_resource", 3304788590L), java.util.Map.entry("rename_resource", 3740211285L),
			java.util.Map.entry("has_resource", 2619796661L), java.util.Map.entry("get_resource_list", 1139954409L),
			java.util.Map.entry("add_resource", 1168801743L), java.util.Map.entry("get_resource", 3742749261L));

	ResourcePreloader(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourcePreloader(long nativePointer) {
		super(nativePointer);
	}

	public void add_resource(String name, Resource resource) {
		super.call("add_resource", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) resource});
	}

	public void remove_resource(String name) {
		super.call("remove_resource", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void rename_resource(String name, String newname) {
		super.call("rename_resource", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) newname});
	}

	public boolean has_resource(String name) {
		return (boolean) super.call("has_resource", new java.lang.Object[]{(java.lang.Object) name});
	}

	public Resource get_resource(String name) {
		return (Resource) super.call("get_resource", new java.lang.Object[]{(java.lang.Object) name});
	}

	public GodotArray getResources() {
		return (GodotArray) super.call("_get_resources", new java.lang.Object[0]);
	}

	public void setResources(GodotArray value) {
		super.call("_set_resources", new java.lang.Object[]{(java.lang.Object) value});
	}
}
