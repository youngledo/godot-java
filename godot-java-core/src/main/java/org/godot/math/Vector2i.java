package org.godot.math;

/**
 * 2D integer vector. Matches Godot's VECTOR2I (int32_t x, y).
 */
public final class Vector2i {
	public int x;
	public int y;
	public Vector2i() {
	}
	public Vector2i(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
