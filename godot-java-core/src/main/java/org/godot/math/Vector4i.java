package org.godot.math;

import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.JAVA_INT;

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

	public void toSegment(MemorySegment seg) {
		seg.set(JAVA_INT, 0, x);
		seg.set(JAVA_INT, 4, y);
		seg.set(JAVA_INT, 8, z);
		seg.set(JAVA_INT, 12, w);
	}

	public static Vector4i fromSegment(MemorySegment seg) {
		return new Vector4i(seg.get(JAVA_INT, 0), seg.get(JAVA_INT, 4), seg.get(JAVA_INT, 8), seg.get(JAVA_INT, 12));
	}
	/// Convert to the floating-point {@link Vector4}.
	public Vector4 toVector4() {
		return new Vector4(x, y, z, w);
	}

}
