package org.godot.collection;

import org.godot.exception.GodotInvalidObjectException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for GodotDictionary - Task 7.6. Tests get, put, containsKey,
 * remove, clear, and size operations.
 *
 * Note: These tests require native Godot runtime since GodotDictionary
 * operations rely on Bridge.callVoid for native calls. The tests verify the API
 * contract and expected behavior for invalid/empty dictionaries.
 */
public class GodotDictionaryTest {

	@Test
	void constructor_defaultCreatesInvalidDictionary() {
		GodotDictionary dict = new GodotDictionary();
		// Default native object is 0 (invalid)
		assertEquals(0, dict.getPtr());
	}

	@Test
	void constructor_withNativePtr() {
		// Create with a specific native pointer
		GodotDictionary dict = new GodotDictionary(0x1000L);
		assertEquals(0x1000L, dict.getPtr());
	}

	@Test
	void get_invalidDictionaryReturnsNull() {
		GodotDictionary dict = new GodotDictionary();
		// get() should return null for invalid dictionary
		assertNull(dict.get("key"));
	}

	@Test
	void put_invalidDictionaryDoesNothing() {
		GodotDictionary dict = new GodotDictionary();
		// put() should not throw on invalid dictionary
		assertDoesNotThrow(() -> dict.put("key", "value"));
	}

	@Test
	void containsKey_invalidDictionaryReturnsFalse() {
		GodotDictionary dict = new GodotDictionary();
		// containsKey() returns get() != null, so should be false for invalid
		assertFalse(dict.containsKey("key"));
	}

	@Test
	void remove_invalidDictionaryThrowsException() {
		GodotDictionary dict = new GodotDictionary();
		// remove() calls erase which uses call(), throws when nativeObject is 0
		assertThrows(GodotInvalidObjectException.class, () -> dict.remove("key"));
	}

	@Test
	void clear_invalidDictionaryThrowsException() {
		GodotDictionary dict = new GodotDictionary();
		// clear() uses call(), throws when nativeObject is 0
		assertThrows(GodotInvalidObjectException.class, () -> dict.clear());
	}

	@Test
	void size_invalidDictionaryReturnsZero() {
		GodotDictionary dict = new GodotDictionary();
		// size() returns 0 for invalid dictionary
		assertEquals(0, dict.size());
	}

	@Test
	void isEmpty_invalidDictionaryReturnsTrue() {
		GodotDictionary dict = new GodotDictionary();
		assertTrue(dict.isEmpty());
	}
}
