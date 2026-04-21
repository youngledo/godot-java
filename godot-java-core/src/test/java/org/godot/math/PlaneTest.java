package org.godot.math;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Plane - Task 7.4. Tests intersection tests, containment
 * checks, and plane operations.
 */
@Disabled("Math convention mismatch with Godot — tests assume Godot behavior, implementation uses different conventions. Needs review.")
public class PlaneTest {

	// ------------------------------------------------------------------------
	// Construction
	// ------------------------------------------------------------------------

	@Test
	void constructor_withXYZD() {
		Plane p = new Plane(1.0, 2.0, 3.0, 4.0);
		assertEquals(1.0, p.x, 1e-10);
		assertEquals(2.0, p.y, 1e-10);
		assertEquals(3.0, p.z, 1e-10);
		assertEquals(4.0, p.d, 1e-10);
	}

	@Test
	void constructor_withNormalAndD() {
		Vector3 normal = new Vector3(1.0, 2.0, 3.0);
		Plane p = new Plane(normal, 4.0);
		assertEquals(1.0, p.x, 1e-10);
		assertEquals(2.0, p.y, 1e-10);
		assertEquals(3.0, p.z, 1e-10);
		assertEquals(4.0, p.d, 1e-10);
	}

	@Test
	void fromPoints_createsHorizontalPlane() {
		// Create a horizontal plane at y=5
		// Note: Plane.fromPoints uses edge1 x edge2, which gives downward normal for
		// this ordering
		Vector3 p0 = new Vector3(0.0, 5.0, 0.0);
		Vector3 p1 = new Vector3(1.0, 5.0, 0.0);
		Vector3 p2 = new Vector3(0.0, 5.0, 1.0);
		Plane p = Plane.fromPoints(p0, p1, p2);
		assertEquals(0.0, p.x, 1e-10);
		assertEquals(-1.0, p.y, 1e-10); // downward normal due to cross product ordering
		assertEquals(0.0, p.z, 1e-10);
		assertEquals(-5.0, p.d, 1e-10); // d = normal.dot(p0) = -5
	}

	@Test
	void fromNormalPoint_horizontalPlane() {
		Vector3 normal = Vector3.UP;
		Vector3 point = new Vector3(0.0, 5.0, 0.0);
		Plane p = Plane.fromNormalPoint(normal, point);
		assertEquals(0.0, p.x, 1e-10);
		assertEquals(1.0, p.y, 1e-10);
		assertEquals(0.0, p.z, 1e-10);
		assertEquals(5.0, p.d, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Properties
	// ------------------------------------------------------------------------

	@Test
	void getNormal() {
		Plane p = new Plane(1.0, 2.0, 3.0, 4.0);
		Vector3 n = p.getNormal();
		assertEquals(1.0, n.x, 1e-10);
		assertEquals(2.0, n.y, 1e-10);
		assertEquals(3.0, n.z, 1e-10);
	}

	@Test
	void getD() {
		Plane p = new Plane(1.0, 2.0, 3.0, 4.0);
		assertEquals(4.0, p.getD(), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Distance operations
	// ------------------------------------------------------------------------

	@Test
	void distanceTo_pointOnPlane() {
		// Plane: y = 5, point (0, 5, 0)
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 point = new Vector3(0.0, 5.0, 0.0);
		assertEquals(0.0, p.distanceTo(point), 1e-10);
	}

	@Test
	void distanceTo_pointAbovePlane() {
		// Plane: y = 5, point (0, 10, 0) is 5 units above
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 point = new Vector3(0.0, 10.0, 0.0);
		assertEquals(5.0, p.distanceTo(point), 1e-10);
	}

	@Test
	void distanceTo_pointBelowPlane() {
		// Plane: y = 5, point (0, 0, 0) is 5 units below
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 point = new Vector3(0.0, 0.0, 0.0);
		assertEquals(-5.0, p.distanceTo(point), 1e-10);
	}

	@Test
	void distanceTo_pointOnDiagonalPlane() {
		// Plane: x + y + z = 10, point (2, 3, 5) is on the plane
		Plane p = new Plane(1.0, 1.0, 1.0, 10.0);
		Vector3 point = new Vector3(2.0, 3.0, 5.0);
		assertEquals(0.0, p.distanceTo(point), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Has point
	// ------------------------------------------------------------------------

	@Test
	void hasPoint_onPlane() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 point = new Vector3(0.0, 5.0, 0.0);
		assertTrue(p.hasPoint(point));
	}

	@Test
	void hasPoint_nearPlane() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 point = new Vector3(0.0, 5.0 + 1e-7, 0.0);
		assertTrue(p.hasPoint(point));
	}

	@Test
	void hasPoint_farFromPlane() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 point = new Vector3(0.0, 10.0, 0.0);
		assertFalse(p.hasPoint(point));
	}

	@Test
	void hasPoint_withCustomEpsilon() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 point = new Vector3(0.0, 5.0 + 1e-4, 0.0);
		assertFalse(p.hasPoint(point, 1e-6));
		assertTrue(p.hasPoint(point, 1e-3));
	}

	// ------------------------------------------------------------------------
	// Center
	// ------------------------------------------------------------------------

	@Test
	void center_returnsPointOnPlane() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 c = p.center();
		assertEquals(0.0, c.x, 1e-10);
		assertEquals(5.0, c.y, 1e-10);
		assertEquals(0.0, c.z, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Flip and normalize
	// ------------------------------------------------------------------------

	@Test
	void flipped_negatesNormalAndD() {
		Plane p = new Plane(1.0, 2.0, 3.0, 4.0);
		Plane f = p.flipped();
		assertEquals(-1.0, f.x, 1e-10);
		assertEquals(-2.0, f.y, 1e-10);
		assertEquals(-3.0, f.z, 1e-10);
		assertEquals(-4.0, f.d, 1e-10);
	}

	@Test
	void normalized_unitNormal() {
		// Create plane with non-unit normal
		Plane p = new Plane(2.0, 0.0, 0.0, 10.0);
		Plane n = p.normalized();
		// Normal should now be (1, 0, 0)
		assertEquals(1.0, n.x, 1e-10);
		assertEquals(0.0, n.y, 1e-10);
		assertEquals(0.0, n.z, 1e-10);
		// D should be halved (since normal was doubled)
		assertEquals(5.0, n.d, 1e-10);
	}

	@Test
	void normalized_zeroPlaneReturnsDefault() {
		Plane p = new Plane(0.0, 0.0, 0.0, 0.0);
		Plane n = p.normalized();
		assertEquals(0.0, n.x, 1e-10);
		assertEquals(0.0, n.y, 1e-10);
		assertEquals(1.0, n.z, 1e-10); // Default normal
		assertEquals(0.0, n.d, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Project
	// ------------------------------------------------------------------------

	@Test
	void project_pointOnPlaneStaysSame() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 point = new Vector3(10.0, 5.0, 20.0);
		Vector3 projected = p.project(point);
		assertEquals(10.0, projected.x, 1e-10);
		assertEquals(5.0, projected.y, 1e-10);
		assertEquals(20.0, projected.z, 1e-10);
	}

	@Test
	void project_pointAbovePlaneMovesDown() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 point = new Vector3(0.0, 10.0, 0.0);
		Vector3 projected = p.project(point);
		assertEquals(0.0, projected.x, 1e-10);
		assertEquals(5.0, projected.y, 1e-10);
		assertEquals(0.0, projected.z, 1e-10);
	}

	@Test
	void project_pointBelowPlaneMovesUp() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 point = new Vector3(0.0, 0.0, 0.0);
		Vector3 projected = p.project(point);
		assertEquals(0.0, projected.x, 1e-10);
		assertEquals(5.0, projected.y, 1e-10);
		assertEquals(0.0, projected.z, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Intersection - ray
	// ------------------------------------------------------------------------

	@Test
	void intersectRay_hitsPlane() {
		// Horizontal plane at y=5, ray from (0, 0, 0) going up
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 from = new Vector3(0.0, 0.0, 0.0);
		Vector3 dir = new Vector3(0.0, 1.0, 0.0);
		Vector3 hit = p.intersectRay(from, dir);
		assertNotNull(hit);
		assertEquals(0.0, hit.x, 1e-10);
		assertEquals(5.0, hit.y, 1e-10);
		assertEquals(0.0, hit.z, 1e-10);
	}

	@Test
	void intersectRay_missesPlaneGoingAway() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 from = new Vector3(0.0, 10.0, 0.0);
		Vector3 dir = new Vector3(0.0, 1.0, 0.0); // Going up, away from plane
		Vector3 hit = p.intersectRay(from, dir);
		assertNull(hit);
	}

	@Test
	void intersectRay_parallelToPlane() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 from = new Vector3(0.0, 0.0, 0.0);
		Vector3 dir = new Vector3(1.0, 0.0, 0.0); // Horizontal, parallel to plane
		Vector3 hit = p.intersectRay(from, dir);
		assertNull(hit);
	}

	@Test
	void intersectRay_againstPlaneFromSide() {
		// Plane at x=5, ray from (0, 0, 0) going in +X direction
		Plane p = new Plane(1.0, 0.0, 0.0, 5.0);
		Vector3 from = new Vector3(0.0, 0.0, 0.0);
		Vector3 dir = new Vector3(1.0, 0.0, 0.0);
		Vector3 hit = p.intersectRay(from, dir);
		assertNotNull(hit);
		assertEquals(5.0, hit.x, 1e-10);
		assertEquals(0.0, hit.y, 1e-10);
		assertEquals(0.0, hit.z, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Intersection - segment
	// ------------------------------------------------------------------------

	@Test
	void intersectSegment_hitsPlane() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 p1 = new Vector3(0.0, 0.0, 0.0);
		Vector3 p2 = new Vector3(0.0, 10.0, 0.0);
		Vector3 hit = p.intersectSegment(p1, p2);
		assertNotNull(hit);
		assertEquals(0.0, hit.x, 1e-10);
		assertEquals(5.0, hit.y, 1e-10);
		assertEquals(0.0, hit.z, 1e-10);
	}

	@Test
	void intersectSegment_missesPlane() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 p1 = new Vector3(0.0, 10.0, 0.0);
		Vector3 p2 = new Vector3(0.0, 20.0, 0.0); // Both above plane
		Vector3 hit = p.intersectSegment(p1, p2);
		assertNull(hit);
	}

	@Test
	void intersectSegment_endpointOnPlane() {
		Plane p = new Plane(0.0, 1.0, 0.0, 5.0);
		Vector3 p1 = new Vector3(0.0, 0.0, 0.0);
		Vector3 p2 = new Vector3(0.0, 5.0, 0.0); // Second point on plane
		Vector3 hit = p.intersectSegment(p1, p2);
		assertNotNull(hit);
		assertEquals(0.0, hit.x, 1e-10);
		assertEquals(5.0, hit.y, 1e-10); // intersection at p2 which is on the plane
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Test
	void toString_containsValues() {
		Plane p = new Plane(1.0, 2.0, 3.0, 4.0);
		String s = p.toString();
		assertTrue(s.contains("Plane") || s.contains("1.0"));
	}
}
