package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OccluderPolygon2D extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_closed", 2586408642L), java.util.Map.entry("set_polygon", 1509147220L),
			java.util.Map.entry("get_polygon", 2961356807L), java.util.Map.entry("set_cull_mode", 3500863002L),
			java.util.Map.entry("get_cull_mode", 33931036L), java.util.Map.entry("is_closed", 36873697L));

	OccluderPolygon2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OccluderPolygon2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_closed() {
		return (boolean) super.call("is_closed");
	}

	public boolean isClosed() {
		return (boolean) super.call("is_closed", new java.lang.Object[0]);
	}

	public void setClosed(boolean value) {
		super.call("set_closed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getCull_mode() {
		return (long) super.call("get_cull_mode", new java.lang.Object[0]);
	}

	public void setCull_mode(long value) {
		super.call("set_cull_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double[][] getPolygon() {
		return (double[][]) super.call("get_polygon", new java.lang.Object[0]);
	}

	public void setPolygon(double[][] value) {
		super.call("set_polygon", new java.lang.Object[]{(java.lang.Object) value});
	}
}
