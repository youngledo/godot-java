package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector2;

public class Line2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_begin_cap_mode", 1669024546L), java.util.Map.entry("get_antialiased", 36873697L),
			java.util.Map.entry("get_gradient", 132272999L), java.util.Map.entry("set_points", 1509147220L),
			java.util.Map.entry("get_joint_mode", 2546544037L), java.util.Map.entry("get_default_color", 3444240500L),
			java.util.Map.entry("get_texture_mode", 2341040722L), java.util.Map.entry("get_width", 1740695150L),
			java.util.Map.entry("set_texture_mode", 1952559516L), java.util.Map.entry("get_point_count", 3905245786L),
			java.util.Map.entry("set_end_cap_mode", 1669024546L), java.util.Map.entry("set_sharp_limit", 373806689L),
			java.util.Map.entry("set_joint_mode", 604292979L), java.util.Map.entry("get_points", 2961356807L),
			java.util.Map.entry("set_antialiased", 2586408642L), java.util.Map.entry("is_closed", 36873697L),
			java.util.Map.entry("set_default_color", 2920490490L), java.util.Map.entry("set_gradient", 2756054477L),
			java.util.Map.entry("set_closed", 2586408642L), java.util.Map.entry("get_begin_cap_mode", 1107511441L),
			java.util.Map.entry("set_width", 373806689L), java.util.Map.entry("set_round_precision", 1286410249L),
			java.util.Map.entry("clear_points", 3218959716L), java.util.Map.entry("get_sharp_limit", 1740695150L),
			java.util.Map.entry("get_end_cap_mode", 1107511441L),
			java.util.Map.entry("get_point_position", 2299179447L), java.util.Map.entry("remove_point", 1286410249L),
			java.util.Map.entry("get_round_precision", 3905245786L), java.util.Map.entry("set_texture", 4051416890L),
			java.util.Map.entry("get_curve", 2460114913L), java.util.Map.entry("set_point_position", 163021252L),
			java.util.Map.entry("add_point", 2654014372L), java.util.Map.entry("set_curve", 270443179L),
			java.util.Map.entry("get_texture", 3635182373L));

	Line2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Line2D(long nativePointer) {
		super(nativePointer);
	}

	public void set_point_position(long index, Vector2 position) {
		super.call("set_point_position",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) position});
	}

	public Vector2 get_point_position(long index) {
		return (Vector2) super.call("get_point_position", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void add_point(Vector2 position, long index) {
		super.call("add_point", new java.lang.Object[]{(java.lang.Object) position, java.lang.Long.valueOf(index)});
	}

	public void remove_point(long index) {
		super.call("remove_point", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void clear_points() {
		super.call("clear_points");
	}

	public boolean is_closed() {
		return (boolean) super.call("is_closed");
	}

	public double[][] getPoints() {
		return (double[][]) super.call("get_points", new java.lang.Object[0]);
	}

	public void setPoints(double[][] value) {
		super.call("set_points", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isClosed() {
		return (boolean) super.call("is_closed", new java.lang.Object[0]);
	}

	public void setClosed(boolean value) {
		super.call("set_closed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getWidth() {
		return (double) super.call("get_width", new java.lang.Object[0]);
	}

	public void setWidth(double value) {
		super.call("set_width", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Curve getWidth_curve() {
		return (Curve) super.call("get_curve", new java.lang.Object[0]);
	}

	public void setWidth_curve(Curve value) {
		super.call("set_curve", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getDefault_color() {
		return (Color) super.call("get_default_color", new java.lang.Object[0]);
	}

	public void setDefault_color(Color value) {
		super.call("set_default_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Gradient getGradient() {
		return (Gradient) super.call("get_gradient", new java.lang.Object[0]);
	}

	public void setGradient(Gradient value) {
		super.call("set_gradient", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getTexture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getTexture_mode() {
		return (long) super.call("get_texture_mode", new java.lang.Object[0]);
	}

	public void setTexture_mode(long value) {
		super.call("set_texture_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getJoint_mode() {
		return (long) super.call("get_joint_mode", new java.lang.Object[0]);
	}

	public void setJoint_mode(long value) {
		super.call("set_joint_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBegin_cap_mode() {
		return (long) super.call("get_begin_cap_mode", new java.lang.Object[0]);
	}

	public void setBegin_cap_mode(long value) {
		super.call("set_begin_cap_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getEnd_cap_mode() {
		return (long) super.call("get_end_cap_mode", new java.lang.Object[0]);
	}

	public void setEnd_cap_mode(long value) {
		super.call("set_end_cap_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getSharp_limit() {
		return (double) super.call("get_sharp_limit", new java.lang.Object[0]);
	}

	public void setSharp_limit(double value) {
		super.call("set_sharp_limit", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getRound_precision() {
		return (long) super.call("get_round_precision", new java.lang.Object[0]);
	}

	public void setRound_precision(long value) {
		super.call("set_round_precision", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getAntialiased() {
		return (boolean) super.call("get_antialiased", new java.lang.Object[0]);
	}

	public void setAntialiased(boolean value) {
		super.call("set_antialiased", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
