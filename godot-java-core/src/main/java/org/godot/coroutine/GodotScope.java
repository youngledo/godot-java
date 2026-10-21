package org.godot.coroutine;

import org.godot.Godot;
import org.godot.bridge.Bridge;
import org.godot.bridge.CallableDispatch;
import org.godot.core.Callable;
import org.godot.core.NativeCallable;
import org.godot.internal.api.ApiIndex;
import org.godot.signal.ConnectFlags;
import java.lang.foreign.MemorySegment;
import java.time.Duration;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;
import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

/// Virtual Thread scope integrated with Godot's single-threaded execution model.
///
/// Launches Virtual Threads that can suspend on signals and delays. All Godot
/// API calls within a coroutine execute on the main thread via `flush()`,
/// which should be called each frame from `_process()`.
///
/// At engine shutdown, {@link #shutdown()} cancels every parked coroutine with
/// a {@link CancellationException}, so coroutines waiting on a signal whose
/// emitter is being freed do not park forever.
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

	/** Threads parked in await()/delay(); unparked by shutdown(). */
	private static final ConcurrentLinkedQueue<Thread> PARKED = new ConcurrentLinkedQueue<>();

	private static volatile boolean shutdown;

	/// A handle that can be awaited and fired. Represents a single-shot signal
	/// for coroutine synchronization.
	public static final class SignalHandle {
		private volatile Thread waiter;
		private volatile Object[] args;

		/// Park the current thread until `fire()` is called, or until the scope is
		/// shut down (throws {@link CancellationException}).
		public void await() {
			Thread current = Thread.currentThread();
			waiter = current;
			PARKED.add(current);
			try {
				LockSupport.park(this);
			} finally {
				PARKED.remove(current);
				waiter = null;
			}
			if (shutdown && args == null) {
				throw new CancellationException("godot-java: coroutine cancelled at engine shutdown");
			}
		}

		/// Park the current thread until `fire()` is called or the timeout elapses.
		/// Returns the signal arguments if fired, or null if timed out.
		public Object[] await(Duration timeout) {
			Thread current = Thread.currentThread();
			waiter = current;
			PARKED.add(current);
			try {
				LockSupport.parkNanos(timeout.toNanos());
			} finally {
				PARKED.remove(current);
				waiter = null;
			}
			if (shutdown && args == null) {
				throw new CancellationException("godot-java: coroutine cancelled at engine shutdown");
			}
			return args;
		}

		/// Wake the thread waiting on this signal.
		public void fire() {
			fire(new Object[0]);
		}

		/// Wake the thread waiting on this signal with arguments.
		public void fire(Object... signalArgs) {
			Thread w = waiter;
			if (w != null) {
				this.args = signalArgs;
				RESUMABLE.add(w);
				waiter = null;
			}
		}

		/// Get the signal arguments from the last fire().
		public Object[] args() {
			return args;
		}
	}

	/// Launch a Virtual Thread that will execute the given task. The task can
	/// call `delay(double)` or `SignalHandle.await()` to suspend.
	/// Resumes happen during `flush()` on the main thread.
	public static void launch(Runnable task) {
		Thread.ofVirtual().name("godot-coroutine").start(() -> {
			try {
				task.run();
			} catch (CancellationException e) {
				// Expected at engine shutdown — the coroutine's awaited signal or
				// delay was cancelled.
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
		PARKED.add(current);
		try {
			LockSupport.park();
		} finally {
			PARKED.remove(current);
		}
		if (shutdown) {
			throw new CancellationException("godot-java: coroutine cancelled at engine shutdown");
		}
	}

	/// Await a signal on a Godot object. Connects a one-shot native callable,
	/// parks the current coroutine, and resumes when the signal fires.
	/// Returns the signal arguments, or an empty array if the signal has no args.
	/// Must be called from a coroutine launched via `launch()`.
	public static Object[] awaitSignal(Godot source, String signalName) {
		SignalHandle handle = new SignalHandle();
		NativeCallable nc = createSignalCallable(handle);
		Callable callable = new Callable(nc);
		source.connect(signalName, callable, ConnectFlags.ONE_SHOT);
		handle.await();
		nc.free();
		return handle.args();
	}

	/// Await a signal with a timeout. Disconnects on timeout.
	/// Returns the signal arguments if fired, or null if timed out.
	public static Object[] awaitSignal(Godot source, String signalName, Duration timeout) {
		SignalHandle handle = new SignalHandle();
		NativeCallable nc = createSignalCallable(handle);
		Callable callable = new Callable(nc);
		source.connect(signalName, callable, ConnectFlags.ONE_SHOT);
		Object[] result = handle.await(timeout);
		if (result == null) {
			source.disconnect(signalName, callable);
		}
		nc.free();
		return result;
	}

	/// Create a NativeCallable that fires a SignalHandle when invoked.
	private static NativeCallable createSignalCallable(SignalHandle handle) {
		long key = CallableDispatch.registerLambdaCallable(() -> handle.fire());
		MemorySegment callableSeg = Bridge.allocate(Callable.NATIVE_SIZE);
		MemorySegment infoSeg = Bridge.allocate(NativeCallable.INFO_SIZE);
		infoSeg.set(ADDRESS, 0, MemorySegment.ofAddress(key));
		infoSeg.set(ADDRESS, 8, MemorySegment.ofAddress(Bridge.libraryPtr()));
		infoSeg.set(JAVA_LONG, 16, 0L);
		infoSeg.set(ADDRESS, 24, CallableDispatch.getCallStub());
		infoSeg.set(ADDRESS, 32, CallableDispatch.getIsValidStub());
		infoSeg.set(ADDRESS, 40, CallableDispatch.getFreeStub());
		for (int off = 48; off < 88; off += 8) {
			infoSeg.set(ADDRESS, off, MemorySegment.ofAddress(0));
		}
		Bridge.callVoid(ApiIndex.CALLABLE_CUSTOM_CREATE2, callableSeg, infoSeg);
		return new NativeCallable(callableSeg, key);
	}

	/// Cancel every parked coroutine (engine shutdown). Coroutines suspended in
	/// `delay()` or `SignalHandle.await()` resume with a
	/// {@link CancellationException}.
	public static void shutdown() {
		shutdown = true;
		int cancelled = 0;
		Thread t;
		while ((t = PARKED.poll()) != null) {
			LockSupport.unpark(t);
			cancelled++;
		}
		if (cancelled > 0) {
			System.err.println("[godot-java] Cancelled " + cancelled + " coroutine(s) at shutdown");
		}
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

	/** Test hook: clear shutdown state after a {@link #shutdown()} call. */
	static void resetForTesting() {
		shutdown = false;
		PARKED.clear();
	}
}
