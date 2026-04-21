package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CSGShape3D extends GeometryInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_collision_layer", 3905245786L),
			java.util.Map.entry("set_collision_mask_value", 300928843L), java.util.Map.entry("get_snap", 1740695150L),
			java.util.Map.entry("get_collision_mask_value", 1116898809L),
			java.util.Map.entry("get_collision_priority", 1740695150L),
			java.util.Map.entry("bake_collision_shape", 36102322L), java.util.Map.entry("set_operation", 811425055L),
			java.util.Map.entry("get_collision_layer_value", 1116898809L),
			java.util.Map.entry("is_calculating_tangents", 36873697L),
			java.util.Map.entry("bake_static_mesh", 1605880883L),
			java.util.Map.entry("set_calculate_tangents", 2586408642L),
			java.util.Map.entry("is_using_collision", 36873697L), java.util.Map.entry("get_meshes", 3995934104L),
			java.util.Map.entry("get_collision_mask", 3905245786L),
			java.util.Map.entry("set_collision_layer", 1286410249L),
			java.util.Map.entry("set_collision_layer_value", 300928843L),
			java.util.Map.entry("set_collision_priority", 373806689L),
			java.util.Map.entry("get_operation", 2662425879L), java.util.Map.entry("set_collision_mask", 1286410249L),
			java.util.Map.entry("set_snap", 373806689L), java.util.Map.entry("is_root_shape", 36873697L),
			java.util.Map.entry("set_use_collision", 2586408642L));

	CSGShape3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CSGShape3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_root_shape() {
		return (boolean) super.call("is_root_shape");
	}

	public boolean is_using_collision() {
		return (boolean) super.call("is_using_collision");
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

	public ConcavePolygonShape3D bake_collision_shape() {
		return (ConcavePolygonShape3D) super.call("bake_collision_shape");
	}

	public boolean is_calculating_tangents() {
		return (boolean) super.call("is_calculating_tangents");
	}

	public ArrayMesh bake_static_mesh() {
		return (ArrayMesh) super.call("bake_static_mesh");
	}

	public long getOperation() {
		return (long) super.call("get_operation", new java.lang.Object[0]);
	}

	public void setOperation(long value) {
		super.call("set_operation", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getSnap() {
		return (double) super.call("get_snap", new java.lang.Object[0]);
	}

	public void setSnap(double value) {
		super.call("set_snap", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isCalculate_tangents() {
		return (boolean) super.call("is_calculating_tangents", new java.lang.Object[0]);
	}

	public void setCalculate_tangents(boolean value) {
		super.call("set_calculate_tangents", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isUse_collision() {
		return (boolean) super.call("is_using_collision", new java.lang.Object[0]);
	}

	public void setUse_collision(boolean value) {
		super.call("set_use_collision", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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
}
