package org.godot.annotation;

import java.lang.annotation.*;

/**
 * Marks a class as a Godot extension class. The class will be registered to
 * Godot's ClassDB at startup.
 *
 * <p>
 * Example:
 *
 * <pre>
 * &#64;GodotClass(name = "MyPlayer", parent = "CharacterBody2D")
 * public class MyPlayer extends CharacterBody2D {
 * }
 * </pre>
 *
 * <p>
 * Elements:
 * <ul>
 * <li>{@code name} - Godot class name (e.g., "Player")</li>
 * <li>{@code parent} - Parent class name in Godot (e.g., "CharacterBody2D"),
 * defaults to "RefCounted"</li>
 * </ul>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface GodotClass {
	String name();

	String parent() default "RefCounted";
}
