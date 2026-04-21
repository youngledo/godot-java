package org.godot.math;

import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;

/**
 * 2D vector (x, y). Used for positions, directions, velocities in 2D space.
 *
 * <pre>{@code
 * Vector2 v = new Vector2(3, 4);
 * double len = v.length(); // 5.0
 * Vector2 n = v.normalized(); // (0.6, 0.8)
 * }</pre>
 */
public final class Vector2 {

	public double x;
	public double y;

	public Vector2() {
	}

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------

	public static final Vector2 ZERO = new Vector2(0, 0);
	public static final Vector2 ONE = new Vector2(1, 1);
	public static final Vector2 UP = new Vector2(0, -1);
	public static final Vector2 DOWN = new Vector2(0, 1);
	public static final Vector2 LEFT = new Vector2(-1, 0);
	public static final Vector2 RIGHT = new Vector2(1, 0);
	public static final Vector2 INF = new Vector2(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

	// ------------------------------------------------------------------------
	// Basic operations
	// ------------------------------------------------------------------------

	/**
	 * Euclidean length (magnitude) of the vector.
	 */
	public double length() {
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * Squared length — faster than length() when you don't need the sqrt.
	 */
	public double lengthSquared() {
		return x * x + y * y;
	}

	/**
	 * Returns a normalized copy of this vector (length = 1).
	 */
	public Vector2 normalized() {
		double len = length();
		if (len == 0)
			return ZERO;
		return new Vector2(x / len, y / len);
	}

	/**
	 * Dot product with another vector.
	 */
	public double dot(Vector2 other) {
		return x * other.x + y * other.y;
	}

	/**
	 * 2D cross product — returns the signed scalar cross product.
	 */
	public double cross(Vector2 other) {
		return x * other.y - y * other.x;
	}

	/**
	 * Distance to another vector.
	 */
	public double distanceTo(Vector2 other) {
		return Math.sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y));
	}

	/**
	 * Squared distance to another vector.
	 */
	public double distanceSquaredTo(Vector2 other) {
		double dx = x - other.x;
		double dy = y - other.y;
		return dx * dx + dy * dy;
	}

	/**
	 * Linear interpolation to another vector.
	 */
	public Vector2 lerp(Vector2 other, double t) {
		return new Vector2(x + (other.x - x) * t, y + (other.y - y) * t);
	}

	/**
	 * Linear interpolation to another vector (float variant).
	 */
	public Vector2 lerpTo(Vector2 other, double t) {
		return lerp(other, t);
	}

	/**
	 * Element-wise minimum.
	 */
	public Vector2 min(Vector2 other) {
		return new Vector2(Math.min(x, other.x), Math.min(y, other.y));
	}

	/**
	 * Element-wise maximum.
	 */
	public Vector2 max(Vector2 other) {
		return new Vector2(Math.max(x, other.x), Math.max(y, other.y));
	}

	/**
	 * Angle in radians to another vector.
	 */
	public double angleTo(Vector2 other) {
		return Math.atan2(cross(other), dot(other));
	}

	/**
	 * Angle in radians to the positive X axis.
	 */
	public double angle() {
		return Math.atan2(y, x);
	}

	/**
	 * Rotate the vector by the given angle (in radians).
	 */
	public Vector2 rotated(double angle) {
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		return new Vector2(x * cos - y * sin, x * sin + y * cos);
	}

	/**
	 * Project this vector onto another.
	 */
	public Vector2 project(Vector2 onto) {
		double d = onto.dot(onto);
		if (d == 0)
			return ZERO;
		double s = dot(onto) / d;
		return new Vector2(onto.x * s, onto.y * s);
	}

	/**
	 * Reflect this vector off a surface with the given normal.
	 */
	public Vector2 reflected(Vector2 normal) {
		double d = 2.0 * dot(normal);
		return new Vector2(x - d * normal.x, y - d * normal.y);
	}

	/**
	 * Slide (bounce) this vector along a surface with the given normal.
	 */
	public Vector2 slide(Vector2 normal) {
		double d = dot(normal);
		if (d < 0) {
			return new Vector2(x - normal.x * d, y - normal.y * d);
		}
		return new Vector2(x, y);
	}

	/**
	 * Clamp the vector to the given bounds.
	 */
	public Vector2 clamped(double minLen, double maxLen) {
		double len = length();
		if (len < minLen && len > 0)
			return normalized().mul(minLen);
		if (len > maxLen)
			return normalized().mul(maxLen);
		return this;
	}

	/**
	 * Clamp the vector to the given rect (min/max bounds).
	 */
	public Vector2 clampedTo(Vector2 minBound, Vector2 maxBound) {
		return new Vector2(Math.max(minBound.x, Math.min(maxBound.x, x)),
				Math.max(minBound.y, Math.min(maxBound.y, y)));
	}

	// ------------------------------------------------------------------------
	// Arithmetic operators
	// ------------------------------------------------------------------------

	public Vector2 add(Vector2 other) {
		return new Vector2(x + other.x, y + other.y);
	}
	public Vector2 sub(Vector2 other) {
		return new Vector2(x - other.x, y - other.y);
	}
	public Vector2 mul(double scalar) {
		return new Vector2(x * scalar, y * scalar);
	}
	public Vector2 div(double scalar) {
		return new Vector2(x / scalar, y / scalar);
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
	public void setX(double v) {
		this.x = v;
	}
	public void setY(double v) {
		this.y = v;
	}

	/**
	 * Get component by index (0=x, 1=y).
	 */
	public double axis(int index) {
		return index == 0 ? x : y;
	}

	// ------------------------------------------------------------------------
	// Native interop
	// ------------------------------------------------------------------------

	/**
	 * Pack into a 16-byte MemorySegment (for passing to native functions).
	 */
	public void toSegment(MemorySegment seg) {
		seg.set(JAVA_DOUBLE, 0, x);
		seg.set(JAVA_DOUBLE, 8, y);
	}

	/**
	 * Read from a 16-byte MemorySegment (from native functions).
	 */
	public static Vector2 fromSegment(MemorySegment seg) {
		return new Vector2(seg.get(JAVA_DOUBLE, 0), seg.get(JAVA_DOUBLE, 8));
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Vector2))
			return false;
		Vector2 v = (Vector2) o;
		return Math.abs(x - v.x) < 1e-10 && Math.abs(y - v.y) < 1e-10;
	}

	@Override
	public int hashCode() {
		return Double.hashCode(x) ^ (Double.hashCode(y) * 31);
	}
}
