package org.godot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/// Marks a method as a property validator.
///
/// Called by Godot when the editor needs to validate a property value.
/// Method signature: `boolean _validateProperty(String propertyName, long propertyInfoPtr)`
/// Return `true` if the property is valid. You can modify `propertyInfo` to adjust hints.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ValidateProperty {
}
