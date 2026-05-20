package org.godot.annotation;

/// Initialization level for Godot class registration.
/// Controls when a class is registered with ClassDB during engine startup.
public enum InitLevel {
	CORE, SERVERS, SCENE, EDITOR
}
