package org.godot.math;

/**
 * 4x4 projection matrix. Memory layout: 4 Vector4 columns, 64 bytes total
 * (float_32).
 */
public final class Projection {
	/**
	 * X column of the projection matrix.
	 */
	public Vector4 x;
	/**
	 * Y column of the projection matrix.
	 */
	public Vector4 y;
	/**
	 * Z column of the projection matrix.
	 */
	public Vector4 z;
	/**
	 * W column of the projection matrix.
	 */
	public Vector4 w;

	public Projection() {
		this.x = new Vector4();
		this.y = new Vector4();
		this.z = new Vector4();
		this.w = new Vector4();
	}

	public Projection(Vector4 x, Vector4 y, Vector4 z, Vector4 w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
}
