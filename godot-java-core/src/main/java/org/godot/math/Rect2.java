package org.godot.math;

import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;

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

	public void toSegment(MemorySegment seg) {
		seg.set(JAVA_DOUBLE, 0, position.x);
		seg.set(JAVA_DOUBLE, 8, position.y);
		seg.set(JAVA_DOUBLE, 16, size.x);
		seg.set(JAVA_DOUBLE, 24, size.y);
	}

	public static Rect2 fromSegment(MemorySegment seg) {
		return new Rect2(seg.get(JAVA_DOUBLE, 0), seg.get(JAVA_DOUBLE, 8), seg.get(JAVA_DOUBLE, 16),
				seg.get(JAVA_DOUBLE, 24));
	}
	/// Convert to the integer {@link Rect2i}, truncating each component toward zero.
	public Rect2i toRect2i() {
		return new Rect2i((int) position.x, (int) position.y, (int) size.x, (int) size.y);
	}

}
