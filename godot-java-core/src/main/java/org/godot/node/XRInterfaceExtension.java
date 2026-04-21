package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2;
import org.godot.math.Rect2i;
import org.godot.math.Vector2;

public class XRInterfaceExtension extends XRInterface {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_depth_texture", 529393457L),
			java.util.Map.entry("get_velocity_texture", 529393457L),
			java.util.Map.entry("get_color_texture", 529393457L), java.util.Map.entry("add_blit", 258596971L),
			java.util.Map.entry("get_render_target_texture", 41030802L));

	XRInterfaceExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRInterfaceExtension(long nativePointer) {
		super(nativePointer);
	}

	public void add_blit(long render_target, Rect2 src_rect, Rect2i dst_rect, boolean use_layer, long layer,
			boolean apply_lens_distortion, Vector2 eye_center, double k1, double k2, double upscale,
			double aspect_ratio) {
		super.call("add_blit",
				new java.lang.Object[]{java.lang.Long.valueOf(render_target), (java.lang.Object) src_rect,
						(java.lang.Object) dst_rect, java.lang.Boolean.valueOf(use_layer),
						java.lang.Long.valueOf(layer), java.lang.Boolean.valueOf(apply_lens_distortion),
						(java.lang.Object) eye_center, java.lang.Double.valueOf(k1), java.lang.Double.valueOf(k2),
						java.lang.Double.valueOf(upscale), java.lang.Double.valueOf(aspect_ratio)});
	}

	public long get_render_target_texture(long render_target) {
		return (long) super.call("get_render_target_texture",
				new java.lang.Object[]{java.lang.Long.valueOf(render_target)});
	}
}
