package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Basis;
import org.godot.math.Vector3;
import org.godot.math.Vector3i;

public class GridMap extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_collision_layer", 3905245786L),
			java.util.Map.entry("set_collision_mask_value", 300928843L),
			java.util.Map.entry("get_bake_meshes", 2915620761L), java.util.Map.entry("resource_changed", 968641751L),
			java.util.Map.entry("get_used_cells_by_item", 663333327L),
			java.util.Map.entry("get_collision_layer_value", 1116898809L),
			java.util.Map.entry("get_cell_scale", 1740695150L), java.util.Map.entry("get_center_x", 36873697L),
			java.util.Map.entry("get_used_cells", 3995934104L), java.util.Map.entry("get_center_z", 36873697L),
			java.util.Map.entry("get_navigation_map", 2944877500L), java.util.Map.entry("set_cell_item", 3449088946L),
			java.util.Map.entry("get_center_y", 36873697L), java.util.Map.entry("get_physics_material", 2521850424L),
			java.util.Map.entry("clear_baked_meshes", 3218959716L), java.util.Map.entry("set_octant_size", 1286410249L),
			java.util.Map.entry("get_collision_mask", 3905245786L), java.util.Map.entry("get_cell_size", 3360562783L),
			java.util.Map.entry("set_collision_layer_value", 300928843L),
			java.util.Map.entry("make_baked_meshes", 3609286057L),
			java.util.Map.entry("set_collision_mask", 1286410249L),
			java.util.Map.entry("get_basis_with_orthogonal_index", 2816196998L),
			java.util.Map.entry("get_octant_size", 3905245786L), java.util.Map.entry("map_to_local", 1088329196L),
			java.util.Map.entry("set_cell_size", 3460891852L),
			java.util.Map.entry("get_collision_mask_value", 1116898809L),
			java.util.Map.entry("get_collision_priority", 1740695150L),
			java.util.Map.entry("set_physics_material", 1784508650L),
			java.util.Map.entry("set_bake_navigation", 2586408642L),
			java.util.Map.entry("set_navigation_map", 2722037293L), java.util.Map.entry("set_center_z", 2586408642L),
			java.util.Map.entry("clear", 3218959716L), java.util.Map.entry("set_center_y", 2586408642L),
			java.util.Map.entry("get_orthogonal_index_from_basis", 4210359952L),
			java.util.Map.entry("get_meshes", 3995934104L), java.util.Map.entry("set_center_x", 2586408642L),
			java.util.Map.entry("set_collision_layer", 1286410249L),
			java.util.Map.entry("set_mesh_library", 1488083439L), java.util.Map.entry("get_cell_item", 3724960147L),
			java.util.Map.entry("get_mesh_library", 3350993772L),
			java.util.Map.entry("set_collision_priority", 373806689L),
			java.util.Map.entry("get_cell_item_basis", 3493604918L), java.util.Map.entry("local_to_map", 1257687843L),
			java.util.Map.entry("is_baking_navigation", 2240911060L),
			java.util.Map.entry("get_bake_mesh_instance", 937000113L),
			java.util.Map.entry("set_cell_scale", 373806689L),
			java.util.Map.entry("get_cell_item_orientation", 3724960147L));

	GridMap(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GridMap(long nativePointer) {
		super(nativePointer);
	}

	public void set_collision_mask_value(long layer_number, boolean value) {
		super.call("set_collision_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_collision_mask_value(long layer_number) {
		return (boolean) super.call("get_collision_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public void set_collision_layer_value(long layer_number, boolean value) {
		super.call("set_collision_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_collision_layer_value(long layer_number) {
		return (boolean) super.call("get_collision_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public boolean is_baking_navigation() {
		return (boolean) super.call("is_baking_navigation");
	}

	public void set_cell_item(Vector3i position, long item, long orientation) {
		super.call("set_cell_item", new java.lang.Object[]{(java.lang.Object) position, java.lang.Long.valueOf(item),
				java.lang.Long.valueOf(orientation)});
	}

	public int get_cell_item(Vector3i position) {
		return (int) super.call("get_cell_item", new java.lang.Object[]{(java.lang.Object) position});
	}

	public int get_cell_item_orientation(Vector3i position) {
		return (int) super.call("get_cell_item_orientation", new java.lang.Object[]{(java.lang.Object) position});
	}

	public Basis get_cell_item_basis(Vector3i position) {
		return (Basis) super.call("get_cell_item_basis", new java.lang.Object[]{(java.lang.Object) position});
	}

	public Basis get_basis_with_orthogonal_index(long index) {
		return (Basis) super.call("get_basis_with_orthogonal_index",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_orthogonal_index_from_basis(Basis basis) {
		return (int) super.call("get_orthogonal_index_from_basis", new java.lang.Object[]{(java.lang.Object) basis});
	}

	public Vector3i local_to_map(Vector3 local_position) {
		return (Vector3i) super.call("local_to_map", new java.lang.Object[]{(java.lang.Object) local_position});
	}

	public Vector3 map_to_local(Vector3i map_position) {
		return (Vector3) super.call("map_to_local", new java.lang.Object[]{(java.lang.Object) map_position});
	}

	public void resource_changed(Resource resource) {
		super.call("resource_changed", new java.lang.Object[]{(java.lang.Object) resource});
	}

	public void clear() {
		super.call("clear");
	}

	public Vector3i[] get_used_cells_by_item(long item) {
		return (Vector3i[]) super.call("get_used_cells_by_item", new java.lang.Object[]{java.lang.Long.valueOf(item)});
	}

	public long get_bake_mesh_instance(long idx) {
		return (long) super.call("get_bake_mesh_instance", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void clear_baked_meshes() {
		super.call("clear_baked_meshes");
	}

	public void make_baked_meshes(boolean gen_lightmap_uv, double lightmap_uv_texel_size) {
		super.call("make_baked_meshes", new java.lang.Object[]{java.lang.Boolean.valueOf(gen_lightmap_uv),
				java.lang.Double.valueOf(lightmap_uv_texel_size)});
	}

	public MeshLibrary getMesh_library() {
		return (MeshLibrary) super.call("get_mesh_library", new java.lang.Object[0]);
	}

	public void setMesh_library(MeshLibrary value) {
		super.call("set_mesh_library", new java.lang.Object[]{(java.lang.Object) value});
	}

	public PhysicsMaterial getPhysics_material() {
		return (PhysicsMaterial) super.call("get_physics_material", new java.lang.Object[0]);
	}

	public void setPhysics_material(PhysicsMaterial value) {
		super.call("set_physics_material", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getCell_size() {
		return (Vector3) super.call("get_cell_size", new java.lang.Object[0]);
	}

	public void setCell_size(Vector3 value) {
		super.call("set_cell_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getCell_octant_size() {
		return (long) super.call("get_octant_size", new java.lang.Object[0]);
	}

	public void setCell_octant_size(long value) {
		super.call("set_octant_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getCell_center_x() {
		return (boolean) super.call("get_center_x", new java.lang.Object[0]);
	}

	public void setCell_center_x(boolean value) {
		super.call("set_center_x", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getCell_center_y() {
		return (boolean) super.call("get_center_y", new java.lang.Object[0]);
	}

	public void setCell_center_y(boolean value) {
		super.call("set_center_y", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getCell_center_z() {
		return (boolean) super.call("get_center_z", new java.lang.Object[0]);
	}

	public void setCell_center_z(boolean value) {
		super.call("set_center_z", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getCell_scale() {
		return (double) super.call("get_cell_scale", new java.lang.Object[0]);
	}

	public void setCell_scale(double value) {
		super.call("set_cell_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getCollision_layer() {
		return (long) super.call("get_collision_layer", new java.lang.Object[0]);
	}

	public void setCollision_layer(long value) {
		super.call("set_collision_layer", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCollision_mask() {
		return (long) super.call("get_collision_mask", new java.lang.Object[0]);
	}

	public void setCollision_mask(long value) {
		super.call("set_collision_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getCollision_priority() {
		return (double) super.call("get_collision_priority", new java.lang.Object[0]);
	}

	public void setCollision_priority(double value) {
		super.call("set_collision_priority", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isBake_navigation() {
		return (boolean) super.call("is_baking_navigation", new java.lang.Object[0]);
	}

	public void setBake_navigation(boolean value) {
		super.call("set_bake_navigation", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
