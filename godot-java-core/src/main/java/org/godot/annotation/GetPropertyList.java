package org.godot.annotation;

import java.lang.annotation.*;

/// Marks a method as a dynamic property list provider. Called by Godot to
/// discover properties beyond those declared with `@Export`.
///
/// Method signature: `Object[] _getPropertyList()`
///
/// Each element should be a `GodotDictionary` with keys: `"name"`,
/// `"type"`, `"hint"`, `"hint_string"`, `"usage"`.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GetPropertyList {
}
