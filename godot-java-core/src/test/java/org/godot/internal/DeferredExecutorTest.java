package org.godot.internal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for DeferredExecutor - Task 7.8. Tests queue tasks and verify
 * execution on main thread.
 */
public class DeferredExecutorTest {

	@AfterEach
	void cleanup() {
		// Clear any pending tasks
		while (DeferredExecutor.pendingCount() > 0) {
			DeferredExecutor.flush();
		}
	}

	@Test
	void callDeferred_addsTaskToQueue() {
		DeferredExecutor.callDeferred(() -> {
		});
		assertEquals(1, DeferredExecutor.pendingCount());
	}

	@Test
	void callDeferred_nullTaskDoesNotAddToQueue() {
		DeferredExecutor.callDeferred(null);
		assertEquals(0, DeferredExecutor.pendingCount());
	}

	@Test
	void flush_executesAllTasks() {
		AtomicInteger counter = new AtomicInteger(0);
		DeferredExecutor.callDeferred(counter::incrementAndGet);
		DeferredExecutor.callDeferred(counter::incrementAndGet);
		DeferredExecutor.callDeferred(counter::incrementAndGet);

		assertEquals(3, DeferredExecutor.pendingCount());
		int flushed = DeferredExecutor.flush();
		assertEquals(3, flushed);
		assertEquals(0, DeferredExecutor.pendingCount());
		assertEquals(3, counter.get());
	}

	@Test
	void flush_returnsZero_whenQueueEmpty() {
		int flushed = DeferredExecutor.flush();
		assertEquals(0, flushed);
	}

	@Test
	void pendingCount_returnsQueueSize() {
		assertEquals(0, DeferredExecutor.pendingCount());
		DeferredExecutor.callDeferred(() -> {
		});
		assertEquals(1, DeferredExecutor.pendingCount());
		DeferredExecutor.callDeferred(() -> {
		});
		assertEquals(2, DeferredExecutor.pendingCount());
	}

	@Test
	void flush_clearsQueueEvenIfTaskThrows() {
		AtomicInteger counter = new AtomicInteger(0);
		DeferredExecutor.callDeferred(() -> {
			throw new RuntimeException("Test exception");
		});
		DeferredExecutor.callDeferred(counter::incrementAndGet);

		// flush() should catch the exception and continue
		int flushed = DeferredExecutor.flush();
		assertEquals(2, flushed);
		assertEquals(0, DeferredExecutor.pendingCount());
		assertEquals(1, counter.get());
	}

	@Test
	void flush_handlesMultipleFlushes() {
		DeferredExecutor.callDeferred(() -> {
		});
		DeferredExecutor.flush();
		// Second flush should return 0
		assertEquals(0, DeferredExecutor.flush());
	}

	@Test
	void callDeferred_canPassDataThroughRunnable() {
		AtomicBoolean executed = new AtomicBoolean(false);
		DeferredExecutor.callDeferred(() -> executed.set(true));
		DeferredExecutor.flush();
		assertTrue(executed.get());
	}

	@Test
	void flush_executesInOrder() {
		StringBuilder order = new StringBuilder();
		DeferredExecutor.callDeferred(() -> order.append("1"));
		DeferredExecutor.callDeferred(() -> order.append("2"));
		DeferredExecutor.callDeferred(() -> order.append("3"));
		DeferredExecutor.flush();
		assertEquals("123", order.toString());
	}

	@Test
	void callDeferred_fromMultipleThreads_addsToQueue() throws InterruptedException {
		AtomicInteger counter = new AtomicInteger(0);
		Thread t1 = new Thread(() -> DeferredExecutor.callDeferred(counter::incrementAndGet));
		Thread t2 = new Thread(() -> DeferredExecutor.callDeferred(counter::incrementAndGet));
		Thread t3 = new Thread(() -> DeferredExecutor.callDeferred(counter::incrementAndGet));

		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();

		// All 3 tasks should be queued
		assertEquals(3, DeferredExecutor.pendingCount());
		DeferredExecutor.flush();
		assertEquals(3, counter.get());
	}

	@Test
	void flush_taskCanQueueAnotherTask() {
		AtomicInteger counter = new AtomicInteger(0);
		DeferredExecutor.callDeferred(() -> {
			counter.incrementAndGet();
			// Queue another task mid-flush
			DeferredExecutor.callDeferred(counter::incrementAndGet);
		});
		// Only 1 task initially
		assertEquals(1, DeferredExecutor.pendingCount());
		// Flush - this will process the task and any tasks it queues
		// Since task A queues task B during execution, task B is also processed
		// in the same flush (not left pending)
		int flushed = DeferredExecutor.flush();
		// Both tasks were processed in one flush
		assertEquals(2, flushed);
		// Queue is now empty
		assertEquals(0, DeferredExecutor.pendingCount());
		// Both increments were executed
		assertEquals(2, counter.get());
	}
}
