package org.godot.coroutine;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.godot.coroutine.GodotScope.SignalHandle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class GodotScopeShutdownTest {

	@AfterEach
	void reset() {
		GodotScope.resetForTesting();
	}

	@Test
	void shutdownCancelsDelayedCoroutine() throws Exception {
		AtomicBoolean completed = new AtomicBoolean(false);
		AtomicBoolean cancelled = new AtomicBoolean(false);
		Thread coroutine = Thread.ofVirtual().start(() -> {
			try {
				GodotScope.delay(10.0);
				completed.set(true);
			} catch (CancellationException e) {
				cancelled.set(true);
			}
		});
		Thread.sleep(200); // let the coroutine park
		GodotScope.shutdown();
		coroutine.join(2000);
		assertFalse(coroutine.isAlive(), "coroutine must not park until the delay elapses");
		assertTrue(cancelled.get());
		assertFalse(completed.get());
	}

	@Test
	void shutdownCancelsAwaitingSignalHandle() throws Exception {
		AtomicBoolean cancelled = new AtomicBoolean(false);
		SignalHandle handle = new SignalHandle();
		Thread coroutine = Thread.ofVirtual().start(() -> {
			try {
				handle.await();
			} catch (CancellationException e) {
				cancelled.set(true);
			}
		});
		Thread.sleep(200); // let the coroutine park
		GodotScope.shutdown();
		coroutine.join(2000);
		assertFalse(coroutine.isAlive(), "awaiting coroutine must not park forever");
		assertTrue(cancelled.get());
	}

	@Test
	void firedHandleStillDeliversArguments() throws Exception {
		SignalHandle handle = new SignalHandle();
		AtomicReference<Object[]> received = new AtomicReference<>();
		CountDownLatch done = new CountDownLatch(1);
		Thread coroutine = Thread.ofVirtual().start(() -> {
			handle.await();
			received.set(handle.args());
			done.countDown();
		});
		Thread.sleep(200); // let the coroutine park
		handle.fire("hello", 42);
		GodotScope.flush();
		assertTrue(done.await(2, TimeUnit.SECONDS));
		assertArrayEquals(new Object[]{"hello", 42}, received.get());
	}
}
