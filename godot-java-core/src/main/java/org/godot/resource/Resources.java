package org.godot.resource;

import org.godot.Godot;
import org.godot.singleton.ResourceLoader;
import org.godot.singleton.ResourceSaver;

/// Typed resource load/save utilities wrapping generated ResourceLoader and
/// ResourceSaver singletons.
///
/// Usage:
///   Texture2D tex = Resources.load("res://icon.svg", Texture2D.class);
///   Resources.save(myResource, "res://data/save.tres");
public final class Resources {

	private Resources() {
	}

	/// Load a resource at the given path, cast to the expected type.
	/// Returns null if the resource doesn't exist or the type doesn't match.
	@SuppressWarnings("unchecked")
	public static <T extends Godot> T load(String path, Class<T> type) {
		Object result = ResourceLoader.singleton().call("load", path);
		if (result == null)
			return null;
		return Godot.as((Godot) result, type);
	}

	/// Load a resource with a type hint for faster lookup.
	public static <T extends Godot> T load(String path, Class<T> type, String typeHint) {
		Object result = ResourceLoader.singleton().call("load", path, typeHint);
		if (result == null)
			return null;
		return Godot.as((Godot) result, type);
	}

	/// Load a resource with cache mode control.
	/// cacheMode: 0 = ignore cache, 1 = use/update cache, 2 = use only.
	public static <T extends Godot> T load(String path, Class<T> type, String typeHint, int cacheMode) {
		Object result = ResourceLoader.singleton().call("load", path, typeHint, cacheMode);
		if (result == null)
			return null;
		return Godot.as((Godot) result, type);
	}

	/// Check whether a resource exists at the given path.
	public static boolean exists(String path) {
		Object result = ResourceLoader.singleton().call("exists", path);
		if (result instanceof Boolean b)
			return b;
		if (result instanceof Number n)
			return n.intValue() != 0;
		return false;
	}

	/// Check whether a resource exists with a type hint.
	public static boolean exists(String path, String typeHint) {
		Object result = ResourceLoader.singleton().call("exists", path, typeHint);
		if (result instanceof Boolean b)
			return b;
		if (result instanceof Number n)
			return n.intValue() != 0;
		return false;
	}

	/// Save a resource to the given path.
	/// Returns true on success.
	public static boolean save(Godot resource, String path) {
		Object result = ResourceSaver.singleton().call("save", resource, path);
		if (result instanceof Number n)
			return n.intValue() == 0;
		return false;
	}

	/// Save a resource with flags.
	/// flags: 1 = relative, 2 = bundle_resources, 4 = change_path, 8 = omit_editor_properties,
	///        16 = merge_with_existing, 32 = replace_subresource_paths.
	public static boolean save(Godot resource, String path, int flags) {
		Object result = ResourceSaver.singleton().call("save", resource, path, flags);
		if (result instanceof Number n)
			return n.intValue() == 0;
		return false;
	}
}
