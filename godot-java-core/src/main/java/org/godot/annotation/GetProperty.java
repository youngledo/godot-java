package org.godot.annotation;

import java.lang.annotation.*;

/**
 * Marks a method as a dynamic property getter. Called by Godot when accessing a
 * property not declared with {@code @Export}.
 *
 * <p>
 * Method signature: {@code Object _getProperty(String propertyName)}
 *
 * <p>
 * Return the property value, or {@code null} if the property is not recognized.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GetProperty {
}
