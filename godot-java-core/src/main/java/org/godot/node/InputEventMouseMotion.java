package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class InputEventMouseMotion extends InputEventMouse {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_pressure", 373806689L), java.util.Map.entry("get_pressure", 1740695150L),
			java.util.Map.entry("set_relative", 743155724L), java.util.Map.entry("get_relative", 3341600327L),
			java.util.Map.entry("set_tilt", 743155724L), java.util.Map.entry("set_screen_velocity", 743155724L),
			java.util.Map.entry("get_screen_relative", 3341600327L), java.util.Map.entry("set_velocity", 743155724L),
			java.util.Map.entry("get_velocity", 3341600327L), java.util.Map.entry("get_pen_inverted", 36873697L),
			java.util.Map.entry("get_tilt", 3341600327L), java.util.Map.entry("get_screen_velocity", 3341600327L),
			java.util.Map.entry("set_screen_relative", 743155724L),
			java.util.Map.entry("set_pen_inverted", 2586408642L));

	InputEventMouseMotion(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventMouseMotion(long nativePointer) {
		super(nativePointer);
	}

	public Vector2 getTilt() {
		return (Vector2) super.call("get_tilt", new java.lang.Object[0]);
	}

	public void setTilt(Vector2 value) {
		super.call("set_tilt", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getPressure() {
		return (double) super.call("get_pressure", new java.lang.Object[0]);
	}

	public void setPressure(double value) {
		super.call("set_pressure", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getPen_inverted() {
		return (boolean) super.call("get_pen_inverted", new java.lang.Object[0]);
	}

	public void setPen_inverted(boolean value) {
		super.call("set_pen_inverted", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getRelative() {
		return (Vector2) super.call("get_relative", new java.lang.Object[0]);
	}

	public void setRelative(Vector2 value) {
		super.call("set_relative", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getScreen_relative() {
		return (Vector2) super.call("get_screen_relative", new java.lang.Object[0]);
	}

	public void setScreen_relative(Vector2 value) {
		super.call("set_screen_relative", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getVelocity() {
		return (Vector2) super.call("get_velocity", new java.lang.Object[0]);
	}

	public void setVelocity(Vector2 value) {
		super.call("set_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getScreen_velocity() {
		return (Vector2) super.call("get_screen_velocity", new java.lang.Object[0]);
	}

	public void setScreen_velocity(Vector2 value) {
		super.call("set_screen_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}
}
