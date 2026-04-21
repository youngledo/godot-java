package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDPipelineDepthStencilState extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_back_op_compare", 2573711505L),
			java.util.Map.entry("get_enable_depth_test", 36873697L),
			java.util.Map.entry("set_front_op_fail", 2092799566L), java.util.Map.entry("set_back_op_pass", 2092799566L),
			java.util.Map.entry("get_front_op_compare", 269730778L),
			java.util.Map.entry("get_back_op_write_mask", 3905245786L),
			java.util.Map.entry("set_enable_depth_write", 2586408642L),
			java.util.Map.entry("get_back_op_compare_mask", 3905245786L),
			java.util.Map.entry("get_back_op_depth_fail", 1714732389L),
			java.util.Map.entry("set_depth_range_max", 373806689L),
			java.util.Map.entry("get_enable_depth_write", 36873697L),
			java.util.Map.entry("set_enable_stencil", 2586408642L),
			java.util.Map.entry("set_front_op_reference", 1286410249L),
			java.util.Map.entry("set_enable_depth_range", 2586408642L),
			java.util.Map.entry("get_enable_stencil", 36873697L),
			java.util.Map.entry("set_depth_compare_operator", 2573711505L),
			java.util.Map.entry("set_back_op_write_mask", 1286410249L),
			java.util.Map.entry("get_enable_depth_range", 36873697L),
			java.util.Map.entry("get_back_op_fail", 1714732389L), java.util.Map.entry("get_back_op_pass", 1714732389L),
			java.util.Map.entry("get_front_op_write_mask", 3905245786L),
			java.util.Map.entry("get_front_op_reference", 3905245786L),
			java.util.Map.entry("get_depth_range_max", 1740695150L),
			java.util.Map.entry("set_back_op_compare_mask", 1286410249L),
			java.util.Map.entry("set_enable_depth_test", 2586408642L),
			java.util.Map.entry("set_front_op_compare_mask", 1286410249L),
			java.util.Map.entry("set_front_op_depth_fail", 2092799566L),
			java.util.Map.entry("get_front_op_pass", 1714732389L),
			java.util.Map.entry("get_front_op_compare_mask", 3905245786L),
			java.util.Map.entry("get_front_op_fail", 1714732389L),
			java.util.Map.entry("set_depth_range_min", 373806689L),
			java.util.Map.entry("set_back_op_fail", 2092799566L), java.util.Map.entry("set_front_op_pass", 2092799566L),
			java.util.Map.entry("set_front_op_compare", 2573711505L),
			java.util.Map.entry("set_back_op_depth_fail", 2092799566L),
			java.util.Map.entry("get_back_op_compare", 269730778L),
			java.util.Map.entry("get_depth_range_min", 1740695150L),
			java.util.Map.entry("get_front_op_depth_fail", 1714732389L),
			java.util.Map.entry("set_back_op_reference", 1286410249L),
			java.util.Map.entry("get_back_op_reference", 3905245786L),
			java.util.Map.entry("get_depth_compare_operator", 269730778L),
			java.util.Map.entry("set_front_op_write_mask", 1286410249L));

	RDPipelineDepthStencilState(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDPipelineDepthStencilState(long nativePointer) {
		super(nativePointer);
	}

	public boolean getEnable_depth_test() {
		return (boolean) super.call("get_enable_depth_test", new java.lang.Object[0]);
	}

	public void setEnable_depth_test(boolean value) {
		super.call("set_enable_depth_test", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getEnable_depth_write() {
		return (boolean) super.call("get_enable_depth_write", new java.lang.Object[0]);
	}

	public void setEnable_depth_write(boolean value) {
		super.call("set_enable_depth_write", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getDepth_compare_operator() {
		return (long) super.call("get_depth_compare_operator", new java.lang.Object[0]);
	}

	public void setDepth_compare_operator(long value) {
		super.call("set_depth_compare_operator", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getEnable_depth_range() {
		return (boolean) super.call("get_enable_depth_range", new java.lang.Object[0]);
	}

	public void setEnable_depth_range(boolean value) {
		super.call("set_enable_depth_range", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getDepth_range_min() {
		return (double) super.call("get_depth_range_min", new java.lang.Object[0]);
	}

	public void setDepth_range_min(double value) {
		super.call("set_depth_range_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDepth_range_max() {
		return (double) super.call("get_depth_range_max", new java.lang.Object[0]);
	}

	public void setDepth_range_max(double value) {
		super.call("set_depth_range_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getEnable_stencil() {
		return (boolean) super.call("get_enable_stencil", new java.lang.Object[0]);
	}

	public void setEnable_stencil(boolean value) {
		super.call("set_enable_stencil", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getFront_op_fail() {
		return (long) super.call("get_front_op_fail", new java.lang.Object[0]);
	}

	public void setFront_op_fail(long value) {
		super.call("set_front_op_fail", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFront_op_pass() {
		return (long) super.call("get_front_op_pass", new java.lang.Object[0]);
	}

	public void setFront_op_pass(long value) {
		super.call("set_front_op_pass", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFront_op_depth_fail() {
		return (long) super.call("get_front_op_depth_fail", new java.lang.Object[0]);
	}

	public void setFront_op_depth_fail(long value) {
		super.call("set_front_op_depth_fail", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFront_op_compare() {
		return (long) super.call("get_front_op_compare", new java.lang.Object[0]);
	}

	public void setFront_op_compare(long value) {
		super.call("set_front_op_compare", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFront_op_compare_mask() {
		return (long) super.call("get_front_op_compare_mask", new java.lang.Object[0]);
	}

	public void setFront_op_compare_mask(long value) {
		super.call("set_front_op_compare_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFront_op_write_mask() {
		return (long) super.call("get_front_op_write_mask", new java.lang.Object[0]);
	}

	public void setFront_op_write_mask(long value) {
		super.call("set_front_op_write_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFront_op_reference() {
		return (long) super.call("get_front_op_reference", new java.lang.Object[0]);
	}

	public void setFront_op_reference(long value) {
		super.call("set_front_op_reference", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBack_op_fail() {
		return (long) super.call("get_back_op_fail", new java.lang.Object[0]);
	}

	public void setBack_op_fail(long value) {
		super.call("set_back_op_fail", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBack_op_pass() {
		return (long) super.call("get_back_op_pass", new java.lang.Object[0]);
	}

	public void setBack_op_pass(long value) {
		super.call("set_back_op_pass", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBack_op_depth_fail() {
		return (long) super.call("get_back_op_depth_fail", new java.lang.Object[0]);
	}

	public void setBack_op_depth_fail(long value) {
		super.call("set_back_op_depth_fail", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBack_op_compare() {
		return (long) super.call("get_back_op_compare", new java.lang.Object[0]);
	}

	public void setBack_op_compare(long value) {
		super.call("set_back_op_compare", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBack_op_compare_mask() {
		return (long) super.call("get_back_op_compare_mask", new java.lang.Object[0]);
	}

	public void setBack_op_compare_mask(long value) {
		super.call("set_back_op_compare_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBack_op_write_mask() {
		return (long) super.call("get_back_op_write_mask", new java.lang.Object[0]);
	}

	public void setBack_op_write_mask(long value) {
		super.call("set_back_op_write_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBack_op_reference() {
		return (long) super.call("get_back_op_reference", new java.lang.Object[0]);
	}

	public void setBack_op_reference(long value) {
		super.call("set_back_op_reference", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
