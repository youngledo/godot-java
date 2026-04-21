package org.godot.math;

/**
 * 4D integer vector. Matches Godot's VECTOR4I (int32_t x, y, z, w).
 */
public final class Vector4i {
	public int x;
	public int y;
	public int z;
	public int w;
	public Vector4i() {
	}
	public Vector4i(int x, int y, int z, int w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
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
	public int getW() {
		return w;
	}
}
