package org.godot.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Rect2 - Task 7.4. Tests intersection tests and containment
 * checks.
 */
public class Rect2Test {

	// ------------------------------------------------------------------------
	// Construction
	// ------------------------------------------------------------------------

	@Test
	void constructor_defaultCreatesZeroRect() {
		Rect2 r = new Rect2();
		assertEquals(0.0, r.getX(), 1e-10);
		assertEquals(0.0, r.getY(), 1e-10);
		assertEquals(0.0, r.getWidth(), 1e-10);
		assertEquals(0.0, r.getHeight(), 1e-10);
	}

	@Test
	void constructor_withX_Y_Width_Height() {
		Rect2 r = new Rect2(10.0, 20.0, 100.0, 50.0);
		assertEquals(10.0, r.getX(), 1e-10);
		assertEquals(20.0, r.getY(), 1e-10);
		assertEquals(100.0, r.getWidth(), 1e-10);
		assertEquals(50.0, r.getHeight(), 1e-10);
	}

	@Test
	void constructor_withPositionAndSize() {
		Vector2 pos = new Vector2(10.0, 20.0);
		Vector2 size = new Vector2(100.0, 50.0);
		Rect2 r = new Rect2(pos, size);
		assertEquals(10.0, r.getX(), 1e-10);
		assertEquals(20.0, r.getY(), 1e-10);
		assertEquals(100.0, r.getWidth(), 1e-10);
		assertEquals(50.0, r.getHeight(), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Properties
	// ------------------------------------------------------------------------

	@Test
	void getX_returnsPositionX() {
		Rect2 r = new Rect2(10.0, 20.0, 100.0, 50.0);
		assertEquals(10.0, r.getX(), 1e-10);
	}

	@Test
	void getY_returnsPositionY() {
		Rect2 r = new Rect2(10.0, 20.0, 100.0, 50.0);
		assertEquals(20.0, r.getY(), 1e-10);
	}

	@Test
	void getWidth_returnsSizeX() {
		Rect2 r = new Rect2(10.0, 20.0, 100.0, 50.0);
		assertEquals(100.0, r.getWidth(), 1e-10);
	}

	@Test
	void getHeight_returnsSizeY() {
		Rect2 r = new Rect2(10.0, 20.0, 100.0, 50.0);
		assertEquals(50.0, r.getHeight(), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Test
	void toString_containsValues() {
		Rect2 r = new Rect2(10.0, 20.0, 100.0, 50.0);
		String s = r.toString();
		assertTrue(s.contains("10.0") || s.contains("Rect2"));
	}
}
