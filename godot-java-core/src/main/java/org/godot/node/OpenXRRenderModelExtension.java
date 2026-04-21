package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;

public class OpenXRRenderModelExtension extends OpenXRExtensionWrapper {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_active", 36873697L),
			java.util.Map.entry("render_model_get_animatable_node_name", 1464764419L),
			java.util.Map.entry("render_model_get_all", 2915620761L),
			java.util.Map.entry("render_model_new_scene_instance", 788010739L),
			java.util.Map.entry("render_model_get_animatable_node_count", 2198884583L),
			java.util.Map.entry("render_model_get_subaction_paths", 2801473409L),
			java.util.Map.entry("render_model_create", 937000113L),
			java.util.Map.entry("render_model_is_animatable_node_visible", 3120086654L),
			java.util.Map.entry("render_model_get_animatable_node_transform", 1050775521L),
			java.util.Map.entry("render_model_get_root_transform", 1128465797L),
			java.util.Map.entry("render_model_destroy", 2722037293L),
			java.util.Map.entry("render_model_get_top_level_path", 642473191L),
			java.util.Map.entry("render_model_get_confidence", 2350330949L));

	OpenXRRenderModelExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRRenderModelExtension(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_active() {
		return (boolean) super.call("is_active");
	}

	public long render_model_create(long render_model_id) {
		return (long) super.call("render_model_create",
				new java.lang.Object[]{java.lang.Long.valueOf(render_model_id)});
	}

	public void render_model_destroy(long render_model) {
		super.call("render_model_destroy", new java.lang.Object[]{java.lang.Long.valueOf(render_model)});
	}

	public long[] render_model_get_all() {
		return (long[]) super.call("render_model_get_all");
	}

	public Node3D render_model_new_scene_instance(long render_model) {
		return (Node3D) super.call("render_model_new_scene_instance",
				new java.lang.Object[]{java.lang.Long.valueOf(render_model)});
	}

	public String[] render_model_get_subaction_paths(long render_model) {
		return (String[]) super.call("render_model_get_subaction_paths",
				new java.lang.Object[]{java.lang.Long.valueOf(render_model)});
	}

	public String render_model_get_top_level_path(long render_model) {
		return (String) super.call("render_model_get_top_level_path",
				new java.lang.Object[]{java.lang.Long.valueOf(render_model)});
	}

	public int render_model_get_confidence(long render_model) {
		return (int) super.call("render_model_get_confidence",
				new java.lang.Object[]{java.lang.Long.valueOf(render_model)});
	}

	public Transform3D render_model_get_root_transform(long render_model) {
		return (Transform3D) super.call("render_model_get_root_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(render_model)});
	}

	public long render_model_get_animatable_node_count(long render_model) {
		return (long) super.call("render_model_get_animatable_node_count",
				new java.lang.Object[]{java.lang.Long.valueOf(render_model)});
	}

	public String render_model_get_animatable_node_name(long render_model, long index) {
		return (String) super.call("render_model_get_animatable_node_name",
				new java.lang.Object[]{java.lang.Long.valueOf(render_model), java.lang.Long.valueOf(index)});
	}

	public boolean render_model_is_animatable_node_visible(long render_model, long index) {
		return (boolean) super.call("render_model_is_animatable_node_visible",
				new java.lang.Object[]{java.lang.Long.valueOf(render_model), java.lang.Long.valueOf(index)});
	}

	public Transform3D render_model_get_animatable_node_transform(long render_model, long index) {
		return (Transform3D) super.call("render_model_get_animatable_node_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(render_model), java.lang.Long.valueOf(index)});
	}
}
