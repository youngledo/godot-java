package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class GPUParticlesCollisionHeightField3D extends GPUParticlesCollision3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_size", 3460891852L), java.util.Map.entry("is_follow_camera_enabled", 36873697L),
			java.util.Map.entry("get_update_mode", 1998141380L), java.util.Map.entry("set_update_mode", 673680859L),
			java.util.Map.entry("get_heightfield_mask", 3905245786L),
			java.util.Map.entry("set_follow_camera_enabled", 2586408642L),
			java.util.Map.entry("set_resolution", 1009996517L), java.util.Map.entry("get_resolution", 1156065644L),
			java.util.Map.entry("set_heightfield_mask", 1286410249L), java.util.Map.entry("get_size", 3360562783L),
			java.util.Map.entry("get_heightfield_mask_value", 1116898809L),
			java.util.Map.entry("set_heightfield_mask_value", 300928843L));

	GPUParticlesCollisionHeightField3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GPUParticlesCollisionHeightField3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_heightfield_mask_value(long layer_number, boolean value) {
		super.call("set_heightfield_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_heightfield_mask_value(long layer_number) {
		return (boolean) super.call("get_heightfield_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public boolean is_follow_camera_enabled() {
		return (boolean) super.call("is_follow_camera_enabled");
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

	public long getUpdate_mode() {
		return (long) super.call("get_update_mode", new java.lang.Object[0]);
	}

	public void setUpdate_mode(long value) {
		super.call("set_update_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isFollow_camera_enabled() {
		return (boolean) super.call("is_follow_camera_enabled", new java.lang.Object[0]);
	}

	public void setFollow_camera_enabled(boolean value) {
		super.call("set_follow_camera_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getHeightfield_mask() {
		return (long) super.call("get_heightfield_mask", new java.lang.Object[0]);
	}

	public void setHeightfield_mask(long value) {
		super.call("set_heightfield_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
