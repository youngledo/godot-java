package org.godot.builtin;

import org.godot.math.Vector3i;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/// Unit tests for Vector3i.
public class Vector3iTest {

	@Test
	void constructor_defaultCreatesZeroVector() {
		Vector3i v = new Vector3i();
		assertEquals(0, v.x);
		assertEquals(0, v.y);
		assertEquals(0, v.z);
	}

	@Test
	void constructor_withValues() {
		Vector3i v = new Vector3i(3, 4, 5);
		assertEquals(3, v.x);
		assertEquals(4, v.y);
		assertEquals(5, v.z);
	}

	@Test
	void getters_returnCorrectValues() {
		Vector3i v = new Vector3i(7, 11, 13);
		assertEquals(7, v.getX());
		assertEquals(11, v.getY());
		assertEquals(13, v.getZ());
	}

	@Test
	void toString_isNotEmpty() {
		Vector3i v = new Vector3i(3, 4, 5);
		String s = v.toString();
		assertNotNull(s);
		assertFalse(s.isEmpty());
	}
}
