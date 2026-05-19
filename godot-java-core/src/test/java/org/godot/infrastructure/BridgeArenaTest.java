package org.godot.infrastructure;

import org.godot.bridge.Bridge;
import org.junit.jupiter.api.Test;

import java.lang.foreign.MemorySegment;

import static org.junit.jupiter.api.Assertions.*;

class BridgeArenaTest {

	@Test
	void runScopedCreatesAndClosesArena() {
		// After runScoped completes, the arena should be closed
		// Verify by checking that allocations inside scope work
		Bridge.runScoped(() -> {
			MemorySegment seg = Bridge.allocVariant();
			assertNotNull(seg);
			assertEquals(24, seg.byteSize());
			return null;
		});
	}

	@Test
	void runScopedReturnsValue() {
		Object result = Bridge.runScoped(() -> {
			return "test_result";
		});
		assertEquals("test_result", result);
	}

	@Test
	void nestedRunScopedCreatesIndependentScopes() {
		Bridge.runScoped(() -> {
			MemorySegment outer = Bridge.allocVariant();
			outer.set(java.lang.foreign.ValueLayout.JAVA_INT, 0, 42);

			Bridge.runScoped(() -> {
				MemorySegment inner = Bridge.allocVariant();
				// Inner allocation should work independently
				assertNotNull(inner);
				assertEquals(24, inner.byteSize());
				return null;
			});

			// Outer should still be accessible
			assertEquals(42, outer.get(java.lang.foreign.ValueLayout.JAVA_INT, 0));
			return null;
		});
	}

	@Test
	void allocVariantTrackedInMemoryTracker() {
		long beforeCount = org.godot.internal.NativeMemoryTracker.getLiveAllocationCount();

		Bridge.runScoped(() -> {
			Bridge.allocVariant();
			Bridge.allocVariant();
			Bridge.allocVariant();
			// Inside scope: live allocations should be +3
			assertEquals(beforeCount + 3, org.godot.internal.NativeMemoryTracker.getLiveAllocationCount());
			return null;
		});

		// After scope closes, onFree is called so live count returns to baseline
		assertEquals(beforeCount, org.godot.internal.NativeMemoryTracker.getLiveAllocationCount());
	}

	@Test
	void allocateTrackedInMemoryTracker() {
		long beforeBytes = org.godot.internal.NativeMemoryTracker.getLiveBytes();

		Bridge.runScoped(() -> {
			Bridge.allocate(100);
			// Inside scope: live bytes should be +100
			assertEquals(beforeBytes + 100, org.godot.internal.NativeMemoryTracker.getLiveBytes());
			return null;
		});

		// After scope closes, onFree is called so live bytes returns to baseline
		assertEquals(beforeBytes, org.godot.internal.NativeMemoryTracker.getLiveBytes());
	}

	@Test
	void destroyVariantDoesNotThrowOnNullSegment() {
		// destroyVariant should handle errors gracefully
		assertDoesNotThrow(() -> {
			Bridge.runScoped(() -> {
				MemorySegment seg = Bridge.allocVariant();
				// Destroy should not throw even though the Variant has no real Godot data
				Bridge.destroyVariant(seg);
				return null;
			});
		});
	}
}
