package org.godot.math;

/**
 * 2D axis-aligned bounding box (position + size). Memory layout: 2 Vector2
 * (position, size), 16 bytes total (float_32).
 */
public final class Rect2 {
	/**
	 * Top-left corner.
	 */
	public Vector2 position;
	/**
	 * Width and height.
	 */
	public Vector2 size;

	public Rect2() {
		this.position = new Vector2();
		this.size = new Vector2();
	}

	public Rect2(double x, double y, double width, double height) {
		this.position = new Vector2(x, y);
		this.size = new Vector2(width, height);
	}

	public Rect2(Vector2 position, Vector2 size) {
		this.position = position;
		this.size = size;
	}

	public double getX() {
		return position.x;
	}
	public double getY() {
		return position.y;
	}
	public double getWidth() {
		return size.x;
	}
	public double getHeight() {
		return size.y;
	}

	@Override
	public String toString() {
		return "[P:" + position + " S:" + size + "]";
	}
}
