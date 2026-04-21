package org.godot.internal;

import org.godot.exception.GodotThreadException;

/**
 * Enforces that Godot API calls happen on the main thread.
 *
 * Godot's engine is single-threaded; calling API functions from a background
 * thread causes undefined behavior (crashes, corruption). This utility records
 * the main thread ID during initialization and validates every
 * {@link org.godot.bridge.Bridge} call.
 *
 * Thread checking can be disabled via the system property
 * {@code godot.java.threadCheck=false} (useful for debugging or when you know a
 * specific call is safe).
 */
public final class ThreadChecker {

	private ThreadChecker() {
	}

	/** Thread ID of the thread where GDExtension was initialized. */
	private static volatile long mainThreadId = -1;

	/** Whether thread checking is enabled. Defaults to true. */
	private static volatile boolean enabled = true;

	static {
		String prop = System.getProperty("godot.java.threadCheck", "true");
		enabled = !"false".equalsIgnoreCase(prop);
	}

	/**
	 * Record the current thread as the main Godot thread. Called once during
	 * GDExtension initialization.
	 */
	public static void recordMainThread() {
		mainThreadId = Thread.currentThread().threadId();
	}

	/**
	 * Get the recorded main thread ID, or -1 if not yet initialized.
	 */
	public static long getMainThreadId() {
		return mainThreadId;
	}

	/**
	 * Check that the current thread is the main Godot thread. Throws
	 * {@link GodotThreadException} if called from a background thread.
	 */
	public static void ensureMainThread() {
		if (!enabled) {
			return;
		}
		if (mainThreadId == -1) {
			// Not yet initialized, skip check
			return;
		}
		long currentId = Thread.currentThread().threadId();
		if (currentId != mainThreadId) {
			throw new GodotThreadException("Godot API called from non-main thread '" + Thread.currentThread().getName()
					+ "' (threadId=" + currentId + ", mainThreadId=" + mainThreadId + ")",
					Thread.currentThread().getName());
		}
	}

	/**
	 * Check if the current thread is the main Godot thread.
	 */
	public static boolean isMainThread() {
		if (mainThreadId == -1) {
			return true;
		}
		return Thread.currentThread().threadId() == mainThreadId;
	}

	/**
	 * Enable or disable thread checking at runtime.
	 */
	public static void setEnabled(boolean value) {
		enabled = value;
	}

	/**
	 * Check if thread checking is currently enabled.
	 */
	public static boolean isEnabled() {
		return enabled;
	}
}
