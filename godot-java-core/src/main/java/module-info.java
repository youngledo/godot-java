/*
 * godot-java — Panama FFI binding for Godot 4.x (Java 25+)
 *
 * Module: org.godot
 *
 * Public API packages (exported for user code): - org.godot — Base class Godot
 * - org.godot.annotation — @GodotClass, @GodotMethod, @Export, @Signal -
 * org.godot.core — Variant, GodotStringName, GodotString - org.godot.node —
 * Node, Node2D (user extends these) - org.godot.math — Vector2, Vector3, etc. -
 * org.godot.collection — GodotArray, GodotDictionary - org.godot.registration —
 * Scanner (classpath scanning)
 *
 * Internal packages (not exported): - org.godot.bootstrap — C++ → Java
 * initialization entry point - org.godot.bridge — Panama FFI API bridge -
 * org.godot.internal — Internal utilities
 */
module org.godot {
	requires java.base;
	requires java.compiler;
	requires org.apache.logging.log4j;

	// Public API packages
	exports org.godot;
	exports org.godot.annotation;
	exports org.godot.core;
	exports org.godot.node;
	exports org.godot.math;
	exports org.godot.collection;
	exports org.godot.registration;
}
