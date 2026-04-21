package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDPipelineRasterizationState extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_discard_primitives", 2586408642L),
			java.util.Map.entry("set_patch_control_points", 1286410249L),
			java.util.Map.entry("set_depth_bias_enabled", 2586408642L),
			java.util.Map.entry("get_front_face", 708793786L), java.util.Map.entry("set_front_face", 2637251213L),
			java.util.Map.entry("set_enable_depth_clamp", 2586408642L),
			java.util.Map.entry("get_enable_depth_clamp", 36873697L), java.util.Map.entry("get_cull_mode", 2192484313L),
			java.util.Map.entry("get_depth_bias_enabled", 36873697L),
			java.util.Map.entry("get_line_width", 1740695150L),
			java.util.Map.entry("get_patch_control_points", 3905245786L),
			java.util.Map.entry("get_wireframe", 36873697L), java.util.Map.entry("get_discard_primitives", 36873697L),
			java.util.Map.entry("set_depth_bias_constant_factor", 373806689L),
			java.util.Map.entry("set_depth_bias_clamp", 373806689L), java.util.Map.entry("set_line_width", 373806689L),
			java.util.Map.entry("set_depth_bias_slope_factor", 373806689L),
			java.util.Map.entry("get_depth_bias_constant_factor", 1740695150L),
			java.util.Map.entry("set_wireframe", 2586408642L), java.util.Map.entry("set_cull_mode", 2662586502L),
			java.util.Map.entry("get_depth_bias_clamp", 1740695150L),
			java.util.Map.entry("get_depth_bias_slope_factor", 1740695150L));

	RDPipelineRasterizationState(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDPipelineRasterizationState(long nativePointer) {
		super(nativePointer);
	}

	public boolean getEnable_depth_clamp() {
		return (boolean) super.call("get_enable_depth_clamp", new java.lang.Object[0]);
	}

	public void setEnable_depth_clamp(boolean value) {
		super.call("set_enable_depth_clamp", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDiscard_primitives() {
		return (boolean) super.call("get_discard_primitives", new java.lang.Object[0]);
	}

	public void setDiscard_primitives(boolean value) {
		super.call("set_discard_primitives", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getWireframe() {
		return (boolean) super.call("get_wireframe", new java.lang.Object[0]);
	}

	public void setWireframe(boolean value) {
		super.call("set_wireframe", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getCull_mode() {
		return (long) super.call("get_cull_mode", new java.lang.Object[0]);
	}

	public void setCull_mode(long value) {
		super.call("set_cull_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFront_face() {
		return (long) super.call("get_front_face", new java.lang.Object[0]);
	}

	public void setFront_face(long value) {
		super.call("set_front_face", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getDepth_bias_enabled() {
		return (boolean) super.call("get_depth_bias_enabled", new java.lang.Object[0]);
	}

	public void setDepth_bias_enabled(boolean value) {
		super.call("set_depth_bias_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getDepth_bias_constant_factor() {
		return (double) super.call("get_depth_bias_constant_factor", new java.lang.Object[0]);
	}

	public void setDepth_bias_constant_factor(double value) {
		super.call("set_depth_bias_constant_factor", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDepth_bias_clamp() {
		return (double) super.call("get_depth_bias_clamp", new java.lang.Object[0]);
	}

	public void setDepth_bias_clamp(double value) {
		super.call("set_depth_bias_clamp", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDepth_bias_slope_factor() {
		return (double) super.call("get_depth_bias_slope_factor", new java.lang.Object[0]);
	}

	public void setDepth_bias_slope_factor(double value) {
		super.call("set_depth_bias_slope_factor", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getLine_width() {
		return (double) super.call("get_line_width", new java.lang.Object[0]);
	}

	public void setLine_width(double value) {
		super.call("set_line_width", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getPatch_control_points() {
		return (long) super.call("get_patch_control_points", new java.lang.Object[0]);
	}

	public void setPatch_control_points(long value) {
		super.call("set_patch_control_points", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
