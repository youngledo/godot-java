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
		private volatile Object[] args;

		/// Park the current thread until `fire()` is called.
		public void await() {
			waiter = Thread.currentThread();
			LockSupport.park(this);
		}

		/// Park the current thread until `fire()` is called or the timeout elapses.
		/// Returns the signal arguments if fired, or null if timed out.
		public Object[] await(Duration timeout) {
			waiter = Thread.currentThread();
			LockSupport.parkNanos(timeout.toNanos());
			waiter = null;
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

	/// Await a signal on a Godot object. Connects a one-shot native callable,
	/// parks the current coroutine, and resumes when the signal fires.
	/// Must be called from a coroutine launched via `launch()`.
	public static void awaitSignal(Godot source, String signalName) {
		SignalHandle handle = new SignalHandle();
		NativeCallable nc = createSignalCallable(handle);
		Callable callable = new Callable(nc);
		source.connect(signalName, callable, ConnectFlags.ONE_SHOT);
		handle.await();
		nc.free();
	}

	/// Await a signal with a timeout. Disconnects on timeout.
	/// Returns true if the signal fired, false if timed out.
	public static boolean awaitSignal(Godot source, String signalName, Duration timeout) {
		SignalHandle handle = new SignalHandle();
		NativeCallable nc = createSignalCallable(handle);
		Callable callable = new Callable(nc);
		source.connect(signalName, callable, ConnectFlags.ONE_SHOT);
		Object[] result = handle.await(timeout);
		if (result == null) {
			source.disconnect(signalName, callable);
		}
		nc.free();
		return result != null;
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
		for (int off = 32; off < 88; off += 8) {
			infoSeg.set(ADDRESS, off, MemorySegment.ofAddress(0));
		}
		Bridge.callVoid(ApiIndex.CALLABLE_CUSTOM_CREATE2, callableSeg, infoSeg);
		return new NativeCallable(callableSeg, key);
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
