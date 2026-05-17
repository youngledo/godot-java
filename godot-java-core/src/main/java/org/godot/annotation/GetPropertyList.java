package org.godot.annotation;

import java.lang.annotation.*;

/**
 * Marks a method as a dynamic property list provider. Called by Godot to
 * discover properties beyond those declared with {@code @Export}.
 *
 * <p>
 * Method signature: {@code Object[] _getPropertyList()}
 *
 * <p>
 * Each element should be a {@code GodotDictionary} with keys: {@code "name"},
 * {@code "type"}, {@code "hint"}, {@code "hint_string"}, {@code "usage"}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GetPropertyList {
}
