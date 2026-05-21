package org.godot.builtin;

import org.godot.math.Vector2i;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/// Unit tests for Vector2i.
public class Vector2iTest {

	@Test
	void constructor_defaultCreatesZeroVector() {
		Vector2i v = new Vector2i();
		assertEquals(0, v.x);
		assertEquals(0, v.y);
	}

	@Test
	void constructor_withValues() {
		Vector2i v = new Vector2i(3, 4);
		assertEquals(3, v.x);
		assertEquals(4, v.y);
	}

	@Test
	void getters_returnCorrectValues() {
		Vector2i v = new Vector2i(7, 11);
		assertEquals(7, v.getX());
		assertEquals(11, v.getY());
	}

	@Test
	void toString_isNotEmpty() {
		Vector2i v = new Vector2i(3, 4);
		String s = v.toString();
		assertNotNull(s);
		assertFalse(s.isEmpty());
	}
}
