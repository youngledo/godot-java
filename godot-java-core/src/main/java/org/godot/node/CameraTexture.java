package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CameraTexture extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_camera_feed_id", 1286410249L),
			java.util.Map.entry("get_camera_feed_id", 3905245786L), java.util.Map.entry("set_which_feed", 1595299230L),
			java.util.Map.entry("set_camera_active", 2586408642L), java.util.Map.entry("get_camera_active", 36873697L),
			java.util.Map.entry("get_which_feed", 91039457L));

	CameraTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CameraTexture(long nativePointer) {
		super(nativePointer);
	}

	public long getCamera_feed_id() {
		return (long) super.call("get_camera_feed_id", new java.lang.Object[0]);
	}

	public void setCamera_feed_id(long value) {
		super.call("set_camera_feed_id", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getWhich_feed() {
		return (long) super.call("get_which_feed", new java.lang.Object[0]);
	}

	public void setWhich_feed(long value) {
		super.call("set_which_feed", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getCamera_is_active() {
		return (boolean) super.call("get_camera_active", new java.lang.Object[0]);
	}

	public void setCamera_is_active(boolean value) {
		super.call("set_camera_active", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
