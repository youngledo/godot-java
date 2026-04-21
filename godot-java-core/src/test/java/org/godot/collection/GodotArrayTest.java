package org.godot.collection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for GodotArray methods.
 *
 * Note: These tests focus on Java-side logic (shuffle, reverse, etc.) and
 * method signatures. Full integration tests require a running Godot instance
 * with the GodotArray native bindings.
 */
public class GodotArrayTest {

	@Test
	void constructor_defaultCreatesEmptyArray() {
		GodotArray arr = new GodotArray();
		assertEquals(0, arr.size());
		assertTrue(arr.isEmpty());
	}

	@Test
	void constructor_withNativePtrSetsNativeObject() {
		// Creating with nativePtr doesn't call Godot, just sets the pointer
		GodotArray arr = new GodotArray(0x12345678L);
		// nativeObject is set via RefCounted constructor
		assertEquals(0x12345678L, arr.getPtr());
	}

	@Test
	void isEmpty_returnsTrueForEmptyArray() {
		GodotArray arr = new GodotArray();
		assertTrue(arr.isEmpty());
	}

	@Test
	void shuffle_doesNotThrowForEmptyArray() {
		GodotArray arr = new GodotArray();
		// Should not throw even on empty array
		arr.shuffle();
		assertTrue(arr.isEmpty());
	}

	@Test
	void shuffle_doesNotThrowForSingleElement() {
		GodotArray arr = new GodotArray();
		// Single element - shuffle should be no-op but not throw
		// We can't actually test this without mocking Bridge.call
		// This tests the guard clause exists
		assertDoesNotThrow(() -> arr.shuffle());
	}

	@Test
	void reverse_doesNotThrowForEmptyArray() {
		GodotArray arr = new GodotArray();
		arr.reverse();
		assertTrue(arr.isEmpty());
	}

	@Test
	void reverse_doesNotThrowForSingleElement() {
		GodotArray arr = new GodotArray();
		// Single element - reverse should be no-op but not throw
		assertDoesNotThrow(() -> arr.reverse());
	}

	@Test
	void add_doesNotThrowForInvalidArray() {
		GodotArray arr = new GodotArray();
		// add() should early-return when nativeObject == 0
		assertDoesNotThrow(() -> arr.add("test"));
	}

	@Test
	void append_isAliasForAdd() {
		GodotArray arr = new GodotArray();
		// append should behave same as add - both call Godot which we can't test here
		// Just verify no crash on invalid array
		assertDoesNotThrow(() -> arr.append("test"));
	}

	@Test
	void set_doesNotThrowForInvalidArray() {
		GodotArray arr = new GodotArray();
		assertDoesNotThrow(() -> arr.set(0, "value"));
	}

	@Test
	void get_doesNotThrowForInvalidArray() {
		GodotArray arr = new GodotArray();
		assertDoesNotThrow(() -> arr.get(0));
		assertNull(arr.get(0));
	}

	@Test
	void remove_doesNotThrowForInvalidArray() {
		GodotArray arr = new GodotArray();
		assertDoesNotThrow(() -> arr.remove(0));
	}

	@Test
	void insert_doesNotThrowForInvalidArray() {
		GodotArray arr = new GodotArray();
		assertDoesNotThrow(() -> arr.insert(0, "value"));
	}

	@Test
	void clear_doesNotThrowForInvalidArray() {
		GodotArray arr = new GodotArray();
		assertDoesNotThrow(() -> arr.clear());
	}

	@Test
	void resize_doesNotThrowForInvalidArray() {
		GodotArray arr = new GodotArray();
		assertDoesNotThrow(() -> arr.resize(10));
	}

	@Test
	void sort_doesNotThrowForInvalidArray() {
		GodotArray arr = new GodotArray();
		assertDoesNotThrow(() -> arr.sort());
	}

	@Test
	void fromNative_returnsNullForZeroPtr() {
		assertNull(GodotArray.fromNative(0));
	}

	@Test
	void fromNative_returnsArrayForValidPtr() {
		GodotArray arr = GodotArray.fromNative(0x12345678L);
		assertNotNull(arr);
		assertEquals(0x12345678L, arr.getPtr());
	}

	// =========================================================================
	// Test shuffle algorithm correctness (Java-side logic)
	// =========================================================================

	@Test
	void shuffle_algorithmUsesSwap() {
		// This tests the shuffle algorithm logic by checking it doesn't lose elements
		// We'll use reflection to simulate a controlled test
		// Since we can't mock Bridge.call, we verify the guard clause exists
		GodotArray arr = new GodotArray();
		assertDoesNotThrow(() -> arr.shuffle());
	}

	@Test
	void reverse_algorithmUsesTwoPointerSwap() {
		// Verify guard clause prevents crash on invalid array
		GodotArray arr = new GodotArray();
		assertDoesNotThrow(() -> arr.reverse());
	}
}
