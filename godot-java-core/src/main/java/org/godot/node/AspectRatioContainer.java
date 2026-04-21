package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AspectRatioContainer extends Container {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_ratio", 1740695150L), java.util.Map.entry("get_alignment_horizontal", 3838875429L),
			java.util.Map.entry("set_ratio", 373806689L), java.util.Map.entry("set_alignment_horizontal", 2147829016L),
			java.util.Map.entry("get_alignment_vertical", 3838875429L),
			java.util.Map.entry("set_stretch_mode", 1876743467L),
			java.util.Map.entry("set_alignment_vertical", 2147829016L),
			java.util.Map.entry("get_stretch_mode", 3416449033L));

	AspectRatioContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AspectRatioContainer(long nativePointer) {
		super(nativePointer);
	}

	public double getRatio() {
		return (double) super.call("get_ratio", new java.lang.Object[0]);
	}

	public void setRatio(double value) {
		super.call("set_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getStretch_mode() {
		return (long) super.call("get_stretch_mode", new java.lang.Object[0]);
	}

	public void setStretch_mode(long value) {
		super.call("set_stretch_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getAlignment_horizontal() {
		return (long) super.call("get_alignment_horizontal", new java.lang.Object[0]);
	}

	public void setAlignment_horizontal(long value) {
		super.call("set_alignment_horizontal", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getAlignment_vertical() {
		return (long) super.call("get_alignment_vertical", new java.lang.Object[0]);
	}

	public void setAlignment_vertical(long value) {
		super.call("set_alignment_vertical", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
