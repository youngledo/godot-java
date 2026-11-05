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
		GodotScope.launch(() -> {
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
		assertEquals("after-delay", state.get());
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
