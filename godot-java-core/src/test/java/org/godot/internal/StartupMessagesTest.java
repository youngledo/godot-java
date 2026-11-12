package org.godot.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class StartupMessagesTest {

	@AfterEach
	void reset() {
		StartupMessages.resetForTesting();
	}

	@Test
	void buffersAndDeduplicatesPerKey() {
		StartupMessages.error("class:com.example.Foo", "registration failed");
		StartupMessages.error("class:com.example.Foo", "registration failed again — suppressed");
		StartupMessages.error("class:com.example.Bar", "other failure");
		assertEquals(2, StartupMessages.pendingCount());
	}

	@Test
	void flushClearsBufferAndReportsFatal() {
		StartupMessages.error("k1", "recoverable");
		assertFalse(StartupMessages.flush(), "errors only must not be fatal");
		assertEquals(0, StartupMessages.pendingCount());

		StartupMessages.fatal("k2", "fatal");
		assertTrue(StartupMessages.flush(), "fatal must be reported");
		assertEquals(0, StartupMessages.pendingCount());
	}

	@Test
	void fatalPersistsAcrossFlushes() {
		StartupMessages.fatal("k1", "fatal");
		assertTrue(StartupMessages.flush());
		// A later level flush must still see the fatal — fatals latch.
		StartupMessages.error("k3", "later error");
		assertTrue(StartupMessages.flush());
	}

	@Test
	void resetClearsFatalLatch() {
		StartupMessages.fatal("k1", "fatal");
		StartupMessages.flush();
		StartupMessages.resetForTesting();
		StartupMessages.error("k2", "plain error");
		assertFalse(StartupMessages.flush());
		// Same key is reportable again after reset.
		StartupMessages.fatal("k1", "fatal again");
		assertEquals(1, StartupMessages.pendingCount());
	}
}
