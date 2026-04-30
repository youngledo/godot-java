package org.godot.math;

import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;

/**
 * 3D vector (x, y, z). Used for positions, directions, velocities in 3D space.
 *
 * <pre>{@code
 * Vector3 v = new Vector3(1, 0, 0);
 * double len = v.length(); // 1.0
 * Vector3 n = v.normalized(); // (1, 0, 0)
 * }</pre>
 */
public final class Vector3 {

	public double x;
	public double y;
	public double z;

	public Vector3() {
	}

	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------

	public static final Vector3 ZERO = new Vector3(0, 0, 0);
	public static final Vector3 ONE = new Vector3(1, 1, 1);
	public static final Vector3 INF = new Vector3(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,
			Double.POSITIVE_INFINITY);
	public static final Vector3 UP = new Vector3(0, 1, 0);
	public static final Vector3 DOWN = new Vector3(0, -1, 0);
	public static final Vector3 LEFT = new Vector3(-1, 0, 0);
	public static final Vector3 RIGHT = new Vector3(1, 0, 0);
	public static final Vector3 FORWARD = new Vector3(0, 0, -1);
	public static final Vector3 BACK = new Vector3(0, 0, 1);

	// ------------------------------------------------------------------------
	// Basic operations
	// ------------------------------------------------------------------------

	/**
	 * Euclidean length (magnitude) of the vector.
	 */
	public double length() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	/**
	 * Squared length.
	 */
	public double lengthSquared() {
		return x * x + y * y + z * z;
	}

	/**
	 * Returns a normalized copy of this vector (length = 1).
	 */
	public Vector3 normalized() {
		double len = length();
		if (len == 0)
			return ZERO;
		return new Vector3(x / len, y / len, z / len);
	}

	/**
	 * Dot product with another vector.
	 */
	public double dot(Vector3 other) {
		return x * other.x + y * other.y + z * other.z;
	}

	/**
	 * 3D cross product.
	 */
	public Vector3 cross(Vector3 other) {
		return new Vector3(y * other.z - z * other.y, z * other.x - x * other.z, x * other.y - y * other.x);
	}

	/**
	 * Distance to another vector.
	 */
	public double distanceTo(Vector3 other) {
		return Math.sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y) + (z - other.z) * (z - other.z));
	}

	/**
	 * Squared distance to another vector.
	 */
	public double distanceSquaredTo(Vector3 other) {
		double dx = x - other.x;
		double dy = y - other.y;
		double dz = z - other.z;
		return dx * dx + dy * dy + dz * dz;
	}

	/**
	 * Linear interpolation to another vector.
	 */
	public Vector3 lerp(Vector3 other, double t) {
		return new Vector3(x + (other.x - x) * t, y + (other.y - y) * t, z + (other.z - z) * t);
	}

	/**
	 * Element-wise minimum.
	 */
	public Vector3 min(Vector3 other) {
		return new Vector3(Math.min(x, other.x), Math.min(y, other.y), Math.min(z, other.z));
	}

	/**
	 * Element-wise maximum.
	 */
	public Vector3 max(Vector3 other) {
		return new Vector3(Math.max(x, other.x), Math.max(y, other.y), Math.max(z, other.z));
	}

	/**
	 * Project this vector onto another.
	 */
	public Vector3 project(Vector3 onto) {
		double d = onto.dot(onto);
		if (d == 0)
			return ZERO;
		double s = dot(onto) / d;
		return new Vector3(onto.x * s, onto.y * s, onto.z * s);
	}

	/**
	 * Reflect this vector off a surface with the given normal.
	 */
	public Vector3 reflected(Vector3 normal) {
		double d = 2.0 * dot(normal);
		return new Vector3(x - d * normal.x, y - d * normal.y, z - d * normal.z);
	}

	/**
	 * Slide (bounce) this vector along a surface with the given normal.
	 */
	public Vector3 slide(Vector3 normal) {
		double d = dot(normal);
		if (d < 0) {
			return new Vector3(x - normal.x * d, y - normal.y * d, z - normal.z * d);
		}
		return new Vector3(x, y, z);
	}

	// ------------------------------------------------------------------------
	// Mutable operations (modify in-place, return this)
	// ------------------------------------------------------------------------

	/**
	 * Set all components. Returns this for chaining.
	 */
	public Vector3 set(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	/**
	 * Copy values from another vector. Returns this for chaining.
	 */
	public Vector3 set(Vector3 other) {
		this.x = other.x;
		this.y = other.y;
		this.z = other.z;
		return this;
	}

	/**
	 * Add in-place. Returns this for chaining.
	 */
	public Vector3 addInto(Vector3 other) {
		this.x += other.x;
		this.y += other.y;
		this.z += other.z;
		return this;
	}

	/**
	 * Subtract in-place. Returns this for chaining.
	 */
	public Vector3 subInto(Vector3 other) {
		this.x -= other.x;
		this.y -= other.y;
		this.z -= other.z;
		return this;
	}

	/**
	 * Scale in-place. Returns this for chaining.
	 */
	public Vector3 mulInto(double scalar) {
		this.x *= scalar;
		this.y *= scalar;
		this.z *= scalar;
		return this;
	}

	/**
	 * Lerp in-place toward another vector. Returns this for chaining.
	 */
	public Vector3 lerpInto(Vector3 other, double t) {
		this.x += (other.x - this.x) * t;
		this.y += (other.y - this.y) * t;
		this.z += (other.z - this.z) * t;
		return this;
	}

	/**
	 * Clamp all components in-place. Returns this for chaining.
	 */
	public Vector3 clampInto(double minVal, double maxVal) {
		this.x = Math.max(minVal, Math.min(maxVal, this.x));
		this.y = Math.max(minVal, Math.min(maxVal, this.y));
		this.z = Math.max(minVal, Math.min(maxVal, this.z));
		return this;
	}

	// ------------------------------------------------------------------------
	// Arithmetic operators (immutable — allocate new Vector3)
	// ------------------------------------------------------------------------

	public Vector3 add(Vector3 other) {
		return new Vector3(x + other.x, y + other.y, z + other.z);
	}
	public Vector3 sub(Vector3 other) {
		return new Vector3(x - other.x, y - other.y, z - other.z);
	}
	public Vector3 mul(double scalar) {
		return new Vector3(x * scalar, y * scalar, z * scalar);
	}
	public Vector3 div(double scalar) {
		return new Vector3(x / scalar, y / scalar, z / scalar);
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
	public void setX(double v) {
		this.x = v;
	}
	public void setY(double v) {
		this.y = v;
	}
	public void setZ(double v) {
		this.z = v;
	}

	/**
	 * Get component by index (0=x, 1=y, 2=z).
	 */
	public double axis(int index) {
		return switch (index) {
			case 0 -> x;
			case 1 -> y;
			case 2 -> z;
			default -> throw new IndexOutOfBoundsException("Vector3 axis " + index);
		};
	}

	// ------------------------------------------------------------------------
	// Native interop
	// ------------------------------------------------------------------------

	/**
	 * Pack into a 24-byte MemorySegment (for passing to native functions).
	 */
	public void toSegment(MemorySegment seg) {
		seg.set(JAVA_DOUBLE, 0, x);
		seg.set(JAVA_DOUBLE, 8, y);
		seg.set(JAVA_DOUBLE, 16, z);
	}

	/**
	 * Read from a 24-byte MemorySegment (from native functions).
	 */
	public static Vector3 fromSegment(MemorySegment seg) {
		return new Vector3(seg.get(JAVA_DOUBLE, 0), seg.get(JAVA_DOUBLE, 8), seg.get(JAVA_DOUBLE, 16));
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Vector3))
			return false;
		Vector3 v = (Vector3) o;
		return Math.abs(x - v.x) < 1e-10 && Math.abs(y - v.y) < 1e-10 && Math.abs(z - v.z) < 1e-10;
	}

	@Override
	public int hashCode() {
		int h = Double.hashCode(x);
		h = h * 31 ^ Double.hashCode(y);
		h = h * 31 ^ Double.hashCode(z);
		return h;
	}
}
