package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ImporterMeshInstance3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_visibility_range_end_margin", 1740695150L),
			java.util.Map.entry("set_layer_mask", 1286410249L),
			java.util.Map.entry("get_visibility_range_end", 1740695150L), java.util.Map.entry("set_skin", 3971435618L),
			java.util.Map.entry("set_visibility_range_end_margin", 373806689L),
			java.util.Map.entry("set_visibility_range_fade_mode", 1440117808L),
			java.util.Map.entry("get_visibility_range_begin", 1740695150L),
			java.util.Map.entry("get_layer_mask", 3905245786L),
			java.util.Map.entry("set_visibility_range_end", 373806689L),
			java.util.Map.entry("set_visibility_range_begin", 373806689L),
			java.util.Map.entry("get_cast_shadows_setting", 3383019359L), java.util.Map.entry("set_mesh", 2255166972L),
			java.util.Map.entry("get_skin", 2074563878L), java.util.Map.entry("set_cast_shadows_setting", 856677339L),
			java.util.Map.entry("get_mesh", 3161779525L),
			java.util.Map.entry("get_visibility_range_begin_margin", 1740695150L),
			java.util.Map.entry("set_visibility_range_begin_margin", 373806689L),
			java.util.Map.entry("get_visibility_range_fade_mode", 2067221882L),
			java.util.Map.entry("set_skeleton_path", 1348162250L),
			java.util.Map.entry("get_skeleton_path", 4075236667L));

	ImporterMeshInstance3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ImporterMeshInstance3D(long nativePointer) {
		super(nativePointer);
	}

	public ImporterMesh getMesh() {
		return (ImporterMesh) super.call("get_mesh", new java.lang.Object[0]);
	}

	public void setMesh(ImporterMesh value) {
		super.call("set_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Skin getSkin() {
		return (Skin) super.call("get_skin", new java.lang.Object[0]);
	}

	public void setSkin(Skin value) {
		super.call("set_skin", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getSkeleton_path() {
		return (String) super.call("get_skeleton_path", new java.lang.Object[0]);
	}

	public void setSkeleton_path(String value) {
		super.call("set_skeleton_path", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getLayer_mask() {
		return (long) super.call("get_layer_mask", new java.lang.Object[0]);
	}

	public void setLayer_mask(long value) {
		super.call("set_layer_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCast_shadow() {
		return (long) super.call("get_cast_shadows_setting", new java.lang.Object[0]);
	}

	public void setCast_shadow(long value) {
		super.call("set_cast_shadows_setting", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getVisibility_range_begin() {
		return (double) super.call("get_visibility_range_begin", new java.lang.Object[0]);
	}

	public void setVisibility_range_begin(double value) {
		super.call("set_visibility_range_begin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVisibility_range_begin_margin() {
		return (double) super.call("get_visibility_range_begin_margin", new java.lang.Object[0]);
	}

	public void setVisibility_range_begin_margin(double value) {
		super.call("set_visibility_range_begin_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVisibility_range_end() {
		return (double) super.call("get_visibility_range_end", new java.lang.Object[0]);
	}

	public void setVisibility_range_end(double value) {
		super.call("set_visibility_range_end", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVisibility_range_end_margin() {
		return (double) super.call("get_visibility_range_end_margin", new java.lang.Object[0]);
	}

	public void setVisibility_range_end_margin(double value) {
		super.call("set_visibility_range_end_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getVisibility_range_fade_mode() {
		return (long) super.call("get_visibility_range_fade_mode", new java.lang.Object[0]);
	}

	public void setVisibility_range_fade_mode(long value) {
		super.call("set_visibility_range_fade_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
