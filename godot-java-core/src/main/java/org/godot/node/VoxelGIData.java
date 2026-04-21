package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.AABB;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class VoxelGIData extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_dynamic_range", 1740695150L), java.util.Map.entry("set_bias", 373806689L),
			java.util.Map.entry("get_data_cells", 2362200018L), java.util.Map.entry("set_energy", 373806689L),
			java.util.Map.entry("set_use_two_bounces", 2586408642L),
			java.util.Map.entry("get_to_cell_xform", 3229777777L), java.util.Map.entry("get_energy", 1740695150L),
			java.util.Map.entry("set_dynamic_range", 373806689L), java.util.Map.entry("get_bias", 1740695150L),
			java.util.Map.entry("get_bounds", 1068685055L), java.util.Map.entry("get_octree_size", 3360562783L),
			java.util.Map.entry("get_octree_cells", 2362200018L), java.util.Map.entry("get_propagation", 1740695150L),
			java.util.Map.entry("get_normal_bias", 1740695150L), java.util.Map.entry("allocate", 4041601946L),
			java.util.Map.entry("set_propagation", 373806689L), java.util.Map.entry("is_interior", 36873697L),
			java.util.Map.entry("set_normal_bias", 373806689L), java.util.Map.entry("set_interior", 2586408642L),
			java.util.Map.entry("get_level_counts", 1930428628L),
			java.util.Map.entry("is_using_two_bounces", 36873697L));

	VoxelGIData(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VoxelGIData(long nativePointer) {
		super(nativePointer);
	}

	public void allocate(Transform3D to_cell_xform, AABB aabb, Vector3 octree_size, byte[] octree_cells,
			byte[] data_cells, byte[] distance_field, int[] level_counts) {
		super.call("allocate",
				new java.lang.Object[]{(java.lang.Object) to_cell_xform, (java.lang.Object) aabb,
						(java.lang.Object) octree_size, (java.lang.Object) octree_cells, (java.lang.Object) data_cells,
						(java.lang.Object) distance_field, (java.lang.Object) level_counts});
	}

	public boolean is_interior() {
		return (boolean) super.call("is_interior");
	}

	public boolean is_using_two_bounces() {
		return (boolean) super.call("is_using_two_bounces");
	}

	public double getDynamic_range() {
		return (double) super.call("get_dynamic_range", new java.lang.Object[0]);
	}

	public void setDynamic_range(double value) {
		super.call("set_dynamic_range", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getEnergy() {
		return (double) super.call("get_energy", new java.lang.Object[0]);
	}

	public void setEnergy(double value) {
		super.call("set_energy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getBias() {
		return (double) super.call("get_bias", new java.lang.Object[0]);
	}

	public void setBias(double value) {
		super.call("set_bias", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getNormal_bias() {
		return (double) super.call("get_normal_bias", new java.lang.Object[0]);
	}

	public void setNormal_bias(double value) {
		super.call("set_normal_bias", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPropagation() {
		return (double) super.call("get_propagation", new java.lang.Object[0]);
	}

	public void setPropagation(double value) {
		super.call("set_propagation", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isUse_two_bounces() {
		return (boolean) super.call("is_using_two_bounces", new java.lang.Object[0]);
	}

	public void setUse_two_bounces(boolean value) {
		super.call("set_use_two_bounces", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isInterior() {
		return (boolean) super.call("is_interior", new java.lang.Object[0]);
	}

	public void setInterior(boolean value) {
		super.call("set_interior", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
