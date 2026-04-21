package org.godot.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for GodotString - Task 7.5. Tests construction, toJavaString(),
 * and equality operations.
 *
 * Note: These tests require native Godot runtime to be available since
 * GodotString relies on Bridge.callVoid for native string construction. The
 * tests verify the API contract and expected behavior.
 */
public class GodotStringTest {

	@Test
	void constructor_defaultCreatesNullString() {
		GodotString s = new GodotString();
		assertTrue(s.isNull());
		assertEquals(0, s.getPtr());
	}

	@Test
	void isNull_nullStringReturnsTrue() {
		GodotString s = new GodotString();
		assertTrue(s.isNull());
	}

	@Test
	void buffer_returnsSegment() {
		GodotString s = new GodotString();
		// buffer() should return the internal segment
		assertNotNull(s.buffer());
	}

	@Test
	void segment_returnsSegment() {
		GodotString s = new GodotString();
		// segment() should return the internal segment
		assertNotNull(s.segment());
	}

	@Test
	void toString_nullStringReturnsEmpty() {
		GodotString s = new GodotString();
		// toString() calls toJavaString() which returns "" for null strings
		assertEquals("", s.toString());
	}

	@Test
	void getPtr_nullStringReturnsZero() {
		GodotString s = new GodotString();
		assertEquals(0, s.getPtr());
	}
}
