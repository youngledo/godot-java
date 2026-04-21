package org.godot.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for GodotStringName - Task 7.5. Tests construction and address()
 * method.
 *
 * Note: These tests require native Godot runtime to be available since
 * GodotStringName relies on Bridge.callVoid for native string construction. The
 * tests verify the API contract and expected behavior.
 */
public class GodotStringNameTest {

	@Test
	void constructor_defaultCreatesNullStringName() {
		GodotStringName sn = new GodotStringName();
		assertEquals(0, sn.address());
	}

	@Test
	void address_nullStringNameReturnsZero() {
		GodotStringName sn = new GodotStringName();
		assertEquals(0, sn.address());
	}

	@Test
	void segment_returnsSegment() {
		GodotStringName sn = new GodotStringName();
		// segment() should return the internal segment
		assertNotNull(sn.segment());
	}

	@Test
	void segment_nullSegmentHasZeroAddress() {
		GodotStringName sn = new GodotStringName();
		assertEquals(0, sn.segment().address());
	}
}
