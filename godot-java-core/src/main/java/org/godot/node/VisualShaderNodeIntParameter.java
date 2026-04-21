package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeIntParameter extends VisualShaderNodeParameter {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_min", 1286410249L), java.util.Map.entry("get_min", 3905245786L),
			java.util.Map.entry("get_step", 3905245786L), java.util.Map.entry("get_enum_names", 1139954409L),
			java.util.Map.entry("set_default_value_enabled", 2586408642L), java.util.Map.entry("get_max", 3905245786L),
			java.util.Map.entry("set_max", 1286410249L), java.util.Map.entry("get_default_value", 3905245786L),
			java.util.Map.entry("is_default_value_enabled", 36873697L), java.util.Map.entry("set_step", 1286410249L),
			java.util.Map.entry("set_default_value", 1286410249L), java.util.Map.entry("get_hint", 4250814924L),
			java.util.Map.entry("set_enum_names", 4015028928L), java.util.Map.entry("set_hint", 2540512075L));

	VisualShaderNodeIntParameter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeIntParameter(long nativePointer) {
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

	public long getMin() {
		return (long) super.call("get_min", new java.lang.Object[0]);
	}

	public void setMin(long value) {
		super.call("set_min", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMax() {
		return (long) super.call("get_max", new java.lang.Object[0]);
	}

	public void setMax(long value) {
		super.call("set_max", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getStep() {
		return (long) super.call("get_step", new java.lang.Object[0]);
	}

	public void setStep(long value) {
		super.call("set_step", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String[] getEnum_names() {
		return (String[]) super.call("get_enum_names", new java.lang.Object[0]);
	}

	public void setEnum_names(String[] value) {
		super.call("set_enum_names", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isDefault_value_enabled() {
		return (boolean) super.call("is_default_value_enabled", new java.lang.Object[0]);
	}

	public void setDefault_value_enabled(boolean value) {
		super.call("set_default_value_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getDefault_value() {
		return (long) super.call("get_default_value", new java.lang.Object[0]);
	}

	public void setDefault_value(long value) {
		super.call("set_default_value", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
