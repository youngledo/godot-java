package org.godot.exception;

/**
 * Thrown when a Godot API call fails (null pointer, invalid argument, engine
 * error).
 */
public class GodotApiException extends GodotException {

	private final String apiName;

	public GodotApiException(String apiName, String message) {
		super(apiName + ": " + message);
		this.apiName = apiName;
	}

	public GodotApiException(String apiName, String message, Throwable cause) {
		super(apiName + ": " + message, cause);
		this.apiName = apiName;
	}

	public String getApiName() {
		return apiName;
	}
}
