package org.godot.node;

import org.godot.math.Vector2;

/**
 * A 2D game object. Base class for all 2D nodes. Provides position, rotation,
 * scale, and Z-index.
 *
 * <pre>{@code
 * public class Player extends Node2D {
 * 	protected void _ready() {
 * 		setPosition(new Vector2(100, 200));
 * 	}
 * }
 * }</pre>
 */
public class Node2D extends Node {

	/**
	 * Godot class name for method bind lookup.
	 */
	private static final String GODOT_CLASS_NAME = "Node2D";

	private static final java.util.Map<String, Long> METHOD_HASHES = java.util.Map.of("set_position", 743155724L,
			"get_position", 3341600327L, "set_rotation", 373806689L, "get_rotation", 1740695150L, "set_scale",
			743155724L, "get_scale", 3341600327L, "set_z_index", 373806689L, "translate", 743155724L);

	/**
	 * Position.
	 */
	protected Vector2 position = new Vector2(0, 0);

	/**
	 * Rotation in radians.
	 */
	protected double rotation;

	/**
	 * Scale on X and Y axes.
	 */
	protected Vector2 scale = new Vector2(1.0, 1.0);

	/**
	 * Z-index for draw order.
	 */
	protected int zIndex;

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	protected Node2D(long nativeObject) {
		super(nativeObject);
	}

	protected Node2D(java.lang.foreign.MemorySegment nativePtr) {
		super(nativePtr);
	}

	public Node2D() {
		super(0);
	}

	// ------------------------------------------------------------------------
	// Position
	// ------------------------------------------------------------------------

	public Vector2 getPosition() {
		return position;
	}
	public double getX() {
		return position.x;
	}
	public double getY() {
		return position.y;
	}

	public void setPosition(Vector2 pos) {
		this.position = pos;
		if (isValid()) {
			call("set_position", pos);
		}
	}

	public void setPosition(double x, double y) {
		setPosition(new Vector2(x, y));
	}

	public void setX(double x) {
		this.position = new Vector2(x, position.y);
		if (isValid()) {
			call("set_position", position);
		}
	}

	public void setY(double y) {
		this.position = new Vector2(position.x, y);
		if (isValid()) {
			call("set_position", position);
		}
	}

	// ------------------------------------------------------------------------
	// Rotation
	// ------------------------------------------------------------------------

	public double getRotation() {
		return rotation;
	}

	/**
	 * Set rotation in radians.
	 */
	public void setRotation(double radians) {
		this.rotation = radians;
		if (isValid()) {
			call("set_rotation", radians);
		}
	}

	/**
	 * Set rotation in degrees.
	 */
	public void setRotationDeg(double degrees) {
		setRotation(Math.toRadians(degrees));
	}

	public double getRotationDeg() {
		return Math.toDegrees(rotation);
	}

	// ------------------------------------------------------------------------
	// Scale
	// ------------------------------------------------------------------------

	public Vector2 getScale() {
		return scale;
	}
	public double getScaleX() {
		return scale.x;
	}
	public double getScaleY() {
		return scale.y;
	}

	public void setScale(Vector2 s) {
		this.scale = s;
		if (isValid()) {
			call("set_scale", s);
		}
	}

	public void setScale(double scaleX, double scaleY) {
		setScale(new Vector2(scaleX, scaleY));
	}

	// ------------------------------------------------------------------------
	// Z-Index
	// ------------------------------------------------------------------------

	public int getZIndex() {
		return zIndex;
	}
	public void setZIndex(int zIndex) {
		this.zIndex = zIndex;
		if (isValid()) {
			call("set_z_index", zIndex);
		}
	}

	// ------------------------------------------------------------------------
	// Transform
	// ------------------------------------------------------------------------

	/**
	 * Move the node by a delta (pixels).
	 */
	public void translate(double dx, double dy) {
		setPosition(position.x + dx, position.y + dy);
	}

	/**
	 * Rotate by angle in radians.
	 */
	public void rotate(double radians) {
		setRotation(rotation + radians);
	}

	@Override
	protected String getGodotClassName() {
		return "Node2D";
	}
}
