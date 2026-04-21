package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeFloatParameter extends VisualShaderNodeParameter {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_min", 373806689L), java.util.Map.entry("get_max", 1740695150L),
			java.util.Map.entry("set_max", 373806689L), java.util.Map.entry("get_default_value", 1740695150L),
			java.util.Map.entry("get_min", 1740695150L), java.util.Map.entry("get_step", 1740695150L),
			java.util.Map.entry("is_default_value_enabled", 36873697L), java.util.Map.entry("set_step", 373806689L),
			java.util.Map.entry("set_default_value", 373806689L),
			java.util.Map.entry("set_default_value_enabled", 2586408642L), java.util.Map.entry("get_hint", 3042240429L),
			java.util.Map.entry("set_hint", 3712586466L));

	VisualShaderNodeFloatParameter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeFloatParameter(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_default_value_enabled() {
		return (boolean) super.call("is_default_value_enabled");
	}

	public long getHint() {
		return (long) super.call("get_hint", new java.lang.Object[0]);
	}

	public void setHint(long value) {
		super.call("set_hint", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getMin() {
		return (double) super.call("get_min", new java.lang.Object[0]);
	}

	public void setMin(double value) {
		super.call("set_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMax() {
		return (double) super.call("get_max", new java.lang.Object[0]);
	}

	public void setMax(double value) {
		super.call("set_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getStep() {
		return (double) super.call("get_step", new java.lang.Object[0]);
	}

	public void setStep(double value) {
		super.call("set_step", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isDefault_value_enabled() {
		return (boolean) super.call("is_default_value_enabled", new java.lang.Object[0]);
	}

	public void setDefault_value_enabled(boolean value) {
		super.call("set_default_value_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getDefault_value() {
		return (double) super.call("get_default_value", new java.lang.Object[0]);
	}

	public void setDefault_value(double value) {
		super.call("set_default_value", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
