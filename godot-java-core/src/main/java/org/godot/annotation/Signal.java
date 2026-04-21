package org.godot.annotation;

import java.lang.annotation.*;

/**
 * Declares a Godot signal on the annotated method. The method signature defines
 * the signal arguments.
 *
 * <p>
 * Example:
 *
 * <pre>
 * &#64;GodotClass(name = "MyNode", parent = "Node2D")
 * public class MyNode extends Node2D {
 * 	&#64;Signal
 * 	public void playerDied(int playerId) {
 * 	}
 * }
 * </pre>
 *
 * <p>
 * Emit with {@code call("emit_signal", "playerDied", playerId)}.
 *
 * <p>
 * Elements:
 * <ul>
 * <li>{@code name} - Signal name (defaults to method name)</li>
 * </ul>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Signal {
	String name() default "";
}
