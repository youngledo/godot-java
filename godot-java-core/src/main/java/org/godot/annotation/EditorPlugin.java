package org.godot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/// Marks a @GodotClass as a Godot editor plugin.
/// The class should have @Tool annotation and @GodotClass(parent = "EditorPlugin").
/// Editor plugins are auto-registered when the extension loads in the editor.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EditorPlugin {
	/// Plugin name shown in the editor's Plugin dialog.
	String value() default "";
}
