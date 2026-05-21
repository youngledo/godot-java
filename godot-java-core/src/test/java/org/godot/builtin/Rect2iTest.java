package org.godot.builtin;

import org.godot.math.Rect2i;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/// Unit tests for Rect2i.
public class Rect2iTest {

	@Test
	void constructor_defaultCreatesZeroValues() {
		Rect2i r = new Rect2i();
		assertEquals(0, r.x);
		assertEquals(0, r.y);
		assertEquals(0, r.width);
		assertEquals(0, r.height);
	}

	@Test
	void constructor_withValues() {
		Rect2i r = new Rect2i(10, 20, 100, 200);
		assertEquals(10, r.x);
		assertEquals(20, r.y);
		assertEquals(100, r.width);
		assertEquals(200, r.height);
	}

	@Test
	void getters_returnCorrectValues() {
		Rect2i r = new Rect2i(5, 15, 50, 75);
		assertEquals(5, r.getX());
		assertEquals(15, r.getY());
		assertEquals(50, r.getWidth());
		assertEquals(75, r.getHeight());
	}

	@Test
	void toString_isNotEmpty() {
		Rect2i r = new Rect2i(10, 20, 100, 200);
		String s = r.toString();
		assertNotNull(s);
		assertFalse(s.isEmpty());
	}
}
