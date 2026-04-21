package org.godot.bridge;

import org.junit.jupiter.api.Test;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Bridge scoped memory management (runScoped, destroyVariant).
 * These tests verify the ScopedValue-based arena switching without requiring a
 * running Godot instance.
 */
public class BridgeScopedMemoryTest {

	@Test
	void arena_returnsPersistentArenaOutsideScope() {
		Arena persistent = getPersistentArena();
		Arena active = Bridge.arena();
		assertSame(persistent, active, "Outside runScoped, arena() should return the persistent ARENA");
	}

	@Test
	void runScoped_switchesArenaForCallable() {
		Arena persistent = getPersistentArena();

		String result = Bridge.runScoped(() -> {
			Arena active = Bridge.arena();
			assertNotSame(persistent, active, "Inside runScoped, arena() should return a scoped arena");
			assertNotNull(active);
			return "ok";
		});

		assertEquals("ok", result);
		assertSame(persistent, Bridge.arena(), "After runScoped, arena() should revert to persistent");
	}

	@Test
	void runScoped_switchesArenaForRunnable() {
		Arena persistent = getPersistentArena();
		boolean[] ran = {false};

		Bridge.runScoped(() -> {
			Arena active = Bridge.arena();
			assertNotSame(persistent, active);
			ran[0] = true;
		});

		assertTrue(ran[0]);
		assertSame(persistent, Bridge.arena());
	}

	@Test
	void runScoped_nestedCreatesSeparateArenas() {
		Arena[] outerArena = {null};
		Arena[] innerArena = {null};

		Bridge.runScoped(() -> {
			outerArena[0] = Bridge.arena();
			Bridge.runScoped(() -> {
				innerArena[0] = Bridge.arena();
				assertNotSame(outerArena[0], innerArena[0], "Nested scope should have a different arena");
			});
			assertSame(outerArena[0], Bridge.arena(), "After inner scope, outer arena should be restored");
		});

		assertNotNull(outerArena[0]);
		assertNotNull(innerArena[0]);
	}

	@Test
	void runScoped_allocationsAreFreedAfterScope() {
		// Verify that a scoped arena closes after runScoped completes.
		// We can't directly test if memory is freed, but we can verify the arena is
		// closed.
		Arena[] captured = {null};

		Bridge.runScoped(() -> {
			captured[0] = Bridge.arena();
			// Allocate something
			MemorySegment seg = Bridge.allocate(100);
			assertFalse(seg.equals(MemorySegment.NULL));
		});

		// After scope closes, the captured arena should be closed
		assertThrows(IllegalStateException.class, () -> captured[0].allocate(1),
				"Scoped arena should be closed after runScoped exits");
	}

	@Test
	void allocVariant_usesScopedArena() {
		Arena persistent = getPersistentArena();

		Bridge.runScoped(() -> {
			MemorySegment variant = Bridge.allocVariant();
			assertNotNull(variant);
			assertEquals(24, variant.byteSize());
			// Verify it's from the scoped arena, not persistent
			assertNotSame(persistent, Bridge.arena());
		});
	}

	@Test
	void runScoped_propagatesRuntimeException() {
		RuntimeException expected = new RuntimeException("test error");
		RuntimeException caught = assertThrows(RuntimeException.class, () -> {
			Bridge.runScoped(() -> {
				throw expected;
			});
		});
		assertSame(expected, caught);

		// Arena should still be restored after exception
		Arena persistent = getPersistentArena();
		assertSame(persistent, Bridge.arena(), "Arena should be restored even after exception");
	}

	@Test
	void destroyVariant_doesNotThrowWhenApiNotLoaded() {
		// Bridge.load() hasn't been called, so destroyVariant should log a warning
		// but not throw
		MemorySegment fakeVariant = Arena.ofShared().allocate(24);
		assertDoesNotThrow(() -> Bridge.destroyVariant(fakeVariant));
	}

	// Helper to access the private ARENA field for testing
	private static Arena getPersistentArena() {
		try {
			Field field = Bridge.class.getDeclaredField("ARENA");
			field.setAccessible(true);
			return (Arena) field.get(null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
