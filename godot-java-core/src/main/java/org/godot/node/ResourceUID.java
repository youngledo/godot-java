package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class ResourceUID extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_id_path", 844755477L), java.util.Map.entry("uid_to_path", 1703090593L),
			java.util.Map.entry("text_to_id", 1321353865L), java.util.Map.entry("create_id", 2455072627L),
			java.util.Map.entry("has_id", 1116898809L), java.util.Map.entry("id_to_text", 844755477L),
			java.util.Map.entry("remove_id", 1286410249L), java.util.Map.entry("ensure_path", 1703090593L),
			java.util.Map.entry("set_id", 501894301L), java.util.Map.entry("create_id_for_path", 1597066294L),
			java.util.Map.entry("add_id", 501894301L), java.util.Map.entry("path_to_uid", 1703090593L));

	ResourceUID(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceUID(long nativePointer) {
		super(nativePointer);
	}

	public String id_to_text(long id) {
		return (String) super.call("id_to_text", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public long text_to_id(String text_id) {
		return (long) super.call("text_to_id", new java.lang.Object[]{(java.lang.Object) text_id});
	}

	public long create_id() {
		return (long) super.call("create_id");
	}

	public long create_id_for_path(String path) {
		return (long) super.call("create_id_for_path", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean has_id(long id) {
		return (boolean) super.call("has_id", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void add_id(long id, String path) {
		super.call("add_id", new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) path});
	}

	public void set_id(long id, String path) {
		super.call("set_id", new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) path});
	}

	public String get_id_path(long id) {
		return (String) super.call("get_id_path", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void remove_id(long id) {
		super.call("remove_id", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public String uid_to_path(String uid) {
		return (String) super.call("uid_to_path", new java.lang.Object[]{(java.lang.Object) uid});
	}

	public String path_to_uid(String path) {
		return (String) super.call("path_to_uid", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String ensure_path(String path_or_uid) {
		return (String) super.call("ensure_path", new java.lang.Object[]{(java.lang.Object) path_or_uid});
	}
}
