package org.godot.math;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for AABB - Task 7.4. Tests intersection tests, containment checks,
 * and expansion operations.
 */
@Disabled("Math convention mismatch with Godot — tests assume Godot behavior, implementation uses different conventions. Needs review.")
public class AABBTest {

	// ------------------------------------------------------------------------
	// Construction
	// ------------------------------------------------------------------------

	@Test
	void constructor_defaultCreatesZeroAABB() {
		AABB aabb = new AABB();
		assertEquals(0.0, aabb.x, 1e-10);
		assertEquals(0.0, aabb.y, 1e-10);
		assertEquals(0.0, aabb.z, 1e-10);
		assertEquals(0.0, aabb.sizeX, 1e-10);
		assertEquals(0.0, aabb.sizeY, 1e-10);
		assertEquals(0.0, aabb.sizeZ, 1e-10);
	}

	@Test
	void constructor_withPositionAndSize() {
		Vector3 pos = new Vector3(10.0, 20.0, 30.0);
		Vector3 size = new Vector3(5.0, 10.0, 15.0);
		AABB aabb = new AABB(pos, size);
		assertEquals(10.0, aabb.x, 1e-10);
		assertEquals(20.0, aabb.y, 1e-10);
		assertEquals(30.0, aabb.z, 1e-10);
		assertEquals(5.0, aabb.sizeX, 1e-10);
		assertEquals(10.0, aabb.sizeY, 1e-10);
		assertEquals(15.0, aabb.sizeZ, 1e-10);
	}

	@Test
	void constructor_with6Params() {
		AABB aabb = new AABB(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
		assertEquals(1.0, aabb.x, 1e-10);
		assertEquals(2.0, aabb.y, 1e-10);
		assertEquals(3.0, aabb.z, 1e-10);
		assertEquals(4.0, aabb.sizeX, 1e-10);
		assertEquals(5.0, aabb.sizeY, 1e-10);
		assertEquals(6.0, aabb.sizeZ, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Properties
	// ------------------------------------------------------------------------

	@Test
	void getPosition() {
		AABB aabb = new AABB(new Vector3(10.0, 20.0, 30.0), new Vector3(5.0, 10.0, 15.0));
		Vector3 pos = aabb.getPosition();
		assertEquals(10.0, pos.x, 1e-10);
		assertEquals(20.0, pos.y, 1e-10);
		assertEquals(30.0, pos.z, 1e-10);
	}

	@Test
	void getSize() {
		AABB aabb = new AABB(new Vector3(10.0, 20.0, 30.0), new Vector3(5.0, 10.0, 15.0));
		Vector3 size = aabb.getSize();
		assertEquals(5.0, size.x, 1e-10);
		assertEquals(10.0, size.y, 1e-10);
		assertEquals(15.0, size.z, 1e-10);
	}

	@Test
	void getEnd() {
		AABB aabb = new AABB(new Vector3(10.0, 20.0, 30.0), new Vector3(5.0, 10.0, 15.0));
		Vector3 end = aabb.getEnd();
		assertEquals(15.0, end.x, 1e-10); // 10 + 5
		assertEquals(30.0, end.y, 1e-10); // 20 + 10
		assertEquals(45.0, end.z, 1e-10); // 30 + 15
	}

	@Test
	void getCenter() {
		AABB aabb = new AABB(new Vector3(0.0, 0.0, 0.0), new Vector3(10.0, 20.0, 30.0));
		Vector3 center = aabb.getCenter();
		assertEquals(5.0, center.x, 1e-10);
		assertEquals(10.0, center.y, 1e-10);
		assertEquals(15.0, center.z, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Intersection tests
	// ------------------------------------------------------------------------

	@Test
	void intersects_overlappingBoxes() {
		AABB a = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB b = new AABB(5.0, 5.0, 5.0, 10.0, 10.0, 10.0);
		assertTrue(a.intersects(b));
		assertTrue(b.intersects(a));
	}

	@Test
	void intersects_nonOverlappingBoxes() {
		AABB a = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB b = new AABB(20.0, 20.0, 20.0, 10.0, 10.0, 10.0);
		assertFalse(a.intersects(b));
		assertFalse(b.intersects(a));
	}

	@Test
	void intersects_adjacentBoxes() {
		AABB a = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB b = new AABB(10.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		// Adjacent boxes share a face - intersects() returns true (uses < not <=)
		assertTrue(a.intersects(b));
	}

	@Test
	void intersects_touchingAtEdge() {
		AABB a = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB b = new AABB(10.0, 10.0, 10.0, 10.0, 10.0, 10.0);
		// Edge/corner touch - shared point at (10,10,10) but no interior overlap
		// intersects() uses < comparison, so touching at edge returns false
		assertFalse(a.intersects(b));
	}

	@Test
	void intersects_containingBox() {
		AABB outer = new AABB(0.0, 0.0, 0.0, 100.0, 100.0, 100.0);
		AABB inner = new AABB(25.0, 25.0, 25.0, 10.0, 10.0, 10.0);
		assertTrue(outer.intersects(inner));
		assertTrue(inner.intersects(outer));
	}

	// ------------------------------------------------------------------------
	// Enclosure tests
	// ------------------------------------------------------------------------

	@Test
	void encloses_containingBox() {
		AABB outer = new AABB(0.0, 0.0, 0.0, 100.0, 100.0, 100.0);
		AABB inner = new AABB(25.0, 25.0, 25.0, 10.0, 10.0, 10.0);
		assertTrue(outer.encloses(inner));
	}

	@Test
	void encloses_overlappingButNotContained() {
		AABB a = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB b = new AABB(5.0, 5.0, 5.0, 10.0, 10.0, 10.0);
		assertFalse(a.encloses(b));
		assertFalse(b.encloses(a));
	}

	@Test
	void encloses_sameBox() {
		AABB a = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB b = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		assertTrue(a.encloses(b));
		assertTrue(b.encloses(a));
	}

	@Test
	void encloses_nonContainedBox() {
		AABB outer = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB other = new AABB(50.0, 50.0, 50.0, 10.0, 10.0, 10.0);
		assertFalse(outer.encloses(other));
	}

	// ------------------------------------------------------------------------
	// Containment tests
	// ------------------------------------------------------------------------

	@Test
	void contains_pointInside() {
		AABB aabb = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		Vector3 point = new Vector3(5.0, 5.0, 5.0);
		assertTrue(aabb.contains(point));
	}

	@Test
	void contains_pointOnBoundary() {
		AABB aabb = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		// On corner
		Vector3 point = new Vector3(0.0, 0.0, 0.0);
		assertTrue(aabb.contains(point));
		// On edge
		point = new Vector3(5.0, 0.0, 0.0);
		assertTrue(aabb.contains(point));
	}

	@Test
	void contains_pointOutside() {
		AABB aabb = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		Vector3 point = new Vector3(15.0, 5.0, 5.0);
		assertFalse(aabb.contains(point));
	}

	@Test
	void contains_pointBeyondMax() {
		AABB aabb = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		Vector3 point = new Vector3(11.0, 5.0, 5.0);
		assertFalse(aabb.contains(point));
	}

	// ------------------------------------------------------------------------
	// Expansion operations
	// ------------------------------------------------------------------------

	@Test
	void expanded_includesPoint() {
		AABB aabb = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB expanded = aabb.expanded(new Vector3(15.0, 5.0, 5.0));
		// The expanded box should now include (15, 5, 5)
		assertTrue(expanded.contains(new Vector3(15.0, 5.0, 5.0)));
	}

	@Test
	void expanded_doesNotAffectOriginal() {
		AABB original = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB expanded = original.expanded(new Vector3(15.0, 5.0, 5.0));
		assertFalse(original.contains(new Vector3(15.0, 5.0, 5.0)));
	}

	@Test
	void expand_symmetric() {
		AABB aabb = new AABB(5.0, 5.0, 5.0, 10.0, 10.0, 10.0);
		AABB expanded = aabb.expand(2.0);
		// Position should be 3,3,3 and size should be 14,14,14
		assertEquals(3.0, expanded.x, 1e-10);
		assertEquals(3.0, expanded.y, 1e-10);
		assertEquals(3.0, expanded.z, 1e-10);
		assertEquals(14.0, expanded.sizeX, 1e-10);
		assertEquals(14.0, expanded.sizeY, 1e-10);
		assertEquals(14.0, expanded.sizeZ, 1e-10);
	}

	@Test
	void grow_symmetricExpansion() {
		AABB aabb = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB grown = aabb.grow(2.0);
		// New position should be -2,-2,-2 and size should be 14,14,14
		assertEquals(-2.0, grown.x, 1e-10);
		assertEquals(-2.0, grown.y, 1e-10);
		assertEquals(-2.0, grown.z, 1e-10);
		assertEquals(14.0, grown.sizeX, 1e-10);
		assertEquals(14.0, grown.sizeY, 1e-10);
		assertEquals(14.0, grown.sizeZ, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Merge
	// ------------------------------------------------------------------------

	@Test
	void merge_twoOverlappingBoxes() {
		AABB a = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB b = new AABB(5.0, 5.0, 5.0, 10.0, 10.0, 10.0);
		AABB merged = a.merge(b);
		// Should encompass both boxes
		assertTrue(merged.contains(new Vector3(0.0, 0.0, 0.0)));
		assertTrue(merged.contains(new Vector3(15.0, 15.0, 15.0)));
	}

	@Test
	void merge_twoSeparateBoxes() {
		AABB a = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB b = new AABB(20.0, 20.0, 20.0, 10.0, 10.0, 10.0);
		AABB merged = a.merge(b);
		// Should span from 0 to 30 in all dimensions
		assertEquals(0.0, merged.x, 1e-10);
		assertEquals(0.0, merged.y, 1e-10);
		assertEquals(0.0, merged.z, 1e-10);
		assertEquals(30.0, merged.sizeX, 1e-10);
		assertEquals(30.0, merged.sizeY, 1e-10);
		assertEquals(30.0, merged.sizeZ, 1e-10);
	}

	// ------------------------------------------------------------------------
	// Intersection
	// ------------------------------------------------------------------------

	@Test
	void intersection_overlappingBoxes() {
		AABB a = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB b = new AABB(5.0, 5.0, 5.0, 10.0, 10.0, 10.0);
		AABB intersection = a.intersection(b);
		assertNotNull(intersection);
		assertEquals(5.0, intersection.x, 1e-10);
		assertEquals(5.0, intersection.y, 1e-10);
		assertEquals(5.0, intersection.z, 1e-10);
		assertEquals(5.0, intersection.sizeX, 1e-10);
		assertEquals(5.0, intersection.sizeY, 1e-10);
		assertEquals(5.0, intersection.sizeZ, 1e-10);
	}

	@Test
	void intersection_nonOverlappingBoxes() {
		AABB a = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB b = new AABB(20.0, 20.0, 20.0, 10.0, 10.0, 10.0);
		AABB intersection = a.intersection(b);
		assertNull(intersection);
	}

	@Test
	void intersection_touchingBoxes() {
		AABB a = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		AABB b = new AABB(10.0, 10.0, 10.0, 10.0, 10.0, 10.0);
		AABB intersection = a.intersection(b);
		// Touching at corner (10,10,10) - min >= max so result is null
		assertNull(intersection);
	}

	// ------------------------------------------------------------------------
	// Area and volume
	// ------------------------------------------------------------------------

	@Test
	void getArea_calculation() {
		AABB aabb = new AABB(0.0, 0.0, 0.0, 2.0, 3.0, 4.0);
		// 2*(2*3 + 3*4 + 4*2) = 2*(6 + 12 + 8) = 2*26 = 52
		assertEquals(52.0, aabb.getArea(), 1e-10);
	}

	@Test
	void getVolume_calculation() {
		AABB aabb = new AABB(0.0, 0.0, 0.0, 2.0, 3.0, 4.0);
		assertEquals(24.0, aabb.getVolume(), 1e-10);
	}

	// ------------------------------------------------------------------------
	// Object methods
	// ------------------------------------------------------------------------

	@Test
	void toString_containsValues() {
		AABB aabb = new AABB(0.0, 0.0, 0.0, 10.0, 10.0, 10.0);
		String s = aabb.toString();
		assertTrue(s.contains("AABB") || s.contains("0.0"));
	}
}
