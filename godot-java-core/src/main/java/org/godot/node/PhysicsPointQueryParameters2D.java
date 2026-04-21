package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;
import org.godot.math.Vector2;

public class PhysicsPointQueryParameters2D extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_position", 743155724L), java.util.Map.entry("get_position", 3341600327L),
			java.util.Map.entry("set_canvas_instance_id", 1286410249L),
			java.util.Map.entry("get_canvas_instance_id", 3905245786L), java.util.Map.entry("get_exclude", 3995934104L),
			java.util.Map.entry("is_collide_with_bodies_enabled", 36873697L),
			java.util.Map.entry("is_collide_with_areas_enabled", 36873697L),
			java.util.Map.entry("set_collision_mask", 1286410249L), java.util.Map.entry("set_exclude", 381264803L),
			java.util.Map.entry("set_collide_with_bodies", 2586408642L),
			java.util.Map.entry("set_collide_with_areas", 2586408642L),
			java.util.Map.entry("get_collision_mask", 3905245786L));

	PhysicsPointQueryParameters2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsPointQueryParameters2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_collide_with_bodies_enabled() {
		return (boolean) super.call("is_collide_with_bodies_enabled");
	}

	public boolean is_collide_with_areas_enabled() {
		return (boolean) super.call("is_collide_with_areas_enabled");
	}

	public Vector2 getPosition() {
		return (Vector2) super.call("get_position", new java.lang.Object[0]);
	}

	public void setPosition(Vector2 value) {
		super.call("set_position", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getCanvas_instance_id() {
		return (long) super.call("get_canvas_instance_id", new java.lang.Object[0]);
	}

	public void setCanvas_instance_id(long value) {
		super.call("set_canvas_instance_id", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCollision_mask() {
		return (long) super.call("get_collision_mask", new java.lang.Object[0]);
	}

	public void setCollision_mask(long value) {
		super.call("set_collision_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long[] getExclude() {
		return (long[]) super.call("get_exclude", new java.lang.Object[0]);
	}

	public void setExclude(long[] value) {
		super.call("set_exclude", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isCollide_with_bodies() {
		return (boolean) super.call("is_collide_with_bodies_enabled", new java.lang.Object[0]);
	}

	public void setCollide_with_bodies(boolean value) {
		super.call("set_collide_with_bodies", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isCollide_with_areas() {
		return (boolean) super.call("is_collide_with_areas_enabled", new java.lang.Object[0]);
	}

	public void setCollide_with_areas(boolean value) {
		super.call("set_collide_with_areas", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
