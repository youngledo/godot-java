package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class StaticBody3D extends PhysicsBody3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_physics_material_override", 1784508650L),
			java.util.Map.entry("set_constant_angular_velocity", 3460891852L),
			java.util.Map.entry("get_constant_linear_velocity", 3360562783L),
			java.util.Map.entry("get_physics_material_override", 2521850424L),
			java.util.Map.entry("get_constant_angular_velocity", 3360562783L),
			java.util.Map.entry("set_constant_linear_velocity", 3460891852L));

	StaticBody3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StaticBody3D(long nativePointer) {
		super(nativePointer);
	}

	public PhysicsMaterial getPhysics_material_override() {
		return (PhysicsMaterial) super.call("get_physics_material_override", new java.lang.Object[0]);
	}

	public void setPhysics_material_override(PhysicsMaterial value) {
		super.call("set_physics_material_override", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getConstant_linear_velocity() {
		return (Vector3) super.call("get_constant_linear_velocity", new java.lang.Object[0]);
	}

	public void setConstant_linear_velocity(Vector3 value) {
		super.call("set_constant_linear_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getConstant_angular_velocity() {
		return (Vector3) super.call("get_constant_angular_velocity", new java.lang.Object[0]);
	}

	public void setConstant_angular_velocity(Vector3 value) {
		super.call("set_constant_angular_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}
}
