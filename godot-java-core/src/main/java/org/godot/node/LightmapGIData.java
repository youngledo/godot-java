package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.math.Rect2;

public class LightmapGIData extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_lightmap_textures", 3995934104L), java.util.Map.entry("clear_users", 3218959716L),
			java.util.Map.entry("get_shadowmask_textures", 3995934104L),
			java.util.Map.entry("get_light_texture", 3984243839L),
			java.util.Map.entry("set_lightmap_textures", 381264803L),
			java.util.Map.entry("set_light_texture", 1278366092L), java.util.Map.entry("get_user_path", 408788394L),
			java.util.Map.entry("is_using_spherical_harmonics", 36873697L),
			java.util.Map.entry("set_shadowmask_textures", 381264803L),
			java.util.Map.entry("set_uses_spherical_harmonics", 2586408642L),
			java.util.Map.entry("add_user", 4272570515L), java.util.Map.entry("get_user_count", 3905245786L));

	LightmapGIData(MemorySegment nativePointer) {
		super(nativePointer);
	}

	LightmapGIData(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_using_spherical_harmonics() {
		return (boolean) super.call("is_using_spherical_harmonics");
	}

	public void add_user(String path, Rect2 uv_scale, long slice_index, long sub_instance) {
		super.call("add_user", new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) uv_scale,
				java.lang.Long.valueOf(slice_index), java.lang.Long.valueOf(sub_instance)});
	}

	public String get_user_path(long user_idx) {
		return (String) super.call("get_user_path", new java.lang.Object[]{java.lang.Long.valueOf(user_idx)});
	}

	public void clear_users() {
		super.call("clear_users");
	}

	public TextureLayered[] getLightmap_textures() {
		return (TextureLayered[]) super.call("get_lightmap_textures", new java.lang.Object[0]);
	}

	public void setLightmap_textures(TextureLayered[] value) {
		super.call("set_lightmap_textures", new java.lang.Object[]{(java.lang.Object) value});
	}

	public TextureLayered[] getShadowmask_textures() {
		return (TextureLayered[]) super.call("get_shadowmask_textures", new java.lang.Object[0]);
	}

	public void setShadowmask_textures(TextureLayered[] value) {
		super.call("set_shadowmask_textures", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isUses_spherical_harmonics() {
		return (boolean) super.call("is_using_spherical_harmonics", new java.lang.Object[0]);
	}

	public void setUses_spherical_harmonics(boolean value) {
		super.call("set_uses_spherical_harmonics", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public GodotArray getUser_data() {
		return (GodotArray) super.call("_get_user_data", new java.lang.Object[0]);
	}

	public void setUser_data(GodotArray value) {
		super.call("_set_user_data", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotDictionary getProbe_data() {
		return (GodotDictionary) super.call("_get_probe_data", new java.lang.Object[0]);
	}

	public void setProbe_data(GodotDictionary value) {
		super.call("_set_probe_data", new java.lang.Object[]{(java.lang.Object) value});
	}

	public TextureLayered getLight_texture() {
		return (TextureLayered) super.call("get_light_texture", new java.lang.Object[0]);
	}

	public void setLight_texture(TextureLayered value) {
		super.call("set_light_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getLight_textures() {
		return (GodotArray) super.call("_get_light_textures_data", new java.lang.Object[0]);
	}

	public void setLight_textures(GodotArray value) {
		super.call("_set_light_textures_data", new java.lang.Object[]{(java.lang.Object) value});
	}
}
