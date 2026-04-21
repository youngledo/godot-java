package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;

public class AnimationNode extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_filter_path", 3868023870L), java.util.Map.entry("blend_node", 1746075988L),
			java.util.Map.entry("set_filter_enabled", 2586408642L), java.util.Map.entry("add_input", 2323990056L),
			java.util.Map.entry("get_input_name", 844755477L), java.util.Map.entry("set_input_name", 215573526L),
			java.util.Map.entry("is_path_filtered", 861721659L), java.util.Map.entry("is_process_testing", 36873697L),
			java.util.Map.entry("blend_input", 1361527350L), java.util.Map.entry("blend_animation", 1630801826L),
			java.util.Map.entry("get_parameter", 2760726917L), java.util.Map.entry("is_filter_enabled", 36873697L),
			java.util.Map.entry("remove_input", 1286410249L), java.util.Map.entry("get_input_count", 3905245786L),
			java.util.Map.entry("get_processing_animation_tree_instance_id", 3905245786L),
			java.util.Map.entry("find_input", 1321353865L), java.util.Map.entry("set_parameter", 3776071444L));

	AnimationNode(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationNode(long nativePointer) {
		super(nativePointer);
	}

	public boolean add_input(String name) {
		return (boolean) super.call("add_input", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void remove_input(long index) {
		super.call("remove_input", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean set_input_name(long input, String name) {
		return (boolean) super.call("set_input_name",
				new java.lang.Object[]{java.lang.Long.valueOf(input), (java.lang.Object) name});
	}

	public String get_input_name(long input) {
		return (String) super.call("get_input_name", new java.lang.Object[]{java.lang.Long.valueOf(input)});
	}

	public int find_input(String name) {
		return (int) super.call("find_input", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void set_filter_path(String path, boolean enable) {
		super.call("set_filter_path",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Boolean.valueOf(enable)});
	}

	public boolean is_path_filtered(String path) {
		return (boolean) super.call("is_path_filtered", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean is_filter_enabled() {
		return (boolean) super.call("is_filter_enabled");
	}

	public boolean is_process_testing() {
		return (boolean) super.call("is_process_testing");
	}

	public void blend_animation(String animation, double time, double delta, boolean seeked,
			boolean is_external_seeking, double blend, int looped_flag) {
		super.call("blend_animation",
				new java.lang.Object[]{(java.lang.Object) animation, java.lang.Double.valueOf(time),
						java.lang.Double.valueOf(delta), java.lang.Boolean.valueOf(seeked),
						java.lang.Boolean.valueOf(is_external_seeking), java.lang.Double.valueOf(blend),
						java.lang.Integer.valueOf(looped_flag)});
	}

	public double blend_node(String name, AnimationNode node, double time, boolean seek, boolean is_external_seeking,
			double blend, int filter, boolean sync, boolean test_only) {
		return (double) super.call("blend_node",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) node, java.lang.Double.valueOf(time),
						java.lang.Boolean.valueOf(seek), java.lang.Boolean.valueOf(is_external_seeking),
						java.lang.Double.valueOf(blend), java.lang.Integer.valueOf(filter),
						java.lang.Boolean.valueOf(sync), java.lang.Boolean.valueOf(test_only)});
	}

	public double blend_input(long input_index, double time, boolean seek, boolean is_external_seeking, double blend,
			int filter, boolean sync, boolean test_only) {
		return (double) super.call("blend_input",
				new java.lang.Object[]{java.lang.Long.valueOf(input_index), java.lang.Double.valueOf(time),
						java.lang.Boolean.valueOf(seek), java.lang.Boolean.valueOf(is_external_seeking),
						java.lang.Double.valueOf(blend), java.lang.Integer.valueOf(filter),
						java.lang.Boolean.valueOf(sync), java.lang.Boolean.valueOf(test_only)});
	}

	public void set_parameter(String name, Object value) {
		super.call("set_parameter", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) value});
	}

	public Object get_parameter(String name) {
		return (Object) super.call("get_parameter", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean isFilter_enabled() {
		return (boolean) super.call("is_filter_enabled", new java.lang.Object[0]);
	}

	public void setFilter_enabled(boolean value) {
		super.call("set_filter_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public GodotArray getFilters() {
		return (GodotArray) super.call("_get_filters", new java.lang.Object[0]);
	}

	public void setFilters(GodotArray value) {
		super.call("_set_filters", new java.lang.Object[]{(java.lang.Object) value});
	}
}
