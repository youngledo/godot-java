package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OccluderInstance3D extends VisualInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_bake_simplification_distance", 373806689L),
			java.util.Map.entry("get_bake_simplification_distance", 1740695150L),
			java.util.Map.entry("get_occluder", 1696836198L), java.util.Map.entry("set_bake_mask_value", 300928843L),
			java.util.Map.entry("get_bake_mask_value", 1116898809L), java.util.Map.entry("set_occluder", 1664878165L),
			java.util.Map.entry("set_bake_mask", 1286410249L), java.util.Map.entry("get_bake_mask", 3905245786L));

	OccluderInstance3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OccluderInstance3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_bake_mask_value(long layer_number, boolean value) {
		super.call("set_bake_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_bake_mask_value(long layer_number) {
		return (boolean) super.call("get_bake_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public Occluder3D getOccluder() {
		return (Occluder3D) super.call("get_occluder", new java.lang.Object[0]);
	}

	public void setOccluder(Occluder3D value) {
		super.call("set_occluder", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getBake_mask() {
		return (long) super.call("get_bake_mask", new java.lang.Object[0]);
	}

	public void setBake_mask(long value) {
		super.call("set_bake_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getBake_simplification_distance() {
		return (double) super.call("get_bake_simplification_distance", new java.lang.Object[0]);
	}

	public void setBake_simplification_distance(double value) {
		super.call("set_bake_simplification_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
