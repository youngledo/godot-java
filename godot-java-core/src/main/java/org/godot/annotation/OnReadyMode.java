package org.godot.annotation;

/** Initialization mode for @OnReady fields. */
public enum OnReadyMode {
	/** Initialize by calling the default constructor. */
	NEW,
	/** Initialize by loading a node from the scene tree (requires node path). */
	NODE,
	/** Manual initialization -- call init() before _ready(). */
	MANUAL
}
