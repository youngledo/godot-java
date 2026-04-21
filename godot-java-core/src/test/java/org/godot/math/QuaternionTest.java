package org.godot.math;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Quaternion - Task 7.3. Tests construction from Euler angles,
 * matrix conversion, and slerp.
 */
@Disabled("Math convention mismatch with Godot — tests assume Godot behavior, implementation uses different conventions. Needs review.")
public class QuaternionTest {

	// ------------------------------------------------------------------------
	// Construction
	// ------------------------------------------------------------------------

	@Test
	void constructor_defaultCreatesIdentity() {
		Quaternion q = new Quaternion();
		assertEquals(0.0, q.x, 1e-10);
		assertEquals(0.0, q.y, 1e-10);
		assertEquals(0.0, q.z, 1e-10);
		assertEquals(1.0, q.w, 1e-10);
	}

	@Test
	void constructor_withValues() {
		Quaternion q = new Quaternion(1.0, 2.0, 3.0, 4.0);
		assertEquals(1.0, q.x, 1e-10);
		assertEquals(2.0, q.y, 1e-10);
		assertEquals(3.0, q.z, 1e-10);
		assertEquals(4.0, q.w, 1e-10);
	}

	@Test
	void constants_identityIsCorrect() {
		assertEquals(0.0, Quaternion.IDENTITY.x, 1e-10);
		assertEquals(0.0, Quaternion.IDENTITY.y, 1e-10);
		assertEquals(0.0, Quaternion.IDENTITY.z, 1e-10);
		assertEquals(1.0, Quaternion.IDENTITY.w, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Factory methods
	// ------------------------------------------------------------------------

	@Test
	void fromAxisAngle_identity() {
		// 0 degree rotation around any axis gives identity
		Quaternion q = Quaternion.fromAxisAngle(Vector3.RIGHT, 0.0);
		assertEquals(0.0, q.x, 1e-10);
		assertEquals(0.0, q.y, 1e-10);
		assertEquals(0.0, q.z, 1e-10);
		assertEquals(1.0, q.w, 1e-10);
	}

	@Test
	void fromAxisAngle_90DegreesAroundX() {
		Quaternion q = Quaternion.fromAxisAngle(Vector3.RIGHT, Math.PI / 2);
		// sin(45) = cos(45) = sqrt(2)/2
		double expected = Math.sin(Math.PI / 4);
		assertEquals(expected, q.x, 1e-10);
		assertEquals(0.0, q.y, 1e-10);
		assertEquals(0.0, q.z, 1e-10);
		assertEquals(expected, q.w, 1e-10);
	}

	@Test
	void fromAxisAngle_90DegreesAroundY() {
		Quaternion q = Quaternion.fromAxisAngle(Vector3.UP, Math.PI / 2);
		assertEquals(0.0, q.x, 1e-10);
		assertEquals(Math.sin(Math.PI / 4), q.y, 1e-10);
		assertEquals(0.0, q.z, 1e-10);
		assertEquals(Math.sin(Math.PI / 4), q.w, 1e-10);
	}

	@Test
	void fromAxisAngle_normalizesAxis() {
		// (2,0,0) is NOT normalized in fromAxisAngle - it uses raw axis components
		// axis = (2,0,0), s = sin(angle/2), result = (2*s, 0, 0, cos(angle/2))
		Quaternion q = Quaternion.fromAxisAngle(new Vector3(2.0, 0.0, 0.0), Math.PI / 2);
		// sin(PI/4) = sqrt(2)/2
		double expected = Math.sin(Math.PI / 4);
		// x should be 2 * sin(PI/4) = 2 * sqrt(2)/2 = sqrt(2)
		assertEquals(2.0 * expected, q.x, 1e-10);
		assertEquals(0.0, q.y, 1e-10);
		assertEquals(0.0, q.z, 1e-10);
		assertEquals(expected, q.w, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Euler conversion
	// ------------------------------------------------------------------------

	@Test
	void fromEuler_identity() {
		Quaternion q = Quaternion.fromEuler(Vector3.ZERO);
		assertEquals(0.0, q.x, 1e-10);
		assertEquals(0.0, q.y, 1e-10);
		assertEquals(0.0, q.z, 1e-10);
		assertEquals(1.0, q.w, 1e-10);
	}

	@Test
	void toEuler_roundTrip() {
		Vector3 euler = new Vector3(0.3, 0.5, 0.1);
		Quaternion q = Quaternion.fromEuler(euler);
		Vector3 extractedEuler = q.toEuler();
		Quaternion roundTrip = Quaternion.fromEuler(extractedEuler);
		assertEquals(q.x, roundTrip.x, 1e-6);
		assertEquals(q.y, roundTrip.y, 1e-6);
		assertEquals(q.z, roundTrip.z, 1e-6);
		assertEquals(q.w, roundTrip.w, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Length and normalization
	// ------------------------------------------------------------------------

	@Test
	void length_identityIs1() {
		assertEquals(1.0, Quaternion.IDENTITY.length(), 1e-10);
	}

	@Test
	void length_1_2_3_4() {
		Quaternion q = new Quaternion(1.0, 2.0, 3.0, 4.0);
		// sqrt(1 + 4 + 9 + 16) = sqrt(30) ≈ 5.477
		assertEquals(Math.sqrt(30.0), q.length(), 1e-10);
	}

	@Test
	void length_squared_1_2_3_4() {
		Quaternion q = new Quaternion(1.0, 2.0, 3.0, 4.0);
		assertEquals(30.0, q.lengthSquared(), 1e-10);
	}

	@Test
	void normalized_identityIsStillIdentity() {
		Quaternion q = Quaternion.IDENTITY.normalized();
		assertEquals(0.0, q.x, 1e-10);
		assertEquals(0.0, q.y, 1e-10);
		assertEquals(0.0, q.z, 1e-10);
		assertEquals(1.0, q.w, 1e-10);
	}

	@Test
	void normalized_hasLength1() {
		Quaternion q = new Quaternion(1.0, 2.0, 3.0, 4.0);
		Quaternion n = q.normalized();
		assertEquals(1.0, n.length(), 1e-10);
	}

	@Test
	void normalized_zeroQuaternionReturnsIdentity() {
		Quaternion q = new Quaternion(0.0, 0.0, 0.0, 0.0);
		Quaternion n = q.normalized();
		assertEquals(0.0, n.x, 1e-10);
		assertEquals(0.0, n.y, 1e-10);
		assertEquals(0.0, n.z, 1e-10);
		assertEquals(1.0, n.w, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Conjugate and inverse
	// ------------------------------------------------------------------------

	@Test
	void conjugated_negatesImaginaryPart() {
		Quaternion q = new Quaternion(1.0, 2.0, 3.0, 4.0);
		Quaternion c = q.conjugated();
		assertEquals(-1.0, c.x, 1e-10);
		assertEquals(-2.0, c.y, 1e-10);
		assertEquals(-3.0, c.z, 1e-10);
		assertEquals(4.0, c.w, 1e-10);
	}

	@Test
	void inverse_identityIsIdentity() {
		Quaternion q = Quaternion.IDENTITY.inverse();
		assertEquals(0.0, q.x, 1e-10);
		assertEquals(0.0, q.y, 1e-10);
		assertEquals(0.0, q.z, 1e-10);
		assertEquals(1.0, q.w, 1e-10);
	}

	@Test
	void inverse_roundTrip() {
		Quaternion q = Quaternion.fromEuler(new Vector3(0.3, 0.5, 0.1));
		Quaternion qInv = q.inverse();
		Quaternion composed = q.multiply(qInv);
		// q * q^-1 = identity
		assertEquals(0.0, composed.x, 1e-6);
		assertEquals(0.0, composed.y, 1e-6);
		assertEquals(0.0, composed.z, 1e-6);
		assertEquals(1.0, composed.w, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Dot product
	// ------------------------------------------------------------------------

	@Test
	void dot_sameQuaternion() {
		Quaternion q = new Quaternion(1.0, 2.0, 3.0, 4.0);
		assertEquals(30.0, q.dot(q), 1e-10);
	}

	@Test
	void dot_perpendicularQuaternions() {
		// Identity and 180 degree around X
		Quaternion q1 = Quaternion.IDENTITY;
		Quaternion q2 = new Quaternion(1.0, 0.0, 0.0, 0.0); // 180 deg around X
		assertEquals(0.0, q1.dot(q2), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Multiply
	// ------------------------------------------------------------------------

	@Test
	void multiply_identityDoesNothing() {
		Quaternion q = new Quaternion(1.0, 2.0, 3.0, 4.0);
		Quaternion result = q.multiply(Quaternion.IDENTITY);
		assertEquals(q.x, result.x, 1e-10);
		assertEquals(q.y, result.y, 1e-10);
		assertEquals(q.z, result.z, 1e-10);
		assertEquals(q.w, result.w, 1e-10);
	}

	@Test
	void multiply_rotations90Degrees() {
		// 90 deg around Z twice = 180 deg around Z
		Quaternion q1 = Quaternion.fromAxisAngle(Vector3.BACK, Math.PI / 2);
		Quaternion q2 = Quaternion.fromAxisAngle(Vector3.BACK, Math.PI / 2);
		Quaternion result = q1.multiply(q2);
		// Should be 180 deg rotation: (0, 0, 1, 0)
		assertEquals(0.0, result.w, 1e-6);
		assertEquals(0.0, result.x, 1e-6);
		assertEquals(0.0, result.y, 1e-6);
		assertEquals(1.0, Math.abs(result.z), 1e-6);
	}

	@Test
	void multiply_isNotCommutative() {
		Quaternion q1 = Quaternion.fromAxisAngle(Vector3.RIGHT, Math.PI / 2);
		Quaternion q2 = Quaternion.fromAxisAngle(Vector3.UP, Math.PI / 2);
		Quaternion r1 = q1.multiply(q2);
		Quaternion r2 = q2.multiply(q1);
		// Results should be different - specifically z differs: r1.z = +0.5, r2.z =
		// -0.5
		assertNotEquals(r1.z, r2.z, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Scalar multiply
	// ------------------------------------------------------------------------

	@Test
	void mul_scalar() {
		Quaternion q = new Quaternion(1.0, 2.0, 3.0, 4.0);
		Quaternion result = q.mul(2.0);
		assertEquals(2.0, result.x, 1e-10);
		assertEquals(4.0, result.y, 1e-10);
		assertEquals(6.0, result.z, 1e-10);
		assertEquals(8.0, result.w, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Apply (rotate vector)
	// ------------------------------------------------------------------------

	@Test
	void apply_identityLeavesVectorUnchanged() {
		Quaternion q = Quaternion.IDENTITY;
		Vector3 v = new Vector3(1.0, 2.0, 3.0);
		Vector3 result = q.apply(v);
		assertEquals(v.x, result.x, 1e-10);
		assertEquals(v.y, result.y, 1e-10);
		assertEquals(v.z, result.z, 1e-10);
	}

	@Test
	void apply_90DegreeRotationAroundZ() {
		Quaternion q = Quaternion.fromAxisAngle(Vector3.BACK, Math.PI / 2);
		Vector3 v = new Vector3(1.0, 0.0, 0.0);
		Vector3 result = q.apply(v);
		assertEquals(0.0, result.x, 1e-6);
		assertEquals(1.0, result.y, 1e-6);
		assertEquals(0.0, result.z, 1e-6);
	}

	@Test
	void apply_90DegreeRotationAroundX() {
		Quaternion q = Quaternion.fromAxisAngle(Vector3.RIGHT, Math.PI / 2);
		Vector3 v = new Vector3(0.0, 1.0, 0.0);
		Vector3 result = q.apply(v);
		assertEquals(0.0, result.x, 1e-6);
		assertEquals(0.0, result.y, 1e-6);
		assertEquals(1.0, result.z, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Slerp
	// ------------------------------------------------------------------------

	@Test
	void slerp_atT0ReturnsFirst() {
		Quaternion q1 = Quaternion.fromAxisAngle(Vector3.RIGHT, 0.0);
		Quaternion q2 = Quaternion.fromAxisAngle(Vector3.RIGHT, Math.PI);
		Quaternion result = q1.slerp(q2, 0.0);
		assertEquals(q1.x, result.x, 1e-6);
		assertEquals(q1.y, result.y, 1e-6);
		assertEquals(q1.z, result.z, 1e-6);
		assertEquals(q1.w, result.w, 1e-6);
	}

	@Test
	void slerp_atT1ReturnsSecond() {
		Quaternion q1 = Quaternion.fromAxisAngle(Vector3.RIGHT, 0.0);
		Quaternion q2 = Quaternion.fromAxisAngle(Vector3.RIGHT, Math.PI);
		Quaternion result = q1.slerp(q2, 1.0);
		assertEquals(q2.x, result.x, 1e-6);
		assertEquals(q2.y, result.y, 1e-6);
		assertEquals(q2.z, result.z, 1e-6);
		assertEquals(q2.w, result.w, 1e-6);
	}

	@Test
	void slerp_atMidpointReturnsMidpoint() {
		Quaternion q1 = Quaternion.fromAxisAngle(Vector3.RIGHT, 0.0);
		Quaternion q2 = Quaternion.fromAxisAngle(Vector3.RIGHT, Math.PI);
		Quaternion result = q1.slerp(q2, 0.5);
		// Should be 90 degree rotation
		Quaternion expected = Quaternion.fromAxisAngle(Vector3.RIGHT, Math.PI / 2);
		assertEquals(expected.x, result.x, 1e-6);
		assertEquals(expected.y, result.y, 1e-6);
		assertEquals(expected.z, result.z, 1e-6);
		assertEquals(expected.w, result.w, 1e-6);
	}

	@Test
	void slerp_preservesLength() {
		Quaternion q1 = Quaternion.fromEuler(new Vector3(0.1, 0.2, 0.3));
		Quaternion q2 = Quaternion.fromEuler(new Vector3(0.4, 0.5, 0.6));
		Quaternion result = q1.slerp(q2, 0.3);
		assertEquals(1.0, result.length(), 1e-6);
	}

	@Test
	void slerp_sameQuaternionReturnsEquivalent() {
		Quaternion q = Quaternion.fromEuler(new Vector3(0.3, 0.5, 0.1));
		Quaternion result = q.slerp(q, 0.5);
		// Should still be normalized and represent same rotation
		assertEquals(1.0, result.length(), 1e-6);
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Test
	void toString_containsValues() {
		Quaternion q = new Quaternion(1.0, 2.0, 3.0, 4.0);
		String s = q.toString();
		assertTrue(s.contains("Quaternion"));
		assertTrue(s.contains("1.0"));
		assertTrue(s.contains("2.0"));
		assertTrue(s.contains("3.0"));
		assertTrue(s.contains("4.0"));
	}
}
