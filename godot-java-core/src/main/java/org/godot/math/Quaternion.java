package org.godot.math;

/**
 * Quaternion for 3D rotation (w + xi + yj + zk).
 *
 * More numerically stable for chained rotations than rotation matrices, and
 * avoids gimbal lock.
 *
 * <pre>{@code
 * Quaternion q = Quaternion.fromEuler(new Vector3(0.5, 0.3, 0.1));
 * Vector3 rotated = q.apply(Vector3.RIGHT);
 * Quaternion slerped = q1.slerp(q2, 0.5);
 * }</pre>
 */
public final class Quaternion {

	public double x, y, z, w;

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	/**
	 * Identity quaternion (no rotation).
	 */
	public Quaternion() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.w = 1;
	}

	public Quaternion(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------

	public static final Quaternion IDENTITY = new Quaternion(0, 0, 0, 1);

	// ------------------------------------------------------------------------
	// Factory methods
	// ------------------------------------------------------------------------

	/**
	 * Create from axis (normalized) and angle (radians).
	 */
	public static Quaternion fromAxisAngle(Vector3 axis, double angle) {
		double s = Math.sin(angle * 0.5);
		double c = Math.cos(angle * 0.5);
		return new Quaternion(axis.x * s, axis.y * s, axis.z * s, c);
	}

	/**
	 * Create from Euler angles (radians). Order: Z, Y, X.
	 */
	public static Quaternion fromEuler(Vector3 euler) {
		double ex = euler.x * 0.5, ey = euler.y * 0.5, ez = euler.z * 0.5;
		double cx = Math.cos(ex), sx = Math.sin(ex);
		double cy = Math.cos(ey), sy = Math.sin(ey);
		double cz = Math.cos(ez), sz = Math.sin(ez);
		// ZYX order
		return new Quaternion(sx * cy * cz - cx * sy * sz, cx * sy * cz + sx * cy * sz, cx * cy * sz - sx * sy * cz,
				cx * cy * cz + sx * sy * sz);
	}

	/**
	 * Create from a Basis matrix.
	 */
	public static Quaternion fromBasis(Basis basis) {
		return basis.toQuaternion();
	}

	// ------------------------------------------------------------------------
	// Properties
	// ------------------------------------------------------------------------

	/**
	 * Length (magnitude).
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
	public Quaternion normalized() {
		double len = length();
		if (len == 0)
			return IDENTITY;
		return new Quaternion(x / len, y / len, z / len, w / len);
	}

	/**
	 * Conjugate (negate imaginary part): (−x, −y, −z, w).
	 */
	public Quaternion conjugated() {
		return new Quaternion(-x, -y, -z, w);
	}

	/**
	 * Inverse (conjugate / length_squared).
	 */
	public Quaternion inverse() {
		double lenSq = lengthSquared();
		if (lenSq == 0)
			return IDENTITY;
		double invSq = 1.0 / lenSq;
		return new Quaternion(-x * invSq, -y * invSq, -z * invSq, w * invSq);
	}

	/**
	 * Dot product with another quaternion.
	 */
	public double dot(Quaternion other) {
		return x * other.x + y * other.y + z * other.z + w * other.w;
	}

	// ------------------------------------------------------------------------
	// Operations
	// ------------------------------------------------------------------------

	/**
	 * Multiply two quaternions (concatenate rotations).
	 */
	public Quaternion multiply(Quaternion other) {
		// q1 * q2: first q2, then q1
		return new Quaternion(w * other.x + x * other.w + y * other.z - z * other.y,
				w * other.y - x * other.z + y * other.w + z * other.x,
				w * other.z + x * other.y - y * other.x + z * other.w,
				w * other.w - x * other.x - y * other.y - z * other.z);
	}

	/**
	 * Scale the quaternion.
	 */
	public Quaternion mul(double scalar) {
		return new Quaternion(x * scalar, y * scalar, z * scalar, w * scalar);
	}

	/**
	 * Apply quaternion rotation to a vector.
	 */
	public Vector3 apply(Vector3 v) {
		// v' = q * v * q^-1
		// Optimized: v' = v + 2 * cross(q.xyz, cross(q.xyz, v) + q.w * v)
		double ix = w * v.x + y * v.z - z * v.y;
		double iy = w * v.y + z * v.x - x * v.z;
		double iz = w * v.z + x * v.y - y * v.x;
		double iw = -x * v.x - y * v.y - z * v.z;

		return new Vector3(ix * w + iw * -x + iy * -z - iz * -y, iy * w + iw * -y + iz * -x - ix * -z,
				iz * w + iw * -z + ix * -y - iy * -x);
	}

	/**
	 * Spherical linear interpolation between this and another quaternion.
	 *
	 * @param other
	 *            Target quaternion
	 * @param t
	 *            Interpolation parameter [0, 1]
	 * @return Interpolated quaternion
	 */
	public Quaternion slerp(Quaternion other, double t) {
		double cosHalfTheta = dot(other);

		// If quaternions are very close, use linear interpolation
		if (Math.abs(cosHalfTheta) >= 0.9995) {
			double nx = x + (other.x - x) * t;
			double ny = y + (other.y - y) * t;
			double nz = z + (other.z - z) * t;
			double nw = w + (other.w - w) * t;
			return new Quaternion(nx, ny, nz, nw).normalized();
		}

		// Ensure shortest path (flip if dot product is negative)
		double sign = cosHalfTheta >= 0 ? 1.0 : -1.0;
		cosHalfTheta = Math.abs(cosHalfTheta);

		double sinHalfTheta = Math.sqrt(1.0 - cosHalfTheta * cosHalfTheta);
		double halfTheta = Math.atan2(sinHalfTheta, cosHalfTheta);

		double a = Math.sin((1 - t) * halfTheta) / sinHalfTheta;
		double b = Math.sin(t * halfTheta) / sinHalfTheta * sign;

		return new Quaternion(x * a + other.x * b, y * a + other.y * b, z * a + other.z * b, w * a + other.w * b);
	}

	/**
	 * Convert to Euler angles (Z, Y, X order, radians).
	 */
	public Vector3 toEuler() {
		// YXZ order (Godot default)
		double sinr_cosp = 2 * (w * x + y * z);
		double cosr_cosp = 1 - 2 * (x * x + y * y);
		double ex = Math.atan2(sinr_cosp, cosr_cosp);

		double sinp = 2 * (w * y - z * x);
		double ey = Math.abs(sinp) >= 1
				? Math.copySign(Math.PI / 2, sinp) // use 90 degrees if out of range
				: Math.asin(sinp);

		double siny_cosp = 2 * (w * z + x * y);
		double cosy_cosp = 1 - 2 * (y * y + z * z);
		double ez = Math.atan2(siny_cosp, cosy_cosp);

		return new Vector3(ex, ey, ez);
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Override
	public String toString() {
		return "Quaternion(" + x + ", " + y + ", " + z + ", " + w + ")";
	}
}
