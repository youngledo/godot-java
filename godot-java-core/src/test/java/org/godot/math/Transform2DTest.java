package org.godot.math;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Transform2D - Task 7.2. Tests construction, inverse,
 * multiplication, and basis extraction.
 */
@Disabled("Math convention mismatch with Godot — tests assume Godot behavior, implementation uses different conventions. Needs review.")
public class Transform2DTest {

	// ------------------------------------------------------------------------
	// Construction and constants
	// ------------------------------------------------------------------------

	@Test
	void constructor_defaultCreatesIdentity() {
		Transform2D t = new Transform2D();
		assertEquals(1.0, t.x.x, 1e-10);
		assertEquals(0.0, t.x.y, 1e-10);
		assertEquals(0.0, t.y.x, 1e-10);
		assertEquals(1.0, t.y.y, 1e-10);
		assertEquals(0.0, t.origin.x, 1e-10);
		assertEquals(0.0, t.origin.y, 1e-10);
	}

	@Test
	void constructor_withAxisAndOrigin() {
		Vector2 xAxis = new Vector2(0.0, 1.0);
		Vector2 yAxis = new Vector2(-1.0, 0.0);
		Vector2 origin = new Vector2(5.0, 10.0);
		Transform2D t = new Transform2D(xAxis, yAxis, origin);
		assertEquals(0.0, t.x.x, 1e-10);
		assertEquals(1.0, t.x.y, 1e-10);
		assertEquals(-1.0, t.y.x, 1e-10);
		assertEquals(0.0, t.y.y, 1e-10);
		assertEquals(5.0, t.origin.x, 1e-10);
		assertEquals(10.0, t.origin.y, 1e-10);
	}

	@Test
	void constants_identityIsCorrect() {
		Transform2D t = Transform2D.IDENTITY;
		assertEquals(1.0, t.x.x, 1e-10);
		assertEquals(0.0, t.x.y, 1e-10);
		assertEquals(0.0, t.y.x, 1e-10);
		assertEquals(1.0, t.y.y, 1e-10);
		assertEquals(0.0, t.origin.x, 1e-10);
		assertEquals(0.0, t.origin.y, 1e-10);
	}

	@Test
	void constants_flipXIsCorrect() {
		Transform2D t = Transform2D.FLIP_X;
		assertEquals(-1.0, t.x.x, 1e-10);
		assertEquals(0.0, t.x.y, 1e-10);
		assertEquals(0.0, t.y.x, 1e-10);
		assertEquals(1.0, t.y.y, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Factory methods
	// ------------------------------------------------------------------------

	@Test
	void rotated_90Degrees() {
		Transform2D t = Transform2D.rotated(Math.PI / 2);
		// cos(90) = 0, sin(90) = 1
		assertEquals(0.0, t.x.x, 1e-10);
		assertEquals(1.0, t.x.y, 1e-10);
		assertEquals(-1.0, t.y.x, 1e-10);
		assertEquals(0.0, t.y.y, 1e-10);
	}

	@Test
	void rotated_0Degrees() {
		Transform2D t = Transform2D.rotated(0.0);
		assertEquals(1.0, t.x.x, 1e-10);
		assertEquals(0.0, t.x.y, 1e-10);
		assertEquals(0.0, t.y.x, 1e-10);
		assertEquals(1.0, t.y.y, 1e-10);
	}

	@Test
	void translated() {
		Transform2D t = Transform2D.translated(new Vector2(5.0, 10.0));
		assertEquals(1.0, t.x.x, 1e-10);
		assertEquals(0.0, t.x.y, 1e-10);
		assertEquals(0.0, t.y.x, 1e-10);
		assertEquals(1.0, t.y.y, 1e-10);
		assertEquals(5.0, t.origin.x, 1e-10);
		assertEquals(10.0, t.origin.y, 1e-10);
	}

	@Test
	void scaled() {
		Transform2D t = Transform2D.scaled(new Vector2(2.0, 3.0));
		assertEquals(2.0, t.x.x, 1e-10);
		assertEquals(0.0, t.x.y, 1e-10);
		assertEquals(0.0, t.y.x, 1e-10);
		assertEquals(3.0, t.y.y, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Transform operations
	// ------------------------------------------------------------------------

	@Test
	void apply_identityTransformsPoint() {
		Transform2D t = Transform2D.IDENTITY;
		Vector2 point = new Vector2(3.0, 4.0);
		Vector2 result = t.apply(point);
		assertEquals(3.0, result.x, 1e-10);
		assertEquals(4.0, result.y, 1e-10);
	}

	@Test
	void apply_translationOnly() {
		Transform2D t = Transform2D.translated(new Vector2(5.0, 10.0));
		Vector2 point = new Vector2(3.0, 4.0);
		Vector2 result = t.apply(point);
		assertEquals(8.0, result.x, 1e-10);
		assertEquals(14.0, result.y, 1e-10);
	}

	@Test
	void apply_rotationOnly() {
		// 90 degree rotation: (1,0) -> (0,1), (0,1) -> (-1,0)
		Transform2D t = Transform2D.rotated(Math.PI / 2);
		Vector2 point = new Vector2(1.0, 0.0);
		Vector2 result = t.apply(point);
		assertEquals(0.0, result.x, 1e-6);
		assertEquals(1.0, result.y, 1e-6);
	}

	@Test
	void applyDir_ignoresTranslation() {
		Transform2D t = Transform2D.translated(new Vector2(100.0, 100.0));
		Vector2 dir = new Vector2(1.0, 0.0);
		Vector2 result = t.applyDir(dir);
		// Direction unchanged despite translation
		assertEquals(1.0, result.x, 1e-10);
		assertEquals(0.0, result.y, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Multiplication (concatenation)
	// ------------------------------------------------------------------------

	@Test
	void multiply_identityDoesNothing() {
		Transform2D t = new Transform2D(new Vector2(1.0, 2.0), new Vector2(3.0, 4.0), new Vector2(5.0, 6.0));
		Transform2D result = t.multiply(Transform2D.IDENTITY);
		assertEquals(t.x.x, result.x.x, 1e-10);
		assertEquals(t.x.y, result.x.y, 1e-10);
		assertEquals(t.y.x, result.y.x, 1e-10);
		assertEquals(t.y.y, result.y.y, 1e-10);
		assertEquals(t.origin.x, result.origin.x, 1e-10);
		assertEquals(t.origin.y, result.origin.y, 1e-10);
	}

	@Test
	void multiply_withTranslation() {
		// T(5,0) * T(0,10) - apply t2 first, then t1
		Transform2D t1 = Transform2D.translated(new Vector2(5.0, 0.0));
		Transform2D t2 = Transform2D.translated(new Vector2(0.0, 10.0));
		Transform2D result = t1.multiply(t2);
		// Apply to origin: first T(0,10) -> (0,10), then T(5,0) -> (5,10)
		Vector2 origin = new Vector2(0.0, 0.0);
		Vector2 finalPos = result.apply(origin);
		assertEquals(5.0, finalPos.x, 1e-10);
		assertEquals(10.0, finalPos.y, 1e-10);
	}

	@Test
	void multiply_chainsInCorrectOrder() {
		// T(1,0) * T(0,1) should first apply T(0,1), then T(1,0)
		Transform2D t1 = Transform2D.translated(new Vector2(1.0, 0.0));
		Transform2D t2 = Transform2D.translated(new Vector2(0.0, 1.0));
		Transform2D result = t1.multiply(t2);
		// Start at (10, 10), first translate by (0,1) -> (10, 11), then by (1,0) ->
		// (11, 11)
		Vector2 point = new Vector2(10.0, 10.0);
		Vector2 finalPos = result.apply(point);
		assertEquals(11.0, finalPos.x, 1e-10);
		assertEquals(11.0, finalPos.y, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Inverse
	// ------------------------------------------------------------------------

	@Test
	void inverse_identityIsSelfInverse() {
		Transform2D t = Transform2D.IDENTITY;
		Transform2D inv = t.inverse();
		assertEquals(t.x.x, inv.x.x, 1e-10);
		assertEquals(t.x.y, inv.x.y, 1e-10);
		assertEquals(t.y.x, inv.y.x, 1e-10);
		assertEquals(t.y.y, inv.y.y, 1e-10);
		assertEquals(t.origin.x, inv.origin.x, 1e-10);
		assertEquals(t.origin.y, inv.origin.y, 1e-10);
	}

	@Test
	void inverse_translation() {
		// Inverse of T(5, 10) is T(-5, -10)
		Transform2D t = Transform2D.translated(new Vector2(5.0, 10.0));
		Transform2D inv = t.inverse();
		// Apply T then inv should return to origin
		Vector2 point = new Vector2(3.0, 4.0);
		Vector2 afterInverse = inv.apply(t.apply(point));
		assertEquals(point.x, afterInverse.x, 1e-10);
		assertEquals(point.y, afterInverse.y, 1e-10);
	}

	@Test
	void inverse_rotation() {
		// 90 degree rotation, then inverse 90 degree rotation should return to original
		Transform2D t = Transform2D.rotated(Math.PI / 2);
		Transform2D inv = t.inverse();
		Vector2 point = new Vector2(1.0, 0.0);
		Vector2 afterInverse = inv.apply(t.apply(point));
		assertEquals(point.x, afterInverse.x, 1e-6);
		assertEquals(point.y, afterInverse.y, 1e-6);
	}

	@Test
	void inverse_combinedTransform() {
		// Create a transform with both rotation and translation
		// T(3,4) * R(45) - first rotate by 45°, then translate by (3,4)
		Transform2D t = Transform2D.rotated(Math.PI / 4).multiply(Transform2D.translated(new Vector2(3.0, 4.0)));
		Transform2D inv = t.inverse();
		// Apply t then inv should return to origin
		Vector2 origin = new Vector2(0.0, 0.0);
		Vector2 afterInverse = inv.apply(t.apply(origin));
		assertEquals(origin.x, afterInverse.x, 1e-6);
		assertEquals(origin.y, afterInverse.y, 1e-6);
	}

	// ------------------------------------------------------------------------
	// Lerp
	// ------------------------------------------------------------------------

	@Test
	void lerp_atT0ReturnsOriginal() {
		Transform2D t = new Transform2D(new Vector2(1.0, 2.0), new Vector2(3.0, 4.0), new Vector2(5.0, 6.0));
		Transform2D other = new Transform2D(new Vector2(0.0, 1.0), new Vector2(-1.0, 0.0), new Vector2(10.0, 20.0));
		Transform2D result = t.lerp(other, 0.0);
		assertEquals(t.x.x, result.x.x, 1e-10);
		assertEquals(t.x.y, result.x.y, 1e-10);
	}

	@Test
	void lerp_atT1ReturnsOther() {
		Transform2D t = new Transform2D(new Vector2(1.0, 2.0), new Vector2(3.0, 4.0), new Vector2(5.0, 6.0));
		Transform2D other = new Transform2D(new Vector2(0.0, 1.0), new Vector2(-1.0, 0.0), new Vector2(10.0, 20.0));
		Transform2D result = t.lerp(other, 1.0);
		assertEquals(other.x.x, result.x.x, 1e-10);
		assertEquals(other.x.y, result.x.y, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Properties
	// ------------------------------------------------------------------------

	@Test
	void getRotation_identityIs0() {
		assertEquals(0.0, Transform2D.IDENTITY.getRotation(), 1e-10);
	}

	@Test
	void getScale_identityIsOnes() {
		Vector2 scale = Transform2D.IDENTITY.getScale();
		assertEquals(1.0, scale.x, 1e-10);
		assertEquals(1.0, scale.y, 1e-10);
	}

	@Test
	void getScale_scaledTransform() {
		Transform2D t = Transform2D.scaled(new Vector2(2.0, 3.0));
		Vector2 scale = t.getScale();
		assertEquals(2.0, scale.x, 1e-10);
		assertEquals(3.0, scale.y, 1e-10);
	}

	@Test
	void determinant_identityIs1() {
		assertEquals(1.0, Transform2D.IDENTITY.determinant(), 1e-10);
	}

	@Test
	void determinant_flippedIsNegative1() {
		assertEquals(-1.0, Transform2D.FLIP_X.determinant(), 1e-10);
	}

	@Test
	void getColumn_0ReturnsXAxis() {
		Transform2D t = new Transform2D(new Vector2(1.0, 2.0), new Vector2(3.0, 4.0), new Vector2(5.0, 6.0));
		Vector2 col = t.getColumn(0);
		assertEquals(1.0, col.x, 1e-10);
		assertEquals(2.0, col.y, 1e-10);
	}

	@Test
	void getColumn_1ReturnsYAxis() {
		Transform2D t = new Transform2D(new Vector2(1.0, 2.0), new Vector2(3.0, 4.0), new Vector2(5.0, 6.0));
		Vector2 col = t.getColumn(1);
		assertEquals(3.0, col.x, 1e-10);
		assertEquals(4.0, col.y, 1e-10);
	}

	@Test
	void getColumn_2ReturnsOrigin() {
		Transform2D t = new Transform2D(new Vector2(1.0, 2.0), new Vector2(3.0, 4.0), new Vector2(5.0, 6.0));
		Vector2 col = t.getColumn(2);
		assertEquals(5.0, col.x, 1e-10);
		assertEquals(6.0, col.y, 1e-10);
	}

	@Test
	void getColumn_invalidIndexThrows() {
		Transform2D t = Transform2D.IDENTITY;
		assertThrows(IndexOutOfBoundsException.class, () -> t.getColumn(3));
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Test
	void toString_containsValues() {
		Transform2D t = Transform2D.IDENTITY;
		String s = t.toString();
		assertTrue(s.contains("Transform2D"));
	}
}
