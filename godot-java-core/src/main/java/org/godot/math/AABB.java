package org.godot.math;

/**
 * Axis-Aligned Bounding Box (AABB) in 3D space.
 *
 * Defined by a minimum corner and a size (extent). The maximum corner is
 * implicitly min + size.
 *
 * <pre>{@code
 * AABB box = new AABB(new Vector3(0, 0, 0), new Vector3(10, 5, 3));
 * Vector3 center = box.getCenter();
 * boolean hits = box.intersects(otherBox);
 * AABB expanded = box.expanded(new Vector3(1, 0, 0)); // grows by 1 unit in +X
 * }</pre>
 */
public final class AABB {

	/**
	 * Position (minimum corner).
	 */
	public double x, y, z;
	/**
	 * Size / extent (always positive values).
	 */
	public double sizeX, sizeY, sizeZ;

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	/**
	 * Create an AABB at origin with zero size.
	 */
	public AABB() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.sizeX = 0;
		this.sizeY = 0;
		this.sizeZ = 0;
	}

	/**
	 * Create an AABB.
	 *
	 * @param position
	 *            Minimum corner position
	 * @param size
	 *            Extent (size) — must be non-negative
	 */
	public AABB(Vector3 position, Vector3 size) {
		this.x = position.x;
		this.y = position.y;
		this.z = position.z;
		this.sizeX = size.x;
		this.sizeY = size.y;
		this.sizeZ = size.z;
	}

	public AABB(double x, double y, double z, double sizeX, double sizeY, double sizeZ) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.sizeZ = sizeZ;
	}

	// ------------------------------------------------------------------------
	// Properties
	// ------------------------------------------------------------------------

	/**
	 * Get the position (minimum corner) as a Vector3.
	 */
	public Vector3 getPosition() {
		return new Vector3(x, y, z);
	}

	/**
	 * Get the size (extent) as a Vector3.
	 */
	public Vector3 getSize() {
		return new Vector3(sizeX, sizeY, sizeZ);
	}

	/**
	 * Get the maximum corner (position + size).
	 */
	public Vector3 getEnd() {
		return new Vector3(x + sizeX, y + sizeY, z + sizeZ);
	}

	/**
	 * Get the center point.
	 */
	public Vector3 getCenter() {
		return new Vector3(x + sizeX * 0.5, y + sizeY * 0.5, z + sizeZ * 0.5);
	}

	// ------------------------------------------------------------------------
	// Operations
	// ------------------------------------------------------------------------

	/**
	 * Expand the AABB to include a point.
	 */
	public AABB expanded(Vector3 point) {
		double nx = Math.min(x, point.x);
		double ny = Math.min(y, point.y);
		double nz = Math.min(z, point.z);
		double mx = Math.max(x + sizeX, point.x);
		double my = Math.max(y + sizeY, point.y);
		double mz = Math.max(z + sizeZ, point.z);
		return new AABB(nx, ny, nz, mx - nx, my - ny, mz - nz);
	}

	/**
	 * Expand the AABB in all directions by a given amount (symmetric expansion).
	 */
	public AABB expand(double amount) {
		return new AABB(x - amount, y - amount, z - amount, sizeX + amount * 2, sizeY + amount * 2, sizeZ + amount * 2);
	}

	/**
	 * Grow the AABB by expanding its size symmetrically around its center.
	 */
	public AABB grow(double by) {
		return new AABB(x - by, y - by, z - by, sizeX + by * 2, sizeY + by * 2, sizeZ + by * 2);
	}

	/**
	 * Check if this AABB intersects (overlaps) another AABB.
	 */
	public boolean intersects(AABB other) {
		if (x + sizeX < other.x || other.x + other.sizeX < x)
			return false;
		if (y + sizeY < other.y || other.y + other.sizeY < y)
			return false;
		if (z + sizeZ < other.z || other.z + other.sizeZ < z)
			return false;
		return true;
	}

	/**
	 * Check if this AABB completely encloses another AABB.
	 */
	public boolean encloses(AABB other) {
		return x <= other.x && y <= other.y && z <= other.z && x + sizeX >= other.x + other.sizeX
				&& y + sizeY >= other.y + other.sizeY && z + sizeZ >= other.z + other.sizeZ;
	}

	/**
	 * Check if this AABB contains a point (within inclusive bounds).
	 */
	public boolean contains(Vector3 point) {
		return point.x >= x && point.x <= x + sizeX && point.y >= y && point.y <= y + sizeY && point.z >= z
				&& point.z <= z + sizeZ;
	}

	/**
	 * Merge this AABB with another, returning the minimal AABB containing both.
	 */
	public AABB merge(AABB other) {
		double nx = Math.min(x, other.x);
		double ny = Math.min(y, other.y);
		double nz = Math.min(z, other.z);
		double mx = Math.max(x + sizeX, other.x + other.sizeX);
		double my = Math.max(y + sizeY, other.y + other.sizeY);
		double mz = Math.max(z + sizeZ, other.z + other.sizeZ);
		return new AABB(nx, ny, nz, mx - nx, my - ny, mz - nz);
	}

	/**
	 * Get the intersection of two AABBs, or null if they don't overlap.
	 */
	public AABB intersection(AABB other) {
		double nx = Math.max(x, other.x);
		double ny = Math.max(y, other.y);
		double nz = Math.max(z, other.z);
		double mx = Math.min(x + sizeX, other.x + other.sizeX);
		double my = Math.min(y + sizeY, other.y + other.sizeY);
		double mz = Math.min(z + sizeZ, other.z + other.sizeZ);
		if (mx < nx || my < ny || mz < nz)
			return null;
		return new AABB(nx, ny, nz, mx - nx, my - ny, mz - nz);
	}

	/**
	 * Surface area of the AABB (for spatial partitioning).
	 */
	public double getArea() {
		return 2.0 * (sizeX * sizeY + sizeY * sizeZ + sizeZ * sizeX);
	}

	/**
	 * Volume of the AABB.
	 */
	public double getVolume() {
		return sizeX * sizeY * sizeZ;
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Override
	public String toString() {
		return "AABB(pos=(" + x + "," + y + "," + z + "), size=(" + sizeX + "," + sizeY + "," + sizeZ + "))";
	}
}
