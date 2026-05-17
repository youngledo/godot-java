package org.godot.annotation;

import java.lang.annotation.*;

/**
 * Marks a method as a dynamic property setter. Called by Godot when setting a
 * property not declared with {@code @Export}.
 *
 * <p>
 * Method signature:
 * {@code boolean _setProperty(String propertyName, Object value)}
 *
 * <p>
 * Return {@code true} if the property was handled, {@code false} otherwise.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SetProperty {
}
