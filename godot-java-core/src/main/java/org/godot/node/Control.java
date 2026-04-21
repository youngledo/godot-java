package org.godot.node;

import org.godot.bridge.Bridge;
import org.godot.core.GodotStringName;
import org.godot.internal.api.ApiIndex;

import java.lang.foreign.MemorySegment;

/**
 * Base class for all UI elements. Control nodes use anchors, margins, and size
 * flags for layout instead of global coordinates.
 */
public class Control extends Node {

	/**
	 * Godot class name for method bind lookup.
	 */
	private static final String GODOT_CLASS_NAME = "Control";

	private static final java.util.Map<String, Long> METHOD_HASHES = java.util.Map.of("get_minimum_width", 866169185L,
			"get_minimum_height", 866169185L, "set_custom_minimum_size", 743155724L, "set_anchors_preset", 509135270L);

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	protected Control(long nativeObject) {
		super(nativeObject);
	}

	protected Control(java.lang.foreign.MemorySegment nativePtr) {
		super(nativePtr);
	}

	public Control() {
		super(0);
	}

	/**
	 * Create a new native Godot Control and return a wrapper for it.
	 */
	public static Control create() {
		GodotStringName controlClass = GodotStringName.fromJavaString("Control");
		MemorySegment nativePtr = Bridge.callPtr(ApiIndex.CLASSDB_CONSTRUCT_OBJECT, controlClass.segment());
		return new Control(nativePtr);
	}

	// ------------------------------------------------------------------------
	// Layout
	// ------------------------------------------------------------------------

	/**
	 * Get the minimum width.
	 */
	public double getMinimumWidth() {
		if (!isValid())
			return 0;
		var result = call("get_minimum_width");
		if (result instanceof Number n) {
			return n.doubleValue();
		}
		return 0;
	}

	/**
	 * Get the minimum height.
	 */
	public double getMinimumHeight() {
		if (!isValid())
			return 0;
		var result = call("get_minimum_height");
		if (result instanceof Number n) {
			return n.doubleValue();
		}
		return 0;
	}

	/**
	 * Set the custom minimum size.
	 */
	public void setCustomMinimumSize(double width, double height) {
		if (!isValid())
			return;
		call("set_custom_minimum_size", new org.godot.math.Vector2(width, height));
	}

	/**
	 * Set the custom minimum size using a Vector2.
	 */
	public void setCustomMinimumSize(org.godot.math.Vector2 size) {
		if (!isValid())
			return;
		call("set_custom_minimum_size", size);
	}

	/**
	 * Set anchor to all edges (full parent size).
	 *
	 * @param preset
	 *            Layout preset (e.g., LayoutPreset.FULL_RECT)
	 * @param keepOffsets
	 *            If true, keep the current margin offsets
	 */
	public void setAnchorsPreset(int preset, boolean keepOffsets) {
		if (!isValid())
			return;
		call("set_anchors_preset", preset, keepOffsets);
	}

	/**
	 * Set anchor to all edges (full parent size).
	 *
	 * @param preset
	 *            Layout preset (e.g., LayoutPreset.FULL_RECT)
	 */
	public void setAnchorsPreset(int preset) {
		setAnchorsPreset(preset, false);
	}

	@Override
	protected String getGodotClassName() {
		return GODOT_CLASS_NAME;
	}
}
