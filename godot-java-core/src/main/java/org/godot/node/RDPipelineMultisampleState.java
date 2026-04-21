package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDPipelineMultisampleState extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_sample_masks", 381264803L), java.util.Map.entry("get_sample_count", 407791724L),
			java.util.Map.entry("set_enable_sample_shading", 2586408642L),
			java.util.Map.entry("get_sample_masks", 3995934104L),
			java.util.Map.entry("set_min_sample_shading", 373806689L),
			java.util.Map.entry("set_enable_alpha_to_coverage", 2586408642L),
			java.util.Map.entry("get_enable_alpha_to_coverage", 36873697L),
			java.util.Map.entry("get_enable_sample_shading", 36873697L),
			java.util.Map.entry("set_enable_alpha_to_one", 2586408642L),
			java.util.Map.entry("get_min_sample_shading", 1740695150L),
			java.util.Map.entry("set_sample_count", 3774171498L),
			java.util.Map.entry("get_enable_alpha_to_one", 36873697L));

	RDPipelineMultisampleState(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDPipelineMultisampleState(long nativePointer) {
		super(nativePointer);
	}

	public long getSample_count() {
		return (long) super.call("get_sample_count", new java.lang.Object[0]);
	}

	public void setSample_count(long value) {
		super.call("set_sample_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getEnable_sample_shading() {
		return (boolean) super.call("get_enable_sample_shading", new java.lang.Object[0]);
	}

	public void setEnable_sample_shading(boolean value) {
		super.call("set_enable_sample_shading", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getMin_sample_shading() {
		return (double) super.call("get_min_sample_shading", new java.lang.Object[0]);
	}

	public void setMin_sample_shading(double value) {
		super.call("set_min_sample_shading", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getEnable_alpha_to_coverage() {
		return (boolean) super.call("get_enable_alpha_to_coverage", new java.lang.Object[0]);
	}

	public void setEnable_alpha_to_coverage(boolean value) {
		super.call("set_enable_alpha_to_coverage", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getEnable_alpha_to_one() {
		return (boolean) super.call("get_enable_alpha_to_one", new java.lang.Object[0]);
	}

	public void setEnable_alpha_to_one(boolean value) {
		super.call("set_enable_alpha_to_one", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long[] getSample_masks() {
		return (long[]) super.call("get_sample_masks", new java.lang.Object[0]);
	}

	public void setSample_masks(long[] value) {
		super.call("set_sample_masks", new java.lang.Object[]{(java.lang.Object) value});
	}
}
