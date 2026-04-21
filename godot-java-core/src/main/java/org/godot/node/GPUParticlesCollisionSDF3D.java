package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class GPUParticlesCollisionSDF3D extends GPUParticlesCollision3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_size", 3460891852L), java.util.Map.entry("set_thickness", 373806689L),
			java.util.Map.entry("set_bake_mask_value", 300928843L), java.util.Map.entry("set_resolution", 1155629297L),
			java.util.Map.entry("get_bake_mask_value", 1116898809L), java.util.Map.entry("get_resolution", 2919555867L),
			java.util.Map.entry("get_thickness", 1740695150L), java.util.Map.entry("get_size", 3360562783L),
			java.util.Map.entry("set_texture", 1188404210L), java.util.Map.entry("get_texture", 373985333L),
			java.util.Map.entry("set_bake_mask", 1286410249L), java.util.Map.entry("get_bake_mask", 3905245786L));

	GPUParticlesCollisionSDF3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GPUParticlesCollisionSDF3D(long nativePointer) {
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

	public Vector3 getSize() {
		return (Vector3) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector3 value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getResolution() {
		return (long) super.call("get_resolution", new java.lang.Object[0]);
	}

	public void setResolution(long value) {
		super.call("set_resolution", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getThickness() {
		return (double) super.call("get_thickness", new java.lang.Object[0]);
	}

	public void setThickness(double value) {
		super.call("set_thickness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getBake_mask() {
		return (long) super.call("get_bake_mask", new java.lang.Object[0]);
	}

	public void setBake_mask(long value) {
		super.call("set_bake_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Texture3D getTexture() {
		return (Texture3D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture3D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}
}
