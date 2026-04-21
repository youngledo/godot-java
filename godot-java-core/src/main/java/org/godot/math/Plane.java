package org.godot.math;

/**
 * Infinite 3D plane defined by a unit normal vector and a distance from origin.
 *
 * Equation: normal · point = d Where normal = (x, y, z) and d = the signed
 * distance.
 *
 * <pre>{@code
 * Plane p = new Plane(Vector3.UP, -1.0); // horizontal plane at y=1
 * boolean contains = p.hasPoint(myPoint);
 * double dist = p.distanceTo(point);
 * }</pre>
 */
public final class Plane {

	/**
	 * Unit normal vector.
	 */
	public double x, y, z;
	/**
	 * D constant: signed distance from origin.
	 */
	public double d;

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	/**
	 * Create a plane with the given normal and D value.
	 */
	public Plane(double x, double y, double z, double d) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.d = d;
	}

	/**
	 * Create a plane with the given normal vector and D value.
	 */
	public Plane(Vector3 normal, double d) {
		this.x = normal.x;
		this.y = normal.y;
		this.z = normal.z;
		this.d = d;
	}

	/**
	 * Create a plane from three non-collinear points. The plane normal is computed
	 * from the cross product of (p1-p0) × (p2-p0).
	 */
	public static Plane fromPoints(Vector3 p0, Vector3 p1, Vector3 p2) {
		Vector3 edge1 = p1.sub(p0);
		Vector3 edge2 = p2.sub(p0);
		Vector3 normal = edge1.cross(edge2).normalized();
		double d = normal.dot(p0);
		return new Plane(normal, d);
	}

	/**
	 * Create a plane from a normal vector and a point on the plane.
	 */
	public static Plane fromNormalPoint(Vector3 normal, Vector3 point) {
		Vector3 n = normal.normalized();
		return new Plane(n, n.dot(point));
	}

	// ------------------------------------------------------------------------
	// Properties
	// ------------------------------------------------------------------------

	/**
	 * Get the normal vector.
	 */
	public Vector3 getNormal() {
		return new Vector3(x, y, z);
	}

	/**
	 * Get the D value (distance from origin along normal).
	 */
	public double getD() {
		return d;
	}

	/**
	 * Returns the signed distance from a point to the plane.
	 */
	public double distanceTo(Vector3 point) {
		return x * point.x + y * point.y + z * point.z - d;
	}

	/**
	 * Returns true if the given point is on the plane (within epsilon tolerance).
	 */
	public boolean hasPoint(Vector3 point, double epsilon) {
		return Math.abs(distanceTo(point)) < epsilon;
	}

	/**
	 * HasPoint with default epsilon.
	 */
	public boolean hasPoint(Vector3 point) {
		return hasPoint(point, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Operations
	// ------------------------------------------------------------------------

	/**
	 * Get the center point of the plane.
	 */
	public Vector3 center() {
		return new Vector3(x * d, y * d, z * d);
	}

	/**
	 * Flip the plane (negate normal and D).
	 */
	public Plane flipped() {
		return new Plane(-x, -y, -z, -d);
	}

	/**
	 * Normalize the plane so the normal has unit length.
	 */
	public Plane normalized() {
		double len = Math.sqrt(x * x + y * y + z * z);
		if (len == 0)
			return new Plane(0, 0, 1, 0);
		double inv = 1.0 / len;
		return new Plane(x * inv, y * inv, z * inv, d * inv);
	}

	/**
	 * Project a point onto the plane.
	 */
	public Vector3 project(Vector3 point) {
		// project(p) = p - normal * distanceTo(p)
		double dist = distanceTo(point);
		return new Vector3(point.x - x * dist, point.y - y * dist, point.z - z * dist);
	}

	// ------------------------------------------------------------------------
	// Intersection methods
	// ------------------------------------------------------------------------

	/**
	 * Intersect this plane with another plane. Returns the line of intersection as
	 * a point and direction, or null if parallel.
	 */
	public Vector3[] intersectPlane(Plane other) {
		// Two planes: n1·p = d1, n2·p = d2
		// Line direction = n1 × n2
		Vector3 n1 = new Vector3(x, y, z);
		Vector3 n2 = new Vector3(other.x, other.y, other.z);
		Vector3 direction = n1.cross(n2);

		double det = direction.lengthSquared();
		if (det < 1e-10)
			return null; // Parallel planes

		// Point on intersection line
		// Use Cramer's rule to solve the 2x2 system
		double c1 = d * n2.z - other.d * n2.y;
		double c2 = -d * n2.x + other.d * n2.z;
		double c3 = d * n1.y - other.d * n1.x;
		double c4 = -d * n1.z + other.d * n1.z;
		double denom = x * n2.y - y * n2.x;

		if (Math.abs(denom) < 1e-10) {
			// Degenerate case: try other combinations
			denom = x * n2.z - z * n2.x;
			if (Math.abs(denom) < 1e-10) {
				denom = y * n2.z - z * n2.y;
			}
		}

		double px = c1 / denom;
		double py = c2 / denom;
		double pz = c3 / denom;
		Vector3 point = new Vector3(px, py, pz);

		return new Vector3[]{point, direction.normalized()};
	}

	/**
	 * Intersect this plane with a ray (origin + direction). Returns the
	 * intersection point, or null if no intersection.
	 *
	 * @param from
	 *            Ray origin
	 * @param dir
	 *            Ray direction (unit vector recommended)
	 */
	public Vector3 intersectRay(Vector3 from, Vector3 dir) {
		double denom = x * dir.x + y * dir.y + z * dir.z;
		if (Math.abs(denom) < 1e-10)
			return null; // Ray is parallel to plane

		double t = (d - (x * from.x + y * from.y + z * from.z)) / denom;
		if (t < 0)
			return null; // Intersection is behind the ray origin

		return new Vector3(from.x + dir.x * t, from.y + dir.y * t, from.z + dir.z * t);
	}

	/**
	 * Intersect this plane with a line segment between two points. Returns the
	 * intersection point, or null if no intersection.
	 */
	public Vector3 intersectSegment(Vector3 p1, Vector3 p2) {
		Vector3 dir = p2.sub(p1);
		double denom = x * dir.x + y * dir.y + z * dir.z;
		if (Math.abs(denom) < 1e-10)
			return null;

		double t = (d - (x * p1.x + y * p1.y + z * p1.z)) / denom;
		if (t < 0 || t > 1)
			return null;

		return new Vector3(p1.x + dir.x * t, p1.y + dir.y * t, p1.z + dir.z * t);
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Override
	public String toString() {
		return "Plane(normal=(" + x + ", " + y + ", " + z + "), d=" + d + ")";
	}
}
