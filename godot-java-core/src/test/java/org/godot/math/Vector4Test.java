package org.godot.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Vector4 - Task 7.1. Tests arithmetic, normalization, dot
 * product, and lerp operations.
 */
public class Vector4Test {

	// ------------------------------------------------------------------------
	// Construction and constants
	// ------------------------------------------------------------------------

	@Test
	void constructor_defaultCreatesZeroVector() {
		Vector4 v = new Vector4();
		assertEquals(0.0, v.x);
		assertEquals(0.0, v.y);
		assertEquals(0.0, v.z);
		assertEquals(0.0, v.w);
	}

	@Test
	void constructor_withValues() {
		Vector4 v = new Vector4(1.0, 2.0, 3.0, 4.0);
		assertEquals(1.0, v.x);
		assertEquals(2.0, v.y);
		assertEquals(3.0, v.z);
		assertEquals(4.0, v.w);
	}

	@Test
	void constants_zeroIsCorrect() {
		assertEquals(0.0, Vector4.ZERO.x);
		assertEquals(0.0, Vector4.ZERO.y);
		assertEquals(0.0, Vector4.ZERO.z);
		assertEquals(0.0, Vector4.ZERO.w);
	}

	@Test
	void constants_oneIsCorrect() {
		assertEquals(1.0, Vector4.ONE.x);
		assertEquals(1.0, Vector4.ONE.y);
		assertEquals(1.0, Vector4.ONE.z);
		assertEquals(1.0, Vector4.ONE.w);
	}

	// ------------------------------------------------------------------------
	// Length and normalization
	// ------------------------------------------------------------------------

	@Test
	void length_1_2_2_4() {
		// sqrt(1 + 4 + 4 + 16) = sqrt(25) = 5
		Vector4 v = new Vector4(1.0, 2.0, 2.0, 4.0);
		assertEquals(5.0, v.length(), 1e-10);
	}

	@Test
	void length_squared() {
		Vector4 v = new Vector4(1.0, 2.0, 2.0, 4.0);
		assertEquals(25.0, v.lengthSquared(), 1e-10);
	}

	@Test
	void length_unitVector() {
		Vector4 v = new Vector4(1.0, 0.0, 0.0, 0.0);
		assertEquals(1.0, v.length(), 1e-10);
	}

	@Test
	void length_zeroVector() {
		Vector4 v = new Vector4(0.0, 0.0, 0.0, 0.0);
		assertEquals(0.0, v.length(), 1e-10);
	}

	@Test
	void normalized_unitVector_unchanged() {
		Vector4 v = new Vector4(1.0, 0.0, 0.0, 0.0);
		Vector4 n = v.normalized();
		assertEquals(1.0, n.length(), 1e-10);
	}

	@Test
	void normalized_1_2_2_4_normalizesTo0_2_0_4_0_4_0_8() {
		Vector4 v = new Vector4(1.0, 2.0, 2.0, 4.0);
		Vector4 n = v.normalized();
		assertEquals(0.2, n.x, 1e-10);
		assertEquals(0.4, n.y, 1e-10);
		assertEquals(0.4, n.z, 1e-10);
		assertEquals(0.8, n.w, 1e-10);
		assertEquals(1.0, n.length(), 1e-10);
	}

	@Test
	void normalized_zeroVectorReturnsZero() {
		Vector4 v = new Vector4(0.0, 0.0, 0.0, 0.0);
		Vector4 n = v.normalized();
		assertEquals(0.0, n.x, 1e-10);
		assertEquals(0.0, n.y, 1e-10);
		assertEquals(0.0, n.z, 1e-10);
		assertEquals(0.0, n.w, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Arithmetic operations
	// ------------------------------------------------------------------------

	@Test
	void add_twoVectors() {
		Vector4 a = new Vector4(1.0, 2.0, 3.0, 4.0);
		Vector4 b = new Vector4(5.0, 6.0, 7.0, 8.0);
		Vector4 result = a.add(b);
		assertEquals(6.0, result.x, 1e-10);
		assertEquals(8.0, result.y, 1e-10);
		assertEquals(10.0, result.z, 1e-10);
		assertEquals(12.0, result.w, 1e-10);
	}

	@Test
	void sub_twoVectors() {
		Vector4 a = new Vector4(10.0, 9.0, 8.0, 7.0);
		Vector4 b = new Vector4(2.0, 3.0, 4.0, 5.0);
		Vector4 result = a.sub(b);
		assertEquals(8.0, result.x, 1e-10);
		assertEquals(6.0, result.y, 1e-10);
		assertEquals(4.0, result.z, 1e-10);
		assertEquals(2.0, result.w, 1e-10);
	}

	@Test
	void mul_scalar() {
		Vector4 v = new Vector4(2.0, 3.0, 4.0, 5.0);
		Vector4 result = v.mul(2.0);
		assertEquals(4.0, result.x, 1e-10);
		assertEquals(6.0, result.y, 1e-10);
		assertEquals(8.0, result.z, 1e-10);
		assertEquals(10.0, result.w, 1e-10);
	}

	@Test
	void div_scalar() {
		Vector4 v = new Vector4(6.0, 8.0, 10.0, 12.0);
		Vector4 result = v.div(2.0);
		assertEquals(3.0, result.x, 1e-10);
		assertEquals(4.0, result.y, 1e-10);
		assertEquals(5.0, result.z, 1e-10);
		assertEquals(6.0, result.w, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Dot product
	// ------------------------------------------------------------------------

	@Test
	void dot_perpendicularVectors() {
		Vector4 a = new Vector4(1.0, 0.0, 0.0, 0.0);
		Vector4 b = new Vector4(0.0, 1.0, 0.0, 0.0);
		assertEquals(0.0, a.dot(b), 1e-10);
	}

	@Test
	void dot_parallelVectors() {
		Vector4 a = new Vector4(1.0, 0.0, 0.0, 0.0);
		Vector4 b = new Vector4(3.0, 0.0, 0.0, 0.0);
		assertEquals(3.0, a.dot(b), 1e-10);
	}

	@Test
	void dot_1_2_3_4_with_2_3_4_5() {
		Vector4 a = new Vector4(1.0, 2.0, 3.0, 4.0);
		Vector4 b = new Vector4(2.0, 3.0, 4.0, 5.0);
		// 1*2 + 2*3 + 3*4 + 4*5 = 2 + 6 + 12 + 20 = 40
		assertEquals(40.0, a.dot(b), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Lerp
	// ------------------------------------------------------------------------

	@Test
	void lerp_atT0() {
		Vector4 a = new Vector4(0.0, 0.0, 0.0, 0.0);
		Vector4 b = new Vector4(10.0, 20.0, 30.0, 40.0);
		Vector4 result = a.lerp(b, 0.0);
		assertEquals(0.0, result.x, 1e-10);
		assertEquals(0.0, result.y, 1e-10);
		assertEquals(0.0, result.z, 1e-10);
		assertEquals(0.0, result.w, 1e-10);
	}

	@Test
	void lerp_atT1() {
		Vector4 a = new Vector4(0.0, 0.0, 0.0, 0.0);
		Vector4 b = new Vector4(10.0, 20.0, 30.0, 40.0);
		Vector4 result = a.lerp(b, 1.0);
		assertEquals(10.0, result.x, 1e-10);
		assertEquals(20.0, result.y, 1e-10);
		assertEquals(30.0, result.z, 1e-10);
		assertEquals(40.0, result.w, 1e-10);
	}

	@Test
	void lerp_atMidpoint() {
		Vector4 a = new Vector4(0.0, 0.0, 0.0, 0.0);
		Vector4 b = new Vector4(10.0, 20.0, 30.0, 40.0);
		Vector4 result = a.lerp(b, 0.5);
		assertEquals(5.0, result.x, 1e-10);
		assertEquals(10.0, result.y, 1e-10);
		assertEquals(15.0, result.z, 1e-10);
		assertEquals(20.0, result.w, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Min/Max
	// ------------------------------------------------------------------------

	@Test
	void min_returnsComponentWiseMinimum() {
		Vector4 a = new Vector4(5.0, 8.0, 2.0, 10.0);
		Vector4 b = new Vector4(3.0, 10.0, 7.0, 5.0);
		Vector4 result = a.min(b);
		assertEquals(3.0, result.x, 1e-10);
		assertEquals(8.0, result.y, 1e-10);
		assertEquals(2.0, result.z, 1e-10);
		assertEquals(5.0, result.w, 1e-10);
	}

	@Test
	void max_returnsComponentWiseMaximum() {
		Vector4 a = new Vector4(5.0, 8.0, 2.0, 10.0);
		Vector4 b = new Vector4(3.0, 10.0, 7.0, 5.0);
		Vector4 result = a.max(b);
		assertEquals(5.0, result.x, 1e-10);
		assertEquals(10.0, result.y, 1e-10);
		assertEquals(7.0, result.z, 1e-10);
		assertEquals(10.0, result.w, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Element access
	// ------------------------------------------------------------------------

	@Test
	void axis_0ReturnsX() {
		Vector4 v = new Vector4(1.0, 2.0, 3.0, 4.0);
		assertEquals(1.0, v.axis(0), 1e-10);
	}

	@Test
	void axis_1ReturnsY() {
		Vector4 v = new Vector4(1.0, 2.0, 3.0, 4.0);
		assertEquals(2.0, v.axis(1), 1e-10);
	}

	@Test
	void axis_2ReturnsZ() {
		Vector4 v = new Vector4(1.0, 2.0, 3.0, 4.0);
		assertEquals(3.0, v.axis(2), 1e-10);
	}

	@Test
	void axis_3ReturnsW() {
		Vector4 v = new Vector4(1.0, 2.0, 3.0, 4.0);
		assertEquals(4.0, v.axis(3), 1e-10);
	}

	@Test
	void axis_invalidIndexThrows() {
		Vector4 v = new Vector4(1.0, 2.0, 3.0, 4.0);
		assertThrows(IndexOutOfBoundsException.class, () -> v.axis(4));
	}

	@Test
	void getters_setters() {
		Vector4 v = new Vector4();
		v.setX(1.0);
		v.setY(2.0);
		v.setZ(3.0);
		v.setW(4.0);
		assertEquals(1.0, v.getX(), 1e-10);
		assertEquals(2.0, v.getY(), 1e-10);
		assertEquals(3.0, v.getZ(), 1e-10);
		assertEquals(4.0, v.getW(), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Test
	void equals_sameVectorReturnsTrue() {
		Vector4 a = new Vector4(1.0, 2.0, 3.0, 4.0);
		Vector4 b = new Vector4(1.0, 2.0, 3.0, 4.0);
		assertTrue(a.equals(b));
	}

	@Test
	void equals_differentVectorReturnsFalse() {
		Vector4 a = new Vector4(1.0, 2.0, 3.0, 4.0);
		Vector4 b = new Vector4(5.0, 6.0, 7.0, 8.0);
		assertFalse(a.equals(b));
	}

	@Test
	void equals_withinEpsilonReturnsTrue() {
		Vector4 a = new Vector4(1.0, 2.0, 3.0, 4.0);
		Vector4 b = new Vector4(1.0 + 1e-11, 2.0 - 1e-11, 3.0 + 1e-11, 4.0 - 1e-11);
		assertTrue(a.equals(b));
	}

	@Test
	void hashCode_consistentForEqualVectors() {
		Vector4 a = new Vector4(1.0, 2.0, 3.0, 4.0);
		Vector4 b = new Vector4(1.0, 2.0, 3.0, 4.0);
		assertEquals(a.hashCode(), b.hashCode());
	}

	@Test
	void toString_containsValues() {
		Vector4 v = new Vector4(1.0, 2.0, 3.0, 4.0);
		String s = v.toString();
		assertTrue(s.contains("1.0"));
		assertTrue(s.contains("2.0"));
		assertTrue(s.contains("3.0"));
		assertTrue(s.contains("4.0"));
	}
}
