package org.godot.math;

import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.JAVA_INT;

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

	public void toSegment(MemorySegment seg) {
		seg.set(JAVA_INT, 0, x);
		seg.set(JAVA_INT, 4, y);
		seg.set(JAVA_INT, 8, width);
		seg.set(JAVA_INT, 12, height);
	}

	public static Rect2i fromSegment(MemorySegment seg) {
		return new Rect2i(seg.get(JAVA_INT, 0), seg.get(JAVA_INT, 4), seg.get(JAVA_INT, 8), seg.get(JAVA_INT, 12));
	}
	/// Convert to the floating-point {@link Rect2}.
	public Rect2 toRect2() {
		return new Rect2(x, y, width, height);
	}

}
