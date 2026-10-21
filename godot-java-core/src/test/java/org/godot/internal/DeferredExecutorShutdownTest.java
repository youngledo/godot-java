package org.godot.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class DeferredExecutorShutdownTest {

	@AfterEach
	void reset() {
		DeferredExecutor.resetForTesting();
	}

	@Test
	void executesQueuedTasksBeforeShutdown() {
		AtomicBoolean ran = new AtomicBoolean(false);
		DeferredExecutor.callDeferred(() -> ran.set(true));
		assertEquals(1, DeferredExecutor.pendingCount());
		DeferredExecutor.flush();
		assertTrue(ran.get());
		assertEquals(0, DeferredExecutor.pendingCount());
	}

	@Test
	void shutdownDropsQueuedTasksAndRejectsNewOnes() {
		AtomicBoolean ran = new AtomicBoolean(false);
		DeferredExecutor.callDeferred(() -> ran.set(true));
		DeferredExecutor.shutdown();
		assertTrue(DeferredExecutor.isShutdown());
		// queued task was dropped, not executed later
		assertEquals(0, DeferredExecutor.pendingCount());
		DeferredExecutor.callDeferred(() -> ran.set(true));
		assertEquals(0, DeferredExecutor.pendingCount());
		DeferredExecutor.flush();
		assertFalse(ran.get());
	}
}
