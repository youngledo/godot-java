package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.math.Transform3D;

public class MeshLibrary extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_item_navigation_mesh_transform", 3616898986L),
			java.util.Map.entry("get_item_name", 844755477L),
			java.util.Map.entry("get_item_navigation_layers", 923996154L),
			java.util.Map.entry("set_item_shapes", 537221740L),
			java.util.Map.entry("set_item_navigation_layers", 3937882851L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("get_item_shapes", 663333327L), java.util.Map.entry("set_item_name", 501894301L),
			java.util.Map.entry("find_item_by_name", 1321353865L), java.util.Map.entry("set_item_mesh", 969122797L),
			java.util.Map.entry("get_item_list", 1930428628L),
			java.util.Map.entry("set_item_mesh_transform", 3616898986L),
			java.util.Map.entry("get_item_mesh_transform", 1965739696L),
			java.util.Map.entry("set_item_preview", 666127730L),
			java.util.Map.entry("get_last_unused_item_id", 3905245786L),
			java.util.Map.entry("get_item_navigation_mesh", 2729647406L),
			java.util.Map.entry("set_item_mesh_cast_shadow", 3923400443L),
			java.util.Map.entry("remove_item", 1286410249L), java.util.Map.entry("get_item_preview", 3536238170L),
			java.util.Map.entry("create_item", 1286410249L),
			java.util.Map.entry("get_item_mesh_cast_shadow", 1841766007L),
			java.util.Map.entry("get_item_navigation_mesh_transform", 1965739696L),
			java.util.Map.entry("get_item_mesh", 1576363275L),
			java.util.Map.entry("set_item_navigation_mesh", 3483353960L));

	MeshLibrary(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MeshLibrary(long nativePointer) {
		super(nativePointer);
	}

	public void create_item(long id) {
		super.call("create_item", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void set_item_name(long id, String name) {
		super.call("set_item_name", new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) name});
	}

	public void set_item_mesh(long id, Mesh mesh) {
		super.call("set_item_mesh", new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) mesh});
	}

	public void set_item_mesh_transform(long id, Transform3D mesh_transform) {
		super.call("set_item_mesh_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) mesh_transform});
	}

	public void set_item_mesh_cast_shadow(long id, int shadow_casting_setting) {
		super.call("set_item_mesh_cast_shadow",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Integer.valueOf(shadow_casting_setting)});
	}

	public void set_item_navigation_mesh(long id, NavigationMesh navigation_mesh) {
		super.call("set_item_navigation_mesh",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) navigation_mesh});
	}

	public void set_item_navigation_mesh_transform(long id, Transform3D navigation_mesh) {
		super.call("set_item_navigation_mesh_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) navigation_mesh});
	}

	public void set_item_navigation_layers(long id, long navigation_layers) {
		super.call("set_item_navigation_layers",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Long.valueOf(navigation_layers)});
	}

	public void set_item_shapes(long id, GodotArray shapes) {
		super.call("set_item_shapes", new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) shapes});
	}

	public void set_item_preview(long id, Texture2D texture) {
		super.call("set_item_preview", new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) texture});
	}

	public String get_item_name(long id) {
		return (String) super.call("get_item_name", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public Mesh get_item_mesh(long id) {
		return (Mesh) super.call("get_item_mesh", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public Transform3D get_item_mesh_transform(long id) {
		return (Transform3D) super.call("get_item_mesh_transform", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public int get_item_mesh_cast_shadow(long id) {
		return (int) super.call("get_item_mesh_cast_shadow", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public NavigationMesh get_item_navigation_mesh(long id) {
		return (NavigationMesh) super.call("get_item_navigation_mesh",
				new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public Transform3D get_item_navigation_mesh_transform(long id) {
		return (Transform3D) super.call("get_item_navigation_mesh_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public long get_item_navigation_layers(long id) {
		return (long) super.call("get_item_navigation_layers", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public GodotArray get_item_shapes(long id) {
		return (GodotArray) super.call("get_item_shapes", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public Texture2D get_item_preview(long id) {
		return (Texture2D) super.call("get_item_preview", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void remove_item(long id) {
		super.call("remove_item", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public int find_item_by_name(String name) {
		return (int) super.call("find_item_by_name", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void clear() {
		super.call("clear");
	}
}
