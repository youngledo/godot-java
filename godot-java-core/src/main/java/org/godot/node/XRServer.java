package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.GodotObject;
import org.godot.collection.GodotDictionary;
import org.godot.math.Vector3;

public class XRServer extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_interfaces", 3995934104L), java.util.Map.entry("center_on_hmd", 1450904707L),
			java.util.Map.entry("clear_reference_frame", 3218959716L),
			java.util.Map.entry("set_camera_locked_to_origin", 2586408642L),
			java.util.Map.entry("remove_interface", 1898711491L), java.util.Map.entry("set_world_scale", 373806689L),
			java.util.Map.entry("get_world_origin", 3229777777L),
			java.util.Map.entry("get_interface_count", 3905245786L), java.util.Map.entry("add_interface", 1898711491L),
			java.util.Map.entry("get_primary_interface", 2143545064L),
			java.util.Map.entry("find_interface", 1395192955L), java.util.Map.entry("get_hmd_transform", 4183770049L),
			java.util.Map.entry("remove_tracker", 684804553L), java.util.Map.entry("get_world_scale", 1740695150L),
			java.util.Map.entry("get_interface", 4237347919L),
			java.util.Map.entry("set_primary_interface", 1898711491L),
			java.util.Map.entry("get_reference_frame", 3229777777L), java.util.Map.entry("add_tracker", 684804553L),
			java.util.Map.entry("is_camera_locked_to_origin", 36873697L),
			java.util.Map.entry("set_world_origin", 2952846383L), java.util.Map.entry("get_trackers", 3554694381L),
			java.util.Map.entry("get_tracker", 147382240L));

	XRServer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRServer(long nativePointer) {
		super(nativePointer);
	}

	public void clear_reference_frame() {
		super.call("clear_reference_frame");
	}

	public void center_on_hmd(int rotation_mode, boolean keep_height) {
		super.call("center_on_hmd", new java.lang.Object[]{java.lang.Integer.valueOf(rotation_mode),
				java.lang.Boolean.valueOf(keep_height)});
	}

	public boolean is_camera_locked_to_origin() {
		return (boolean) super.call("is_camera_locked_to_origin");
	}

	public void add_interface(XRInterface interface_) {
		super.call("add_interface", new java.lang.Object[]{(java.lang.Object) interface_});
	}

	public void remove_interface(XRInterface interface_) {
		super.call("remove_interface", new java.lang.Object[]{(java.lang.Object) interface_});
	}

	public XRInterface get_interface(long idx) {
		return (XRInterface) super.call("get_interface", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public XRInterface find_interface(String name) {
		return (XRInterface) super.call("find_interface", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void add_tracker(XRTracker tracker) {
		super.call("add_tracker", new java.lang.Object[]{(java.lang.Object) tracker});
	}

	public void remove_tracker(XRTracker tracker) {
		super.call("remove_tracker", new java.lang.Object[]{(java.lang.Object) tracker});
	}

	public GodotDictionary get_trackers(long tracker_types) {
		return (GodotDictionary) super.call("get_trackers",
				new java.lang.Object[]{java.lang.Long.valueOf(tracker_types)});
	}

	public XRTracker get_tracker(String tracker_name) {
		return (XRTracker) super.call("get_tracker", new java.lang.Object[]{(java.lang.Object) tracker_name});
	}

	public double getWorld_scale() {
		return (double) super.call("get_world_scale", new java.lang.Object[0]);
	}

	public void setWorld_scale(double value) {
		super.call("set_world_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector3 getWorld_origin() {
		return (Vector3) super.call("get_world_origin", new java.lang.Object[0]);
	}

	public void setWorld_origin(Vector3 value) {
		super.call("set_world_origin", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isCamera_locked_to_origin() {
		return (boolean) super.call("is_camera_locked_to_origin", new java.lang.Object[0]);
	}

	public void setCamera_locked_to_origin(boolean value) {
		super.call("set_camera_locked_to_origin", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public GodotObject getPrimary_interface() {
		return (GodotObject) super.call("get_primary_interface", new java.lang.Object[0]);
	}

	public void setPrimary_interface(GodotObject value) {
		super.call("set_primary_interface", new java.lang.Object[]{(java.lang.Object) value});
	}
}
