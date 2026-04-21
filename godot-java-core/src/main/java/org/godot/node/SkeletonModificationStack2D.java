package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SkeletonModificationStack2D extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("delete_modification", 1286410249L),
			java.util.Map.entry("get_modification_count", 3905245786L), java.util.Map.entry("get_enabled", 36873697L),
			java.util.Map.entry("set_strength", 373806689L),
			java.util.Map.entry("enable_all_modifications", 2586408642L),
			java.util.Map.entry("get_skeleton", 1697361217L), java.util.Map.entry("execute", 1005356550L),
			java.util.Map.entry("get_strength", 1740695150L), java.util.Map.entry("set_modification", 1098262544L),
			java.util.Map.entry("set_modification_count", 1286410249L), java.util.Map.entry("set_enabled", 2586408642L),
			java.util.Map.entry("get_modification", 2570274329L), java.util.Map.entry("add_modification", 354162120L),
			java.util.Map.entry("get_is_setup", 36873697L), java.util.Map.entry("setup", 3218959716L));

	SkeletonModificationStack2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonModificationStack2D(long nativePointer) {
		super(nativePointer);
	}

	public void setup() {
		super.call("setup");
	}

	public void execute(double delta, long execution_mode) {
		super.call("execute",
				new java.lang.Object[]{java.lang.Double.valueOf(delta), java.lang.Long.valueOf(execution_mode)});
	}

	public void enable_all_modifications(boolean enabled) {
		super.call("enable_all_modifications", new java.lang.Object[]{java.lang.Boolean.valueOf(enabled)});
	}

	public SkeletonModification2D get_modification(long mod_idx) {
		return (SkeletonModification2D) super.call("get_modification",
				new java.lang.Object[]{java.lang.Long.valueOf(mod_idx)});
	}

	public void add_modification(SkeletonModification2D modification) {
		super.call("add_modification", new java.lang.Object[]{(java.lang.Object) modification});
	}

	public void delete_modification(long mod_idx) {
		super.call("delete_modification", new java.lang.Object[]{java.lang.Long.valueOf(mod_idx)});
	}

	public void set_modification(long mod_idx, SkeletonModification2D modification) {
		super.call("set_modification",
				new java.lang.Object[]{java.lang.Long.valueOf(mod_idx), (java.lang.Object) modification});
	}

	public boolean getEnabled() {
		return (boolean) super.call("get_enabled", new java.lang.Object[0]);
	}

	public void setEnabled(boolean value) {
		super.call("set_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getStrength() {
		return (double) super.call("get_strength", new java.lang.Object[0]);
	}

	public void setStrength(double value) {
		super.call("set_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getModification_count() {
		return (long) super.call("get_modification_count", new java.lang.Object[0]);
	}

	public void setModification_count(long value) {
		super.call("set_modification_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
