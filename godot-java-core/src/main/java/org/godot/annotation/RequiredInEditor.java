package org.godot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/// Marks an exported field as required in the Godot editor.
///
/// When used on a field annotated with `@Export`, the field will be checked
/// during editor configuration validation. If the field value is null or
/// default, a configuration warning will appear in the Godot Inspector.
///
/// Requires the class to be annotated with `@Tool` or `@EditorPlugin`.
///
/// Usage:
/// ```java
/// @GodotClass(name = "Baker", parent = "Node")
/// @Tool
/// public class Baker extends Node {
///     @RequiredInEditor
///     @Export
///     public Texture2D bakeTexture;
/// }
/// ```
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface RequiredInEditor {

	/// Custom warning message shown when the field is not set.
	/// Defaults to "Property '{name}' is required."
	String value() default "";
}
