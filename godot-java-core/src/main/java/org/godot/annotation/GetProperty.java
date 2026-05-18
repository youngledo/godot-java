package org.godot.annotation;

import java.lang.annotation.*;

/// Marks a method as a dynamic property getter. Called by Godot when accessing a
/// property not declared with `@Export`.
///
/// Method signature: `Object _getProperty(String propertyName)`
///
/// Return the property value, or `null` if the property is not recognized.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GetProperty {
}
