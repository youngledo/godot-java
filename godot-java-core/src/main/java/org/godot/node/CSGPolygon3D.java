package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CSGPolygon3D extends CSGPrimitive3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_material", 5934680L), java.util.Map.entry("get_spin_degrees", 1740695150L),
			java.util.Map.entry("set_path_interval_type", 3744240707L), java.util.Map.entry("set_polygon", 1509147220L),
			java.util.Map.entry("get_polygon", 2961356807L), java.util.Map.entry("is_path_local", 36873697L),
			java.util.Map.entry("set_path_interval", 373806689L),
			java.util.Map.entry("set_path_continuous_u", 2586408642L), java.util.Map.entry("set_depth", 373806689L),
			java.util.Map.entry("get_path_simplify_angle", 1740695150L),
			java.util.Map.entry("set_path_rotation", 1412947288L), java.util.Map.entry("get_path_node", 4075236667L),
			java.util.Map.entry("get_path_rotation", 647219346L), java.util.Map.entry("set_path_local", 2586408642L),
			java.util.Map.entry("set_path_joined", 2586408642L),
			java.util.Map.entry("get_path_rotation_accurate", 36873697L), java.util.Map.entry("get_mode", 1201612222L),
			java.util.Map.entry("set_material", 2757459619L), java.util.Map.entry("get_depth", 1740695150L),
			java.util.Map.entry("get_smooth_faces", 36873697L), java.util.Map.entry("get_path_interval", 1740695150L),
			java.util.Map.entry("get_spin_sides", 3905245786L),
			java.util.Map.entry("set_path_rotation_accurate", 2586408642L),
			java.util.Map.entry("set_path_node", 1348162250L), java.util.Map.entry("is_path_continuous_u", 36873697L),
			java.util.Map.entry("is_path_joined", 36873697L), java.util.Map.entry("set_spin_degrees", 373806689L),
			java.util.Map.entry("set_spin_sides", 1286410249L),
			java.util.Map.entry("set_path_simplify_angle", 373806689L),
			java.util.Map.entry("set_path_u_distance", 373806689L),
			java.util.Map.entry("get_path_interval_type", 3434618397L), java.util.Map.entry("set_mode", 3158377035L),
			java.util.Map.entry("get_path_u_distance", 1740695150L),
			java.util.Map.entry("set_smooth_faces", 2586408642L));

	CSGPolygon3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CSGPolygon3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_path_local() {
		return (boolean) super.call("is_path_local");
	}

	public boolean is_path_continuous_u() {
		return (boolean) super.call("is_path_continuous_u");
	}

	public boolean is_path_joined() {
		return (boolean) super.call("is_path_joined");
	}

	public double[][] getPolygon() {
		return (double[][]) super.call("get_polygon", new java.lang.Object[0]);
	}

	public void setPolygon(double[][] value) {
		super.call("set_polygon", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getMode() {
		return (long) super.call("get_mode", new java.lang.Object[0]);
	}

	public void setMode(long value) {
		super.call("set_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getDepth() {
		return (double) super.call("get_depth", new java.lang.Object[0]);
	}

	public void setDepth(double value) {
		super.call("set_depth", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSpin_degrees() {
		return (double) super.call("get_spin_degrees", new java.lang.Object[0]);
	}

	public void setSpin_degrees(double value) {
		super.call("set_spin_degrees", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getSpin_sides() {
		return (long) super.call("get_spin_sides", new java.lang.Object[0]);
	}

	public void setSpin_sides(long value) {
		super.call("set_spin_sides", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getPath_node() {
		return (String) super.call("get_path_node", new java.lang.Object[0]);
	}

	public void setPath_node(String value) {
		super.call("set_path_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getPath_interval_type() {
		return (long) super.call("get_path_interval_type", new java.lang.Object[0]);
	}

	public void setPath_interval_type(long value) {
		super.call("set_path_interval_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getPath_interval() {
		return (double) super.call("get_path_interval", new java.lang.Object[0]);
	}

	public void setPath_interval(double value) {
		super.call("set_path_interval", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPath_simplify_angle() {
		return (double) super.call("get_path_simplify_angle", new java.lang.Object[0]);
	}

	public void setPath_simplify_angle(double value) {
		super.call("set_path_simplify_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getPath_rotation() {
		return (long) super.call("get_path_rotation", new java.lang.Object[0]);
	}

	public void setPath_rotation(long value) {
		super.call("set_path_rotation", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getPath_rotation_accurate() {
		return (boolean) super.call("get_path_rotation_accurate", new java.lang.Object[0]);
	}

	public void setPath_rotation_accurate(boolean value) {
		super.call("set_path_rotation_accurate", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPath_local() {
		return (boolean) super.call("is_path_local", new java.lang.Object[0]);
	}

	public void setPath_local(boolean value) {
		super.call("set_path_local", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPath_continuous_u() {
		return (boolean) super.call("is_path_continuous_u", new java.lang.Object[0]);
	}

	public void setPath_continuous_u(boolean value) {
		super.call("set_path_continuous_u", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getPath_u_distance() {
		return (double) super.call("get_path_u_distance", new java.lang.Object[0]);
	}

	public void setPath_u_distance(double value) {
		super.call("set_path_u_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isPath_joined() {
		return (boolean) super.call("is_path_joined", new java.lang.Object[0]);
	}

	public void setPath_joined(boolean value) {
		super.call("set_path_joined", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getSmooth_faces() {
		return (boolean) super.call("get_smooth_faces", new java.lang.Object[0]);
	}

	public void setSmooth_faces(boolean value) {
		super.call("set_smooth_faces", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Object getMaterial() {
		return (Object) super.call("get_material", new java.lang.Object[0]);
	}

	public void setMaterial(Object value) {
		super.call("set_material", new java.lang.Object[]{(java.lang.Object) value});
	}
}
