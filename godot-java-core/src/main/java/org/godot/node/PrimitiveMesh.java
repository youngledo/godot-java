package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.AABB;

public class PrimitiveMesh extends Mesh {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_custom_aabb", 259215842L), java.util.Map.entry("set_add_uv2", 2586408642L),
			java.util.Map.entry("get_custom_aabb", 1068685055L), java.util.Map.entry("set_material", 2757459619L),
			java.util.Map.entry("get_material", 5934680L), java.util.Map.entry("get_mesh_arrays", 3995934104L),
			java.util.Map.entry("get_flip_faces", 36873697L), java.util.Map.entry("get_add_uv2", 36873697L),
			java.util.Map.entry("get_uv2_padding", 1740695150L), java.util.Map.entry("request_update", 3218959716L),
			java.util.Map.entry("set_flip_faces", 2586408642L), java.util.Map.entry("set_uv2_padding", 373806689L));

	PrimitiveMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PrimitiveMesh(long nativePointer) {
		super(nativePointer);
	}

	public void request_update() {
		super.call("request_update");
	}

	public Object getMaterial() {
		return (Object) super.call("get_material", new java.lang.Object[0]);
	}

	public void setMaterial(Object value) {
		super.call("set_material", new java.lang.Object[]{(java.lang.Object) value});
	}

	public AABB getCustom_aabb() {
		return (AABB) super.call("get_custom_aabb", new java.lang.Object[0]);
	}

	public void setCustom_aabb(AABB value) {
		super.call("set_custom_aabb", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getFlip_faces() {
		return (boolean) super.call("get_flip_faces", new java.lang.Object[0]);
	}

	public void setFlip_faces(boolean value) {
		super.call("set_flip_faces", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAdd_uv2() {
		return (boolean) super.call("get_add_uv2", new java.lang.Object[0]);
	}

	public void setAdd_uv2(boolean value) {
		super.call("set_add_uv2", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getUv2_padding() {
		return (double) super.call("get_uv2_padding", new java.lang.Object[0]);
	}

	public void setUv2_padding(double value) {
		super.call("set_uv2_padding", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
