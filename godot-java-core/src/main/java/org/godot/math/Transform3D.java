package org.godot.math;

/**
 * 3D transform (4x4 homogeneous matrix: 3x3 basis + origin).
 *
 * Represents rotation, scale, and translation in 3D space. The implicit bottom
 * row is (0, 0, 0, 1).
 *
 * <pre>{@code
 * Transform3D t = Transform3D.identity();
 * t = t.translated(new Vector3(1, 2, 3));
 * t = t.rotated(Vector3.UP, Math.PI / 2);
 * Vector3 pos = t.apply(new Vector3(1, 0, 0)); // rotated + translated
 * }</pre>
 */
public final class Transform3D {

	/**
	 * Basis: three column vectors defining rotation and scale.
	 */
	public double xx, xy, xz; // column 0
	public double yx, yy, yz; // column 1
	public double zx, zy, zz; // column 2

	/**
	 * Origin / translation.
	 */
	public double ox, oy, oz;

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	/**
	 * Create identity transform.
	 */
	public Transform3D() {
		this.xx = 1;
		this.xy = 0;
		this.xz = 0;
		this.yx = 0;
		this.yy = 1;
		this.yz = 0;
		this.zx = 0;
		this.zy = 0;
		this.zz = 1;
		this.ox = 0;
		this.oy = 0;
		this.oz = 0;
	}

	/**
	 * Create from basis columns and origin.
	 *
	 * @param bx
	 *            X basis column (xx, xy, xz)
	 * @param by
	 *            Y basis column (yx, yy, yz)
	 * @param bz
	 *            Z basis column (zx, zy, zz)
	 * @param origin
	 *            Translation (ox, oy, oz)
	 */
	public Transform3D(Vector3 bx, Vector3 by, Vector3 bz, Vector3 origin) {
		this.xx = bx.x;
		this.xy = bx.y;
		this.xz = bx.z;
		this.yx = by.x;
		this.yy = by.y;
		this.yz = by.z;
		this.zx = bz.x;
		this.zy = bz.y;
		this.zz = bz.z;
		this.ox = origin.x;
		this.oy = origin.y;
		this.oz = origin.z;
	}

	/**
	 * Create from basis object and origin.
	 */
	public Transform3D(Basis basis, Vector3 origin) {
		this.xx = basis.xx;
		this.xy = basis.xy;
		this.xz = basis.xz;
		this.yx = basis.yx;
		this.yy = basis.yy;
		this.yz = basis.yz;
		this.zx = basis.zx;
		this.zy = basis.zy;
		this.zz = basis.zz;
		this.ox = origin.x;
		this.oy = origin.y;
		this.oz = origin.z;
	}

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------

	public static final Transform3D IDENTITY = new Transform3D();
	public static final Transform3D FLIP_X = new Transform3D(new Vector3(-1, 0, 0), new Vector3(0, 1, 0),
			new Vector3(0, 0, 1), new Vector3(0, 0, 0));

	// ------------------------------------------------------------------------
	// Factory methods
	// ------------------------------------------------------------------------

	/**
	 * Translation by offset.
	 */
	public static Transform3D translated(Vector3 offset) {
		Transform3D t = new Transform3D();
		t.ox = offset.x;
		t.oy = offset.y;
		t.oz = offset.z;
		return t;
	}

	/**
	 * Rotation by angle (radians) around axis.
	 */
	public static Transform3D rotated(Vector3 axis, double angle) {
		Basis b = Basis.fromAxisAngle(axis, angle);
		return new Transform3D(b, Vector3.ZERO);
	}

	/**
	 * Uniform scale.
	 */
	public static Transform3D scaled(Vector3 scale) {
		Transform3D t = new Transform3D();
		t.xx = scale.x;
		t.yy = scale.y;
		t.zz = scale.z;
		return t;
	}

	// ------------------------------------------------------------------------
	// Operations
	// ------------------------------------------------------------------------

	/**
	 * Transform a 3D point (applies translation).
	 */
	public Vector3 apply(Vector3 point) {
		return new Vector3(xx * point.x + yx * point.y + zx * point.z + ox,
				xy * point.x + yy * point.y + zy * point.z + oy, xz * point.x + yz * point.y + zz * point.z + oz);
	}

	/**
	 * Transform a 3D direction (ignores translation).
	 */
	public Vector3 applyDir(Vector3 direction) {
		return new Vector3(xx * direction.x + yx * direction.y + zx * direction.z,
				xy * direction.x + yy * direction.y + zy * direction.z,
				xz * direction.x + yz * direction.y + zz * direction.z);
	}

	/**
	 * Concatenate: returns this * other.
	 */
	public Transform3D multiply(Transform3D other) {
		double nxx = xx * other.xx + yx * other.xy + zx * other.xz;
		double nxy = xy * other.xx + yy * other.xy + zy * other.xz;
		double nxz = xz * other.xx + yz * other.xy + zz * other.xz;

		double nyx = xx * other.yx + yx * other.yy + zx * other.yz;
		double nyy = xy * other.yx + yy * other.yy + zy * other.yz;
		double nyz = xz * other.yx + yz * other.yy + zz * other.yz;

		double nzx = xx * other.zx + yx * other.zy + zx * other.zz;
		double nzy = xy * other.zx + yy * other.zy + zy * other.zz;
		double nzz = xz * other.zx + yz * other.zy + zz * other.zz;

		double nox = xx * other.ox + yx * other.oy + zx * other.oz + ox;
		double noy = xy * other.ox + yy * other.oy + zy * other.oz + oy;
		double noz = xz * other.ox + yz * other.oy + zz * other.oz + oz;

		Transform3D r = new Transform3D();
		r.xx = nxx;
		r.xy = nxy;
		r.xz = nxz;
		r.yx = nyx;
		r.yy = nyy;
		r.yz = nyz;
		r.zx = nzx;
		r.zy = nzy;
		r.zz = nzz;
		r.ox = nox;
		r.oy = noy;
		r.oz = noz;
		return r;
	}

	/**
	 * Invert this transform. inv(T) = [inv(B), -inv(B) * origin]
	 */
	public Transform3D inverse() {
		Basis invBasis = getBasis().inverse();
		Vector3 negOrigin = new Vector3(-ox, -oy, -oz);
		Vector3 newOrigin = invBasis.apply(negOrigin);
		return new Transform3D(invBasis, newOrigin);
	}

	/**
	 * Linear interpolation between two transforms.
	 */
	public Transform3D lerp(Transform3D other, double t) {
		Basis b = new Basis(xx, xy, xz, yx, yy, yz, zx, zy, zz);
		Basis ob = new Basis(other.xx, other.xy, other.xz, other.yx, other.yy, other.yz, other.zx, other.zy, other.zz);
		Vector3 orig = new Vector3(ox, oy, oz).lerp(new Vector3(other.ox, other.oy, other.oz), t);
		// Simple linear interpolation of basis columns
		return new Transform3D(new Vector3(xx, xy, xz).lerp(new Vector3(other.xx, other.xy, other.xz), t),
				new Vector3(yx, yy, yz).lerp(new Vector3(other.yx, other.yy, other.yz), t),
				new Vector3(zx, zy, zz).lerp(new Vector3(other.zx, other.zy, other.zz), t), orig);
	}

	/**
	 * Get the basis as a Basis object.
	 */
	public Basis getBasis() {
		return new Basis(xx, xy, xz, yx, yy, yz, zx, zy, zz);
	}

	/**
	 * Get the origin as a Vector3.
	 */
	public Vector3 getOrigin() {
		return new Vector3(ox, oy, oz);
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Override
	public String toString() {
		return "Transform3D[\n  basis=(" + xx + "," + xy + "," + xz + ";" + yx + "," + yy + "," + yz + ";" + zx + ","
				+ zy + "," + zz + ")," + " origin=(" + ox + "," + oy + "," + oz + ")]";
	}
}
