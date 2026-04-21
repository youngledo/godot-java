package org.godot.annotation;

/**
 * Godot property hint constants, matching {@code PropertyHint} in
 * {@code extension_api.json}.
 *
 * <p>
 * Used with {@link Export#hint()} to control how the editor displays a
 * property.
 */
public enum PropertyHint {
	NONE(0), RANGE(1), RANGE_STEP(2), ENUM(3), ENUM_SUGGESTION(4), EXP_EASING(5), LINK(6), FLAGS(7), LAYERS_2D_RENDER(
			8), LAYERS_2D_PHYSICS(9), LAYERS_2D_NAVIGATION(10), LAYERS_3D_RENDER(11), LAYERS_3D_PHYSICS(
					12), LAYERS_3D_NAVIGATION(13), FILE(14), DIR(15), GLOBAL_FILE(16), GLOBAL_DIR(17), RESOURCE_TYPE(
							18), MULTILINE_TEXT(19), EXPRESSION(20), PLACEHOLDER_TEXT(21), COLOR_NO_ALPHA(
									22), OBJECT_ID(23), TYPE_STRING(24), NODE_PATH_VALID_TYPES(25), SAVE_FILE(
											26), GLOBAL_SAVE_FILE(27), INT_IS_OBJECTID(28), INT_IS_POINTER(
													29), ARRAY_TYPE(30), LOCALE_ID(31), LOCALIZABLE_STRING(
															32), NODE_TYPE(33), HIDE_QUATERNION_COMPONENT(34), PASSWORD(
																	35), LAYERS_AVOIDANCE(37), ARRAY(38), MAX(39);

	private final int id;

	PropertyHint(int id) {
		this.id = id;
	}

	public int id() {
		return id;
	}
}
