package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class NavigationPathQueryResult3D extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_path", 497664490L), java.util.Map.entry("set_path_rids", 381264803L),
			java.util.Map.entry("set_path_types", 3614634198L), java.util.Map.entry("set_path_owner_ids", 3709968205L),
			java.util.Map.entry("get_path_length", 1740695150L), java.util.Map.entry("get_path_owner_ids", 235988956L),
			java.util.Map.entry("reset", 3218959716L), java.util.Map.entry("get_path_types", 1930428628L),
			java.util.Map.entry("get_path_rids", 3995934104L), java.util.Map.entry("set_path_length", 373806689L),
			java.util.Map.entry("set_path", 334873810L));

	NavigationPathQueryResult3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationPathQueryResult3D(long nativePointer) {
		super(nativePointer);
	}

	public void reset() {
		super.call("reset");
	}

	public double[][] getPath() {
		return (double[][]) super.call("get_path", new java.lang.Object[0]);
	}

	public void setPath(double[][] value) {
		super.call("set_path", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int[] getPath_types() {
		return (int[]) super.call("get_path_types", new java.lang.Object[0]);
	}

	public void setPath_types(int[] value) {
		super.call("set_path_types", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long[] getPath_rids() {
		return (long[]) super.call("get_path_rids", new java.lang.Object[0]);
	}

	public void setPath_rids(long[] value) {
		super.call("set_path_rids", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long[] getPath_owner_ids() {
		return (long[]) super.call("get_path_owner_ids", new java.lang.Object[0]);
	}

	public void setPath_owner_ids(long[] value) {
		super.call("set_path_owner_ids", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getPath_length() {
		return (double) super.call("get_path_length", new java.lang.Object[0]);
	}

	public void setPath_length(double value) {
		super.call("set_path_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
