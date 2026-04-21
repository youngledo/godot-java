package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class EditorNode3DGizmoPlugin extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("create_handle_material", 2486475223L),
			java.util.Map.entry("create_icon_material", 3804976916L), java.util.Map.entry("get_material", 974464017L),
			java.util.Map.entry("create_material", 3486012546L), java.util.Map.entry("add_material", 1374068695L));

	EditorNode3DGizmoPlugin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorNode3DGizmoPlugin(long nativePointer) {
		super(nativePointer);
	}

	public void create_material(String name, Color color, boolean billboard, boolean on_top, boolean use_vertex_color) {
		super.call("create_material",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) color,
						java.lang.Boolean.valueOf(billboard), java.lang.Boolean.valueOf(on_top),
						java.lang.Boolean.valueOf(use_vertex_color)});
	}

	public void create_icon_material(String name, Texture2D texture, boolean on_top, Color color) {
		super.call("create_icon_material", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) texture,
				java.lang.Boolean.valueOf(on_top), (java.lang.Object) color});
	}

	public void create_handle_material(String name, boolean billboard, Texture2D texture) {
		super.call("create_handle_material", new java.lang.Object[]{(java.lang.Object) name,
				java.lang.Boolean.valueOf(billboard), (java.lang.Object) texture});
	}

	public void add_material(String name, StandardMaterial3D material) {
		super.call("add_material", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) material});
	}

	public StandardMaterial3D get_material(String name, EditorNode3DGizmo gizmo) {
		return (StandardMaterial3D) super.call("get_material",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) gizmo});
	}
}
