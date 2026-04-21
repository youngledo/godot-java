package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2;

public class MobileVRInterface extends XRInterface {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_k1", 373806689L), java.util.Map.entry("get_vrs_min_radius", 1740695150L),
			java.util.Map.entry("get_eye_height", 1740695150L), java.util.Map.entry("set_oversample", 373806689L),
			java.util.Map.entry("set_vrs_min_radius", 373806689L),
			java.util.Map.entry("get_display_to_lens", 1740695150L),
			java.util.Map.entry("get_offset_rect", 1639390495L), java.util.Map.entry("get_display_width", 1740695150L),
			java.util.Map.entry("set_k2", 373806689L), java.util.Map.entry("get_k1", 1740695150L),
			java.util.Map.entry("get_vrs_strength", 1740695150L), java.util.Map.entry("set_eye_height", 373806689L),
			java.util.Map.entry("set_iod", 373806689L), java.util.Map.entry("get_oversample", 1740695150L),
			java.util.Map.entry("set_display_width", 373806689L), java.util.Map.entry("get_k2", 1740695150L),
			java.util.Map.entry("set_display_to_lens", 373806689L), java.util.Map.entry("set_vrs_strength", 373806689L),
			java.util.Map.entry("get_iod", 1740695150L), java.util.Map.entry("set_offset_rect", 2046264180L));

	MobileVRInterface(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MobileVRInterface(long nativePointer) {
		super(nativePointer);
	}

	public double getEye_height() {
		return (double) super.call("get_eye_height", new java.lang.Object[0]);
	}

	public void setEye_height(double value) {
		super.call("set_eye_height", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getIod() {
		return (double) super.call("get_iod", new java.lang.Object[0]);
	}

	public void setIod(double value) {
		super.call("set_iod", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDisplay_width() {
		return (double) super.call("get_display_width", new java.lang.Object[0]);
	}

	public void setDisplay_width(double value) {
		super.call("set_display_width", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDisplay_to_lens() {
		return (double) super.call("get_display_to_lens", new java.lang.Object[0]);
	}

	public void setDisplay_to_lens(double value) {
		super.call("set_display_to_lens", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Rect2 getOffset_rect() {
		return (Rect2) super.call("get_offset_rect", new java.lang.Object[0]);
	}

	public void setOffset_rect(Rect2 value) {
		super.call("set_offset_rect", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getOversample() {
		return (double) super.call("get_oversample", new java.lang.Object[0]);
	}

	public void setOversample(double value) {
		super.call("set_oversample", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getK1() {
		return (double) super.call("get_k1", new java.lang.Object[0]);
	}

	public void setK1(double value) {
		super.call("set_k1", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getK2() {
		return (double) super.call("get_k2", new java.lang.Object[0]);
	}

	public void setK2(double value) {
		super.call("set_k2", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVrs_min_radius() {
		return (double) super.call("get_vrs_min_radius", new java.lang.Object[0]);
	}

	public void setVrs_min_radius(double value) {
		super.call("set_vrs_min_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVrs_strength() {
		return (double) super.call("get_vrs_strength", new java.lang.Object[0]);
	}

	public void setVrs_strength(double value) {
		super.call("set_vrs_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
