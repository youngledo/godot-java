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
 *
 * After {@link #shutdown()} (engine deinitialization), new tasks are dropped
 * and parked coroutines are cancelled — deferred work must not execute while
 * the engine tears down, against freed objects.
 */
public final class DeferredExecutor {

	private DeferredExecutor() {
	}

	private static final ConcurrentLinkedQueue<Runnable> QUEUE = new ConcurrentLinkedQueue<>();
	private static volatile boolean shutdown;

	/**
	 * Schedule a task for execution on the main thread. Safe to call from any
	 * thread. Dropped after {@link #shutdown()}.
	 *
	 * @param task
	 *            The task to execute on the main thread
	 */
	public static void callDeferred(Runnable task) {
		if (task == null) {
			return;
		}
		if (shutdown) {
			System.err.println("[godot-java] Deferred task dropped after shutdown: " + task);
			return;
		}
		QUEUE.add(task);
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
		count += org.godot.coroutine.GodotScope.flush();
		return count;
	}

	/**
	 * Stop accepting and executing deferred tasks, drop everything still queued,
	 * and cancel parked coroutines. Called once at engine deinitialization.
	 */
	public static void shutdown() {
		shutdown = true;
		int dropped = 0;
		while (QUEUE.poll() != null) {
			dropped++;
		}
		if (dropped > 0) {
			System.err.println("[godot-java] Dropped " + dropped + " deferred task(s) at shutdown");
		}
		org.godot.coroutine.GodotScope.shutdown();
	}

	/** Whether {@link #shutdown()} has been called. */
	public static boolean isShutdown() {
		return shutdown;
	}

	/**
	 * Get the number of pending deferred tasks.
	 */
	public static int pendingCount() {
		return QUEUE.size();
	}

	/** Test hook: re-enable deferral after a {@link #shutdown()} call. */
	static void resetForTesting() {
		shutdown = false;
		QUEUE.clear();
	}
}
