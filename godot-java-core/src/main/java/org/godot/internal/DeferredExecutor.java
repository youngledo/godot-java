package org.godot.internal;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Executes {@link Runnable} tasks on the main Godot thread.
 *
 * Background threads can call {@link #callDeferred(Runnable)} to schedule work.
 * The tasks are executed in order during {@link #flush()}, which should be
 * called from the main thread (typically during {@code _process()} or a
 * dedicated tick).
 *
 * This is the Java-side equivalent of Godot's {@code call_deferred()}.
 */
public final class DeferredExecutor {

	private DeferredExecutor() {
	}

	private static final ConcurrentLinkedQueue<Runnable> QUEUE = new ConcurrentLinkedQueue<>();

	/**
	 * Schedule a task for execution on the main thread. Safe to call from any
	 * thread.
	 *
	 * @param task
	 *            The task to execute on the main thread
	 */
	public static void callDeferred(Runnable task) {
		if (task != null) {
			QUEUE.add(task);
		}
	}

	/**
	 * Execute all pending deferred tasks. Must be called on the main thread.
	 *
	 * @return the number of tasks executed
	 */
	public static int flush() {
		int count = 0;
		Runnable task;
		while ((task = QUEUE.poll()) != null) {
			try {
				task.run();
			} catch (Throwable t) {
				System.err.println("[godot-java] Deferred task failed: " + t.getMessage());
				t.printStackTrace();
			}
			count++;
		}
		return count;
	}

	/**
	 * Get the number of pending deferred tasks.
	 */
	public static int pendingCount() {
		return QUEUE.size();
	}
}
