package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;
import org.godot.math.Vector3;

public class Noise extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_noise_2d", 2753205203L), java.util.Map.entry("get_noise_2dv", 2276447920L),
			java.util.Map.entry("get_noise_1d", 3919130443L), java.util.Map.entry("get_noise_3dv", 1109078154L),
			java.util.Map.entry("get_seamless_image", 2770743602L), java.util.Map.entry("get_noise_3d", 973811851L),
			java.util.Map.entry("get_image_3d", 3977814329L), java.util.Map.entry("get_image", 3180683109L),
			java.util.Map.entry("get_seamless_image_3d", 451006340L));

	Noise(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Noise(long nativePointer) {
		super(nativePointer);
	}

	public double get_noise_1d(double x) {
		return (double) super.call("get_noise_1d", new java.lang.Object[]{java.lang.Double.valueOf(x)});
	}

	public double get_noise_2d(double x, double y) {
		return (double) super.call("get_noise_2d",
				new java.lang.Object[]{java.lang.Double.valueOf(x), java.lang.Double.valueOf(y)});
	}

	public double get_noise_2dv(Vector2 v) {
		return (double) super.call("get_noise_2dv", new java.lang.Object[]{(java.lang.Object) v});
	}

	public double get_noise_3d(double x, double y, double z) {
		return (double) super.call("get_noise_3d", new java.lang.Object[]{java.lang.Double.valueOf(x),
				java.lang.Double.valueOf(y), java.lang.Double.valueOf(z)});
	}

	public double get_noise_3dv(Vector3 v) {
		return (double) super.call("get_noise_3dv", new java.lang.Object[]{(java.lang.Object) v});
	}

	public Image get_image(long width, long height, boolean invert, boolean in_3d_space, boolean normalize) {
		return (Image) super.call("get_image",
				new java.lang.Object[]{java.lang.Long.valueOf(width), java.lang.Long.valueOf(height),
						java.lang.Boolean.valueOf(invert), java.lang.Boolean.valueOf(in_3d_space),
						java.lang.Boolean.valueOf(normalize)});
	}

	public Image get_seamless_image(long width, long height, boolean invert, boolean in_3d_space, double skirt,
			boolean normalize) {
		return (Image) super.call("get_seamless_image",
				new java.lang.Object[]{java.lang.Long.valueOf(width), java.lang.Long.valueOf(height),
						java.lang.Boolean.valueOf(invert), java.lang.Boolean.valueOf(in_3d_space),
						java.lang.Double.valueOf(skirt), java.lang.Boolean.valueOf(normalize)});
	}

	public Image[] get_image_3d(long width, long height, long depth, boolean invert, boolean normalize) {
		return (Image[]) super.call("get_image_3d",
				new java.lang.Object[]{java.lang.Long.valueOf(width), java.lang.Long.valueOf(height),
						java.lang.Long.valueOf(depth), java.lang.Boolean.valueOf(invert),
						java.lang.Boolean.valueOf(normalize)});
	}

	public Image[] get_seamless_image_3d(long width, long height, long depth, boolean invert, double skirt,
			boolean normalize) {
		return (Image[]) super.call("get_seamless_image_3d",
				new java.lang.Object[]{java.lang.Long.valueOf(width), java.lang.Long.valueOf(height),
						java.lang.Long.valueOf(depth), java.lang.Boolean.valueOf(invert),
						java.lang.Double.valueOf(skirt), java.lang.Boolean.valueOf(normalize)});
	}
}
