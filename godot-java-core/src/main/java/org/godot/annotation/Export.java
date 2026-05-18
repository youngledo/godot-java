package org.godot.annotation;

import java.lang.annotation.*;

/**
 * Exports a field as a Godot property, visible in the editor. The field type
 * must be convertible to/from a Godot Variant.
 *
 * <p>
 * Supports custom getter/setter methods and read-only properties:
 *
 * <pre>
 * &#64;Export(getter = "getHealth", setter = "setHealth")
 * private int health = 100;
 *
 * &#64;Export(readOnly = true)
 * private String label = "Hello";
 *
 * public int getHealth() {
 * 	return health;
 * }
 * public void setHealth(int v) {
 * 	health = Math.max(0, v);
 * }
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Export {
	String propertyName() default "";

	PropertyHint hint() default PropertyHint.NONE;

	String hintString() default "";

	PropertyUsage usage() default PropertyUsage.DEFAULT;

	/**
	 * Name of a public method to use as the property getter. Empty string (default)
	 * means direct field access via VarHandle.
	 */
	String getter() default "";

	/**
	 * Name of a public method to use as the property setter. Empty string (default)
	 * means direct field access via VarHandle. Ignored when
	 * {@code readOnly = true}.
	 */
	String setter() default "";

	/**
	 * If true, the property is read-only in the editor. Equivalent to
	 * {@code usage = PropertyUsage.EDITOR_READ_ONLY}. Implies no setter.
	 */
	boolean readOnly() default false;

	/// Default value for property revert in the editor.
	/// Used by the Inspector's "Revert" button. Must be a string representation
	/// of the default value. Empty string means no explicit revert value
	/// (falls back to fresh instance defaults).
	String defaultValue() default "";
}
