package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class PointLight2D extends Light2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_texture_offset", 743155724L), java.util.Map.entry("set_texture", 4051416890L),
			java.util.Map.entry("get_texture_offset", 3341600327L),
			java.util.Map.entry("get_texture_scale", 1740695150L), java.util.Map.entry("get_texture", 3635182373L),
			java.util.Map.entry("set_texture_scale", 373806689L));

	PointLight2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PointLight2D(long nativePointer) {
		super(nativePointer);
	}

	public Object getTexture() {
		return (Object) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Object value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getOffset() {
		return (Vector2) super.call("get_texture_offset", new java.lang.Object[0]);
	}

	public void setOffset(Vector2 value) {
		super.call("set_texture_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getTexture_scale() {
		return (double) super.call("get_texture_scale", new java.lang.Object[0]);
	}

	public void setTexture_scale(double value) {
		super.call("set_texture_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getHeight() {
		return (double) super.call("get_height", new java.lang.Object[0]);
	}

	public void setHeight(double value) {
		super.call("set_height", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
