package org.godot.internal;

/**
 * Configurable debug logging for godot-java internals.
 *
 * Enable via system properties:
 * <ul>
 * <li>{@code godot.java.debug.bridge=true} — log Bridge API calls</li>
 * <li>{@code godot.java.debug.virtual=true} — log virtual method dispatch</li>
 * </ul>
 *
 * All output goes to stderr for minimal overhead (no logging framework
 * dependency).
 */
public final class DebugLogger {

	private DebugLogger() {
	}

	private static final boolean DEBUG_BRIDGE = "true".equalsIgnoreCase(System.getProperty("godot.java.debug.bridge"));
	private static final boolean DEBUG_VIRTUAL = "true"
			.equalsIgnoreCase(System.getProperty("godot.java.debug.virtual"));

	public static boolean isBridgeDebugEnabled() {
		return DEBUG_BRIDGE;
	}

	public static boolean isVirtualDebugEnabled() {
		return DEBUG_VIRTUAL;
	}

	/**
	 * Log a Bridge API call. Only outputs if {@code godot.java.debug.bridge=true}.
	 */
	public static void logBridge(String apiName, String method, long elapsedNanos) {
		if (DEBUG_BRIDGE) {
			System.err.println("[godot-java:bridge] " + apiName + " via " + method + " in " + elapsedNanos + "ns");
		}
	}

	/**
	 * Log a virtual method dispatch. Only outputs if
	 * {@code godot.java.debug.virtual=true}.
	 */
	public static void logVirtual(String className, String methodName, boolean hit) {
		if (DEBUG_VIRTUAL) {
			System.err.println("[godot-java:virtual] " + className + "." + methodName + " (stub=" + hit + ")");
		}
	}

	/**
	 * Log a general debug message.
	 */
	public static void log(String tag, String message) {
		System.err.println("[godot-java:" + tag + "] " + message);
	}
}
