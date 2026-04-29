package org.godot.math;

/**
 * 3x3 basis matrix for 3D rotation and scale.
 *
 * Used as the rotational component of Transform3D. Can also represent a pure
 * rotation/scale without translation.
 *
 * <pre>{@code
 * Basis b = Basis.fromEuler(new Vector3(0.5, 0.3, 0.1));
 * Vector3 rotated = b.apply(Vector3.RIGHT);
 * Basis inv = b.inverse();
 * }</pre>
 */
public final class Basis {

	// Column-major storage (same as Godot):
	// column 0: (xx, xy, xz)
	// column 1: (yx, yy, yz)
	// column 2: (zx, zy, zz)
	public double xx, xy, xz;
	public double yx, yy, yz;
	public double zx, zy, zz;

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	/**
	 * Identity basis (no rotation, unit scale).
	 */
	public Basis() {
		this.xx = 1;
		this.xy = 0;
		this.xz = 0;
		this.yx = 0;
		this.yy = 1;
		this.yz = 0;
		this.zx = 0;
		this.zy = 0;
		this.zz = 1;
	}

	/**
	 * Create from 9 elements in row-major order.
	 */
	public Basis(double xx, double xy, double xz, double yx, double yy, double yz, double zx, double zy, double zz) {
		this.xx = xx;
		this.xy = xy;
		this.xz = xz;
		this.yx = yx;
		this.yy = yy;
		this.yz = yz;
		this.zx = zx;
		this.zy = zy;
		this.zz = zz;
	}

	// ------------------------------------------------------------------------
	// Factory methods
	// ------------------------------------------------------------------------

	/**
	 * Rotation around X axis by angle (radians).
	 */
	public static Basis fromAxisAngleX(double angle) {
		double c = Math.cos(angle), s = Math.sin(angle);
		return new Basis(1, 0, 0, 0, c, -s, 0, s, c);
	}

	/**
	 * Rotation around Y axis by angle (radians).
	 */
	public static Basis fromAxisAngleY(double angle) {
		double c = Math.cos(angle), s = Math.sin(angle);
		return new Basis(c, 0, s, 0, 1, 0, -s, 0, c);
	}

	/**
	 * Rotation around Z axis by angle (radians).
	 */
	public static Basis fromAxisAngleZ(double angle) {
		double c = Math.cos(angle), s = Math.sin(angle);
		return new Basis(c, -s, 0, s, c, 0, 0, 0, 1);
	}

	/**
	 * Rotation around an arbitrary axis by angle (radians). Uses Rodrigues'
	 * rotation formula.
	 */
	public static Basis fromAxisAngle(Vector3 axis, double angle) {
		Vector3 normalized = axis.normalized();
		double x = normalized.x, y = normalized.y, z = normalized.z;
		double c = Math.cos(angle), s = Math.sin(angle), t = 1.0 - c;

		return new Basis(t * x * x + c, t * x * y - s * z, t * x * z + s * y, t * x * y + s * z, t * y * y + c,
				t * y * z - s * x, t * x * z - s * y, t * y * z + s * x, t * z * z + c);
	}

	/**
	 * Create from Euler angles (radians). Godot default order: YXZ (intrinsic Y,
	 * then X, then Z). Matrix: R_z(ez) * R_x(ex) * R_y(ey).
	 */
	public static Basis fromEuler(Vector3 euler) {
		double ex = euler.x, ey = euler.y, ez = euler.z;
		double cx = Math.cos(ex), sx = Math.sin(ex);
		double cy = Math.cos(ey), sy = Math.sin(ey);
		double cz = Math.cos(ez), sz = Math.sin(ez);

		// R_z(ez) * R_x(ex) * R_y(ey) — column-major
		// Column 0 (xx, xy, xz):
		double c0x = cz * cy + sz * sx * sy;
		double c0y = sz * cy - cz * sx * sy;
		double c0z = cx * sy;
		// Column 1 (yx, yy, yz):
		double c1x = -sz * cx;
		double c1y = cz * cx;
		double c1z = -sx;
		// Column 2 (zx, zy, zz):
		double c2x = -cz * sy + sz * sx * cy;
		double c2y = -sz * sy - cz * sx * cy;
		double c2z = cx * cy;

		return new Basis(c0x, c0y, c0z, c1x, c1y, c1z, c2x, c2y, c2z);
	}

	/**
	 * Diagonal scaling basis.
	 */
	public static Basis diagonal(Vector3 scale) {
		return new Basis(scale.x, 0, 0, 0, scale.y, 0, 0, 0, scale.z);
	}

	// ------------------------------------------------------------------------
	// Basic operations
	// ------------------------------------------------------------------------

	/**
	 * Determinant of the 3x3 matrix.
	 */
	public double determinant() {
		return xx * (yy * zz - yz * zy) - xy * (yx * zz - yz * zx) + xz * (yx * zy - yy * zx);
	}

	/**
	 * Transpose (swap rows and columns).
	 */
	public Basis transposed() {
		return new Basis(xx, yx, zx, xy, yy, zy, xz, yz, zz);
	}

	/**
	 * Inverse of the rotation/scale matrix.
	 */
	public Basis inverse() {
		double det = determinant();
		if (Math.abs(det) < 1e-10) {
			throw new ArithmeticException("Basis is singular and cannot be inverted");
		}
		double invDet = 1.0 / det;
		return new Basis((yy * zz - yz * zy) * invDet, (xz * zy - xy * zz) * invDet, (xy * yz - xz * yy) * invDet,

				(yz * zx - yx * zz) * invDet, (xx * zz - xz * zx) * invDet, (xz * yx - xx * yz) * invDet,

				(yx * zy - yy * zx) * invDet, (xy * zx - xx * zy) * invDet, (xx * yy - xy * yx) * invDet);
	}

	/**
	 * Matrix multiplication (concatenation).
	 */
	public Basis multiply(Basis other) {
		double nxx = xx * other.xx + yx * other.xy + zx * other.xz;
		double nxy = xy * other.xx + yy * other.xy + zy * other.xz;
		double nxz = xz * other.xx + yz * other.xy + zz * other.xz;

		double nyx = xx * other.yx + yx * other.yy + zx * other.yz;
		double nyy = xy * other.yx + yy * other.yy + zy * other.yz;
		double nyz = xz * other.yx + yz * other.yy + zz * other.yz;

		double nzx = xx * other.zx + yx * other.zy + zx * other.zz;
		double nzy = xy * other.zx + yy * other.zy + zy * other.zz;
		double nzz = xz * other.zx + yz * other.zy + zz * other.zz;

		return new Basis(nxx, nxy, nxz, nyx, nyy, nyz, nzx, nzy, nzz);
	}

	/**
	 * Apply basis to a vector.
	 */
	public Vector3 apply(Vector3 v) {
		return new Vector3(xx * v.x + yx * v.y + zx * v.z, xy * v.x + yy * v.y + zy * v.z,
				xz * v.x + yz * v.y + zz * v.z);
	}

	/**
	 * Scale the basis by a scalar.
	 */
	public Basis mul(double scalar) {
		return new Basis(xx * scalar, xy * scalar, xz * scalar, yx * scalar, yy * scalar, yz * scalar, zx * scalar,
				zy * scalar, zz * scalar);
	}

	// ------------------------------------------------------------------------
	// Rotation properties
	// ------------------------------------------------------------------------

	/**
	 * Get the rotation quaternion.
	 */
	public Quaternion toQuaternion() {
		double trace = xx + yy + zz;
		if (trace > 0) {
			double s = Math.sqrt(trace + 1.0) * 2.0; // s = 4 * w
			double w = 0.25 * s;
			double x = (zy - yz) / s;
			double y = (xz - zx) / s;
			double z = (yx - xy) / s;
			return new Quaternion(x, y, z, w);
		} else if (xx > yy && xx > zz) {
			double s = Math.sqrt(1.0 + xx - yy - zz) * 2.0;
			double w = (zy - yz) / s;
			double x = 0.25 * s;
			double y = (yx + xy) / s;
			double z = (xz + zx) / s;
			return new Quaternion(x, y, z, w);
		} else if (yy > zz) {
			double s = Math.sqrt(1.0 + yy - xx - zz) * 2.0;
			double w = (xz - zx) / s;
			double x = (yx + xy) / s;
			double y = 0.25 * s;
			double z = (zy + yz) / s;
			return new Quaternion(x, y, z, w);
		} else {
			double s = Math.sqrt(1.0 + zz - xx - yy) * 2.0;
			double w = (yx - xy) / s;
			double x = (xz + zx) / s;
			double y = (zy + yz) / s;
			double z = 0.25 * s;
			return new Quaternion(x, y, z, w);
		}
	}

	/**
	 * Get scale from basis (column vector lengths).
	 */
	public Vector3 getScale() {
		return new Vector3(Math.sqrt(xx * xx + xy * xy + xz * xz), Math.sqrt(yx * yx + yy * yy + yz * yz),
				Math.sqrt(zx * zx + zy * zy + zz * zz));
	}

	/**
	 * Get the Euler angles (radians). Returns Z, Y, X order.
	 */
	public Vector3 toEuler() {
		// YXZ order (Godot default)
		double sy = Math.sqrt(zx * zx + zy * zy);
		boolean singular = sy < 1e-6;
		double ex, ey, ez;
		if (singular) {
			ez = Math.atan2(-yx, xx);
			ex = Math.atan2(zx, zz);
			ey = 0;
		} else {
			ez = Math.atan2(zy, zx);
			ex = Math.atan2(yz, yy);
			ey = Math.atan2(-zy, sy);
		}
		return new Vector3(ex, ey, ez);
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Override
	public String toString() {
		return "Basis[\n  (" + xx + "," + xy + "," + xz + "),\n  (" + yx + "," + yy + "," + yz + "),\n  (" + zx + ","
				+ zy + "," + zz + ")]";
	}
}
