package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.math.AABB;
import org.godot.math.Transform3D;

public class ArrayMesh extends Mesh {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("surface_update_attribute_region", 3837166854L),
			java.util.Map.entry("surface_get_format", 3718287884L),
			java.util.Map.entry("set_blend_shape_mode", 227983991L), java.util.Map.entry("surface_remove", 1286410249L),
			java.util.Map.entry("surface_get_array_index_len", 923996154L),
			java.util.Map.entry("clear_surfaces", 3218959716L),
			java.util.Map.entry("surface_find_by_name", 1321353865L),
			java.util.Map.entry("surface_update_skin_region", 3837166854L),
			java.util.Map.entry("get_custom_aabb", 1068685055L), java.util.Map.entry("surface_get_name", 844755477L),
			java.util.Map.entry("add_surface_from_arrays", 1796411378L),
			java.util.Map.entry("get_shadow_mesh", 3206942465L), java.util.Map.entry("surface_set_name", 501894301L),
			java.util.Map.entry("lightmap_unwrap", 1476641071L), java.util.Map.entry("clear_blend_shapes", 3218959716L),
			java.util.Map.entry("surface_get_primitive_type", 4141943888L),
			java.util.Map.entry("surface_get_array_len", 923996154L),
			java.util.Map.entry("set_shadow_mesh", 3377897901L), java.util.Map.entry("add_blend_shape", 3304788590L),
			java.util.Map.entry("get_blend_shape_name", 659327637L), java.util.Map.entry("set_custom_aabb", 259215842L),
			java.util.Map.entry("set_blend_shape_name", 3780747571L),
			java.util.Map.entry("regen_normal_maps", 3218959716L),
			java.util.Map.entry("get_blend_shape_mode", 836485024L),
			java.util.Map.entry("get_blend_shape_count", 3905245786L),
			java.util.Map.entry("surface_update_vertex_region", 3837166854L));

	ArrayMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ArrayMesh(long nativePointer) {
		super(nativePointer);
	}

	public void add_blend_shape(String name) {
		super.call("add_blend_shape", new java.lang.Object[]{(java.lang.Object) name});
	}

	public String get_blend_shape_name(long index) {
		return (String) super.call("get_blend_shape_name", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_blend_shape_name(long index, String name) {
		super.call("set_blend_shape_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) name});
	}

	public void clear_blend_shapes() {
		super.call("clear_blend_shapes");
	}

	public void add_surface_from_arrays(int primitive, GodotArray arrays, GodotArray[] blend_shapes,
			GodotDictionary lods, int flags) {
		super.call("add_surface_from_arrays",
				new java.lang.Object[]{java.lang.Integer.valueOf(primitive), (java.lang.Object) arrays,
						(java.lang.Object) blend_shapes, (java.lang.Object) lods, java.lang.Integer.valueOf(flags)});
	}

	public void clear_surfaces() {
		super.call("clear_surfaces");
	}

	public void surface_remove(long surf_idx) {
		super.call("surface_remove", new java.lang.Object[]{java.lang.Long.valueOf(surf_idx)});
	}

	public void surface_update_vertex_region(long surf_idx, long offset, byte[] data) {
		super.call("surface_update_vertex_region", new java.lang.Object[]{java.lang.Long.valueOf(surf_idx),
				java.lang.Long.valueOf(offset), (java.lang.Object) data});
	}

	public void surface_update_attribute_region(long surf_idx, long offset, byte[] data) {
		super.call("surface_update_attribute_region", new java.lang.Object[]{java.lang.Long.valueOf(surf_idx),
				java.lang.Long.valueOf(offset), (java.lang.Object) data});
	}

	public void surface_update_skin_region(long surf_idx, long offset, byte[] data) {
		super.call("surface_update_skin_region", new java.lang.Object[]{java.lang.Long.valueOf(surf_idx),
				java.lang.Long.valueOf(offset), (java.lang.Object) data});
	}

	public int surface_get_array_len(long surf_idx) {
		return (int) super.call("surface_get_array_len", new java.lang.Object[]{java.lang.Long.valueOf(surf_idx)});
	}

	public int surface_get_array_index_len(long surf_idx) {
		return (int) super.call("surface_get_array_index_len",
				new java.lang.Object[]{java.lang.Long.valueOf(surf_idx)});
	}

	public int surface_get_format(long surf_idx) {
		return (int) super.call("surface_get_format", new java.lang.Object[]{java.lang.Long.valueOf(surf_idx)});
	}

	public int surface_get_primitive_type(long surf_idx) {
		return (int) super.call("surface_get_primitive_type", new java.lang.Object[]{java.lang.Long.valueOf(surf_idx)});
	}

	public int surface_find_by_name(String name) {
		return (int) super.call("surface_find_by_name", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void surface_set_name(long surf_idx, String name) {
		super.call("surface_set_name",
				new java.lang.Object[]{java.lang.Long.valueOf(surf_idx), (java.lang.Object) name});
	}

	public String surface_get_name(long surf_idx) {
		return (String) super.call("surface_get_name", new java.lang.Object[]{java.lang.Long.valueOf(surf_idx)});
	}

	public void regen_normal_maps() {
		super.call("regen_normal_maps");
	}

	public int lightmap_unwrap(Transform3D transform, double texel_size) {
		return (int) super.call("lightmap_unwrap",
				new java.lang.Object[]{(java.lang.Object) transform, java.lang.Double.valueOf(texel_size)});
	}

	public long getBlend_shape_mode() {
		return (long) super.call("get_blend_shape_mode", new java.lang.Object[0]);
	}

	public void setBlend_shape_mode(long value) {
		super.call("set_blend_shape_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public AABB getCustom_aabb() {
		return (AABB) super.call("get_custom_aabb", new java.lang.Object[0]);
	}

	public void setCustom_aabb(AABB value) {
		super.call("set_custom_aabb", new java.lang.Object[]{(java.lang.Object) value});
	}

	public ArrayMesh getShadow_mesh() {
		return (ArrayMesh) super.call("get_shadow_mesh", new java.lang.Object[0]);
	}

	public void setShadow_mesh(ArrayMesh value) {
		super.call("set_shadow_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}
}
