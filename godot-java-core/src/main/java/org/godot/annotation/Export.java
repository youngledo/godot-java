package org.godot.annotation;

import java.lang.annotation.*;

/**
 * Exports a field as a Godot property, visible in the editor. The field type
 * must be convertible to/from a Godot Variant.
 *
 * <p>
 * Example:
 *
 * <pre>
 * &#64;GodotClass(name = "MyNode", parent = "Node2D")
 * public class MyNode extends Node2D {
 * 	&#64;Export
 * 	private float speed = 300.0f;
 *
 * 	&#64;Export(hint = PropertyHint.RANGE, hintString = "0,100,1")
 * 	private int health = 100;
 * }
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Export {
	String propertyName() default "";

	PropertyHint hint() default PropertyHint.NONE;

	String hintString() default "";
}
