package org.godot.node;

import org.godot.math.Vector3;

/**
 * Base class for all 3D game objects. Uses Vector3 for position, rotation, and
 * scale in 3D space.
 */
public class Node3D extends Node {

	private static final java.util.Map<String, Long> METHOD_HASHES = java.util.Map.of("set_position", 3460891852L,
			"get_position", 3360562783L, "set_rotation", 3460891852L, "get_rotation", 3360562783L, "set_scale",
			3460891852L, "get_scale", 3360562783L, "translate3d", 3460891852L);

	/**
	 * Position in 3D space.
	 */
	protected Vector3 position = new Vector3(0, 0, 0);

	/**
	 * Rotation in radians around X, Y, Z axes (Euler angles).
	 */
	protected Vector3 rotation = new Vector3(0, 0, 0);

	/**
	 * Scale on X, Y, Z axes.
	 */
	protected Vector3 scale = new Vector3(1.0, 1.0, 1.0);

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	protected Node3D(long nativeObject) {
		super(nativeObject);
	}

	protected Node3D(java.lang.foreign.MemorySegment nativePtr) {
		super(nativePtr);
	}

	public Node3D() {
		super(0);
	}

	// ------------------------------------------------------------------------
	// Position
	// ------------------------------------------------------------------------

	public Vector3 getPosition() {
		return position;
	}
	public double getX() {
		return position.x;
	}
	public double getY() {
		return position.y;
	}
	public double getZ() {
		return position.z;
	}

	public void setPosition3D(double x, double y, double z) {
		setPosition3D(new Vector3(x, y, z));
	}

	public void setPosition3D(Vector3 pos) {
		this.position = pos;
		if (isValid()) {
			call("set_position", pos.x, pos.y, pos.z);
		}
	}

	/**
	 * Move by a 3D delta vector.
	 */
	public void translate3D(double dx, double dy, double dz) {
		setPosition3D(position.x + dx, position.y + dy, position.z + dz);
	}

	// ------------------------------------------------------------------------
	// Rotation
	// ------------------------------------------------------------------------

	public Vector3 getRotation() {
		return rotation;
	}
	public double getRotationX() {
		return rotation.x;
	}
	public double getRotationY() {
		return rotation.y;
	}
	public double getRotationZ() {
		return rotation.z;
	}

	public void setRotation3D(double x, double y, double z) {
		setRotation3D(new Vector3(x, y, z));
	}

	public void setRotation3D(Vector3 rot) {
		this.rotation = rot;
		if (isValid()) {
			call("set_rotation", rot.x, rot.y, rot.z);
		}
	}

	// ------------------------------------------------------------------------
	// Scale
	// ------------------------------------------------------------------------

	public Vector3 getScale() {
		return scale;
	}
	public double getScaleX() {
		return scale.x;
	}
	public double getScaleY() {
		return scale.y;
	}
	public double getScaleZ() {
		return scale.z;
	}

	public void setScale3D(double x, double y, double z) {
		setScale3D(new Vector3(x, y, z));
	}

	public void setScale3D(Vector3 s) {
		this.scale = s;
		if (isValid()) {
			call("set_scale", s.x, s.y, s.z);
		}
	}

	@Override
	protected String getGodotClassName() {
		return "Node3D";
	}
}
