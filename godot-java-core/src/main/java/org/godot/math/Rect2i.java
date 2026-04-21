package org.godot.math;

/**
 * 2D integer axis-aligned bounding box (position + size). Matches Godot's
 * Rect2i (int32_t x, y, width, height).
 */
public final class Rect2i {
	public int x;
	public int y;
	public int width;
	public int height;

	public Rect2i() {
	}

	public Rect2i(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
