package org.godot.annotation;

import java.lang.annotation.*;

/**
 * Marks a field for automatic initialization before _ready(). Supports three
 * modes: NEW (default constructor), NODE (scene tree path), MANUAL.
 *
 * <p>
 * Example usage:
 *
 * <pre>
 * // Load node from scene tree
 * &#64;OnReady(node = "UI/HealthBar")
 * private ProgressBar healthBar;
 *
 * // Manual initialization
 * &#64;OnReady(mode = OnReadyMode.MANUAL)
 * private Node target;
 * </pre>
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface OnReady {
	/**
	 * Scene tree node path (relative to this node). Only used with NODE mode. If
	 * set, mode defaults to NODE automatically.
	 */
	String node() default "";

	/**
	 * Initialization mode. Defaults to NEW if node is empty, NODE if node is set.
	 */
	OnReadyMode mode() default OnReadyMode.NEW;
}
