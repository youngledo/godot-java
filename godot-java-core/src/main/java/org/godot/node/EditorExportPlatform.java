package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.core.Callable;
import org.godot.core.RefCounted;

public class EditorExportPlatform extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("gen_export_flags", 2976483270L), java.util.Map.entry("get_message_type", 2667287293L),
			java.util.Map.entry("ssh_run_on_remote", 3163734797L),
			java.util.Map.entry("get_current_presets", 3995934104L),
			java.util.Map.entry("ssh_run_on_remote_no_wait", 3606362233L),
			java.util.Map.entry("get_os_name", 201670096L), java.util.Map.entry("get_worst_message_type", 2580557466L),
			java.util.Map.entry("get_message_text", 844755477L), java.util.Map.entry("export_pack_patch", 608021658L),
			java.util.Map.entry("get_forced_export_files", 1939331020L),
			java.util.Map.entry("save_pack_patch", 1485052307L), java.util.Map.entry("save_zip_patch", 1485052307L),
			java.util.Map.entry("save_zip", 1485052307L), java.util.Map.entry("add_message", 782767225L),
			java.util.Map.entry("export_pack", 3879521245L), java.util.Map.entry("clear_messages", 3218959716L),
			java.util.Map.entry("get_message_category", 844755477L), java.util.Map.entry("export_project", 3879521245L),
			java.util.Map.entry("export_zip", 3879521245L), java.util.Map.entry("save_pack", 3420080977L),
			java.util.Map.entry("create_preset", 2572397818L), java.util.Map.entry("export_project_files", 1063735070L),
			java.util.Map.entry("get_internal_export_files", 89550086L),
			java.util.Map.entry("find_export_template", 2248993622L),
			java.util.Map.entry("get_message_count", 3905245786L),
			java.util.Map.entry("ssh_push_to_remote", 218756989L), java.util.Map.entry("export_zip_patch", 608021658L));

	EditorExportPlatform(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorExportPlatform(long nativePointer) {
		super(nativePointer);
	}

	public EditorExportPreset create_preset() {
		return (EditorExportPreset) super.call("create_preset");
	}

	public GodotDictionary find_export_template(String template_file_name) {
		return (GodotDictionary) super.call("find_export_template",
				new java.lang.Object[]{(java.lang.Object) template_file_name});
	}

	public GodotDictionary save_pack(EditorExportPreset preset, boolean debug, String path, boolean embed) {
		return (GodotDictionary) super.call("save_pack", new java.lang.Object[]{(java.lang.Object) preset,
				java.lang.Boolean.valueOf(debug), (java.lang.Object) path, java.lang.Boolean.valueOf(embed)});
	}

	public GodotDictionary save_zip(EditorExportPreset preset, boolean debug, String path) {
		return (GodotDictionary) super.call("save_zip", new java.lang.Object[]{(java.lang.Object) preset,
				java.lang.Boolean.valueOf(debug), (java.lang.Object) path});
	}

	public GodotDictionary save_pack_patch(EditorExportPreset preset, boolean debug, String path) {
		return (GodotDictionary) super.call("save_pack_patch", new java.lang.Object[]{(java.lang.Object) preset,
				java.lang.Boolean.valueOf(debug), (java.lang.Object) path});
	}

	public GodotDictionary save_zip_patch(EditorExportPreset preset, boolean debug, String path) {
		return (GodotDictionary) super.call("save_zip_patch", new java.lang.Object[]{(java.lang.Object) preset,
				java.lang.Boolean.valueOf(debug), (java.lang.Object) path});
	}

	public String[] gen_export_flags(int flags) {
		return (String[]) super.call("gen_export_flags", new java.lang.Object[]{java.lang.Integer.valueOf(flags)});
	}

	public int export_project_files(EditorExportPreset preset, boolean debug, Callable save_cb, Callable shared_cb) {
		return (int) super.call("export_project_files", new java.lang.Object[]{(java.lang.Object) preset,
				java.lang.Boolean.valueOf(debug), (java.lang.Object) save_cb, (java.lang.Object) shared_cb});
	}

	public int export_project(EditorExportPreset preset, boolean debug, String path, int flags) {
		return (int) super.call("export_project", new java.lang.Object[]{(java.lang.Object) preset,
				java.lang.Boolean.valueOf(debug), (java.lang.Object) path, java.lang.Integer.valueOf(flags)});
	}

	public int export_pack(EditorExportPreset preset, boolean debug, String path, int flags) {
		return (int) super.call("export_pack", new java.lang.Object[]{(java.lang.Object) preset,
				java.lang.Boolean.valueOf(debug), (java.lang.Object) path, java.lang.Integer.valueOf(flags)});
	}

	public int export_zip(EditorExportPreset preset, boolean debug, String path, int flags) {
		return (int) super.call("export_zip", new java.lang.Object[]{(java.lang.Object) preset,
				java.lang.Boolean.valueOf(debug), (java.lang.Object) path, java.lang.Integer.valueOf(flags)});
	}

	public int export_pack_patch(EditorExportPreset preset, boolean debug, String path, String[] patches, int flags) {
		return (int) super.call("export_pack_patch",
				new java.lang.Object[]{(java.lang.Object) preset, java.lang.Boolean.valueOf(debug),
						(java.lang.Object) path, (java.lang.Object) patches, java.lang.Integer.valueOf(flags)});
	}

	public int export_zip_patch(EditorExportPreset preset, boolean debug, String path, String[] patches, int flags) {
		return (int) super.call("export_zip_patch",
				new java.lang.Object[]{(java.lang.Object) preset, java.lang.Boolean.valueOf(debug),
						(java.lang.Object) path, (java.lang.Object) patches, java.lang.Integer.valueOf(flags)});
	}

	public void clear_messages() {
		super.call("clear_messages");
	}

	public void add_message(int type, String category, String message) {
		super.call("add_message", new java.lang.Object[]{java.lang.Integer.valueOf(type), (java.lang.Object) category,
				(java.lang.Object) message});
	}

	public int get_message_type(long index) {
		return (int) super.call("get_message_type", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_message_category(long index) {
		return (String) super.call("get_message_category", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_message_text(long index) {
		return (String) super.call("get_message_text", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int ssh_run_on_remote(String host, String port, String[] ssh_arg, String cmd_args, GodotArray output,
			long port_fwd) {
		return (int) super.call("ssh_run_on_remote",
				new java.lang.Object[]{(java.lang.Object) host, (java.lang.Object) port, (java.lang.Object) ssh_arg,
						(java.lang.Object) cmd_args, (java.lang.Object) output, java.lang.Long.valueOf(port_fwd)});
	}

	public long ssh_run_on_remote_no_wait(String host, String port, String[] ssh_args, String cmd_args, long port_fwd) {
		return (long) super.call("ssh_run_on_remote_no_wait",
				new java.lang.Object[]{(java.lang.Object) host, (java.lang.Object) port, (java.lang.Object) ssh_args,
						(java.lang.Object) cmd_args, java.lang.Long.valueOf(port_fwd)});
	}

	public int ssh_push_to_remote(String host, String port, String[] scp_args, String src_file, String dst_file) {
		return (int) super.call("ssh_push_to_remote",
				new java.lang.Object[]{(java.lang.Object) host, (java.lang.Object) port, (java.lang.Object) scp_args,
						(java.lang.Object) src_file, (java.lang.Object) dst_file});
	}

	public GodotDictionary get_internal_export_files(EditorExportPreset preset, boolean debug) {
		return (GodotDictionary) super.call("get_internal_export_files",
				new java.lang.Object[]{(java.lang.Object) preset, java.lang.Boolean.valueOf(debug)});
	}

	public String[] get_forced_export_files(EditorExportPreset preset) {
		return (String[]) super.call("get_forced_export_files", new java.lang.Object[]{(java.lang.Object) preset});
	}
}
