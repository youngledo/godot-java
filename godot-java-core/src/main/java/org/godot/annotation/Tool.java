package org.godot.annotation;

import java.lang.annotation.*;

/**
 * Marks a {@link GodotClass}-annotated class as a tool class, allowing its
 * virtual callbacks (such as {@code _ready}, {@code _process}) to execute in
 * the Godot editor.
 *
 * <p>
 * Without this annotation, virtual callbacks are suppressed when
 * {@code Engine.isEditorHint()} returns true. This prevents unnecessary work in
 * the editor for classes that only matter at runtime.
 *
 * <p>
 * Mirrors gdext's {@code #[class(tool)]} attribute.
 *
 * <p>
 * Example:
 *
 * <pre>
 * &#64;Tool
 * &#64;GodotClass(name = "MyGizmo", parent = "Node3D")
 * public class MyGizmo extends Node3D {
 * 	&#64;Override
 * 	public void _process(double delta) {
 * 		// Runs in the editor
 * 	}
 * }
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Tool {
}
