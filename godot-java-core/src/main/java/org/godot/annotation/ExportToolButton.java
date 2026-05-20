package org.godot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/// Marks a void method as an editor tool button. The method appears as a
/// clickable button in the Godot Inspector when the class has `@Tool`.
///
/// Usage:
/// ```java
/// @GodotClass(name = "Baker", parent = "Node")
/// @Tool
/// public class Baker extends Node {
///     @ExportToolButton("Bake NavMesh")
///     public void bakeNavMesh() { ... }
/// }
/// ```
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExportToolButton {

	/// Button text shown in the Inspector.
	String value();
}
