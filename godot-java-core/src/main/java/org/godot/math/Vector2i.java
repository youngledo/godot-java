package org.godot.math;

import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.JAVA_INT;

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

	public void toSegment(MemorySegment seg) {
		seg.set(JAVA_INT, 0, x);
		seg.set(JAVA_INT, 4, y);
	}

	public static Vector2i fromSegment(MemorySegment seg) {
		return new Vector2i(seg.get(JAVA_INT, 0), seg.get(JAVA_INT, 4));
	}
	/// Convert to the floating-point {@link Vector2}.
	public Vector2 toVector2() {
		return new Vector2(x, y);
	}

}
