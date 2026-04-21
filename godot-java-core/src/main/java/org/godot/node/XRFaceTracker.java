package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class XRFaceTracker extends XRTracker {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_blend_shape", 2352588791L), java.util.Map.entry("get_blend_shapes", 675695659L),
			java.util.Map.entry("set_blend_shapes", 2899603908L), java.util.Map.entry("get_blend_shape", 330010046L));

	XRFaceTracker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRFaceTracker(long nativePointer) {
		super(nativePointer);
	}

	public double get_blend_shape(int blend_shape) {
		return (double) super.call("get_blend_shape", new java.lang.Object[]{java.lang.Integer.valueOf(blend_shape)});
	}

	public void set_blend_shape(int blend_shape, double weight) {
		super.call("set_blend_shape",
				new java.lang.Object[]{java.lang.Integer.valueOf(blend_shape), java.lang.Double.valueOf(weight)});
	}

	public double[] getBlend_shapes() {
		return (double[]) super.call("get_blend_shapes", new java.lang.Object[0]);
	}

	public void setBlend_shapes(double[] value) {
		super.call("set_blend_shapes", new java.lang.Object[]{(java.lang.Object) value});
	}
}
