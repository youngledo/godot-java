package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class CameraServer extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_feed_count", 2455072627L), java.util.Map.entry("remove_feed", 3204782488L),
			java.util.Map.entry("is_monitoring_feeds", 36873697L),
			java.util.Map.entry("set_monitoring_feeds", 2586408642L), java.util.Map.entry("feeds", 2915620761L),
			java.util.Map.entry("get_feed", 361927068L), java.util.Map.entry("add_feed", 3204782488L));

	CameraServer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CameraServer(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_monitoring_feeds() {
		return (boolean) super.call("is_monitoring_feeds");
	}

	public CameraFeed get_feed(long index) {
		return (CameraFeed) super.call("get_feed", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public CameraFeed[] feeds() {
		return (CameraFeed[]) super.call("feeds");
	}

	public void add_feed(CameraFeed feed) {
		super.call("add_feed", new java.lang.Object[]{(java.lang.Object) feed});
	}

	public void remove_feed(CameraFeed feed) {
		super.call("remove_feed", new java.lang.Object[]{(java.lang.Object) feed});
	}

	public boolean isMonitoring_feeds() {
		return (boolean) super.call("is_monitoring_feeds", new java.lang.Object[0]);
	}

	public void setMonitoring_feeds(boolean value) {
		super.call("set_monitoring_feeds", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
