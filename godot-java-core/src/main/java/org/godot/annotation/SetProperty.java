package org.godot.annotation;

import java.lang.annotation.*;

/// Marks a method as a dynamic property setter. Called by Godot when setting a
/// property not declared with `@Export`.
///
/// Method signature: `boolean _setProperty(String propertyName, Object value)`
///
/// Return `true` if the property was handled, `false` otherwise.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SetProperty {
}
