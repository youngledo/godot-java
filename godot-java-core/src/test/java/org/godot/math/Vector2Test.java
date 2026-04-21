package org.godot.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Vector2 - Task 7.1. Tests arithmetic, normalization, dot/cross
 * products, lerp, and distance operations.
 */
public class Vector2Test {

	// ------------------------------------------------------------------------
	// Construction and constants
	// ------------------------------------------------------------------------

	@Test
	void constructor_defaultCreatesZeroVector() {
		Vector2 v = new Vector2();
		assertEquals(0.0, v.x);
		assertEquals(0.0, v.y);
	}

	@Test
	void constructor_withValues() {
		Vector2 v = new Vector2(3.0, 4.0);
		assertEquals(3.0, v.x);
		assertEquals(4.0, v.y);
	}

	@Test
	void constants_zeroIsCorrect() {
		assertEquals(0.0, Vector2.ZERO.x);
		assertEquals(0.0, Vector2.ZERO.y);
	}

	@Test
	void constants_oneIsCorrect() {
		assertEquals(1.0, Vector2.ONE.x);
		assertEquals(1.0, Vector2.ONE.y);
	}

	// ------------------------------------------------------------------------
	// Length and normalization
	// ------------------------------------------------------------------------

	@Test
	void length_3_4_5Triangle() {
		Vector2 v = new Vector2(3.0, 4.0);
		assertEquals(5.0, v.length(), 1e-10);
	}

	@Test
	void length_squared_3_4_5Triangle() {
		Vector2 v = new Vector2(3.0, 4.0);
		assertEquals(25.0, v.lengthSquared(), 1e-10);
	}

	@Test
	void length_unitVector() {
		Vector2 v = new Vector2(1.0, 0.0);
		assertEquals(1.0, v.length(), 1e-10);
	}

	@Test
	void length_zeroVector() {
		Vector2 v = new Vector2(0.0, 0.0);
		assertEquals(0.0, v.length(), 1e-10);
	}

	@Test
	void normalized_unitVector_unchanged() {
		Vector2 v = new Vector2(1.0, 0.0);
		Vector2 n = v.normalized();
		assertEquals(1.0, n.length(), 1e-10);
		assertEquals(1.0, n.x, 1e-10);
		assertEquals(0.0, n.y, 1e-10);
	}

	@Test
	void normalized_3_4_normalizesTo0_6_0_8() {
		Vector2 v = new Vector2(3.0, 4.0);
		Vector2 n = v.normalized();
		assertEquals(0.6, n.x, 1e-10);
		assertEquals(0.8, n.y, 1e-10);
	}

	@Test
	void normalized_zeroVectorReturnsZero() {
		Vector2 v = new Vector2(0.0, 0.0);
		Vector2 n = v.normalized();
		assertEquals(0.0, n.x, 1e-10);
		assertEquals(0.0, n.y, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Arithmetic operations
	// ------------------------------------------------------------------------

	@Test
	void add_twoVectors() {
		Vector2 a = new Vector2(1.0, 2.0);
		Vector2 b = new Vector2(3.0, 4.0);
		Vector2 result = a.add(b);
		assertEquals(4.0, result.x, 1e-10);
		assertEquals(6.0, result.y, 1e-10);
	}

	@Test
	void sub_twoVectors() {
		Vector2 a = new Vector2(5.0, 7.0);
		Vector2 b = new Vector2(2.0, 3.0);
		Vector2 result = a.sub(b);
		assertEquals(3.0, result.x, 1e-10);
		assertEquals(4.0, result.y, 1e-10);
	}

	@Test
	void mul_scalar() {
		Vector2 v = new Vector2(2.0, 3.0);
		Vector2 result = v.mul(2.0);
		assertEquals(4.0, result.x, 1e-10);
		assertEquals(6.0, result.y, 1e-10);
	}

	@Test
	void div_scalar() {
		Vector2 v = new Vector2(6.0, 8.0);
		Vector2 result = v.div(2.0);
		assertEquals(3.0, result.x, 1e-10);
		assertEquals(4.0, result.y, 1e-10);
	}

	@Test
	void add_doesNotMutateOriginal() {
		Vector2 a = new Vector2(1.0, 2.0);
		Vector2 b = new Vector2(3.0, 4.0);
		a.add(b);
		assertEquals(1.0, a.x, 1e-10);
		assertEquals(2.0, a.y, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Dot and cross products
	// ------------------------------------------------------------------------

	@Test
	void dot_perpendicularVectors() {
		// (1,0) dot (0,1) = 0
		Vector2 a = new Vector2(1.0, 0.0);
		Vector2 b = new Vector2(0.0, 1.0);
		assertEquals(0.0, a.dot(b), 1e-10);
	}

	@Test
	void dot_parallelVectors() {
		// (1,0) dot (3,0) = 3
		Vector2 a = new Vector2(1.0, 0.0);
		Vector2 b = new Vector2(3.0, 0.0);
		assertEquals(3.0, a.dot(b), 1e-10);
	}

	@Test
	void dot_3_4_with_2_1() {
		Vector2 a = new Vector2(3.0, 4.0);
		Vector2 b = new Vector2(2.0, 1.0);
		assertEquals(10.0, a.dot(b), 1e-10); // 3*2 + 4*1 = 10
	}

	@Test
	void cross_returnsSignedScalar() {
		// (1,0) cross (0,1) = 1*1 - 0*0 = 1
		Vector2 a = new Vector2(1.0, 0.0);
		Vector2 b = new Vector2(0.0, 1.0);
		assertEquals(1.0, a.cross(b), 1e-10);
	}

	@Test
	void cross_reversesSign() {
		// (0,1) cross (1,0) = 0*0 - 1*1 = -1
		Vector2 a = new Vector2(0.0, 1.0);
		Vector2 b = new Vector2(1.0, 0.0);
		assertEquals(-1.0, a.cross(b), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Distance operations
	// ------------------------------------------------------------------------

	@Test
	void distanceTo_samePoint() {
		Vector2 a = new Vector2(3.0, 4.0);
		Vector2 b = new Vector2(3.0, 4.0);
		assertEquals(0.0, a.distanceTo(b), 1e-10);
	}

	@Test
	void distanceTo_3_4_to_0_0() {
		Vector2 a = new Vector2(3.0, 4.0);
		Vector2 b = new Vector2(0.0, 0.0);
		assertEquals(5.0, a.distanceTo(b), 1e-10);
	}

	@Test
	void distanceSquaredTo() {
		Vector2 a = new Vector2(3.0, 4.0);
		Vector2 b = new Vector2(0.0, 0.0);
		assertEquals(25.0, a.distanceSquaredTo(b), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Lerp
	// ------------------------------------------------------------------------

	@Test
	void lerp_atT0() {
		Vector2 a = new Vector2(0.0, 0.0);
		Vector2 b = new Vector2(10.0, 20.0);
		Vector2 result = a.lerp(b, 0.0);
		assertEquals(0.0, result.x, 1e-10);
		assertEquals(0.0, result.y, 1e-10);
	}

	@Test
	void lerp_atT1() {
		Vector2 a = new Vector2(0.0, 0.0);
		Vector2 b = new Vector2(10.0, 20.0);
		Vector2 result = a.lerp(b, 1.0);
		assertEquals(10.0, result.x, 1e-10);
		assertEquals(20.0, result.y, 1e-10);
	}

	@Test
	void lerp_atMidpoint() {
		Vector2 a = new Vector2(0.0, 0.0);
		Vector2 b = new Vector2(10.0, 20.0);
		Vector2 result = a.lerp(b, 0.5);
		assertEquals(5.0, result.x, 1e-10);
		assertEquals(10.0, result.y, 1e-10);
	}

	@Test
	void lerp_beyondReturnsExtrapolation() {
		Vector2 a = new Vector2(0.0, 0.0);
		Vector2 b = new Vector2(10.0, 20.0);
		Vector2 result = a.lerp(b, 2.0);
		assertEquals(20.0, result.x, 1e-10);
		assertEquals(40.0, result.y, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Min/Max
	// ------------------------------------------------------------------------

	@Test
	void min_returnsComponentWiseMinimum() {
		Vector2 a = new Vector2(5.0, 8.0);
		Vector2 b = new Vector2(3.0, 10.0);
		Vector2 result = a.min(b);
		assertEquals(3.0, result.x, 1e-10);
		assertEquals(8.0, result.y, 1e-10);
	}

	@Test
	void max_returnsComponentWiseMaximum() {
		Vector2 a = new Vector2(5.0, 8.0);
		Vector2 b = new Vector2(3.0, 10.0);
		Vector2 result = a.max(b);
		assertEquals(5.0, result.x, 1e-10);
		assertEquals(10.0, result.y, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Element access
	// ------------------------------------------------------------------------

	@Test
	void axis_0ReturnsX() {
		Vector2 v = new Vector2(3.0, 4.0);
		assertEquals(3.0, v.axis(0), 1e-10);
	}

	@Test
	void axis_1ReturnsY() {
		Vector2 v = new Vector2(3.0, 4.0);
		assertEquals(4.0, v.axis(1), 1e-10);
	}

	@Test
	void axis_invalidIndexReturnsY() {
		// axis() returns y for any index != 0 (no exception)
		Vector2 v = new Vector2(3.0, 4.0);
		assertEquals(4.0, v.axis(2), 1e-10); // returns y
	}

	@Test
	void getters_setters() {
		Vector2 v = new Vector2();
		v.setX(5.0);
		v.setY(10.0);
		assertEquals(5.0, v.getX(), 1e-10);
		assertEquals(10.0, v.getY(), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Test
	void equals_sameVectorReturnsTrue() {
		Vector2 a = new Vector2(3.0, 4.0);
		Vector2 b = new Vector2(3.0, 4.0);
		assertTrue(a.equals(b));
	}

	@Test
	void equals_differentVectorReturnsFalse() {
		Vector2 a = new Vector2(3.0, 4.0);
		Vector2 b = new Vector2(5.0, 6.0);
		assertFalse(a.equals(b));
	}

	@Test
	void equals_withinEpsilonReturnsTrue() {
		Vector2 a = new Vector2(3.0, 4.0);
		Vector2 b = new Vector2(3.0 + 1e-11, 4.0 - 1e-11);
		assertTrue(a.equals(b));
	}

	@Test
	void hashCode_consistentForEqualVectors() {
		Vector2 a = new Vector2(3.0, 4.0);
		Vector2 b = new Vector2(3.0, 4.0);
		assertEquals(a.hashCode(), b.hashCode());
	}

	@Test
	void toString_containsValues() {
		Vector2 v = new Vector2(3.0, 4.0);
		String s = v.toString();
		assertTrue(s.contains("3.0"));
		assertTrue(s.contains("4.0"));
	}
}
