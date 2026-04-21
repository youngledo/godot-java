package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;

public class Shape2D extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("collide_and_get_contacts", 3056932662L),
			java.util.Map.entry("collide_with_motion_and_get_contacts", 3620351573L),
			java.util.Map.entry("collide", 3709843132L), java.util.Map.entry("set_custom_solver_bias", 373806689L),
			java.util.Map.entry("get_custom_solver_bias", 1740695150L),
			java.util.Map.entry("collide_with_motion", 2869556801L), java.util.Map.entry("draw", 2948539648L),
			java.util.Map.entry("get_rect", 1639390495L));

	Shape2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Shape2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean collide(Transform2D local_xform, Shape2D with_shape, Transform2D shape_xform) {
		return (boolean) super.call("collide", new java.lang.Object[]{(java.lang.Object) local_xform,
				(java.lang.Object) with_shape, (java.lang.Object) shape_xform});
	}

	public boolean collide_with_motion(Transform2D local_xform, Vector2 local_motion, Shape2D with_shape,
			Transform2D shape_xform, Vector2 shape_motion) {
		return (boolean) super.call("collide_with_motion",
				new java.lang.Object[]{(java.lang.Object) local_xform, (java.lang.Object) local_motion,
						(java.lang.Object) with_shape, (java.lang.Object) shape_xform,
						(java.lang.Object) shape_motion});
	}

	public double[][] collide_and_get_contacts(Transform2D local_xform, Shape2D with_shape, Transform2D shape_xform) {
		return (double[][]) super.call("collide_and_get_contacts", new java.lang.Object[]{
				(java.lang.Object) local_xform, (java.lang.Object) with_shape, (java.lang.Object) shape_xform});
	}

	public double[][] collide_with_motion_and_get_contacts(Transform2D local_xform, Vector2 local_motion,
			Shape2D with_shape, Transform2D shape_xform, Vector2 shape_motion) {
		return (double[][]) super.call("collide_with_motion_and_get_contacts",
				new java.lang.Object[]{(java.lang.Object) local_xform, (java.lang.Object) local_motion,
						(java.lang.Object) with_shape, (java.lang.Object) shape_xform,
						(java.lang.Object) shape_motion});
	}

	public void draw(long canvas_item, Color color) {
		super.call("draw", new java.lang.Object[]{java.lang.Long.valueOf(canvas_item), (java.lang.Object) color});
	}

	public double getCustom_solver_bias() {
		return (double) super.call("get_custom_solver_bias", new java.lang.Object[0]);
	}

	public void setCustom_solver_bias(double value) {
		super.call("set_custom_solver_bias", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
