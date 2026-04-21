package org.godot.exception;

/**
 * Thrown when trying to use a Java wrapper for a Godot object that has been
 * freed or is otherwise invalid.
 */
public class GodotInvalidObjectException extends GodotException {

	public GodotInvalidObjectException(String message) {
		super(message);
	}
}
