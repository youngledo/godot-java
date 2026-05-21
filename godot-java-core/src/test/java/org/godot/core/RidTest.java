package org.godot.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/// Tests for [Rid] value wrapper.
class RidTest {

	@Test
	void constructor_storesId() {
		Rid rid = new Rid(42L);
		assertEquals(42L, rid.id());
	}

	@Test
	void constructor_negativeId() {
		Rid rid = new Rid(-1L);
		assertEquals(-1L, rid.id());
	}

	@Test
	void constructor_zeroId() {
		Rid rid = new Rid(0L);
		assertEquals(0L, rid.id());
	}

	@Test
	void toString_containsId() {
		Rid rid = new Rid(123);
		String s = rid.toString();
		assertTrue(s.contains("123"));
		assertTrue(s.contains("Rid"));
	}
}
