package org.godot.annotation;

import java.lang.annotation.*;

/**
 * Marks a method as callable from Godot. Methods without this annotation are
 * not exposed to the Godot engine.
 *
 * <pre>
 * {@code
 * &#64;GodotClass(name = "MyNode", parent = "Node2D")
 * public class MyNode extends Node2D {
 *     // Exposed to Godot
 *     &#64;GodotMethod
 *     public void takeDamage(int amount) { ... }
 *
 *     // NOT exposed (no annotation)
 *     public void internalHelper() { ... }
 * }
 * }
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GodotMethod {
	/** Godot-side method name. Empty means use the Java method name. */
	String value() default "";
}
