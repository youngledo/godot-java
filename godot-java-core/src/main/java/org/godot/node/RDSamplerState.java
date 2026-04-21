package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDSamplerState extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_lod_bias", 1740695150L), java.util.Map.entry("set_min_lod", 373806689L),
			java.util.Map.entry("get_unnormalized_uvw", 36873697L),
			java.util.Map.entry("get_border_color", 3514246478L), java.util.Map.entry("set_min_filter", 1493420382L),
			java.util.Map.entry("set_mip_filter", 1493420382L), java.util.Map.entry("get_repeat_w", 3227895872L),
			java.util.Map.entry("set_enable_compare", 2586408642L), java.util.Map.entry("get_repeat_v", 3227895872L),
			java.util.Map.entry("get_repeat_u", 3227895872L), java.util.Map.entry("set_anisotropy_max", 373806689L),
			java.util.Map.entry("get_mip_filter", 2209202801L), java.util.Map.entry("set_mag_filter", 1493420382L),
			java.util.Map.entry("set_max_lod", 373806689L), java.util.Map.entry("get_min_filter", 2209202801L),
			java.util.Map.entry("get_min_lod", 1740695150L), java.util.Map.entry("get_max_lod", 1740695150L),
			java.util.Map.entry("set_lod_bias", 373806689L), java.util.Map.entry("set_compare_op", 2573711505L),
			java.util.Map.entry("get_anisotropy_max", 1740695150L),
			java.util.Map.entry("set_unnormalized_uvw", 2586408642L), java.util.Map.entry("set_repeat_v", 246127626L),
			java.util.Map.entry("set_repeat_u", 246127626L), java.util.Map.entry("get_enable_compare", 36873697L),
			java.util.Map.entry("get_use_anisotropy", 36873697L),
			java.util.Map.entry("set_use_anisotropy", 2586408642L), java.util.Map.entry("get_compare_op", 269730778L),
			java.util.Map.entry("set_repeat_w", 246127626L), java.util.Map.entry("set_border_color", 1115869595L),
			java.util.Map.entry("get_mag_filter", 2209202801L));

	RDSamplerState(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDSamplerState(long nativePointer) {
		super(nativePointer);
	}

	public long getMag_filter() {
		return (long) super.call("get_mag_filter", new java.lang.Object[0]);
	}

	public void setMag_filter(long value) {
		super.call("set_mag_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMin_filter() {
		return (long) super.call("get_min_filter", new java.lang.Object[0]);
	}

	public void setMin_filter(long value) {
		super.call("set_min_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMip_filter() {
		return (long) super.call("get_mip_filter", new java.lang.Object[0]);
	}

	public void setMip_filter(long value) {
		super.call("set_mip_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRepeat_u() {
		return (long) super.call("get_repeat_u", new java.lang.Object[0]);
	}

	public void setRepeat_u(long value) {
		super.call("set_repeat_u", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRepeat_v() {
		return (long) super.call("get_repeat_v", new java.lang.Object[0]);
	}

	public void setRepeat_v(long value) {
		super.call("set_repeat_v", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRepeat_w() {
		return (long) super.call("get_repeat_w", new java.lang.Object[0]);
	}

	public void setRepeat_w(long value) {
		super.call("set_repeat_w", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getLod_bias() {
		return (double) super.call("get_lod_bias", new java.lang.Object[0]);
	}

	public void setLod_bias(double value) {
		super.call("set_lod_bias", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getUse_anisotropy() {
		return (boolean) super.call("get_use_anisotropy", new java.lang.Object[0]);
	}

	public void setUse_anisotropy(boolean value) {
		super.call("set_use_anisotropy", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getAnisotropy_max() {
		return (double) super.call("get_anisotropy_max", new java.lang.Object[0]);
	}

	public void setAnisotropy_max(double value) {
		super.call("set_anisotropy_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getEnable_compare() {
		return (boolean) super.call("get_enable_compare", new java.lang.Object[0]);
	}

	public void setEnable_compare(boolean value) {
		super.call("set_enable_compare", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getCompare_op() {
		return (long) super.call("get_compare_op", new java.lang.Object[0]);
	}

	public void setCompare_op(long value) {
		super.call("set_compare_op", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getMin_lod() {
		return (double) super.call("get_min_lod", new java.lang.Object[0]);
	}

	public void setMin_lod(double value) {
		super.call("set_min_lod", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMax_lod() {
		return (double) super.call("get_max_lod", new java.lang.Object[0]);
	}

	public void setMax_lod(double value) {
		super.call("set_max_lod", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getBorder_color() {
		return (long) super.call("get_border_color", new java.lang.Object[0]);
	}

	public void setBorder_color(long value) {
		super.call("set_border_color", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getUnnormalized_uvw() {
		return (boolean) super.call("get_unnormalized_uvw", new java.lang.Object[0]);
	}

	public void setUnnormalized_uvw(boolean value) {
		super.call("set_unnormalized_uvw", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
