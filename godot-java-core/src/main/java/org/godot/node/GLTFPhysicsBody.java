package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Basis;
import org.godot.math.Quaternion;
import org.godot.math.Vector3;

public class GLTFPhysicsBody extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_center_of_mass", 3360562783L),
			java.util.Map.entry("set_inertia_diagonal", 3460891852L),
			java.util.Map.entry("get_inertia_orientation", 1222331677L),
			java.util.Map.entry("from_dictionary", 1177544336L), java.util.Map.entry("to_node", 3224013656L),
			java.util.Map.entry("set_mass", 373806689L), java.util.Map.entry("get_angular_velocity", 3360562783L),
			java.util.Map.entry("set_linear_velocity", 3460891852L),
			java.util.Map.entry("set_inertia_tensor", 1055510324L), java.util.Map.entry("get_body_type", 201670096L),
			java.util.Map.entry("to_dictionary", 3102165223L), java.util.Map.entry("get_mass", 1740695150L),
			java.util.Map.entry("set_angular_velocity", 3460891852L),
			java.util.Map.entry("set_inertia_orientation", 1727505552L),
			java.util.Map.entry("get_linear_velocity", 3360562783L), java.util.Map.entry("set_body_type", 83702148L),
			java.util.Map.entry("get_inertia_tensor", 2716978435L), java.util.Map.entry("from_node", 420544174L),
			java.util.Map.entry("set_center_of_mass", 3460891852L),
			java.util.Map.entry("get_inertia_diagonal", 3360562783L));

	GLTFPhysicsBody(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFPhysicsBody(long nativePointer) {
		super(nativePointer);
	}

	public GLTFPhysicsBody from_node(CollisionObject3D body_node) {
		return (GLTFPhysicsBody) super.call("from_node", new java.lang.Object[]{(java.lang.Object) body_node});
	}

	public CollisionObject3D to_node() {
		return (CollisionObject3D) super.call("to_node");
	}

	public GLTFPhysicsBody from_dictionary(GodotDictionary dictionary) {
		return (GLTFPhysicsBody) super.call("from_dictionary", new java.lang.Object[]{(java.lang.Object) dictionary});
	}

	public GodotDictionary to_dictionary() {
		return (GodotDictionary) super.call("to_dictionary");
	}

	public String getBody_type() {
		return (String) super.call("get_body_type", new java.lang.Object[0]);
	}

	public void setBody_type(String value) {
		super.call("set_body_type", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getMass() {
		return (double) super.call("get_mass", new java.lang.Object[0]);
	}

	public void setMass(double value) {
		super.call("set_mass", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector3 getLinear_velocity() {
		return (Vector3) super.call("get_linear_velocity", new java.lang.Object[0]);
	}

	public void setLinear_velocity(Vector3 value) {
		super.call("set_linear_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getAngular_velocity() {
		return (Vector3) super.call("get_angular_velocity", new java.lang.Object[0]);
	}

	public void setAngular_velocity(Vector3 value) {
		super.call("set_angular_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getCenter_of_mass() {
		return (Vector3) super.call("get_center_of_mass", new java.lang.Object[0]);
	}

	public void setCenter_of_mass(Vector3 value) {
		super.call("set_center_of_mass", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getInertia_diagonal() {
		return (Vector3) super.call("get_inertia_diagonal", new java.lang.Object[0]);
	}

	public void setInertia_diagonal(Vector3 value) {
		super.call("set_inertia_diagonal", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Quaternion getInertia_orientation() {
		return (Quaternion) super.call("get_inertia_orientation", new java.lang.Object[0]);
	}

	public void setInertia_orientation(Quaternion value) {
		super.call("set_inertia_orientation", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Basis getInertia_tensor() {
		return (Basis) super.call("get_inertia_tensor", new java.lang.Object[0]);
	}

	public void setInertia_tensor(Basis value) {
		super.call("set_inertia_tensor", new java.lang.Object[]{(java.lang.Object) value});
	}
}
