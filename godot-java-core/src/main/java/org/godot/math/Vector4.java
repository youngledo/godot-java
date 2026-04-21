package org.godot.math;

import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;

/**
 * 4D vector (x, y, z, w). Used for homogeneous coordinates in 3D transforms,
 * color calculations (RGBA), and physics.
 */
public final class Vector4 {

	public double x;
	public double y;
	public double z;
	public double w;

	public Vector4() {
	}

	public Vector4(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------

	public static final Vector4 ZERO = new Vector4(0, 0, 0, 0);
	public static final Vector4 ONE = new Vector4(1, 1, 1, 1);

	// ------------------------------------------------------------------------
	// Basic operations
	// ------------------------------------------------------------------------

	/**
	 * Euclidean length.
	 */
	public double length() {
		return Math.sqrt(x * x + y * y + z * z + w * w);
	}

	/**
	 * Squared length.
	 */
	public double lengthSquared() {
		return x * x + y * y + z * z + w * w;
	}

	/**
	 * Returns a normalized copy.
	 */
	public Vector4 normalized() {
		double len = length();
		if (len == 0)
			return ZERO;
		return new Vector4(x / len, y / len, z / len, w / len);
	}

	/**
	 * Dot product with another vector.
	 */
	public double dot(Vector4 other) {
		return x * other.x + y * other.y + z * other.z + w * other.w;
	}

	/**
	 * Linear interpolation.
	 */
	public Vector4 lerp(Vector4 other, double t) {
		return new Vector4(x + (other.x - x) * t, y + (other.y - y) * t, z + (other.z - z) * t, w + (other.w - w) * t);
	}

	/**
	 * Element-wise minimum.
	 */
	public Vector4 min(Vector4 other) {
		return new Vector4(Math.min(x, other.x), Math.min(y, other.y), Math.min(z, other.z), Math.min(w, other.w));
	}

	/**
	 * Element-wise maximum.
	 */
	public Vector4 max(Vector4 other) {
		return new Vector4(Math.max(x, other.x), Math.max(y, other.y), Math.max(z, other.z), Math.max(w, other.w));
	}

	// ------------------------------------------------------------------------
	// Arithmetic
	// ------------------------------------------------------------------------

	public Vector4 add(Vector4 other) {
		return new Vector4(x + other.x, y + other.y, z + other.z, w + other.w);
	}
	public Vector4 sub(Vector4 other) {
		return new Vector4(x - other.x, y - other.y, z - other.z, w - other.w);
	}
	public Vector4 mul(double scalar) {
		return new Vector4(x * scalar, y * scalar, z * scalar, w * scalar);
	}
	public Vector4 div(double scalar) {
		return new Vector4(x / scalar, y / scalar, z / scalar, w / scalar);
	}

	// ------------------------------------------------------------------------
	// Element access
	// ------------------------------------------------------------------------

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}
	public double getW() {
		return w;
	}
	public void setX(double v) {
		this.x = v;
	}
	public void setY(double v) {
		this.y = v;
	}
	public void setZ(double v) {
		this.z = v;
	}
	public void setW(double v) {
		this.w = v;
	}

	/**
	 * Get component by index (0=x, 1=y, 2=z, 3=w).
	 */
	public double axis(int index) {
		return switch (index) {
			case 0 -> x;
			case 1 -> y;
			case 2 -> z;
			case 3 -> w;
			default -> throw new IndexOutOfBoundsException("Vector4 axis " + index);
		};
	}

	// ------------------------------------------------------------------------
	// Native interop
	// ------------------------------------------------------------------------

	/**
	 * Pack into a 32-byte MemorySegment.
	 */
	public void toSegment(MemorySegment seg) {
		seg.set(JAVA_DOUBLE, 0, x);
		seg.set(JAVA_DOUBLE, 8, y);
		seg.set(JAVA_DOUBLE, 16, z);
		seg.set(JAVA_DOUBLE, 24, w);
	}

	/**
	 * Read from a 32-byte MemorySegment.
	 */
	public static Vector4 fromSegment(MemorySegment seg) {
		return new Vector4(seg.get(JAVA_DOUBLE, 0), seg.get(JAVA_DOUBLE, 8), seg.get(JAVA_DOUBLE, 16),
				seg.get(JAVA_DOUBLE, 24));
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ", " + w + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Vector4))
			return false;
		Vector4 v = (Vector4) o;
		return Math.abs(x - v.x) < 1e-10 && Math.abs(y - v.y) < 1e-10 && Math.abs(z - v.z) < 1e-10
				&& Math.abs(w - v.w) < 1e-10;
	}

	@Override
	public int hashCode() {
		int h = Double.hashCode(x);
		h = h * 31 ^ Double.hashCode(y);
		h = h * 31 ^ Double.hashCode(z);
		h = h * 31 ^ Double.hashCode(w);
		return h;
	}
}
