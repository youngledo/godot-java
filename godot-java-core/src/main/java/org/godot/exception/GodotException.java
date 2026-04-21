package org.godot.exception;

/**
 * Base exception for all godot-java runtime errors.
 */
public class GodotException extends RuntimeException {

	public GodotException(String message) {
		super(message);
	}

	public GodotException(String message, Throwable cause) {
		super(message, cause);
	}
}
