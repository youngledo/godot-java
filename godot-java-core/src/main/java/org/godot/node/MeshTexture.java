package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class MeshTexture extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_base_texture", 4051416890L), java.util.Map.entry("set_image_size", 743155724L),
			java.util.Map.entry("get_base_texture", 3635182373L), java.util.Map.entry("get_image_size", 3341600327L),
			java.util.Map.entry("set_mesh", 194775623L), java.util.Map.entry("get_mesh", 1808005922L));

	MeshTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MeshTexture(long nativePointer) {
		super(nativePointer);
	}

	public Mesh getMesh() {
		return (Mesh) super.call("get_mesh", new java.lang.Object[0]);
	}

	public void setMesh(Mesh value) {
		super.call("set_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getBase_texture() {
		return (Texture2D) super.call("get_base_texture", new java.lang.Object[0]);
	}

	public void setBase_texture(Texture2D value) {
		super.call("set_base_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getImage_size() {
		return (Vector2) super.call("get_image_size", new java.lang.Object[0]);
	}

	public void setImage_size(Vector2 value) {
		super.call("set_image_size", new java.lang.Object[]{(java.lang.Object) value});
	}
}
