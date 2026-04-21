package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PhysicsMaterial extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_absorbent", 2586408642L), java.util.Map.entry("set_rough", 2586408642L),
			java.util.Map.entry("get_bounce", 1740695150L), java.util.Map.entry("get_friction", 1740695150L),
			java.util.Map.entry("set_bounce", 373806689L), java.util.Map.entry("is_rough", 36873697L),
			java.util.Map.entry("set_friction", 373806689L), java.util.Map.entry("is_absorbent", 36873697L));

	PhysicsMaterial(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsMaterial(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_rough() {
		return (boolean) super.call("is_rough");
	}

	public boolean is_absorbent() {
		return (boolean) super.call("is_absorbent");
	}

	public double getFriction() {
		return (double) super.call("get_friction", new java.lang.Object[0]);
	}

	public void setFriction(double value) {
		super.call("set_friction", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isRough() {
		return (boolean) super.call("is_rough", new java.lang.Object[0]);
	}

	public void setRough(boolean value) {
		super.call("set_rough", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getBounce() {
		return (double) super.call("get_bounce", new java.lang.Object[0]);
	}

	public void setBounce(double value) {
		super.call("set_bounce", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isAbsorbent() {
		return (boolean) super.call("is_absorbent", new java.lang.Object[0]);
	}

	public void setAbsorbent(boolean value) {
		super.call("set_absorbent", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
