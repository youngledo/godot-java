package org.godot.math;

/**
 * 3D integer vector. Matches Godot's VECTOR3I (int32_t x, y, z).
 */
public final class Vector3i {
	public int x;
	public int y;
	public int z;
	public Vector3i() {
	}
	public Vector3i(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}
}
