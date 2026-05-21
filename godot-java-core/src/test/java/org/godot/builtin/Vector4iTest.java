package org.godot.builtin;

import org.godot.math.Vector4i;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/// Unit tests for Vector4i.
public class Vector4iTest {

	@Test
	void constructor_defaultCreatesZeroVector() {
		Vector4i v = new Vector4i();
		assertEquals(0, v.x);
		assertEquals(0, v.y);
		assertEquals(0, v.z);
		assertEquals(0, v.w);
	}

	@Test
	void constructor_withValues() {
		Vector4i v = new Vector4i(3, 4, 5, 6);
		assertEquals(3, v.x);
		assertEquals(4, v.y);
		assertEquals(5, v.z);
		assertEquals(6, v.w);
	}

	@Test
	void getters_returnCorrectValues() {
		Vector4i v = new Vector4i(7, 11, 13, 17);
		assertEquals(7, v.getX());
		assertEquals(11, v.getY());
		assertEquals(13, v.getZ());
		assertEquals(17, v.getW());
	}

	@Test
	void toString_isNotEmpty() {
		Vector4i v = new Vector4i(3, 4, 5, 6);
		String s = v.toString();
		assertNotNull(s);
		assertFalse(s.isEmpty());
	}
}
