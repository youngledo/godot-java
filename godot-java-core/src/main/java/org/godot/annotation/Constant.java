package org.godot.annotation;

import java.lang.annotation.*;

/**
 * Marks a public static final int/long field as a Godot integer constant. The
 * constant will be registered via
 * classdb_register_extension_class_integer_constant.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface Constant {
}
