package org.godot.builtin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.godot.math.AABB;
import org.godot.math.Basis;
import org.godot.math.Color;
import org.godot.math.Plane;
import org.godot.math.Projection;
import org.godot.math.Quaternion;
import org.godot.math.Rect2;
import org.godot.math.Rect2i;
import org.godot.math.Transform2D;
import org.godot.math.Transform3D;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;
import org.godot.math.Vector3;
import org.godot.math.Vector3i;
import org.godot.math.Vector4;
import org.godot.math.Vector4i;
import org.junit.jupiter.api.Test;

class BuiltinStructSegmentLayoutTest {

	private static final double EPSILON = 1e-6;

	@Test
	void vectorLayoutsRoundTripThroughNativeSegments() {
		assertVector2(new Vector2(1.25, -2.5), roundTrip(16, new Vector2(1.25, -2.5), Vector2::fromSegment));
		assertVector2i(new Vector2i(1, -2), roundTrip(8, new Vector2i(1, -2), Vector2i::fromSegment));
		assertVector3(new Vector3(1.25, -2.5, 3.75),
				roundTrip(24, new Vector3(1.25, -2.5, 3.75), Vector3::fromSegment));
		assertVector3i(new Vector3i(1, -2, 3), roundTrip(12, new Vector3i(1, -2, 3), Vector3i::fromSegment));
		assertVector4(new Vector4(1.25, -2.5, 3.75, -4.5),
				roundTrip(32, new Vector4(1.25, -2.5, 3.75, -4.5), Vector4::fromSegment));
		assertVector4i(new Vector4i(1, -2, 3, -4), roundTrip(16, new Vector4i(1, -2, 3, -4), Vector4i::fromSegment));
	}

	@Test
	void rectAndColorLayoutsRoundTripThroughNativeSegments() {
		assertRect2(new Rect2(1.25, -2.5, 3.75, 4.5),
				roundTrip(32, new Rect2(1.25, -2.5, 3.75, 4.5), Rect2::fromSegment));
		assertRect2i(new Rect2i(1, -2, 3, 4), roundTrip(16, new Rect2i(1, -2, 3, 4), Rect2i::fromSegment));
		assertColor(new Color(0.25, 0.5, 0.75, 1.0),
				roundTrip(16, new Color(0.25, 0.5, 0.75, 1.0), Color::fromSegment));
	}

	@Test
	void transformLayoutsRoundTripThroughNativeSegments() {
		Transform2D transform2D = new Transform2D(new Vector2(1.0, 2.0), new Vector2(3.0, 4.0), new Vector2(5.0, 6.0));
		assertTransform2D(transform2D, roundTrip(48, transform2D, Transform2D::fromSegment));

		Basis basis = new Basis(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
		assertBasis(basis, roundTrip(72, basis, Basis::fromSegment));

		Transform3D transform3D = new Transform3D(new Vector3(1.0, 2.0, 3.0), new Vector3(4.0, 5.0, 6.0),
				new Vector3(7.0, 8.0, 9.0), new Vector3(10.0, 11.0, 12.0));
		assertTransform3D(transform3D, roundTrip(96, transform3D, Transform3D::fromSegment));

		Projection projection = new Projection(new Vector4(1.0, 2.0, 3.0, 4.0), new Vector4(5.0, 6.0, 7.0, 8.0),
				new Vector4(9.0, 10.0, 11.0, 12.0), new Vector4(13.0, 14.0, 15.0, 16.0));
		assertProjection(projection, roundTrip(64, projection, Projection::fromSegment));
	}

	@Test
	void planeQuaternionAndAabbLayoutsRoundTripThroughNativeSegments() {
		assertPlane(new Plane(1.0, -2.0, 3.0, -4.0),
				roundTrip(32, new Plane(1.0, -2.0, 3.0, -4.0), Plane::fromSegment));
		assertQuaternion(new Quaternion(1.0, -2.0, 3.0, -4.0),
				roundTrip(32, new Quaternion(1.0, -2.0, 3.0, -4.0), Quaternion::fromSegment));
		assertAabb(new AABB(1.0, -2.0, 3.0, 4.0, 5.0, 6.0),
				roundTrip(48, new AABB(1.0, -2.0, 3.0, 4.0, 5.0, 6.0), AABB::fromSegment));
	}

	private static <T> T roundTrip(long byteSize, T value, SegmentReader<T> reader) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = arena.allocate(byteSize, 8);
			writeSegment(value, segment);
			return reader.read(segment);
		}
	}

	private static void writeSegment(Object value, MemorySegment segment) {
		switch (value) {
			case Vector2 v -> v.toSegment(segment);
			case Vector2i v -> v.toSegment(segment);
			case Rect2 v -> v.toSegment(segment);
			case Rect2i v -> v.toSegment(segment);
			case Vector3 v -> v.toSegment(segment);
			case Vector3i v -> v.toSegment(segment);
			case Transform2D v -> v.toSegment(segment);
			case Vector4 v -> v.toSegment(segment);
			case Vector4i v -> v.toSegment(segment);
			case Plane v -> v.toSegment(segment);
			case Quaternion v -> v.toSegment(segment);
			case AABB v -> v.toSegment(segment);
			case Basis v -> v.toSegment(segment);
			case Transform3D v -> v.toSegment(segment);
			case Projection v -> v.toSegment(segment);
			case Color v -> v.toSegment(segment);
			default -> throw new IllegalArgumentException("Unsupported segment value: " + value.getClass().getName());
		}
	}

	private static void assertVector2(Vector2 expected, Vector2 actual) {
		assertEquals(expected.x, actual.x, EPSILON);
		assertEquals(expected.y, actual.y, EPSILON);
	}

	private static void assertVector2i(Vector2i expected, Vector2i actual) {
		assertEquals(expected.x, actual.x);
		assertEquals(expected.y, actual.y);
	}

	private static void assertVector3(Vector3 expected, Vector3 actual) {
		assertEquals(expected.x, actual.x, EPSILON);
		assertEquals(expected.y, actual.y, EPSILON);
		assertEquals(expected.z, actual.z, EPSILON);
	}

	private static void assertVector3i(Vector3i expected, Vector3i actual) {
		assertEquals(expected.x, actual.x);
		assertEquals(expected.y, actual.y);
		assertEquals(expected.z, actual.z);
	}

	private static void assertVector4(Vector4 expected, Vector4 actual) {
		assertEquals(expected.x, actual.x, EPSILON);
		assertEquals(expected.y, actual.y, EPSILON);
		assertEquals(expected.z, actual.z, EPSILON);
		assertEquals(expected.w, actual.w, EPSILON);
	}

	private static void assertVector4i(Vector4i expected, Vector4i actual) {
		assertEquals(expected.x, actual.x);
		assertEquals(expected.y, actual.y);
		assertEquals(expected.z, actual.z);
		assertEquals(expected.w, actual.w);
	}

	private static void assertRect2(Rect2 expected, Rect2 actual) {
		assertVector2(expected.position, actual.position);
		assertVector2(expected.size, actual.size);
	}

	private static void assertRect2i(Rect2i expected, Rect2i actual) {
		assertEquals(expected.x, actual.x);
		assertEquals(expected.y, actual.y);
		assertEquals(expected.width, actual.width);
		assertEquals(expected.height, actual.height);
	}

	private static void assertColor(Color expected, Color actual) {
		assertEquals(expected.r, actual.r, EPSILON);
		assertEquals(expected.g, actual.g, EPSILON);
		assertEquals(expected.b, actual.b, EPSILON);
		assertEquals(expected.a, actual.a, EPSILON);
	}

	private static void assertTransform2D(Transform2D expected, Transform2D actual) {
		assertVector2(expected.x, actual.x);
		assertVector2(expected.y, actual.y);
		assertVector2(expected.origin, actual.origin);
	}

	private static void assertBasis(Basis expected, Basis actual) {
		assertEquals(expected.xx, actual.xx, EPSILON);
		assertEquals(expected.xy, actual.xy, EPSILON);
		assertEquals(expected.xz, actual.xz, EPSILON);
		assertEquals(expected.yx, actual.yx, EPSILON);
		assertEquals(expected.yy, actual.yy, EPSILON);
		assertEquals(expected.yz, actual.yz, EPSILON);
		assertEquals(expected.zx, actual.zx, EPSILON);
		assertEquals(expected.zy, actual.zy, EPSILON);
		assertEquals(expected.zz, actual.zz, EPSILON);
	}

	private static void assertTransform3D(Transform3D expected, Transform3D actual) {
		assertEquals(expected.xx, actual.xx, EPSILON);
		assertEquals(expected.xy, actual.xy, EPSILON);
		assertEquals(expected.xz, actual.xz, EPSILON);
		assertEquals(expected.yx, actual.yx, EPSILON);
		assertEquals(expected.yy, actual.yy, EPSILON);
		assertEquals(expected.yz, actual.yz, EPSILON);
		assertEquals(expected.zx, actual.zx, EPSILON);
		assertEquals(expected.zy, actual.zy, EPSILON);
		assertEquals(expected.zz, actual.zz, EPSILON);
		assertEquals(expected.ox, actual.ox, EPSILON);
		assertEquals(expected.oy, actual.oy, EPSILON);
		assertEquals(expected.oz, actual.oz, EPSILON);
	}

	private static void assertProjection(Projection expected, Projection actual) {
		assertVector4(expected.x, actual.x);
		assertVector4(expected.y, actual.y);
		assertVector4(expected.z, actual.z);
		assertVector4(expected.w, actual.w);
	}

	private static void assertPlane(Plane expected, Plane actual) {
		assertEquals(expected.x, actual.x, EPSILON);
		assertEquals(expected.y, actual.y, EPSILON);
		assertEquals(expected.z, actual.z, EPSILON);
		assertEquals(expected.d, actual.d, EPSILON);
	}

	private static void assertQuaternion(Quaternion expected, Quaternion actual) {
		assertEquals(expected.x, actual.x, EPSILON);
		assertEquals(expected.y, actual.y, EPSILON);
		assertEquals(expected.z, actual.z, EPSILON);
		assertEquals(expected.w, actual.w, EPSILON);
	}

	private static void assertAabb(AABB expected, AABB actual) {
		assertEquals(expected.x, actual.x, EPSILON);
		assertEquals(expected.y, actual.y, EPSILON);
		assertEquals(expected.z, actual.z, EPSILON);
		assertEquals(expected.sizeX, actual.sizeX, EPSILON);
		assertEquals(expected.sizeY, actual.sizeY, EPSILON);
		assertEquals(expected.sizeZ, actual.sizeZ, EPSILON);
	}

	private interface SegmentReader<T> {
		T read(MemorySegment segment);
	}
}
