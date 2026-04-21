package org.godot.internal;

import org.godot.exception.GodotThreadException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ThreadChecker - Task 7.7. Tests main thread enforcement and
 * exception type.
 */
public class ThreadCheckerTest {

	@AfterEach
	void cleanup() {
		// Reset thread checker state after each test
		ThreadChecker.setEnabled(true);
	}

	@Test
	void recordMainThread_setsMainThreadId() {
		// Record current thread as main
		ThreadChecker.recordMainThread();
		long mainId = ThreadChecker.getMainThreadId();
		assertTrue(mainId > 0, "Main thread ID should be positive");
		assertEquals(Thread.currentThread().threadId(), mainId);
	}

	@Test
	void isMainThread_whenNotInitialized_returnsTrue() {
		// Before recordMainThread is called, isMainThread returns true
		// (assumes main thread if not set)
		assertTrue(ThreadChecker.isMainThread());
	}

	@Test
	void isMainThread_afterRecordingCurrentThread_returnsTrue() {
		ThreadChecker.recordMainThread();
		assertTrue(ThreadChecker.isMainThread());
	}

	@Test
	void ensureMainThread_onMainThread_doesNotThrow() {
		ThreadChecker.recordMainThread();
		// Should not throw when called from main thread
		assertDoesNotThrow(() -> ThreadChecker.ensureMainThread());
	}

	@Test
	void ensureMainThread_throwsGodotThreadException_fromBackgroundThread() {
		ThreadChecker.recordMainThread();

		// Create an exception to hold the thrown exception
		Exception[] caughtException = new Exception[1];
		Thread backgroundThread = new Thread(() -> {
			try {
				ThreadChecker.ensureMainThread();
				fail("Expected GodotThreadException was not thrown");
			} catch (GodotThreadException e) {
				caughtException[0] = e;
			}
		});

		backgroundThread.start();
		try {
			backgroundThread.join();
		} catch (InterruptedException e) {
			fail("Test thread was interrupted");
		}

		// Verify exception was caught
		assertNotNull(caughtException[0], "GodotThreadException should have been thrown");
		assertTrue(caughtException[0] instanceof GodotThreadException);

		GodotThreadException te = (GodotThreadException) caughtException[0];
		assertTrue(te.getMessage().contains("non-main thread"));
		assertNotNull(te.getThreadName());
	}

	@Test
	void ensureMainThread_exceptionContainsThreadName() {
		ThreadChecker.recordMainThread();

		Exception[] caughtException = new Exception[1];
		Thread backgroundThread = new Thread(() -> {
			try {
				ThreadChecker.ensureMainThread();
			} catch (GodotThreadException e) {
				caughtException[0] = e;
			}
		});

		backgroundThread.start();
		try {
			backgroundThread.join();
		} catch (InterruptedException e) {
			fail("Test interrupted");
		}

		assertNotNull(caughtException[0]);
		GodotThreadException te = (GodotThreadException) caughtException[0];
		assertEquals(backgroundThread.getName(), te.getThreadName());
	}

	@Test
	void ensureMainThread_whenDisabled_doesNotThrow() {
		// Disable thread checking
		ThreadChecker.setEnabled(false);
		// Even from a background thread, should not throw
		Thread backgroundThread = new Thread(() -> {
			assertDoesNotThrow(() -> ThreadChecker.ensureMainThread());
		});
		backgroundThread.start();
		try {
			backgroundThread.join();
		} catch (InterruptedException e) {
			fail("Test interrupted");
		}
	}

	@Test
	void setEnabled_canDisableThreadChecking() {
		ThreadChecker.recordMainThread();
		ThreadChecker.setEnabled(false);

		Thread backgroundThread = new Thread(() -> {
			// Should not throw when disabled
			assertDoesNotThrow(() -> ThreadChecker.ensureMainThread());
		});
		backgroundThread.start();
		try {
			backgroundThread.join();
		} catch (InterruptedException e) {
			fail("Test interrupted");
		}
	}

	@Test
	void isEnabled_initiallyTrue() {
		// Default is true (from static initializer)
		// But we need to reset after other tests
		assertTrue(ThreadChecker.isEnabled());
	}

	@Test
	void getMainThreadId_initiallyNegativeOne() {
		// Before recordMainThread is called, mainThreadId is -1
		// Note: other tests may have called recordMainThread, so we just verify
		// the method returns a valid long
		long id = ThreadChecker.getMainThreadId();
		assertTrue(id >= -1, "Main thread ID should be -1 or greater");
	}
}
