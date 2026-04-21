package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class ResourceSaver extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_uid", 993915709L), java.util.Map.entry("get_recognized_extensions", 4223597960L),
			java.util.Map.entry("remove_resource_format_saver", 3373026878L), java.util.Map.entry("save", 2983274697L),
			java.util.Map.entry("add_resource_format_saver", 362894272L),
			java.util.Map.entry("get_resource_id_for_path", 150756522L));

	ResourceSaver(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceSaver(long nativePointer) {
		super(nativePointer);
	}

	public int save(Resource resource, String path, int flags) {
		return (int) super.call("save", new java.lang.Object[]{(java.lang.Object) resource, (java.lang.Object) path,
				java.lang.Integer.valueOf(flags)});
	}

	public int set_uid(String resource, long uid) {
		return (int) super.call("set_uid",
				new java.lang.Object[]{(java.lang.Object) resource, java.lang.Long.valueOf(uid)});
	}

	public String[] get_recognized_extensions(Resource type) {
		return (String[]) super.call("get_recognized_extensions", new java.lang.Object[]{(java.lang.Object) type});
	}

	public void add_resource_format_saver(ResourceFormatSaver format_saver, boolean at_front) {
		super.call("add_resource_format_saver",
				new java.lang.Object[]{(java.lang.Object) format_saver, java.lang.Boolean.valueOf(at_front)});
	}

	public void remove_resource_format_saver(ResourceFormatSaver format_saver) {
		super.call("remove_resource_format_saver", new java.lang.Object[]{(java.lang.Object) format_saver});
	}

	public long get_resource_id_for_path(String path, boolean generate) {
		return (long) super.call("get_resource_id_for_path",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Boolean.valueOf(generate)});
	}
}
