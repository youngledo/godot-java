package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDPipelineColorBlendStateAttachment extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_src_alpha_blend_factor", 3691288359L),
			java.util.Map.entry("get_write_b", 36873697L),
			java.util.Map.entry("get_dst_alpha_blend_factor", 3691288359L),
			java.util.Map.entry("get_write_a", 36873697L), java.util.Map.entry("get_write_g", 36873697L),
			java.util.Map.entry("set_src_alpha_blend_factor", 2251019273L),
			java.util.Map.entry("set_write_r", 2586408642L),
			java.util.Map.entry("set_dst_alpha_blend_factor", 2251019273L),
			java.util.Map.entry("get_src_color_blend_factor", 3691288359L),
			java.util.Map.entry("get_alpha_blend_op", 1385093561L),
			java.util.Map.entry("get_dst_color_blend_factor", 3691288359L),
			java.util.Map.entry("set_alpha_blend_op", 3073022720L),
			java.util.Map.entry("set_color_blend_op", 3073022720L), java.util.Map.entry("set_as_mix", 3218959716L),
			java.util.Map.entry("set_enable_blend", 2586408642L), java.util.Map.entry("get_write_r", 36873697L),
			java.util.Map.entry("set_src_color_blend_factor", 2251019273L),
			java.util.Map.entry("set_write_b", 2586408642L), java.util.Map.entry("get_enable_blend", 36873697L),
			java.util.Map.entry("set_dst_color_blend_factor", 2251019273L),
			java.util.Map.entry("set_write_a", 2586408642L), java.util.Map.entry("set_write_g", 2586408642L),
			java.util.Map.entry("get_color_blend_op", 1385093561L));

	RDPipelineColorBlendStateAttachment(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDPipelineColorBlendStateAttachment(long nativePointer) {
		super(nativePointer);
	}

	public void set_as_mix() {
		super.call("set_as_mix");
	}

	public boolean getEnable_blend() {
		return (boolean) super.call("get_enable_blend", new java.lang.Object[0]);
	}

	public void setEnable_blend(boolean value) {
		super.call("set_enable_blend", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSrc_color_blend_factor() {
		return (long) super.call("get_src_color_blend_factor", new java.lang.Object[0]);
	}

	public void setSrc_color_blend_factor(long value) {
		super.call("set_src_color_blend_factor", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDst_color_blend_factor() {
		return (long) super.call("get_dst_color_blend_factor", new java.lang.Object[0]);
	}

	public void setDst_color_blend_factor(long value) {
		super.call("set_dst_color_blend_factor", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getColor_blend_op() {
		return (long) super.call("get_color_blend_op", new java.lang.Object[0]);
	}

	public void setColor_blend_op(long value) {
		super.call("set_color_blend_op", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSrc_alpha_blend_factor() {
		return (long) super.call("get_src_alpha_blend_factor", new java.lang.Object[0]);
	}

	public void setSrc_alpha_blend_factor(long value) {
		super.call("set_src_alpha_blend_factor", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDst_alpha_blend_factor() {
		return (long) super.call("get_dst_alpha_blend_factor", new java.lang.Object[0]);
	}

	public void setDst_alpha_blend_factor(long value) {
		super.call("set_dst_alpha_blend_factor", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getAlpha_blend_op() {
		return (long) super.call("get_alpha_blend_op", new java.lang.Object[0]);
	}

	public void setAlpha_blend_op(long value) {
		super.call("set_alpha_blend_op", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getWrite_r() {
		return (boolean) super.call("get_write_r", new java.lang.Object[0]);
	}

	public void setWrite_r(boolean value) {
		super.call("set_write_r", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getWrite_g() {
		return (boolean) super.call("get_write_g", new java.lang.Object[0]);
	}

	public void setWrite_g(boolean value) {
		super.call("set_write_g", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getWrite_b() {
		return (boolean) super.call("get_write_b", new java.lang.Object[0]);
	}

	public void setWrite_b(boolean value) {
		super.call("set_write_b", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getWrite_a() {
		return (boolean) super.call("get_write_a", new java.lang.Object[0]);
	}

	public void setWrite_a(boolean value) {
		super.call("set_write_a", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
