package org.godot.exception;

/**
 * Thrown when a Godot API call is made from a non-main thread. Godot's engine
 * is single-threaded; all API calls must happen on the thread where GDExtension
 * was initialized.
 */
public class GodotThreadException extends GodotException {

	private final String threadName;

	public GodotThreadException(String message, String threadName) {
		super(message);
		this.threadName = threadName;
	}

	public String getThreadName() {
		return threadName;
	}
}
