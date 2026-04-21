package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.AABB;
import org.godot.math.Color;
import org.godot.math.Transform2D;
import org.godot.math.Transform3D;

public class MultiMesh extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_using_custom_data", 36873697L),
			java.util.Map.entry("set_instance_transform_2d", 30160968L),
			java.util.Map.entry("set_buffer_interpolated", 3514430332L),
			java.util.Map.entry("set_transform_format", 2404750322L),
			java.util.Map.entry("get_physics_interpolation_quality", 1465701882L),
			java.util.Map.entry("get_instance_transform_2d", 3836996910L),
			java.util.Map.entry("get_instance_custom_data", 3457211756L),
			java.util.Map.entry("reset_instance_physics_interpolation", 1286410249L),
			java.util.Map.entry("set_instance_count", 1286410249L), java.util.Map.entry("get_custom_aabb", 1068685055L),
			java.util.Map.entry("get_instance_color", 3457211756L),
			java.util.Map.entry("set_visible_instance_count", 1286410249L),
			java.util.Map.entry("set_instance_color", 2878471219L),
			java.util.Map.entry("set_use_custom_data", 2586408642L), java.util.Map.entry("set_use_colors", 2586408642L),
			java.util.Map.entry("get_aabb", 1068685055L), java.util.Map.entry("set_instance_custom_data", 2878471219L),
			java.util.Map.entry("set_physics_interpolation_quality", 1819488408L),
			java.util.Map.entry("get_buffer", 675695659L), java.util.Map.entry("set_buffer", 2899603908L),
			java.util.Map.entry("reset_instances_physics_interpolation", 3218959716L),
			java.util.Map.entry("set_custom_aabb", 259215842L),
			java.util.Map.entry("get_visible_instance_count", 3905245786L),
			java.util.Map.entry("get_instance_transform", 1965739696L), java.util.Map.entry("set_mesh", 194775623L),
			java.util.Map.entry("get_mesh", 1808005922L), java.util.Map.entry("get_transform_format", 2444156481L),
			java.util.Map.entry("get_instance_count", 3905245786L), java.util.Map.entry("is_using_colors", 36873697L),
			java.util.Map.entry("set_instance_transform", 3616898986L));

	MultiMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MultiMesh(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_using_colors() {
		return (boolean) super.call("is_using_colors");
	}

	public boolean is_using_custom_data() {
		return (boolean) super.call("is_using_custom_data");
	}

	public void set_instance_transform(long instance, Transform3D transform) {
		super.call("set_instance_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), (java.lang.Object) transform});
	}

	public void set_instance_transform_2d(long instance, Transform2D transform) {
		super.call("set_instance_transform_2d",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), (java.lang.Object) transform});
	}

	public Transform3D get_instance_transform(long instance) {
		return (Transform3D) super.call("get_instance_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(instance)});
	}

	public Transform2D get_instance_transform_2d(long instance) {
		return (Transform2D) super.call("get_instance_transform_2d",
				new java.lang.Object[]{java.lang.Long.valueOf(instance)});
	}

	public void set_instance_color(long instance, Color color) {
		super.call("set_instance_color",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), (java.lang.Object) color});
	}

	public Color get_instance_color(long instance) {
		return (Color) super.call("get_instance_color", new java.lang.Object[]{java.lang.Long.valueOf(instance)});
	}

	public void set_instance_custom_data(long instance, Color custom_data) {
		super.call("set_instance_custom_data",
				new java.lang.Object[]{java.lang.Long.valueOf(instance), (java.lang.Object) custom_data});
	}

	public Color get_instance_custom_data(long instance) {
		return (Color) super.call("get_instance_custom_data", new java.lang.Object[]{java.lang.Long.valueOf(instance)});
	}

	public void reset_instance_physics_interpolation(long instance) {
		super.call("reset_instance_physics_interpolation", new java.lang.Object[]{java.lang.Long.valueOf(instance)});
	}

	public void reset_instances_physics_interpolation() {
		super.call("reset_instances_physics_interpolation");
	}

	public void set_buffer_interpolated(double[] buffer_curr, double[] buffer_prev) {
		super.call("set_buffer_interpolated",
				new java.lang.Object[]{(java.lang.Object) buffer_curr, (java.lang.Object) buffer_prev});
	}

	public long getTransform_format() {
		return (long) super.call("get_transform_format", new java.lang.Object[0]);
	}

	public void setTransform_format(long value) {
		super.call("set_transform_format", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isUse_colors() {
		return (boolean) super.call("is_using_colors", new java.lang.Object[0]);
	}

	public void setUse_colors(boolean value) {
		super.call("set_use_colors", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isUse_custom_data() {
		return (boolean) super.call("is_using_custom_data", new java.lang.Object[0]);
	}

	public void setUse_custom_data(boolean value) {
		super.call("set_use_custom_data", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public AABB getCustom_aabb() {
		return (AABB) super.call("get_custom_aabb", new java.lang.Object[0]);
	}

	public void setCustom_aabb(AABB value) {
		super.call("set_custom_aabb", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getInstance_count() {
		return (long) super.call("get_instance_count", new java.lang.Object[0]);
	}

	public void setInstance_count(long value) {
		super.call("set_instance_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getVisible_instance_count() {
		return (long) super.call("get_visible_instance_count", new java.lang.Object[0]);
	}

	public void setVisible_instance_count(long value) {
		super.call("set_visible_instance_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Mesh getMesh() {
		return (Mesh) super.call("get_mesh", new java.lang.Object[0]);
	}

	public void setMesh(Mesh value) {
		super.call("set_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[] getBuffer() {
		return (double[]) super.call("get_buffer", new java.lang.Object[0]);
	}

	public void setBuffer(double[] value) {
		super.call("set_buffer", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[][] getTransform_array() {
		return (double[][]) super.call("_get_transform_array", new java.lang.Object[0]);
	}

	public void setTransform_array(double[][] value) {
		super.call("_set_transform_array", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[][] getTransform_2d_array() {
		return (double[][]) super.call("_get_transform_2d_array", new java.lang.Object[0]);
	}

	public void setTransform_2d_array(double[][] value) {
		super.call("_set_transform_2d_array", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[][] getColor_array() {
		return (double[][]) super.call("_get_color_array", new java.lang.Object[0]);
	}

	public void setColor_array(double[][] value) {
		super.call("_set_color_array", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[][] getCustom_data_array() {
		return (double[][]) super.call("_get_custom_data_array", new java.lang.Object[0]);
	}

	public void setCustom_data_array(double[][] value) {
		super.call("_set_custom_data_array", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getPhysics_interpolation_quality() {
		return (long) super.call("get_physics_interpolation_quality", new java.lang.Object[0]);
	}

	public void setPhysics_interpolation_quality(long value) {
		super.call("set_physics_interpolation_quality", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
