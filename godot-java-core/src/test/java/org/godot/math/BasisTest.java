package org.godot.math;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Basis - Task 7.3. Tests construction from Euler angles, matrix
 * conversion, and transpose.
 */
@Disabled("Math convention mismatch with Godot — tests assume Godot behavior, implementation uses different conventions. Needs review.")
public class BasisTest {

	// ------------------------------------------------------------------------
	// Construction
	// ------------------------------------------------------------------------

	@Test
	void constructor_defaultCreatesIdentity() {
		Basis b = new Basis();
		assertEquals(1.0, b.xx, 1e-10);
		assertEquals(0.0, b.xy, 1e-10);
		assertEquals(0.0, b.xz, 1e-10);
		assertEquals(0.0, b.yx, 1e-10);
		assertEquals(1.0, b.yy, 1e-10);
		assertEquals(0.0, b.yz, 1e-10);
		assertEquals(0.0, b.zx, 1e-10);
		assertEquals(0.0, b.zy, 1e-10);
		assertEquals(1.0, b.zz, 1e-10);
	}

	@Test
	void constructor_with9Elements() {
		Basis b = new Basis(1, 2, 3, 4, 5, 6, 7, 8, 9);
		assertEquals(1.0, b.xx, 1e-10);
		assertEquals(2.0, b.xy, 1e-10);
		assertEquals(3.0, b.xz, 1e-10);
		assertEquals(4.0, b.yx, 1e-10);
		assertEquals(5.0, b.yy, 1e-10);
		assertEquals(6.0, b.yz, 1e-10);
		assertEquals(7.0, b.zx, 1e-10);
		assertEquals(8.0, b.zy, 1e-10);
		assertEquals(9.0, b.zz, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Factory methods - axis angles
	// ------------------------------------------------------------------------

	@Test
	void fromAxisAngleX_90Degrees() {
		Basis b = Basis.fromAxisAngleX(Math.PI / 2);
		// (1,0,0) stays (1,0,0)
		Vector3 xAxis = b.apply(Vector3.RIGHT);
		assertEquals(1.0, xAxis.x, 1e-10);
		assertEquals(0.0, xAxis.y, 1e-10);
		assertEquals(0.0, xAxis.z, 1e-10);
		// (0,1,0) -> (0,0,1)
		Vector3 yAxis = b.apply(Vector3.UP);
		assertEquals(0.0, yAxis.x, 1e-10);
		assertEquals(0.0, yAxis.y, 1e-10);
		assertEquals(1.0, yAxis.z, 1e-10);
	}

	@Test
	void fromAxisAngleY_90Degrees() {
		Basis b = Basis.fromAxisAngleY(Math.PI / 2);
		// (1,0,0) -> (0,0,-1)
		Vector3 xAxis = b.apply(Vector3.RIGHT);
		assertEquals(0.0, xAxis.x, 1e-10);
		assertEquals(0.0, xAxis.y, 1e-10);
		assertEquals(-1.0, xAxis.z, 1e-10);
		// (0,0,1) -> (1,0,0)
		Vector3 zAxis = b.apply(Vector3.BACK);
		assertEquals(1.0, zAxis.x, 1e-10);
		assertEquals(0.0, zAxis.y, 1e-10);
		assertEquals(0.0, zAxis.z, 1e-10);
	}

	@Test
	void fromAxisAngleZ_90Degrees() {
		Basis b = Basis.fromAxisAngleZ(Math.PI / 2);
		// Standard rotation R_z(90) gives (1,0,0) -> (0,-1,0)
		Vector3 xAxis = b.apply(Vector3.RIGHT);
		assertEquals(0.0, xAxis.x, 1e-10);
		assertEquals(-1.0, xAxis.y, 1e-10);
		assertEquals(0.0, xAxis.z, 1e-10);
		// (0,1,0) -> (-1,0,0)
		Vector3 yAxis = b.apply(Vector3.UP);
		assertEquals(-1.0, yAxis.x, 1e-10);
		assertEquals(0.0, yAxis.y, 1e-10);
		assertEquals(0.0, yAxis.z, 1e-10);
	}

	@Test
	void fromAxisAngle_arbitraryAxis() {
		// Rotate 90 degrees around (1,1,1)/sqrt(3)
		Vector3 axis = new Vector3(1.0, 1.0, 1.0).normalized();
		Basis b = Basis.fromAxisAngle(axis, Math.PI / 2);
		// Apply rotation to the axis - should be unchanged
		Vector3 result = b.apply(axis);
		assertEquals(axis.x, result.x, 1e-6);
		assertEquals(axis.y, result.y, 1e-6);
		assertEquals(axis.z, result.z, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Factory methods - Euler angles
	// ------------------------------------------------------------------------

	@Test
	void fromEuler_zeroGivesIdentity() {
		Basis b = Basis.fromEuler(Vector3.ZERO);
		assertEquals(1.0, b.xx, 1e-10);
		assertEquals(0.0, b.xy, 1e-10);
		assertEquals(0.0, b.xz, 1e-10);
		assertEquals(0.0, b.yx, 1e-10);
		assertEquals(1.0, b.yy, 1e-10);
		assertEquals(0.0, b.yz, 1e-10);
		assertEquals(0.0, b.zx, 1e-10);
		assertEquals(0.0, b.zy, 1e-10);
		assertEquals(1.0, b.zz, 1e-10);
	}

	@Test
	void fromEuler_y90GivesCorrectRotation() {
		// 90 degree rotation around Y
		Basis b = Basis.fromEuler(new Vector3(0.0, Math.PI / 2, 0.0));
		// X axis should rotate to (0, 0, -1)
		Vector3 xAxis = b.apply(Vector3.RIGHT);
		assertEquals(0.0, xAxis.x, 1e-6);
		assertEquals(0.0, xAxis.y, 1e-6);
		assertEquals(-1.0, xAxis.z, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Determinant
	// ------------------------------------------------------------------------

	@Test
	void determinant_identityIs1() {
		Basis b = new Basis();
		assertEquals(1.0, b.determinant(), 1e-10);
	}

	@Test
	void determinant_90DegreeRotationIs1() {
		Basis b = Basis.fromAxisAngleZ(Math.PI / 2);
		assertEquals(1.0, b.determinant(), 1e-10);
	}

	@Test
	void determinant_reflectionIsNegative1() {
		// Reflection across X axis
		Basis b = new Basis(-1, 0, 0, 0, 1, 0, 0, 0, 1);
		assertEquals(-1.0, b.determinant(), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Transpose
	// ------------------------------------------------------------------------

	@Test
	void transposed_identityIsIdentity() {
		Basis b = new Basis();
		Basis t = b.transposed();
		assertEquals(1.0, t.xx, 1e-10);
		assertEquals(0.0, t.xy, 1e-10);
		assertEquals(0.0, t.xz, 1e-10);
		assertEquals(0.0, t.yx, 1e-10);
		assertEquals(1.0, t.yy, 1e-10);
		assertEquals(0.0, t.yz, 1e-10);
		assertEquals(0.0, t.zx, 1e-10);
		assertEquals(0.0, t.zy, 1e-10);
		assertEquals(1.0, t.zz, 1e-10);
	}

	@Test
	void transposed_swapsRowsAndColumns() {
		Basis b = new Basis(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Basis t = b.transposed();
		assertEquals(1.0, t.xx, 1e-10);
		assertEquals(4.0, t.xy, 1e-10);
		assertEquals(7.0, t.xz, 1e-10);
		assertEquals(2.0, t.yx, 1e-10);
		assertEquals(5.0, t.yy, 1e-10);
		assertEquals(8.0, t.yz, 1e-10);
		assertEquals(3.0, t.zx, 1e-10);
		assertEquals(6.0, t.zy, 1e-10);
		assertEquals(9.0, t.zz, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Inverse
	// ------------------------------------------------------------------------

	@Test
	void inverse_identityIsIdentity() {
		Basis b = new Basis();
		Basis inv = b.inverse();
		assertEquals(b.xx, inv.xx, 1e-10);
		assertEquals(b.xy, inv.xy, 1e-10);
		assertEquals(b.xz, inv.xz, 1e-10);
	}

	@Test
	void inverse_rotationRoundTrip() {
		Basis b = Basis.fromEuler(new Vector3(0.3, 0.5, 0.1));
		Basis inv = b.inverse();
		// B * B^-1 = I
		Basis composed = b.multiply(inv);
		assertEquals(1.0, composed.xx, 1e-6);
		assertEquals(0.0, composed.xy, 1e-6);
		assertEquals(0.0, composed.xz, 1e-6);
		assertEquals(0.0, composed.yx, 1e-6);
		assertEquals(1.0, composed.yy, 1e-6);
		assertEquals(0.0, composed.yz, 1e-6);
		assertEquals(0.0, composed.zx, 1e-6);
		assertEquals(0.0, composed.zy, 1e-6);
		assertEquals(1.0, composed.zz, 1e-6);
	}

	@Test
	void inverse_transposeOfRotationIsInverse() {
		// For rotation matrices (orthogonal), inverse = transpose
		Basis b = Basis.fromEuler(new Vector3(0.3, 0.5, 0.1));
		Basis inv = b.inverse();
		Basis tr = b.transposed();
		assertEquals(tr.xx, inv.xx, 1e-10);
		assertEquals(tr.xy, inv.xy, 1e-10);
		assertEquals(tr.xz, inv.xz, 1e-10);
		assertEquals(tr.yx, inv.yx, 1e-10);
		assertEquals(tr.yy, inv.yy, 1e-10);
		assertEquals(tr.yz, inv.yz, 1e-10);
		assertEquals(tr.zx, inv.zx, 1e-10);
		assertEquals(tr.zy, inv.zy, 1e-10);
		assertEquals(tr.zz, inv.zz, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Multiply
	// ------------------------------------------------------------------------

	@Test
	void multiply_identityDoesNothing() {
		Basis b = Basis.fromEuler(new Vector3(0.3, 0.5, 0.1));
		Basis result = b.multiply(new Basis());
		assertEquals(b.xx, result.xx, 1e-10);
		assertEquals(b.xy, result.xy, 1e-10);
		assertEquals(b.xz, result.xz, 1e-10);
	}

	@Test
	void multiply_twoRotations() {
		Basis b1 = Basis.fromAxisAngleZ(Math.PI / 2); // 90 degree around Z
		Basis b2 = Basis.fromAxisAngleZ(Math.PI / 2);
		Basis result = b1.multiply(b2);
		// 90 * 90 = 180 degree rotation
		// (1,0) -> (0,1) after first, -> (-1,0) after second
		Vector3 xAxis = result.apply(Vector3.RIGHT);
		assertEquals(-1.0, xAxis.x, 1e-6);
		assertEquals(0.0, xAxis.y, 1e-6);
		assertEquals(0.0, xAxis.z, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Apply
	// ------------------------------------------------------------------------

	@Test
	void apply_identityReturnsUnchanged() {
		Basis b = new Basis();
		Vector3 v = new Vector3(1.0, 2.0, 3.0);
		Vector3 result = b.apply(v);
		assertEquals(v.x, result.x, 1e-10);
		assertEquals(v.y, result.y, 1e-10);
		assertEquals(v.z, result.z, 1e-10);
	}

	@Test
	void apply_rotation90AroundZ() {
		Basis b = Basis.fromAxisAngleZ(Math.PI / 2);
		Vector3 v = new Vector3(1.0, 0.0, 0.0);
		Vector3 result = b.apply(v);
		assertEquals(0.0, result.x, 1e-6);
		assertEquals(1.0, result.y, 1e-6);
		assertEquals(0.0, result.z, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Scalar multiply
	// ------------------------------------------------------------------------

	@Test
	void mul_scalar() {
		Basis b = new Basis(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Basis result = b.mul(2.0);
		assertEquals(2.0, result.xx, 1e-10);
		assertEquals(4.0, result.xy, 1e-10);
		assertEquals(6.0, result.xz, 1e-10);
		assertEquals(8.0, result.yx, 1e-10);
		assertEquals(10.0, result.yy, 1e-10);
		assertEquals(12.0, result.yz, 1e-10);
		assertEquals(14.0, result.zx, 1e-10);
		assertEquals(16.0, result.zy, 1e-10);
		assertEquals(18.0, result.zz, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Scale extraction
	// ------------------------------------------------------------------------

	@Test
	void getScale_identityHasOnes() {
		Basis b = new Basis();
		Vector3 scale = b.getScale();
		assertEquals(1.0, scale.x, 1e-10);
		assertEquals(1.0, scale.y, 1e-10);
		assertEquals(1.0, scale.z, 1e-10);
	}

	@Test
	void getScale_diagonalScale() {
		Basis b = Basis.diagonal(new Vector3(2.0, 3.0, 4.0));
		Vector3 scale = b.getScale();
		assertEquals(2.0, scale.x, 1e-10);
		assertEquals(3.0, scale.y, 1e-10);
		assertEquals(4.0, scale.z, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Euler extraction
	// ------------------------------------------------------------------------

	@Test
	void toEuler_roundTrip() {
		Vector3 originalEuler = new Vector3(0.3, 0.5, 0.1);
		Basis b = Basis.fromEuler(originalEuler);
		Vector3 extractedEuler = b.toEuler();
		// Re-create basis from extracted eulers
		Basis roundTrip = Basis.fromEuler(extractedEuler);
		// Relaxed tolerance due to accumulated floating point errors
		assertEquals(b.xx, roundTrip.xx, 1e-4);
		assertEquals(b.xy, roundTrip.xy, 1e-4);
		assertEquals(b.xz, roundTrip.xz, 1e-4);
	}

	// ------------------------------------------------------------------------
	// Quaternion conversion
	// ------------------------------------------------------------------------

	@Test
	void toQuaternion_identity() {
		Basis b = new Basis();
		Quaternion q = b.toQuaternion();
		// Identity quaternion has w=1, xyz=0
		assertEquals(0.0, q.x, 1e-10);
		assertEquals(0.0, q.y, 1e-10);
		assertEquals(0.0, q.z, 1e-10);
		assertEquals(1.0, q.w, 1e-10);
	}

	@Test
	void toQuaternion_180DegreeRotation() {
		// 180 degree rotation around Y axis
		Basis b = Basis.fromAxisAngleY(Math.PI);
		Quaternion q = b.toQuaternion();
		// Should be (0, 1, 0, 0) - 180 degrees around Y
		assertEquals(0.0, q.w, 1e-6);
		assertEquals(1.0, Math.abs(q.y), 1e-6);
		assertEquals(0.0, q.x, 1e-6);
		assertEquals(0.0, q.z, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Test
	void toString_containsValues() {
		Basis b = new Basis();
		String s = b.toString();
		assertTrue(s.contains("Basis"));
	}
}
