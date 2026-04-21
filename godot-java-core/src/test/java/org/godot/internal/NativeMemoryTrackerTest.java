package org.godot.internal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for NativeMemoryTracker.onFree() and allocation counters.
 */
public class NativeMemoryTrackerTest {

	@AfterEach
	void tearDown() {
		// Reset counters between tests to avoid test interference
		// Note: The tracker has no reset method, so we read values and verify deltas
	}

	@Test
	void onFree_decrementsLiveAllocationCount() {
		// Record initial state
		long before = NativeMemoryTracker.getLiveAllocationCount();

		// Simulate onAllocate followed by onFree
		NativeMemoryTracker.onAllocate(100);
		assertEquals(before + 1, NativeMemoryTracker.getLiveAllocationCount(), "Should increment after allocate");

		NativeMemoryTracker.onFree(100);
		assertEquals(before, NativeMemoryTracker.getLiveAllocationCount(), "Should be back to initial after free");
	}

	@Test
	void onFree_decrementsLiveBytes() {
		long before = NativeMemoryTracker.getLiveBytes();

		NativeMemoryTracker.onAllocate(500);
		assertEquals(before + 500, NativeMemoryTracker.getLiveBytes(), "Should increment bytes after allocate");

		NativeMemoryTracker.onFree(500);
		assertEquals(before, NativeMemoryTracker.getLiveBytes(), "Should be back to initial bytes after free");
	}

	@Test
	void onFree_handlesMultipleAllocations() {
		long before = NativeMemoryTracker.getLiveAllocationCount();
		long bytesBefore = NativeMemoryTracker.getLiveBytes();

		// Allocate multiple blocks of different sizes
		NativeMemoryTracker.onAllocate(100);
		NativeMemoryTracker.onAllocate(200);
		NativeMemoryTracker.onAllocate(300);
		assertEquals(before + 3, NativeMemoryTracker.getLiveAllocationCount());
		assertEquals(bytesBefore + 600, NativeMemoryTracker.getLiveBytes());

		// Free in any order
		NativeMemoryTracker.onFree(200);
		assertEquals(before + 2, NativeMemoryTracker.getLiveAllocationCount());
		assertEquals(bytesBefore + 400, NativeMemoryTracker.getLiveBytes());

		NativeMemoryTracker.onFree(100);
		assertEquals(before + 1, NativeMemoryTracker.getLiveAllocationCount());
		assertEquals(bytesBefore + 300, NativeMemoryTracker.getLiveBytes(), "600 - 200 - 100 = 300");

		NativeMemoryTracker.onFree(300);
		assertEquals(before, NativeMemoryTracker.getLiveAllocationCount());
		assertEquals(bytesBefore, NativeMemoryTracker.getLiveBytes());
	}

	@Test
	void getStats_containsExpectedFields() {
		String stats = NativeMemoryTracker.getStats();
		assertNotNull(stats);
		assertTrue(stats.contains("totalAllocations="));
		assertTrue(stats.contains("totalBytes="));
		assertTrue(stats.contains("liveAllocations="));
		assertTrue(stats.contains("liveBytes="));
	}
}
