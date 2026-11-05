package org.godot.math;

import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.JAVA_INT;

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

	public void toSegment(MemorySegment seg) {
		seg.set(JAVA_INT, 0, x);
		seg.set(JAVA_INT, 4, y);
		seg.set(JAVA_INT, 8, z);
	}

	public static Vector3i fromSegment(MemorySegment seg) {
		return new Vector3i(seg.get(JAVA_INT, 0), seg.get(JAVA_INT, 4), seg.get(JAVA_INT, 8));
	}
	/// Convert to the floating-point {@link Vector3}.
	public Vector3 toVector3() {
		return new Vector3(x, y, z);
	}

}
