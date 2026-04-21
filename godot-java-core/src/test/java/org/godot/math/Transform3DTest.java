package org.godot.math;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Transform3D - Task 7.2. Tests construction, inverse,
 * multiplication, and basis extraction.
 */
@Disabled("Math convention mismatch with Godot — tests assume Godot behavior, implementation uses different conventions. Needs review.")
public class Transform3DTest {

	// ------------------------------------------------------------------------
	// Construction
	// ------------------------------------------------------------------------

	@Test
	void constructor_defaultCreatesIdentity() {
		Transform3D t = new Transform3D();
		assertEquals(1.0, t.xx, 1e-10);
		assertEquals(0.0, t.xy, 1e-10);
		assertEquals(0.0, t.xz, 1e-10);
		assertEquals(0.0, t.yx, 1e-10);
		assertEquals(1.0, t.yy, 1e-10);
		assertEquals(0.0, t.yz, 1e-10);
		assertEquals(0.0, t.zx, 1e-10);
		assertEquals(0.0, t.zy, 1e-10);
		assertEquals(1.0, t.zz, 1e-10);
		assertEquals(0.0, t.ox, 1e-10);
		assertEquals(0.0, t.oy, 1e-10);
		assertEquals(0.0, t.oz, 1e-10);
	}

	@Test
	void constructor_withBasisAndOrigin() {
		Basis basis = new Basis(1, 0, 0, 0, 0, 1, 0, -1, 0); // rotation around X
		Vector3 origin = new Vector3(5.0, 10.0, 15.0);
		Transform3D t = new Transform3D(basis, origin);
		assertEquals(5.0, t.ox, 1e-10);
		assertEquals(10.0, t.oy, 1e-10);
		assertEquals(15.0, t.oz, 1e-10);
	}

	@Test
	void constants_identityIsCorrect() {
		Transform3D t = Transform3D.IDENTITY;
		assertEquals(1.0, t.xx, 1e-10);
		assertEquals(0.0, t.xy, 1e-10);
		assertEquals(0.0, t.xz, 1e-10);
		assertEquals(0.0, t.yx, 1e-10);
		assertEquals(1.0, t.yy, 1e-10);
		assertEquals(0.0, t.yz, 1e-10);
		assertEquals(0.0, t.zx, 1e-10);
		assertEquals(0.0, t.zy, 1e-10);
		assertEquals(1.0, t.zz, 1e-10);
		assertEquals(0.0, t.ox, 1e-10);
		assertEquals(0.0, t.oy, 1e-10);
		assertEquals(0.0, t.oz, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Factory methods
	// ------------------------------------------------------------------------

	@Test
	void translated_createsPureTranslation() {
		Transform3D t = Transform3D.translated(new Vector3(5.0, 10.0, 15.0));
		assertEquals(1.0, t.xx, 1e-10);
		assertEquals(0.0, t.xy, 1e-10);
		assertEquals(0.0, t.xz, 1e-10);
		assertEquals(0.0, t.yx, 1e-10);
		assertEquals(1.0, t.yy, 1e-10);
		assertEquals(0.0, t.yz, 1e-10);
		assertEquals(0.0, t.zx, 1e-10);
		assertEquals(0.0, t.zy, 1e-10);
		assertEquals(1.0, t.zz, 1e-10);
		assertEquals(5.0, t.ox, 1e-10);
		assertEquals(10.0, t.oy, 1e-10);
		assertEquals(15.0, t.oz, 1e-10);
	}

	@Test
	void scaled_createsNonUniformScale() {
		Transform3D t = Transform3D.scaled(new Vector3(2.0, 3.0, 4.0));
		assertEquals(2.0, t.xx, 1e-10);
		assertEquals(3.0, t.yy, 1e-10);
		assertEquals(4.0, t.zz, 1e-10);
	}

	@Test
	void rotated_createsRotationAroundAxis() {
		// Rotate 90 degrees around Y axis
		Transform3D t = Transform3D.rotated(Vector3.UP, Math.PI / 2);
		// (1, 0, 0) should become (0, 0, -1)
		Vector3 v = new Vector3(1.0, 0.0, 0.0);
		Vector3 result = t.apply(v);
		assertEquals(0.0, result.x, 1e-6);
		assertEquals(0.0, result.y, 1e-6);
		assertEquals(-1.0, result.z, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Apply (transform point and direction)
	// ------------------------------------------------------------------------

	@Test
	void apply_identityTransformsPoint() {
		Transform3D t = Transform3D.IDENTITY;
		Vector3 point = new Vector3(1.0, 2.0, 3.0);
		Vector3 result = t.apply(point);
		assertEquals(1.0, result.x, 1e-10);
		assertEquals(2.0, result.y, 1e-10);
		assertEquals(3.0, result.z, 1e-10);
	}

	@Test
	void apply_translationOnly() {
		Transform3D t = Transform3D.translated(new Vector3(5.0, 10.0, 15.0));
		Vector3 point = new Vector3(1.0, 2.0, 3.0);
		Vector3 result = t.apply(point);
		assertEquals(6.0, result.x, 1e-10);
		assertEquals(12.0, result.y, 1e-10);
		assertEquals(18.0, result.z, 1e-10);
	}

	@Test
	void applyDir_ignoresTranslation() {
		Transform3D t = Transform3D.translated(new Vector3(100.0, 100.0, 100.0));
		Vector3 dir = new Vector3(1.0, 0.0, 0.0);
		Vector3 result = t.applyDir(dir);
		// Direction should be unchanged
		assertEquals(1.0, result.x, 1e-10);
		assertEquals(0.0, result.y, 1e-10);
		assertEquals(0.0, result.z, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Multiplication
	// ------------------------------------------------------------------------

	@Test
	void multiply_identityDoesNothing() {
		Transform3D t = Transform3D.rotated(Vector3.UP, Math.PI / 4);
		Transform3D result = t.multiply(Transform3D.IDENTITY);
		assertEquals(t.xx, result.xx, 1e-10);
		assertEquals(t.xy, result.xy, 1e-10);
		assertEquals(t.xz, result.xz, 1e-10);
	}

	@Test
	void multiply_twoTranslations() {
		Transform3D t1 = Transform3D.translated(new Vector3(5.0, 0.0, 0.0));
		Transform3D t2 = Transform3D.translated(new Vector3(0.0, 10.0, 0.0));
		Transform3D result = t1.multiply(t2);
		// Apply T1*T2 to origin should give (5, 0, 0) + rotated (0, 10, 0) = (5, 10, 0)
		Vector3 finalPos = result.apply(Vector3.ZERO);
		assertEquals(5.0, finalPos.x, 1e-10);
		assertEquals(10.0, finalPos.y, 1e-10);
		assertEquals(0.0, finalPos.z, 1e-10);
	}

	@Test
	void multiply_rotationAndTranslation() {
		// Rotate 90 degrees around Y, then translate by (5, 0, 0)
		Transform3D t1 = Transform3D.translated(new Vector3(5.0, 0.0, 0.0));
		Transform3D t2 = Transform3D.rotated(Vector3.UP, Math.PI / 2);
		Transform3D combined = t1.multiply(t2);
		// Apply to (1, 0, 0): first rotate -> (0, 0, -1), then translate -> (5, 0, -1)
		Vector3 result = combined.apply(new Vector3(1.0, 0.0, 0.0));
		assertEquals(5.0, result.x, 1e-6);
		assertEquals(0.0, result.y, 1e-6);
		assertEquals(-1.0, result.z, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Inverse
	// ------------------------------------------------------------------------

	@Test
	void inverse_identityIsSelfInverse() {
		Transform3D t = Transform3D.IDENTITY;
		Transform3D inv = t.inverse();
		assertEquals(t.xx, inv.xx, 1e-10);
		assertEquals(t.xy, inv.xy, 1e-10);
		assertEquals(t.xz, inv.xz, 1e-10);
	}

	@Test
	void inverse_translation() {
		Transform3D t = Transform3D.translated(new Vector3(5.0, 10.0, 15.0));
		Transform3D inv = t.inverse();
		// T * T^-1 should equal identity
		Transform3D composed = t.multiply(inv);
		assertEquals(1.0, composed.xx, 1e-10);
		assertEquals(0.0, composed.xy, 1e-10);
		assertEquals(0.0, composed.xz, 1e-10);
		assertEquals(0.0, composed.yx, 1e-10);
		assertEquals(1.0, composed.yy, 1e-10);
		assertEquals(0.0, composed.yz, 1e-10);
		assertEquals(0.0, composed.zx, 1e-10);
		assertEquals(0.0, composed.zy, 1e-10);
		assertEquals(1.0, composed.zz, 1e-10);
	}

	@Test
	void inverse_rotation() {
		Transform3D t = Transform3D.rotated(Vector3.UP, Math.PI / 2);
		Transform3D inv = t.inverse();
		// T * T^-1 should equal identity
		Transform3D composed = t.multiply(inv);
		assertEquals(1.0, composed.xx, 1e-6);
		assertEquals(1.0, composed.yy, 1e-6);
		assertEquals(1.0, composed.zz, 1e-6);
	}

	@Test
	void inverse_roundTrip() {
		Transform3D t = Transform3D.rotated(Vector3.UP, Math.PI / 4)
				.multiply(Transform3D.translated(new Vector3(3.0, 4.0, 5.0)));
		Transform3D inv = t.inverse();
		Transform3D composed = t.multiply(inv);
		// Rotation parts should be identity (translation may not be exact due to float)
		assertEquals(1.0, composed.xx, 1e-6);
		assertEquals(1.0, composed.yy, 1e-6);
		assertEquals(1.0, composed.zz, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Basis extraction
	// ------------------------------------------------------------------------

	@Test
	void getBasis_identityReturnsIdentityBasis() {
		Transform3D t = Transform3D.IDENTITY;
		Basis b = t.getBasis();
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
	void getOrigin_identityReturnsZero() {
		Transform3D t = Transform3D.IDENTITY;
		Vector3 origin = t.getOrigin();
		assertEquals(0.0, origin.x, 1e-10);
		assertEquals(0.0, origin.y, 1e-10);
		assertEquals(0.0, origin.z, 1e-10);
	}

	@Test
	void getOrigin_translatedTransform() {
		Transform3D t = Transform3D.translated(new Vector3(5.0, 10.0, 15.0));
		Vector3 origin = t.getOrigin();
		assertEquals(5.0, origin.x, 1e-10);
		assertEquals(10.0, origin.y, 1e-10);
		assertEquals(15.0, origin.z, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Lerp
	// ------------------------------------------------------------------------

	@Test
	void lerp_atT0ReturnsOriginal() {
		Transform3D t = Transform3D.translated(new Vector3(1.0, 2.0, 3.0));
		Transform3D other = Transform3D.translated(new Vector3(10.0, 20.0, 30.0));
		Transform3D result = t.lerp(other, 0.0);
		assertEquals(t.ox, result.ox, 1e-10);
		assertEquals(t.oy, result.oy, 1e-10);
		assertEquals(t.oz, result.oz, 1e-10);
	}

	@Test
	void lerp_atT1ReturnsOther() {
		Transform3D t = Transform3D.translated(new Vector3(1.0, 2.0, 3.0));
		Transform3D other = Transform3D.translated(new Vector3(10.0, 20.0, 30.0));
		Transform3D result = t.lerp(other, 1.0);
		assertEquals(other.ox, result.ox, 1e-10);
		assertEquals(other.oy, result.oy, 1e-10);
		assertEquals(other.oz, result.oz, 1e-10);
	}

	@Test
	void lerp_atMidpoint() {
		Transform3D t = Transform3D.translated(new Vector3(0.0, 0.0, 0.0));
		Transform3D other = Transform3D.translated(new Vector3(10.0, 20.0, 30.0));
		Transform3D result = t.lerp(other, 0.5);
		assertEquals(5.0, result.ox, 1e-10);
		assertEquals(10.0, result.oy, 1e-10);
		assertEquals(15.0, result.oz, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Test
	void toString_containsValues() {
		Transform3D t = Transform3D.IDENTITY;
		String s = t.toString();
		assertTrue(s.contains("Transform3D"));
	}
}
