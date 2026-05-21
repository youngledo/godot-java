package org.godot.builtin;

import org.godot.math.Projection;
import org.godot.math.Vector4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Projection - Task 9. Tests construction and column access.
 */
public class ProjectionTest {

	// ------------------------------------------------------------------------
	// Construction
	// ------------------------------------------------------------------------

	@Test
	void constructor_defaultCreatesZeroColumns() {
		Projection p = new Projection();
		assertEquals(0.0, p.x.x, 1e-10);
		assertEquals(0.0, p.x.y, 1e-10);
		assertEquals(0.0, p.x.z, 1e-10);
		assertEquals(0.0, p.x.w, 1e-10);
		assertEquals(0.0, p.y.x, 1e-10);
		assertEquals(0.0, p.y.y, 1e-10);
		assertEquals(0.0, p.y.z, 1e-10);
		assertEquals(0.0, p.y.w, 1e-10);
		assertEquals(0.0, p.z.x, 1e-10);
		assertEquals(0.0, p.z.y, 1e-10);
		assertEquals(0.0, p.z.z, 1e-10);
		assertEquals(0.0, p.z.w, 1e-10);
		assertEquals(0.0, p.w.x, 1e-10);
		assertEquals(0.0, p.w.y, 1e-10);
		assertEquals(0.0, p.w.z, 1e-10);
		assertEquals(0.0, p.w.w, 1e-10);
	}

	@Test
	void constructor_fourVectorsSetsColumnsCorrectly() {
		Vector4 colX = new Vector4(1.0, 0.0, 0.0, 0.0);
		Vector4 colY = new Vector4(0.0, 2.0, 0.0, 0.0);
		Vector4 colZ = new Vector4(0.0, 0.0, 3.0, 0.0);
		Vector4 colW = new Vector4(4.0, 5.0, 6.0, 1.0);
		Projection p = new Projection(colX, colY, colZ, colW);

		// X column
		assertEquals(1.0, p.x.x, 1e-10);
		assertEquals(0.0, p.x.y, 1e-10);
		assertEquals(0.0, p.x.z, 1e-10);
		assertEquals(0.0, p.x.w, 1e-10);
		// Y column
		assertEquals(0.0, p.y.x, 1e-10);
		assertEquals(2.0, p.y.y, 1e-10);
		assertEquals(0.0, p.y.z, 1e-10);
		assertEquals(0.0, p.y.w, 1e-10);
		// Z column
		assertEquals(0.0, p.z.x, 1e-10);
		assertEquals(0.0, p.z.y, 1e-10);
		assertEquals(3.0, p.z.z, 1e-10);
		assertEquals(0.0, p.z.w, 1e-10);
		// W column
		assertEquals(4.0, p.w.x, 1e-10);
		assertEquals(5.0, p.w.y, 1e-10);
		assertEquals(6.0, p.w.z, 1e-10);
		assertEquals(1.0, p.w.w, 1e-10);
	}

	@Test
	void constructor_columnsAreSameReferences() {
		Vector4 colX = new Vector4(1, 2, 3, 4);
		Vector4 colY = new Vector4(5, 6, 7, 8);
		Vector4 colZ = new Vector4(9, 10, 11, 12);
		Vector4 colW = new Vector4(13, 14, 15, 16);
		Projection p = new Projection(colX, colY, colZ, colW);

		assertSame(colX, p.x);
		assertSame(colY, p.y);
		assertSame(colZ, p.z);
		assertSame(colW, p.w);
	}
}
