package org.godot.math;

/**
 * 2D transform (3x2 matrix: basis + origin).
 *
 * Stores a 2D rotation/scale (two column vectors) and a 2D translation origin.
 * The implicit third row is (0, 0, 1).
 *
 * <pre>{@code
 * Transform2D t = Transform2D.identity();
 * t = t.translated(new Vector2(100, 50));
 * t = t.rotated(Math.PI / 2);
 * Vector2 pos = t.apply(new Vector2(1, 0)); // rotated + translated point
 * }</pre>
 */
public final class Transform2D {

	/**
	 * X axis (first column): (cos, sin) after rotation.
	 */
	public Vector2 x;
	/**
	 * Y axis (second column): (-sin, cos) after rotation.
	 */
	public Vector2 y;
	/**
	 * Origin / translation (third column).
	 */
	public Vector2 origin;

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	/**
	 * Create identity transform.
	 */
	public Transform2D() {
		this.x = new Vector2(1, 0);
		this.y = new Vector2(0, 1);
		this.origin = new Vector2(0, 0);
	}

	/**
	 * Create transform from basis columns and origin.
	 *
	 * @param xAxis
	 *            X axis of the basis (first column)
	 * @param yAxis
	 *            Y axis of the basis (second column)
	 * @param origin
	 *            Translation (third column)
	 */
	public Transform2D(Vector2 xAxis, Vector2 yAxis, Vector2 origin) {
		this.x = xAxis;
		this.y = yAxis;
		this.origin = origin;
	}

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------

	public static final Transform2D IDENTITY = new Transform2D(new Vector2(1, 0), new Vector2(0, 1), new Vector2(0, 0));
	public static final Transform2D FLIP_X = new Transform2D(new Vector2(-1, 0), new Vector2(0, 1), new Vector2(0, 0));
	public static final Transform2D FLIP_Y = new Transform2D(new Vector2(1, 0), new Vector2(0, -1), new Vector2(0, 0));

	// ------------------------------------------------------------------------
	// Factory methods
	// ------------------------------------------------------------------------

	/**
	 * Rotation by angle (radians) around origin.
	 */
	public static Transform2D rotated(double angle) {
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		return new Transform2D(new Vector2(cos, sin), new Vector2(-sin, cos), new Vector2(0, 0));
	}

	/**
	 * Translation by offset.
	 */
	public static Transform2D translated(Vector2 offset) {
		return new Transform2D(new Vector2(1, 0), new Vector2(0, 1), offset);
	}

	/**
	 * Non-uniform scale.
	 */
	public static Transform2D scaled(Vector2 scale) {
		return new Transform2D(new Vector2(scale.x, 0), new Vector2(0, scale.y), new Vector2(0, 0));
	}

	// ------------------------------------------------------------------------
	// Operations
	// ------------------------------------------------------------------------

	/**
	 * Transform a 2D point (applies translation). result = M * point + origin
	 */
	public Vector2 apply(Vector2 point) {
		return new Vector2(x.x * point.x + y.x * point.y + origin.x, x.y * point.x + y.y * point.y + origin.y);
	}

	/**
	 * Transform a 2D direction vector (ignores translation). result = M * dir
	 */
	public Vector2 applyDir(Vector2 direction) {
		return new Vector2(x.x * direction.x + y.x * direction.y, x.y * direction.x + y.y * direction.y);
	}

	/**
	 * Transform the X axis direction.
	 */
	public Vector2 applyXAxis(Vector2 point) {
		return new Vector2(x.x * point.x + y.x * point.y, x.y * point.x + y.y * point.y);
	}

	/**
	 * Transform the Y axis direction.
	 */
	public Vector2 applyYAxis(Vector2 point) {
		return new Vector2(x.x * point.x + y.x * point.y, x.y * point.x + y.y * point.y);
	}

	/**
	 * Concatenate (multiply) this transform with another. Returns this * other
	 * (application order: apply other first, then this).
	 */
	public Transform2D multiply(Transform2D other) {
		return new Transform2D(applyDir(other.x), applyDir(other.y), apply(other.origin));
	}

	/**
	 * Invert this transform.
	 */
	public Transform2D inverse() {
		// For 2D affine transform: [R|t] -> [R^-1 | -R^-1 * t]
		// Where R = [x.x, y.x; x.y, y.y]
		double det = x.x * y.y - y.x * x.y;
		if (Math.abs(det) < 1e-10) {
			throw new ArithmeticException("Transform2D is singular and cannot be inverted");
		}
		double invDet = 1.0 / det;
		// R^-1 = (1/det) * [y.y, -y.x; -x.y, x.x]
		Vector2 newX = new Vector2(invDet * y.y, -invDet * x.y);
		Vector2 newY = new Vector2(-invDet * y.x, invDet * x.x);
		// -R^-1 * t
		double ox = -(newX.x * origin.x + newX.y * origin.y);
		double oy = -(newY.x * origin.x + newY.y * origin.y);
		return new Transform2D(newX, newY, new Vector2(ox, oy));
	}

	/**
	 * Linear interpolation between two transforms.
	 */
	public Transform2D lerp(Transform2D other, double t) {
		return new Transform2D(x.lerp(other.x, t), y.lerp(other.y, t), origin.lerp(other.origin, t));
	}

	/**
	 * Get the rotation angle in radians.
	 */
	public double getRotation() {
		return Math.atan2(x.y, x.x);
	}

	/**
	 * Get the scale from the basis.
	 */
	public Vector2 getScale() {
		return new Vector2(x.length(), y.length());
	}

	/**
	 * Get the determinant of the basis matrix.
	 */
	public double determinant() {
		return x.x * y.y - y.x * x.y;
	}

	/**
	 * Get a column vector by index (0=x, 1=y, 2=origin).
	 */
	public Vector2 getColumn(int index) {
		return switch (index) {
			case 0 -> x;
			case 1 -> y;
			case 2 -> origin;
			default -> throw new IndexOutOfBoundsException("Transform2D column " + index);
		};
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Override
	public String toString() {
		return "Transform2D[\n  " + x + ", " + y + ", " + origin + "]";
	}
}
