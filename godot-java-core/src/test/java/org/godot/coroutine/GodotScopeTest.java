package org.godot.coroutine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BooleanSupplier;

class GodotScopeTest {

	/// Waits up to 5s for the condition. Fixed sleeps are not enough on loaded
	/// CI runners: virtual-thread scheduling can lag arbitrarily, so timing
	/// tests must poll instead of assuming wake-up slack.
	private static void awaitTrue(BooleanSupplier condition) throws InterruptedException {
		long deadline = System.currentTimeMillis() + 5_000;
		while (!condition.getAsBoolean() && System.currentTimeMillis() < deadline) {
			Thread.sleep(10);
		}
	}

	/// Like {@link #awaitTrue(BooleanSupplier)}, flushing the scope each round
	/// so coroutines woken by delay()/fire() get scheduled.
	private static void awaitFlushed(BooleanSupplier condition) throws InterruptedException {
		long deadline = System.currentTimeMillis() + 5_000;
		while (!condition.getAsBoolean() && System.currentTimeMillis() < deadline) {
			GodotScope.flush();
			Thread.sleep(10);
		}
	}

	@Test
	void launchRunsVirtualThread() throws InterruptedException {
		AtomicBoolean ran = new AtomicBoolean(false);
		GodotScope.launch(() -> {
			ran.set(true);
		});
		awaitTrue(ran::get);
		assertTrue(ran.get());
	}

	@Test
	void delaySuspendsAndResumes() throws InterruptedException {
		AtomicReference<String> state = new AtomicReference<>("started");
		final Thread[] coroutine = new Thread[1];
		GodotScope.launch(() -> {
			coroutine[0] = Thread.currentThread();
			state.set("before-delay");
			GodotScope.delay(0.05); // 50ms
			state.set("after-delay");
		});

		// Suspended: the coroutine reaches before-delay and stays there — without
		// a flush, delay() cannot return regardless of scheduler speed.
		awaitTrue(() -> "before-delay".equals(state.get()));
		assertEquals("before-delay", state.get());

		// Resumed: flush repeatedly until the waker's deadline passes and the
		// coroutine is scheduled again.
		awaitFlushed(() -> "after-delay".equals(state.get()));
		if (!"after-delay".equals(state.get())) {
			// Diagnostics for the resume failure observed on Temurin 25.0.5
			// Linux runners: distinguish "waker never enqueued the coroutine"
			// from "unpark does not wake it".
			String beforeProbe;
			Thread c = coroutine[0];
			if (c == null) {
				beforeProbe = "coroutine thread never ran";
			} else {
				beforeProbe = c + " state=" + c.getState();
				java.util.concurrent.locks.LockSupport.unpark(c);
				Thread.sleep(200);
			}
			fail("delay() did not resume after 5s of flushing; pendingCount=" + GodotScope.pendingCount()
					+ ", parkedCount=" + GodotScope.parkedCount() + "; before probe: " + beforeProbe
					+ "; after direct unpark: state=" + state.get() + ", threadState="
					+ (c == null ? "-" : c.getState()));
		}
	}

	@Test
	void awaitOnSignalResumesOnEmit() throws InterruptedException {
		AtomicBoolean resumed = new AtomicBoolean(false);
		var signal = new GodotScope.SignalHandle();
		GodotScope.launch(() -> {
			signal.await();
			resumed.set(true);
		});

		// Not resumed before the signal fires: wait until the coroutine actually
		// parked, then assert it is still suspended.
		awaitTrue(() -> GodotScope.parkedCount() > 0);
		assertFalse(resumed.get());

		// Fire+flush until the awaiting coroutine registered and woke. Firing
		// repeatedly is safe: fire() with no waiter registered is a no-op.
		long deadline = System.currentTimeMillis() + 5_000;
		while (!resumed.get() && System.currentTimeMillis() < deadline) {
			signal.fire();
			GodotScope.flush();
			Thread.sleep(10);
		}
		assertTrue(resumed.get());
	}
}
