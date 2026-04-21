package org.godot.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Vector3 - Task 7.1. Tests arithmetic, normalization, dot/cross
 * products, lerp, and distance operations.
 */
public class Vector3Test {

	// ------------------------------------------------------------------------
	// Construction and constants
	// ------------------------------------------------------------------------

	@Test
	void constructor_defaultCreatesZeroVector() {
		Vector3 v = new Vector3();
		assertEquals(0.0, v.x);
		assertEquals(0.0, v.y);
		assertEquals(0.0, v.z);
	}

	@Test
	void constructor_withValues() {
		Vector3 v = new Vector3(1.0, 2.0, 3.0);
		assertEquals(1.0, v.x);
		assertEquals(2.0, v.y);
		assertEquals(3.0, v.z);
	}

	@Test
	void constants_zeroIsCorrect() {
		assertEquals(0.0, Vector3.ZERO.x);
		assertEquals(0.0, Vector3.ZERO.y);
		assertEquals(0.0, Vector3.ZERO.z);
	}

	@Test
	void constants_oneIsCorrect() {
		assertEquals(1.0, Vector3.ONE.x);
		assertEquals(1.0, Vector3.ONE.y);
		assertEquals(1.0, Vector3.ONE.z);
	}

	@Test
	void constants_upIsCorrect() {
		assertEquals(0.0, Vector3.UP.x);
		assertEquals(1.0, Vector3.UP.y);
		assertEquals(0.0, Vector3.UP.z);
	}

	// ------------------------------------------------------------------------
	// Length and normalization
	// ------------------------------------------------------------------------

	@Test
	void length_3_4_5_5Triangle() {
		// sqrt(3^2 + 4^2 + 5^2) = sqrt(9 + 16 + 25) = sqrt(50) ≈ 7.07
		Vector3 v = new Vector3(3.0, 4.0, 5.0);
		assertEquals(Math.sqrt(50.0), v.length(), 1e-10);
	}

	@Test
	void length_squared_3_4_5() {
		Vector3 v = new Vector3(3.0, 4.0, 5.0);
		assertEquals(50.0, v.lengthSquared(), 1e-10);
	}

	@Test
	void length_unitVector() {
		Vector3 v = new Vector3(1.0, 0.0, 0.0);
		assertEquals(1.0, v.length(), 1e-10);
	}

	@Test
	void length_zeroVector() {
		Vector3 v = new Vector3(0.0, 0.0, 0.0);
		assertEquals(0.0, v.length(), 1e-10);
	}

	@Test
	void normalized_unitVector_unchanged() {
		Vector3 v = new Vector3(1.0, 0.0, 0.0);
		Vector3 n = v.normalized();
		assertEquals(1.0, n.length(), 1e-10);
		assertEquals(1.0, n.x, 1e-10);
		assertEquals(0.0, n.y, 1e-10);
		assertEquals(0.0, n.z, 1e-10);
	}

	@Test
	void normalized_3_4_5_normalizesToProperUnitVector() {
		Vector3 v = new Vector3(3.0, 4.0, 5.0);
		double len = Math.sqrt(50.0);
		Vector3 n = v.normalized();
		assertEquals(3.0 / len, n.x, 1e-10);
		assertEquals(4.0 / len, n.y, 1e-10);
		assertEquals(5.0 / len, n.z, 1e-10);
		assertEquals(1.0, n.length(), 1e-10);
	}

	@Test
	void normalized_zeroVectorReturnsZero() {
		Vector3 v = new Vector3(0.0, 0.0, 0.0);
		Vector3 n = v.normalized();
		assertEquals(0.0, n.x, 1e-10);
		assertEquals(0.0, n.y, 1e-10);
		assertEquals(0.0, n.z, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Arithmetic operations
	// ------------------------------------------------------------------------

	@Test
	void add_twoVectors() {
		Vector3 a = new Vector3(1.0, 2.0, 3.0);
		Vector3 b = new Vector3(4.0, 5.0, 6.0);
		Vector3 result = a.add(b);
		assertEquals(5.0, result.x, 1e-10);
		assertEquals(7.0, result.y, 1e-10);
		assertEquals(9.0, result.z, 1e-10);
	}

	@Test
	void sub_twoVectors() {
		Vector3 a = new Vector3(7.0, 8.0, 9.0);
		Vector3 b = new Vector3(2.0, 3.0, 4.0);
		Vector3 result = a.sub(b);
		assertEquals(5.0, result.x, 1e-10);
		assertEquals(5.0, result.y, 1e-10);
		assertEquals(5.0, result.z, 1e-10);
	}

	@Test
	void mul_scalar() {
		Vector3 v = new Vector3(2.0, 3.0, 4.0);
		Vector3 result = v.mul(2.0);
		assertEquals(4.0, result.x, 1e-10);
		assertEquals(6.0, result.y, 1e-10);
		assertEquals(8.0, result.z, 1e-10);
	}

	@Test
	void div_scalar() {
		Vector3 v = new Vector3(6.0, 8.0, 10.0);
		Vector3 result = v.div(2.0);
		assertEquals(3.0, result.x, 1e-10);
		assertEquals(4.0, result.y, 1e-10);
		assertEquals(5.0, result.z, 1e-10);
	}

	@Test
	void add_doesNotMutateOriginal() {
		Vector3 a = new Vector3(1.0, 2.0, 3.0);
		Vector3 b = new Vector3(4.0, 5.0, 6.0);
		a.add(b);
		assertEquals(1.0, a.x, 1e-10);
		assertEquals(2.0, a.y, 1e-10);
		assertEquals(3.0, a.z, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Dot and cross products
	// ------------------------------------------------------------------------

	@Test
	void dot_perpendicularVectors() {
		// (1,0,0) dot (0,1,0) = 0
		Vector3 a = new Vector3(1.0, 0.0, 0.0);
		Vector3 b = new Vector3(0.0, 1.0, 0.0);
		assertEquals(0.0, a.dot(b), 1e-10);
	}

	@Test
	void dot_parallelVectors() {
		// (1,0,0) dot (3,0,0) = 3
		Vector3 a = new Vector3(1.0, 0.0, 0.0);
		Vector3 b = new Vector3(3.0, 0.0, 0.0);
		assertEquals(3.0, a.dot(b), 1e-10);
	}

	@Test
	void dot_1_2_3_with_4_5_6() {
		Vector3 a = new Vector3(1.0, 2.0, 3.0);
		Vector3 b = new Vector3(4.0, 5.0, 6.0);
		// 1*4 + 2*5 + 3*6 = 4 + 10 + 18 = 32
		assertEquals(32.0, a.dot(b), 1e-10);
	}

	@Test
	void cross_returnsPerpendicularVector() {
		// (1,0,0) cross (0,1,0) = (0,0,1)
		Vector3 a = new Vector3(1.0, 0.0, 0.0);
		Vector3 b = new Vector3(0.0, 1.0, 0.0);
		Vector3 result = a.cross(b);
		assertEquals(0.0, result.x, 1e-10);
		assertEquals(0.0, result.y, 1e-10);
		assertEquals(1.0, result.z, 1e-10);
	}

	@Test
	void cross_reversesSign() {
		// (0,1,0) cross (1,0,0) = (0,0,-1)
		Vector3 a = new Vector3(0.0, 1.0, 0.0);
		Vector3 b = new Vector3(1.0, 0.0, 0.0);
		Vector3 result = a.cross(b);
		assertEquals(0.0, result.x, 1e-10);
		assertEquals(0.0, result.y, 1e-10);
		assertEquals(-1.0, result.z, 1e-10);
	}

	@Test
	void cross_followsRightHandRule() {
		// x cross y = z
		assertEquals(new Vector3(0, 0, 1), new Vector3(1, 0, 0).cross(new Vector3(0, 1, 0)));
		// y cross z = x
		assertEquals(new Vector3(1, 0, 0), new Vector3(0, 1, 0).cross(new Vector3(0, 0, 1)));
		// z cross x = y
		assertEquals(new Vector3(0, 1, 0), new Vector3(0, 0, 1).cross(new Vector3(1, 0, 0)));
	}

	// ------------------------------------------------------------------------
	// Distance operations
	// ------------------------------------------------------------------------

	@Test
	void distanceTo_samePoint() {
		Vector3 a = new Vector3(1.0, 2.0, 3.0);
		Vector3 b = new Vector3(1.0, 2.0, 3.0);
		assertEquals(0.0, a.distanceTo(b), 1e-10);
	}

	@Test
	void distanceTo_diagonalDistance() {
		// Distance from (0,0,0) to (3,4,5) = sqrt(9 + 16 + 25) = sqrt(50)
		Vector3 a = new Vector3(0.0, 0.0, 0.0);
		Vector3 b = new Vector3(3.0, 4.0, 5.0);
		assertEquals(Math.sqrt(50.0), a.distanceTo(b), 1e-10);
	}

	@Test
	void distanceSquaredTo() {
		Vector3 a = new Vector3(0.0, 0.0, 0.0);
		Vector3 b = new Vector3(3.0, 4.0, 5.0);
		assertEquals(50.0, a.distanceSquaredTo(b), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Lerp
	// ------------------------------------------------------------------------

	@Test
	void lerp_atT0() {
		Vector3 a = new Vector3(0.0, 0.0, 0.0);
		Vector3 b = new Vector3(10.0, 20.0, 30.0);
		Vector3 result = a.lerp(b, 0.0);
		assertEquals(0.0, result.x, 1e-10);
		assertEquals(0.0, result.y, 1e-10);
		assertEquals(0.0, result.z, 1e-10);
	}

	@Test
	void lerp_atT1() {
		Vector3 a = new Vector3(0.0, 0.0, 0.0);
		Vector3 b = new Vector3(10.0, 20.0, 30.0);
		Vector3 result = a.lerp(b, 1.0);
		assertEquals(10.0, result.x, 1e-10);
		assertEquals(20.0, result.y, 1e-10);
		assertEquals(30.0, result.z, 1e-10);
	}

	@Test
	void lerp_atMidpoint() {
		Vector3 a = new Vector3(0.0, 0.0, 0.0);
		Vector3 b = new Vector3(10.0, 20.0, 30.0);
		Vector3 result = a.lerp(b, 0.5);
		assertEquals(5.0, result.x, 1e-10);
		assertEquals(10.0, result.y, 1e-10);
		assertEquals(15.0, result.z, 1e-10);
	}

	@Test
	void lerp_beyondReturnsExtrapolation() {
		Vector3 a = new Vector3(0.0, 0.0, 0.0);
		Vector3 b = new Vector3(10.0, 20.0, 30.0);
		Vector3 result = a.lerp(b, 2.0);
		assertEquals(20.0, result.x, 1e-10);
		assertEquals(40.0, result.y, 1e-10);
		assertEquals(60.0, result.z, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Min/Max
	// ------------------------------------------------------------------------

	@Test
	void min_returnsComponentWiseMinimum() {
		Vector3 a = new Vector3(5.0, 8.0, 2.0);
		Vector3 b = new Vector3(3.0, 10.0, 7.0);
		Vector3 result = a.min(b);
		assertEquals(3.0, result.x, 1e-10);
		assertEquals(8.0, result.y, 1e-10);
		assertEquals(2.0, result.z, 1e-10);
	}

	@Test
	void max_returnsComponentWiseMaximum() {
		Vector3 a = new Vector3(5.0, 8.0, 2.0);
		Vector3 b = new Vector3(3.0, 10.0, 7.0);
		Vector3 result = a.max(b);
		assertEquals(5.0, result.x, 1e-10);
		assertEquals(10.0, result.y, 1e-10);
		assertEquals(7.0, result.z, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Element access
	// ------------------------------------------------------------------------

	@Test
	void axis_0ReturnsX() {
		Vector3 v = new Vector3(3.0, 4.0, 5.0);
		assertEquals(3.0, v.axis(0), 1e-10);
	}

	@Test
	void axis_1ReturnsY() {
		Vector3 v = new Vector3(3.0, 4.0, 5.0);
		assertEquals(4.0, v.axis(1), 1e-10);
	}

	@Test
	void axis_2ReturnsZ() {
		Vector3 v = new Vector3(3.0, 4.0, 5.0);
		assertEquals(5.0, v.axis(2), 1e-10);
	}

	@Test
	void axis_invalidIndexThrows() {
		Vector3 v = new Vector3(3.0, 4.0, 5.0);
		assertThrows(IndexOutOfBoundsException.class, () -> v.axis(3));
	}

	@Test
	void getters_setters() {
		Vector3 v = new Vector3();
		v.setX(5.0);
		v.setY(10.0);
		v.setZ(15.0);
		assertEquals(5.0, v.getX(), 1e-10);
		assertEquals(10.0, v.getY(), 1e-10);
		assertEquals(15.0, v.getZ(), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Test
	void equals_sameVectorReturnsTrue() {
		Vector3 a = new Vector3(3.0, 4.0, 5.0);
		Vector3 b = new Vector3(3.0, 4.0, 5.0);
		assertTrue(a.equals(b));
	}

	@Test
	void equals_differentVectorReturnsFalse() {
		Vector3 a = new Vector3(3.0, 4.0, 5.0);
		Vector3 b = new Vector3(6.0, 7.0, 8.0);
		assertFalse(a.equals(b));
	}

	@Test
	void equals_withinEpsilonReturnsTrue() {
		Vector3 a = new Vector3(3.0, 4.0, 5.0);
		Vector3 b = new Vector3(3.0 + 1e-11, 4.0 - 1e-11, 5.0 + 1e-11);
		assertTrue(a.equals(b));
	}

	@Test
	void hashCode_consistentForEqualVectors() {
		Vector3 a = new Vector3(3.0, 4.0, 5.0);
		Vector3 b = new Vector3(3.0, 4.0, 5.0);
		assertEquals(a.hashCode(), b.hashCode());
	}

	@Test
	void toString_containsValues() {
		Vector3 v = new Vector3(3.0, 4.0, 5.0);
		String s = v.toString();
		assertTrue(s.contains("3.0"));
		assertTrue(s.contains("4.0"));
		assertTrue(s.contains("5.0"));
	}
}
