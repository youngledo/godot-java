package org.godot.coroutine;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

/// Virtual Thread scope integrated with Godot's single-threaded execution model.
///
/// Launches Virtual Threads that can suspend on signals and delays. All Godot
/// API calls within a coroutine execute on the main thread via `flush()`,
/// which should be called each frame from `_process()`.
///
/// Usage:
/// ```java
/// GodotScope.launch(() -> {
///     GodotScope.delay(2.0);
///     player.emitSignal("timeout");
/// });
/// ```
public final class GodotScope {

	private GodotScope() {
	}

	private static final ConcurrentLinkedQueue<Thread> RESUMABLE = new ConcurrentLinkedQueue<>();

	/// A handle that can be awaited and fired. Represents a single-shot signal
	/// for coroutine synchronization.
	public static final class SignalHandle {
		private volatile Thread waiter;

		/// Park the current thread until `fire()` is called.
		public void await() {
			waiter = Thread.currentThread();
			LockSupport.park(this);
		}

		/// Wake the thread waiting on this signal.
		public void fire() {
			Thread w = waiter;
			if (w != null) {
				RESUMABLE.add(w);
				waiter = null;
			}
		}
	}

	/// Launch a Virtual Thread that will execute the given task. The task can
	/// call `delay(double)` or `SignalHandle.await()` to suspend.
	/// Resumes happen during `flush()` on the main thread.
	public static void launch(Runnable task) {
		Thread.ofVirtual().name("godot-coroutine").start(() -> {
			try {
				task.run();
			} catch (Exception e) {
				System.err.println("[godot-java] Coroutine failed: " + e.getMessage());
				e.printStackTrace();
			}
		});
	}

	/// Suspend the current coroutine for the given duration in seconds.
	public static void delay(double seconds) {
		long deadlineNanos = System.nanoTime() + (long) (seconds * 1_000_000_000);
		Thread current = Thread.currentThread();
		Thread.startVirtualThread(() -> {
			long remaining;
			while ((remaining = deadlineNanos - System.nanoTime()) > 0) {
				LockSupport.parkNanos(remaining);
			}
			RESUMABLE.add(current);
		});
		LockSupport.park();
	}

	/// Flush all resumable coroutines. Must be called on the main thread
	/// (from `_process` or similar tick). Returns the number of coroutines resumed.
	public static int flush() {
		int count = 0;
		Thread t;
		while ((t = RESUMABLE.poll()) != null) {
			LockSupport.unpark(t);
			count++;
		}
		return count;
	}

	/// Get the number of resumable coroutines waiting to be flushed.
	public static int pendingCount() {
		return RESUMABLE.size();
	}
}
