package org.godot.builtin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.godot.math.Color;
import org.junit.jupiter.api.Test;

/// Tests for [Color] constructors, HSV conversion, equals, hashCode, and toString.
class ColorTest {

	private static final double EPSILON_EXACT = 1e-10;
	private static final double EPSILON_HSV = 0.01;

	@Test
	void defaultConstructor_allZero() {
		Color c = new Color();
		assertEquals(0.0, c.r, EPSILON_EXACT);
		assertEquals(0.0, c.g, EPSILON_EXACT);
		assertEquals(0.0, c.b, EPSILON_EXACT);
		assertEquals(0.0, c.a, EPSILON_EXACT);
	}

	@Test
	void threeArgConstructor_rgbSet_alphaDefaultsToOne() {
		Color c = new Color(0.25, 0.5, 0.75);
		assertEquals(0.25, c.r, EPSILON_EXACT);
		assertEquals(0.5, c.g, EPSILON_EXACT);
		assertEquals(0.75, c.b, EPSILON_EXACT);
		assertEquals(1.0, c.a, EPSILON_EXACT);
	}

	@Test
	void fourArgConstructor_allSet() {
		Color c = new Color(0.1, 0.2, 0.3, 0.4);
		assertEquals(0.1, c.r, EPSILON_EXACT);
		assertEquals(0.2, c.g, EPSILON_EXACT);
		assertEquals(0.3, c.b, EPSILON_EXACT);
		assertEquals(0.4, c.a, EPSILON_EXACT);
	}

	@Test
	void fromHsv_red() {
		Color c = Color.fromHsv(0, 1, 1);
		assertEquals(1.0, c.r, EPSILON_HSV);
		assertEquals(0.0, c.g, EPSILON_HSV);
		assertEquals(0.0, c.b, EPSILON_HSV);
		assertEquals(1.0, c.a, EPSILON_HSV);
	}

	@Test
	void fromHsv_green() {
		// H=1/3 (normalized hue, ~120 degrees) gives green
		Color c = Color.fromHsv(1.0 / 3.0, 1, 1);
		assertEquals(0.0, c.r, EPSILON_HSV);
		assertEquals(1.0, c.g, EPSILON_HSV);
		assertEquals(0.0, c.b, EPSILON_HSV);
		assertEquals(1.0, c.a, EPSILON_HSV);
	}

	@Test
	void fromHsv_withAlpha() {
		Color c = Color.fromHsv(0, 1, 1, 0.5);
		assertEquals(1.0, c.r, EPSILON_HSV);
		assertEquals(0.0, c.g, EPSILON_HSV);
		assertEquals(0.0, c.b, EPSILON_HSV);
		assertEquals(0.5, c.a, EPSILON_HSV);
	}

	@Test
	void equals_sameValues_returnsTrue() {
		Color a = new Color(0.3, 0.6, 0.9, 0.2);
		Color b = new Color(0.3, 0.6, 0.9, 0.2);
		assertEquals(a, b);
		assertTrue(a.equals(b));
	}

	@Test
	void equals_differentValues_returnsFalse() {
		Color a = new Color(0.3, 0.6, 0.9, 0.2);
		Color b = new Color(0.3, 0.6, 0.9, 0.3);
		assertNotEquals(a, b);
		assertFalse(a.equals(b));
	}

	@Test
	void equals_nonColor_returnsFalse() {
		Color c = new Color(1, 0, 0);
		assertFalse(c.equals("not a color"));
	}

	@Test
	void hashCode_sameValues_match() {
		Color a = new Color(0.3, 0.6, 0.9, 0.2);
		Color b = new Color(0.3, 0.6, 0.9, 0.2);
		assertEquals(a.hashCode(), b.hashCode());
	}

	@Test
	void toString_notEmpty() {
		Color c = new Color(0.1, 0.2, 0.3, 0.4);
		String s = c.toString();
		assertNotNull(s);
		assertFalse(s.isEmpty());
		assertTrue(s.contains("0.1"));
		assertTrue(s.contains("0.4"));
	}
}
