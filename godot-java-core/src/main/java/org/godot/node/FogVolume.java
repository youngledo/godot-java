package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class FogVolume extends VisualInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_size", 3460891852L), java.util.Map.entry("set_material", 2757459619L),
			java.util.Map.entry("get_material", 5934680L), java.util.Map.entry("get_size", 3360562783L),
			java.util.Map.entry("get_shape", 3920334604L), java.util.Map.entry("set_shape", 1416323362L));

	FogVolume(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FogVolume(long nativePointer) {
		super(nativePointer);
	}

	public Vector3 getSize() {
		return (Vector3) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector3 value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getShape() {
		return (long) super.call("get_shape", new java.lang.Object[0]);
	}

	public void setShape(long value) {
		super.call("set_shape", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Object getMaterial() {
		return (Object) super.call("get_material", new java.lang.Object[0]);
	}

	public void setMaterial(Object value) {
		super.call("set_material", new java.lang.Object[]{(java.lang.Object) value});
	}
}
