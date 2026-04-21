package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class WorldEnvironment extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_compositor", 1586754307L),
			java.util.Map.entry("set_camera_attributes", 2817810567L),
			java.util.Map.entry("get_camera_attributes", 3921283215L),
			java.util.Map.entry("set_environment", 4143518816L), java.util.Map.entry("get_compositor", 3647707413L),
			java.util.Map.entry("get_environment", 3082064660L));

	WorldEnvironment(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WorldEnvironment(long nativePointer) {
		super(nativePointer);
	}

	public Environment getEnvironment() {
		return (Environment) super.call("get_environment", new java.lang.Object[0]);
	}

	public void setEnvironment(Environment value) {
		super.call("set_environment", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Object getCamera_attributes() {
		return (Object) super.call("get_camera_attributes", new java.lang.Object[0]);
	}

	public void setCamera_attributes(Object value) {
		super.call("set_camera_attributes", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Compositor getCompositor() {
		return (Compositor) super.call("get_compositor", new java.lang.Object[0]);
	}

	public void setCompositor(Compositor value) {
		super.call("set_compositor", new java.lang.Object[]{(java.lang.Object) value});
	}
}
