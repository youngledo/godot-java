package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Range extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_min", 373806689L), java.util.Map.entry("set_allow_greater", 2586408642L),
			java.util.Map.entry("get_min", 1740695150L), java.util.Map.entry("get_step", 1740695150L),
			java.util.Map.entry("set_value", 373806689L), java.util.Map.entry("is_using_rounded_values", 36873697L),
			java.util.Map.entry("set_exp_ratio", 2586408642L), java.util.Map.entry("get_as_ratio", 1740695150L),
			java.util.Map.entry("is_greater_allowed", 36873697L), java.util.Map.entry("set_allow_lesser", 2586408642L),
			java.util.Map.entry("get_max", 1740695150L), java.util.Map.entry("set_page", 373806689L),
			java.util.Map.entry("set_max", 373806689L), java.util.Map.entry("get_value", 1740695150L),
			java.util.Map.entry("unshare", 3218959716L), java.util.Map.entry("set_step", 373806689L),
			java.util.Map.entry("get_page", 1740695150L), java.util.Map.entry("set_as_ratio", 373806689L),
			java.util.Map.entry("is_lesser_allowed", 36873697L),
			java.util.Map.entry("set_use_rounded_values", 2586408642L), java.util.Map.entry("is_ratio_exp", 36873697L),
			java.util.Map.entry("share", 1078189570L), java.util.Map.entry("set_value_no_signal", 373806689L));

	Range(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Range(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_using_rounded_values() {
		return (boolean) super.call("is_using_rounded_values");
	}

	public boolean is_ratio_exp() {
		return (boolean) super.call("is_ratio_exp");
	}

	public boolean is_greater_allowed() {
		return (boolean) super.call("is_greater_allowed");
	}

	public boolean is_lesser_allowed() {
		return (boolean) super.call("is_lesser_allowed");
	}

	public void share(Node with) {
		super.call("share", new java.lang.Object[]{(java.lang.Object) with});
	}

	public void unshare() {
		super.call("unshare");
	}

	public double getMin_value() {
		return (double) super.call("get_min", new java.lang.Object[0]);
	}

	public void setMin_value(double value) {
		super.call("set_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMax_value() {
		return (double) super.call("get_max", new java.lang.Object[0]);
	}

	public void setMax_value(double value) {
		super.call("set_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getStep() {
		return (double) super.call("get_step", new java.lang.Object[0]);
	}

	public void setStep(double value) {
		super.call("set_step", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPage() {
		return (double) super.call("get_page", new java.lang.Object[0]);
	}

	public void setPage(double value) {
		super.call("set_page", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getValue() {
		return (double) super.call("get_value", new java.lang.Object[0]);
	}

	public void setValue(double value) {
		super.call("set_value", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRatio() {
		return (double) super.call("get_as_ratio", new java.lang.Object[0]);
	}

	public void setRatio(double value) {
		super.call("set_as_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isExp_edit() {
		return (boolean) super.call("is_ratio_exp", new java.lang.Object[0]);
	}

	public void setExp_edit(boolean value) {
		super.call("set_exp_ratio", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isRounded() {
		return (boolean) super.call("is_using_rounded_values", new java.lang.Object[0]);
	}

	public void setRounded(boolean value) {
		super.call("set_use_rounded_values", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isAllow_greater() {
		return (boolean) super.call("is_greater_allowed", new java.lang.Object[0]);
	}

	public void setAllow_greater(boolean value) {
		super.call("set_allow_greater", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isAllow_lesser() {
		return (boolean) super.call("is_lesser_allowed", new java.lang.Object[0]);
	}

	public void setAllow_lesser(boolean value) {
		super.call("set_allow_lesser", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
